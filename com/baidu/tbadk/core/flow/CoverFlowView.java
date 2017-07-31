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
    private ListViewPager acS;
    private IndicatorView acT;
    private com.baidu.tbadk.core.flow.a.c acU;
    private com.baidu.tbadk.core.flow.a<T> acV;
    private com.baidu.tbadk.core.flow.b acW;
    private CoverFlowView<T>.a acX;
    private d<T> acY;
    private CoverFlowView<T>.c acZ;
    private CoverFlowView<T>.b ada;
    private long adb;
    private View mCustomView;

    public CoverFlowView(Context context) {
        super(context);
        this.mCustomView = null;
        this.acX = new a();
        this.acZ = new c();
        this.ada = new b();
        this.adb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomView = null;
        this.acX = new a();
        this.acZ = new c();
        this.ada = new b();
        this.adb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCustomView = null;
        this.acX = new a();
        this.acZ = new c();
        this.ada = new b();
        this.adb = TbConfig.NOTIFY_SOUND_INTERVAL;
        init(context);
    }

    public void setCallback(d<T> dVar) {
        this.acY = dVar;
    }

    private void init(Context context) {
        au(context);
        av(context);
        setCoverFlowFactory(new com.baidu.tbadk.core.flow.a.b());
        addView(this.acS);
        addView(this.acT);
        this.acV = new com.baidu.tbadk.core.flow.a<>(context);
        this.acV.setOnClickListener(this.acZ);
        this.acS.setAdapter(this.acV);
        this.acS.setOnPageChangeListener(this.ada);
    }

    private void au(Context context) {
        this.acS = new ListViewPager(context);
    }

    private void av(Context context) {
        this.acT = new IndicatorView(context);
        this.acT.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public T cu(int i) {
        if (this.acV == null) {
            return null;
        }
        return this.acV.cu(i);
    }

    public void setData(List<T> list) {
        if (list != null && !list.isEmpty()) {
            this.acV.a(list, this.acW);
            int size = list.size();
            if (size > 1) {
                this.acT.setVisibility(0);
                this.acT.setCount(size);
                this.acS.setCurrentItem(1, false);
                this.acT.setPosition(0.0f);
                tF();
                return;
            }
            this.acT.setVisibility(8);
            tG();
        }
    }

    public void setCoverFlowFactory(com.baidu.tbadk.core.flow.b bVar) {
        if (bVar != null) {
            this.acW = bVar;
            this.acU = bVar.tC();
            this.acU.g(this.acT);
            bVar.tD().b(this.acS);
            this.mCustomView = bVar.tE();
            if (this.mCustomView != null) {
                removeAllViews();
                addView(this.acS);
                addView(this.mCustomView);
                addView(this.acT);
            }
        }
    }

    public void tF() {
        tH();
    }

    public void tG() {
        this.acX.removeMessages(1);
    }

    public void tH() {
        this.acX.removeMessages(1);
        this.acX.sendEmptyMessageDelayed(1, this.adb);
    }

    public void setMarqueenTime(long j) {
        this.adb = j;
        tH();
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
                    CoverFlowView.this.tI();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        int count;
        if (this.acS != null && this.acV != null && (count = this.acV.getCount()) > 1) {
            int currentItem = this.acS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acS.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.acS.setCurrentItem(1, false);
            } else {
                this.acS.setCurrentItem(currentItem + 1);
            }
            this.acS.invalidate();
        }
    }

    private boolean tJ() {
        int count;
        if (this.acV != null && (count = this.acV.getCount()) > 1) {
            int currentItem = this.acS.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.acS.setCurrentItem(i, false);
                this.acS.invalidate();
            } else if (currentItem > i) {
                this.acS.setCurrentItem(1, false);
                this.acS.invalidate();
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
            if (CoverFlowView.this.acT != null && CoverFlowView.this.acV != null && CoverFlowView.this.acT.getVisibility() == 0) {
                int count = CoverFlowView.this.acV.getCount();
                if (i == 0) {
                    CoverFlowView.this.acT.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CoverFlowView.this.acT.setPosition(f);
                } else {
                    CoverFlowView.this.acT.setPosition((i - 1) + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tbadk.core.flow.a.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CoverFlowView.this.acV != null) {
                int count = CoverFlowView.this.acV.getCount();
                if (i >= 0 && i < count && CoverFlowView.this.acY != null) {
                    CoverFlowView.this.acY.a(i, CoverFlowView.this.acV.cu(i));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CoverFlowView.this.acS != null && CoverFlowView.this.acV != null) {
                switch (i) {
                    case 0:
                        CoverFlowView.this.tK();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK() {
        if (tJ()) {
            tH();
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
            if (CoverFlowView.this.acY != null && (view.getTag() instanceof Integer) && (cu = CoverFlowView.this.acV.cu((intValue = ((Integer) view.getTag()).intValue()))) != null) {
                CoverFlowView.this.acY.g(intValue, cu.pQ());
            }
        }
    }

    public void onChangeSkinType() {
        this.acV.onChangeSkinType();
        if (this.acT != null && this.acU != null) {
            this.acT.setDrawable(ai.getDrawable(this.acU.tL()));
            this.acT.setSelector(ai.getDrawable(this.acU.tM()));
        }
    }

    public void setSwipeControlInterface(d.c cVar) {
        if (this.acS != null) {
            this.acS.setSwipeControlInterface(cVar);
        }
    }

    public void setDisableParentEvent(boolean z) {
        if (this.acS != null) {
            this.acS.setDisableParentEvent(z);
        }
    }
}
