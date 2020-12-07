package com.baidu.searchbox.logsystem.javacrash;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.logsystem.util.LLog;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "loki-java-UncaughtExceptionHandler";
    private Thread.UncaughtExceptionHandler mPreHandler;
    private List<ProcessExceptionListener> mProcessExceptionListeners;

    protected abstract void processException(@NonNull Thread thread, @NonNull Throwable th);

    public UncaughtExceptionHandler(@Nullable List<ProcessExceptionListener> list) {
        this.mPreHandler = null;
        if (this.mPreHandler == null) {
            this.mPreHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        this.mProcessExceptionListeners = list;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        Log.d(TAG, Log.getStackTraceString(th));
        if (this.mProcessExceptionListeners == null || this.mProcessExceptionListeners.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            try {
                if (this.mProcessExceptionListeners != null) {
                    for (ProcessExceptionListener processExceptionListener : this.mProcessExceptionListeners) {
                        if (processExceptionListener != null) {
                            processExceptionListener.onProcessExceptionStart(this, th);
                        }
                    }
                }
            } catch (Throwable th2) {
                if (LLog.sDebug) {
                    th2.printStackTrace();
                }
                if (z && this.mProcessExceptionListeners != null) {
                    for (ProcessExceptionListener processExceptionListener2 : this.mProcessExceptionListeners) {
                        if (processExceptionListener2 != null) {
                            try {
                                processExceptionListener2.onProcessExceptionFail(this, th, th2);
                            } catch (Throwable th3) {
                                if (LLog.sDebug) {
                                    Log.d(TAG, Log.getStackTraceString(th3));
                                }
                            }
                        }
                    }
                }
            }
        }
        processException(thread, th);
        if (z && this.mProcessExceptionListeners != null) {
            for (ProcessExceptionListener processExceptionListener3 : this.mProcessExceptionListeners) {
                if (processExceptionListener3 != null) {
                    processExceptionListener3.onProcessExceptionSuccess(this, th);
                }
            }
        }
        if (this.mPreHandler != null) {
            if (z) {
                try {
                    if (this.mProcessExceptionListeners != null) {
                        for (ProcessExceptionListener processExceptionListener4 : this.mProcessExceptionListeners) {
                            if (processExceptionListener4 != null) {
                                processExceptionListener4.onProxyProcessExceptionStart(this.mPreHandler, th);
                            }
                        }
                    }
                } catch (Throwable th4) {
                    if (LLog.sDebug) {
                        th4.printStackTrace();
                    }
                    if (z && this.mProcessExceptionListeners != null) {
                        for (ProcessExceptionListener processExceptionListener5 : this.mProcessExceptionListeners) {
                            if (processExceptionListener5 != null) {
                                try {
                                    processExceptionListener5.onProxyProcessExceptionFail(this.mPreHandler, th4, th4);
                                } catch (Throwable th5) {
                                    if (LLog.sDebug) {
                                        Log.d(TAG, Log.getStackTraceString(th5));
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            this.mPreHandler.uncaughtException(thread, th);
            if (z && this.mProcessExceptionListeners != null) {
                for (ProcessExceptionListener processExceptionListener6 : this.mProcessExceptionListeners) {
                    if (processExceptionListener6 != null) {
                        processExceptionListener6.onProxyProcessExceptionSuccess(this.mPreHandler, th);
                    }
                }
            }
        }
    }
}
