package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private TextView aLM;
    private IndicatorView aLN;
    private BdBaseViewPagerAdapter aLQ;
    private d aLR;
    private boolean aLS;
    private boolean aLT;
    private int aLU;
    private List<h> aLV;
    private ViewPager.OnPageChangeListener aLW;
    private long aLX;
    private ViewPager.OnPageChangeListener aLY;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aLS = false;
        this.aLT = true;
        this.aLU = 2;
        this.aLV = new ArrayList();
        this.aLX = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FD();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aLY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aLW != null) {
                    b.this.aLW.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.FF();
                } else if (i == 0 && (count = b.this.aLQ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FE();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aLW != null) {
                    b.this.aLW.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aLR != null && b.this.aLR.eJ(i) == i) {
                    if (b.this.aLN != null) {
                        b.this.aLN.setPosition(b.this.aLR.eK(i));
                    }
                    if (b.this.aLW != null) {
                        b.this.aLW.onPageSelected(b.this.aLR.eK(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aLS = false;
        this.aLT = true;
        this.aLU = 2;
        this.aLV = new ArrayList();
        this.aLX = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FD();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aLY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aLW != null) {
                    b.this.aLW.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.FF();
                } else if (i2 == 0 && (count = b.this.aLQ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FE();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aLW != null) {
                    b.this.aLW.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aLR != null && b.this.aLR.eJ(i2) == i2) {
                    if (b.this.aLN != null) {
                        b.this.aLN.setPosition(b.this.aLR.eK(i2));
                    }
                    if (b.this.aLW != null) {
                        b.this.aLW.onPageSelected(b.this.aLR.eK(i2));
                    }
                }
            }
        };
        this.aLS = z;
        this.aLT = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aLN = indicatorView;
        this.aLM = textView;
        this.mContext = context;
        this.aLQ = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aLQ);
            this.mViewPager.setOnPageChangeListener(this.aLY);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aLU = i;
        if (this.aLR != null) {
            this.aLR.eL(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aLS = z;
    }

    public void bN(boolean z) {
        this.aLT = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aLQ != null) {
            this.aLQ.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.H(list) != 0) {
            this.aLV = list;
            this.aLR = new d(this.aLV, this.aLS, this.aLU);
            this.aLR.eM(2);
            this.aLR.eN(1);
            this.aLQ.setDatas(this.aLR.FK());
            this.aLQ.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aLR.FJ(), false);
            if (this.aLR.FI() > 0) {
                if (this.aLR.FI() > this.aLU) {
                    if (this.aLM != null) {
                        this.aLM.setVisibility(0);
                        this.aLM.setOnClickListener(null);
                        if (this.aLN != null) {
                            this.aLN.setVisibility(8);
                        }
                    } else if (this.aLN != null && !this.aLS) {
                        this.aLN.setVisibility(8);
                    }
                    if (this.aLN != null && this.aLN.getVisibility() == 0 && this.aLN.getCount() != this.aLU) {
                        this.aLN.setCount(this.aLU);
                    }
                    FE();
                }
                if (this.aLR.FI() >= 2 && this.aLR.FI() <= this.aLU) {
                    if (this.aLM != null) {
                        this.aLM.setVisibility(8);
                    }
                    if (this.aLN != null) {
                        this.aLN.setVisibility(0);
                        if (this.aLN.getCount() != this.aLR.FI()) {
                            this.aLN.setCount(this.aLR.FI());
                        }
                    }
                    FE();
                }
                if (this.aLR.FI() < 2) {
                    if (this.aLM != null) {
                        this.aLM.setVisibility(8);
                    }
                    if (this.aLN != null) {
                        this.aLN.setVisibility(8);
                    }
                    FF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        int count;
        if (this.mViewPager != null && this.aLQ != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aLQ.getCount()) >= 2) {
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
        this.aLX = j;
    }

    public void FE() {
        if (this.aLT) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aLX);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void FF() {
        this.mHandler.removeMessages(1);
    }
}
