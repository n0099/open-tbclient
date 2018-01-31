package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an aVT = null;
    private boolean aVU = false;
    private boolean aVV = false;
    private int aVW = TbConfig.POST_IMAGE_SMALL;
    private String aVX = String.valueOf(45);

    public static an CK() {
        if (aVT == null) {
            synchronized (an.class) {
                aVT = new an();
            }
        }
        return aVT;
    }

    public an() {
        CN();
        CL();
    }

    private void CL() {
        CS();
        CT();
        CU();
    }

    public void bj(boolean z) {
        this.aVV = z;
    }

    public boolean CM() {
        return this.aVV;
    }

    public void bk(boolean z) {
        this.aVU = z;
        CL();
    }

    private void CN() {
        this.aVU = com.baidu.adp.lib.util.j.oK();
    }

    public boolean CO() {
        return this.aVU;
    }

    public String CP() {
        return this.aVX;
    }

    public int CQ() {
        CU();
        return this.aVW;
    }

    public int CR() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void CS() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.wB().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.wB().getViewImageQuality() != 1 : !this.aVU) {
            z = false;
        }
        bj(z);
    }

    public void CT() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.wB().getViewImageQuality() == 0) {
            if (CO()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.wB().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aVX = valueOf;
    }

    public void CU() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.wB().wE()) {
            case 0:
                if (!CO()) {
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
        this.aVW = i;
    }

    public static boolean CV() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
