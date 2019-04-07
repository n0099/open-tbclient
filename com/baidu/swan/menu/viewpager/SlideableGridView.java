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
    protected int[] blA;
    private a blh;
    b blu;
    private int blv;
    private int blw;
    private int blx;
    private int bly;
    protected PointPageIndicator blz;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView blB;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int eW(int i);

        public abstract int getPageCount();

        void f(SlideableGridView slideableGridView) {
            this.blB = slideableGridView;
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
            if (this.blB != null && this.blB.blu != null) {
                this.blB.blu.notifyDataSetChanged();
                this.blB.Rr();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.blh;
    }

    public void setGridItemAdapter(a aVar) {
        this.blh = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.blu == null) {
                this.blu = new b(getContext());
                this.mViewPager.setAdapter(this.blu);
            } else {
                this.blu.notifyDataSetChanged();
            }
            this.blz.eZ(aVar.getPageCount());
        } else if (this.blu != null) {
            this.blu.notifyDataSetChanged();
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
        this.blz = null;
        this.blA = new int[2];
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
        this.blz = new PointPageIndicator(context).N(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).fa((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.blA[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.blA[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.blz, Rq());
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
        return this.blz;
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
        this.blA[0] = i;
        this.blA[1] = i2;
        requestLayout();
    }

    protected void Rr() {
        int pageCount = this.blh == null ? 0 : this.blh.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.blA[0] : this.blA[1];
        this.blz.eZ(pageCount);
        this.blz.setVisibility(z ? 0 : 4);
        this.blz.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.blz.fb(i);
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
            if (SlideableGridView.this.blh != null) {
                return SlideableGridView.this.blh.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View b(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.blh);
            gridPageView.setPadding(SlideableGridView.this.blv, SlideableGridView.this.blx, SlideableGridView.this.blw, SlideableGridView.this.bly);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).M(SlideableGridView.this.blh.fc(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.blz != null) {
            this.blz.N(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.blz != null) {
            this.mViewPager.setCurrentItem(i);
            this.blz.fb(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.blv = i;
        this.blw = i3;
        this.blx = i2;
        this.bly = i4;
    }
}
