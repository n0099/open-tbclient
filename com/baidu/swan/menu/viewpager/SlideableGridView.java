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
/* loaded from: classes23.dex */
public class SlideableGridView extends LinearLayout {
    private a dGA;
    b dGL;
    private int dGM;
    private int dGN;
    private int dGO;
    protected PointPageIndicator dGP;
    protected int[] dGQ;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes23.dex */
    public static abstract class a {
        private SlideableGridView dGR;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lW(int i);

        void f(SlideableGridView slideableGridView) {
            this.dGR = slideableGridView;
        }

        public int lX(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += lW(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.dGA;
    }

    public void setGridItemAdapter(a aVar) {
        this.dGA = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.dGL == null) {
                this.dGL = new b(getContext());
                this.mViewPager.setAdapter(this.dGL);
            } else {
                this.dGL.notifyDataSetChanged();
            }
            this.dGP.lT(aVar.getPageCount());
        } else if (this.dGL != null) {
            this.dGL.notifyDataSetChanged();
        }
        aTD();
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
        this.dGP = null;
        this.dGQ = new int[2];
        init(context);
    }

    protected ViewPager dC(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dE(context);
        dD(context);
    }

    protected void dD(Context context) {
        this.dGP = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).lU((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.dGQ[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.dGQ[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.dGP, aTC());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dE(Context context) {
        this.mViewPager = dC(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aTz());
    }

    public PointPageIndicator getPageindicator() {
        return this.dGP;
    }

    protected int aTx() {
        return -2;
    }

    protected int aTy() {
        return -1;
    }

    protected LinearLayout.LayoutParams aTz() {
        return new LinearLayout.LayoutParams(aTy(), aTx());
    }

    protected int aTA() {
        return -1;
    }

    protected int aTB() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aTC() {
        return new LinearLayout.LayoutParams(aTA(), aTB());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.dGQ[0] = i;
        this.dGQ[1] = i2;
        requestLayout();
    }

    protected void aTD() {
        int pageCount = this.dGA == null ? 0 : this.dGA.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.dGQ[0] : this.dGQ[1];
        this.dGP.lT(pageCount);
        this.dGP.setVisibility(z ? 0 : 4);
        this.dGP.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.dGP.lV(i);
        }
    }

    /* loaded from: classes23.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.dGA != null) {
                return SlideableGridView.this.dGA.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.dGA);
            gridPageView.setPadding(SlideableGridView.this.dGM, SlideableGridView.this.mTopPadding, SlideableGridView.this.dGN, SlideableGridView.this.dGO);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.dGA.lX(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.dGP != null) {
            this.dGP.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.dGP != null) {
            this.mViewPager.setCurrentItem(i);
            this.dGP.lV(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.dGM = i;
        this.dGN = i3;
        this.mTopPadding = i2;
        this.dGO = i4;
    }
}
