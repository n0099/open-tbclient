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
    private ListViewPager acJ;
    private IndicatorView acK;
    private com.baidu.tbadk.core.flow.a.c acL;
    private com.baidu.tbadk.core.flow.a<T> acM;
    private com.baidu.tbadk.core.flow.b acN;
    private CoverFlowView<T>.a acO;
    private d<T> acP;
    private CoverFlowView<T>.c acQ;
    private CoverFlowView<T>.b acR;
    private long acS;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acO = new a();
        this.acQ = new c();
        this.acR = new b();
        this.acS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acO = new a();
        this.acQ = new c();
        this.acR = new b();
        this.acS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acO = new a();
        this.acQ = new c();
        this.acR = new b();
        this.acS = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.acP = dVar;
    }

    private void init(Context context) {
        aB(context);
        aC(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acJ);
        addView(this.acK);
        this.acM = new com.baidu.tbadk.core.flow.a<>(context);
        this.acM.setOnClickListener(this.acQ);
        this.acJ.setAdapter(this.acM);
        this.acJ.setOnPageChangeListener(this.acR);
    }

    private void aB(Context context) {
        this.acJ = new ListViewPager(context);
    }

    private void aC(Context context) {
        this.acK = new IndicatorView(context);
        this.acK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acM == null) {
            return null;
        }
        return this.acM.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acM.a(list, this.acN);
            int size = list.size();
            if (size > 1) {
                this.acK.setVisibility(0);
                this.acK.setCount(size);
                this.acJ.setCurrentItem(1, false);
                this.acK.setPosition(0.0f);
                tz();
                return;
            }
            this.acK.setVisibility(8);
            tA();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acN = bVar;
            this.acL = bVar.tw();
            this.acL.g(this.acK);
            bVar.tx().a(this.acJ);
            this.mCustomView = bVar.ty();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acJ);
                addView(this.mCustomView);
                addView(this.acK);
            }
        }
    }

    public void tz() {
        tB();
    }

    public void tA() {
        this.acO.removeMessages(1);
    }

    public void tB() {
        this.acO.removeMessages(1);
        this.acO.sendEmptyMessageDelayed(1, this.acS);
    }

    public void setMarqueenTime(long j) {
        this.acS = j;
        tB();
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
                    CoverFlowView.this.tC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC() {
        int count;
        if (this.acJ != null && this.acM != null && (count = this.acM.getCount()) > 1) {
            int currentItem = this.acJ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acJ.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acJ.setCurrentItem(1, false);
            } else {
                this.acJ.setCurrentItem(currentItem + 1);
            }
            this.acJ.invalidate();
        }
    }

    private boolean tD() {
        int count;
        if (this.acM != null && (count = this.acM.getCount()) > 1) {
            int currentItem = this.acJ.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acJ.setCurrentItem(i, false);
                this.acJ.invalidate();
            } else if (currentItem > i) {
                this.acJ.setCurrentItem(1, false);
                this.acJ.invalidate();
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
            if (CoverFlowView.this.acK != null && CoverFlowView.this.acM != null && CoverFlowView.this.acK.getVisibility() == 0) {
                int count = CoverFlowView.this.acM.getCount();
                if (i == 0) {
                    CoverFlowView.this.acK.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acK.setPosition(f);
                } else {
                    CoverFlowView.this.acK.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acM != null) {
                int count = CoverFlowView.this.acM.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.acP != null) {
                    CoverFlowView.this.acP.a(i, CoverFlowView.this.acM.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acJ != null && CoverFlowView.this.acM != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tE();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        if (tD()) {
            tB();
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
            com.baidu.tbadk.core.flow.a.a cu;
            if (CoverFlowView.this.acP != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acM.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.acP.g(intValue, cu.pO());
            }
        }
    }

    public void onChangeSkinType() {
        this.acM.onChangeSkinType();
        if (this.acK != null && this.acL != null) {
            this.acK.setDrawable(aj.getDrawable(this.acL.tF()));
            this.acK.setSelector(aj.getDrawable(this.acL.tG()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acJ != null) {
            this.acJ.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acJ != null) {
            this.acJ.setDisableParentEvent(z);
        }
    }
}
