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
    private ListViewPager bFW;
    private IndicatorView bFX;
    private com.baidu.tbadk.core.flow.a.c bFY;
    private CoverFlowAdapter<T> bFZ;
    private com.baidu.tbadk.core.flow.a bGa;
    private CoverFlowView<T>.a bGb;
    private boolean bGc;
    private boolean bGd;
    private boolean bGe;
    private d<T> bGf;
    private CoverFlowView<T>.c bGg;
    private CoverFlowView<T>.b bGh;
    private long bGi;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bGb = new a();
        this.bGc = false;
        this.bGd = true;
        this.bGe = true;
        this.bGg = new c();
        this.bGh = new b();
        this.bGi = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bGb = new a();
        this.bGc = false;
        this.bGd = true;
        this.bGe = true;
        this.bGg = new c();
        this.bGh = new b();
        this.bGi = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bGb = new a();
        this.bGc = false;
        this.bGd = true;
        this.bGe = true;
        this.bGg = new c();
        this.bGh = new b();
        this.bGi = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bGf = dVar;
    }

    private void init(Context context) {
        cH(context);
        cI(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bFW);
        addView(this.bFX);
        this.bFZ = new CoverFlowAdapter<>(context);
        this.bFZ.setOnClickListener(this.bGg);
        this.bFW.setAdapter(this.bFZ);
        this.bFW.setOnPageChangeListener(this.bGh);
    }

    private void cH(Context context) {
        this.bFW = new ListViewPager(context);
    }

    private void cI(Context context) {
        this.bFX = new IndicatorView(context);
        this.bFX.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T gS(int i) {
        if (this.bFZ == null) {
            return null;
        }
        return this.bFZ.gS(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bFZ.a(list, this.bGa);
            int size = list.size();
            if (size > 1) {
                this.bFX.setVisibility(0);
                this.bFX.setCount(size);
                this.bFW.setCurrentItem(1, false);
                this.bFX.setPosition(0.0f);
                abm();
                return;
            }
            this.bFX.setVisibility(8);
            this.bFX.setCount(size);
            this.bFW.setCurrentItem(1, false);
            this.bFX.setPosition(0.0f);
            abn();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bGa = aVar;
            this.bFY = aVar.abj();
            this.bFY.g(this.bFX);
            aVar.abk().a(this.bFW);
            this.mCustomView = aVar.abl();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bFW);
                addView(this.mCustomView);
                addView(this.bFX);
            }
        }
    }

    public void abm() {
        abo();
    }

    public void abn() {
        this.bGb.removeMessages(1);
    }

    public void abo() {
        this.bGb.removeMessages(1);
        this.bGb.sendEmptyMessageDelayed(1, this.bGi);
    }

    public void setIndicatorVisible(int i) {
        if (this.bFX != null) {
            this.bFX.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bGi = j;
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
        if (this.bFW != null && this.bFZ != null && (count = this.bFZ.getCount()) > 1) {
            int currentItem = this.bFW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFW.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bFW.setCurrentItem(1, false);
            } else {
                this.bFW.setCurrentItem(currentItem + 1);
            }
            this.bFW.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abq() {
        int count;
        if (this.bFZ != null && (count = this.bFZ.getCount()) > 1) {
            int currentItem = this.bFW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFW.setCurrentItem(i, false);
                this.bFW.invalidate();
            } else if (currentItem > i) {
                this.bFW.setCurrentItem(1, false);
                this.bFW.invalidate();
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
            if (CoverFlowView.this.bFX != null && CoverFlowView.this.bFZ != null) {
                if (CoverFlowView.this.bFZ.getCount() == 1 && i == 0 && CoverFlowView.this.bGf != null) {
                    CoverFlowView.this.bGf.a(1, CoverFlowView.this.bFZ.gS(i));
                }
                if (CoverFlowView.this.bFX.getVisibility() == 0 && !CoverFlowView.this.bGc) {
                    int count = CoverFlowView.this.bFZ.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bFX.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bFX.setPosition(f);
                    } else {
                        CoverFlowView.this.bFX.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bFZ != null) {
                int count = CoverFlowView.this.bFZ.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bGc) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bGf != null) {
                        CoverFlowView.this.bGf.a(i, CoverFlowView.this.bFZ.gS(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bFW != null && CoverFlowView.this.bFZ != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bGe) {
                            CoverFlowView.this.abr();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bGe = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bGe) {
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
        int count = this.bFZ.getCount();
        if (i == 0) {
            this.bFX.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bFX.setPosition(i);
        } else {
            this.bFX.setPosition(i - 1);
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
            if (CoverFlowView.this.bGf != null && (view.getTag() instanceof Integer) && (gS = CoverFlowView.this.bFZ.gS((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bGf.y(intValue, gS.Xf());
            }
        }
    }

    public void onChangeSkinType() {
        this.bFZ.onChangeSkinType();
        if (this.bFX != null && this.bFY != null) {
            this.bFX.setDrawable(al.getDrawable(this.bFY.abs()));
            this.bFX.setSelector(al.getDrawable(this.bFY.abt()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bFW != null) {
            this.bFW.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bFW != null) {
            this.bFW.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bGc = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bGd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bGd;
    }

    private void setAutoPlay(boolean z) {
        this.bGe = z;
    }
}
