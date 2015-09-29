package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class as {
    private static as abj = null;
    private boolean abk = false;
    private boolean abl = false;
    private int abm = TbConfig.POST_IMAGE_SMALL;
    private String abn = String.valueOf(45);

    public static as uI() {
        if (abj == null) {
            synchronized (as.class) {
                abj = new as();
            }
        }
        return abj;
    }

    public as() {
        uL();
        uJ();
    }

    private void uJ() {
        uP();
        uQ();
        uR();
    }

    public void ar(boolean z) {
        this.abl = z;
    }

    public boolean uK() {
        return this.abl;
    }

    public void as(boolean z) {
        this.abk = z;
        uJ();
    }

    private void uL() {
        this.abk = com.baidu.adp.lib.util.i.iN();
    }

    public boolean uM() {
        return this.abk;
    }

    public String uN() {
        return this.abn;
    }

    public int uO() {
        uR();
        return this.abm;
    }

    public void uP() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.qX().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.qX().getViewImageQuality() != 1 : !this.abk) {
            z = false;
        }
        ar(z);
    }

    public void uQ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 0) {
            if (uM()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abn = valueOf;
    }

    public void uR() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.qX().ra()) {
            case 0:
                if (!uM()) {
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
        this.abm = i;
    }

    public static boolean uS() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
