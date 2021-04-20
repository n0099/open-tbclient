package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.util.n;
import com.facebook.cache.disk.DefaultDiskStorage;
/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.widget.g f1794a;

    /* renamed from: b  reason: collision with root package name */
    public String f1795b;

    /* renamed from: c  reason: collision with root package name */
    public String f1796c;

    /* renamed from: d  reason: collision with root package name */
    public String f1797d;

    /* renamed from: e  reason: collision with root package name */
    public String f1798e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1799f;

    /* renamed from: g  reason: collision with root package name */
    public String f1800g;

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.f1811a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.g gVar = this.f1794a;
        if (gVar instanceof com.alipay.sdk.widget.h) {
            gVar.b();
            return;
        }
        if (!gVar.b()) {
            super.onBackPressed();
        }
        j.a(j.c());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url", null);
            this.f1795b = string;
            if (!n.f(string)) {
                finish();
                return;
            }
            this.f1797d = extras.getString("cookie", null);
            this.f1796c = extras.getString("method", null);
            this.f1798e = extras.getString("title", null);
            this.f1800g = extras.getString("version", "v1");
            this.f1799f = extras.getBoolean("backisexit", false);
            try {
                if (DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX.equals(this.f1800g)) {
                    com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this);
                    setContentView(jVar);
                    jVar.a(this.f1798e, this.f1796c, this.f1799f);
                    jVar.a(this.f1795b);
                    this.f1794a = jVar;
                    return;
                }
                com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this);
                this.f1794a = hVar;
                setContentView(hVar);
                this.f1794a.a(this.f1795b, this.f1797d);
                this.f1794a.a(this.f1795b);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", "GetInstalledAppEx", th);
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1794a.a();
    }
}
