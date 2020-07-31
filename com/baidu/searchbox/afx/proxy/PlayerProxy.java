package com.baidu.searchbox.afx.proxy;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class PlayerProxy implements IPlayer {
    protected OnVideoEndedListener mOnVideoEndedListener;
    protected OnVideoErrorListener mOnVideoErrorListener;
    protected OnVideoStartedListener mOnVideoStartedListener;
    protected PlayerState mPlayerState = PlayerState.NOT_PREPARED;

    /* loaded from: classes6.dex */
    public enum PlayerState {
        NOT_PREPARED,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        STOPPED,
        DESTROYED
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourcePath(String str) {
        setSourceFile(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSourceFile(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    setSourceFD(fileInputStream.getFD());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (this.mOnVideoErrorListener != null) {
                        this.mOnVideoErrorListener.onError(new ErrorInfo(1, "设置播放源（文件）时发生错误，srcFile: " + file, e));
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceAssets(Context context, String str) {
        try {
            setSourceAfd(context.getAssets().openFd(str));
        } catch (IOException e) {
            e.printStackTrace();
            if (this.mOnVideoErrorListener != null) {
                this.mOnVideoErrorListener.onError(new ErrorInfo(1, "设置播放源（assets文件）时发生错误，assetsFileName: " + str, e));
            }
        }
    }

    protected void setSourceFD(FileDescriptor fileDescriptor) {
    }

    protected void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
    }

    protected void setSourceAfd(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            setSourceFD(assetFileDescriptor.getFileDescriptor());
        } else {
            setSourceFD(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j, long j2) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i, int i2) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        this.mPlayerState = PlayerState.PLAYING;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        this.mPlayerState = PlayerState.PAUSED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void resume() {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        this.mPlayerState = PlayerState.STOPPED;
        if (this.mOnVideoEndedListener != null) {
            this.mOnVideoEndedListener.onVideoEnded();
        }
    }

    public void reset() {
        this.mPlayerState = PlayerState.NOT_PREPARED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        this.mPlayerState = PlayerState.DESTROYED;
    }

    public final boolean isNotPrepared() {
        return this.mPlayerState == PlayerState.NOT_PREPARED;
    }

    public final boolean isPrepared() {
        return this.mPlayerState == PlayerState.PREPARED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPlaying() {
        return this.mPlayerState == PlayerState.PLAYING;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPaused() {
        return this.mPlayerState == PlayerState.PAUSED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isStopped() {
        return this.mPlayerState == PlayerState.STOPPED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isDestroyed() {
        return this.mPlayerState == PlayerState.DESTROYED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        this.mOnVideoStartedListener = onVideoStartedListener;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        this.mOnVideoEndedListener = onVideoEndedListener;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        this.mOnVideoErrorListener = onVideoErrorListener;
    }

    public PlayerState getState() {
        return this.mPlayerState;
    }
}
