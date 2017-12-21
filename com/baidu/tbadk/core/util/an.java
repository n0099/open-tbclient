package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahH = null;
    private boolean ahI = false;
    private boolean ahJ = false;
    private int ahK = TbConfig.POST_IMAGE_SMALL;
    private String ahL = String.valueOf(45);

    public static an vs() {
        if (ahH == null) {
            synchronized (an.class) {
                ahH = new an();
            }
        }
        return ahH;
    }

    public an() {
        vv();
        vt();
    }

    private void vt() {
        vA();
        vB();
        vC();
    }

    public void aA(boolean z) {
        this.ahJ = z;
    }

    public boolean vu() {
        return this.ahJ;
    }

    public void aB(boolean z) {
        this.ahI = z;
        vt();
    }

    private void vv() {
        this.ahI = com.baidu.adp.lib.util.j.hi();
    }

    public boolean vw() {
        return this.ahI;
    }

    public String vx() {
        return this.ahL;
    }

    public int vy() {
        vC();
        return this.ahK;
    }

    public int vz() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void vA() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oY().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oY().getViewImageQuality() != 1 : !this.ahI) {
            z = false;
        }
        aA(z);
    }

    public void vB() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oY().getViewImageQuality() == 0) {
            if (vw()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oY().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ahL = valueOf;
    }

    public void vC() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.oY().pb()) {
            case 0:
                if (!vw()) {
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
        this.ahK = i;
    }

    public static boolean vD() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
