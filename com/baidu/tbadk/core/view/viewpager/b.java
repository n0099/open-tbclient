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
    private TextView aCO;
    private IndicatorView aCP;
    private BdBaseViewPagerAdapter aCS;
    private d aCT;
    private boolean aCU;
    private boolean aCV;
    private int aCW;
    private List<h> aCX;
    private ViewPager.OnPageChangeListener aCY;
    private long aCZ;
    private ViewPager.OnPageChangeListener aDa;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aCU = false;
        this.aCV = true;
        this.aCW = 2;
        this.aCX = new ArrayList();
        this.aCZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Cj();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aDa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aCY != null) {
                    b.this.aCY.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.Cl();
                } else if (i == 0 && (count = b.this.aCS.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ck();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aCY != null) {
                    b.this.aCY.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aCT != null && b.this.aCT.dW(i) == i) {
                    if (b.this.aCP != null) {
                        b.this.aCP.setPosition(b.this.aCT.dX(i));
                    }
                    if (b.this.aCY != null) {
                        b.this.aCY.onPageSelected(b.this.aCT.dX(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aCU = false;
        this.aCV = true;
        this.aCW = 2;
        this.aCX = new ArrayList();
        this.aCZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Cj();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aDa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aCY != null) {
                    b.this.aCY.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.Cl();
                } else if (i2 == 0 && (count = b.this.aCS.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ck();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aCY != null) {
                    b.this.aCY.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aCT != null && b.this.aCT.dW(i2) == i2) {
                    if (b.this.aCP != null) {
                        b.this.aCP.setPosition(b.this.aCT.dX(i2));
                    }
                    if (b.this.aCY != null) {
                        b.this.aCY.onPageSelected(b.this.aCT.dX(i2));
                    }
                }
            }
        };
        this.aCU = z;
        this.aCV = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aCP = indicatorView;
        this.aCO = textView;
        this.mContext = context;
        this.aCS = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aCS);
            this.mViewPager.setOnPageChangeListener(this.aDa);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aCW = i;
        if (this.aCT != null) {
            this.aCT.dY(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aCU = z;
    }

    public void bl(boolean z) {
        this.aCV = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aCS != null) {
            this.aCS.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.y(list) != 0) {
            this.aCX = list;
            this.aCT = new d(this.aCX, this.aCU, this.aCW);
            this.aCT.dZ(2);
            this.aCT.ea(1);
            this.aCS.setDatas(this.aCT.Cq());
            this.aCS.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aCT.Cp(), false);
            if (this.aCT.Co() > 0) {
                if (this.aCT.Co() > this.aCW) {
                    if (this.aCO != null) {
                        this.aCO.setVisibility(0);
                        this.aCO.setOnClickListener(null);
                        if (this.aCP != null) {
                            this.aCP.setVisibility(8);
                        }
                    } else if (this.aCP != null && !this.aCU) {
                        this.aCP.setVisibility(8);
                    }
                    if (this.aCP != null && this.aCP.getVisibility() == 0 && this.aCP.getCount() != this.aCW) {
                        this.aCP.setCount(this.aCW);
                    }
                    Ck();
                }
                if (this.aCT.Co() >= 2 && this.aCT.Co() <= this.aCW) {
                    if (this.aCO != null) {
                        this.aCO.setVisibility(8);
                    }
                    if (this.aCP != null) {
                        this.aCP.setVisibility(0);
                        if (this.aCP.getCount() != this.aCT.Co()) {
                            this.aCP.setCount(this.aCT.Co());
                        }
                    }
                    Ck();
                }
                if (this.aCT.Co() < 2) {
                    if (this.aCO != null) {
                        this.aCO.setVisibility(8);
                    }
                    if (this.aCP != null) {
                        this.aCP.setVisibility(8);
                    }
                    Cl();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        int count;
        if (this.mViewPager != null && this.aCS != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aCS.getCount()) >= 2) {
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
        this.aCZ = j;
    }

    public void Ck() {
        if (this.aCV) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aCZ);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void Cl() {
        this.mHandler.removeMessages(1);
    }
}
