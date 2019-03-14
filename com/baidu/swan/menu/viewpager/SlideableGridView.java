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
    private a ble;
    b blr;
    private int bls;
    private int blt;
    private int blu;
    private int blv;
    protected PointPageIndicator blw;
    protected int[] blx;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView bly;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int eX(int i);

        public abstract int getPageCount();

        void f(SlideableGridView slideableGridView) {
            this.bly = slideableGridView;
        }

        public int fd(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += eX(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void Ru() {
            if (this.bly != null && this.bly.blr != null) {
                this.bly.blr.notifyDataSetChanged();
                this.bly.Rt();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.ble;
    }

    public void setGridItemAdapter(a aVar) {
        this.ble = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.blr == null) {
                this.blr = new b(getContext());
                this.mViewPager.setAdapter(this.blr);
            } else {
                this.blr.notifyDataSetChanged();
            }
            this.blw.fa(aVar.getPageCount());
        } else if (this.blr != null) {
            this.blr.notifyDataSetChanged();
        }
        Rt();
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
        this.blw = null;
        this.blx = new int[2];
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
        this.blw = new PointPageIndicator(context).N(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).fb((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.blx[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.blx[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.blw, Rs());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cB(Context context) {
        this.mViewPager = cz(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, Rp());
    }

    public PointPageIndicator getPageindicator() {
        return this.blw;
    }

    protected int Rn() {
        return -2;
    }

    protected int Ro() {
        return -1;
    }

    protected LinearLayout.LayoutParams Rp() {
        return new LinearLayout.LayoutParams(Ro(), Rn());
    }

    protected int Rq() {
        return -1;
    }

    protected int Rr() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams Rs() {
        return new LinearLayout.LayoutParams(Rq(), Rr());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.blx[0] = i;
        this.blx[1] = i2;
        requestLayout();
    }

    protected void Rt() {
        int pageCount = this.ble == null ? 0 : this.ble.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.blx[0] : this.blx[1];
        this.blw.fa(pageCount);
        this.blw.setVisibility(z ? 0 : 4);
        this.blw.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.blw.fc(i);
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
            if (SlideableGridView.this.ble != null) {
                return SlideableGridView.this.ble.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View b(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.ble);
            gridPageView.setPadding(SlideableGridView.this.bls, SlideableGridView.this.blu, SlideableGridView.this.blt, SlideableGridView.this.blv);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).M(SlideableGridView.this.ble.fd(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.blw != null) {
            this.blw.N(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.blw != null) {
            this.mViewPager.setCurrentItem(i);
            this.blw.fc(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.bls = i;
        this.blt = i3;
        this.blu = i2;
        this.blv = i4;
    }
}
