package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.menu.SwanAppMenuMode;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.viewpager.SlideableGridView;
/* loaded from: classes2.dex */
public class SwanAppMenuSlidableGridView extends SlideableGridView {
    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SwanAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwanAppMenuSlidableGridView(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected ViewPager cd(Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    private class a extends WrapContentHeightViewPager {
        private a(Context context) {
            super(context);
        }

        @Override // android.support.v4.view.ViewPager
        protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
            return false;
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void init(Context context) {
        setOrientation(1);
        cf(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height1)));
        ce(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void ce(Context context) {
        this.bLz = new com.baidu.swan.menu.viewpager.a(context).U(f.c.menu_indicator_normal, f.c.menu_indicator_selected).gz((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.bLA[0] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        this.bLA[1] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        addView(this.bLz, aaO());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int aaN() {
        return (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void aaP() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.bLA[0] : this.bLA[1];
        if (!z) {
            this.bLz.setVisibility(8);
            return;
        }
        this.bLz.setVisibility(0);
        this.bLz.gy(pageCount);
        this.bLz.getLayoutParams().height = i;
    }

    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.bLz.setAlpha(1.0f);
    }
}
