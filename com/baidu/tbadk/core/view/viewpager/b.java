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
    private ViewPager.OnPageChangeListener cyV;
    private boolean fhA;
    private boolean fhB;
    private int fhC;
    private List<q> fhD;
    private long fhE;
    private ViewPager.OnPageChangeListener fhF;
    private TextView fhu;
    private IndicatorView fhv;
    private BdBaseViewPagerAdapter fhy;
    private d fhz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.fhA = false;
        this.fhB = true;
        this.fhC = 2;
        this.fhD = new ArrayList();
        this.fhE = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bwA();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fhF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.cyV != null) {
                    b.this.cyV.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.bwC();
                } else if (i == 0 && (count = b.this.fhy.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bwB();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.cyV != null) {
                    b.this.cyV.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.fhz != null && b.this.fhz.ru(i) == i) {
                    if (b.this.fhv != null) {
                        b.this.fhv.setPosition(b.this.fhz.rv(i));
                    }
                    if (b.this.cyV != null) {
                        b.this.cyV.onPageSelected(b.this.fhz.rv(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.fhA = false;
        this.fhB = true;
        this.fhC = 2;
        this.fhD = new ArrayList();
        this.fhE = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bwA();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fhF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.cyV != null) {
                    b.this.cyV.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.bwC();
                } else if (i2 == 0 && (count = b.this.fhy.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bwB();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.cyV != null) {
                    b.this.cyV.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.fhz != null && b.this.fhz.ru(i2) == i2) {
                    if (b.this.fhv != null) {
                        b.this.fhv.setPosition(b.this.fhz.rv(i2));
                    }
                    if (b.this.cyV != null) {
                        b.this.cyV.onPageSelected(b.this.fhz.rv(i2));
                    }
                }
            }
        };
        this.fhA = z;
        this.fhB = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.fhv = indicatorView;
        this.fhu = textView;
        this.mContext = context;
        this.fhy = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.fhy);
            this.mViewPager.setOnPageChangeListener(this.fhF);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.fhC = i;
        if (this.fhz != null) {
            this.fhz.rw(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fhA = z;
    }

    public void jN(boolean z) {
        this.fhB = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.fhy != null) {
            this.fhy.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.fhD = list;
            this.fhz = new d(this.fhD, this.fhA, this.fhC);
            this.fhz.rx(2);
            this.fhz.ry(1);
            this.fhy.setDatas(this.fhz.bwH());
            this.fhy.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.fhz.bwG(), false);
            if (this.fhz.bwF() > 0) {
                if (this.fhz.bwF() > this.fhC) {
                    if (this.fhu != null) {
                        this.fhu.setVisibility(0);
                        this.fhu.setOnClickListener(null);
                        if (this.fhv != null) {
                            this.fhv.setVisibility(8);
                        }
                    } else if (this.fhv != null && !this.fhA) {
                        this.fhv.setVisibility(8);
                    }
                    if (this.fhv != null && this.fhv.getVisibility() == 0 && this.fhv.getCount() != this.fhC) {
                        this.fhv.setCount(this.fhC);
                    }
                    bwB();
                }
                if (this.fhz.bwF() >= 2 && this.fhz.bwF() <= this.fhC) {
                    if (this.fhu != null) {
                        this.fhu.setVisibility(8);
                    }
                    if (this.fhv != null) {
                        this.fhv.setVisibility(0);
                        if (this.fhv.getCount() != this.fhz.bwF()) {
                            this.fhv.setCount(this.fhz.bwF());
                        }
                    }
                    bwB();
                }
                if (this.fhz.bwF() < 2) {
                    if (this.fhu != null) {
                        this.fhu.setVisibility(8);
                    }
                    if (this.fhv != null) {
                        this.fhv.setVisibility(8);
                    }
                    bwC();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwA() {
        int count;
        if (this.mViewPager != null && this.fhy != null) {
            h H = i.H(this.mContext);
            if ((H == null || !H.isScroll()) && (count = this.fhy.getCount()) >= 2) {
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
        this.fhE = j;
    }

    public void bwB() {
        if (this.fhB) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fhE);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bwC() {
        this.mHandler.removeMessages(1);
    }
}
