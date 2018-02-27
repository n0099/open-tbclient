package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ao {
    private static ao aXq = null;
    private boolean aXr = false;
    private boolean aXs = false;
    private int aXt = TbConfig.POST_IMAGE_SMALL;
    private String aXu = String.valueOf(45);

    public static ao Dd() {
        if (aXq == null) {
            synchronized (ao.class) {
                aXq = new ao();
            }
        }
        return aXq;
    }

    public ao() {
        Dg();
        De();
    }

    private void De() {
        Dl();
        Dm();
        Dn();
    }

    public void bm(boolean z) {
        this.aXs = z;
    }

    public boolean Df() {
        return this.aXs;
    }

    public void bn(boolean z) {
        this.aXr = z;
        De();
    }

    private void Dg() {
        this.aXr = com.baidu.adp.lib.util.j.oK();
    }

    public boolean Dh() {
        return this.aXr;
    }

    public String Di() {
        return this.aXu;
    }

    public int Dj() {
        Dn();
        return this.aXt;
    }

    public int Dk() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Dl() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xo().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xo().getViewImageQuality() != 1 : !this.aXr) {
            z = false;
        }
        bm(z);
    }

    public void Dm() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.xo().getViewImageQuality() == 0) {
            if (Dh()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.xo().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aXu = valueOf;
    }

    public void Dn() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.xo().xr()) {
            case 0:
                if (!Dh()) {
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
        this.aXt = i;
    }

    public static boolean Do() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
