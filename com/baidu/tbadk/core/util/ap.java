package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ap {
    private static ap aiW = null;
    private boolean aiX = false;
    private boolean aiY = false;
    private int aiZ = TbConfig.POST_IMAGE_SMALL;
    private String aja = String.valueOf(45);

    public static ap vP() {
        if (aiW == null) {
            synchronized (ap.class) {
                aiW = new ap();
            }
        }
        return aiW;
    }

    public ap() {
        vS();
        vQ();
    }

    private void vQ() {
        vX();
        vY();
        vZ();
    }

    public void aE(boolean z) {
        this.aiY = z;
    }

    public boolean vR() {
        return this.aiY;
    }

    public void aF(boolean z) {
        this.aiX = z;
        vQ();
    }

    private void vS() {
        this.aiX = com.baidu.adp.lib.util.j.gQ();
    }

    public boolean vT() {
        return this.aiX;
    }

    public String vU() {
        return this.aja;
    }

    public int vV() {
        vZ();
        return this.aiZ;
    }

    public int vW() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void vX() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.pX().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.pX().getViewImageQuality() != 1 : !this.aiX) {
            z = false;
        }
        aE(z);
    }

    public void vY() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.pX().getViewImageQuality() == 0) {
            if (vT()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.pX().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aja = valueOf;
    }

    public void vZ() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.pX().qa()) {
            case 0:
                if (!vT()) {
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

    public static boolean wa() {
        return k.m15do() && com.baidu.adp.gif.c.dn();
    }
}
