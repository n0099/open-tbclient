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
    private ListViewPager acD;
    private IndicatorView acE;
    private com.baidu.tbadk.core.flow.a.c acF;
    private com.baidu.tbadk.core.flow.a<T> acG;
    private com.baidu.tbadk.core.flow.b acH;
    private CoverFlowView<T>.a acI;
    private d<T> acJ;
    private CoverFlowView<T>.c acK;
    private CoverFlowView<T>.b acL;
    private long acM;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acI = new a();
        this.acK = new c();
        this.acL = new b();
        this.acM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acI = new a();
        this.acK = new c();
        this.acL = new b();
        this.acM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acI = new a();
        this.acK = new c();
        this.acL = new b();
        this.acM = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.acJ = dVar;
    }

    private void init(Context context) {
        ay(context);
        az(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acD);
        addView(this.acE);
        this.acG = new com.baidu.tbadk.core.flow.a<>(context);
        this.acG.setOnClickListener(this.acK);
        this.acD.setAdapter(this.acG);
        this.acD.setOnPageChangeListener(this.acL);
    }

    private void ay(Context context) {
        this.acD = new ListViewPager(context);
    }

    private void az(Context context) {
        this.acE = new IndicatorView(context);
        this.acE.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acG == null) {
            return null;
        }
        return this.acG.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acG.a(list, this.acH);
            int size = list.size();
            if (size > 1) {
                this.acE.setVisibility(0);
                this.acE.setCount(size);
                this.acD.setCurrentItem(1, false);
                this.acE.setPosition(0.0f);
                tw();
                return;
            }
            this.acE.setVisibility(8);
            tx();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acH = bVar;
            this.acF = bVar.tt();
            this.acF.g(this.acE);
            bVar.tu().a(this.acD);
            this.mCustomView = bVar.tv();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acD);
                addView(this.mCustomView);
                addView(this.acE);
            }
        }
    }

    public void tw() {
        ty();
    }

    public void tx() {
        this.acI.removeMessages(1);
    }

    public void ty() {
        this.acI.removeMessages(1);
        this.acI.sendEmptyMessageDelayed(1, this.acM);
    }

    public void setMarqueenTime(long j) {
        this.acM = j;
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
        if (this.acD != null && this.acG != null && (count = this.acG.getCount()) > 1) {
            int currentItem = this.acD.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acD.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acD.setCurrentItem(1, false);
            } else {
                this.acD.setCurrentItem(currentItem + 1);
            }
            this.acD.invalidate();
        }
    }

    private boolean tA() {
        int count;
        if (this.acG != null && (count = this.acG.getCount()) > 1) {
            int currentItem = this.acD.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acD.setCurrentItem(i, false);
                this.acD.invalidate();
            } else if (currentItem > i) {
                this.acD.setCurrentItem(1, false);
                this.acD.invalidate();
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
            if (CoverFlowView.this.acE != null && CoverFlowView.this.acG != null && CoverFlowView.this.acE.getVisibility() == 0) {
                int count = CoverFlowView.this.acG.getCount();
                if (i == 0) {
                    CoverFlowView.this.acE.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acE.setPosition(f);
                } else {
                    CoverFlowView.this.acE.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acG != null) {
                int count = CoverFlowView.this.acG.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.acJ != null) {
                    CoverFlowView.this.acJ.a(i, CoverFlowView.this.acG.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acD != null && CoverFlowView.this.acG != null) {
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
            if (CoverFlowView.this.acJ != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acG.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.acJ.g(intValue, cu.pM());
            }
        }
    }

    public void onChangeSkinType() {
        this.acG.onChangeSkinType();
        if (this.acE != null && this.acF != null) {
            this.acE.setDrawable(aj.getDrawable(this.acF.tC()));
            this.acE.setSelector(aj.getDrawable(this.acF.tD()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acD != null) {
            this.acD.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acD != null) {
            this.acD.setDisableParentEvent(z);
        }
    }
}
