package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class az {
    private static az XW = null;
    private boolean XX = false;
    private boolean XY = false;
    private int XZ = TbConfig.POST_IMAGE_SMALL;
    private String Ya = String.valueOf(45);

    public static az uf() {
        if (XW == null) {
            synchronized (az.class) {
                XW = new az();
            }
        }
        return XW;
    }

    public az() {
        ui();
        ug();
    }

    private void ug() {
        um();
        un();
        uo();
    }

    public void az(boolean z) {
        this.XY = z;
    }

    public boolean uh() {
        return this.XY;
    }

    public void aA(boolean z) {
        this.XX = z;
        ug();
    }

    private void ui() {
        this.XX = com.baidu.adp.lib.util.i.fr();
    }

    public boolean uj() {
        return this.XX;
    }

    public String uk() {
        return this.Ya;
    }

    public int ul() {
        uo();
        return this.XZ;
    }

    public void um() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.ob().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.ob().getViewImageQuality() != 1 : !this.XX) {
            z = false;
        }
        az(z);
    }

    public void un() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.ob().getViewImageQuality() == 0) {
            if (uj()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.ob().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Ya = valueOf;
    }

    public void uo() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.ob().oe()) {
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
        this.XZ = i;
    }

    public static boolean up() {
        return m.bF() && com.baidu.adp.gif.e.bE();
    }
}
