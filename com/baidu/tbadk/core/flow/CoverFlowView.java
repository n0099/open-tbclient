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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private com.baidu.tbadk.core.flow.b abA;
    private CoverFlowView<T>.a abB;
    private d<T> abC;
    private CoverFlowView<T>.c abD;
    private CoverFlowView<T>.b abE;
    private long abF;
    private ListViewPager abw;
    private IndicatorView abx;
    private com.baidu.tbadk.core.flow.a.c aby;
    private com.baidu.tbadk.core.flow.a<T> abz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abB = new a();
        this.abD = new c();
        this.abE = new b();
        this.abF = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abB = new a();
        this.abD = new c();
        this.abE = new b();
        this.abF = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abB = new a();
        this.abD = new c();
        this.abE = new b();
        this.abF = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abC = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.abw);
        addView(this.abx);
        this.abz = new com.baidu.tbadk.core.flow.a<>(context);
        this.abz.setOnClickListener(this.abD);
        this.abw.setAdapter(this.abz);
        this.abw.setOnPageChangeListener(this.abE);
    }

    private void at(Context context) {
        this.abw = new ListViewPager(context);
    }

    private void au(Context context) {
        this.abx = new IndicatorView(context);
        this.abx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cs(int i) {
        if (this.abz == null) {
            return null;
        }
        return this.abz.cs(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.abz.a(list, this.abA);
            int size = list.size();
            if (size > 1) {
                this.abx.setVisibility(0);
                this.abx.setCount(size);
                this.abw.setCurrentItem(1, false);
                this.abx.setPosition(0.0f);
                tv();
                return;
            }
            this.abx.setVisibility(8);
            tw();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abA = bVar;
            this.aby = bVar.ts();
            this.aby.g(this.abx);
            bVar.tt().b(this.abw);
            this.mCustomView = bVar.tu();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.abw);
                addView(this.mCustomView);
                addView(this.abx);
            }
        }
    }

    public void tv() {
        tx();
    }

    public void tw() {
        this.abB.removeMessages(1);
    }

    public void tx() {
        this.abB.removeMessages(1);
        this.abB.sendEmptyMessageDelayed(1, this.abF);
    }

    public void setMarqueenTime(long j) {
        this.abF = j;
        tx();
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
                    CoverFlowView.this.ty();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty() {
        int count;
        if (this.abw != null && this.abz != null && (count = this.abz.getCount()) > 1) {
            int currentItem = this.abw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abw.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.abw.setCurrentItem(1, false);
            } else {
                this.abw.setCurrentItem(currentItem + 1);
            }
            this.abw.invalidate();
        }
    }

    private boolean tz() {
        int count;
        if (this.abz != null && (count = this.abz.getCount()) > 1) {
            int currentItem = this.abw.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abw.setCurrentItem(i, false);
                this.abw.invalidate();
            } else if (currentItem > i) {
                this.abw.setCurrentItem(1, false);
                this.abw.invalidate();
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
            if (CoverFlowView.this.abx != null && CoverFlowView.this.abz != null && CoverFlowView.this.abx.getVisibility() == 0) {
                int count = CoverFlowView.this.abz.getCount();
                if (i == 0) {
                    CoverFlowView.this.abx.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.abx.setPosition(f);
                } else {
                    CoverFlowView.this.abx.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.abz != null) {
                int count = CoverFlowView.this.abz.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abC != null) {
                    CoverFlowView.this.abC.a(i, CoverFlowView.this.abz.cs(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.abw != null && CoverFlowView.this.abz != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tA();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tA() {
        if (tz()) {
            tx();
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
            com.baidu.tbadk.core.flow.a.a cs;
            if (CoverFlowView.this.abC != null && (view.getTag() instanceof Integer) && (cs = CoverFlowView.this.abz.cs((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abC.g(intValue, cs.pG());
            }
        }
    }

    public void onChangeSkinType() {
        this.abz.onChangeSkinType();
        if (this.abx != null && this.aby != null) {
            this.abx.setDrawable(ai.getDrawable(this.aby.tB()));
            this.abx.setSelector(ai.getDrawable(this.aby.tC()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.abw != null) {
            this.abw.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.abw != null) {
            this.abw.setDisableParentEvent(z);
        }
    }
}
