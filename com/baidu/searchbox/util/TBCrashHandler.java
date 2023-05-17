package com.baidu.searchbox.util;

import android.util.Log;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class TBCrashHandler implements Thread.UncaughtExceptionHandler {
    public Thread.UncaughtExceptionHandler mHandler;

    public TBCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mHandler = uncaughtExceptionHandler;
    }

    private boolean isBlock(Throwable th) {
        try {
            boolean isLsPatchException = isLsPatchException(th);
            if (isLsPatchException) {
                try {
                    TiebaStatic.log(new StatisticItem("tb_block_err").addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_param1", Log.getStackTraceString(th)));
                    return isLsPatchException;
                } catch (Exception unused) {
                    return isLsPatchException;
                }
            }
            return isLsPatchException;
        } catch (Exception unused2) {
            return false;
        }
    }

    private boolean isLsPatchException(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString != null && stackTraceString.contains("com.baidu.tieba/cache/lspatch/origin") && stackTraceString.contains("java.lang.ClassNotFoundException")) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!isBlock(th) && (uncaughtExceptionHandler = this.mHandler) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
