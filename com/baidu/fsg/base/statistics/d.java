package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f1938a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1939b;
    private JSONObject c;
    private ConcurrentHashMap<Thread, Throwable> d;
    private String e;

    /* synthetic */ d(e eVar) {
        this();
    }

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static d f1940a = new d(null);

        private a() {
        }
    }

    private d() {
        this.f1938a = null;
        this.f1939b = null;
        this.c = null;
        this.d = new ConcurrentHashMap<>();
    }

    public static d a() {
        return a.f1940a;
    }

    public void a(Context context) {
        if (this.f1939b == null) {
            if (context != null) {
                this.f1939b = context.getApplicationContext();
            } else {
                return;
            }
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (this != defaultUncaughtExceptionHandler) {
            this.f1938a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th == this.d.get(thread)) {
            if (thread.isAlive()) {
                thread.stop(th);
            }
            this.d.remove(thread);
            return;
        }
        this.d.put(thread, th);
        String th2 = th.toString();
        String str = "";
        if (th2 != null && !th2.equals("")) {
            try {
                str = th2.length() > 0 ? th2.split(":")[0] : th2;
            } catch (Exception e) {
                str = "";
            }
        }
        if (str != null && !str.equals("")) {
            th2 = str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        String obj = stringWriter.toString();
        if (a(this.f1939b, obj)) {
            a(System.currentTimeMillis(), obj, th2);
            new Thread(new e(this)).start();
        }
        if (this != this.f1938a && this.f1938a != null) {
            this.f1938a.uncaughtException(thread, th);
        }
    }

    private void a(long j, String str, String str2) {
        if (this.f1939b != null && str != null && !str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(c.f1936a, j);
                if (str.getBytes().length > 51200) {
                    byte[] bArr = new byte[b.c];
                    str.getBytes(0, b.c, bArr, 0);
                    jSONObject.put(c.f1937b, new String(bArr));
                } else {
                    jSONObject.put(c.f1937b, str);
                }
                jSONObject.put(c.c, com.baidu.fsg.base.statistics.a.a(jSONObject.getString(c.f1937b).getBytes(), false));
                try {
                    jSONObject.put(c.d, com.baidu.fsg.base.statistics.a.a());
                } catch (Exception e) {
                }
                try {
                    jSONObject.put(c.e, com.baidu.fsg.base.statistics.a.b(this.f1939b));
                } catch (Exception e2) {
                }
                try {
                    jSONObject.put(c.f, com.baidu.fsg.base.statistics.a.c(this.f1939b));
                } catch (Exception e3) {
                }
                f.a().a(jSONObject);
                com.baidu.fsg.base.statistics.a.a(this.f1939b, b.n, f.a().d().toString(), false);
            } catch (Exception e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context, String str) {
        String[] split;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2) || (split = b2.split(",")) == null || split.length <= 0) {
            return false;
        }
        for (String str2 : split) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        if (this.e == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.baidu.fsg.rimdemo").append(",");
            sb.append(com.baidu.fsg.base.a.f1860b).append(",");
            this.e = sb.toString();
        }
        return this.e;
    }
}
