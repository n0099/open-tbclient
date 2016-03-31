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
public class b implements BdBaseViewPager.a {
    private ViewPager aim;
    private IndicatorView ain;
    private TextView aio;
    private a aip;
    private f aiq;
    private ViewPager.OnPageChangeListener aiv;
    private Context mContext;
    private boolean air = false;
    private boolean ais = true;
    private int ait = 2;
    private List<u> aiu = new ArrayList();
    private long aiw = TbConfig.NOTIFY_SOUND_INTERVAL;
    private final Handler.Callback aix = new c(this);
    private final Handler mHandler = new Handler(this.aix);
    private ViewPager.OnPageChangeListener aiy = new d(this);

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aiv = onPageChangeListener;
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aim = viewPager;
        this.ain = indicatorView;
        this.aio = textView;
        this.mContext = context;
        this.aip = new a(context);
        if (this.aim != null) {
            this.aim.setAdapter(this.aip);
            this.aim.setOnPageChangeListener(this.aiy);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ait = i;
        if (this.aiq != null) {
            this.aiq.du(i);
        }
    }

    public void a(Context context, e<?, ?> eVar) {
        if (this.aip != null) {
            this.aip.a(context, eVar);
        }
    }

    public void setDatas(List<u> list) {
        boolean z = true;
        if (y.p(list) != 0) {
            this.aiu = list;
            this.aiq = new f(this.aiu, this.air, this.ait);
            this.aiq.dv(2);
            this.aiq.dw(1);
            this.aip.setDatas(this.aiq.xW());
            this.aip.notifyDataSetChanged();
            this.aim.setCurrentItem(this.aiq.xV(), false);
            if (this.aiq.xU() > 0) {
                if (this.aiq.xU() > this.ait) {
                    if (this.aio != null) {
                        this.aio.setVisibility(0);
                        this.aio.setOnClickListener(null);
                        if (this.ain != null) {
                            this.ain.setVisibility(8);
                        }
                    }
                    if (this.ain != null && this.aio == null && this.air) {
                        z = false;
                    }
                    if (!z) {
                        this.ain.setVisibility(8);
                        if (this.ain.getCount() != this.ait) {
                            this.ain.setCount(this.ait);
                        }
                    }
                    xO();
                }
                if (this.aiq.xU() >= 2 && this.aiq.xU() <= this.ait) {
                    if (this.aio != null) {
                        this.aio.setVisibility(8);
                    }
                    if (this.ain != null) {
                        this.ain.setVisibility(0);
                        if (this.ain.getCount() != this.aiq.xU()) {
                            this.ain.setCount(this.aiq.xU());
                        }
                    }
                    xO();
                }
                if (this.aiq.xU() < 2) {
                    if (this.aio != null) {
                        this.aio.setVisibility(8);
                    }
                    if (this.ain != null) {
                        this.ain.setVisibility(8);
                    }
                    xP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR() {
        int count;
        if (this.aim != null && this.aip != null) {
            k q = l.q(this.mContext);
            if ((q == null || !q.isScroll()) && (count = this.aip.getCount()) >= 2) {
                int currentItem = this.aim.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.aim.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.aim.setCurrentItem(1, false);
                } else {
                    this.aim.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.aiw = j;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xO() {
        if (this.ais) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aiw);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void xP() {
        this.mHandler.removeMessages(1);
    }

    public void de(int i) {
        this.aip.de(i);
    }
}
