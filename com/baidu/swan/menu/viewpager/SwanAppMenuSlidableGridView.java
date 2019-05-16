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
    protected ViewPager cc(Context context) {
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
        ce(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height1)));
        cd(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void cd(Context context) {
        this.brC = new com.baidu.swan.menu.viewpager.a(context).L(f.c.menu_indicator_normal, f.c.menu_indicator_selected).fz((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.brD[0] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        this.brD[1] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        addView(this.brC, Vc());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int Vb() {
        return (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void Vd() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.brD[0] : this.brD[1];
        if (!z) {
            this.brC.setVisibility(8);
            return;
        }
        this.brC.setVisibility(0);
        this.brC.fy(pageCount);
        this.brC.getLayoutParams().height = i;
    }

    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.brC.setAlpha(1.0f);
    }
}
