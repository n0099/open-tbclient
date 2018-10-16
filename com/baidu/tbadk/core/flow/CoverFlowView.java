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
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager atj;
    private IndicatorView atk;
    private com.baidu.tbadk.core.flow.a.c atl;
    private CoverFlowAdapter<T> atm;
    private com.baidu.tbadk.core.flow.a atn;
    private CoverFlowView<T>.a ato;
    private boolean atp;
    private boolean atq;
    private boolean atr;
    private d<T> ats;
    private CoverFlowView<T>.c att;
    private CoverFlowView<T>.b atu;
    private long atv;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.ato = new a();
        this.atp = false;
        this.atq = true;
        this.atr = true;
        this.att = new c();
        this.atu = new b();
        this.atv = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.ato = new a();
        this.atp = false;
        this.atq = true;
        this.atr = true;
        this.att = new c();
        this.atu = new b();
        this.atv = 5000L;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.ato = new a();
        this.atp = false;
        this.atq = true;
        this.atr = true;
        this.att = new c();
        this.atu = new b();
        this.atv = 5000L;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ats = dVar;
    }

    private void init(Context context) {
        bs(context);
        bt(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.atj);
        addView(this.atk);
        this.atm = new CoverFlowAdapter<>(context);
        this.atm.setOnClickListener(this.att);
        this.atj.setAdapter(this.atm);
        this.atj.setOnPageChangeListener(this.atu);
    }

    private void bs(Context context) {
        this.atj = new ListViewPager(context);
    }

    private void bt(Context context) {
        this.atk = new IndicatorView(context);
        this.atk.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cP(int i) {
        if (this.atm == null) {
            return null;
        }
        return this.atm.cP(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.atm.a(list, this.atn);
            int size = list.size();
            if (size > 1) {
                this.atk.setVisibility(0);
                this.atk.setCount(size);
                this.atj.setCurrentItem(1, false);
                this.atk.setPosition(0.0f);
                AH();
                return;
            }
            this.atk.setVisibility(8);
            this.atk.setCount(size);
            this.atj.setCurrentItem(1, false);
            this.atk.setPosition(0.0f);
            AI();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.a aVar) {
        if (aVar != null) {
            this.atn = aVar;
            this.atl = aVar.AE();
            this.atl.g(this.atk);
            aVar.AF().a(this.atj);
            this.mCustomView = aVar.AG();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.atj);
                addView(this.mCustomView);
                addView(this.atk);
            }
        }
    }

    public void AH() {
        AJ();
    }

    public void AI() {
        this.ato.removeMessages(1);
    }

    public void AJ() {
        this.ato.removeMessages(1);
        this.ato.sendEmptyMessageDelayed(1, this.atv);
    }

    public void setIndicatorVisible(int i) {
        if (this.atk != null) {
            this.atk.setVisibility(i);
        }
    }

    public void setMarqueenTime(long j) {
        this.atv = j;
        AJ();
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
                    CoverFlowView.this.AK();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        int count;
        if (this.atj != null && this.atm != null && (count = this.atm.getCount()) > 1) {
            int currentItem = this.atj.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.atj.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.atj.setCurrentItem(1, false);
            } else {
                this.atj.setCurrentItem(currentItem + 1);
            }
            this.atj.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AL() {
        int count;
        if (this.atm != null && (count = this.atm.getCount()) > 1) {
            int currentItem = this.atj.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.atj.setCurrentItem(i, false);
                this.atj.invalidate();
            } else if (currentItem > i) {
                this.atj.setCurrentItem(1, false);
                this.atj.invalidate();
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
            if (CoverFlowView.this.atk != null && CoverFlowView.this.atm != null) {
                if (CoverFlowView.this.atm.getCount() == 1 && i == 0 && CoverFlowView.this.ats != null) {
                    CoverFlowView.this.ats.a(1, CoverFlowView.this.atm.cP(i));
                }
                if (CoverFlowView.this.atk.getVisibility() == 0 && !CoverFlowView.this.atp) {
                    int count = CoverFlowView.this.atm.getCount();
                    if (i == 0) {
                        CoverFlowView.this.atk.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        CoverFlowView.this.atk.setPosition(f);
                    } else {
                        CoverFlowView.this.atk.setPosition((i - 1) + f);
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.atm != null) {
                int count = CoverFlowView.this.atm.getCount();
                if (i >= 0 && i < count) {
                    if (CoverFlowView.this.atp) {
                        CoverFlowView.this.setIndicatorSelected(i);
                    }
                    if (CoverFlowView.this.ats != null) {
                        CoverFlowView.this.ats.a(i, CoverFlowView.this.atm.cP(i));
                    }
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.atj != null && CoverFlowView.this.atm != null) {
                switch (i) {
                    case 0:
                        if (CoverFlowView.this.atr) {
                            CoverFlowView.this.AM();
                            return;
                        }
                        return;
                    case 1:
                        CoverFlowView.this.atr = CoverFlowView.this.getAutoPlayPlayDragging();
                        if (!CoverFlowView.this.atr) {
                            CoverFlowView.this.AI();
                            CoverFlowView.this.AL();
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
        int count = this.atm.getCount();
        if (i == 0) {
            this.atk.setPosition(0.0f);
        } else if (i == count - 1) {
            this.atk.setPosition(i);
        } else {
            this.atk.setPosition(i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM() {
        if (AL()) {
            AJ();
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
            com.baidu.tbadk.core.flow.a.a cP;
            if (CoverFlowView.this.ats != null && (view.getTag() instanceof Integer) && (cP = CoverFlowView.this.atm.cP((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.ats.h(intValue, cP.xa());
            }
        }
    }

    public void onChangeSkinType() {
        this.atm.onChangeSkinType();
        if (this.atk != null && this.atl != null) {
            this.atk.setDrawable(al.getDrawable(this.atl.AN()));
            this.atk.setSelector(al.getDrawable(this.atl.AO()));
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        if (this.atj != null) {
            this.atj.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.atj != null) {
            this.atj.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        this.atp = z;
    }

    public void setIsAutoPlayDragging(boolean z) {
        this.atq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoPlayPlayDragging() {
        return this.atq;
    }

    private void setAutoPlay(boolean z) {
        this.atr = z;
    }
}
