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
import com.baidu.adp.widget.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager acb;
    private IndicatorView acc;
    private com.baidu.tbadk.core.flow.a.c acd;
    private com.baidu.tbadk.core.flow.a<T> ace;
    private com.baidu.tbadk.core.flow.b acf;
    private CoverFlowView<T>.a acg;
    private d<T> ach;
    private CoverFlowView<T>.c aci;
    private CoverFlowView<T>.b acj;
    private long ack;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acg = new a();
        this.aci = new c();
        this.acj = new b();
        this.ack = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acg = new a();
        this.aci = new c();
        this.acj = new b();
        this.ack = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acg = new a();
        this.aci = new c();
        this.acj = new b();
        this.ack = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ach = dVar;
    }

    private void init(Context context) {
        aA(context);
        aB(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acb);
        addView(this.acc);
        this.ace = new com.baidu.tbadk.core.flow.a<>(context);
        this.ace.setOnClickListener(this.aci);
        this.acb.setAdapter(this.ace);
        this.acb.setOnPageChangeListener(this.acj);
    }

    private void aA(Context context) {
        this.acb = new ListViewPager(context);
    }

    private void aB(Context context) {
        this.acc = new IndicatorView(context);
        this.acc.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.ace == null) {
            return null;
        }
        return this.ace.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.ace.a(list, this.acf);
            int size = list.size();
            if (size > 1) {
                this.acc.setVisibility(0);
                this.acc.setCount(size);
                this.acb.setCurrentItem(1, false);
                this.acc.setPosition(0.0f);
                tC();
                return;
            }
            this.acc.setVisibility(8);
            tD();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acf = bVar;
            this.acd = bVar.tz();
            this.acd.g(this.acc);
            bVar.tA().a(this.acb);
            this.mCustomView = bVar.tB();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acb);
                addView(this.mCustomView);
                addView(this.acc);
            }
        }
    }

    public void tC() {
        tE();
    }

    public void tD() {
        this.acg.removeMessages(1);
    }

    public void tE() {
        this.acg.removeMessages(1);
        this.acg.sendEmptyMessageDelayed(1, this.ack);
    }

    public void setMarqueenTime(long j) {
        this.ack = j;
        tE();
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
                    CoverFlowView.this.tF();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF() {
        int count;
        if (this.acb != null && this.ace != null && (count = this.ace.getCount()) > 1) {
            int currentItem = this.acb.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acb.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acb.setCurrentItem(1, false);
            } else {
                this.acb.setCurrentItem(currentItem + 1);
            }
            this.acb.invalidate();
        }
    }

    private boolean tG() {
        int count;
        if (this.ace != null && (count = this.ace.getCount()) > 1) {
            int currentItem = this.acb.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acb.setCurrentItem(i, false);
                this.acb.invalidate();
            } else if (currentItem > i) {
                this.acb.setCurrentItem(1, false);
                this.acb.invalidate();
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

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.acc != null && CoverFlowView.this.ace != null && CoverFlowView.this.acc.getVisibility() == 0) {
                int count = CoverFlowView.this.ace.getCount();
                if (i == 0) {
                    CoverFlowView.this.acc.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acc.setPosition(f);
                } else {
                    CoverFlowView.this.acc.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.ace != null) {
                int count = CoverFlowView.this.ace.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.ach != null) {
                    CoverFlowView.this.ach.a(i, CoverFlowView.this.ace.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acb != null && CoverFlowView.this.ace != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tH();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        if (tG()) {
            tE();
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
            com.baidu.tbadk.core.flow.a.a cu;
            if (CoverFlowView.this.ach != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.ace.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.ach.g(intValue, cu.pM());
            }
        }
    }

    public void onChangeSkinType() {
        this.ace.onChangeSkinType();
        if (this.acc != null && this.acd != null) {
            this.acc.setDrawable(aj.getDrawable(this.acd.tI()));
            this.acc.setSelector(aj.getDrawable(this.acd.tJ()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acb != null) {
            this.acb.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acb != null) {
            this.acb.setDisableParentEvent(z);
        }
    }
}
