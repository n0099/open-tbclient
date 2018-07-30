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
    private TextView azN;
    private IndicatorView azO;
    private BdBaseViewPagerAdapter azR;
    private d azS;
    private boolean azT;
    private boolean azU;
    private int azV;
    private List<h> azW;
    private ViewPager.OnPageChangeListener azX;
    private long azY;
    private ViewPager.OnPageChangeListener azZ;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.azT = false;
        this.azU = true;
        this.azV = 2;
        this.azW = new ArrayList();
        this.azY = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Ba();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.azX != null) {
                    b.this.azX.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.Bc();
                } else if (i == 0 && (count = b.this.azR.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Bb();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.azX != null) {
                    b.this.azX.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.azS != null && b.this.azS.dL(i) == i) {
                    if (b.this.azO != null) {
                        b.this.azO.setPosition(b.this.azS.dM(i));
                    }
                    if (b.this.azX != null) {
                        b.this.azX.onPageSelected(b.this.azS.dM(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.azT = false;
        this.azU = true;
        this.azV = 2;
        this.azW = new ArrayList();
        this.azY = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.Ba();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.azX != null) {
                    b.this.azX.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.Bc();
                } else if (i2 == 0 && (count = b.this.azR.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.Bb();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.azX != null) {
                    b.this.azX.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.azS != null && b.this.azS.dL(i2) == i2) {
                    if (b.this.azO != null) {
                        b.this.azO.setPosition(b.this.azS.dM(i2));
                    }
                    if (b.this.azX != null) {
                        b.this.azX.onPageSelected(b.this.azS.dM(i2));
                    }
                }
            }
        };
        this.azT = z;
        this.azU = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.azO = indicatorView;
        this.azN = textView;
        this.mContext = context;
        this.azR = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.azR);
            this.mViewPager.setOnPageChangeListener(this.azZ);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.azV = i;
        if (this.azS != null) {
            this.azS.dN(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azT = z;
    }

    public void aY(boolean z) {
        this.azU = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.azR != null) {
            this.azR.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (w.y(list) != 0) {
            this.azW = list;
            this.azS = new d(this.azW, this.azT, this.azV);
            this.azS.dO(2);
            this.azS.dP(1);
            this.azR.setDatas(this.azS.Bh());
            this.azR.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.azS.Bg(), false);
            if (this.azS.Bf() > 0) {
                if (this.azS.Bf() > this.azV) {
                    if (this.azN != null) {
                        this.azN.setVisibility(0);
                        this.azN.setOnClickListener(null);
                        if (this.azO != null) {
                            this.azO.setVisibility(8);
                        }
                    } else if (this.azO != null && !this.azT) {
                        this.azO.setVisibility(8);
                    }
                    if (this.azO != null && this.azO.getVisibility() == 0 && this.azO.getCount() != this.azV) {
                        this.azO.setCount(this.azV);
                    }
                    Bb();
                }
                if (this.azS.Bf() >= 2 && this.azS.Bf() <= this.azV) {
                    if (this.azN != null) {
                        this.azN.setVisibility(8);
                    }
                    if (this.azO != null) {
                        this.azO.setVisibility(0);
                        if (this.azO.getCount() != this.azS.Bf()) {
                            this.azO.setCount(this.azS.Bf());
                        }
                    }
                    Bb();
                }
                if (this.azS.Bf() < 2) {
                    if (this.azN != null) {
                        this.azN.setVisibility(8);
                    }
                    if (this.azO != null) {
                        this.azO.setVisibility(8);
                    }
                    Bc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        int count;
        if (this.mViewPager != null && this.azR != null) {
            com.baidu.adp.base.h ab = i.ab(this.mContext);
            if ((ab == null || !ab.isScroll()) && (count = this.azR.getCount()) >= 2) {
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
        this.azY = j;
    }

    public void Bb() {
        if (this.azU) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.azY);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void Bc() {
        this.mHandler.removeMessages(1);
    }
}
