package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq aDj = null;
    private boolean aDk = false;
    private boolean aDl = false;
    private int aDm = TbConfig.POST_IMAGE_SMALL;
    private String aDn = String.valueOf(45);

    public static aq Ee() {
        if (aDj == null) {
            synchronized (aq.class) {
                aDj = new aq();
            }
        }
        return aDj;
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
        this.aDl = z;
    }

    public boolean Eg() {
        return this.aDl;
    }

    public void bw(boolean z) {
        this.aDk = z;
        Ef();
    }

    private void Eh() {
        this.aDk = com.baidu.adp.lib.util.j.kW();
    }

    public boolean Ei() {
        return this.aDk;
    }

    public String Ej() {
        return this.aDn;
    }

    public int Ek() {
        Eo();
        return this.aDm;
    }

    public int El() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void Em() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.xR().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.xR().getViewImageQuality() != 1 : !this.aDk) {
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
        this.aDn = valueOf;
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
        this.aDm = i;
    }

    public static boolean Ep() {
        return l.hA() && com.baidu.adp.gif.c.hz();
    }
}
