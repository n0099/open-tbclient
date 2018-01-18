package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class an {
    private static an aVQ = null;
    private boolean aVR = false;
    private boolean aVS = false;
    private int aVT = TbConfig.POST_IMAGE_SMALL;
    private String aVU = String.valueOf(45);

    public static an CJ() {
        if (aVQ == null) {
            synchronized (an.class) {
                aVQ = new an();
            }
        }
        return aVQ;
    }

    public an() {
        CM();
        CK();
    }

    private void CK() {
        CR();
        CS();
        CT();
    }

    public void bi(boolean z) {
        this.aVS = z;
    }

    public boolean CL() {
        return this.aVS;
    }

    public void bj(boolean z) {
        this.aVR = z;
        CK();
    }

    private void CM() {
        this.aVR = com.baidu.adp.lib.util.j.oJ();
    }

    public boolean CN() {
        return this.aVR;
    }

    public String CO() {
        return this.aVU;
    }

    public int CP() {
        CT();
        return this.aVT;
    }

    public int CQ() {
        return TbConfig.POST_IMAGE_HIGHT_LIMIT;
    }

    public void CR() {
        boolean z = true;
        if (com.baidu.tbadk.core.i.wA().getViewImageQuality() != 0 ? com.baidu.tbadk.core.i.wA().getViewImageQuality() != 1 : !this.aVR) {
            z = false;
        }
        bi(z);
    }

    public void CS() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.i.wA().getViewImageQuality() == 0) {
            if (CN()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.i.wA().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.aVU = valueOf;
    }

    public void CT() {
        int i = 2000;
        switch (com.baidu.tbadk.core.i.wA().wD()) {
            case 0:
                if (!CN()) {
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
        this.aVT = i;
    }

    public static boolean CU() {
        return k.lk() && com.baidu.adp.gif.c.lj();
    }
}
