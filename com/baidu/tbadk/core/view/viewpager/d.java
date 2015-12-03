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
    private TextView age;
    private IndicatorView agf;
    private a agi;
    private h agj;
    private boolean agk;
    private boolean agl;
    private int agm;
    private List<u> agn;
    private ViewPager.OnPageChangeListener ago;
    private long agp;
    private ViewPager.OnPageChangeListener agq;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ago = onPageChangeListener;
    }

    public d(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.agk = false;
        this.agl = true;
        this.agm = 2;
        this.agn = new ArrayList();
        this.agp = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new e(this);
        this.mHandler = new Handler(this.mCallback);
        this.agq = new f(this);
        a(context, viewPager, indicatorView, textView);
    }

    public d(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.agk = false;
        this.agl = true;
        this.agm = 2;
        this.agn = new ArrayList();
        this.agp = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new e(this);
        this.mHandler = new Handler(this.mCallback);
        this.agq = new f(this);
        this.agk = z;
        this.agl = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.agf = indicatorView;
        this.age = textView;
        this.mContext = context;
        this.agi = new a(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.agi);
            this.mViewPager.setOnPageChangeListener(this.agq);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.agm = i;
        if (this.agj != null) {
            this.agj.dc(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.agk = z;
    }

    public void aC(boolean z) {
        this.agl = z;
    }

    public void a(Context context, g<?, ?> gVar) {
        if (this.agi != null) {
            this.agi.a(context, gVar);
        }
    }

    public void setDatas(List<u> list) {
        boolean z = true;
        if (y.k(list) != 0) {
            this.agn = list;
            this.agj = new h(this.agn, this.agk, this.agm);
            this.agj.dd(2);
            this.agj.de(1);
            this.agi.setDatas(this.agj.wx());
            this.agi.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.agj.ww(), false);
            if (this.agj.wv() > 0) {
                if (this.agj.wv() > this.agm) {
                    if (this.age != null) {
                        this.age.setVisibility(0);
                        this.age.setOnClickListener(null);
                        if (this.agf != null) {
                            this.agf.setVisibility(8);
                        }
                    }
                    if (this.agf != null && this.age == null && this.agk) {
                        z = false;
                    }
                    if (!z) {
                        this.agf.setVisibility(8);
                        if (this.agf.getCount() != this.agm) {
                            this.agf.setCount(this.agm);
                        }
                    }
                    wp();
                }
                if (this.agj.wv() >= 2 && this.agj.wv() <= this.agm) {
                    if (this.age != null) {
                        this.age.setVisibility(8);
                    }
                    if (this.agf != null) {
                        this.agf.setVisibility(0);
                        if (this.agf.getCount() != this.agj.wv()) {
                            this.agf.setCount(this.agj.wv());
                        }
                    }
                    wp();
                }
                if (this.agj.wv() < 2) {
                    if (this.age != null) {
                        this.age.setVisibility(8);
                    }
                    if (this.agf != null) {
                        this.agf.setVisibility(8);
                    }
                    wq();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        int count;
        if (this.mViewPager != null && this.agi != null) {
            k A = l.A(this.mContext);
            if ((A == null || !A.isScroll()) && (count = this.agi.getCount()) >= 2) {
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
        this.agp = j;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wp() {
        if (this.agl) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.agp);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wq() {
        this.mHandler.removeMessages(1);
    }

    public void cZ(int i) {
        this.agi.cZ(i);
    }

    public void notifyDataSetChanged() {
        if (this.agj != null) {
            this.agj.l(this.agn);
            this.agi.setDatas(this.agj.wx());
        }
        this.agi.notifyDataSetChanged();
    }
}
