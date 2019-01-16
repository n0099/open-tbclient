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
    private ListViewPager axZ;
    private IndicatorView aya;
    private com.baidu.tbadk.core.flow.a.c ayb;
    private CoverFlowAdapter<T> ayc;
    private com.baidu.tbadk.core.flow.a ayd;
    private CoverFlowView<T>.a aye;
    private boolean ayf;
    private boolean ayg;
    private boolean ayh;
    private d<T> ayi;
    private CoverFlowView<T>.c ayj;
    private CoverFlowView<T>.b ayk;
    private long ayl;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aye = new a();
        this.ayf = false;
        this.ayg = true;
        this.ayh = true;
        this.ayj = new c();
        this.ayk = new b();
        this.ayl = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aye = new a();
        this.ayf = false;
        this.ayg = true;
        this.ayh = true;
        this.ayj = new c();
        this.ayk = new b();
        this.ayl = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aye = new a();
        this.ayf = false;
        this.ayg = true;
        this.ayh = true;
        this.ayj = new c();
        this.ayk = new b();
        this.ayl = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ayi = dVar;
    }

    private void init(Context context) {
        bt(context);
        bu(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.axZ);
        addView(this.aya);
        this.ayc = new CoverFlowAdapter<>(context);
        this.ayc.setOnClickListener(this.ayj);
        this.axZ.setAdapter(this.ayc);
        this.axZ.setOnPageChangeListener(this.ayk);
    }

    private void bt(Context context) {
        this.axZ = new ListViewPager(context);
    }

    private void bu(Context context) {
        this.aya = new IndicatorView(context);
        this.aya.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T dr(int i) {
        if (this.ayc == null) {
            return null;
        }
        return this.ayc.dr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.ayc.a(list, this.ayd);
            int size = list.size();
            if (size > 1) {
                this.aya.setVisibility(0);
                this.aya.setCount(size);
                this.axZ.setCurrentItem(1, false);
                this.aya.setPosition(0.0f);
                Cf();
                return;
            }
            this.aya.setVisibility(8);
            this.aya.setCount(size);
            this.axZ.setCurrentItem(1, false);
            this.aya.setPosition(0.0f);
            Cg();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.ayd = aVar;
            this.ayb = aVar.Cc();
            this.ayb.g(this.aya);
            aVar.Cd().a(this.axZ);
            this.mCustomView = aVar.Ce();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.axZ);
                addView(this.mCustomView);
                addView(this.aya);
            }
        }
    }

    public void Cf() {
        Ch();
    }

    public void Cg() {
        this.aye.removeMessages(1);
    }

    public void Ch() {
        this.aye.removeMessages(1);
        this.aye.sendEmptyMessageDelayed(1, this.ayl);
    }

    public void setIndicatorVisible(int i) {
        if (this.aya != null) {
            this.aya.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.ayl = j;
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
        if (this.axZ != null && this.ayc != null && (count = this.ayc.getCount()) > 1) {
            int currentItem = this.axZ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axZ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.axZ.setCurrentItem(1, false);
            } else {
                this.axZ.setCurrentItem(currentItem + 1);
            }
            this.axZ.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cj() {
        int count;
        if (this.ayc != null && (count = this.ayc.getCount()) > 1) {
            int currentItem = this.axZ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axZ.setCurrentItem(i, false);
                this.axZ.invalidate();
            } else if (currentItem > i) {
                this.axZ.setCurrentItem(1, false);
                this.axZ.invalidate();
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
            if (CoverFlowView.this.aya != null && CoverFlowView.this.ayc != null) {
                if (CoverFlowView.this.ayc.getCount() == 1 && i == 0 && CoverFlowView.this.ayi != null) {
                    CoverFlowView.this.ayi.a(1, CoverFlowView.this.ayc.dr(i));
                }
                if (CoverFlowView.this.aya.getVisibility() == 0 && !CoverFlowView.this.ayf) {
                    int count = CoverFlowView.this.ayc.getCount();
                    if (i == 0) {
                        CoverFlowView.this.aya.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.aya.setPosition(f);
                    } else {
                        CoverFlowView.this.aya.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.ayc != null) {
                int count = CoverFlowView.this.ayc.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.ayf) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.ayi != null) {
                        CoverFlowView.this.ayi.a(i, CoverFlowView.this.ayc.dr(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.axZ != null && CoverFlowView.this.ayc != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.ayh) {
                            CoverFlowView.this.Ck();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.ayh = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.ayh) {
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
        int count = this.ayc.getCount();
        if (i == 0) {
            this.aya.setPosition(0.0f);
        } else if (i == count - 1) {
            this.aya.setPosition(i);
        } else {
            this.aya.setPosition(i - 1);
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
            if (CoverFlowView.this.ayi != null && (view.getTag() instanceof Integer) && (dr = CoverFlowView.this.ayc.dr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.ayi.i(intValue, dr.yA());
            }
        }
    }

    public void onChangeSkinType() {
        this.ayc.onChangeSkinType();
        if (this.aya != null && this.ayb != null) {
            this.aya.setDrawable(al.getDrawable(this.ayb.Cl()));
            this.aya.setSelector(al.getDrawable(this.ayb.Cm()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.axZ != null) {
            this.axZ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.axZ != null) {
            this.axZ.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.ayf = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.ayg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.ayg;
    }

    private void setAutoPlay(boolean z) {
        this.ayh = z;
    }
}
