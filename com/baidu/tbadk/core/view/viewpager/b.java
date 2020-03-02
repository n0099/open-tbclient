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
    private ViewPager.OnPageChangeListener aZT;
    private int dkA;
    private List<m> dkB;
    private long dkC;
    private ViewPager.OnPageChangeListener dkD;
    private TextView dks;
    private IndicatorView dkt;
    private BdBaseViewPagerAdapter dkw;
    private d dkx;
    private boolean dky;
    private boolean dkz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dky = false;
        this.dkz = true;
        this.dkA = 2;
        this.dkB = new ArrayList();
        this.dkC = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIy();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aZT != null) {
                    b.this.aZT.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aIA();
                } else if (i == 0 && (count = b.this.dkw.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIz();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aZT != null) {
                    b.this.aZT.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dkx != null && b.this.dkx.lB(i) == i) {
                    if (b.this.dkt != null) {
                        b.this.dkt.setPosition(b.this.dkx.lC(i));
                    }
                    if (b.this.aZT != null) {
                        b.this.aZT.onPageSelected(b.this.dkx.lC(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dky = false;
        this.dkz = true;
        this.dkA = 2;
        this.dkB = new ArrayList();
        this.dkC = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIy();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aZT != null) {
                    b.this.aZT.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aIA();
                } else if (i2 == 0 && (count = b.this.dkw.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIz();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aZT != null) {
                    b.this.aZT.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dkx != null && b.this.dkx.lB(i2) == i2) {
                    if (b.this.dkt != null) {
                        b.this.dkt.setPosition(b.this.dkx.lC(i2));
                    }
                    if (b.this.aZT != null) {
                        b.this.aZT.onPageSelected(b.this.dkx.lC(i2));
                    }
                }
            }
        };
        this.dky = z;
        this.dkz = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dkt = indicatorView;
        this.dks = textView;
        this.mContext = context;
        this.dkw = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dkw);
            this.mViewPager.setOnPageChangeListener(this.dkD);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkA = i;
        if (this.dkx != null) {
            this.dkx.lD(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dky = z;
    }

    public void fW(boolean z) {
        this.dkz = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dkw != null) {
            this.dkw.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dkB = list;
            this.dkx = new d(this.dkB, this.dky, this.dkA);
            this.dkx.lE(2);
            this.dkx.lF(1);
            this.dkw.setDatas(this.dkx.aIF());
            this.dkw.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dkx.aIE(), false);
            if (this.dkx.aID() > 0) {
                if (this.dkx.aID() > this.dkA) {
                    if (this.dks != null) {
                        this.dks.setVisibility(0);
                        this.dks.setOnClickListener(null);
                        if (this.dkt != null) {
                            this.dkt.setVisibility(8);
                        }
                    } else if (this.dkt != null && !this.dky) {
                        this.dkt.setVisibility(8);
                    }
                    if (this.dkt != null && this.dkt.getVisibility() == 0 && this.dkt.getCount() != this.dkA) {
                        this.dkt.setCount(this.dkA);
                    }
                    aIz();
                }
                if (this.dkx.aID() >= 2 && this.dkx.aID() <= this.dkA) {
                    if (this.dks != null) {
                        this.dks.setVisibility(8);
                    }
                    if (this.dkt != null) {
                        this.dkt.setVisibility(0);
                        if (this.dkt.getCount() != this.dkx.aID()) {
                            this.dkt.setCount(this.dkx.aID());
                        }
                    }
                    aIz();
                }
                if (this.dkx.aID() < 2) {
                    if (this.dks != null) {
                        this.dks.setVisibility(8);
                    }
                    if (this.dkt != null) {
                        this.dkt.setVisibility(8);
                    }
                    aIA();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIy() {
        int count;
        if (this.mViewPager != null && this.dkw != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dkw.getCount()) >= 2) {
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
        this.dkC = j;
    }

    public void aIz() {
        if (this.dkz) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dkC);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aIA() {
        this.mHandler.removeMessages(1);
    }
}
