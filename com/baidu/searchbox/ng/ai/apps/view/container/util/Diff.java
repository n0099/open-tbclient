package com.baidu.searchbox.ng.ai.apps.view.container.util;
/* loaded from: classes2.dex */
public class Diff {
    public static final int ALL = 15;
    public static final int ANIM = 4;
    public static final int NONE = 0;
    public static final int POSITION = 1;
    public static final int STYLE = 2;
    public static final int VISIBILITY = 8;
    private int mFlag = 0;

    public void mask(int i) {
        this.mFlag |= i;
    }

    public int get() {
        return this.mFlag;
    }
}
