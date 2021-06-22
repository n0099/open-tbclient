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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import d.a.n0.r.w.b.a;
import d.a.n0.r.w.b.e;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowView<T extends d.a.n0.r.w.b.a> extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f12263e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12264f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.w.b.c f12265g;

    /* renamed from: h  reason: collision with root package name */
    public View f12266h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowAdapter<T> f12267i;
    public d.a.n0.r.w.a j;
    public CoverFlowView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.a.n0.r.w.b.d<T> o;
    public CoverFlowView<T>.d p;
    public CoverFlowView<T>.c q;
    public long r;

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
            CoverFlowView.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (CoverFlowView.this.f12263e == null || CoverFlowView.this.f12267i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !CoverFlowView.this.m) {
                    CoverFlowView.this.w();
                    CoverFlowView.this.m();
                }
            } else if (CoverFlowView.this.n) {
                CoverFlowView.this.o();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v25, resolved type: d.a.n0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (CoverFlowView.this.f12264f == null || CoverFlowView.this.f12267i == null) {
                return;
            }
            if (CoverFlowView.this.f12267i.getCount() == 1 && i2 == 0 && CoverFlowView.this.o != null) {
                CoverFlowView.this.o.a(1, CoverFlowView.this.f12267i.i(i2));
            }
            if (CoverFlowView.this.f12264f.getVisibility() != 0 || CoverFlowView.this.l) {
                return;
            }
            int count = CoverFlowView.this.f12267i.getCount();
            if (i2 == 0) {
                CoverFlowView.this.f12264f.setPosition((count - 3) + f2);
            } else if (i2 == count - 1) {
                CoverFlowView.this.f12264f.setPosition(f2);
            } else {
                CoverFlowView.this.f12264f.setPosition((i2 - 1) + f2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: d.a.n0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (CoverFlowView.this.f12267i == null) {
                return;
            }
            int count = CoverFlowView.this.f12267i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (CoverFlowView.this.l) {
                CoverFlowView.this.setIndicatorSelected(i2);
            }
            if (CoverFlowView.this.o == null) {
                return;
            }
            CoverFlowView.this.o.a(i2, CoverFlowView.this.f12267i.i(i2));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.a.n0.r.w.b.a i2;
            if (CoverFlowView.this.o == null || !(view.getTag() instanceof Integer) || (i2 = CoverFlowView.this.f12267i.i((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            CoverFlowView.this.o.b(intValue, i2.b());
        }
    }

    public CoverFlowView(Context context) {
        super(context);
        this.f12266h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.r = 5000L;
        p(context);
    }

    private boolean getAutoPlayPlayDragging() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i2) {
        int count = this.f12267i.getCount();
        if (i2 == 0) {
            this.f12264f.setPosition(0.0f);
        } else if (i2 == count - 1) {
            this.f12264f.setPosition(i2);
        } else {
            this.f12264f.setPosition(i2 - 1);
        }
    }

    public void l() {
        if (this.k.hasMessages(1)) {
            return;
        }
        v();
    }

    public final boolean m() {
        int count;
        CoverFlowAdapter<T> coverFlowAdapter = this.f12267i;
        if (coverFlowAdapter != null && (count = coverFlowAdapter.getCount()) > 1) {
            int currentItem = this.f12263e.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f12263e.setCurrentItem(i2, false);
                this.f12263e.invalidate();
            } else if (currentItem > i2) {
                this.f12263e.setCurrentItem(1, false);
                this.f12263e.invalidate();
            }
            return true;
        }
        return false;
    }

    public T n(int i2) {
        CoverFlowAdapter<T> coverFlowAdapter = this.f12267i;
        if (coverFlowAdapter == null) {
            return null;
        }
        return coverFlowAdapter.i(i2);
    }

    public final void o() {
        if (m()) {
            t();
        }
    }

    public final void p(Context context) {
        r(context);
        q(context);
        setCoverFlowFactory(new d.a.n0.r.w.b.b());
        addView(this.f12263e);
        addView(this.f12264f);
        CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
        this.f12267i = coverFlowAdapter;
        coverFlowAdapter.m(this.p);
        this.f12263e.setAdapter(this.f12267i);
        this.f12263e.setOnPageChangeListener(this.q);
    }

    public final void q(Context context) {
        IndicatorView indicatorView = new IndicatorView(context);
        this.f12264f = indicatorView;
        indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public final void r(Context context) {
        this.f12263e = new ListViewPager(context);
    }

    public void s() {
        d.a.n0.r.w.b.c cVar;
        this.f12267i.j();
        IndicatorView indicatorView = this.f12264f;
        if (indicatorView == null || (cVar = this.f12265g) == null) {
            return;
        }
        indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
        this.f12264f.setSelector(SkinManager.getDrawable(this.f12265g.b()));
    }

    public void setAutoPlay(boolean z) {
        this.n = z;
    }

    public void setCallback(d.a.n0.r.w.b.d<T> dVar) {
        this.o = dVar;
    }

    public void setCoverFlowFactory(d.a.n0.r.w.a aVar) {
        if (aVar == null) {
            return;
        }
        this.j = aVar;
        d.a.n0.r.w.b.c a2 = aVar.a();
        this.f12265g = a2;
        a2.i(this.f12264f);
        aVar.c().b(this.f12263e);
        View b2 = aVar.b();
        this.f12266h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f12263e);
            addView(this.f12266h);
            addView(this.f12264f);
        }
    }

    public void setData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12267i.l(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f12264f.setVisibility(0);
            this.f12264f.setCount(size);
            this.f12263e.setCurrentItem(1, false);
            this.f12264f.setPosition(0.0f);
            if (this.n) {
                v();
                return;
            }
            return;
        }
        this.f12264f.setVisibility(8);
        this.f12264f.setCount(size);
        this.f12263e.setCurrentItem(1, false);
        this.f12264f.setPosition(0.0f);
        w();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager = this.f12263e;
        if (listViewPager != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.l = z;
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView = this.f12264f;
        if (indicatorView != null) {
            indicatorView.setVisibility(i2);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.m = z;
    }

    public void setMarqueenTime(long j) {
        this.r = j;
        t();
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager = this.f12263e;
        if (listViewPager != null) {
            listViewPager.setPageMargin(i2);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager = this.f12263e;
        if (listViewPager != null) {
            listViewPager.setSwipeControlInterface(cVar);
        }
    }

    public void t() {
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, this.r);
    }

    public final void u() {
        CoverFlowAdapter<T> coverFlowAdapter;
        int count;
        if (this.f12263e == null || (coverFlowAdapter = this.f12267i) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f12263e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f12263e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f12263e.setCurrentItem(1, false);
        } else {
            this.f12263e.setCurrentItem(currentItem + 1);
        }
        this.f12263e.invalidate();
    }

    public void v() {
        t();
    }

    public void w() {
        this.k.removeMessages(1);
    }

    public void x(e eVar) {
        ListViewPager listViewPager;
        if (eVar == null || (listViewPager = this.f12263e) == null) {
            return;
        }
        eVar.b(listViewPager);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12266h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.r = 5000L;
        p(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12266h = null;
        this.k = new b();
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d();
        this.q = new c();
        this.r = 5000L;
        p(context);
    }
}
