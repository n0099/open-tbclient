package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.ge4;
/* loaded from: classes3.dex */
public class SwanAppMenuSlidableGridView extends SlideableGridView {

    /* loaded from: classes3.dex */
    public class a extends WrapContentHeightViewPager {
        @Override // androidx.viewpager.widget.ViewPager
        public boolean canScroll(View view2, boolean z, int i, int i2, int i3) {
            return false;
        }

        public a(Context context) {
            super(context);
        }
    }

    public SwanAppMenuSlidableGridView(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public ViewPager g(Context context) {
        return new a(context);
    }

    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void a(Context context) {
        PointPageIndicator e = new ge4(context).e(R.drawable.obfuscated_res_0x7f080de1, R.drawable.obfuscated_res_0x7f080de2);
        e.f((int) getResources().getDimension(R.dimen.common_grid_indicator_margin));
        this.h = e;
        this.i[0] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
        this.i[1] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
        addView(this.h, e());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void c() {
        int c;
        boolean z;
        int i;
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        if (gridItemAdapter == null) {
            c = 0;
        } else {
            c = gridItemAdapter.c();
        }
        if (c > 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i = this.i[0];
        } else {
            i = this.i[1];
        }
        if (!z) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        this.h.c(c);
        this.h.getLayoutParams().height = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public int d() {
        return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0700dd);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void k(Context context) {
        setOrientation(1);
        b(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700df)));
        a(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700e0)));
    }
}
