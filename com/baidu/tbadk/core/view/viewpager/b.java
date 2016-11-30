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
    private ViewPager aiC;
    private IndicatorView aiD;
    private TextView aiE;
    private a aiF;
    private f aiG;
    private ViewPager.OnPageChangeListener aiL;
    private Context mContext;
    private boolean aiH = false;
    private boolean aiI = true;
    private int aiJ = 2;
    private List<v> aiK = new ArrayList();
    private long aiM = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback aiN = new c(this);
    private final Handler mHandler = new Handler(this.aiN);
    private ViewPager.OnPageChangeListener aiO = new d(this);

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aiC = viewPager;
        this.aiD = indicatorView;
        this.aiE = textView;
        this.mContext = context;
        this.aiF = new a(context);
        if (this.aiC != null) {
            this.aiC.setAdapter(this.aiF);
            this.aiC.setOnPageChangeListener(this.aiO);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aiJ = i;
        if (this.aiG != null) {
            this.aiG.dt(i);
        }
    }

    public void aQ(boolean z) {
        this.aiH = z;
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.aiF != null) {
            this.aiF.a(context, eVar);
        }
    }

    public void setDatas(List<v> list) {
        if (x.s(list) != 0) {
            this.aiK = list;
            this.aiG = new f(this.aiK, this.aiH, this.aiJ);
            this.aiG.du(2);
            this.aiG.dv(1);
            this.aiF.setDatas(this.aiG.xf());
            this.aiF.notifyDataSetChanged();
            this.aiC.setCurrentItem(this.aiG.xe(), false);
            if (this.aiG.xd() > 0) {
                if (this.aiG.xd() > this.aiJ) {
                    if (this.aiE != null) {
                        this.aiE.setVisibility(0);
                        this.aiE.setOnClickListener(null);
                        if (this.aiD != null) {
                            this.aiD.setVisibility(8);
                        }
                    } else if (this.aiD != null && !this.aiH) {
                        this.aiD.setVisibility(8);
                    }
                    if (this.aiD != null && this.aiD.getVisibility() == 0 && this.aiD.getCount() != this.aiJ) {
                        this.aiD.setCount(this.aiJ);
                    }
                    wZ();
                }
                if (this.aiG.xd() >= 2 && this.aiG.xd() <= this.aiJ) {
                    if (this.aiE != null) {
                        this.aiE.setVisibility(8);
                    }
                    if (this.aiD != null) {
                        this.aiD.setVisibility(0);
                        if (this.aiD.getCount() != this.aiG.xd()) {
                            this.aiD.setCount(this.aiG.xd());
                        }
                    }
                    wZ();
                }
                if (this.aiG.xd() < 2) {
                    if (this.aiE != null) {
                        this.aiE.setVisibility(8);
                    }
                    if (this.aiD != null) {
                        this.aiD.setVisibility(8);
                    }
                    xa();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY() {
        int count;
        if (this.aiC != null && this.aiF != null) {
            k A = l.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.aiF.getCount()) >= 2) {
                int currentItem = this.aiC.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.aiC.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.aiC.setCurrentItem(1, false);
                } else {
                    this.aiC.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.aiM = j;
    }

    public void wZ() {
        if (this.aiI) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aiM);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void xa() {
        this.mHandler.removeMessages(1);
    }

    public void dd(int i) {
        this.aiF.dd(i);
    }
}
