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
    private a emi;
    b emt;
    private int emu;
    private int emv;
    private int emw;
    protected PointPageIndicator emx;
    protected int[] emy;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView emz;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int ni(int i);

        void f(SlideableGridView slideableGridView) {
            this.emz = slideableGridView;
        }

        public int nj(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += ni(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.emi;
    }

    public void setGridItemAdapter(a aVar) {
        this.emi = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.emt == null) {
                this.emt = new b(getContext());
                this.mViewPager.setAdapter(this.emt);
            } else {
                this.emt.notifyDataSetChanged();
            }
            this.emx.nf(aVar.getPageCount());
        } else if (this.emt != null) {
            this.emt.notifyDataSetChanged();
        }
        bdd();
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
        this.emx = null;
        this.emy = new int[2];
        init(context);
    }

    protected ViewPager eo(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        eq(context);
        ep(context);
    }

    protected void ep(Context context) {
        this.emx = new PointPageIndicator(context).aF(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).ng((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.emy[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.emy[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.emx, bdc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(Context context) {
        this.mViewPager = eo(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, bcZ());
    }

    public PointPageIndicator getPageindicator() {
        return this.emx;
    }

    protected int bcX() {
        return -2;
    }

    protected int bcY() {
        return -1;
    }

    protected LinearLayout.LayoutParams bcZ() {
        return new LinearLayout.LayoutParams(bcY(), bcX());
    }

    protected int bda() {
        return -1;
    }

    protected int bdb() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams bdc() {
        return new LinearLayout.LayoutParams(bda(), bdb());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.emy[0] = i;
        this.emy[1] = i2;
        requestLayout();
    }

    protected void bdd() {
        int pageCount = this.emi == null ? 0 : this.emi.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.emy[0] : this.emy[1];
        this.emx.nf(pageCount);
        this.emx.setVisibility(z ? 0 : 4);
        this.emx.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.emx.nh(i);
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
            if (SlideableGridView.this.emi != null) {
                return SlideableGridView.this.emi.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.emi);
            gridPageView.setPadding(SlideableGridView.this.emu, SlideableGridView.this.mTopPadding, SlideableGridView.this.emv, SlideableGridView.this.emw);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void h(View view, int i) {
            ((GridPageView) view).aE(SlideableGridView.this.emi.nj(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.emx != null) {
            this.emx.aF(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.emx != null) {
            this.mViewPager.setCurrentItem(i);
            this.emx.nh(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.emu = i;
        this.emv = i3;
        this.mTopPadding = i2;
        this.emw = i4;
    }
}
