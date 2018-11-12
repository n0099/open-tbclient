package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aq {
    private static aq azf = null;
    private boolean azg = false;
    private boolean azh = false;
    private int azi = TbConfig.POST_IMAGE_SMALL;
    private String azj = String.valueOf(45);

    public static aq CN() {
        if (azf == null) {
            synchronized (aq.class) {
                azf = new aq();
            }
        }
        return azf;
    }

    public aq() {
        CQ();
        CO();
    }

    private void CO() {
        CV();
        CW();
        CX();
    }

    public void bt(boolean z) {
        this.azh = z;
    }

    public boolean CP() {
        return this.azh;
    }

    public void bu(boolean z) {
        this.azg = z;
        CO();
    }

    private void CQ() {
        this.azg = com.baidu.adp.lib.util.j.kW();
    }

    public boolean CR() {
        return this.azg;
    }

    public String CS() {
        return this.azj;
    }

    public int CT() {
        CX();
        return this.azi;
    }

    public int CU() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void CV() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.wA().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.wA().getViewImageQuality() != 1 : !this.azg) {
            z = false;
        }
        bt(z);
    }

    public void CW() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.wA().getViewImageQuality() == 0) {
            if (CR()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.wA().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.azj = valueOf;
    }

    public void CX() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.wA().wB()) {
            case 0:
                if (!CR()) {
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
        this.azi = i;
    }

    public static boolean CY() {
        return l.hA() && com.baidu.adp.gif.c.hz();
    }
}
