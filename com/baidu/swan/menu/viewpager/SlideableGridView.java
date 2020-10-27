package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
/* loaded from: classes14.dex */
public class SlideableGridView extends LinearLayout {
    private a eaX;
    b ebi;
    private int ebj;
    private int ebk;
    private int ebl;
    protected PointPageIndicator ebm;
    protected int[] ebn;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView ebo;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int mE(int i);

        void f(SlideableGridView slideableGridView) {
            this.ebo = slideableGridView;
        }

        public int mF(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += mE(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.eaX;
    }

    public void setGridItemAdapter(a aVar) {
        this.eaX = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.ebi == null) {
                this.ebi = new b(getContext());
                this.mViewPager.setAdapter(this.ebi);
            } else {
                this.ebi.notifyDataSetChanged();
            }
            this.ebm.mB(aVar.getPageCount());
        } else if (this.ebi != null) {
            this.ebi.notifyDataSetChanged();
        }
        aYf();
    }

    public SlideableGridView(Context context) {
        this(context, null);
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPager = null;
        this.ebm = null;
        this.ebn = new int[2];
        init(context);
    }

    protected ViewPager dI(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dK(context);
        dJ(context);
    }

    protected void dJ(Context context) {
        this.ebm = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).mC((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.ebn[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.ebn[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.ebm, aYe());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(Context context) {
        this.mViewPager = dI(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aYb());
    }

    public PointPageIndicator getPageindicator() {
        return this.ebm;
    }

    protected int aXZ() {
        return -2;
    }

    protected int aYa() {
        return -1;
    }

    protected LinearLayout.LayoutParams aYb() {
        return new LinearLayout.LayoutParams(aYa(), aXZ());
    }

    protected int aYc() {
        return -1;
    }

    protected int aYd() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aYe() {
        return new LinearLayout.LayoutParams(aYc(), aYd());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.ebn[0] = i;
        this.ebn[1] = i2;
        requestLayout();
    }

    protected void aYf() {
        int pageCount = this.eaX == null ? 0 : this.eaX.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.ebn[0] : this.ebn[1];
        this.ebm.mB(pageCount);
        this.ebm.setVisibility(z ? 0 : 4);
        this.ebm.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.ebm.mD(i);
        }
    }

    /* loaded from: classes14.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.eaX != null) {
                return SlideableGridView.this.eaX.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.eaX);
            gridPageView.setPadding(SlideableGridView.this.ebj, SlideableGridView.this.mTopPadding, SlideableGridView.this.ebk, SlideableGridView.this.ebl);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.eaX.mF(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.ebm != null) {
            this.ebm.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.ebm != null) {
            this.mViewPager.setCurrentItem(i);
            this.ebm.mD(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.ebj = i;
        this.ebk = i3;
        this.mTopPadding = i2;
        this.ebl = i4;
    }
}
