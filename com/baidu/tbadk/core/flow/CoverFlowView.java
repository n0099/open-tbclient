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
    private SquareViewPager TP;
    private IndicatorView TQ;
    private com.baidu.tbadk.core.flow.a.c TR;
    private com.baidu.tbadk.core.flow.a<T> TS;
    private com.baidu.tbadk.core.flow.b TT;
    private CoverFlowView<T>.a TU;
    private d<T> TV;
    private CoverFlowView<T>.c TW;
    private CoverFlowView<T>.b TX;
    private long TY;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.TU = new a(this, null);
        this.TW = new c(this, null);
        this.TX = new b(this, null);
        this.TY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.TU = new a(this, null);
        this.TW = new c(this, null);
        this.TX = new b(this, null);
        this.TY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.TU = new a(this, null);
        this.TW = new c(this, null);
        this.TX = new b(this, null);
        this.TY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.TV = dVar;
    }

    private void init(Context context) {
        J(context);
        K(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.TP);
        addView(this.TQ);
        this.TS = new com.baidu.tbadk.core.flow.a<>(context);
        this.TS.setOnClickListener(this.TW);
        this.TP.setAdapter(this.TS);
        this.TP.setOnPageChangeListener(this.TX);
    }

    private void J(Context context) {
        this.TP = new SquareViewPager(context);
    }

    private void K(Context context) {
        this.TQ = new IndicatorView(context);
        this.TQ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.TS.a(list, this.TT);
            int size = list.size();
            if (size > 1) {
                this.TQ.setVisibility(0);
                this.TQ.setCount(size);
                this.TP.setCurrentItem(1, false);
                this.TQ.setPosition(0.0f);
                sh();
                return;
            }
            this.TQ.setVisibility(8);
            si();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.TT = bVar;
            this.TR = bVar.se();
            this.TR.g(this.TQ);
            bVar.sf().b(this.TP);
            this.mCustomView = bVar.sg();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.TP);
                addView(this.mCustomView);
                addView(this.TQ);
            }
        }
    }

    public void sh() {
        sj();
    }

    public void si() {
        this.TU.removeMessages(1);
    }

    public void sj() {
        this.TU.removeMessages(1);
        this.TU.sendEmptyMessageDelayed(1, this.TY);
    }

    public void setMarqueenTime(long j) {
        this.TY = j;
        sj();
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
                    CoverFlowView.this.sk();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk() {
        int count;
        if (this.TP != null && this.TS != null && (count = this.TS.getCount()) > 1) {
            int currentItem = this.TP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.TP.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.TP.setCurrentItem(1, false);
            } else {
                this.TP.setCurrentItem(currentItem + 1);
            }
            this.TP.invalidate();
        }
    }

    private boolean sl() {
        int count;
        if (this.TS != null && (count = this.TS.getCount()) > 1) {
            int currentItem = this.TP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.TP.setCurrentItem(i, false);
                this.TP.invalidate();
            } else if (currentItem > i) {
                this.TP.setCurrentItem(1, false);
                this.TP.invalidate();
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
            if (CoverFlowView.this.TQ != null && CoverFlowView.this.TS != null && CoverFlowView.this.TQ.getVisibility() == 0) {
                int count = CoverFlowView.this.TS.getCount();
                if (i == 0) {
                    CoverFlowView.this.TQ.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.TQ.setPosition(f);
                } else {
                    CoverFlowView.this.TQ.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.TS != null) {
                int count = CoverFlowView.this.TS.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.TV != null) {
                    CoverFlowView.this.TV.a(i, CoverFlowView.this.TS.cd(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.TP == null || CoverFlowView.this.TS == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.sm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm() {
        if (sl()) {
            sj();
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
            com.baidu.tbadk.core.flow.a.a cd;
            if (CoverFlowView.this.TV != null && (view.getTag() instanceof Integer) && (cd = CoverFlowView.this.TS.cd((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.TV.g(intValue, cd.getPicLinkUrl());
            }
        }
    }

    public void sd() {
        this.TS.sd();
        if (this.TQ != null && this.TR != null) {
            this.TQ.setDrawable(av.getDrawable(this.TR.sn()));
            this.TQ.setSelector(av.getDrawable(this.TR.so()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.TP != null) {
            this.TP.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.TP != null) {
            this.TP.setDisableParentEvent(z);
        }
    }
}
