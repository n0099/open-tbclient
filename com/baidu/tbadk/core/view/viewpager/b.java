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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements BdBaseViewPager.a {
    private ViewPager ahW;
    private IndicatorView ahX;
    private TextView ahY;
    private a ahZ;
    private f aia;
    private ViewPager.OnPageChangeListener aif;
    private Context mContext;
    private boolean aib = false;
    private boolean aic = true;
    private int aid = 2;
    private List<u> aie = new ArrayList();
    private long aig = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback aih = new c(this);
    private final Handler mHandler = new Handler(this.aih);
    private ViewPager.OnPageChangeListener aii = new d(this);

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aif = onPageChangeListener;
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ahW = viewPager;
        this.ahX = indicatorView;
        this.ahY = textView;
        this.mContext = context;
        this.ahZ = new a(context);
        if (this.ahW != null) {
            this.ahW.setAdapter(this.ahZ);
            this.ahW.setOnPageChangeListener(this.aii);
        }
    }

    public void dn(int i) {
        this.aid = i;
        if (this.aia != null) {
            this.aia.dr(i);
        }
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.ahZ != null) {
            this.ahZ.a(context, eVar);
        }
    }

    public void setDatas(List<u> list) {
        boolean z = true;
        if (x.o(list) != 0) {
            this.aie = list;
            this.aia = new f(this.aie, this.aib, this.aid);
            this.aia.ds(2);
            this.aia.dt(1);
            this.ahZ.setDatas(this.aia.xw());
            this.ahZ.notifyDataSetChanged();
            this.ahW.setCurrentItem(this.aia.xv(), false);
            if (this.aia.xu() > 0) {
                if (this.aia.xu() > this.aid) {
                    if (this.ahY != null) {
                        this.ahY.setVisibility(0);
                        this.ahY.setOnClickListener(null);
                        if (this.ahX != null) {
                            this.ahX.setVisibility(8);
                        }
                    }
                    if (this.ahX != null && this.ahY == null && this.aib) {
                        z = false;
                    }
                    if (!z) {
                        this.ahX.setVisibility(8);
                        if (this.ahX.getCount() != this.aid) {
                            this.ahX.setCount(this.aid);
                        }
                    }
                    xo();
                }
                if (this.aia.xu() >= 2 && this.aia.xu() <= this.aid) {
                    if (this.ahY != null) {
                        this.ahY.setVisibility(8);
                    }
                    if (this.ahX != null) {
                        this.ahX.setVisibility(0);
                        if (this.ahX.getCount() != this.aia.xu()) {
                            this.ahX.setCount(this.aia.xu());
                        }
                    }
                    xo();
                }
                if (this.aia.xu() < 2) {
                    if (this.ahY != null) {
                        this.ahY.setVisibility(8);
                    }
                    if (this.ahX != null) {
                        this.ahX.setVisibility(8);
                    }
                    xp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        int count;
        if (this.ahW != null && this.ahZ != null) {
            k A = l.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.ahZ.getCount()) >= 2) {
                int currentItem = this.ahW.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.ahW.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.ahW.setCurrentItem(1, false);
                } else {
                    this.ahW.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void H(long j) {
        if (j < 0) {
            j = 0;
        }
        this.aig = j;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xo() {
        if (this.aic) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aig);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xp() {
        this.mHandler.removeMessages(1);
    }

    public void db(int i) {
        this.ahZ.db(i);
    }
}
