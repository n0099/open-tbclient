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
    private ListViewPager eWX;
    private IndicatorView eWY;
    private com.baidu.tbadk.core.flow.a.c eWZ;
    private com.baidu.tbadk.core.flow.a eXb;
    private boolean eXd;
    private boolean eXe;
    private boolean eXf;
    private d<T> eXg;
    private long eXj;
    private CoverFlowAdapter<T> eXl;
    private CoverFlowView<T>.a eXm;
    private CoverFlowView<T>.c eXn;
    private CoverFlowView<T>.b eXo;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eXm = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXn = new c();
        this.eXo = new b();
        this.eXj = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eXm = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXn = new c();
        this.eXo = new b();
        this.eXj = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eXm = new a();
        this.eXd = false;
        this.eXe = true;
        this.eXf = true;
        this.eXn = new c();
        this.eXo = new b();
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
        this.eXl = new CoverFlowAdapter<>(context);
        this.eXl.setOnClickListener(this.eXn);
        this.eWX.setAdapter(this.eXl);
        this.eWX.setOnPageChangeListener(this.eXo);
    }

    private void eR(Context context) {
        this.eWX = new ListViewPager(context);
    }

    private void eS(Context context) {
        this.eWY = new IndicatorView(context);
        this.eWY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T oo(int i) {
        if (this.eXl == null) {
            return null;
        }
        return this.eXl.oo(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eXl.a(list, this.eXb);
            int size = list.size();
            if (size > 1) {
                this.eWY.setVisibility(0);
                this.eWY.setCount(size);
                this.eWX.setCurrentItem(1, false);
                this.eWY.setPosition(0.0f);
                if (this.eXf) {
                    bri();
                    return;
                }
                return;
            }
            this.eWY.setVisibility(8);
            this.eWY.setCount(size);
            this.eWX.setCurrentItem(1, false);
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
        this.eXm.removeMessages(1);
    }

    public void brk() {
        this.eXm.removeMessages(1);
        this.eXm.sendEmptyMessageDelayed(1, this.eXj);
    }

    public void ts() {
        if (!this.eXm.hasMessages(1)) {
            bri();
        }
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
                    CoverFlowView.this.brl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brl() {
        int count;
        if (this.eWX != null && this.eXl != null && (count = this.eXl.getCount()) > 1) {
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
        if (this.eXl != null && (count = this.eXl.getCount()) > 1) {
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
            if (CoverFlowView.this.eWY != null && CoverFlowView.this.eXl != null) {
                if (CoverFlowView.this.eXl.getCount() == 1 && i == 0 && CoverFlowView.this.eXg != null) {
                    CoverFlowView.this.eXg.a(1, CoverFlowView.this.eXl.oo(i));
                }
                if (CoverFlowView.this.eWY.getVisibility() == 0 && !CoverFlowView.this.eXd) {
                    int count = CoverFlowView.this.eXl.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eWY.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eWY.setPosition(f);
                    } else {
                        CoverFlowView.this.eWY.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eXl != null) {
                int count = CoverFlowView.this.eXl.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eXd) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eXg != null) {
                        CoverFlowView.this.eXg.a(i, CoverFlowView.this.eXl.oo(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eWX != null && CoverFlowView.this.eXl != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eXf) {
                            CoverFlowView.this.brn();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eXe) {
                            CoverFlowView.this.brj();
                            CoverFlowView.this.brm();
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
        int count = this.eXl.getCount();
        if (i == 0) {
            this.eWY.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eWY.setPosition(i);
        } else {
            this.eWY.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brn() {
        if (brm()) {
            brk();
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
            if (CoverFlowView.this.eXg != null && (view.getTag() instanceof Integer) && (oo = CoverFlowView.this.eXl.oo((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eXg.f(intValue, oo.blL());
            }
        }
    }

    public void onChangeSkinType() {
        this.eXl.onChangeSkinType();
        if (this.eWY != null && this.eWZ != null) {
            this.eWY.setDrawable(ap.getDrawable(this.eWZ.bro()));
            this.eWY.setSelector(ap.getDrawable(this.eWZ.brp()));
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

    public void a(e eVar) {
        if (eVar != null && this.eWX != null) {
            eVar.b(this.eWX);
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
