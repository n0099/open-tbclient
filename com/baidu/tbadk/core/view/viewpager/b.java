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
    private ViewPager.OnPageChangeListener cnN;
    private TextView eVa;
    private IndicatorView eVb;
    private BdBaseViewPagerAdapter eVe;
    private d eVf;
    private boolean eVg;
    private boolean eVh;
    private int eVi;
    private List<q> eVj;
    private long eVk;
    private ViewPager.OnPageChangeListener eVl;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eVg = false;
        this.eVh = true;
        this.eVi = 2;
        this.eVj = new ArrayList();
        this.eVk = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.brk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eVl = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.cnN != null) {
                    b.this.cnN.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.brm();
                } else if (i == 0 && (count = b.this.eVe.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.brl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.cnN != null) {
                    b.this.cnN.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eVf != null && b.this.eVf.ql(i) == i) {
                    if (b.this.eVb != null) {
                        b.this.eVb.setPosition(b.this.eVf.qm(i));
                    }
                    if (b.this.cnN != null) {
                        b.this.cnN.onPageSelected(b.this.eVf.qm(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eVg = false;
        this.eVh = true;
        this.eVi = 2;
        this.eVj = new ArrayList();
        this.eVk = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.brk();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eVl = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.cnN != null) {
                    b.this.cnN.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.brm();
                } else if (i2 == 0 && (count = b.this.eVe.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.brl();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.cnN != null) {
                    b.this.cnN.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eVf != null && b.this.eVf.ql(i2) == i2) {
                    if (b.this.eVb != null) {
                        b.this.eVb.setPosition(b.this.eVf.qm(i2));
                    }
                    if (b.this.cnN != null) {
                        b.this.cnN.onPageSelected(b.this.eVf.qm(i2));
                    }
                }
            }
        };
        this.eVg = z;
        this.eVh = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eVb = indicatorView;
        this.eVa = textView;
        this.mContext = context;
        this.eVe = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eVe);
            this.mViewPager.setOnPageChangeListener(this.eVl);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eVi = i;
        if (this.eVf != null) {
            this.eVf.qn(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eVg = z;
    }

    public void jn(boolean z) {
        this.eVh = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eVe != null) {
            this.eVe.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.eVj = list;
            this.eVf = new d(this.eVj, this.eVg, this.eVi);
            this.eVf.qo(2);
            this.eVf.qp(1);
            this.eVe.setDatas(this.eVf.brr());
            this.eVe.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eVf.brq(), false);
            if (this.eVf.brp() > 0) {
                if (this.eVf.brp() > this.eVi) {
                    if (this.eVa != null) {
                        this.eVa.setVisibility(0);
                        this.eVa.setOnClickListener(null);
                        if (this.eVb != null) {
                            this.eVb.setVisibility(8);
                        }
                    } else if (this.eVb != null && !this.eVg) {
                        this.eVb.setVisibility(8);
                    }
                    if (this.eVb != null && this.eVb.getVisibility() == 0 && this.eVb.getCount() != this.eVi) {
                        this.eVb.setCount(this.eVi);
                    }
                    brl();
                }
                if (this.eVf.brp() >= 2 && this.eVf.brp() <= this.eVi) {
                    if (this.eVa != null) {
                        this.eVa.setVisibility(8);
                    }
                    if (this.eVb != null) {
                        this.eVb.setVisibility(0);
                        if (this.eVb.getCount() != this.eVf.brp()) {
                            this.eVb.setCount(this.eVf.brp());
                        }
                    }
                    brl();
                }
                if (this.eVf.brp() < 2) {
                    if (this.eVa != null) {
                        this.eVa.setVisibility(8);
                    }
                    if (this.eVb != null) {
                        this.eVb.setVisibility(8);
                    }
                    brm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brk() {
        int count;
        if (this.mViewPager != null && this.eVe != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.eVe.getCount()) >= 2) {
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
        this.eVk = j;
    }

    public void brl() {
        if (this.eVh) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eVk);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void brm() {
        this.mHandler.removeMessages(1);
    }
}
