package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private CoverFlowView<T>.c SA;
    private com.baidu.tbadk.core.flow.a.d<T> SB;
    private CoverFlowView<T>.e SC;
    private CoverFlowView<T>.d SD;
    private long SE;
    private SquareViewPager Sw;
    private IndicatorView Sx;
    private a<T> Sy;
    private b Sz;

    public CoverFlowView(Context context) {
        super(context);
        this.SA = new c(this, null);
        this.SC = new e(this, null);
        this.SD = new d(this, null);
        this.SE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SA = new c(this, null);
        this.SC = new e(this, null);
        this.SD = new d(this, null);
        this.SE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SA = new c(this, null);
        this.SC = new e(this, null);
        this.SD = new d(this, null);
        this.SE = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(com.baidu.tbadk.core.flow.a.d<T> dVar) {
        this.SB = dVar;
    }

    private void init(Context context) {
        W(context);
        X(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Sw);
        addView(this.Sx);
        this.Sy = new a<>(context);
        this.Sy.setOnClickListener(this.SC);
        this.Sw.setAdapter(this.Sy);
        this.Sw.setOnPageChangeListener(this.SD);
    }

    private void W(Context context) {
        this.Sw = new SquareViewPager(context);
    }

    private void X(Context context) {
        this.Sx = new IndicatorView(context);
        this.Sx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bL(int i) {
        if (this.Sy == null) {
            return null;
        }
        return this.Sy.bL(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Sy.a(list, this.Sz);
            int size = list.size();
            if (size > 1) {
                this.Sx.setVisibility(0);
                this.Sx.setCount(size);
                this.Sw.setCurrentItem(1, false);
                this.Sx.setPosition(0.0f);
                rX();
                return;
            }
            this.Sx.setVisibility(8);
            rY();
        }
    }

    public void setCoverFlowFactory(b bVar) {
        if (bVar != null) {
            this.Sz = bVar;
            bVar.rV().g(this.Sx);
            bVar.rW().a(this.Sw);
        }
    }

    public void rX() {
        rZ();
    }

    public void rY() {
        this.SA.removeMessages(1);
    }

    public void rZ() {
        this.SA.removeMessages(1);
        this.SA.sendEmptyMessageDelayed(1, this.SE);
    }

    public void setMarqueenTime(long j) {
        this.SE = j;
        rZ();
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        private c() {
        }

        /* synthetic */ c(CoverFlowView coverFlowView, c cVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.sa();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa() {
        int count;
        if (this.Sw != null && this.Sy != null && (count = this.Sy.getCount()) > 1) {
            int currentItem = this.Sw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Sw.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Sw.setCurrentItem(1, false);
            } else {
                this.Sw.setCurrentItem(currentItem + 1);
            }
            this.Sw.invalidate();
        }
    }

    private boolean sb() {
        int count;
        if (this.Sy != null && (count = this.Sy.getCount()) > 1) {
            int currentItem = this.Sw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Sw.setCurrentItem(i, false);
                this.Sw.invalidate();
            } else if (currentItem > i) {
                this.Sw.setCurrentItem(1, false);
                this.Sw.invalidate();
            }
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    class d implements ViewPager.OnPageChangeListener {
        private d() {
        }

        /* synthetic */ d(CoverFlowView coverFlowView, d dVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.Sx != null && CoverFlowView.this.Sy != null && CoverFlowView.this.Sx.getVisibility() == 0) {
                int count = CoverFlowView.this.Sy.getCount();
                if (i == 0) {
                    CoverFlowView.this.Sx.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Sx.setPosition(f);
                } else {
                    CoverFlowView.this.Sx.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Sy != null) {
                int count = CoverFlowView.this.Sy.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.SB != null) {
                    CoverFlowView.this.SB.a(i, CoverFlowView.this.Sy.bL(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Sw == null || CoverFlowView.this.Sy == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.sc();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        if (sb()) {
            rZ();
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        private e() {
        }

        /* synthetic */ e(CoverFlowView coverFlowView, e eVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a bL;
            if (CoverFlowView.this.SB != null && (view.getTag() instanceof Integer) && (bL = CoverFlowView.this.Sy.bL((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.SB.m(intValue, bL.sd());
            }
        }
    }

    public void rU() {
        this.Sy.rU();
    }

    public void setSwipeControlInterface(t tVar) {
        if (this.Sw != null) {
            this.Sw.setSwipeControlInterface(tVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Sw != null) {
            this.Sw.setDisableParentEvent(z);
        }
    }
}
