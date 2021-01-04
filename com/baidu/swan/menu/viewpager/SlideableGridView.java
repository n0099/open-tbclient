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
    private ViewPager Zk;
    private a evP;
    b ewc;
    private int ewd;
    private int ewe;
    private int ewf;
    protected PointPageIndicator ewg;
    protected int[] ewh;
    private int mTopPadding;

    /* loaded from: classes5.dex */
    public static abstract class a {
        private SlideableGridView ewi;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int nr(int i);

        void f(SlideableGridView slideableGridView) {
            this.ewi = slideableGridView;
        }

        public int ns(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 < getPageCount()) {
                    i2 = nr(i3) + i4;
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
        return this.evP;
    }

    public void setGridItemAdapter(a aVar) {
        this.evP = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.ewc == null) {
                this.ewc = new b(getContext());
                this.Zk.setAdapter(this.ewc);
            } else {
                this.ewc.notifyDataSetChanged();
            }
            this.ewg.no(aVar.getPageCount());
        } else if (this.ewc != null) {
            this.ewc.notifyDataSetChanged();
        }
        bfz();
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
        this.Zk = null;
        this.ewg = null;
        this.ewh = new int[2];
        init(context);
    }

    protected ViewPager eH(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        eJ(context);
        eI(context);
    }

    protected void eI(Context context) {
        this.ewg = new PointPageIndicator(context).aC(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).np((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.ewh[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.ewh[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.ewg, bfy());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eJ(Context context) {
        this.Zk = eH(context);
        this.Zk.setOffscreenPageLimit(0);
        this.Zk.setOnPageChangeListener(new c());
        this.Zk.setOverScrollMode(2);
        addView(this.Zk, bfv());
    }

    public PointPageIndicator getPageindicator() {
        return this.ewg;
    }

    protected int bft() {
        return -2;
    }

    protected int bfu() {
        return -1;
    }

    protected LinearLayout.LayoutParams bfv() {
        return new LinearLayout.LayoutParams(bfu(), bft());
    }

    protected int bfw() {
        return -1;
    }

    protected int bfx() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams bfy() {
        return new LinearLayout.LayoutParams(bfw(), bfx());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.ewh[0] = i;
        this.ewh[1] = i2;
        requestLayout();
    }

    protected void bfz() {
        int pageCount = this.evP == null ? 0 : this.evP.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.ewh[0] : this.ewh[1];
        this.ewg.no(pageCount);
        this.ewg.setVisibility(z ? 0 : 4);
        this.ewg.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.ewg.nq(i);
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
            if (SlideableGridView.this.evP != null) {
                return SlideableGridView.this.evP.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View j(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.evP);
            gridPageView.setPadding(SlideableGridView.this.ewd, SlideableGridView.this.mTopPadding, SlideableGridView.this.ewe, SlideableGridView.this.ewf);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void k(View view, int i) {
            ((GridPageView) view).aB(SlideableGridView.this.evP.ns(i), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.ewg != null) {
            this.ewg.aC(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.Zk != null && this.ewg != null) {
            this.Zk.setCurrentItem(i);
            this.ewg.nq(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.ewd = i;
        this.ewe = i3;
        this.mTopPadding = i2;
        this.ewf = i4;
    }
}
