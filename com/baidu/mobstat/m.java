package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    private static Handler b;
    private WeakReference<Context> e;

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f966a = new HandlerThread("SessionAnalysisThread");
    private static m g = new m();
    private long c = 0;
    private long d = 0;
    private k f = new k();
    private boolean h = true;
    private boolean i = false;

    private m() {
        f966a.start();
        b = new Handler(f966a.getLooper());
    }

    public static m a() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (context == null) {
            com.baidu.mobstat.a.b.a("stat", "clearLastSession(Context context):context=null");
        } else {
            com.baidu.mobstat.a.a.a(false, context, "__local_last_session.json", "{}", false);
        }
    }

    private void a(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, long j) {
        com.baidu.mobstat.a.b.a("stat", "flush current session to last_session.json");
        new JSONObject();
        JSONObject c = this.f.c();
        try {
            c.put("e", j);
        } catch (JSONException e) {
            com.baidu.mobstat.a.b.a("stat", "StatSession.flushSession() failed");
        }
        com.baidu.mobstat.a.a.a(false, context, "__local_last_session.json", c.toString(), false);
    }

    private boolean d() {
        return this.h;
    }

    public void a(Context context, long j) {
        com.baidu.mobstat.a.b.a("stat", "post resume job");
        if (this.i) {
            com.baidu.mobstat.a.b.b("stat", "遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.i = true;
        if (d()) {
            a(false);
            b.post(new n(this));
        }
        b.post(new p(this, this.c, j, context));
        this.e = new WeakReference<>(context);
        this.d = j;
    }

    public void b() {
        this.f.a(this.f.d() + 1);
    }

    public void b(Context context, long j) {
        com.baidu.mobstat.a.b.a("stat", "post pause job");
        if (!this.i) {
            com.baidu.mobstat.a.b.b("stat", "遗漏StatService.onResume() || missing StatService.onResume()");
            return;
        }
        this.i = false;
        b.post(new o(this, j, context, this.d, this.e.get()));
        this.c = j;
    }

    public long c() {
        return this.f.a();
    }
}
