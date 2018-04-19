package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private TextView aqV;
    private IndicatorView aqW;
    private BdBaseViewPagerAdapter aqZ;
    private d ara;
    private boolean arb;
    private boolean arc;
    private int ard;
    private List<h> are;
    private ViewPager.OnPageChangeListener arf;
    private long arg;
    private final Handler.Callback arh;
    private ViewPager.OnPageChangeListener ari;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.arb = false;
        this.arc = true;
        this.ard = 2;
        this.are = new ArrayList();
        this.arg = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.arh = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.xr();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.arh);
        this.ari = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.arf != null) {
                    b.this.arf.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.xt();
                } else if (i == 0 && (count = b.this.aqZ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.xs();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.arf != null) {
                    b.this.arf.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.ara != null && b.this.ara.dE(i) == i) {
                    if (b.this.aqW != null) {
                        b.this.aqW.setPosition(b.this.ara.dF(i));
                    }
                    if (b.this.arf != null) {
                        b.this.arf.onPageSelected(b.this.ara.dF(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.arb = false;
        this.arc = true;
        this.ard = 2;
        this.are = new ArrayList();
        this.arg = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.arh = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.xr();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.arh);
        this.ari = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.arf != null) {
                    b.this.arf.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.xt();
                } else if (i2 == 0 && (count = b.this.aqZ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.xs();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.arf != null) {
                    b.this.arf.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.ara != null && b.this.ara.dE(i2) == i2) {
                    if (b.this.aqW != null) {
                        b.this.aqW.setPosition(b.this.ara.dF(i2));
                    }
                    if (b.this.arf != null) {
                        b.this.arf.onPageSelected(b.this.ara.dF(i2));
                    }
                }
            }
        };
        this.arb = z;
        this.arc = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aqW = indicatorView;
        this.aqV = textView;
        this.mContext = context;
        this.aqZ = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aqZ);
            this.mViewPager.setOnPageChangeListener(this.ari);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ard = i;
        if (this.ara != null) {
            this.ara.dG(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.arb = z;
    }

    public void aT(boolean z) {
        this.arc = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aqZ != null) {
            this.aqZ.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.v(list) != 0) {
            this.are = list;
            this.ara = new d(this.are, this.arb, this.ard);
            this.ara.dH(2);
            this.ara.dI(1);
            this.aqZ.setDatas(this.ara.xy());
            this.aqZ.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ara.xx(), false);
            if (this.ara.xw() > 0) {
                if (this.ara.xw() > this.ard) {
                    if (this.aqV != null) {
                        this.aqV.setVisibility(0);
                        this.aqV.setOnClickListener(null);
                        if (this.aqW != null) {
                            this.aqW.setVisibility(8);
                        }
                    } else if (this.aqW != null && !this.arb) {
                        this.aqW.setVisibility(8);
                    }
                    if (this.aqW != null && this.aqW.getVisibility() == 0 && this.aqW.getCount() != this.ard) {
                        this.aqW.setCount(this.ard);
                    }
                    xs();
                }
                if (this.ara.xw() >= 2 && this.ara.xw() <= this.ard) {
                    if (this.aqV != null) {
                        this.aqV.setVisibility(8);
                    }
                    if (this.aqW != null) {
                        this.aqW.setVisibility(0);
                        if (this.aqW.getCount() != this.ara.xw()) {
                            this.aqW.setCount(this.ara.xw());
                        }
                    }
                    xs();
                }
                if (this.ara.xw() < 2) {
                    if (this.aqV != null) {
                        this.aqV.setVisibility(8);
                    }
                    if (this.aqW != null) {
                        this.aqW.setVisibility(8);
                    }
                    xt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        int count;
        if (this.mViewPager != null && this.aqZ != null) {
            com.baidu.adp.base.h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.aqZ.getCount()) >= 2) {
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
        this.arg = j;
    }

    public void xs() {
        if (this.arc) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.arg);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void xt() {
        this.mHandler.removeMessages(1);
    }
}
