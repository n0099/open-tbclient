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
    private TextView aLK;
    private IndicatorView aLL;
    private BdBaseViewPagerAdapter aLO;
    private d aLP;
    private boolean aLQ;
    private boolean aLR;
    private int aLS;
    private List<h> aLT;
    private ViewPager.OnPageChangeListener aLU;
    private long aLV;
    private ViewPager.OnPageChangeListener aLW;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aLQ = false;
        this.aLR = true;
        this.aLS = 2;
        this.aLT = new ArrayList();
        this.aLV = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FC();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aLW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aLU != null) {
                    b.this.aLU.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.FE();
                } else if (i == 0 && (count = b.this.aLO.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FD();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aLU != null) {
                    b.this.aLU.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aLP != null && b.this.aLP.eI(i) == i) {
                    if (b.this.aLL != null) {
                        b.this.aLL.setPosition(b.this.aLP.eJ(i));
                    }
                    if (b.this.aLU != null) {
                        b.this.aLU.onPageSelected(b.this.aLP.eJ(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aLQ = false;
        this.aLR = true;
        this.aLS = 2;
        this.aLT = new ArrayList();
        this.aLV = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FC();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aLW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aLU != null) {
                    b.this.aLU.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.FE();
                } else if (i2 == 0 && (count = b.this.aLO.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FD();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aLU != null) {
                    b.this.aLU.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aLP != null && b.this.aLP.eI(i2) == i2) {
                    if (b.this.aLL != null) {
                        b.this.aLL.setPosition(b.this.aLP.eJ(i2));
                    }
                    if (b.this.aLU != null) {
                        b.this.aLU.onPageSelected(b.this.aLP.eJ(i2));
                    }
                }
            }
        };
        this.aLQ = z;
        this.aLR = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aLL = indicatorView;
        this.aLK = textView;
        this.mContext = context;
        this.aLO = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aLO);
            this.mViewPager.setOnPageChangeListener(this.aLW);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aLS = i;
        if (this.aLP != null) {
            this.aLP.eK(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aLQ = z;
    }

    public void bN(boolean z) {
        this.aLR = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aLO != null) {
            this.aLO.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.H(list) != 0) {
            this.aLT = list;
            this.aLP = new d(this.aLT, this.aLQ, this.aLS);
            this.aLP.eL(2);
            this.aLP.eM(1);
            this.aLO.setDatas(this.aLP.FJ());
            this.aLO.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aLP.FI(), false);
            if (this.aLP.FH() > 0) {
                if (this.aLP.FH() > this.aLS) {
                    if (this.aLK != null) {
                        this.aLK.setVisibility(0);
                        this.aLK.setOnClickListener(null);
                        if (this.aLL != null) {
                            this.aLL.setVisibility(8);
                        }
                    } else if (this.aLL != null && !this.aLQ) {
                        this.aLL.setVisibility(8);
                    }
                    if (this.aLL != null && this.aLL.getVisibility() == 0 && this.aLL.getCount() != this.aLS) {
                        this.aLL.setCount(this.aLS);
                    }
                    FD();
                }
                if (this.aLP.FH() >= 2 && this.aLP.FH() <= this.aLS) {
                    if (this.aLK != null) {
                        this.aLK.setVisibility(8);
                    }
                    if (this.aLL != null) {
                        this.aLL.setVisibility(0);
                        if (this.aLL.getCount() != this.aLP.FH()) {
                            this.aLL.setCount(this.aLP.FH());
                        }
                    }
                    FD();
                }
                if (this.aLP.FH() < 2) {
                    if (this.aLK != null) {
                        this.aLK.setVisibility(8);
                    }
                    if (this.aLL != null) {
                        this.aLL.setVisibility(8);
                    }
                    FE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        int count;
        if (this.mViewPager != null && this.aLO != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aLO.getCount()) >= 2) {
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
        this.aLV = j;
    }

    public void FD() {
        if (this.aLR) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aLV);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void FE() {
        this.mHandler.removeMessages(1);
    }
}
