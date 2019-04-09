package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.menu.SwanAppMenuMode;
import com.baidu.swan.menu.g;
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
    protected ViewPager cz(Context context) {
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
        cB(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height1)));
        cA(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(g.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void cA(Context context) {
        this.blA = new com.baidu.swan.menu.viewpager.a(context).N(g.c.menu_indicator_normal, g.c.menu_indicator_selected).fa((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.blB[0] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        this.blB[1] = (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
        addView(this.blA, Rq());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int Rp() {
        return (int) getResources().getDimension(g.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void Rr() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.blB[0] : this.blB[1];
        if (!z) {
            this.blA.setVisibility(8);
            return;
        }
        this.blA.setVisibility(0);
        this.blA.eZ(pageCount);
        this.blA.getLayoutParams().height = i;
    }

    public void setMode(SwanAppMenuMode swanAppMenuMode) {
        this.blA.setAlpha(1.0f);
    }
}
