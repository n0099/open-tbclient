package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bg WR();

    public abstract aj WT();

    public String WS() {
        if (WR() == null) {
            return null;
        }
        return WR().WS();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.m(WR());
    }

    public String WU() {
        return null;
    }
}
