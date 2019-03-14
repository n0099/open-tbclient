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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager bFU;
    private IndicatorView bFV;
    private com.baidu.tbadk.core.flow.a.c bFW;
    private CoverFlowAdapter<T> bFX;
    private com.baidu.tbadk.core.flow.a bFY;
    private CoverFlowView<T>.a bFZ;
    private boolean bGa;
    private boolean bGb;
    private boolean bGc;
    private d<T> bGd;
    private CoverFlowView<T>.c bGe;
    private CoverFlowView<T>.b bGf;
    private long bGg;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bFZ = new a();
        this.bGa = false;
        this.bGb = true;
        this.bGc = true;
        this.bGe = new c();
        this.bGf = new b();
        this.bGg = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bFZ = new a();
        this.bGa = false;
        this.bGb = true;
        this.bGc = true;
        this.bGe = new c();
        this.bGf = new b();
        this.bGg = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bFZ = new a();
        this.bGa = false;
        this.bGb = true;
        this.bGc = true;
        this.bGe = new c();
        this.bGf = new b();
        this.bGg = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bGd = dVar;
    }

    private void init(Context context) {
        cH(context);
        cI(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bFU);
        addView(this.bFV);
        this.bFX = new CoverFlowAdapter<>(context);
        this.bFX.setOnClickListener(this.bGe);
        this.bFU.setAdapter(this.bFX);
        this.bFU.setOnPageChangeListener(this.bGf);
    }

    private void cH(Context context) {
        this.bFU = new ListViewPager(context);
    }

    private void cI(Context context) {
        this.bFV = new IndicatorView(context);
        this.bFV.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T gT(int i) {
        if (this.bFX == null) {
            return null;
        }
        return this.bFX.gT(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bFX.a(list, this.bFY);
            int size = list.size();
            if (size > 1) {
                this.bFV.setVisibility(0);
                this.bFV.setCount(size);
                this.bFU.setCurrentItem(1, false);
                this.bFV.setPosition(0.0f);
                abp();
                return;
            }
            this.bFV.setVisibility(8);
            this.bFV.setCount(size);
            this.bFU.setCurrentItem(1, false);
            this.bFV.setPosition(0.0f);
            abq();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bFY = aVar;
            this.bFW = aVar.abm();
            this.bFW.g(this.bFV);
            aVar.abn().a(this.bFU);
            this.mCustomView = aVar.abo();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bFU);
                addView(this.mCustomView);
                addView(this.bFV);
            }
        }
    }

    public void abp() {
        abr();
    }

    public void abq() {
        this.bFZ.removeMessages(1);
    }

    public void abr() {
        this.bFZ.removeMessages(1);
        this.bFZ.sendEmptyMessageDelayed(1, this.bGg);
    }

    public void setIndicatorVisible(int i) {
        if (this.bFV != null) {
            this.bFV.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bGg = j;
        abr();
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
                    CoverFlowView.this.abs();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abs() {
        int count;
        if (this.bFU != null && this.bFX != null && (count = this.bFX.getCount()) > 1) {
            int currentItem = this.bFU.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFU.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bFU.setCurrentItem(1, false);
            } else {
                this.bFU.setCurrentItem(currentItem + 1);
            }
            this.bFU.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abt() {
        int count;
        if (this.bFX != null && (count = this.bFX.getCount()) > 1) {
            int currentItem = this.bFU.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFU.setCurrentItem(i, false);
                this.bFU.invalidate();
            } else if (currentItem > i) {
                this.bFU.setCurrentItem(1, false);
                this.bFU.invalidate();
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
            if (CoverFlowView.this.bFV != null && CoverFlowView.this.bFX != null) {
                if (CoverFlowView.this.bFX.getCount() == 1 && i == 0 && CoverFlowView.this.bGd != null) {
                    CoverFlowView.this.bGd.a(1, CoverFlowView.this.bFX.gT(i));
                }
                if (CoverFlowView.this.bFV.getVisibility() == 0 && !CoverFlowView.this.bGa) {
                    int count = CoverFlowView.this.bFX.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bFV.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bFV.setPosition(f);
                    } else {
                        CoverFlowView.this.bFV.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bFX != null) {
                int count = CoverFlowView.this.bFX.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bGa) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bGd != null) {
                        CoverFlowView.this.bGd.a(i, CoverFlowView.this.bFX.gT(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bFU != null && CoverFlowView.this.bFX != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bGc) {
                            CoverFlowView.this.abu();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bGc = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bGc) {
                            CoverFlowView.this.abq();
                            CoverFlowView.this.abt();
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
        int count = this.bFX.getCount();
        if (i == 0) {
            this.bFV.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bFV.setPosition(i);
        } else {
            this.bFV.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        if (abt()) {
            abr();
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
            com.baidu.tbadk.core.flow.a.a gT;
            if (CoverFlowView.this.bGd != null && (view.getTag() instanceof Integer) && (gT = CoverFlowView.this.bFX.gT((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bGd.y(intValue, gT.Xi());
            }
        }
    }

    public void onChangeSkinType() {
        this.bFX.onChangeSkinType();
        if (this.bFV != null && this.bFW != null) {
            this.bFV.setDrawable(al.getDrawable(this.bFW.abv()));
            this.bFV.setSelector(al.getDrawable(this.bFW.abw()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bFU != null) {
            this.bFU.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bFU != null) {
            this.bFU.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bGa = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bGb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bGb;
    }

    private void setAutoPlay(boolean z) {
        this.bGc = z;
    }
}
