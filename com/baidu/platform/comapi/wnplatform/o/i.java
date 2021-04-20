package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static i f9928a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f9929b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9930c = false;

    private void c() {
        if (this.f9929b == null) {
            this.f9929b = new MediaPlayer();
        }
    }

    private void d() {
        MediaPlayer mediaPlayer = this.f9929b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f9929b = null;
        }
    }

    public boolean b() {
        return this.f9930c;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f9928a == null) {
                f9928a = new i();
            }
            iVar = f9928a;
        }
        return iVar;
    }

    public void b(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.f9930c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f9929b.setDataSource(str);
                this.f9929b.prepare();
                this.f9929b.start();
                this.f9929b.setOnCompletionListener(new k(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playEnd-->" + str);
        d();
        c();
        try {
            this.f9930c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f9929b.setDataSource(str);
                this.f9929b.prepare();
                this.f9929b.start();
                this.f9929b.setOnCompletionListener(new l(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("WN player play-->" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        c();
        try {
            com.baidu.platform.comapi.wnplatform.m.d.a().a(true);
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f9929b.setDataSource(str);
                this.f9929b.prepare();
                this.f9929b.start();
                this.f9929b.setOnCompletionListener(new j(this));
                return true;
            }
            return false;
        } catch (Exception unused) {
            com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
            return false;
        }
    }
}
