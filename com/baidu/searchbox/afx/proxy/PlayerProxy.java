package com.baidu.searchbox.afx.proxy;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class PlayerProxy implements IPlayer {
    protected OnReportListener mOnReportListener;
    protected OnVideoEndedListener mOnVideoEndedListener;
    protected OnVideoErrorListener mOnVideoErrorListener;
    protected OnVideoStartedListener mOnVideoStartedListener;
    protected PlayerState mPlayerState = PlayerState.NOT_PREPARED;
    protected String mSourcePath;

    /* loaded from: classes5.dex */
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
        this.mSourcePath = str;
        if (TextUtils.isEmpty(str)) {
            String sourcePath = getSourcePath();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            if (this.mOnReportListener != null) {
                this.mOnReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
            }
            if (this.mOnVideoErrorListener != null) {
                this.mOnVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
                return;
            }
            return;
        }
        setSourceFile(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSourceFile(File file) {
        FileInputStream fileInputStream;
        IOException iOException;
        FileInputStream fileInputStream2;
        if (file != null) {
            this.mSourcePath = file.getPath();
            try {
                fileInputStream2 = new FileInputStream(file);
            } catch (IOException e) {
                iOException = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                setSourceFD(fileInputStream2.getFD());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            } catch (IOException e3) {
                iOException = e3;
                fileInputStream = fileInputStream2;
                try {
                    iOException.printStackTrace();
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    String str = ErrorInfo.PARAMETER_ERROR_SRCFILE_ERRORMSG + file;
                    if (this.mOnReportListener != null) {
                        this.mOnReportListener.onError(new ErrorInfo(1, str, iOException, "-1", null, getSourcePath(), valueOf));
                    }
                    if (this.mOnVideoErrorListener != null) {
                        this.mOnVideoErrorListener.onError(new ErrorInfo(1, str, iOException, "-1", null, getSourcePath(), valueOf));
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
        String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
        if (this.mOnReportListener != null) {
            this.mOnReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
        }
        if (this.mOnVideoErrorListener != null) {
            this.mOnVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceAssets(Context context, String str) {
        this.mSourcePath = str;
        if (TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            if (this.mOnReportListener != null) {
                this.mOnReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
            }
            if (this.mOnVideoErrorListener != null) {
                this.mOnVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
                return;
            }
            return;
        }
        try {
            setSourceAfd(context.getAssets().openFd(str));
        } catch (IOException e) {
            e.printStackTrace();
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            String str2 = ErrorInfo.PARAMETER_ERROR_ASSETS_ERRORMSG + str;
            if (this.mOnReportListener != null) {
                this.mOnReportListener.onError(new ErrorInfo(1, str2, e, "-1", null, getSourcePath(), valueOf2));
            }
            if (this.mOnVideoErrorListener != null) {
                this.mOnVideoErrorListener.onError(new ErrorInfo(1, str2, e, "-1", null, getSourcePath(), valueOf2));
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public String getSourcePath() {
        return this.mSourcePath;
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

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnReportListener(OnReportListener onReportListener) {
        this.mOnReportListener = onReportListener;
    }

    public PlayerState getState() {
        return this.mPlayerState;
    }
}
