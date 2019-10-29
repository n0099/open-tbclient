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
    private TextView ctc;
    private IndicatorView ctd;
    private BdBaseViewPagerAdapter ctg;
    private d cth;
    private boolean cti;
    private boolean ctj;
    private int ctk;
    private List<m> ctl;
    private ViewPager.OnPageChangeListener ctm;
    private long ctn;
    private ViewPager.OnPageChangeListener cto;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.cti = false;
        this.ctj = true;
        this.ctk = 2;
        this.ctl = new ArrayList();
        this.ctn = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aon();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cto = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.ctm != null) {
                    b.this.ctm.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aop();
                } else if (i == 0 && (count = b.this.ctg.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aoo();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.ctm != null) {
                    b.this.ctm.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.cth != null && b.this.cth.iY(i) == i) {
                    if (b.this.ctd != null) {
                        b.this.ctd.setPosition(b.this.cth.iZ(i));
                    }
                    if (b.this.ctm != null) {
                        b.this.ctm.onPageSelected(b.this.cth.iZ(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.cti = false;
        this.ctj = true;
        this.ctk = 2;
        this.ctl = new ArrayList();
        this.ctn = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aon();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cto = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.ctm != null) {
                    b.this.ctm.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aop();
                } else if (i2 == 0 && (count = b.this.ctg.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aoo();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.ctm != null) {
                    b.this.ctm.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.cth != null && b.this.cth.iY(i2) == i2) {
                    if (b.this.ctd != null) {
                        b.this.ctd.setPosition(b.this.cth.iZ(i2));
                    }
                    if (b.this.ctm != null) {
                        b.this.ctm.onPageSelected(b.this.cth.iZ(i2));
                    }
                }
            }
        };
        this.cti = z;
        this.ctj = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ctd = indicatorView;
        this.ctc = textView;
        this.mContext = context;
        this.ctg = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ctg);
            this.mViewPager.setOnPageChangeListener(this.cto);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ctk = i;
        if (this.cth != null) {
            this.cth.ja(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.cti = z;
    }

    public void ey(boolean z) {
        this.ctj = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ctg != null) {
            this.ctg.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.ctl = list;
            this.cth = new d(this.ctl, this.cti, this.ctk);
            this.cth.jb(2);
            this.cth.jc(1);
            this.ctg.setDatas(this.cth.aou());
            this.ctg.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.cth.aot(), false);
            if (this.cth.aos() > 0) {
                if (this.cth.aos() > this.ctk) {
                    if (this.ctc != null) {
                        this.ctc.setVisibility(0);
                        this.ctc.setOnClickListener(null);
                        if (this.ctd != null) {
                            this.ctd.setVisibility(8);
                        }
                    } else if (this.ctd != null && !this.cti) {
                        this.ctd.setVisibility(8);
                    }
                    if (this.ctd != null && this.ctd.getVisibility() == 0 && this.ctd.getCount() != this.ctk) {
                        this.ctd.setCount(this.ctk);
                    }
                    aoo();
                }
                if (this.cth.aos() >= 2 && this.cth.aos() <= this.ctk) {
                    if (this.ctc != null) {
                        this.ctc.setVisibility(8);
                    }
                    if (this.ctd != null) {
                        this.ctd.setVisibility(0);
                        if (this.ctd.getCount() != this.cth.aos()) {
                            this.ctd.setCount(this.cth.aos());
                        }
                    }
                    aoo();
                }
                if (this.cth.aos() < 2) {
                    if (this.ctc != null) {
                        this.ctc.setVisibility(8);
                    }
                    if (this.ctd != null) {
                        this.ctd.setVisibility(8);
                    }
                    aop();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aon() {
        int count;
        if (this.mViewPager != null && this.ctg != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.ctg.getCount()) >= 2) {
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
        this.ctn = j;
    }

    public void aoo() {
        if (this.ctj) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ctn);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aop() {
        this.mHandler.removeMessages(1);
    }
}
