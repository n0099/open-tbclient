package com.baidu.searchbox.ugc.transcoder.interfaces;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public interface IUgcCommonTranscoderInterface {

    /* loaded from: classes4.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    /* loaded from: classes4.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2, Object obj);
    }

    /* loaded from: classes4.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* loaded from: classes4.dex */
    public interface OnTerminalListener {
        void onTerminal();
    }

    /* loaded from: classes4.dex */
    public interface TranscoderInvokeCallback {
        void invokeFailed();

        void invokeSuccess();
    }

    void createFFmpegCmdExecutor();

    boolean createMediaRemuxer();

    void createMediaTranscoder();

    void createMediaTranscoder(int i);

    String getCoreVersion();

    int getCurrentPosition();

    int getMode();

    String getSDKVersion();

    int getTotalSize();

    void install(Context context, String str) throws NullPointerException;

    void mediaRemuxerExecute(String str, String str2, FFmpegCmdListener fFmpegCmdListener);

    void mediaRemuxerRelease();

    void mediaRemuxerStop();

    void pause();

    void prepareAsync();

    int probe();

    void release();

    void releaseFFmpeg();

    void reset();

    void setDataSource(String str);

    void setFFmpegListener(FFmpegCmdListener fFmpegCmdListener);

    void setFFmpegSource(ArrayList<String> arrayList);

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

    void startFFmpeg();

    void stop();

    void testTranscoder(Activity activity);
}
