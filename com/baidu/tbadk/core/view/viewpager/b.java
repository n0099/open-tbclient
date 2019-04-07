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
    private TextView bUR;
    private IndicatorView bUS;
    private BdBaseViewPagerAdapter bUV;
    private d bUW;
    private boolean bUX;
    private boolean bUY;
    private int bUZ;
    private List<m> bVa;
    private ViewPager.OnPageChangeListener bVb;
    private long bVc;
    private ViewPager.OnPageChangeListener bVd;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.bUX = false;
        this.bUY = true;
        this.bUZ = 2;
        this.bVa = new ArrayList();
        this.bVc = 5000L;
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
        this.bVd = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bVb != null) {
                    b.this.bVb.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.afj();
                } else if (i == 0 && (count = b.this.bUV.getCount()) >= 2) {
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
                if (b.this.bVb != null) {
                    b.this.bVb.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.bUW != null && b.this.bUW.io(i) == i) {
                    if (b.this.bUS != null) {
                        b.this.bUS.setPosition(b.this.bUW.ip(i));
                    }
                    if (b.this.bVb != null) {
                        b.this.bVb.onPageSelected(b.this.bUW.ip(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.bUX = false;
        this.bUY = true;
        this.bUZ = 2;
        this.bVa = new ArrayList();
        this.bVc = 5000L;
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
        this.bVd = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bVb != null) {
                    b.this.bVb.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.afj();
                } else if (i2 == 0 && (count = b.this.bUV.getCount()) >= 2) {
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
                if (b.this.bVb != null) {
                    b.this.bVb.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.bUW != null && b.this.bUW.io(i2) == i2) {
                    if (b.this.bUS != null) {
                        b.this.bUS.setPosition(b.this.bUW.ip(i2));
                    }
                    if (b.this.bVb != null) {
                        b.this.bVb.onPageSelected(b.this.bUW.ip(i2));
                    }
                }
            }
        };
        this.bUX = z;
        this.bUY = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.bUS = indicatorView;
        this.bUR = textView;
        this.mContext = context;
        this.bUV = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.bUV);
            this.mViewPager.setOnPageChangeListener(this.bVd);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUZ = i;
        if (this.bUW != null) {
            this.bUW.iq(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUX = z;
    }

    public void dX(boolean z) {
        this.bUY = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.bUV != null) {
            this.bUV.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.S(list) != 0) {
            this.bVa = list;
            this.bUW = new d(this.bVa, this.bUX, this.bUZ);
            this.bUW.ir(2);
            this.bUW.is(1);
            this.bUV.setDatas(this.bUW.afo());
            this.bUV.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.bUW.afn(), false);
            if (this.bUW.afm() > 0) {
                if (this.bUW.afm() > this.bUZ) {
                    if (this.bUR != null) {
                        this.bUR.setVisibility(0);
                        this.bUR.setOnClickListener(null);
                        if (this.bUS != null) {
                            this.bUS.setVisibility(8);
                        }
                    } else if (this.bUS != null && !this.bUX) {
                        this.bUS.setVisibility(8);
                    }
                    if (this.bUS != null && this.bUS.getVisibility() == 0 && this.bUS.getCount() != this.bUZ) {
                        this.bUS.setCount(this.bUZ);
                    }
                    afi();
                }
                if (this.bUW.afm() >= 2 && this.bUW.afm() <= this.bUZ) {
                    if (this.bUR != null) {
                        this.bUR.setVisibility(8);
                    }
                    if (this.bUS != null) {
                        this.bUS.setVisibility(0);
                        if (this.bUS.getCount() != this.bUW.afm()) {
                            this.bUS.setCount(this.bUW.afm());
                        }
                    }
                    afi();
                }
                if (this.bUW.afm() < 2) {
                    if (this.bUR != null) {
                        this.bUR.setVisibility(8);
                    }
                    if (this.bUS != null) {
                        this.bUS.setVisibility(8);
                    }
                    afj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        int count;
        if (this.mViewPager != null && this.bUV != null) {
            h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.bUV.getCount()) >= 2) {
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
        this.bVc = j;
    }

    public void afi() {
        if (this.bUY) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.bVc);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void afj() {
        this.mHandler.removeMessages(1);
    }
}
