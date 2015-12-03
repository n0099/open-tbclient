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
    private SquareViewPager Yi;
    private IndicatorView Yj;
    private com.baidu.tbadk.core.flow.a.c Yk;
    private com.baidu.tbadk.core.flow.a<T> Yl;
    private com.baidu.tbadk.core.flow.b Ym;
    private CoverFlowView<T>.a Yn;
    private d<T> Yo;
    private CoverFlowView<T>.c Yp;
    private CoverFlowView<T>.b Yq;
    private long Yr;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Yn = new a(this, null);
        this.Yp = new c(this, null);
        this.Yq = new b(this, null);
        this.Yr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Yn = new a(this, null);
        this.Yp = new c(this, null);
        this.Yq = new b(this, null);
        this.Yr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Yn = new a(this, null);
        this.Yp = new c(this, null);
        this.Yq = new b(this, null);
        this.Yr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Yo = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Yi);
        addView(this.Yj);
        this.Yl = new com.baidu.tbadk.core.flow.a<>(context);
        this.Yl.setOnClickListener(this.Yp);
        this.Yi.setAdapter(this.Yl);
        this.Yi.setOnPageChangeListener(this.Yq);
    }

    private void Y(Context context) {
        this.Yi = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Yj = new IndicatorView(context);
        this.Yj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Yl.a(list, this.Ym);
            int size = list.size();
            if (size > 1) {
                this.Yj.setVisibility(0);
                this.Yj.setCount(size);
                this.Yi.setCurrentItem(1, false);
                this.Yj.setPosition(0.0f);
                tL();
                return;
            }
            this.Yj.setVisibility(8);
            tM();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Ym = bVar;
            this.Yk = bVar.tI();
            this.Yk.g(this.Yj);
            bVar.tJ().a(this.Yi);
            this.mCustomView = bVar.tK();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Yi);
                addView(this.mCustomView);
                addView(this.Yj);
            }
        }
    }

    public void tL() {
        tN();
    }

    public void tM() {
        this.Yn.removeMessages(1);
    }

    public void tN() {
        this.Yn.removeMessages(1);
        this.Yn.sendEmptyMessageDelayed(1, this.Yr);
    }

    public void setMarqueenTime(long j) {
        this.Yr = j;
        tN();
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
                    CoverFlowView.this.tO();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO() {
        int count;
        if (this.Yi != null && this.Yl != null && (count = this.Yl.getCount()) > 1) {
            int currentItem = this.Yi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Yi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Yi.setCurrentItem(1, false);
            } else {
                this.Yi.setCurrentItem(currentItem + 1);
            }
            this.Yi.invalidate();
        }
    }

    private boolean tP() {
        int count;
        if (this.Yl != null && (count = this.Yl.getCount()) > 1) {
            int currentItem = this.Yi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Yi.setCurrentItem(i, false);
                this.Yi.invalidate();
            } else if (currentItem > i) {
                this.Yi.setCurrentItem(1, false);
                this.Yi.invalidate();
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
            if (CoverFlowView.this.Yj != null && CoverFlowView.this.Yl != null && CoverFlowView.this.Yj.getVisibility() == 0) {
                int count = CoverFlowView.this.Yl.getCount();
                if (i == 0) {
                    CoverFlowView.this.Yj.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Yj.setPosition(f);
                } else {
                    CoverFlowView.this.Yj.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Yl != null) {
                int count = CoverFlowView.this.Yl.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Yo != null) {
                    CoverFlowView.this.Yo.a(i, CoverFlowView.this.Yl.ce(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Yi == null || CoverFlowView.this.Yl == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tQ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ() {
        if (tP()) {
            tN();
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
            com.baidu.tbadk.core.flow.a.a ce;
            if (CoverFlowView.this.Yo != null && (view.getTag() instanceof Integer) && (ce = CoverFlowView.this.Yl.ce((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Yo.o(intValue, ce.rK());
            }
        }
    }

    public void tH() {
        this.Yl.tH();
        if (this.Yj != null && this.Yk != null) {
            this.Yj.setDrawable(as.getDrawable(this.Yk.tR()));
            this.Yj.setSelector(as.getDrawable(this.Yk.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Yi != null) {
            this.Yi.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Yi != null) {
            this.Yi.setDisableParentEvent(z);
        }
    }
}
