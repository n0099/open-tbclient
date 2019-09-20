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
    private ListViewPager bPf;
    private IndicatorView bPg;
    private com.baidu.tbadk.core.flow.a.c bPh;
    private CoverFlowAdapter<T> bPi;
    private com.baidu.tbadk.core.flow.a bPj;
    private CoverFlowView<T>.a bPk;
    private boolean bPl;
    private boolean bPm;
    private boolean bPn;
    private d<T> bPo;
    private CoverFlowView<T>.c bPp;
    private CoverFlowView<T>.b bPq;
    private long bPr;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bPk = new a();
        this.bPl = false;
        this.bPm = true;
        this.bPn = true;
        this.bPp = new c();
        this.bPq = new b();
        this.bPr = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bPk = new a();
        this.bPl = false;
        this.bPm = true;
        this.bPn = true;
        this.bPp = new c();
        this.bPq = new b();
        this.bPr = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bPk = new a();
        this.bPl = false;
        this.bPm = true;
        this.bPn = true;
        this.bPp = new c();
        this.bPq = new b();
        this.bPr = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bPo = dVar;
    }

    private void init(Context context) {
        cn(context);
        co(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bPf);
        addView(this.bPg);
        this.bPi = new CoverFlowAdapter<>(context);
        this.bPi.setOnClickListener(this.bPp);
        this.bPf.setAdapter(this.bPi);
        this.bPf.setOnPageChangeListener(this.bPq);
    }

    private void cn(Context context) {
        this.bPf = new ListViewPager(context);
    }

    private void co(Context context) {
        this.bPg = new IndicatorView(context);
        this.bPg.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T hM(int i) {
        if (this.bPi == null) {
            return null;
        }
        return this.bPi.hM(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bPi.a(list, this.bPj);
            int size = list.size();
            if (size > 1) {
                this.bPg.setVisibility(0);
                this.bPg.setCount(size);
                this.bPf.setCurrentItem(1, false);
                this.bPg.setPosition(0.0f);
                ahm();
                return;
            }
            this.bPg.setVisibility(8);
            this.bPg.setCount(size);
            this.bPf.setCurrentItem(1, false);
            this.bPg.setPosition(0.0f);
            ahn();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bPj = aVar;
            this.bPh = aVar.ahj();
            this.bPh.g(this.bPg);
            aVar.ahk().a(this.bPf);
            this.mCustomView = aVar.ahl();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bPf);
                addView(this.mCustomView);
                addView(this.bPg);
            }
        }
    }

    public void ahm() {
        aho();
    }

    public void ahn() {
        this.bPk.removeMessages(1);
    }

    public void aho() {
        this.bPk.removeMessages(1);
        this.bPk.sendEmptyMessageDelayed(1, this.bPr);
    }

    public void setIndicatorVisible(int i) {
        if (this.bPg != null) {
            this.bPg.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bPr = j;
        aho();
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
                    CoverFlowView.this.ahp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahp() {
        int count;
        if (this.bPf != null && this.bPi != null && (count = this.bPi.getCount()) > 1) {
            int currentItem = this.bPf.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bPf.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bPf.setCurrentItem(1, false);
            } else {
                this.bPf.setCurrentItem(currentItem + 1);
            }
            this.bPf.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahq() {
        int count;
        if (this.bPi != null && (count = this.bPi.getCount()) > 1) {
            int currentItem = this.bPf.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bPf.setCurrentItem(i, false);
                this.bPf.invalidate();
            } else if (currentItem > i) {
                this.bPf.setCurrentItem(1, false);
                this.bPf.invalidate();
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
            if (CoverFlowView.this.bPg != null && CoverFlowView.this.bPi != null) {
                if (CoverFlowView.this.bPi.getCount() == 1 && i == 0 && CoverFlowView.this.bPo != null) {
                    CoverFlowView.this.bPo.a(1, CoverFlowView.this.bPi.hM(i));
                }
                if (CoverFlowView.this.bPg.getVisibility() == 0 && !CoverFlowView.this.bPl) {
                    int count = CoverFlowView.this.bPi.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bPg.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bPg.setPosition(f);
                    } else {
                        CoverFlowView.this.bPg.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bPi != null) {
                int count = CoverFlowView.this.bPi.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bPl) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bPo != null) {
                        CoverFlowView.this.bPo.a(i, CoverFlowView.this.bPi.hM(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bPf != null && CoverFlowView.this.bPi != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bPn) {
                            CoverFlowView.this.ahr();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bPn = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bPn) {
                            CoverFlowView.this.ahn();
                            CoverFlowView.this.ahq();
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
        int count = this.bPi.getCount();
        if (i == 0) {
            this.bPg.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bPg.setPosition(i);
        } else {
            this.bPg.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahr() {
        if (ahq()) {
            aho();
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
            if (CoverFlowView.this.bPo != null && (view.getTag() instanceof Integer) && (hM = CoverFlowView.this.bPi.hM((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bPo.B(intValue, hM.acU());
            }
        }
    }

    public void onChangeSkinType() {
        this.bPi.onChangeSkinType();
        if (this.bPg != null && this.bPh != null) {
            this.bPg.setDrawable(am.getDrawable(this.bPh.ahs()));
            this.bPg.setSelector(am.getDrawable(this.bPh.aht()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bPf != null) {
            this.bPf.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bPf != null) {
            this.bPf.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bPl = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bPm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bPm;
    }

    private void setAutoPlay(boolean z) {
        this.bPn = z;
    }
}
