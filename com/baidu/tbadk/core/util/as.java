package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class as {
    private static as bUc = null;
    private boolean bUd = false;
    private boolean bUe = false;
    private int bUf = TbConfig.POST_IMAGE_SMALL;
    private String bUg = String.valueOf(45);

    public static as ajq() {
        if (bUc == null) {
            synchronized (as.class) {
                if (bUc == null) {
                    bUc = new as();
                }
            }
        }
        return bUc;
    }

    public as() {
        ajt();
        ajr();
    }

    private void ajr() {
        ajy();
        ajz();
        ajA();
    }

    public void ed(boolean z) {
        this.bUe = z;
    }

    public boolean ajs() {
        return this.bUe;
    }

    public void ee(boolean z) {
        this.bUd = z;
        ajr();
    }

    private void ajt() {
        this.bUd = com.baidu.adp.lib.util.j.kd();
    }

    public boolean aju() {
        return this.bUd;
    }

    public String ajv() {
        return this.bUg;
    }

    public int ajw() {
        ajA();
        return this.bUf;
    }

    public int ajx() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void ajy() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.aca().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.aca().getViewImageQuality() != 1 : !this.bUd) {
            z = false;
        }
        ed(z);
    }

    public void ajz() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.aca().getViewImageQuality() == 0) {
            if (aju()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.aca().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bUg = valueOf;
    }

    public void ajA() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.aca().acb()) {
            case 0:
                if (!aju()) {
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
        this.bUf = i;
    }

    public static boolean ajB() {
        return m.gB() && com.baidu.adp.gif.c.gA();
    }
}
