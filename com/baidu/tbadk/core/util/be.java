package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class be {
    private static be Vu = null;
    private boolean Vv = false;
    private boolean Vw = false;
    private int Vx = TbConfig.POST_IMAGE_SMALL;
    private String Vy = String.valueOf(45);

    public static be sY() {
        if (Vu == null) {
            synchronized (be.class) {
                Vu = new be();
            }
        }
        return Vu;
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
        this.Vw = z;
    }

    public boolean ta() {
        return this.Vw;
    }

    public void ai(boolean z) {
        this.Vv = z;
        sZ();
    }

    private void tb() {
        this.Vv = com.baidu.adp.lib.util.k.iI();
    }

    public boolean tc() {
        return this.Vv;
    }

    public String td() {
        return this.Vy;
    }

    public int te() {
        th();
        return this.Vx;
    }

    public void tf() {
        boolean z = true;
        if (com.baidu.tbadk.core.n.px().getViewImageQuality() != 0 ? com.baidu.tbadk.core.n.px().getViewImageQuality() != 1 : !this.Vv) {
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
        this.Vy = valueOf;
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
        this.Vx = i;
    }

    public static boolean ti() {
        return o.fj() && com.baidu.adp.gif.f.fi();
    }
}
