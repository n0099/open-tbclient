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
    private boolean aHA;
    private boolean aHB;
    private int aHC;
    private List<h> aHD;
    private ViewPager.OnPageChangeListener aHE;
    private long aHF;
    private ViewPager.OnPageChangeListener aHG;
    private TextView aHu;
    private IndicatorView aHv;
    private BdBaseViewPagerAdapter aHy;
    private d aHz;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aHA = false;
        this.aHB = true;
        this.aHC = 2;
        this.aHD = new ArrayList();
        this.aHF = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Eo();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aHG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aHE != null) {
                    b.this.aHE.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.Eq();
                } else if (i == 0 && (count = b.this.aHy.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ep();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aHE != null) {
                    b.this.aHE.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aHz != null && b.this.aHz.eg(i) == i) {
                    if (b.this.aHv != null) {
                        b.this.aHv.setPosition(b.this.aHz.eh(i));
                    }
                    if (b.this.aHE != null) {
                        b.this.aHE.onPageSelected(b.this.aHz.eh(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aHA = false;
        this.aHB = true;
        this.aHC = 2;
        this.aHD = new ArrayList();
        this.aHF = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Eo();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aHG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aHE != null) {
                    b.this.aHE.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.Eq();
                } else if (i2 == 0 && (count = b.this.aHy.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ep();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aHE != null) {
                    b.this.aHE.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aHz != null && b.this.aHz.eg(i2) == i2) {
                    if (b.this.aHv != null) {
                        b.this.aHv.setPosition(b.this.aHz.eh(i2));
                    }
                    if (b.this.aHE != null) {
                        b.this.aHE.onPageSelected(b.this.aHz.eh(i2));
                    }
                }
            }
        };
        this.aHA = z;
        this.aHB = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aHv = indicatorView;
        this.aHu = textView;
        this.mContext = context;
        this.aHy = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aHy);
            this.mViewPager.setOnPageChangeListener(this.aHG);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aHC = i;
        if (this.aHz != null) {
            this.aHz.ei(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aHA = z;
    }

    public void bv(boolean z) {
        this.aHB = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aHy != null) {
            this.aHy.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.I(list) != 0) {
            this.aHD = list;
            this.aHz = new d(this.aHD, this.aHA, this.aHC);
            this.aHz.ej(2);
            this.aHz.ek(1);
            this.aHy.setDatas(this.aHz.Ev());
            this.aHy.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aHz.Eu(), false);
            if (this.aHz.Et() > 0) {
                if (this.aHz.Et() > this.aHC) {
                    if (this.aHu != null) {
                        this.aHu.setVisibility(0);
                        this.aHu.setOnClickListener(null);
                        if (this.aHv != null) {
                            this.aHv.setVisibility(8);
                        }
                    } else if (this.aHv != null && !this.aHA) {
                        this.aHv.setVisibility(8);
                    }
                    if (this.aHv != null && this.aHv.getVisibility() == 0 && this.aHv.getCount() != this.aHC) {
                        this.aHv.setCount(this.aHC);
                    }
                    Ep();
                }
                if (this.aHz.Et() >= 2 && this.aHz.Et() <= this.aHC) {
                    if (this.aHu != null) {
                        this.aHu.setVisibility(8);
                    }
                    if (this.aHv != null) {
                        this.aHv.setVisibility(0);
                        if (this.aHv.getCount() != this.aHz.Et()) {
                            this.aHv.setCount(this.aHz.Et());
                        }
                    }
                    Ep();
                }
                if (this.aHz.Et() < 2) {
                    if (this.aHu != null) {
                        this.aHu.setVisibility(8);
                    }
                    if (this.aHv != null) {
                        this.aHv.setVisibility(8);
                    }
                    Eq();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        int count;
        if (this.mViewPager != null && this.aHy != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aHy.getCount()) >= 2) {
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
        this.aHF = j;
    }

    public void Ep() {
        if (this.aHB) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aHF);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void Eq() {
        this.mHandler.removeMessages(1);
    }
}
