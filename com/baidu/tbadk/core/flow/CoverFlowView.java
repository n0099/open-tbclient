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
    private SquareViewPager RO;
    private IndicatorView RP;
    private a<T> RQ;
    private b RR;
    private CoverFlowView<T>.c RS;
    private com.baidu.tbadk.core.flow.a.d<T> RT;
    private CoverFlowView<T>.e RU;
    private CoverFlowView<T>.d RV;
    private long RW;

    public CoverFlowView(Context context) {
        super(context);
        this.RS = new c(this, null);
        this.RU = new e(this, null);
        this.RV = new d(this, null);
        this.RW = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RS = new c(this, null);
        this.RU = new e(this, null);
        this.RV = new d(this, null);
        this.RW = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RS = new c(this, null);
        this.RU = new e(this, null);
        this.RV = new d(this, null);
        this.RW = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(com.baidu.tbadk.core.flow.a.d<T> dVar) {
        this.RT = dVar;
    }

    private void init(Context context) {
        W(context);
        X(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.RO);
        addView(this.RP);
        this.RQ = new a<>(context);
        this.RQ.setOnClickListener(this.RU);
        this.RO.setAdapter(this.RQ);
        this.RO.setOnPageChangeListener(this.RV);
    }

    private void W(Context context) {
        this.RO = new SquareViewPager(context);
    }

    private void X(Context context) {
        this.RP = new IndicatorView(context);
        this.RP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.RQ.a(list, this.RR);
            int size = list.size();
            if (size > 1) {
                this.RP.setVisibility(0);
                this.RP.setCount(size);
                this.RO.setCurrentItem(1, false);
                this.RP.setPosition(0.0f);
                rn();
                return;
            }
            this.RP.setVisibility(8);
            ro();
        }
    }

    public void setCoverFlowFactory(b bVar) {
        if (bVar != null) {
            this.RR = bVar;
            bVar.rl().g(this.RP);
            bVar.rm().a(this.RO);
        }
    }

    public void rn() {
        rp();
    }

    public void ro() {
        this.RS.removeMessages(1);
    }

    public void rp() {
        this.RS.removeMessages(1);
        this.RS.sendEmptyMessageDelayed(1, this.RW);
    }

    public void setMarqueenTime(long j) {
        this.RW = j;
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
        if (this.RO != null && this.RQ != null && (count = this.RQ.getCount()) > 1) {
            int currentItem = this.RO.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.RO.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.RO.setCurrentItem(1, false);
            } else {
                this.RO.setCurrentItem(currentItem + 1);
            }
            this.RO.invalidate();
        }
    }

    private boolean rr() {
        int count;
        if (this.RQ != null && (count = this.RQ.getCount()) > 1) {
            int currentItem = this.RO.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.RO.setCurrentItem(i, false);
                this.RO.invalidate();
            } else if (currentItem > i) {
                this.RO.setCurrentItem(1, false);
                this.RO.invalidate();
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
            if (CoverFlowView.this.RP != null && CoverFlowView.this.RQ != null && CoverFlowView.this.RP.getVisibility() == 0) {
                int count = CoverFlowView.this.RQ.getCount();
                if (i == 0) {
                    CoverFlowView.this.RP.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.RP.setPosition(f);
                } else {
                    CoverFlowView.this.RP.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.RQ != null) {
                int count = CoverFlowView.this.RQ.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.RT != null) {
                    CoverFlowView.this.RT.a(i, CoverFlowView.this.RQ.bH(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.RO == null || CoverFlowView.this.RQ == null) {
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
            if (CoverFlowView.this.RT != null && (view.getTag() instanceof Integer) && (bH = CoverFlowView.this.RQ.bH((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.RT.m(intValue, bH.rt());
            }
        }
    }

    public void rk() {
        this.RQ.rk();
    }

    public void setSwipeControlInterface(t tVar) {
        if (this.RO != null) {
            this.RO.setSwipeControlInterface(tVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.RO != null) {
            this.RO.setDisableParentEvent(z);
        }
    }
}
