package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class bf {
    private static bf a = null;
    private boolean b = false;
    private boolean c = false;
    private int d = TbConfig.POST_IMAGE_SMALL;
    private String e = String.valueOf(45);

    public static bf a() {
        if (a == null) {
            synchronized (bf.class) {
                a = new bf();
            }
        }
        return a;
    }

    public bf() {
        k();
        j();
    }

    private void j() {
        f();
        g();
        h();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.b = z;
        j();
    }

    private void k() {
        this.b = UtilHelper.getNetStatusInfo(TbadkApplication.m252getInst().getApp().getApplicationContext()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    public boolean c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        h();
        return this.d;
    }

    public void f() {
        boolean z = true;
        if (com.baidu.tbadk.core.g.a().g() != 0 ? com.baidu.tbadk.core.g.a().g() != 1 : !this.b) {
            z = false;
        }
        a(z);
    }

    public void g() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.g.a().g() == 0) {
            if (c()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.g.a().g() == 1) {
            valueOf = String.valueOf(80);
        }
        this.e = valueOf;
    }

    public void h() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.g.a().e()) {
            case 0:
                if (!c()) {
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

    public static boolean i() {
        return x.a() && com.baidu.adp.gif.e.a();
    }
}
