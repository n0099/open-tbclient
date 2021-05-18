package com.baidu.mapsdkplatform.comapi.b.a;

import com.baidu.down.request.db.DownloadDataConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7616b = false;

    /* renamed from: a  reason: collision with root package name */
    public String f7617a;

    /* renamed from: c  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f7618c;

    /* renamed from: com.baidu.mapsdkplatform.comapi.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0097a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7619a = new a();
    }

    public a() {
        this.f7617a = "";
        this.f7618c = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static a a() {
        return C0097a.f7619a;
    }

    private void a(Throwable th) {
        if (th == null) {
            return;
        }
        String th2 = th.toString();
        if (th2.isEmpty() || th2.contains("BDMapSDKException")) {
            return;
        }
        if (th2.contains("com.baidu.platform") || th2.contains("com.baidu.mapsdkplatform") || th2.contains("com.baidu.mapsdkvi")) {
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                Throwable cause = th.getCause();
                if (cause != null) {
                    cause.printStackTrace(printWriter);
                }
                printWriter.close();
                String obj = stringWriter.toString();
                if (!obj.isEmpty() && this.f7617a != null && !this.f7617a.isEmpty()) {
                    File file = new File(URLEncoder.encode(this.f7617a + (System.currentTimeMillis() / 1000) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION, "UTF-8"));
                    if (file.exists() || file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(obj.getBytes());
                        fileOutputStream.close();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        this.f7617a = str;
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (f7616b) {
            return;
        }
        f7616b = true;
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7618c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
