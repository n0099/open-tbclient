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
    private a egP;
    b eha;
    private int ehb;
    private int ehc;
    private int ehd;
    protected PointPageIndicator ehe;
    protected int[] ehf;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView ehg;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int mO(int i);

        void f(SlideableGridView slideableGridView) {
            this.ehg = slideableGridView;
        }

        public int mP(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += mO(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.egP;
    }

    public void setGridItemAdapter(a aVar) {
        this.egP = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.eha == null) {
                this.eha = new b(getContext());
                this.mViewPager.setAdapter(this.eha);
            } else {
                this.eha.notifyDataSetChanged();
            }
            this.ehe.mL(aVar.getPageCount());
        } else if (this.eha != null) {
            this.eha.notifyDataSetChanged();
        }
        baF();
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
        this.ehe = null;
        this.ehf = new int[2];
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
        this.ehe = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).mM((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.ehf[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.ehf[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.ehe, baE());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(Context context) {
        this.mViewPager = dI(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, baB());
    }

    public PointPageIndicator getPageindicator() {
        return this.ehe;
    }

    protected int baz() {
        return -2;
    }

    protected int baA() {
        return -1;
    }

    protected LinearLayout.LayoutParams baB() {
        return new LinearLayout.LayoutParams(baA(), baz());
    }

    protected int baC() {
        return -1;
    }

    protected int baD() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams baE() {
        return new LinearLayout.LayoutParams(baC(), baD());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.ehf[0] = i;
        this.ehf[1] = i2;
        requestLayout();
    }

    protected void baF() {
        int pageCount = this.egP == null ? 0 : this.egP.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.ehf[0] : this.ehf[1];
        this.ehe.mL(pageCount);
        this.ehe.setVisibility(z ? 0 : 4);
        this.ehe.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.ehe.mN(i);
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
            if (SlideableGridView.this.egP != null) {
                return SlideableGridView.this.egP.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.egP);
            gridPageView.setPadding(SlideableGridView.this.ehb, SlideableGridView.this.mTopPadding, SlideableGridView.this.ehc, SlideableGridView.this.ehd);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.egP.mP(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.ehe != null) {
            this.ehe.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.ehe != null) {
            this.mViewPager.setCurrentItem(i);
            this.ehe.mN(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.ehb = i;
        this.ehc = i3;
        this.mTopPadding = i2;
        this.ehd = i4;
    }
}
