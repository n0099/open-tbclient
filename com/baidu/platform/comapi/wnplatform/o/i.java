package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f4458a;

    /* renamed from: b  reason: collision with root package name */
    private MediaPlayer f4459b = null;
    private boolean c = false;

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f4458a == null) {
                f4458a = new i();
            }
            iVar = f4458a;
        }
        return iVar;
    }

    private i() {
    }

    public boolean b() {
        return this.c;
    }

    private void c() {
        if (this.f4459b == null) {
            this.f4459b = new MediaPlayer();
        }
    }

    private void d() {
        if (this.f4459b != null) {
            this.f4459b.release();
            this.f4459b = null;
        }
    }

    public boolean a(String str) {
        boolean z = true;
        com.baidu.platform.comapi.wnplatform.d.a.b("WN player play-->" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        c();
        try {
            com.baidu.platform.comapi.wnplatform.m.d.a().a(true);
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
            this.f4459b.setDataSource(str);
            this.f4459b.prepare();
            this.f4459b.start();
            this.f4459b.setOnCompletionListener(new j(this));
            return z;
        }
        z = false;
        return z;
    }

    public void b(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f4459b.setDataSource(str);
                this.f4459b.prepare();
                this.f4459b.start();
                this.f4459b.setOnCompletionListener(new k(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playEnd-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f4459b.setDataSource(str);
                this.f4459b.prepare();
                this.f4459b.start();
                this.f4459b.setOnCompletionListener(new l(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
