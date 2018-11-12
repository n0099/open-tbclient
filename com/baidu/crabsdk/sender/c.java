package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import com.baidu.crabsdk.b.o;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes6.dex */
public final class c implements Thread.UncaughtExceptionHandler {
    public static boolean YD = false;
    private static final String YE = Environment.getExternalStorageDirectory().getPath() + File.separator + o.H() + File.separator + "oom" + File.separator;
    private static c YF = new c();
    private Thread.UncaughtExceptionHandler YG = null;
    private Context YH = null;

    private c() {
    }

    private static boolean i(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static c rw() {
        return YF;
    }

    public final void d(Context context) {
        if (this.YG == null) {
            this.YG = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.YH == null) {
            this.YH = context.getApplicationContext();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x018b -> B:69:0x0103). Please submit an issue!!! */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (com.baidu.crabsdk.a.J) {
            return;
        }
        com.baidu.crabsdk.a.J = true;
        String th2 = th.toString();
        String str = "";
        if (th2 != null && !th2.equals("")) {
            try {
                str = th2.length() > 1 ? th2.split(":")[0] : th2;
            } catch (Exception e) {
                str = "";
            }
        }
        if (str == null || str.equals("")) {
            str = th2;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String obj = stringWriter.toString();
        try {
            printWriter.close();
            stringWriter.close();
        } catch (IOException e2) {
            com.baidu.crabsdk.c.a.f("pw", e2);
        }
        if (obj != null && !str.trim().equals("")) {
            if (com.baidu.crabsdk.a.n && i(th)) {
                try {
                    String str2 = YE;
                    File file = new File(str2);
                    if (!file.exists()) {
                        if (file.mkdirs()) {
                            com.baidu.crabsdk.c.a.cJ("app文件创建ok  fileName is " + str2);
                        } else {
                            com.baidu.crabsdk.c.a.cJ("app文件创建失败  fileName is " + str2);
                        }
                    }
                    String str3 = str2 + System.currentTimeMillis() + ".hprof";
                    Debug.dumpHprofData(str3);
                    com.baidu.crabsdk.c.a.cI("输出OOM的dump信息 name=" + str3);
                } catch (Throwable th3) {
                    com.baidu.crabsdk.c.a.cJ("oom save fail" + th3.getMessage());
                }
            }
            if (e.ry() && e.Y() && e.j(th)) {
                YD = false;
                if (this.YH != null && thread != null && th != null) {
                    f.c(this.YH, f.j(d.a(this.YH, th, false)));
                    e.c(th);
                    e.k(th);
                    e.ab();
                    h.a(false, this.YH);
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (!YD) {
                            if (currentTimeMillis2 - currentTimeMillis > 2500) {
                                com.baidu.crabsdk.c.a.cI("T^T upload timeout!");
                                break;
                            }
                        } else {
                            com.baidu.crabsdk.c.a.cI("^^ upload finished()! --> cost : " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                            break;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (com.baidu.crabsdk.a.N != null) {
                com.baidu.crabsdk.a.N.onCrashStarted(thread, th);
            }
        }
        if (this.YG.equals(this)) {
            return;
        }
        this.YG.uncaughtException(thread, th);
    }
}
