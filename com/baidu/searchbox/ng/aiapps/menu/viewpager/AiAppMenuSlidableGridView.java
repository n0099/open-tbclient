package com.baidu.searchbox.ng.aiapps.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuMode;
import com.baidu.searchbox.ng.aiapps.menu.R;
import com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView;
/* loaded from: classes2.dex */
public class AiAppMenuSlidableGridView extends SlideableGridView {
    private static final float DEFAULT_ALPHA = 1.0f;
    private static final float NIGHTMODE_ALPHA = 0.3f;

    public AiAppMenuSlidableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AiAppMenuSlidableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AiAppMenuSlidableGridView(Context context) {
        super(context);
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView
    protected ViewPager createViewPager(Context context) {
        return new ScrollDisabledViewPager(context);
    }

    /* loaded from: classes2.dex */
    private class ScrollDisabledViewPager extends WrapContentHeightViewPager {
        private ScrollDisabledViewPager(Context context) {
            super(context);
        }

        @Override // android.support.v4.view.ViewPager
        protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
            return false;
        }
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView
    protected void init(Context context) {
        setOrientation(1);
        addViewPager(context);
        Resources resources = context.getResources();
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.aiapp_menu_gridview_padding_view_height1)));
        addIndicator(context);
        addView(new View(context), new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(R.dimen.aiapp_menu_gridview_padding_view_height2)));
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView
    protected void addIndicator(Context context) {
        this.mIndicator = new MenuPageIndicator(context).setPointDrawableResId(R.drawable.menu_indicator_normal, R.drawable.menu_indicator_selected).setPointMargin((int) getResources().getDimension(R.dimen.common_grid_indicator_margin));
        this.mIndicatorHeight[0] = (int) getResources().getDimension(R.dimen.aiapp_menu_gridview_indicator_height);
        this.mIndicatorHeight[1] = (int) getResources().getDimension(R.dimen.aiapp_menu_gridview_indicator_height);
        addView(this.mIndicator, createIndicatorParams());
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView
    protected int createIndicatorHeight() {
        return (int) getResources().getDimension(R.dimen.aiapp_menu_gridview_indicator_height);
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView
    protected void adjustLayout() {
        SlideableGridView.GridItemAdapter gridItemAdapter = getGridItemAdapter();
        int pageCount = gridItemAdapter == null ? 0 : gridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.mIndicatorHeight[0] : this.mIndicatorHeight[1];
        if (!z) {
            this.mIndicator.setVisibility(8);
            return;
        }
        this.mIndicator.setVisibility(0);
        this.mIndicator.setPointCount(pageCount);
        this.mIndicator.getLayoutParams().height = i;
    }

    public void setMode(AiAppMenuMode aiAppMenuMode) {
        this.mIndicator.setAlpha(1.0f);
    }
}
