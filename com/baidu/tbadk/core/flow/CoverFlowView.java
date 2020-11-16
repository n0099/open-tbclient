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
    private ListViewPager eIi;
    private IndicatorView eIj;
    private com.baidu.tbadk.core.flow.a.c eIk;
    private com.baidu.tbadk.core.flow.a eIm;
    private boolean eIo;
    private boolean eIp;
    private boolean eIq;
    private d<T> eIr;
    private long eIu;
    private CoverFlowAdapter<T> eIw;
    private CoverFlowView<T>.a eIx;
    private CoverFlowView<T>.c eIy;
    private CoverFlowView<T>.b eIz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eIx = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIy = new c();
        this.eIz = new b();
        this.eIu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eIx = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIy = new c();
        this.eIz = new b();
        this.eIu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eIx = new a();
        this.eIo = false;
        this.eIp = true;
        this.eIq = true;
        this.eIy = new c();
        this.eIz = new b();
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
        this.eIw = new CoverFlowAdapter<>(context);
        this.eIw.setOnClickListener(this.eIy);
        this.eIi.setAdapter(this.eIw);
        this.eIi.setOnPageChangeListener(this.eIz);
    }

    private void dW(Context context) {
        this.eIi = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eIj = new IndicatorView(context);
        this.eIj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T pf(int i) {
        if (this.eIw == null) {
            return null;
        }
        return this.eIw.pf(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eIw.a(list, this.eIm);
            int size = list.size();
            if (size > 1) {
                this.eIj.setVisibility(0);
                this.eIj.setCount(size);
                this.eIi.setCurrentItem(1, false);
                this.eIj.setPosition(0.0f);
                if (this.eIq) {
                    boM();
                    return;
                }
                return;
            }
            this.eIj.setVisibility(8);
            this.eIj.setCount(size);
            this.eIi.setCurrentItem(1, false);
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
        this.eIx.removeMessages(1);
    }

    public void boO() {
        this.eIx.removeMessages(1);
        this.eIx.sendEmptyMessageDelayed(1, this.eIu);
    }

    public void ue() {
        if (!this.eIx.hasMessages(1)) {
            boM();
        }
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
                    CoverFlowView.this.boP();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boP() {
        int count;
        if (this.eIi != null && this.eIw != null && (count = this.eIw.getCount()) > 1) {
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
        if (this.eIw != null && (count = this.eIw.getCount()) > 1) {
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
            if (CoverFlowView.this.eIj != null && CoverFlowView.this.eIw != null) {
                if (CoverFlowView.this.eIw.getCount() == 1 && i == 0 && CoverFlowView.this.eIr != null) {
                    CoverFlowView.this.eIr.a(1, CoverFlowView.this.eIw.pf(i));
                }
                if (CoverFlowView.this.eIj.getVisibility() == 0 && !CoverFlowView.this.eIo) {
                    int count = CoverFlowView.this.eIw.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eIj.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eIj.setPosition(f);
                    } else {
                        CoverFlowView.this.eIj.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eIw != null) {
                int count = CoverFlowView.this.eIw.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eIo) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eIr != null) {
                        CoverFlowView.this.eIr.a(i, CoverFlowView.this.eIw.pf(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eIi != null && CoverFlowView.this.eIw != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eIq) {
                            CoverFlowView.this.boR();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eIp) {
                            CoverFlowView.this.boN();
                            CoverFlowView.this.boQ();
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
        int count = this.eIw.getCount();
        if (i == 0) {
            this.eIj.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eIj.setPosition(i);
        } else {
            this.eIj.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boR() {
        if (boQ()) {
            boO();
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
            if (CoverFlowView.this.eIr != null && (view.getTag() instanceof Integer) && (pf = CoverFlowView.this.eIw.pf((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eIr.e(intValue, pf.bjA());
            }
        }
    }

    public void onChangeSkinType() {
        this.eIw.onChangeSkinType();
        if (this.eIj != null && this.eIk != null) {
            this.eIj.setDrawable(ap.getDrawable(this.eIk.boS()));
            this.eIj.setSelector(ap.getDrawable(this.eIk.boT()));
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

    public void a(e eVar) {
        if (eVar != null && this.eIi != null) {
            eVar.b(this.eIi);
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
