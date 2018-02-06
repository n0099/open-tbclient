package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ao {
    private static ao aXC = null;
    private boolean aXD = false;
    private boolean aXE = false;
    private int aXF = TbConfig.POST_IMAGE_SMALL;
    private String aXG = String.valueOf(45);

    public static ao De() {
        if (aXC == null) {
            synchronized (ao.class) {
                aXC = new ao();
            }
        }
        return aXC;
    }

    public ao() {
        Dh();
        Df();
    }

    private void Df() {
        Dm();
        Dn();
        Do();
    }

    public void bm(boolean z) {
        this.aXE = z;
    }

    public boolean Dg() {
        return this.aXE;
    }

    public void bn(boolean z) {
        this.aXD = z;
        Df();
    }

    private void Dh() {
        this.aXD = com.baidu.adp.lib.util.j.oK();
    }

    public boolean Di() {
        return this.aXD;
    }

    public String Dj() {
        return this.aXG;
    }

    public int Dk() {
        Do();
        return this.aXF;
    }

    public int Dl() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Dm() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xo().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xo().getViewImageQuality() != 1 : !this.aXD) {
            z = false;
        }
        bm(z);
    }

    public void Dn() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.xo().getViewImageQuality() == 0) {
            if (Di()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.xo().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aXG = valueOf;
    }

    public void Do() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.xo().xr()) {
            case 0:
                if (!Di()) {
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
        this.aXF = i;
    }

    public static boolean Dp() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
