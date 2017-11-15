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
import com.baidu.adp.widget.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager aco;
    private IndicatorView acp;
    private com.baidu.tbadk.core.flow.a.c acq;
    private com.baidu.tbadk.core.flow.a<T> acr;
    private com.baidu.tbadk.core.flow.b acs;
    private CoverFlowView<T>.a act;
    private d<T> acu;
    private CoverFlowView<T>.c acv;
    private CoverFlowView<T>.b acw;
    private long acx;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.act = new a();
        this.acv = new c();
        this.acw = new b();
        this.acx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.act = new a();
        this.acv = new c();
        this.acw = new b();
        this.acx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.act = new a();
        this.acv = new c();
        this.acw = new b();
        this.acx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.acu = dVar;
    }

    private void init(Context context) {
        az(context);
        aA(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aco);
        addView(this.acp);
        this.acr = new com.baidu.tbadk.core.flow.a<>(context);
        this.acr.setOnClickListener(this.acv);
        this.aco.setAdapter(this.acr);
        this.aco.setOnPageChangeListener(this.acw);
    }

    private void az(Context context) {
        this.aco = new ListViewPager(context);
    }

    private void aA(Context context) {
        this.acp = new IndicatorView(context);
        this.acp.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ct(int i) {
        if (this.acr == null) {
            return null;
        }
        return this.acr.ct(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acr.a(list, this.acs);
            int size = list.size();
            if (size > 1) {
                this.acp.setVisibility(0);
                this.acp.setCount(size);
                this.aco.setCurrentItem(1, false);
                this.acp.setPosition(0.0f);
                tw();
                return;
            }
            this.acp.setVisibility(8);
            tx();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acs = bVar;
            this.acq = bVar.tt();
            this.acq.g(this.acp);
            bVar.tu().a(this.aco);
            this.mCustomView = bVar.tv();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aco);
                addView(this.mCustomView);
                addView(this.acp);
            }
        }
    }

    public void tw() {
        ty();
    }

    public void tx() {
        this.act.removeMessages(1);
    }

    public void ty() {
        this.act.removeMessages(1);
        this.act.sendEmptyMessageDelayed(1, this.acx);
    }

    public void setMarqueenTime(long j) {
        this.acx = j;
        ty();
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
                    CoverFlowView.this.tz();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        int count;
        if (this.aco != null && this.acr != null && (count = this.acr.getCount()) > 1) {
            int currentItem = this.aco.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aco.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aco.setCurrentItem(1, false);
            } else {
                this.aco.setCurrentItem(currentItem + 1);
            }
            this.aco.invalidate();
        }
    }

    private boolean tA() {
        int count;
        if (this.acr != null && (count = this.acr.getCount()) > 1) {
            int currentItem = this.aco.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aco.setCurrentItem(i, false);
                this.aco.invalidate();
            } else if (currentItem > i) {
                this.aco.setCurrentItem(1, false);
                this.aco.invalidate();
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

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.acp != null && CoverFlowView.this.acr != null && CoverFlowView.this.acp.getVisibility() == 0) {
                int count = CoverFlowView.this.acr.getCount();
                if (i == 0) {
                    CoverFlowView.this.acp.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acp.setPosition(f);
                } else {
                    CoverFlowView.this.acp.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acr != null) {
                int count = CoverFlowView.this.acr.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.acu != null) {
                    CoverFlowView.this.acu.a(i, CoverFlowView.this.acr.ct(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aco != null && CoverFlowView.this.acr != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tB();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB() {
        if (tA()) {
            ty();
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
            com.baidu.tbadk.core.flow.a.a ct;
            if (CoverFlowView.this.acu != null && (view.getTag() instanceof Integer) && (ct = CoverFlowView.this.acr.ct((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.acu.g(intValue, ct.pL());
            }
        }
    }

    public void onChangeSkinType() {
        this.acr.onChangeSkinType();
        if (this.acp != null && this.acq != null) {
            this.acp.setDrawable(aj.getDrawable(this.acq.tC()));
            this.acp.setSelector(aj.getDrawable(this.acq.tD()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aco != null) {
            this.aco.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aco != null) {
            this.aco.setDisableParentEvent(z);
        }
    }
}
