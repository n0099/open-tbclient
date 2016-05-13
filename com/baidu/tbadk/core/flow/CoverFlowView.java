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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager SP;
    private IndicatorView SQ;
    private com.baidu.tbadk.core.flow.a.c SR;
    private com.baidu.tbadk.core.flow.a<T> SS;
    private com.baidu.tbadk.core.flow.b ST;
    private CoverFlowView<T>.a SU;
    private d<T> SV;
    private CoverFlowView<T>.c SW;
    private CoverFlowView<T>.b SX;
    private long SY;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.SU = new a(this, null);
        this.SW = new c(this, null);
        this.SX = new b(this, null);
        this.SY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.SU = new a(this, null);
        this.SW = new c(this, null);
        this.SX = new b(this, null);
        this.SY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.SU = new a(this, null);
        this.SW = new c(this, null);
        this.SX = new b(this, null);
        this.SY = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.SV = dVar;
    }

    private void init(Context context) {
        K(context);
        L(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.SP);
        addView(this.SQ);
        this.SS = new com.baidu.tbadk.core.flow.a<>(context);
        this.SS.setOnClickListener(this.SW);
        this.SP.setAdapter(this.SS);
        this.SP.setOnPageChangeListener(this.SX);
    }

    private void K(Context context) {
        this.SP = new SquareViewPager(context);
    }

    private void L(Context context) {
        this.SQ = new IndicatorView(context);
        this.SQ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.SS.a(list, this.ST);
            int size = list.size();
            if (size > 1) {
                this.SQ.setVisibility(0);
                this.SQ.setCount(size);
                this.SP.setCurrentItem(1, false);
                this.SQ.setPosition(0.0f);
                sk();
                return;
            }
            this.SQ.setVisibility(8);
            sl();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.ST = bVar;
            this.SR = bVar.sh();
            this.SR.g(this.SQ);
            bVar.si().a(this.SP);
            this.mCustomView = bVar.sj();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.SP);
                addView(this.mCustomView);
                addView(this.SQ);
            }
        }
    }

    public void sk() {
        sm();
    }

    public void sl() {
        this.SU.removeMessages(1);
    }

    public void sm() {
        this.SU.removeMessages(1);
        this.SU.sendEmptyMessageDelayed(1, this.SY);
    }

    public void setMarqueenTime(long j) {
        this.SY = j;
        sm();
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
                    CoverFlowView.this.sn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn() {
        int count;
        if (this.SP != null && this.SS != null && (count = this.SS.getCount()) > 1) {
            int currentItem = this.SP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.SP.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.SP.setCurrentItem(1, false);
            } else {
                this.SP.setCurrentItem(currentItem + 1);
            }
            this.SP.invalidate();
        }
    }

    private boolean so() {
        int count;
        if (this.SS != null && (count = this.SS.getCount()) > 1) {
            int currentItem = this.SP.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.SP.setCurrentItem(i, false);
                this.SP.invalidate();
            } else if (currentItem > i) {
                this.SP.setCurrentItem(1, false);
                this.SP.invalidate();
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
            if (CoverFlowView.this.SQ != null && CoverFlowView.this.SS != null && CoverFlowView.this.SQ.getVisibility() == 0) {
                int count = CoverFlowView.this.SS.getCount();
                if (i == 0) {
                    CoverFlowView.this.SQ.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.SQ.setPosition(f);
                } else {
                    CoverFlowView.this.SQ.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.SS != null) {
                int count = CoverFlowView.this.SS.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.SV != null) {
                    CoverFlowView.this.SV.a(i, CoverFlowView.this.SS.cc(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.SP == null || CoverFlowView.this.SS == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.sp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp() {
        if (so()) {
            sm();
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
            com.baidu.tbadk.core.flow.a.a cc;
            if (CoverFlowView.this.SV != null && (view.getTag() instanceof Integer) && (cc = CoverFlowView.this.SS.cc((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.SV.g(intValue, cc.oU());
            }
        }
    }

    public void sg() {
        this.SS.sg();
        if (this.SQ != null && this.SR != null) {
            this.SQ.setDrawable(at.getDrawable(this.SR.sq()));
            this.SQ.setSelector(at.getDrawable(this.SR.sr()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.SP != null) {
            this.SP.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.SP != null) {
            this.SP.setDisableParentEvent(z);
        }
    }
}
