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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager VZ;
    private IndicatorView Wa;
    private com.baidu.tbadk.core.flow.a.c Wb;
    private com.baidu.tbadk.core.flow.a<T> Wc;
    private com.baidu.tbadk.core.flow.b Wd;
    private CoverFlowView<T>.a We;
    private d<T> Wf;
    private CoverFlowView<T>.c Wg;
    private CoverFlowView<T>.b Wh;
    private long Wi;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.We = new a(this, null);
        this.Wg = new c(this, null);
        this.Wh = new b(this, null);
        this.Wi = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.We = new a(this, null);
        this.Wg = new c(this, null);
        this.Wh = new b(this, null);
        this.Wi = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.We = new a(this, null);
        this.Wg = new c(this, null);
        this.Wh = new b(this, null);
        this.Wi = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.Wf = dVar;
    }

    private void init(Context context) {
        T(context);
        U(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.VZ);
        addView(this.Wa);
        this.Wc = new com.baidu.tbadk.core.flow.a<>(context);
        this.Wc.setOnClickListener(this.Wg);
        this.VZ.setAdapter(this.Wc);
        this.VZ.setOnPageChangeListener(this.Wh);
    }

    private void T(Context context) {
        this.VZ = new ListViewPager(context);
    }

    private void U(Context context) {
        this.Wa = new IndicatorView(context);
        this.Wa.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.Wc.a(list, this.Wd);
            int size = list.size();
            if (size > 1) {
                this.Wa.setVisibility(0);
                this.Wa.setCount(size);
                this.VZ.setCurrentItem(1, false);
                this.Wa.setPosition(0.0f);
                tk();
                return;
            }
            this.Wa.setVisibility(8);
            tl();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.Wd = bVar;
            this.Wb = bVar.th();
            this.Wb.g(this.Wa);
            bVar.ti().b(this.VZ);
            this.mCustomView = bVar.tj();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.VZ);
                addView(this.mCustomView);
                addView(this.Wa);
            }
        }
    }

    public void tk() {
        tm();
    }

    public void tl() {
        this.We.removeMessages(1);
    }

    public void tm() {
        this.We.removeMessages(1);
        this.We.sendEmptyMessageDelayed(1, this.Wi);
    }

    public void setMarqueenTime(long j) {
        this.Wi = j;
        tm();
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
                    CoverFlowView.this.tn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tn() {
        int count;
        if (this.VZ != null && this.Wc != null && (count = this.Wc.getCount()) > 1) {
            int currentItem = this.VZ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.VZ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.VZ.setCurrentItem(1, false);
            } else {
                this.VZ.setCurrentItem(currentItem + 1);
            }
            this.VZ.invalidate();
        }
    }

    private boolean to() {
        int count;
        if (this.Wc != null && (count = this.Wc.getCount()) > 1) {
            int currentItem = this.VZ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.VZ.setCurrentItem(i, false);
                this.VZ.invalidate();
            } else if (currentItem > i) {
                this.VZ.setCurrentItem(1, false);
                this.VZ.invalidate();
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
            if (CoverFlowView.this.Wa != null && CoverFlowView.this.Wc != null && CoverFlowView.this.Wa.getVisibility() == 0) {
                int count = CoverFlowView.this.Wc.getCount();
                if (i == 0) {
                    CoverFlowView.this.Wa.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.Wa.setPosition(f);
                } else {
                    CoverFlowView.this.Wa.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.Wc != null) {
                int count = CoverFlowView.this.Wc.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.Wf != null) {
                    CoverFlowView.this.Wf.a(i, CoverFlowView.this.Wc.cs(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.VZ == null || CoverFlowView.this.Wc == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.tp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp() {
        if (to()) {
            tm();
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
            com.baidu.tbadk.core.flow.a.a cs;
            if (CoverFlowView.this.Wf != null && (view.getTag() instanceof Integer) && (cs = CoverFlowView.this.Wc.cs((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.Wf.f(intValue, cs.pB());
            }
        }
    }

    public void tg() {
        this.Wc.tg();
        if (this.Wa != null && this.Wb != null) {
            this.Wa.setDrawable(ap.getDrawable(this.Wb.tq()));
            this.Wa.setSelector(ap.getDrawable(this.Wb.tr()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.VZ != null) {
            this.VZ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.VZ != null) {
            this.VZ.setDisableParentEvent(z);
        }
    }
}
