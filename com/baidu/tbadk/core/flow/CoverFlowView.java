package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager abm;
    private IndicatorView abn;
    private com.baidu.tbadk.core.flow.a.c abo;
    private com.baidu.tbadk.core.flow.a<T> abp;
    private com.baidu.tbadk.core.flow.b abq;
    private CoverFlowView<T>.a abr;
    private d<T> abt;
    private CoverFlowView<T>.c abu;
    private CoverFlowView<T>.b abv;
    private long abw;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abr = new a(this, null);
        this.abu = new c(this, null);
        this.abv = new b(this, null);
        this.abw = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abr = new a(this, null);
        this.abu = new c(this, null);
        this.abv = new b(this, null);
        this.abw = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abr = new a(this, null);
        this.abu = new c(this, null);
        this.abv = new b(this, null);
        this.abw = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abt = dVar;
    }

    private void init(Context context) {
        ar(context);
        as(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.abm);
        addView(this.abn);
        this.abp = new com.baidu.tbadk.core.flow.a<>(context);
        this.abp.setOnClickListener(this.abu);
        this.abm.setAdapter(this.abp);
        this.abm.setOnPageChangeListener(this.abv);
    }

    private void ar(Context context) {
        this.abm = new ListViewPager(context);
    }

    private void as(Context context) {
        this.abn = new IndicatorView(context);
        this.abn.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.abp.a(list, this.abq);
            int size = list.size();
            if (size > 1) {
                this.abn.setVisibility(0);
                this.abn.setCount(size);
                this.abm.setCurrentItem(1, false);
                this.abn.setPosition(0.0f);
                tH();
                return;
            }
            this.abn.setVisibility(8);
            tI();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abq = bVar;
            this.abo = bVar.tE();
            this.abo.g(this.abn);
            bVar.tF().b(this.abm);
            this.mCustomView = bVar.tG();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.abm);
                addView(this.mCustomView);
                addView(this.abn);
            }
        }
    }

    public void tH() {
        tJ();
    }

    public void tI() {
        this.abr.removeMessages(1);
    }

    public void tJ() {
        this.abr.removeMessages(1);
        this.abr.sendEmptyMessageDelayed(1, this.abw);
    }

    public void setMarqueenTime(long j) {
        this.abw = j;
        tJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(CoverFlowView coverFlowView, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.tK();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK() {
        int count;
        if (this.abm != null && this.abp != null && (count = this.abp.getCount()) > 1) {
            int currentItem = this.abm.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abm.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.abm.setCurrentItem(1, false);
            } else {
                this.abm.setCurrentItem(currentItem + 1);
            }
            this.abm.invalidate();
        }
    }

    private boolean tL() {
        int count;
        if (this.abp != null && (count = this.abp.getCount()) > 1) {
            int currentItem = this.abm.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abm.setCurrentItem(i, false);
                this.abm.invalidate();
            } else if (currentItem > i) {
                this.abm.setCurrentItem(1, false);
                this.abm.invalidate();
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

        /* synthetic */ b(CoverFlowView coverFlowView, b bVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.abn != null && CoverFlowView.this.abp != null && CoverFlowView.this.abn.getVisibility() == 0) {
                int count = CoverFlowView.this.abp.getCount();
                if (i == 0) {
                    CoverFlowView.this.abn.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.abn.setPosition(f);
                } else {
                    CoverFlowView.this.abn.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.abp != null) {
                int count = CoverFlowView.this.abp.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abt != null) {
                    CoverFlowView.this.abt.a(i, CoverFlowView.this.abp.co(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.abm == null || CoverFlowView.this.abp == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tM();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        if (tL()) {
            tJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(CoverFlowView coverFlowView, c cVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a co;
            if (CoverFlowView.this.abt != null && (view.getTag() instanceof Integer) && (co = CoverFlowView.this.abp.co((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abt.g(intValue, co.pT());
            }
        }
    }

    public void tD() {
        this.abp.tD();
        if (this.abn != null && this.abo != null) {
            this.abn.setDrawable(aq.getDrawable(this.abo.tN()));
            this.abn.setSelector(aq.getDrawable(this.abo.tO()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.abm != null) {
            this.abm.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.abm != null) {
            this.abm.setDisableParentEvent(z);
        }
    }
}
