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
    private ListViewPager cSa;
    private IndicatorView cSb;
    private com.baidu.tbadk.core.flow.a.c cSc;
    private CoverFlowAdapter<T> cSd;
    private com.baidu.tbadk.core.flow.a cSe;
    private CoverFlowView<T>.a cSf;
    private boolean cSg;
    private boolean cSh;
    private boolean cSi;
    private d<T> cSj;
    private CoverFlowView<T>.c cSk;
    private CoverFlowView<T>.b cSl;
    private long cSm;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cSf = new a();
        this.cSg = false;
        this.cSh = true;
        this.cSi = true;
        this.cSk = new c();
        this.cSl = new b();
        this.cSm = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cSf = new a();
        this.cSg = false;
        this.cSh = true;
        this.cSi = true;
        this.cSk = new c();
        this.cSl = new b();
        this.cSm = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cSf = new a();
        this.cSg = false;
        this.cSh = true;
        this.cSi = true;
        this.cSk = new c();
        this.cSl = new b();
        this.cSm = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cSj = dVar;
    }

    private void init(Context context) {
        dG(context);
        dH(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cSa);
        addView(this.cSb);
        this.cSd = new CoverFlowAdapter<>(context);
        this.cSd.setOnClickListener(this.cSk);
        this.cSa.setAdapter(this.cSd);
        this.cSa.setOnPageChangeListener(this.cSl);
    }

    private void dG(Context context) {
        this.cSa = new ListViewPager(context);
    }

    private void dH(Context context) {
        this.cSb = new IndicatorView(context);
        this.cSb.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T jS(int i) {
        if (this.cSd == null) {
            return null;
        }
        return this.cSd.jS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cSd.a(list, this.cSe);
            int size = list.size();
            if (size > 1) {
                this.cSb.setVisibility(0);
                this.cSb.setCount(size);
                this.cSa.setCurrentItem(1, false);
                this.cSb.setPosition(0.0f);
                aCK();
                return;
            }
            this.cSb.setVisibility(8);
            this.cSb.setCount(size);
            this.cSa.setCurrentItem(1, false);
            this.cSb.setPosition(0.0f);
            aCL();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cSe = aVar;
            this.cSc = aVar.aCH();
            this.cSc.g(this.cSb);
            aVar.aCI().b(this.cSa);
            this.mCustomView = aVar.aCJ();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cSa);
                addView(this.mCustomView);
                addView(this.cSb);
            }
        }
    }

    public void aCK() {
        aCM();
    }

    public void aCL() {
        this.cSf.removeMessages(1);
    }

    public void aCM() {
        this.cSf.removeMessages(1);
        this.cSf.sendEmptyMessageDelayed(1, this.cSm);
    }

    public void setIndicatorVisible(int i) {
        if (this.cSb != null) {
            this.cSb.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cSm = j;
        aCM();
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
                    CoverFlowView.this.aCN();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        int count;
        if (this.cSa != null && this.cSd != null && (count = this.cSd.getCount()) > 1) {
            int currentItem = this.cSa.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cSa.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cSa.setCurrentItem(1, false);
            } else {
                this.cSa.setCurrentItem(currentItem + 1);
            }
            this.cSa.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCO() {
        int count;
        if (this.cSd != null && (count = this.cSd.getCount()) > 1) {
            int currentItem = this.cSa.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cSa.setCurrentItem(i, false);
                this.cSa.invalidate();
            } else if (currentItem > i) {
                this.cSa.setCurrentItem(1, false);
                this.cSa.invalidate();
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
            if (CoverFlowView.this.cSb != null && CoverFlowView.this.cSd != null) {
                if (CoverFlowView.this.cSd.getCount() == 1 && i == 0 && CoverFlowView.this.cSj != null) {
                    CoverFlowView.this.cSj.a(1, CoverFlowView.this.cSd.jS(i));
                }
                if (CoverFlowView.this.cSb.getVisibility() == 0 && !CoverFlowView.this.cSg) {
                    int count = CoverFlowView.this.cSd.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cSb.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cSb.setPosition(f);
                    } else {
                        CoverFlowView.this.cSb.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cSd != null) {
                int count = CoverFlowView.this.cSd.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cSg) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cSj != null) {
                        CoverFlowView.this.cSj.a(i, CoverFlowView.this.cSd.jS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cSa != null && CoverFlowView.this.cSd != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cSi) {
                            CoverFlowView.this.aCP();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cSi = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cSi) {
                            CoverFlowView.this.aCL();
                            CoverFlowView.this.aCO();
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
        int count = this.cSd.getCount();
        if (i == 0) {
            this.cSb.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cSb.setPosition(i);
        } else {
            this.cSb.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCP() {
        if (aCO()) {
            aCM();
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
            com.baidu.tbadk.core.flow.a.a jS;
            if (CoverFlowView.this.cSj != null && (view.getTag() instanceof Integer) && (jS = CoverFlowView.this.cSd.jS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cSj.O(intValue, jS.ayl());
            }
        }
    }

    public void onChangeSkinType() {
        this.cSd.onChangeSkinType();
        if (this.cSb != null && this.cSc != null) {
            this.cSb.setDrawable(am.getDrawable(this.cSc.aCQ()));
            this.cSb.setSelector(am.getDrawable(this.cSc.aCR()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cSa != null) {
            this.cSa.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cSa != null) {
            this.cSa.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cSg = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cSh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cSh;
    }

    private void setAutoPlay(boolean z) {
        this.cSi = z;
    }
}
