package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class am {
    private static am aim = null;
    private boolean ain = false;
    private boolean aio = false;
    private int aip = TbConfig.POST_IMAGE_SMALL;
    private String aiq = String.valueOf(45);

    public static am vQ() {
        if (aim == null) {
            synchronized (am.class) {
                aim = new am();
            }
        }
        return aim;
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
        this.aio = z;
    }

    public boolean vS() {
        return this.aio;
    }

    public void aE(boolean z) {
        this.ain = z;
        vR();
    }

    private void vT() {
        this.ain = com.baidu.adp.lib.util.i.hs();
    }

    public boolean vU() {
        return this.ain;
    }

    public String vV() {
        return this.aiq;
    }

    public int vW() {
        vZ();
        return this.aip;
    }

    public void vX() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oX().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oX().getViewImageQuality() != 1 : !this.ain) {
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
        this.aiq = valueOf;
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
        this.aip = i;
    }

    public static boolean wa() {
        return k.dR() && com.baidu.adp.gif.c.dQ();
    }
}
