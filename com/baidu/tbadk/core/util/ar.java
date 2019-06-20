package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar bSV = null;
    private boolean bSW = false;
    private boolean bSX = false;
    private int bSY = TbConfig.POST_IMAGE_SMALL;
    private String bSZ = String.valueOf(45);

    public static ar ail() {
        if (bSV == null) {
            synchronized (ar.class) {
                if (bSV == null) {
                    bSV = new ar();
                }
            }
        }
        return bSV;
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
        this.bSX = z;
    }

    public boolean ain() {
        return this.bSX;
    }

    public void ea(boolean z) {
        this.bSW = z;
        aim();
    }

    private void aio() {
        this.bSW = com.baidu.adp.lib.util.j.jT();
    }

    public boolean aip() {
        return this.bSW;
    }

    public String aiq() {
        return this.bSZ;
    }

    public int air() {
        aiv();
        return this.bSY;
    }

    public int ais() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void ait() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.abb().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.abb().getViewImageQuality() != 1 : !this.bSW) {
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
        this.bSZ = valueOf;
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
        this.bSY = i;
    }

    public static boolean aiw() {
        return m.gs() && com.baidu.adp.gif.c.gr();
    }
}
