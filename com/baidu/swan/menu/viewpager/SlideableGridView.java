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
    b bsJ;
    private int bsK;
    private int bsL;
    private int bsM;
    private int bsN;
    protected PointPageIndicator bsO;
    protected int[] bsP;
    private a bsv;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView bsQ;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int fA(int i);

        public abstract int getPageCount();

        void f(SlideableGridView slideableGridView) {
            this.bsQ = slideableGridView;
        }

        public int fG(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += fA(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void Wb() {
            if (this.bsQ != null && this.bsQ.bsJ != null) {
                this.bsQ.bsJ.notifyDataSetChanged();
                this.bsQ.Wa();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.bsv;
    }

    public void setGridItemAdapter(a aVar) {
        this.bsv = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.bsJ == null) {
                this.bsJ = new b(getContext());
                this.mViewPager.setAdapter(this.bsJ);
            } else {
                this.bsJ.notifyDataSetChanged();
            }
            this.bsO.fD(aVar.getPageCount());
        } else if (this.bsJ != null) {
            this.bsJ.notifyDataSetChanged();
        }
        Wa();
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
        this.bsO = null;
        this.bsP = new int[2];
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
        this.bsO = new PointPageIndicator(context).O(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).fE((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.bsP[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.bsP[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.bsO, VZ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cf(Context context) {
        this.mViewPager = cd(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, VW());
    }

    public PointPageIndicator getPageindicator() {
        return this.bsO;
    }

    protected int VU() {
        return -2;
    }

    protected int VV() {
        return -1;
    }

    protected LinearLayout.LayoutParams VW() {
        return new LinearLayout.LayoutParams(VV(), VU());
    }

    protected int VX() {
        return -1;
    }

    protected int VY() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams VZ() {
        return new LinearLayout.LayoutParams(VX(), VY());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.bsP[0] = i;
        this.bsP[1] = i2;
        requestLayout();
    }

    protected void Wa() {
        int pageCount = this.bsv == null ? 0 : this.bsv.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.bsP[0] : this.bsP[1];
        this.bsO.fD(pageCount);
        this.bsO.setVisibility(z ? 0 : 4);
        this.bsO.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.bsO.fF(i);
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
            if (SlideableGridView.this.bsv != null) {
                return SlideableGridView.this.bsv.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View c(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.bsv);
            gridPageView.setPadding(SlideableGridView.this.bsK, SlideableGridView.this.bsM, SlideableGridView.this.bsL, SlideableGridView.this.bsN);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).N(SlideableGridView.this.bsv.fG(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.bsO != null) {
            this.bsO.O(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.bsO != null) {
            this.mViewPager.setCurrentItem(i);
            this.bsO.fF(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.bsK = i;
        this.bsL = i3;
        this.bsM = i2;
        this.bsN = i4;
    }
}
