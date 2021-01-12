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
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager eUH;
    private IndicatorView eUI;
    private com.baidu.tbadk.core.flow.a.c eUJ;
    private com.baidu.tbadk.core.flow.a eUL;
    private boolean eUN;
    private boolean eUO;
    private boolean eUP;
    private d<T> eUQ;
    private long eUT;
    private CoverFlowAdapter<T> eUV;
    private CoverFlowView<T>.a eUW;
    private CoverFlowView<T>.c eUX;
    private CoverFlowView<T>.b eUY;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eUW = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUX = new c();
        this.eUY = new b();
        this.eUT = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eUW = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUX = new c();
        this.eUY = new b();
        this.eUT = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eUW = new a();
        this.eUN = false;
        this.eUO = true;
        this.eUP = true;
        this.eUX = new c();
        this.eUY = new b();
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
        this.eUV = new CoverFlowAdapter<>(context);
        this.eUV.setOnClickListener(this.eUX);
        this.eUH.setAdapter(this.eUV);
        this.eUH.setOnPageChangeListener(this.eUY);
    }

    private void eS(Context context) {
        this.eUH = new ListViewPager(context);
    }

    private void eT(Context context) {
        this.eUI = new IndicatorView(context);
        this.eUI.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T oj(int i) {
        if (this.eUV == null) {
            return null;
        }
        return this.eUV.oj(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eUV.a(list, this.eUL);
            int size = list.size();
            if (size > 1) {
                this.eUI.setVisibility(0);
                this.eUI.setCount(size);
                this.eUH.setCurrentItem(1, false);
                this.eUI.setPosition(0.0f);
                if (this.eUP) {
                    bqP();
                    return;
                }
                return;
            }
            this.eUI.setVisibility(8);
            this.eUI.setCount(size);
            this.eUH.setCurrentItem(1, false);
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
        this.eUW.removeMessages(1);
    }

    public void bqR() {
        this.eUW.removeMessages(1);
        this.eUW.sendEmptyMessageDelayed(1, this.eUT);
    }

    public void tv() {
        if (!this.eUW.hasMessages(1)) {
            bqP();
        }
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
                    CoverFlowView.this.bqS();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        int count;
        if (this.eUH != null && this.eUV != null && (count = this.eUV.getCount()) > 1) {
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
        if (this.eUV != null && (count = this.eUV.getCount()) > 1) {
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.eUI != null && CoverFlowView.this.eUV != null) {
                if (CoverFlowView.this.eUV.getCount() == 1 && i == 0 && CoverFlowView.this.eUQ != null) {
                    CoverFlowView.this.eUQ.a(1, CoverFlowView.this.eUV.oj(i));
                }
                if (CoverFlowView.this.eUI.getVisibility() == 0 && !CoverFlowView.this.eUN) {
                    int count = CoverFlowView.this.eUV.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eUI.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eUI.setPosition(f);
                    } else {
                        CoverFlowView.this.eUI.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eUV != null) {
                int count = CoverFlowView.this.eUV.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eUN) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eUQ != null) {
                        CoverFlowView.this.eUQ.a(i, CoverFlowView.this.eUV.oj(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eUH != null && CoverFlowView.this.eUV != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eUP) {
                            CoverFlowView.this.bqU();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eUO) {
                            CoverFlowView.this.bqQ();
                            CoverFlowView.this.bqT();
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
        int count = this.eUV.getCount();
        if (i == 0) {
            this.eUI.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eUI.setPosition(i);
        } else {
            this.eUI.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        if (bqT()) {
            bqR();
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
            if (CoverFlowView.this.eUQ != null && (view.getTag() instanceof Integer) && (oj = CoverFlowView.this.eUV.oj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eUQ.f(intValue, oj.blt());
            }
        }
    }

    public void onChangeSkinType() {
        this.eUV.onChangeSkinType();
        if (this.eUI != null && this.eUJ != null) {
            this.eUI.setDrawable(ao.getDrawable(this.eUJ.bqV()));
            this.eUI.setSelector(ao.getDrawable(this.eUJ.bqW()));
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

    public void a(e eVar) {
        if (eVar != null && this.eUH != null) {
            eVar.b(this.eUH);
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
