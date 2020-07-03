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
/* loaded from: classes11.dex */
public class SlideableGridView extends LinearLayout {
    private a doI;
    b doT;
    protected PointPageIndicator doU;
    protected int[] doV;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView doW;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int jm(int i);

        void f(SlideableGridView slideableGridView) {
            this.doW = slideableGridView;
        }

        public int jn(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += jm(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.doI;
    }

    public void setGridItemAdapter(a aVar) {
        this.doI = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.doT == null) {
                this.doT = new b(getContext());
                this.mViewPager.setAdapter(this.doT);
            } else {
                this.doT.notifyDataSetChanged();
            }
            this.doU.jj(aVar.getPageCount());
        } else if (this.doT != null) {
            this.doT.notifyDataSetChanged();
        }
        aGo();
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
        this.doU = null;
        this.doV = new int[2];
        init(context);
    }

    protected ViewPager dt(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dv(context);
        du(context);
    }

    protected void du(Context context) {
        this.doU = new PointPageIndicator(context).aw(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).jk((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.doV[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.doV[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.doU, aGn());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dv(Context context) {
        this.mViewPager = dt(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aGk());
    }

    public PointPageIndicator getPageindicator() {
        return this.doU;
    }

    protected int aGi() {
        return -2;
    }

    protected int aGj() {
        return -1;
    }

    protected LinearLayout.LayoutParams aGk() {
        return new LinearLayout.LayoutParams(aGj(), aGi());
    }

    protected int aGl() {
        return -1;
    }

    protected int aGm() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aGn() {
        return new LinearLayout.LayoutParams(aGl(), aGm());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.doV[0] = i;
        this.doV[1] = i2;
        requestLayout();
    }

    protected void aGo() {
        int pageCount = this.doI == null ? 0 : this.doI.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.doV[0] : this.doV[1];
        this.doU.jj(pageCount);
        this.doU.setVisibility(z ? 0 : 4);
        this.doU.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.doU.jl(i);
        }
    }

    /* loaded from: classes11.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.doI != null) {
                return SlideableGridView.this.doI.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.doI);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).av(SlideableGridView.this.doI.jn(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.doU != null) {
            this.doU.aw(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.doU != null) {
            this.mViewPager.setCurrentItem(i);
            this.doU.jl(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
