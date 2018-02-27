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
    private ListViewPager aSo;
    private IndicatorView aSp;
    private com.baidu.tbadk.core.flow.a.c aSq;
    private com.baidu.tbadk.core.flow.a<T> aSr;
    private com.baidu.tbadk.core.flow.b aSs;
    private CoverFlowView<T>.a aSt;
    private d<T> aSu;
    private CoverFlowView<T>.c aSv;
    private CoverFlowView<T>.b aSw;
    private long aSx;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aSt = new a();
        this.aSv = new c();
        this.aSw = new b();
        this.aSx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aSt = new a();
        this.aSv = new c();
        this.aSw = new b();
        this.aSx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aSt = new a();
        this.aSv = new c();
        this.aSw = new b();
        this.aSx = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aSu = dVar;
    }

    private void init(Context context) {
        aJ(context);
        aK(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aSo);
        addView(this.aSp);
        this.aSr = new com.baidu.tbadk.core.flow.a<>(context);
        this.aSr.setOnClickListener(this.aSv);
        this.aSo.setAdapter(this.aSr);
        this.aSo.setOnPageChangeListener(this.aSw);
    }

    private void aJ(Context context) {
        this.aSo = new ListViewPager(context);
    }

    private void aK(Context context) {
        this.aSp = new IndicatorView(context);
        this.aSp.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T fr(int i) {
        if (this.aSr == null) {
            return null;
        }
        return this.aSr.fr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aSr.a(list, this.aSs);
            int size = list.size();
            if (size > 1) {
                this.aSp.setVisibility(0);
                this.aSp.setCount(size);
                this.aSo.setCurrentItem(1, false);
                this.aSp.setPosition(0.0f);
                Bi();
                return;
            }
            this.aSp.setVisibility(8);
            Bj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aSs = bVar;
            this.aSq = bVar.Bf();
            this.aSq.g(this.aSp);
            bVar.Bg().a(this.aSo);
            this.mCustomView = bVar.Bh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aSo);
                addView(this.mCustomView);
                addView(this.aSp);
            }
        }
    }

    public void Bi() {
        Bk();
    }

    public void Bj() {
        this.aSt.removeMessages(1);
    }

    public void Bk() {
        this.aSt.removeMessages(1);
        this.aSt.sendEmptyMessageDelayed(1, this.aSx);
    }

    public void setMarqueenTime(long j) {
        this.aSx = j;
        Bk();
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
                    CoverFlowView.this.Bl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        int count;
        if (this.aSo != null && this.aSr != null && (count = this.aSr.getCount()) > 1) {
            int currentItem = this.aSo.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSo.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aSo.setCurrentItem(1, false);
            } else {
                this.aSo.setCurrentItem(currentItem + 1);
            }
            this.aSo.invalidate();
        }
    }

    private boolean Bm() {
        int count;
        if (this.aSr != null && (count = this.aSr.getCount()) > 1) {
            int currentItem = this.aSo.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSo.setCurrentItem(i, false);
                this.aSo.invalidate();
            } else if (currentItem > i) {
                this.aSo.setCurrentItem(1, false);
                this.aSo.invalidate();
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
            if (CoverFlowView.this.aSp != null && CoverFlowView.this.aSr != null && CoverFlowView.this.aSp.getVisibility() == 0) {
                int count = CoverFlowView.this.aSr.getCount();
                if (i == 0) {
                    CoverFlowView.this.aSp.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aSp.setPosition(f);
                } else {
                    CoverFlowView.this.aSp.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aSr != null) {
                int count = CoverFlowView.this.aSr.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aSu != null) {
                    CoverFlowView.this.aSu.a(i, CoverFlowView.this.aSr.fr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aSo != null && CoverFlowView.this.aSr != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.Bn();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        if (Bm()) {
            Bk();
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
            com.baidu.tbadk.core.flow.a.a fr;
            if (CoverFlowView.this.aSu != null && (view.getTag() instanceof Integer) && (fr = CoverFlowView.this.aSr.fr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aSu.f(intValue, fr.xV());
            }
        }
    }

    public void onChangeSkinType() {
        this.aSr.onChangeSkinType();
        if (this.aSp != null && this.aSq != null) {
            this.aSp.setDrawable(aj.getDrawable(this.aSq.Bo()));
            this.aSp.setSelector(aj.getDrawable(this.aSq.Bp()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aSo != null) {
            this.aSo.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aSo != null) {
            this.aSo.setDisableParentEvent(z);
        }
    }
}
