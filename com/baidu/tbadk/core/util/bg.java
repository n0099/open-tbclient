package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bg {
    private static bg JI = null;
    private boolean JJ = false;
    private boolean JK = false;
    private int JL = TbConfig.POST_IMAGE_SMALL;
    private String JM = String.valueOf(45);

    public static bg pB() {
        if (JI == null) {
            synchronized (bg.class) {
                JI = new bg();
            }
        }
        return JI;
    }

    public bg() {
        pE();
        pC();
    }

    private void pC() {
        pI();
        pJ();
        pK();
    }

    public void an(boolean z) {
        this.JK = z;
    }

    public boolean pD() {
        return this.JK;
    }

    public void ao(boolean z) {
        this.JJ = z;
        pC();
    }

    private void pE() {
        this.JJ = com.baidu.adp.lib.util.i.fg();
    }

    public boolean pF() {
        return this.JJ;
    }

    public String pG() {
        return this.JM;
    }

    public int pH() {
        pK();
        return this.JL;
    }

    public void pI() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.lV().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.lV().getViewImageQuality() != 1 : !this.JJ) {
            z = false;
        }
        an(z);
    }

    public void pJ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.lV().getViewImageQuality() == 0) {
            if (pF()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.lV().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.JM = valueOf;
    }

    public void pK() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.lV().lY()) {
            case 0:
                if (!pF()) {
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
        this.JL = i;
    }

    public static boolean pL() {
        return s.bL() && com.baidu.adp.gif.f.bK();
    }
}
