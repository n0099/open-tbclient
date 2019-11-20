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
    private d<T> cfA;
    private CoverFlowView<T>.c cfB;
    private CoverFlowView<T>.b cfC;
    private long cfD;
    private ListViewPager cfr;
    private IndicatorView cfs;
    private com.baidu.tbadk.core.flow.a.c cft;
    private CoverFlowAdapter<T> cfu;
    private com.baidu.tbadk.core.flow.a cfv;
    private CoverFlowView<T>.a cfw;
    private boolean cfx;
    private boolean cfy;
    private boolean cfz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.cfw = new a();
        this.cfx = false;
        this.cfy = true;
        this.cfz = true;
        this.cfB = new c();
        this.cfC = new b();
        this.cfD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.cfw = new a();
        this.cfx = false;
        this.cfy = true;
        this.cfz = true;
        this.cfB = new c();
        this.cfC = new b();
        this.cfD = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.cfw = new a();
        this.cfx = false;
        this.cfy = true;
        this.cfz = true;
        this.cfB = new c();
        this.cfC = new b();
        this.cfD = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.cfA = dVar;
    }

    private void init(Context context) {
        cm(context);
        cn(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.cfr);
        addView(this.cfs);
        this.cfu = new CoverFlowAdapter<>(context);
        this.cfu.setOnClickListener(this.cfB);
        this.cfr.setAdapter(this.cfu);
        this.cfr.setOnPageChangeListener(this.cfC);
    }

    private void cm(Context context) {
        this.cfr = new ListViewPager(context);
    }

    private void cn(Context context) {
        this.cfs = new IndicatorView(context);
        this.cfs.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ig(int i) {
        if (this.cfu == null) {
            return null;
        }
        return this.cfu.ig(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.cfu.a(list, this.cfv);
            int size = list.size();
            if (size > 1) {
                this.cfs.setVisibility(0);
                this.cfs.setCount(size);
                this.cfr.setCurrentItem(1, false);
                this.cfs.setPosition(0.0f);
                alh();
                return;
            }
            this.cfs.setVisibility(8);
            this.cfs.setCount(size);
            this.cfr.setCurrentItem(1, false);
            this.cfs.setPosition(0.0f);
            ali();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.cfv = aVar;
            this.cft = aVar.ale();
            this.cft.g(this.cfs);
            aVar.alf().a(this.cfr);
            this.mCustomView = aVar.alg();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.cfr);
                addView(this.mCustomView);
                addView(this.cfs);
            }
        }
    }

    public void alh() {
        alj();
    }

    public void ali() {
        this.cfw.removeMessages(1);
    }

    public void alj() {
        this.cfw.removeMessages(1);
        this.cfw.sendEmptyMessageDelayed(1, this.cfD);
    }

    public void setIndicatorVisible(int i) {
        if (this.cfs != null) {
            this.cfs.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.cfD = j;
        alj();
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
                    CoverFlowView.this.alk();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alk() {
        int count;
        if (this.cfr != null && this.cfu != null && (count = this.cfu.getCount()) > 1) {
            int currentItem = this.cfr.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cfr.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.cfr.setCurrentItem(1, false);
            } else {
                this.cfr.setCurrentItem(currentItem + 1);
            }
            this.cfr.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean all() {
        int count;
        if (this.cfu != null && (count = this.cfu.getCount()) > 1) {
            int currentItem = this.cfr.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.cfr.setCurrentItem(i, false);
                this.cfr.invalidate();
            } else if (currentItem > i) {
                this.cfr.setCurrentItem(1, false);
                this.cfr.invalidate();
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
            if (CoverFlowView.this.cfs != null && CoverFlowView.this.cfu != null) {
                if (CoverFlowView.this.cfu.getCount() == 1 && i == 0 && CoverFlowView.this.cfA != null) {
                    CoverFlowView.this.cfA.a(1, CoverFlowView.this.cfu.ig(i));
                }
                if (CoverFlowView.this.cfs.getVisibility() == 0 && !CoverFlowView.this.cfx) {
                    int count = CoverFlowView.this.cfu.getCount();
                    if (i == 0) {
                        CoverFlowView.this.cfs.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.cfs.setPosition(f);
                    } else {
                        CoverFlowView.this.cfs.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.cfu != null) {
                int count = CoverFlowView.this.cfu.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.cfx) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.cfA != null) {
                        CoverFlowView.this.cfA.a(i, CoverFlowView.this.cfu.ig(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.cfr != null && CoverFlowView.this.cfu != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.cfz) {
                            CoverFlowView.this.alm();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.cfz = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.cfz) {
                            CoverFlowView.this.ali();
                            CoverFlowView.this.all();
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
        int count = this.cfu.getCount();
        if (i == 0) {
            this.cfs.setPosition(0.0f);
        } else if (i == count - 1) {
            this.cfs.setPosition(i);
        } else {
            this.cfs.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alm() {
        if (all()) {
            alj();
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
            com.baidu.tbadk.core.flow.a.a ig;
            if (CoverFlowView.this.cfA != null && (view.getTag() instanceof Integer) && (ig = CoverFlowView.this.cfu.ig((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.cfA.E(intValue, ig.agY());
            }
        }
    }

    public void onChangeSkinType() {
        this.cfu.onChangeSkinType();
        if (this.cfs != null && this.cft != null) {
            this.cfs.setDrawable(am.getDrawable(this.cft.aln()));
            this.cfs.setSelector(am.getDrawable(this.cft.alo()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.cfr != null) {
            this.cfr.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.cfr != null) {
            this.cfr.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.cfx = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.cfy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.cfy;
    }

    private void setAutoPlay(boolean z) {
        this.cfz = z;
    }
}
