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
    private CoverFlowView<T>.b XA;
    private long XB;
    private SquareViewPager Xs;
    private IndicatorView Xt;
    private com.baidu.tbadk.core.flow.a.c Xu;
    private com.baidu.tbadk.core.flow.a<T> Xv;
    private com.baidu.tbadk.core.flow.b Xw;
    private CoverFlowView<T>.a Xx;
    private d<T> Xy;
    private CoverFlowView<T>.c Xz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Xx = new a(this, null);
        this.Xz = new c(this, null);
        this.XA = new b(this, null);
        this.XB = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Xx = new a(this, null);
        this.Xz = new c(this, null);
        this.XA = new b(this, null);
        this.XB = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Xx = new a(this, null);
        this.Xz = new c(this, null);
        this.XA = new b(this, null);
        this.XB = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Xy = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Xs);
        addView(this.Xt);
        this.Xv = new com.baidu.tbadk.core.flow.a<>(context);
        this.Xv.setOnClickListener(this.Xz);
        this.Xs.setAdapter(this.Xv);
        this.Xs.setOnPageChangeListener(this.XA);
    }

    private void Y(Context context) {
        this.Xs = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Xt = new IndicatorView(context);
        this.Xt.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bW(int i) {
        if (this.Xv == null) {
            return null;
        }
        return this.Xv.bW(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Xv.a(list, this.Xw);
            int size = list.size();
            if (size > 1) {
                this.Xt.setVisibility(0);
                this.Xt.setCount(size);
                this.Xs.setCurrentItem(1, false);
                this.Xt.setPosition(0.0f);
                td();
                return;
            }
            this.Xt.setVisibility(8);
            te();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Xw = bVar;
            this.Xu = bVar.ta();
            this.Xu.g(this.Xt);
            bVar.tb().a(this.Xs);
            this.mCustomView = bVar.tc();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Xs);
                addView(this.mCustomView);
                addView(this.Xt);
            }
        }
    }

    public void td() {
        tf();
    }

    public void te() {
        this.Xx.removeMessages(1);
    }

    public void tf() {
        this.Xx.removeMessages(1);
        this.Xx.sendEmptyMessageDelayed(1, this.XB);
    }

    public void setMarqueenTime(long j) {
        this.XB = j;
        tf();
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
                    CoverFlowView.this.tg();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        int count;
        if (this.Xs != null && this.Xv != null && (count = this.Xv.getCount()) > 1) {
            int currentItem = this.Xs.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xs.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Xs.setCurrentItem(1, false);
            } else {
                this.Xs.setCurrentItem(currentItem + 1);
            }
            this.Xs.invalidate();
        }
    }

    private boolean th() {
        int count;
        if (this.Xv != null && (count = this.Xv.getCount()) > 1) {
            int currentItem = this.Xs.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xs.setCurrentItem(i, false);
                this.Xs.invalidate();
            } else if (currentItem > i) {
                this.Xs.setCurrentItem(1, false);
                this.Xs.invalidate();
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
            if (CoverFlowView.this.Xt != null && CoverFlowView.this.Xv != null && CoverFlowView.this.Xt.getVisibility() == 0) {
                int count = CoverFlowView.this.Xv.getCount();
                if (i == 0) {
                    CoverFlowView.this.Xt.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Xt.setPosition(f);
                } else {
                    CoverFlowView.this.Xt.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Xv != null) {
                int count = CoverFlowView.this.Xv.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Xy != null) {
                    CoverFlowView.this.Xy.a(i, CoverFlowView.this.Xv.bW(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Xs == null || CoverFlowView.this.Xv == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.ti();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        if (th()) {
            tf();
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
            if (CoverFlowView.this.Xy != null && (view.getTag() instanceof Integer) && (bW = CoverFlowView.this.Xv.bW((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Xy.o(intValue, bW.rv());
            }
        }
    }

    public void sZ() {
        this.Xv.sZ();
        if (this.Xt != null && this.Xu != null) {
            this.Xt.setDrawable(an.getDrawable(this.Xu.tj()));
            this.Xt.setSelector(an.getDrawable(this.Xu.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Xs != null) {
            this.Xs.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Xs != null) {
            this.Xs.setDisableParentEvent(z);
        }
    }
}
