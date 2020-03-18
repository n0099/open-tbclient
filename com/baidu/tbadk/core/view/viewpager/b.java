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
    private ViewPager.OnPageChangeListener bah;
    private TextView dkS;
    private IndicatorView dkT;
    private BdBaseViewPagerAdapter dkW;
    private d dkX;
    private boolean dkY;
    private boolean dkZ;
    private int dla;
    private List<m> dlb;
    private long dlc;
    private ViewPager.OnPageChangeListener dld;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.dkY = false;
        this.dkZ = true;
        this.dla = 2;
        this.dlb = new ArrayList();
        this.dlc = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aID();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dld = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.bah != null) {
                    b.this.bah.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aIF();
                } else if (i == 0 && (count = b.this.dkW.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIE();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.bah != null) {
                    b.this.bah.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.dkX != null && b.this.dkX.lD(i) == i) {
                    if (b.this.dkT != null) {
                        b.this.dkT.setPosition(b.this.dkX.lE(i));
                    }
                    if (b.this.bah != null) {
                        b.this.bah.onPageSelected(b.this.dkX.lE(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.dkY = false;
        this.dkZ = true;
        this.dla = 2;
        this.dlb = new ArrayList();
        this.dlc = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aID();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.dld = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.bah != null) {
                    b.this.bah.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aIF();
                } else if (i2 == 0 && (count = b.this.dkW.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.aIE();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.bah != null) {
                    b.this.bah.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.dkX != null && b.this.dkX.lD(i2) == i2) {
                    if (b.this.dkT != null) {
                        b.this.dkT.setPosition(b.this.dkX.lE(i2));
                    }
                    if (b.this.bah != null) {
                        b.this.bah.onPageSelected(b.this.dkX.lE(i2));
                    }
                }
            }
        };
        this.dkY = z;
        this.dkZ = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.dkT = indicatorView;
        this.dkS = textView;
        this.mContext = context;
        this.dkW = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.dkW);
            this.mViewPager.setOnPageChangeListener(this.dld);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.dla = i;
        if (this.dkX != null) {
            this.dkX.lF(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dkY = z;
    }

    public void fX(boolean z) {
        this.dkZ = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.dkW != null) {
            this.dkW.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.getCount(list) != 0) {
            this.dlb = list;
            this.dkX = new d(this.dlb, this.dkY, this.dla);
            this.dkX.lG(2);
            this.dkX.lH(1);
            this.dkW.setDatas(this.dkX.aIK());
            this.dkW.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.dkX.aIJ(), false);
            if (this.dkX.aII() > 0) {
                if (this.dkX.aII() > this.dla) {
                    if (this.dkS != null) {
                        this.dkS.setVisibility(0);
                        this.dkS.setOnClickListener(null);
                        if (this.dkT != null) {
                            this.dkT.setVisibility(8);
                        }
                    } else if (this.dkT != null && !this.dkY) {
                        this.dkT.setVisibility(8);
                    }
                    if (this.dkT != null && this.dkT.getVisibility() == 0 && this.dkT.getCount() != this.dla) {
                        this.dkT.setCount(this.dla);
                    }
                    aIE();
                }
                if (this.dkX.aII() >= 2 && this.dkX.aII() <= this.dla) {
                    if (this.dkS != null) {
                        this.dkS.setVisibility(8);
                    }
                    if (this.dkT != null) {
                        this.dkT.setVisibility(0);
                        if (this.dkT.getCount() != this.dkX.aII()) {
                            this.dkT.setCount(this.dkX.aII());
                        }
                    }
                    aIE();
                }
                if (this.dkX.aII() < 2) {
                    if (this.dkS != null) {
                        this.dkS.setVisibility(8);
                    }
                    if (this.dkT != null) {
                        this.dkT.setVisibility(8);
                    }
                    aIF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aID() {
        int count;
        if (this.mViewPager != null && this.dkW != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.dkW.getCount()) >= 2) {
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
        this.dlc = j;
    }

    public void aIE() {
        if (this.dkZ) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.dlc);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aIF() {
        this.mHandler.removeMessages(1);
    }
}
