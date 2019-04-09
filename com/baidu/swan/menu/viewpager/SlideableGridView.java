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
/* loaded from: classes2.dex */
public class SlideableGridView extends LinearLayout {
    protected PointPageIndicator blA;
    protected int[] blB;
    private a bli;
    b blv;
    private int blw;
    private int blx;
    private int bly;
    private int blz;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView blC;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int eW(int i);

        public abstract int getPageCount();

        void f(SlideableGridView slideableGridView) {
            this.blC = slideableGridView;
        }

        public int fc(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += eW(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void Rs() {
            if (this.blC != null && this.blC.blv != null) {
                this.blC.blv.notifyDataSetChanged();
                this.blC.Rr();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.bli;
    }

    public void setGridItemAdapter(a aVar) {
        this.bli = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.blv == null) {
                this.blv = new b(getContext());
                this.mViewPager.setAdapter(this.blv);
            } else {
                this.blv.notifyDataSetChanged();
            }
            this.blA.eZ(aVar.getPageCount());
        } else if (this.blv != null) {
            this.blv.notifyDataSetChanged();
        }
        Rr();
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
        this.blA = null;
        this.blB = new int[2];
        init(context);
    }

    protected ViewPager cz(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        cB(context);
        cA(context);
    }

    protected void cA(Context context) {
        this.blA = new PointPageIndicator(context).N(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).fa((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.blB[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.blB[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.blA, Rq());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cB(Context context) {
        this.mViewPager = cz(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, Rn());
    }

    public PointPageIndicator getPageindicator() {
        return this.blA;
    }

    protected int Rl() {
        return -2;
    }

    protected int Rm() {
        return -1;
    }

    protected LinearLayout.LayoutParams Rn() {
        return new LinearLayout.LayoutParams(Rm(), Rl());
    }

    protected int Ro() {
        return -1;
    }

    protected int Rp() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams Rq() {
        return new LinearLayout.LayoutParams(Ro(), Rp());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.blB[0] = i;
        this.blB[1] = i2;
        requestLayout();
    }

    protected void Rr() {
        int pageCount = this.bli == null ? 0 : this.bli.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.blB[0] : this.blB[1];
        this.blA.eZ(pageCount);
        this.blA.setVisibility(z ? 0 : 4);
        this.blA.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.blA.fb(i);
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
            if (SlideableGridView.this.bli != null) {
                return SlideableGridView.this.bli.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View b(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.bli);
            gridPageView.setPadding(SlideableGridView.this.blw, SlideableGridView.this.bly, SlideableGridView.this.blx, SlideableGridView.this.blz);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).M(SlideableGridView.this.bli.fc(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.blA != null) {
            this.blA.N(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.blA != null) {
            this.mViewPager.setCurrentItem(i);
            this.blA.fb(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.blw = i;
        this.blx = i3;
        this.bly = i2;
        this.blz = i4;
    }
}
