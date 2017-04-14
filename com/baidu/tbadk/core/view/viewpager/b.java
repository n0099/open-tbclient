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
    private IndicatorView anb;
    private TextView anc;
    private a and;
    private f ane;
    private ViewPager.OnPageChangeListener anj;
    private Context mContext;
    private ViewPager mViewPager;
    private boolean anf = false;
    private boolean ang = true;
    private int anh = 2;
    private List<v> ani = new ArrayList();
    private long ank = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback anl = new c(this);
    private final Handler mHandler = new Handler(this.anl);
    private ViewPager.OnPageChangeListener anm = new d(this);

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.anb = indicatorView;
        this.anc = textView;
        this.mContext = context;
        this.and = new a(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.and);
            this.mViewPager.setOnPageChangeListener(this.anm);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.anh = i;
        if (this.ane != null) {
            this.ane.dv(i);
        }
    }

    public void aS(boolean z) {
        this.anf = z;
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.and != null) {
            this.and.a(context, eVar);
        }
    }

    public void setDatas(List<v> list) {
        if (x.p(list) != 0) {
            this.ani = list;
            this.ane = new f(this.ani, this.anf, this.anh);
            this.ane.dw(2);
            this.ane.dx(1);
            this.and.setDatas(this.ane.xF());
            this.and.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ane.xE(), false);
            if (this.ane.xD() > 0) {
                if (this.ane.xD() > this.anh) {
                    if (this.anc != null) {
                        this.anc.setVisibility(0);
                        this.anc.setOnClickListener(null);
                        if (this.anb != null) {
                            this.anb.setVisibility(8);
                        }
                    } else if (this.anb != null && !this.anf) {
                        this.anb.setVisibility(8);
                    }
                    if (this.anb != null && this.anb.getVisibility() == 0 && this.anb.getCount() != this.anh) {
                        this.anb.setCount(this.anh);
                    }
                    xz();
                }
                if (this.ane.xD() >= 2 && this.ane.xD() <= this.anh) {
                    if (this.anc != null) {
                        this.anc.setVisibility(8);
                    }
                    if (this.anb != null) {
                        this.anb.setVisibility(0);
                        if (this.anb.getCount() != this.ane.xD()) {
                            this.anb.setCount(this.ane.xD());
                        }
                    }
                    xz();
                }
                if (this.ane.xD() < 2) {
                    if (this.anc != null) {
                        this.anc.setVisibility(8);
                    }
                    if (this.anb != null) {
                        this.anb.setVisibility(8);
                    }
                    xA();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy() {
        int count;
        if (this.mViewPager != null && this.and != null) {
            j X = k.X(this.mContext);
            if ((X == null || !X.isScroll()) && (count = this.and.getCount()) >= 2) {
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
        this.ank = j;
    }

    public void xz() {
        if (this.ang) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ank);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void xA() {
        this.mHandler.removeMessages(1);
    }

    public void df(int i) {
        this.and.df(i);
    }
}
