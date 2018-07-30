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
    private ListViewPager alN;
    private IndicatorView alO;
    private com.baidu.tbadk.core.flow.a.c alP;
    private CoverFlowAdapter<T> alQ;
    private com.baidu.tbadk.core.flow.a alR;
    private CoverFlowView<T>.a alS;
    private boolean alT;
    private d<T> alU;
    private CoverFlowView<T>.c alV;
    private CoverFlowView<T>.b alW;
    private long alX;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.alS = new a();
        this.alT = false;
        this.alV = new c();
        this.alW = new b();
        this.alX = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.alS = new a();
        this.alT = false;
        this.alV = new c();
        this.alW = new b();
        this.alX = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.alS = new a();
        this.alT = false;
        this.alV = new c();
        this.alW = new b();
        this.alX = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.alU = dVar;
    }

    private void init(Context context) {
        aE(context);
        aF(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.alN);
        addView(this.alO);
        this.alQ = new CoverFlowAdapter<>(context);
        this.alQ.setOnClickListener(this.alV);
        this.alN.setAdapter(this.alQ);
        this.alN.setOnPageChangeListener(this.alW);
    }

    private void aE(Context context) {
        this.alN = new ListViewPager(context);
    }

    private void aF(Context context) {
        this.alO = new IndicatorView(context);
        this.alO.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cv(int i) {
        if (this.alQ == null) {
            return null;
        }
        return this.alQ.cv(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.alQ.a(list, this.alR);
            int size = list.size();
            if (size > 1) {
                this.alO.setVisibility(0);
                this.alO.setCount(size);
                this.alN.setCurrentItem(1, false);
                this.alO.setPosition(0.0f);
                xt();
                return;
            }
            this.alO.setVisibility(8);
            this.alO.setCount(size);
            this.alN.setCurrentItem(1, false);
            this.alO.setPosition(0.0f);
            xu();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.alR = aVar;
            this.alP = aVar.xq();
            this.alP.g(this.alO);
            aVar.xr().a(this.alN);
            this.mCustomView = aVar.xs();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.alN);
                addView(this.mCustomView);
                addView(this.alO);
            }
        }
    }

    public void xt() {
        xv();
    }

    public void xu() {
        this.alS.removeMessages(1);
    }

    public void xv() {
        this.alS.removeMessages(1);
        this.alS.sendEmptyMessageDelayed(1, this.alX);
    }

    public void setMarqueenTime(long j) {
        this.alX = j;
        xv();
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
                    CoverFlowView.this.xw();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw() {
        int count;
        if (this.alN != null && this.alQ != null && (count = this.alQ.getCount()) > 1) {
            int currentItem = this.alN.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.alN.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.alN.setCurrentItem(1, false);
            } else {
                this.alN.setCurrentItem(currentItem + 1);
            }
            this.alN.invalidate();
        }
    }

    private boolean xx() {
        int count;
        if (this.alQ != null && (count = this.alQ.getCount()) > 1) {
            int currentItem = this.alN.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.alN.setCurrentItem(i, false);
                this.alN.invalidate();
            } else if (currentItem > i) {
                this.alN.setCurrentItem(1, false);
                this.alN.invalidate();
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
            if (CoverFlowView.this.alO != null && CoverFlowView.this.alQ != null) {
                if (CoverFlowView.this.alQ.getCount() == 1 && i == 0 && CoverFlowView.this.alU != null) {
                    CoverFlowView.this.alU.a(1, CoverFlowView.this.alQ.cv(i));
                }
                if (CoverFlowView.this.alO.getVisibility() == 0 && !CoverFlowView.this.alT) {
                    int count = CoverFlowView.this.alQ.getCount();
                    if (i == 0) {
                        CoverFlowView.this.alO.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.alO.setPosition(f);
                    } else {
                        CoverFlowView.this.alO.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.alQ != null) {
                int count = CoverFlowView.this.alQ.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.alT) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.alU != null) {
                        CoverFlowView.this.alU.a(i, CoverFlowView.this.alQ.cv(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.alN != null && CoverFlowView.this.alQ != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.xy();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        int count = this.alQ.getCount();
        if (i == 0) {
            this.alO.setPosition(0.0f);
        } else if (i == count - 1) {
            this.alO.setPosition(i);
        } else {
            this.alO.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy() {
        if (xx()) {
            xv();
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
            if (CoverFlowView.this.alU != null && (view.getTag() instanceof Integer) && (cv = CoverFlowView.this.alQ.cv((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.alU.h(intValue, cv.tP());
            }
        }
    }

    public void onChangeSkinType() {
        this.alQ.onChangeSkinType();
        if (this.alO != null && this.alP != null) {
            this.alO.setDrawable(am.getDrawable(this.alP.xz()));
            this.alO.setSelector(am.getDrawable(this.alP.xA()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.alN != null) {
            this.alN.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.alN != null) {
            this.alN.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.alT = z;
    }
}
