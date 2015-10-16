package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class at {
    private static at abm = null;
    private boolean abn = false;
    private boolean abo = false;
    private int abp = TbConfig.POST_IMAGE_SMALL;
    private String abq = String.valueOf(45);

    public static at uJ() {
        if (abm == null) {
            synchronized (at.class) {
                abm = new at();
            }
        }
        return abm;
    }

    public at() {
        uM();
        uK();
    }

    private void uK() {
        uQ();
        uR();
        uS();
    }

    public void ar(boolean z) {
        this.abo = z;
    }

    public boolean uL() {
        return this.abo;
    }

    public void as(boolean z) {
        this.abn = z;
        uK();
    }

    private void uM() {
        this.abn = com.baidu.adp.lib.util.i.iN();
    }

    public boolean uN() {
        return this.abn;
    }

    public String uO() {
        return this.abq;
    }

    public int uP() {
        uS();
        return this.abp;
    }

    public void uQ() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.qX().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.qX().getViewImageQuality() != 1 : !this.abn) {
            z = false;
        }
        ar(z);
    }

    public void uR() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 0) {
            if (uN()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abq = valueOf;
    }

    public void uS() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.qX().ra()) {
            case 0:
                if (!uN()) {
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

    public static boolean uT() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
