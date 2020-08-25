package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
import android.text.TextUtils;
/* loaded from: classes20.dex */
public class j {
    private static j a;
    private MediaPlayer b = null;
    private boolean c = false;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    private j() {
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
            com.baidu.platform.comapi.wnplatform.n.d.a().a(true);
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.n.d.a().a(false);
        }
        if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
            this.b.setDataSource(str);
            this.b.prepare();
            this.b.start();
            this.b.setOnCompletionListener(new k(this));
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
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new l(this));
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
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new m(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
