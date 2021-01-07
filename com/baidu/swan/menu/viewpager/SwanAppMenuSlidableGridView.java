package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.viewpager.SlideableGridView;
/* loaded from: classes6.dex */
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
    protected ViewPager eH(Context context) {
        return new a(context);
    }

    /* loaded from: classes6.dex */
    private class a extends WrapContentHeightViewPager {
        private a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.viewpager.widget.ViewPager
        public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
            return false;
        }
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void init(Context context) {
        setOrientation(1);
        eJ(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height1)));
        eI(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(f.b.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void eI(Context context) {
        this.ewg = new com.baidu.swan.menu.viewpager.a(context).aC(f.c.menu_indicator_normal, f.c.menu_indicator_selected).np((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.ewh[0] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        this.ewh[1] = (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
        addView(this.ewg, bfz());
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected int bfy() {
        return (int) getResources().getDimension(f.b.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView
    protected void bfA() {
        SlideableGridView.a gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.ewh[0] : this.ewh[1];
        if (!z) {
            this.ewg.setVisibility(8);
            return;
        }
        this.ewg.setVisibility(0);
        this.ewg.no(pageCount);
        this.ewg.getLayoutParams().height = i;
    }
}
