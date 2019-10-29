package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bh agI();

    public abstract aj agK();

    public String agJ() {
        if (agI() == null) {
            return null;
        }
        return agI().agJ();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.o(agI());
    }

    public String agL() {
        return null;
    }
}
