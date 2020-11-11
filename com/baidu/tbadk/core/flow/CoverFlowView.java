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
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager eJi;
    private IndicatorView eJj;
    private com.baidu.tbadk.core.flow.a.c eJk;
    private com.baidu.tbadk.core.flow.a eJm;
    private boolean eJo;
    private boolean eJp;
    private boolean eJq;
    private d<T> eJr;
    private long eJu;
    private CoverFlowAdapter<T> eJw;
    private CoverFlowView<T>.a eJx;
    private CoverFlowView<T>.c eJy;
    private CoverFlowView<T>.b eJz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eJx = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJy = new c();
        this.eJz = new b();
        this.eJu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eJx = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJy = new c();
        this.eJz = new b();
        this.eJu = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eJx = new a();
        this.eJo = false;
        this.eJp = true;
        this.eJq = true;
        this.eJy = new c();
        this.eJz = new b();
        this.eJu = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eJr = dVar;
    }

    private void init(Context context) {
        dW(context);
        dX(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eJi);
        addView(this.eJj);
        this.eJw = new CoverFlowAdapter<>(context);
        this.eJw.setOnClickListener(this.eJy);
        this.eJi.setAdapter(this.eJw);
        this.eJi.setOnPageChangeListener(this.eJz);
    }

    private void dW(Context context) {
        this.eJi = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eJj = new IndicatorView(context);
        this.eJj.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T oK(int i) {
        if (this.eJw == null) {
            return null;
        }
        return this.eJw.oK(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eJw.a(list, this.eJm);
            int size = list.size();
            if (size > 1) {
                this.eJj.setVisibility(0);
                this.eJj.setCount(size);
                this.eJi.setCurrentItem(1, false);
                this.eJj.setPosition(0.0f);
                if (this.eJq) {
                    bpz();
                    return;
                }
                return;
            }
            this.eJj.setVisibility(8);
            this.eJj.setCount(size);
            this.eJi.setCurrentItem(1, false);
            this.eJj.setPosition(0.0f);
            bpA();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eJm = aVar;
            this.eJk = aVar.ug();
            this.eJk.g(this.eJj);
            aVar.uf().b(this.eJi);
            this.mCustomView = aVar.bpy();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eJi);
                addView(this.mCustomView);
                addView(this.eJj);
            }
        }
    }

    public void bpz() {
        bpB();
    }

    public void bpA() {
        this.eJx.removeMessages(1);
    }

    public void bpB() {
        this.eJx.removeMessages(1);
        this.eJx.sendEmptyMessageDelayed(1, this.eJu);
    }

    public void ue() {
        if (!this.eJx.hasMessages(1)) {
            bpz();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.eJj != null) {
            this.eJj.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eJu = j;
        bpB();
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
                    CoverFlowView.this.bpC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpC() {
        int count;
        if (this.eJi != null && this.eJw != null && (count = this.eJw.getCount()) > 1) {
            int currentItem = this.eJi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eJi.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eJi.setCurrentItem(1, false);
            } else {
                this.eJi.setCurrentItem(currentItem + 1);
            }
            this.eJi.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpD() {
        int count;
        if (this.eJw != null && (count = this.eJw.getCount()) > 1) {
            int currentItem = this.eJi.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eJi.setCurrentItem(i, false);
                this.eJi.invalidate();
            } else if (currentItem > i) {
                this.eJi.setCurrentItem(1, false);
                this.eJi.invalidate();
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
            if (CoverFlowView.this.eJj != null && CoverFlowView.this.eJw != null) {
                if (CoverFlowView.this.eJw.getCount() == 1 && i == 0 && CoverFlowView.this.eJr != null) {
                    CoverFlowView.this.eJr.a(1, CoverFlowView.this.eJw.oK(i));
                }
                if (CoverFlowView.this.eJj.getVisibility() == 0 && !CoverFlowView.this.eJo) {
                    int count = CoverFlowView.this.eJw.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eJj.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eJj.setPosition(f);
                    } else {
                        CoverFlowView.this.eJj.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eJw != null) {
                int count = CoverFlowView.this.eJw.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eJo) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eJr != null) {
                        CoverFlowView.this.eJr.a(i, CoverFlowView.this.eJw.oK(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eJi != null && CoverFlowView.this.eJw != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eJq) {
                            CoverFlowView.this.bpE();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eJp) {
                            CoverFlowView.this.bpA();
                            CoverFlowView.this.bpD();
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
        int count = this.eJw.getCount();
        if (i == 0) {
            this.eJj.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eJj.setPosition(i);
        } else {
            this.eJj.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        if (bpD()) {
            bpB();
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
            com.baidu.tbadk.core.flow.a.a oK;
            if (CoverFlowView.this.eJr != null && (view.getTag() instanceof Integer) && (oK = CoverFlowView.this.eJw.oK((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eJr.e(intValue, oK.bky());
            }
        }
    }

    public void onChangeSkinType() {
        this.eJw.onChangeSkinType();
        if (this.eJj != null && this.eJk != null) {
            this.eJj.setDrawable(ap.getDrawable(this.eJk.bpF()));
            this.eJj.setSelector(ap.getDrawable(this.eJk.bpG()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eJi != null) {
            this.eJi.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eJi != null) {
            this.eJi.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eJo = z;
    }

    public void setPageMargin(int i) {
        if (this.eJi != null) {
            this.eJi.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.eJi != null) {
            eVar.b(this.eJi);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eJp = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eJp;
    }

    public void setAutoPlay(boolean z) {
        this.eJq = z;
    }
}
