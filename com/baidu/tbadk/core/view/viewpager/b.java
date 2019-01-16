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
    private ViewPager.OnPageChangeListener aMA;
    private TextView aMo;
    private IndicatorView aMp;
    private BdBaseViewPagerAdapter aMs;
    private d aMt;
    private boolean aMu;
    private boolean aMv;
    private int aMw;
    private List<h> aMx;
    private ViewPager.OnPageChangeListener aMy;
    private long aMz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aMu = false;
        this.aMv = true;
        this.aMw = 2;
        this.aMx = new ArrayList();
        this.aMz = 5000L;
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
        this.aMA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aMy != null) {
                    b.this.aMy.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.FS();
                } else if (i == 0 && (count = b.this.aMs.getCount()) >= 2) {
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
                if (b.this.aMy != null) {
                    b.this.aMy.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aMt != null && b.this.aMt.eJ(i) == i) {
                    if (b.this.aMp != null) {
                        b.this.aMp.setPosition(b.this.aMt.eK(i));
                    }
                    if (b.this.aMy != null) {
                        b.this.aMy.onPageSelected(b.this.aMt.eK(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aMu = false;
        this.aMv = true;
        this.aMw = 2;
        this.aMx = new ArrayList();
        this.aMz = 5000L;
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
        this.aMA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aMy != null) {
                    b.this.aMy.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.FS();
                } else if (i2 == 0 && (count = b.this.aMs.getCount()) >= 2) {
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
                if (b.this.aMy != null) {
                    b.this.aMy.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aMt != null && b.this.aMt.eJ(i2) == i2) {
                    if (b.this.aMp != null) {
                        b.this.aMp.setPosition(b.this.aMt.eK(i2));
                    }
                    if (b.this.aMy != null) {
                        b.this.aMy.onPageSelected(b.this.aMt.eK(i2));
                    }
                }
            }
        };
        this.aMu = z;
        this.aMv = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aMp = indicatorView;
        this.aMo = textView;
        this.mContext = context;
        this.aMs = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aMs);
            this.mViewPager.setOnPageChangeListener(this.aMA);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aMw = i;
        if (this.aMt != null) {
            this.aMt.eL(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aMu = z;
    }

    public void bO(boolean z) {
        this.aMv = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aMs != null) {
            this.aMs.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.H(list) != 0) {
            this.aMx = list;
            this.aMt = new d(this.aMx, this.aMu, this.aMw);
            this.aMt.eM(2);
            this.aMt.eN(1);
            this.aMs.setDatas(this.aMt.FX());
            this.aMs.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aMt.FW(), false);
            if (this.aMt.FV() > 0) {
                if (this.aMt.FV() > this.aMw) {
                    if (this.aMo != null) {
                        this.aMo.setVisibility(0);
                        this.aMo.setOnClickListener(null);
                        if (this.aMp != null) {
                            this.aMp.setVisibility(8);
                        }
                    } else if (this.aMp != null && !this.aMu) {
                        this.aMp.setVisibility(8);
                    }
                    if (this.aMp != null && this.aMp.getVisibility() == 0 && this.aMp.getCount() != this.aMw) {
                        this.aMp.setCount(this.aMw);
                    }
                    FR();
                }
                if (this.aMt.FV() >= 2 && this.aMt.FV() <= this.aMw) {
                    if (this.aMo != null) {
                        this.aMo.setVisibility(8);
                    }
                    if (this.aMp != null) {
                        this.aMp.setVisibility(0);
                        if (this.aMp.getCount() != this.aMt.FV()) {
                            this.aMp.setCount(this.aMt.FV());
                        }
                    }
                    FR();
                }
                if (this.aMt.FV() < 2) {
                    if (this.aMo != null) {
                        this.aMo.setVisibility(8);
                    }
                    if (this.aMp != null) {
                        this.aMp.setVisibility(8);
                    }
                    FS();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ() {
        int count;
        if (this.mViewPager != null && this.aMs != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aMs.getCount()) >= 2) {
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
        this.aMz = j;
    }

    public void FR() {
        if (this.aMv) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aMz);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void FS() {
        this.mHandler.removeMessages(1);
    }
}
