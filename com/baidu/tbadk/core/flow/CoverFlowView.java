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
    private ListViewPager aQT;
    private IndicatorView aQU;
    private com.baidu.tbadk.core.flow.a.c aQV;
    private com.baidu.tbadk.core.flow.a<T> aQW;
    private com.baidu.tbadk.core.flow.b aQX;
    private CoverFlowView<T>.a aQY;
    private d<T> aQZ;
    private CoverFlowView<T>.c aRa;
    private CoverFlowView<T>.b aRb;
    private long aRc;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aQY = new a();
        this.aRa = new c();
        this.aRb = new b();
        this.aRc = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aQY = new a();
        this.aRa = new c();
        this.aRb = new b();
        this.aRc = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aQY = new a();
        this.aRa = new c();
        this.aRb = new b();
        this.aRc = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aQZ = dVar;
    }

    private void init(Context context) {
        aK(context);
        aL(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aQT);
        addView(this.aQU);
        this.aQW = new com.baidu.tbadk.core.flow.a<>(context);
        this.aQW.setOnClickListener(this.aRa);
        this.aQT.setAdapter(this.aQW);
        this.aQT.setOnPageChangeListener(this.aRb);
    }

    private void aK(Context context) {
        this.aQT = new ListViewPager(context);
    }

    private void aL(Context context) {
        this.aQU = new IndicatorView(context);
        this.aQU.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ft(int i) {
        if (this.aQW == null) {
            return null;
        }
        return this.aQW.ft(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aQW.a(list, this.aQX);
            int size = list.size();
            if (size > 1) {
                this.aQU.setVisibility(0);
                this.aQU.setCount(size);
                this.aQT.setCurrentItem(1, false);
                this.aQU.setPosition(0.0f);
                AW();
                return;
            }
            this.aQU.setVisibility(8);
            AX();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aQX = bVar;
            this.aQV = bVar.AT();
            this.aQV.g(this.aQU);
            bVar.AU().a(this.aQT);
            this.mCustomView = bVar.AV();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aQT);
                addView(this.mCustomView);
                addView(this.aQU);
            }
        }
    }

    public void AW() {
        AY();
    }

    public void AX() {
        this.aQY.removeMessages(1);
    }

    public void AY() {
        this.aQY.removeMessages(1);
        this.aQY.sendEmptyMessageDelayed(1, this.aRc);
    }

    public void setMarqueenTime(long j) {
        this.aRc = j;
        AY();
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
                    CoverFlowView.this.AZ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        int count;
        if (this.aQT != null && this.aQW != null && (count = this.aQW.getCount()) > 1) {
            int currentItem = this.aQT.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQT.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aQT.setCurrentItem(1, false);
            } else {
                this.aQT.setCurrentItem(currentItem + 1);
            }
            this.aQT.invalidate();
        }
    }

    private boolean Ba() {
        int count;
        if (this.aQW != null && (count = this.aQW.getCount()) > 1) {
            int currentItem = this.aQT.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aQT.setCurrentItem(i, false);
                this.aQT.invalidate();
            } else if (currentItem > i) {
                this.aQT.setCurrentItem(1, false);
                this.aQT.invalidate();
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
            if (CoverFlowView.this.aQU != null && CoverFlowView.this.aQW != null && CoverFlowView.this.aQU.getVisibility() == 0) {
                int count = CoverFlowView.this.aQW.getCount();
                if (i == 0) {
                    CoverFlowView.this.aQU.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aQU.setPosition(f);
                } else {
                    CoverFlowView.this.aQU.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aQW != null) {
                int count = CoverFlowView.this.aQW.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aQZ != null) {
                    CoverFlowView.this.aQZ.a(i, CoverFlowView.this.aQW.ft(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aQT != null && CoverFlowView.this.aQW != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.Bb();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        if (Ba()) {
            AY();
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
            com.baidu.tbadk.core.flow.a.a ft;
            if (CoverFlowView.this.aQZ != null && (view.getTag() instanceof Integer) && (ft = CoverFlowView.this.aQW.ft((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aQZ.f(intValue, ft.xp());
            }
        }
    }

    public void onChangeSkinType() {
        this.aQW.onChangeSkinType();
        if (this.aQU != null && this.aQV != null) {
            this.aQU.setDrawable(aj.getDrawable(this.aQV.Bc()));
            this.aQU.setSelector(aj.getDrawable(this.aQV.Bd()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aQT != null) {
            this.aQT.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aQT != null) {
            this.aQT.setDisableParentEvent(z);
        }
    }
}
