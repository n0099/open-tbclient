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
    private ViewPager.OnPageChangeListener aZU;
    private TextView dkF;
    private IndicatorView dkG;
    private BdBaseViewPagerAdapter dkJ;
    private d dkK;
    private boolean dkL;
    private boolean dkM;
    private int dkN;
    private List<m> dkO;
    private long dkP;
    private ViewPager.OnPageChangeListener dkQ;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dkL = false;
        this.dkM = true;
        this.dkN = 2;
        this.dkO = new ArrayList();
        this.dkP = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIz();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkQ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aZU != null) {
                    b.this.aZU.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aIB();
                } else if (i == 0 && (count = b.this.dkJ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIA();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aZU != null) {
                    b.this.aZU.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dkK != null && b.this.dkK.lB(i) == i) {
                    if (b.this.dkG != null) {
                        b.this.dkG.setPosition(b.this.dkK.lC(i));
                    }
                    if (b.this.aZU != null) {
                        b.this.aZU.onPageSelected(b.this.dkK.lC(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dkL = false;
        this.dkM = true;
        this.dkN = 2;
        this.dkO = new ArrayList();
        this.dkP = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aIz();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dkQ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aZU != null) {
                    b.this.aZU.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aIB();
                } else if (i2 == 0 && (count = b.this.dkJ.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIA();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aZU != null) {
                    b.this.aZU.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dkK != null && b.this.dkK.lB(i2) == i2) {
                    if (b.this.dkG != null) {
                        b.this.dkG.setPosition(b.this.dkK.lC(i2));
                    }
                    if (b.this.aZU != null) {
                        b.this.aZU.onPageSelected(b.this.dkK.lC(i2));
                    }
                }
            }
        };
        this.dkL = z;
        this.dkM = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dkG = indicatorView;
        this.dkF = textView;
        this.mContext = context;
        this.dkJ = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dkJ);
            this.mViewPager.setOnPageChangeListener(this.dkQ);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkN = i;
        if (this.dkK != null) {
            this.dkK.lD(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dkL = z;
    }

    public void fW(boolean z) {
        this.dkM = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dkJ != null) {
            this.dkJ.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dkO = list;
            this.dkK = new d(this.dkO, this.dkL, this.dkN);
            this.dkK.lE(2);
            this.dkK.lF(1);
            this.dkJ.setDatas(this.dkK.aIG());
            this.dkJ.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dkK.aIF(), false);
            if (this.dkK.aIE() > 0) {
                if (this.dkK.aIE() > this.dkN) {
                    if (this.dkF != null) {
                        this.dkF.setVisibility(0);
                        this.dkF.setOnClickListener(null);
                        if (this.dkG != null) {
                            this.dkG.setVisibility(8);
                        }
                    } else if (this.dkG != null && !this.dkL) {
                        this.dkG.setVisibility(8);
                    }
                    if (this.dkG != null && this.dkG.getVisibility() == 0 && this.dkG.getCount() != this.dkN) {
                        this.dkG.setCount(this.dkN);
                    }
                    aIA();
                }
                if (this.dkK.aIE() >= 2 && this.dkK.aIE() <= this.dkN) {
                    if (this.dkF != null) {
                        this.dkF.setVisibility(8);
                    }
                    if (this.dkG != null) {
                        this.dkG.setVisibility(0);
                        if (this.dkG.getCount() != this.dkK.aIE()) {
                            this.dkG.setCount(this.dkK.aIE());
                        }
                    }
                    aIA();
                }
                if (this.dkK.aIE() < 2) {
                    if (this.dkF != null) {
                        this.dkF.setVisibility(8);
                    }
                    if (this.dkG != null) {
                        this.dkG.setVisibility(8);
                    }
                    aIB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIz() {
        int count;
        if (this.mViewPager != null && this.dkJ != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dkJ.getCount()) >= 2) {
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
        this.dkP = j;
    }

    public void aIA() {
        if (this.dkM) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dkP);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aIB() {
        this.mHandler.removeMessages(1);
    }
}
