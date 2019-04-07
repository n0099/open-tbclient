package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar bLh = null;
    private boolean bLi = false;
    private boolean bLj = false;
    private int bLk = TbConfig.POST_IMAGE_SMALL;
    private String bLl = String.valueOf(45);

    public static ar adm() {
        if (bLh == null) {
            synchronized (ar.class) {
                bLh = new ar();
            }
        }
        return bLh;
    }

    public ar() {
        adp();
        adn();
    }

    private void adn() {
        adu();
        adv();
        adw();
    }

    public void dD(boolean z) {
        this.bLj = z;
    }

    public boolean ado() {
        return this.bLj;
    }

    public void dE(boolean z) {
        this.bLi = z;
        adn();
    }

    private void adp() {
        this.bLi = com.baidu.adp.lib.util.j.kZ();
    }

    public boolean adq() {
        return this.bLi;
    }

    public String adr() {
        return this.bLl;
    }

    public int ads() {
        adw();
        return this.bLk;
    }

    public int adt() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void adu() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.Wv().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.Wv().getViewImageQuality() != 1 : !this.bLi) {
            z = false;
        }
        dD(z);
    }

    public void adv() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.Wv().getViewImageQuality() == 0) {
            if (adq()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.Wv().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.bLl = valueOf;
    }

    public void adw() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.Wv().Ww()) {
            case 0:
                if (!adq()) {
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
        this.bLk = i;
    }

    public static boolean adx() {
        return m.hy() && com.baidu.adp.gif.c.hx();
    }
}
