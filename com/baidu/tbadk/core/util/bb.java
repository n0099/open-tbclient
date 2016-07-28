package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bb {
    private static bb YX = null;
    private boolean YY = false;
    private boolean YZ = false;
    private int Za = TbConfig.POST_IMAGE_SMALL;
    private String Zb = String.valueOf(45);

    public static bb ue() {
        if (YX == null) {
            synchronized (bb.class) {
                YX = new bb();
            }
        }
        return YX;
    }

    public bb() {
        uh();
        uf();
    }

    private void uf() {
        um();
        un();
        uo();
    }

    public void aA(boolean z) {
        this.YZ = z;
    }

    public boolean ug() {
        return this.YZ;
    }

    public void aB(boolean z) {
        this.YY = z;
        uf();
    }

    private void uh() {
        this.YY = com.baidu.adp.lib.util.i.fr();
    }

    public boolean uj() {
        return this.YY;
    }

    public String uk() {
        return this.Zb;
    }

    public int ul() {
        uo();
        return this.Za;
    }

    public void um() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.nL().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.nL().getViewImageQuality() != 1 : !this.YY) {
            z = false;
        }
        aA(z);
    }

    public void un() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.nL().getViewImageQuality() == 0) {
            if (uj()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.nL().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Zb = valueOf;
    }

    public void uo() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.nL().nO()) {
            case 0:
                if (!uj()) {
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
        this.Za = i;
    }

    public static boolean up() {
        return m.bF() && com.baidu.adp.gif.e.bE();
    }
}
