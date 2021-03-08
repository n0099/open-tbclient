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
/* loaded from: classes4.dex */
public class SlideableGridView extends LinearLayout {
    private ViewPager aaw;
    private a euK;
    b euX;
    private int euY;
    private int euZ;
    private int eva;
    protected PointPageIndicator evb;
    protected int[] evc;
    private int mTopPadding;

    /* loaded from: classes4.dex */
    public static abstract class a {
        private SlideableGridView evd;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lP(int i);

        void f(SlideableGridView slideableGridView) {
            this.evd = slideableGridView;
        }

        public int lQ(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 < getPageCount()) {
                    i2 = lP(i3) + i4;
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
        return this.euK;
    }

    public void setGridItemAdapter(a aVar) {
        this.euK = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.euX == null) {
                this.euX = new b(getContext());
                this.aaw.setAdapter(this.euX);
            } else {
                this.euX.notifyDataSetChanged();
            }
            this.evb.lM(aVar.getPageCount());
        } else if (this.euX != null) {
            this.euX.notifyDataSetChanged();
        }
        bbV();
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
        this.aaw = null;
        this.evb = null;
        this.evc = new int[2];
        init(context);
    }

    protected ViewPager eE(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        eG(context);
        eF(context);
    }

    protected void eF(Context context) {
        this.evb = new PointPageIndicator(context).az(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).lN((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.evc[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.evc[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.evb, bbU());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(Context context) {
        this.aaw = eE(context);
        this.aaw.setOffscreenPageLimit(0);
        this.aaw.setOnPageChangeListener(new c());
        this.aaw.setOverScrollMode(2);
        addView(this.aaw, bbR());
    }

    public PointPageIndicator getPageindicator() {
        return this.evb;
    }

    protected int bbP() {
        return -2;
    }

    protected int bbQ() {
        return -1;
    }

    protected LinearLayout.LayoutParams bbR() {
        return new LinearLayout.LayoutParams(bbQ(), bbP());
    }

    protected int bbS() {
        return -1;
    }

    protected int bbT() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams bbU() {
        return new LinearLayout.LayoutParams(bbS(), bbT());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.evc[0] = i;
        this.evc[1] = i2;
        requestLayout();
    }

    protected void bbV() {
        int pageCount = this.euK == null ? 0 : this.euK.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.evc[0] : this.evc[1];
        this.evb.lM(pageCount);
        this.evb.setVisibility(z ? 0 : 4);
        this.evb.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.evb.lO(i);
        }
    }

    /* loaded from: classes4.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.euK != null) {
                return SlideableGridView.this.euK.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View j(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.euK);
            gridPageView.setPadding(SlideableGridView.this.euY, SlideableGridView.this.mTopPadding, SlideableGridView.this.euZ, SlideableGridView.this.eva);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void k(View view, int i) {
            ((GridPageView) view).ay(SlideableGridView.this.euK.lQ(i), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.evb != null) {
            this.evb.az(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.aaw != null && this.evb != null) {
            this.aaw.setCurrentItem(i);
            this.evb.lO(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.euY = i;
        this.euZ = i3;
        this.mTopPadding = i2;
        this.eva = i4;
    }
}
