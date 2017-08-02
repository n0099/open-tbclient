package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class am {
    private static am agT = null;
    private boolean agU = false;
    private boolean agV = false;
    private int agW = TbConfig.POST_IMAGE_SMALL;
    private String agX = String.valueOf(45);

    public static am vG() {
        if (agT == null) {
            synchronized (am.class) {
                agT = new am();
            }
        }
        return agT;
    }

    public am() {
        vJ();
        vH();
    }

    private void vH() {
        vN();
        vO();
        vP();
    }

    public void aD(boolean z) {
        this.agV = z;
    }

    public boolean vI() {
        return this.agV;
    }

    public void aE(boolean z) {
        this.agU = z;
        vH();
    }

    private void vJ() {
        this.agU = com.baidu.adp.lib.util.i.hi();
    }

    public boolean vK() {
        return this.agU;
    }

    public String vL() {
        return this.agX;
    }

    public int vM() {
        vP();
        return this.agW;
    }

    public void vN() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oN().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oN().getViewImageQuality() != 1 : !this.agU) {
            z = false;
        }
        aD(z);
    }

    public void vO() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oN().getViewImageQuality() == 0) {
            if (vK()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oN().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agX = valueOf;
    }

    public void vP() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.h.oN().oQ()) {
            case 0:
                if (!vK()) {
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
        this.agW = i;
    }

    public static boolean vQ() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
