package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ViewPager Zi;
    private ViewPager.OnPageChangeListener czc;
    private c fmA;
    private boolean fmB;
    private boolean fmC;
    private int fmD;
    private List<n> fmE;
    private long fmF;
    private ViewPager.OnPageChangeListener fmG;
    private TextView fmv;
    private IndicatorView fmw;
    private BdBaseViewPagerAdapter fmz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.fmB = false;
        this.fmC = true;
        this.fmD = 2;
        this.fmE = new ArrayList();
        this.fmF = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bva();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fmG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (a.this.czc != null) {
                    a.this.czc.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    a.this.bvc();
                } else if (i == 0 && (count = a.this.fmz.getCount()) >= 2) {
                    int currentItem = a.this.Zi.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        a.this.Zi.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        a.this.Zi.setCurrentItem(1, false);
                    }
                    a.this.bvb();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (a.this.czc != null) {
                    a.this.czc.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (a.this.fmA != null && a.this.fmA.qa(i) == i) {
                    if (a.this.fmw != null) {
                        a.this.fmw.setPosition(a.this.fmA.qb(i));
                    }
                    if (a.this.czc != null) {
                        a.this.czc.onPageSelected(a.this.fmA.qb(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.fmB = false;
        this.fmC = true;
        this.fmD = 2;
        this.fmE = new ArrayList();
        this.fmF = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bva();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fmG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (a.this.czc != null) {
                    a.this.czc.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    a.this.bvc();
                } else if (i2 == 0 && (count = a.this.fmz.getCount()) >= 2) {
                    int currentItem = a.this.Zi.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        a.this.Zi.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        a.this.Zi.setCurrentItem(1, false);
                    }
                    a.this.bvb();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (a.this.czc != null) {
                    a.this.czc.onPageScrolled(i2, f, i22);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (a.this.fmA != null && a.this.fmA.qa(i2) == i2) {
                    if (a.this.fmw != null) {
                        a.this.fmw.setPosition(a.this.fmA.qb(i2));
                    }
                    if (a.this.czc != null) {
                        a.this.czc.onPageSelected(a.this.fmA.qb(i2));
                    }
                }
            }
        };
        this.fmB = z;
        this.fmC = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.Zi = viewPager;
        this.fmw = indicatorView;
        this.fmv = textView;
        this.mContext = context;
        this.fmz = new BdBaseViewPagerAdapter(context);
        if (this.Zi != null) {
            this.Zi.setAdapter(this.fmz);
            this.Zi.setOnPageChangeListener(this.fmG);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.fmD = i;
        if (this.fmA != null) {
            this.fmA.qc(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fmB = z;
    }

    public void kf(boolean z) {
        this.fmC = z;
    }

    public void a(Context context, b<?, ?> bVar) {
        if (this.fmz != null) {
            this.fmz.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        if (x.getCount(list) != 0) {
            this.fmE = list;
            this.fmA = new c(this.fmE, this.fmB, this.fmD);
            this.fmA.qd(2);
            this.fmA.qe(1);
            this.fmz.setDatas(this.fmA.bvh());
            this.fmz.notifyDataSetChanged();
            this.Zi.setCurrentItem(this.fmA.bvg(), false);
            if (this.fmA.bvf() > 0) {
                if (this.fmA.bvf() > this.fmD) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(0);
                        this.fmv.setOnClickListener(null);
                        if (this.fmw != null) {
                            this.fmw.setVisibility(8);
                        }
                    } else if (this.fmw != null && !this.fmB) {
                        this.fmw.setVisibility(8);
                    }
                    if (this.fmw != null && this.fmw.getVisibility() == 0 && this.fmw.getCount() != this.fmD) {
                        this.fmw.setCount(this.fmD);
                    }
                    bvb();
                }
                if (this.fmA.bvf() >= 2 && this.fmA.bvf() <= this.fmD) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(8);
                    }
                    if (this.fmw != null) {
                        this.fmw.setVisibility(0);
                        if (this.fmw.getCount() != this.fmA.bvf()) {
                            this.fmw.setCount(this.fmA.bvf());
                        }
                    }
                    bvb();
                }
                if (this.fmA.bvf() < 2) {
                    if (this.fmv != null) {
                        this.fmv.setVisibility(8);
                    }
                    if (this.fmw != null) {
                        this.fmw.setVisibility(8);
                    }
                    bvc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bva() {
        int count;
        if (this.Zi != null && this.fmz != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.fmz.getCount()) >= 2) {
                int currentItem = this.Zi.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.Zi.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.Zi.setCurrentItem(1, false);
                } else {
                    this.Zi.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.fmF = j;
    }

    public void bvb() {
        if (this.fmC) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fmF);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvc() {
        this.mHandler.removeMessages(1);
    }
}
