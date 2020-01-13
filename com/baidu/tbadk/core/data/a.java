package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.card.data.b {
    public int objType = 1;

    public abstract bj axQ();

    public abstract al axS();

    public String axR() {
        if (axQ() == null) {
            return null;
        }
        return axQ().axR();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.u(axQ());
    }

    public String axT() {
        return null;
    }
}
