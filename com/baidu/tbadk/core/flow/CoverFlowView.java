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
    private ListViewPager cWc;
    private IndicatorView cWd;
    private com.baidu.tbadk.core.flow.a.c cWe;
    private CoverFlowAdapter<T> cWf;
    private com.baidu.tbadk.core.flow.a cWg;
    private CoverFlowView<T>.a cWh;
    private boolean cWi;
    private boolean cWj;
    private boolean cWk;
    private d<T> cWl;
    private CoverFlowView<T>.c cWm;
    private CoverFlowView<T>.b cWn;
    private long cWo;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cWh = new a();
        this.cWi = false;
        this.cWj = true;
        this.cWk = true;
        this.cWm = new c();
        this.cWn = new b();
        this.cWo = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cWh = new a();
        this.cWi = false;
        this.cWj = true;
        this.cWk = true;
        this.cWm = new c();
        this.cWn = new b();
        this.cWo = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cWh = new a();
        this.cWi = false;
        this.cWj = true;
        this.cWk = true;
        this.cWm = new c();
        this.cWn = new b();
        this.cWo = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cWl = dVar;
    }

    private void init(Context context) {
        dK(context);
        dL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cWc);
        addView(this.cWd);
        this.cWf = new CoverFlowAdapter<>(context);
        this.cWf.setOnClickListener(this.cWm);
        this.cWc.setAdapter(this.cWf);
        this.cWc.setOnPageChangeListener(this.cWn);
    }

    private void dK(Context context) {
        this.cWc = new ListViewPager(context);
    }

    private void dL(Context context) {
        this.cWd = new IndicatorView(context);
        this.cWd.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kj(int i) {
        if (this.cWf == null) {
            return null;
        }
        return this.cWf.kj(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cWf.a(list, this.cWg);
            int size = list.size();
            if (size > 1) {
                this.cWd.setVisibility(0);
                this.cWd.setCount(size);
                this.cWc.setCurrentItem(1, false);
                this.cWd.setPosition(0.0f);
                aEU();
                return;
            }
            this.cWd.setVisibility(8);
            this.cWd.setCount(size);
            this.cWc.setCurrentItem(1, false);
            this.cWd.setPosition(0.0f);
            aEV();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cWg = aVar;
            this.cWe = aVar.aER();
            this.cWe.g(this.cWd);
            aVar.aES().b(this.cWc);
            this.mCustomView = aVar.aET();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cWc);
                addView(this.mCustomView);
                addView(this.cWd);
            }
        }
    }

    public void aEU() {
        aEW();
    }

    public void aEV() {
        this.cWh.removeMessages(1);
    }

    public void aEW() {
        this.cWh.removeMessages(1);
        this.cWh.sendEmptyMessageDelayed(1, this.cWo);
    }

    public void setIndicatorVisible(int i) {
        if (this.cWd != null) {
            this.cWd.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cWo = j;
        aEW();
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
                    CoverFlowView.this.aEX();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEX() {
        int count;
        if (this.cWc != null && this.cWf != null && (count = this.cWf.getCount()) > 1) {
            int currentItem = this.cWc.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWc.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cWc.setCurrentItem(1, false);
            } else {
                this.cWc.setCurrentItem(currentItem + 1);
            }
            this.cWc.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEY() {
        int count;
        if (this.cWf != null && (count = this.cWf.getCount()) > 1) {
            int currentItem = this.cWc.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cWc.setCurrentItem(i, false);
                this.cWc.invalidate();
            } else if (currentItem > i) {
                this.cWc.setCurrentItem(1, false);
                this.cWc.invalidate();
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
            if (CoverFlowView.this.cWd != null && CoverFlowView.this.cWf != null) {
                if (CoverFlowView.this.cWf.getCount() == 1 && i == 0 && CoverFlowView.this.cWl != null) {
                    CoverFlowView.this.cWl.a(1, CoverFlowView.this.cWf.kj(i));
                }
                if (CoverFlowView.this.cWd.getVisibility() == 0 && !CoverFlowView.this.cWi) {
                    int count = CoverFlowView.this.cWf.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cWd.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cWd.setPosition(f);
                    } else {
                        CoverFlowView.this.cWd.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cWf != null) {
                int count = CoverFlowView.this.cWf.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cWi) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cWl != null) {
                        CoverFlowView.this.cWl.a(i, CoverFlowView.this.cWf.kj(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cWc != null && CoverFlowView.this.cWf != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cWk) {
                            CoverFlowView.this.aEZ();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cWk = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cWk) {
                            CoverFlowView.this.aEV();
                            CoverFlowView.this.aEY();
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
        int count = this.cWf.getCount();
        if (i == 0) {
            this.cWd.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cWd.setPosition(i);
        } else {
            this.cWd.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEZ() {
        if (aEY()) {
            aEW();
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
            if (CoverFlowView.this.cWl != null && (view.getTag() instanceof Integer) && (kj = CoverFlowView.this.cWf.kj((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cWl.Q(intValue, kj.aAz());
            }
        }
    }

    public void onChangeSkinType() {
        this.cWf.onChangeSkinType();
        if (this.cWd != null && this.cWe != null) {
            this.cWd.setDrawable(am.getDrawable(this.cWe.aFa()));
            this.cWd.setSelector(am.getDrawable(this.cWe.aFb()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cWc != null) {
            this.cWc.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cWc != null) {
            this.cWc.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cWi = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cWj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cWj;
    }

    private void setAutoPlay(boolean z) {
        this.cWk = z;
    }
}
