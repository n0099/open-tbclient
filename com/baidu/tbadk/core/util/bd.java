package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class bd {
    private static bd a = null;
    private boolean b;
    private boolean c = false;
    private int d = 600;
    private String e = String.valueOf(45);

    public static bd a() {
        if (a == null) {
            synchronized (bd.class) {
                a = new bd();
            }
        }
        return a;
    }

    public bd() {
        this.b = false;
        this.b = UtilHelper.d(TbadkApplication.j().b().getApplicationContext()) == UtilHelper.NetworkStateInfo.WIFI;
        i();
    }

    private void i() {
        f();
        g();
        h();
    }

    public final boolean b() {
        return this.c;
    }

    public final void a(boolean z) {
        this.b = z;
        i();
    }

    public final boolean c() {
        return this.b;
    }

    public final String d() {
        return this.e;
    }

    public final int e() {
        h();
        return this.d;
    }

    public final void f() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.a().g() != 0 ? com.baidu.tbadk.core.h.a().g() != 1 : !this.b) {
            z = false;
        }
        this.c = z;
    }

    public final void g() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.a().g() == 0) {
            if (this.b) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.a().g() == 1) {
            valueOf = String.valueOf(80);
        }
        this.e = valueOf;
    }

    public final void h() {
        int i = 900;
        switch (com.baidu.tbadk.core.h.a().e()) {
            case 0:
                if (!this.b) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 750;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 750;
                break;
        }
        this.d = i;
    }
}
