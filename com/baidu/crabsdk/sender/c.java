package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.crabsdk.b.o;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes2.dex */
public final class c implements Thread.UncaughtExceptionHandler {
    public static boolean Tn = false;
    private static final String To = Environment.getExternalStorageDirectory().getPath() + File.separator + o.G() + File.separator + "oom" + File.separator;
    private static c Tp = new c();
    private Thread.UncaughtExceptionHandler Tq = null;
    private Context Tr = null;

    private c() {
    }

    private static boolean g(Throwable th) {
        while (!"java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static c pl() {
        return Tp;
    }

    public final void d(Context context) {
        if (this.Tq == null) {
            this.Tq = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.Tr == null) {
            this.Tr = context.getApplicationContext();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x018f -> B:69:0x0103). Please submit an issue!!! */
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
                str = th2.length() > 1 ? th2.split(SystemInfoUtil.COLON)[0] : th2;
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
            com.baidu.crabsdk.c.a.b("pw", e2);
        }
        if (obj != null && !str.trim().equals("")) {
            if (com.baidu.crabsdk.a.n && g(th)) {
                try {
                    String str2 = To;
                    File file = new File(str2);
                    if (!file.exists()) {
                        if (file.mkdirs()) {
                            com.baidu.crabsdk.c.a.ch("app文件创建ok  fileName is " + str2);
                        } else {
                            com.baidu.crabsdk.c.a.ch("app文件创建失败  fileName is " + str2);
                        }
                    }
                    String str3 = str2 + System.currentTimeMillis() + ".hprof";
                    Debug.dumpHprofData(str3);
                    com.baidu.crabsdk.c.a.cg("输出OOM的dump信息 name=" + str3);
                } catch (Throwable th3) {
                    com.baidu.crabsdk.c.a.ch("oom save fail" + th3.getMessage());
                }
            }
            if (e.pn() && e.pp() && e.h(th)) {
                Tn = false;
                if (this.Tr != null && thread != null && th != null) {
                    f.c(this.Tr, f.j(d.a(this.Tr, th, false)));
                    e.i(th);
                    e.j(th);
                    e.aa();
                    h.a(false, this.Tr);
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (!Tn) {
                            if (currentTimeMillis2 - currentTimeMillis > 2500) {
                                com.baidu.crabsdk.c.a.cg("T^T upload timeout!");
                                break;
                            }
                        } else {
                            com.baidu.crabsdk.c.a.cg("^^ upload finished()! --> cost : " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                            break;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (com.baidu.crabsdk.a.M != null) {
                com.baidu.crabsdk.a.M.onCrashStarted(thread, th);
            }
        }
        if (!this.Tq.equals(this)) {
            this.Tq.uncaughtException(thread, th);
        }
        throw new RuntimeException(th);
    }
}
