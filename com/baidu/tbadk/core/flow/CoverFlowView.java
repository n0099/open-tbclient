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
    private ListViewPager dvG;
    private IndicatorView dvH;
    private com.baidu.tbadk.core.flow.a.c dvI;
    private CoverFlowAdapter<T> dvJ;
    private com.baidu.tbadk.core.flow.a dvK;
    private CoverFlowView<T>.a dvL;
    private boolean dvM;
    private boolean dvN;
    private boolean dvO;
    private d<T> dvP;
    private CoverFlowView<T>.c dvQ;
    private CoverFlowView<T>.b dvR;
    private long dvS;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.dvL = new a();
        this.dvM = false;
        this.dvN = true;
        this.dvO = true;
        this.dvQ = new c();
        this.dvR = new b();
        this.dvS = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.dvL = new a();
        this.dvM = false;
        this.dvN = true;
        this.dvO = true;
        this.dvQ = new c();
        this.dvR = new b();
        this.dvS = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.dvL = new a();
        this.dvM = false;
        this.dvN = true;
        this.dvO = true;
        this.dvQ = new c();
        this.dvR = new b();
        this.dvS = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.dvP = dVar;
    }

    private void init(Context context) {
        dl(context);
        dm(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.dvG);
        addView(this.dvH);
        this.dvJ = new CoverFlowAdapter<>(context);
        this.dvJ.setOnClickListener(this.dvQ);
        this.dvG.setAdapter(this.dvJ);
        this.dvG.setOnPageChangeListener(this.dvR);
    }

    private void dl(Context context) {
        this.dvG = new ListViewPager(context);
    }

    private void dm(Context context) {
        this.dvH = new IndicatorView(context);
        this.dvH.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T kq(int i) {
        if (this.dvJ == null) {
            return null;
        }
        return this.dvJ.kq(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.dvJ.a(list, this.dvK);
            int size = list.size();
            if (size > 1) {
                this.dvH.setVisibility(0);
                this.dvH.setCount(size);
                this.dvG.setCurrentItem(1, false);
                this.dvH.setPosition(0.0f);
                aNm();
                return;
            }
            this.dvH.setVisibility(8);
            this.dvH.setCount(size);
            this.dvG.setCurrentItem(1, false);
            this.dvH.setPosition(0.0f);
            aNn();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.dvK = aVar;
            this.dvI = aVar.aNj();
            this.dvI.g(this.dvH);
            aVar.aNk().b(this.dvG);
            this.mCustomView = aVar.aNl();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.dvG);
                addView(this.mCustomView);
                addView(this.dvH);
            }
        }
    }

    public void aNm() {
        aNo();
    }

    public void aNn() {
        this.dvL.removeMessages(1);
    }

    public void aNo() {
        this.dvL.removeMessages(1);
        this.dvL.sendEmptyMessageDelayed(1, this.dvS);
    }

    public void setIndicatorVisible(int i) {
        if (this.dvH != null) {
            this.dvH.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.dvS = j;
        aNo();
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
                    CoverFlowView.this.aNp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNp() {
        int count;
        if (this.dvG != null && this.dvJ != null && (count = this.dvJ.getCount()) > 1) {
            int currentItem = this.dvG.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dvG.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.dvG.setCurrentItem(1, false);
            } else {
                this.dvG.setCurrentItem(currentItem + 1);
            }
            this.dvG.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNq() {
        int count;
        if (this.dvJ != null && (count = this.dvJ.getCount()) > 1) {
            int currentItem = this.dvG.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dvG.setCurrentItem(i, false);
                this.dvG.invalidate();
            } else if (currentItem > i) {
                this.dvG.setCurrentItem(1, false);
                this.dvG.invalidate();
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
            if (CoverFlowView.this.dvH != null && CoverFlowView.this.dvJ != null) {
                if (CoverFlowView.this.dvJ.getCount() == 1 && i == 0 && CoverFlowView.this.dvP != null) {
                    CoverFlowView.this.dvP.a(1, CoverFlowView.this.dvJ.kq(i));
                }
                if (CoverFlowView.this.dvH.getVisibility() == 0 && !CoverFlowView.this.dvM) {
                    int count = CoverFlowView.this.dvJ.getCount();
                    if (i == 0) {
                        CoverFlowView.this.dvH.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.dvH.setPosition(f);
                    } else {
                        CoverFlowView.this.dvH.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.dvJ != null) {
                int count = CoverFlowView.this.dvJ.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.dvM) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.dvP != null) {
                        CoverFlowView.this.dvP.a(i, CoverFlowView.this.dvJ.kq(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.dvG != null && CoverFlowView.this.dvJ != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.dvO) {
                            CoverFlowView.this.aNr();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.dvO = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.dvO) {
                            CoverFlowView.this.aNn();
                            CoverFlowView.this.aNq();
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
        int count = this.dvJ.getCount();
        if (i == 0) {
            this.dvH.setPosition(0.0f);
        } else if (i == count - 1) {
            this.dvH.setPosition(i);
        } else {
            this.dvH.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNr() {
        if (aNq()) {
            aNo();
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
            if (CoverFlowView.this.dvP != null && (view.getTag() instanceof Integer) && (kq = CoverFlowView.this.dvJ.kq((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.dvP.ah(intValue, kq.aIP());
            }
        }
    }

    public void onChangeSkinType() {
        this.dvJ.onChangeSkinType();
        if (this.dvH != null && this.dvI != null) {
            this.dvH.setDrawable(am.getDrawable(this.dvI.aNs()));
            this.dvH.setSelector(am.getDrawable(this.dvI.aNt()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.dvG != null) {
            this.dvG.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.dvG != null) {
            this.dvG.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.dvM = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.dvN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.dvN;
    }

    private void setAutoPlay(boolean z) {
        this.dvO = z;
    }
}
