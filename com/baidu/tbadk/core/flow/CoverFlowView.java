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
import com.baidu.adp.widget.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager aQS;
    private IndicatorView aQT;
    private com.baidu.tbadk.core.flow.a.c aQU;
    private com.baidu.tbadk.core.flow.a<T> aQV;
    private com.baidu.tbadk.core.flow.b aQW;
    private CoverFlowView<T>.a aQX;
    private d<T> aQY;
    private CoverFlowView<T>.c aQZ;
    private CoverFlowView<T>.b aRa;
    private long aRb;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aQX = new a();
        this.aQZ = new c();
        this.aRa = new b();
        this.aRb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aQX = new a();
        this.aQZ = new c();
        this.aRa = new b();
        this.aRb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aQX = new a();
        this.aQZ = new c();
        this.aRa = new b();
        this.aRb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aQY = dVar;
    }

    private void init(Context context) {
        aK(context);
        aL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aQS);
        addView(this.aQT);
        this.aQV = new com.baidu.tbadk.core.flow.a<>(context);
        this.aQV.setOnClickListener(this.aQZ);
        this.aQS.setAdapter(this.aQV);
        this.aQS.setOnPageChangeListener(this.aRa);
    }

    private void aK(Context context) {
        this.aQS = new ListViewPager(context);
    }

    private void aL(Context context) {
        this.aQT = new IndicatorView(context);
        this.aQT.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T fr(int i) {
        if (this.aQV == null) {
            return null;
        }
        return this.aQV.fr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aQV.a(list, this.aQW);
            int size = list.size();
            if (size > 1) {
                this.aQT.setVisibility(0);
                this.aQT.setCount(size);
                this.aQS.setCurrentItem(1, false);
                this.aQT.setPosition(0.0f);
                AO();
                return;
            }
            this.aQT.setVisibility(8);
            AP();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aQW = bVar;
            this.aQU = bVar.AL();
            this.aQU.g(this.aQT);
            bVar.AM().a(this.aQS);
            this.mCustomView = bVar.AN();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aQS);
                addView(this.mCustomView);
                addView(this.aQT);
            }
        }
    }

    public void AO() {
        AQ();
    }

    public void AP() {
        this.aQX.removeMessages(1);
    }

    public void AQ() {
        this.aQX.removeMessages(1);
        this.aQX.sendEmptyMessageDelayed(1, this.aRb);
    }

    public void setMarqueenTime(long j) {
        this.aRb = j;
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
        if (this.aQS != null && this.aQV != null && (count = this.aQV.getCount()) > 1) {
            int currentItem = this.aQS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQS.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aQS.setCurrentItem(1, false);
            } else {
                this.aQS.setCurrentItem(currentItem + 1);
            }
            this.aQS.invalidate();
        }
    }

    private boolean AS() {
        int count;
        if (this.aQV != null && (count = this.aQV.getCount()) > 1) {
            int currentItem = this.aQS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQS.setCurrentItem(i, false);
                this.aQS.invalidate();
            } else if (currentItem > i) {
                this.aQS.setCurrentItem(1, false);
                this.aQS.invalidate();
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

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.aQT != null && CoverFlowView.this.aQV != null && CoverFlowView.this.aQT.getVisibility() == 0) {
                int count = CoverFlowView.this.aQV.getCount();
                if (i == 0) {
                    CoverFlowView.this.aQT.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aQT.setPosition(f);
                } else {
                    CoverFlowView.this.aQT.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aQV != null) {
                int count = CoverFlowView.this.aQV.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aQY != null) {
                    CoverFlowView.this.aQY.a(i, CoverFlowView.this.aQV.fr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aQS != null && CoverFlowView.this.aQV != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.AT();
                        return;
                    default:
                        return;
                }
            }
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
            com.baidu.tbadk.core.flow.a.a fr;
            if (CoverFlowView.this.aQY != null && (view.getTag() instanceof Integer) && (fr = CoverFlowView.this.aQV.fr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aQY.f(intValue, fr.xo());
            }
        }
    }

    public void onChangeSkinType() {
        this.aQV.onChangeSkinType();
        if (this.aQT != null && this.aQU != null) {
            this.aQT.setDrawable(aj.getDrawable(this.aQU.AU()));
            this.aQT.setSelector(aj.getDrawable(this.aQU.AV()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aQS != null) {
            this.aQS.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aQS != null) {
            this.aQS.setDisableParentEvent(z);
        }
    }
}
