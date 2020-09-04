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
    private ViewPager.OnPageChangeListener bRa;
    private boolean eyA;
    private int eyB;
    private List<q> eyC;
    private long eyD;
    private ViewPager.OnPageChangeListener eyE;
    private TextView eyt;
    private IndicatorView eyu;
    private BdBaseViewPagerAdapter eyx;
    private d eyy;
    private boolean eyz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eyz = false;
        this.eyA = true;
        this.eyB = 2;
        this.eyC = new ArrayList();
        this.eyD = 5000L;
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
        this.eyE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bRa != null) {
                    b.this.bRa.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.blP();
                } else if (i == 0 && (count = b.this.eyx.getCount()) >= 2) {
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
                if (b.this.bRa != null) {
                    b.this.bRa.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eyy != null && b.this.eyy.pp(i) == i) {
                    if (b.this.eyu != null) {
                        b.this.eyu.setPosition(b.this.eyy.pq(i));
                    }
                    if (b.this.bRa != null) {
                        b.this.bRa.onPageSelected(b.this.eyy.pq(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eyz = false;
        this.eyA = true;
        this.eyB = 2;
        this.eyC = new ArrayList();
        this.eyD = 5000L;
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
        this.eyE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bRa != null) {
                    b.this.bRa.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.blP();
                } else if (i2 == 0 && (count = b.this.eyx.getCount()) >= 2) {
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
                if (b.this.bRa != null) {
                    b.this.bRa.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eyy != null && b.this.eyy.pp(i2) == i2) {
                    if (b.this.eyu != null) {
                        b.this.eyu.setPosition(b.this.eyy.pq(i2));
                    }
                    if (b.this.bRa != null) {
                        b.this.bRa.onPageSelected(b.this.eyy.pq(i2));
                    }
                }
            }
        };
        this.eyz = z;
        this.eyA = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eyu = indicatorView;
        this.eyt = textView;
        this.mContext = context;
        this.eyx = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eyx);
            this.mViewPager.setOnPageChangeListener(this.eyE);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eyB = i;
        if (this.eyy != null) {
            this.eyy.pr(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eyz = z;
    }

    public void iF(boolean z) {
        this.eyA = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eyx != null) {
            this.eyx.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.eyC = list;
            this.eyy = new d(this.eyC, this.eyz, this.eyB);
            this.eyy.ps(2);
            this.eyy.pt(1);
            this.eyx.setDatas(this.eyy.blU());
            this.eyx.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eyy.blT(), false);
            if (this.eyy.blS() > 0) {
                if (this.eyy.blS() > this.eyB) {
                    if (this.eyt != null) {
                        this.eyt.setVisibility(0);
                        this.eyt.setOnClickListener(null);
                        if (this.eyu != null) {
                            this.eyu.setVisibility(8);
                        }
                    } else if (this.eyu != null && !this.eyz) {
                        this.eyu.setVisibility(8);
                    }
                    if (this.eyu != null && this.eyu.getVisibility() == 0 && this.eyu.getCount() != this.eyB) {
                        this.eyu.setCount(this.eyB);
                    }
                    blO();
                }
                if (this.eyy.blS() >= 2 && this.eyy.blS() <= this.eyB) {
                    if (this.eyt != null) {
                        this.eyt.setVisibility(8);
                    }
                    if (this.eyu != null) {
                        this.eyu.setVisibility(0);
                        if (this.eyu.getCount() != this.eyy.blS()) {
                            this.eyu.setCount(this.eyy.blS());
                        }
                    }
                    blO();
                }
                if (this.eyy.blS() < 2) {
                    if (this.eyt != null) {
                        this.eyt.setVisibility(8);
                    }
                    if (this.eyu != null) {
                        this.eyu.setVisibility(8);
                    }
                    blP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blN() {
        int count;
        if (this.mViewPager != null && this.eyx != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.eyx.getCount()) >= 2) {
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
        this.eyD = j;
    }

    public void blO() {
        if (this.eyA) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eyD);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void blP() {
        this.mHandler.removeMessages(1);
    }
}
