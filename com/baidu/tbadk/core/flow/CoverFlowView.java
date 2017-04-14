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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager abC;
    private IndicatorView abD;
    private com.baidu.tbadk.core.flow.a.c abE;
    private com.baidu.tbadk.core.flow.a<T> abF;
    private com.baidu.tbadk.core.flow.b abG;
    private CoverFlowView<T>.a abH;
    private d<T> abI;
    private CoverFlowView<T>.c abJ;
    private CoverFlowView<T>.b abK;
    private long abL;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abH = new a(this, null);
        this.abJ = new c(this, null);
        this.abK = new b(this, null);
        this.abL = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abH = new a(this, null);
        this.abJ = new c(this, null);
        this.abK = new b(this, null);
        this.abL = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abH = new a(this, null);
        this.abJ = new c(this, null);
        this.abK = new b(this, null);
        this.abL = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abI = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.abC);
        addView(this.abD);
        this.abF = new com.baidu.tbadk.core.flow.a<>(context);
        this.abF.setOnClickListener(this.abJ);
        this.abC.setAdapter(this.abF);
        this.abC.setOnPageChangeListener(this.abK);
    }

    private void at(Context context) {
        this.abC = new ListViewPager(context);
    }

    private void au(Context context) {
        this.abD = new IndicatorView(context);
        this.abD.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.abF.a(list, this.abG);
            int size = list.size();
            if (size > 1) {
                this.abD.setVisibility(0);
                this.abD.setCount(size);
                this.abC.setCurrentItem(1, false);
                this.abD.setPosition(0.0f);
                ue();
                return;
            }
            this.abD.setVisibility(8);
            uf();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abG = bVar;
            this.abE = bVar.ub();
            this.abE.g(this.abD);
            bVar.uc().b(this.abC);
            this.mCustomView = bVar.ud();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.abC);
                addView(this.mCustomView);
                addView(this.abD);
            }
        }
    }

    public void ue() {
        ug();
    }

    public void uf() {
        this.abH.removeMessages(1);
    }

    public void ug() {
        this.abH.removeMessages(1);
        this.abH.sendEmptyMessageDelayed(1, this.abL);
    }

    public void setMarqueenTime(long j) {
        this.abL = j;
        ug();
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
                    CoverFlowView.this.uh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        int count;
        if (this.abC != null && this.abF != null && (count = this.abF.getCount()) > 1) {
            int currentItem = this.abC.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abC.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.abC.setCurrentItem(1, false);
            } else {
                this.abC.setCurrentItem(currentItem + 1);
            }
            this.abC.invalidate();
        }
    }

    private boolean uj() {
        int count;
        if (this.abF != null && (count = this.abF.getCount()) > 1) {
            int currentItem = this.abC.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abC.setCurrentItem(i, false);
                this.abC.invalidate();
            } else if (currentItem > i) {
                this.abC.setCurrentItem(1, false);
                this.abC.invalidate();
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
            if (CoverFlowView.this.abD != null && CoverFlowView.this.abF != null && CoverFlowView.this.abD.getVisibility() == 0) {
                int count = CoverFlowView.this.abF.getCount();
                if (i == 0) {
                    CoverFlowView.this.abD.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.abD.setPosition(f);
                } else {
                    CoverFlowView.this.abD.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.abF != null) {
                int count = CoverFlowView.this.abF.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abI != null) {
                    CoverFlowView.this.abI.a(i, CoverFlowView.this.abF.cr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.abC == null || CoverFlowView.this.abF == null) {
                return;
            }
            switch (i) {
                case 0:
                    CoverFlowView.this.uk();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk() {
        if (uj()) {
            ug();
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
            com.baidu.tbadk.core.flow.a.a cr;
            if (CoverFlowView.this.abI != null && (view.getTag() instanceof Integer) && (cr = CoverFlowView.this.abF.cr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abI.g(intValue, cr.qr());
            }
        }
    }

    public void onChangeSkinType() {
        this.abF.onChangeSkinType();
        if (this.abD != null && this.abE != null) {
            this.abD.setDrawable(aq.getDrawable(this.abE.ul()));
            this.abD.setSelector(aq.getDrawable(this.abE.um()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.abC != null) {
            this.abC.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.abC != null) {
            this.abC.setDisableParentEvent(z);
        }
    }
}
