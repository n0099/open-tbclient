package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahH = null;
    private boolean ahI = false;
    private boolean ahJ = false;
    private int ahK = TbConfig.POST_IMAGE_SMALL;
    private String ahL = String.valueOf(45);

    public static an vO() {
        if (ahH == null) {
            synchronized (an.class) {
                ahH = new an();
            }
        }
        return ahH;
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
        this.ahJ = z;
    }

    public boolean vQ() {
        return this.ahJ;
    }

    public void aE(boolean z) {
        this.ahI = z;
        vP();
    }

    private void vR() {
        this.ahI = com.baidu.adp.lib.util.i.hj();
    }

    public boolean vS() {
        return this.ahI;
    }

    public String vT() {
        return this.ahL;
    }

    public int vU() {
        vX();
        return this.ahK;
    }

    public void vV() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oS().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oS().getViewImageQuality() != 1 : !this.ahI) {
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
        this.ahL = valueOf;
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
        this.ahK = i;
    }

    public static boolean vY() {
        return k.dH() && com.baidu.adp.gif.c.dG();
    }
}
