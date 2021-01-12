package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public class SlideableGridView extends LinearLayout {
    private ViewPager Zi;
    private a erb;
    b ero;
    private int erp;
    private int erq;
    private int ers;
    protected PointPageIndicator ert;
    protected int[] eru;
    private int mTopPadding;

    /* loaded from: classes5.dex */
    public static abstract class a {
        private SlideableGridView erv;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lL(int i);

        void f(SlideableGridView slideableGridView) {
            this.erv = slideableGridView;
        }

        public int lM(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 < getPageCount()) {
                    i2 = lL(i3) + i4;
                    i3++;
                } else {
                    if (i4 < 5) {
                    }
                    return 5;
                }
            }
        }
    }

    public a getGridItemAdapter() {
        return this.erb;
    }

    public void setGridItemAdapter(a aVar) {
        this.erb = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.ero == null) {
                this.ero = new b(getContext());
                this.Zi.setAdapter(this.ero);
            } else {
                this.ero.notifyDataSetChanged();
            }
            this.ert.lI(aVar.getPageCount());
        } else if (this.ero != null) {
            this.ero.notifyDataSetChanged();
        }
        bbG();
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
        this.Zi = null;
        this.ert = null;
        this.eru = new int[2];
        init(context);
    }

    protected ViewPager eG(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        eI(context);
        eH(context);
    }

    protected void eH(Context context) {
        this.ert = new PointPageIndicator(context).aC(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).lJ((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.eru[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.eru[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.ert, bbF());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(Context context) {
        this.Zi = eG(context);
        this.Zi.setOffscreenPageLimit(0);
        this.Zi.setOnPageChangeListener(new c());
        this.Zi.setOverScrollMode(2);
        addView(this.Zi, bbC());
    }

    public PointPageIndicator getPageindicator() {
        return this.ert;
    }

    protected int bbA() {
        return -2;
    }

    protected int bbB() {
        return -1;
    }

    protected LinearLayout.LayoutParams bbC() {
        return new LinearLayout.LayoutParams(bbB(), bbA());
    }

    protected int bbD() {
        return -1;
    }

    protected int bbE() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams bbF() {
        return new LinearLayout.LayoutParams(bbD(), bbE());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.eru[0] = i;
        this.eru[1] = i2;
        requestLayout();
    }

    protected void bbG() {
        int pageCount = this.erb == null ? 0 : this.erb.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.eru[0] : this.eru[1];
        this.ert.lI(pageCount);
        this.ert.setVisibility(z ? 0 : 4);
        this.ert.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.ert.lK(i);
        }
    }

    /* loaded from: classes5.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.erb != null) {
                return SlideableGridView.this.erb.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View j(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.erb);
            gridPageView.setPadding(SlideableGridView.this.erp, SlideableGridView.this.mTopPadding, SlideableGridView.this.erq, SlideableGridView.this.ers);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void k(View view, int i) {
            ((GridPageView) view).aB(SlideableGridView.this.erb.lM(i), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.ert != null) {
            this.ert.aC(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.Zi != null && this.ert != null) {
            this.Zi.setCurrentItem(i);
            this.ert.lK(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.erp = i;
        this.erq = i3;
        this.mTopPadding = i2;
        this.ers = i4;
    }
}
