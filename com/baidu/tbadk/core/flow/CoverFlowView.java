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
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager eiM;
    private IndicatorView eiN;
    private com.baidu.tbadk.core.flow.a.c eiO;
    private com.baidu.tbadk.core.flow.a eiQ;
    private boolean eiS;
    private boolean eiT;
    private boolean eiU;
    private d<T> eiV;
    private long eiY;
    private CoverFlowAdapter<T> eja;
    private CoverFlowView<T>.a ejb;
    private CoverFlowView<T>.c ejc;
    private CoverFlowView<T>.b ejd;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ejb = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.ejc = new c();
        this.ejd = new b();
        this.eiY = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ejb = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.ejc = new c();
        this.ejd = new b();
        this.eiY = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ejb = new a();
        this.eiS = false;
        this.eiT = true;
        this.eiU = true;
        this.ejc = new c();
        this.ejd = new b();
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
        this.eja = new CoverFlowAdapter<>(context);
        this.eja.setOnClickListener(this.ejc);
        this.eiM.setAdapter(this.eja);
        this.eiM.setOnPageChangeListener(this.ejd);
    }

    private void dQ(Context context) {
        this.eiM = new ListViewPager(context);
    }

    private void dR(Context context) {
        this.eiN = new IndicatorView(context);
        this.eiN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T nS(int i) {
        if (this.eja == null) {
            return null;
        }
        return this.eja.nS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eja.a(list, this.eiQ);
            int size = list.size();
            if (size > 1) {
                this.eiN.setVisibility(0);
                this.eiN.setCount(size);
                this.eiM.setCurrentItem(1, false);
                this.eiN.setPosition(0.0f);
                if (this.eiU) {
                    bix();
                    return;
                }
                return;
            }
            this.eiN.setVisibility(8);
            this.eiN.setCount(size);
            this.eiM.setCurrentItem(1, false);
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
        this.ejb.removeMessages(1);
    }

    public void biz() {
        this.ejb.removeMessages(1);
        this.ejb.sendEmptyMessageDelayed(1, this.eiY);
    }

    public void ue() {
        if (!this.ejb.hasMessages(1)) {
            bix();
        }
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
                    CoverFlowView.this.biA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        int count;
        if (this.eiM != null && this.eja != null && (count = this.eja.getCount()) > 1) {
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
        if (this.eja != null && (count = this.eja.getCount()) > 1) {
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
            if (CoverFlowView.this.eiN != null && CoverFlowView.this.eja != null) {
                if (CoverFlowView.this.eja.getCount() == 1 && i == 0 && CoverFlowView.this.eiV != null) {
                    CoverFlowView.this.eiV.a(1, CoverFlowView.this.eja.nS(i));
                }
                if (CoverFlowView.this.eiN.getVisibility() == 0 && !CoverFlowView.this.eiS) {
                    int count = CoverFlowView.this.eja.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eiN.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eiN.setPosition(f);
                    } else {
                        CoverFlowView.this.eiN.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eja != null) {
                int count = CoverFlowView.this.eja.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eiS) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eiV != null) {
                        CoverFlowView.this.eiV.a(i, CoverFlowView.this.eja.nS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eiM != null && CoverFlowView.this.eja != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eiU) {
                            CoverFlowView.this.biC();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eiT) {
                            CoverFlowView.this.biy();
                            CoverFlowView.this.biB();
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
        int count = this.eja.getCount();
        if (i == 0) {
            this.eiN.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eiN.setPosition(i);
        } else {
            this.eiN.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        if (biB()) {
            biz();
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
            if (CoverFlowView.this.eiV != null && (view.getTag() instanceof Integer) && (nS = CoverFlowView.this.eja.nS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eiV.e(intValue, nS.bdw());
            }
        }
    }

    public void onChangeSkinType() {
        this.eja.onChangeSkinType();
        if (this.eiN != null && this.eiO != null) {
            this.eiN.setDrawable(ap.getDrawable(this.eiO.biD()));
            this.eiN.setSelector(ap.getDrawable(this.eiO.biE()));
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

    public void a(e eVar) {
        if (eVar != null && this.eiM != null) {
            eVar.b(this.eiM);
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
