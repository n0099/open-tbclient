package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class az {
    private static az Fh = null;
    private boolean Fi = false;
    private boolean Fj = false;
    private int Fk = TbConfig.POST_IMAGE_SMALL;
    private String Fl = String.valueOf(45);

    public static az mD() {
        if (Fh == null) {
            synchronized (az.class) {
                Fh = new az();
            }
        }
        return Fh;
    }

    public az() {
        mG();
        mE();
    }

    private void mE() {
        mK();
        mL();
        mM();
    }

    public void U(boolean z) {
        this.Fj = z;
    }

    public boolean mF() {
        return this.Fj;
    }

    public void V(boolean z) {
        this.Fi = z;
        mE();
    }

    private void mG() {
        this.Fi = com.baidu.adp.lib.util.j.fi();
    }

    public boolean mH() {
        return this.Fi;
    }

    public String mI() {
        return this.Fl;
    }

    public int mJ() {
        mM();
        return this.Fk;
    }

    public void mK() {
        boolean z = true;
        if (com.baidu.tbadk.core.k.js().getViewImageQuality() != 0 ? com.baidu.tbadk.core.k.js().getViewImageQuality() != 1 : !this.Fi) {
            z = false;
        }
        U(z);
    }

    public void mL() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.k.js().getViewImageQuality() == 0) {
            if (mH()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.k.js().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Fl = valueOf;
    }

    public void mM() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.k.js().jv()) {
            case 0:
                if (!mH()) {
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
        this.Fk = i;
    }

    public static boolean mN() {
        return s.bm() && com.baidu.adp.gif.f.bl();
    }
}
