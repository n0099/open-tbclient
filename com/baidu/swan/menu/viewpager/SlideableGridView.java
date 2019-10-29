package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.swan.menu.f;
/* loaded from: classes2.dex */
public class SlideableGridView extends LinearLayout {
    protected int[] bLA;
    private a bLg;
    b bLu;
    private int bLv;
    private int bLw;
    private int bLx;
    private int bLy;
    protected PointPageIndicator bLz;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView bLB;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int gv(int i);

        void f(SlideableGridView slideableGridView) {
            this.bLB = slideableGridView;
        }

        public int gB(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += gv(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void aaQ() {
            if (this.bLB != null && this.bLB.bLu != null) {
                this.bLB.bLu.notifyDataSetChanged();
                this.bLB.aaP();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.bLg;
    }

    public void setGridItemAdapter(a aVar) {
        this.bLg = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.bLu == null) {
                this.bLu = new b(getContext());
                this.mViewPager.setAdapter(this.bLu);
            } else {
                this.bLu.notifyDataSetChanged();
            }
            this.bLz.gy(aVar.getPageCount());
        } else if (this.bLu != null) {
            this.bLu.notifyDataSetChanged();
        }
        aaP();
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
        this.bLz = null;
        this.bLA = new int[2];
        init(context);
    }

    protected ViewPager cd(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        cf(context);
        ce(context);
    }

    protected void ce(Context context) {
        this.bLz = new PointPageIndicator(context).U(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).gz((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.bLA[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.bLA[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.bLz, aaO());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cf(Context context) {
        this.mViewPager = cd(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aaL());
    }

    public PointPageIndicator getPageindicator() {
        return this.bLz;
    }

    protected int aaJ() {
        return -2;
    }

    protected int aaK() {
        return -1;
    }

    protected LinearLayout.LayoutParams aaL() {
        return new LinearLayout.LayoutParams(aaK(), aaJ());
    }

    protected int aaM() {
        return -1;
    }

    protected int aaN() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aaO() {
        return new LinearLayout.LayoutParams(aaM(), aaN());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.bLA[0] = i;
        this.bLA[1] = i2;
        requestLayout();
    }

    protected void aaP() {
        int pageCount = this.bLg == null ? 0 : this.bLg.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.bLA[0] : this.bLA[1];
        this.bLz.gy(pageCount);
        this.bLz.setVisibility(z ? 0 : 4);
        this.bLz.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.bLz.gA(i);
        }
    }

    /* loaded from: classes2.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.bLg != null) {
                return SlideableGridView.this.bLg.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View c(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.bLg);
            gridPageView.setPadding(SlideableGridView.this.bLv, SlideableGridView.this.bLx, SlideableGridView.this.bLw, SlideableGridView.this.bLy);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).T(SlideableGridView.this.bLg.gB(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.bLz != null) {
            this.bLz.U(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.bLz != null) {
            this.mViewPager.setCurrentItem(i);
            this.bLz.gA(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.bLv = i;
        this.bLw = i3;
        this.bLx = i2;
        this.bLy = i4;
    }
}
