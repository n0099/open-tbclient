package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ao {
    private static ao aXs = null;
    private boolean aXt = false;
    private boolean aXu = false;
    private int aXv = TbConfig.POST_IMAGE_SMALL;
    private String aXw = String.valueOf(45);

    public static ao De() {
        if (aXs == null) {
            synchronized (ao.class) {
                aXs = new ao();
            }
        }
        return aXs;
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
        this.aXu = z;
    }

    public boolean Dg() {
        return this.aXu;
    }

    public void bn(boolean z) {
        this.aXt = z;
        Df();
    }

    private void Dh() {
        this.aXt = com.baidu.adp.lib.util.j.oK();
    }

    public boolean Di() {
        return this.aXt;
    }

    public String Dj() {
        return this.aXw;
    }

    public int Dk() {
        Do();
        return this.aXv;
    }

    public int Dl() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Dm() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xo().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xo().getViewImageQuality() != 1 : !this.aXt) {
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
        this.aXw = valueOf;
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
        this.aXv = i;
    }

    public static boolean Dp() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
