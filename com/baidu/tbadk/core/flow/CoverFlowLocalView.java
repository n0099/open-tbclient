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
/* loaded from: classes2.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean egA;
    private boolean egB;
    private d<T> egC;
    private CoverFlowLocalView<T>.c egD;
    private CoverFlowLocalView<T>.b egE;
    private long egF;
    private boolean egs;
    private ListViewPager egt;
    private IndicatorView egu;
    private com.baidu.tbadk.core.flow.a.c egv;
    private CoverFlowLocalAdapter<T> egw;
    private com.baidu.tbadk.core.flow.a egx;
    private CoverFlowLocalView<T>.a egy;
    private boolean egz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.egy = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egD = new c();
        this.egE = new b();
        this.egF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.egy = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egD = new c();
        this.egE = new b();
        this.egF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.egy = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egD = new c();
        this.egE = new b();
        this.egF = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.egC = dVar;
    }

    private void init(Context context) {
        dR(context);
        dS(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.egt);
        addView(this.egu);
        this.egw = new CoverFlowLocalAdapter<>(context);
        this.egw.setOnClickListener(this.egD);
        this.egt.setAdapter(this.egw);
        this.egt.setOnPageChangeListener(this.egE);
    }

    private void dR(Context context) {
        this.egt = new ListViewPager(context);
    }

    private void dS(Context context) {
        this.egu = new IndicatorView(context);
        this.egu.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.egw.a(list, this.egx);
            int size = list.size();
            if (size > 1) {
                this.egu.setVisibility(0);
                this.egu.setCount(size);
                this.egt.setCurrentItem(0, false);
                this.egu.setPosition(0.0f);
                if (this.egB) {
                    bhD();
                    return;
                }
                return;
            }
            this.egu.setVisibility(8);
            this.egu.setCount(size);
            this.egt.setCurrentItem(0, false);
            this.egu.setPosition(0.0f);
            bhE();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.egx = aVar;
            this.egv = aVar.ua();
            this.egv.g(this.egu);
            aVar.tZ().b(this.egt);
            this.mCustomView = aVar.bhC();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.egt);
                addView(this.mCustomView);
                addView(this.egu);
            }
        }
    }

    public void bhD() {
        bhF();
    }

    public void bhE() {
        this.egy.removeMessages(1);
    }

    public void bhF() {
        this.egy.removeMessages(1);
        this.egy.sendEmptyMessageDelayed(1, this.egF);
    }

    public void setIndicatorVisible(int i) {
        if (this.egu != null) {
            this.egu.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.egF = j;
        bhF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
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
        if (this.egt != null && this.egw != null && (count = this.egw.getCount()) > 1) {
            int currentItem = this.egt.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.egt.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.egt.setCurrentItem(1, false);
            } else {
                this.egt.setCurrentItem(currentItem + 1);
            }
            this.egt.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhH() {
        int count;
        if (this.egw == null || !this.egs || (count = this.egw.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.egt.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.egt.setCurrentItem(i, false);
            this.egt.invalidate();
        } else if (currentItem > i) {
            this.egt.setCurrentItem(1, false);
            this.egt.invalidate();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.egu != null && CoverFlowLocalView.this.egw != null) {
                if (CoverFlowLocalView.this.egw.getCount() == 1 && i == 0 && CoverFlowLocalView.this.egC != null) {
                    CoverFlowLocalView.this.egC.a(1, CoverFlowLocalView.this.egw.nG(i));
                }
                if (CoverFlowLocalView.this.egu.getVisibility() == 0 && !CoverFlowLocalView.this.egz) {
                    if (CoverFlowLocalView.this.egs) {
                        int count = CoverFlowLocalView.this.egw.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.egu.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.egu.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.egu.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.egu.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.egw != null) {
                int count = CoverFlowLocalView.this.egw.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.egz) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.egC != null) {
                        CoverFlowLocalView.this.egC.a(i, CoverFlowLocalView.this.egw.nG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.egt != null && CoverFlowLocalView.this.egw != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.egB) {
                            CoverFlowLocalView.this.bhI();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.egA) {
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
        if (this.egs) {
            int count = this.egw.getCount();
            if (i == 0) {
                this.egu.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.egu.setPosition(i);
                return;
            } else {
                this.egu.setPosition(i - 1);
                return;
            }
        }
        this.egu.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        if (bhH()) {
            bhF();
        }
    }

    public void setCanRepeat(boolean z) {
        this.egs = z;
        if (this.egw != null) {
            this.egw.setCanRepeat(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a nG;
            if (CoverFlowLocalView.this.egC != null && (view.getTag() instanceof Integer) && (nG = CoverFlowLocalView.this.egw.nG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.egC.e(intValue, nG.bcC());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.egt != null) {
            this.egt.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.egt != null) {
            this.egt.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.egz = z;
    }

    public void setPageMargin(int i) {
        if (this.egt != null) {
            this.egt.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.egA = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.egA;
    }

    public void setAutoPlay(boolean z) {
        this.egB = z;
    }
}
