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
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager bFS;
    private IndicatorView bFT;
    private com.baidu.tbadk.core.flow.a.c bFU;
    private CoverFlowAdapter<T> bFV;
    private com.baidu.tbadk.core.flow.a bFW;
    private CoverFlowView<T>.a bFX;
    private boolean bFY;
    private boolean bFZ;
    private boolean bGa;
    private d<T> bGb;
    private CoverFlowView<T>.c bGc;
    private CoverFlowView<T>.b bGd;
    private long bGe;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.bFX = new a();
        this.bFY = false;
        this.bFZ = true;
        this.bGa = true;
        this.bGc = new c();
        this.bGd = new b();
        this.bGe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.bFX = new a();
        this.bFY = false;
        this.bFZ = true;
        this.bGa = true;
        this.bGc = new c();
        this.bGd = new b();
        this.bGe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.bFX = new a();
        this.bFY = false;
        this.bFZ = true;
        this.bGa = true;
        this.bGc = new c();
        this.bGd = new b();
        this.bGe = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.bGb = dVar;
    }

    private void init(Context context) {
        cH(context);
        cI(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.bFS);
        addView(this.bFT);
        this.bFV = new CoverFlowAdapter<>(context);
        this.bFV.setOnClickListener(this.bGc);
        this.bFS.setAdapter(this.bFV);
        this.bFS.setOnPageChangeListener(this.bGd);
    }

    private void cH(Context context) {
        this.bFS = new ListViewPager(context);
    }

    private void cI(Context context) {
        this.bFT = new IndicatorView(context);
        this.bFT.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T gT(int i) {
        if (this.bFV == null) {
            return null;
        }
        return this.bFV.gT(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.bFV.a(list, this.bFW);
            int size = list.size();
            if (size > 1) {
                this.bFT.setVisibility(0);
                this.bFT.setCount(size);
                this.bFS.setCurrentItem(1, false);
                this.bFT.setPosition(0.0f);
                abp();
                return;
            }
            this.bFT.setVisibility(8);
            this.bFT.setCount(size);
            this.bFS.setCurrentItem(1, false);
            this.bFT.setPosition(0.0f);
            abq();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.bFW = aVar;
            this.bFU = aVar.abm();
            this.bFU.g(this.bFT);
            aVar.abn().a(this.bFS);
            this.mCustomView = aVar.abo();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.bFS);
                addView(this.mCustomView);
                addView(this.bFT);
            }
        }
    }

    public void abp() {
        abr();
    }

    public void abq() {
        this.bFX.removeMessages(1);
    }

    public void abr() {
        this.bFX.removeMessages(1);
        this.bFX.sendEmptyMessageDelayed(1, this.bGe);
    }

    public void setIndicatorVisible(int i) {
        if (this.bFT != null) {
            this.bFT.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.bGe = j;
        abr();
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
                    CoverFlowView.this.abs();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abs() {
        int count;
        if (this.bFS != null && this.bFV != null && (count = this.bFV.getCount()) > 1) {
            int currentItem = this.bFS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFS.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.bFS.setCurrentItem(1, false);
            } else {
                this.bFS.setCurrentItem(currentItem + 1);
            }
            this.bFS.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abt() {
        int count;
        if (this.bFV != null && (count = this.bFV.getCount()) > 1) {
            int currentItem = this.bFS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.bFS.setCurrentItem(i, false);
                this.bFS.invalidate();
            } else if (currentItem > i) {
                this.bFS.setCurrentItem(1, false);
                this.bFS.invalidate();
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v26, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CoverFlowView.this.bFT != null && CoverFlowView.this.bFV != null) {
                if (CoverFlowView.this.bFV.getCount() == 1 && i == 0 && CoverFlowView.this.bGb != null) {
                    CoverFlowView.this.bGb.a(1, CoverFlowView.this.bFV.gT(i));
                }
                if (CoverFlowView.this.bFT.getVisibility() == 0 && !CoverFlowView.this.bFY) {
                    int count = CoverFlowView.this.bFV.getCount();
                    if (i == 0) {
                        CoverFlowView.this.bFT.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.bFT.setPosition(f);
                    } else {
                        CoverFlowView.this.bFT.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.bFV != null) {
                int count = CoverFlowView.this.bFV.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.bFY) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.bGb != null) {
                        CoverFlowView.this.bGb.a(i, CoverFlowView.this.bFV.gT(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.bFS != null && CoverFlowView.this.bFV != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.bGa) {
                            CoverFlowView.this.abu();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.bGa = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.bGa) {
                            CoverFlowView.this.abq();
                            CoverFlowView.this.abt();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        int count = this.bFV.getCount();
        if (i == 0) {
            this.bFT.setPosition(0.0f);
        } else if (i == count - 1) {
            this.bFT.setPosition(i);
        } else {
            this.bFT.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        if (abt()) {
            abr();
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
            com.baidu.tbadk.core.flow.a.a gT;
            if (CoverFlowView.this.bGb != null && (view.getTag() instanceof Integer) && (gT = CoverFlowView.this.bFV.gT((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.bGb.y(intValue, gT.Xi());
            }
        }
    }

    public void onChangeSkinType() {
        this.bFV.onChangeSkinType();
        if (this.bFT != null && this.bFU != null) {
            this.bFT.setDrawable(al.getDrawable(this.bFU.abv()));
            this.bFT.setSelector(al.getDrawable(this.bFU.abw()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.bFS != null) {
            this.bFS.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.bFS != null) {
            this.bFS.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.bFY = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.bFZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.bFZ;
    }

    private void setAutoPlay(boolean z) {
        this.bGa = z;
    }
}
