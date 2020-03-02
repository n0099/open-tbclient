package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj aAg();

    public abstract al aAi();

    public String aAh() {
        if (aAg() == null) {
            return null;
        }
        return aAg().aAh();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(aAg());
    }

    public String aAj() {
        return null;
    }
}
