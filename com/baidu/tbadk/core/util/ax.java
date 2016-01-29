package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ax {
    private static ax adk = null;
    private boolean adl = false;
    private boolean adm = false;
    private int adn = TbConfig.POST_IMAGE_SMALL;
    private String ado = String.valueOf(45);

    public static ax wg() {
        if (adk == null) {
            synchronized (ax.class) {
                adk = new ax();
            }
        }
        return adk;
    }

    public ax() {
        wj();
        wh();
    }

    private void wh() {
        wn();
        wo();
        wp();
    }

    public void as(boolean z) {
        this.adm = z;
    }

    public boolean wi() {
        return this.adm;
    }

    public void at(boolean z) {
        this.adl = z;
        wh();
    }

    private void wj() {
        this.adl = com.baidu.adp.lib.util.i.ja();
    }

    public boolean wk() {
        return this.adl;
    }

    public String wl() {
        return this.ado;
    }

    public int wm() {
        wp();
        return this.adn;
    }

    public void wn() {
        boolean z = true;
        if (com.baidu.tbadk.core.l.rn().getViewImageQuality() != 0 ? com.baidu.tbadk.core.l.rn().getViewImageQuality() != 1 : !this.adl) {
            z = false;
        }
        as(z);
    }

    public void wo() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.l.rn().getViewImageQuality() == 0) {
            if (wk()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.l.rn().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.ado = valueOf;
    }

    public void wp() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.l.rn().rq()) {
            case 0:
                if (!wk()) {
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
        this.adn = i;
    }

    public static boolean wq() {
        return m.fq() && com.baidu.adp.gif.e.fp();
    }
}
