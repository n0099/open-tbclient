package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj axx();

    public abstract al axz();

    public String axy() {
        if (axx() == null) {
            return null;
        }
        return axx().axy();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(axx());
    }

    public String axA() {
        return null;
    }
}
