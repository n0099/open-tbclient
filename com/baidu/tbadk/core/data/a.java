package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bg acx();

    public abstract aj acz();

    public String acy() {
        if (acx() == null) {
            return null;
        }
        return acx().acy();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.av.m(acx());
    }

    public String acA() {
        return null;
    }
}
