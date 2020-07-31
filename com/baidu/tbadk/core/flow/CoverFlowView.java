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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager dWS;
    private IndicatorView dWT;
    private com.baidu.tbadk.core.flow.a.c dWU;
    private CoverFlowAdapter<T> dWV;
    private com.baidu.tbadk.core.flow.a dWW;
    private CoverFlowView<T>.a dWX;
    private boolean dWY;
    private boolean dWZ;
    private boolean dXa;
    private d<T> dXb;
    private CoverFlowView<T>.c dXc;
    private CoverFlowView<T>.b dXd;
    private long dXe;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.dWX = new a();
        this.dWY = false;
        this.dWZ = true;
        this.dXa = true;
        this.dXc = new c();
        this.dXd = new b();
        this.dXe = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.dWX = new a();
        this.dWY = false;
        this.dWZ = true;
        this.dXa = true;
        this.dXc = new c();
        this.dXd = new b();
        this.dXe = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.dWX = new a();
        this.dWY = false;
        this.dWZ = true;
        this.dXa = true;
        this.dXc = new c();
        this.dXd = new b();
        this.dXe = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.dXb = dVar;
    }

    private void init(Context context) {
        dJ(context);
        dK(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.dWS);
        addView(this.dWT);
        this.dWV = new CoverFlowAdapter<>(context);
        this.dWV.setOnClickListener(this.dXc);
        this.dWS.setAdapter(this.dWV);
        this.dWS.setOnPageChangeListener(this.dXd);
    }

    private void dJ(Context context) {
        this.dWS = new ListViewPager(context);
    }

    private void dK(Context context) {
        this.dWT = new IndicatorView(context);
        this.dWT.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T lA(int i) {
        if (this.dWV == null) {
            return null;
        }
        return this.dWV.lA(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.dWV.a(list, this.dWW);
            int size = list.size();
            if (size > 1) {
                this.dWT.setVisibility(0);
                this.dWT.setCount(size);
                this.dWS.setCurrentItem(1, false);
                this.dWT.setPosition(0.0f);
                aZi();
                return;
            }
            this.dWT.setVisibility(8);
            this.dWT.setCount(size);
            this.dWS.setCurrentItem(1, false);
            this.dWT.setPosition(0.0f);
            aZj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.dWW = aVar;
            this.dWU = aVar.sp();
            this.dWU.g(this.dWT);
            aVar.so().b(this.dWS);
            this.mCustomView = aVar.aZh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.dWS);
                addView(this.mCustomView);
                addView(this.dWT);
            }
        }
    }

    public void aZi() {
        aZk();
    }

    public void aZj() {
        this.dWX.removeMessages(1);
    }

    public void aZk() {
        this.dWX.removeMessages(1);
        this.dWX.sendEmptyMessageDelayed(1, this.dXe);
    }

    public void sn() {
        if (!this.dWX.hasMessages(1)) {
            aZi();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dWT != null) {
            this.dWT.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.dXe = j;
        aZk();
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
                    CoverFlowView.this.aZl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZl() {
        int count;
        if (this.dWS != null && this.dWV != null && (count = this.dWV.getCount()) > 1) {
            int currentItem = this.dWS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dWS.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.dWS.setCurrentItem(1, false);
            } else {
                this.dWS.setCurrentItem(currentItem + 1);
            }
            this.dWS.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZm() {
        int count;
        if (this.dWV != null && (count = this.dWV.getCount()) > 1) {
            int currentItem = this.dWS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.dWS.setCurrentItem(i, false);
                this.dWS.invalidate();
            } else if (currentItem > i) {
                this.dWS.setCurrentItem(1, false);
                this.dWS.invalidate();
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
            if (CoverFlowView.this.dWT != null && CoverFlowView.this.dWV != null) {
                if (CoverFlowView.this.dWV.getCount() == 1 && i == 0 && CoverFlowView.this.dXb != null) {
                    CoverFlowView.this.dXb.a(1, CoverFlowView.this.dWV.lA(i));
                }
                if (CoverFlowView.this.dWT.getVisibility() == 0 && !CoverFlowView.this.dWY) {
                    int count = CoverFlowView.this.dWV.getCount();
                    if (i == 0) {
                        CoverFlowView.this.dWT.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.dWT.setPosition(f);
                    } else {
                        CoverFlowView.this.dWT.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.dWV != null) {
                int count = CoverFlowView.this.dWV.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.dWY) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.dXb != null) {
                        CoverFlowView.this.dXb.a(i, CoverFlowView.this.dWV.lA(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.dWS != null && CoverFlowView.this.dWV != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.dXa) {
                            CoverFlowView.this.aZn();
                            return;
                        }
                        return;
                    case 1:
                        if (!CoverFlowView.this.dWZ) {
                            CoverFlowView.this.aZj();
                            CoverFlowView.this.aZm();
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
        int count = this.dWV.getCount();
        if (i == 0) {
            this.dWT.setPosition(0.0f);
        } else if (i == count - 1) {
            this.dWT.setPosition(i);
        } else {
            this.dWT.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZn() {
        if (aZm()) {
            aZk();
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
            com.baidu.tbadk.core.flow.a.a lA;
            if (CoverFlowView.this.dXb != null && (view.getTag() instanceof Integer) && (lA = CoverFlowView.this.dWV.lA((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.dXb.f(intValue, lA.aUj());
            }
        }
    }

    public void onChangeSkinType() {
        this.dWV.onChangeSkinType();
        if (this.dWT != null && this.dWU != null) {
            this.dWT.setDrawable(ao.getDrawable(this.dWU.aZo()));
            this.dWT.setSelector(ao.getDrawable(this.dWU.aZp()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.dWS != null) {
            this.dWS.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.dWS != null) {
            this.dWS.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.dWY = z;
    }

    public void setPageMargin(int i) {
        if (this.dWS != null) {
            this.dWS.setPageMargin(i);
        }
    }

    public void a(e eVar) {
        if (eVar != null && this.dWS != null) {
            eVar.b(this.dWS);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.dWZ = z;
    }

    private boolean getAutoPlayPlayDragging() {
        return this.dWZ;
    }

    public void setAutoPlay(boolean z) {
        this.dXa = z;
    }
}
