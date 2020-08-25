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
/* loaded from: classes2.dex */
public class b {
    private ViewPager.OnPageChangeListener bQW;
    private ViewPager.OnPageChangeListener eyA;
    private TextView eyp;
    private IndicatorView eyq;
    private BdBaseViewPagerAdapter eyt;
    private d eyu;
    private boolean eyv;
    private boolean eyw;
    private int eyx;
    private List<q> eyy;
    private long eyz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eyv = false;
        this.eyw = true;
        this.eyx = 2;
        this.eyy = new ArrayList();
        this.eyz = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.blN();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eyA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bQW != null) {
                    b.this.bQW.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.blP();
                } else if (i == 0 && (count = b.this.eyt.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.blO();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bQW != null) {
                    b.this.bQW.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eyu != null && b.this.eyu.pp(i) == i) {
                    if (b.this.eyq != null) {
                        b.this.eyq.setPosition(b.this.eyu.pq(i));
                    }
                    if (b.this.bQW != null) {
                        b.this.bQW.onPageSelected(b.this.eyu.pq(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eyv = false;
        this.eyw = true;
        this.eyx = 2;
        this.eyy = new ArrayList();
        this.eyz = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.blN();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eyA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bQW != null) {
                    b.this.bQW.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.blP();
                } else if (i2 == 0 && (count = b.this.eyt.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.blO();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bQW != null) {
                    b.this.bQW.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eyu != null && b.this.eyu.pp(i2) == i2) {
                    if (b.this.eyq != null) {
                        b.this.eyq.setPosition(b.this.eyu.pq(i2));
                    }
                    if (b.this.bQW != null) {
                        b.this.bQW.onPageSelected(b.this.eyu.pq(i2));
                    }
                }
            }
        };
        this.eyv = z;
        this.eyw = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eyq = indicatorView;
        this.eyp = textView;
        this.mContext = context;
        this.eyt = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eyt);
            this.mViewPager.setOnPageChangeListener(this.eyA);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eyx = i;
        if (this.eyu != null) {
            this.eyu.pr(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eyv = z;
    }

    public void iE(boolean z) {
        this.eyw = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eyt != null) {
            this.eyt.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.eyy = list;
            this.eyu = new d(this.eyy, this.eyv, this.eyx);
            this.eyu.ps(2);
            this.eyu.pt(1);
            this.eyt.setDatas(this.eyu.blU());
            this.eyt.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eyu.blT(), false);
            if (this.eyu.blS() > 0) {
                if (this.eyu.blS() > this.eyx) {
                    if (this.eyp != null) {
                        this.eyp.setVisibility(0);
                        this.eyp.setOnClickListener(null);
                        if (this.eyq != null) {
                            this.eyq.setVisibility(8);
                        }
                    } else if (this.eyq != null && !this.eyv) {
                        this.eyq.setVisibility(8);
                    }
                    if (this.eyq != null && this.eyq.getVisibility() == 0 && this.eyq.getCount() != this.eyx) {
                        this.eyq.setCount(this.eyx);
                    }
                    blO();
                }
                if (this.eyu.blS() >= 2 && this.eyu.blS() <= this.eyx) {
                    if (this.eyp != null) {
                        this.eyp.setVisibility(8);
                    }
                    if (this.eyq != null) {
                        this.eyq.setVisibility(0);
                        if (this.eyq.getCount() != this.eyu.blS()) {
                            this.eyq.setCount(this.eyu.blS());
                        }
                    }
                    blO();
                }
                if (this.eyu.blS() < 2) {
                    if (this.eyp != null) {
                        this.eyp.setVisibility(8);
                    }
                    if (this.eyq != null) {
                        this.eyq.setVisibility(8);
                    }
                    blP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blN() {
        int count;
        if (this.mViewPager != null && this.eyt != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.eyt.getCount()) >= 2) {
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
        this.eyz = j;
    }

    public void blO() {
        if (this.eyw) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eyz);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void blP() {
        this.mHandler.removeMessages(1);
    }
}
