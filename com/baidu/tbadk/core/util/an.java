package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahI = null;
    private boolean ahJ = false;
    private boolean ahK = false;
    private int ahL = TbConfig.POST_IMAGE_SMALL;
    private String ahM = String.valueOf(45);

    public static an vO() {
        if (ahI == null) {
            synchronized (an.class) {
                ahI = new an();
            }
        }
        return ahI;
    }

    public an() {
        vR();
        vP();
    }

    private void vP() {
        vV();
        vW();
        vX();
    }

    public void aD(boolean z) {
        this.ahK = z;
    }

    public boolean vQ() {
        return this.ahK;
    }

    public void aE(boolean z) {
        this.ahJ = z;
        vP();
    }

    private void vR() {
        this.ahJ = com.baidu.adp.lib.util.i.hj();
    }

    public boolean vS() {
        return this.ahJ;
    }

    public String vT() {
        return this.ahM;
    }

    public int vU() {
        vX();
        return this.ahL;
    }

    public void vV() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oS().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oS().getViewImageQuality() != 1 : !this.ahJ) {
            z = false;
        }
        aD(z);
    }

    public void vW() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oS().getViewImageQuality() == 0) {
            if (vS()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oS().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ahM = valueOf;
    }

    public void vX() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.oS().oV()) {
            case 0:
                if (!vS()) {
                    i = 600;
                    break;
                }
                break;
            case 3:
                i = 600;
                break;
        }
        this.ahL = i;
    }

    public static boolean vY() {
        return k.dH() && com.baidu.adp.gif.c.dG();
    }
}
