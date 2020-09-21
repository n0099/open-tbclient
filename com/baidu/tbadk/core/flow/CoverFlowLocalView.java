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
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean eiL;
    private ListViewPager eiM;
    private IndicatorView eiN;
    private com.baidu.tbadk.core.flow.a.c eiO;
    private CoverFlowLocalAdapter<T> eiP;
    private com.baidu.tbadk.core.flow.a eiQ;
    private CoverFlowLocalView<T>.a eiR;
    private boolean eiS;
    private boolean eiT;
    private boolean eiU;
    private d<T> eiV;
    private CoverFlowLocalView<T>.c eiW;
    private CoverFlowLocalView<T>.b eiX;
    private long eiY;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eiR = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.eiW = new c();
        this.eiX = new b();
        this.eiY = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eiR = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.eiW = new c();
        this.eiX = new b();
        this.eiY = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eiR = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.eiW = new c();
        this.eiX = new b();
        this.eiY = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eiV = dVar;
    }

    private void init(Context context) {
        dQ(context);
        dR(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eiM);
        addView(this.eiN);
        this.eiP = new CoverFlowLocalAdapter<>(context);
        this.eiP.setOnClickListener(this.eiW);
        this.eiM.setAdapter(this.eiP);
        this.eiM.setOnPageChangeListener(this.eiX);
    }

    private void dQ(Context context) {
        this.eiM = new ListViewPager(context);
    }

    private void dR(Context context) {
        this.eiN = new IndicatorView(context);
        this.eiN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eiP.a(list, this.eiQ);
            int size = list.size();
            if (size > 1) {
                this.eiN.setVisibility(0);
                this.eiN.setCount(size);
                this.eiM.setCurrentItem(0, false);
                this.eiN.setPosition(0.0f);
                if (this.eiU) {
                    bix();
                    return;
                }
                return;
            }
            this.eiN.setVisibility(8);
            this.eiN.setCount(size);
            this.eiM.setCurrentItem(0, false);
            this.eiN.setPosition(0.0f);
            biy();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eiQ = aVar;
            this.eiO = aVar.ug();
            this.eiO.g(this.eiN);
            aVar.uf().b(this.eiM);
            this.mCustomView = aVar.biw();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eiM);
                addView(this.mCustomView);
                addView(this.eiN);
            }
        }
    }

    public void bix() {
        biz();
    }

    public void biy() {
        this.eiR.removeMessages(1);
    }

    public void biz() {
        this.eiR.removeMessages(1);
        this.eiR.sendEmptyMessageDelayed(1, this.eiY);
    }

    public void setIndicatorVisible(int i) {
        if (this.eiN != null) {
            this.eiN.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eiY = j;
        biz();
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
                    CoverFlowLocalView.this.biA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        int count;
        if (this.eiM != null && this.eiP != null && (count = this.eiP.getCount()) > 1) {
            int currentItem = this.eiM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eiM.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eiM.setCurrentItem(1, false);
            } else {
                this.eiM.setCurrentItem(currentItem + 1);
            }
            this.eiM.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean biB() {
        int count;
        if (this.eiP == null || !this.eiL || (count = this.eiP.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eiM.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eiM.setCurrentItem(i, false);
            this.eiM.invalidate();
        } else if (currentItem > i) {
            this.eiM.setCurrentItem(1, false);
            this.eiM.invalidate();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.eiN != null && CoverFlowLocalView.this.eiP != null) {
                if (CoverFlowLocalView.this.eiP.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eiV != null) {
                    CoverFlowLocalView.this.eiV.a(1, CoverFlowLocalView.this.eiP.nS(i));
                }
                if (CoverFlowLocalView.this.eiN.getVisibility() == 0 && !CoverFlowLocalView.this.eiS) {
                    if (CoverFlowLocalView.this.eiL) {
                        int count = CoverFlowLocalView.this.eiP.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eiN.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eiN.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eiN.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eiN.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eiP != null) {
                int count = CoverFlowLocalView.this.eiP.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eiS) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eiV != null) {
                        CoverFlowLocalView.this.eiV.a(i, CoverFlowLocalView.this.eiP.nS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eiM != null && CoverFlowLocalView.this.eiP != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eiU) {
                            CoverFlowLocalView.this.biC();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eiT) {
                            CoverFlowLocalView.this.biy();
                            CoverFlowLocalView.this.biB();
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
        if (this.eiL) {
            int count = this.eiP.getCount();
            if (i == 0) {
                this.eiN.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eiN.setPosition(i);
                return;
            } else {
                this.eiN.setPosition(i - 1);
                return;
            }
        }
        this.eiN.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        if (biB()) {
            biz();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eiL = z;
        if (this.eiP != null) {
            this.eiP.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a nS;
            if (CoverFlowLocalView.this.eiV != null && (view.getTag() instanceof Integer) && (nS = CoverFlowLocalView.this.eiP.nS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eiV.e(intValue, nS.bdw());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eiM != null) {
            this.eiM.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eiM != null) {
            this.eiM.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eiS = z;
    }

    public void setPageMargin(int i) {
        if (this.eiM != null) {
            this.eiM.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eiT = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eiT;
    }

    public void setAutoPlay(boolean z) {
        this.eiU = z;
    }
}
