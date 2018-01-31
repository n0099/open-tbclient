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
    private ListViewPager aQV;
    private IndicatorView aQW;
    private com.baidu.tbadk.core.flow.a.c aQX;
    private com.baidu.tbadk.core.flow.a<T> aQY;
    private com.baidu.tbadk.core.flow.b aQZ;
    private CoverFlowView<T>.a aRa;
    private d<T> aRb;
    private CoverFlowView<T>.c aRc;
    private CoverFlowView<T>.b aRd;
    private long aRe;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aRa = new a();
        this.aRc = new c();
        this.aRd = new b();
        this.aRe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aRa = new a();
        this.aRc = new c();
        this.aRd = new b();
        this.aRe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aRa = new a();
        this.aRc = new c();
        this.aRd = new b();
        this.aRe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aRb = dVar;
    }

    private void init(Context context) {
        aK(context);
        aL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aQV);
        addView(this.aQW);
        this.aQY = new com.baidu.tbadk.core.flow.a<>(context);
        this.aQY.setOnClickListener(this.aRc);
        this.aQV.setAdapter(this.aQY);
        this.aQV.setOnPageChangeListener(this.aRd);
    }

    private void aK(Context context) {
        this.aQV = new ListViewPager(context);
    }

    private void aL(Context context) {
        this.aQW = new IndicatorView(context);
        this.aQW.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T fr(int i) {
        if (this.aQY == null) {
            return null;
        }
        return this.aQY.fr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aQY.a(list, this.aQZ);
            int size = list.size();
            if (size > 1) {
                this.aQW.setVisibility(0);
                this.aQW.setCount(size);
                this.aQV.setCurrentItem(1, false);
                this.aQW.setPosition(0.0f);
                AP();
                return;
            }
            this.aQW.setVisibility(8);
            AQ();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aQZ = bVar;
            this.aQX = bVar.AM();
            this.aQX.g(this.aQW);
            bVar.AN().a(this.aQV);
            this.mCustomView = bVar.AO();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aQV);
                addView(this.mCustomView);
                addView(this.aQW);
            }
        }
    }

    public void AP() {
        AR();
    }

    public void AQ() {
        this.aRa.removeMessages(1);
    }

    public void AR() {
        this.aRa.removeMessages(1);
        this.aRa.sendEmptyMessageDelayed(1, this.aRe);
    }

    public void setMarqueenTime(long j) {
        this.aRe = j;
        AR();
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
                    CoverFlowView.this.AS();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        int count;
        if (this.aQV != null && this.aQY != null && (count = this.aQY.getCount()) > 1) {
            int currentItem = this.aQV.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQV.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aQV.setCurrentItem(1, false);
            } else {
                this.aQV.setCurrentItem(currentItem + 1);
            }
            this.aQV.invalidate();
        }
    }

    private boolean AT() {
        int count;
        if (this.aQY != null && (count = this.aQY.getCount()) > 1) {
            int currentItem = this.aQV.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQV.setCurrentItem(i, false);
                this.aQV.invalidate();
            } else if (currentItem > i) {
                this.aQV.setCurrentItem(1, false);
                this.aQV.invalidate();
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
            if (CoverFlowView.this.aQW != null && CoverFlowView.this.aQY != null && CoverFlowView.this.aQW.getVisibility() == 0) {
                int count = CoverFlowView.this.aQY.getCount();
                if (i == 0) {
                    CoverFlowView.this.aQW.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aQW.setPosition(f);
                } else {
                    CoverFlowView.this.aQW.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aQY != null) {
                int count = CoverFlowView.this.aQY.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aRb != null) {
                    CoverFlowView.this.aRb.a(i, CoverFlowView.this.aQY.fr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aQV != null && CoverFlowView.this.aQY != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.AU();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        if (AT()) {
            AR();
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
            if (CoverFlowView.this.aRb != null && (view.getTag() instanceof Integer) && (fr = CoverFlowView.this.aQY.fr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aRb.f(intValue, fr.xp());
            }
        }
    }

    public void onChangeSkinType() {
        this.aQY.onChangeSkinType();
        if (this.aQW != null && this.aQX != null) {
            this.aQW.setDrawable(aj.getDrawable(this.aQX.AV()));
            this.aQW.setSelector(aj.getDrawable(this.aQX.AW()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aQV != null) {
            this.aQV.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aQV != null) {
            this.aQV.setDisableParentEvent(z);
        }
    }
}
