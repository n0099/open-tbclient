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
    private ListViewPager cgi;
    private IndicatorView cgj;
    private com.baidu.tbadk.core.flow.a.c cgk;
    private CoverFlowAdapter<T> cgl;
    private com.baidu.tbadk.core.flow.a cgm;
    private CoverFlowView<T>.a cgn;
    private boolean cgo;
    private boolean cgp;
    private boolean cgq;
    private d<T> cgr;
    private CoverFlowView<T>.c cgs;
    private CoverFlowView<T>.b cgt;
    private long cgu;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cgn = new a();
        this.cgo = false;
        this.cgp = true;
        this.cgq = true;
        this.cgs = new c();
        this.cgt = new b();
        this.cgu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cgn = new a();
        this.cgo = false;
        this.cgp = true;
        this.cgq = true;
        this.cgs = new c();
        this.cgt = new b();
        this.cgu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cgn = new a();
        this.cgo = false;
        this.cgp = true;
        this.cgq = true;
        this.cgs = new c();
        this.cgt = new b();
        this.cgu = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cgr = dVar;
    }

    private void init(Context context) {
        cm(context);
        cn(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cgi);
        addView(this.cgj);
        this.cgl = new CoverFlowAdapter<>(context);
        this.cgl.setOnClickListener(this.cgs);
        this.cgi.setAdapter(this.cgl);
        this.cgi.setOnPageChangeListener(this.cgt);
    }

    private void cm(Context context) {
        this.cgi = new ListViewPager(context);
    }

    private void cn(Context context) {
        this.cgj = new IndicatorView(context);
        this.cgj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ih(int i) {
        if (this.cgl == null) {
            return null;
        }
        return this.cgl.ih(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cgl.a(list, this.cgm);
            int size = list.size();
            if (size > 1) {
                this.cgj.setVisibility(0);
                this.cgj.setCount(size);
                this.cgi.setCurrentItem(1, false);
                this.cgj.setPosition(0.0f);
                alj();
                return;
            }
            this.cgj.setVisibility(8);
            this.cgj.setCount(size);
            this.cgi.setCurrentItem(1, false);
            this.cgj.setPosition(0.0f);
            alk();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cgm = aVar;
            this.cgk = aVar.alg();
            this.cgk.g(this.cgj);
            aVar.alh().a(this.cgi);
            this.mCustomView = aVar.ali();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cgi);
                addView(this.mCustomView);
                addView(this.cgj);
            }
        }
    }

    public void alj() {
        all();
    }

    public void alk() {
        this.cgn.removeMessages(1);
    }

    public void all() {
        this.cgn.removeMessages(1);
        this.cgn.sendEmptyMessageDelayed(1, this.cgu);
    }

    public void setIndicatorVisible(int i) {
        if (this.cgj != null) {
            this.cgj.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cgu = j;
        all();
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
                    CoverFlowView.this.alm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alm() {
        int count;
        if (this.cgi != null && this.cgl != null && (count = this.cgl.getCount()) > 1) {
            int currentItem = this.cgi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cgi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cgi.setCurrentItem(1, false);
            } else {
                this.cgi.setCurrentItem(currentItem + 1);
            }
            this.cgi.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aln() {
        int count;
        if (this.cgl != null && (count = this.cgl.getCount()) > 1) {
            int currentItem = this.cgi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cgi.setCurrentItem(i, false);
                this.cgi.invalidate();
            } else if (currentItem > i) {
                this.cgi.setCurrentItem(1, false);
                this.cgi.invalidate();
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
            if (CoverFlowView.this.cgj != null && CoverFlowView.this.cgl != null) {
                if (CoverFlowView.this.cgl.getCount() == 1 && i == 0 && CoverFlowView.this.cgr != null) {
                    CoverFlowView.this.cgr.a(1, CoverFlowView.this.cgl.ih(i));
                }
                if (CoverFlowView.this.cgj.getVisibility() == 0 && !CoverFlowView.this.cgo) {
                    int count = CoverFlowView.this.cgl.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cgj.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cgj.setPosition(f);
                    } else {
                        CoverFlowView.this.cgj.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cgl != null) {
                int count = CoverFlowView.this.cgl.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cgo) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cgr != null) {
                        CoverFlowView.this.cgr.a(i, CoverFlowView.this.cgl.ih(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cgi != null && CoverFlowView.this.cgl != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cgq) {
                            CoverFlowView.this.alo();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cgq = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cgq) {
                            CoverFlowView.this.alk();
                            CoverFlowView.this.aln();
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
        int count = this.cgl.getCount();
        if (i == 0) {
            this.cgj.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cgj.setPosition(i);
        } else {
            this.cgj.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        if (aln()) {
            all();
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
            com.baidu.tbadk.core.flow.a.a ih;
            if (CoverFlowView.this.cgr != null && (view.getTag() instanceof Integer) && (ih = CoverFlowView.this.cgl.ih((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cgr.F(intValue, ih.aha());
            }
        }
    }

    public void onChangeSkinType() {
        this.cgl.onChangeSkinType();
        if (this.cgj != null && this.cgk != null) {
            this.cgj.setDrawable(am.getDrawable(this.cgk.alp()));
            this.cgj.setSelector(am.getDrawable(this.cgk.alq()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cgi != null) {
            this.cgi.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cgi != null) {
            this.cgi.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cgo = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cgp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cgp;
    }

    private void setAutoPlay(boolean z) {
        this.cgq = z;
    }
}
