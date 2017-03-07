package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private IndicatorView amN;
    private TextView amO;
    private a amP;
    private f amQ;
    private ViewPager.OnPageChangeListener amV;
    private Context mContext;
    private ViewPager mViewPager;
    private boolean amR = false;
    private boolean amS = true;
    private int amT = 2;
    private List<v> amU = new ArrayList();
    private long amW = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback amX = new c(this);
    private final Handler mHandler = new Handler(this.amX);
    private ViewPager.OnPageChangeListener amY = new d(this);

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.amN = indicatorView;
        this.amO = textView;
        this.mContext = context;
        this.amP = new a(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.amP);
            this.mViewPager.setOnPageChangeListener(this.amY);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.amT = i;
        if (this.amQ != null) {
            this.amQ.ds(i);
        }
    }

    public void aQ(boolean z) {
        this.amR = z;
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.amP != null) {
            this.amP.a(context, eVar);
        }
    }

    public void setDatas(List<v> list) {
        if (x.p(list) != 0) {
            this.amU = list;
            this.amQ = new f(this.amU, this.amR, this.amT);
            this.amQ.dt(2);
            this.amQ.du(1);
            this.amP.setDatas(this.amQ.xj());
            this.amP.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.amQ.xi(), false);
            if (this.amQ.xh() > 0) {
                if (this.amQ.xh() > this.amT) {
                    if (this.amO != null) {
                        this.amO.setVisibility(0);
                        this.amO.setOnClickListener(null);
                        if (this.amN != null) {
                            this.amN.setVisibility(8);
                        }
                    } else if (this.amN != null && !this.amR) {
                        this.amN.setVisibility(8);
                    }
                    if (this.amN != null && this.amN.getVisibility() == 0 && this.amN.getCount() != this.amT) {
                        this.amN.setCount(this.amT);
                    }
                    xd();
                }
                if (this.amQ.xh() >= 2 && this.amQ.xh() <= this.amT) {
                    if (this.amO != null) {
                        this.amO.setVisibility(8);
                    }
                    if (this.amN != null) {
                        this.amN.setVisibility(0);
                        if (this.amN.getCount() != this.amQ.xh()) {
                            this.amN.setCount(this.amQ.xh());
                        }
                    }
                    xd();
                }
                if (this.amQ.xh() < 2) {
                    if (this.amO != null) {
                        this.amO.setVisibility(8);
                    }
                    if (this.amN != null) {
                        this.amN.setVisibility(8);
                    }
                    xe();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc() {
        int count;
        if (this.mViewPager != null && this.amP != null) {
            j Y = k.Y(this.mContext);
            if ((Y == null || !Y.isScroll()) && (count = this.amP.getCount()) >= 2) {
                int currentItem = this.mViewPager.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.mViewPager.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.mViewPager.setCurrentItem(1, false);
                } else {
                    this.mViewPager.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.amW = j;
    }

    public void xd() {
        if (this.amS) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.amW);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void xe() {
        this.mHandler.removeMessages(1);
    }

    public void dc(int i) {
        this.amP.dc(i);
    }
}
