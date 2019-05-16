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
    private CoverFlowAdapter<T> bNA;
    private com.baidu.tbadk.core.flow.a bNB;
    private CoverFlowView<T>.a bNC;
    private boolean bND;
    private boolean bNE;
    private boolean bNF;
    private d<T> bNG;
    private CoverFlowView<T>.c bNH;
    private CoverFlowView<T>.b bNI;
    private long bNJ;
    private ListViewPager bNx;
    private IndicatorView bNy;
    private com.baidu.tbadk.core.flow.a.c bNz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bNC = new a();
        this.bND = false;
        this.bNE = true;
        this.bNF = true;
        this.bNH = new c();
        this.bNI = new b();
        this.bNJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bNC = new a();
        this.bND = false;
        this.bNE = true;
        this.bNF = true;
        this.bNH = new c();
        this.bNI = new b();
        this.bNJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bNC = new a();
        this.bND = false;
        this.bNE = true;
        this.bNF = true;
        this.bNH = new c();
        this.bNI = new b();
        this.bNJ = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bNG = dVar;
    }

    private void init(Context context) {
        cm(context);
        cn(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bNx);
        addView(this.bNy);
        this.bNA = new CoverFlowAdapter<>(context);
        this.bNA.setOnClickListener(this.bNH);
        this.bNx.setAdapter(this.bNA);
        this.bNx.setOnPageChangeListener(this.bNI);
    }

    private void cm(Context context) {
        this.bNx = new ListViewPager(context);
    }

    private void cn(Context context) {
        this.bNy = new IndicatorView(context);
        this.bNy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T hG(int i) {
        if (this.bNA == null) {
            return null;
        }
        return this.bNA.hG(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bNA.a(list, this.bNB);
            int size = list.size();
            if (size > 1) {
                this.bNy.setVisibility(0);
                this.bNy.setCount(size);
                this.bNx.setCurrentItem(1, false);
                this.bNy.setPosition(0.0f);
                age();
                return;
            }
            this.bNy.setVisibility(8);
            this.bNy.setCount(size);
            this.bNx.setCurrentItem(1, false);
            this.bNy.setPosition(0.0f);
            agf();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bNB = aVar;
            this.bNz = aVar.agb();
            this.bNz.g(this.bNy);
            aVar.agc().a(this.bNx);
            this.mCustomView = aVar.agd();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bNx);
                addView(this.mCustomView);
                addView(this.bNy);
            }
        }
    }

    public void age() {
        agg();
    }

    public void agf() {
        this.bNC.removeMessages(1);
    }

    public void agg() {
        this.bNC.removeMessages(1);
        this.bNC.sendEmptyMessageDelayed(1, this.bNJ);
    }

    public void setIndicatorVisible(int i) {
        if (this.bNy != null) {
            this.bNy.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bNJ = j;
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
        if (this.bNx != null && this.bNA != null && (count = this.bNA.getCount()) > 1) {
            int currentItem = this.bNx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bNx.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bNx.setCurrentItem(1, false);
            } else {
                this.bNx.setCurrentItem(currentItem + 1);
            }
            this.bNx.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agi() {
        int count;
        if (this.bNA != null && (count = this.bNA.getCount()) > 1) {
            int currentItem = this.bNx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bNx.setCurrentItem(i, false);
                this.bNx.invalidate();
            } else if (currentItem > i) {
                this.bNx.setCurrentItem(1, false);
                this.bNx.invalidate();
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
            if (CoverFlowView.this.bNy != null && CoverFlowView.this.bNA != null) {
                if (CoverFlowView.this.bNA.getCount() == 1 && i == 0 && CoverFlowView.this.bNG != null) {
                    CoverFlowView.this.bNG.a(1, CoverFlowView.this.bNA.hG(i));
                }
                if (CoverFlowView.this.bNy.getVisibility() == 0 && !CoverFlowView.this.bND) {
                    int count = CoverFlowView.this.bNA.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bNy.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bNy.setPosition(f);
                    } else {
                        CoverFlowView.this.bNy.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bNA != null) {
                int count = CoverFlowView.this.bNA.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bND) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bNG != null) {
                        CoverFlowView.this.bNG.a(i, CoverFlowView.this.bNA.hG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bNx != null && CoverFlowView.this.bNA != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bNF) {
                            CoverFlowView.this.agj();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bNF = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bNF) {
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
        int count = this.bNA.getCount();
        if (i == 0) {
            this.bNy.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bNy.setPosition(i);
        } else {
            this.bNy.setPosition(i - 1);
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
            if (CoverFlowView.this.bNG != null && (view.getTag() instanceof Integer) && (hG = CoverFlowView.this.bNA.hG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bNG.B(intValue, hG.abN());
            }
        }
    }

    public void onChangeSkinType() {
        this.bNA.onChangeSkinType();
        if (this.bNy != null && this.bNz != null) {
            this.bNy.setDrawable(al.getDrawable(this.bNz.agk()));
            this.bNy.setSelector(al.getDrawable(this.bNz.agl()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bNx != null) {
            this.bNx.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bNx != null) {
            this.bNx.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bND = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bNE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bNE;
    }

    private void setAutoPlay(boolean z) {
        this.bNF = z;
    }
}
