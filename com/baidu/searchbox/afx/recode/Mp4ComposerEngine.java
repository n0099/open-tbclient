package com.baidu.searchbox.afx.recode;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import org.webrtc.HardwareVideoEncoder;
/* loaded from: classes2.dex */
public class Mp4ComposerEngine {
    public static final long PROGRESS_INTERVAL_STEPS = 10;
    public static final float PROGRESS_UNKNOWN = -1.0f;
    public static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 10;
    public static final String TAG = "Mp4ComposerEngine";
    public long mDurationUs;
    public ProgressCallback mProgressCallback;

    /* loaded from: classes2.dex */
    public interface ProgressCallback {
        void onProgress(float f);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    @SuppressLint({"BDThrowableCheck, InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void compose(MediaExtractor mediaExtractor, String str, Mp4Info mp4Info) throws IOException {
        MediaMuxer mediaMuxer;
        VideoTrackTranscoder videoTrackTranscoder;
        VideoTrackTranscoder videoTrackTranscoder2 = null;
        try {
            int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
            if (selectVideoTrackIndex >= 0) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
                String string = trackFormat.getString("mime");
                int i = 25;
                try {
                    i = trackFormat.getInteger("frame-rate");
                } catch (Exception e) {
                    Log.e(TAG, "get frame rate (FPS) failed.", e);
                }
                this.mDurationUs = mp4Info.getDurationUs();
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(string, mp4Info.getWidth(), mp4Info.getHeight());
                createVideoFormat.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, 0);
                createVideoFormat.setInteger("bitrate", mp4Info.getBitrate() * 3);
                createVideoFormat.setInteger("frame-rate", i);
                createVideoFormat.setInteger("i-frame-interval", 0);
                createVideoFormat.setInteger("color-format", 2130708361);
                mediaMuxer = new MediaMuxer(str, 0);
                try {
                    videoTrackTranscoder = new VideoTrackTranscoder(mediaExtractor, selectVideoTrackIndex, createVideoFormat, new QueuedMuxer(mediaMuxer));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    videoTrackTranscoder.setup(mp4Info);
                    mediaExtractor.selectTrack(selectVideoTrackIndex);
                    runPipelinesNoAudio(videoTrackTranscoder);
                    mediaMuxer.stop();
                    videoTrackTranscoder.release();
                    if (mediaExtractor != null) {
                        mediaExtractor.release();
                    }
                    mediaMuxer.release();
                    return;
                } catch (Throwable th2) {
                    videoTrackTranscoder2 = videoTrackTranscoder;
                    th = th2;
                    if (videoTrackTranscoder2 != null) {
                    }
                    if (mediaExtractor != null) {
                    }
                    if (mediaMuxer != null) {
                    }
                    throw th;
                }
            }
            Log.e(TAG, "No video track found in " + str);
            throw new RuntimeException("No video track found in " + str);
        } catch (Throwable th3) {
            th = th3;
            mediaMuxer = null;
            if (videoTrackTranscoder2 != null) {
                videoTrackTranscoder2.release();
            }
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            if (mediaMuxer != null) {
                mediaMuxer.release();
            }
            throw th;
        }
    }

    private void runPipelinesNoAudio(VideoTrackTranscoder videoTrackTranscoder) {
        ProgressCallback progressCallback;
        if (this.mDurationUs <= 0 && (progressCallback = this.mProgressCallback) != null) {
            progressCallback.onProgress(-1.0f);
        }
        long j = 0;
        while (!videoTrackTranscoder.isFinished()) {
            boolean stepPipeline = videoTrackTranscoder.stepPipeline();
            j++;
            if (this.mDurationUs > 0 && j % 10 == 0) {
                float f = 1.0f;
                if (!videoTrackTranscoder.isFinished()) {
                    f = Math.min(1.0f, ((float) videoTrackTranscoder.getWrittenPresentationTimeUs()) / ((float) this.mDurationUs));
                }
                ProgressCallback progressCallback2 = this.mProgressCallback;
                if (progressCallback2 != null) {
                    progressCallback2.onProgress(f);
                }
            }
            if (!stepPipeline) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                return i;
            }
        }
        return -1;
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.mProgressCallback = progressCallback;
    }

    public void compose(AssetFileDescriptor assetFileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor());
        } else {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
        compose(mediaExtractor, str, mp4Info);
    }

    public void compose(FileDescriptor fileDescriptor, String str, Mp4Info mp4Info) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(fileDescriptor);
        compose(mediaExtractor, str, mp4Info);
    }
}
