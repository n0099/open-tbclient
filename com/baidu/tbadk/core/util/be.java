package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class be {
    private static be Vw = null;
    private boolean Vx = false;
    private boolean Vy = false;
    private int Vz = TbConfig.POST_IMAGE_SMALL;
    private String VA = String.valueOf(45);

    public static be sY() {
        if (Vw == null) {
            synchronized (be.class) {
                Vw = new be();
            }
        }
        return Vw;
    }

    public be() {
        tb();
        sZ();
    }

    private void sZ() {
        tf();
        tg();
        th();
    }

    public void ah(boolean z) {
        this.Vy = z;
    }

    public boolean ta() {
        return this.Vy;
    }

    public void ai(boolean z) {
        this.Vx = z;
        sZ();
    }

    private void tb() {
        this.Vx = com.baidu.adp.lib.util.k.iI();
    }

    public boolean tc() {
        return this.Vx;
    }

    public String td() {
        return this.VA;
    }

    public int te() {
        th();
        return this.Vz;
    }

    public void tf() {
        boolean z = true;
        if (com.baidu.tbadk.core.n.px().getViewImageQuality() != 0 ? com.baidu.tbadk.core.n.px().getViewImageQuality() != 1 : !this.Vx) {
            z = false;
        }
        ah(z);
    }

    public void tg() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 0) {
            if (tc()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.VA = valueOf;
    }

    public void th() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.n.px().pA()) {
            case 0:
                if (!tc()) {
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
        this.Vz = i;
    }

    public static boolean ti() {
        return o.fj() && com.baidu.adp.gif.f.fi();
    }
}
