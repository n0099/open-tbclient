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
    private ViewPager.OnPageChangeListener ctL;
    private TextView faP;
    private IndicatorView faQ;
    private BdBaseViewPagerAdapter faT;
    private d faU;
    private boolean faV;
    private boolean faW;
    private int faX;
    private List<q> faY;
    private long faZ;
    private ViewPager.OnPageChangeListener fba;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.faV = false;
        this.faW = true;
        this.faX = 2;
        this.faY = new ArrayList();
        this.faZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.btK();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fba = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.ctL != null) {
                    b.this.ctL.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.btM();
                } else if (i == 0 && (count = b.this.faT.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.btL();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.ctL != null) {
                    b.this.ctL.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.faU != null && b.this.faU.qv(i) == i) {
                    if (b.this.faQ != null) {
                        b.this.faQ.setPosition(b.this.faU.qw(i));
                    }
                    if (b.this.ctL != null) {
                        b.this.ctL.onPageSelected(b.this.faU.qw(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.faV = false;
        this.faW = true;
        this.faX = 2;
        this.faY = new ArrayList();
        this.faZ = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.btK();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fba = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.ctL != null) {
                    b.this.ctL.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.btM();
                } else if (i2 == 0 && (count = b.this.faT.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.btL();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.ctL != null) {
                    b.this.ctL.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.faU != null && b.this.faU.qv(i2) == i2) {
                    if (b.this.faQ != null) {
                        b.this.faQ.setPosition(b.this.faU.qw(i2));
                    }
                    if (b.this.ctL != null) {
                        b.this.ctL.onPageSelected(b.this.faU.qw(i2));
                    }
                }
            }
        };
        this.faV = z;
        this.faW = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.faQ = indicatorView;
        this.faP = textView;
        this.mContext = context;
        this.faT = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.faT);
            this.mViewPager.setOnPageChangeListener(this.fba);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.faX = i;
        if (this.faU != null) {
            this.faU.qx(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.faV = z;
    }

    public void jw(boolean z) {
        this.faW = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.faT != null) {
            this.faT.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.faY = list;
            this.faU = new d(this.faY, this.faV, this.faX);
            this.faU.qy(2);
            this.faU.qz(1);
            this.faT.setDatas(this.faU.btR());
            this.faT.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.faU.btQ(), false);
            if (this.faU.btP() > 0) {
                if (this.faU.btP() > this.faX) {
                    if (this.faP != null) {
                        this.faP.setVisibility(0);
                        this.faP.setOnClickListener(null);
                        if (this.faQ != null) {
                            this.faQ.setVisibility(8);
                        }
                    } else if (this.faQ != null && !this.faV) {
                        this.faQ.setVisibility(8);
                    }
                    if (this.faQ != null && this.faQ.getVisibility() == 0 && this.faQ.getCount() != this.faX) {
                        this.faQ.setCount(this.faX);
                    }
                    btL();
                }
                if (this.faU.btP() >= 2 && this.faU.btP() <= this.faX) {
                    if (this.faP != null) {
                        this.faP.setVisibility(8);
                    }
                    if (this.faQ != null) {
                        this.faQ.setVisibility(0);
                        if (this.faQ.getCount() != this.faU.btP()) {
                            this.faQ.setCount(this.faU.btP());
                        }
                    }
                    btL();
                }
                if (this.faU.btP() < 2) {
                    if (this.faP != null) {
                        this.faP.setVisibility(8);
                    }
                    if (this.faQ != null) {
                        this.faQ.setVisibility(8);
                    }
                    btM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btK() {
        int count;
        if (this.mViewPager != null && this.faT != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.faT.getCount()) >= 2) {
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
        this.faZ = j;
    }

    public void btL() {
        if (this.faW) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.faZ);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void btM() {
        this.mHandler.removeMessages(1);
    }
}
