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
    private a dSB;
    b dSM;
    private int dSN;
    private int dSO;
    private int dSP;
    protected PointPageIndicator dSQ;
    protected int[] dSR;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView dSS;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int mt(int i);

        void f(SlideableGridView slideableGridView) {
            this.dSS = slideableGridView;
        }

        public int mu(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += mt(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.dSB;
    }

    public void setGridItemAdapter(a aVar) {
        this.dSB = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.dSM == null) {
                this.dSM = new b(getContext());
                this.mViewPager.setAdapter(this.dSM);
            } else {
                this.dSM.notifyDataSetChanged();
            }
            this.dSQ.mq(aVar.getPageCount());
        } else if (this.dSM != null) {
            this.dSM.notifyDataSetChanged();
        }
        aWm();
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
        this.dSQ = null;
        this.dSR = new int[2];
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
        this.dSQ = new PointPageIndicator(context).aC(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).mr((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.dSR[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.dSR[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.dSQ, aWl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(Context context) {
        this.mViewPager = dI(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aWi());
    }

    public PointPageIndicator getPageindicator() {
        return this.dSQ;
    }

    protected int aWg() {
        return -2;
    }

    protected int aWh() {
        return -1;
    }

    protected LinearLayout.LayoutParams aWi() {
        return new LinearLayout.LayoutParams(aWh(), aWg());
    }

    protected int aWj() {
        return -1;
    }

    protected int aWk() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aWl() {
        return new LinearLayout.LayoutParams(aWj(), aWk());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.dSR[0] = i;
        this.dSR[1] = i2;
        requestLayout();
    }

    protected void aWm() {
        int pageCount = this.dSB == null ? 0 : this.dSB.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.dSR[0] : this.dSR[1];
        this.dSQ.mq(pageCount);
        this.dSQ.setVisibility(z ? 0 : 4);
        this.dSQ.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.dSQ.ms(i);
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
            if (SlideableGridView.this.dSB != null) {
                return SlideableGridView.this.dSB.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.dSB);
            gridPageView.setPadding(SlideableGridView.this.dSN, SlideableGridView.this.mTopPadding, SlideableGridView.this.dSO, SlideableGridView.this.dSP);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aB(SlideableGridView.this.dSB.mu(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.dSQ != null) {
            this.dSQ.aC(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.dSQ != null) {
            this.mViewPager.setCurrentItem(i);
            this.dSQ.ms(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.dSN = i;
        this.dSO = i3;
        this.mTopPadding = i2;
        this.dSP = i4;
    }
}
