package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class as {
    private static as bTW = null;
    private boolean bTX = false;
    private boolean bTY = false;
    private int bTZ = TbConfig.POST_IMAGE_SMALL;
    private String bUa = String.valueOf(45);

    public static as ajo() {
        if (bTW == null) {
            synchronized (as.class) {
                if (bTW == null) {
                    bTW = new as();
                }
            }
        }
        return bTW;
    }

    public as() {
        ajr();
        ajp();
    }

    private void ajp() {
        ajw();
        ajx();
        ajy();
    }

    public void ed(boolean z) {
        this.bTY = z;
    }

    public boolean ajq() {
        return this.bTY;
    }

    public void ee(boolean z) {
        this.bTX = z;
        ajp();
    }

    private void ajr() {
        this.bTX = com.baidu.adp.lib.util.j.kd();
    }

    public boolean ajs() {
        return this.bTX;
    }

    public String ajt() {
        return this.bUa;
    }

    public int aju() {
        ajy();
        return this.bTZ;
    }

    public int ajv() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void ajw() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.aca().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.aca().getViewImageQuality() != 1 : !this.bTX) {
            z = false;
        }
        ed(z);
    }

    public void ajx() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.aca().getViewImageQuality() == 0) {
            if (ajs()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.aca().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bUa = valueOf;
    }

    public void ajy() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.aca().acb()) {
            case 0:
                if (!ajs()) {
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
        this.bTZ = i;
    }

    public static boolean ajz() {
        return m.gB() && com.baidu.adp.gif.c.gA();
    }
}
