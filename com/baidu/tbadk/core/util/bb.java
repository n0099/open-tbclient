package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bb {
    private static bb Yo = null;
    private boolean Yp = false;
    private boolean Yq = false;
    private int Yr = TbConfig.POST_IMAGE_SMALL;
    private String Ys = String.valueOf(45);

    public static bb uf() {
        if (Yo == null) {
            synchronized (bb.class) {
                Yo = new bb();
            }
        }
        return Yo;
    }

    public bb() {
        ui();
        ug();
    }

    private void ug() {
        um();
        un();
        uo();
    }

    public void ax(boolean z) {
        this.Yq = z;
    }

    public boolean uh() {
        return this.Yq;
    }

    public void ay(boolean z) {
        this.Yp = z;
        ug();
    }

    private void ui() {
        this.Yp = com.baidu.adp.lib.util.i.fs();
    }

    public boolean uj() {
        return this.Yp;
    }

    public String uk() {
        return this.Ys;
    }

    public int ul() {
        uo();
        return this.Yr;
    }

    public void um() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.nW().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.nW().getViewImageQuality() != 1 : !this.Yp) {
            z = false;
        }
        ax(z);
    }

    public void un() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.nW().getViewImageQuality() == 0) {
            if (uj()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.nW().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.Ys = valueOf;
    }

    public void uo() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.nW().nZ()) {
            case 0:
                if (!uj()) {
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
        this.Yr = i;
    }

    public static boolean up() {
        return m.bG() && com.baidu.adp.gif.e.bF();
    }
}
