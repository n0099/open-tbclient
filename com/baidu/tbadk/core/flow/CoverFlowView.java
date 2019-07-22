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
    private com.baidu.tbadk.core.flow.a.c bOA;
    private CoverFlowAdapter<T> bOB;
    private com.baidu.tbadk.core.flow.a bOC;
    private CoverFlowView<T>.a bOD;
    private boolean bOE;
    private boolean bOF;
    private boolean bOG;
    private d<T> bOH;
    private CoverFlowView<T>.c bOI;
    private CoverFlowView<T>.b bOJ;
    private long bOK;
    private ListViewPager bOy;
    private IndicatorView bOz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bOD = new a();
        this.bOE = false;
        this.bOF = true;
        this.bOG = true;
        this.bOI = new c();
        this.bOJ = new b();
        this.bOK = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bOD = new a();
        this.bOE = false;
        this.bOF = true;
        this.bOG = true;
        this.bOI = new c();
        this.bOJ = new b();
        this.bOK = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bOD = new a();
        this.bOE = false;
        this.bOF = true;
        this.bOG = true;
        this.bOI = new c();
        this.bOJ = new b();
        this.bOK = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bOH = dVar;
    }

    private void init(Context context) {
        cn(context);
        co(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bOy);
        addView(this.bOz);
        this.bOB = new CoverFlowAdapter<>(context);
        this.bOB.setOnClickListener(this.bOI);
        this.bOy.setAdapter(this.bOB);
        this.bOy.setOnPageChangeListener(this.bOJ);
    }

    private void cn(Context context) {
        this.bOy = new ListViewPager(context);
    }

    private void co(Context context) {
        this.bOz = new IndicatorView(context);
        this.bOz.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T hM(int i) {
        if (this.bOB == null) {
            return null;
        }
        return this.bOB.hM(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bOB.a(list, this.bOC);
            int size = list.size();
            if (size > 1) {
                this.bOz.setVisibility(0);
                this.bOz.setCount(size);
                this.bOy.setCurrentItem(1, false);
                this.bOz.setPosition(0.0f);
                ahg();
                return;
            }
            this.bOz.setVisibility(8);
            this.bOz.setCount(size);
            this.bOy.setCurrentItem(1, false);
            this.bOz.setPosition(0.0f);
            ahh();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bOC = aVar;
            this.bOA = aVar.ahd();
            this.bOA.g(this.bOz);
            aVar.ahe().a(this.bOy);
            this.mCustomView = aVar.ahf();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bOy);
                addView(this.mCustomView);
                addView(this.bOz);
            }
        }
    }

    public void ahg() {
        ahi();
    }

    public void ahh() {
        this.bOD.removeMessages(1);
    }

    public void ahi() {
        this.bOD.removeMessages(1);
        this.bOD.sendEmptyMessageDelayed(1, this.bOK);
    }

    public void setIndicatorVisible(int i) {
        if (this.bOz != null) {
            this.bOz.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bOK = j;
        ahi();
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
                    CoverFlowView.this.ahj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahj() {
        int count;
        if (this.bOy != null && this.bOB != null && (count = this.bOB.getCount()) > 1) {
            int currentItem = this.bOy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bOy.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bOy.setCurrentItem(1, false);
            } else {
                this.bOy.setCurrentItem(currentItem + 1);
            }
            this.bOy.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahk() {
        int count;
        if (this.bOB != null && (count = this.bOB.getCount()) > 1) {
            int currentItem = this.bOy.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bOy.setCurrentItem(i, false);
                this.bOy.invalidate();
            } else if (currentItem > i) {
                this.bOy.setCurrentItem(1, false);
                this.bOy.invalidate();
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
            if (CoverFlowView.this.bOz != null && CoverFlowView.this.bOB != null) {
                if (CoverFlowView.this.bOB.getCount() == 1 && i == 0 && CoverFlowView.this.bOH != null) {
                    CoverFlowView.this.bOH.a(1, CoverFlowView.this.bOB.hM(i));
                }
                if (CoverFlowView.this.bOz.getVisibility() == 0 && !CoverFlowView.this.bOE) {
                    int count = CoverFlowView.this.bOB.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bOz.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bOz.setPosition(f);
                    } else {
                        CoverFlowView.this.bOz.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bOB != null) {
                int count = CoverFlowView.this.bOB.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bOE) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bOH != null) {
                        CoverFlowView.this.bOH.a(i, CoverFlowView.this.bOB.hM(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bOy != null && CoverFlowView.this.bOB != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bOG) {
                            CoverFlowView.this.ahl();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bOG = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bOG) {
                            CoverFlowView.this.ahh();
                            CoverFlowView.this.ahk();
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
        int count = this.bOB.getCount();
        if (i == 0) {
            this.bOz.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bOz.setPosition(i);
        } else {
            this.bOz.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahl() {
        if (ahk()) {
            ahi();
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
            com.baidu.tbadk.core.flow.a.a hM;
            if (CoverFlowView.this.bOH != null && (view.getTag() instanceof Integer) && (hM = CoverFlowView.this.bOB.hM((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bOH.B(intValue, hM.acP());
            }
        }
    }

    public void onChangeSkinType() {
        this.bOB.onChangeSkinType();
        if (this.bOz != null && this.bOA != null) {
            this.bOz.setDrawable(am.getDrawable(this.bOA.ahm()));
            this.bOz.setSelector(am.getDrawable(this.bOA.ahn()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bOy != null) {
            this.bOy.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bOy != null) {
            this.bOy.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bOE = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bOF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bOF;
    }

    private void setAutoPlay(boolean z) {
        this.bOG = z;
    }
}
