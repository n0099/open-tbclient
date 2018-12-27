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
    private CoverFlowAdapter<T> axA;
    private com.baidu.tbadk.core.flow.a axB;
    private CoverFlowView<T>.a axC;
    private boolean axD;
    private boolean axE;
    private boolean axF;
    private d<T> axG;
    private CoverFlowView<T>.c axH;
    private CoverFlowView<T>.b axI;
    private long axJ;
    private ListViewPager axx;
    private IndicatorView axy;
    private com.baidu.tbadk.core.flow.a.c axz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.axC = new a();
        this.axD = false;
        this.axE = true;
        this.axF = true;
        this.axH = new c();
        this.axI = new b();
        this.axJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.axC = new a();
        this.axD = false;
        this.axE = true;
        this.axF = true;
        this.axH = new c();
        this.axI = new b();
        this.axJ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.axC = new a();
        this.axD = false;
        this.axE = true;
        this.axF = true;
        this.axH = new c();
        this.axI = new b();
        this.axJ = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.axG = dVar;
    }

    private void init(Context context) {
        bt(context);
        bu(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.axx);
        addView(this.axy);
        this.axA = new CoverFlowAdapter<>(context);
        this.axA.setOnClickListener(this.axH);
        this.axx.setAdapter(this.axA);
        this.axx.setOnPageChangeListener(this.axI);
    }

    private void bt(Context context) {
        this.axx = new ListViewPager(context);
    }

    private void bu(Context context) {
        this.axy = new IndicatorView(context);
        this.axy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T dr(int i) {
        if (this.axA == null) {
            return null;
        }
        return this.axA.dr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.axA.a(list, this.axB);
            int size = list.size();
            if (size > 1) {
                this.axy.setVisibility(0);
                this.axy.setCount(size);
                this.axx.setCurrentItem(1, false);
                this.axy.setPosition(0.0f);
                BS();
                return;
            }
            this.axy.setVisibility(8);
            this.axy.setCount(size);
            this.axx.setCurrentItem(1, false);
            this.axy.setPosition(0.0f);
            BT();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.axB = aVar;
            this.axz = aVar.BP();
            this.axz.g(this.axy);
            aVar.BQ().a(this.axx);
            this.mCustomView = aVar.BR();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.axx);
                addView(this.mCustomView);
                addView(this.axy);
            }
        }
    }

    public void BS() {
        BU();
    }

    public void BT() {
        this.axC.removeMessages(1);
    }

    public void BU() {
        this.axC.removeMessages(1);
        this.axC.sendEmptyMessageDelayed(1, this.axJ);
    }

    public void setIndicatorVisible(int i) {
        if (this.axy != null) {
            this.axy.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.axJ = j;
        BU();
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
                    CoverFlowView.this.BV();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BV() {
        int count;
        if (this.axx != null && this.axA != null && (count = this.axA.getCount()) > 1) {
            int currentItem = this.axx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axx.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.axx.setCurrentItem(1, false);
            } else {
                this.axx.setCurrentItem(currentItem + 1);
            }
            this.axx.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BW() {
        int count;
        if (this.axA != null && (count = this.axA.getCount()) > 1) {
            int currentItem = this.axx.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axx.setCurrentItem(i, false);
                this.axx.invalidate();
            } else if (currentItem > i) {
                this.axx.setCurrentItem(1, false);
                this.axx.invalidate();
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
            if (CoverFlowView.this.axy != null && CoverFlowView.this.axA != null) {
                if (CoverFlowView.this.axA.getCount() == 1 && i == 0 && CoverFlowView.this.axG != null) {
                    CoverFlowView.this.axG.a(1, CoverFlowView.this.axA.dr(i));
                }
                if (CoverFlowView.this.axy.getVisibility() == 0 && !CoverFlowView.this.axD) {
                    int count = CoverFlowView.this.axA.getCount();
                    if (i == 0) {
                        CoverFlowView.this.axy.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.axy.setPosition(f);
                    } else {
                        CoverFlowView.this.axy.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.axA != null) {
                int count = CoverFlowView.this.axA.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.axD) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.axG != null) {
                        CoverFlowView.this.axG.a(i, CoverFlowView.this.axA.dr(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.axx != null && CoverFlowView.this.axA != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.axF) {
                            CoverFlowView.this.BX();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.axF = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.axF) {
                            CoverFlowView.this.BT();
                            CoverFlowView.this.BW();
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
        int count = this.axA.getCount();
        if (i == 0) {
            this.axy.setPosition(0.0f);
        } else if (i == count - 1) {
            this.axy.setPosition(i);
        } else {
            this.axy.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BX() {
        if (BW()) {
            BU();
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
            com.baidu.tbadk.core.flow.a.a dr;
            if (CoverFlowView.this.axG != null && (view.getTag() instanceof Integer) && (dr = CoverFlowView.this.axA.dr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.axG.g(intValue, dr.yn());
            }
        }
    }

    public void onChangeSkinType() {
        this.axA.onChangeSkinType();
        if (this.axy != null && this.axz != null) {
            this.axy.setDrawable(al.getDrawable(this.axz.BY()));
            this.axy.setSelector(al.getDrawable(this.axz.BZ()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.axx != null) {
            this.axx.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.axx != null) {
            this.axx.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.axD = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.axE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.axE;
    }

    private void setAutoPlay(boolean z) {
        this.axF = z;
    }
}
