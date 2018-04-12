package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ap {
    private static ap aiW = null;
    private boolean aiX = false;
    private boolean aiY = false;
    private int aiZ = TbConfig.POST_IMAGE_SMALL;
    private String aja = String.valueOf(45);

    public static ap vQ() {
        if (aiW == null) {
            synchronized (ap.class) {
                aiW = new ap();
            }
        }
        return aiW;
    }

    public ap() {
        vT();
        vR();
    }

    private void vR() {
        vY();
        vZ();
        wa();
    }

    public void aE(boolean z) {
        this.aiY = z;
    }

    public boolean vS() {
        return this.aiY;
    }

    public void aF(boolean z) {
        this.aiX = z;
        vR();
    }

    private void vT() {
        this.aiX = com.baidu.adp.lib.util.j.gQ();
    }

    public boolean vU() {
        return this.aiX;
    }

    public String vV() {
        return this.aja;
    }

    public int vW() {
        wa();
        return this.aiZ;
    }

    public int vX() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void vY() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.pY().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.pY().getViewImageQuality() != 1 : !this.aiX) {
            z = false;
        }
        aE(z);
    }

    public void vZ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.pY().getViewImageQuality() == 0) {
            if (vU()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.pY().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aja = valueOf;
    }

    public void wa() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.pY().qb()) {
            case 0:
                if (!vU()) {
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
        this.aiZ = i;
    }

    public static boolean wb() {
        return k.m15do() && com.baidu.adp.gif.c.dn();
    }
}
