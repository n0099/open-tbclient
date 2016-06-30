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
    private SquareViewPager Tg;
    private IndicatorView Th;
    private com.baidu.tbadk.core.flow.a.c Ti;
    private com.baidu.tbadk.core.flow.a<T> Tj;
    private com.baidu.tbadk.core.flow.b Tk;
    private CoverFlowView<T>.a Tl;
    private d<T> Tm;
    private CoverFlowView<T>.c Tn;
    private CoverFlowView<T>.b To;
    private long Tp;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Tl = new a(this, null);
        this.Tn = new c(this, null);
        this.To = new b(this, null);
        this.Tp = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Tl = new a(this, null);
        this.Tn = new c(this, null);
        this.To = new b(this, null);
        this.Tp = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Tl = new a(this, null);
        this.Tn = new c(this, null);
        this.To = new b(this, null);
        this.Tp = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Tm = dVar;
    }

    private void init(Context context) {
        J(context);
        K(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Tg);
        addView(this.Th);
        this.Tj = new com.baidu.tbadk.core.flow.a<>(context);
        this.Tj.setOnClickListener(this.Tn);
        this.Tg.setAdapter(this.Tj);
        this.Tg.setOnPageChangeListener(this.To);
    }

    private void J(Context context) {
        this.Tg = new SquareViewPager(context);
    }

    private void K(Context context) {
        this.Th = new IndicatorView(context);
        this.Th.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Tj.a(list, this.Tk);
            int size = list.size();
            if (size > 1) {
                this.Th.setVisibility(0);
                this.Th.setCount(size);
                this.Tg.setCurrentItem(1, false);
                this.Th.setPosition(0.0f);
                si();
                return;
            }
            this.Th.setVisibility(8);
            sj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Tk = bVar;
            this.Ti = bVar.sf();
            this.Ti.g(this.Th);
            bVar.sg().a(this.Tg);
            this.mCustomView = bVar.sh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Tg);
                addView(this.mCustomView);
                addView(this.Th);
            }
        }
    }

    public void si() {
        sk();
    }

    public void sj() {
        this.Tl.removeMessages(1);
    }

    public void sk() {
        this.Tl.removeMessages(1);
        this.Tl.sendEmptyMessageDelayed(1, this.Tp);
    }

    public void setMarqueenTime(long j) {
        this.Tp = j;
        sk();
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
                    CoverFlowView.this.sl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        int count;
        if (this.Tg != null && this.Tj != null && (count = this.Tj.getCount()) > 1) {
            int currentItem = this.Tg.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Tg.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Tg.setCurrentItem(1, false);
            } else {
                this.Tg.setCurrentItem(currentItem + 1);
            }
            this.Tg.invalidate();
        }
    }

    private boolean sm() {
        int count;
        if (this.Tj != null && (count = this.Tj.getCount()) > 1) {
            int currentItem = this.Tg.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Tg.setCurrentItem(i, false);
                this.Tg.invalidate();
            } else if (currentItem > i) {
                this.Tg.setCurrentItem(1, false);
                this.Tg.invalidate();
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
            if (CoverFlowView.this.Th != null && CoverFlowView.this.Tj != null && CoverFlowView.this.Th.getVisibility() == 0) {
                int count = CoverFlowView.this.Tj.getCount();
                if (i == 0) {
                    CoverFlowView.this.Th.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Th.setPosition(f);
                } else {
                    CoverFlowView.this.Th.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Tj != null) {
                int count = CoverFlowView.this.Tj.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Tm != null) {
                    CoverFlowView.this.Tm.a(i, CoverFlowView.this.Tj.cd(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Tg == null || CoverFlowView.this.Tj == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.sn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn() {
        if (sm()) {
            sk();
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
            if (CoverFlowView.this.Tm != null && (view.getTag() instanceof Integer) && (cd = CoverFlowView.this.Tj.cd((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Tm.g(intValue, cd.getPicLinkUrl());
            }
        }
    }

    public void se() {
        this.Tj.se();
        if (this.Th != null && this.Ti != null) {
            this.Th.setDrawable(av.getDrawable(this.Ti.so()));
            this.Th.setSelector(av.getDrawable(this.Ti.sp()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Tg != null) {
            this.Tg.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Tg != null) {
            this.Tg.setDisableParentEvent(z);
        }
    }
}
