package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static i f10369a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f10370b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10371c = false;

    private void c() {
        if (this.f10370b == null) {
            this.f10370b = new MediaPlayer();
        }
    }

    private void d() {
        MediaPlayer mediaPlayer = this.f10370b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f10370b = null;
        }
    }

    public boolean b() {
        return this.f10371c;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f10369a == null) {
                f10369a = new i();
            }
            iVar = f10369a;
        }
        return iVar;
    }

    public void b(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.f10371c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f10370b.setDataSource(str);
                this.f10370b.prepare();
                this.f10370b.start();
                this.f10370b.setOnCompletionListener(new k(this));
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
            this.f10371c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().f() != null) {
                this.f10370b.setDataSource(str);
                this.f10370b.prepare();
                this.f10370b.start();
                this.f10370b.setOnCompletionListener(new l(this));
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
                this.f10370b.setDataSource(str);
                this.f10370b.prepare();
                this.f10370b.start();
                this.f10370b.setOnCompletionListener(new j(this));
                return true;
            }
            return false;
        } catch (Exception unused) {
            com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
            return false;
        }
    }
}
