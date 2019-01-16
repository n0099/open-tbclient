package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq aDi = null;
    private boolean aDj = false;
    private boolean aDk = false;
    private int aDl = TbConfig.POST_IMAGE_SMALL;
    private String aDm = String.valueOf(45);

    public static aq Ee() {
        if (aDi == null) {
            synchronized (aq.class) {
                aDi = new aq();
            }
        }
        return aDi;
    }

    public aq() {
        Eh();
        Ef();
    }

    private void Ef() {
        Em();
        En();
        Eo();
    }

    public void bv(boolean z) {
        this.aDk = z;
    }

    public boolean Eg() {
        return this.aDk;
    }

    public void bw(boolean z) {
        this.aDj = z;
        Ef();
    }

    private void Eh() {
        this.aDj = com.baidu.adp.lib.util.j.kW();
    }

    public boolean Ei() {
        return this.aDj;
    }

    public String Ej() {
        return this.aDm;
    }

    public int Ek() {
        Eo();
        return this.aDl;
    }

    public int El() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Em() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xR().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xR().getViewImageQuality() != 1 : !this.aDj) {
            z = false;
        }
        bv(z);
    }

    public void En() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.xR().getViewImageQuality() == 0) {
            if (Ei()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.xR().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aDm = valueOf;
    }

    public void Eo() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.xR().xS()) {
            case 0:
                if (!Ei()) {
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
        this.aDl = i;
    }

    public static boolean Ep() {
        return l.hA() && com.baidu.adp.gif.c.hz();
    }
}
