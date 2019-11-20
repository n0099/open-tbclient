package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bh agG();

    public abstract aj agI();

    public String agH() {
        if (agG() == null) {
            return null;
        }
        return agG().agH();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.o(agG());
    }

    public String agJ() {
        return null;
    }
}
