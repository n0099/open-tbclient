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
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private com.baidu.tbadk.core.flow.a eYA;
    private boolean eYC;
    private boolean eYD;
    private boolean eYE;
    private d<T> eYF;
    private long eYI;
    private CoverFlowAdapter<T> eYK;
    private CoverFlowView<T>.a eYL;
    private CoverFlowView<T>.c eYM;
    private CoverFlowView<T>.b eYN;
    private ListViewPager eYw;
    private IndicatorView eYx;
    private com.baidu.tbadk.core.flow.a.c eYy;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eYL = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYM = new c();
        this.eYN = new b();
        this.eYI = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eYL = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYM = new c();
        this.eYN = new b();
        this.eYI = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eYL = new a();
        this.eYC = false;
        this.eYD = true;
        this.eYE = true;
        this.eYM = new c();
        this.eYN = new b();
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
        this.eYK = new CoverFlowAdapter<>(context);
        this.eYK.setOnClickListener(this.eYM);
        this.eYw.setAdapter(this.eYK);
        this.eYw.setOnPageChangeListener(this.eYN);
    }

    private void eQ(Context context) {
        this.eYw = new ListViewPager(context);
    }

    private void eR(Context context) {
        this.eYx = new IndicatorView(context);
        this.eYx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T op(int i) {
        if (this.eYK == null) {
            return null;
        }
        return this.eYK.op(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eYK.a(list, this.eYA);
            int size = list.size();
            if (size > 1) {
                this.eYx.setVisibility(0);
                this.eYx.setCount(size);
                this.eYw.setCurrentItem(1, false);
                this.eYx.setPosition(0.0f);
                if (this.eYE) {
                    brj();
                    return;
                }
                return;
            }
            this.eYx.setVisibility(8);
            this.eYx.setCount(size);
            this.eYw.setCurrentItem(1, false);
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
        this.eYL.removeMessages(1);
    }

    public void brl() {
        this.eYL.removeMessages(1);
        this.eYL.sendEmptyMessageDelayed(1, this.eYI);
    }

    public void ts() {
        if (!this.eYL.hasMessages(1)) {
            brj();
        }
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
                    CoverFlowView.this.brm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brm() {
        int count;
        if (this.eYw != null && this.eYK != null && (count = this.eYK.getCount()) > 1) {
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
        if (this.eYK != null && (count = this.eYK.getCount()) > 1) {
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.eYx != null && CoverFlowView.this.eYK != null) {
                if (CoverFlowView.this.eYK.getCount() == 1 && i == 0 && CoverFlowView.this.eYF != null) {
                    CoverFlowView.this.eYF.a(1, CoverFlowView.this.eYK.op(i));
                }
                if (CoverFlowView.this.eYx.getVisibility() == 0 && !CoverFlowView.this.eYC) {
                    int count = CoverFlowView.this.eYK.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eYx.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eYx.setPosition(f);
                    } else {
                        CoverFlowView.this.eYx.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eYK != null) {
                int count = CoverFlowView.this.eYK.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eYC) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eYF != null) {
                        CoverFlowView.this.eYF.a(i, CoverFlowView.this.eYK.op(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eYw != null && CoverFlowView.this.eYK != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eYE) {
                            CoverFlowView.this.bro();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eYD) {
                            CoverFlowView.this.brk();
                            CoverFlowView.this.brn();
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
        int count = this.eYK.getCount();
        if (i == 0) {
            this.eYx.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eYx.setPosition(i);
        } else {
            this.eYx.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bro() {
        if (brn()) {
            brl();
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
            if (CoverFlowView.this.eYF != null && (view.getTag() instanceof Integer) && (op = CoverFlowView.this.eYK.op((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eYF.f(intValue, op.blN());
            }
        }
    }

    public void onChangeSkinType() {
        this.eYK.onChangeSkinType();
        if (this.eYx != null && this.eYy != null) {
            this.eYx.setDrawable(ap.getDrawable(this.eYy.brp()));
            this.eYx.setSelector(ap.getDrawable(this.eYy.brq()));
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

    public void a(e eVar) {
        if (eVar != null && this.eYw != null) {
            eVar.b(this.eYw);
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
