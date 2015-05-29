package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bc {
    private static bc Wd = null;
    private boolean We = false;
    private boolean Wf = false;
    private int Wg = TbConfig.POST_IMAGE_SMALL;
    private String Wh = String.valueOf(45);

    public static bc tB() {
        if (Wd == null) {
            synchronized (bc.class) {
                Wd = new bc();
            }
        }
        return Wd;
    }

    public bc() {
        tE();
        tC();
    }

    private void tC() {
        tI();
        tJ();
        tK();
    }

    public void an(boolean z) {
        this.Wf = z;
    }

    public boolean tD() {
        return this.Wf;
    }

    public void ao(boolean z) {
        this.We = z;
        tC();
    }

    private void tE() {
        this.We = com.baidu.adp.lib.util.k.iY();
    }

    public boolean tF() {
        return this.We;
    }

    public String tG() {
        return this.Wh;
    }

    public int tH() {
        tK();
        return this.Wg;
    }

    public void tI() {
        boolean z = true;
        if (com.baidu.tbadk.core.n.qc().getViewImageQuality() != 0 ? com.baidu.tbadk.core.n.qc().getViewImageQuality() != 1 : !this.We) {
            z = false;
        }
        an(z);
    }

    public void tJ() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 0) {
            if (tF()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Wh = valueOf;
    }

    public void tK() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.n.qc().qf()) {
            case 0:
                if (!tF()) {
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
        this.Wg = i;
    }

    public static boolean tL() {
        return o.fo() && com.baidu.adp.gif.f.fn();
    }
}
