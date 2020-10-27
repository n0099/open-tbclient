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
    private boolean eDA;
    private boolean eDB;
    private d<T> eDC;
    private long eDF;
    private CoverFlowAdapter<T> eDH;
    private CoverFlowView<T>.a eDI;
    private CoverFlowView<T>.c eDJ;
    private CoverFlowView<T>.b eDK;
    private ListViewPager eDt;
    private IndicatorView eDu;
    private com.baidu.tbadk.core.flow.a.c eDv;
    private com.baidu.tbadk.core.flow.a eDx;
    private boolean eDz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eDI = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDJ = new c();
        this.eDK = new b();
        this.eDF = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eDI = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDJ = new c();
        this.eDK = new b();
        this.eDF = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eDI = new a();
        this.eDz = false;
        this.eDA = true;
        this.eDB = true;
        this.eDJ = new c();
        this.eDK = new b();
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
        this.eDH = new CoverFlowAdapter<>(context);
        this.eDH.setOnClickListener(this.eDJ);
        this.eDt.setAdapter(this.eDH);
        this.eDt.setOnPageChangeListener(this.eDK);
    }

    private void dW(Context context) {
        this.eDt = new ListViewPager(context);
    }

    private void dX(Context context) {
        this.eDu = new IndicatorView(context);
        this.eDu.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T oA(int i) {
        if (this.eDH == null) {
            return null;
        }
        return this.eDH.oA(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eDH.a(list, this.eDx);
            int size = list.size();
            if (size > 1) {
                this.eDu.setVisibility(0);
                this.eDu.setCount(size);
                this.eDt.setCurrentItem(1, false);
                this.eDu.setPosition(0.0f);
                if (this.eDB) {
                    bmZ();
                    return;
                }
                return;
            }
            this.eDu.setVisibility(8);
            this.eDu.setCount(size);
            this.eDt.setCurrentItem(1, false);
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
        this.eDI.removeMessages(1);
    }

    public void bnb() {
        this.eDI.removeMessages(1);
        this.eDI.sendEmptyMessageDelayed(1, this.eDF);
    }

    public void ue() {
        if (!this.eDI.hasMessages(1)) {
            bmZ();
        }
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
                    CoverFlowView.this.bnc();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnc() {
        int count;
        if (this.eDt != null && this.eDH != null && (count = this.eDH.getCount()) > 1) {
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
        if (this.eDH != null && (count = this.eDH.getCount()) > 1) {
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
            if (CoverFlowView.this.eDu != null && CoverFlowView.this.eDH != null) {
                if (CoverFlowView.this.eDH.getCount() == 1 && i == 0 && CoverFlowView.this.eDC != null) {
                    CoverFlowView.this.eDC.a(1, CoverFlowView.this.eDH.oA(i));
                }
                if (CoverFlowView.this.eDu.getVisibility() == 0 && !CoverFlowView.this.eDz) {
                    int count = CoverFlowView.this.eDH.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eDu.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eDu.setPosition(f);
                    } else {
                        CoverFlowView.this.eDu.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eDH != null) {
                int count = CoverFlowView.this.eDH.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eDz) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eDC != null) {
                        CoverFlowView.this.eDC.a(i, CoverFlowView.this.eDH.oA(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eDt != null && CoverFlowView.this.eDH != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eDB) {
                            CoverFlowView.this.bne();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eDA) {
                            CoverFlowView.this.bna();
                            CoverFlowView.this.bnd();
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
        int count = this.eDH.getCount();
        if (i == 0) {
            this.eDu.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eDu.setPosition(i);
        } else {
            this.eDu.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bne() {
        if (bnd()) {
            bnb();
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
            if (CoverFlowView.this.eDC != null && (view.getTag() instanceof Integer) && (oA = CoverFlowView.this.eDH.oA((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eDC.e(intValue, oA.bhY());
            }
        }
    }

    public void onChangeSkinType() {
        this.eDH.onChangeSkinType();
        if (this.eDu != null && this.eDv != null) {
            this.eDu.setDrawable(ap.getDrawable(this.eDv.bnf()));
            this.eDu.setSelector(ap.getDrawable(this.eDv.bng()));
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

    public void a(e eVar) {
        if (eVar != null && this.eDt != null) {
            eVar.b(this.eDt);
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
