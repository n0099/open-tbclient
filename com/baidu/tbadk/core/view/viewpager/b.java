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
    private TextView ccO;
    private IndicatorView ccP;
    private BdBaseViewPagerAdapter ccS;
    private d ccT;
    private boolean ccU;
    private boolean ccV;
    private int ccW;
    private List<m> ccX;
    private ViewPager.OnPageChangeListener ccY;
    private long ccZ;
    private ViewPager.OnPageChangeListener cda;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ccU = false;
        this.ccV = true;
        this.ccW = 2;
        this.ccX = new ArrayList();
        this.ccZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.akg();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cda = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.ccY != null) {
                    b.this.ccY.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aki();
                } else if (i == 0 && (count = b.this.ccS.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.akh();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.ccY != null) {
                    b.this.ccY.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.ccT != null && b.this.ccT.jc(i) == i) {
                    if (b.this.ccP != null) {
                        b.this.ccP.setPosition(b.this.ccT.jd(i));
                    }
                    if (b.this.ccY != null) {
                        b.this.ccY.onPageSelected(b.this.ccT.jd(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ccU = false;
        this.ccV = true;
        this.ccW = 2;
        this.ccX = new ArrayList();
        this.ccZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.akg();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cda = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.ccY != null) {
                    b.this.ccY.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aki();
                } else if (i2 == 0 && (count = b.this.ccS.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.akh();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.ccY != null) {
                    b.this.ccY.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.ccT != null && b.this.ccT.jc(i2) == i2) {
                    if (b.this.ccP != null) {
                        b.this.ccP.setPosition(b.this.ccT.jd(i2));
                    }
                    if (b.this.ccY != null) {
                        b.this.ccY.onPageSelected(b.this.ccT.jd(i2));
                    }
                }
            }
        };
        this.ccU = z;
        this.ccV = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ccP = indicatorView;
        this.ccO = textView;
        this.mContext = context;
        this.ccS = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ccS);
            this.mViewPager.setOnPageChangeListener(this.cda);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccW = i;
        if (this.ccT != null) {
            this.ccT.je(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ccU = z;
    }

    public void eu(boolean z) {
        this.ccV = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ccS != null) {
            this.ccS.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.Z(list) != 0) {
            this.ccX = list;
            this.ccT = new d(this.ccX, this.ccU, this.ccW);
            this.ccT.jf(2);
            this.ccT.jg(1);
            this.ccS.setDatas(this.ccT.akn());
            this.ccS.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ccT.akm(), false);
            if (this.ccT.akl() > 0) {
                if (this.ccT.akl() > this.ccW) {
                    if (this.ccO != null) {
                        this.ccO.setVisibility(0);
                        this.ccO.setOnClickListener(null);
                        if (this.ccP != null) {
                            this.ccP.setVisibility(8);
                        }
                    } else if (this.ccP != null && !this.ccU) {
                        this.ccP.setVisibility(8);
                    }
                    if (this.ccP != null && this.ccP.getVisibility() == 0 && this.ccP.getCount() != this.ccW) {
                        this.ccP.setCount(this.ccW);
                    }
                    akh();
                }
                if (this.ccT.akl() >= 2 && this.ccT.akl() <= this.ccW) {
                    if (this.ccO != null) {
                        this.ccO.setVisibility(8);
                    }
                    if (this.ccP != null) {
                        this.ccP.setVisibility(0);
                        if (this.ccP.getCount() != this.ccT.akl()) {
                            this.ccP.setCount(this.ccT.akl());
                        }
                    }
                    akh();
                }
                if (this.ccT.akl() < 2) {
                    if (this.ccO != null) {
                        this.ccO.setVisibility(8);
                    }
                    if (this.ccP != null) {
                        this.ccP.setVisibility(8);
                    }
                    aki();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akg() {
        int count;
        if (this.mViewPager != null && this.ccS != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.ccS.getCount()) >= 2) {
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
        this.ccZ = j;
    }

    public void akh() {
        if (this.ccV) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ccZ);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aki() {
        this.mHandler.removeMessages(1);
    }
}
