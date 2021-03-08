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
    private com.baidu.tbadk.core.flow.a eYA;
    private CoverFlowLocalView<T>.a eYB;
    private boolean eYC;
    private boolean eYD;
    private boolean eYE;
    private d<T> eYF;
    private CoverFlowLocalView<T>.c eYG;
    private CoverFlowLocalView<T>.b eYH;
    private long eYI;
    private boolean eYv;
    private ListViewPager eYw;
    private IndicatorView eYx;
    private com.baidu.tbadk.core.flow.a.c eYy;
    private CoverFlowLocalAdapter<T> eYz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eYB = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYG = new c();
        this.eYH = new b();
        this.eYI = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eYB = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYG = new c();
        this.eYH = new b();
        this.eYI = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eYB = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYG = new c();
        this.eYH = new b();
        this.eYI = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eYF = dVar;
    }

    private void init(Context context) {
        eQ(context);
        eR(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eYw);
        addView(this.eYx);
        this.eYz = new CoverFlowLocalAdapter<>(context);
        this.eYz.setOnClickListener(this.eYG);
        this.eYw.setAdapter(this.eYz);
        this.eYw.setOnPageChangeListener(this.eYH);
    }

    private void eQ(Context context) {
        this.eYw = new ListViewPager(context);
    }

    private void eR(Context context) {
        this.eYx = new IndicatorView(context);
        this.eYx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eYz.a(list, this.eYA);
            int size = list.size();
            if (size > 1) {
                this.eYx.setVisibility(0);
                this.eYx.setCount(size);
                this.eYw.setCurrentItem(0, false);
                this.eYx.setPosition(0.0f);
                if (this.eYE) {
                    brj();
                    return;
                }
                return;
            }
            this.eYx.setVisibility(8);
            this.eYx.setCount(size);
            this.eYw.setCurrentItem(0, false);
            this.eYx.setPosition(0.0f);
            brk();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eYA = aVar;
            this.eYy = aVar.tu();
            this.eYy.g(this.eYx);
            aVar.tt().b(this.eYw);
            this.mCustomView = aVar.bri();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eYw);
                addView(this.mCustomView);
                addView(this.eYx);
            }
        }
    }

    public void brj() {
        brl();
    }

    public void brk() {
        this.eYB.removeMessages(1);
    }

    public void brl() {
        this.eYB.removeMessages(1);
        this.eYB.sendEmptyMessageDelayed(1, this.eYI);
    }

    public void setIndicatorVisible(int i) {
        if (this.eYx != null) {
            this.eYx.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eYI = j;
        brl();
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
                    CoverFlowLocalView.this.brm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brm() {
        int count;
        if (this.eYw != null && this.eYz != null && (count = this.eYz.getCount()) > 1) {
            int currentItem = this.eYw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eYw.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eYw.setCurrentItem(1, false);
            } else {
                this.eYw.setCurrentItem(currentItem + 1);
            }
            this.eYw.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brn() {
        int count;
        if (this.eYz == null || !this.eYv || (count = this.eYz.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eYw.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eYw.setCurrentItem(i, false);
            this.eYw.invalidate();
        } else if (currentItem > i) {
            this.eYw.setCurrentItem(1, false);
            this.eYw.invalidate();
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
            if (CoverFlowLocalView.this.eYx != null && CoverFlowLocalView.this.eYz != null) {
                if (CoverFlowLocalView.this.eYz.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eYF != null) {
                    CoverFlowLocalView.this.eYF.a(1, CoverFlowLocalView.this.eYz.op(i));
                }
                if (CoverFlowLocalView.this.eYx.getVisibility() == 0 && !CoverFlowLocalView.this.eYC) {
                    if (CoverFlowLocalView.this.eYv) {
                        int count = CoverFlowLocalView.this.eYz.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eYx.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eYx.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eYx.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eYx.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eYz != null) {
                int count = CoverFlowLocalView.this.eYz.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eYC) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eYF != null) {
                        CoverFlowLocalView.this.eYF.a(i, CoverFlowLocalView.this.eYz.op(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eYw != null && CoverFlowLocalView.this.eYz != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eYE) {
                            CoverFlowLocalView.this.bro();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eYD) {
                            CoverFlowLocalView.this.brk();
                            CoverFlowLocalView.this.brn();
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
        if (this.eYv) {
            int count = this.eYz.getCount();
            if (i == 0) {
                this.eYx.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eYx.setPosition(i);
                return;
            } else {
                this.eYx.setPosition(i - 1);
                return;
            }
        }
        this.eYx.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bro() {
        if (brn()) {
            brl();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eYv = z;
        if (this.eYz != null) {
            this.eYz.setCanRepeat(z);
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
            if (CoverFlowLocalView.this.eYF != null && (view.getTag() instanceof Integer) && (op = CoverFlowLocalView.this.eYz.op((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eYF.f(intValue, op.blN());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eYw != null) {
            this.eYw.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eYw != null) {
            this.eYw.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eYC = z;
    }

    public void setPageMargin(int i) {
        if (this.eYw != null) {
            this.eYw.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eYD = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eYD;
    }

    public void setAutoPlay(boolean z) {
        this.eYE = z;
    }
}
