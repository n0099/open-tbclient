package com.baidu.searchbox.afx.proxy;

import android.content.Context;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.gl.GLTextureView;
import java.io.File;
/* loaded from: classes2.dex */
public interface IPlayer {
    void destroy();

    int getCurrentPosition();

    long getDuration();

    int getFps();

    String getSourcePath();

    boolean isDestroyed();

    boolean isNotPrepared();

    boolean isPaused();

    boolean isPlaying();

    boolean isStopped();

    void pause();

    void play();

    void resume();

    void setGLTextureView(GLTextureView gLTextureView);

    void setLoopSection(int i);

    void setLoopSection(int i, int i2);

    void setLoopSection(long j);

    void setLoopSection(long j, long j2);

    void setLooping(boolean z);

    void setOnReportListener(OnReportListener onReportListener);

    void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener);

    void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener);

    void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener);

    void setSourceAssets(Context context, String str);

    void setSourceFile(File file);

    void setSourcePath(String str);

    void setSurface(Surface surface);

    void stop();
}
