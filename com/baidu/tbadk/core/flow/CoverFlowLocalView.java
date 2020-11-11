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
    private boolean eJh;
    private ListViewPager eJi;
    private IndicatorView eJj;
    private com.baidu.tbadk.core.flow.a.c eJk;
    private CoverFlowLocalAdapter<T> eJl;
    private com.baidu.tbadk.core.flow.a eJm;
    private CoverFlowLocalView<T>.a eJn;
    private boolean eJo;
    private boolean eJp;
    private boolean eJq;
    private d<T> eJr;
    private CoverFlowLocalView<T>.c eJs;
    private CoverFlowLocalView<T>.b eJt;
    private long eJu;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eJn = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJs = new c();
        this.eJt = new b();
        this.eJu = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eJn = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJs = new c();
        this.eJt = new b();
        this.eJu = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eJn = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJs = new c();
        this.eJt = new b();
        this.eJu = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eJr = dVar;
    }

    private void init(Context context) {
        dW(context);
        dX(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eJi);
        addView(this.eJj);
        this.eJl = new CoverFlowLocalAdapter<>(context);
        this.eJl.setOnClickListener(this.eJs);
        this.eJi.setAdapter(this.eJl);
        this.eJi.setOnPageChangeListener(this.eJt);
    }

    private void dW(Context context) {
        this.eJi = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eJj = new IndicatorView(context);
        this.eJj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eJl.a(list, this.eJm);
            int size = list.size();
            if (size > 1) {
                this.eJj.setVisibility(0);
                this.eJj.setCount(size);
                this.eJi.setCurrentItem(0, false);
                this.eJj.setPosition(0.0f);
                if (this.eJq) {
                    bpz();
                    return;
                }
                return;
            }
            this.eJj.setVisibility(8);
            this.eJj.setCount(size);
            this.eJi.setCurrentItem(0, false);
            this.eJj.setPosition(0.0f);
            bpA();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eJm = aVar;
            this.eJk = aVar.ug();
            this.eJk.g(this.eJj);
            aVar.uf().b(this.eJi);
            this.mCustomView = aVar.bpy();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eJi);
                addView(this.mCustomView);
                addView(this.eJj);
            }
        }
    }

    public void bpz() {
        bpB();
    }

    public void bpA() {
        this.eJn.removeMessages(1);
    }

    public void bpB() {
        this.eJn.removeMessages(1);
        this.eJn.sendEmptyMessageDelayed(1, this.eJu);
    }

    public void setIndicatorVisible(int i) {
        if (this.eJj != null) {
            this.eJj.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eJu = j;
        bpB();
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
                    CoverFlowLocalView.this.bpC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpC() {
        int count;
        if (this.eJi != null && this.eJl != null && (count = this.eJl.getCount()) > 1) {
            int currentItem = this.eJi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eJi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eJi.setCurrentItem(1, false);
            } else {
                this.eJi.setCurrentItem(currentItem + 1);
            }
            this.eJi.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpD() {
        int count;
        if (this.eJl == null || !this.eJh || (count = this.eJl.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eJi.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eJi.setCurrentItem(i, false);
            this.eJi.invalidate();
        } else if (currentItem > i) {
            this.eJi.setCurrentItem(1, false);
            this.eJi.invalidate();
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
            if (CoverFlowLocalView.this.eJj != null && CoverFlowLocalView.this.eJl != null) {
                if (CoverFlowLocalView.this.eJl.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eJr != null) {
                    CoverFlowLocalView.this.eJr.a(1, CoverFlowLocalView.this.eJl.oK(i));
                }
                if (CoverFlowLocalView.this.eJj.getVisibility() == 0 && !CoverFlowLocalView.this.eJo) {
                    if (CoverFlowLocalView.this.eJh) {
                        int count = CoverFlowLocalView.this.eJl.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eJj.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eJj.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eJj.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eJj.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eJl != null) {
                int count = CoverFlowLocalView.this.eJl.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eJo) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eJr != null) {
                        CoverFlowLocalView.this.eJr.a(i, CoverFlowLocalView.this.eJl.oK(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eJi != null && CoverFlowLocalView.this.eJl != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eJq) {
                            CoverFlowLocalView.this.bpE();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eJp) {
                            CoverFlowLocalView.this.bpA();
                            CoverFlowLocalView.this.bpD();
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
        if (this.eJh) {
            int count = this.eJl.getCount();
            if (i == 0) {
                this.eJj.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eJj.setPosition(i);
                return;
            } else {
                this.eJj.setPosition(i - 1);
                return;
            }
        }
        this.eJj.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        if (bpD()) {
            bpB();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eJh = z;
        if (this.eJl != null) {
            this.eJl.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a oK;
            if (CoverFlowLocalView.this.eJr != null && (view.getTag() instanceof Integer) && (oK = CoverFlowLocalView.this.eJl.oK((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eJr.e(intValue, oK.bky());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eJi != null) {
            this.eJi.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eJi != null) {
            this.eJi.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eJo = z;
    }

    public void setPageMargin(int i) {
        if (this.eJi != null) {
            this.eJi.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eJp = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eJp;
    }

    public void setAutoPlay(boolean z) {
        this.eJq = z;
    }
}
