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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager alM;
    private IndicatorView alN;
    private com.baidu.tbadk.core.flow.a.c alO;
    private CoverFlowAdapter<T> alP;
    private com.baidu.tbadk.core.flow.a alQ;
    private CoverFlowView<T>.a alR;
    private boolean alS;
    private boolean alT;
    private boolean alU;
    private d<T> alV;
    private CoverFlowView<T>.c alW;
    private CoverFlowView<T>.b alX;
    private long alY;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.alR = new a();
        this.alS = false;
        this.alT = true;
        this.alU = true;
        this.alW = new c();
        this.alX = new b();
        this.alY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.alR = new a();
        this.alS = false;
        this.alT = true;
        this.alU = true;
        this.alW = new c();
        this.alX = new b();
        this.alY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.alR = new a();
        this.alS = false;
        this.alT = true;
        this.alU = true;
        this.alW = new c();
        this.alX = new b();
        this.alY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.alV = dVar;
    }

    private void init(Context context) {
        aD(context);
        aE(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.alM);
        addView(this.alN);
        this.alP = new CoverFlowAdapter<>(context);
        this.alP.setOnClickListener(this.alW);
        this.alM.setAdapter(this.alP);
        this.alM.setOnPageChangeListener(this.alX);
    }

    private void aD(Context context) {
        this.alM = new ListViewPager(context);
    }

    private void aE(Context context) {
        this.alN = new IndicatorView(context);
        this.alN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cv(int i) {
        if (this.alP == null) {
            return null;
        }
        return this.alP.cv(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.alP.a(list, this.alQ);
            int size = list.size();
            if (size > 1) {
                this.alN.setVisibility(0);
                this.alN.setCount(size);
                this.alM.setCurrentItem(1, false);
                this.alN.setPosition(0.0f);
                xs();
                return;
            }
            this.alN.setVisibility(8);
            this.alN.setCount(size);
            this.alM.setCurrentItem(1, false);
            this.alN.setPosition(0.0f);
            xt();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.alQ = aVar;
            this.alO = aVar.xp();
            this.alO.g(this.alN);
            aVar.xq().a(this.alM);
            this.mCustomView = aVar.xr();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.alM);
                addView(this.mCustomView);
                addView(this.alN);
            }
        }
    }

    public void xs() {
        xu();
    }

    public void xt() {
        this.alR.removeMessages(1);
    }

    public void xu() {
        this.alR.removeMessages(1);
        this.alR.sendEmptyMessageDelayed(1, this.alY);
    }

    public void setIndicatorVisible(int i) {
        if (this.alN != null) {
            this.alN.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.alY = j;
        xu();
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
                    CoverFlowView.this.xv();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        int count;
        if (this.alM != null && this.alP != null && (count = this.alP.getCount()) > 1) {
            int currentItem = this.alM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.alM.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.alM.setCurrentItem(1, false);
            } else {
                this.alM.setCurrentItem(currentItem + 1);
            }
            this.alM.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xw() {
        int count;
        if (this.alP != null && (count = this.alP.getCount()) > 1) {
            int currentItem = this.alM.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.alM.setCurrentItem(i, false);
                this.alM.invalidate();
            } else if (currentItem > i) {
                this.alM.setCurrentItem(1, false);
                this.alM.invalidate();
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
            if (CoverFlowView.this.alN != null && CoverFlowView.this.alP != null) {
                if (CoverFlowView.this.alP.getCount() == 1 && i == 0 && CoverFlowView.this.alV != null) {
                    CoverFlowView.this.alV.a(1, CoverFlowView.this.alP.cv(i));
                }
                if (CoverFlowView.this.alN.getVisibility() == 0 && !CoverFlowView.this.alS) {
                    int count = CoverFlowView.this.alP.getCount();
                    if (i == 0) {
                        CoverFlowView.this.alN.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.alN.setPosition(f);
                    } else {
                        CoverFlowView.this.alN.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.alP != null) {
                int count = CoverFlowView.this.alP.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.alS) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.alV != null) {
                        CoverFlowView.this.alV.a(i, CoverFlowView.this.alP.cv(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.alM != null && CoverFlowView.this.alP != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.alU) {
                            CoverFlowView.this.xx();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.alU = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.alU) {
                            CoverFlowView.this.xt();
                            CoverFlowView.this.xw();
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
        int count = this.alP.getCount();
        if (i == 0) {
            this.alN.setPosition(0.0f);
        } else if (i == count - 1) {
            this.alN.setPosition(i);
        } else {
            this.alN.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx() {
        if (xw()) {
            xu();
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
            com.baidu.tbadk.core.flow.a.a cv;
            if (CoverFlowView.this.alV != null && (view.getTag() instanceof Integer) && (cv = CoverFlowView.this.alP.cv((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.alV.h(intValue, cv.tO());
            }
        }
    }

    public void onChangeSkinType() {
        this.alP.onChangeSkinType();
        if (this.alN != null && this.alO != null) {
            this.alN.setDrawable(am.getDrawable(this.alO.xy()));
            this.alN.setSelector(am.getDrawable(this.alO.xz()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.alM != null) {
            this.alM.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.alM != null) {
            this.alM.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.alS = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.alT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.alT;
    }

    private void setAutoPlay(boolean z) {
        this.alU = z;
    }
}
