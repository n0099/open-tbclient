package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj aAe();

    public abstract al aAg();

    public String aAf() {
        if (aAe() == null) {
            return null;
        }
        return aAe().aAf();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(aAe());
    }

    public String aAh() {
        return null;
    }
}
