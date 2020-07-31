package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.viewpager.SlideableGridView;
/* loaded from: classes9.dex */
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
    protected ViewPager dx(Context context) {
        return new a(context);
    }

    /* loaded from: classes9.dex */
    private class a extends WrapContentHeightViewPager {
        private a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.view.ViewPager
        public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
            return false;
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void init(Context context) {
        setOrientation(1);
        dz(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height1)));
        dy(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void dy(Context context) {
        this.duL = new com.baidu.swan.menu.viewpager.a(context).aw(g.c.menu_indicator_normal, g.c.menu_indicator_selected).jB((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.duM[0] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        this.duM[1] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        addView(this.duL, aKe());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int aKd() {
        return (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void aKf() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.duM[0] : this.duM[1];
        if (!z) {
            this.duL.setVisibility(8);
            return;
        }
        this.duL.setVisibility(0);
        this.duL.jA(pageCount);
        this.duL.getLayoutParams().height = i;
    }
}
