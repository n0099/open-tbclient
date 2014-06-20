package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {
    private static Handler c;
    private WeakReference<Context> h;
    private WeakReference<Fragment> i;
    private WeakReference<Object> j;
    private static HandlerThread b = new HandlerThread("SessionAnalysisThread");
    private static q l = new q();
    static HashMap<String, v> a = new HashMap<>();
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private o k = new o();
    private int m = -1;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    private q() {
        b.start();
        b.setPriority(10);
        c = new Handler(b.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a(Object obj) {
        try {
            return (Context) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th) {
            com.baidu.mobstat.a.e.a(th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (context == null) {
            com.baidu.mobstat.a.e.a("statsdk", "clearLastSession(Context context):context=null");
        } else {
            com.baidu.mobstat.a.c.a(false, context, "__local_last_session.json", "{}", false);
        }
    }

    private void a(boolean z) {
        this.n = z;
    }

    public static q b() {
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "flush current session to last_session.json");
        new JSONObject();
        JSONObject c2 = this.k.c();
        try {
            c2.put("e", j);
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", "StatSession.flushSession() failed");
        }
        String jSONObject = c2.toString();
        com.baidu.mobstat.a.e.a("statsdk", "cacheString=" + jSONObject);
        com.baidu.mobstat.a.c.a(false, context, "__local_last_session.json", jSONObject, false);
    }

    private boolean e() {
        return this.n;
    }

    public int a() {
        if (this.m == -1) {
            this.m = 30000;
        }
        return this.m;
    }

    public void a(int i) {
        this.m = i * 1000;
    }

    public void a(Context context, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "AnalysisResume job");
        if (this.o) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.o = true;
        if (e()) {
            com.baidu.mobstat.a.e.a("is_first_resume=true");
            a(false);
            c.post(new r(this));
        } else {
            com.baidu.mobstat.a.e.a("statsdk", " is_first_resume=false");
        }
        c.post(new x(this, this.d, j, context, null, null, 1));
        this.h = new WeakReference<>(context);
        this.e = j;
    }

    public void a(Context context, long j, String str) {
        a(str);
        com.baidu.mobstat.a.e.a("statsdk", "AnalysisPageStart");
        if (b(str).b) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏StatService.onPageEnd() || missing StatService.onPageEnd()");
        }
        b(str).b = true;
        b(str).c = j;
        if (e()) {
            com.baidu.mobstat.a.e.b("PPPPPPPPPPPPP is_first_resume=true");
            a(false);
            c.post(new s(this));
        } else {
            com.baidu.mobstat.a.e.a("statsdk", " is_first_resume=false");
        }
        c.post(new x(this, this.d, j, context, null, null, 1));
        this.h = new WeakReference<>(context);
        this.e = j;
    }

    public void a(Fragment fragment, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "post resume job");
        if (this.p) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.p = true;
        if (e()) {
            com.baidu.mobstat.a.e.a("statsdk", "is_first_resume=true");
            a(false);
            c.post(new t(this));
        } else {
            com.baidu.mobstat.a.e.a("statsdk", "is_first_resume=false");
        }
        c.post(new x(this, this.d, j, null, fragment, null, 2));
        this.i = new WeakReference<>(fragment);
        this.f = j;
    }

    public void a(Object obj, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "post resume job");
        if (this.q) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.q = true;
        if (e()) {
            com.baidu.mobstat.a.e.a("statsdk", "is_first_resume=true");
            a(false);
            c.post(new u(this));
        } else {
            com.baidu.mobstat.a.e.a("statsdk", "is_first_resume=false");
        }
        c.post(new x(this, this.d, j, null, null, obj, 3));
        this.j = new WeakReference<>(obj);
        this.g = j;
    }

    void a(String str) {
        if (str == null) {
            com.baidu.mobstat.a.e.c("sdkstat", "page Object is null");
            return;
        }
        v vVar = new v(this, str);
        if (a.containsKey(str)) {
            return;
        }
        a.put(str, vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v b(String str) {
        if (str == null) {
            com.baidu.mobstat.a.e.c("sdkstat", "pageName is null");
            return null;
        }
        if (!a.containsKey(str)) {
            a(str);
        }
        return a.get(str);
    }

    public void b(Context context, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "post pause job");
        if (!this.o) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏StatService.onResume() || missing StatService.onResume()");
            return;
        }
        this.o = false;
        c.post(new w(this, j, context, null, this.e, this.h.get(), null, 1, null, null, null));
        this.d = j;
    }

    public void b(Context context, long j, String str) {
        com.baidu.mobstat.a.e.a("statsdk", "post pause job");
        if (b(str) == null) {
            com.baidu.mobstat.a.e.c("statsdk", "自定义页面" + str + "没有优先调用或者遗漏，请检查确保在onPageEnd函数之前调用onPageStart函数");
        } else if (!b(str).b) {
            com.baidu.mobstat.a.e.c("statsdk", "Please check (1)遗漏StatService.onPageStart() || missing StatService.onPageStart()");
        } else {
            b(str).b = false;
            b(str).d = j;
            c.post(new w(this, j, context, null, b(str).c, this.h.get(), null, 1, str, null, null));
            this.d = j;
        }
    }

    public void b(Fragment fragment, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "post pause job");
        if (!this.p) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏android.support.v4.app.Fragment StatService.onResume() || android.support.v4.app.Fragment missing StatService.onResume()");
            return;
        }
        this.p = false;
        c.post(new w(this, j, null, fragment, this.f, null, this.i.get(), 2, null, null, null));
        this.d = j;
    }

    public void b(Object obj, long j) {
        com.baidu.mobstat.a.e.a("statsdk", "post pause job");
        if (!this.q) {
            com.baidu.mobstat.a.e.c("statsdk", "遗漏android.app.Fragment StatService.onResume() || android.app.Fragment missing StatService.onResume()");
            return;
        }
        this.q = false;
        c.post(new w(this, j, null, null, this.g, null, null, 3, null, this.j.get(), obj));
        this.d = j;
    }

    public void c() {
        this.k.a(this.k.d() + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (str == null) {
            com.baidu.mobstat.a.e.c("sdkstat", "pageName is null");
        } else if (a.containsKey(str)) {
            a.remove(str);
        }
    }

    public long d() {
        return this.k.a();
    }
}
