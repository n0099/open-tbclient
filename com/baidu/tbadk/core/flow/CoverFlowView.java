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
    private ListViewPager cWd;
    private IndicatorView cWe;
    private com.baidu.tbadk.core.flow.a.c cWf;
    private CoverFlowAdapter<T> cWg;
    private com.baidu.tbadk.core.flow.a cWh;
    private CoverFlowView<T>.a cWi;
    private boolean cWj;
    private boolean cWk;
    private boolean cWl;
    private d<T> cWm;
    private CoverFlowView<T>.c cWn;
    private CoverFlowView<T>.b cWo;
    private long cWp;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cWi = new a();
        this.cWj = false;
        this.cWk = true;
        this.cWl = true;
        this.cWn = new c();
        this.cWo = new b();
        this.cWp = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cWi = new a();
        this.cWj = false;
        this.cWk = true;
        this.cWl = true;
        this.cWn = new c();
        this.cWo = new b();
        this.cWp = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cWi = new a();
        this.cWj = false;
        this.cWk = true;
        this.cWl = true;
        this.cWn = new c();
        this.cWo = new b();
        this.cWp = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cWm = dVar;
    }

    private void init(Context context) {
        dK(context);
        dL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cWd);
        addView(this.cWe);
        this.cWg = new CoverFlowAdapter<>(context);
        this.cWg.setOnClickListener(this.cWn);
        this.cWd.setAdapter(this.cWg);
        this.cWd.setOnPageChangeListener(this.cWo);
    }

    private void dK(Context context) {
        this.cWd = new ListViewPager(context);
    }

    private void dL(Context context) {
        this.cWe = new IndicatorView(context);
        this.cWe.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kj(int i) {
        if (this.cWg == null) {
            return null;
        }
        return this.cWg.kj(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cWg.a(list, this.cWh);
            int size = list.size();
            if (size > 1) {
                this.cWe.setVisibility(0);
                this.cWe.setCount(size);
                this.cWd.setCurrentItem(1, false);
                this.cWe.setPosition(0.0f);
                aEW();
                return;
            }
            this.cWe.setVisibility(8);
            this.cWe.setCount(size);
            this.cWd.setCurrentItem(1, false);
            this.cWe.setPosition(0.0f);
            aEX();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cWh = aVar;
            this.cWf = aVar.aET();
            this.cWf.g(this.cWe);
            aVar.aEU().b(this.cWd);
            this.mCustomView = aVar.aEV();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cWd);
                addView(this.mCustomView);
                addView(this.cWe);
            }
        }
    }

    public void aEW() {
        aEY();
    }

    public void aEX() {
        this.cWi.removeMessages(1);
    }

    public void aEY() {
        this.cWi.removeMessages(1);
        this.cWi.sendEmptyMessageDelayed(1, this.cWp);
    }

    public void setIndicatorVisible(int i) {
        if (this.cWe != null) {
            this.cWe.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cWp = j;
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
        if (this.cWd != null && this.cWg != null && (count = this.cWg.getCount()) > 1) {
            int currentItem = this.cWd.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWd.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cWd.setCurrentItem(1, false);
            } else {
                this.cWd.setCurrentItem(currentItem + 1);
            }
            this.cWd.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFa() {
        int count;
        if (this.cWg != null && (count = this.cWg.getCount()) > 1) {
            int currentItem = this.cWd.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWd.setCurrentItem(i, false);
                this.cWd.invalidate();
            } else if (currentItem > i) {
                this.cWd.setCurrentItem(1, false);
                this.cWd.invalidate();
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
            if (CoverFlowView.this.cWe != null && CoverFlowView.this.cWg != null) {
                if (CoverFlowView.this.cWg.getCount() == 1 && i == 0 && CoverFlowView.this.cWm != null) {
                    CoverFlowView.this.cWm.a(1, CoverFlowView.this.cWg.kj(i));
                }
                if (CoverFlowView.this.cWe.getVisibility() == 0 && !CoverFlowView.this.cWj) {
                    int count = CoverFlowView.this.cWg.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cWe.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cWe.setPosition(f);
                    } else {
                        CoverFlowView.this.cWe.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cWg != null) {
                int count = CoverFlowView.this.cWg.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cWj) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cWm != null) {
                        CoverFlowView.this.cWm.a(i, CoverFlowView.this.cWg.kj(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cWd != null && CoverFlowView.this.cWg != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cWl) {
                            CoverFlowView.this.aFb();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cWl = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cWl) {
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
        int count = this.cWg.getCount();
        if (i == 0) {
            this.cWe.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cWe.setPosition(i);
        } else {
            this.cWe.setPosition(i - 1);
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
            if (CoverFlowView.this.cWm != null && (view.getTag() instanceof Integer) && (kj = CoverFlowView.this.cWg.kj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cWm.Q(intValue, kj.aAB());
            }
        }
    }

    public void onChangeSkinType() {
        this.cWg.onChangeSkinType();
        if (this.cWe != null && this.cWf != null) {
            this.cWe.setDrawable(am.getDrawable(this.cWf.aFc()));
            this.cWe.setSelector(am.getDrawable(this.cWf.aFd()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cWd != null) {
            this.cWd.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cWd != null) {
            this.cWd.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cWj = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cWk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cWk;
    }

    private void setAutoPlay(boolean z) {
        this.cWl = z;
    }
}
