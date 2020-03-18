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
    private d<T> cWA;
    private CoverFlowView<T>.c cWB;
    private CoverFlowView<T>.b cWC;
    private long cWD;
    private ListViewPager cWr;
    private IndicatorView cWs;
    private com.baidu.tbadk.core.flow.a.c cWt;
    private CoverFlowAdapter<T> cWu;
    private com.baidu.tbadk.core.flow.a cWv;
    private CoverFlowView<T>.a cWw;
    private boolean cWx;
    private boolean cWy;
    private boolean cWz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cWw = new a();
        this.cWx = false;
        this.cWy = true;
        this.cWz = true;
        this.cWB = new c();
        this.cWC = new b();
        this.cWD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cWw = new a();
        this.cWx = false;
        this.cWy = true;
        this.cWz = true;
        this.cWB = new c();
        this.cWC = new b();
        this.cWD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cWw = new a();
        this.cWx = false;
        this.cWy = true;
        this.cWz = true;
        this.cWB = new c();
        this.cWC = new b();
        this.cWD = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cWA = dVar;
    }

    private void init(Context context) {
        dJ(context);
        dK(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cWr);
        addView(this.cWs);
        this.cWu = new CoverFlowAdapter<>(context);
        this.cWu.setOnClickListener(this.cWB);
        this.cWr.setAdapter(this.cWu);
        this.cWr.setOnPageChangeListener(this.cWC);
    }

    private void dJ(Context context) {
        this.cWr = new ListViewPager(context);
    }

    private void dK(Context context) {
        this.cWs = new IndicatorView(context);
        this.cWs.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kj(int i) {
        if (this.cWu == null) {
            return null;
        }
        return this.cWu.kj(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cWu.a(list, this.cWv);
            int size = list.size();
            if (size > 1) {
                this.cWs.setVisibility(0);
                this.cWs.setCount(size);
                this.cWr.setCurrentItem(1, false);
                this.cWs.setPosition(0.0f);
                aFa();
                return;
            }
            this.cWs.setVisibility(8);
            this.cWs.setCount(size);
            this.cWr.setCurrentItem(1, false);
            this.cWs.setPosition(0.0f);
            aFb();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cWv = aVar;
            this.cWt = aVar.aEX();
            this.cWt.g(this.cWs);
            aVar.aEY().b(this.cWr);
            this.mCustomView = aVar.aEZ();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cWr);
                addView(this.mCustomView);
                addView(this.cWs);
            }
        }
    }

    public void aFa() {
        aFc();
    }

    public void aFb() {
        this.cWw.removeMessages(1);
    }

    public void aFc() {
        this.cWw.removeMessages(1);
        this.cWw.sendEmptyMessageDelayed(1, this.cWD);
    }

    public void setIndicatorVisible(int i) {
        if (this.cWs != null) {
            this.cWs.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cWD = j;
        aFc();
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
                    CoverFlowView.this.aFd();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFd() {
        int count;
        if (this.cWr != null && this.cWu != null && (count = this.cWu.getCount()) > 1) {
            int currentItem = this.cWr.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWr.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cWr.setCurrentItem(1, false);
            } else {
                this.cWr.setCurrentItem(currentItem + 1);
            }
            this.cWr.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFe() {
        int count;
        if (this.cWu != null && (count = this.cWu.getCount()) > 1) {
            int currentItem = this.cWr.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWr.setCurrentItem(i, false);
                this.cWr.invalidate();
            } else if (currentItem > i) {
                this.cWr.setCurrentItem(1, false);
                this.cWr.invalidate();
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
            if (CoverFlowView.this.cWs != null && CoverFlowView.this.cWu != null) {
                if (CoverFlowView.this.cWu.getCount() == 1 && i == 0 && CoverFlowView.this.cWA != null) {
                    CoverFlowView.this.cWA.a(1, CoverFlowView.this.cWu.kj(i));
                }
                if (CoverFlowView.this.cWs.getVisibility() == 0 && !CoverFlowView.this.cWx) {
                    int count = CoverFlowView.this.cWu.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cWs.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cWs.setPosition(f);
                    } else {
                        CoverFlowView.this.cWs.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cWu != null) {
                int count = CoverFlowView.this.cWu.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cWx) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cWA != null) {
                        CoverFlowView.this.cWA.a(i, CoverFlowView.this.cWu.kj(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cWr != null && CoverFlowView.this.cWu != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cWz) {
                            CoverFlowView.this.aFf();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cWz = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cWz) {
                            CoverFlowView.this.aFb();
                            CoverFlowView.this.aFe();
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
        int count = this.cWu.getCount();
        if (i == 0) {
            this.cWs.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cWs.setPosition(i);
        } else {
            this.cWs.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFf() {
        if (aFe()) {
            aFc();
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
            com.baidu.tbadk.core.flow.a.a kj;
            if (CoverFlowView.this.cWA != null && (view.getTag() instanceof Integer) && (kj = CoverFlowView.this.cWu.kj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cWA.Q(intValue, kj.aAE());
            }
        }
    }

    public void onChangeSkinType() {
        this.cWu.onChangeSkinType();
        if (this.cWs != null && this.cWt != null) {
            this.cWs.setDrawable(am.getDrawable(this.cWt.aFg()));
            this.cWs.setSelector(am.getDrawable(this.cWt.aFh()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cWr != null) {
            this.cWr.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cWr != null) {
            this.cWr.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cWx = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cWy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cWy;
    }

    private void setAutoPlay(boolean z) {
        this.cWz = z;
    }
}
