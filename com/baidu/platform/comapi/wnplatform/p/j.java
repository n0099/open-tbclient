package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f4695a;

    /* renamed from: b  reason: collision with root package name */
    private MediaPlayer f4696b = null;
    private boolean c = false;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f4695a == null) {
                f4695a = new j();
            }
            jVar = f4695a;
        }
        return jVar;
    }

    private j() {
    }

    public boolean b() {
        return this.c;
    }

    private void c() {
        if (this.f4696b == null) {
            this.f4696b = new MediaPlayer();
        }
    }

    private void d() {
        if (this.f4696b != null) {
            this.f4696b.release();
            this.f4696b = null;
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
            com.baidu.platform.comapi.wnplatform.n.d.a().a(true);
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.n.d.a().a(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
            this.f4696b.setDataSource(str);
            this.f4696b.prepare();
            this.f4696b.start();
            this.f4696b.setOnCompletionListener(new k(this));
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
            if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
                this.f4696b.setDataSource(str);
                this.f4696b.prepare();
                this.f4696b.start();
                this.f4696b.setOnCompletionListener(new l(this));
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
            if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
                this.f4696b.setDataSource(str);
                this.f4696b.prepare();
                this.f4696b.start();
                this.f4696b.setOnCompletionListener(new m(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
