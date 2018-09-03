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
    private TextView azK;
    private IndicatorView azL;
    private BdBaseViewPagerAdapter azO;
    private d azP;
    private boolean azQ;
    private boolean azR;
    private int azS;
    private List<h> azT;
    private ViewPager.OnPageChangeListener azU;
    private long azV;
    private ViewPager.OnPageChangeListener azW;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.azQ = false;
        this.azR = true;
        this.azS = 2;
        this.azT = new ArrayList();
        this.azV = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.AX();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.azU != null) {
                    b.this.azU.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.AZ();
                } else if (i == 0 && (count = b.this.azO.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.AY();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.azU != null) {
                    b.this.azU.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.azP != null && b.this.azP.dK(i) == i) {
                    if (b.this.azL != null) {
                        b.this.azL.setPosition(b.this.azP.dL(i));
                    }
                    if (b.this.azU != null) {
                        b.this.azU.onPageSelected(b.this.azP.dL(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.azQ = false;
        this.azR = true;
        this.azS = 2;
        this.azT = new ArrayList();
        this.azV = TbConfig.NOTIFY_SOUND_INTERVAL;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.AX();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.azW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.azU != null) {
                    b.this.azU.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.AZ();
                } else if (i2 == 0 && (count = b.this.azO.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.AY();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.azU != null) {
                    b.this.azU.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.azP != null && b.this.azP.dK(i2) == i2) {
                    if (b.this.azL != null) {
                        b.this.azL.setPosition(b.this.azP.dL(i2));
                    }
                    if (b.this.azU != null) {
                        b.this.azU.onPageSelected(b.this.azP.dL(i2));
                    }
                }
            }
        };
        this.azQ = z;
        this.azR = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.azL = indicatorView;
        this.azK = textView;
        this.mContext = context;
        this.azO = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.azO);
            this.mViewPager.setOnPageChangeListener(this.azW);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.azS = i;
        if (this.azP != null) {
            this.azP.dM(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azQ = z;
    }

    public void aZ(boolean z) {
        this.azR = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.azO != null) {
            this.azO.a(context, cVar);
        }
    }

    public void setDatas(List<h> list) {
        if (w.y(list) != 0) {
            this.azT = list;
            this.azP = new d(this.azT, this.azQ, this.azS);
            this.azP.dN(2);
            this.azP.dO(1);
            this.azO.setDatas(this.azP.Be());
            this.azO.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.azP.Bd(), false);
            if (this.azP.Bc() > 0) {
                if (this.azP.Bc() > this.azS) {
                    if (this.azK != null) {
                        this.azK.setVisibility(0);
                        this.azK.setOnClickListener(null);
                        if (this.azL != null) {
                            this.azL.setVisibility(8);
                        }
                    } else if (this.azL != null && !this.azQ) {
                        this.azL.setVisibility(8);
                    }
                    if (this.azL != null && this.azL.getVisibility() == 0 && this.azL.getCount() != this.azS) {
                        this.azL.setCount(this.azS);
                    }
                    AY();
                }
                if (this.azP.Bc() >= 2 && this.azP.Bc() <= this.azS) {
                    if (this.azK != null) {
                        this.azK.setVisibility(8);
                    }
                    if (this.azL != null) {
                        this.azL.setVisibility(0);
                        if (this.azL.getCount() != this.azP.Bc()) {
                            this.azL.setCount(this.azP.Bc());
                        }
                    }
                    AY();
                }
                if (this.azP.Bc() < 2) {
                    if (this.azK != null) {
                        this.azK.setVisibility(8);
                    }
                    if (this.azL != null) {
                        this.azL.setVisibility(8);
                    }
                    AZ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX() {
        int count;
        if (this.mViewPager != null && this.azO != null) {
            com.baidu.adp.base.h ab = i.ab(this.mContext);
            if ((ab == null || !ab.isScroll()) && (count = this.azO.getCount()) >= 2) {
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
        this.azV = j;
    }

    public void AY() {
        if (this.azR) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.azV);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void AZ() {
        this.mHandler.removeMessages(1);
    }
}
