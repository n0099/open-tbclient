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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager adM;
    private IndicatorView adN;
    private com.baidu.tbadk.core.flow.a.c adO;
    private CoverFlowAdapter<T> adP;
    private com.baidu.tbadk.core.flow.a adQ;
    private CoverFlowView<T>.a adR;
    private d<T> adS;
    private CoverFlowView<T>.c adT;
    private CoverFlowView<T>.b adU;
    private long adV;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.adR = new a();
        this.adT = new c();
        this.adU = new b();
        this.adV = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.adR = new a();
        this.adT = new c();
        this.adU = new b();
        this.adV = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.adR = new a();
        this.adT = new c();
        this.adU = new b();
        this.adV = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.adS = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.adM);
        addView(this.adN);
        this.adP = new CoverFlowAdapter<>(context);
        this.adP.setOnClickListener(this.adT);
        this.adM.setAdapter(this.adP);
        this.adM.setOnPageChangeListener(this.adU);
    }

    private void at(Context context) {
        this.adM = new ListViewPager(context);
    }

    private void au(Context context) {
        this.adN = new IndicatorView(context);
        this.adN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cq(int i) {
        if (this.adP == null) {
            return null;
        }
        return this.adP.cq(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.adP.a(list, this.adQ);
            int size = list.size();
            if (size > 1) {
                this.adN.setVisibility(0);
                this.adN.setCount(size);
                this.adM.setCurrentItem(1, false);
                this.adN.setPosition(0.0f);
                tR();
                return;
            }
            this.adN.setVisibility(8);
            tS();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.adQ = aVar;
            this.adO = aVar.tO();
            this.adO.g(this.adN);
            aVar.tP().a(this.adM);
            this.mCustomView = aVar.tQ();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.adM);
                addView(this.mCustomView);
                addView(this.adN);
            }
        }
    }

    public void tR() {
        tT();
    }

    public void tS() {
        this.adR.removeMessages(1);
    }

    public void tT() {
        this.adR.removeMessages(1);
        this.adR.sendEmptyMessageDelayed(1, this.adV);
    }

    public void setMarqueenTime(long j) {
        this.adV = j;
        tT();
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
                    CoverFlowView.this.tU();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tU() {
        int count;
        if (this.adM != null && this.adP != null && (count = this.adP.getCount()) > 1) {
            int currentItem = this.adM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.adM.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.adM.setCurrentItem(1, false);
            } else {
                this.adM.setCurrentItem(currentItem + 1);
            }
            this.adM.invalidate();
        }
    }

    private boolean tV() {
        int count;
        if (this.adP != null && (count = this.adP.getCount()) > 1) {
            int currentItem = this.adM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.adM.setCurrentItem(i, false);
                this.adM.invalidate();
            } else if (currentItem > i) {
                this.adM.setCurrentItem(1, false);
                this.adM.invalidate();
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

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.adN != null && CoverFlowView.this.adP != null && CoverFlowView.this.adN.getVisibility() == 0) {
                int count = CoverFlowView.this.adP.getCount();
                if (i == 0) {
                    CoverFlowView.this.adN.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.adN.setPosition(f);
                } else {
                    CoverFlowView.this.adN.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.adP != null) {
                int count = CoverFlowView.this.adP.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.adS != null) {
                    CoverFlowView.this.adS.a(i, CoverFlowView.this.adP.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.adM != null && CoverFlowView.this.adP != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tW();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW() {
        if (tV()) {
            tT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a cq;
            if (CoverFlowView.this.adS != null && (view2.getTag() instanceof Integer) && (cq = CoverFlowView.this.adP.cq((intValue = ((Integer) view2.getTag()).intValue()))) != null) {
                CoverFlowView.this.adS.f(intValue, cq.qB());
            }
        }
    }

    public void onChangeSkinType() {
        this.adP.onChangeSkinType();
        if (this.adN != null && this.adO != null) {
            this.adN.setDrawable(ak.getDrawable(this.adO.tX()));
            this.adN.setSelector(ak.getDrawable(this.adO.tY()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.adM != null) {
            this.adM.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.adM != null) {
            this.adM.setDisableParentEvent(z);
        }
    }
}
