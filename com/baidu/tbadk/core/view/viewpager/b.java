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
    private ViewPager.OnPageChangeListener cfo;
    private TextView eME;
    private IndicatorView eMF;
    private BdBaseViewPagerAdapter eMI;
    private d eMJ;
    private boolean eMK;
    private boolean eML;
    private int eMM;
    private List<q> eMN;
    private long eMO;
    private ViewPager.OnPageChangeListener eMP;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.eMK = false;
        this.eML = true;
        this.eMM = 2;
        this.eMN = new ArrayList();
        this.eMO = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bpr();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eMP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.cfo != null) {
                    b.this.cfo.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.bpt();
                } else if (i == 0 && (count = b.this.eMI.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bps();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.cfo != null) {
                    b.this.cfo.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.eMJ != null && b.this.eMJ.qa(i) == i) {
                    if (b.this.eMF != null) {
                        b.this.eMF.setPosition(b.this.eMJ.qb(i));
                    }
                    if (b.this.cfo != null) {
                        b.this.cfo.onPageSelected(b.this.eMJ.qb(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.eMK = false;
        this.eML = true;
        this.eMM = 2;
        this.eMN = new ArrayList();
        this.eMO = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.bpr();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.eMP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.cfo != null) {
                    b.this.cfo.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.bpt();
                } else if (i2 == 0 && (count = b.this.eMI.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.bps();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.cfo != null) {
                    b.this.cfo.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.eMJ != null && b.this.eMJ.qa(i2) == i2) {
                    if (b.this.eMF != null) {
                        b.this.eMF.setPosition(b.this.eMJ.qb(i2));
                    }
                    if (b.this.cfo != null) {
                        b.this.cfo.onPageSelected(b.this.eMJ.qb(i2));
                    }
                }
            }
        };
        this.eMK = z;
        this.eML = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.eMF = indicatorView;
        this.eME = textView;
        this.mContext = context;
        this.eMI = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.eMI);
            this.mViewPager.setOnPageChangeListener(this.eMP);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.eMM = i;
        if (this.eMJ != null) {
            this.eMJ.qc(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eMK = z;
    }

    public void ja(boolean z) {
        this.eML = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.eMI != null) {
            this.eMI.a(context, cVar);
        }
    }

    public void setDatas(List<q> list) {
        if (y.getCount(list) != 0) {
            this.eMN = list;
            this.eMJ = new d(this.eMN, this.eMK, this.eMM);
            this.eMJ.qd(2);
            this.eMJ.qe(1);
            this.eMI.setDatas(this.eMJ.bpy());
            this.eMI.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.eMJ.bpx(), false);
            if (this.eMJ.bpw() > 0) {
                if (this.eMJ.bpw() > this.eMM) {
                    if (this.eME != null) {
                        this.eME.setVisibility(0);
                        this.eME.setOnClickListener(null);
                        if (this.eMF != null) {
                            this.eMF.setVisibility(8);
                        }
                    } else if (this.eMF != null && !this.eMK) {
                        this.eMF.setVisibility(8);
                    }
                    if (this.eMF != null && this.eMF.getVisibility() == 0 && this.eMF.getCount() != this.eMM) {
                        this.eMF.setCount(this.eMM);
                    }
                    bps();
                }
                if (this.eMJ.bpw() >= 2 && this.eMJ.bpw() <= this.eMM) {
                    if (this.eME != null) {
                        this.eME.setVisibility(8);
                    }
                    if (this.eMF != null) {
                        this.eMF.setVisibility(0);
                        if (this.eMF.getCount() != this.eMJ.bpw()) {
                            this.eMF.setCount(this.eMJ.bpw());
                        }
                    }
                    bps();
                }
                if (this.eMJ.bpw() < 2) {
                    if (this.eME != null) {
                        this.eME.setVisibility(8);
                    }
                    if (this.eMF != null) {
                        this.eMF.setVisibility(8);
                    }
                    bpt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpr() {
        int count;
        if (this.mViewPager != null && this.eMI != null) {
            h G = i.G(this.mContext);
            if ((G == null || !G.isScroll()) && (count = this.eMI.getCount()) >= 2) {
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
        this.eMO = j;
    }

    public void bps() {
        if (this.eML) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.eMO);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void bpt() {
        this.mHandler.removeMessages(1);
    }
}
