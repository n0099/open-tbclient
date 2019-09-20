package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bh acC();

    public abstract aj acE();

    public String acD() {
        if (acC() == null) {
            return null;
        }
        return acC().acD();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.o(acC());
    }

    public String acF() {
        return null;
    }
}
