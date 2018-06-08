package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private TextView azc;
    private IndicatorView azd;
    private BdBaseViewPagerAdapter azg;
    private d azh;
    private boolean azi;
    private boolean azj;
    private int azk;
    private List<h> azl;
    private ViewPager.OnPageChangeListener azm;
    private long azn;
    private ViewPager.OnPageChangeListener azo;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.azi = false;
        this.azj = true;
        this.azk = 2;
        this.azl = new ArrayList();
        this.azn = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.AR();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.azm != null) {
                    b.this.azm.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.AT();
                } else if (i == 0 && (count = b.this.azg.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.AS();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.azm != null) {
                    b.this.azm.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.azh != null && b.this.azh.dH(i) == i) {
                    if (b.this.azd != null) {
                        b.this.azd.setPosition(b.this.azh.dI(i));
                    }
                    if (b.this.azm != null) {
                        b.this.azm.onPageSelected(b.this.azh.dI(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.azi = false;
        this.azj = true;
        this.azk = 2;
        this.azl = new ArrayList();
        this.azn = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.AR();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.azm != null) {
                    b.this.azm.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.AT();
                } else if (i2 == 0 && (count = b.this.azg.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.AS();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.azm != null) {
                    b.this.azm.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.azh != null && b.this.azh.dH(i2) == i2) {
                    if (b.this.azd != null) {
                        b.this.azd.setPosition(b.this.azh.dI(i2));
                    }
                    if (b.this.azm != null) {
                        b.this.azm.onPageSelected(b.this.azh.dI(i2));
                    }
                }
            }
        };
        this.azi = z;
        this.azj = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.azd = indicatorView;
        this.azc = textView;
        this.mContext = context;
        this.azg = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.azg);
            this.mViewPager.setOnPageChangeListener(this.azo);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.azk = i;
        if (this.azh != null) {
            this.azh.dJ(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azi = z;
    }

    public void aX(boolean z) {
        this.azj = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.azg != null) {
            this.azg.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (w.y(list) != 0) {
            this.azl = list;
            this.azh = new d(this.azl, this.azi, this.azk);
            this.azh.dK(2);
            this.azh.dL(1);
            this.azg.setDatas(this.azh.AY());
            this.azg.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.azh.AX(), false);
            if (this.azh.AW() > 0) {
                if (this.azh.AW() > this.azk) {
                    if (this.azc != null) {
                        this.azc.setVisibility(0);
                        this.azc.setOnClickListener(null);
                        if (this.azd != null) {
                            this.azd.setVisibility(8);
                        }
                    } else if (this.azd != null && !this.azi) {
                        this.azd.setVisibility(8);
                    }
                    if (this.azd != null && this.azd.getVisibility() == 0 && this.azd.getCount() != this.azk) {
                        this.azd.setCount(this.azk);
                    }
                    AS();
                }
                if (this.azh.AW() >= 2 && this.azh.AW() <= this.azk) {
                    if (this.azc != null) {
                        this.azc.setVisibility(8);
                    }
                    if (this.azd != null) {
                        this.azd.setVisibility(0);
                        if (this.azd.getCount() != this.azh.AW()) {
                            this.azd.setCount(this.azh.AW());
                        }
                    }
                    AS();
                }
                if (this.azh.AW() < 2) {
                    if (this.azc != null) {
                        this.azc.setVisibility(8);
                    }
                    if (this.azd != null) {
                        this.azd.setVisibility(8);
                    }
                    AT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        int count;
        if (this.mViewPager != null && this.azg != null) {
            com.baidu.adp.base.h ab = i.ab(this.mContext);
            if ((ab == null || !ab.isScroll()) && (count = this.azg.getCount()) >= 2) {
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
        this.azn = j;
    }

    public void AS() {
        if (this.azj) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.azn);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void AT() {
        this.mHandler.removeMessages(1);
    }
}
