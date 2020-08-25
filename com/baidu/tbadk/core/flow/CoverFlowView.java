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
/* loaded from: classes2.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean egA;
    private boolean egB;
    private d<T> egC;
    private long egF;
    private CoverFlowAdapter<T> egH;
    private CoverFlowView<T>.a egI;
    private CoverFlowView<T>.c egJ;
    private CoverFlowView<T>.b egK;
    private ListViewPager egt;
    private IndicatorView egu;
    private com.baidu.tbadk.core.flow.a.c egv;
    private com.baidu.tbadk.core.flow.a egx;
    private boolean egz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.egI = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egJ = new c();
        this.egK = new b();
        this.egF = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.egI = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egJ = new c();
        this.egK = new b();
        this.egF = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.egI = new a();
        this.egz = false;
        this.egA = true;
        this.egB = true;
        this.egJ = new c();
        this.egK = new b();
        this.egF = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.egC = dVar;
    }

    private void init(Context context) {
        dR(context);
        dS(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.egt);
        addView(this.egu);
        this.egH = new CoverFlowAdapter<>(context);
        this.egH.setOnClickListener(this.egJ);
        this.egt.setAdapter(this.egH);
        this.egt.setOnPageChangeListener(this.egK);
    }

    private void dR(Context context) {
        this.egt = new ListViewPager(context);
    }

    private void dS(Context context) {
        this.egu = new IndicatorView(context);
        this.egu.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T nG(int i) {
        if (this.egH == null) {
            return null;
        }
        return this.egH.nG(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.egH.a(list, this.egx);
            int size = list.size();
            if (size > 1) {
                this.egu.setVisibility(0);
                this.egu.setCount(size);
                this.egt.setCurrentItem(1, false);
                this.egu.setPosition(0.0f);
                if (this.egB) {
                    bhD();
                    return;
                }
                return;
            }
            this.egu.setVisibility(8);
            this.egu.setCount(size);
            this.egt.setCurrentItem(1, false);
            this.egu.setPosition(0.0f);
            bhE();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.egx = aVar;
            this.egv = aVar.ua();
            this.egv.g(this.egu);
            aVar.tZ().b(this.egt);
            this.mCustomView = aVar.bhC();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.egt);
                addView(this.mCustomView);
                addView(this.egu);
            }
        }
    }

    public void bhD() {
        bhF();
    }

    public void bhE() {
        this.egI.removeMessages(1);
    }

    public void bhF() {
        this.egI.removeMessages(1);
        this.egI.sendEmptyMessageDelayed(1, this.egF);
    }

    public void tY() {
        if (!this.egI.hasMessages(1)) {
            bhD();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.egu != null) {
            this.egu.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.egF = j;
        bhF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.bhG();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhG() {
        int count;
        if (this.egt != null && this.egH != null && (count = this.egH.getCount()) > 1) {
            int currentItem = this.egt.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.egt.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.egt.setCurrentItem(1, false);
            } else {
                this.egt.setCurrentItem(currentItem + 1);
            }
            this.egt.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhH() {
        int count;
        if (this.egH != null && (count = this.egH.getCount()) > 1) {
            int currentItem = this.egt.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.egt.setCurrentItem(i, false);
                this.egt.invalidate();
            } else if (currentItem > i) {
                this.egt.setCurrentItem(1, false);
                this.egt.invalidate();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.egu != null && CoverFlowView.this.egH != null) {
                if (CoverFlowView.this.egH.getCount() == 1 && i == 0 && CoverFlowView.this.egC != null) {
                    CoverFlowView.this.egC.a(1, CoverFlowView.this.egH.nG(i));
                }
                if (CoverFlowView.this.egu.getVisibility() == 0 && !CoverFlowView.this.egz) {
                    int count = CoverFlowView.this.egH.getCount();
                    if (i == 0) {
                        CoverFlowView.this.egu.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.egu.setPosition(f);
                    } else {
                        CoverFlowView.this.egu.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.egH != null) {
                int count = CoverFlowView.this.egH.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.egz) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.egC != null) {
                        CoverFlowView.this.egC.a(i, CoverFlowView.this.egH.nG(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.egt != null && CoverFlowView.this.egH != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.egB) {
                            CoverFlowView.this.bhI();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.egA) {
                            CoverFlowView.this.bhE();
                            CoverFlowView.this.bhH();
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
        int count = this.egH.getCount();
        if (i == 0) {
            this.egu.setPosition(0.0f);
        } else if (i == count - 1) {
            this.egu.setPosition(i);
        } else {
            this.egu.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        if (bhH()) {
            bhF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a nG;
            if (CoverFlowView.this.egC != null && (view.getTag() instanceof Integer) && (nG = CoverFlowView.this.egH.nG((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.egC.e(intValue, nG.bcC());
            }
        }
    }

    public void onChangeSkinType() {
        this.egH.onChangeSkinType();
        if (this.egu != null && this.egv != null) {
            this.egu.setDrawable(ap.getDrawable(this.egv.bhJ()));
            this.egu.setSelector(ap.getDrawable(this.egv.bhK()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.egt != null) {
            this.egt.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.egt != null) {
            this.egt.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.egz = z;
    }

    public void setPageMargin(int i) {
        if (this.egt != null) {
            this.egt.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.egt != null) {
            eVar.b(this.egt);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.egA = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.egA;
    }

    public void setAutoPlay(boolean z) {
        this.egB = z;
    }
}
