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
    private static int LQ = 5000;
    private CarouselRecommendView<T>.e LJ;
    private IndicatorView LL;
    private float LM;
    private int LN;
    private int LO;
    private int LP;
    private boolean LR;
    private View LS;
    private String LT;
    private List<T> LU;
    private CarouselRecommendView<T>.g LV;
    public View.OnTouchListener LW;
    private TbPageContext<?> mContext;
    private Handler mHandler;
    private int mHeight;
    private ViewPager mPager;
    private int mWidth;

    public CarouselRecommendView(Context context, boolean z) {
        this(context, null, z);
    }

    public View getViewPagerBottomLine() {
        return this.LS;
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPager = null;
        this.LL = null;
        this.LJ = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.LM = 0.3043478f;
        this.LR = true;
        this.LT = "";
        this.LU = new ArrayList();
        this.mHandler = new c(this);
        this.LV = null;
        this.LW = new d(this);
        this.LR = z;
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.carousel_topics_recommend, this, true);
        this.mPager = (ViewPager) findViewById(com.baidu.tieba.w.carousel_pager);
        if (z) {
            this.LS = findViewById(com.baidu.tieba.w.carousel_bottom_line);
            this.LL = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator_for_game_center);
        } else {
            this.LL = (IndicatorView) findViewById(com.baidu.tieba.w.carousel_indicator);
        }
        this.LL.setVisibility(0);
        this.mPager.setOnTouchListener(this.LW);
        if (this.LR) {
            this.mWidth = com.baidu.adp.lib.util.l.M(context);
            this.mHeight = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds330);
        } else {
            this.LO = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingTop);
            this.LN = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_caroucel_paddingBottom);
            this.LP = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.square_page_padding);
            this.mWidth = com.baidu.adp.lib.util.l.M(context) - (this.LP * 2);
            this.mHeight = (int) (0.5f + (this.mWidth * this.LM));
            setPadding(this.LP, this.LO, this.LP, this.LN);
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
        if (this.LJ == null) {
            this.LJ = new e(this.mContext);
        }
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return false;
        }
        this.LU.clear();
        this.LU = list;
        setVisibility(0);
        int size = this.LU.size();
        if (size > 1) {
            this.LU.add(list.get(0));
            this.LU.add(0, list.get(list.size() - 1));
        }
        this.LV = new g(this, null);
        this.LJ.setData(this.LU);
        this.mPager.setAdapter(this.LJ);
        this.mPager.setOnPageChangeListener(this.LV);
        this.mPager.setCurrentItem(size > 1 ? 1 : 0, false);
        this.mPager.invalidate();
        if (size > 1) {
            this.LL.setVisibility(0);
            this.LL.setCount(this.LU.size() - 2);
            this.LL.setPosition(0.0f);
        } else {
            this.LL.setVisibility(8);
        }
        qv();
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.LJ != null) {
            this.LJ.onChangeSkinType(i);
        }
    }

    public void qv() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, LQ);
    }

    public void qw() {
        this.mHandler.removeMessages(0);
    }

    public CarouselRecommendView<T>.e getPagerAdapter() {
        return this.LJ;
    }

    public void setGameRefId(String str) {
        this.LT = str;
    }

    public void onDestroy() {
        if (this.mPager != null) {
            this.mPager.setOnPageChangeListener(null);
        }
        if (this.LJ != null) {
            this.LJ.qz();
        }
    }

    /* loaded from: classes.dex */
    public class e extends PagerAdapter implements t, com.baidu.tbadk.imageManager.d {
        private TbPageContext<?> mContext;
        private View mParent;
        private List<T> LY = null;
        private int count = 0;
        private List<View> LZ = new ArrayList();
        public List<TbImageView> Ma = new ArrayList();

        public e(TbPageContext<?> tbPageContext) {
            this.mContext = null;
            this.mContext = tbPageContext;
        }

        public void qz() {
            for (TbImageView tbImageView : this.Ma) {
                tbImageView.setOnClickListener(null);
            }
            this.Ma.clear();
            this.LZ.clear();
        }

        private void a(TbImageView tbImageView, T t, int i) {
            if (tbImageView != null && t != null && t.mP() != null) {
                if (CarouselRecommendView.this.LR) {
                    tbImageView.a(t.mP().trim(), 10, CarouselRecommendView.this.mWidth, CarouselRecommendView.this.mHeight, false);
                } else {
                    tbImageView.a(t.mP().trim(), 10, CarouselRecommendView.this.mWidth - (CarouselRecommendView.this.LP * 2), (CarouselRecommendView.this.mHeight - CarouselRecommendView.this.LO) - CarouselRecommendView.this.LN, false);
                }
                tbImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setOnClickListener(new f(this, t, tbImageView, i));
                this.Ma.add(tbImageView);
            }
        }

        public void setData(List<T> list) {
            clear();
            if (list != null && list.size() != 0) {
                this.count = list.size();
                this.LY = list;
                int i = 0;
                while (i < this.count) {
                    TbImageView tbImageView = (TbImageView) com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.carousel_topics_recommend_item, null);
                    tbImageView.setSupportNoImage(false);
                    if (!CarouselRecommendView.this.LR) {
                        tbImageView.setDrawerType(1);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setDrawBorder(true);
                    }
                    a(tbImageView, (TbImageView) list.get(i), i > 0 ? i - 1 : 0);
                    this.LZ.add(tbImageView);
                    i++;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.LZ == null) {
                return 0;
            }
            return this.LZ.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.LZ.get(i);
            view.setTag(Integer.valueOf(i));
            view.invalidate();
            if (view.getParent() == null) {
                viewGroup.addView(view);
            }
            return view;
        }

        public void onChangeSkinType(int i) {
            if (this.Ma != null && this.Ma.size() > 0) {
                for (TbImageView tbImageView : this.Ma) {
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
            this.LZ.clear();
            this.count = 0;
            this.LY = null;
            notifyDataSetChanged();
        }

        @Override // com.baidu.tbadk.core.view.t
        public void qx() {
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
            if (CarouselRecommendView.this.LL != null && CarouselRecommendView.this.LJ != null && CarouselRecommendView.this.LU.size() > 1) {
                int count = CarouselRecommendView.this.LJ.getCount();
                if (i == 0) {
                    CarouselRecommendView.this.LL.setPosition((count - 3) + f);
                } else if (i == count - 1) {
                    CarouselRecommendView.this.LL.setPosition(f);
                } else {
                    CarouselRecommendView.this.LL.setPosition((i - 1) + f);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            String str;
            if (CarouselRecommendView.this.LR && i >= 1 && i <= 5) {
                com.baidu.tbadk.core.data.l lVar = (com.baidu.tbadk.core.data.l) CarouselRecommendView.this.LU.get(i - 1);
                if (!(lVar instanceof com.baidu.tbadk.core.data.l)) {
                    str = "";
                } else {
                    str = com.baidu.tieba.tbadkCore.util.k.iu(lVar.getLink());
                }
                if ("4001001".equals(CarouselRecommendView.this.LT)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_single_" + i, "", 1, "dev_id", str, "ref_id", CarouselRecommendView.this.LT);
                } else if ("4000201".equals(CarouselRecommendView.this.LT)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_h5_" + i, "", 1, "dev_id", str, "ref_id", CarouselRecommendView.this.LT);
                } else if ("4000101".equals(CarouselRecommendView.this.LT)) {
                    TiebaStatic.eventStat(CarouselRecommendView.this.mContext.getPageActivity(), "gamecenter_ad_index_" + i, "", 1, "dev_id", str, "ref_id", CarouselRecommendView.this.LT);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (CarouselRecommendView.this.mPager != null && CarouselRecommendView.this.LJ != null) {
                if (i == 0) {
                    if (CarouselRecommendView.this.LU.size() > 1) {
                        int currentItem = CarouselRecommendView.this.mPager.getCurrentItem();
                        if (currentItem < 1) {
                            CarouselRecommendView.this.mPager.setCurrentItem(CarouselRecommendView.this.LJ.getCount() - 2, false);
                            CarouselRecommendView.this.mPager.invalidate();
                        } else if (currentItem > CarouselRecommendView.this.LJ.getCount() - 2) {
                            CarouselRecommendView.this.mPager.setCurrentItem(1, false);
                            CarouselRecommendView.this.mPager.invalidate();
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.LQ);
                        } else {
                            CarouselRecommendView.this.mHandler.removeMessages(0);
                            CarouselRecommendView.this.mHandler.sendEmptyMessageDelayed(0, CarouselRecommendView.LQ);
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
