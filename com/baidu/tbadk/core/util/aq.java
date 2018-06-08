package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq are = null;
    private boolean arf = false;
    private boolean arg = false;
    private int arh = TbConfig.POST_IMAGE_SMALL;
    private String ari = String.valueOf(45);

    public static aq zq() {
        if (are == null) {
            synchronized (aq.class) {
                are = new aq();
            }
        }
        return are;
    }

    public aq() {
        zt();
        zr();
    }

    private void zr() {
        zy();
        zz();
        zA();
    }

    public void aI(boolean z) {
        this.arg = z;
    }

    public boolean zs() {
        return this.arg;
    }

    public void aJ(boolean z) {
        this.arf = z;
        zr();
    }

    private void zt() {
        this.arf = com.baidu.adp.lib.util.j.jE();
    }

    public boolean zu() {
        return this.arf;
    }

    public String zv() {
        return this.ari;
    }

    public int zw() {
        zA();
        return this.arh;
    }

    public int zx() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void zy() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.tt().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.tt().getViewImageQuality() != 1 : !this.arf) {
            z = false;
        }
        aI(z);
    }

    public void zz() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.tt().getViewImageQuality() == 0) {
            if (zu()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.tt().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ari = valueOf;
    }

    public void zA() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.tt().tw()) {
            case 0:
                if (!zu()) {
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
        this.arh = i;
    }

    public static boolean zB() {
        return l.ge() && com.baidu.adp.gif.c.gd();
    }
}
