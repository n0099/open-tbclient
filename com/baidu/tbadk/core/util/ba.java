package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ba {
    private static ba Fi = null;
    private boolean Fj = false;
    private boolean Fk = false;
    private int Fl = TbConfig.POST_IMAGE_SMALL;
    private String Fm = String.valueOf(45);

    public static ba mD() {
        if (Fi == null) {
            synchronized (ba.class) {
                Fi = new ba();
            }
        }
        return Fi;
    }

    public ba() {
        mG();
        mE();
    }

    private void mE() {
        mK();
        mL();
        mM();
    }

    public void U(boolean z) {
        this.Fk = z;
    }

    public boolean mF() {
        return this.Fk;
    }

    public void V(boolean z) {
        this.Fj = z;
        mE();
    }

    private void mG() {
        this.Fj = com.baidu.adp.lib.util.j.fi();
    }

    public boolean mH() {
        return this.Fj;
    }

    public String mI() {
        return this.Fm;
    }

    public int mJ() {
        mM();
        return this.Fl;
    }

    public void mK() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.js().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.js().getViewImageQuality() != 1 : !this.Fj) {
            z = false;
        }
        U(z);
    }

    public void mL() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.js().getViewImageQuality() == 0) {
            if (mH()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.js().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Fm = valueOf;
    }

    public void mM() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.js().jv()) {
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
        this.Fl = i;
    }

    public static boolean mN() {
        return s.bm() && com.baidu.adp.gif.f.bl();
    }
}
