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
    private ListViewPager abQ;
    private IndicatorView abR;
    private com.baidu.tbadk.core.flow.a.c abS;
    private com.baidu.tbadk.core.flow.a<T> abT;
    private com.baidu.tbadk.core.flow.b abU;
    private CoverFlowView<T>.a abV;
    private d<T> abW;
    private CoverFlowView<T>.c abX;
    private CoverFlowView<T>.b abY;
    private long abZ;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abV = new a();
        this.abX = new c();
        this.abY = new b();
        this.abZ = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abV = new a();
        this.abX = new c();
        this.abY = new b();
        this.abZ = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abV = new a();
        this.abX = new c();
        this.abY = new b();
        this.abZ = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abW = dVar;
    }

    private void init(Context context) {
        az(context);
        aA(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.abQ);
        addView(this.abR);
        this.abT = new com.baidu.tbadk.core.flow.a<>(context);
        this.abT.setOnClickListener(this.abX);
        this.abQ.setAdapter(this.abT);
        this.abQ.setOnPageChangeListener(this.abY);
    }

    private void az(Context context) {
        this.abQ = new ListViewPager(context);
    }

    private void aA(Context context) {
        this.abR = new IndicatorView(context);
        this.abR.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T ct(int i) {
        if (this.abT == null) {
            return null;
        }
        return this.abT.ct(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.abT.a(list, this.abU);
            int size = list.size();
            if (size > 1) {
                this.abR.setVisibility(0);
                this.abR.setCount(size);
                this.abQ.setCurrentItem(1, false);
                this.abR.setPosition(0.0f);
                tp();
                return;
            }
            this.abR.setVisibility(8);
            tq();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abU = bVar;
            this.abS = bVar.tm();
            this.abS.g(this.abR);
            bVar.tn().a(this.abQ);
            this.mCustomView = bVar.to();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.abQ);
                addView(this.mCustomView);
                addView(this.abR);
            }
        }
    }

    public void tp() {
        tr();
    }

    public void tq() {
        this.abV.removeMessages(1);
    }

    public void tr() {
        this.abV.removeMessages(1);
        this.abV.sendEmptyMessageDelayed(1, this.abZ);
    }

    public void setMarqueenTime(long j) {
        this.abZ = j;
        tr();
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
                    CoverFlowView.this.ts();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts() {
        int count;
        if (this.abQ != null && this.abT != null && (count = this.abT.getCount()) > 1) {
            int currentItem = this.abQ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abQ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.abQ.setCurrentItem(1, false);
            } else {
                this.abQ.setCurrentItem(currentItem + 1);
            }
            this.abQ.invalidate();
        }
    }

    private boolean tt() {
        int count;
        if (this.abT != null && (count = this.abT.getCount()) > 1) {
            int currentItem = this.abQ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abQ.setCurrentItem(i, false);
                this.abQ.invalidate();
            } else if (currentItem > i) {
                this.abQ.setCurrentItem(1, false);
                this.abQ.invalidate();
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
            if (CoverFlowView.this.abR != null && CoverFlowView.this.abT != null && CoverFlowView.this.abR.getVisibility() == 0) {
                int count = CoverFlowView.this.abT.getCount();
                if (i == 0) {
                    CoverFlowView.this.abR.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.abR.setPosition(f);
                } else {
                    CoverFlowView.this.abR.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.abT != null) {
                int count = CoverFlowView.this.abT.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abW != null) {
                    CoverFlowView.this.abW.a(i, CoverFlowView.this.abT.ct(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.abQ != null && CoverFlowView.this.abT != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tu();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu() {
        if (tt()) {
            tr();
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
            com.baidu.tbadk.core.flow.a.a ct;
            if (CoverFlowView.this.abW != null && (view.getTag() instanceof Integer) && (ct = CoverFlowView.this.abT.ct((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abW.g(intValue, ct.pG());
            }
        }
    }

    public void onChangeSkinType() {
        this.abT.onChangeSkinType();
        if (this.abR != null && this.abS != null) {
            this.abR.setDrawable(aj.getDrawable(this.abS.tv()));
            this.abR.setSelector(aj.getDrawable(this.abS.tw()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.abQ != null) {
            this.abQ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.abQ != null) {
            this.abQ.setDisableParentEvent(z);
        }
    }
}
