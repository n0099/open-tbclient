package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ax {
    private static ax agx = null;
    private boolean agy = false;
    private boolean agz = false;
    private int agA = TbConfig.POST_IMAGE_SMALL;
    private String agB = String.valueOf(45);

    public static ax vA() {
        if (agx == null) {
            synchronized (ax.class) {
                agx = new ax();
            }
        }
        return agx;
    }

    public ax() {
        vD();
        vB();
    }

    private void vB() {
        vH();
        vI();
        vJ();
    }

    public void aE(boolean z) {
        this.agz = z;
    }

    public boolean vC() {
        return this.agz;
    }

    public void aF(boolean z) {
        this.agy = z;
        vB();
    }

    private void vD() {
        this.agy = com.baidu.adp.lib.util.i.hk();
    }

    public boolean vE() {
        return this.agy;
    }

    public String vF() {
        return this.agB;
    }

    public int vG() {
        vJ();
        return this.agA;
    }

    public void vH() {
        boolean z = true;
        if (com.baidu.tbadk.core.r.oK().getViewImageQuality() != 0 ? com.baidu.tbadk.core.r.oK().getViewImageQuality() != 1 : !this.agy) {
            z = false;
        }
        aE(z);
    }

    public void vI() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.r.oK().getViewImageQuality() == 0) {
            if (vE()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.r.oK().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agB = valueOf;
    }

    public void vJ() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.r.oK().oN()) {
            case 0:
                if (!vE()) {
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
        this.agA = i;
    }

    public static boolean vK() {
        return n.dH() && com.baidu.adp.gif.e.dG();
    }
}
