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
    private ListViewPager bOE;
    private IndicatorView bOF;
    private com.baidu.tbadk.core.flow.a.c bOG;
    private CoverFlowAdapter<T> bOH;
    private com.baidu.tbadk.core.flow.a bOI;
    private CoverFlowView<T>.a bOJ;
    private boolean bOK;
    private boolean bOL;
    private boolean bOM;
    private d<T> bON;
    private CoverFlowView<T>.c bOO;
    private CoverFlowView<T>.b bOP;
    private long bOQ;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bOJ = new a();
        this.bOK = false;
        this.bOL = true;
        this.bOM = true;
        this.bOO = new c();
        this.bOP = new b();
        this.bOQ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bOJ = new a();
        this.bOK = false;
        this.bOL = true;
        this.bOM = true;
        this.bOO = new c();
        this.bOP = new b();
        this.bOQ = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bOJ = new a();
        this.bOK = false;
        this.bOL = true;
        this.bOM = true;
        this.bOO = new c();
        this.bOP = new b();
        this.bOQ = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bON = dVar;
    }

    private void init(Context context) {
        cn(context);
        co(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bOE);
        addView(this.bOF);
        this.bOH = new CoverFlowAdapter<>(context);
        this.bOH.setOnClickListener(this.bOO);
        this.bOE.setAdapter(this.bOH);
        this.bOE.setOnPageChangeListener(this.bOP);
    }

    private void cn(Context context) {
        this.bOE = new ListViewPager(context);
    }

    private void co(Context context) {
        this.bOF = new IndicatorView(context);
        this.bOF.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T hM(int i) {
        if (this.bOH == null) {
            return null;
        }
        return this.bOH.hM(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bOH.a(list, this.bOI);
            int size = list.size();
            if (size > 1) {
                this.bOF.setVisibility(0);
                this.bOF.setCount(size);
                this.bOE.setCurrentItem(1, false);
                this.bOF.setPosition(0.0f);
                ahi();
                return;
            }
            this.bOF.setVisibility(8);
            this.bOF.setCount(size);
            this.bOE.setCurrentItem(1, false);
            this.bOF.setPosition(0.0f);
            ahj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bOI = aVar;
            this.bOG = aVar.ahf();
            this.bOG.g(this.bOF);
            aVar.ahg().a(this.bOE);
            this.mCustomView = aVar.ahh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bOE);
                addView(this.mCustomView);
                addView(this.bOF);
            }
        }
    }

    public void ahi() {
        ahk();
    }

    public void ahj() {
        this.bOJ.removeMessages(1);
    }

    public void ahk() {
        this.bOJ.removeMessages(1);
        this.bOJ.sendEmptyMessageDelayed(1, this.bOQ);
    }

    public void setIndicatorVisible(int i) {
        if (this.bOF != null) {
            this.bOF.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bOQ = j;
        ahk();
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
                    CoverFlowView.this.ahl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahl() {
        int count;
        if (this.bOE != null && this.bOH != null && (count = this.bOH.getCount()) > 1) {
            int currentItem = this.bOE.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bOE.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bOE.setCurrentItem(1, false);
            } else {
                this.bOE.setCurrentItem(currentItem + 1);
            }
            this.bOE.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahm() {
        int count;
        if (this.bOH != null && (count = this.bOH.getCount()) > 1) {
            int currentItem = this.bOE.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bOE.setCurrentItem(i, false);
                this.bOE.invalidate();
            } else if (currentItem > i) {
                this.bOE.setCurrentItem(1, false);
                this.bOE.invalidate();
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
            if (CoverFlowView.this.bOF != null && CoverFlowView.this.bOH != null) {
                if (CoverFlowView.this.bOH.getCount() == 1 && i == 0 && CoverFlowView.this.bON != null) {
                    CoverFlowView.this.bON.a(1, CoverFlowView.this.bOH.hM(i));
                }
                if (CoverFlowView.this.bOF.getVisibility() == 0 && !CoverFlowView.this.bOK) {
                    int count = CoverFlowView.this.bOH.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bOF.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bOF.setPosition(f);
                    } else {
                        CoverFlowView.this.bOF.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bOH != null) {
                int count = CoverFlowView.this.bOH.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bOK) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bON != null) {
                        CoverFlowView.this.bON.a(i, CoverFlowView.this.bOH.hM(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bOE != null && CoverFlowView.this.bOH != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bOM) {
                            CoverFlowView.this.ahn();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bOM = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bOM) {
                            CoverFlowView.this.ahj();
                            CoverFlowView.this.ahm();
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
        int count = this.bOH.getCount();
        if (i == 0) {
            this.bOF.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bOF.setPosition(i);
        } else {
            this.bOF.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahn() {
        if (ahm()) {
            ahk();
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
            if (CoverFlowView.this.bON != null && (view.getTag() instanceof Integer) && (hM = CoverFlowView.this.bOH.hM((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bON.B(intValue, hM.acQ());
            }
        }
    }

    public void onChangeSkinType() {
        this.bOH.onChangeSkinType();
        if (this.bOF != null && this.bOG != null) {
            this.bOF.setDrawable(am.getDrawable(this.bOG.aho()));
            this.bOF.setSelector(am.getDrawable(this.bOG.ahp()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bOE != null) {
            this.bOE.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bOE != null) {
            this.bOE.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bOK = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bOL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bOL;
    }

    private void setAutoPlay(boolean z) {
        this.bOM = z;
    }
}
