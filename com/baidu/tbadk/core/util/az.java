package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class az {
    private static az XW = null;
    private boolean XX = false;
    private boolean XY = false;
    private int XZ = TbConfig.POST_IMAGE_SMALL;
    private String Ya = String.valueOf(45);

    public static az ug() {
        if (XW == null) {
            synchronized (az.class) {
                XW = new az();
            }
        }
        return XW;
    }

    public az() {
        uj();
        uh();
    }

    private void uh() {
        un();
        uo();
        up();
    }

    public void az(boolean z) {
        this.XY = z;
    }

    public boolean ui() {
        return this.XY;
    }

    public void aA(boolean z) {
        this.XX = z;
        uh();
    }

    private void uj() {
        this.XX = com.baidu.adp.lib.util.i.fr();
    }

    public boolean uk() {
        return this.XX;
    }

    public String ul() {
        return this.Ya;
    }

    public int um() {
        up();
        return this.XZ;
    }

    public void un() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.ob().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.ob().getViewImageQuality() != 1 : !this.XX) {
            z = false;
        }
        az(z);
    }

    public void uo() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.ob().getViewImageQuality() == 0) {
            if (uk()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.ob().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Ya = valueOf;
    }

    public void up() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.ob().oe()) {
            case 0:
                if (!uk()) {
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

    public static boolean uq() {
        return m.bF() && com.baidu.adp.gif.e.bE();
    }
}
