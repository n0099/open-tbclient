package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ViewPager Zk;
    private ViewPager.OnPageChangeListener cDO;
    private TextView frf;
    private IndicatorView frg;
    private BdBaseViewPagerAdapter frj;
    private c frk;
    private boolean frl;
    private boolean frm;
    private int frn;
    private List<n> fro;
    private long frp;
    private ViewPager.OnPageChangeListener frq;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.frl = false;
        this.frm = true;
        this.frn = 2;
        this.fro = new ArrayList();
        this.frp = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.byT();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.frq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (a.this.cDO != null) {
                    a.this.cDO.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    a.this.byV();
                } else if (i == 0 && (count = a.this.frj.getCount()) >= 2) {
                    int currentItem = a.this.Zk.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        a.this.Zk.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        a.this.Zk.setCurrentItem(1, false);
                    }
                    a.this.byU();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (a.this.cDO != null) {
                    a.this.cDO.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (a.this.frk != null && a.this.frk.rG(i) == i) {
                    if (a.this.frg != null) {
                        a.this.frg.setPosition(a.this.frk.rH(i));
                    }
                    if (a.this.cDO != null) {
                        a.this.cDO.onPageSelected(a.this.frk.rH(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.frl = false;
        this.frm = true;
        this.frn = 2;
        this.fro = new ArrayList();
        this.frp = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.byT();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.frq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (a.this.cDO != null) {
                    a.this.cDO.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    a.this.byV();
                } else if (i2 == 0 && (count = a.this.frj.getCount()) >= 2) {
                    int currentItem = a.this.Zk.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        a.this.Zk.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        a.this.Zk.setCurrentItem(1, false);
                    }
                    a.this.byU();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (a.this.cDO != null) {
                    a.this.cDO.onPageScrolled(i2, f, i22);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (a.this.frk != null && a.this.frk.rG(i2) == i2) {
                    if (a.this.frg != null) {
                        a.this.frg.setPosition(a.this.frk.rH(i2));
                    }
                    if (a.this.cDO != null) {
                        a.this.cDO.onPageSelected(a.this.frk.rH(i2));
                    }
                }
            }
        };
        this.frl = z;
        this.frm = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.Zk = viewPager;
        this.frg = indicatorView;
        this.frf = textView;
        this.mContext = context;
        this.frj = new BdBaseViewPagerAdapter(context);
        if (this.Zk != null) {
            this.Zk.setAdapter(this.frj);
            this.Zk.setOnPageChangeListener(this.frq);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.frn = i;
        if (this.frk != null) {
            this.frk.rI(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.frl = z;
    }

    public void kj(boolean z) {
        this.frm = z;
    }

    public void a(Context context, b<?, ?> bVar) {
        if (this.frj != null) {
            this.frj.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        if (x.getCount(list) != 0) {
            this.fro = list;
            this.frk = new c(this.fro, this.frl, this.frn);
            this.frk.rJ(2);
            this.frk.rK(1);
            this.frj.setDatas(this.frk.bza());
            this.frj.notifyDataSetChanged();
            this.Zk.setCurrentItem(this.frk.byZ(), false);
            if (this.frk.byY() > 0) {
                if (this.frk.byY() > this.frn) {
                    if (this.frf != null) {
                        this.frf.setVisibility(0);
                        this.frf.setOnClickListener(null);
                        if (this.frg != null) {
                            this.frg.setVisibility(8);
                        }
                    } else if (this.frg != null && !this.frl) {
                        this.frg.setVisibility(8);
                    }
                    if (this.frg != null && this.frg.getVisibility() == 0 && this.frg.getCount() != this.frn) {
                        this.frg.setCount(this.frn);
                    }
                    byU();
                }
                if (this.frk.byY() >= 2 && this.frk.byY() <= this.frn) {
                    if (this.frf != null) {
                        this.frf.setVisibility(8);
                    }
                    if (this.frg != null) {
                        this.frg.setVisibility(0);
                        if (this.frg.getCount() != this.frk.byY()) {
                            this.frg.setCount(this.frk.byY());
                        }
                    }
                    byU();
                }
                if (this.frk.byY() < 2) {
                    if (this.frf != null) {
                        this.frf.setVisibility(8);
                    }
                    if (this.frg != null) {
                        this.frg.setVisibility(8);
                    }
                    byV();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byT() {
        int count;
        if (this.Zk != null && this.frj != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.frj.getCount()) >= 2) {
                int currentItem = this.Zk.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.Zk.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.Zk.setCurrentItem(1, false);
                } else {
                    this.Zk.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.frp = j;
    }

    public void byU() {
        if (this.frm) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.frp);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void byV() {
        this.mHandler.removeMessages(1);
    }
}
