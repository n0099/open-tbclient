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
    private com.baidu.tbadk.core.flow.a egB;
    private boolean egD;
    private boolean egE;
    private boolean egF;
    private d<T> egG;
    private long egJ;
    private CoverFlowAdapter<T> egL;
    private CoverFlowView<T>.a egM;
    private CoverFlowView<T>.c egN;
    private CoverFlowView<T>.b egO;
    private ListViewPager egx;
    private IndicatorView egy;
    private com.baidu.tbadk.core.flow.a.c egz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.egM = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egN = new c();
        this.egO = new b();
        this.egJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.egM = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egN = new c();
        this.egO = new b();
        this.egJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.egM = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egN = new c();
        this.egO = new b();
        this.egJ = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.egG = dVar;
    }

    private void init(Context context) {
        dR(context);
        dS(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.egx);
        addView(this.egy);
        this.egL = new CoverFlowAdapter<>(context);
        this.egL.setOnClickListener(this.egN);
        this.egx.setAdapter(this.egL);
        this.egx.setOnPageChangeListener(this.egO);
    }

    private void dR(Context context) {
        this.egx = new ListViewPager(context);
    }

    private void dS(Context context) {
        this.egy = new IndicatorView(context);
        this.egy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T nG(int i) {
        if (this.egL == null) {
            return null;
        }
        return this.egL.nG(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.egL.a(list, this.egB);
            int size = list.size();
            if (size > 1) {
                this.egy.setVisibility(0);
                this.egy.setCount(size);
                this.egx.setCurrentItem(1, false);
                this.egy.setPosition(0.0f);
                if (this.egF) {
                    bhD();
                    return;
                }
                return;
            }
            this.egy.setVisibility(8);
            this.egy.setCount(size);
            this.egx.setCurrentItem(1, false);
            this.egy.setPosition(0.0f);
            bhE();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.egB = aVar;
            this.egz = aVar.ua();
            this.egz.g(this.egy);
            aVar.tZ().b(this.egx);
            this.mCustomView = aVar.bhC();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.egx);
                addView(this.mCustomView);
                addView(this.egy);
            }
        }
    }

    public void bhD() {
        bhF();
    }

    public void bhE() {
        this.egM.removeMessages(1);
    }

    public void bhF() {
        this.egM.removeMessages(1);
        this.egM.sendEmptyMessageDelayed(1, this.egJ);
    }

    public void tY() {
        if (!this.egM.hasMessages(1)) {
            bhD();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.egy != null) {
            this.egy.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.egJ = j;
        bhF();
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
                    CoverFlowView.this.bhG();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhG() {
        int count;
        if (this.egx != null && this.egL != null && (count = this.egL.getCount()) > 1) {
            int currentItem = this.egx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.egx.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.egx.setCurrentItem(1, false);
            } else {
                this.egx.setCurrentItem(currentItem + 1);
            }
            this.egx.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhH() {
        int count;
        if (this.egL != null && (count = this.egL.getCount()) > 1) {
            int currentItem = this.egx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.egx.setCurrentItem(i, false);
                this.egx.invalidate();
            } else if (currentItem > i) {
                this.egx.setCurrentItem(1, false);
                this.egx.invalidate();
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
            if (CoverFlowView.this.egy != null && CoverFlowView.this.egL != null) {
                if (CoverFlowView.this.egL.getCount() == 1 && i == 0 && CoverFlowView.this.egG != null) {
                    CoverFlowView.this.egG.a(1, CoverFlowView.this.egL.nG(i));
                }
                if (CoverFlowView.this.egy.getVisibility() == 0 && !CoverFlowView.this.egD) {
                    int count = CoverFlowView.this.egL.getCount();
                    if (i == 0) {
                        CoverFlowView.this.egy.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.egy.setPosition(f);
                    } else {
                        CoverFlowView.this.egy.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.egL != null) {
                int count = CoverFlowView.this.egL.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.egD) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.egG != null) {
                        CoverFlowView.this.egG.a(i, CoverFlowView.this.egL.nG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.egx != null && CoverFlowView.this.egL != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.egF) {
                            CoverFlowView.this.bhI();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.egE) {
                            CoverFlowView.this.bhE();
                            CoverFlowView.this.bhH();
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
        int count = this.egL.getCount();
        if (i == 0) {
            this.egy.setPosition(0.0f);
        } else if (i == count - 1) {
            this.egy.setPosition(i);
        } else {
            this.egy.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        if (bhH()) {
            bhF();
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
            com.baidu.tbadk.core.flow.a.a nG;
            if (CoverFlowView.this.egG != null && (view.getTag() instanceof Integer) && (nG = CoverFlowView.this.egL.nG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.egG.e(intValue, nG.bcC());
            }
        }
    }

    public void onChangeSkinType() {
        this.egL.onChangeSkinType();
        if (this.egy != null && this.egz != null) {
            this.egy.setDrawable(ap.getDrawable(this.egz.bhJ()));
            this.egy.setSelector(ap.getDrawable(this.egz.bhK()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.egx != null) {
            this.egx.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.egx != null) {
            this.egx.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.egD = z;
    }

    public void setPageMargin(int i) {
        if (this.egx != null) {
            this.egx.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.egx != null) {
            eVar.b(this.egx);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.egE = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.egE;
    }

    public void setAutoPlay(boolean z) {
        this.egF = z;
    }
}
