package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class DrawablePageIndicator extends View implements PageIndicator {
    public static final int INVALID_POINTER = -1;
    public static float VALUE_NOT_SET = -1.0f;
    public int mActivePointerId;
    public int mCurrentPage;
    public Drawable mDrawable;
    public float mIndicatorHeight;
    public float mIndicatorLenPercent;
    public boolean mIsDragging;
    public float mLastMotionX;
    public ViewPager.OnPageChangeListener mListener;
    public BdPagerTabBar mPagerTabBar;
    public float mPositionOffset;
    public int mScrollState;
    public float mShadowLeft;
    public float mShadowRight;
    public GradientDrawable mStandDrawable;
    public int mStandardDrawableHeight;
    public int mStandardDrawableWidth;
    public OnTabClickListener mTabClickListener;
    public SparseIntArray mTabTextWidthArray;
    public int mTouchSlop;
    public Type mType;
    public boolean mUseStandardStyle;
    public ViewPager mViewPager;

    /* loaded from: classes4.dex */
    public interface OnTabClickListener {
        void onClick(int i);
    }

    /* loaded from: classes4.dex */
    public enum Type {
        DRAW_COLOR,
        DRAW_BOTTOM_COLOR,
        DRAW_BOTTOM_COLOR_TEXT_WIDTH
    }

    public DrawablePageIndicator(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.mScrollState = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mScrollState == 0) {
            this.mCurrentPage = i;
            this.mPositionOffset = 0.0f;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
        requestLayout();
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setCurrentItem(int i) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(i);
        this.mCurrentPage = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        if (this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i);
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setIndicatorHeight(float f) {
        if (this.mUseStandardStyle) {
            return;
        }
        this.mIndicatorHeight = f;
    }

    public void setIndicatorType(Type type) {
        this.mType = type;
    }

    public void setIndicatorWidth(float f) {
        if (this.mUseStandardStyle) {
            return;
        }
        this.mIndicatorLenPercent = (f < 0.0f || f > 1.0f) ? 1.0f : 1.0f;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mListener = onPageChangeListener;
    }

    public void setPagerTabBar(BdPagerTabBar bdPagerTabBar) {
        this.mPagerTabBar = bdPagerTabBar;
    }

    public void setTabClickListener(OnTabClickListener onTabClickListener) {
        this.mTabClickListener = onTabClickListener;
    }

    public void setUseStandardStyle(boolean z) {
        this.mUseStandardStyle = z;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        viewPager.getAdapter();
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(this);
        invalidate();
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.ui.viewpager.DrawablePageIndicator.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int currentPage;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPage);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public DrawablePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0407f4);
    }

    private float getMotionEventX(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getX(motionEvent, findPointerIndex);
    }

    public void setIndicatorColor(int i, float f) {
        if (this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i);
        this.mIndicatorHeight = f;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setViewPager(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }

    public DrawablePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        this.mTabTextWidthArray = null;
        this.mUseStandardStyle = true;
        this.mStandardDrawableWidth = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701bf);
        this.mStandardDrawableHeight = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701bd);
        this.mStandDrawable = new GradientDrawable();
        this.mStandDrawable.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0603aa));
        this.mStandDrawable.setCornerRadius(this.mStandardDrawableHeight / 2);
        this.mType = Type.DRAW_BOTTOM_COLOR;
        this.mIndicatorLenPercent = VALUE_NOT_SET;
        this.mIndicatorHeight = this.mStandardDrawableHeight;
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.DrawablePageIndicator, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        this.mShadowLeft = obtainStyledAttributes.getDimension(2, 0.0f);
        this.mShadowRight = obtainStyledAttributes.getDimension(3, 0.0f);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(1);
        this.mDrawable = drawable2;
        if (drawable2 == null) {
            this.mDrawable = this.mStandDrawable;
        }
        obtainStyledAttributes.recycle();
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public float getTextWidth() {
        AdapterLinearLayout adapterLinearLayout;
        View childAt;
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar == null || (adapterLinearLayout = (AdapterLinearLayout) bdPagerTabBar.getChildAt(0)) == null || (childAt = adapterLinearLayout.getChildAt(this.mCurrentPage)) == null || !(childAt instanceof TextView)) {
            return 0.0f;
        }
        TextView textView = (TextView) childAt;
        return textView.getPaint().measureText(textView.getText().toString());
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void notifyDataSetChanged() {
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    public void setTabTextWidthArrayNull() {
        this.mTabTextWidthArray = null;
    }

    public void updateStandardDrawable() {
        this.mStandDrawable.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0603aa));
    }

    public float getTextWidth(int i) {
        AdapterLinearLayout adapterLinearLayout;
        BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
        if (bdPagerTabBar != null && (adapterLinearLayout = (AdapterLinearLayout) bdPagerTabBar.getChildAt(0)) != null) {
            View childAt = adapterLinearLayout.getChildAt(i);
            if (childAt != null && (childAt instanceof TextView)) {
                TextView textView = (TextView) childAt;
                return textView.getPaint().measureText(textView.getText().toString());
            } else if (childAt instanceof BdPagerTabBar.PagerNewTipsTabBarItem) {
                BdPagerTabBar.PagerTabBarItem pagerTabBarItem = ((BdPagerTabBar.PagerNewTipsTabBarItem) childAt).getPagerTabBarItem();
                return pagerTabBarItem.getPaint().measureText(pagerTabBarItem.getText().toString());
            }
        }
        return 0.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        float f;
        super.onDraw(canvas);
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.mCurrentPage >= count) {
            setCurrentItem(count - 1);
            return;
        }
        int paddingLeft = getPaddingLeft();
        float width = ((getWidth() - paddingLeft) - getPaddingRight()) / (count * 1.0f);
        float paddingTop = getPaddingTop();
        float height = getHeight() - getPaddingBottom();
        if (this.mUseStandardStyle) {
            float f2 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
            float min = Math.min(width, this.mStandardDrawableWidth);
            float f3 = f2 + ((width - min) / 2.0f);
            this.mStandDrawable.setBounds((int) (f3 - this.mShadowLeft), (getPaddingTop() + getHeight()) - this.mStandardDrawableHeight, (int) (min + f3 + this.mShadowRight), (int) height);
            this.mStandDrawable.draw(canvas);
            return;
        }
        Type type = this.mType;
        if (type == Type.DRAW_BOTTOM_COLOR) {
            float f4 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
            float f5 = this.mIndicatorLenPercent;
            if (f5 == VALUE_NOT_SET) {
                f = Math.min(width, this.mStandardDrawableWidth);
            } else {
                f = f5 * width;
            }
            float f6 = f4 + ((width - f) / 2.0f);
            this.mDrawable.setBounds((int) (f6 - this.mShadowLeft), (int) ((getPaddingTop() + getHeight()) - this.mIndicatorHeight), (int) (f + f6 + this.mShadowRight), (int) height);
        } else if (type == Type.DRAW_BOTTOM_COLOR_TEXT_WIDTH) {
            int i = this.mCurrentPage;
            if (this.mTabTextWidthArray == null) {
                this.mTabTextWidthArray = new SparseIntArray(count);
            }
            int i2 = this.mTabTextWidthArray.get(i);
            if (i2 <= 0) {
                i2 = (int) getTextWidth(i);
                this.mTabTextWidthArray.put(i, i2);
            }
            int i3 = i + 1;
            int i4 = this.mTabTextWidthArray.get(i3);
            if (i4 <= 0 && i3 < count) {
                i4 = (int) getTextWidth(i3);
                this.mTabTextWidthArray.put(i3, i4);
            }
            float f7 = this.mPositionOffset;
            float f8 = i2 + ((i4 - i2) * f7);
            float f9 = (((this.mCurrentPage + 0.5f) + f7) * width) - (f8 / 2.0f);
            this.mDrawable.setBounds((int) f9, (int) ((getPaddingTop() + getHeight()) - this.mIndicatorHeight), (int) (f9 + f8), (int) height);
        } else if (type == Type.DRAW_COLOR) {
            float f10 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
            float f11 = f10 + width;
            float textWidth = getTextWidth();
            float f12 = 0.0f;
            if (textWidth != 0.0f) {
                f12 = (width - textWidth) / 2.0f;
            }
            this.mDrawable.setBounds((int) ((f10 - this.mShadowLeft) + f12), (int) paddingTop, (int) ((f11 + this.mShadowRight) - f12), (int) height);
        }
        this.mDrawable.draw(canvas);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.mCurrentPage = i;
        this.mPositionOffset = f;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    public void setIndicatorColor(int i, float f, float f2) {
        if (this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i);
        this.mIndicatorLenPercent = (f < 0.0f || f > 1.0f) ? 1.0f : 1.0f;
        this.mIndicatorHeight = f2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
                                }
                                float motionEventX = getMotionEventX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                                this.mLastMotionX = motionEventX;
                                if (motionEventX == -1.0f) {
                                    return false;
                                }
                            }
                        } else {
                            int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                            float motionEventX2 = getMotionEventX(motionEvent, actionIndex2);
                            this.mLastMotionX = motionEventX2;
                            if (motionEventX2 == -1.0f) {
                                return false;
                            }
                            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                        }
                    }
                } else {
                    float motionEventX3 = getMotionEventX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                    if (motionEventX3 == -1.0f) {
                        return false;
                    }
                    float f = motionEventX3 - this.mLastMotionX;
                    if (!this.mIsDragging && Math.abs(f) > this.mTouchSlop) {
                        this.mIsDragging = true;
                    }
                    if (this.mIsDragging) {
                        this.mLastMotionX = motionEventX3;
                        if (this.mViewPager.isFakeDragging()) {
                            this.mViewPager.beginFakeDrag();
                            try {
                                this.mViewPager.fakeDragBy(f);
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            if (!this.mIsDragging && action != 3) {
                int x = (int) (motionEvent.getX() / (getWidth() / this.mViewPager.getAdapter().getCount()));
                if (x != this.mCurrentPage) {
                    this.mViewPager.setCurrentItem(x);
                    OnTabClickListener onTabClickListener = this.mTabClickListener;
                    if (onTabClickListener != null) {
                        onTabClickListener.onClick(x);
                    }
                    return true;
                }
            }
            this.mIsDragging = false;
            this.mActivePointerId = -1;
            if (this.mViewPager.isFakeDragging()) {
                this.mViewPager.endFakeDrag();
            }
        } else {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mLastMotionX = motionEvent.getX();
        }
        return true;
    }
}
