package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj aAj();

    public abstract al aAl();

    public String aAk() {
        if (aAj() == null) {
            return null;
        }
        return aAj().aAk();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(aAj());
    }

    public String aAm() {
        return null;
    }
}
