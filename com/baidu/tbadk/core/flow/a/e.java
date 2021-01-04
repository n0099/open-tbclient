package com.baidu.tbadk.core.flow.a;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes.dex */
public class e {
    private int height = -2;
    private int width = -1;

    public void setHeight(int i) {
        this.height = i;
    }

    public void b(ViewPager viewPager) {
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
