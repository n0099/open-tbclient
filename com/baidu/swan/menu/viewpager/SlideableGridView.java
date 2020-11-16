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
/* loaded from: classes5.dex */
public class SlideableGridView extends LinearLayout {
    private a efh;
    b efs;
    private int eft;
    private int efu;
    private int efv;
    protected PointPageIndicator efw;
    protected int[] efx;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes5.dex */
    public static abstract class a {
        private SlideableGridView efy;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int mK(int i);

        void f(SlideableGridView slideableGridView) {
            this.efy = slideableGridView;
        }

        public int mL(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += mK(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.efh;
    }

    public void setGridItemAdapter(a aVar) {
        this.efh = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.efs == null) {
                this.efs = new b(getContext());
                this.mViewPager.setAdapter(this.efs);
            } else {
                this.efs.notifyDataSetChanged();
            }
            this.efw.mH(aVar.getPageCount());
        } else if (this.efs != null) {
            this.efs.notifyDataSetChanged();
        }
        aZY();
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
        this.efw = null;
        this.efx = new int[2];
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
        this.efw = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).mI((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.efx[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.efx[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.efw, aZX());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(Context context) {
        this.mViewPager = dI(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aZU());
    }

    public PointPageIndicator getPageindicator() {
        return this.efw;
    }

    protected int aZS() {
        return -2;
    }

    protected int aZT() {
        return -1;
    }

    protected LinearLayout.LayoutParams aZU() {
        return new LinearLayout.LayoutParams(aZT(), aZS());
    }

    protected int aZV() {
        return -1;
    }

    protected int aZW() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aZX() {
        return new LinearLayout.LayoutParams(aZV(), aZW());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.efx[0] = i;
        this.efx[1] = i2;
        requestLayout();
    }

    protected void aZY() {
        int pageCount = this.efh == null ? 0 : this.efh.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.efx[0] : this.efx[1];
        this.efw.mH(pageCount);
        this.efw.setVisibility(z ? 0 : 4);
        this.efw.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.efw.mJ(i);
        }
    }

    /* loaded from: classes5.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.efh != null) {
                return SlideableGridView.this.efh.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.efh);
            gridPageView.setPadding(SlideableGridView.this.eft, SlideableGridView.this.mTopPadding, SlideableGridView.this.efu, SlideableGridView.this.efv);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void h(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.efh.mL(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.efw != null) {
            this.efw.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.efw != null) {
            this.mViewPager.setCurrentItem(i);
            this.efw.mJ(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.eft = i;
        this.efu = i3;
        this.mTopPadding = i2;
        this.efv = i4;
    }
}
