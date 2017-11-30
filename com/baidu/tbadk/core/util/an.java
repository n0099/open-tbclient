package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahK = null;
    private boolean ahL = false;
    private boolean ahM = false;
    private int ahN = TbConfig.POST_IMAGE_SMALL;
    private String ahO = String.valueOf(45);

    public static an vv() {
        if (ahK == null) {
            synchronized (an.class) {
                ahK = new an();
            }
        }
        return ahK;
    }

    public an() {
        vy();
        vw();
    }

    private void vw() {
        vD();
        vE();
        vF();
    }

    public void aA(boolean z) {
        this.ahM = z;
    }

    public boolean vx() {
        return this.ahM;
    }

    public void aB(boolean z) {
        this.ahL = z;
        vw();
    }

    private void vy() {
        this.ahL = com.baidu.adp.lib.util.j.hi();
    }

    public boolean vz() {
        return this.ahL;
    }

    public String vA() {
        return this.ahO;
    }

    public int vB() {
        vF();
        return this.ahN;
    }

    public int vC() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void vD() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.pa().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.pa().getViewImageQuality() != 1 : !this.ahL) {
            z = false;
        }
        aA(z);
    }

    public void vE() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.pa().getViewImageQuality() == 0) {
            if (vz()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.pa().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ahO = valueOf;
    }

    public void vF() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.pa().pd()) {
            case 0:
                if (!vz()) {
                    i = 1500;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 1500;
                break;
            default:
                i = 1800;
                break;
        }
        this.ahN = i;
    }

    public static boolean vG() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
