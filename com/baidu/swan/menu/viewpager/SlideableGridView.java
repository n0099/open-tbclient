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
    b bKD;
    private int bKE;
    private int bKF;
    private int bKG;
    private int bKH;
    protected PointPageIndicator bKI;
    protected int[] bKJ;
    private a bKp;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private SlideableGridView bKK;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int gu(int i);

        void f(SlideableGridView slideableGridView) {
            this.bKK = slideableGridView;
        }

        public int gA(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += gu(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void aaO() {
            if (this.bKK != null && this.bKK.bKD != null) {
                this.bKK.bKD.notifyDataSetChanged();
                this.bKK.aaN();
            }
        }
    }

    public a getGridItemAdapter() {
        return this.bKp;
    }

    public void setGridItemAdapter(a aVar) {
        this.bKp = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.bKD == null) {
                this.bKD = new b(getContext());
                this.mViewPager.setAdapter(this.bKD);
            } else {
                this.bKD.notifyDataSetChanged();
            }
            this.bKI.gx(aVar.getPageCount());
        } else if (this.bKD != null) {
            this.bKD.notifyDataSetChanged();
        }
        aaN();
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
        this.bKI = null;
        this.bKJ = new int[2];
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
        this.bKI = new PointPageIndicator(context).S(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).gy((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.bKJ[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.bKJ[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.bKI, aaM());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cf(Context context) {
        this.mViewPager = cd(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aaJ());
    }

    public PointPageIndicator getPageindicator() {
        return this.bKI;
    }

    protected int aaH() {
        return -2;
    }

    protected int aaI() {
        return -1;
    }

    protected LinearLayout.LayoutParams aaJ() {
        return new LinearLayout.LayoutParams(aaI(), aaH());
    }

    protected int aaK() {
        return -1;
    }

    protected int aaL() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aaM() {
        return new LinearLayout.LayoutParams(aaK(), aaL());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.bKJ[0] = i;
        this.bKJ[1] = i2;
        requestLayout();
    }

    protected void aaN() {
        int pageCount = this.bKp == null ? 0 : this.bKp.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.bKJ[0] : this.bKJ[1];
        this.bKI.gx(pageCount);
        this.bKI.setVisibility(z ? 0 : 4);
        this.bKI.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.bKI.gz(i);
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
            if (SlideableGridView.this.bKp != null) {
                return SlideableGridView.this.bKp.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View c(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.bKp);
            gridPageView.setPadding(SlideableGridView.this.bKE, SlideableGridView.this.bKG, SlideableGridView.this.bKF, SlideableGridView.this.bKH);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).R(SlideableGridView.this.bKp.gA(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.bKI != null) {
            this.bKI.S(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.bKI != null) {
            this.mViewPager.setCurrentItem(i);
            this.bKI.gz(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.bKE = i;
        this.bKF = i3;
        this.bKG = i2;
        this.bKH = i4;
    }
}
