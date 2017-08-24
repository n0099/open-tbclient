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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowView<T extends com.baidu.tbadk.core.flow.a.a> extends FrameLayout {
    private ListViewPager acU;
    private IndicatorView acV;
    private com.baidu.tbadk.core.flow.a.c acW;
    private com.baidu.tbadk.core.flow.a<T> acX;
    private com.baidu.tbadk.core.flow.b acY;
    private CoverFlowView<T>.a acZ;
    private d<T> ada;
    private CoverFlowView<T>.c adb;
    private CoverFlowView<T>.b adc;
    private long ade;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acZ = new a();
        this.adb = new c();
        this.adc = new b();
        this.ade = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acZ = new a();
        this.adb = new c();
        this.adc = new b();
        this.ade = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acZ = new a();
        this.adb = new c();
        this.adc = new b();
        this.ade = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.ada = dVar;
    }

    private void init(Context context) {
        au(context);
        av(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acU);
        addView(this.acV);
        this.acX = new com.baidu.tbadk.core.flow.a<>(context);
        this.acX.setOnClickListener(this.adb);
        this.acU.setAdapter(this.acX);
        this.acU.setOnPageChangeListener(this.adc);
    }

    private void au(Context context) {
        this.acU = new ListViewPager(context);
    }

    private void av(Context context) {
        this.acV = new IndicatorView(context);
        this.acV.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acX == null) {
            return null;
        }
        return this.acX.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acX.a(list, this.acY);
            int size = list.size();
            if (size > 1) {
                this.acV.setVisibility(0);
                this.acV.setCount(size);
                this.acU.setCurrentItem(1, false);
                this.acV.setPosition(0.0f);
                tG();
                return;
            }
            this.acV.setVisibility(8);
            tH();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acY = bVar;
            this.acW = bVar.tD();
            this.acW.g(this.acV);
            bVar.tE().b(this.acU);
            this.mCustomView = bVar.tF();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acU);
                addView(this.mCustomView);
                addView(this.acV);
            }
        }
    }

    public void tG() {
        tI();
    }

    public void tH() {
        this.acZ.removeMessages(1);
    }

    public void tI() {
        this.acZ.removeMessages(1);
        this.acZ.sendEmptyMessageDelayed(1, this.ade);
    }

    public void setMarqueenTime(long j) {
        this.ade = j;
        tI();
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
                    CoverFlowView.this.tJ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        int count;
        if (this.acU != null && this.acX != null && (count = this.acX.getCount()) > 1) {
            int currentItem = this.acU.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acU.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acU.setCurrentItem(1, false);
            } else {
                this.acU.setCurrentItem(currentItem + 1);
            }
            this.acU.invalidate();
        }
    }

    private boolean tK() {
        int count;
        if (this.acX != null && (count = this.acX.getCount()) > 1) {
            int currentItem = this.acU.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acU.setCurrentItem(i, false);
                this.acU.invalidate();
            } else if (currentItem > i) {
                this.acU.setCurrentItem(1, false);
                this.acU.invalidate();
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
            if (CoverFlowView.this.acV != null && CoverFlowView.this.acX != null && CoverFlowView.this.acV.getVisibility() == 0) {
                int count = CoverFlowView.this.acX.getCount();
                if (i == 0) {
                    CoverFlowView.this.acV.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acV.setPosition(f);
                } else {
                    CoverFlowView.this.acV.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acX != null) {
                int count = CoverFlowView.this.acX.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.ada != null) {
                    CoverFlowView.this.ada.a(i, CoverFlowView.this.acX.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acU != null && CoverFlowView.this.acX != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tL();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL() {
        if (tK()) {
            tI();
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
            if (CoverFlowView.this.ada != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acX.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.ada.g(intValue, cu.pR());
            }
        }
    }

    public void onChangeSkinType() {
        this.acX.onChangeSkinType();
        if (this.acV != null && this.acW != null) {
            this.acV.setDrawable(ai.getDrawable(this.acW.tM()));
            this.acV.setSelector(ai.getDrawable(this.acW.tN()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acU != null) {
            this.acU.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acU != null) {
            this.acU.setDisableParentEvent(z);
        }
    }
}
