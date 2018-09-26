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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private d<T> aoA;
    private CoverFlowView<T>.c aoB;
    private CoverFlowView<T>.b aoC;
    private long aoD;
    private ListViewPager aor;
    private IndicatorView aos;
    private com.baidu.tbadk.core.flow.a.c aot;
    private CoverFlowAdapter<T> aou;
    private com.baidu.tbadk.core.flow.a aov;
    private CoverFlowView<T>.a aow;
    private boolean aox;
    private boolean aoy;
    private boolean aoz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aow = new a();
        this.aox = false;
        this.aoy = true;
        this.aoz = true;
        this.aoB = new c();
        this.aoC = new b();
        this.aoD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aow = new a();
        this.aox = false;
        this.aoy = true;
        this.aoz = true;
        this.aoB = new c();
        this.aoC = new b();
        this.aoD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aow = new a();
        this.aox = false;
        this.aoy = true;
        this.aoz = true;
        this.aoB = new c();
        this.aoC = new b();
        this.aoD = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aoA = dVar;
    }

    private void init(Context context) {
        bj(context);
        bk(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aor);
        addView(this.aos);
        this.aou = new CoverFlowAdapter<>(context);
        this.aou.setOnClickListener(this.aoB);
        this.aor.setAdapter(this.aou);
        this.aor.setOnPageChangeListener(this.aoC);
    }

    private void bj(Context context) {
        this.aor = new ListViewPager(context);
    }

    private void bk(Context context) {
        this.aos = new IndicatorView(context);
        this.aos.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cF(int i) {
        if (this.aou == null) {
            return null;
        }
        return this.aou.cF(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aou.a(list, this.aov);
            int size = list.size();
            if (size > 1) {
                this.aos.setVisibility(0);
                this.aos.setCount(size);
                this.aor.setCurrentItem(1, false);
                this.aos.setPosition(0.0f);
                yz();
                return;
            }
            this.aos.setVisibility(8);
            this.aos.setCount(size);
            this.aor.setCurrentItem(1, false);
            this.aos.setPosition(0.0f);
            yA();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.aov = aVar;
            this.aot = aVar.yw();
            this.aot.g(this.aos);
            aVar.yx().a(this.aor);
            this.mCustomView = aVar.yy();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aor);
                addView(this.mCustomView);
                addView(this.aos);
            }
        }
    }

    public void yz() {
        yB();
    }

    public void yA() {
        this.aow.removeMessages(1);
    }

    public void yB() {
        this.aow.removeMessages(1);
        this.aow.sendEmptyMessageDelayed(1, this.aoD);
    }

    public void setIndicatorVisible(int i) {
        if (this.aos != null) {
            this.aos.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.aoD = j;
        yB();
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
                    CoverFlowView.this.yC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC() {
        int count;
        if (this.aor != null && this.aou != null && (count = this.aou.getCount()) > 1) {
            int currentItem = this.aor.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aor.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aor.setCurrentItem(1, false);
            } else {
                this.aor.setCurrentItem(currentItem + 1);
            }
            this.aor.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yD() {
        int count;
        if (this.aou != null && (count = this.aou.getCount()) > 1) {
            int currentItem = this.aor.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aor.setCurrentItem(i, false);
                this.aor.invalidate();
            } else if (currentItem > i) {
                this.aor.setCurrentItem(1, false);
                this.aor.invalidate();
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
            if (CoverFlowView.this.aos != null && CoverFlowView.this.aou != null) {
                if (CoverFlowView.this.aou.getCount() == 1 && i == 0 && CoverFlowView.this.aoA != null) {
                    CoverFlowView.this.aoA.a(1, CoverFlowView.this.aou.cF(i));
                }
                if (CoverFlowView.this.aos.getVisibility() == 0 && !CoverFlowView.this.aox) {
                    int count = CoverFlowView.this.aou.getCount();
                    if (i == 0) {
                        CoverFlowView.this.aos.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.aos.setPosition(f);
                    } else {
                        CoverFlowView.this.aos.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aou != null) {
                int count = CoverFlowView.this.aou.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.aox) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.aoA != null) {
                        CoverFlowView.this.aoA.a(i, CoverFlowView.this.aou.cF(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aor != null && CoverFlowView.this.aou != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.aoz) {
                            CoverFlowView.this.yE();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.aoz = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.aoz) {
                            CoverFlowView.this.yA();
                            CoverFlowView.this.yD();
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
        int count = this.aou.getCount();
        if (i == 0) {
            this.aos.setPosition(0.0f);
        } else if (i == count - 1) {
            this.aos.setPosition(i);
        } else {
            this.aos.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE() {
        if (yD()) {
            yB();
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
            com.baidu.tbadk.core.flow.a.a cF;
            if (CoverFlowView.this.aoA != null && (view.getTag() instanceof Integer) && (cF = CoverFlowView.this.aou.cF((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aoA.h(intValue, cF.uR());
            }
        }
    }

    public void onChangeSkinType() {
        this.aou.onChangeSkinType();
        if (this.aos != null && this.aot != null) {
            this.aos.setDrawable(al.getDrawable(this.aot.yF()));
            this.aos.setSelector(al.getDrawable(this.aot.yG()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.aor != null) {
            this.aor.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aor != null) {
            this.aor.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.aox = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.aoy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.aoy;
    }

    private void setAutoPlay(boolean z) {
        this.aoz = z;
    }
}
