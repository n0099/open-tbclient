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
    private int brA;
    private int brB;
    protected PointPageIndicator brC;
    protected int[] brD;
    private a brk;
    b brx;
    private int bry;
    private int brz;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView brE;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int fv(int i);

        public abstract int getPageCount();

        void f(SlideableGridView slideableGridView) {
            this.brE = slideableGridView;
        }

        public int fB(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += fv(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void Ve() {
            if (this.brE != null && this.brE.brx != null) {
                this.brE.brx.notifyDataSetChanged();
                this.brE.Vd();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.brk;
    }

    public void setGridItemAdapter(a aVar) {
        this.brk = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.brx == null) {
                this.brx = new b(getContext());
                this.mViewPager.setAdapter(this.brx);
            } else {
                this.brx.notifyDataSetChanged();
            }
            this.brC.fy(aVar.getPageCount());
        } else if (this.brx != null) {
            this.brx.notifyDataSetChanged();
        }
        Vd();
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
        this.brC = null;
        this.brD = new int[2];
        init(context);
    }

    protected ViewPager cc(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        ce(context);
        cd(context);
    }

    protected void cd(Context context) {
        this.brC = new PointPageIndicator(context).L(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).fz((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.brD[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.brD[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.brC, Vc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ce(Context context) {
        this.mViewPager = cc(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, UZ());
    }

    public PointPageIndicator getPageindicator() {
        return this.brC;
    }

    protected int UX() {
        return -2;
    }

    protected int UY() {
        return -1;
    }

    protected LinearLayout.LayoutParams UZ() {
        return new LinearLayout.LayoutParams(UY(), UX());
    }

    protected int Va() {
        return -1;
    }

    protected int Vb() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams Vc() {
        return new LinearLayout.LayoutParams(Va(), Vb());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.brD[0] = i;
        this.brD[1] = i2;
        requestLayout();
    }

    protected void Vd() {
        int pageCount = this.brk == null ? 0 : this.brk.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.brD[0] : this.brD[1];
        this.brC.fy(pageCount);
        this.brC.setVisibility(z ? 0 : 4);
        this.brC.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.brC.fA(i);
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
            if (SlideableGridView.this.brk != null) {
                return SlideableGridView.this.brk.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View c(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.brk);
            gridPageView.setPadding(SlideableGridView.this.bry, SlideableGridView.this.brA, SlideableGridView.this.brz, SlideableGridView.this.brB);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).K(SlideableGridView.this.brk.fB(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.brC != null) {
            this.brC.L(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.brC != null) {
            this.mViewPager.setCurrentItem(i);
            this.brC.fA(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.bry = i;
        this.brz = i3;
        this.brA = i2;
        this.brB = i4;
    }
}
