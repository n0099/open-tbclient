package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes3.dex */
public final class f implements Thread.UncaughtExceptionHandler {
    public static boolean Kn = false;
    private static final String Ko = Environment.getExternalStorageDirectory().getPath() + File.separator + com.baidu.crabsdk.b.o.G() + File.separator + "oom" + File.separator;
    private static f Kp = new f();
    private Thread.UncaughtExceptionHandler Kq = null;
    private Context Kr = null;

    private f() {
    }

    private static boolean h(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static f mx() {
        return Kp;
    }

    public final void e(Context context) {
        if (this.Kq == null) {
            this.Kq = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.Kr == null) {
            this.Kr = context.getApplicationContext();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x018a -> B:69:0x010c). Please submit an issue!!! */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (com.baidu.crabsdk.a.J) {
            return;
        }
        com.baidu.crabsdk.a.J = true;
        if (com.baidu.crabsdk.a.N != null) {
            com.baidu.crabsdk.a.N.onCrashStarted(thread, th);
        }
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
            if (com.baidu.crabsdk.a.n && h(th)) {
                try {
                    String str2 = Ko;
                    File file = new File(str2);
                    if (!file.exists()) {
                        if (file.mkdirs()) {
                            com.baidu.crabsdk.c.a.w("app文件创建ok  fileName is " + str2);
                        } else {
                            com.baidu.crabsdk.c.a.w("app文件创建失败  fileName is " + str2);
                        }
                    }
                    String str3 = str2 + System.currentTimeMillis() + ".hprof";
                    Debug.dumpHprofData(str3);
                    com.baidu.crabsdk.c.a.v("输出OOM的dump信息 name=" + str3);
                } catch (Throwable th3) {
                    com.baidu.crabsdk.c.a.w("oom save fail" + th3.getMessage());
                }
            }
            if (h.mz() && h.mB() && h.i(th)) {
                Kn = false;
                if (this.Kr != null && thread != null && th != null) {
                    i.c(this.Kr, i.g(g.a(this.Kr, th, false)));
                    h.c(th);
                    h.j(th);
                    h.aa();
                    k.a(false, this.Kr);
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (!Kn) {
                            if (currentTimeMillis2 - currentTimeMillis > 2500) {
                                com.baidu.crabsdk.c.a.v("T^T upload timeout!");
                                break;
                            }
                        } else {
                            com.baidu.crabsdk.c.a.v("^^ upload finished()! --> cost : " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                            break;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (this.Kq.equals(this)) {
            return;
        }
        this.Kq.uncaughtException(thread, th);
    }
}
