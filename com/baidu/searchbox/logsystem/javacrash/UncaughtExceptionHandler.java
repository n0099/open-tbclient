package com.baidu.searchbox.logsystem.javacrash;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.util.LLog;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "loki-java-UncaughtExceptionHandler";
    public Thread.UncaughtExceptionHandler mPreHandler;
    public List<ProcessExceptionListener> mProcessExceptionListeners;

    public abstract void processException(@NonNull Thread thread, @NonNull Throwable th);

    public UncaughtExceptionHandler(@Nullable List<ProcessExceptionListener> list) {
        this.mPreHandler = null;
        if (0 == 0) {
            this.mPreHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        this.mProcessExceptionListeners = list;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        List<ProcessExceptionListener> list;
        List<ProcessExceptionListener> list2;
        Log.d(TAG, Log.getStackTraceString(th));
        List<ProcessExceptionListener> list3 = this.mProcessExceptionListeners;
        if (list3 != null && list3.size() > 0) {
            z = true;
        } else {
            z = false;
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
                if (z && (list2 = this.mProcessExceptionListeners) != null) {
                    for (ProcessExceptionListener processExceptionListener2 : list2) {
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
                    if (z && (list = this.mProcessExceptionListeners) != null) {
                        for (ProcessExceptionListener processExceptionListener5 : list) {
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
