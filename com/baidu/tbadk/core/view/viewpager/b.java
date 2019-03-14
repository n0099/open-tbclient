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
    private TextView bUP;
    private IndicatorView bUQ;
    private BdBaseViewPagerAdapter bUT;
    private d bUU;
    private boolean bUV;
    private boolean bUW;
    private int bUX;
    private List<m> bUY;
    private ViewPager.OnPageChangeListener bUZ;
    private long bVa;
    private ViewPager.OnPageChangeListener bVb;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.bUV = false;
        this.bUW = true;
        this.bUX = 2;
        this.bUY = new ArrayList();
        this.bVa = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.afk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.bVb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bUZ != null) {
                    b.this.bUZ.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.afm();
                } else if (i == 0 && (count = b.this.bUT.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.afl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bUZ != null) {
                    b.this.bUZ.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.bUU != null && b.this.bUU.ip(i) == i) {
                    if (b.this.bUQ != null) {
                        b.this.bUQ.setPosition(b.this.bUU.iq(i));
                    }
                    if (b.this.bUZ != null) {
                        b.this.bUZ.onPageSelected(b.this.bUU.iq(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.bUV = false;
        this.bUW = true;
        this.bUX = 2;
        this.bUY = new ArrayList();
        this.bVa = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.afk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.bVb = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bUZ != null) {
                    b.this.bUZ.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.afm();
                } else if (i2 == 0 && (count = b.this.bUT.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.afl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bUZ != null) {
                    b.this.bUZ.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.bUU != null && b.this.bUU.ip(i2) == i2) {
                    if (b.this.bUQ != null) {
                        b.this.bUQ.setPosition(b.this.bUU.iq(i2));
                    }
                    if (b.this.bUZ != null) {
                        b.this.bUZ.onPageSelected(b.this.bUU.iq(i2));
                    }
                }
            }
        };
        this.bUV = z;
        this.bUW = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.bUQ = indicatorView;
        this.bUP = textView;
        this.mContext = context;
        this.bUT = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.bUT);
            this.mViewPager.setOnPageChangeListener(this.bVb);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUX = i;
        if (this.bUU != null) {
            this.bUU.ir(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUV = z;
    }

    public void dX(boolean z) {
        this.bUW = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.bUT != null) {
            this.bUT.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.S(list) != 0) {
            this.bUY = list;
            this.bUU = new d(this.bUY, this.bUV, this.bUX);
            this.bUU.is(2);
            this.bUU.it(1);
            this.bUT.setDatas(this.bUU.afr());
            this.bUT.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.bUU.afq(), false);
            if (this.bUU.afp() > 0) {
                if (this.bUU.afp() > this.bUX) {
                    if (this.bUP != null) {
                        this.bUP.setVisibility(0);
                        this.bUP.setOnClickListener(null);
                        if (this.bUQ != null) {
                            this.bUQ.setVisibility(8);
                        }
                    } else if (this.bUQ != null && !this.bUV) {
                        this.bUQ.setVisibility(8);
                    }
                    if (this.bUQ != null && this.bUQ.getVisibility() == 0 && this.bUQ.getCount() != this.bUX) {
                        this.bUQ.setCount(this.bUX);
                    }
                    afl();
                }
                if (this.bUU.afp() >= 2 && this.bUU.afp() <= this.bUX) {
                    if (this.bUP != null) {
                        this.bUP.setVisibility(8);
                    }
                    if (this.bUQ != null) {
                        this.bUQ.setVisibility(0);
                        if (this.bUQ.getCount() != this.bUU.afp()) {
                            this.bUQ.setCount(this.bUU.afp());
                        }
                    }
                    afl();
                }
                if (this.bUU.afp() < 2) {
                    if (this.bUP != null) {
                        this.bUP.setVisibility(8);
                    }
                    if (this.bUQ != null) {
                        this.bUQ.setVisibility(8);
                    }
                    afm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        int count;
        if (this.mViewPager != null && this.bUT != null) {
            h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.bUT.getCount()) >= 2) {
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
        this.bVa = j;
    }

    public void afl() {
        if (this.bUW) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.bVa);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void afm() {
        this.mHandler.removeMessages(1);
    }
}
