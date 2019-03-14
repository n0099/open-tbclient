package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public class i {
    private static i a;
    private MediaPlayer b = null;
    private boolean c = false;

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i();
            }
            iVar = a;
        }
        return iVar;
    }

    private i() {
    }

    public boolean b() {
        return this.c;
    }

    private void c() {
        if (this.b == null) {
            this.b = new MediaPlayer();
        }
    }

    private void d() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
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
            this.b.setDataSource(str);
            this.b.prepare();
            this.b.start();
            this.b.setOnCompletionListener(new j(this));
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
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new k(this));
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
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new l(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
