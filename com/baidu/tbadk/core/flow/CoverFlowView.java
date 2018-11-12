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
    private ListViewPager atW;
    private IndicatorView atX;
    private com.baidu.tbadk.core.flow.a.c atY;
    private CoverFlowAdapter<T> atZ;
    private com.baidu.tbadk.core.flow.a aua;
    private CoverFlowView<T>.a aub;
    private boolean auc;
    private boolean aud;
    private boolean aue;
    private d<T> auf;
    private CoverFlowView<T>.c aug;
    private CoverFlowView<T>.b auh;
    private long aui;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aub = new a();
        this.auc = false;
        this.aud = true;
        this.aue = true;
        this.aug = new c();
        this.auh = new b();
        this.aui = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aub = new a();
        this.auc = false;
        this.aud = true;
        this.aue = true;
        this.aug = new c();
        this.auh = new b();
        this.aui = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aub = new a();
        this.auc = false;
        this.aud = true;
        this.aue = true;
        this.aug = new c();
        this.auh = new b();
        this.aui = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.auf = dVar;
    }

    private void init(Context context) {
        bq(context);
        br(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.atW);
        addView(this.atX);
        this.atZ = new CoverFlowAdapter<>(context);
        this.atZ.setOnClickListener(this.aug);
        this.atW.setAdapter(this.atZ);
        this.atW.setOnPageChangeListener(this.auh);
    }

    private void bq(Context context) {
        this.atW = new ListViewPager(context);
    }

    private void br(Context context) {
        this.atX = new IndicatorView(context);
        this.atX.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T dd(int i) {
        if (this.atZ == null) {
            return null;
        }
        return this.atZ.dd(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.atZ.a(list, this.aua);
            int size = list.size();
            if (size > 1) {
                this.atX.setVisibility(0);
                this.atX.setCount(size);
                this.atW.setCurrentItem(1, false);
                this.atX.setPosition(0.0f);
                AO();
                return;
            }
            this.atX.setVisibility(8);
            this.atX.setCount(size);
            this.atW.setCurrentItem(1, false);
            this.atX.setPosition(0.0f);
            AP();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.aua = aVar;
            this.atY = aVar.AL();
            this.atY.g(this.atX);
            aVar.AM().a(this.atW);
            this.mCustomView = aVar.AN();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.atW);
                addView(this.mCustomView);
                addView(this.atX);
            }
        }
    }

    public void AO() {
        AQ();
    }

    public void AP() {
        this.aub.removeMessages(1);
    }

    public void AQ() {
        this.aub.removeMessages(1);
        this.aub.sendEmptyMessageDelayed(1, this.aui);
    }

    public void setIndicatorVisible(int i) {
        if (this.atX != null) {
            this.atX.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.aui = j;
        AQ();
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
                    CoverFlowView.this.AR();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        int count;
        if (this.atW != null && this.atZ != null && (count = this.atZ.getCount()) > 1) {
            int currentItem = this.atW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.atW.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.atW.setCurrentItem(1, false);
            } else {
                this.atW.setCurrentItem(currentItem + 1);
            }
            this.atW.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AS() {
        int count;
        if (this.atZ != null && (count = this.atZ.getCount()) > 1) {
            int currentItem = this.atW.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.atW.setCurrentItem(i, false);
                this.atW.invalidate();
            } else if (currentItem > i) {
                this.atW.setCurrentItem(1, false);
                this.atW.invalidate();
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
            if (CoverFlowView.this.atX != null && CoverFlowView.this.atZ != null) {
                if (CoverFlowView.this.atZ.getCount() == 1 && i == 0 && CoverFlowView.this.auf != null) {
                    CoverFlowView.this.auf.a(1, CoverFlowView.this.atZ.dd(i));
                }
                if (CoverFlowView.this.atX.getVisibility() == 0 && !CoverFlowView.this.auc) {
                    int count = CoverFlowView.this.atZ.getCount();
                    if (i == 0) {
                        CoverFlowView.this.atX.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.atX.setPosition(f);
                    } else {
                        CoverFlowView.this.atX.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.atZ != null) {
                int count = CoverFlowView.this.atZ.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.auc) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.auf != null) {
                        CoverFlowView.this.auf.a(i, CoverFlowView.this.atZ.dd(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.atW != null && CoverFlowView.this.atZ != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.aue) {
                            CoverFlowView.this.AT();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.aue = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.aue) {
                            CoverFlowView.this.AP();
                            CoverFlowView.this.AS();
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
        int count = this.atZ.getCount();
        if (i == 0) {
            this.atX.setPosition(0.0f);
        } else if (i == count - 1) {
            this.atX.setPosition(i);
        } else {
            this.atX.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AT() {
        if (AS()) {
            AQ();
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
            com.baidu.tbadk.core.flow.a.a dd;
            if (CoverFlowView.this.auf != null && (view.getTag() instanceof Integer) && (dd = CoverFlowView.this.atZ.dd((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.auf.g(intValue, dd.xi());
            }
        }
    }

    public void onChangeSkinType() {
        this.atZ.onChangeSkinType();
        if (this.atX != null && this.atY != null) {
            this.atX.setDrawable(al.getDrawable(this.atY.AU()));
            this.atX.setSelector(al.getDrawable(this.atY.AV()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.atW != null) {
            this.atW.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.atW != null) {
            this.atW.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.auc = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.aud = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.aud;
    }

    private void setAutoPlay(boolean z) {
        this.aue = z;
    }
}
