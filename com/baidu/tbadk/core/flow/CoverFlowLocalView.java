package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import d.b.i0.r.w.b.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalView<T extends d.b.i0.r.w.b.a> extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f12945e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12946f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.w.b.c f12947g;

    /* renamed from: h  reason: collision with root package name */
    public View f12948h;
    public CoverFlowLocalAdapter<T> i;
    public d.b.i0.r.w.a j;
    public CoverFlowLocalView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.b.i0.r.w.b.d<T> o;
    public CoverFlowLocalView<T>.d p;
    public CoverFlowLocalView<T>.c q;
    public boolean r;
    public long s;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            CoverFlowLocalView.this.s();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.f12945e == null || CoverFlowLocalView.this.i == null) {
                return;
            }
            if (i != 0) {
                if (i == 1 && !CoverFlowLocalView.this.m) {
                    CoverFlowLocalView.this.u();
                    CoverFlowLocalView.this.m();
                }
            } else if (CoverFlowLocalView.this.n) {
                CoverFlowLocalView.this.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: d.b.i0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (CoverFlowLocalView.this.f12946f == null || CoverFlowLocalView.this.i == null) {
                return;
            }
            if (CoverFlowLocalView.this.i.getCount() == 1 && i == 0 && CoverFlowLocalView.this.o != null) {
                CoverFlowLocalView.this.o.a(1, CoverFlowLocalView.this.i.i(i));
            }
            if (CoverFlowLocalView.this.f12946f.getVisibility() != 0 || CoverFlowLocalView.this.l) {
                return;
            }
            if (CoverFlowLocalView.this.r) {
                int count = CoverFlowLocalView.this.i.getCount();
                if (i == 0) {
                    CoverFlowLocalView.this.f12946f.setPosition((count - 3) + f2);
                    return;
                } else if (i == count - 1) {
                    CoverFlowLocalView.this.f12946f.setPosition(f2);
                    return;
                } else {
                    CoverFlowLocalView.this.f12946f.setPosition((i - 1) + f2);
                    return;
                }
            }
            CoverFlowLocalView.this.f12946f.setPosition(i + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: d.b.i0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.i == null) {
                return;
            }
            int count = CoverFlowLocalView.this.i.getCount();
            if (i < 0 || i >= count) {
                return;
            }
            if (CoverFlowLocalView.this.l) {
                CoverFlowLocalView.this.setIndicatorSelected(i);
            }
            if (CoverFlowLocalView.this.o == null) {
                return;
            }
            CoverFlowLocalView.this.o.a(i, CoverFlowLocalView.this.i.i(i));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.b.i0.r.w.b.a i;
            if (CoverFlowLocalView.this.o == null || !(view.getTag() instanceof Integer) || (i = CoverFlowLocalView.this.i.i((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            CoverFlowLocalView.this.o.b(intValue, i.b());
        }
    }

    public CoverFlowLocalView(Context context) {
        super(context);
        this.f12948h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.s = 5000L;
        o(context);
    }

    private boolean getAutoPlayPlayDragging() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        if (this.r) {
            int count = this.i.getCount();
            if (i == 0) {
                this.f12946f.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.f12946f.setPosition(i);
                return;
            } else {
                this.f12946f.setPosition(i - 1);
                return;
            }
        }
        this.f12946f.setPosition(i);
    }

    public final boolean m() {
        int count;
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.i;
        if (coverFlowLocalAdapter == null || !this.r || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.f12945e.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.f12945e.setCurrentItem(i, false);
            this.f12945e.invalidate();
        } else if (currentItem > i) {
            this.f12945e.setCurrentItem(1, false);
            this.f12945e.invalidate();
        }
        return true;
    }

    public final void n() {
        if (m()) {
            r();
        }
    }

    public final void o(Context context) {
        q(context);
        p(context);
        setCoverFlowFactory(new d.b.i0.r.w.b.b());
        addView(this.f12945e);
        addView(this.f12946f);
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
        this.i = coverFlowLocalAdapter;
        coverFlowLocalAdapter.m(this.p);
        this.f12945e.setAdapter(this.i);
        this.f12945e.setOnPageChangeListener(this.q);
    }

    public final void p(Context context) {
        IndicatorView indicatorView = new IndicatorView(context);
        this.f12946f = indicatorView;
        indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public final void q(Context context) {
        this.f12945e = new ListViewPager(context);
    }

    public void r() {
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, this.s);
    }

    public final void s() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        if (this.f12945e == null || (coverFlowLocalAdapter = this.i) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f12945e.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.f12945e.setCurrentItem(i, false);
        } else if (currentItem > i) {
            this.f12945e.setCurrentItem(1, false);
        } else {
            this.f12945e.setCurrentItem(currentItem + 1);
        }
        this.f12945e.invalidate();
    }

    public void setAutoPlay(boolean z) {
        this.n = z;
    }

    public void setCallback(d.b.i0.r.w.b.d<T> dVar) {
        this.o = dVar;
    }

    public void setCanRepeat(boolean z) {
        this.r = z;
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.i;
        if (coverFlowLocalAdapter != null) {
            coverFlowLocalAdapter.k(z);
        }
    }

    public void setCoverFlowFactory(d.b.i0.r.w.a aVar) {
        if (aVar == null) {
            return;
        }
        this.j = aVar;
        d.b.i0.r.w.b.c a2 = aVar.a();
        this.f12947g = a2;
        a2.i(this.f12946f);
        aVar.d().b(this.f12945e);
        View b2 = aVar.b();
        this.f12948h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f12945e);
            addView(this.f12948h);
            addView(this.f12946f);
        }
    }

    public void setData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.i.l(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f12946f.setVisibility(0);
            this.f12946f.setCount(size);
            this.f12945e.setCurrentItem(0, false);
            this.f12946f.setPosition(0.0f);
            if (this.n) {
                t();
                return;
            }
            return;
        }
        this.f12946f.setVisibility(8);
        this.f12946f.setCount(size);
        this.f12945e.setCurrentItem(0, false);
        this.f12946f.setPosition(0.0f);
        u();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager = this.f12945e;
        if (listViewPager != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.l = z;
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView = this.f12946f;
        if (indicatorView != null) {
            indicatorView.setVisibility(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.m = z;
    }

    public void setMarqueenTime(long j) {
        this.s = j;
        r();
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager = this.f12945e;
        if (listViewPager != null) {
            listViewPager.setPageMargin(i);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager = this.f12945e;
        if (listViewPager != null) {
            listViewPager.setSwipeControlInterface(cVar);
        }
    }

    public void t() {
        r();
    }

    public void u() {
        this.k.removeMessages(1);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12948h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.s = 5000L;
        o(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12948h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.s = 5000L;
        o(context);
    }
}
