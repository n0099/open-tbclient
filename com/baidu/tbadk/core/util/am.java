package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class am {
    private static am aio = null;
    private boolean aip = false;
    private boolean aiq = false;
    private int air = TbConfig.POST_IMAGE_SMALL;
    private String ais = String.valueOf(45);

    public static am vQ() {
        if (aio == null) {
            synchronized (am.class) {
                aio = new am();
            }
        }
        return aio;
    }

    public am() {
        vT();
        vR();
    }

    private void vR() {
        vX();
        vY();
        vZ();
    }

    public void aD(boolean z) {
        this.aiq = z;
    }

    public boolean vS() {
        return this.aiq;
    }

    public void aE(boolean z) {
        this.aip = z;
        vR();
    }

    private void vT() {
        this.aip = com.baidu.adp.lib.util.i.hs();
    }

    public boolean vU() {
        return this.aip;
    }

    public String vV() {
        return this.ais;
    }

    public int vW() {
        vZ();
        return this.air;
    }

    public void vX() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oX().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oX().getViewImageQuality() != 1 : !this.aip) {
            z = false;
        }
        aD(z);
    }

    public void vY() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oX().getViewImageQuality() == 0) {
            if (vU()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oX().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ais = valueOf;
    }

    public void vZ() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.h.oX().pa()) {
            case 0:
                if (!vU()) {
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
        this.air = i;
    }

    public static boolean wa() {
        return k.dR() && com.baidu.adp.gif.c.dQ();
    }
}
