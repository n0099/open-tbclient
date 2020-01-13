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
    private ViewPager.OnPageChangeListener aVG;
    private TextView dgl;
    private IndicatorView dgm;
    private BdBaseViewPagerAdapter dgp;
    private d dgq;
    private boolean dgr;
    private boolean dgs;
    private int dgt;
    private List<m> dgu;
    private long dgv;
    private ViewPager.OnPageChangeListener dgw;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dgr = false;
        this.dgs = true;
        this.dgt = 2;
        this.dgu = new ArrayList();
        this.dgv = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aGh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dgw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aVG != null) {
                    b.this.aVG.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aGj();
                } else if (i == 0 && (count = b.this.dgp.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aGi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aVG != null) {
                    b.this.aVG.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dgq != null && b.this.dgq.lk(i) == i) {
                    if (b.this.dgm != null) {
                        b.this.dgm.setPosition(b.this.dgq.ll(i));
                    }
                    if (b.this.aVG != null) {
                        b.this.aVG.onPageSelected(b.this.dgq.ll(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dgr = false;
        this.dgs = true;
        this.dgt = 2;
        this.dgu = new ArrayList();
        this.dgv = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aGh();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dgw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aVG != null) {
                    b.this.aVG.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aGj();
                } else if (i2 == 0 && (count = b.this.dgp.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aGi();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aVG != null) {
                    b.this.aVG.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dgq != null && b.this.dgq.lk(i2) == i2) {
                    if (b.this.dgm != null) {
                        b.this.dgm.setPosition(b.this.dgq.ll(i2));
                    }
                    if (b.this.aVG != null) {
                        b.this.aVG.onPageSelected(b.this.dgq.ll(i2));
                    }
                }
            }
        };
        this.dgr = z;
        this.dgs = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dgm = indicatorView;
        this.dgl = textView;
        this.mContext = context;
        this.dgp = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dgp);
            this.mViewPager.setOnPageChangeListener(this.dgw);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dgt = i;
        if (this.dgq != null) {
            this.dgq.lm(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dgr = z;
    }

    public void fP(boolean z) {
        this.dgs = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dgp != null) {
            this.dgp.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dgu = list;
            this.dgq = new d(this.dgu, this.dgr, this.dgt);
            this.dgq.ln(2);
            this.dgq.lo(1);
            this.dgp.setDatas(this.dgq.aGo());
            this.dgp.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dgq.aGn(), false);
            if (this.dgq.aGm() > 0) {
                if (this.dgq.aGm() > this.dgt) {
                    if (this.dgl != null) {
                        this.dgl.setVisibility(0);
                        this.dgl.setOnClickListener(null);
                        if (this.dgm != null) {
                            this.dgm.setVisibility(8);
                        }
                    } else if (this.dgm != null && !this.dgr) {
                        this.dgm.setVisibility(8);
                    }
                    if (this.dgm != null && this.dgm.getVisibility() == 0 && this.dgm.getCount() != this.dgt) {
                        this.dgm.setCount(this.dgt);
                    }
                    aGi();
                }
                if (this.dgq.aGm() >= 2 && this.dgq.aGm() <= this.dgt) {
                    if (this.dgl != null) {
                        this.dgl.setVisibility(8);
                    }
                    if (this.dgm != null) {
                        this.dgm.setVisibility(0);
                        if (this.dgm.getCount() != this.dgq.aGm()) {
                            this.dgm.setCount(this.dgq.aGm());
                        }
                    }
                    aGi();
                }
                if (this.dgq.aGm() < 2) {
                    if (this.dgl != null) {
                        this.dgl.setVisibility(8);
                    }
                    if (this.dgm != null) {
                        this.dgm.setVisibility(8);
                    }
                    aGj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGh() {
        int count;
        if (this.mViewPager != null && this.dgp != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dgp.getCount()) >= 2) {
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
        this.dgv = j;
    }

    public void aGi() {
        if (this.dgs) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dgv);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aGj() {
        this.mHandler.removeMessages(1);
    }
}
