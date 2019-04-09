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
    private ListViewPager bFX;
    private IndicatorView bFY;
    private com.baidu.tbadk.core.flow.a.c bFZ;
    private CoverFlowAdapter<T> bGa;
    private com.baidu.tbadk.core.flow.a bGb;
    private CoverFlowView<T>.a bGc;
    private boolean bGd;
    private boolean bGe;
    private boolean bGf;
    private d<T> bGg;
    private CoverFlowView<T>.c bGh;
    private CoverFlowView<T>.b bGi;
    private long bGj;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bGc = new a();
        this.bGd = false;
        this.bGe = true;
        this.bGf = true;
        this.bGh = new c();
        this.bGi = new b();
        this.bGj = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bGc = new a();
        this.bGd = false;
        this.bGe = true;
        this.bGf = true;
        this.bGh = new c();
        this.bGi = new b();
        this.bGj = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bGc = new a();
        this.bGd = false;
        this.bGe = true;
        this.bGf = true;
        this.bGh = new c();
        this.bGi = new b();
        this.bGj = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bGg = dVar;
    }

    private void init(Context context) {
        cH(context);
        cI(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bFX);
        addView(this.bFY);
        this.bGa = new CoverFlowAdapter<>(context);
        this.bGa.setOnClickListener(this.bGh);
        this.bFX.setAdapter(this.bGa);
        this.bFX.setOnPageChangeListener(this.bGi);
    }

    private void cH(Context context) {
        this.bFX = new ListViewPager(context);
    }

    private void cI(Context context) {
        this.bFY = new IndicatorView(context);
        this.bFY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T gS(int i) {
        if (this.bGa == null) {
            return null;
        }
        return this.bGa.gS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bGa.a(list, this.bGb);
            int size = list.size();
            if (size > 1) {
                this.bFY.setVisibility(0);
                this.bFY.setCount(size);
                this.bFX.setCurrentItem(1, false);
                this.bFY.setPosition(0.0f);
                abm();
                return;
            }
            this.bFY.setVisibility(8);
            this.bFY.setCount(size);
            this.bFX.setCurrentItem(1, false);
            this.bFY.setPosition(0.0f);
            abn();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bGb = aVar;
            this.bFZ = aVar.abj();
            this.bFZ.g(this.bFY);
            aVar.abk().a(this.bFX);
            this.mCustomView = aVar.abl();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bFX);
                addView(this.mCustomView);
                addView(this.bFY);
            }
        }
    }

    public void abm() {
        abo();
    }

    public void abn() {
        this.bGc.removeMessages(1);
    }

    public void abo() {
        this.bGc.removeMessages(1);
        this.bGc.sendEmptyMessageDelayed(1, this.bGj);
    }

    public void setIndicatorVisible(int i) {
        if (this.bFY != null) {
            this.bFY.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bGj = j;
        abo();
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
                    CoverFlowView.this.abp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abp() {
        int count;
        if (this.bFX != null && this.bGa != null && (count = this.bGa.getCount()) > 1) {
            int currentItem = this.bFX.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFX.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bFX.setCurrentItem(1, false);
            } else {
                this.bFX.setCurrentItem(currentItem + 1);
            }
            this.bFX.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abq() {
        int count;
        if (this.bGa != null && (count = this.bGa.getCount()) > 1) {
            int currentItem = this.bFX.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFX.setCurrentItem(i, false);
                this.bFX.invalidate();
            } else if (currentItem > i) {
                this.bFX.setCurrentItem(1, false);
                this.bFX.invalidate();
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
            if (CoverFlowView.this.bFY != null && CoverFlowView.this.bGa != null) {
                if (CoverFlowView.this.bGa.getCount() == 1 && i == 0 && CoverFlowView.this.bGg != null) {
                    CoverFlowView.this.bGg.a(1, CoverFlowView.this.bGa.gS(i));
                }
                if (CoverFlowView.this.bFY.getVisibility() == 0 && !CoverFlowView.this.bGd) {
                    int count = CoverFlowView.this.bGa.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bFY.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bFY.setPosition(f);
                    } else {
                        CoverFlowView.this.bFY.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bGa != null) {
                int count = CoverFlowView.this.bGa.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bGd) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bGg != null) {
                        CoverFlowView.this.bGg.a(i, CoverFlowView.this.bGa.gS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bFX != null && CoverFlowView.this.bGa != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bGf) {
                            CoverFlowView.this.abr();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bGf = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bGf) {
                            CoverFlowView.this.abn();
                            CoverFlowView.this.abq();
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
        int count = this.bGa.getCount();
        if (i == 0) {
            this.bFY.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bFY.setPosition(i);
        } else {
            this.bFY.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abr() {
        if (abq()) {
            abo();
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
            com.baidu.tbadk.core.flow.a.a gS;
            if (CoverFlowView.this.bGg != null && (view.getTag() instanceof Integer) && (gS = CoverFlowView.this.bGa.gS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bGg.y(intValue, gS.Xf());
            }
        }
    }

    public void onChangeSkinType() {
        this.bGa.onChangeSkinType();
        if (this.bFY != null && this.bFZ != null) {
            this.bFY.setDrawable(al.getDrawable(this.bFZ.abs()));
            this.bFY.setSelector(al.getDrawable(this.bFZ.abt()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bFX != null) {
            this.bFX.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bFX != null) {
            this.bFX.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bGd = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bGe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bGe;
    }

    private void setAutoPlay(boolean z) {
        this.bGf = z;
    }
}
