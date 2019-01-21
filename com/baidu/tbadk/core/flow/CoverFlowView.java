package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager aya;
    private IndicatorView ayb;
    private com.baidu.tbadk.core.flow.a.c ayc;
    private CoverFlowAdapter<T> ayd;
    private com.baidu.tbadk.core.flow.a aye;
    private CoverFlowView<T>.a ayf;
    private boolean ayg;
    private boolean ayh;
    private boolean ayi;
    private d<T> ayj;
    private CoverFlowView<T>.c ayk;
    private CoverFlowView<T>.b ayl;
    private long aym;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ayf = new a();
        this.ayg = false;
        this.ayh = true;
        this.ayi = true;
        this.ayk = new c();
        this.ayl = new b();
        this.aym = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ayf = new a();
        this.ayg = false;
        this.ayh = true;
        this.ayi = true;
        this.ayk = new c();
        this.ayl = new b();
        this.aym = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ayf = new a();
        this.ayg = false;
        this.ayh = true;
        this.ayi = true;
        this.ayk = new c();
        this.ayl = new b();
        this.aym = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ayj = dVar;
    }

    private void init(Context context) {
        bt(context);
        bu(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aya);
        addView(this.ayb);
        this.ayd = new CoverFlowAdapter<>(context);
        this.ayd.setOnClickListener(this.ayk);
        this.aya.setAdapter(this.ayd);
        this.aya.setOnPageChangeListener(this.ayl);
    }

    private void bt(Context context) {
        this.aya = new ListViewPager(context);
    }

    private void bu(Context context) {
        this.ayb = new IndicatorView(context);
        this.ayb.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T dr(int i) {
        if (this.ayd == null) {
            return null;
        }
        return this.ayd.dr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.ayd.a(list, this.aye);
            int size = list.size();
            if (size > 1) {
                this.ayb.setVisibility(0);
                this.ayb.setCount(size);
                this.aya.setCurrentItem(1, false);
                this.ayb.setPosition(0.0f);
                Cf();
                return;
            }
            this.ayb.setVisibility(8);
            this.ayb.setCount(size);
            this.aya.setCurrentItem(1, false);
            this.ayb.setPosition(0.0f);
            Cg();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.aye = aVar;
            this.ayc = aVar.Cc();
            this.ayc.g(this.ayb);
            aVar.Cd().a(this.aya);
            this.mCustomView = aVar.Ce();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aya);
                addView(this.mCustomView);
                addView(this.ayb);
            }
        }
    }

    public void Cf() {
        Ch();
    }

    public void Cg() {
        this.ayf.removeMessages(1);
    }

    public void Ch() {
        this.ayf.removeMessages(1);
        this.ayf.sendEmptyMessageDelayed(1, this.aym);
    }

    public void setIndicatorVisible(int i) {
        if (this.ayb != null) {
            this.ayb.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.aym = j;
        Ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.Ci();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        int count;
        if (this.aya != null && this.ayd != null && (count = this.ayd.getCount()) > 1) {
            int currentItem = this.aya.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aya.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aya.setCurrentItem(1, false);
            } else {
                this.aya.setCurrentItem(currentItem + 1);
            }
            this.aya.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cj() {
        int count;
        if (this.ayd != null && (count = this.ayd.getCount()) > 1) {
            int currentItem = this.aya.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aya.setCurrentItem(i, false);
                this.aya.invalidate();
            } else if (currentItem > i) {
                this.aya.setCurrentItem(1, false);
                this.aya.invalidate();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.ayb != null && CoverFlowView.this.ayd != null) {
                if (CoverFlowView.this.ayd.getCount() == 1 && i == 0 && CoverFlowView.this.ayj != null) {
                    CoverFlowView.this.ayj.a(1, CoverFlowView.this.ayd.dr(i));
                }
                if (CoverFlowView.this.ayb.getVisibility() == 0 && !CoverFlowView.this.ayg) {
                    int count = CoverFlowView.this.ayd.getCount();
                    if (i == 0) {
                        CoverFlowView.this.ayb.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.ayb.setPosition(f);
                    } else {
                        CoverFlowView.this.ayb.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.ayd != null) {
                int count = CoverFlowView.this.ayd.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.ayg) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.ayj != null) {
                        CoverFlowView.this.ayj.a(i, CoverFlowView.this.ayd.dr(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aya != null && CoverFlowView.this.ayd != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.ayi) {
                            CoverFlowView.this.Ck();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.ayi = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.ayi) {
                            CoverFlowView.this.Cg();
                            CoverFlowView.this.Cj();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        int count = this.ayd.getCount();
        if (i == 0) {
            this.ayb.setPosition(0.0f);
        } else if (i == count - 1) {
            this.ayb.setPosition(i);
        } else {
            this.ayb.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if (Cj()) {
            Ch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a dr;
            if (CoverFlowView.this.ayj != null && (view.getTag() instanceof Integer) && (dr = CoverFlowView.this.ayd.dr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.ayj.i(intValue, dr.yA());
            }
        }
    }

    public void onChangeSkinType() {
        this.ayd.onChangeSkinType();
        if (this.ayb != null && this.ayc != null) {
            this.ayb.setDrawable(al.getDrawable(this.ayc.Cl()));
            this.ayb.setSelector(al.getDrawable(this.ayc.Cm()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.aya != null) {
            this.aya.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aya != null) {
            this.aya.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.ayg = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.ayh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.ayh;
    }

    private void setAutoPlay(boolean z) {
        this.ayi = z;
    }
}
