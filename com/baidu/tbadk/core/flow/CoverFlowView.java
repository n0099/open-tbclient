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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager dQA;
    private IndicatorView dQB;
    private com.baidu.tbadk.core.flow.a.c dQC;
    private CoverFlowAdapter<T> dQD;
    private com.baidu.tbadk.core.flow.a dQE;
    private CoverFlowView<T>.a dQF;
    private boolean dQG;
    private boolean dQH;
    private boolean dQI;
    private d<T> dQJ;
    private CoverFlowView<T>.c dQK;
    private CoverFlowView<T>.b dQL;
    private long dQM;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.dQF = new a();
        this.dQG = false;
        this.dQH = true;
        this.dQI = true;
        this.dQK = new c();
        this.dQL = new b();
        this.dQM = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.dQF = new a();
        this.dQG = false;
        this.dQH = true;
        this.dQI = true;
        this.dQK = new c();
        this.dQL = new b();
        this.dQM = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.dQF = new a();
        this.dQG = false;
        this.dQH = true;
        this.dQI = true;
        this.dQK = new c();
        this.dQL = new b();
        this.dQM = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.dQJ = dVar;
    }

    private void init(Context context) {
        dE(context);
        dF(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.dQA);
        addView(this.dQB);
        this.dQD = new CoverFlowAdapter<>(context);
        this.dQD.setOnClickListener(this.dQK);
        this.dQA.setAdapter(this.dQD);
        this.dQA.setOnPageChangeListener(this.dQL);
    }

    private void dE(Context context) {
        this.dQA = new ListViewPager(context);
    }

    private void dF(Context context) {
        this.dQB = new IndicatorView(context);
        this.dQB.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T lg(int i) {
        if (this.dQD == null) {
            return null;
        }
        return this.dQD.lg(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.dQD.a(list, this.dQE);
            int size = list.size();
            if (size > 1) {
                this.dQB.setVisibility(0);
                this.dQB.setCount(size);
                this.dQA.setCurrentItem(1, false);
                this.dQB.setPosition(0.0f);
                aVi();
                return;
            }
            this.dQB.setVisibility(8);
            this.dQB.setCount(size);
            this.dQA.setCurrentItem(1, false);
            this.dQB.setPosition(0.0f);
            aVj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.dQE = aVar;
            this.dQC = aVar.sn();
            this.dQC.g(this.dQB);
            aVar.sm().b(this.dQA);
            this.mCustomView = aVar.aVh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.dQA);
                addView(this.mCustomView);
                addView(this.dQB);
            }
        }
    }

    public void aVi() {
        aVk();
    }

    public void aVj() {
        this.dQF.removeMessages(1);
    }

    public void aVk() {
        this.dQF.removeMessages(1);
        this.dQF.sendEmptyMessageDelayed(1, this.dQM);
    }

    public void sl() {
        if (!this.dQF.hasMessages(1)) {
            aVi();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dQB != null) {
            this.dQB.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.dQM = j;
        aVk();
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
                    CoverFlowView.this.aVl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVl() {
        int count;
        if (this.dQA != null && this.dQD != null && (count = this.dQD.getCount()) > 1) {
            int currentItem = this.dQA.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dQA.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.dQA.setCurrentItem(1, false);
            } else {
                this.dQA.setCurrentItem(currentItem + 1);
            }
            this.dQA.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVm() {
        int count;
        if (this.dQD != null && (count = this.dQD.getCount()) > 1) {
            int currentItem = this.dQA.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dQA.setCurrentItem(i, false);
                this.dQA.invalidate();
            } else if (currentItem > i) {
                this.dQA.setCurrentItem(1, false);
                this.dQA.invalidate();
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
            if (CoverFlowView.this.dQB != null && CoverFlowView.this.dQD != null) {
                if (CoverFlowView.this.dQD.getCount() == 1 && i == 0 && CoverFlowView.this.dQJ != null) {
                    CoverFlowView.this.dQJ.a(1, CoverFlowView.this.dQD.lg(i));
                }
                if (CoverFlowView.this.dQB.getVisibility() == 0 && !CoverFlowView.this.dQG) {
                    int count = CoverFlowView.this.dQD.getCount();
                    if (i == 0) {
                        CoverFlowView.this.dQB.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.dQB.setPosition(f);
                    } else {
                        CoverFlowView.this.dQB.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.dQD != null) {
                int count = CoverFlowView.this.dQD.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.dQG) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.dQJ != null) {
                        CoverFlowView.this.dQJ.a(i, CoverFlowView.this.dQD.lg(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.dQA != null && CoverFlowView.this.dQD != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.dQI) {
                            CoverFlowView.this.aVn();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.dQH) {
                            CoverFlowView.this.aVj();
                            CoverFlowView.this.aVm();
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
        int count = this.dQD.getCount();
        if (i == 0) {
            this.dQB.setPosition(0.0f);
        } else if (i == count - 1) {
            this.dQB.setPosition(i);
        } else {
            this.dQB.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVn() {
        if (aVm()) {
            aVk();
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
            com.baidu.tbadk.core.flow.a.a lg;
            if (CoverFlowView.this.dQJ != null && (view.getTag() instanceof Integer) && (lg = CoverFlowView.this.dQD.lg((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.dQJ.f(intValue, lg.aQn());
            }
        }
    }

    public void onChangeSkinType() {
        this.dQD.onChangeSkinType();
        if (this.dQB != null && this.dQC != null) {
            this.dQB.setDrawable(an.getDrawable(this.dQC.aVo()));
            this.dQB.setSelector(an.getDrawable(this.dQC.aVp()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.dQA != null) {
            this.dQA.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.dQA != null) {
            this.dQA.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.dQG = z;
    }

    public void setPageMargin(int i) {
        if (this.dQA != null) {
            this.dQA.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.dQA != null) {
            eVar.b(this.dQA);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.dQH = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.dQH;
    }

    public void setAutoPlay(boolean z) {
        this.dQI = z;
    }
}
