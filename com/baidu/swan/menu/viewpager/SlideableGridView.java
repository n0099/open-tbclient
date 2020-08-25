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
    b dEG;
    protected PointPageIndicator dEH;
    protected int[] dEI;
    private a dEv;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView dEJ;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lL(int i);

        void f(SlideableGridView slideableGridView) {
            this.dEJ = slideableGridView;
        }

        public int lM(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += lL(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.dEv;
    }

    public void setGridItemAdapter(a aVar) {
        this.dEv = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.dEG == null) {
                this.dEG = new b(getContext());
                this.mViewPager.setAdapter(this.dEG);
            } else {
                this.dEG.notifyDataSetChanged();
            }
            this.dEH.lI(aVar.getPageCount());
        } else if (this.dEG != null) {
            this.dEG.notifyDataSetChanged();
        }
        aSR();
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
        this.dEH = null;
        this.dEI = new int[2];
        init(context);
    }

    protected ViewPager dD(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dF(context);
        dE(context);
    }

    protected void dE(Context context) {
        this.dEH = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).lJ((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.dEI[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.dEI[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.dEH, aSQ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dF(Context context) {
        this.mViewPager = dD(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aSN());
    }

    public PointPageIndicator getPageindicator() {
        return this.dEH;
    }

    protected int aSL() {
        return -2;
    }

    protected int aSM() {
        return -1;
    }

    protected LinearLayout.LayoutParams aSN() {
        return new LinearLayout.LayoutParams(aSM(), aSL());
    }

    protected int aSO() {
        return -1;
    }

    protected int aSP() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aSQ() {
        return new LinearLayout.LayoutParams(aSO(), aSP());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.dEI[0] = i;
        this.dEI[1] = i2;
        requestLayout();
    }

    protected void aSR() {
        int pageCount = this.dEv == null ? 0 : this.dEv.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.dEI[0] : this.dEI[1];
        this.dEH.lI(pageCount);
        this.dEH.setVisibility(z ? 0 : 4);
        this.dEH.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.dEH.lK(i);
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
            if (SlideableGridView.this.dEv != null) {
                return SlideableGridView.this.dEv.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.dEv);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.dEv.lM(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.dEH != null) {
            this.dEH.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.dEH != null) {
            this.mViewPager.setCurrentItem(i);
            this.dEH.lK(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
