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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager Xq;
    private IndicatorView Xr;
    private com.baidu.tbadk.core.flow.a.c Xs;
    private com.baidu.tbadk.core.flow.a<T> Xt;
    private com.baidu.tbadk.core.flow.b Xu;
    private CoverFlowView<T>.a Xv;
    private d<T> Xw;
    private CoverFlowView<T>.c Xx;
    private CoverFlowView<T>.b Xy;
    private long Xz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Xv = new a(this, null);
        this.Xx = new c(this, null);
        this.Xy = new b(this, null);
        this.Xz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Xv = new a(this, null);
        this.Xx = new c(this, null);
        this.Xy = new b(this, null);
        this.Xz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Xv = new a(this, null);
        this.Xx = new c(this, null);
        this.Xy = new b(this, null);
        this.Xz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Xw = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Xq);
        addView(this.Xr);
        this.Xt = new com.baidu.tbadk.core.flow.a<>(context);
        this.Xt.setOnClickListener(this.Xx);
        this.Xq.setAdapter(this.Xt);
        this.Xq.setOnPageChangeListener(this.Xy);
    }

    private void Y(Context context) {
        this.Xq = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Xr = new IndicatorView(context);
        this.Xr.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bW(int i) {
        if (this.Xt == null) {
            return null;
        }
        return this.Xt.bW(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Xt.a(list, this.Xu);
            int size = list.size();
            if (size > 1) {
                this.Xr.setVisibility(0);
                this.Xr.setCount(size);
                this.Xq.setCurrentItem(1, false);
                this.Xr.setPosition(0.0f);
                tg();
                return;
            }
            this.Xr.setVisibility(8);
            th();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Xu = bVar;
            this.Xs = bVar.td();
            this.Xs.g(this.Xr);
            bVar.te().a(this.Xq);
            this.mCustomView = bVar.tf();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Xq);
                addView(this.mCustomView);
                addView(this.Xr);
            }
        }
    }

    public void tg() {
        ti();
    }

    public void th() {
        this.Xv.removeMessages(1);
    }

    public void ti() {
        this.Xv.removeMessages(1);
        this.Xv.sendEmptyMessageDelayed(1, this.Xz);
    }

    public void setMarqueenTime(long j) {
        this.Xz = j;
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
        if (this.Xq != null && this.Xt != null && (count = this.Xt.getCount()) > 1) {
            int currentItem = this.Xq.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xq.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Xq.setCurrentItem(1, false);
            } else {
                this.Xq.setCurrentItem(currentItem + 1);
            }
            this.Xq.invalidate();
        }
    }

    private boolean tk() {
        int count;
        if (this.Xt != null && (count = this.Xt.getCount()) > 1) {
            int currentItem = this.Xq.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xq.setCurrentItem(i, false);
                this.Xq.invalidate();
            } else if (currentItem > i) {
                this.Xq.setCurrentItem(1, false);
                this.Xq.invalidate();
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
            if (CoverFlowView.this.Xr != null && CoverFlowView.this.Xt != null && CoverFlowView.this.Xr.getVisibility() == 0) {
                int count = CoverFlowView.this.Xt.getCount();
                if (i == 0) {
                    CoverFlowView.this.Xr.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Xr.setPosition(f);
                } else {
                    CoverFlowView.this.Xr.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Xt != null) {
                int count = CoverFlowView.this.Xt.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Xw != null) {
                    CoverFlowView.this.Xw.a(i, CoverFlowView.this.Xt.bW(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Xq == null || CoverFlowView.this.Xt == null) {
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
            if (CoverFlowView.this.Xw != null && (view.getTag() instanceof Integer) && (bW = CoverFlowView.this.Xt.bW((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Xw.o(intValue, bW.ry());
            }
        }
    }

    public void tc() {
        this.Xt.tc();
        if (this.Xr != null && this.Xs != null) {
            this.Xr.setDrawable(am.getDrawable(this.Xs.tm()));
            this.Xr.setSelector(am.getDrawable(this.Xs.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Xq != null) {
            this.Xq.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Xq != null) {
            this.Xq.setDisableParentEvent(z);
        }
    }
}
