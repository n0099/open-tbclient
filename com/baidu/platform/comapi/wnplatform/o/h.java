package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* loaded from: classes4.dex */
public class h {
    private static h a;
    private MediaPlayer b = null;
    private boolean c = false;

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    private h() {
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

    public void a(String str) {
        com.baidu.platform.comapi.wnplatform.c.a.a("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().d() != null) {
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new i(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        com.baidu.platform.comapi.wnplatform.c.a.a("yang12", "WN player playEnd-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().d() != null) {
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new j(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
