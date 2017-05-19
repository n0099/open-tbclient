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
public class c {
    private IndicatorView ang;
    private TextView anh;
    private b ani;
    private g anj;
    private ViewPager.OnPageChangeListener ano;
    private Context mContext;
    private ViewPager mViewPager;
    private boolean ank = false;
    private boolean anl = true;
    private int anm = 2;
    private List<v> ann = new ArrayList();
    private long anp = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback anq = new d(this);
    private final Handler mHandler = new Handler(this.anq);
    private ViewPager.OnPageChangeListener anr = new e(this);

    public c(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ang = indicatorView;
        this.anh = textView;
        this.mContext = context;
        this.ani = new b(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ani);
            this.mViewPager.setOnPageChangeListener(this.anr);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.anm = i;
        if (this.anj != null) {
            this.anj.dt(i);
        }
    }

    public void aS(boolean z) {
        this.ank = z;
    }

    public void a(Context context, f<?, ?> fVar) {
        if (this.ani != null) {
            this.ani.a(context, fVar);
        }
    }

    public void setDatas(List<v> list) {
        if (x.q(list) != 0) {
            this.ann = list;
            this.anj = new g(this.ann, this.ank, this.anm);
            this.anj.du(2);
            this.anj.dv(1);
            this.ani.setDatas(this.anj.wT());
            this.ani.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.anj.wS(), false);
            if (this.anj.wR() > 0) {
                if (this.anj.wR() > this.anm) {
                    if (this.anh != null) {
                        this.anh.setVisibility(0);
                        this.anh.setOnClickListener(null);
                        if (this.ang != null) {
                            this.ang.setVisibility(8);
                        }
                    } else if (this.ang != null && !this.ank) {
                        this.ang.setVisibility(8);
                    }
                    if (this.ang != null && this.ang.getVisibility() == 0 && this.ang.getCount() != this.anm) {
                        this.ang.setCount(this.anm);
                    }
                    wN();
                }
                if (this.anj.wR() >= 2 && this.anj.wR() <= this.anm) {
                    if (this.anh != null) {
                        this.anh.setVisibility(8);
                    }
                    if (this.ang != null) {
                        this.ang.setVisibility(0);
                        if (this.ang.getCount() != this.anj.wR()) {
                            this.ang.setCount(this.anj.wR());
                        }
                    }
                    wN();
                }
                if (this.anj.wR() < 2) {
                    if (this.anh != null) {
                        this.anh.setVisibility(8);
                    }
                    if (this.ang != null) {
                        this.ang.setVisibility(8);
                    }
                    wO();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM() {
        int count;
        if (this.mViewPager != null && this.ani != null) {
            j X = k.X(this.mContext);
            if ((X == null || !X.isScroll()) && (count = this.ani.getCount()) >= 2) {
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
        this.anp = j;
    }

    public void wN() {
        if (this.anl) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.anp);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void wO() {
        this.mHandler.removeMessages(1);
    }

    public void db(int i) {
        this.ani.db(i);
    }
}
