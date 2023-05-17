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
/* loaded from: classes3.dex */
public abstract class PlayerProxy implements IPlayer {
    public OnReportListener mOnReportListener;
    public OnVideoEndedListener mOnVideoEndedListener;
    public OnVideoErrorListener mOnVideoErrorListener;
    public OnVideoStartedListener mOnVideoStartedListener;
    public PlayerState mPlayerState = PlayerState.NOT_PREPARED;
    public String mSourcePath;

    /* loaded from: classes3.dex */
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
    public void resume() {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i, int i2) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j, long j2) {
    }

    public void setSourceFD(FileDescriptor fileDescriptor) {
    }

    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        this.mPlayerState = PlayerState.DESTROYED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public String getSourcePath() {
        return this.mSourcePath;
    }

    public PlayerState getState() {
        return this.mPlayerState;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isDestroyed() {
        if (this.mPlayerState == PlayerState.DESTROYED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isNotPrepared() {
        if (this.mPlayerState == PlayerState.NOT_PREPARED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPaused() {
        if (this.mPlayerState == PlayerState.PAUSED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPlaying() {
        if (this.mPlayerState == PlayerState.PLAYING) {
            return true;
        }
        return false;
    }

    public final boolean isPrepared() {
        if (this.mPlayerState == PlayerState.PREPARED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isStopped() {
        if (this.mPlayerState == PlayerState.STOPPED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        this.mPlayerState = PlayerState.PAUSED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        this.mPlayerState = PlayerState.PLAYING;
    }

    public void reset() {
        this.mPlayerState = PlayerState.NOT_PREPARED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        this.mPlayerState = PlayerState.STOPPED;
        OnVideoEndedListener onVideoEndedListener = this.mOnVideoEndedListener;
        if (onVideoEndedListener != null) {
            onVideoEndedListener.onVideoEnded();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnReportListener(OnReportListener onReportListener) {
        this.mOnReportListener = onReportListener;
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
    public final void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        this.mOnVideoStartedListener = onVideoStartedListener;
    }

    public void setSourceAfd(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            setSourceFD(assetFileDescriptor.getFileDescriptor());
        } else {
            setSourceFD(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceAssets(Context context, String str) {
        this.mSourcePath = str;
        if (TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            OnReportListener onReportListener = this.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
            }
            OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
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
            OnReportListener onReportListener2 = this.mOnReportListener;
            if (onReportListener2 != null) {
                onReportListener2.onError(new ErrorInfo(1, str2, e, "-1", null, getSourcePath(), valueOf2));
            }
            OnVideoErrorListener onVideoErrorListener2 = this.mOnVideoErrorListener;
            if (onVideoErrorListener2 != null) {
                onVideoErrorListener2.onError(new ErrorInfo(1, str2, e, "-1", null, getSourcePath(), valueOf2));
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0082: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:27:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSourceFile(File file) {
        FileInputStream fileInputStream;
        IOException e;
        FileInputStream fileInputStream2;
        if (file != null) {
            this.mSourcePath = file.getPath();
            FileInputStream fileInputStream3 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            setSourceFD(fileInputStream.getFD());
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                            String str = ErrorInfo.PARAMETER_ERROR_SRCFILE_ERRORMSG + file;
                            if (this.mOnReportListener != null) {
                                this.mOnReportListener.onError(new ErrorInfo(1, str, e, "-1", null, getSourcePath(), valueOf));
                            }
                            if (this.mOnVideoErrorListener != null) {
                                this.mOnVideoErrorListener.onError(new ErrorInfo(1, str, e, "-1", null, getSourcePath(), valueOf));
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream2;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    fileInputStream = null;
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream3 != null) {
                    }
                    throw th;
                }
                return;
            } catch (IOException e5) {
                e5.printStackTrace();
                return;
            }
        }
        String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
        OnReportListener onReportListener = this.mOnReportListener;
        if (onReportListener != null) {
            onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
        }
        OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
        if (onVideoErrorListener != null) {
            onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourcePath(String str) {
        this.mSourcePath = str;
        if (TextUtils.isEmpty(str)) {
            String sourcePath = getSourcePath();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            OnReportListener onReportListener = this.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
            }
            OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
                return;
            }
            return;
        }
        setSourceFile(new File(str));
    }
}
