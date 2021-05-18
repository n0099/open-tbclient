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
import d.a.j0.r.w.b.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalView<T extends d.a.j0.r.w.b.a> extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f12203e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12204f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.w.b.c f12205g;

    /* renamed from: h  reason: collision with root package name */
    public View f12206h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowLocalAdapter<T> f12207i;
    public d.a.j0.r.w.a j;
    public CoverFlowLocalView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.a.j0.r.w.b.d<T> o;
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
        public void onPageScrollStateChanged(int i2) {
            if (CoverFlowLocalView.this.f12203e == null || CoverFlowLocalView.this.f12207i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !CoverFlowLocalView.this.m) {
                    CoverFlowLocalView.this.u();
                    CoverFlowLocalView.this.m();
                }
            } else if (CoverFlowLocalView.this.n) {
                CoverFlowLocalView.this.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: d.a.j0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (CoverFlowLocalView.this.f12204f == null || CoverFlowLocalView.this.f12207i == null) {
                return;
            }
            if (CoverFlowLocalView.this.f12207i.getCount() == 1 && i2 == 0 && CoverFlowLocalView.this.o != null) {
                CoverFlowLocalView.this.o.a(1, CoverFlowLocalView.this.f12207i.b(i2));
            }
            if (CoverFlowLocalView.this.f12204f.getVisibility() != 0 || CoverFlowLocalView.this.l) {
                return;
            }
            if (CoverFlowLocalView.this.r) {
                int count = CoverFlowLocalView.this.f12207i.getCount();
                if (i2 == 0) {
                    CoverFlowLocalView.this.f12204f.setPosition((count - 3) + f2);
                    return;
                } else if (i2 == count - 1) {
                    CoverFlowLocalView.this.f12204f.setPosition(f2);
                    return;
                } else {
                    CoverFlowLocalView.this.f12204f.setPosition((i2 - 1) + f2);
                    return;
                }
            }
            CoverFlowLocalView.this.f12204f.setPosition(i2 + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: d.a.j0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (CoverFlowLocalView.this.f12207i == null) {
                return;
            }
            int count = CoverFlowLocalView.this.f12207i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (CoverFlowLocalView.this.l) {
                CoverFlowLocalView.this.setIndicatorSelected(i2);
            }
            if (CoverFlowLocalView.this.o == null) {
                return;
            }
            CoverFlowLocalView.this.o.a(i2, CoverFlowLocalView.this.f12207i.b(i2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.a.j0.r.w.b.a b2;
            if (CoverFlowLocalView.this.o == null || !(view.getTag() instanceof Integer) || (b2 = CoverFlowLocalView.this.f12207i.b((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            CoverFlowLocalView.this.o.b(intValue, b2.b());
        }
    }

    public CoverFlowLocalView(Context context) {
        super(context);
        this.f12206h = null;
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
    public void setIndicatorSelected(int i2) {
        if (this.r) {
            int count = this.f12207i.getCount();
            if (i2 == 0) {
                this.f12204f.setPosition(0.0f);
                return;
            } else if (i2 == count - 1) {
                this.f12204f.setPosition(i2);
                return;
            } else {
                this.f12204f.setPosition(i2 - 1);
                return;
            }
        }
        this.f12204f.setPosition(i2);
    }

    public final boolean m() {
        int count;
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f12207i;
        if (coverFlowLocalAdapter == null || !this.r || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.f12203e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f12203e.setCurrentItem(i2, false);
            this.f12203e.invalidate();
        } else if (currentItem > i2) {
            this.f12203e.setCurrentItem(1, false);
            this.f12203e.invalidate();
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
        setCoverFlowFactory(new d.a.j0.r.w.b.b());
        addView(this.f12203e);
        addView(this.f12204f);
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
        this.f12207i = coverFlowLocalAdapter;
        coverFlowLocalAdapter.f(this.p);
        this.f12203e.setAdapter(this.f12207i);
        this.f12203e.setOnPageChangeListener(this.q);
    }

    public final void p(Context context) {
        IndicatorView indicatorView = new IndicatorView(context);
        this.f12204f = indicatorView;
        indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public final void q(Context context) {
        this.f12203e = new ListViewPager(context);
    }

    public void r() {
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, this.s);
    }

    public final void s() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        if (this.f12203e == null || (coverFlowLocalAdapter = this.f12207i) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f12203e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f12203e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f12203e.setCurrentItem(1, false);
        } else {
            this.f12203e.setCurrentItem(currentItem + 1);
        }
        this.f12203e.invalidate();
    }

    public void setAutoPlay(boolean z) {
        this.n = z;
    }

    public void setCallback(d.a.j0.r.w.b.d<T> dVar) {
        this.o = dVar;
    }

    public void setCanRepeat(boolean z) {
        this.r = z;
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f12207i;
        if (coverFlowLocalAdapter != null) {
            coverFlowLocalAdapter.d(z);
        }
    }

    public void setCoverFlowFactory(d.a.j0.r.w.a aVar) {
        if (aVar == null) {
            return;
        }
        this.j = aVar;
        d.a.j0.r.w.b.c a2 = aVar.a();
        this.f12205g = a2;
        a2.i(this.f12204f);
        aVar.c().b(this.f12203e);
        View b2 = aVar.b();
        this.f12206h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f12203e);
            addView(this.f12206h);
            addView(this.f12204f);
        }
    }

    public void setData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12207i.e(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f12204f.setVisibility(0);
            this.f12204f.setCount(size);
            this.f12203e.setCurrentItem(0, false);
            this.f12204f.setPosition(0.0f);
            if (this.n) {
                t();
                return;
            }
            return;
        }
        this.f12204f.setVisibility(8);
        this.f12204f.setCount(size);
        this.f12203e.setCurrentItem(0, false);
        this.f12204f.setPosition(0.0f);
        u();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager = this.f12203e;
        if (listViewPager != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.l = z;
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView = this.f12204f;
        if (indicatorView != null) {
            indicatorView.setVisibility(i2);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.m = z;
    }

    public void setMarqueenTime(long j) {
        this.s = j;
        r();
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager = this.f12203e;
        if (listViewPager != null) {
            listViewPager.setPageMargin(i2);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager = this.f12203e;
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

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12206h = null;
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
        this.f12206h = null;
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
