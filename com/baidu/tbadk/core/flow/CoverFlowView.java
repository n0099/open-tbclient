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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager cWe;
    private IndicatorView cWf;
    private com.baidu.tbadk.core.flow.a.c cWg;
    private CoverFlowAdapter<T> cWh;
    private com.baidu.tbadk.core.flow.a cWi;
    private CoverFlowView<T>.a cWj;
    private boolean cWk;
    private boolean cWl;
    private boolean cWm;
    private d<T> cWn;
    private CoverFlowView<T>.c cWo;
    private CoverFlowView<T>.b cWp;
    private long cWq;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cWj = new a();
        this.cWk = false;
        this.cWl = true;
        this.cWm = true;
        this.cWo = new c();
        this.cWp = new b();
        this.cWq = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cWj = new a();
        this.cWk = false;
        this.cWl = true;
        this.cWm = true;
        this.cWo = new c();
        this.cWp = new b();
        this.cWq = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cWj = new a();
        this.cWk = false;
        this.cWl = true;
        this.cWm = true;
        this.cWo = new c();
        this.cWp = new b();
        this.cWq = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cWn = dVar;
    }

    private void init(Context context) {
        dK(context);
        dL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cWe);
        addView(this.cWf);
        this.cWh = new CoverFlowAdapter<>(context);
        this.cWh.setOnClickListener(this.cWo);
        this.cWe.setAdapter(this.cWh);
        this.cWe.setOnPageChangeListener(this.cWp);
    }

    private void dK(Context context) {
        this.cWe = new ListViewPager(context);
    }

    private void dL(Context context) {
        this.cWf = new IndicatorView(context);
        this.cWf.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kj(int i) {
        if (this.cWh == null) {
            return null;
        }
        return this.cWh.kj(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cWh.a(list, this.cWi);
            int size = list.size();
            if (size > 1) {
                this.cWf.setVisibility(0);
                this.cWf.setCount(size);
                this.cWe.setCurrentItem(1, false);
                this.cWf.setPosition(0.0f);
                aEW();
                return;
            }
            this.cWf.setVisibility(8);
            this.cWf.setCount(size);
            this.cWe.setCurrentItem(1, false);
            this.cWf.setPosition(0.0f);
            aEX();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cWi = aVar;
            this.cWg = aVar.aET();
            this.cWg.g(this.cWf);
            aVar.aEU().b(this.cWe);
            this.mCustomView = aVar.aEV();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cWe);
                addView(this.mCustomView);
                addView(this.cWf);
            }
        }
    }

    public void aEW() {
        aEY();
    }

    public void aEX() {
        this.cWj.removeMessages(1);
    }

    public void aEY() {
        this.cWj.removeMessages(1);
        this.cWj.sendEmptyMessageDelayed(1, this.cWq);
    }

    public void setIndicatorVisible(int i) {
        if (this.cWf != null) {
            this.cWf.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cWq = j;
        aEY();
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
                    CoverFlowView.this.aEZ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEZ() {
        int count;
        if (this.cWe != null && this.cWh != null && (count = this.cWh.getCount()) > 1) {
            int currentItem = this.cWe.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWe.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cWe.setCurrentItem(1, false);
            } else {
                this.cWe.setCurrentItem(currentItem + 1);
            }
            this.cWe.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFa() {
        int count;
        if (this.cWh != null && (count = this.cWh.getCount()) > 1) {
            int currentItem = this.cWe.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWe.setCurrentItem(i, false);
                this.cWe.invalidate();
            } else if (currentItem > i) {
                this.cWe.setCurrentItem(1, false);
                this.cWe.invalidate();
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
            if (CoverFlowView.this.cWf != null && CoverFlowView.this.cWh != null) {
                if (CoverFlowView.this.cWh.getCount() == 1 && i == 0 && CoverFlowView.this.cWn != null) {
                    CoverFlowView.this.cWn.a(1, CoverFlowView.this.cWh.kj(i));
                }
                if (CoverFlowView.this.cWf.getVisibility() == 0 && !CoverFlowView.this.cWk) {
                    int count = CoverFlowView.this.cWh.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cWf.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cWf.setPosition(f);
                    } else {
                        CoverFlowView.this.cWf.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cWh != null) {
                int count = CoverFlowView.this.cWh.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cWk) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cWn != null) {
                        CoverFlowView.this.cWn.a(i, CoverFlowView.this.cWh.kj(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cWe != null && CoverFlowView.this.cWh != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cWm) {
                            CoverFlowView.this.aFb();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cWm = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cWm) {
                            CoverFlowView.this.aEX();
                            CoverFlowView.this.aFa();
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
        int count = this.cWh.getCount();
        if (i == 0) {
            this.cWf.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cWf.setPosition(i);
        } else {
            this.cWf.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFb() {
        if (aFa()) {
            aEY();
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
            com.baidu.tbadk.core.flow.a.a kj;
            if (CoverFlowView.this.cWn != null && (view.getTag() instanceof Integer) && (kj = CoverFlowView.this.cWh.kj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cWn.Q(intValue, kj.aAB());
            }
        }
    }

    public void onChangeSkinType() {
        this.cWh.onChangeSkinType();
        if (this.cWf != null && this.cWg != null) {
            this.cWf.setDrawable(am.getDrawable(this.cWg.aFc()));
            this.cWf.setSelector(am.getDrawable(this.cWg.aFd()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cWe != null) {
            this.cWe.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cWe != null) {
            this.cWe.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cWk = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cWl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cWl;
    }

    private void setAutoPlay(boolean z) {
        this.cWm = z;
    }
}
