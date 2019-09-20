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
    private TextView ceQ;
    private IndicatorView ceR;
    private BdBaseViewPagerAdapter ceU;
    private d ceV;
    private boolean ceW;
    private boolean ceX;
    private int ceY;
    private List<m> ceZ;
    private ViewPager.OnPageChangeListener cfa;
    private long cfb;
    private ViewPager.OnPageChangeListener cfc;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ceW = false;
        this.ceX = true;
        this.ceY = 2;
        this.ceZ = new ArrayList();
        this.cfb = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.alz();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.cfa != null) {
                    b.this.cfa.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.alB();
                } else if (i == 0 && (count = b.this.ceU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alA();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.cfa != null) {
                    b.this.cfa.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.ceV != null && b.this.ceV.jm(i) == i) {
                    if (b.this.ceR != null) {
                        b.this.ceR.setPosition(b.this.ceV.jn(i));
                    }
                    if (b.this.cfa != null) {
                        b.this.cfa.onPageSelected(b.this.ceV.jn(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ceW = false;
        this.ceX = true;
        this.ceY = 2;
        this.ceZ = new ArrayList();
        this.cfb = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.alz();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.cfa != null) {
                    b.this.cfa.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.alB();
                } else if (i2 == 0 && (count = b.this.ceU.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alA();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.cfa != null) {
                    b.this.cfa.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.ceV != null && b.this.ceV.jm(i2) == i2) {
                    if (b.this.ceR != null) {
                        b.this.ceR.setPosition(b.this.ceV.jn(i2));
                    }
                    if (b.this.cfa != null) {
                        b.this.cfa.onPageSelected(b.this.ceV.jn(i2));
                    }
                }
            }
        };
        this.ceW = z;
        this.ceX = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ceR = indicatorView;
        this.ceQ = textView;
        this.mContext = context;
        this.ceU = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ceU);
            this.mViewPager.setOnPageChangeListener(this.cfc);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ceY = i;
        if (this.ceV != null) {
            this.ceV.jo(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ceW = z;
    }

    public void eB(boolean z) {
        this.ceX = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ceU != null) {
            this.ceU.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.Z(list) != 0) {
            this.ceZ = list;
            this.ceV = new d(this.ceZ, this.ceW, this.ceY);
            this.ceV.jp(2);
            this.ceV.jq(1);
            this.ceU.setDatas(this.ceV.alG());
            this.ceU.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ceV.alF(), false);
            if (this.ceV.alE() > 0) {
                if (this.ceV.alE() > this.ceY) {
                    if (this.ceQ != null) {
                        this.ceQ.setVisibility(0);
                        this.ceQ.setOnClickListener(null);
                        if (this.ceR != null) {
                            this.ceR.setVisibility(8);
                        }
                    } else if (this.ceR != null && !this.ceW) {
                        this.ceR.setVisibility(8);
                    }
                    if (this.ceR != null && this.ceR.getVisibility() == 0 && this.ceR.getCount() != this.ceY) {
                        this.ceR.setCount(this.ceY);
                    }
                    alA();
                }
                if (this.ceV.alE() >= 2 && this.ceV.alE() <= this.ceY) {
                    if (this.ceQ != null) {
                        this.ceQ.setVisibility(8);
                    }
                    if (this.ceR != null) {
                        this.ceR.setVisibility(0);
                        if (this.ceR.getCount() != this.ceV.alE()) {
                            this.ceR.setCount(this.ceV.alE());
                        }
                    }
                    alA();
                }
                if (this.ceV.alE() < 2) {
                    if (this.ceQ != null) {
                        this.ceQ.setVisibility(8);
                    }
                    if (this.ceR != null) {
                        this.ceR.setVisibility(8);
                    }
                    alB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        int count;
        if (this.mViewPager != null && this.ceU != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.ceU.getCount()) >= 2) {
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
        this.cfb = j;
    }

    public void alA() {
        if (this.ceX) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.cfb);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void alB() {
        this.mHandler.removeMessages(1);
    }
}
