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
    private ListViewPager abD;
    private IndicatorView abE;
    private com.baidu.tbadk.core.flow.a.c abF;
    private com.baidu.tbadk.core.flow.a<T> abG;
    private com.baidu.tbadk.core.flow.b abH;
    private CoverFlowView<T>.a abI;
    private d<T> abJ;
    private CoverFlowView<T>.c abK;
    private CoverFlowView<T>.b abL;
    private long abM;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.abI = new a(this, null);
        this.abK = new c(this, null);
        this.abL = new b(this, null);
        this.abM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.abI = new a(this, null);
        this.abK = new c(this, null);
        this.abL = new b(this, null);
        this.abM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.abI = new a(this, null);
        this.abK = new c(this, null);
        this.abL = new b(this, null);
        this.abM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.abJ = dVar;
    }

    private void init(Context context) {
        at(context);
        au(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.abD);
        addView(this.abE);
        this.abG = new com.baidu.tbadk.core.flow.a<>(context);
        this.abG.setOnClickListener(this.abK);
        this.abD.setAdapter(this.abG);
        this.abD.setOnPageChangeListener(this.abL);
    }

    private void at(Context context) {
        this.abD = new ListViewPager(context);
    }

    private void au(Context context) {
        this.abE = new IndicatorView(context);
        this.abE.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.abG.a(list, this.abH);
            int size = list.size();
            if (size > 1) {
                this.abE.setVisibility(0);
                this.abE.setCount(size);
                this.abD.setCurrentItem(1, false);
                this.abE.setPosition(0.0f);
                ue();
                return;
            }
            this.abE.setVisibility(8);
            uf();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.abH = bVar;
            this.abF = bVar.ub();
            this.abF.g(this.abE);
            bVar.uc().b(this.abD);
            this.mCustomView = bVar.ud();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.abD);
                addView(this.mCustomView);
                addView(this.abE);
            }
        }
    }

    public void ue() {
        ug();
    }

    public void uf() {
        this.abI.removeMessages(1);
    }

    public void ug() {
        this.abI.removeMessages(1);
        this.abI.sendEmptyMessageDelayed(1, this.abM);
    }

    public void setMarqueenTime(long j) {
        this.abM = j;
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
        if (this.abD != null && this.abG != null && (count = this.abG.getCount()) > 1) {
            int currentItem = this.abD.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abD.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.abD.setCurrentItem(1, false);
            } else {
                this.abD.setCurrentItem(currentItem + 1);
            }
            this.abD.invalidate();
        }
    }

    private boolean uj() {
        int count;
        if (this.abG != null && (count = this.abG.getCount()) > 1) {
            int currentItem = this.abD.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.abD.setCurrentItem(i, false);
                this.abD.invalidate();
            } else if (currentItem > i) {
                this.abD.setCurrentItem(1, false);
                this.abD.invalidate();
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
            if (CoverFlowView.this.abE != null && CoverFlowView.this.abG != null && CoverFlowView.this.abE.getVisibility() == 0) {
                int count = CoverFlowView.this.abG.getCount();
                if (i == 0) {
                    CoverFlowView.this.abE.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.abE.setPosition(f);
                } else {
                    CoverFlowView.this.abE.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.abG != null) {
                int count = CoverFlowView.this.abG.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.abJ != null) {
                    CoverFlowView.this.abJ.a(i, CoverFlowView.this.abG.cr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.abD == null || CoverFlowView.this.abG == null) {
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
            if (CoverFlowView.this.abJ != null && (view.getTag() instanceof Integer) && (cr = CoverFlowView.this.abG.cr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.abJ.g(intValue, cr.qr());
            }
        }
    }

    public void onChangeSkinType() {
        this.abG.onChangeSkinType();
        if (this.abE != null && this.abF != null) {
            this.abE.setDrawable(aq.getDrawable(this.abF.ul()));
            this.abE.setSelector(aq.getDrawable(this.abF.um()));
        }
    }

    public void setSwipeControlInterface(f.c cVar) {
        if (this.abD != null) {
            this.abD.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.abD != null) {
            this.abD.setDisableParentEvent(z);
        }
    }
}
