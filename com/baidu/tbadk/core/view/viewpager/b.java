package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager.OnPageChangeListener bGq;
    private TextView dZh;
    private IndicatorView dZi;
    private BdBaseViewPagerAdapter dZl;
    private d dZm;
    private boolean dZn;
    private boolean dZo;
    private int dZp;
    private List<o> dZq;
    private long dZr;
    private ViewPager.OnPageChangeListener dZs;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dZn = false;
        this.dZo = true;
        this.dZp = 2;
        this.dZq = new ArrayList();
        this.dZr = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aXe();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dZs = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bGq != null) {
                    b.this.bGq.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aXg();
                } else if (i == 0 && (count = b.this.dZl.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aXf();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bGq != null) {
                    b.this.bGq.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dZm != null && b.this.dZm.mu(i) == i) {
                    if (b.this.dZi != null) {
                        b.this.dZi.setPosition(b.this.dZm.mv(i));
                    }
                    if (b.this.bGq != null) {
                        b.this.bGq.onPageSelected(b.this.dZm.mv(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dZn = false;
        this.dZo = true;
        this.dZp = 2;
        this.dZq = new ArrayList();
        this.dZr = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aXe();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dZs = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bGq != null) {
                    b.this.bGq.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aXg();
                } else if (i2 == 0 && (count = b.this.dZl.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aXf();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bGq != null) {
                    b.this.bGq.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dZm != null && b.this.dZm.mu(i2) == i2) {
                    if (b.this.dZi != null) {
                        b.this.dZi.setPosition(b.this.dZm.mv(i2));
                    }
                    if (b.this.bGq != null) {
                        b.this.bGq.onPageSelected(b.this.dZm.mv(i2));
                    }
                }
            }
        };
        this.dZn = z;
        this.dZo = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dZi = indicatorView;
        this.dZh = textView;
        this.mContext = context;
        this.dZl = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dZl);
            this.mViewPager.setOnPageChangeListener(this.dZs);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dZp = i;
        if (this.dZm != null) {
            this.dZm.mw(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dZn = z;
    }

    public void ht(boolean z) {
        this.dZo = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dZl != null) {
            this.dZl.a(context, cVar);
        }
    }

    public void setDatas(List<o> list) {
        if (v.getCount(list) != 0) {
            this.dZq = list;
            this.dZm = new d(this.dZq, this.dZn, this.dZp);
            this.dZm.mx(2);
            this.dZm.my(1);
            this.dZl.setDatas(this.dZm.aXl());
            this.dZl.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dZm.aXk(), false);
            if (this.dZm.aXj() > 0) {
                if (this.dZm.aXj() > this.dZp) {
                    if (this.dZh != null) {
                        this.dZh.setVisibility(0);
                        this.dZh.setOnClickListener(null);
                        if (this.dZi != null) {
                            this.dZi.setVisibility(8);
                        }
                    } else if (this.dZi != null && !this.dZn) {
                        this.dZi.setVisibility(8);
                    }
                    if (this.dZi != null && this.dZi.getVisibility() == 0 && this.dZi.getCount() != this.dZp) {
                        this.dZi.setCount(this.dZp);
                    }
                    aXf();
                }
                if (this.dZm.aXj() >= 2 && this.dZm.aXj() <= this.dZp) {
                    if (this.dZh != null) {
                        this.dZh.setVisibility(8);
                    }
                    if (this.dZi != null) {
                        this.dZi.setVisibility(0);
                        if (this.dZi.getCount() != this.dZm.aXj()) {
                            this.dZi.setCount(this.dZm.aXj());
                        }
                    }
                    aXf();
                }
                if (this.dZm.aXj() < 2) {
                    if (this.dZh != null) {
                        this.dZh.setVisibility(8);
                    }
                    if (this.dZi != null) {
                        this.dZi.setVisibility(8);
                    }
                    aXg();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        int count;
        if (this.mViewPager != null && this.dZl != null) {
            h E = i.E(this.mContext);
            if ((E == null || !E.isScroll()) && (count = this.dZl.getCount()) >= 2) {
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
        this.dZr = j;
    }

    public void aXf() {
        if (this.dZo) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dZr);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aXg() {
        this.mHandler.removeMessages(1);
    }
}
