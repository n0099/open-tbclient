package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar bSU = null;
    private boolean bSV = false;
    private boolean bSW = false;
    private int bSX = TbConfig.POST_IMAGE_SMALL;
    private String bSY = String.valueOf(45);

    public static ar ail() {
        if (bSU == null) {
            synchronized (ar.class) {
                if (bSU == null) {
                    bSU = new ar();
                }
            }
        }
        return bSU;
    }

    public ar() {
        aio();
        aim();
    }

    private void aim() {
        ait();
        aiu();
        aiv();
    }

    public void dZ(boolean z) {
        this.bSW = z;
    }

    public boolean ain() {
        return this.bSW;
    }

    public void ea(boolean z) {
        this.bSV = z;
        aim();
    }

    private void aio() {
        this.bSV = com.baidu.adp.lib.util.j.jT();
    }

    public boolean aip() {
        return this.bSV;
    }

    public String aiq() {
        return this.bSY;
    }

    public int air() {
        aiv();
        return this.bSX;
    }

    public int ais() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void ait() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.abb().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.abb().getViewImageQuality() != 1 : !this.bSV) {
            z = false;
        }
        dZ(z);
    }

    public void aiu() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.abb().getViewImageQuality() == 0) {
            if (aip()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.abb().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bSY = valueOf;
    }

    public void aiv() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.abb().abc()) {
            case 0:
                if (!aip()) {
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
        this.bSX = i;
    }

    public static boolean aiw() {
        return m.gs() && com.baidu.adp.gif.c.gr();
    }
}
