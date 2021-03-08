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
    private ViewPager aaw;
    private ViewPager.OnPageChangeListener cCY;
    private TextView fqn;
    private IndicatorView fqo;
    private BdBaseViewPagerAdapter fqr;
    private c fqs;
    private boolean fqt;
    private boolean fqu;
    private int fqv;
    private List<n> fqw;
    private long fqx;
    private ViewPager.OnPageChangeListener fqy;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.fqt = false;
        this.fqu = true;
        this.fqv = 2;
        this.fqw = new ArrayList();
        this.fqx = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bvx();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fqy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (a.this.cCY != null) {
                    a.this.cCY.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    a.this.bvz();
                } else if (i == 0 && (count = a.this.fqr.getCount()) >= 2) {
                    int currentItem = a.this.aaw.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        a.this.aaw.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        a.this.aaw.setCurrentItem(1, false);
                    }
                    a.this.bvy();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (a.this.cCY != null) {
                    a.this.cCY.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (a.this.fqs != null && a.this.fqs.qg(i) == i) {
                    if (a.this.fqo != null) {
                        a.this.fqo.setPosition(a.this.fqs.qh(i));
                    }
                    if (a.this.cCY != null) {
                        a.this.cCY.onPageSelected(a.this.fqs.qh(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.fqt = false;
        this.fqu = true;
        this.fqv = 2;
        this.fqw = new ArrayList();
        this.fqx = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.a.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.bvx();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.fqy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.a.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (a.this.cCY != null) {
                    a.this.cCY.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    a.this.bvz();
                } else if (i2 == 0 && (count = a.this.fqr.getCount()) >= 2) {
                    int currentItem = a.this.aaw.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        a.this.aaw.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        a.this.aaw.setCurrentItem(1, false);
                    }
                    a.this.bvy();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (a.this.cCY != null) {
                    a.this.cCY.onPageScrolled(i2, f, i22);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (a.this.fqs != null && a.this.fqs.qg(i2) == i2) {
                    if (a.this.fqo != null) {
                        a.this.fqo.setPosition(a.this.fqs.qh(i2));
                    }
                    if (a.this.cCY != null) {
                        a.this.cCY.onPageSelected(a.this.fqs.qh(i2));
                    }
                }
            }
        };
        this.fqt = z;
        this.fqu = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.aaw = viewPager;
        this.fqo = indicatorView;
        this.fqn = textView;
        this.mContext = context;
        this.fqr = new BdBaseViewPagerAdapter(context);
        if (this.aaw != null) {
            this.aaw.setAdapter(this.fqr);
            this.aaw.setOnPageChangeListener(this.fqy);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.fqv = i;
        if (this.fqs != null) {
            this.fqs.qi(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fqt = z;
    }

    public void ki(boolean z) {
        this.fqu = z;
    }

    public void a(Context context, b<?, ?> bVar) {
        if (this.fqr != null) {
            this.fqr.a(context, bVar);
        }
    }

    public void setDatas(List<n> list) {
        if (y.getCount(list) != 0) {
            this.fqw = list;
            this.fqs = new c(this.fqw, this.fqt, this.fqv);
            this.fqs.qj(2);
            this.fqs.qk(1);
            this.fqr.setDatas(this.fqs.bvE());
            this.fqr.notifyDataSetChanged();
            this.aaw.setCurrentItem(this.fqs.bvD(), false);
            if (this.fqs.bvC() > 0) {
                if (this.fqs.bvC() > this.fqv) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(0);
                        this.fqn.setOnClickListener(null);
                        if (this.fqo != null) {
                            this.fqo.setVisibility(8);
                        }
                    } else if (this.fqo != null && !this.fqt) {
                        this.fqo.setVisibility(8);
                    }
                    if (this.fqo != null && this.fqo.getVisibility() == 0 && this.fqo.getCount() != this.fqv) {
                        this.fqo.setCount(this.fqv);
                    }
                    bvy();
                }
                if (this.fqs.bvC() >= 2 && this.fqs.bvC() <= this.fqv) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(8);
                    }
                    if (this.fqo != null) {
                        this.fqo.setVisibility(0);
                        if (this.fqo.getCount() != this.fqs.bvC()) {
                            this.fqo.setCount(this.fqs.bvC());
                        }
                    }
                    bvy();
                }
                if (this.fqs.bvC() < 2) {
                    if (this.fqn != null) {
                        this.fqn.setVisibility(8);
                    }
                    if (this.fqo != null) {
                        this.fqo.setVisibility(8);
                    }
                    bvz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvx() {
        int count;
        if (this.aaw != null && this.fqr != null) {
            i H = j.H(this.mContext);
            if ((H == null || !H.isScroll()) && (count = this.fqr.getCount()) >= 2) {
                int currentItem = this.aaw.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.aaw.setCurrentItem(i, false);
                } else if (currentItem > i) {
                    this.aaw.setCurrentItem(1, false);
                } else {
                    this.aaw.setCurrentItem(currentItem + 1);
                }
            }
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        this.fqx = j;
    }

    public void bvy() {
        if (this.fqu) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.fqx);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bvz() {
        this.mHandler.removeMessages(1);
    }
}
