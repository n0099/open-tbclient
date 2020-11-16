package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager.OnPageChangeListener crZ;
    private TextView eZX;
    private IndicatorView eZY;
    private BdBaseViewPagerAdapter fab;
    private d fac;
    private boolean fad;
    private boolean fae;
    private int faf;
    private List<q> fag;
    private long fah;
    private ViewPager.OnPageChangeListener fai;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.fad = false;
        this.fae = true;
        this.faf = 2;
        this.fag = new ArrayList();
        this.fah = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bta();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fai = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.crZ != null) {
                    b.this.crZ.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.btc();
                } else if (i == 0 && (count = b.this.fab.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.btb();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.crZ != null) {
                    b.this.crZ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.fac != null && b.this.fac.qT(i) == i) {
                    if (b.this.eZY != null) {
                        b.this.eZY.setPosition(b.this.fac.qU(i));
                    }
                    if (b.this.crZ != null) {
                        b.this.crZ.onPageSelected(b.this.fac.qU(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.fad = false;
        this.fae = true;
        this.faf = 2;
        this.fag = new ArrayList();
        this.fah = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bta();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fai = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.crZ != null) {
                    b.this.crZ.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.btc();
                } else if (i2 == 0 && (count = b.this.fab.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.btb();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.crZ != null) {
                    b.this.crZ.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.fac != null && b.this.fac.qT(i2) == i2) {
                    if (b.this.eZY != null) {
                        b.this.eZY.setPosition(b.this.fac.qU(i2));
                    }
                    if (b.this.crZ != null) {
                        b.this.crZ.onPageSelected(b.this.fac.qU(i2));
                    }
                }
            }
        };
        this.fad = z;
        this.fae = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eZY = indicatorView;
        this.eZX = textView;
        this.mContext = context;
        this.fab = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.fab);
            this.mViewPager.setOnPageChangeListener(this.fai);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.faf = i;
        if (this.fac != null) {
            this.fac.qV(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fad = z;
    }

    public void jx(boolean z) {
        this.fae = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.fab != null) {
            this.fab.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.fag = list;
            this.fac = new d(this.fag, this.fad, this.faf);
            this.fac.qW(2);
            this.fac.qX(1);
            this.fab.setDatas(this.fac.bth());
            this.fab.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.fac.btg(), false);
            if (this.fac.btf() > 0) {
                if (this.fac.btf() > this.faf) {
                    if (this.eZX != null) {
                        this.eZX.setVisibility(0);
                        this.eZX.setOnClickListener(null);
                        if (this.eZY != null) {
                            this.eZY.setVisibility(8);
                        }
                    } else if (this.eZY != null && !this.fad) {
                        this.eZY.setVisibility(8);
                    }
                    if (this.eZY != null && this.eZY.getVisibility() == 0 && this.eZY.getCount() != this.faf) {
                        this.eZY.setCount(this.faf);
                    }
                    btb();
                }
                if (this.fac.btf() >= 2 && this.fac.btf() <= this.faf) {
                    if (this.eZX != null) {
                        this.eZX.setVisibility(8);
                    }
                    if (this.eZY != null) {
                        this.eZY.setVisibility(0);
                        if (this.eZY.getCount() != this.fac.btf()) {
                            this.eZY.setCount(this.fac.btf());
                        }
                    }
                    btb();
                }
                if (this.fac.btf() < 2) {
                    if (this.eZX != null) {
                        this.eZX.setVisibility(8);
                    }
                    if (this.eZY != null) {
                        this.eZY.setVisibility(8);
                    }
                    btc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bta() {
        int count;
        if (this.mViewPager != null && this.fab != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.fab.getCount()) >= 2) {
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
        this.fah = j;
    }

    public void btb() {
        if (this.fae) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fah);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void btc() {
        this.mHandler.removeMessages(1);
    }
}
