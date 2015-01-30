package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bg {
    private static bg JL = null;
    private boolean JM = false;
    private boolean JN = false;
    private int JO = TbConfig.POST_IMAGE_SMALL;
    private String JP = String.valueOf(45);

    public static bg pI() {
        if (JL == null) {
            synchronized (bg.class) {
                JL = new bg();
            }
        }
        return JL;
    }

    public bg() {
        pL();
        pJ();
    }

    private void pJ() {
        pP();
        pQ();
        pR();
    }

    public void an(boolean z) {
        this.JN = z;
    }

    public boolean pK() {
        return this.JN;
    }

    public void ao(boolean z) {
        this.JM = z;
        pJ();
    }

    private void pL() {
        this.JM = com.baidu.adp.lib.util.i.fg();
    }

    public boolean pM() {
        return this.JM;
    }

    public String pN() {
        return this.JP;
    }

    public int pO() {
        pR();
        return this.JO;
    }

    public void pP() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.mc().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.mc().getViewImageQuality() != 1 : !this.JM) {
            z = false;
        }
        an(z);
    }

    public void pQ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 0) {
            if (pM()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.JP = valueOf;
    }

    public void pR() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.mc().mf()) {
            case 0:
                if (!pM()) {
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
        this.JO = i;
    }

    public static boolean pS() {
        return s.bL() && com.baidu.adp.gif.f.bK();
    }
}
