package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj aIu();

    public abstract al aIw();

    public String aIv() {
        if (aIu() == null) {
            return null;
        }
        return aIu().aIv();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(aIu());
    }

    public String aIx() {
        return null;
    }
}
