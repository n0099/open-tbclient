package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ViewPager Ze;
    private ViewPager.OnPageChangeListener cBy;
    private TextView foN;
    private IndicatorView foO;
    private BdBaseViewPagerAdapter foR;
    private c foS;
    private boolean foT;
    private boolean foU;
    private int foV;
    private List<n> foW;
    private long foX;
    private ViewPager.OnPageChangeListener foY;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.foT = false;
        this.foU = true;
        this.foV = 2;
        this.foW = new ArrayList();
        this.foX = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bvu();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.foY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (a.this.cBy != null) {
                    a.this.cBy.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    a.this.bvw();
                } else if (i == 0 && (count = a.this.foR.getCount()) >= 2) {
                    int currentItem = a.this.Ze.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        a.this.Ze.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        a.this.Ze.setCurrentItem(1, false);
                    }
                    a.this.bvv();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (a.this.cBy != null) {
                    a.this.cBy.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (a.this.foS != null && a.this.foS.qf(i) == i) {
                    if (a.this.foO != null) {
                        a.this.foO.setPosition(a.this.foS.qg(i));
                    }
                    if (a.this.cBy != null) {
                        a.this.cBy.onPageSelected(a.this.foS.qg(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.foT = false;
        this.foU = true;
        this.foV = 2;
        this.foW = new ArrayList();
        this.foX = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bvu();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.foY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (a.this.cBy != null) {
                    a.this.cBy.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    a.this.bvw();
                } else if (i2 == 0 && (count = a.this.foR.getCount()) >= 2) {
                    int currentItem = a.this.Ze.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        a.this.Ze.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        a.this.Ze.setCurrentItem(1, false);
                    }
                    a.this.bvv();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (a.this.cBy != null) {
                    a.this.cBy.onPageScrolled(i2, f, i22);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (a.this.foS != null && a.this.foS.qf(i2) == i2) {
                    if (a.this.foO != null) {
                        a.this.foO.setPosition(a.this.foS.qg(i2));
                    }
                    if (a.this.cBy != null) {
                        a.this.cBy.onPageSelected(a.this.foS.qg(i2));
                    }
                }
            }
        };
        this.foT = z;
        this.foU = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.Ze = viewPager;
        this.foO = indicatorView;
        this.foN = textView;
        this.mContext = context;
        this.foR = new BdBaseViewPagerAdapter(context);
        if (this.Ze != null) {
            this.Ze.setAdapter(this.foR);
            this.Ze.setOnPageChangeListener(this.foY);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.foV = i;
        if (this.foS != null) {
            this.foS.qh(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.foT = z;
    }

    public void ki(boolean z) {
        this.foU = z;
    }

    public void a(Context context, b<?, ?> bVar) {
        if (this.foR != null) {
            this.foR.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        if (y.getCount(list) != 0) {
            this.foW = list;
            this.foS = new c(this.foW, this.foT, this.foV);
            this.foS.qi(2);
            this.foS.qj(1);
            this.foR.setDatas(this.foS.bvB());
            this.foR.notifyDataSetChanged();
            this.Ze.setCurrentItem(this.foS.bvA(), false);
            if (this.foS.bvz() > 0) {
                if (this.foS.bvz() > this.foV) {
                    if (this.foN != null) {
                        this.foN.setVisibility(0);
                        this.foN.setOnClickListener(null);
                        if (this.foO != null) {
                            this.foO.setVisibility(8);
                        }
                    } else if (this.foO != null && !this.foT) {
                        this.foO.setVisibility(8);
                    }
                    if (this.foO != null && this.foO.getVisibility() == 0 && this.foO.getCount() != this.foV) {
                        this.foO.setCount(this.foV);
                    }
                    bvv();
                }
                if (this.foS.bvz() >= 2 && this.foS.bvz() <= this.foV) {
                    if (this.foN != null) {
                        this.foN.setVisibility(8);
                    }
                    if (this.foO != null) {
                        this.foO.setVisibility(0);
                        if (this.foO.getCount() != this.foS.bvz()) {
                            this.foO.setCount(this.foS.bvz());
                        }
                    }
                    bvv();
                }
                if (this.foS.bvz() < 2) {
                    if (this.foN != null) {
                        this.foN.setVisibility(8);
                    }
                    if (this.foO != null) {
                        this.foO.setVisibility(8);
                    }
                    bvw();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvu() {
        int count;
        if (this.Ze != null && this.foR != null) {
            i I = j.I(this.mContext);
            if ((I == null || !I.isScroll()) && (count = this.foR.getCount()) >= 2) {
                int currentItem = this.Ze.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.Ze.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.Ze.setCurrentItem(1, false);
                } else {
                    this.Ze.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.foX = j;
    }

    public void bvv() {
        if (this.foU) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.foX);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvw() {
        this.mHandler.removeMessages(1);
    }
}
