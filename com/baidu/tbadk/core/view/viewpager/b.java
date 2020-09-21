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
    private ViewPager.OnPageChangeListener bTa;
    private BdBaseViewPagerAdapter eAB;
    private d eAC;
    private boolean eAD;
    private boolean eAE;
    private int eAF;
    private List<q> eAG;
    private long eAH;
    private ViewPager.OnPageChangeListener eAI;
    private TextView eAx;
    private IndicatorView eAy;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eAD = false;
        this.eAE = true;
        this.eAF = 2;
        this.eAG = new ArrayList();
        this.eAH = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bmH();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eAI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bTa != null) {
                    b.this.bTa.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.bmJ();
                } else if (i == 0 && (count = b.this.eAB.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bmI();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bTa != null) {
                    b.this.bTa.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eAC != null && b.this.eAC.pC(i) == i) {
                    if (b.this.eAy != null) {
                        b.this.eAy.setPosition(b.this.eAC.pD(i));
                    }
                    if (b.this.bTa != null) {
                        b.this.bTa.onPageSelected(b.this.eAC.pD(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eAD = false;
        this.eAE = true;
        this.eAF = 2;
        this.eAG = new ArrayList();
        this.eAH = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bmH();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eAI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bTa != null) {
                    b.this.bTa.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.bmJ();
                } else if (i2 == 0 && (count = b.this.eAB.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bmI();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bTa != null) {
                    b.this.bTa.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eAC != null && b.this.eAC.pC(i2) == i2) {
                    if (b.this.eAy != null) {
                        b.this.eAy.setPosition(b.this.eAC.pD(i2));
                    }
                    if (b.this.bTa != null) {
                        b.this.bTa.onPageSelected(b.this.eAC.pD(i2));
                    }
                }
            }
        };
        this.eAD = z;
        this.eAE = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eAy = indicatorView;
        this.eAx = textView;
        this.mContext = context;
        this.eAB = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eAB);
            this.mViewPager.setOnPageChangeListener(this.eAI);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eAF = i;
        if (this.eAC != null) {
            this.eAC.pE(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eAD = z;
    }

    public void iC(boolean z) {
        this.eAE = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eAB != null) {
            this.eAB.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.eAG = list;
            this.eAC = new d(this.eAG, this.eAD, this.eAF);
            this.eAC.pF(2);
            this.eAC.pG(1);
            this.eAB.setDatas(this.eAC.bmO());
            this.eAB.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eAC.bmN(), false);
            if (this.eAC.bmM() > 0) {
                if (this.eAC.bmM() > this.eAF) {
                    if (this.eAx != null) {
                        this.eAx.setVisibility(0);
                        this.eAx.setOnClickListener(null);
                        if (this.eAy != null) {
                            this.eAy.setVisibility(8);
                        }
                    } else if (this.eAy != null && !this.eAD) {
                        this.eAy.setVisibility(8);
                    }
                    if (this.eAy != null && this.eAy.getVisibility() == 0 && this.eAy.getCount() != this.eAF) {
                        this.eAy.setCount(this.eAF);
                    }
                    bmI();
                }
                if (this.eAC.bmM() >= 2 && this.eAC.bmM() <= this.eAF) {
                    if (this.eAx != null) {
                        this.eAx.setVisibility(8);
                    }
                    if (this.eAy != null) {
                        this.eAy.setVisibility(0);
                        if (this.eAy.getCount() != this.eAC.bmM()) {
                            this.eAy.setCount(this.eAC.bmM());
                        }
                    }
                    bmI();
                }
                if (this.eAC.bmM() < 2) {
                    if (this.eAx != null) {
                        this.eAx.setVisibility(8);
                    }
                    if (this.eAy != null) {
                        this.eAy.setVisibility(8);
                    }
                    bmJ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmH() {
        int count;
        if (this.mViewPager != null && this.eAB != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.eAB.getCount()) >= 2) {
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
        this.eAH = j;
    }

    public void bmI() {
        if (this.eAE) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eAH);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bmJ() {
        this.mHandler.removeMessages(1);
    }
}
