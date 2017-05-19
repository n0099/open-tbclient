package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av {
    private static av afX = null;
    private boolean afY = false;
    private boolean afZ = false;
    private int aga = TbConfig.POST_IMAGE_SMALL;
    private String agb = String.valueOf(45);

    public static av vo() {
        if (afX == null) {
            synchronized (av.class) {
                afX = new av();
            }
        }
        return afX;
    }

    public av() {
        vr();
        vp();
    }

    private void vp() {
        vv();
        vw();
        vx();
    }

    public void aE(boolean z) {
        this.afZ = z;
    }

    public boolean vq() {
        return this.afZ;
    }

    public void aF(boolean z) {
        this.afY = z;
        vp();
    }

    private void vr() {
        this.afY = com.baidu.adp.lib.util.i.hl();
    }

    public boolean vs() {
        return this.afY;
    }

    public String vt() {
        return this.agb;
    }

    public int vu() {
        vx();
        return this.aga;
    }

    public void vv() {
        boolean z = true;
        if (com.baidu.tbadk.core.r.oV().getViewImageQuality() != 0 ? com.baidu.tbadk.core.r.oV().getViewImageQuality() != 1 : !this.afY) {
            z = false;
        }
        aE(z);
    }

    public void vw() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.r.oV().getViewImageQuality() == 0) {
            if (vs()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.r.oV().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agb = valueOf;
    }

    public void vx() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.r.oV().oY()) {
            case 0:
                if (!vs()) {
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
        this.aga = i;
    }

    public static boolean vy() {
        return l.dH() && com.baidu.adp.gif.e.dG();
    }
}
