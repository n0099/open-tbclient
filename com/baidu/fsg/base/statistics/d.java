package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f5207a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5208b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f5209c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Thread, Throwable> f5210d;

    /* renamed from: e  reason: collision with root package name */
    public String f5211e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f5212a = new d(null);
    }

    public /* synthetic */ d(e eVar) {
        this();
    }

    public static d a() {
        return a.f5212a;
    }

    public String b() {
        if (this.f5211e == null) {
            this.f5211e = "com.baidu.fsg.rimdemo," + com.baidu.fsg.base.a.f5024b + ",";
        }
        return this.f5211e;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String obj;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th == this.f5210d.get(thread)) {
            if (thread.isAlive()) {
                thread.stop(th);
            }
            this.f5210d.remove(thread);
            return;
        }
        this.f5210d.put(thread, th);
        String th2 = th.toString();
        if (th2 != null && !th2.equals("")) {
            try {
                str = th2.length() > 0 ? th2.split(":")[0] : th2;
            } catch (Exception unused) {
            }
            if (str != null && !str.equals("")) {
                th2 = str;
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            obj = stringWriter.toString();
            if (a(this.f5208b, obj)) {
                a(System.currentTimeMillis(), obj, th2);
                new Thread(new e(this)).start();
            }
            uncaughtExceptionHandler = this.f5207a;
            if (this != uncaughtExceptionHandler || uncaughtExceptionHandler == null) {
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        str = "";
        if (str != null) {
            th2 = str;
        }
        StringWriter stringWriter2 = new StringWriter();
        PrintWriter printWriter2 = new PrintWriter(stringWriter2);
        th.printStackTrace(printWriter2);
        printWriter2.close();
        obj = stringWriter2.toString();
        if (a(this.f5208b, obj)) {
        }
        uncaughtExceptionHandler = this.f5207a;
        if (this != uncaughtExceptionHandler) {
        }
    }

    public d() {
        this.f5207a = null;
        this.f5208b = null;
        this.f5209c = null;
        this.f5210d = new ConcurrentHashMap<>();
    }

    public void a(Context context) {
        if (this.f5208b == null) {
            if (context == null) {
                return;
            }
            this.f5208b = context.getApplicationContext();
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (this != defaultUncaughtExceptionHandler) {
            this.f5207a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void a(long j, String str, String str2) {
        if (this.f5208b != null && str != null && !str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dim_excep_time", j);
                if (str.getBytes().length > 51200) {
                    byte[] bArr = new byte[51200];
                    str.getBytes(0, 51200, bArr, 0);
                    jSONObject.put("dim_excep_cont", new String(bArr));
                } else {
                    jSONObject.put("dim_excep_cont", str);
                }
                jSONObject.put("dim_excep_type", com.baidu.fsg.base.statistics.a.a(jSONObject.getString("dim_excep_cont").getBytes(), false));
                try {
                    jSONObject.put("dim_excep_line_way", com.baidu.fsg.base.statistics.a.a());
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("dim_excep_free_mem", com.baidu.fsg.base.statistics.a.b(this.f5208b));
                } catch (Exception unused2) {
                }
                try {
                    jSONObject.put("dim_excep_total_mem", com.baidu.fsg.base.statistics.a.c(this.f5208b));
                } catch (Exception unused3) {
                }
                f.a().a(jSONObject);
                com.baidu.fsg.base.statistics.a.a(this.f5208b, b.n, f.a().d().toString(), false);
            } catch (Exception unused4) {
            }
        }
    }

    public boolean a(Context context, String str) {
        String[] split;
        if (context != null && !TextUtils.isEmpty(str)) {
            String b2 = b();
            if (!TextUtils.isEmpty(b2) && (split = b2.split(",")) != null && split.length > 0) {
                for (String str2 : split) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
