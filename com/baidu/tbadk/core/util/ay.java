package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ay {
    private static ay acx = null;
    private boolean acy = false;
    private boolean acz = false;
    private int acA = TbConfig.POST_IMAGE_SMALL;
    private String acB = String.valueOf(45);

    public static ay vC() {
        if (acx == null) {
            synchronized (ay.class) {
                acx = new ay();
            }
        }
        return acx;
    }

    public ay() {
        vF();
        vD();
    }

    private void vD() {
        vJ();
        vK();
        vL();
    }

    public void aE(boolean z) {
        this.acz = z;
    }

    public boolean vE() {
        return this.acz;
    }

    public void aF(boolean z) {
        this.acy = z;
        vD();
    }

    private void vF() {
        this.acy = com.baidu.adp.lib.util.i.gn();
    }

    public boolean vG() {
        return this.acy;
    }

    public String vH() {
        return this.acB;
    }

    public int vI() {
        vL();
        return this.acA;
    }

    public void vJ() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oJ().getViewImageQuality() != 1 : !this.acy) {
            z = false;
        }
        aE(z);
    }

    public void vK() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() == 0) {
            if (vG()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oJ().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.acB = valueOf;
    }

    public void vL() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oJ().oM()) {
            case 0:
                if (!vG()) {
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

    public static boolean vM() {
        return m.cA() && com.baidu.adp.gif.e.cz();
    }
}
