package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bg WO();

    public abstract aj WQ();

    public String WP() {
        if (WO() == null) {
            return null;
        }
        return WO().WP();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.m(WO());
    }

    public String WR() {
        return null;
    }
}
