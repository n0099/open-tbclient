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
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private IndicatorView ahr;
    private TextView ahs;
    private a aht;
    private f ahu;
    private ViewPager.OnPageChangeListener ahz;
    private Context mContext;
    private ViewPager mViewPager;
    private boolean ahv = false;
    private boolean ahw = true;
    private int ahx = 2;
    private List<v> ahy = new ArrayList();
    private long ahA = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback ahB = new c(this);
    private final Handler mHandler = new Handler(this.ahB);
    private ViewPager.OnPageChangeListener ahC = new d(this);

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ahr = indicatorView;
        this.ahs = textView;
        this.mContext = context;
        this.aht = new a(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aht);
            this.mViewPager.setOnPageChangeListener(this.ahC);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ahx = i;
        if (this.ahu != null) {
            this.ahu.dw(i);
        }
    }

    public void aR(boolean z) {
        this.ahv = z;
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.aht != null) {
            this.aht.a(context, eVar);
        }
    }

    public void setDatas(List<v> list) {
        if (w.r(list) != 0) {
            this.ahy = list;
            this.ahu = new f(this.ahy, this.ahv, this.ahx);
            this.ahu.dx(2);
            this.ahu.dy(1);
            this.aht.setDatas(this.ahu.wM());
            this.aht.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ahu.wL(), false);
            if (this.ahu.wK() > 0) {
                if (this.ahu.wK() > this.ahx) {
                    if (this.ahs != null) {
                        this.ahs.setVisibility(0);
                        this.ahs.setOnClickListener(null);
                        if (this.ahr != null) {
                            this.ahr.setVisibility(8);
                        }
                    } else if (this.ahr != null && !this.ahv) {
                        this.ahr.setVisibility(8);
                    }
                    if (this.ahr != null && this.ahr.getVisibility() == 0 && this.ahr.getCount() != this.ahx) {
                        this.ahr.setCount(this.ahx);
                    }
                    wG();
                }
                if (this.ahu.wK() >= 2 && this.ahu.wK() <= this.ahx) {
                    if (this.ahs != null) {
                        this.ahs.setVisibility(8);
                    }
                    if (this.ahr != null) {
                        this.ahr.setVisibility(0);
                        if (this.ahr.getCount() != this.ahu.wK()) {
                            this.ahr.setCount(this.ahu.wK());
                        }
                    }
                    wG();
                }
                if (this.ahu.wK() < 2) {
                    if (this.ahs != null) {
                        this.ahs.setVisibility(8);
                    }
                    if (this.ahr != null) {
                        this.ahr.setVisibility(8);
                    }
                    wH();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF() {
        int count;
        if (this.mViewPager != null && this.aht != null) {
            j A = k.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.aht.getCount()) >= 2) {
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
        this.ahA = j;
    }

    public void wG() {
        if (this.ahw) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ahA);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void wH() {
        this.mHandler.removeMessages(1);
    }

    public void dg(int i) {
        this.aht.dg(i);
    }
}
