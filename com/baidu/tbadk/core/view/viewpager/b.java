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
    private ViewPager.OnPageChangeListener byI;
    private TextView dKM;
    private IndicatorView dKN;
    private BdBaseViewPagerAdapter dKQ;
    private d dKR;
    private boolean dKS;
    private boolean dKT;
    private int dKU;
    private List<m> dKV;
    private long dKW;
    private ViewPager.OnPageChangeListener dKX;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dKS = false;
        this.dKT = true;
        this.dKU = 2;
        this.dKV = new ArrayList();
        this.dKW = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aQZ();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dKX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.byI != null) {
                    b.this.byI.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aRb();
                } else if (i == 0 && (count = b.this.dKQ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aRa();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.byI != null) {
                    b.this.byI.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dKR != null && b.this.dKR.lP(i) == i) {
                    if (b.this.dKN != null) {
                        b.this.dKN.setPosition(b.this.dKR.lQ(i));
                    }
                    if (b.this.byI != null) {
                        b.this.byI.onPageSelected(b.this.dKR.lQ(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dKS = false;
        this.dKT = true;
        this.dKU = 2;
        this.dKV = new ArrayList();
        this.dKW = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aQZ();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dKX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.byI != null) {
                    b.this.byI.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aRb();
                } else if (i2 == 0 && (count = b.this.dKQ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aRa();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.byI != null) {
                    b.this.byI.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dKR != null && b.this.dKR.lP(i2) == i2) {
                    if (b.this.dKN != null) {
                        b.this.dKN.setPosition(b.this.dKR.lQ(i2));
                    }
                    if (b.this.byI != null) {
                        b.this.byI.onPageSelected(b.this.dKR.lQ(i2));
                    }
                }
            }
        };
        this.dKS = z;
        this.dKT = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dKN = indicatorView;
        this.dKM = textView;
        this.mContext = context;
        this.dKQ = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dKQ);
            this.mViewPager.setOnPageChangeListener(this.dKX);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dKU = i;
        if (this.dKR != null) {
            this.dKR.lR(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dKS = z;
    }

    public void gV(boolean z) {
        this.dKT = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dKQ != null) {
            this.dKQ.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dKV = list;
            this.dKR = new d(this.dKV, this.dKS, this.dKU);
            this.dKR.lS(2);
            this.dKR.lT(1);
            this.dKQ.setDatas(this.dKR.aRg());
            this.dKQ.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dKR.aRf(), false);
            if (this.dKR.aRe() > 0) {
                if (this.dKR.aRe() > this.dKU) {
                    if (this.dKM != null) {
                        this.dKM.setVisibility(0);
                        this.dKM.setOnClickListener(null);
                        if (this.dKN != null) {
                            this.dKN.setVisibility(8);
                        }
                    } else if (this.dKN != null && !this.dKS) {
                        this.dKN.setVisibility(8);
                    }
                    if (this.dKN != null && this.dKN.getVisibility() == 0 && this.dKN.getCount() != this.dKU) {
                        this.dKN.setCount(this.dKU);
                    }
                    aRa();
                }
                if (this.dKR.aRe() >= 2 && this.dKR.aRe() <= this.dKU) {
                    if (this.dKM != null) {
                        this.dKM.setVisibility(8);
                    }
                    if (this.dKN != null) {
                        this.dKN.setVisibility(0);
                        if (this.dKN.getCount() != this.dKR.aRe()) {
                            this.dKN.setCount(this.dKR.aRe());
                        }
                    }
                    aRa();
                }
                if (this.dKR.aRe() < 2) {
                    if (this.dKM != null) {
                        this.dKM.setVisibility(8);
                    }
                    if (this.dKN != null) {
                        this.dKN.setVisibility(8);
                    }
                    aRb();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQZ() {
        int count;
        if (this.mViewPager != null && this.dKQ != null) {
            h R = i.R(this.mContext);
            if ((R == null || !R.isScroll()) && (count = this.dKQ.getCount()) >= 2) {
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
        this.dKW = j;
    }

    public void aRa() {
        if (this.dKT) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dKW);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aRb() {
        this.mHandler.removeMessages(1);
    }
}
