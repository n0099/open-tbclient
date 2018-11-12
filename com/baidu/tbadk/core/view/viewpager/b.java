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
    private TextView aIk;
    private IndicatorView aIl;
    private BdBaseViewPagerAdapter aIo;
    private d aIp;
    private boolean aIq;
    private boolean aIr;
    private int aIs;
    private List<h> aIt;
    private ViewPager.OnPageChangeListener aIu;
    private long aIv;
    private ViewPager.OnPageChangeListener aIw;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aIq = false;
        this.aIr = true;
        this.aIs = 2;
        this.aIt = new ArrayList();
        this.aIv = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Ey();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aIw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aIu != null) {
                    b.this.aIu.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.EA();
                } else if (i == 0 && (count = b.this.aIo.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ez();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aIu != null) {
                    b.this.aIu.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.aIp != null && b.this.aIp.eu(i) == i) {
                    if (b.this.aIl != null) {
                        b.this.aIl.setPosition(b.this.aIp.ev(i));
                    }
                    if (b.this.aIu != null) {
                        b.this.aIu.onPageSelected(b.this.aIp.ev(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aIq = false;
        this.aIr = true;
        this.aIs = 2;
        this.aIt = new ArrayList();
        this.aIv = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Ey();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aIw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aIu != null) {
                    b.this.aIu.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.EA();
                } else if (i2 == 0 && (count = b.this.aIo.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Ez();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aIu != null) {
                    b.this.aIu.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.aIp != null && b.this.aIp.eu(i2) == i2) {
                    if (b.this.aIl != null) {
                        b.this.aIl.setPosition(b.this.aIp.ev(i2));
                    }
                    if (b.this.aIu != null) {
                        b.this.aIu.onPageSelected(b.this.aIp.ev(i2));
                    }
                }
            }
        };
        this.aIq = z;
        this.aIr = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.aIl = indicatorView;
        this.aIk = textView;
        this.mContext = context;
        this.aIo = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.aIo);
            this.mViewPager.setOnPageChangeListener(this.aIw);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aIs = i;
        if (this.aIp != null) {
            this.aIp.ew(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aIq = z;
    }

    public void bM(boolean z) {
        this.aIr = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.aIo != null) {
            this.aIo.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (v.H(list) != 0) {
            this.aIt = list;
            this.aIp = new d(this.aIt, this.aIq, this.aIs);
            this.aIp.ex(2);
            this.aIp.ey(1);
            this.aIo.setDatas(this.aIp.EF());
            this.aIo.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.aIp.EE(), false);
            if (this.aIp.ED() > 0) {
                if (this.aIp.ED() > this.aIs) {
                    if (this.aIk != null) {
                        this.aIk.setVisibility(0);
                        this.aIk.setOnClickListener(null);
                        if (this.aIl != null) {
                            this.aIl.setVisibility(8);
                        }
                    } else if (this.aIl != null && !this.aIq) {
                        this.aIl.setVisibility(8);
                    }
                    if (this.aIl != null && this.aIl.getVisibility() == 0 && this.aIl.getCount() != this.aIs) {
                        this.aIl.setCount(this.aIs);
                    }
                    Ez();
                }
                if (this.aIp.ED() >= 2 && this.aIp.ED() <= this.aIs) {
                    if (this.aIk != null) {
                        this.aIk.setVisibility(8);
                    }
                    if (this.aIl != null) {
                        this.aIl.setVisibility(0);
                        if (this.aIl.getCount() != this.aIp.ED()) {
                            this.aIl.setCount(this.aIp.ED());
                        }
                    }
                    Ez();
                }
                if (this.aIp.ED() < 2) {
                    if (this.aIk != null) {
                        this.aIk.setVisibility(8);
                    }
                    if (this.aIl != null) {
                        this.aIl.setVisibility(8);
                    }
                    EA();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        int count;
        if (this.mViewPager != null && this.aIo != null) {
            com.baidu.adp.base.h aI = i.aI(this.mContext);
            if ((aI == null || !aI.isScroll()) && (count = this.aIo.getCount()) >= 2) {
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
        this.aIv = j;
    }

    public void Ez() {
        if (this.aIr) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aIv);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void EA() {
        this.mHandler.removeMessages(1);
    }
}
