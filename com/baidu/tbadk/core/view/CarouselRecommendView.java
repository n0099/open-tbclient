package com.baidu.tbadk.core.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselRecommendView<T extends com.baidu.tbadk.core.data.k> extends FrameLayout {
    private static int Lv = 5000;
    private CarouselRecommendView<T>.g LA;
    public View.OnTouchListener LB;
    private CarouselRecommendView<T>.e Lo;
    private IndicatorView Lq;
    private float Lr;
    private int Ls;
    private int Lt;
    private int Lu;
    private boolean Lw;
    private View Lx;
    private String Ly;
    private List<T> Lz;
    private TbPageContext<?> mContext;
    private Handler mHandler;
    private int mHeight;
    private ViewPager mPager;
    private int mWidth;

    public CarouselRecommendView(Context context, boolean z) {
        this(context, null, z);
    }

    public View getViewPagerBottomLine() {
        return this.Lx;
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPager = null;
        this.Lq = null;
        this.Lo = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.Lr = 0.3043478f;
        this.Lw = true;
        this.Ly = "";
        this.Lz = new ArrayList();
        this.mHandler = new c(this);
        this.LA = null;
        this.LB = new d(this);
        this.Lw = z;
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.carousel_topics_recommend, this, true);
        this.mPager = (ViewPager) findViewById(com.baidu.tieba.w.carousel_pager);
        if (z) {
            this.Lx = findViewById(com.baidu.tieba.w.carousel_bottom_line);
            this.Lq = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator_for_game_center);
        } else {
            this.Lq = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator);
        }
        this.Lq.setVisibility(0);
        this.mPager.setOnTouchListener(this.LB);
        if (this.Lw) {
            this.mWidth = com.baidu.adp.lib.util.l.M(context);
            this.mHeight = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds330);
        } else {
            this.Lt = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingTop);
            this.Ls = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingBottom);
            this.Lu = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_page_padding);
            this.mWidth = com.baidu.adp.lib.util.l.M(context) - (this.Lu * 2);
            this.mHeight = (int) (0.5f + (this.mWidth * this.Lr));
            setPadding(this.Lu, this.Lt, this.Lu, this.Ls);
        }
        ViewGroup.LayoutParams layoutParams = this.mPager.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        this.mPager.setLayoutParams(layoutParams);
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, true);
    }

    public boolean a(TbPageContext<?> tbPageContext, List<T> list) {
        this.mContext = tbPageContext;
        if (this.Lo == null) {
            this.Lo = new e(this.mContext);
        }
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return false;
        }
        this.Lz.clear();
        this.Lz = list;
        setVisibility(0);
        int size = this.Lz.size();
        if (size > 1) {
            this.Lz.add(list.get(0));
            this.Lz.add(0, list.get(list.size() - 1));
        }
        this.LA = new g(this, null);
        this.Lo.setData(this.Lz);
        this.mPager.setAdapter(this.Lo);
        this.mPager.setOnPageChangeListener(this.LA);
        this.mPager.setCurrentItem(size > 1 ? 1 : 0, false);
        this.mPager.invalidate();
        if (size > 1) {
            this.Lq.setVisibility(0);
            this.Lq.setCount(this.Lz.size() - 2);
            this.Lq.setPosition(0.0f);
        } else {
            this.Lq.setVisibility(8);
        }
        qk();
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.Lo != null) {
            this.Lo.onChangeSkinType(i);
        }
    }

    public void qk() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, Lv);
    }

    public void ql() {
        this.mHandler.removeMessages(0);
    }

    public CarouselRecommendView<T>.e getPagerAdapter() {
        return this.Lo;
    }

    public void setGameRefId(String str) {
        this.Ly = str;
    }

    public void onDestroy() {
        if (this.mPager != null) {
            this.mPager.setOnPageChangeListener(null);
        }
        if (this.Lo != null) {
            this.Lo.qo();
        }
    }

    /* loaded from: classes.dex */
    public class e extends PagerAdapter implements t, com.baidu.tbadk.imageManager.d {
        private TbPageContext<?> mContext;
        private View mParent;
        private List<T> LE = null;
        private int count = 0;
        private List<View> LF = new ArrayList();
        public List<TbImageView> LG = new ArrayList();

        public e(TbPageContext<?> tbPageContext) {
            this.mContext = null;
            this.mContext = tbPageContext;
        }

        public void qo() {
            for (TbImageView tbImageView : this.LG) {
                tbImageView.setOnClickListener(null);
            }
            this.LG.clear();
            this.LF.clear();
        }

        private void a(TbImageView tbImageView, T t, int i) {
            if (tbImageView != null && t != null && t.mN() != null) {
                if (CarouselRecommendView.this.Lw) {
                    tbImageView.a(t.mN().trim(), 10, CarouselRecommendView.this.mWidth, CarouselRecommendView.this.mHeight, false);
                } else {
                    tbImageView.a(t.mN().trim(), 10, CarouselRecommendView.this.mWidth - (CarouselRecommendView.this.Lu * 2), (CarouselRecommendView.this.mHeight - CarouselRecommendView.this.Lt) - CarouselRecommendView.this.Ls, false);
                }
                tbImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setOnClickListener(new f(this, t, tbImageView, i));
                this.LG.add(tbImageView);
            }
        }

        public void setData(List<T> list) {
            clear();
            if (list != null && list.size() != 0) {
                this.count = list.size();
                this.LE = list;
                int i = 0;
                while (i < this.count) {
                    TbImageView tbImageView = (TbImageView) com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getContext(), com.baidu.tieba.x.carousel_topics_recommend_item, null);
                    tbImageView.setSupportNoImage(false);
                    if (!CarouselRecommendView.this.Lw) {
                        tbImageView.setDrawerType(1);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setDrawBorder(true);
                    }
                    a(tbImageView, (TbImageView) list.get(i), i > 0 ? i - 1 : 0);
                    this.LF.add(tbImageView);
                    i++;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.LF == null) {
                return 0;
            }
            return this.LF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.LF.get(i);
            view.setTag(Integer.valueOf(i));
            view.invalidate();
            if (view.getParent() == null) {
                viewGroup.addView(view);
            }
            return view;
        }

        public void onChangeSkinType(int i) {
            if (this.LG != null && this.LG.size() > 0) {
                for (TbImageView tbImageView : this.LG) {
                    tbImageView.invalidate();
                }
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private void clear() {
            this.LF.clear();
            this.count = 0;
            this.LE = null;
            notifyDataSetChanged();
        }

        @Override // com.baidu.tbadk.core.view.t
        public void qm() {
        }

        @Override // com.baidu.tbadk.core.view.t
        public void f(View view, int i, int i2) {
        }

        @Override // com.baidu.tbadk.imageManager.d
        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            if (this.mParent != null && (headImageView = (HeadImageView) this.mParent.findViewWithTag(str)) != null) {
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                headImageView.invalidate();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements ViewPager.OnPageChangeListener {
        private g() {
        }

        /* synthetic */ g(CarouselRecommendView carouselRecommendView, g gVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (CarouselRecommendView.this.Lq != null && CarouselRecommendView.this.Lo != null && CarouselRecommendView.this.Lz.size() > 1) {
                int count = CarouselRecommendView.this.Lo.getCount();
                if (i == 0) {
                    CarouselRecommendView.this.Lq.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CarouselRecommendView.this.Lq.setPosition(f);
                } else {
                    CarouselRecommendView.this.Lq.setPosition((i - 1) + f);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            String str;
            if (CarouselRecommendView.this.Lw && i >= 1 && i <= 5) {
                com.baidu.tbadk.core.data.k kVar = (com.baidu.tbadk.core.data.k) CarouselRecommendView.this.Lz.get(i - 1);
                if (!(kVar instanceof com.baidu.tbadk.core.data.k)) {
                    str = "";
                } else {
                    str = com.baidu.tieba.tbadkCore.util.k.in(kVar.getLink());
                }
                if ("4001001".equals(CarouselRecommendView.this.Ly)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_single_" + i, "", 1, "dev_id", str);
                } else if ("4000201".equals(CarouselRecommendView.this.Ly)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_h5_" + i, "", 1, "dev_id", str);
                } else if ("4000101".equals(CarouselRecommendView.this.Ly)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_index_" + i, "", 1, "dev_id", str);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CarouselRecommendView.this.mPager != null && CarouselRecommendView.this.Lo != null) {
                if (i == 0) {
                    if (CarouselRecommendView.this.Lz.size() > 1) {
                        int currentItem = CarouselRecommendView.this.mPager.getCurrentItem();
                        if (currentItem < 1) {
                            CarouselRecommendView.this.mPager.setCurrentItem(CarouselRecommendView.this.Lo.getCount() - 2, false);
                            CarouselRecommendView.this.mPager.invalidate();
                        } else if (currentItem > CarouselRecommendView.this.Lo.getCount() - 2) {
                            CarouselRecommendView.this.mPager.setCurrentItem(1, false);
                            CarouselRecommendView.this.mPager.invalidate();
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.Lv);
                        } else {
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.Lv);
                        }
                    }
                    CarouselRecommendView.this.mPager.requestDisallowInterceptTouchEvent(false);
                } else if (i == 1) {
                    CarouselRecommendView.this.mPager.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }
}
