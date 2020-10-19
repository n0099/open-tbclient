package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean euT;
    private ListViewPager euU;
    private IndicatorView euV;
    private com.baidu.tbadk.core.flow.a.c euW;
    private CoverFlowLocalAdapter<T> euX;
    private com.baidu.tbadk.core.flow.a euY;
    private CoverFlowLocalView<T>.a euZ;
    private boolean eva;
    private boolean evb;
    private boolean evc;
    private d<T> evd;
    private CoverFlowLocalView<T>.c eve;
    private CoverFlowLocalView<T>.b evf;
    private long evg;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.euZ = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.eve = new c();
        this.evf = new b();
        this.evg = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.euZ = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.eve = new c();
        this.evf = new b();
        this.evg = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.euZ = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.eve = new c();
        this.evf = new b();
        this.evg = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.evd = dVar;
    }

    private void init(Context context) {
        dW(context);
        dX(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.euU);
        addView(this.euV);
        this.euX = new CoverFlowLocalAdapter<>(context);
        this.euX.setOnClickListener(this.eve);
        this.euU.setAdapter(this.euX);
        this.euU.setOnPageChangeListener(this.evf);
    }

    private void dW(Context context) {
        this.euU = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.euV = new IndicatorView(context);
        this.euV.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.euX.a(list, this.euY);
            int size = list.size();
            if (size > 1) {
                this.euV.setVisibility(0);
                this.euV.setCount(size);
                this.euU.setCurrentItem(0, false);
                this.euV.setPosition(0.0f);
                if (this.evc) {
                    blg();
                    return;
                }
                return;
            }
            this.euV.setVisibility(8);
            this.euV.setCount(size);
            this.euU.setCurrentItem(0, false);
            this.euV.setPosition(0.0f);
            blh();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.euY = aVar;
            this.euW = aVar.ug();
            this.euW.g(this.euV);
            aVar.uf().b(this.euU);
            this.mCustomView = aVar.blf();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.euU);
                addView(this.mCustomView);
                addView(this.euV);
            }
        }
    }

    public void blg() {
        bli();
    }

    public void blh() {
        this.euZ.removeMessages(1);
    }

    public void bli() {
        this.euZ.removeMessages(1);
        this.euZ.sendEmptyMessageDelayed(1, this.evg);
    }

    public void setIndicatorVisible(int i) {
        if (this.euV != null) {
            this.euV.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.evg = j;
        bli();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowLocalView.this.blj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blj() {
        int count;
        if (this.euU != null && this.euX != null && (count = this.euX.getCount()) > 1) {
            int currentItem = this.euU.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.euU.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.euU.setCurrentItem(1, false);
            } else {
                this.euU.setCurrentItem(currentItem + 1);
            }
            this.euU.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blk() {
        int count;
        if (this.euX == null || !this.euT || (count = this.euX.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.euU.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.euU.setCurrentItem(i, false);
            this.euU.invalidate();
        } else if (currentItem > i) {
            this.euU.setCurrentItem(1, false);
            this.euU.invalidate();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.euV != null && CoverFlowLocalView.this.euX != null) {
                if (CoverFlowLocalView.this.euX.getCount() == 1 && i == 0 && CoverFlowLocalView.this.evd != null) {
                    CoverFlowLocalView.this.evd.a(1, CoverFlowLocalView.this.euX.op(i));
                }
                if (CoverFlowLocalView.this.euV.getVisibility() == 0 && !CoverFlowLocalView.this.eva) {
                    if (CoverFlowLocalView.this.euT) {
                        int count = CoverFlowLocalView.this.euX.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.euV.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.euV.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.euV.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.euV.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.euX != null) {
                int count = CoverFlowLocalView.this.euX.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eva) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.evd != null) {
                        CoverFlowLocalView.this.evd.a(i, CoverFlowLocalView.this.euX.op(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.euU != null && CoverFlowLocalView.this.euX != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.evc) {
                            CoverFlowLocalView.this.bll();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.evb) {
                            CoverFlowLocalView.this.blh();
                            CoverFlowLocalView.this.blk();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        if (this.euT) {
            int count = this.euX.getCount();
            if (i == 0) {
                this.euV.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.euV.setPosition(i);
                return;
            } else {
                this.euV.setPosition(i - 1);
                return;
            }
        }
        this.euV.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        if (blk()) {
            bli();
        }
    }

    public void setCanRepeat(boolean z) {
        this.euT = z;
        if (this.euX != null) {
            this.euX.setCanRepeat(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a op;
            if (CoverFlowLocalView.this.evd != null && (view.getTag() instanceof Integer) && (op = CoverFlowLocalView.this.euX.op((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.evd.e(intValue, op.bgf());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.euU != null) {
            this.euU.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.euU != null) {
            this.euU.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eva = z;
    }

    public void setPageMargin(int i) {
        if (this.euU != null) {
            this.euU.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.evb = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.evb;
    }

    public void setAutoPlay(boolean z) {
        this.evc = z;
    }
}
