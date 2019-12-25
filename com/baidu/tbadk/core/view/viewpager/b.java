package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager.OnPageChangeListener aUO;
    private TextView dfZ;
    private IndicatorView dga;
    private BdBaseViewPagerAdapter dgd;
    private d dge;
    private boolean dgf;
    private boolean dgg;
    private int dgh;
    private List<m> dgi;
    private long dgj;
    private ViewPager.OnPageChangeListener dgk;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dgf = false;
        this.dgg = true;
        this.dgh = 2;
        this.dgi = new ArrayList();
        this.dgj = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aFO();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dgk = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aUO != null) {
                    b.this.aUO.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aFQ();
                } else if (i == 0 && (count = b.this.dgd.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aFP();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aUO != null) {
                    b.this.aUO.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dge != null && b.this.dge.lk(i) == i) {
                    if (b.this.dga != null) {
                        b.this.dga.setPosition(b.this.dge.ll(i));
                    }
                    if (b.this.aUO != null) {
                        b.this.aUO.onPageSelected(b.this.dge.ll(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dgf = false;
        this.dgg = true;
        this.dgh = 2;
        this.dgi = new ArrayList();
        this.dgj = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aFO();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dgk = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aUO != null) {
                    b.this.aUO.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aFQ();
                } else if (i2 == 0 && (count = b.this.dgd.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aFP();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aUO != null) {
                    b.this.aUO.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dge != null && b.this.dge.lk(i2) == i2) {
                    if (b.this.dga != null) {
                        b.this.dga.setPosition(b.this.dge.ll(i2));
                    }
                    if (b.this.aUO != null) {
                        b.this.aUO.onPageSelected(b.this.dge.ll(i2));
                    }
                }
            }
        };
        this.dgf = z;
        this.dgg = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dga = indicatorView;
        this.dfZ = textView;
        this.mContext = context;
        this.dgd = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dgd);
            this.mViewPager.setOnPageChangeListener(this.dgk);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dgh = i;
        if (this.dge != null) {
            this.dge.lm(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dgf = z;
    }

    public void fK(boolean z) {
        this.dgg = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dgd != null) {
            this.dgd.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dgi = list;
            this.dge = new d(this.dgi, this.dgf, this.dgh);
            this.dge.ln(2);
            this.dge.lo(1);
            this.dgd.setDatas(this.dge.aFV());
            this.dgd.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dge.aFU(), false);
            if (this.dge.aFT() > 0) {
                if (this.dge.aFT() > this.dgh) {
                    if (this.dfZ != null) {
                        this.dfZ.setVisibility(0);
                        this.dfZ.setOnClickListener(null);
                        if (this.dga != null) {
                            this.dga.setVisibility(8);
                        }
                    } else if (this.dga != null && !this.dgf) {
                        this.dga.setVisibility(8);
                    }
                    if (this.dga != null && this.dga.getVisibility() == 0 && this.dga.getCount() != this.dgh) {
                        this.dga.setCount(this.dgh);
                    }
                    aFP();
                }
                if (this.dge.aFT() >= 2 && this.dge.aFT() <= this.dgh) {
                    if (this.dfZ != null) {
                        this.dfZ.setVisibility(8);
                    }
                    if (this.dga != null) {
                        this.dga.setVisibility(0);
                        if (this.dga.getCount() != this.dge.aFT()) {
                            this.dga.setCount(this.dge.aFT());
                        }
                    }
                    aFP();
                }
                if (this.dge.aFT() < 2) {
                    if (this.dfZ != null) {
                        this.dfZ.setVisibility(8);
                    }
                    if (this.dga != null) {
                        this.dga.setVisibility(8);
                    }
                    aFQ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFO() {
        int count;
        if (this.mViewPager != null && this.dgd != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dgd.getCount()) >= 2) {
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
        this.dgj = j;
    }

    public void aFP() {
        if (this.dgg) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dgj);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aFQ() {
        this.mHandler.removeMessages(1);
    }
}
