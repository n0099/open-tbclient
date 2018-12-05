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
    private com.baidu.tbadk.core.flow.a axA;
    private CoverFlowView<T>.a axB;
    private boolean axC;
    private boolean axD;
    private boolean axE;
    private d<T> axF;
    private CoverFlowView<T>.c axG;
    private CoverFlowView<T>.b axH;
    private long axI;
    private ListViewPager axw;
    private IndicatorView axx;
    private com.baidu.tbadk.core.flow.a.c axy;
    private CoverFlowAdapter<T> axz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.axB = new a();
        this.axC = false;
        this.axD = true;
        this.axE = true;
        this.axG = new c();
        this.axH = new b();
        this.axI = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.axB = new a();
        this.axC = false;
        this.axD = true;
        this.axE = true;
        this.axG = new c();
        this.axH = new b();
        this.axI = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.axB = new a();
        this.axC = false;
        this.axD = true;
        this.axE = true;
        this.axG = new c();
        this.axH = new b();
        this.axI = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.axF = dVar;
    }

    private void init(Context context) {
        bt(context);
        bu(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.axw);
        addView(this.axx);
        this.axz = new CoverFlowAdapter<>(context);
        this.axz.setOnClickListener(this.axG);
        this.axw.setAdapter(this.axz);
        this.axw.setOnPageChangeListener(this.axH);
    }

    private void bt(Context context) {
        this.axw = new ListViewPager(context);
    }

    private void bu(Context context) {
        this.axx = new IndicatorView(context);
        this.axx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T dr(int i) {
        if (this.axz == null) {
            return null;
        }
        return this.axz.dr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.axz.a(list, this.axA);
            int size = list.size();
            if (size > 1) {
                this.axx.setVisibility(0);
                this.axx.setCount(size);
                this.axw.setCurrentItem(1, false);
                this.axx.setPosition(0.0f);
                BS();
                return;
            }
            this.axx.setVisibility(8);
            this.axx.setCount(size);
            this.axw.setCurrentItem(1, false);
            this.axx.setPosition(0.0f);
            BT();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.axA = aVar;
            this.axy = aVar.BP();
            this.axy.g(this.axx);
            aVar.BQ().a(this.axw);
            this.mCustomView = aVar.BR();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.axw);
                addView(this.mCustomView);
                addView(this.axx);
            }
        }
    }

    public void BS() {
        BU();
    }

    public void BT() {
        this.axB.removeMessages(1);
    }

    public void BU() {
        this.axB.removeMessages(1);
        this.axB.sendEmptyMessageDelayed(1, this.axI);
    }

    public void setIndicatorVisible(int i) {
        if (this.axx != null) {
            this.axx.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.axI = j;
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
        if (this.axw != null && this.axz != null && (count = this.axz.getCount()) > 1) {
            int currentItem = this.axw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axw.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.axw.setCurrentItem(1, false);
            } else {
                this.axw.setCurrentItem(currentItem + 1);
            }
            this.axw.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BW() {
        int count;
        if (this.axz != null && (count = this.axz.getCount()) > 1) {
            int currentItem = this.axw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.axw.setCurrentItem(i, false);
                this.axw.invalidate();
            } else if (currentItem > i) {
                this.axw.setCurrentItem(1, false);
                this.axw.invalidate();
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
            if (CoverFlowView.this.axx != null && CoverFlowView.this.axz != null) {
                if (CoverFlowView.this.axz.getCount() == 1 && i == 0 && CoverFlowView.this.axF != null) {
                    CoverFlowView.this.axF.a(1, CoverFlowView.this.axz.dr(i));
                }
                if (CoverFlowView.this.axx.getVisibility() == 0 && !CoverFlowView.this.axC) {
                    int count = CoverFlowView.this.axz.getCount();
                    if (i == 0) {
                        CoverFlowView.this.axx.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.axx.setPosition(f);
                    } else {
                        CoverFlowView.this.axx.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.axz != null) {
                int count = CoverFlowView.this.axz.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.axC) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.axF != null) {
                        CoverFlowView.this.axF.a(i, CoverFlowView.this.axz.dr(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.axw != null && CoverFlowView.this.axz != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.axE) {
                            CoverFlowView.this.BX();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.axE = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.axE) {
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
        int count = this.axz.getCount();
        if (i == 0) {
            this.axx.setPosition(0.0f);
        } else if (i == count - 1) {
            this.axx.setPosition(i);
        } else {
            this.axx.setPosition(i - 1);
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
            if (CoverFlowView.this.axF != null && (view.getTag() instanceof Integer) && (dr = CoverFlowView.this.axz.dr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.axF.g(intValue, dr.yn());
            }
        }
    }

    public void onChangeSkinType() {
        this.axz.onChangeSkinType();
        if (this.axx != null && this.axy != null) {
            this.axx.setDrawable(al.getDrawable(this.axy.BY()));
            this.axx.setSelector(al.getDrawable(this.axy.BZ()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.axw != null) {
            this.axw.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.axw != null) {
            this.axw.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.axC = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.axD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.axD;
    }

    private void setAutoPlay(boolean z) {
        this.axE = z;
    }
}
