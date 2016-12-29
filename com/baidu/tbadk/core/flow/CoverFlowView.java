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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager WJ;
    private IndicatorView WK;
    private com.baidu.tbadk.core.flow.a.c WL;
    private com.baidu.tbadk.core.flow.a<T> WM;
    private com.baidu.tbadk.core.flow.b WN;
    private CoverFlowView<T>.a WO;
    private d<T> WP;
    private CoverFlowView<T>.c WQ;
    private CoverFlowView<T>.b WR;
    private long WS;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.WO = new a(this, null);
        this.WQ = new c(this, null);
        this.WR = new b(this, null);
        this.WS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.WO = new a(this, null);
        this.WQ = new c(this, null);
        this.WR = new b(this, null);
        this.WS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.WO = new a(this, null);
        this.WQ = new c(this, null);
        this.WR = new b(this, null);
        this.WS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.WP = dVar;
    }

    private void init(Context context) {
        R(context);
        S(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.WJ);
        addView(this.WK);
        this.WM = new com.baidu.tbadk.core.flow.a<>(context);
        this.WM.setOnClickListener(this.WQ);
        this.WJ.setAdapter(this.WM);
        this.WJ.setOnPageChangeListener(this.WR);
    }

    private void R(Context context) {
        this.WJ = new ListViewPager(context);
    }

    private void S(Context context) {
        this.WK = new IndicatorView(context);
        this.WK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.WM.a(list, this.WN);
            int size = list.size();
            if (size > 1) {
                this.WK.setVisibility(0);
                this.WK.setCount(size);
                this.WJ.setCurrentItem(1, false);
                this.WK.setPosition(0.0f);
                tq();
                return;
            }
            this.WK.setVisibility(8);
            tr();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.WN = bVar;
            this.WL = bVar.tn();
            this.WL.g(this.WK);
            bVar.to().b(this.WJ);
            this.mCustomView = bVar.tp();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.WJ);
                addView(this.mCustomView);
                addView(this.WK);
            }
        }
    }

    public void tq() {
        ts();
    }

    public void tr() {
        this.WO.removeMessages(1);
    }

    public void ts() {
        this.WO.removeMessages(1);
        this.WO.sendEmptyMessageDelayed(1, this.WS);
    }

    public void setMarqueenTime(long j) {
        this.WS = j;
        ts();
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
                    CoverFlowView.this.tt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        int count;
        if (this.WJ != null && this.WM != null && (count = this.WM.getCount()) > 1) {
            int currentItem = this.WJ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WJ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.WJ.setCurrentItem(1, false);
            } else {
                this.WJ.setCurrentItem(currentItem + 1);
            }
            this.WJ.invalidate();
        }
    }

    private boolean tu() {
        int count;
        if (this.WM != null && (count = this.WM.getCount()) > 1) {
            int currentItem = this.WJ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.WJ.setCurrentItem(i, false);
                this.WJ.invalidate();
            } else if (currentItem > i) {
                this.WJ.setCurrentItem(1, false);
                this.WJ.invalidate();
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
            if (CoverFlowView.this.WK != null && CoverFlowView.this.WM != null && CoverFlowView.this.WK.getVisibility() == 0) {
                int count = CoverFlowView.this.WM.getCount();
                if (i == 0) {
                    CoverFlowView.this.WK.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.WK.setPosition(f);
                } else {
                    CoverFlowView.this.WK.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.WM != null) {
                int count = CoverFlowView.this.WM.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.WP != null) {
                    CoverFlowView.this.WP.a(i, CoverFlowView.this.WM.ct(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.WJ == null || CoverFlowView.this.WM == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tv();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv() {
        if (tu()) {
            ts();
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
            com.baidu.tbadk.core.flow.a.a ct;
            if (CoverFlowView.this.WP != null && (view.getTag() instanceof Integer) && (ct = CoverFlowView.this.WM.ct((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.WP.f(intValue, ct.pI());
            }
        }
    }

    public void tm() {
        this.WM.tm();
        if (this.WK != null && this.WL != null) {
            this.WK.setDrawable(ar.getDrawable(this.WL.tw()));
            this.WK.setSelector(ar.getDrawable(this.WL.tx()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.WJ != null) {
            this.WJ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.WJ != null) {
            this.WJ.setDisableParentEvent(z);
        }
    }
}
