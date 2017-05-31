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
    private ListViewPager aaW;
    private IndicatorView aaX;
    private com.baidu.tbadk.core.flow.a.c aaY;
    private com.baidu.tbadk.core.flow.a<T> aaZ;
    private com.baidu.tbadk.core.flow.b aba;
    private CoverFlowView<T>.a abb;
    private d<T> abc;
    private CoverFlowView<T>.c abd;
    private CoverFlowView<T>.b abe;
    private long abf;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abb = new a(this, null);
        this.abd = new c(this, null);
        this.abe = new b(this, null);
        this.abf = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abb = new a(this, null);
        this.abd = new c(this, null);
        this.abe = new b(this, null);
        this.abf = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abb = new a(this, null);
        this.abd = new c(this, null);
        this.abe = new b(this, null);
        this.abf = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abc = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aaW);
        addView(this.aaX);
        this.aaZ = new com.baidu.tbadk.core.flow.a<>(context);
        this.aaZ.setOnClickListener(this.abd);
        this.aaW.setAdapter(this.aaZ);
        this.aaW.setOnPageChangeListener(this.abe);
    }

    private void at(Context context) {
        this.aaW = new ListViewPager(context);
    }

    private void au(Context context) {
        this.aaX = new IndicatorView(context);
        this.aaX.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cq(int i) {
        if (this.aaZ == null) {
            return null;
        }
        return this.aaZ.cq(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aaZ.a(list, this.aba);
            int size = list.size();
            if (size > 1) {
                this.aaX.setVisibility(0);
                this.aaX.setCount(size);
                this.aaW.setCurrentItem(1, false);
                this.aaX.setPosition(0.0f);
                tq();
                return;
            }
            this.aaX.setVisibility(8);
            tr();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aba = bVar;
            this.aaY = bVar.tn();
            this.aaY.g(this.aaX);
            bVar.to().b(this.aaW);
            this.mCustomView = bVar.tp();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aaW);
                addView(this.mCustomView);
                addView(this.aaX);
            }
        }
    }

    public void tq() {
        ts();
    }

    public void tr() {
        this.abb.removeMessages(1);
    }

    public void ts() {
        this.abb.removeMessages(1);
        this.abb.sendEmptyMessageDelayed(1, this.abf);
    }

    public void setMarqueenTime(long j) {
        this.abf = j;
        ts();
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
                    CoverFlowView.this.tt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        int count;
        if (this.aaW != null && this.aaZ != null && (count = this.aaZ.getCount()) > 1) {
            int currentItem = this.aaW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aaW.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aaW.setCurrentItem(1, false);
            } else {
                this.aaW.setCurrentItem(currentItem + 1);
            }
            this.aaW.invalidate();
        }
    }

    private boolean tu() {
        int count;
        if (this.aaZ != null && (count = this.aaZ.getCount()) > 1) {
            int currentItem = this.aaW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aaW.setCurrentItem(i, false);
                this.aaW.invalidate();
            } else if (currentItem > i) {
                this.aaW.setCurrentItem(1, false);
                this.aaW.invalidate();
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
            if (CoverFlowView.this.aaX != null && CoverFlowView.this.aaZ != null && CoverFlowView.this.aaX.getVisibility() == 0) {
                int count = CoverFlowView.this.aaZ.getCount();
                if (i == 0) {
                    CoverFlowView.this.aaX.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aaX.setPosition(f);
                } else {
                    CoverFlowView.this.aaX.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aaZ != null) {
                int count = CoverFlowView.this.aaZ.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abc != null) {
                    CoverFlowView.this.abc.a(i, CoverFlowView.this.aaZ.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aaW == null || CoverFlowView.this.aaZ == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tv();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv() {
        if (tu()) {
            ts();
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
            com.baidu.tbadk.core.flow.a.a cq;
            if (CoverFlowView.this.abc != null && (view.getTag() instanceof Integer) && (cq = CoverFlowView.this.aaZ.cq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abc.g(intValue, cq.pG());
            }
        }
    }

    public void onChangeSkinType() {
        this.aaZ.onChangeSkinType();
        if (this.aaX != null && this.aaY != null) {
            this.aaX.setDrawable(aq.getDrawable(this.aaY.tw()));
            this.aaX.setSelector(aq.getDrawable(this.aaY.tx()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.aaW != null) {
            this.aaW.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aaW != null) {
            this.aaW.setDisableParentEvent(z);
        }
    }
}
