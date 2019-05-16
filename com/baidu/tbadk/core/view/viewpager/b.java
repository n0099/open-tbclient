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
    private TextView ccN;
    private IndicatorView ccO;
    private BdBaseViewPagerAdapter ccR;
    private d ccS;
    private boolean ccT;
    private boolean ccU;
    private int ccV;
    private List<m> ccW;
    private ViewPager.OnPageChangeListener ccX;
    private long ccY;
    private ViewPager.OnPageChangeListener ccZ;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ccT = false;
        this.ccU = true;
        this.ccV = 2;
        this.ccW = new ArrayList();
        this.ccY = 5000L;
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
        this.ccZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.ccX != null) {
                    b.this.ccX.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.aki();
                } else if (i == 0 && (count = b.this.ccR.getCount()) >= 2) {
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
                if (b.this.ccX != null) {
                    b.this.ccX.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.ccS != null && b.this.ccS.jc(i) == i) {
                    if (b.this.ccO != null) {
                        b.this.ccO.setPosition(b.this.ccS.jd(i));
                    }
                    if (b.this.ccX != null) {
                        b.this.ccX.onPageSelected(b.this.ccS.jd(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ccT = false;
        this.ccU = true;
        this.ccV = 2;
        this.ccW = new ArrayList();
        this.ccY = 5000L;
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
        this.ccZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.ccX != null) {
                    b.this.ccX.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.aki();
                } else if (i2 == 0 && (count = b.this.ccR.getCount()) >= 2) {
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
                if (b.this.ccX != null) {
                    b.this.ccX.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.ccS != null && b.this.ccS.jc(i2) == i2) {
                    if (b.this.ccO != null) {
                        b.this.ccO.setPosition(b.this.ccS.jd(i2));
                    }
                    if (b.this.ccX != null) {
                        b.this.ccX.onPageSelected(b.this.ccS.jd(i2));
                    }
                }
            }
        };
        this.ccT = z;
        this.ccU = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.ccO = indicatorView;
        this.ccN = textView;
        this.mContext = context;
        this.ccR = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ccR);
            this.mViewPager.setOnPageChangeListener(this.ccZ);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccV = i;
        if (this.ccS != null) {
            this.ccS.je(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ccT = z;
    }

    public void eu(boolean z) {
        this.ccU = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ccR != null) {
            this.ccR.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.Z(list) != 0) {
            this.ccW = list;
            this.ccS = new d(this.ccW, this.ccT, this.ccV);
            this.ccS.jf(2);
            this.ccS.jg(1);
            this.ccR.setDatas(this.ccS.akn());
            this.ccR.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.ccS.akm(), false);
            if (this.ccS.akl() > 0) {
                if (this.ccS.akl() > this.ccV) {
                    if (this.ccN != null) {
                        this.ccN.setVisibility(0);
                        this.ccN.setOnClickListener(null);
                        if (this.ccO != null) {
                            this.ccO.setVisibility(8);
                        }
                    } else if (this.ccO != null && !this.ccT) {
                        this.ccO.setVisibility(8);
                    }
                    if (this.ccO != null && this.ccO.getVisibility() == 0 && this.ccO.getCount() != this.ccV) {
                        this.ccO.setCount(this.ccV);
                    }
                    akh();
                }
                if (this.ccS.akl() >= 2 && this.ccS.akl() <= this.ccV) {
                    if (this.ccN != null) {
                        this.ccN.setVisibility(8);
                    }
                    if (this.ccO != null) {
                        this.ccO.setVisibility(0);
                        if (this.ccO.getCount() != this.ccS.akl()) {
                            this.ccO.setCount(this.ccS.akl());
                        }
                    }
                    akh();
                }
                if (this.ccS.akl() < 2) {
                    if (this.ccN != null) {
                        this.ccN.setVisibility(8);
                    }
                    if (this.ccO != null) {
                        this.ccO.setVisibility(8);
                    }
                    aki();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akg() {
        int count;
        if (this.mViewPager != null && this.ccR != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.ccR.getCount()) >= 2) {
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
        this.ccY = j;
    }

    public void akh() {
        if (this.ccU) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.ccY);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void aki() {
        this.mHandler.removeMessages(1);
    }
}
