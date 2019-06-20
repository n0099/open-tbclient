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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private com.baidu.tbadk.core.flow.a.c bNA;
    private CoverFlowAdapter<T> bNB;
    private com.baidu.tbadk.core.flow.a bNC;
    private CoverFlowView<T>.a bND;
    private boolean bNE;
    private boolean bNF;
    private boolean bNG;
    private d<T> bNH;
    private CoverFlowView<T>.c bNI;
    private CoverFlowView<T>.b bNJ;
    private long bNK;
    private ListViewPager bNy;
    private IndicatorView bNz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bND = new a();
        this.bNE = false;
        this.bNF = true;
        this.bNG = true;
        this.bNI = new c();
        this.bNJ = new b();
        this.bNK = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bND = new a();
        this.bNE = false;
        this.bNF = true;
        this.bNG = true;
        this.bNI = new c();
        this.bNJ = new b();
        this.bNK = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bND = new a();
        this.bNE = false;
        this.bNF = true;
        this.bNG = true;
        this.bNI = new c();
        this.bNJ = new b();
        this.bNK = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bNH = dVar;
    }

    private void init(Context context) {
        cm(context);
        cn(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bNy);
        addView(this.bNz);
        this.bNB = new CoverFlowAdapter<>(context);
        this.bNB.setOnClickListener(this.bNI);
        this.bNy.setAdapter(this.bNB);
        this.bNy.setOnPageChangeListener(this.bNJ);
    }

    private void cm(Context context) {
        this.bNy = new ListViewPager(context);
    }

    private void cn(Context context) {
        this.bNz = new IndicatorView(context);
        this.bNz.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T hG(int i) {
        if (this.bNB == null) {
            return null;
        }
        return this.bNB.hG(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bNB.a(list, this.bNC);
            int size = list.size();
            if (size > 1) {
                this.bNz.setVisibility(0);
                this.bNz.setCount(size);
                this.bNy.setCurrentItem(1, false);
                this.bNz.setPosition(0.0f);
                age();
                return;
            }
            this.bNz.setVisibility(8);
            this.bNz.setCount(size);
            this.bNy.setCurrentItem(1, false);
            this.bNz.setPosition(0.0f);
            agf();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bNC = aVar;
            this.bNA = aVar.agb();
            this.bNA.g(this.bNz);
            aVar.agc().a(this.bNy);
            this.mCustomView = aVar.agd();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bNy);
                addView(this.mCustomView);
                addView(this.bNz);
            }
        }
    }

    public void age() {
        agg();
    }

    public void agf() {
        this.bND.removeMessages(1);
    }

    public void agg() {
        this.bND.removeMessages(1);
        this.bND.sendEmptyMessageDelayed(1, this.bNK);
    }

    public void setIndicatorVisible(int i) {
        if (this.bNz != null) {
            this.bNz.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bNK = j;
        agg();
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
                    CoverFlowView.this.agh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        int count;
        if (this.bNy != null && this.bNB != null && (count = this.bNB.getCount()) > 1) {
            int currentItem = this.bNy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bNy.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bNy.setCurrentItem(1, false);
            } else {
                this.bNy.setCurrentItem(currentItem + 1);
            }
            this.bNy.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agi() {
        int count;
        if (this.bNB != null && (count = this.bNB.getCount()) > 1) {
            int currentItem = this.bNy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bNy.setCurrentItem(i, false);
                this.bNy.invalidate();
            } else if (currentItem > i) {
                this.bNy.setCurrentItem(1, false);
                this.bNy.invalidate();
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
            if (CoverFlowView.this.bNz != null && CoverFlowView.this.bNB != null) {
                if (CoverFlowView.this.bNB.getCount() == 1 && i == 0 && CoverFlowView.this.bNH != null) {
                    CoverFlowView.this.bNH.a(1, CoverFlowView.this.bNB.hG(i));
                }
                if (CoverFlowView.this.bNz.getVisibility() == 0 && !CoverFlowView.this.bNE) {
                    int count = CoverFlowView.this.bNB.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bNz.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bNz.setPosition(f);
                    } else {
                        CoverFlowView.this.bNz.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bNB != null) {
                int count = CoverFlowView.this.bNB.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bNE) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bNH != null) {
                        CoverFlowView.this.bNH.a(i, CoverFlowView.this.bNB.hG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bNy != null && CoverFlowView.this.bNB != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bNG) {
                            CoverFlowView.this.agj();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bNG = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bNG) {
                            CoverFlowView.this.agf();
                            CoverFlowView.this.agi();
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
        int count = this.bNB.getCount();
        if (i == 0) {
            this.bNz.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bNz.setPosition(i);
        } else {
            this.bNz.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agj() {
        if (agi()) {
            agg();
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
            com.baidu.tbadk.core.flow.a.a hG;
            if (CoverFlowView.this.bNH != null && (view.getTag() instanceof Integer) && (hG = CoverFlowView.this.bNB.hG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bNH.B(intValue, hG.abN());
            }
        }
    }

    public void onChangeSkinType() {
        this.bNB.onChangeSkinType();
        if (this.bNz != null && this.bNA != null) {
            this.bNz.setDrawable(al.getDrawable(this.bNA.agk()));
            this.bNz.setSelector(al.getDrawable(this.bNA.agl()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bNy != null) {
            this.bNy.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bNy != null) {
            this.bNy.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bNE = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bNF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bNF;
    }

    private void setAutoPlay(boolean z) {
        this.bNG = z;
    }
}
