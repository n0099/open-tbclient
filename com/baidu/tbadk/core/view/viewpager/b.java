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
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private ViewPager.OnPageChangeListener bLA;
    private TextView eoc;
    private IndicatorView eod;
    private BdBaseViewPagerAdapter eoh;
    private d eoi;
    private boolean eoj;
    private boolean eok;
    private int eol;
    private List<q> eom;
    private long eon;
    private ViewPager.OnPageChangeListener eoo;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eoj = false;
        this.eok = true;
        this.eol = 2;
        this.eom = new ArrayList();
        this.eon = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bdh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eoo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bLA != null) {
                    b.this.bLA.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.bdj();
                } else if (i == 0 && (count = b.this.eoh.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bdi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bLA != null) {
                    b.this.bLA.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eoi != null && b.this.eoi.ng(i) == i) {
                    if (b.this.eod != null) {
                        b.this.eod.setPosition(b.this.eoi.nh(i));
                    }
                    if (b.this.bLA != null) {
                        b.this.bLA.onPageSelected(b.this.eoi.nh(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eoj = false;
        this.eok = true;
        this.eol = 2;
        this.eom = new ArrayList();
        this.eon = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bdh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eoo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bLA != null) {
                    b.this.bLA.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.bdj();
                } else if (i2 == 0 && (count = b.this.eoh.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bdi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bLA != null) {
                    b.this.bLA.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eoi != null && b.this.eoi.ng(i2) == i2) {
                    if (b.this.eod != null) {
                        b.this.eod.setPosition(b.this.eoi.nh(i2));
                    }
                    if (b.this.bLA != null) {
                        b.this.bLA.onPageSelected(b.this.eoi.nh(i2));
                    }
                }
            }
        };
        this.eoj = z;
        this.eok = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eod = indicatorView;
        this.eoc = textView;
        this.mContext = context;
        this.eoh = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eoh);
            this.mViewPager.setOnPageChangeListener(this.eoo);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eol = i;
        if (this.eoi != null) {
            this.eoi.ni(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eoj = z;
    }

    public void ig(boolean z) {
        this.eok = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eoh != null) {
            this.eoh.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (x.getCount(list) != 0) {
            this.eom = list;
            this.eoi = new d(this.eom, this.eoj, this.eol);
            this.eoi.nj(2);
            this.eoi.nk(1);
            this.eoh.setDatas(this.eoi.bdo());
            this.eoh.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eoi.bdn(), false);
            if (this.eoi.bdm() > 0) {
                if (this.eoi.bdm() > this.eol) {
                    if (this.eoc != null) {
                        this.eoc.setVisibility(0);
                        this.eoc.setOnClickListener(null);
                        if (this.eod != null) {
                            this.eod.setVisibility(8);
                        }
                    } else if (this.eod != null && !this.eoj) {
                        this.eod.setVisibility(8);
                    }
                    if (this.eod != null && this.eod.getVisibility() == 0 && this.eod.getCount() != this.eol) {
                        this.eod.setCount(this.eol);
                    }
                    bdi();
                }
                if (this.eoi.bdm() >= 2 && this.eoi.bdm() <= this.eol) {
                    if (this.eoc != null) {
                        this.eoc.setVisibility(8);
                    }
                    if (this.eod != null) {
                        this.eod.setVisibility(0);
                        if (this.eod.getCount() != this.eoi.bdm()) {
                            this.eod.setCount(this.eoi.bdm());
                        }
                    }
                    bdi();
                }
                if (this.eoi.bdm() < 2) {
                    if (this.eoc != null) {
                        this.eoc.setVisibility(8);
                    }
                    if (this.eod != null) {
                        this.eod.setVisibility(8);
                    }
                    bdj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdh() {
        int count;
        if (this.mViewPager != null && this.eoh != null) {
            h E = i.E(this.mContext);
            if ((E == null || !E.isScroll()) && (count = this.eoh.getCount()) >= 2) {
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
        this.eon = j;
    }

    public void bdi() {
        if (this.eok) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eon);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bdj() {
        this.mHandler.removeMessages(1);
    }
}
