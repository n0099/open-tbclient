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
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager euU;
    private IndicatorView euV;
    private com.baidu.tbadk.core.flow.a.c euW;
    private com.baidu.tbadk.core.flow.a euY;
    private boolean eva;
    private boolean evb;
    private boolean evc;
    private d<T> evd;
    private long evg;
    private CoverFlowAdapter<T> evi;
    private CoverFlowView<T>.a evj;
    private CoverFlowView<T>.c evk;
    private CoverFlowView<T>.b evl;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.evj = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.evk = new c();
        this.evl = new b();
        this.evg = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.evj = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.evk = new c();
        this.evl = new b();
        this.evg = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.evj = new a();
        this.eva = false;
        this.evb = true;
        this.evc = true;
        this.evk = new c();
        this.evl = new b();
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
        this.evi = new CoverFlowAdapter<>(context);
        this.evi.setOnClickListener(this.evk);
        this.euU.setAdapter(this.evi);
        this.euU.setOnPageChangeListener(this.evl);
    }

    private void dW(Context context) {
        this.euU = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.euV = new IndicatorView(context);
        this.euV.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T op(int i) {
        if (this.evi == null) {
            return null;
        }
        return this.evi.op(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.evi.a(list, this.euY);
            int size = list.size();
            if (size > 1) {
                this.euV.setVisibility(0);
                this.euV.setCount(size);
                this.euU.setCurrentItem(1, false);
                this.euV.setPosition(0.0f);
                if (this.evc) {
                    blg();
                    return;
                }
                return;
            }
            this.euV.setVisibility(8);
            this.euV.setCount(size);
            this.euU.setCurrentItem(1, false);
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
        this.evj.removeMessages(1);
    }

    public void bli() {
        this.evj.removeMessages(1);
        this.evj.sendEmptyMessageDelayed(1, this.evg);
    }

    public void ue() {
        if (!this.evj.hasMessages(1)) {
            blg();
        }
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
                    CoverFlowView.this.blj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blj() {
        int count;
        if (this.euU != null && this.evi != null && (count = this.evi.getCount()) > 1) {
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
        if (this.evi != null && (count = this.evi.getCount()) > 1) {
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.euV != null && CoverFlowView.this.evi != null) {
                if (CoverFlowView.this.evi.getCount() == 1 && i == 0 && CoverFlowView.this.evd != null) {
                    CoverFlowView.this.evd.a(1, CoverFlowView.this.evi.op(i));
                }
                if (CoverFlowView.this.euV.getVisibility() == 0 && !CoverFlowView.this.eva) {
                    int count = CoverFlowView.this.evi.getCount();
                    if (i == 0) {
                        CoverFlowView.this.euV.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.euV.setPosition(f);
                    } else {
                        CoverFlowView.this.euV.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.evi != null) {
                int count = CoverFlowView.this.evi.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eva) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.evd != null) {
                        CoverFlowView.this.evd.a(i, CoverFlowView.this.evi.op(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.euU != null && CoverFlowView.this.evi != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.evc) {
                            CoverFlowView.this.bll();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.evb) {
                            CoverFlowView.this.blh();
                            CoverFlowView.this.blk();
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
        int count = this.evi.getCount();
        if (i == 0) {
            this.euV.setPosition(0.0f);
        } else if (i == count - 1) {
            this.euV.setPosition(i);
        } else {
            this.euV.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        if (blk()) {
            bli();
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
            if (CoverFlowView.this.evd != null && (view.getTag() instanceof Integer) && (op = CoverFlowView.this.evi.op((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.evd.e(intValue, op.bgf());
            }
        }
    }

    public void onChangeSkinType() {
        this.evi.onChangeSkinType();
        if (this.euV != null && this.euW != null) {
            this.euV.setDrawable(ap.getDrawable(this.euW.blm()));
            this.euV.setSelector(ap.getDrawable(this.euW.bln()));
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

    public void a(e eVar) {
        if (eVar != null && this.euU != null) {
            eVar.b(this.euU);
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
