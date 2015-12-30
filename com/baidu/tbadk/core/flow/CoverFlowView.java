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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager YL;
    private IndicatorView YM;
    private com.baidu.tbadk.core.flow.a.c YN;
    private com.baidu.tbadk.core.flow.a<T> YO;
    private com.baidu.tbadk.core.flow.b YP;
    private CoverFlowView<T>.a YQ;
    private d<T> YR;
    private CoverFlowView<T>.c YS;
    private CoverFlowView<T>.b YT;
    private long YU;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.YQ = new a(this, null);
        this.YS = new c(this, null);
        this.YT = new b(this, null);
        this.YU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.YQ = new a(this, null);
        this.YS = new c(this, null);
        this.YT = new b(this, null);
        this.YU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.YQ = new a(this, null);
        this.YS = new c(this, null);
        this.YT = new b(this, null);
        this.YU = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.YR = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.YL);
        addView(this.YM);
        this.YO = new com.baidu.tbadk.core.flow.a<>(context);
        this.YO.setOnClickListener(this.YS);
        this.YL.setAdapter(this.YO);
        this.YL.setOnPageChangeListener(this.YT);
    }

    private void Y(Context context) {
        this.YL = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.YM = new IndicatorView(context);
        this.YM.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.YO.a(list, this.YP);
            int size = list.size();
            if (size > 1) {
                this.YM.setVisibility(0);
                this.YM.setCount(size);
                this.YL.setCurrentItem(1, false);
                this.YM.setPosition(0.0f);
                tv();
                return;
            }
            this.YM.setVisibility(8);
            tw();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.YP = bVar;
            this.YN = bVar.ts();
            this.YN.g(this.YM);
            bVar.tt().a(this.YL);
            this.mCustomView = bVar.tu();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.YL);
                addView(this.mCustomView);
                addView(this.YM);
            }
        }
    }

    public void tv() {
        tx();
    }

    public void tw() {
        this.YQ.removeMessages(1);
    }

    public void tx() {
        this.YQ.removeMessages(1);
        this.YQ.sendEmptyMessageDelayed(1, this.YU);
    }

    public void setMarqueenTime(long j) {
        this.YU = j;
        tx();
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
                    CoverFlowView.this.ty();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty() {
        int count;
        if (this.YL != null && this.YO != null && (count = this.YO.getCount()) > 1) {
            int currentItem = this.YL.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.YL.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.YL.setCurrentItem(1, false);
            } else {
                this.YL.setCurrentItem(currentItem + 1);
            }
            this.YL.invalidate();
        }
    }

    private boolean tz() {
        int count;
        if (this.YO != null && (count = this.YO.getCount()) > 1) {
            int currentItem = this.YL.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.YL.setCurrentItem(i, false);
                this.YL.invalidate();
            } else if (currentItem > i) {
                this.YL.setCurrentItem(1, false);
                this.YL.invalidate();
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
            if (CoverFlowView.this.YM != null && CoverFlowView.this.YO != null && CoverFlowView.this.YM.getVisibility() == 0) {
                int count = CoverFlowView.this.YO.getCount();
                if (i == 0) {
                    CoverFlowView.this.YM.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.YM.setPosition(f);
                } else {
                    CoverFlowView.this.YM.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.YO != null) {
                int count = CoverFlowView.this.YO.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.YR != null) {
                    CoverFlowView.this.YR.a(i, CoverFlowView.this.YO.bX(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.YL == null || CoverFlowView.this.YO == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tA() {
        if (tz()) {
            tx();
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
            com.baidu.tbadk.core.flow.a.a bX;
            if (CoverFlowView.this.YR != null && (view.getTag() instanceof Integer) && (bX = CoverFlowView.this.YO.bX((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.YR.o(intValue, bX.rt());
            }
        }
    }

    public void tr() {
        this.YO.tr();
        if (this.YM != null && this.YN != null) {
            this.YM.setDrawable(as.getDrawable(this.YN.tB()));
            this.YM.setSelector(as.getDrawable(this.YN.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.YL != null) {
            this.YL.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.YL != null) {
            this.YL.setDisableParentEvent(z);
        }
    }
}
