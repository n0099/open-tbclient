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
/* loaded from: classes9.dex */
public class SlideableGridView extends LinearLayout {
    b cvF;
    protected PointPageIndicator cvG;
    protected int[] cvH;
    private a cvu;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes9.dex */
    public static abstract class a {
        private SlideableGridView cvI;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int ik(int i);

        void f(SlideableGridView slideableGridView) {
            this.cvI = slideableGridView;
        }

        public int il(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += ik(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.cvu;
    }

    public void setGridItemAdapter(a aVar) {
        this.cvu = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.cvF == null) {
                this.cvF = new b(getContext());
                this.mViewPager.setAdapter(this.cvF);
            } else {
                this.cvF.notifyDataSetChanged();
            }
            this.cvG.ih(aVar.getPageCount());
        } else if (this.cvF != null) {
            this.cvF.notifyDataSetChanged();
        }
        aqu();
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
        this.cvG = null;
        this.cvH = new int[2];
        init(context);
    }

    protected ViewPager dy(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dA(context);
        dz(context);
    }

    protected void dz(Context context) {
        this.cvG = new PointPageIndicator(context).an(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).ii((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.cvH[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.cvH[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.cvG, aqt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dA(Context context) {
        this.mViewPager = dy(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aqq());
    }

    public PointPageIndicator getPageindicator() {
        return this.cvG;
    }

    protected int aqo() {
        return -2;
    }

    protected int aqp() {
        return -1;
    }

    protected LinearLayout.LayoutParams aqq() {
        return new LinearLayout.LayoutParams(aqp(), aqo());
    }

    protected int aqr() {
        return -1;
    }

    protected int aqs() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aqt() {
        return new LinearLayout.LayoutParams(aqr(), aqs());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.cvH[0] = i;
        this.cvH[1] = i2;
        requestLayout();
    }

    protected void aqu() {
        int pageCount = this.cvu == null ? 0 : this.cvu.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.cvH[0] : this.cvH[1];
        this.cvG.ih(pageCount);
        this.cvG.setVisibility(z ? 0 : 4);
        this.cvG.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.cvG.ij(i);
        }
    }

    /* loaded from: classes9.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.cvu != null) {
                return SlideableGridView.this.cvu.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View h(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.cvu);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void g(View view, int i) {
            ((GridPageView) view).am(SlideableGridView.this.cvu.il(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.cvG != null) {
            this.cvG.an(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.cvG != null) {
            this.mViewPager.setCurrentItem(i);
            this.cvG.ij(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
