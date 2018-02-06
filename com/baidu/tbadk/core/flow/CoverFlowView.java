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
    private IndicatorView aSA;
    private com.baidu.tbadk.core.flow.a.c aSB;
    private com.baidu.tbadk.core.flow.a<T> aSC;
    private com.baidu.tbadk.core.flow.b aSD;
    private CoverFlowView<T>.a aSE;
    private d<T> aSF;
    private CoverFlowView<T>.c aSG;
    private CoverFlowView<T>.b aSH;
    private long aSI;
    private ListViewPager aSz;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.aSE = new a();
        this.aSG = new c();
        this.aSH = new b();
        this.aSI = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.aSE = new a();
        this.aSG = new c();
        this.aSH = new b();
        this.aSI = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.aSE = new a();
        this.aSG = new c();
        this.aSH = new b();
        this.aSI = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.aSF = dVar;
    }

    private void init(Context context) {
        aJ(context);
        aK(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.aSz);
        addView(this.aSA);
        this.aSC = new com.baidu.tbadk.core.flow.a<>(context);
        this.aSC.setOnClickListener(this.aSG);
        this.aSz.setAdapter(this.aSC);
        this.aSz.setOnPageChangeListener(this.aSH);
    }

    private void aJ(Context context) {
        this.aSz = new ListViewPager(context);
    }

    private void aK(Context context) {
        this.aSA = new IndicatorView(context);
        this.aSA.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T fr(int i) {
        if (this.aSC == null) {
            return null;
        }
        return this.aSC.fr(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.aSC.a(list, this.aSD);
            int size = list.size();
            if (size > 1) {
                this.aSA.setVisibility(0);
                this.aSA.setCount(size);
                this.aSz.setCurrentItem(1, false);
                this.aSA.setPosition(0.0f);
                Bi();
                return;
            }
            this.aSA.setVisibility(8);
            Bj();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.aSD = bVar;
            this.aSB = bVar.Bf();
            this.aSB.g(this.aSA);
            bVar.Bg().a(this.aSz);
            this.mCustomView = bVar.Bh();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.aSz);
                addView(this.mCustomView);
                addView(this.aSA);
            }
        }
    }

    public void Bi() {
        Bk();
    }

    public void Bj() {
        this.aSE.removeMessages(1);
    }

    public void Bk() {
        this.aSE.removeMessages(1);
        this.aSE.sendEmptyMessageDelayed(1, this.aSI);
    }

    public void setMarqueenTime(long j) {
        this.aSI = j;
        Bk();
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
                    CoverFlowView.this.Bl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        int count;
        if (this.aSz != null && this.aSC != null && (count = this.aSC.getCount()) > 1) {
            int currentItem = this.aSz.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSz.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.aSz.setCurrentItem(1, false);
            } else {
                this.aSz.setCurrentItem(currentItem + 1);
            }
            this.aSz.invalidate();
        }
    }

    private boolean Bm() {
        int count;
        if (this.aSC != null && (count = this.aSC.getCount()) > 1) {
            int currentItem = this.aSz.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.aSz.setCurrentItem(i, false);
                this.aSz.invalidate();
            } else if (currentItem > i) {
                this.aSz.setCurrentItem(1, false);
                this.aSz.invalidate();
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
            if (CoverFlowView.this.aSA != null && CoverFlowView.this.aSC != null && CoverFlowView.this.aSA.getVisibility() == 0) {
                int count = CoverFlowView.this.aSC.getCount();
                if (i == 0) {
                    CoverFlowView.this.aSA.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.aSA.setPosition(f);
                } else {
                    CoverFlowView.this.aSA.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.aSC != null) {
                int count = CoverFlowView.this.aSC.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.aSF != null) {
                    CoverFlowView.this.aSF.a(i, CoverFlowView.this.aSC.fr(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.aSz != null && CoverFlowView.this.aSC != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.Bn();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        if (Bm()) {
            Bk();
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
            com.baidu.tbadk.core.flow.a.a fr;
            if (CoverFlowView.this.aSF != null && (view.getTag() instanceof Integer) && (fr = CoverFlowView.this.aSC.fr((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.aSF.f(intValue, fr.xV());
            }
        }
    }

    public void onChangeSkinType() {
        this.aSC.onChangeSkinType();
        if (this.aSA != null && this.aSB != null) {
            this.aSA.setDrawable(aj.getDrawable(this.aSB.Bo()));
            this.aSA.setSelector(aj.getDrawable(this.aSB.Bp()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.aSz != null) {
            this.aSz.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.aSz != null) {
            this.aSz.setDisableParentEvent(z);
        }
    }
}
