package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.horizonalscrolllistview.MyHorizontalScrollView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {
    private final a aFw;
    private b aFx;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private final int mIndicatorHeight;
    private final int mIndicatorWidth;
    private boolean mIsClicked;
    private int mLastScrollX;
    private View.OnClickListener mOnItemClickListener;
    private ViewPager mPager;
    private Paint mRectPaint;
    private int mScrollOffset;
    private int mSelectorColor;
    private final List<bj> mTabDataList;
    private final List<View> mTabItemView;
    private LinearLayout mTabsContainer;
    private int mTextSize;

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(int i, bj bjVar);

        void b(int i, bj bjVar);

        void onPageScrolled(int i, float f, int i2);
    }

    public ScrollHorizontalTabView(Context context) {
        super(context);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds5);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(a.d.sdk_cp_cont_b);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.aFw = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.live.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        i = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i);
                }
            }
        };
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds5);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(a.d.sdk_cp_cont_b);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.aFw = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.live.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        i = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i);
                }
            }
        };
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds5);
        this.mIndicatorWidth = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds64);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(a.d.sdk_cp_cont_b);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.aFw = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.live.view.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i2 = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i2)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i2);
                }
            }
        };
        init();
    }

    private void init() {
        setHorizontalScrollBarEnabled(false);
        this.mTabsContainer = new LinearLayout(getContext());
        this.mTabsContainer.setGravity(16);
        this.mTabsContainer.setOrientation(0);
        this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mTabsContainer.setClipChildren(false);
        addView(this.mTabsContainer);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, getResources().getDisplayMetrics());
        this.mTextSize = getContext().getResources().getDimensionPixelSize(a.e.sdk_tbfontsize44);
    }

    public void setData(List<bj> list) {
        this.mTabDataList.clear();
        if (!ListUtils.isEmpty(list)) {
            this.mTabDataList.addAll(list);
        }
        setupTabItems();
        fillTabData();
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.view.ScrollHorizontalTabView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ScrollHorizontalTabView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ScrollHorizontalTabView.this.mCurrentTabIndex = ScrollHorizontalTabView.this.mPager.getCurrentItem();
                ScrollHorizontalTabView.this.scrollToChild(ScrollHorizontalTabView.this.mCurrentTabIndex, 0);
            }
        });
    }

    public void setData(List<bj> list, int i) {
        if (i > 0) {
            this.mTextSize = getContext().getResources().getDimensionPixelSize(i);
        }
        setData(list);
    }

    private void setupTabItems() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        getContext().getResources().getDimensionPixelSize(a.e.sdk_ds4);
        getContext().getResources().getDimensionPixelSize(a.e.sdk_ds32);
        if (size > size2) {
            while (size2 < size) {
                View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_scroll_horizatal_item, (ViewGroup) null, false);
                inflate.setOnClickListener(this.mOnItemClickListener);
                c cVar = new c(inflate);
                if (cVar.title != null) {
                    cVar.title.setTextSize(0, this.mTextSize);
                }
                this.mTabItemView.add(inflate);
                size2++;
            }
        } else if (size < size2) {
            for (int i = size2 - 1; i >= size; i--) {
                this.mTabItemView.remove(i);
            }
        }
        this.mTabsContainer.removeAllViews();
        int size3 = this.mTabItemView.size();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        for (int i2 = 0; i2 < size3; i2++) {
            this.mTabsContainer.addView(this.mTabItemView.get(i2), layoutParams);
        }
    }

    private void fillTabData() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        for (int i = 0; i < size && i < size2; i++) {
            bj bjVar = this.mTabDataList.get(i);
            if (bjVar != null) {
                c cVar = new c(this.mTabItemView.get(i));
                if (cVar.title != null) {
                    cVar.title.setText(bjVar.tabName);
                }
                if (cVar.icon != null && (bjVar.extra instanceof Boolean) && ((Boolean) bjVar.extra).booleanValue()) {
                    cVar.icon.setVisibility(0);
                } else {
                    cVar.icon.setVisibility(8);
                }
            } else {
                return;
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.aFw);
        }
    }

    public void setScrollTabPageListener(b bVar) {
        this.aFx = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }

    public void setCurrentIndex(int i) {
        setCurrentIndex(i, true);
    }

    public void setCurrentIndex(int i, boolean z) {
        if (z) {
            int[] iArr = new int[2];
            ((View) ListUtils.getItem(this.mTabItemView, i)).getLocationOnScreen(iArr);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext()) - iArr[0];
            final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds160);
            if (iArr[0] < 0) {
                post(new Runnable() { // from class: com.baidu.live.view.ScrollHorizontalTabView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                    }
                });
            } else if (equipmentWidth < dimensionPixelSize) {
                post(new Runnable() { // from class: com.baidu.live.view.ScrollHorizontalTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView.this.scrollBy(ScrollHorizontalTabView.this.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds160), 0);
                    }
                });
            }
        }
        if (this.mPager != null) {
            this.mPager.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void setTabStatus(TextView textView, boolean z) {
        if (textView != null) {
            if (z) {
                SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_b);
            } else {
                SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_j);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && !this.mTabItemView.isEmpty()) {
            int height = getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            View childAt = this.mTabsContainer.getChildAt(this.mCurrentTabIndex);
            float paddingLeft = childAt.getPaddingLeft() + this.mTabsContainer.getLeft() + childAt.getLeft() + ((((childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight()) - this.mIndicatorWidth) / 2);
            float f = this.mIndicatorWidth + paddingLeft;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
                View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
                float paddingLeft2 = childAt2.getPaddingLeft() + childAt2.getLeft() + this.mTabsContainer.getLeft() + ((((childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
            }
            canvas.drawRoundRect(new RectF(paddingLeft, height - this.mIndicatorHeight, f, height), 10.0f, 10.0f, this.mRectPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        int size = this.mTabItemView.size();
        for (int i = 0; i < size; i++) {
            c cVar = new c(this.mTabItemView.get(i));
            if (cVar.title != null) {
                if (i == this.mCurrentTabIndex) {
                    setTabStatus(cVar.title, true);
                } else {
                    setTabStatus(cVar.title, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (!this.mTabItemView.isEmpty()) {
            int left = this.mTabItemView.get(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.mScrollOffset;
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mLastPosition;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (ScrollHorizontalTabView.this.aFx != null) {
                ScrollHorizontalTabView.this.aFx.onPageScrolled(i, f, i2);
            }
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() != 0 && !ScrollHorizontalTabView.this.mIsClicked) {
                if (ScrollHorizontalTabView.this.mCurrentTabIndex != i) {
                    this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
                }
                ScrollHorizontalTabView.this.mCurrentTabIndex = i;
                ScrollHorizontalTabView.this.mCurrentPositionOffset = f;
                ScrollHorizontalTabView.this.scrollToChild(i, (int) (ScrollHorizontalTabView.this.mTabsContainer.getChildAt(i).getWidth() * f));
                ScrollHorizontalTabView.this.updateTabStyles();
                ScrollHorizontalTabView.this.invalidate();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() != 0 && ScrollHorizontalTabView.this.mPager != null && i == 0) {
                ScrollHorizontalTabView.this.mCurrentPositionOffset = 0.0f;
                ScrollHorizontalTabView.this.mIsClicked = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            bj bjVar = (bj) ListUtils.getItem(ScrollHorizontalTabView.this.mTabDataList, i);
            if (ScrollHorizontalTabView.this.aFx == null || ScrollHorizontalTabView.this.aFx.a(i, bjVar)) {
                if (ScrollHorizontalTabView.this.aFx != null) {
                    ScrollHorizontalTabView.this.aFx.b(i, bjVar);
                }
                if (ScrollHorizontalTabView.this.mIsClicked) {
                    if (ScrollHorizontalTabView.this.mCurrentTabIndex != i) {
                        this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
                    }
                    ScrollHorizontalTabView.this.mCurrentTabIndex = i;
                    ScrollHorizontalTabView.this.scrollToChild(i, (int) (ScrollHorizontalTabView.this.mCurrentPositionOffset * ScrollHorizontalTabView.this.mTabsContainer.getChildAt(i).getWidth()));
                    ScrollHorizontalTabView.this.updateTabStyles();
                    ScrollHorizontalTabView.this.invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView icon;
        TextView title;

        public c(View view) {
            this.title = (TextView) view.findViewById(a.g.tv_item);
            this.icon = (TextView) view.findViewById(a.g.tv_icon);
        }
    }
}
