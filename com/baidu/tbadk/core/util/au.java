package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class au {
    private static au aba = null;
    private boolean abb = false;
    private boolean abc = false;
    private int abd = TbConfig.POST_IMAGE_SMALL;
    private String abe = String.valueOf(45);

    public static au vg() {
        if (aba == null) {
            synchronized (au.class) {
                aba = new au();
            }
        }
        return aba;
    }

    public au() {
        vj();
        vh();
    }

    private void vh() {
        vn();
        vo();
        vp();
    }

    public void aF(boolean z) {
        this.abc = z;
    }

    public boolean vi() {
        return this.abc;
    }

    public void aG(boolean z) {
        this.abb = z;
        vh();
    }

    private void vj() {
        this.abb = com.baidu.adp.lib.util.i.gl();
    }

    public boolean vk() {
        return this.abb;
    }

    public String vl() {
        return this.abe;
    }

    public int vm() {
        vp();
        return this.abd;
    }

    public void vn() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.oC().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.oC().getViewImageQuality() != 1 : !this.abb) {
            z = false;
        }
        aF(z);
    }

    public void vo() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.oC().getViewImageQuality() == 0) {
            if (vk()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.oC().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.abe = valueOf;
    }

    public void vp() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.oC().oF()) {
            case 0:
                if (!vk()) {
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
        this.abd = i;
    }

    public static boolean vq() {
        return l.cy() && com.baidu.adp.gif.e.cx();
    }
}
