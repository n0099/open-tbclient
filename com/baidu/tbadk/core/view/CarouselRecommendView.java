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
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselRecommendView<T extends com.baidu.tbadk.core.data.l> extends FrameLayout {
    private static int LN = 5000;
    private CarouselRecommendView<T>.e LG;
    private IndicatorView LI;
    private float LJ;
    private int LK;
    private int LL;
    private int LM;
    private boolean LO;
    private View LP;
    private String LQ;
    private List<T> LR;
    private CarouselRecommendView<T>.g LS;
    public View.OnTouchListener LT;
    private TbPageContext<?> mContext;
    private Handler mHandler;
    private int mHeight;
    private ViewPager mPager;
    private int mWidth;

    public CarouselRecommendView(Context context, boolean z) {
        this(context, null, z);
    }

    public View getViewPagerBottomLine() {
        return this.LP;
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPager = null;
        this.LI = null;
        this.LG = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.LJ = 0.3043478f;
        this.LO = true;
        this.LQ = "";
        this.LR = new ArrayList();
        this.mHandler = new c(this);
        this.LS = null;
        this.LT = new d(this);
        this.LO = z;
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.carousel_topics_recommend, this, true);
        this.mPager = (ViewPager) findViewById(com.baidu.tieba.w.carousel_pager);
        if (z) {
            this.LP = findViewById(com.baidu.tieba.w.carousel_bottom_line);
            this.LI = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator_for_game_center);
        } else {
            this.LI = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator);
        }
        this.LI.setVisibility(0);
        this.mPager.setOnTouchListener(this.LT);
        if (this.LO) {
            this.mWidth = com.baidu.adp.lib.util.l.M(context);
            this.mHeight = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds330);
        } else {
            this.LL = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingTop);
            this.LK = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingBottom);
            this.LM = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_page_padding);
            this.mWidth = com.baidu.adp.lib.util.l.M(context) - (this.LM * 2);
            this.mHeight = (int) (0.5f + (this.mWidth * this.LJ));
            setPadding(this.LM, this.LL, this.LM, this.LK);
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
        if (this.LG == null) {
            this.LG = new e(this.mContext);
        }
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return false;
        }
        this.LR.clear();
        this.LR = list;
        setVisibility(0);
        int size = this.LR.size();
        if (size > 1) {
            this.LR.add(list.get(0));
            this.LR.add(0, list.get(list.size() - 1));
        }
        this.LS = new g(this, null);
        this.LG.setData(this.LR);
        this.mPager.setAdapter(this.LG);
        this.mPager.setOnPageChangeListener(this.LS);
        this.mPager.setCurrentItem(size > 1 ? 1 : 0, false);
        this.mPager.invalidate();
        if (size > 1) {
            this.LI.setVisibility(0);
            this.LI.setCount(this.LR.size() - 2);
            this.LI.setPosition(0.0f);
        } else {
            this.LI.setVisibility(8);
        }
        qo();
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.LG != null) {
            this.LG.onChangeSkinType(i);
        }
    }

    public void qo() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, LN);
    }

    public void qp() {
        this.mHandler.removeMessages(0);
    }

    public CarouselRecommendView<T>.e getPagerAdapter() {
        return this.LG;
    }

    public void setGameRefId(String str) {
        this.LQ = str;
    }

    public void onDestroy() {
        if (this.mPager != null) {
            this.mPager.setOnPageChangeListener(null);
        }
        if (this.LG != null) {
            this.LG.qs();
        }
    }

    /* loaded from: classes.dex */
    public class e extends PagerAdapter implements t, com.baidu.tbadk.imageManager.d {
        private TbPageContext<?> mContext;
        private View mParent;
        private List<T> LV = null;
        private int count = 0;
        private List<View> LW = new ArrayList();
        public List<TbImageView> LX = new ArrayList();

        public e(TbPageContext<?> tbPageContext) {
            this.mContext = null;
            this.mContext = tbPageContext;
        }

        public void qs() {
            for (TbImageView tbImageView : this.LX) {
                tbImageView.setOnClickListener(null);
            }
            this.LX.clear();
            this.LW.clear();
        }

        private void a(TbImageView tbImageView, T t, int i) {
            if (tbImageView != null && t != null && t.mI() != null) {
                if (CarouselRecommendView.this.LO) {
                    tbImageView.a(t.mI().trim(), 10, CarouselRecommendView.this.mWidth, CarouselRecommendView.this.mHeight, false);
                } else {
                    tbImageView.a(t.mI().trim(), 10, CarouselRecommendView.this.mWidth - (CarouselRecommendView.this.LM * 2), (CarouselRecommendView.this.mHeight - CarouselRecommendView.this.LL) - CarouselRecommendView.this.LK, false);
                }
                tbImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setOnClickListener(new f(this, t, tbImageView, i));
                this.LX.add(tbImageView);
            }
        }

        public void setData(List<T> list) {
            clear();
            if (list != null && list.size() != 0) {
                this.count = list.size();
                this.LV = list;
                int i = 0;
                while (i < this.count) {
                    TbImageView tbImageView = (TbImageView) com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.carousel_topics_recommend_item, null);
                    tbImageView.setSupportNoImage(false);
                    if (!CarouselRecommendView.this.LO) {
                        tbImageView.setDrawerType(1);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setDrawBorder(true);
                    }
                    a(tbImageView, (TbImageView) list.get(i), i > 0 ? i - 1 : 0);
                    this.LW.add(tbImageView);
                    i++;
                }
                notifyDataSetChanged();
            }
        }

        public List<TbImageView> qt() {
            return this.LX;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.LW == null) {
                return 0;
            }
            return this.LW.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.LW.get(i);
            view.setTag(Integer.valueOf(i));
            view.invalidate();
            if (view.getParent() == null) {
                viewGroup.addView(view);
            }
            return view;
        }

        public void onChangeSkinType(int i) {
            if (this.LX != null && this.LX.size() > 0) {
                for (TbImageView tbImageView : this.LX) {
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
            this.LW.clear();
            this.count = 0;
            this.LV = null;
            notifyDataSetChanged();
        }

        @Override // com.baidu.tbadk.core.view.t
        public void qq() {
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
            if (CarouselRecommendView.this.LI != null && CarouselRecommendView.this.LG != null && CarouselRecommendView.this.LR.size() > 1) {
                int count = CarouselRecommendView.this.LG.getCount();
                if (i == 0) {
                    CarouselRecommendView.this.LI.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CarouselRecommendView.this.LI.setPosition(f);
                } else {
                    CarouselRecommendView.this.LI.setPosition((i - 1) + f);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CarouselRecommendView.this.LO && i >= 1 && i <= 5) {
                com.baidu.tbadk.core.data.l lVar = (com.baidu.tbadk.core.data.l) CarouselRecommendView.this.LR.get(i - 1);
                String str = "";
                if (lVar instanceof com.baidu.tbadk.core.data.l) {
                    str = com.baidu.tieba.tbadkCore.util.k.is(lVar.getLink());
                    if (CarouselRecommendView.this.LG != null && CarouselRecommendView.this.LG.qt() != null && CarouselRecommendView.this.LG.qt().get(i - 1) != null) {
                        CarouselRecommendView.this.LG.qt().get(i - 1).refresh();
                    }
                }
                String str2 = str;
                if ("4001001".equals(CarouselRecommendView.this.LQ)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_single_" + i, "", 1, "dev_id", str2, "ref_id", CarouselRecommendView.this.LQ);
                } else if ("4000201".equals(CarouselRecommendView.this.LQ)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_h5_" + i, "", 1, "dev_id", str2, "ref_id", CarouselRecommendView.this.LQ);
                } else if ("4000101".equals(CarouselRecommendView.this.LQ)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_index_" + i, "", 1, "dev_id", str2, "ref_id", CarouselRecommendView.this.LQ);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CarouselRecommendView.this.mPager != null && CarouselRecommendView.this.LG != null) {
                if (i == 0) {
                    if (CarouselRecommendView.this.LR.size() > 1) {
                        int currentItem = CarouselRecommendView.this.mPager.getCurrentItem();
                        if (currentItem < 1) {
                            CarouselRecommendView.this.mPager.setCurrentItem(CarouselRecommendView.this.LG.getCount() - 2, false);
                            CarouselRecommendView.this.mPager.invalidate();
                        } else if (currentItem > CarouselRecommendView.this.LG.getCount() - 2) {
                            CarouselRecommendView.this.mPager.setCurrentItem(1, false);
                            CarouselRecommendView.this.mPager.invalidate();
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.LN);
                        } else {
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.LN);
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
