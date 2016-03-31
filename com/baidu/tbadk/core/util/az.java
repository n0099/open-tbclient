package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class az {
    private static az acx = null;
    private boolean acy = false;
    private boolean acz = false;
    private int acA = TbConfig.POST_IMAGE_SMALL;
    private String acB = String.valueOf(45);

    public static az wz() {
        if (acx == null) {
            synchronized (az.class) {
                acx = new az();
            }
        }
        return acx;
    }

    public az() {
        wC();
        wA();
    }

    private void wA() {
        wG();
        wH();
        wI();
    }

    public void au(boolean z) {
        this.acz = z;
    }

    public boolean wB() {
        return this.acz;
    }

    public void av(boolean z) {
        this.acy = z;
        wA();
    }

    private void wC() {
        this.acy = com.baidu.adp.lib.util.i.jg();
    }

    public boolean wD() {
        return this.acy;
    }

    public String wE() {
        return this.acB;
    }

    public int wF() {
        wI();
        return this.acA;
    }

    public void wG() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.qE().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.qE().getViewImageQuality() != 1 : !this.acy) {
            z = false;
        }
        au(z);
    }

    public void wH() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.qE().getViewImageQuality() == 0) {
            if (wD()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.qE().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.acB = valueOf;
    }

    public void wI() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.qE().qH()) {
            case 0:
                if (!wD()) {
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
        this.acA = i;
    }

    public static boolean wJ() {
        return m.fr() && com.baidu.adp.gif.e.fq();
    }
}
