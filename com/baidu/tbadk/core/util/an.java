package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an ahn = null;
    private boolean aho = false;
    private boolean ahp = false;
    private int ahq = TbConfig.POST_IMAGE_SMALL;
    private String ahr = String.valueOf(45);

    public static an vs() {
        if (ahn == null) {
            synchronized (an.class) {
                ahn = new an();
            }
        }
        return ahn;
    }

    public an() {
        vv();
        vt();
    }

    private void vt() {
        vA();
        vB();
        vC();
    }

    public void aA(boolean z) {
        this.ahp = z;
    }

    public boolean vu() {
        return this.ahp;
    }

    public void aB(boolean z) {
        this.aho = z;
        vt();
    }

    private void vv() {
        this.aho = com.baidu.adp.lib.util.j.hi();
    }

    public boolean vw() {
        return this.aho;
    }

    public String vx() {
        return this.ahr;
    }

    public int vy() {
        vC();
        return this.ahq;
    }

    public int vz() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void vA() {
        boolean z = true;
        if (com.baidu.tbadk.core.h.oT().getViewImageQuality() != 0 ? com.baidu.tbadk.core.h.oT().getViewImageQuality() != 1 : !this.aho) {
            z = false;
        }
        aA(z);
    }

    public void vB() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.h.oT().getViewImageQuality() == 0) {
            if (vw()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.h.oT().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ahr = valueOf;
    }

    public void vC() {
        int i = 2000;
        switch (com.baidu.tbadk.core.h.oT().oW()) {
            case 0:
                if (!vw()) {
                    i = 1500;
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                i = 1800;
                break;
            case 3:
                i = 1500;
                break;
            default:
                i = 1800;
                break;
        }
        this.ahq = i;
    }

    public static boolean vD() {
        return k.dG() && com.baidu.adp.gif.c.dF();
    }
}
