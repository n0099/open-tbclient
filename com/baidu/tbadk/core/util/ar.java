package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ar {
    private static ar arH = null;
    private boolean arI = false;
    private boolean arJ = false;
    private int arK = TbConfig.POST_IMAGE_SMALL;
    private String arL = String.valueOf(45);

    public static ar zF() {
        if (arH == null) {
            synchronized (ar.class) {
                arH = new ar();
            }
        }
        return arH;
    }

    public ar() {
        zI();
        zG();
    }

    private void zG() {
        zN();
        zO();
        zP();
    }

    public void aK(boolean z) {
        this.arJ = z;
    }

    public boolean zH() {
        return this.arJ;
    }

    public void aL(boolean z) {
        this.arI = z;
        zG();
    }

    private void zI() {
        this.arI = com.baidu.adp.lib.util.j.jE();
    }

    public boolean zJ() {
        return this.arI;
    }

    public String zK() {
        return this.arL;
    }

    public int zL() {
        zP();
        return this.arK;
    }

    public int zM() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void zN() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.tt().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.tt().getViewImageQuality() != 1 : !this.arI) {
            z = false;
        }
        aK(z);
    }

    public void zO() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.tt().getViewImageQuality() == 0) {
            if (zJ()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.tt().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.arL = valueOf;
    }

    public void zP() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.tt().tw()) {
            case 0:
                if (!zJ()) {
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
        this.arK = i;
    }

    public static boolean zQ() {
        return l.ge() && com.baidu.adp.gif.c.gd();
    }
}
