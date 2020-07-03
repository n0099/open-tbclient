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
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager.OnPageChangeListener bLe;
    private TextView ehR;
    private IndicatorView ehS;
    private BdBaseViewPagerAdapter ehV;
    private d ehW;
    private boolean ehX;
    private boolean ehY;
    private int ehZ;
    private List<q> eia;
    private long eib;
    private ViewPager.OnPageChangeListener eic;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ehX = false;
        this.ehY = true;
        this.ehZ = 2;
        this.eia = new ArrayList();
        this.eib = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aZk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eic = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bLe != null) {
                    b.this.bLe.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aZm();
                } else if (i == 0 && (count = b.this.ehV.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aZl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bLe != null) {
                    b.this.bLe.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.ehW != null && b.this.ehW.mO(i) == i) {
                    if (b.this.ehS != null) {
                        b.this.ehS.setPosition(b.this.ehW.mP(i));
                    }
                    if (b.this.bLe != null) {
                        b.this.bLe.onPageSelected(b.this.ehW.mP(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ehX = false;
        this.ehY = true;
        this.ehZ = 2;
        this.eia = new ArrayList();
        this.eib = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aZk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eic = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bLe != null) {
                    b.this.bLe.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aZm();
                } else if (i2 == 0 && (count = b.this.ehV.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aZl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bLe != null) {
                    b.this.bLe.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.ehW != null && b.this.ehW.mO(i2) == i2) {
                    if (b.this.ehS != null) {
                        b.this.ehS.setPosition(b.this.ehW.mP(i2));
                    }
                    if (b.this.bLe != null) {
                        b.this.bLe.onPageSelected(b.this.ehW.mP(i2));
                    }
                }
            }
        };
        this.ehX = z;
        this.ehY = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ehS = indicatorView;
        this.ehR = textView;
        this.mContext = context;
        this.ehV = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ehV);
            this.mViewPager.setOnPageChangeListener(this.eic);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ehZ = i;
        if (this.ehW != null) {
            this.ehW.mQ(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ehX = z;
    }

    public void hC(boolean z) {
        this.ehY = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ehV != null) {
            this.ehV.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (w.getCount(list) != 0) {
            this.eia = list;
            this.ehW = new d(this.eia, this.ehX, this.ehZ);
            this.ehW.mR(2);
            this.ehW.mS(1);
            this.ehV.setDatas(this.ehW.aZr());
            this.ehV.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ehW.aZq(), false);
            if (this.ehW.aZp() > 0) {
                if (this.ehW.aZp() > this.ehZ) {
                    if (this.ehR != null) {
                        this.ehR.setVisibility(0);
                        this.ehR.setOnClickListener(null);
                        if (this.ehS != null) {
                            this.ehS.setVisibility(8);
                        }
                    } else if (this.ehS != null && !this.ehX) {
                        this.ehS.setVisibility(8);
                    }
                    if (this.ehS != null && this.ehS.getVisibility() == 0 && this.ehS.getCount() != this.ehZ) {
                        this.ehS.setCount(this.ehZ);
                    }
                    aZl();
                }
                if (this.ehW.aZp() >= 2 && this.ehW.aZp() <= this.ehZ) {
                    if (this.ehR != null) {
                        this.ehR.setVisibility(8);
                    }
                    if (this.ehS != null) {
                        this.ehS.setVisibility(0);
                        if (this.ehS.getCount() != this.ehW.aZp()) {
                            this.ehS.setCount(this.ehW.aZp());
                        }
                    }
                    aZl();
                }
                if (this.ehW.aZp() < 2) {
                    if (this.ehR != null) {
                        this.ehR.setVisibility(8);
                    }
                    if (this.ehS != null) {
                        this.ehS.setVisibility(8);
                    }
                    aZm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZk() {
        int count;
        if (this.mViewPager != null && this.ehV != null) {
            h E = i.E(this.mContext);
            if ((E == null || !E.isScroll()) && (count = this.ehV.getCount()) >= 2) {
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
        this.eib = j;
    }

    public void aZl() {
        if (this.ehY) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eib);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aZm() {
        this.mHandler.removeMessages(1);
    }
}
