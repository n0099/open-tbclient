package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class d implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private Context b;
    private JSONObject c;
    private ConcurrentHashMap<Thread, Throwable> d;
    private String e;

    /* synthetic */ d(e eVar) {
        this();
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static d a = new d(null);

        private a() {
        }
    }

    private d() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = new ConcurrentHashMap<>();
    }

    public static d a() {
        return a.a;
    }

    public void a(Context context) {
        if (this.b == null) {
            if (context != null) {
                this.b = context.getApplicationContext();
            } else {
                return;
            }
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (this != defaultUncaughtExceptionHandler) {
            this.a = defaultUncaughtExceptionHandler;
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
        if (a(this.b, obj)) {
            a(System.currentTimeMillis(), obj, th2);
            new Thread(new e(this)).start();
        }
        if (this != this.a && this.a != null) {
            this.a.uncaughtException(thread, th);
        }
    }

    private void a(long j, String str, String str2) {
        if (this.b != null && str != null && !str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(c.a, j);
                if (str.getBytes().length > 51200) {
                    byte[] bArr = new byte[b.c];
                    str.getBytes(0, b.c, bArr, 0);
                    jSONObject.put(c.b, new String(bArr));
                } else {
                    jSONObject.put(c.b, str);
                }
                jSONObject.put(c.c, com.baidu.fsg.base.statistics.a.a(jSONObject.getString(c.b).getBytes(), false));
                try {
                    jSONObject.put(c.d, com.baidu.fsg.base.statistics.a.a());
                } catch (Exception e) {
                }
                try {
                    jSONObject.put(c.e, com.baidu.fsg.base.statistics.a.b(this.b));
                } catch (Exception e2) {
                }
                try {
                    jSONObject.put(c.f, com.baidu.fsg.base.statistics.a.c(this.b));
                } catch (Exception e3) {
                }
                f.a().a(jSONObject);
                com.baidu.fsg.base.statistics.a.a(this.b, b.n, f.a().d().toString(), false);
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
        String b = b();
        if (TextUtils.isEmpty(b) || (split = b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length <= 0) {
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
            sb.append("com.baidu.fsg.rimdemo").append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(com.baidu.fsg.base.a.b).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            this.e = sb.toString();
        }
        return this.e;
    }
}
