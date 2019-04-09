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
    private TextView bUS;
    private IndicatorView bUT;
    private BdBaseViewPagerAdapter bUW;
    private d bUX;
    private boolean bUY;
    private boolean bUZ;
    private int bVa;
    private List<m> bVb;
    private ViewPager.OnPageChangeListener bVc;
    private long bVd;
    private ViewPager.OnPageChangeListener bVe;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.bUY = false;
        this.bUZ = true;
        this.bVa = 2;
        this.bVb = new ArrayList();
        this.bVd = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.afh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.bVe = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bVc != null) {
                    b.this.bVc.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.afj();
                } else if (i == 0 && (count = b.this.bUW.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.afi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bVc != null) {
                    b.this.bVc.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.bUX != null && b.this.bUX.io(i) == i) {
                    if (b.this.bUT != null) {
                        b.this.bUT.setPosition(b.this.bUX.ip(i));
                    }
                    if (b.this.bVc != null) {
                        b.this.bVc.onPageSelected(b.this.bUX.ip(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.bUY = false;
        this.bUZ = true;
        this.bVa = 2;
        this.bVb = new ArrayList();
        this.bVd = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.afh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.bVe = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bVc != null) {
                    b.this.bVc.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.afj();
                } else if (i2 == 0 && (count = b.this.bUW.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.afi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bVc != null) {
                    b.this.bVc.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.bUX != null && b.this.bUX.io(i2) == i2) {
                    if (b.this.bUT != null) {
                        b.this.bUT.setPosition(b.this.bUX.ip(i2));
                    }
                    if (b.this.bVc != null) {
                        b.this.bVc.onPageSelected(b.this.bUX.ip(i2));
                    }
                }
            }
        };
        this.bUY = z;
        this.bUZ = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.bUT = indicatorView;
        this.bUS = textView;
        this.mContext = context;
        this.bUW = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.bUW);
            this.mViewPager.setOnPageChangeListener(this.bVe);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.bVa = i;
        if (this.bUX != null) {
            this.bUX.iq(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUY = z;
    }

    public void dX(boolean z) {
        this.bUZ = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.bUW != null) {
            this.bUW.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.S(list) != 0) {
            this.bVb = list;
            this.bUX = new d(this.bVb, this.bUY, this.bVa);
            this.bUX.ir(2);
            this.bUX.is(1);
            this.bUW.setDatas(this.bUX.afo());
            this.bUW.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.bUX.afn(), false);
            if (this.bUX.afm() > 0) {
                if (this.bUX.afm() > this.bVa) {
                    if (this.bUS != null) {
                        this.bUS.setVisibility(0);
                        this.bUS.setOnClickListener(null);
                        if (this.bUT != null) {
                            this.bUT.setVisibility(8);
                        }
                    } else if (this.bUT != null && !this.bUY) {
                        this.bUT.setVisibility(8);
                    }
                    if (this.bUT != null && this.bUT.getVisibility() == 0 && this.bUT.getCount() != this.bVa) {
                        this.bUT.setCount(this.bVa);
                    }
                    afi();
                }
                if (this.bUX.afm() >= 2 && this.bUX.afm() <= this.bVa) {
                    if (this.bUS != null) {
                        this.bUS.setVisibility(8);
                    }
                    if (this.bUT != null) {
                        this.bUT.setVisibility(0);
                        if (this.bUT.getCount() != this.bUX.afm()) {
                            this.bUT.setCount(this.bUX.afm());
                        }
                    }
                    afi();
                }
                if (this.bUX.afm() < 2) {
                    if (this.bUS != null) {
                        this.bUS.setVisibility(8);
                    }
                    if (this.bUT != null) {
                        this.bUT.setVisibility(8);
                    }
                    afj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        int count;
        if (this.mViewPager != null && this.bUW != null) {
            h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.bUW.getCount()) >= 2) {
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
        this.bVd = j;
    }

    public void afi() {
        if (this.bUZ) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.bVd);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void afj() {
        this.mHandler.removeMessages(1);
    }
}
