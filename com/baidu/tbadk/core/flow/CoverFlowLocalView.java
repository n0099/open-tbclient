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
    private boolean ePA;
    private boolean ePB;
    private d<T> ePC;
    private CoverFlowLocalView<T>.c ePD;
    private CoverFlowLocalView<T>.b ePE;
    private long ePF;
    private boolean ePs;
    private ListViewPager ePt;
    private IndicatorView ePu;
    private com.baidu.tbadk.core.flow.a.c ePv;
    private CoverFlowLocalAdapter<T> ePw;
    private com.baidu.tbadk.core.flow.a ePx;
    private CoverFlowLocalView<T>.a ePy;
    private boolean ePz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ePy = new a();
        this.ePz = false;
        this.ePA = true;
        this.ePB = true;
        this.ePD = new c();
        this.ePE = new b();
        this.ePF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ePy = new a();
        this.ePz = false;
        this.ePA = true;
        this.ePB = true;
        this.ePD = new c();
        this.ePE = new b();
        this.ePF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ePy = new a();
        this.ePz = false;
        this.ePA = true;
        this.ePB = true;
        this.ePD = new c();
        this.ePE = new b();
        this.ePF = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ePC = dVar;
    }

    private void init(Context context) {
        eB(context);
        eC(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.ePt);
        addView(this.ePu);
        this.ePw = new CoverFlowLocalAdapter<>(context);
        this.ePw.setOnClickListener(this.ePD);
        this.ePt.setAdapter(this.ePw);
        this.ePt.setOnPageChangeListener(this.ePE);
    }

    private void eB(Context context) {
        this.ePt = new ListViewPager(context);
    }

    private void eC(Context context) {
        this.ePu = new IndicatorView(context);
        this.ePu.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.ePw.a(list, this.ePx);
            int size = list.size();
            if (size > 1) {
                this.ePu.setVisibility(0);
                this.ePu.setCount(size);
                this.ePt.setCurrentItem(0, false);
                this.ePu.setPosition(0.0f);
                if (this.ePB) {
                    bsg();
                    return;
                }
                return;
            }
            this.ePu.setVisibility(8);
            this.ePu.setCount(size);
            this.ePt.setCurrentItem(0, false);
            this.ePu.setPosition(0.0f);
            bsh();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.ePx = aVar;
            this.ePv = aVar.uj();
            this.ePv.g(this.ePu);
            aVar.ui().b(this.ePt);
            this.mCustomView = aVar.bsf();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.ePt);
                addView(this.mCustomView);
                addView(this.ePu);
            }
        }
    }

    public void bsg() {
        bsi();
    }

    public void bsh() {
        this.ePy.removeMessages(1);
    }

    public void bsi() {
        this.ePy.removeMessages(1);
        this.ePy.sendEmptyMessageDelayed(1, this.ePF);
    }

    public void setIndicatorVisible(int i) {
        if (this.ePu != null) {
            this.ePu.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.ePF = j;
        bsi();
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
                    CoverFlowLocalView.this.bsj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        int count;
        if (this.ePt != null && this.ePw != null && (count = this.ePw.getCount()) > 1) {
            int currentItem = this.ePt.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.ePt.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.ePt.setCurrentItem(1, false);
            } else {
                this.ePt.setCurrentItem(currentItem + 1);
            }
            this.ePt.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsk() {
        int count;
        if (this.ePw == null || !this.ePs || (count = this.ePw.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.ePt.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.ePt.setCurrentItem(i, false);
            this.ePt.invalidate();
        } else if (currentItem > i) {
            this.ePt.setCurrentItem(1, false);
            this.ePt.invalidate();
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
            if (CoverFlowLocalView.this.ePu != null && CoverFlowLocalView.this.ePw != null) {
                if (CoverFlowLocalView.this.ePw.getCount() == 1 && i == 0 && CoverFlowLocalView.this.ePC != null) {
                    CoverFlowLocalView.this.ePC.a(1, CoverFlowLocalView.this.ePw.pG(i));
                }
                if (CoverFlowLocalView.this.ePu.getVisibility() == 0 && !CoverFlowLocalView.this.ePz) {
                    if (CoverFlowLocalView.this.ePs) {
                        int count = CoverFlowLocalView.this.ePw.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.ePu.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.ePu.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.ePu.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.ePu.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.ePw != null) {
                int count = CoverFlowLocalView.this.ePw.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.ePz) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.ePC != null) {
                        CoverFlowLocalView.this.ePC.a(i, CoverFlowLocalView.this.ePw.pG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.ePt != null && CoverFlowLocalView.this.ePw != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.ePB) {
                            CoverFlowLocalView.this.bsl();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.ePA) {
                            CoverFlowLocalView.this.bsh();
                            CoverFlowLocalView.this.bsk();
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
        if (this.ePs) {
            int count = this.ePw.getCount();
            if (i == 0) {
                this.ePu.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.ePu.setPosition(i);
                return;
            } else {
                this.ePu.setPosition(i - 1);
                return;
            }
        }
        this.ePu.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        if (bsk()) {
            bsi();
        }
    }

    public void setCanRepeat(boolean z) {
        this.ePs = z;
        if (this.ePw != null) {
            this.ePw.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a pG;
            if (CoverFlowLocalView.this.ePC != null && (view.getTag() instanceof Integer) && (pG = CoverFlowLocalView.this.ePw.pG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.ePC.e(intValue, pG.bmN());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.ePt != null) {
            this.ePt.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.ePt != null) {
            this.ePt.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.ePz = z;
    }

    public void setPageMargin(int i) {
        if (this.ePt != null) {
            this.ePt.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.ePA = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.ePA;
    }

    public void setAutoPlay(boolean z) {
        this.ePB = z;
    }
}
