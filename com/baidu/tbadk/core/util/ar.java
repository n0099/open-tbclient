package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar bUF = null;
    private boolean bUG = false;
    private boolean bUH = false;
    private int bUI = TbConfig.POST_IMAGE_SMALL;
    private String bUJ = String.valueOf(45);

    public static ar ajw() {
        if (bUF == null) {
            synchronized (ar.class) {
                if (bUF == null) {
                    bUF = new ar();
                }
            }
        }
        return bUF;
    }

    public ar() {
        ajz();
        ajx();
    }

    private void ajx() {
        ajE();
        ajF();
        ajG();
    }

    public void ed(boolean z) {
        this.bUH = z;
    }

    public boolean ajy() {
        return this.bUH;
    }

    public void ee(boolean z) {
        this.bUG = z;
        ajx();
    }

    private void ajz() {
        this.bUG = com.baidu.adp.lib.util.j.kd();
    }

    public boolean ajA() {
        return this.bUG;
    }

    public String ajB() {
        return this.bUJ;
    }

    public int ajC() {
        ajG();
        return this.bUI;
    }

    public int ajD() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void ajE() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.ace().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.ace().getViewImageQuality() != 1 : !this.bUG) {
            z = false;
        }
        ed(z);
    }

    public void ajF() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.ace().getViewImageQuality() == 0) {
            if (ajA()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.ace().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bUJ = valueOf;
    }

    public void ajG() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.ace().acf()) {
            case 0:
                if (!ajA()) {
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
        this.bUI = i;
    }

    public static boolean ajH() {
        return m.gB() && com.baidu.adp.gif.c.gA();
    }
}
