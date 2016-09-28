package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager WR;
    private IndicatorView WS;
    private com.baidu.tbadk.core.flow.a.c WT;
    private com.baidu.tbadk.core.flow.a<T> WU;
    private com.baidu.tbadk.core.flow.b WV;
    private CoverFlowView<T>.a WW;
    private d<T> WX;
    private CoverFlowView<T>.c WY;
    private CoverFlowView<T>.b WZ;
    private long Xa;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.WW = new a(this, null);
        this.WY = new c(this, null);
        this.WZ = new b(this, null);
        this.Xa = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.WW = new a(this, null);
        this.WY = new c(this, null);
        this.WZ = new b(this, null);
        this.Xa = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.WW = new a(this, null);
        this.WY = new c(this, null);
        this.WZ = new b(this, null);
        this.Xa = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.WX = dVar;
    }

    private void init(Context context) {
        T(context);
        U(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.WR);
        addView(this.WS);
        this.WU = new com.baidu.tbadk.core.flow.a<>(context);
        this.WU.setOnClickListener(this.WY);
        this.WR.setAdapter(this.WU);
        this.WR.setOnPageChangeListener(this.WZ);
    }

    private void T(Context context) {
        this.WR = new ListViewPager(context);
    }

    private void U(Context context) {
        this.WS = new IndicatorView(context);
        this.WS.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.WU.a(list, this.WV);
            int size = list.size();
            if (size > 1) {
                this.WS.setVisibility(0);
                this.WS.setCount(size);
                this.WR.setCurrentItem(1, false);
                this.WS.setPosition(0.0f);
                tB();
                return;
            }
            this.WS.setVisibility(8);
            tC();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.WV = bVar;
            this.WT = bVar.ty();
            this.WT.g(this.WS);
            bVar.tz().b(this.WR);
            this.mCustomView = bVar.tA();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.WR);
                addView(this.mCustomView);
                addView(this.WS);
            }
        }
    }

    public void tB() {
        tD();
    }

    public void tC() {
        this.WW.removeMessages(1);
    }

    public void tD() {
        this.WW.removeMessages(1);
        this.WW.sendEmptyMessageDelayed(1, this.Xa);
    }

    public void setMarqueenTime(long j) {
        this.Xa = j;
        tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(CoverFlowView coverFlowView, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.tE();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        int count;
        if (this.WR != null && this.WU != null && (count = this.WU.getCount()) > 1) {
            int currentItem = this.WR.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WR.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.WR.setCurrentItem(1, false);
            } else {
                this.WR.setCurrentItem(currentItem + 1);
            }
            this.WR.invalidate();
        }
    }

    private boolean tF() {
        int count;
        if (this.WU != null && (count = this.WU.getCount()) > 1) {
            int currentItem = this.WR.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WR.setCurrentItem(i, false);
                this.WR.invalidate();
            } else if (currentItem > i) {
                this.WR.setCurrentItem(1, false);
                this.WR.invalidate();
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

        /* synthetic */ b(CoverFlowView coverFlowView, b bVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.WS != null && CoverFlowView.this.WU != null && CoverFlowView.this.WS.getVisibility() == 0) {
                int count = CoverFlowView.this.WU.getCount();
                if (i == 0) {
                    CoverFlowView.this.WS.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.WS.setPosition(f);
                } else {
                    CoverFlowView.this.WS.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.WU != null) {
                int count = CoverFlowView.this.WU.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.WX != null) {
                    CoverFlowView.this.WX.a(i, CoverFlowView.this.WU.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.WR == null || CoverFlowView.this.WU == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tG();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG() {
        if (tF()) {
            tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(CoverFlowView coverFlowView, c cVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a cq;
            if (CoverFlowView.this.WX != null && (view.getTag() instanceof Integer) && (cq = CoverFlowView.this.WU.cq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.WX.g(intValue, cq.getPicLinkUrl());
            }
        }
    }

    public void tx() {
        this.WU.tx();
        if (this.WS != null && this.WT != null) {
            this.WS.setDrawable(av.getDrawable(this.WT.tH()));
            this.WS.setSelector(av.getDrawable(this.WT.tI()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.WR != null) {
            this.WR.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.WR != null) {
            this.WR.setDisableParentEvent(z);
        }
    }
}
