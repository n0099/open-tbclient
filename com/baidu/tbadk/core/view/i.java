package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class i extends View {
    private int height;
    private int width;

    public i(Context context) {
        super(context);
        this.height = 0;
        this.width = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.width == 0) {
            setMeasuredDimension(i & 1073741823, this.height);
        } else if (this.height == 0) {
            setMeasuredDimension(this.width, 1073741823 & i2);
        }
    }

    public void setHeightPx(int i) {
        this.height = i;
    }

    public void setWidthPx(int i) {
        this.width = i;
    }

    public void setHeightDip(int i) {
        this.height = com.baidu.adp.lib.util.l.dip2px(getContext(), i);
    }

    public void setWidthDip(int i) {
        this.width = com.baidu.adp.lib.util.l.dip2px(getContext(), i);
    }
}
