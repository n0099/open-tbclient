package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class at {
    private static at abr = null;
    private boolean abt = false;
    private boolean abu = false;
    private int abv = TbConfig.POST_IMAGE_SMALL;
    private String abw = String.valueOf(45);

    public static at uK() {
        if (abr == null) {
            synchronized (at.class) {
                abr = new at();
            }
        }
        return abr;
    }

    public at() {
        uN();
        uL();
    }

    private void uL() {
        uR();
        uS();
        uT();
    }

    public void ar(boolean z) {
        this.abu = z;
    }

    public boolean uM() {
        return this.abu;
    }

    public void as(boolean z) {
        this.abt = z;
        uL();
    }

    private void uN() {
        this.abt = com.baidu.adp.lib.util.i.iO();
    }

    public boolean uO() {
        return this.abt;
    }

    public String uP() {
        return this.abw;
    }

    public int uQ() {
        uT();
        return this.abv;
    }

    public void uR() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.qV().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.qV().getViewImageQuality() != 1 : !this.abt) {
            z = false;
        }
        ar(z);
    }

    public void uS() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.qV().getViewImageQuality() == 0) {
            if (uO()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.qV().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abw = valueOf;
    }

    public void uT() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.qV().qY()) {
            case 0:
                if (!uO()) {
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
        this.abv = i;
    }

    public static boolean uU() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
