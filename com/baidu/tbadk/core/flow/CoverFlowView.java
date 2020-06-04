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
    private ListViewPager dJK;
    private IndicatorView dJL;
    private com.baidu.tbadk.core.flow.a.c dJM;
    private CoverFlowAdapter<T> dJN;
    private com.baidu.tbadk.core.flow.a dJO;
    private CoverFlowView<T>.a dJP;
    private boolean dJQ;
    private boolean dJR;
    private boolean dJS;
    private d<T> dJT;
    private CoverFlowView<T>.c dJU;
    private CoverFlowView<T>.b dJV;
    private long dJW;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.dJP = new a();
        this.dJQ = false;
        this.dJR = true;
        this.dJS = true;
        this.dJU = new c();
        this.dJV = new b();
        this.dJW = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.dJP = new a();
        this.dJQ = false;
        this.dJR = true;
        this.dJS = true;
        this.dJU = new c();
        this.dJV = new b();
        this.dJW = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.dJP = new a();
        this.dJQ = false;
        this.dJR = true;
        this.dJS = true;
        this.dJU = new c();
        this.dJV = new b();
        this.dJW = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.dJT = dVar;
    }

    private void init(Context context) {
        dD(context);
        dE(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.dJK);
        addView(this.dJL);
        this.dJN = new CoverFlowAdapter<>(context);
        this.dJN.setOnClickListener(this.dJU);
        this.dJK.setAdapter(this.dJN);
        this.dJK.setOnPageChangeListener(this.dJV);
    }

    private void dD(Context context) {
        this.dJK = new ListViewPager(context);
    }

    private void dE(Context context) {
        this.dJL = new IndicatorView(context);
        this.dJL.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kS(int i) {
        if (this.dJN == null) {
            return null;
        }
        return this.dJN.kS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.dJN.a(list, this.dJO);
            int size = list.size();
            if (size > 1) {
                this.dJL.setVisibility(0);
                this.dJL.setCount(size);
                this.dJK.setCurrentItem(1, false);
                this.dJL.setPosition(0.0f);
                aTq();
                return;
            }
            this.dJL.setVisibility(8);
            this.dJL.setCount(size);
            this.dJK.setCurrentItem(1, false);
            this.dJL.setPosition(0.0f);
            aTr();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.dJO = aVar;
            this.dJM = aVar.aTn();
            this.dJM.g(this.dJL);
            aVar.aTo().b(this.dJK);
            this.mCustomView = aVar.aTp();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.dJK);
                addView(this.mCustomView);
                addView(this.dJL);
            }
        }
    }

    public void aTq() {
        aTs();
    }

    public void aTr() {
        this.dJP.removeMessages(1);
    }

    public void aTs() {
        this.dJP.removeMessages(1);
        this.dJP.sendEmptyMessageDelayed(1, this.dJW);
    }

    public void setIndicatorVisible(int i) {
        if (this.dJL != null) {
            this.dJL.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.dJW = j;
        aTs();
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
                    CoverFlowView.this.aTt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTt() {
        int count;
        if (this.dJK != null && this.dJN != null && (count = this.dJN.getCount()) > 1) {
            int currentItem = this.dJK.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dJK.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.dJK.setCurrentItem(1, false);
            } else {
                this.dJK.setCurrentItem(currentItem + 1);
            }
            this.dJK.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTu() {
        int count;
        if (this.dJN != null && (count = this.dJN.getCount()) > 1) {
            int currentItem = this.dJK.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dJK.setCurrentItem(i, false);
                this.dJK.invalidate();
            } else if (currentItem > i) {
                this.dJK.setCurrentItem(1, false);
                this.dJK.invalidate();
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
            if (CoverFlowView.this.dJL != null && CoverFlowView.this.dJN != null) {
                if (CoverFlowView.this.dJN.getCount() == 1 && i == 0 && CoverFlowView.this.dJT != null) {
                    CoverFlowView.this.dJT.a(1, CoverFlowView.this.dJN.kS(i));
                }
                if (CoverFlowView.this.dJL.getVisibility() == 0 && !CoverFlowView.this.dJQ) {
                    int count = CoverFlowView.this.dJN.getCount();
                    if (i == 0) {
                        CoverFlowView.this.dJL.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.dJL.setPosition(f);
                    } else {
                        CoverFlowView.this.dJL.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.dJN != null) {
                int count = CoverFlowView.this.dJN.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.dJQ) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.dJT != null) {
                        CoverFlowView.this.dJT.a(i, CoverFlowView.this.dJN.kS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.dJK != null && CoverFlowView.this.dJN != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.dJS) {
                            CoverFlowView.this.aTv();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.dJS = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.dJS) {
                            CoverFlowView.this.aTr();
                            CoverFlowView.this.aTu();
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
        int count = this.dJN.getCount();
        if (i == 0) {
            this.dJL.setPosition(0.0f);
        } else if (i == count - 1) {
            this.dJL.setPosition(i);
        } else {
            this.dJL.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTv() {
        if (aTu()) {
            aTs();
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
            com.baidu.tbadk.core.flow.a.a kS;
            if (CoverFlowView.this.dJT != null && (view.getTag() instanceof Integer) && (kS = CoverFlowView.this.dJN.kS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.dJT.am(intValue, kS.aOK());
            }
        }
    }

    public void onChangeSkinType() {
        this.dJN.onChangeSkinType();
        if (this.dJL != null && this.dJM != null) {
            this.dJL.setDrawable(am.getDrawable(this.dJM.aTw()));
            this.dJL.setSelector(am.getDrawable(this.dJM.aTx()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.dJK != null) {
            this.dJK.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.dJK != null) {
            this.dJK.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.dJQ = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.dJR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.dJR;
    }

    private void setAutoPlay(boolean z) {
        this.dJS = z;
    }
}
