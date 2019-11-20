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
    private TextView csl;
    private IndicatorView csm;
    private BdBaseViewPagerAdapter csp;
    private d csq;
    private boolean csr;
    private boolean css;
    private int cst;
    private List<m> csu;
    private ViewPager.OnPageChangeListener csv;
    private long csw;
    private ViewPager.OnPageChangeListener csx;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.csr = false;
        this.css = true;
        this.cst = 2;
        this.csu = new ArrayList();
        this.csw = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aol();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.csx = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.csv != null) {
                    b.this.csv.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aon();
                } else if (i == 0 && (count = b.this.csp.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aom();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.csv != null) {
                    b.this.csv.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.csq != null && b.this.csq.iX(i) == i) {
                    if (b.this.csm != null) {
                        b.this.csm.setPosition(b.this.csq.iY(i));
                    }
                    if (b.this.csv != null) {
                        b.this.csv.onPageSelected(b.this.csq.iY(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.csr = false;
        this.css = true;
        this.cst = 2;
        this.csu = new ArrayList();
        this.csw = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aol();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.csx = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.csv != null) {
                    b.this.csv.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aon();
                } else if (i2 == 0 && (count = b.this.csp.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aom();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.csv != null) {
                    b.this.csv.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.csq != null && b.this.csq.iX(i2) == i2) {
                    if (b.this.csm != null) {
                        b.this.csm.setPosition(b.this.csq.iY(i2));
                    }
                    if (b.this.csv != null) {
                        b.this.csv.onPageSelected(b.this.csq.iY(i2));
                    }
                }
            }
        };
        this.csr = z;
        this.css = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.csm = indicatorView;
        this.csl = textView;
        this.mContext = context;
        this.csp = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.csp);
            this.mViewPager.setOnPageChangeListener(this.csx);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.cst = i;
        if (this.csq != null) {
            this.csq.iZ(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.csr = z;
    }

    public void ey(boolean z) {
        this.css = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.csp != null) {
            this.csp.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.csu = list;
            this.csq = new d(this.csu, this.csr, this.cst);
            this.csq.ja(2);
            this.csq.jb(1);
            this.csp.setDatas(this.csq.aos());
            this.csp.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.csq.aor(), false);
            if (this.csq.aoq() > 0) {
                if (this.csq.aoq() > this.cst) {
                    if (this.csl != null) {
                        this.csl.setVisibility(0);
                        this.csl.setOnClickListener(null);
                        if (this.csm != null) {
                            this.csm.setVisibility(8);
                        }
                    } else if (this.csm != null && !this.csr) {
                        this.csm.setVisibility(8);
                    }
                    if (this.csm != null && this.csm.getVisibility() == 0 && this.csm.getCount() != this.cst) {
                        this.csm.setCount(this.cst);
                    }
                    aom();
                }
                if (this.csq.aoq() >= 2 && this.csq.aoq() <= this.cst) {
                    if (this.csl != null) {
                        this.csl.setVisibility(8);
                    }
                    if (this.csm != null) {
                        this.csm.setVisibility(0);
                        if (this.csm.getCount() != this.csq.aoq()) {
                            this.csm.setCount(this.csq.aoq());
                        }
                    }
                    aom();
                }
                if (this.csq.aoq() < 2) {
                    if (this.csl != null) {
                        this.csl.setVisibility(8);
                    }
                    if (this.csm != null) {
                        this.csm.setVisibility(8);
                    }
                    aon();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aol() {
        int count;
        if (this.mViewPager != null && this.csp != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.csp.getCount()) >= 2) {
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
        this.csw = j;
    }

    public void aom() {
        if (this.css) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.csw);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aon() {
        this.mHandler.removeMessages(1);
    }
}
