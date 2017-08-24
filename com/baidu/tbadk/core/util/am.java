package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class am {
    private static am aio = null;
    private boolean aip = false;
    private boolean aiq = false;
    private int air = TbConfig.POST_IMAGE_SMALL;
    private String ais = String.valueOf(45);

    public static am vR() {
        if (aio == null) {
            synchronized (am.class) {
                aio = new am();
            }
        }
        return aio;
    }

    public am() {
        vU();
        vS();
    }

    private void vS() {
        vY();
        vZ();
        wa();
    }

    public void aD(boolean z) {
        this.aiq = z;
    }

    public boolean vT() {
        return this.aiq;
    }

    public void aE(boolean z) {
        this.aip = z;
        vS();
    }

    private void vU() {
        this.aip = com.baidu.adp.lib.util.i.hs();
    }

    public boolean vV() {
        return this.aip;
    }

    public String vW() {
        return this.ais;
    }

    public int vX() {
        wa();
        return this.air;
    }

    public void vY() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oY().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oY().getViewImageQuality() != 1 : !this.aip) {
            z = false;
        }
        aD(z);
    }

    public void vZ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oY().getViewImageQuality() == 0) {
            if (vV()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oY().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ais = valueOf;
    }

    public void wa() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.h.oY().pb()) {
            case 0:
                if (!vV()) {
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

    public static boolean wb() {
        return k.dR() && com.baidu.adp.gif.c.dQ();
    }
}
