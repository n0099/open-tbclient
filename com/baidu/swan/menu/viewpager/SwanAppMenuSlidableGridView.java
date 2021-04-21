package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import d.b.h0.i.g;
import d.b.h0.i.h;
/* loaded from: classes3.dex */
public class SwanAppMenuSlidableGridView extends SlideableGridView {

    /* loaded from: classes3.dex */
    public class b extends WrapContentHeightViewPager {
        @Override // androidx.viewpager.widget.ViewPager
        public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
            return false;
        }

        public b(Context context) {
            super(context);
        }
    }

    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void f(Context context) {
        PointPageIndicator e2 = new d.b.h0.i.r.a(context).e(h.menu_indicator_normal, h.menu_indicator_selected);
        e2.f((int) getResources().getDimension(g.common_grid_indicator_margin));
        this.l = e2;
        this.m[0] = (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height);
        this.m[1] = (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height);
        addView(this.l, j());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void h() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int c2 = gridItemAdapter == null ? 0 : gridItemAdapter.c();
        boolean z = c2 > 1;
        int i = !z ? this.m[0] : this.m[1];
        if (!z) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        this.l.c(c2);
        this.l.getLayoutParams().height = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public int i() {
        return (int) getResources().getDimension(g.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public ViewPager l(Context context) {
        return new b(context);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    public void p(Context context) {
        setOrientation(1);
        g(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.aiapp_menu_gridview_padding_view_height1)));
        f(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.aiapp_menu_gridview_padding_view_height2)));
    }

    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwanAppMenuSlidableGridView(Context context) {
        super(context);
    }
}
