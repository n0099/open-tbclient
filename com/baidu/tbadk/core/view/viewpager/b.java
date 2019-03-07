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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private TextView bUO;
    private IndicatorView bUP;
    private BdBaseViewPagerAdapter bUS;
    private d bUT;
    private boolean bUU;
    private boolean bUV;
    private int bUW;
    private List<m> bUX;
    private ViewPager.OnPageChangeListener bUY;
    private long bUZ;
    private ViewPager.OnPageChangeListener bVa;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.bUU = false;
        this.bUV = true;
        this.bUW = 2;
        this.bUX = new ArrayList();
        this.bUZ = TbConfig.NOTIFY_SOUND_INTERVAL;
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
        this.bVa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bUY != null) {
                    b.this.bUY.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.afm();
                } else if (i == 0 && (count = b.this.bUS.getCount()) >= 2) {
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
                if (b.this.bUY != null) {
                    b.this.bUY.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.bUT != null && b.this.bUT.ip(i) == i) {
                    if (b.this.bUP != null) {
                        b.this.bUP.setPosition(b.this.bUT.iq(i));
                    }
                    if (b.this.bUY != null) {
                        b.this.bUY.onPageSelected(b.this.bUT.iq(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.bUU = false;
        this.bUV = true;
        this.bUW = 2;
        this.bUX = new ArrayList();
        this.bUZ = TbConfig.NOTIFY_SOUND_INTERVAL;
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
        this.bVa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bUY != null) {
                    b.this.bUY.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.afm();
                } else if (i2 == 0 && (count = b.this.bUS.getCount()) >= 2) {
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
                if (b.this.bUY != null) {
                    b.this.bUY.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.bUT != null && b.this.bUT.ip(i2) == i2) {
                    if (b.this.bUP != null) {
                        b.this.bUP.setPosition(b.this.bUT.iq(i2));
                    }
                    if (b.this.bUY != null) {
                        b.this.bUY.onPageSelected(b.this.bUT.iq(i2));
                    }
                }
            }
        };
        this.bUU = z;
        this.bUV = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.bUP = indicatorView;
        this.bUO = textView;
        this.mContext = context;
        this.bUS = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.bUS);
            this.mViewPager.setOnPageChangeListener(this.bVa);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUW = i;
        if (this.bUT != null) {
            this.bUT.ir(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUU = z;
    }

    public void dX(boolean z) {
        this.bUV = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.bUS != null) {
            this.bUS.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.S(list) != 0) {
            this.bUX = list;
            this.bUT = new d(this.bUX, this.bUU, this.bUW);
            this.bUT.is(2);
            this.bUT.it(1);
            this.bUS.setDatas(this.bUT.afr());
            this.bUS.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.bUT.afq(), false);
            if (this.bUT.afp() > 0) {
                if (this.bUT.afp() > this.bUW) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(0);
                        this.bUO.setOnClickListener(null);
                        if (this.bUP != null) {
                            this.bUP.setVisibility(8);
                        }
                    } else if (this.bUP != null && !this.bUU) {
                        this.bUP.setVisibility(8);
                    }
                    if (this.bUP != null && this.bUP.getVisibility() == 0 && this.bUP.getCount() != this.bUW) {
                        this.bUP.setCount(this.bUW);
                    }
                    afl();
                }
                if (this.bUT.afp() >= 2 && this.bUT.afp() <= this.bUW) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(8);
                    }
                    if (this.bUP != null) {
                        this.bUP.setVisibility(0);
                        if (this.bUP.getCount() != this.bUT.afp()) {
                            this.bUP.setCount(this.bUT.afp());
                        }
                    }
                    afl();
                }
                if (this.bUT.afp() < 2) {
                    if (this.bUO != null) {
                        this.bUO.setVisibility(8);
                    }
                    if (this.bUP != null) {
                        this.bUP.setVisibility(8);
                    }
                    afm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        int count;
        if (this.mViewPager != null && this.bUS != null) {
            h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.bUS.getCount()) >= 2) {
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
        this.bUZ = j;
    }

    public void afl() {
        if (this.bUV) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.bUZ);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void afm() {
        this.mHandler.removeMessages(1);
    }
}
