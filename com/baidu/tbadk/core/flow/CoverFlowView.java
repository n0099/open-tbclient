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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager amn;
    private IndicatorView amo;
    private com.baidu.tbadk.core.flow.a.c amp;
    private CoverFlowAdapter<T> amq;
    private com.baidu.tbadk.core.flow.a amr;
    private CoverFlowView<T>.a ams;
    private boolean amt;
    private d<T> amu;
    private CoverFlowView<T>.c amv;
    private CoverFlowView<T>.b amw;
    private long amx;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ams = new a();
        this.amt = false;
        this.amv = new c();
        this.amw = new b();
        this.amx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ams = new a();
        this.amt = false;
        this.amv = new c();
        this.amw = new b();
        this.amx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ams = new a();
        this.amt = false;
        this.amv = new c();
        this.amw = new b();
        this.amx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.amu = dVar;
    }

    private void init(Context context) {
        aD(context);
        aE(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.amn);
        addView(this.amo);
        this.amq = new CoverFlowAdapter<>(context);
        this.amq.setOnClickListener(this.amv);
        this.amn.setAdapter(this.amq);
        this.amn.setOnPageChangeListener(this.amw);
    }

    private void aD(Context context) {
        this.amn = new ListViewPager(context);
    }

    private void aE(Context context) {
        this.amo = new IndicatorView(context);
        this.amo.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ct(int i) {
        if (this.amq == null) {
            return null;
        }
        return this.amq.ct(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.amq.a(list, this.amr);
            int size = list.size();
            if (size > 1) {
                this.amo.setVisibility(0);
                this.amo.setCount(size);
                this.amn.setCurrentItem(1, false);
                this.amo.setPosition(0.0f);
                xB();
                return;
            }
            this.amo.setVisibility(8);
            this.amo.setCount(size);
            this.amn.setCurrentItem(1, false);
            this.amo.setPosition(0.0f);
            xC();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.amr = aVar;
            this.amp = aVar.xy();
            this.amp.g(this.amo);
            aVar.xz().a(this.amn);
            this.mCustomView = aVar.xA();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.amn);
                addView(this.mCustomView);
                addView(this.amo);
            }
        }
    }

    public void xB() {
        xD();
    }

    public void xC() {
        this.ams.removeMessages(1);
    }

    public void xD() {
        this.ams.removeMessages(1);
        this.ams.sendEmptyMessageDelayed(1, this.amx);
    }

    public void setMarqueenTime(long j) {
        this.amx = j;
        xD();
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
                    CoverFlowView.this.xE();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE() {
        int count;
        if (this.amn != null && this.amq != null && (count = this.amq.getCount()) > 1) {
            int currentItem = this.amn.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.amn.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.amn.setCurrentItem(1, false);
            } else {
                this.amn.setCurrentItem(currentItem + 1);
            }
            this.amn.invalidate();
        }
    }

    private boolean xF() {
        int count;
        if (this.amq != null && (count = this.amq.getCount()) > 1) {
            int currentItem = this.amn.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.amn.setCurrentItem(i, false);
                this.amn.invalidate();
            } else if (currentItem > i) {
                this.amn.setCurrentItem(1, false);
                this.amn.invalidate();
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
            if (CoverFlowView.this.amo != null && CoverFlowView.this.amq != null) {
                if (CoverFlowView.this.amq.getCount() == 1 && i == 0 && CoverFlowView.this.amu != null) {
                    CoverFlowView.this.amu.a(1, CoverFlowView.this.amq.ct(i));
                }
                if (CoverFlowView.this.amo.getVisibility() == 0 && !CoverFlowView.this.amt) {
                    int count = CoverFlowView.this.amq.getCount();
                    if (i == 0) {
                        CoverFlowView.this.amo.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.amo.setPosition(f);
                    } else {
                        CoverFlowView.this.amo.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.amq != null) {
                int count = CoverFlowView.this.amq.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.amt) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.amu != null) {
                        CoverFlowView.this.amu.a(i, CoverFlowView.this.amq.ct(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.amn != null && CoverFlowView.this.amq != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.xG();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        int count = this.amq.getCount();
        if (i == 0) {
            this.amo.setPosition(0.0f);
        } else if (i == count - 1) {
            this.amo.setPosition(i);
        } else {
            this.amo.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG() {
        if (xF()) {
            xD();
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
            com.baidu.tbadk.core.flow.a.a ct;
            if (CoverFlowView.this.amu != null && (view.getTag() instanceof Integer) && (ct = CoverFlowView.this.amq.ct((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.amu.f(intValue, ct.uc());
            }
        }
    }

    public void onChangeSkinType() {
        this.amq.onChangeSkinType();
        if (this.amo != null && this.amp != null) {
            this.amo.setDrawable(am.getDrawable(this.amp.xH()));
            this.amo.setSelector(am.getDrawable(this.amp.xI()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.amn != null) {
            this.amn.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.amn != null) {
            this.amn.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.amt = z;
    }
}
