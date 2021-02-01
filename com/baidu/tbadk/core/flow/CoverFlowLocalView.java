package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean eWW;
    private ListViewPager eWX;
    private IndicatorView eWY;
    private com.baidu.tbadk.core.flow.a.c eWZ;
    private CoverFlowLocalAdapter<T> eXa;
    private com.baidu.tbadk.core.flow.a eXb;
    private CoverFlowLocalView<T>.a eXc;
    private boolean eXd;
    private boolean eXe;
    private boolean eXf;
    private d<T> eXg;
    private CoverFlowLocalView<T>.c eXh;
    private CoverFlowLocalView<T>.b eXi;
    private long eXj;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eXc = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXh = new c();
        this.eXi = new b();
        this.eXj = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eXc = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXh = new c();
        this.eXi = new b();
        this.eXj = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eXc = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXh = new c();
        this.eXi = new b();
        this.eXj = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eXg = dVar;
    }

    private void init(Context context) {
        eR(context);
        eS(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eWX);
        addView(this.eWY);
        this.eXa = new CoverFlowLocalAdapter<>(context);
        this.eXa.setOnClickListener(this.eXh);
        this.eWX.setAdapter(this.eXa);
        this.eWX.setOnPageChangeListener(this.eXi);
    }

    private void eR(Context context) {
        this.eWX = new ListViewPager(context);
    }

    private void eS(Context context) {
        this.eWY = new IndicatorView(context);
        this.eWY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eXa.a(list, this.eXb);
            int size = list.size();
            if (size > 1) {
                this.eWY.setVisibility(0);
                this.eWY.setCount(size);
                this.eWX.setCurrentItem(0, false);
                this.eWY.setPosition(0.0f);
                if (this.eXf) {
                    bri();
                    return;
                }
                return;
            }
            this.eWY.setVisibility(8);
            this.eWY.setCount(size);
            this.eWX.setCurrentItem(0, false);
            this.eWY.setPosition(0.0f);
            brj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eXb = aVar;
            this.eWZ = aVar.tu();
            this.eWZ.g(this.eWY);
            aVar.tt().b(this.eWX);
            this.mCustomView = aVar.brh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eWX);
                addView(this.mCustomView);
                addView(this.eWY);
            }
        }
    }

    public void bri() {
        brk();
    }

    public void brj() {
        this.eXc.removeMessages(1);
    }

    public void brk() {
        this.eXc.removeMessages(1);
        this.eXc.sendEmptyMessageDelayed(1, this.eXj);
    }

    public void setIndicatorVisible(int i) {
        if (this.eWY != null) {
            this.eWY.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eXj = j;
        brk();
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
                    CoverFlowLocalView.this.brl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brl() {
        int count;
        if (this.eWX != null && this.eXa != null && (count = this.eXa.getCount()) > 1) {
            int currentItem = this.eWX.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eWX.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eWX.setCurrentItem(1, false);
            } else {
                this.eWX.setCurrentItem(currentItem + 1);
            }
            this.eWX.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brm() {
        int count;
        if (this.eXa == null || !this.eWW || (count = this.eXa.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eWX.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eWX.setCurrentItem(i, false);
            this.eWX.invalidate();
        } else if (currentItem > i) {
            this.eWX.setCurrentItem(1, false);
            this.eWX.invalidate();
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
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.eWY != null && CoverFlowLocalView.this.eXa != null) {
                if (CoverFlowLocalView.this.eXa.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eXg != null) {
                    CoverFlowLocalView.this.eXg.a(1, CoverFlowLocalView.this.eXa.oo(i));
                }
                if (CoverFlowLocalView.this.eWY.getVisibility() == 0 && !CoverFlowLocalView.this.eXd) {
                    if (CoverFlowLocalView.this.eWW) {
                        int count = CoverFlowLocalView.this.eXa.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eWY.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eWY.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eWY.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eWY.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eXa != null) {
                int count = CoverFlowLocalView.this.eXa.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eXd) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eXg != null) {
                        CoverFlowLocalView.this.eXg.a(i, CoverFlowLocalView.this.eXa.oo(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eWX != null && CoverFlowLocalView.this.eXa != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eXf) {
                            CoverFlowLocalView.this.brn();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eXe) {
                            CoverFlowLocalView.this.brj();
                            CoverFlowLocalView.this.brm();
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
        if (this.eWW) {
            int count = this.eXa.getCount();
            if (i == 0) {
                this.eWY.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eWY.setPosition(i);
                return;
            } else {
                this.eWY.setPosition(i - 1);
                return;
            }
        }
        this.eWY.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brn() {
        if (brm()) {
            brk();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eWW = z;
        if (this.eXa != null) {
            this.eXa.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a oo;
            if (CoverFlowLocalView.this.eXg != null && (view.getTag() instanceof Integer) && (oo = CoverFlowLocalView.this.eXa.oo((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eXg.f(intValue, oo.blL());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eWX != null) {
            this.eWX.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eWX != null) {
            this.eWX.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eXd = z;
    }

    public void setPageMargin(int i) {
        if (this.eWX != null) {
            this.eWX.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eXe = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eXe;
    }

    public void setAutoPlay(boolean z) {
        this.eXf = z;
    }
}
