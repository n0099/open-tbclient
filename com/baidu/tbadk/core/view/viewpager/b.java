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
    private boolean aAa;
    private boolean aAb;
    private int aAc;
    private List<h> aAd;
    private ViewPager.OnPageChangeListener aAe;
    private long aAf;
    private ViewPager.OnPageChangeListener aAg;
    private TextView azU;
    private IndicatorView azV;
    private BdBaseViewPagerAdapter azY;
    private d azZ;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aAa = false;
        this.aAb = true;
        this.aAc = 2;
        this.aAd = new ArrayList();
        this.aAf = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Bj();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aAg = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.aAe != null) {
                    b.this.aAe.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.Bl();
                } else if (i == 0 && (count = b.this.azY.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Bk();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.aAe != null) {
                    b.this.aAe.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.azZ != null && b.this.azZ.dI(i) == i) {
                    if (b.this.azV != null) {
                        b.this.azV.setPosition(b.this.azZ.dJ(i));
                    }
                    if (b.this.aAe != null) {
                        b.this.aAe.onPageSelected(b.this.azZ.dJ(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.aAa = false;
        this.aAb = true;
        this.aAc = 2;
        this.aAd = new ArrayList();
        this.aAf = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Bj();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.aAg = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.aAe != null) {
                    b.this.aAe.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.Bl();
                } else if (i2 == 0 && (count = b.this.azY.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Bk();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.aAe != null) {
                    b.this.aAe.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.azZ != null && b.this.azZ.dI(i2) == i2) {
                    if (b.this.azV != null) {
                        b.this.azV.setPosition(b.this.azZ.dJ(i2));
                    }
                    if (b.this.aAe != null) {
                        b.this.aAe.onPageSelected(b.this.azZ.dJ(i2));
                    }
                }
            }
        };
        this.aAa = z;
        this.aAb = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.azV = indicatorView;
        this.azU = textView;
        this.mContext = context;
        this.azY = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.azY);
            this.mViewPager.setOnPageChangeListener(this.aAg);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.aAc = i;
        if (this.azZ != null) {
            this.azZ.dK(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aAa = z;
    }

    public void ba(boolean z) {
        this.aAb = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.azY != null) {
            this.azY.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (w.z(list) != 0) {
            this.aAd = list;
            this.azZ = new d(this.aAd, this.aAa, this.aAc);
            this.azZ.dL(2);
            this.azZ.dM(1);
            this.azY.setDatas(this.azZ.Bq());
            this.azY.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.azZ.Bp(), false);
            if (this.azZ.Bo() > 0) {
                if (this.azZ.Bo() > this.aAc) {
                    if (this.azU != null) {
                        this.azU.setVisibility(0);
                        this.azU.setOnClickListener(null);
                        if (this.azV != null) {
                            this.azV.setVisibility(8);
                        }
                    } else if (this.azV != null && !this.aAa) {
                        this.azV.setVisibility(8);
                    }
                    if (this.azV != null && this.azV.getVisibility() == 0 && this.azV.getCount() != this.aAc) {
                        this.azV.setCount(this.aAc);
                    }
                    Bk();
                }
                if (this.azZ.Bo() >= 2 && this.azZ.Bo() <= this.aAc) {
                    if (this.azU != null) {
                        this.azU.setVisibility(8);
                    }
                    if (this.azV != null) {
                        this.azV.setVisibility(0);
                        if (this.azV.getCount() != this.azZ.Bo()) {
                            this.azV.setCount(this.azZ.Bo());
                        }
                    }
                    Bk();
                }
                if (this.azZ.Bo() < 2) {
                    if (this.azU != null) {
                        this.azU.setVisibility(8);
                    }
                    if (this.azV != null) {
                        this.azV.setVisibility(8);
                    }
                    Bl();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj() {
        int count;
        if (this.mViewPager != null && this.azY != null) {
            com.baidu.adp.base.h ab = i.ab(this.mContext);
            if ((ab == null || !ab.isScroll()) && (count = this.azY.getCount()) >= 2) {
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
        this.aAf = j;
    }

    public void Bk() {
        if (this.aAb) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.aAf);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void Bl() {
        this.mHandler.removeMessages(1);
    }
}
