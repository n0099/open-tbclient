package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager aid;
    private IndicatorView aie;
    private TextView aif;
    private a aig;
    private f aih;
    private ViewPager.OnPageChangeListener aim;
    private Context mContext;
    private boolean aii = false;
    private boolean aij = true;
    private int aik = 2;
    private List<v> ail = new ArrayList();
    private long ain = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback aio = new c(this);
    private final Handler mHandler = new Handler(this.aio);
    private ViewPager.OnPageChangeListener aip = new d(this);

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aid = viewPager;
        this.aie = indicatorView;
        this.aif = textView;
        this.mContext = context;
        this.aig = new a(context);
        if (this.aid != null) {
            this.aid.setAdapter(this.aig);
            this.aid.setOnPageChangeListener(this.aip);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aik = i;
        if (this.aih != null) {
            this.aih.dv(i);
        }
    }

    public void aR(boolean z) {
        this.aii = z;
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.aig != null) {
            this.aig.a(context, eVar);
        }
    }

    public void setDatas(List<v> list) {
        if (x.s(list) != 0) {
            this.ail = list;
            this.aih = new f(this.ail, this.aii, this.aik);
            this.aih.dw(2);
            this.aih.dx(1);
            this.aig.setDatas(this.aih.wS());
            this.aig.notifyDataSetChanged();
            this.aid.setCurrentItem(this.aih.wR(), false);
            if (this.aih.wQ() > 0) {
                if (this.aih.wQ() > this.aik) {
                    if (this.aif != null) {
                        this.aif.setVisibility(0);
                        this.aif.setOnClickListener(null);
                        if (this.aie != null) {
                            this.aie.setVisibility(8);
                        }
                    } else if (this.aie != null && !this.aii) {
                        this.aie.setVisibility(8);
                    }
                    if (this.aie != null && this.aie.getVisibility() == 0 && this.aie.getCount() != this.aik) {
                        this.aie.setCount(this.aik);
                    }
                    wM();
                }
                if (this.aih.wQ() >= 2 && this.aih.wQ() <= this.aik) {
                    if (this.aif != null) {
                        this.aif.setVisibility(8);
                    }
                    if (this.aie != null) {
                        this.aie.setVisibility(0);
                        if (this.aie.getCount() != this.aih.wQ()) {
                            this.aie.setCount(this.aih.wQ());
                        }
                    }
                    wM();
                }
                if (this.aih.wQ() < 2) {
                    if (this.aif != null) {
                        this.aif.setVisibility(8);
                    }
                    if (this.aie != null) {
                        this.aie.setVisibility(8);
                    }
                    wN();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL() {
        int count;
        if (this.aid != null && this.aig != null) {
            k A = l.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.aig.getCount()) >= 2) {
                int currentItem = this.aid.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.aid.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.aid.setCurrentItem(1, false);
                } else {
                    this.aid.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.ain = j;
    }

    public void wM() {
        if (this.aij) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ain);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void wN() {
        this.mHandler.removeMessages(1);
    }

    public void df(int i) {
        this.aig.df(i);
    }
}
