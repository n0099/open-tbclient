package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.square.SquareViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private SquareViewPager XB;
    private IndicatorView XC;
    private com.baidu.tbadk.core.flow.a.c XD;
    private com.baidu.tbadk.core.flow.a<T> XE;
    private com.baidu.tbadk.core.flow.b XF;
    private CoverFlowView<T>.a XG;
    private d<T> XH;
    private CoverFlowView<T>.c XI;
    private CoverFlowView<T>.b XJ;
    private long XK;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.XG = new a(this, null);
        this.XI = new c(this, null);
        this.XJ = new b(this, null);
        this.XK = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.XG = new a(this, null);
        this.XI = new c(this, null);
        this.XJ = new b(this, null);
        this.XK = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.XG = new a(this, null);
        this.XI = new c(this, null);
        this.XJ = new b(this, null);
        this.XK = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.XH = dVar;
    }

    private void init(Context context) {
        L(context);
        M(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.XB);
        addView(this.XC);
        this.XE = new com.baidu.tbadk.core.flow.a<>(context);
        this.XE.setOnClickListener(this.XI);
        this.XB.setAdapter(this.XE);
        this.XB.setOnPageChangeListener(this.XJ);
    }

    private void L(Context context) {
        this.XB = new SquareViewPager(context);
    }

    private void M(Context context) {
        this.XC = new IndicatorView(context);
        this.XC.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.XE.a(list, this.XF);
            int size = list.size();
            if (size > 1) {
                this.XC.setVisibility(0);
                this.XC.setCount(size);
                this.XB.setCurrentItem(1, false);
                this.XC.setPosition(0.0f);
                uE();
                return;
            }
            this.XC.setVisibility(8);
            uF();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.XF = bVar;
            this.XD = bVar.uB();
            this.XD.g(this.XC);
            bVar.uC().a(this.XB);
            this.mCustomView = bVar.uD();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.XB);
                addView(this.mCustomView);
                addView(this.XC);
            }
        }
    }

    public void uE() {
        uG();
    }

    public void uF() {
        this.XG.removeMessages(1);
    }

    public void uG() {
        this.XG.removeMessages(1);
        this.XG.sendEmptyMessageDelayed(1, this.XK);
    }

    public void setMarqueenTime(long j) {
        this.XK = j;
        uG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(CoverFlowView coverFlowView, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    CoverFlowView.this.uH();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH() {
        int count;
        if (this.XB != null && this.XE != null && (count = this.XE.getCount()) > 1) {
            int currentItem = this.XB.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.XB.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.XB.setCurrentItem(1, false);
            } else {
                this.XB.setCurrentItem(currentItem + 1);
            }
            this.XB.invalidate();
        }
    }

    private boolean uI() {
        int count;
        if (this.XE != null && (count = this.XE.getCount()) > 1) {
            int currentItem = this.XB.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.XB.setCurrentItem(i, false);
                this.XB.invalidate();
            } else if (currentItem > i) {
                this.XB.setCurrentItem(1, false);
                this.XB.invalidate();
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

        /* synthetic */ b(CoverFlowView coverFlowView, b bVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.XC != null && CoverFlowView.this.XE != null && CoverFlowView.this.XC.getVisibility() == 0) {
                int count = CoverFlowView.this.XE.getCount();
                if (i == 0) {
                    CoverFlowView.this.XC.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.XC.setPosition(f);
                } else {
                    CoverFlowView.this.XC.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.XE != null) {
                int count = CoverFlowView.this.XE.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.XH != null) {
                    CoverFlowView.this.XH.a(i, CoverFlowView.this.XE.cs(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.XB == null || CoverFlowView.this.XE == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.uJ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ() {
        if (uI()) {
            uG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(CoverFlowView coverFlowView, c cVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            com.baidu.tbadk.core.flow.a.a cs;
            if (CoverFlowView.this.XH != null && (view.getTag() instanceof Integer) && (cs = CoverFlowView.this.XE.cs((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.XH.g(intValue, cs.rA());
            }
        }
    }

    public void uA() {
        this.XE.uA();
        if (this.XC != null && this.XD != null) {
            this.XC.setDrawable(at.getDrawable(this.XD.uK()));
            this.XC.setSelector(at.getDrawable(this.XD.uL()));
        }
    }

    public void setSwipeControlInterface(f.b bVar) {
        if (this.XB != null) {
            this.XB.setSwipeControlInterface(bVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.XB != null) {
            this.XB.setDisableParentEvent(z);
        }
    }
}
