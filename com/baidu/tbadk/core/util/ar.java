package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar bLf = null;
    private boolean bLg = false;
    private boolean bLh = false;
    private int bLi = TbConfig.POST_IMAGE_SMALL;
    private String bLj = String.valueOf(45);

    public static ar adp() {
        if (bLf == null) {
            synchronized (ar.class) {
                bLf = new ar();
            }
        }
        return bLf;
    }

    public ar() {
        ads();
        adq();
    }

    private void adq() {
        adx();
        ady();
        adz();
    }

    public void dD(boolean z) {
        this.bLh = z;
    }

    public boolean adr() {
        return this.bLh;
    }

    public void dE(boolean z) {
        this.bLg = z;
        adq();
    }

    private void ads() {
        this.bLg = com.baidu.adp.lib.util.j.kZ();
    }

    public boolean adt() {
        return this.bLg;
    }

    public String adu() {
        return this.bLj;
    }

    public int adv() {
        adz();
        return this.bLi;
    }

    public int adw() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void adx() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.Wy().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.Wy().getViewImageQuality() != 1 : !this.bLg) {
            z = false;
        }
        dD(z);
    }

    public void ady() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.Wy().getViewImageQuality() == 0) {
            if (adt()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.Wy().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bLj = valueOf;
    }

    public void adz() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.Wy().Wz()) {
            case 0:
                if (!adt()) {
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
        this.bLi = i;
    }

    public static boolean adA() {
        return m.hy() && com.baidu.adp.gif.c.hx();
    }
}
