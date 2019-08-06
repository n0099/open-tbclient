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
    private TextView cdX;
    private IndicatorView cdY;
    private BdBaseViewPagerAdapter ceb;
    private d cec;
    private boolean ced;
    private boolean cee;
    private int cef;
    private List<m> ceg;
    private ViewPager.OnPageChangeListener ceh;
    private long cei;
    private ViewPager.OnPageChangeListener cej;
    private final Handler.Callback mCallback;
    private Context mContext;
    private final Handler mHandler;
    private ViewPager mViewPager;

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.ced = false;
        this.cee = true;
        this.cef = 2;
        this.ceg = new ArrayList();
        this.cei = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aln();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cej = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                int count;
                if (b.this.ceh != null) {
                    b.this.ceh.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    b.this.alp();
                } else if (i == 0 && (count = b.this.ceb.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alo();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (b.this.ceh != null) {
                    b.this.ceh.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.cec != null && b.this.cec.jj(i) == i) {
                    if (b.this.cdY != null) {
                        b.this.cdY.setPosition(b.this.cec.jk(i));
                    }
                    if (b.this.ceh != null) {
                        b.this.ceh.onPageSelected(b.this.cec.jk(i));
                    }
                }
            }
        };
        a(context, viewPager, indicatorView, textView);
    }

    public b(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.ced = false;
        this.cee = true;
        this.cef = 2;
        this.ceg = new ArrayList();
        this.cei = 5000L;
        this.mCallback = new Handler.Callback() { // from class: com.baidu.tbadk.core.view.viewpager.b.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.aln();
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mHandler = new Handler(this.mCallback);
        this.cej = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.core.view.viewpager.b.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                int count;
                if (b.this.ceh != null) {
                    b.this.ceh.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    b.this.alp();
                } else if (i2 == 0 && (count = b.this.ceb.getCount()) >= 2) {
                    int currentItem = b.this.mViewPager.getCurrentItem();
                    int i22 = count - 2;
                    if (currentItem < 1) {
                        b.this.mViewPager.setCurrentItem(i22, false);
                    } else if (currentItem > i22) {
                        b.this.mViewPager.setCurrentItem(1, false);
                    }
                    b.this.alo();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
                if (b.this.ceh != null) {
                    b.this.ceh.onPageScrolled(i2, f, i22);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (b.this.cec != null && b.this.cec.jj(i2) == i2) {
                    if (b.this.cdY != null) {
                        b.this.cdY.setPosition(b.this.cec.jk(i2));
                    }
                    if (b.this.ceh != null) {
                        b.this.ceh.onPageSelected(b.this.cec.jk(i2));
                    }
                }
            }
        };
        this.ced = z;
        this.cee = z2;
        setMaxScrollCountLimit(i);
        a(context, viewPager, indicatorView, textView);
    }

    private void a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.mViewPager = viewPager;
        this.cdY = indicatorView;
        this.cdX = textView;
        this.mContext = context;
        this.ceb = new BdBaseViewPagerAdapter(context);
        if (this.mViewPager != null) {
            this.mViewPager.setAdapter(this.ceb);
            this.mViewPager.setOnPageChangeListener(this.cej);
        }
    }

    public void setMaxScrollCountLimit(int i) {
        this.cef = i;
        if (this.cec != null) {
            this.cec.jl(i);
        }
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ced = z;
    }

    public void ey(boolean z) {
        this.cee = z;
    }

    public void a(Context context, c<?, ?> cVar) {
        if (this.ceb != null) {
            this.ceb.a(context, cVar);
        }
    }

    public void setDatas(List<m> list) {
        if (v.Z(list) != 0) {
            this.ceg = list;
            this.cec = new d(this.ceg, this.ced, this.cef);
            this.cec.jm(2);
            this.cec.jn(1);
            this.ceb.setDatas(this.cec.alu());
            this.ceb.notifyDataSetChanged();
            this.mViewPager.setCurrentItem(this.cec.alt(), false);
            if (this.cec.als() > 0) {
                if (this.cec.als() > this.cef) {
                    if (this.cdX != null) {
                        this.cdX.setVisibility(0);
                        this.cdX.setOnClickListener(null);
                        if (this.cdY != null) {
                            this.cdY.setVisibility(8);
                        }
                    } else if (this.cdY != null && !this.ced) {
                        this.cdY.setVisibility(8);
                    }
                    if (this.cdY != null && this.cdY.getVisibility() == 0 && this.cdY.getCount() != this.cef) {
                        this.cdY.setCount(this.cef);
                    }
                    alo();
                }
                if (this.cec.als() >= 2 && this.cec.als() <= this.cef) {
                    if (this.cdX != null) {
                        this.cdX.setVisibility(8);
                    }
                    if (this.cdY != null) {
                        this.cdY.setVisibility(0);
                        if (this.cdY.getCount() != this.cec.als()) {
                            this.cdY.setCount(this.cec.als());
                        }
                    }
                    alo();
                }
                if (this.cec.als() < 2) {
                    if (this.cdX != null) {
                        this.cdX.setVisibility(8);
                    }
                    if (this.cdY != null) {
                        this.cdY.setVisibility(8);
                    }
                    alp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        int count;
        if (this.mViewPager != null && this.ceb != null) {
            h Z = i.Z(this.mContext);
            if ((Z == null || !Z.isScroll()) && (count = this.ceb.getCount()) >= 2) {
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
        this.cei = j;
    }

    public void alo() {
        if (this.cee) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, this.cei);
            return;
        }
        this.mHandler.removeMessages(1);
    }

    public void alp() {
        this.mHandler.removeMessages(1);
    }
}
