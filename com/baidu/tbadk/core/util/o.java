package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
/* loaded from: classes.dex */
public class o {
    private static Toast a;
    private static Handler b = new Handler();
    private static Runnable c = new p();
    private boolean d;

    public static o a() {
        return new o();
    }

    private o() {
    }

    public void a(String str, int i, int i2) {
        if (!this.d && str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                b.removeCallbacks(c);
                if (a != null) {
                    a.setText(trim);
                } else {
                    a = Toast.makeText(com.baidu.adp.base.a.getInst().getApp(), trim, 0);
                    a.setGravity(17, 0, i2);
                }
                b.postDelayed(c, i);
                a.show();
            }
        }
    }

    public void a(String str, int i) {
        a(str, i, com.baidu.adp.lib.util.h.a((Context) com.baidu.adp.base.a.getInst().getApp(), 100.0f));
    }

    public void a(int i, int i2) {
        a(com.baidu.adp.base.a.getInst().getApp().getResources().getString(i), i2);
    }

    public void a(int i, int i2, int i3) {
        a(com.baidu.adp.base.a.getInst().getApp().getResources().getString(i), i2, i3);
    }

    public void b() {
        this.d = true;
        d();
    }

    public void c() {
        this.d = false;
    }

    public static void d() {
        if (a != null) {
            b.removeCallbacks(c);
            a.cancel();
            a = null;
        }
    }
}
