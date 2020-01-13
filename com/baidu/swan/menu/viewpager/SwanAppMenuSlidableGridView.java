package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.viewpager.SlideableGridView;
/* loaded from: classes10.dex */
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
    protected ViewPager dy(Context context) {
        return new a(context);
    }

    /* loaded from: classes10.dex */
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
        dA(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height1)));
        dz(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void dz(Context context) {
        this.cvR = new com.baidu.swan.menu.viewpager.a(context).ar(g.c.menu_indicator_normal, g.c.menu_indicator_selected).ii((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.cvS[0] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        this.cvS[1] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        addView(this.cvR, aqM());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int aqL() {
        return (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void aqN() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.cvS[0] : this.cvS[1];
        if (!z) {
            this.cvR.setVisibility(8);
            return;
        }
        this.cvR.setVisibility(0);
        this.cvR.ih(pageCount);
        this.cvR.getLayoutParams().height = i;
    }
}
