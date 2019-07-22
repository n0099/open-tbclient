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
    private TextView cdQ;
    private IndicatorView cdR;
    private BdBaseViewPagerAdapter cdU;
    private d cdV;
    private boolean cdW;
    private boolean cdX;
    private int cdY;
    private List<m> cdZ;
    private ViewPager.OnPageChangeListener cea;
    private long ceb;
    private ViewPager.OnPageChangeListener cec;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.cdW = false;
        this.cdX = true;
        this.cdY = 2;
        this.cdZ = new ArrayList();
        this.ceb = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.all();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cec = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.cea != null) {
                    b.this.cea.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aln();
                } else if (i == 0 && (count = b.this.cdU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alm();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.cea != null) {
                    b.this.cea.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.cdV != null && b.this.cdV.ji(i) == i) {
                    if (b.this.cdR != null) {
                        b.this.cdR.setPosition(b.this.cdV.jj(i));
                    }
                    if (b.this.cea != null) {
                        b.this.cea.onPageSelected(b.this.cdV.jj(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.cdW = false;
        this.cdX = true;
        this.cdY = 2;
        this.cdZ = new ArrayList();
        this.ceb = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.all();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cec = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.cea != null) {
                    b.this.cea.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aln();
                } else if (i2 == 0 && (count = b.this.cdU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alm();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.cea != null) {
                    b.this.cea.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.cdV != null && b.this.cdV.ji(i2) == i2) {
                    if (b.this.cdR != null) {
                        b.this.cdR.setPosition(b.this.cdV.jj(i2));
                    }
                    if (b.this.cea != null) {
                        b.this.cea.onPageSelected(b.this.cdV.jj(i2));
                    }
                }
            }
        };
        this.cdW = z;
        this.cdX = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.cdR = indicatorView;
        this.cdQ = textView;
        this.mContext = context;
        this.cdU = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.cdU);
            this.mViewPager.setOnPageChangeListener(this.cec);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.cdY = i;
        if (this.cdV != null) {
            this.cdV.jk(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.cdW = z;
    }

    public void ey(boolean z) {
        this.cdX = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.cdU != null) {
            this.cdU.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.Z(list) != 0) {
            this.cdZ = list;
            this.cdV = new d(this.cdZ, this.cdW, this.cdY);
            this.cdV.jl(2);
            this.cdV.jm(1);
            this.cdU.setDatas(this.cdV.als());
            this.cdU.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.cdV.alr(), false);
            if (this.cdV.alq() > 0) {
                if (this.cdV.alq() > this.cdY) {
                    if (this.cdQ != null) {
                        this.cdQ.setVisibility(0);
                        this.cdQ.setOnClickListener(null);
                        if (this.cdR != null) {
                            this.cdR.setVisibility(8);
                        }
                    } else if (this.cdR != null && !this.cdW) {
                        this.cdR.setVisibility(8);
                    }
                    if (this.cdR != null && this.cdR.getVisibility() == 0 && this.cdR.getCount() != this.cdY) {
                        this.cdR.setCount(this.cdY);
                    }
                    alm();
                }
                if (this.cdV.alq() >= 2 && this.cdV.alq() <= this.cdY) {
                    if (this.cdQ != null) {
                        this.cdQ.setVisibility(8);
                    }
                    if (this.cdR != null) {
                        this.cdR.setVisibility(0);
                        if (this.cdR.getCount() != this.cdV.alq()) {
                            this.cdR.setCount(this.cdV.alq());
                        }
                    }
                    alm();
                }
                if (this.cdV.alq() < 2) {
                    if (this.cdQ != null) {
                        this.cdQ.setVisibility(8);
                    }
                    if (this.cdR != null) {
                        this.cdR.setVisibility(8);
                    }
                    aln();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void all() {
        int count;
        if (this.mViewPager != null && this.cdU != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.cdU.getCount()) >= 2) {
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
        this.ceb = j;
    }

    public void alm() {
        if (this.cdX) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ceb);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aln() {
        this.mHandler.removeMessages(1);
    }
}
