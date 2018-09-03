package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar arj = null;
    private boolean ark = false;
    private boolean arl = false;
    private int arm = TbConfig.POST_IMAGE_SMALL;
    private String arn = String.valueOf(45);

    public static ar zu() {
        if (arj == null) {
            synchronized (ar.class) {
                arj = new ar();
            }
        }
        return arj;
    }

    public ar() {
        zx();
        zv();
    }

    private void zv() {
        zC();
        zD();
        zE();
    }

    public void aJ(boolean z) {
        this.arl = z;
    }

    public boolean zw() {
        return this.arl;
    }

    public void aK(boolean z) {
        this.ark = z;
        zv();
    }

    private void zx() {
        this.ark = com.baidu.adp.lib.util.j.jF();
    }

    public boolean zy() {
        return this.ark;
    }

    public String zz() {
        return this.arn;
    }

    public int zA() {
        zE();
        return this.arm;
    }

    public int zB() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void zC() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.td().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.td().getViewImageQuality() != 1 : !this.ark) {
            z = false;
        }
        aJ(z);
    }

    public void zD() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.td().getViewImageQuality() == 0) {
            if (zy()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.td().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.arn = valueOf;
    }

    public void zE() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.td().tg()) {
            case 0:
                if (!zy()) {
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
        this.arm = i;
    }

    public static boolean zF() {
        return l.gd() && com.baidu.adp.gif.c.gb();
    }
}
