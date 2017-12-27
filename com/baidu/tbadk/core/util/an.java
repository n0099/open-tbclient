package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an aVR = null;
    private boolean aVS = false;
    private boolean aVT = false;
    private int aVU = TbConfig.POST_IMAGE_SMALL;
    private String aVV = String.valueOf(45);

    public static an CS() {
        if (aVR == null) {
            synchronized (an.class) {
                aVR = new an();
            }
        }
        return aVR;
    }

    public an() {
        CV();
        CT();
    }

    private void CT() {
        Da();
        Db();
        Dc();
    }

    public void bi(boolean z) {
        this.aVT = z;
    }

    public boolean CU() {
        return this.aVT;
    }

    public void bj(boolean z) {
        this.aVS = z;
        CT();
    }

    private void CV() {
        this.aVS = com.baidu.adp.lib.util.j.oJ();
    }

    public boolean CW() {
        return this.aVS;
    }

    public String CX() {
        return this.aVV;
    }

    public int CY() {
        Dc();
        return this.aVU;
    }

    public int CZ() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Da() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.wB().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.wB().getViewImageQuality() != 1 : !this.aVS) {
            z = false;
        }
        bi(z);
    }

    public void Db() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.wB().getViewImageQuality() == 0) {
            if (CW()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.wB().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aVV = valueOf;
    }

    public void Dc() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.wB().wE()) {
            case 0:
                if (!CW()) {
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
        this.aVU = i;
    }

    public static boolean Dd() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
