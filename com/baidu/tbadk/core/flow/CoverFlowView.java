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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager dvC;
    private IndicatorView dvD;
    private com.baidu.tbadk.core.flow.a.c dvE;
    private CoverFlowAdapter<T> dvF;
    private com.baidu.tbadk.core.flow.a dvG;
    private CoverFlowView<T>.a dvH;
    private boolean dvI;
    private boolean dvJ;
    private boolean dvK;
    private d<T> dvL;
    private CoverFlowView<T>.c dvM;
    private CoverFlowView<T>.b dvN;
    private long dvO;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.dvH = new a();
        this.dvI = false;
        this.dvJ = true;
        this.dvK = true;
        this.dvM = new c();
        this.dvN = new b();
        this.dvO = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.dvH = new a();
        this.dvI = false;
        this.dvJ = true;
        this.dvK = true;
        this.dvM = new c();
        this.dvN = new b();
        this.dvO = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.dvH = new a();
        this.dvI = false;
        this.dvJ = true;
        this.dvK = true;
        this.dvM = new c();
        this.dvN = new b();
        this.dvO = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.dvL = dVar;
    }

    private void init(Context context) {
        dx(context);
        dy(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.dvC);
        addView(this.dvD);
        this.dvF = new CoverFlowAdapter<>(context);
        this.dvF.setOnClickListener(this.dvM);
        this.dvC.setAdapter(this.dvF);
        this.dvC.setOnPageChangeListener(this.dvN);
    }

    private void dx(Context context) {
        this.dvC = new ListViewPager(context);
    }

    private void dy(Context context) {
        this.dvD = new IndicatorView(context);
        this.dvD.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kq(int i) {
        if (this.dvF == null) {
            return null;
        }
        return this.dvF.kq(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.dvF.a(list, this.dvG);
            int size = list.size();
            if (size > 1) {
                this.dvD.setVisibility(0);
                this.dvD.setCount(size);
                this.dvC.setCurrentItem(1, false);
                this.dvD.setPosition(0.0f);
                aNo();
                return;
            }
            this.dvD.setVisibility(8);
            this.dvD.setCount(size);
            this.dvC.setCurrentItem(1, false);
            this.dvD.setPosition(0.0f);
            aNp();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.dvG = aVar;
            this.dvE = aVar.aNl();
            this.dvE.g(this.dvD);
            aVar.aNm().b(this.dvC);
            this.mCustomView = aVar.aNn();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.dvC);
                addView(this.mCustomView);
                addView(this.dvD);
            }
        }
    }

    public void aNo() {
        aNq();
    }

    public void aNp() {
        this.dvH.removeMessages(1);
    }

    public void aNq() {
        this.dvH.removeMessages(1);
        this.dvH.sendEmptyMessageDelayed(1, this.dvO);
    }

    public void setIndicatorVisible(int i) {
        if (this.dvD != null) {
            this.dvD.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.dvO = j;
        aNq();
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
                    CoverFlowView.this.aNr();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNr() {
        int count;
        if (this.dvC != null && this.dvF != null && (count = this.dvF.getCount()) > 1) {
            int currentItem = this.dvC.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dvC.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.dvC.setCurrentItem(1, false);
            } else {
                this.dvC.setCurrentItem(currentItem + 1);
            }
            this.dvC.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNs() {
        int count;
        if (this.dvF != null && (count = this.dvF.getCount()) > 1) {
            int currentItem = this.dvC.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dvC.setCurrentItem(i, false);
                this.dvC.invalidate();
            } else if (currentItem > i) {
                this.dvC.setCurrentItem(1, false);
                this.dvC.invalidate();
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
            if (CoverFlowView.this.dvD != null && CoverFlowView.this.dvF != null) {
                if (CoverFlowView.this.dvF.getCount() == 1 && i == 0 && CoverFlowView.this.dvL != null) {
                    CoverFlowView.this.dvL.a(1, CoverFlowView.this.dvF.kq(i));
                }
                if (CoverFlowView.this.dvD.getVisibility() == 0 && !CoverFlowView.this.dvI) {
                    int count = CoverFlowView.this.dvF.getCount();
                    if (i == 0) {
                        CoverFlowView.this.dvD.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.dvD.setPosition(f);
                    } else {
                        CoverFlowView.this.dvD.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.dvF != null) {
                int count = CoverFlowView.this.dvF.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.dvI) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.dvL != null) {
                        CoverFlowView.this.dvL.a(i, CoverFlowView.this.dvF.kq(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.dvC != null && CoverFlowView.this.dvF != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.dvK) {
                            CoverFlowView.this.aNt();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.dvK = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.dvK) {
                            CoverFlowView.this.aNp();
                            CoverFlowView.this.aNs();
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
        int count = this.dvF.getCount();
        if (i == 0) {
            this.dvD.setPosition(0.0f);
        } else if (i == count - 1) {
            this.dvD.setPosition(i);
        } else {
            this.dvD.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNt() {
        if (aNs()) {
            aNq();
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
            com.baidu.tbadk.core.flow.a.a kq;
            if (CoverFlowView.this.dvL != null && (view.getTag() instanceof Integer) && (kq = CoverFlowView.this.dvF.kq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.dvL.ah(intValue, kq.aIR());
            }
        }
    }

    public void onChangeSkinType() {
        this.dvF.onChangeSkinType();
        if (this.dvD != null && this.dvE != null) {
            this.dvD.setDrawable(am.getDrawable(this.dvE.aNu()));
            this.dvD.setSelector(am.getDrawable(this.dvE.aNv()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.dvC != null) {
            this.dvC.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.dvC != null) {
            this.dvC.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.dvI = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.dvJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.dvJ;
    }

    private void setAutoPlay(boolean z) {
        this.dvK = z;
    }
}
