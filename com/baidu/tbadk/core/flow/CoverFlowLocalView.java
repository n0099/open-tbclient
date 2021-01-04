package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean eZA;
    private d<T> eZB;
    private CoverFlowLocalView<T>.c eZC;
    private CoverFlowLocalView<T>.b eZD;
    private long eZE;
    private boolean eZr;
    private ListViewPager eZs;
    private IndicatorView eZt;
    private com.baidu.tbadk.core.flow.a.c eZu;
    private CoverFlowLocalAdapter<T> eZv;
    private com.baidu.tbadk.core.flow.a eZw;
    private CoverFlowLocalView<T>.a eZx;
    private boolean eZy;
    private boolean eZz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eZx = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZC = new c();
        this.eZD = new b();
        this.eZE = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eZx = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZC = new c();
        this.eZD = new b();
        this.eZE = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eZx = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZC = new c();
        this.eZD = new b();
        this.eZE = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eZB = dVar;
    }

    private void init(Context context) {
        eU(context);
        eV(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eZs);
        addView(this.eZt);
        this.eZv = new CoverFlowLocalAdapter<>(context);
        this.eZv.setOnClickListener(this.eZC);
        this.eZs.setAdapter(this.eZv);
        this.eZs.setOnPageChangeListener(this.eZD);
    }

    private void eU(Context context) {
        this.eZs = new ListViewPager(context);
    }

    private void eV(Context context) {
        this.eZt = new IndicatorView(context);
        this.eZt.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eZv.a(list, this.eZw);
            int size = list.size();
            if (size > 1) {
                this.eZt.setVisibility(0);
                this.eZt.setCount(size);
                this.eZs.setCurrentItem(0, false);
                this.eZt.setPosition(0.0f);
                if (this.eZA) {
                    buI();
                    return;
                }
                return;
            }
            this.eZt.setVisibility(8);
            this.eZt.setCount(size);
            this.eZs.setCurrentItem(0, false);
            this.eZt.setPosition(0.0f);
            buJ();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eZw = aVar;
            this.eZu = aVar.tI();
            this.eZu.g(this.eZt);
            aVar.tH().b(this.eZs);
            this.mCustomView = aVar.buH();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eZs);
                addView(this.mCustomView);
                addView(this.eZt);
            }
        }
    }

    public void buI() {
        buK();
    }

    public void buJ() {
        this.eZx.removeMessages(1);
    }

    public void buK() {
        this.eZx.removeMessages(1);
        this.eZx.sendEmptyMessageDelayed(1, this.eZE);
    }

    public void setIndicatorVisible(int i) {
        if (this.eZt != null) {
            this.eZt.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eZE = j;
        buK();
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
                    CoverFlowLocalView.this.buL();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        int count;
        if (this.eZs != null && this.eZv != null && (count = this.eZv.getCount()) > 1) {
            int currentItem = this.eZs.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eZs.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eZs.setCurrentItem(1, false);
            } else {
                this.eZs.setCurrentItem(currentItem + 1);
            }
            this.eZs.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buM() {
        int count;
        if (this.eZv == null || !this.eZr || (count = this.eZv.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eZs.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eZs.setCurrentItem(i, false);
            this.eZs.invalidate();
        } else if (currentItem > i) {
            this.eZs.setCurrentItem(1, false);
            this.eZs.invalidate();
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
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.eZt != null && CoverFlowLocalView.this.eZv != null) {
                if (CoverFlowLocalView.this.eZv.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eZB != null) {
                    CoverFlowLocalView.this.eZB.a(1, CoverFlowLocalView.this.eZv.pQ(i));
                }
                if (CoverFlowLocalView.this.eZt.getVisibility() == 0 && !CoverFlowLocalView.this.eZy) {
                    if (CoverFlowLocalView.this.eZr) {
                        int count = CoverFlowLocalView.this.eZv.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eZt.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eZt.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eZt.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eZt.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eZv != null) {
                int count = CoverFlowLocalView.this.eZv.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eZy) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eZB != null) {
                        CoverFlowLocalView.this.eZB.a(i, CoverFlowLocalView.this.eZv.pQ(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eZs != null && CoverFlowLocalView.this.eZv != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eZA) {
                            CoverFlowLocalView.this.buN();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eZz) {
                            CoverFlowLocalView.this.buJ();
                            CoverFlowLocalView.this.buM();
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
        if (this.eZr) {
            int count = this.eZv.getCount();
            if (i == 0) {
                this.eZt.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eZt.setPosition(i);
                return;
            } else {
                this.eZt.setPosition(i - 1);
                return;
            }
        }
        this.eZt.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (buM()) {
            buK();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eZr = z;
        if (this.eZv != null) {
            this.eZv.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a pQ;
            if (CoverFlowLocalView.this.eZB != null && (view.getTag() instanceof Integer) && (pQ = CoverFlowLocalView.this.eZv.pQ((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eZB.e(intValue, pQ.bpm());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eZs != null) {
            this.eZs.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eZs != null) {
            this.eZs.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eZy = z;
    }

    public void setPageMargin(int i) {
        if (this.eZs != null) {
            this.eZs.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eZz = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eZz;
    }

    public void setAutoPlay(boolean z) {
        this.eZA = z;
    }
}
