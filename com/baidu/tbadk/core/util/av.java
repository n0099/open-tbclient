package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class av {
    private static av agG = null;
    private boolean agH = false;
    private boolean agI = false;
    private int agJ = TbConfig.POST_IMAGE_SMALL;
    private String agK = String.valueOf(45);

    public static av wa() {
        if (agG == null) {
            synchronized (av.class) {
                agG = new av();
            }
        }
        return agG;
    }

    public av() {
        wd();
        wb();
    }

    private void wb() {
        wh();
        wi();
        wj();
    }

    public void aG(boolean z) {
        this.agI = z;
    }

    public boolean wc() {
        return this.agI;
    }

    public void aH(boolean z) {
        this.agH = z;
        wb();
    }

    private void wd() {
        this.agH = com.baidu.adp.lib.util.i.hl();
    }

    public boolean we() {
        return this.agH;
    }

    public String wf() {
        return this.agK;
    }

    public int wg() {
        wj();
        return this.agJ;
    }

    public void wh() {
        boolean z = true;
        if (com.baidu.tbadk.core.q.po().getViewImageQuality() != 0 ? com.baidu.tbadk.core.q.po().getViewImageQuality() != 1 : !this.agH) {
            z = false;
        }
        aG(z);
    }

    public void wi() {
        String valueOf = String.valueOf(45);
        if (com.baidu.tbadk.core.q.po().getViewImageQuality() == 0) {
            if (we()) {
                valueOf = String.valueOf(80);
            }
        } else if (com.baidu.tbadk.core.q.po().getViewImageQuality() == 1) {
            valueOf = String.valueOf(80);
        }
        this.agK = valueOf;
    }

    public void wj() {
        int i = TbConfig.POST_IMAGE_BIG;
        switch (com.baidu.tbadk.core.q.po().pr()) {
            case 0:
                if (!we()) {
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
        this.agJ = i;
    }

    public static boolean wk() {
        return l.dH() && com.baidu.adp.gif.e.dG();
    }
}
