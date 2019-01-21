package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private long aMA;
    private ViewPager.OnPageChangeListener aMB;
    private TextView aMp;
    private IndicatorView aMq;
    private BdBaseViewPagerAdapter aMt;
    private d aMu;
    private boolean aMv;
    private boolean aMw;
    private int aMx;
    private List<h> aMy;
    private ViewPager.OnPageChangeListener aMz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aMv = false;
        this.aMw = true;
        this.aMx = 2;
        this.aMy = new ArrayList();
        this.aMA = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FQ();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aMB = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aMz != null) {
                    b.this.aMz.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.FS();
                } else if (i == 0 && (count = b.this.aMt.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FR();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aMz != null) {
                    b.this.aMz.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aMu != null && b.this.aMu.eJ(i) == i) {
                    if (b.this.aMq != null) {
                        b.this.aMq.setPosition(b.this.aMu.eK(i));
                    }
                    if (b.this.aMz != null) {
                        b.this.aMz.onPageSelected(b.this.aMu.eK(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aMv = false;
        this.aMw = true;
        this.aMx = 2;
        this.aMy = new ArrayList();
        this.aMA = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.FQ();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aMB = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aMz != null) {
                    b.this.aMz.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.FS();
                } else if (i2 == 0 && (count = b.this.aMt.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.FR();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aMz != null) {
                    b.this.aMz.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aMu != null && b.this.aMu.eJ(i2) == i2) {
                    if (b.this.aMq != null) {
                        b.this.aMq.setPosition(b.this.aMu.eK(i2));
                    }
                    if (b.this.aMz != null) {
                        b.this.aMz.onPageSelected(b.this.aMu.eK(i2));
                    }
                }
            }
        };
        this.aMv = z;
        this.aMw = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aMq = indicatorView;
        this.aMp = textView;
        this.mContext = context;
        this.aMt = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aMt);
            this.mViewPager.setOnPageChangeListener(this.aMB);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aMx = i;
        if (this.aMu != null) {
            this.aMu.eL(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aMv = z;
    }

    public void bO(boolean z) {
        this.aMw = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aMt != null) {
            this.aMt.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.H(list) != 0) {
            this.aMy = list;
            this.aMu = new d(this.aMy, this.aMv, this.aMx);
            this.aMu.eM(2);
            this.aMu.eN(1);
            this.aMt.setDatas(this.aMu.FX());
            this.aMt.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aMu.FW(), false);
            if (this.aMu.FV() > 0) {
                if (this.aMu.FV() > this.aMx) {
                    if (this.aMp != null) {
                        this.aMp.setVisibility(0);
                        this.aMp.setOnClickListener(null);
                        if (this.aMq != null) {
                            this.aMq.setVisibility(8);
                        }
                    } else if (this.aMq != null && !this.aMv) {
                        this.aMq.setVisibility(8);
                    }
                    if (this.aMq != null && this.aMq.getVisibility() == 0 && this.aMq.getCount() != this.aMx) {
                        this.aMq.setCount(this.aMx);
                    }
                    FR();
                }
                if (this.aMu.FV() >= 2 && this.aMu.FV() <= this.aMx) {
                    if (this.aMp != null) {
                        this.aMp.setVisibility(8);
                    }
                    if (this.aMq != null) {
                        this.aMq.setVisibility(0);
                        if (this.aMq.getCount() != this.aMu.FV()) {
                            this.aMq.setCount(this.aMu.FV());
                        }
                    }
                    FR();
                }
                if (this.aMu.FV() < 2) {
                    if (this.aMp != null) {
                        this.aMp.setVisibility(8);
                    }
                    if (this.aMq != null) {
                        this.aMq.setVisibility(8);
                    }
                    FS();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ() {
        int count;
        if (this.mViewPager != null && this.aMt != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aMt.getCount()) >= 2) {
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
        this.aMA = j;
    }

    public void FR() {
        if (this.aMw) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aMA);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void FS() {
        this.mHandler.removeMessages(1);
    }
}
