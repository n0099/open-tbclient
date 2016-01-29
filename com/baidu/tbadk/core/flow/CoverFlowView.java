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
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager Zi;
    private IndicatorView Zj;
    private com.baidu.tbadk.core.flow.a.c Zk;
    private com.baidu.tbadk.core.flow.a<T> Zl;
    private com.baidu.tbadk.core.flow.b Zm;
    private CoverFlowView<T>.a Zn;
    private d<T> Zo;
    private CoverFlowView<T>.c Zp;
    private CoverFlowView<T>.b Zq;
    private long Zr;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Zn = new a(this, null);
        this.Zp = new c(this, null);
        this.Zq = new b(this, null);
        this.Zr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Zn = new a(this, null);
        this.Zp = new c(this, null);
        this.Zq = new b(this, null);
        this.Zr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Zn = new a(this, null);
        this.Zp = new c(this, null);
        this.Zq = new b(this, null);
        this.Zr = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Zo = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Zi);
        addView(this.Zj);
        this.Zl = new com.baidu.tbadk.core.flow.a<>(context);
        this.Zl.setOnClickListener(this.Zp);
        this.Zi.setAdapter(this.Zl);
        this.Zi.setOnPageChangeListener(this.Zq);
    }

    private void Y(Context context) {
        this.Zi = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Zj = new IndicatorView(context);
        this.Zj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Zl.a(list, this.Zm);
            int size = list.size();
            if (size > 1) {
                this.Zj.setVisibility(0);
                this.Zj.setCount(size);
                this.Zi.setCurrentItem(1, false);
                this.Zj.setPosition(0.0f);
                uz();
                return;
            }
            this.Zj.setVisibility(8);
            uA();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Zm = bVar;
            this.Zk = bVar.uw();
            this.Zk.g(this.Zj);
            bVar.ux().a(this.Zi);
            this.mCustomView = bVar.uy();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Zi);
                addView(this.mCustomView);
                addView(this.Zj);
            }
        }
    }

    public void uz() {
        uB();
    }

    public void uA() {
        this.Zn.removeMessages(1);
    }

    public void uB() {
        this.Zn.removeMessages(1);
        this.Zn.sendEmptyMessageDelayed(1, this.Zr);
    }

    public void setMarqueenTime(long j) {
        this.Zr = j;
        uB();
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
                    CoverFlowView.this.uC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        int count;
        if (this.Zi != null && this.Zl != null && (count = this.Zl.getCount()) > 1) {
            int currentItem = this.Zi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Zi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Zi.setCurrentItem(1, false);
            } else {
                this.Zi.setCurrentItem(currentItem + 1);
            }
            this.Zi.invalidate();
        }
    }

    private boolean uD() {
        int count;
        if (this.Zl != null && (count = this.Zl.getCount()) > 1) {
            int currentItem = this.Zi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Zi.setCurrentItem(i, false);
                this.Zi.invalidate();
            } else if (currentItem > i) {
                this.Zi.setCurrentItem(1, false);
                this.Zi.invalidate();
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
            if (CoverFlowView.this.Zj != null && CoverFlowView.this.Zl != null && CoverFlowView.this.Zj.getVisibility() == 0) {
                int count = CoverFlowView.this.Zl.getCount();
                if (i == 0) {
                    CoverFlowView.this.Zj.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Zj.setPosition(f);
                } else {
                    CoverFlowView.this.Zj.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Zl != null) {
                int count = CoverFlowView.this.Zl.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Zo != null) {
                    CoverFlowView.this.Zo.a(i, CoverFlowView.this.Zl.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Zi == null || CoverFlowView.this.Zl == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.uE();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE() {
        if (uD()) {
            uB();
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
            if (CoverFlowView.this.Zo != null && (view.getTag() instanceof Integer) && (cq = CoverFlowView.this.Zl.cq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Zo.o(intValue, cq.rX());
            }
        }
    }

    public void uv() {
        this.Zl.uv();
        if (this.Zj != null && this.Zk != null) {
            this.Zj.setDrawable(ar.getDrawable(this.Zk.uF()));
            this.Zj.setSelector(ar.getDrawable(this.Zk.uG()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Zi != null) {
            this.Zi.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Zi != null) {
            this.Zi.setDisableParentEvent(z);
        }
    }
}
