package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager RM;
    private IndicatorView RN;
    private a<T> RO;
    private b RP;
    private CoverFlowView<T>.c RQ;
    private com.baidu.tbadk.core.flow.a.d<T> RR;
    private CoverFlowView<T>.e RS;
    private CoverFlowView<T>.d RT;
    private long RU;

    public CoverFlowView(Context context) {
        super(context);
        this.RQ = new c(this, null);
        this.RS = new e(this, null);
        this.RT = new d(this, null);
        this.RU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RQ = new c(this, null);
        this.RS = new e(this, null);
        this.RT = new d(this, null);
        this.RU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RQ = new c(this, null);
        this.RS = new e(this, null);
        this.RT = new d(this, null);
        this.RU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(com.baidu.tbadk.core.flow.a.d<T> dVar) {
        this.RR = dVar;
    }

    private void init(Context context) {
        W(context);
        X(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.RM);
        addView(this.RN);
        this.RO = new a<>(context);
        this.RO.setOnClickListener(this.RS);
        this.RM.setAdapter(this.RO);
        this.RM.setOnPageChangeListener(this.RT);
    }

    private void W(Context context) {
        this.RM = new SquareViewPager(context);
    }

    private void X(Context context) {
        this.RN = new IndicatorView(context);
        this.RN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.RO.a(list, this.RP);
            int size = list.size();
            if (size > 1) {
                this.RN.setVisibility(0);
                this.RN.setCount(size);
                this.RM.setCurrentItem(1, false);
                this.RN.setPosition(0.0f);
                rn();
                return;
            }
            this.RN.setVisibility(8);
            ro();
        }
    }

    public void setCoverFlowFactory(b bVar) {
        if (bVar != null) {
            this.RP = bVar;
            bVar.rl().g(this.RN);
            bVar.rm().a(this.RM);
        }
    }

    public void rn() {
        rp();
    }

    public void ro() {
        this.RQ.removeMessages(1);
    }

    public void rp() {
        this.RQ.removeMessages(1);
        this.RQ.sendEmptyMessageDelayed(1, this.RU);
    }

    public void setMarqueenTime(long j) {
        this.RU = j;
        rp();
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        private c() {
        }

        /* synthetic */ c(CoverFlowView coverFlowView, c cVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.rq();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        int count;
        if (this.RM != null && this.RO != null && (count = this.RO.getCount()) > 1) {
            int currentItem = this.RM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.RM.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.RM.setCurrentItem(1, false);
            } else {
                this.RM.setCurrentItem(currentItem + 1);
            }
            this.RM.invalidate();
        }
    }

    private boolean rr() {
        int count;
        if (this.RO != null && (count = this.RO.getCount()) > 1) {
            int currentItem = this.RM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.RM.setCurrentItem(i, false);
                this.RM.invalidate();
            } else if (currentItem > i) {
                this.RM.setCurrentItem(1, false);
                this.RM.invalidate();
            }
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    class d implements ViewPager.OnPageChangeListener {
        private d() {
        }

        /* synthetic */ d(CoverFlowView coverFlowView, d dVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.RN != null && CoverFlowView.this.RO != null && CoverFlowView.this.RN.getVisibility() == 0) {
                int count = CoverFlowView.this.RO.getCount();
                if (i == 0) {
                    CoverFlowView.this.RN.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.RN.setPosition(f);
                } else {
                    CoverFlowView.this.RN.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.RO != null) {
                int count = CoverFlowView.this.RO.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.RR != null) {
                    CoverFlowView.this.RR.a(i, CoverFlowView.this.RO.bH(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.RM == null || CoverFlowView.this.RO == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.rs();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs() {
        if (rr()) {
            rp();
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        private e() {
        }

        /* synthetic */ e(CoverFlowView coverFlowView, e eVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a bH;
            if (CoverFlowView.this.RR != null && (view.getTag() instanceof Integer) && (bH = CoverFlowView.this.RO.bH((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.RR.m(intValue, bH.rt());
            }
        }
    }

    public void rk() {
        this.RO.rk();
    }

    public void setSwipeControlInterface(t tVar) {
        if (this.RM != null) {
            this.RM.setSwipeControlInterface(tVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.RM != null) {
            this.RM.setDisableParentEvent(z);
        }
    }
}
