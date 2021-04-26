package com.baidu.ala.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.ala.data.TabData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {
    public float mCurrentPositionOffset;
    public int mCurrentTabIndex;
    public final int mIndicatorHeight;
    public final int mIndicatorWidth;
    public boolean mIsClicked;
    public int mLastScrollX;
    public View.OnClickListener mOnItemClickListener;
    public final InnerScrollTabPageListener mPageListener;
    public ViewPager mPager;
    public Paint mRectPaint;
    public int mScrollOffset;
    public ScrollTabPageListener mScrollTabPageListener;
    public int mSelectorColor;
    public final List<TabData> mTabDataList;
    public final List<View> mTabItemView;
    public LinearLayout mTabsContainer;
    public int mTextSize;
    public OnTabClickListener onTabClickListener;

    /* loaded from: classes.dex */
    public class InnerScrollTabPageListener implements ViewPager.OnPageChangeListener {
        public int mLastPosition;

        public InnerScrollTabPageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() == 0 || ScrollHorizontalTabView.this.mPager == null || i2 != 0) {
                return;
            }
            ScrollHorizontalTabView.this.mCurrentPositionOffset = 0.0f;
            ScrollHorizontalTabView.this.mIsClicked = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (ScrollHorizontalTabView.this.mScrollTabPageListener != null) {
                ScrollHorizontalTabView.this.mScrollTabPageListener.onPageScrolled(i2, f2, i3);
            }
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() == 0 || ScrollHorizontalTabView.this.mIsClicked) {
                return;
            }
            if (ScrollHorizontalTabView.this.mCurrentTabIndex != i2) {
                this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
            }
            ScrollHorizontalTabView.this.mCurrentTabIndex = i2;
            ScrollHorizontalTabView.this.mCurrentPositionOffset = f2;
            ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
            scrollHorizontalTabView.scrollToChild(i2, (int) (f2 * scrollHorizontalTabView.mTabsContainer.getChildAt(i2).getWidth()));
            ScrollHorizontalTabView.this.updateTabStyles();
            ScrollHorizontalTabView.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabData tabData = (TabData) ListUtils.getItem(ScrollHorizontalTabView.this.mTabDataList, i2);
            if (ScrollHorizontalTabView.this.mScrollTabPageListener == null || ScrollHorizontalTabView.this.mScrollTabPageListener.onPrePageSelect(i2, tabData)) {
                if (ScrollHorizontalTabView.this.mScrollTabPageListener != null) {
                    ScrollHorizontalTabView.this.mScrollTabPageListener.onPageSelected(i2, tabData);
                }
                if (ScrollHorizontalTabView.this.mIsClicked) {
                    if (ScrollHorizontalTabView.this.mCurrentTabIndex != i2) {
                        this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
                    }
                    ScrollHorizontalTabView.this.mCurrentTabIndex = i2;
                    ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
                    scrollHorizontalTabView.scrollToChild(i2, (int) (scrollHorizontalTabView.mCurrentPositionOffset * ScrollHorizontalTabView.this.mTabsContainer.getChildAt(i2).getWidth()));
                    ScrollHorizontalTabView.this.updateTabStyles();
                    ScrollHorizontalTabView.this.invalidate();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnTabClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes.dex */
    public interface ScrollTabPageListener {
        void onPageScrolled(int i2, float f2, int i3);

        void onPageSelected(int i2, TabData tabData);

        boolean onPrePageSelect(int i2, TabData tabData);
    }

    /* loaded from: classes.dex */
    public class ViewHolder {
        public TextView icon;
        public TextView title;

        public ViewHolder(View view) {
            this.title = (TextView) view.findViewById(R.id.tv_item);
            this.icon = (TextView) view.findViewById(R.id.tv_icon);
        }
    }

    public ScrollHorizontalTabView(Context context) {
        super(context);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i3)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i2);
                }
                if (ScrollHorizontalTabView.this.onTabClickListener != null) {
                    ScrollHorizontalTabView.this.onTabClickListener.onClick(i2);
                }
            }
        };
        init();
    }

    private void fillTabData() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        for (int i2 = 0; i2 < size && i2 < size2; i2++) {
            TabData tabData = this.mTabDataList.get(i2);
            if (tabData == null) {
                return;
            }
            ViewHolder viewHolder = new ViewHolder(this.mTabItemView.get(i2));
            TextView textView = viewHolder.title;
            if (textView != null) {
                textView.setText(tabData.tabName);
            }
            if (viewHolder.icon != null) {
                Object obj = tabData.extra;
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    viewHolder.icon.setVisibility(0);
                }
            }
            viewHolder.icon.setVisibility(8);
        }
    }

    private void init() {
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mTabsContainer = linearLayout;
        linearLayout.setGravity(16);
        this.mTabsContainer.setOrientation(0);
        this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mTabsContainer.setClipChildren(false);
        addView(this.mTabsContainer);
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, getResources().getDisplayMetrics());
        this.mTextSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbfontsize44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i2, int i3) {
        if (this.mTabItemView.isEmpty()) {
            return;
        }
        int left = this.mTabItemView.get(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.mScrollOffset;
        }
        if (left != this.mLastScrollX) {
            this.mLastScrollX = left;
            scrollTo(left, 0);
        }
    }

    private void setTabStatus(TextView textView, boolean z) {
        if (textView == null) {
            return;
        }
        if (z) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        }
    }

    private void setupTabItems() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        getContext().getResources().getDimensionPixelSize(R.dimen.ds4);
        getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
        if (size > size2) {
            while (size2 < size) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.scroll_horizatal_item, (ViewGroup) null, false);
                inflate.setOnClickListener(this.mOnItemClickListener);
                TextView textView = new ViewHolder(inflate).title;
                if (textView != null) {
                    textView.setTextSize(0, this.mTextSize);
                }
                this.mTabItemView.add(inflate);
                size2++;
            }
        } else if (size < size2) {
            for (int i2 = size2 - 1; i2 >= size; i2--) {
                this.mTabItemView.remove(i2);
            }
        }
        this.mTabsContainer.removeAllViews();
        int size3 = this.mTabItemView.size();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        for (int i3 = 0; i3 < size3; i3++) {
            this.mTabsContainer.addView(this.mTabItemView.get(i3), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        int size = this.mTabItemView.size();
        for (int i2 = 0; i2 < size; i2++) {
            TextView textView = new ViewHolder(this.mTabItemView.get(i2)).title;
            if (textView != null) {
                if (i2 == this.mCurrentTabIndex) {
                    setTabStatus(textView, true);
                } else {
                    setTabStatus(textView, false);
                }
            }
        }
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }

    public void onChangeSkinType(int i2) {
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        updateTabStyles();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabItemView.isEmpty()) {
            return;
        }
        int height = getHeight();
        this.mRectPaint.setColor(this.mSelectorColor);
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTabIndex);
        int width = (childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight();
        int left = this.mTabsContainer.getLeft() + childAt.getLeft() + childAt.getPaddingLeft();
        int i2 = this.mIndicatorWidth;
        float f2 = left + ((width - i2) / 2);
        float f3 = i2 + f2;
        if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
            int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
            int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.mTabsContainer.getLeft();
            int i3 = this.mIndicatorWidth;
            float f4 = left2 + ((width2 - i3) / 2);
            float f5 = this.mCurrentPositionOffset;
            f2 = (f4 * f5) + ((1.0f - f5) * f2);
            f3 = ((i3 + f4) * f5) + ((1.0f - f5) * f3);
        }
        canvas.drawRoundRect(new RectF(f2, height - this.mIndicatorHeight, f3, height), 10.0f, 10.0f, this.mRectPaint);
    }

    public void setCurrentIndex(int i2) {
        setCurrentIndex(i2, true);
    }

    public void setData(List<TabData> list) {
        this.mTabDataList.clear();
        if (!ListUtils.isEmpty(list)) {
            this.mTabDataList.addAll(list);
        }
        setupTabItems();
        fillTabData();
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ScrollHorizontalTabView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
                scrollHorizontalTabView.mCurrentTabIndex = scrollHorizontalTabView.mPager.getCurrentItem();
                ScrollHorizontalTabView scrollHorizontalTabView2 = ScrollHorizontalTabView.this;
                scrollHorizontalTabView2.scrollToChild(scrollHorizontalTabView2.mCurrentTabIndex, 0);
            }
        });
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    public void setScrollTabPageListener(ScrollTabPageListener scrollTabPageListener) {
        this.mScrollTabPageListener = scrollTabPageListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.mPageListener);
    }

    public void setCurrentIndex(int i2, boolean z) {
        if (z) {
            int[] iArr = new int[2];
            ((View) ListUtils.getItem(this.mTabItemView, i2)).getLocationOnScreen(iArr);
            int k = l.k(getContext()) - iArr[0];
            final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
            if (iArr[0] < 0) {
                post(new Runnable() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                    }
                });
            } else if (k < dimensionPixelSize) {
                post(new Runnable() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
                        scrollHorizontalTabView.scrollBy(scrollHorizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                    }
                });
            }
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
        }
        updateTabStyles();
    }

    public void setData(List<TabData> list, int i2) {
        if (i2 > 0) {
            this.mTextSize = getContext().getResources().getDimensionPixelSize(i2);
        }
        setData(list);
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i3)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i2);
                }
                if (ScrollHorizontalTabView.this.onTabClickListener != null) {
                    ScrollHorizontalTabView.this.onTabClickListener.onClick(i2);
                }
            }
        };
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.g(TbadkCoreApplication.getInst(), R.dimen.ds5);
        this.mIndicatorWidth = l.g(TbadkCoreApplication.getInst(), R.dimen.ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.mPageListener = new InnerScrollTabPageListener();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.ala.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i22 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i3)) {
                        i22 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i22);
                }
                if (ScrollHorizontalTabView.this.onTabClickListener != null) {
                    ScrollHorizontalTabView.this.onTabClickListener.onClick(i22);
                }
            }
        };
        init();
    }
}
