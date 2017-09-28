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
    private ListViewPager acc;
    private IndicatorView acd;
    private com.baidu.tbadk.core.flow.a.c ace;
    private com.baidu.tbadk.core.flow.a<T> acf;
    private com.baidu.tbadk.core.flow.b acg;
    private CoverFlowView<T>.a ach;
    private d<T> aci;
    private CoverFlowView<T>.c acj;
    private CoverFlowView<T>.b ack;
    private long acl;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ach = new a();
        this.acj = new c();
        this.ack = new b();
        this.acl = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ach = new a();
        this.acj = new c();
        this.ack = new b();
        this.acl = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ach = new a();
        this.acj = new c();
        this.ack = new b();
        this.acl = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aci = dVar;
    }

    private void init(Context context) {
        aA(context);
        aB(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acc);
        addView(this.acd);
        this.acf = new com.baidu.tbadk.core.flow.a<>(context);
        this.acf.setOnClickListener(this.acj);
        this.acc.setAdapter(this.acf);
        this.acc.setOnPageChangeListener(this.ack);
    }

    private void aA(Context context) {
        this.acc = new ListViewPager(context);
    }

    private void aB(Context context) {
        this.acd = new IndicatorView(context);
        this.acd.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acf == null) {
            return null;
        }
        return this.acf.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acf.a(list, this.acg);
            int size = list.size();
            if (size > 1) {
                this.acd.setVisibility(0);
                this.acd.setCount(size);
                this.acc.setCurrentItem(1, false);
                this.acd.setPosition(0.0f);
                tw();
                return;
            }
            this.acd.setVisibility(8);
            tx();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acg = bVar;
            this.ace = bVar.tt();
            this.ace.g(this.acd);
            bVar.tu().a(this.acc);
            this.mCustomView = bVar.tv();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acc);
                addView(this.mCustomView);
                addView(this.acd);
            }
        }
    }

    public void tw() {
        ty();
    }

    public void tx() {
        this.ach.removeMessages(1);
    }

    public void ty() {
        this.ach.removeMessages(1);
        this.ach.sendEmptyMessageDelayed(1, this.acl);
    }

    public void setMarqueenTime(long j) {
        this.acl = j;
        ty();
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
                    CoverFlowView.this.tz();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        int count;
        if (this.acc != null && this.acf != null && (count = this.acf.getCount()) > 1) {
            int currentItem = this.acc.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acc.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acc.setCurrentItem(1, false);
            } else {
                this.acc.setCurrentItem(currentItem + 1);
            }
            this.acc.invalidate();
        }
    }

    private boolean tA() {
        int count;
        if (this.acf != null && (count = this.acf.getCount()) > 1) {
            int currentItem = this.acc.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acc.setCurrentItem(i, false);
                this.acc.invalidate();
            } else if (currentItem > i) {
                this.acc.setCurrentItem(1, false);
                this.acc.invalidate();
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
            if (CoverFlowView.this.acd != null && CoverFlowView.this.acf != null && CoverFlowView.this.acd.getVisibility() == 0) {
                int count = CoverFlowView.this.acf.getCount();
                if (i == 0) {
                    CoverFlowView.this.acd.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acd.setPosition(f);
                } else {
                    CoverFlowView.this.acd.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acf != null) {
                int count = CoverFlowView.this.acf.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aci != null) {
                    CoverFlowView.this.aci.a(i, CoverFlowView.this.acf.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acc != null && CoverFlowView.this.acf != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tB();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB() {
        if (tA()) {
            ty();
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
            if (CoverFlowView.this.aci != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acf.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aci.g(intValue, cu.pN());
            }
        }
    }

    public void onChangeSkinType() {
        this.acf.onChangeSkinType();
        if (this.acd != null && this.ace != null) {
            this.acd.setDrawable(aj.getDrawable(this.ace.tC()));
            this.acd.setSelector(aj.getDrawable(this.ace.tD()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acc != null) {
            this.acc.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acc != null) {
            this.acc.setDisableParentEvent(z);
        }
    }
}
