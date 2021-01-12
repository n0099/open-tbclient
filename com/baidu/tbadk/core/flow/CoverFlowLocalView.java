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
    private boolean eUG;
    private ListViewPager eUH;
    private IndicatorView eUI;
    private com.baidu.tbadk.core.flow.a.c eUJ;
    private CoverFlowLocalAdapter<T> eUK;
    private com.baidu.tbadk.core.flow.a eUL;
    private CoverFlowLocalView<T>.a eUM;
    private boolean eUN;
    private boolean eUO;
    private boolean eUP;
    private d<T> eUQ;
    private CoverFlowLocalView<T>.c eUR;
    private CoverFlowLocalView<T>.b eUS;
    private long eUT;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eUM = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUR = new c();
        this.eUS = new b();
        this.eUT = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eUM = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUR = new c();
        this.eUS = new b();
        this.eUT = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eUM = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUR = new c();
        this.eUS = new b();
        this.eUT = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eUQ = dVar;
    }

    private void init(Context context) {
        eS(context);
        eT(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eUH);
        addView(this.eUI);
        this.eUK = new CoverFlowLocalAdapter<>(context);
        this.eUK.setOnClickListener(this.eUR);
        this.eUH.setAdapter(this.eUK);
        this.eUH.setOnPageChangeListener(this.eUS);
    }

    private void eS(Context context) {
        this.eUH = new ListViewPager(context);
    }

    private void eT(Context context) {
        this.eUI = new IndicatorView(context);
        this.eUI.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eUK.a(list, this.eUL);
            int size = list.size();
            if (size > 1) {
                this.eUI.setVisibility(0);
                this.eUI.setCount(size);
                this.eUH.setCurrentItem(0, false);
                this.eUI.setPosition(0.0f);
                if (this.eUP) {
                    bqP();
                    return;
                }
                return;
            }
            this.eUI.setVisibility(8);
            this.eUI.setCount(size);
            this.eUH.setCurrentItem(0, false);
            this.eUI.setPosition(0.0f);
            bqQ();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eUL = aVar;
            this.eUJ = aVar.tx();
            this.eUJ.g(this.eUI);
            aVar.tw().b(this.eUH);
            this.mCustomView = aVar.bqO();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eUH);
                addView(this.mCustomView);
                addView(this.eUI);
            }
        }
    }

    public void bqP() {
        bqR();
    }

    public void bqQ() {
        this.eUM.removeMessages(1);
    }

    public void bqR() {
        this.eUM.removeMessages(1);
        this.eUM.sendEmptyMessageDelayed(1, this.eUT);
    }

    public void setIndicatorVisible(int i) {
        if (this.eUI != null) {
            this.eUI.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eUT = j;
        bqR();
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
                    CoverFlowLocalView.this.bqS();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        int count;
        if (this.eUH != null && this.eUK != null && (count = this.eUK.getCount()) > 1) {
            int currentItem = this.eUH.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eUH.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eUH.setCurrentItem(1, false);
            } else {
                this.eUH.setCurrentItem(currentItem + 1);
            }
            this.eUH.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqT() {
        int count;
        if (this.eUK == null || !this.eUG || (count = this.eUK.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eUH.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eUH.setCurrentItem(i, false);
            this.eUH.invalidate();
        } else if (currentItem > i) {
            this.eUH.setCurrentItem(1, false);
            this.eUH.invalidate();
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
            if (CoverFlowLocalView.this.eUI != null && CoverFlowLocalView.this.eUK != null) {
                if (CoverFlowLocalView.this.eUK.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eUQ != null) {
                    CoverFlowLocalView.this.eUQ.a(1, CoverFlowLocalView.this.eUK.oj(i));
                }
                if (CoverFlowLocalView.this.eUI.getVisibility() == 0 && !CoverFlowLocalView.this.eUN) {
                    if (CoverFlowLocalView.this.eUG) {
                        int count = CoverFlowLocalView.this.eUK.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eUI.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eUI.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eUI.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eUI.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eUK != null) {
                int count = CoverFlowLocalView.this.eUK.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eUN) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eUQ != null) {
                        CoverFlowLocalView.this.eUQ.a(i, CoverFlowLocalView.this.eUK.oj(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eUH != null && CoverFlowLocalView.this.eUK != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eUP) {
                            CoverFlowLocalView.this.bqU();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eUO) {
                            CoverFlowLocalView.this.bqQ();
                            CoverFlowLocalView.this.bqT();
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
        if (this.eUG) {
            int count = this.eUK.getCount();
            if (i == 0) {
                this.eUI.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eUI.setPosition(i);
                return;
            } else {
                this.eUI.setPosition(i - 1);
                return;
            }
        }
        this.eUI.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        if (bqT()) {
            bqR();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eUG = z;
        if (this.eUK != null) {
            this.eUK.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a oj;
            if (CoverFlowLocalView.this.eUQ != null && (view.getTag() instanceof Integer) && (oj = CoverFlowLocalView.this.eUK.oj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eUQ.f(intValue, oj.blt());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eUH != null) {
            this.eUH.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eUH != null) {
            this.eUH.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eUN = z;
    }

    public void setPageMargin(int i) {
        if (this.eUH != null) {
            this.eUH.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eUO = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eUO;
    }

    public void setAutoPlay(boolean z) {
        this.eUP = z;
    }
}
