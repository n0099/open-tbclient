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
    private ViewPager.OnPageChangeListener byN;
    private TextView dKQ;
    private IndicatorView dKR;
    private BdBaseViewPagerAdapter dKU;
    private d dKV;
    private boolean dKW;
    private boolean dKX;
    private int dKY;
    private List<m> dKZ;
    private long dLa;
    private ViewPager.OnPageChangeListener dLb;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dKW = false;
        this.dKX = true;
        this.dKY = 2;
        this.dKZ = new ArrayList();
        this.dLa = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aQW();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dLb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.byN != null) {
                    b.this.byN.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aQY();
                } else if (i == 0 && (count = b.this.dKU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aQX();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.byN != null) {
                    b.this.byN.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dKV != null && b.this.dKV.lP(i) == i) {
                    if (b.this.dKR != null) {
                        b.this.dKR.setPosition(b.this.dKV.lQ(i));
                    }
                    if (b.this.byN != null) {
                        b.this.byN.onPageSelected(b.this.dKV.lQ(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dKW = false;
        this.dKX = true;
        this.dKY = 2;
        this.dKZ = new ArrayList();
        this.dLa = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aQW();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dLb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.byN != null) {
                    b.this.byN.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aQY();
                } else if (i2 == 0 && (count = b.this.dKU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aQX();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.byN != null) {
                    b.this.byN.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dKV != null && b.this.dKV.lP(i2) == i2) {
                    if (b.this.dKR != null) {
                        b.this.dKR.setPosition(b.this.dKV.lQ(i2));
                    }
                    if (b.this.byN != null) {
                        b.this.byN.onPageSelected(b.this.dKV.lQ(i2));
                    }
                }
            }
        };
        this.dKW = z;
        this.dKX = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dKR = indicatorView;
        this.dKQ = textView;
        this.mContext = context;
        this.dKU = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dKU);
            this.mViewPager.setOnPageChangeListener(this.dLb);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dKY = i;
        if (this.dKV != null) {
            this.dKV.lR(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dKW = z;
    }

    public void gV(boolean z) {
        this.dKX = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dKU != null) {
            this.dKU.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dKZ = list;
            this.dKV = new d(this.dKZ, this.dKW, this.dKY);
            this.dKV.lS(2);
            this.dKV.lT(1);
            this.dKU.setDatas(this.dKV.aRd());
            this.dKU.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dKV.aRc(), false);
            if (this.dKV.aRb() > 0) {
                if (this.dKV.aRb() > this.dKY) {
                    if (this.dKQ != null) {
                        this.dKQ.setVisibility(0);
                        this.dKQ.setOnClickListener(null);
                        if (this.dKR != null) {
                            this.dKR.setVisibility(8);
                        }
                    } else if (this.dKR != null && !this.dKW) {
                        this.dKR.setVisibility(8);
                    }
                    if (this.dKR != null && this.dKR.getVisibility() == 0 && this.dKR.getCount() != this.dKY) {
                        this.dKR.setCount(this.dKY);
                    }
                    aQX();
                }
                if (this.dKV.aRb() >= 2 && this.dKV.aRb() <= this.dKY) {
                    if (this.dKQ != null) {
                        this.dKQ.setVisibility(8);
                    }
                    if (this.dKR != null) {
                        this.dKR.setVisibility(0);
                        if (this.dKR.getCount() != this.dKV.aRb()) {
                            this.dKR.setCount(this.dKV.aRb());
                        }
                    }
                    aQX();
                }
                if (this.dKV.aRb() < 2) {
                    if (this.dKQ != null) {
                        this.dKQ.setVisibility(8);
                    }
                    if (this.dKR != null) {
                        this.dKR.setVisibility(8);
                    }
                    aQY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQW() {
        int count;
        if (this.mViewPager != null && this.dKU != null) {
            h E = i.E(this.mContext);
            if ((E == null || !E.isScroll()) && (count = this.dKU.getCount()) >= 2) {
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
        this.dLa = j;
    }

    public void aQX() {
        if (this.dKX) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dLa);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aQY() {
        this.mHandler.removeMessages(1);
    }
}
