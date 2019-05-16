package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bg abv();

    public abstract aj abx();

    public String abw() {
        if (abv() == null) {
            return null;
        }
        return abv().abw();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.m(abv());
    }

    public String aby() {
        return null;
    }
}
