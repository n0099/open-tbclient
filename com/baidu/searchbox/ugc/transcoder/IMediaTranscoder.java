package com.baidu.searchbox.ugc.transcoder;

import com.baidu.pyramid.runtime.service.d;
/* loaded from: classes18.dex */
public interface IMediaTranscoder {
    public static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_STREAM_STAT = 1000;
    public static final int MEDIA_INFO_STREAM_STAT_INPUT = 0;
    public static final int MEDIA_INFO_STREAM_STAT_OUTPUT = 1;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_NOP = 0;
    public static final int MEDIA_PREPARED = 1;
    public static final int MEDIA_TRANSCODER_COMPLETE = 2;
    public static final int MEDIA_TRANSCODER_TERMINAL = 3;
    public static final d SERVICE_REFERENCE = new d("ugc_upload", "media_transcoder");
    public static final int TRANSCODER_MODE_MAX = 2;
    public static final int TRANSCODER_MODE_MC = 0;
    public static final int TRANSCODER_MODE_SW = 1;

    /* loaded from: classes18.dex */
    public interface OnCompletionListener {
        void onCompletion(IMediaTranscoder iMediaTranscoder);
    }

    /* loaded from: classes18.dex */
    public interface OnErrorListener {
        boolean onError(IMediaTranscoder iMediaTranscoder, int i, int i2);
    }

    /* loaded from: classes18.dex */
    public interface OnInfoListener {
        boolean onInfo(IMediaTranscoder iMediaTranscoder, int i, int i2, Object obj);
    }

    /* loaded from: classes18.dex */
    public interface OnPreparedListener {
        void onPrepared(IMediaTranscoder iMediaTranscoder);
    }

    /* loaded from: classes18.dex */
    public interface OnTerminalListener {
        void onTerminal(IMediaTranscoder iMediaTranscoder);
    }

    String getCoreVersion();

    int getMode();

    String getSDKVersion();

    void pause();

    void prepareAsync();

    int probe();

    void release();

    void reset();

    void setDataSource(String str);

    void setNativeLogLevel(int i);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnTerminalListener(OnTerminalListener onTerminalListener);

    void setOption(String str);

    void setOption(String str, String str2);

    void setOutputFile(String str);

    void setTranscoderMode(int i);

    void start();

    void stop();
}
