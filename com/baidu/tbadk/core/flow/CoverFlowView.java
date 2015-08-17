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
    private SquareViewPager Xp;
    private IndicatorView Xq;
    private com.baidu.tbadk.core.flow.a.c Xr;
    private com.baidu.tbadk.core.flow.a<T> Xs;
    private com.baidu.tbadk.core.flow.b Xt;
    private CoverFlowView<T>.a Xu;
    private d<T> Xv;
    private CoverFlowView<T>.c Xw;
    private CoverFlowView<T>.b Xx;
    private long Xy;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.Xu = new a(this, null);
        this.Xw = new c(this, null);
        this.Xx = new b(this, null);
        this.Xy = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.Xu = new a(this, null);
        this.Xw = new c(this, null);
        this.Xx = new b(this, null);
        this.Xy = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.Xu = new a(this, null);
        this.Xw = new c(this, null);
        this.Xx = new b(this, null);
        this.Xy = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Xv = dVar;
    }

    private void init(Context context) {
        Y(context);
        Z(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.Xp);
        addView(this.Xq);
        this.Xs = new com.baidu.tbadk.core.flow.a<>(context);
        this.Xs.setOnClickListener(this.Xw);
        this.Xp.setAdapter(this.Xs);
        this.Xp.setOnPageChangeListener(this.Xx);
    }

    private void Y(Context context) {
        this.Xp = new SquareViewPager(context);
    }

    private void Z(Context context) {
        this.Xq = new IndicatorView(context);
        this.Xq.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T bT(int i) {
        if (this.Xs == null) {
            return null;
        }
        return this.Xs.bT(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Xs.a(list, this.Xt);
            int size = list.size();
            if (size > 1) {
                this.Xq.setVisibility(0);
                this.Xq.setCount(size);
                this.Xp.setCurrentItem(1, false);
                this.Xq.setPosition(0.0f);
                te();
                return;
            }
            this.Xq.setVisibility(8);
            tf();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Xt = bVar;
            this.Xr = bVar.tb();
            this.Xr.g(this.Xq);
            bVar.tc().a(this.Xp);
            this.mCustomView = bVar.td();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.Xp);
                addView(this.mCustomView);
                addView(this.Xq);
            }
        }
    }

    public void te() {
        tg();
    }

    public void tf() {
        this.Xu.removeMessages(1);
    }

    public void tg() {
        this.Xu.removeMessages(1);
        this.Xu.sendEmptyMessageDelayed(1, this.Xy);
    }

    public void setMarqueenTime(long j) {
        this.Xy = j;
        tg();
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
                    CoverFlowView.this.th();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        int count;
        if (this.Xp != null && this.Xs != null && (count = this.Xs.getCount()) > 1) {
            int currentItem = this.Xp.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xp.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.Xp.setCurrentItem(1, false);
            } else {
                this.Xp.setCurrentItem(currentItem + 1);
            }
            this.Xp.invalidate();
        }
    }

    private boolean ti() {
        int count;
        if (this.Xs != null && (count = this.Xs.getCount()) > 1) {
            int currentItem = this.Xp.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.Xp.setCurrentItem(i, false);
                this.Xp.invalidate();
            } else if (currentItem > i) {
                this.Xp.setCurrentItem(1, false);
                this.Xp.invalidate();
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
            if (CoverFlowView.this.Xq != null && CoverFlowView.this.Xs != null && CoverFlowView.this.Xq.getVisibility() == 0) {
                int count = CoverFlowView.this.Xs.getCount();
                if (i == 0) {
                    CoverFlowView.this.Xq.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Xq.setPosition(f);
                } else {
                    CoverFlowView.this.Xq.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Xs != null) {
                int count = CoverFlowView.this.Xs.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Xv != null) {
                    CoverFlowView.this.Xv.a(i, CoverFlowView.this.Xs.bT(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.Xp == null || CoverFlowView.this.Xs == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        if (ti()) {
            tg();
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
            com.baidu.tbadk.core.flow.a.a bT;
            if (CoverFlowView.this.Xv != null && (view.getTag() instanceof Integer) && (bT = CoverFlowView.this.Xs.bT((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Xv.o(intValue, bT.rE());
            }
        }
    }

    public void ta() {
        this.Xs.ta();
        if (this.Xq != null && this.Xr != null) {
            this.Xq.setDrawable(al.getDrawable(this.Xr.tk()));
            this.Xq.setSelector(al.getDrawable(this.Xr.getSelectedId()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.Xp != null) {
            this.Xp.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.Xp != null) {
            this.Xp.setDisableParentEvent(z);
        }
    }
}
