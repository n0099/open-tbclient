package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj aIw();

    public abstract al aIy();

    public String aIx() {
        if (aIw() == null) {
            return null;
        }
        return aIw().aIx();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(aIw());
    }

    public String aIz() {
        return null;
    }
}
