package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes8.dex */
public final class f implements Thread.UncaughtExceptionHandler {
    public static boolean arf = false;
    private static final String arg = Environment.getExternalStorageDirectory().getPath() + File.separator + com.baidu.crabsdk.b.p.vd() + File.separator + "oom" + File.separator;
    private static f arh = new f();
    private Thread.UncaughtExceptionHandler ari = null;
    private Context arj = null;

    private f() {
    }

    private static boolean j(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static f vk() {
        return arh;
    }

    public final void e(Context context) {
        if (this.ari == null) {
            this.ari = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.arj == null) {
            this.arj = context.getApplicationContext();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x018a -> B:69:0x010c). Please submit an issue!!! */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (com.baidu.crabsdk.a.J) {
            return;
        }
        com.baidu.crabsdk.a.J = true;
        if (com.baidu.crabsdk.a.P != null) {
            com.baidu.crabsdk.a.P.onCrashStarted(thread, th);
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
            com.baidu.crabsdk.c.a.a("pw", e2);
        }
        if (obj != null && !str.trim().equals("")) {
            if (com.baidu.crabsdk.a.n && j(th)) {
                try {
                    String str2 = arg;
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
            if (h.vm() && h.ac() && h.k(th)) {
                arf = false;
                if (this.arj != null && thread != null && th != null) {
                    i.c(this.arj, i.e(g.a(this.arj, th, false)));
                    h.c(th);
                    h.l(th);
                    h.vo();
                    k.a(false, this.arj);
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (!arf) {
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
        if (this.ari.equals(this)) {
            return;
        }
        this.ari.uncaughtException(thread, th);
    }
}
