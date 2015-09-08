package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar abk = null;
    private boolean abl = false;
    private boolean abm = false;
    private int abn = TbConfig.POST_IMAGE_SMALL;
    private String abo = String.valueOf(45);

    public static ar uK() {
        if (abk == null) {
            synchronized (ar.class) {
                abk = new ar();
            }
        }
        return abk;
    }

    public ar() {
        uN();
        uL();
    }

    private void uL() {
        uR();
        uS();
        uT();
    }

    public void ar(boolean z) {
        this.abm = z;
    }

    public boolean uM() {
        return this.abm;
    }

    public void as(boolean z) {
        this.abl = z;
        uL();
    }

    private void uN() {
        this.abl = com.baidu.adp.lib.util.i.iM();
    }

    public boolean uO() {
        return this.abl;
    }

    public String uP() {
        return this.abo;
    }

    public int uQ() {
        uT();
        return this.abn;
    }

    public void uR() {
        boolean z = true;
        if (com.baidu.tbadk.core.m.rb().getViewImageQuality() != 0 ? com.baidu.tbadk.core.m.rb().getViewImageQuality() != 1 : !this.abl) {
            z = false;
        }
        ar(z);
    }

    public void uS() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.m.rb().getViewImageQuality() == 0) {
            if (uO()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.m.rb().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abo = valueOf;
    }

    public void uT() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.m.rb().re()) {
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
        this.abn = i;
    }

    public static boolean uU() {
        return n.fi() && com.baidu.adp.gif.e.fh();
    }
}
