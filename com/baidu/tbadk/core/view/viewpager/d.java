package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements BdBaseViewPager.a {
    private TextView ahl;
    private IndicatorView ahm;
    private a ahp;
    private h ahq;
    private boolean ahr;
    private boolean ahs;
    private int aht;
    private List<u> ahu;
    private ViewPager.OnPageChangeListener ahv;
    private long ahw;
    private ViewPager.OnPageChangeListener ahx;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ahv = onPageChangeListener;
    }

    public d(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ahr = false;
        this.ahs = true;
        this.aht = 2;
        this.ahu = new ArrayList();
        this.ahw = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new e(this);
        this.mHandler = new Handler(this.mCallback);
        this.ahx = new f(this);
        a(context, viewPager, indicatorView, textView);
    }

    public d(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ahr = false;
        this.ahs = true;
        this.aht = 2;
        this.ahu = new ArrayList();
        this.ahw = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new e(this);
        this.mHandler = new Handler(this.mCallback);
        this.ahx = new f(this);
        this.ahr = z;
        this.ahs = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ahm = indicatorView;
        this.ahl = textView;
        this.mContext = context;
        this.ahp = new a(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ahp);
            this.mViewPager.setOnPageChangeListener(this.ahx);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aht = i;
        if (this.ahq != null) {
            this.ahq.cV(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ahr = z;
    }

    public void az(boolean z) {
        this.ahs = z;
    }

    public void a(Context context, g<?, ?> gVar) {
        if (this.ahp != null) {
            this.ahp.a(context, gVar);
        }
    }

    public void setDatas(List<u> list) {
        boolean z = true;
        if (y.l(list) != 0) {
            this.ahu = list;
            this.ahq = new h(this.ahu, this.ahr, this.aht);
            this.ahq.cW(2);
            this.ahq.cX(1);
            this.ahp.setDatas(this.ahq.wi());
            this.ahp.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ahq.wh(), false);
            if (this.ahq.wg() > 0) {
                if (this.ahq.wg() > this.aht) {
                    if (this.ahl != null) {
                        this.ahl.setVisibility(0);
                        this.ahl.setOnClickListener(null);
                        if (this.ahm != null) {
                            this.ahm.setVisibility(8);
                        }
                    }
                    if (this.ahm != null && this.ahl == null && this.ahr) {
                        z = false;
                    }
                    if (!z) {
                        this.ahm.setVisibility(8);
                        if (this.ahm.getCount() != this.aht) {
                            this.ahm.setCount(this.aht);
                        }
                    }
                    wa();
                }
                if (this.ahq.wg() >= 2 && this.ahq.wg() <= this.aht) {
                    if (this.ahl != null) {
                        this.ahl.setVisibility(8);
                    }
                    if (this.ahm != null) {
                        this.ahm.setVisibility(0);
                        if (this.ahm.getCount() != this.ahq.wg()) {
                            this.ahm.setCount(this.ahq.wg());
                        }
                    }
                    wa();
                }
                if (this.ahq.wg() < 2) {
                    if (this.ahl != null) {
                        this.ahl.setVisibility(8);
                    }
                    if (this.ahm != null) {
                        this.ahm.setVisibility(8);
                    }
                    wb();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd() {
        int count;
        if (this.mViewPager != null && this.ahp != null) {
            k A = l.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.ahp.getCount()) >= 2) {
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
        this.ahw = j;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wa() {
        if (this.ahs) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ahw);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wb() {
        this.mHandler.removeMessages(1);
    }

    public void cK(int i) {
        this.ahp.cK(i);
    }

    public void notifyDataSetChanged() {
        if (this.ahq != null) {
            this.ahq.m(this.ahu);
            this.ahp.setDatas(this.ahq.wi());
        }
        this.ahp.notifyDataSetChanged();
    }
}
