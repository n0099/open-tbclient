package com.baidu.searchbox.ugc.upload;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.hardware.AudioEncoderCore;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.transcoder.TranscoderManager;
import com.baidu.searchbox.ugc.transcoder.TranscoderPlugin;
import com.baidu.searchbox.ugc.transcoder.VideoTranscoder;
import com.baidu.searchbox.ugc.upload.FileUploadSession;
import com.baidu.searchbox.ugc.utils.FileHelper;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.vod.model.GenerateMediaIdResponse;
import com.baidubce.services.vod.model.ProcessMediaResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class UploadVideoTask extends UploadFileTask {
    private static final String AUDIO_MIME = "audio/mp4a-latm";
    private static final String CONTENT_TYPE = "video/mp4";
    public static final int DEFAULT_PROGRESS_DURATION = 15000;
    private static final String EXTENSION = "mp4";
    private static String ONLINE_TEMPLATE = "online_template_shortvideo";
    private static final String PREVIEW_MODE = "preview";
    private static final String TAG = "UploadVideoTask";
    private static final String TRANSCODING_GROUP_NAME = "vod.inbuilt.notranscoding.mp4";
    private static final String TRANSCODING_MODE = "no_transcoding";
    private static final int VIDEO_MAX_EDGELEN = 1920;
    private static final String VIDEO_MIME = "video/avc";
    private static final int VOD_PRIORITY_DEFAULT = 5;
    public static String mSourceKey;
    public boolean isCanceledByUser = false;
    protected CountDownLatch latch = new CountDownLatch(1);
    private String mCurrentVideoMd5;
    private FileUploadSession mFileUploadSession;
    private VideoTranscoder mOldTranscoder;
    private TranscoderPlugin mTranscoder;

    public UploadVideoTask(String str) {
        setFileName(getFilePath(str));
        setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".mp4", str));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("video/mp4");
        setObjectMetadata(objectMetadata);
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask
    public boolean handleCompress() {
        if (this.mCallback != null) {
            this.mCallback.onStart(this);
        }
        if ((getVideoDuration() * 3) / 2 <= 0) {
        }
        if (!isSameSourceVideo(getFileName())) {
            ProcessCacheManager.getInstance().uploadCacheBean.updateNewVideo(getFileName(), this.mCurrentVideoMd5);
        }
        if (isCompressSuccess() || isJumpCompress() || ProcessCacheManager.getInstance().uploadCacheBean.needJumpCompress) {
            ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath = getFileName();
            setCompressFileName(getFileName());
            setCompressSuccess(true);
            return true;
        } else if (isNotNeedCompress()) {
            ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath = getFileName();
            setCompressFileName(getFileName());
            setCompressSuccess(true);
            return true;
        } else if (hasCompressed(getFileName())) {
            setCompressFileName(ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath);
            setCompressSuccess(true);
            return true;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.mTranscoder = new TranscoderPlugin(AppRuntime.getAppContext());
            this.mTranscoder.setDataSource(getFileName());
            this.mTranscoder.setOutputFile(getCompressFileName());
            this.mTranscoder.setOutputMaxEdgeLen(1920);
            this.mTranscoder.setVideoBitRate(5000000);
            this.mTranscoder.setVideoFrameRate(30);
            this.mTranscoder.setAudioBitRate(AudioEncoderCore.EncodeConfig.BIT_RATE);
            this.mTranscoder.setAudioSampleRateHZ(44100);
            this.mTranscoder.setAudioChannelCount(2);
            this.mTranscoder.setOnErrorListener(new TranscoderManager.OnErrorListener() { // from class: com.baidu.searchbox.ugc.upload.UploadVideoTask.1
                @Override // com.baidu.searchbox.ugc.transcoder.TranscoderManager.OnErrorListener
                public boolean onError(int i, int i2) {
                    return true;
                }
            });
            boolean z = false;
            switch (this.mTranscoder.startSync()) {
                case 2:
                case 3:
                    this.mOldTranscoder = new VideoTranscoder();
                    z = this.mOldTranscoder.startTranscoder(AppRuntime.getAppContext(), getFileName(), getCompressFileName(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true);
                    break;
                case 4:
                    z = true;
                    break;
            }
            int currentTimeMillis2 = ((int) (System.currentTimeMillis() - currentTimeMillis)) / 1000;
            if (z && FileHelper.exists(getCompressFileName())) {
                setCompressFileName(getCompressFileName());
                ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath = getCompressFileName();
                ProcessCacheManager.getInstance().uploadCacheBean.isCompressSucceed = true;
                setCompressSuccess(true);
            } else {
                ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath = getFileName();
                setCompressFileName(getFileName());
                setCompressSuccess(true);
            }
            return isCompressSuccess();
        }
    }

    public boolean hasCompressed(String str) {
        return !TextUtils.isEmpty(str) && str.equals(ProcessCacheManager.getInstance().uploadCacheBean.videoPath) && ProcessCacheManager.getInstance().uploadCacheBean.isCompressSucceed && !TextUtils.isEmpty(ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath) && new File(ProcessCacheManager.getInstance().uploadCacheBean.videoCompressPath).exists();
    }

    public boolean isSameSourceVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mCurrentVideoMd5 = MD5Utils.toMd5(new File(str), false);
        return !TextUtils.isEmpty(this.mCurrentVideoMd5) && this.mCurrentVideoMd5.equals(ProcessCacheManager.getInstance().uploadCacheBean.videoPathMd5);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|4|(2:5|6)|7|(12:9|(1:(1:70))(1:(1:19))|20|21|22|23|24|25|(4:27|28|(1:40)(2:30|(2:32|33)(2:35|(2:37|38)(1:39)))|34)|53|54|(2:51|52)(1:49))|71|20|21|22|23|24|25|(0)|53|54|(0)|51|52|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(5:2|3|4|(2:5|6)|7)|(10:(12:9|(1:(1:70))(1:(1:19))|20|21|22|23|24|25|(4:27|28|(1:40)(2:30|(2:32|33)(2:35|(2:37|38)(1:39)))|34)|53|54|(2:51|52)(1:49))|23|24|25|(0)|53|54|(0)|51|52)|71|20|21|22|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cd, code lost:
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ce, code lost:
        r4 = false;
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isNotNeedCompress() {
        boolean z;
        MediaExtractor mediaExtractor;
        int trackCount;
        int i;
        Bitmap frameAtTime;
        int i2;
        long length;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(getFileName());
            frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            try {
                i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e) {
                e.printStackTrace();
                i2 = -1;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
            length = new File(getFileName()).length();
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
                z = false;
            } catch (Exception e3) {
                e3.printStackTrace();
                z = false;
            }
        }
        try {
            if (frameAtTime != null) {
                if (frameAtTime.getWidth() <= 1920 && frameAtTime.getHeight() <= 1920) {
                    if (i2 > 0 && length > 0 && length / (i2 / 1000) < 10000000) {
                        z = true;
                    }
                } else if (i2 > 0 && length > 0 && length / (i2 / 1000) < 20000000) {
                    z = true;
                }
                mediaMetadataRetriever.release();
                mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(getFileName());
                trackCount = mediaExtractor.getTrackCount();
                boolean z2 = false;
                boolean z3 = false;
                for (i = 0; i < trackCount; i++) {
                    try {
                        String string = mediaExtractor.getTrackFormat(i).getString("mime");
                        if (!TextUtils.isEmpty(string)) {
                            if (string.equals("video/avc")) {
                                z3 = true;
                            } else if (string.equals(AUDIO_MIME)) {
                                z2 = true;
                            }
                        }
                    } catch (IOException e4) {
                        boolean z4 = z3;
                        boolean z5 = z2;
                        e = e4;
                        e.printStackTrace();
                        mediaExtractor.release();
                        z2 = z5;
                        z3 = z4;
                        if (z) {
                        }
                    }
                }
                return !z && z3 && z2;
            }
            mediaExtractor.setDataSource(getFileName());
            trackCount = mediaExtractor.getTrackCount();
            boolean z22 = false;
            boolean z32 = false;
            while (i < trackCount) {
            }
            if (z) {
            }
        } finally {
            mediaExtractor.release();
        }
        z = false;
        mediaMetadataRetriever.release();
        mediaExtractor = new MediaExtractor();
    }

    private int getVideoDuration() {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getFileName());
            return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e) {
            return -1;
        }
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask
    protected boolean innerUpload(String str) {
        File file = new File(str);
        this.mFileUploadSession = new FileUploadSession(this, this.mBosClient, new FileUploadSession.MultipartUploadProgressListener() { // from class: com.baidu.searchbox.ugc.upload.UploadVideoTask.2
            @Override // com.baidu.searchbox.ugc.upload.FileUploadSession.MultipartUploadProgressListener
            public void notifyPercent(int i) {
                UploadVideoTask.this.playProgressByPercent(i);
            }
        });
        boolean z = false;
        if (this.mFileUploadSession != null) {
            z = this.mFileUploadSession.upload(file, this.mBucketName, this.mBosKey, 1, this.mObjectMetadata);
        }
        if (!z) {
            if (this.mFileUploadSession != null) {
                z = this.mFileUploadSession.upload(file, this.mBucketName, this.mBosKey, 2, this.mObjectMetadata);
            }
            this.mErrorCode = 5;
        }
        return z;
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask, java.lang.Runnable
    public void run() {
        GenerateMediaIdResponse applyMediaForSpecificMode;
        setStatus(2);
        try {
            if (ProcessCacheManager.getInstance().uploadCacheBean.mediaRes != null && !TextUtils.isEmpty(ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.getMediaId()) && !TextUtils.isEmpty(ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.getSourceBucket()) && !TextUtils.isEmpty(ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.getSourceKey())) {
                applyMediaForSpecificMode = ProcessCacheManager.getInstance().uploadCacheBean.mediaRes;
            } else {
                applyMediaForSpecificMode = this.mVodClient.applyMediaForSpecificMode(PREVIEW_MODE);
                if (ProcessCacheManager.getInstance().uploadCacheBean.mediaRes == null) {
                    ProcessCacheManager.getInstance().uploadCacheBean.mediaRes = new GenerateMediaIdResponse();
                }
                if (applyMediaForSpecificMode != null && !TextUtils.isEmpty(applyMediaForSpecificMode.getMediaId())) {
                    ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.setMediaId(applyMediaForSpecificMode.getMediaId());
                    ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.setSourceBucket(applyMediaForSpecificMode.getSourceBucket());
                    ProcessCacheManager.getInstance().uploadCacheBean.mediaRes.setSourceKey(applyMediaForSpecificMode.getSourceKey());
                } else {
                    uploadVideoFail();
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("mediaId = ").append(applyMediaForSpecificMode.getMediaId()).append("sourceKey = ").append(applyMediaForSpecificMode.getSourceKey());
            ProcessCacheManager.getInstance().mediaIdResponseStr = sb.toString();
            setUrl(applyMediaForSpecificMode.getMediaId());
            setBosKey(applyMediaForSpecificMode.getSourceKey());
            setBucketName(applyMediaForSpecificMode.getSourceBucket());
            if (!TextUtils.isEmpty(applyMediaForSpecificMode.getMediaId())) {
            }
            HttpRequestPublishModule.setVideoInfo(getCompressFileName());
            if (uploadFile(getCompressFileName())) {
                if (!ProcessCacheManager.getInstance().uploadCacheBean.completeTranscode) {
                    ProcessMediaResponse processMedia = this.mVodClient.processMedia(new PriorityProcessMediaRequest().withMediaId(getUrl()).withTitle(getVodTitle()).withDescription(getVodDescription(getCompressFileName())).withSourceExtension(EXTENSION).withTranscodingPresetGroupName(ONLINE_TEMPLATE).withPriority(5));
                    if (processMedia != null && !TextUtils.isEmpty(processMedia.getMediaId())) {
                        ProcessCacheManager.getInstance().uploadCacheBean.completeTranscode = true;
                        this.mCallback.onSuccess(this);
                        return;
                    }
                } else {
                    this.mCallback.onSuccess(this);
                    return;
                }
            }
        } catch (Exception e) {
            if (e != null && !TextUtils.isEmpty(e.getMessage()) && e.getMessage().contains("Delay interrupted")) {
                uploadVideoFail();
                return;
            }
        }
        uploadVideoFail();
    }

    private void uploadVideoSuccess() {
        finishPlayProgress();
        this.mStatus = 4;
        notifySuccessOrFailed(true);
    }

    private void uploadVideoFail() {
        stopPlayProgress();
        this.mStatus = 5;
        notifySuccessOrFailed(false);
    }

    private String getVodTitle() {
        StringBuilder sb = new StringBuilder("rmminivideo_");
        sb.append(getLocalIpAddress()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        String str = EXTENSION;
        try {
            str = getCompressFileName().substring(getCompressFileName().lastIndexOf(46) + 1);
        } catch (Exception e) {
        }
        sb.append(str).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(MD5Utils.toMd5(new File(getCompressFileName()), false));
        return sb.toString();
    }

    public static String getLocalIpAddress() {
        Pattern compile = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (compile.matcher(hostAddress).matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getVodDescription(String str) {
        JSONObject jSONObject = new JSONObject();
        BoxAccountManager boxAccountManager = (BoxAccountManager) c.a(BoxAccountManager.SERVICE_REFERENCE);
        if (!boxAccountManager.isLogin()) {
            return "";
        }
        String session = boxAccountManager.getSession(BoxAccountManager.SESSION_UID);
        String session2 = boxAccountManager.getSession(BoxAccountManager.SESSION_NICKNAME);
        try {
            jSONObject.put("media_name", str);
            jSONObject.put("author_id", session);
            jSONObject.put("author_name", session2);
            jSONObject.put("producer", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask
    public void stop() {
        super.stop();
        this.isCanceledByUser = true;
        if (this.mTranscoder != null) {
            this.mTranscoder.stop();
        }
        if (this.mFileUploadSession != null) {
            this.mFileUploadSession.releaseUploadListener();
            this.mFileUploadSession.singlePoolShutDownNow();
        }
        stopPlayProgress();
    }

    private String getFilePath(String str) {
        Cursor query = AppRuntime.getAppContext().getContentResolver().query(Uri.parse(str), new String[]{"_data"}, null, null, null);
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        return query.getString(columnIndexOrThrow);
    }
}
