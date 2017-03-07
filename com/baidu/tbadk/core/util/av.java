package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av {
    private static av agr = null;
    private boolean ags = false;
    private boolean agt = false;
    private int agu = TbConfig.POST_IMAGE_SMALL;
    private String agv = String.valueOf(45);

    public static av vD() {
        if (agr == null) {
            synchronized (av.class) {
                agr = new av();
            }
        }
        return agr;
    }

    public av() {
        vG();
        vE();
    }

    private void vE() {
        vK();
        vL();
        vM();
    }

    public void aE(boolean z) {
        this.agt = z;
    }

    public boolean vF() {
        return this.agt;
    }

    public void aF(boolean z) {
        this.ags = z;
        vE();
    }

    private void vG() {
        this.ags = com.baidu.adp.lib.util.i.hf();
    }

    public boolean vH() {
        return this.ags;
    }

    public String vI() {
        return this.agv;
    }

    public int vJ() {
        vM();
        return this.agu;
    }

    public void vK() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oQ().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oQ().getViewImageQuality() != 1 : !this.ags) {
            z = false;
        }
        aE(z);
    }

    public void vL() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oQ().getViewImageQuality() == 0) {
            if (vH()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oQ().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agv = valueOf;
    }

    public void vM() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oQ().oT()) {
            case 0:
                if (!vH()) {
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
        this.agu = i;
    }

    public static boolean vN() {
        return l.dH() && com.baidu.adp.gif.e.dG();
    }
}
