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
    private CoverFlowLocalAdapter<T> egA;
    private com.baidu.tbadk.core.flow.a egB;
    private CoverFlowLocalView<T>.a egC;
    private boolean egD;
    private boolean egE;
    private boolean egF;
    private d<T> egG;
    private CoverFlowLocalView<T>.c egH;
    private CoverFlowLocalView<T>.b egI;
    private long egJ;
    private boolean egw;
    private ListViewPager egx;
    private IndicatorView egy;
    private com.baidu.tbadk.core.flow.a.c egz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.egC = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egH = new c();
        this.egI = new b();
        this.egJ = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.egC = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egH = new c();
        this.egI = new b();
        this.egJ = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.egC = new a();
        this.egD = false;
        this.egE = true;
        this.egF = true;
        this.egH = new c();
        this.egI = new b();
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
        this.egA = new CoverFlowLocalAdapter<>(context);
        this.egA.setOnClickListener(this.egH);
        this.egx.setAdapter(this.egA);
        this.egx.setOnPageChangeListener(this.egI);
    }

    private void dR(Context context) {
        this.egx = new ListViewPager(context);
    }

    private void dS(Context context) {
        this.egy = new IndicatorView(context);
        this.egy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.egA.a(list, this.egB);
            int size = list.size();
            if (size > 1) {
                this.egy.setVisibility(0);
                this.egy.setCount(size);
                this.egx.setCurrentItem(0, false);
                this.egy.setPosition(0.0f);
                if (this.egF) {
                    bhD();
                    return;
                }
                return;
            }
            this.egy.setVisibility(8);
            this.egy.setCount(size);
            this.egx.setCurrentItem(0, false);
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
        this.egC.removeMessages(1);
    }

    public void bhF() {
        this.egC.removeMessages(1);
        this.egC.sendEmptyMessageDelayed(1, this.egJ);
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
                    CoverFlowLocalView.this.bhG();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhG() {
        int count;
        if (this.egx != null && this.egA != null && (count = this.egA.getCount()) > 1) {
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
        if (this.egA == null || !this.egw || (count = this.egA.getCount()) <= 1) {
            return false;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.egy != null && CoverFlowLocalView.this.egA != null) {
                if (CoverFlowLocalView.this.egA.getCount() == 1 && i == 0 && CoverFlowLocalView.this.egG != null) {
                    CoverFlowLocalView.this.egG.a(1, CoverFlowLocalView.this.egA.nG(i));
                }
                if (CoverFlowLocalView.this.egy.getVisibility() == 0 && !CoverFlowLocalView.this.egD) {
                    if (CoverFlowLocalView.this.egw) {
                        int count = CoverFlowLocalView.this.egA.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.egy.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.egy.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.egy.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.egy.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.egA != null) {
                int count = CoverFlowLocalView.this.egA.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.egD) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.egG != null) {
                        CoverFlowLocalView.this.egG.a(i, CoverFlowLocalView.this.egA.nG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.egx != null && CoverFlowLocalView.this.egA != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.egF) {
                            CoverFlowLocalView.this.bhI();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.egE) {
                            CoverFlowLocalView.this.bhE();
                            CoverFlowLocalView.this.bhH();
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
        if (this.egw) {
            int count = this.egA.getCount();
            if (i == 0) {
                this.egy.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.egy.setPosition(i);
                return;
            } else {
                this.egy.setPosition(i - 1);
                return;
            }
        }
        this.egy.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        if (bhH()) {
            bhF();
        }
    }

    public void setCanRepeat(boolean z) {
        this.egw = z;
        if (this.egA != null) {
            this.egA.setCanRepeat(z);
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
            if (CoverFlowLocalView.this.egG != null && (view.getTag() instanceof Integer) && (nG = CoverFlowLocalView.this.egA.nG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.egG.e(intValue, nG.bcC());
            }
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
