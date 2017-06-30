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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager aaX;
    private IndicatorView aaY;
    private com.baidu.tbadk.core.flow.a.c aaZ;
    private com.baidu.tbadk.core.flow.a<T> aba;
    private com.baidu.tbadk.core.flow.b abb;
    private CoverFlowView<T>.a abc;
    private d<T> abd;
    private CoverFlowView<T>.c abe;
    private CoverFlowView<T>.b abf;
    private long abg;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abc = new a(this, null);
        this.abe = new c(this, null);
        this.abf = new b(this, null);
        this.abg = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abc = new a(this, null);
        this.abe = new c(this, null);
        this.abf = new b(this, null);
        this.abg = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abc = new a(this, null);
        this.abe = new c(this, null);
        this.abf = new b(this, null);
        this.abg = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abd = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aaX);
        addView(this.aaY);
        this.aba = new com.baidu.tbadk.core.flow.a<>(context);
        this.aba.setOnClickListener(this.abe);
        this.aaX.setAdapter(this.aba);
        this.aaX.setOnPageChangeListener(this.abf);
    }

    private void at(Context context) {
        this.aaX = new ListViewPager(context);
    }

    private void au(Context context) {
        this.aaY = new IndicatorView(context);
        this.aaY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cq(int i) {
        if (this.aba == null) {
            return null;
        }
        return this.aba.cq(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aba.a(list, this.abb);
            int size = list.size();
            if (size > 1) {
                this.aaY.setVisibility(0);
                this.aaY.setCount(size);
                this.aaX.setCurrentItem(1, false);
                this.aaY.setPosition(0.0f);
                to();
                return;
            }
            this.aaY.setVisibility(8);
            tp();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abb = bVar;
            this.aaZ = bVar.tl();
            this.aaZ.g(this.aaY);
            bVar.tm().b(this.aaX);
            this.mCustomView = bVar.tn();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aaX);
                addView(this.mCustomView);
                addView(this.aaY);
            }
        }
    }

    public void to() {
        tq();
    }

    public void tp() {
        this.abc.removeMessages(1);
    }

    public void tq() {
        this.abc.removeMessages(1);
        this.abc.sendEmptyMessageDelayed(1, this.abg);
    }

    public void setMarqueenTime(long j) {
        this.abg = j;
        tq();
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
                    CoverFlowView.this.tr();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr() {
        int count;
        if (this.aaX != null && this.aba != null && (count = this.aba.getCount()) > 1) {
            int currentItem = this.aaX.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aaX.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aaX.setCurrentItem(1, false);
            } else {
                this.aaX.setCurrentItem(currentItem + 1);
            }
            this.aaX.invalidate();
        }
    }

    private boolean ts() {
        int count;
        if (this.aba != null && (count = this.aba.getCount()) > 1) {
            int currentItem = this.aaX.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aaX.setCurrentItem(i, false);
                this.aaX.invalidate();
            } else if (currentItem > i) {
                this.aaX.setCurrentItem(1, false);
                this.aaX.invalidate();
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
            if (CoverFlowView.this.aaY != null && CoverFlowView.this.aba != null && CoverFlowView.this.aaY.getVisibility() == 0) {
                int count = CoverFlowView.this.aba.getCount();
                if (i == 0) {
                    CoverFlowView.this.aaY.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aaY.setPosition(f);
                } else {
                    CoverFlowView.this.aaY.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aba != null) {
                int count = CoverFlowView.this.aba.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abd != null) {
                    CoverFlowView.this.abd.a(i, CoverFlowView.this.aba.cq(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aaX == null || CoverFlowView.this.aba == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        if (ts()) {
            tq();
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
            if (CoverFlowView.this.abd != null && (view.getTag() instanceof Integer) && (cq = CoverFlowView.this.aba.cq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abd.g(intValue, cq.pD());
            }
        }
    }

    public void onChangeSkinType() {
        this.aba.onChangeSkinType();
        if (this.aaY != null && this.aaZ != null) {
            this.aaY.setDrawable(as.getDrawable(this.aaZ.tu()));
            this.aaY.setSelector(as.getDrawable(this.aaZ.tv()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.aaX != null) {
            this.aaX.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aaX != null) {
            this.aaX.setDisableParentEvent(z);
        }
    }
}
