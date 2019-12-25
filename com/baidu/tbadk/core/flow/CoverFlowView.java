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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager cRQ;
    private IndicatorView cRR;
    private com.baidu.tbadk.core.flow.a.c cRS;
    private CoverFlowAdapter<T> cRT;
    private com.baidu.tbadk.core.flow.a cRU;
    private CoverFlowView<T>.a cRV;
    private boolean cRW;
    private boolean cRX;
    private boolean cRY;
    private d<T> cRZ;
    private CoverFlowView<T>.c cSa;
    private CoverFlowView<T>.b cSb;
    private long cSc;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cRV = new a();
        this.cRW = false;
        this.cRX = true;
        this.cRY = true;
        this.cSa = new c();
        this.cSb = new b();
        this.cSc = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cRV = new a();
        this.cRW = false;
        this.cRX = true;
        this.cRY = true;
        this.cSa = new c();
        this.cSb = new b();
        this.cSc = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cRV = new a();
        this.cRW = false;
        this.cRX = true;
        this.cRY = true;
        this.cSa = new c();
        this.cSb = new b();
        this.cSc = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cRZ = dVar;
    }

    private void init(Context context) {
        dG(context);
        dH(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cRQ);
        addView(this.cRR);
        this.cRT = new CoverFlowAdapter<>(context);
        this.cRT.setOnClickListener(this.cSa);
        this.cRQ.setAdapter(this.cRT);
        this.cRQ.setOnPageChangeListener(this.cSb);
    }

    private void dG(Context context) {
        this.cRQ = new ListViewPager(context);
    }

    private void dH(Context context) {
        this.cRR = new IndicatorView(context);
        this.cRR.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T jS(int i) {
        if (this.cRT == null) {
            return null;
        }
        return this.cRT.jS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cRT.a(list, this.cRU);
            int size = list.size();
            if (size > 1) {
                this.cRR.setVisibility(0);
                this.cRR.setCount(size);
                this.cRQ.setCurrentItem(1, false);
                this.cRR.setPosition(0.0f);
                aCr();
                return;
            }
            this.cRR.setVisibility(8);
            this.cRR.setCount(size);
            this.cRQ.setCurrentItem(1, false);
            this.cRR.setPosition(0.0f);
            aCs();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cRU = aVar;
            this.cRS = aVar.aCo();
            this.cRS.g(this.cRR);
            aVar.aCp().b(this.cRQ);
            this.mCustomView = aVar.aCq();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cRQ);
                addView(this.mCustomView);
                addView(this.cRR);
            }
        }
    }

    public void aCr() {
        aCt();
    }

    public void aCs() {
        this.cRV.removeMessages(1);
    }

    public void aCt() {
        this.cRV.removeMessages(1);
        this.cRV.sendEmptyMessageDelayed(1, this.cSc);
    }

    public void setIndicatorVisible(int i) {
        if (this.cRR != null) {
            this.cRR.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cSc = j;
        aCt();
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
                    CoverFlowView.this.aCu();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCu() {
        int count;
        if (this.cRQ != null && this.cRT != null && (count = this.cRT.getCount()) > 1) {
            int currentItem = this.cRQ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cRQ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cRQ.setCurrentItem(1, false);
            } else {
                this.cRQ.setCurrentItem(currentItem + 1);
            }
            this.cRQ.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCv() {
        int count;
        if (this.cRT != null && (count = this.cRT.getCount()) > 1) {
            int currentItem = this.cRQ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cRQ.setCurrentItem(i, false);
                this.cRQ.invalidate();
            } else if (currentItem > i) {
                this.cRQ.setCurrentItem(1, false);
                this.cRQ.invalidate();
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
            if (CoverFlowView.this.cRR != null && CoverFlowView.this.cRT != null) {
                if (CoverFlowView.this.cRT.getCount() == 1 && i == 0 && CoverFlowView.this.cRZ != null) {
                    CoverFlowView.this.cRZ.a(1, CoverFlowView.this.cRT.jS(i));
                }
                if (CoverFlowView.this.cRR.getVisibility() == 0 && !CoverFlowView.this.cRW) {
                    int count = CoverFlowView.this.cRT.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cRR.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cRR.setPosition(f);
                    } else {
                        CoverFlowView.this.cRR.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cRT != null) {
                int count = CoverFlowView.this.cRT.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cRW) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cRZ != null) {
                        CoverFlowView.this.cRZ.a(i, CoverFlowView.this.cRT.jS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cRQ != null && CoverFlowView.this.cRT != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cRY) {
                            CoverFlowView.this.aCw();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cRY = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cRY) {
                            CoverFlowView.this.aCs();
                            CoverFlowView.this.aCv();
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
        int count = this.cRT.getCount();
        if (i == 0) {
            this.cRR.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cRR.setPosition(i);
        } else {
            this.cRR.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCw() {
        if (aCv()) {
            aCt();
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
            com.baidu.tbadk.core.flow.a.a jS;
            if (CoverFlowView.this.cRZ != null && (view.getTag() instanceof Integer) && (jS = CoverFlowView.this.cRT.jS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cRZ.M(intValue, jS.axS());
            }
        }
    }

    public void onChangeSkinType() {
        this.cRT.onChangeSkinType();
        if (this.cRR != null && this.cRS != null) {
            this.cRR.setDrawable(am.getDrawable(this.cRS.aCx()));
            this.cRR.setSelector(am.getDrawable(this.cRS.aCy()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cRQ != null) {
            this.cRQ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cRQ != null) {
            this.cRQ.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cRW = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cRX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cRX;
    }

    private void setAutoPlay(boolean z) {
        this.cRY = z;
    }
}
