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
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager WE;
    private IndicatorView WF;
    private com.baidu.tbadk.core.flow.a.c WG;
    private com.baidu.tbadk.core.flow.a<T> WH;
    private com.baidu.tbadk.core.flow.b WI;
    private CoverFlowView<T>.a WJ;
    private d<T> WK;
    private CoverFlowView<T>.c WL;
    private CoverFlowView<T>.b WM;
    private long WN;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.WJ = new a(this, null);
        this.WL = new c(this, null);
        this.WM = new b(this, null);
        this.WN = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.WJ = new a(this, null);
        this.WL = new c(this, null);
        this.WM = new b(this, null);
        this.WN = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.WJ = new a(this, null);
        this.WL = new c(this, null);
        this.WM = new b(this, null);
        this.WN = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.WK = dVar;
    }

    private void init(Context context) {
        T(context);
        U(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.WE);
        addView(this.WF);
        this.WH = new com.baidu.tbadk.core.flow.a<>(context);
        this.WH.setOnClickListener(this.WL);
        this.WE.setAdapter(this.WH);
        this.WE.setOnPageChangeListener(this.WM);
    }

    private void T(Context context) {
        this.WE = new SquareViewPager(context);
    }

    private void U(Context context) {
        this.WF = new IndicatorView(context);
        this.WF.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.WH.a(list, this.WI);
            int size = list.size();
            if (size > 1) {
                this.WF.setVisibility(0);
                this.WF.setCount(size);
                this.WE.setCurrentItem(1, false);
                this.WF.setPosition(0.0f);
                tm();
                return;
            }
            this.WF.setVisibility(8);
            tn();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.WI = bVar;
            this.WG = bVar.tj();
            this.WG.g(this.WF);
            bVar.tk().b(this.WE);
            this.mCustomView = bVar.tl();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.WE);
                addView(this.mCustomView);
                addView(this.WF);
            }
        }
    }

    public void tm() {
        to();
    }

    public void tn() {
        this.WJ.removeMessages(1);
    }

    public void to() {
        this.WJ.removeMessages(1);
        this.WJ.sendEmptyMessageDelayed(1, this.WN);
    }

    public void setMarqueenTime(long j) {
        this.WN = j;
        to();
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
                    CoverFlowView.this.tp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp() {
        int count;
        if (this.WE != null && this.WH != null && (count = this.WH.getCount()) > 1) {
            int currentItem = this.WE.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WE.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.WE.setCurrentItem(1, false);
            } else {
                this.WE.setCurrentItem(currentItem + 1);
            }
            this.WE.invalidate();
        }
    }

    private boolean tq() {
        int count;
        if (this.WH != null && (count = this.WH.getCount()) > 1) {
            int currentItem = this.WE.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WE.setCurrentItem(i, false);
                this.WE.invalidate();
            } else if (currentItem > i) {
                this.WE.setCurrentItem(1, false);
                this.WE.invalidate();
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
            if (CoverFlowView.this.WF != null && CoverFlowView.this.WH != null && CoverFlowView.this.WF.getVisibility() == 0) {
                int count = CoverFlowView.this.WH.getCount();
                if (i == 0) {
                    CoverFlowView.this.WF.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.WF.setPosition(f);
                } else {
                    CoverFlowView.this.WF.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.WH != null) {
                int count = CoverFlowView.this.WH.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.WK != null) {
                    CoverFlowView.this.WK.a(i, CoverFlowView.this.WH.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.WE == null || CoverFlowView.this.WH == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tr();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr() {
        if (tq()) {
            to();
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
            if (CoverFlowView.this.WK != null && (view.getTag() instanceof Integer) && (cq = CoverFlowView.this.WH.cq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.WK.g(intValue, cq.getPicLinkUrl());
            }
        }
    }

    public void ti() {
        this.WH.ti();
        if (this.WF != null && this.WG != null) {
            this.WF.setDrawable(av.getDrawable(this.WG.ts()));
            this.WF.setSelector(av.getDrawable(this.WG.tt()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.WE != null) {
            this.WE.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.WE != null) {
            this.WE.setDisableParentEvent(z);
        }
    }
}
