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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private com.baidu.tbadk.core.flow.a.c XA;
    private com.baidu.tbadk.core.flow.a<T> XB;
    private com.baidu.tbadk.core.flow.b XC;
    private CoverFlowView<T>.a XD;
    private d<T> XE;
    private CoverFlowView<T>.c XF;
    private CoverFlowView<T>.b XG;
    private long XH;
    private SquareViewPager Xy;
    private IndicatorView Xz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.XD = new a(this, null);
        this.XF = new c(this, null);
        this.XG = new b(this, null);
        this.XH = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.XD = new a(this, null);
        this.XF = new c(this, null);
        this.XG = new b(this, null);
        this.XH = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.XD = new a(this, null);
        this.XF = new c(this, null);
        this.XG = new b(this, null);
        this.XH = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.XE = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Xy);
        addView(this.Xz);
        this.XB = new com.baidu.tbadk.core.flow.a<>(context);
        this.XB.setOnClickListener(this.XF);
        this.Xy.setAdapter(this.XB);
        this.Xy.setOnPageChangeListener(this.XG);
    }

    private void Y(Context context) {
        this.Xy = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Xz = new IndicatorView(context);
        this.Xz.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bW(int i) {
        if (this.XB == null) {
            return null;
        }
        return this.XB.bW(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.XB.a(list, this.XC);
            int size = list.size();
            if (size > 1) {
                this.Xz.setVisibility(0);
                this.Xz.setCount(size);
                this.Xy.setCurrentItem(1, false);
                this.Xz.setPosition(0.0f);
                tj();
                return;
            }
            this.Xz.setVisibility(8);
            tk();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.XC = bVar;
            this.XA = bVar.tg();
            this.XA.g(this.Xz);
            bVar.th().a(this.Xy);
            this.mCustomView = bVar.ti();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Xy);
                addView(this.mCustomView);
                addView(this.Xz);
            }
        }
    }

    public void tj() {
        tl();
    }

    public void tk() {
        this.XD.removeMessages(1);
    }

    public void tl() {
        this.XD.removeMessages(1);
        this.XD.sendEmptyMessageDelayed(1, this.XH);
    }

    public void setMarqueenTime(long j) {
        this.XH = j;
        tl();
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
                    CoverFlowView.this.tm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm() {
        int count;
        if (this.Xy != null && this.XB != null && (count = this.XB.getCount()) > 1) {
            int currentItem = this.Xy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xy.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Xy.setCurrentItem(1, false);
            } else {
                this.Xy.setCurrentItem(currentItem + 1);
            }
            this.Xy.invalidate();
        }
    }

    private boolean tn() {
        int count;
        if (this.XB != null && (count = this.XB.getCount()) > 1) {
            int currentItem = this.Xy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xy.setCurrentItem(i, false);
                this.Xy.invalidate();
            } else if (currentItem > i) {
                this.Xy.setCurrentItem(1, false);
                this.Xy.invalidate();
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
            if (CoverFlowView.this.Xz != null && CoverFlowView.this.XB != null && CoverFlowView.this.Xz.getVisibility() == 0) {
                int count = CoverFlowView.this.XB.getCount();
                if (i == 0) {
                    CoverFlowView.this.Xz.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Xz.setPosition(f);
                } else {
                    CoverFlowView.this.Xz.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.XB != null) {
                int count = CoverFlowView.this.XB.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.XE != null) {
                    CoverFlowView.this.XE.a(i, CoverFlowView.this.XB.bW(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Xy == null || CoverFlowView.this.XB == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.to();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to() {
        if (tn()) {
            tl();
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
            if (CoverFlowView.this.XE != null && (view.getTag() instanceof Integer) && (bW = CoverFlowView.this.XB.bW((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.XE.o(intValue, bW.rD());
            }
        }
    }

    public void tf() {
        this.XB.tf();
        if (this.Xz != null && this.XA != null) {
            this.Xz.setDrawable(al.getDrawable(this.XA.tp()));
            this.Xz.setSelector(al.getDrawable(this.XA.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Xy != null) {
            this.Xy.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Xy != null) {
            this.Xy.setDisableParentEvent(z);
        }
    }
}
