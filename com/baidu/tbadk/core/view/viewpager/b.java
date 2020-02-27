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
    private ViewPager.OnPageChangeListener aZS;
    private List<m> dkA;
    private long dkB;
    private ViewPager.OnPageChangeListener dkC;
    private TextView dkr;
    private IndicatorView dks;
    private BdBaseViewPagerAdapter dkv;
    private d dkw;
    private boolean dkx;
    private boolean dky;
    private int dkz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dkx = false;
        this.dky = true;
        this.dkz = 2;
        this.dkA = new ArrayList();
        this.dkB = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIw();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aZS != null) {
                    b.this.aZS.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aIy();
                } else if (i == 0 && (count = b.this.dkv.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIx();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aZS != null) {
                    b.this.aZS.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dkw != null && b.this.dkw.lB(i) == i) {
                    if (b.this.dks != null) {
                        b.this.dks.setPosition(b.this.dkw.lC(i));
                    }
                    if (b.this.aZS != null) {
                        b.this.aZS.onPageSelected(b.this.dkw.lC(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dkx = false;
        this.dky = true;
        this.dkz = 2;
        this.dkA = new ArrayList();
        this.dkB = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIw();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aZS != null) {
                    b.this.aZS.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aIy();
                } else if (i2 == 0 && (count = b.this.dkv.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIx();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aZS != null) {
                    b.this.aZS.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dkw != null && b.this.dkw.lB(i2) == i2) {
                    if (b.this.dks != null) {
                        b.this.dks.setPosition(b.this.dkw.lC(i2));
                    }
                    if (b.this.aZS != null) {
                        b.this.aZS.onPageSelected(b.this.dkw.lC(i2));
                    }
                }
            }
        };
        this.dkx = z;
        this.dky = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dks = indicatorView;
        this.dkr = textView;
        this.mContext = context;
        this.dkv = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dkv);
            this.mViewPager.setOnPageChangeListener(this.dkC);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkz = i;
        if (this.dkw != null) {
            this.dkw.lD(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dkx = z;
    }

    public void fW(boolean z) {
        this.dky = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dkv != null) {
            this.dkv.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dkA = list;
            this.dkw = new d(this.dkA, this.dkx, this.dkz);
            this.dkw.lE(2);
            this.dkw.lF(1);
            this.dkv.setDatas(this.dkw.aID());
            this.dkv.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dkw.aIC(), false);
            if (this.dkw.aIB() > 0) {
                if (this.dkw.aIB() > this.dkz) {
                    if (this.dkr != null) {
                        this.dkr.setVisibility(0);
                        this.dkr.setOnClickListener(null);
                        if (this.dks != null) {
                            this.dks.setVisibility(8);
                        }
                    } else if (this.dks != null && !this.dkx) {
                        this.dks.setVisibility(8);
                    }
                    if (this.dks != null && this.dks.getVisibility() == 0 && this.dks.getCount() != this.dkz) {
                        this.dks.setCount(this.dkz);
                    }
                    aIx();
                }
                if (this.dkw.aIB() >= 2 && this.dkw.aIB() <= this.dkz) {
                    if (this.dkr != null) {
                        this.dkr.setVisibility(8);
                    }
                    if (this.dks != null) {
                        this.dks.setVisibility(0);
                        if (this.dks.getCount() != this.dkw.aIB()) {
                            this.dks.setCount(this.dkw.aIB());
                        }
                    }
                    aIx();
                }
                if (this.dkw.aIB() < 2) {
                    if (this.dkr != null) {
                        this.dkr.setVisibility(8);
                    }
                    if (this.dks != null) {
                        this.dks.setVisibility(8);
                    }
                    aIy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIw() {
        int count;
        if (this.mViewPager != null && this.dkv != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dkv.getCount()) >= 2) {
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
        this.dkB = j;
    }

    public void aIx() {
        if (this.dky) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dkB);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aIy() {
        this.mHandler.removeMessages(1);
    }
}
