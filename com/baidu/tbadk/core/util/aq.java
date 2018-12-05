package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq aCF = null;
    private boolean aCG = false;
    private boolean aCH = false;
    private int aCI = TbConfig.POST_IMAGE_SMALL;
    private String aCJ = String.valueOf(45);

    public static aq DR() {
        if (aCF == null) {
            synchronized (aq.class) {
                aCF = new aq();
            }
        }
        return aCF;
    }

    public aq() {
        DU();
        DS();
    }

    private void DS() {
        DZ();
        Ea();
        Eb();
    }

    public void bu(boolean z) {
        this.aCH = z;
    }

    public boolean DT() {
        return this.aCH;
    }

    public void bv(boolean z) {
        this.aCG = z;
        DS();
    }

    private void DU() {
        this.aCG = com.baidu.adp.lib.util.j.kW();
    }

    public boolean DV() {
        return this.aCG;
    }

    public String DW() {
        return this.aCJ;
    }

    public int DX() {
        Eb();
        return this.aCI;
    }

    public int DY() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void DZ() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xE().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xE().getViewImageQuality() != 1 : !this.aCG) {
            z = false;
        }
        bu(z);
    }

    public void Ea() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.xE().getViewImageQuality() == 0) {
            if (DV()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.xE().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aCJ = valueOf;
    }

    public void Eb() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.xE().xF()) {
            case 0:
                if (!DV()) {
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
        this.aCI = i;
    }

    public static boolean Ec() {
        return l.hA() && com.baidu.adp.gif.c.hz();
    }
}
