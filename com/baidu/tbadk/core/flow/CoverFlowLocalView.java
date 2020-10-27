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
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean eDA;
    private boolean eDB;
    private d<T> eDC;
    private CoverFlowLocalView<T>.c eDD;
    private CoverFlowLocalView<T>.b eDE;
    private long eDF;
    private boolean eDs;
    private ListViewPager eDt;
    private IndicatorView eDu;
    private com.baidu.tbadk.core.flow.a.c eDv;
    private CoverFlowLocalAdapter<T> eDw;
    private com.baidu.tbadk.core.flow.a eDx;
    private CoverFlowLocalView<T>.a eDy;
    private boolean eDz;
    private View mCustomView;

    public CoverFlowLocalView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eDy = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDD = new c();
        this.eDE = new b();
        this.eDF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eDy = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDD = new c();
        this.eDE = new b();
        this.eDF = 5000L;
        init(context);
    }

    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eDy = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDD = new c();
        this.eDE = new b();
        this.eDF = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eDC = dVar;
    }

    private void init(Context context) {
        dW(context);
        dX(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eDt);
        addView(this.eDu);
        this.eDw = new CoverFlowLocalAdapter<>(context);
        this.eDw.setOnClickListener(this.eDD);
        this.eDt.setAdapter(this.eDw);
        this.eDt.setOnPageChangeListener(this.eDE);
    }

    private void dW(Context context) {
        this.eDt = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eDu = new IndicatorView(context);
        this.eDu.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eDw.a(list, this.eDx);
            int size = list.size();
            if (size > 1) {
                this.eDu.setVisibility(0);
                this.eDu.setCount(size);
                this.eDt.setCurrentItem(0, false);
                this.eDu.setPosition(0.0f);
                if (this.eDB) {
                    bmZ();
                    return;
                }
                return;
            }
            this.eDu.setVisibility(8);
            this.eDu.setCount(size);
            this.eDt.setCurrentItem(0, false);
            this.eDu.setPosition(0.0f);
            bna();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eDx = aVar;
            this.eDv = aVar.ug();
            this.eDv.g(this.eDu);
            aVar.uf().b(this.eDt);
            this.mCustomView = aVar.bmY();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eDt);
                addView(this.mCustomView);
                addView(this.eDu);
            }
        }
    }

    public void bmZ() {
        bnb();
    }

    public void bna() {
        this.eDy.removeMessages(1);
    }

    public void bnb() {
        this.eDy.removeMessages(1);
        this.eDy.sendEmptyMessageDelayed(1, this.eDF);
    }

    public void setIndicatorVisible(int i) {
        if (this.eDu != null) {
            this.eDu.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eDF = j;
        bnb();
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
                    CoverFlowLocalView.this.bnc();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnc() {
        int count;
        if (this.eDt != null && this.eDw != null && (count = this.eDw.getCount()) > 1) {
            int currentItem = this.eDt.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eDt.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eDt.setCurrentItem(1, false);
            } else {
                this.eDt.setCurrentItem(currentItem + 1);
            }
            this.eDt.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnd() {
        int count;
        if (this.eDw == null || !this.eDs || (count = this.eDw.getCount()) <= 1) {
            return false;
        }
        int currentItem = this.eDt.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.eDt.setCurrentItem(i, false);
            this.eDt.invalidate();
        } else if (currentItem > i) {
            this.eDt.setCurrentItem(1, false);
            this.eDt.invalidate();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowLocalView.this.eDu != null && CoverFlowLocalView.this.eDw != null) {
                if (CoverFlowLocalView.this.eDw.getCount() == 1 && i == 0 && CoverFlowLocalView.this.eDC != null) {
                    CoverFlowLocalView.this.eDC.a(1, CoverFlowLocalView.this.eDw.oA(i));
                }
                if (CoverFlowLocalView.this.eDu.getVisibility() == 0 && !CoverFlowLocalView.this.eDz) {
                    if (CoverFlowLocalView.this.eDs) {
                        int count = CoverFlowLocalView.this.eDw.getCount();
                        if (i == 0) {
                            CoverFlowLocalView.this.eDu.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            CoverFlowLocalView.this.eDu.setPosition(f);
                            return;
                        } else {
                            CoverFlowLocalView.this.eDu.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    CoverFlowLocalView.this.eDu.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowLocalView.this.eDw != null) {
                int count = CoverFlowLocalView.this.eDw.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowLocalView.this.eDz) {
                        CoverFlowLocalView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowLocalView.this.eDC != null) {
                        CoverFlowLocalView.this.eDC.a(i, CoverFlowLocalView.this.eDw.oA(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowLocalView.this.eDt != null && CoverFlowLocalView.this.eDw != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowLocalView.this.eDB) {
                            CoverFlowLocalView.this.bne();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowLocalView.this.eDA) {
                            CoverFlowLocalView.this.bna();
                            CoverFlowLocalView.this.bnd();
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
        if (this.eDs) {
            int count = this.eDw.getCount();
            if (i == 0) {
                this.eDu.setPosition(0.0f);
                return;
            } else if (i == count - 1) {
                this.eDu.setPosition(i);
                return;
            } else {
                this.eDu.setPosition(i - 1);
                return;
            }
        }
        this.eDu.setPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (bnd()) {
            bnb();
        }
    }

    public void setCanRepeat(boolean z) {
        this.eDs = z;
        if (this.eDw != null) {
            this.eDw.setCanRepeat(z);
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
            com.baidu.tbadk.core.flow.a.a oA;
            if (CoverFlowLocalView.this.eDC != null && (view.getTag() instanceof Integer) && (oA = CoverFlowLocalView.this.eDw.oA((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowLocalView.this.eDC.e(intValue, oA.bhY());
            }
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eDt != null) {
            this.eDt.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eDt != null) {
            this.eDt.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eDz = z;
    }

    public void setPageMargin(int i) {
        if (this.eDt != null) {
            this.eDt.setPageMargin(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eDA = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eDA;
    }

    public void setAutoPlay(boolean z) {
        this.eDB = z;
    }
}
