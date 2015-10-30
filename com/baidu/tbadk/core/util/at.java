package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class at {
    private static at abm = null;
    private boolean abn = false;
    private boolean abo = false;
    private int abp = TbConfig.POST_IMAGE_SMALL;
    private String abq = String.valueOf(45);

    public static at uG() {
        if (abm == null) {
            synchronized (at.class) {
                abm = new at();
            }
        }
        return abm;
    }

    public at() {
        uJ();
        uH();
    }

    private void uH() {
        uN();
        uO();
        uP();
    }

    public void ar(boolean z) {
        this.abo = z;
    }

    public boolean uI() {
        return this.abo;
    }

    public void as(boolean z) {
        this.abn = z;
        uH();
    }

    private void uJ() {
        this.abn = com.baidu.adp.lib.util.i.iN();
    }

    public boolean uK() {
        return this.abn;
    }

    public String uL() {
        return this.abq;
    }

    public int uM() {
        uP();
        return this.abp;
    }

    public void uN() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.qU().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.qU().getViewImageQuality() != 1 : !this.abn) {
            z = false;
        }
        ar(z);
    }

    public void uO() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.qU().getViewImageQuality() == 0) {
            if (uK()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.qU().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abq = valueOf;
    }

    public void uP() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.qU().qX()) {
            case 0:
                if (!uK()) {
                    i = 600;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 750;
                break;
            case 3:
                i = 600;
                break;
            default:
                i = 750;
                break;
        }
        this.abp = i;
    }

    public static boolean uQ() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
