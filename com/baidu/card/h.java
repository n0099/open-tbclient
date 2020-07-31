package com.baidu.card;

import android.content.Context;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
/* loaded from: classes15.dex */
public abstract class h extends b<AbsThreadDataSupport> {
    private int bottomMargin;
    private int topMargin;

    public h(Context context) {
        super(context);
        this.topMargin = 0;
        this.bottomMargin = 0;
    }

    public int getTopMargin() {
        return this.topMargin;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public int rS() {
        return this.bottomMargin;
    }

    public void bi(int i) {
        this.bottomMargin = i;
    }
}
