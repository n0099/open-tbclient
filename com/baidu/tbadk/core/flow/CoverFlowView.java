package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private boolean eZA;
    private d<T> eZB;
    private long eZE;
    private CoverFlowAdapter<T> eZG;
    private CoverFlowView<T>.a eZH;
    private CoverFlowView<T>.c eZI;
    private CoverFlowView<T>.b eZJ;
    private ListViewPager eZs;
    private IndicatorView eZt;
    private com.baidu.tbadk.core.flow.a.c eZu;
    private com.baidu.tbadk.core.flow.a eZw;
    private boolean eZy;
    private boolean eZz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.eZH = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZI = new c();
        this.eZJ = new b();
        this.eZE = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.eZH = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZI = new c();
        this.eZJ = new b();
        this.eZE = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.eZH = new a();
        this.eZy = false;
        this.eZz = true;
        this.eZA = true;
        this.eZI = new c();
        this.eZJ = new b();
        this.eZE = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.eZB = dVar;
    }

    private void init(Context context) {
        eU(context);
        eV(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.eZs);
        addView(this.eZt);
        this.eZG = new CoverFlowAdapter<>(context);
        this.eZG.setOnClickListener(this.eZI);
        this.eZs.setAdapter(this.eZG);
        this.eZs.setOnPageChangeListener(this.eZJ);
    }

    private void eU(Context context) {
        this.eZs = new ListViewPager(context);
    }

    private void eV(Context context) {
        this.eZt = new IndicatorView(context);
        this.eZt.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T pQ(int i) {
        if (this.eZG == null) {
            return null;
        }
        return this.eZG.pQ(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.eZG.a(list, this.eZw);
            int size = list.size();
            if (size > 1) {
                this.eZt.setVisibility(0);
                this.eZt.setCount(size);
                this.eZs.setCurrentItem(1, false);
                this.eZt.setPosition(0.0f);
                if (this.eZA) {
                    buJ();
                    return;
                }
                return;
            }
            this.eZt.setVisibility(8);
            this.eZt.setCount(size);
            this.eZs.setCurrentItem(1, false);
            this.eZt.setPosition(0.0f);
            buK();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.eZw = aVar;
            this.eZu = aVar.tI();
            this.eZu.g(this.eZt);
            aVar.tH().b(this.eZs);
            this.mCustomView = aVar.buI();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.eZs);
                addView(this.mCustomView);
                addView(this.eZt);
            }
        }
    }

    public void buJ() {
        buL();
    }

    public void buK() {
        this.eZH.removeMessages(1);
    }

    public void buL() {
        this.eZH.removeMessages(1);
        this.eZH.sendEmptyMessageDelayed(1, this.eZE);
    }

    public void tG() {
        if (!this.eZH.hasMessages(1)) {
            buJ();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.eZt != null) {
            this.eZt.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.eZE = j;
        buL();
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
                    CoverFlowView.this.buM();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        int count;
        if (this.eZs != null && this.eZG != null && (count = this.eZG.getCount()) > 1) {
            int currentItem = this.eZs.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eZs.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.eZs.setCurrentItem(1, false);
            } else {
                this.eZs.setCurrentItem(currentItem + 1);
            }
            this.eZs.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buN() {
        int count;
        if (this.eZG != null && (count = this.eZG.getCount()) > 1) {
            int currentItem = this.eZs.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.eZs.setCurrentItem(i, false);
                this.eZs.invalidate();
            } else if (currentItem > i) {
                this.eZs.setCurrentItem(1, false);
                this.eZs.invalidate();
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
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.eZt != null && CoverFlowView.this.eZG != null) {
                if (CoverFlowView.this.eZG.getCount() == 1 && i == 0 && CoverFlowView.this.eZB != null) {
                    CoverFlowView.this.eZB.a(1, CoverFlowView.this.eZG.pQ(i));
                }
                if (CoverFlowView.this.eZt.getVisibility() == 0 && !CoverFlowView.this.eZy) {
                    int count = CoverFlowView.this.eZG.getCount();
                    if (i == 0) {
                        CoverFlowView.this.eZt.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.eZt.setPosition(f);
                    } else {
                        CoverFlowView.this.eZt.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.eZG != null) {
                int count = CoverFlowView.this.eZG.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.eZy) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.eZB != null) {
                        CoverFlowView.this.eZB.a(i, CoverFlowView.this.eZG.pQ(i));
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.eZs != null && CoverFlowView.this.eZG != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.eZA) {
                            CoverFlowView.this.buO();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.eZz) {
                            CoverFlowView.this.buK();
                            CoverFlowView.this.buN();
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
        int count = this.eZG.getCount();
        if (i == 0) {
            this.eZt.setPosition(0.0f);
        } else if (i == count - 1) {
            this.eZt.setPosition(i);
        } else {
            this.eZt.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (buN()) {
            buL();
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
            com.baidu.tbadk.core.flow.a.a pQ;
            if (CoverFlowView.this.eZB != null && (view.getTag() instanceof Integer) && (pQ = CoverFlowView.this.eZG.pQ((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.eZB.e(intValue, pQ.bpn());
            }
        }
    }

    public void onChangeSkinType() {
        this.eZG.onChangeSkinType();
        if (this.eZt != null && this.eZu != null) {
            this.eZt.setDrawable(ao.getDrawable(this.eZu.buP()));
            this.eZt.setSelector(ao.getDrawable(this.eZu.buQ()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.eZs != null) {
            this.eZs.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.eZs != null) {
            this.eZs.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.eZy = z;
    }

    public void setPageMargin(int i) {
        if (this.eZs != null) {
            this.eZs.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.eZs != null) {
            eVar.b(this.eZs);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.eZz = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.eZz;
    }

    public void setAutoPlay(boolean z) {
        this.eZA = z;
    }
}
