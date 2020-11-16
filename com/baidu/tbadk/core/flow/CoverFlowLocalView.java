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
    private boolean eIh;
    private ListViewPager eIi;
    private IndicatorView eIj;
    private com.baidu.tbadk.core.flow.a.c eIk;
    private CoverFlowLocalAdapter<T> eIl;
    private com.baidu.tbadk.core.flow.a eIm;
    private CoverFlowLocalView<T>.a eIn;
    private boolean eIo;
    private boolean eIp;
    private boolean eIq;
    private d<T> eIr;
    private CoverFlowLocalView<T>.c eIs;
    private CoverFlowLocalView<T>.b eIt;
    private long eIu;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eIn = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIs = new c();
        this.eIt = new b();
        this.eIu = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eIn = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIs = new c();
        this.eIt = new b();
        this.eIu = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eIn = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIs = new c();
        this.eIt = new b();
        this.eIu = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eIr = dVar;
    }

    private void init(Context context) {
        dW(context);
        dX(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eIi);
        addView(this.eIj);
        this.eIl = new CoverFlowLocalAdapter<>(context);
        this.eIl.setOnClickListener(this.eIs);
        this.eIi.setAdapter(this.eIl);
        this.eIi.setOnPageChangeListener(this.eIt);
    }

    private void dW(Context context) {
        this.eIi = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eIj = new IndicatorView(context);
        this.eIj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eIl.a(list, this.eIm);
            int size = list.size();
            if (size > 1) {
                this.eIj.setVisibility(0);
                this.eIj.setCount(size);
                this.eIi.setCurrentItem(0, false);
                this.eIj.setPosition(0.0f);
                if (this.eIq) {
                    boM();
                    return;
                }
                return;
            }
            this.eIj.setVisibility(8);
            this.eIj.setCount(size);
            this.eIi.setCurrentItem(0, false);
            this.eIj.setPosition(0.0f);
            boN();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eIm = aVar;
            this.eIk = aVar.ug();
            this.eIk.g(this.eIj);
            aVar.uf().b(this.eIi);
            this.mCustomView = aVar.boL();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eIi);
                addView(this.mCustomView);
                addView(this.eIj);
            }
        }
    }

    public void boM() {
        boO();
    }

    public void boN() {
        this.eIn.removeMessages(1);
    }

    public void boO() {
        this.eIn.removeMessages(1);
        this.eIn.sendEmptyMessageDelayed(1, this.eIu);
    }

    public void setIndicatorVisible(int i) {
        if (this.eIj != null) {
            this.eIj.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eIu = j;
        boO();
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
                    CoverFlowLocalView.this.boP();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boP() {
        int count;
        if (this.eIi != null && this.eIl != null && (count = this.eIl.getCount()) > 1) {
            int currentItem = this.eIi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eIi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eIi.setCurrentItem(1, false);
            } else {
                this.eIi.setCurrentItem(currentItem + 1);
            }
            this.eIi.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boQ() {
        int count;
        if (this.eIl == null || !this.eIh || (count = this.eIl.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eIi.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eIi.setCurrentItem(i, false);
            this.eIi.invalidate();
        } else if (currentItem > i) {
            this.eIi.setCurrentItem(1, false);
            this.eIi.invalidate();
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
            if (CoverFlowLocalView.this.eIj != null && CoverFlowLocalView.this.eIl != null) {
                if (CoverFlowLocalView.this.eIl.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eIr != null) {
                    CoverFlowLocalView.this.eIr.a(1, CoverFlowLocalView.this.eIl.pf(i));
                }
                if (CoverFlowLocalView.this.eIj.getVisibility() == 0 && !CoverFlowLocalView.this.eIo) {
                    if (CoverFlowLocalView.this.eIh) {
                        int count = CoverFlowLocalView.this.eIl.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eIj.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eIj.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eIj.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eIj.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eIl != null) {
                int count = CoverFlowLocalView.this.eIl.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eIo) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eIr != null) {
                        CoverFlowLocalView.this.eIr.a(i, CoverFlowLocalView.this.eIl.pf(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eIi != null && CoverFlowLocalView.this.eIl != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eIq) {
                            CoverFlowLocalView.this.boR();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eIp) {
                            CoverFlowLocalView.this.boN();
                            CoverFlowLocalView.this.boQ();
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
        if (this.eIh) {
            int count = this.eIl.getCount();
            if (i == 0) {
                this.eIj.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eIj.setPosition(i);
                return;
            } else {
                this.eIj.setPosition(i - 1);
                return;
            }
        }
        this.eIj.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boR() {
        if (boQ()) {
            boO();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eIh = z;
        if (this.eIl != null) {
            this.eIl.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a pf;
            if (CoverFlowLocalView.this.eIr != null && (view.getTag() instanceof Integer) && (pf = CoverFlowLocalView.this.eIl.pf((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eIr.e(intValue, pf.bjA());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eIi != null) {
            this.eIi.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eIi != null) {
            this.eIi.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eIo = z;
    }

    public void setPageMargin(int i) {
        if (this.eIi != null) {
            this.eIi.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eIp = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eIp;
    }

    public void setAutoPlay(boolean z) {
        this.eIq = z;
    }
}
