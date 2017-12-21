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
    private ListViewPager acG;
    private IndicatorView acH;
    private com.baidu.tbadk.core.flow.a.c acI;
    private com.baidu.tbadk.core.flow.a<T> acJ;
    private com.baidu.tbadk.core.flow.b acK;
    private CoverFlowView<T>.a acL;
    private d<T> acM;
    private CoverFlowView<T>.c acN;
    private CoverFlowView<T>.b acO;
    private long acP;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acL = new a();
        this.acN = new c();
        this.acO = new b();
        this.acP = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acL = new a();
        this.acN = new c();
        this.acO = new b();
        this.acP = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acL = new a();
        this.acN = new c();
        this.acO = new b();
        this.acP = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.acM = dVar;
    }

    private void init(Context context) {
        ay(context);
        az(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acG);
        addView(this.acH);
        this.acJ = new com.baidu.tbadk.core.flow.a<>(context);
        this.acJ.setOnClickListener(this.acN);
        this.acG.setAdapter(this.acJ);
        this.acG.setOnPageChangeListener(this.acO);
    }

    private void ay(Context context) {
        this.acG = new ListViewPager(context);
    }

    private void az(Context context) {
        this.acH = new IndicatorView(context);
        this.acH.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acJ == null) {
            return null;
        }
        return this.acJ.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acJ.a(list, this.acK);
            int size = list.size();
            if (size > 1) {
                this.acH.setVisibility(0);
                this.acH.setCount(size);
                this.acG.setCurrentItem(1, false);
                this.acH.setPosition(0.0f);
                tw();
                return;
            }
            this.acH.setVisibility(8);
            tx();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acK = bVar;
            this.acI = bVar.tt();
            this.acI.g(this.acH);
            bVar.tu().a(this.acG);
            this.mCustomView = bVar.tv();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acG);
                addView(this.mCustomView);
                addView(this.acH);
            }
        }
    }

    public void tw() {
        ty();
    }

    public void tx() {
        this.acL.removeMessages(1);
    }

    public void ty() {
        this.acL.removeMessages(1);
        this.acL.sendEmptyMessageDelayed(1, this.acP);
    }

    public void setMarqueenTime(long j) {
        this.acP = j;
        ty();
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
                    CoverFlowView.this.tz();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        int count;
        if (this.acG != null && this.acJ != null && (count = this.acJ.getCount()) > 1) {
            int currentItem = this.acG.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acG.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acG.setCurrentItem(1, false);
            } else {
                this.acG.setCurrentItem(currentItem + 1);
            }
            this.acG.invalidate();
        }
    }

    private boolean tA() {
        int count;
        if (this.acJ != null && (count = this.acJ.getCount()) > 1) {
            int currentItem = this.acG.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acG.setCurrentItem(i, false);
                this.acG.invalidate();
            } else if (currentItem > i) {
                this.acG.setCurrentItem(1, false);
                this.acG.invalidate();
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
            if (CoverFlowView.this.acH != null && CoverFlowView.this.acJ != null && CoverFlowView.this.acH.getVisibility() == 0) {
                int count = CoverFlowView.this.acJ.getCount();
                if (i == 0) {
                    CoverFlowView.this.acH.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acH.setPosition(f);
                } else {
                    CoverFlowView.this.acH.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acJ != null) {
                int count = CoverFlowView.this.acJ.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.acM != null) {
                    CoverFlowView.this.acM.a(i, CoverFlowView.this.acJ.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acG != null && CoverFlowView.this.acJ != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tB();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB() {
        if (tA()) {
            ty();
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
            if (CoverFlowView.this.acM != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acJ.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.acM.g(intValue, cu.pM());
            }
        }
    }

    public void onChangeSkinType() {
        this.acJ.onChangeSkinType();
        if (this.acH != null && this.acI != null) {
            this.acH.setDrawable(aj.getDrawable(this.acI.tC()));
            this.acH.setSelector(aj.getDrawable(this.acI.tD()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acG != null) {
            this.acG.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acG != null) {
            this.acG.setDisableParentEvent(z);
        }
    }
}
