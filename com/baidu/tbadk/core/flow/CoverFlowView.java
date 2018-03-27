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
    private ListViewPager aSq;
    private IndicatorView aSr;
    private com.baidu.tbadk.core.flow.a.c aSs;
    private com.baidu.tbadk.core.flow.a<T> aSt;
    private com.baidu.tbadk.core.flow.b aSu;
    private CoverFlowView<T>.a aSv;
    private d<T> aSw;
    private CoverFlowView<T>.c aSx;
    private CoverFlowView<T>.b aSy;
    private long aSz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aSv = new a();
        this.aSx = new c();
        this.aSy = new b();
        this.aSz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aSv = new a();
        this.aSx = new c();
        this.aSy = new b();
        this.aSz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aSv = new a();
        this.aSx = new c();
        this.aSy = new b();
        this.aSz = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aSw = dVar;
    }

    private void init(Context context) {
        aJ(context);
        aK(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aSq);
        addView(this.aSr);
        this.aSt = new com.baidu.tbadk.core.flow.a<>(context);
        this.aSt.setOnClickListener(this.aSx);
        this.aSq.setAdapter(this.aSt);
        this.aSq.setOnPageChangeListener(this.aSy);
    }

    private void aJ(Context context) {
        this.aSq = new ListViewPager(context);
    }

    private void aK(Context context) {
        this.aSr = new IndicatorView(context);
        this.aSr.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T fr(int i) {
        if (this.aSt == null) {
            return null;
        }
        return this.aSt.fr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aSt.a(list, this.aSu);
            int size = list.size();
            if (size > 1) {
                this.aSr.setVisibility(0);
                this.aSr.setCount(size);
                this.aSq.setCurrentItem(1, false);
                this.aSr.setPosition(0.0f);
                Bj();
                return;
            }
            this.aSr.setVisibility(8);
            Bk();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aSu = bVar;
            this.aSs = bVar.Bg();
            this.aSs.g(this.aSr);
            bVar.Bh().a(this.aSq);
            this.mCustomView = bVar.Bi();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aSq);
                addView(this.mCustomView);
                addView(this.aSr);
            }
        }
    }

    public void Bj() {
        Bl();
    }

    public void Bk() {
        this.aSv.removeMessages(1);
    }

    public void Bl() {
        this.aSv.removeMessages(1);
        this.aSv.sendEmptyMessageDelayed(1, this.aSz);
    }

    public void setMarqueenTime(long j) {
        this.aSz = j;
        Bl();
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
                    CoverFlowView.this.Bm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        int count;
        if (this.aSq != null && this.aSt != null && (count = this.aSt.getCount()) > 1) {
            int currentItem = this.aSq.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSq.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aSq.setCurrentItem(1, false);
            } else {
                this.aSq.setCurrentItem(currentItem + 1);
            }
            this.aSq.invalidate();
        }
    }

    private boolean Bn() {
        int count;
        if (this.aSt != null && (count = this.aSt.getCount()) > 1) {
            int currentItem = this.aSq.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSq.setCurrentItem(i, false);
                this.aSq.invalidate();
            } else if (currentItem > i) {
                this.aSq.setCurrentItem(1, false);
                this.aSq.invalidate();
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
            if (CoverFlowView.this.aSr != null && CoverFlowView.this.aSt != null && CoverFlowView.this.aSr.getVisibility() == 0) {
                int count = CoverFlowView.this.aSt.getCount();
                if (i == 0) {
                    CoverFlowView.this.aSr.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aSr.setPosition(f);
                } else {
                    CoverFlowView.this.aSr.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aSt != null) {
                int count = CoverFlowView.this.aSt.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aSw != null) {
                    CoverFlowView.this.aSw.a(i, CoverFlowView.this.aSt.fr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aSq != null && CoverFlowView.this.aSt != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.Bo();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bo() {
        if (Bn()) {
            Bl();
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
            if (CoverFlowView.this.aSw != null && (view.getTag() instanceof Integer) && (fr = CoverFlowView.this.aSt.fr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aSw.f(intValue, fr.xV());
            }
        }
    }

    public void onChangeSkinType() {
        this.aSt.onChangeSkinType();
        if (this.aSr != null && this.aSs != null) {
            this.aSr.setDrawable(aj.getDrawable(this.aSs.Bp()));
            this.aSr.setSelector(aj.getDrawable(this.aSs.Bq()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aSq != null) {
            this.aSq.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aSq != null) {
            this.aSq.setDisableParentEvent(z);
        }
    }
}
