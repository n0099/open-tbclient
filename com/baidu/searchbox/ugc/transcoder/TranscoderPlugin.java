package com.baidu.searchbox.ugc.transcoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.transcoder.TranscoderManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class TranscoderPlugin implements TranscoderManager.OnCompletionListener, TranscoderManager.OnErrorListener, TranscoderManager.OnInfoListener {
    public static final String AUDIO_CODEC = "aac";
    public static final String KEY_SUPPORT_HW_ENCODE = "support_hw_encode";
    public static final int MODE_AUTO = 2;
    public static final int MODE_HW = 0;
    public static final int MODE_SW = 1;
    private static final String TAG = "TranscoderPlugin";
    public static final String VIDEO_CODEC = "libx264";
    private Context mContext;
    private String mDataSource;
    private int mMaxEdgeLen;
    private TranscoderManager.OnCompletionListener mOnCompletionListener;
    private TranscoderManager.OnErrorListener mOnErrorListener;
    private String mOutputFile;
    private TranscoderManager mTranscoder;
    private volatile int mStatus = 0;
    private Map<String, String> mVideoParams = new HashMap();

    /* loaded from: classes14.dex */
    public interface Status {
        public static final int COMPLETION = 4;
        public static final int ERROR = 2;
        public static final int ERROR_PLUGIN = 3;
        public static final int READY = 0;
        public static final int STOP = 5;
        public static final int TRANSCODING = 1;
    }

    public TranscoderPlugin(Context context) {
        this.mContext = context;
        setVideoCodec(VIDEO_CODEC);
        setAudioCodec(AUDIO_CODEC);
        setOutputMaxEdgeLen(640);
        setVideoFrameRate(25);
        setVideoBitRate(520000);
        setAudioBitRate(160000);
        setAudioSampleRateHZ(44100);
        setAudioChannelCount(2);
    }

    public void setDataSource(String str) {
        this.mDataSource = str;
    }

    public void setOutputFile(String str) {
        this.mOutputFile = str;
    }

    public void setOutputMaxEdgeLen(int i) {
        this.mMaxEdgeLen = i;
    }

    private void setAudioCodec(String str) {
        this.mVideoParams.put("acodec", str);
        this.mVideoParams.put("strict", "-2");
    }

    private void setVideoCodec(String str) {
        this.mVideoParams.put("vcodec", str);
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoParams.put("s", i + Config.EVENT_HEAT_X + i2);
    }

    public void setVideoFrameRate(int i) {
        this.mVideoParams.put("r", i + "");
    }

    public void setVideoBitRate(int i) {
        this.mVideoParams.put("b:v", i + "");
    }

    public void setAudioBitRate(int i) {
        this.mVideoParams.put("b:a", i + "");
    }

    public void setAudioSampleRateHZ(int i) {
    }

    public void setAudioChannelCount(int i) {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [239=5, 240=5, 241=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0078 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean setVideoSizeByMaxEdgeLen() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.mMaxEdgeLen == 0) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.mDataSource);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            if (frameAtTime != null) {
                int width = frameAtTime.getWidth();
                try {
                    i2 = width;
                    i = frameAtTime.getHeight();
                } catch (Throwable th) {
                    th = th;
                    i2 = width;
                    i = 0;
                    try {
                        th.printStackTrace();
                        try {
                            mediaMetadataRetriever.release();
                            i3 = i;
                            i4 = i2;
                        } catch (Exception e) {
                            e.printStackTrace();
                            i3 = i;
                            i4 = i2;
                        }
                        if (i4 != 0) {
                        }
                        return false;
                    } finally {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 == 0 || i == 0) {
                try {
                    if (Build.VERSION.SDK_INT < 17) {
                        return false;
                    }
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                    if (TextUtils.isEmpty(extractMetadata)) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return false;
                    } else if ("90".equals(extractMetadata) || "270".equals(extractMetadata)) {
                        i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    } else {
                        i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    mediaMetadataRetriever.release();
                    i3 = i;
                    i4 = i2;
                    if (i4 != 0) {
                    }
                    return false;
                }
            }
            try {
                mediaMetadataRetriever.release();
                i3 = i;
                i4 = i2;
            } catch (Exception e4) {
                e4.printStackTrace();
                i3 = i;
                i4 = i2;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            i2 = 0;
        }
        if (i4 != 0 || i3 == 0) {
            return false;
        }
        if (i4 <= this.mMaxEdgeLen && i3 <= this.mMaxEdgeLen) {
            i5 = i4;
        } else if (i4 > i3) {
            i5 = this.mMaxEdgeLen;
            i3 = (i3 * i5) / i4;
        } else {
            int i6 = this.mMaxEdgeLen;
            i5 = (i4 * i6) / i3;
            i3 = i6;
        }
        setVideoSize(i5, i3);
        return true;
    }

    private int syncWaitFinish() {
        while (this.mStatus == 1) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 5;
            }
        }
        return this.mStatus;
    }

    public void start() {
        stop();
        this.mStatus = 1;
        if (!executeTranscoder()) {
            this.mStatus = 5;
        }
    }

    public int startSync() {
        try {
            start();
            return syncWaitFinish();
        } catch (Throwable th) {
            return 2;
        }
    }

    private boolean executeTranscoder() {
        if (this.mStatus == 5) {
            return false;
        }
        if (this.mMaxEdgeLen > 0 && !setVideoSizeByMaxEdgeLen()) {
            if (this.mOnErrorListener != null) {
                this.mOnErrorListener.onError(0, 0);
                return false;
            }
            return false;
        }
        this.mTranscoder = new TranscoderManager();
        this.mTranscoder.setOnPreparedListener(new TranscoderManager.OnPreparedListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderPlugin.1
            @Override // com.baidu.searchbox.ugc.transcoder.TranscoderManager.OnPreparedListener
            public void onPrepared() {
                TranscoderPlugin.this.mTranscoder.start();
            }
        });
        this.mTranscoder.setOnErrorListener(this);
        this.mTranscoder.setOnCompletionListener(this);
        this.mTranscoder.setOnInfoListener(this);
        for (Map.Entry<String, String> entry : this.mVideoParams.entrySet()) {
            this.mTranscoder.setOption(entry.getKey(), entry.getValue());
        }
        this.mTranscoder.setDataSource(this.mDataSource);
        this.mTranscoder.setOutputFile(this.mOutputFile);
        this.mTranscoder.setTranscoderMode(2);
        this.mTranscoder.prepareAsync();
        return true;
    }

    public void stop() {
        if (this.mTranscoder != null) {
            this.mTranscoder.stop();
            this.mTranscoder.release();
        }
        this.mStatus = 5;
    }

    public void setOnErrorListener(TranscoderManager.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnCompletionListener(TranscoderManager.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.searchbox.ugc.transcoder.TranscoderManager.OnCompletionListener
    public void onCompletion() {
        this.mStatus = 4;
        if (this.mOnCompletionListener != null) {
            this.mOnCompletionListener.onCompletion();
        }
    }

    @Override // com.baidu.searchbox.ugc.transcoder.TranscoderManager.OnErrorListener
    public boolean onError(int i, int i2) {
        this.mStatus = 2;
        if (this.mOnErrorListener != null) {
            return this.mOnErrorListener.onError(i, i2);
        }
        return false;
    }

    @Override // com.baidu.searchbox.ugc.transcoder.TranscoderManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        return false;
    }
}
