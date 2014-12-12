package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bb {
    private static bb Js = null;
    private boolean Jt = false;
    private boolean Ju = false;
    private int Jv = TbConfig.POST_IMAGE_SMALL;
    private String Jw = String.valueOf(45);

    public static bb px() {
        if (Js == null) {
            synchronized (bb.class) {
                Js = new bb();
            }
        }
        return Js;
    }

    public bb() {
        pA();
        py();
    }

    private void py() {
        pE();
        pF();
        pG();
    }

    public void al(boolean z) {
        this.Ju = z;
    }

    public boolean pz() {
        return this.Ju;
    }

    public void am(boolean z) {
        this.Jt = z;
        py();
    }

    private void pA() {
        this.Jt = com.baidu.adp.lib.util.i.fh();
    }

    public boolean pB() {
        return this.Jt;
    }

    public String pC() {
        return this.Jw;
    }

    public int pD() {
        pG();
        return this.Jv;
    }

    public void pE() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.mc().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.mc().getViewImageQuality() != 1 : !this.Jt) {
            z = false;
        }
        al(z);
    }

    public void pF() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 0) {
            if (pB()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Jw = valueOf;
    }

    public void pG() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.mc().mf()) {
            case 0:
                if (!pB()) {
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
        this.Jv = i;
    }

    public static boolean pH() {
        return s.bN() && com.baidu.adp.gif.f.bM();
    }
}
