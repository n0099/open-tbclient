package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar ari = null;
    private boolean arj = false;
    private boolean ark = false;
    private int arl = TbConfig.POST_IMAGE_SMALL;
    private String arm = String.valueOf(45);

    public static ar zw() {
        if (ari == null) {
            synchronized (ar.class) {
                ari = new ar();
            }
        }
        return ari;
    }

    public ar() {
        zz();
        zx();
    }

    private void zx() {
        zE();
        zF();
        zG();
    }

    public void aI(boolean z) {
        this.ark = z;
    }

    public boolean zy() {
        return this.ark;
    }

    public void aJ(boolean z) {
        this.arj = z;
        zx();
    }

    private void zz() {
        this.arj = com.baidu.adp.lib.util.j.jF();
    }

    public boolean zA() {
        return this.arj;
    }

    public String zB() {
        return this.arm;
    }

    public int zC() {
        zG();
        return this.arl;
    }

    public int zD() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void zE() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.te().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.te().getViewImageQuality() != 1 : !this.arj) {
            z = false;
        }
        aI(z);
    }

    public void zF() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.te().getViewImageQuality() == 0) {
            if (zA()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.te().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.arm = valueOf;
    }

    public void zG() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.te().th()) {
            case 0:
                if (!zA()) {
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
        this.arl = i;
    }

    public static boolean zH() {
        return l.gd() && com.baidu.adp.gif.c.gb();
    }
}
