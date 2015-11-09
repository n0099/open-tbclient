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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private CoverFlowView<T>.a XA;
    private d<T> XB;
    private CoverFlowView<T>.c XC;
    private CoverFlowView<T>.b XD;
    private long XE;
    private SquareViewPager Xv;
    private IndicatorView Xw;
    private com.baidu.tbadk.core.flow.a.c Xx;
    private com.baidu.tbadk.core.flow.a<T> Xy;
    private com.baidu.tbadk.core.flow.b Xz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.XA = new a(this, null);
        this.XC = new c(this, null);
        this.XD = new b(this, null);
        this.XE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.XA = new a(this, null);
        this.XC = new c(this, null);
        this.XD = new b(this, null);
        this.XE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.XA = new a(this, null);
        this.XC = new c(this, null);
        this.XD = new b(this, null);
        this.XE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.XB = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Xv);
        addView(this.Xw);
        this.Xy = new com.baidu.tbadk.core.flow.a<>(context);
        this.Xy.setOnClickListener(this.XC);
        this.Xv.setAdapter(this.Xy);
        this.Xv.setOnPageChangeListener(this.XD);
    }

    private void Y(Context context) {
        this.Xv = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Xw = new IndicatorView(context);
        this.Xw.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bW(int i) {
        if (this.Xy == null) {
            return null;
        }
        return this.Xy.bW(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Xy.a(list, this.Xz);
            int size = list.size();
            if (size > 1) {
                this.Xw.setVisibility(0);
                this.Xw.setCount(size);
                this.Xv.setCurrentItem(1, false);
                this.Xw.setPosition(0.0f);
                tg();
                return;
            }
            this.Xw.setVisibility(8);
            th();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Xz = bVar;
            this.Xx = bVar.td();
            this.Xx.g(this.Xw);
            bVar.te().a(this.Xv);
            this.mCustomView = bVar.tf();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Xv);
                addView(this.mCustomView);
                addView(this.Xw);
            }
        }
    }

    public void tg() {
        ti();
    }

    public void th() {
        this.XA.removeMessages(1);
    }

    public void ti() {
        this.XA.removeMessages(1);
        this.XA.sendEmptyMessageDelayed(1, this.XE);
    }

    public void setMarqueenTime(long j) {
        this.XE = j;
        ti();
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
                    CoverFlowView.this.tj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        int count;
        if (this.Xv != null && this.Xy != null && (count = this.Xy.getCount()) > 1) {
            int currentItem = this.Xv.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xv.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Xv.setCurrentItem(1, false);
            } else {
                this.Xv.setCurrentItem(currentItem + 1);
            }
            this.Xv.invalidate();
        }
    }

    private boolean tk() {
        int count;
        if (this.Xy != null && (count = this.Xy.getCount()) > 1) {
            int currentItem = this.Xv.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xv.setCurrentItem(i, false);
                this.Xv.invalidate();
            } else if (currentItem > i) {
                this.Xv.setCurrentItem(1, false);
                this.Xv.invalidate();
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
            if (CoverFlowView.this.Xw != null && CoverFlowView.this.Xy != null && CoverFlowView.this.Xw.getVisibility() == 0) {
                int count = CoverFlowView.this.Xy.getCount();
                if (i == 0) {
                    CoverFlowView.this.Xw.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Xw.setPosition(f);
                } else {
                    CoverFlowView.this.Xw.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Xy != null) {
                int count = CoverFlowView.this.Xy.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.XB != null) {
                    CoverFlowView.this.XB.a(i, CoverFlowView.this.Xy.bW(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Xv == null || CoverFlowView.this.Xy == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (tk()) {
            ti();
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
            com.baidu.tbadk.core.flow.a.a bW;
            if (CoverFlowView.this.XB != null && (view.getTag() instanceof Integer) && (bW = CoverFlowView.this.Xy.bW((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.XB.o(intValue, bW.rw());
            }
        }
    }

    public void tc() {
        this.Xy.tc();
        if (this.Xw != null && this.Xx != null) {
            this.Xw.setDrawable(an.getDrawable(this.Xx.tm()));
            this.Xw.setSelector(an.getDrawable(this.Xx.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Xv != null) {
            this.Xv.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Xv != null) {
            this.Xv.setDisableParentEvent(z);
        }
    }
}
