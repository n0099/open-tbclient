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
import d.b.h0.r.w.b.a;
import d.b.h0.r.w.b.e;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowView<T extends d.b.h0.r.w.b.a> extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f13283e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f13284f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.w.b.c f13285g;

    /* renamed from: h  reason: collision with root package name */
    public View f13286h;
    public CoverFlowAdapter<T> i;
    public d.b.h0.r.w.a j;
    public CoverFlowView<T>.b k;
    public boolean l;
    public boolean m;
    public boolean n;
    public d.b.h0.r.w.b.d<T> o;
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
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.f13283e == null || CoverFlowView.this.i == null) {
                return;
            }
            if (i != 0) {
                if (i == 1 && !CoverFlowView.this.m) {
                    CoverFlowView.this.w();
                    CoverFlowView.this.m();
                }
            } else if (CoverFlowView.this.n) {
                CoverFlowView.this.o();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v25, resolved type: d.b.h0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (CoverFlowView.this.f13284f == null || CoverFlowView.this.i == null) {
                return;
            }
            if (CoverFlowView.this.i.getCount() == 1 && i == 0 && CoverFlowView.this.o != null) {
                CoverFlowView.this.o.a(1, CoverFlowView.this.i.i(i));
            }
            if (CoverFlowView.this.f13284f.getVisibility() != 0 || CoverFlowView.this.l) {
                return;
            }
            int count = CoverFlowView.this.i.getCount();
            if (i == 0) {
                CoverFlowView.this.f13284f.setPosition((count - 3) + f2);
            } else if (i == count - 1) {
                CoverFlowView.this.f13284f.setPosition(f2);
            } else {
                CoverFlowView.this.f13284f.setPosition((i - 1) + f2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: d.b.h0.r.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.i == null) {
                return;
            }
            int count = CoverFlowView.this.i.getCount();
            if (i < 0 || i >= count) {
                return;
            }
            if (CoverFlowView.this.l) {
                CoverFlowView.this.setIndicatorSelected(i);
            }
            if (CoverFlowView.this.o == null) {
                return;
            }
            CoverFlowView.this.o.a(i, CoverFlowView.this.i.i(i));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            d.b.h0.r.w.b.a i;
            if (CoverFlowView.this.o == null || !(view.getTag() instanceof Integer) || (i = CoverFlowView.this.i.i((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            CoverFlowView.this.o.b(intValue, i.b());
        }
    }

    public CoverFlowView(Context context) {
        super(context);
        this.f13286h = null;
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
    public void setIndicatorSelected(int i) {
        int count = this.i.getCount();
        if (i == 0) {
            this.f13284f.setPosition(0.0f);
        } else if (i == count - 1) {
            this.f13284f.setPosition(i);
        } else {
            this.f13284f.setPosition(i - 1);
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
        CoverFlowAdapter<T> coverFlowAdapter = this.i;
        if (coverFlowAdapter != null && (count = coverFlowAdapter.getCount()) > 1) {
            int currentItem = this.f13283e.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f13283e.setCurrentItem(i, false);
                this.f13283e.invalidate();
            } else if (currentItem > i) {
                this.f13283e.setCurrentItem(1, false);
                this.f13283e.invalidate();
            }
            return true;
        }
        return false;
    }

    public T n(int i) {
        CoverFlowAdapter<T> coverFlowAdapter = this.i;
        if (coverFlowAdapter == null) {
            return null;
        }
        return coverFlowAdapter.i(i);
    }

    public final void o() {
        if (m()) {
            t();
        }
    }

    public final void p(Context context) {
        r(context);
        q(context);
        setCoverFlowFactory(new d.b.h0.r.w.b.b());
        addView(this.f13283e);
        addView(this.f13284f);
        CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
        this.i = coverFlowAdapter;
        coverFlowAdapter.m(this.p);
        this.f13283e.setAdapter(this.i);
        this.f13283e.setOnPageChangeListener(this.q);
    }

    public final void q(Context context) {
        IndicatorView indicatorView = new IndicatorView(context);
        this.f13284f = indicatorView;
        indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public final void r(Context context) {
        this.f13283e = new ListViewPager(context);
    }

    public void s() {
        d.b.h0.r.w.b.c cVar;
        this.i.j();
        IndicatorView indicatorView = this.f13284f;
        if (indicatorView == null || (cVar = this.f13285g) == null) {
            return;
        }
        indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
        this.f13284f.setSelector(SkinManager.getDrawable(this.f13285g.b()));
    }

    public void setAutoPlay(boolean z) {
        this.n = z;
    }

    public void setCallback(d.b.h0.r.w.b.d<T> dVar) {
        this.o = dVar;
    }

    public void setCoverFlowFactory(d.b.h0.r.w.a aVar) {
        if (aVar == null) {
            return;
        }
        this.j = aVar;
        d.b.h0.r.w.b.c a2 = aVar.a();
        this.f13285g = a2;
        a2.i(this.f13284f);
        aVar.d().b(this.f13283e);
        View b2 = aVar.b();
        this.f13286h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f13283e);
            addView(this.f13286h);
            addView(this.f13284f);
        }
    }

    public void setData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.i.l(list, this.j);
        int size = list.size();
        if (size > 1) {
            this.f13284f.setVisibility(0);
            this.f13284f.setCount(size);
            this.f13283e.setCurrentItem(1, false);
            this.f13284f.setPosition(0.0f);
            if (this.n) {
                v();
                return;
            }
            return;
        }
        this.f13284f.setVisibility(8);
        this.f13284f.setCount(size);
        this.f13283e.setCurrentItem(1, false);
        this.f13284f.setPosition(0.0f);
        w();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager = this.f13283e;
        if (listViewPager != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.l = z;
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView = this.f13284f;
        if (indicatorView != null) {
            indicatorView.setVisibility(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.m = z;
    }

    public void setMarqueenTime(long j) {
        this.r = j;
        t();
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager = this.f13283e;
        if (listViewPager != null) {
            listViewPager.setPageMargin(i);
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager = this.f13283e;
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
        if (this.f13283e == null || (coverFlowAdapter = this.i) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f13283e.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.f13283e.setCurrentItem(i, false);
        } else if (currentItem > i) {
            this.f13283e.setCurrentItem(1, false);
        } else {
            this.f13283e.setCurrentItem(currentItem + 1);
        }
        this.f13283e.invalidate();
    }

    public void v() {
        t();
    }

    public void w() {
        this.k.removeMessages(1);
    }

    public void x(e eVar) {
        ListViewPager listViewPager;
        if (eVar == null || (listViewPager = this.f13283e) == null) {
            return;
        }
        eVar.b(listViewPager);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13286h = null;
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
        this.f13286h = null;
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
