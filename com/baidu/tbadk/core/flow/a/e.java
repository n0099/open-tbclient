package com.baidu.tbadk.core.flow.a;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class e {
    private int height = -2;
    private int width = -1;

    public void setHeight(int i) {
        this.height = i;
    }

    public void a(ViewPager viewPager) {
        if (viewPager != null) {
            ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.width, this.height);
            } else {
                layoutParams.height = this.height;
                layoutParams.width = this.width;
            }
            viewPager.setLayoutParams(layoutParams);
        }
    }
}
