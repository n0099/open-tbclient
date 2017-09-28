package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahe = null;
    private boolean ahf = false;
    private boolean ahg = false;
    private int ahh = TbConfig.POST_IMAGE_SMALL;
    private String ahi = String.valueOf(45);

    public static an vs() {
        if (ahe == null) {
            synchronized (an.class) {
                ahe = new an();
            }
        }
        return ahe;
    }

    public an() {
        vv();
        vt();
    }

    private void vt() {
        vz();
        vA();
        vB();
    }

    public void aD(boolean z) {
        this.ahg = z;
    }

    public boolean vu() {
        return this.ahg;
    }

    public void aE(boolean z) {
        this.ahf = z;
        vt();
    }

    private void vv() {
        this.ahf = com.baidu.adp.lib.util.j.hi();
    }

    public boolean vw() {
        return this.ahf;
    }

    public String vx() {
        return this.ahi;
    }

    public int vy() {
        vB();
        return this.ahh;
    }

    public void vz() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oT().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oT().getViewImageQuality() != 1 : !this.ahf) {
            z = false;
        }
        aD(z);
    }

    public void vA() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oT().getViewImageQuality() == 0) {
            if (vw()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oT().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ahi = valueOf;
    }

    public void vB() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.oT().oW()) {
            case 0:
                if (!vw()) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 1800;
                break;
        }
        this.ahh = i;
    }

    public static boolean vC() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
