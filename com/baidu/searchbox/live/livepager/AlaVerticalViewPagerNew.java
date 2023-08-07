package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class AlaVerticalViewPagerNew extends ViewGroup {
    public static final int CLOSE_ENOUGH = 2;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_GUTTER_SIZE = 16;
    public static final int DEFAULT_OFFSCREEN_PAGES = 1;
    public static final float DETERMINE_Y_RATIO = 0.5f;
    public static final int DRAW_ORDER_DEFAULT = 0;
    public static final int DRAW_ORDER_FORWARD = 1;
    public static final int DRAW_ORDER_REVERSE = 2;
    public static final int INVALID_POINTER = -1;
    public static final int MAX_SETTLE_DURATION = 2000;
    public static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "ViewPager";
    public static final boolean USE_CACHE = false;
    public boolean disallowIntercept;
    public boolean isPointerCountValid;
    public int mActivePointerId;
    public PagerAdapter mAdapter;
    public OnAdapterChangeListener mAdapterChangeListener;
    public EdgeEffectCompat mBottomEdge;
    public Callback mCallback;
    public boolean mCalledSuper;
    public int mChildHeightMeasureSpec;
    public int mChildWidthMeasureSpec;
    public int mCloseEnough;
    public int mCurItem;
    public int mDecorChildCount;
    public int mDefaultGutterSize;
    public float mDetermineYRatio;
    public int mDrawingOrder;
    public ArrayList<View> mDrawingOrderedChildren;
    public final Runnable mEndScrollRunnable;
    public int mExpectedAdapterCount;
    public long mFakeDragBeginTime;
    public boolean mFakeDragging;
    public boolean mFirstLayout;
    public float mFirstOffset;
    public int mFlingDistance;
    public int mGutterSize;
    public boolean mIgnoreGutter;
    public boolean mInLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public ViewPager.OnPageChangeListener mInternalPageChangeListener;
    public boolean mIsBeingDragged;
    public boolean mIsScrollable;
    public boolean mIsUnableToDrag;
    public final ArrayList<ItemInfo> mItems;
    public float mLastMotionX;
    public float mLastMotionY;
    public float mLastOffset;
    public int mLeftPageBounds;
    public Drawable mMarginDrawable;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public boolean mNeedCalculatePageOffsets;
    public PagerObserver mObserver;
    public int mOffscreenPageLimit;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public int mPageMargin;
    public ViewPager.PageTransformer mPageTransformer;
    public boolean mPopulatePending;
    public Parcelable mRestoredAdapterState;
    public ClassLoader mRestoredClassLoader;
    public int mRestoredCurItem;
    public int mRightPageBounds;
    public int mScrollState;
    public Scroller mScroller;
    public boolean mScrollingCacheEnabled;
    public Method mSetChildrenDrawingOrderEnabled;
    public final ItemInfo mTempItem;
    public final Rect mTempRect;
    public EdgeEffectCompat mTopEdge;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public static final int[] LAYOUT_ATTRS = {16842931};
    public static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    public static final Interpolator INTERPOLATOR = new Interpolator() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final ViewPositionComparator POSITION_COMPARATOR = new ViewPositionComparator();

    /* loaded from: classes4.dex */
    public interface Callback {
        void onScrollNearlyComplete();
    }

    /* loaded from: classes4.dex */
    public interface Decor {
    }

    /* loaded from: classes4.dex */
    public static class ItemInfo {
        public float heightFactor;
        public Object object;
        public float offset;
        public int position;
        public boolean scrolling;
    }

    /* loaded from: classes4.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int childIndex;
        public int gravity;
        public float heightFactor;
        public boolean isDecor;
        public boolean needsMeasure;
        public int position;

        public LayoutParams() {
            super(-1, -1);
            this.heightFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.heightFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AlaVerticalViewPagerNew.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes4.dex */
    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        public MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            if (AlaVerticalViewPagerNew.this.mAdapter != null && AlaVerticalViewPagerNew.this.mAdapter.getCount() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && AlaVerticalViewPagerNew.this.mAdapter != null) {
                obtain.setItemCount(AlaVerticalViewPagerNew.this.mAdapter.getCount());
                obtain.setFromIndex(AlaVerticalViewPagerNew.this.mCurItem);
                obtain.setToIndex(AlaVerticalViewPagerNew.this.mCurItem);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (AlaVerticalViewPagerNew.this.internalCanScrollVertically(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (AlaVerticalViewPagerNew.this.internalCanScrollVertically(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view2, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !AlaVerticalViewPagerNew.this.internalCanScrollVertically(-1)) {
                    return false;
                }
                AlaVerticalViewPagerNew alaVerticalViewPagerNew = AlaVerticalViewPagerNew.this;
                alaVerticalViewPagerNew.setCurrentItem(alaVerticalViewPagerNew.mCurItem - 1);
                return true;
            } else if (!AlaVerticalViewPagerNew.this.internalCanScrollVertically(1)) {
                return false;
            } else {
                AlaVerticalViewPagerNew alaVerticalViewPagerNew2 = AlaVerticalViewPagerNew.this;
                alaVerticalViewPagerNew2.setCurrentItem(alaVerticalViewPagerNew2.mCurItem + 1);
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class PagerObserver extends DataSetObserver {
        public PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AlaVerticalViewPagerNew.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AlaVerticalViewPagerNew.this.dataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void resetTouch() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, POSITION_COMPARATOR);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    public boolean pageDown() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, false);
        return true;
    }

    public boolean pageUp() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, false);
        return true;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    /* loaded from: classes4.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view2, View view3) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z != layoutParams2.isDecor) {
                if (z) {
                    return 1;
                }
                return -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }

    public AlaVerticalViewPagerNew(Context context) {
        super(context);
        this.mIsScrollable = true;
        this.isPointerCountValid = false;
        this.disallowIntercept = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.3
            @Override // java.lang.Runnable
            public void run() {
                AlaVerticalViewPagerNew.this.setScrollState(0);
                AlaVerticalViewPagerNew.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void completeScroll(boolean z) {
        boolean z2;
        if (this.mScrollState == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    public boolean pageScrolled(int i) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientHeight = getClientHeight();
        int i2 = this.mPageMargin;
        int i3 = clientHeight + i2;
        float f = clientHeight;
        int i4 = infoForCurrentScrollPosition.position;
        float f2 = ((i / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.heightFactor + (i2 / f));
        this.mCalledSuper = false;
        onPageScrolled(i4, f2, (int) (i3 * f2));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public AlaVerticalViewPagerNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsScrollable = true;
        this.isPointerCountValid = false;
        this.disallowIntercept = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew.3
            @Override // java.lang.Runnable
            public void run() {
                AlaVerticalViewPagerNew.this.setScrollState(0);
                AlaVerticalViewPagerNew.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view2) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view2 == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view2.getLeft();
        rect.right = view2.getRight();
        rect.top = view2.getTop();
        rect.bottom = view2.getBottom();
        ViewParent parent = view2.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean isGutterDrag(float f, float f2) {
        if ((f < this.mGutterSize && f2 > 0.0f) || (f > getHeight() - this.mGutterSize && f2 < 0.0f)) {
            return true;
        }
        return false;
    }

    public ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        itemInfo.heightFactor = this.mAdapter.getPageWidth(i);
        if (i2 >= 0 && i2 < this.mItems.size()) {
            this.mItems.add(i2, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (Build.VERSION.SDK_INT >= 11) {
            int i = 1;
            if (pageTransformer != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.mPageTransformer != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mPageTransformer = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = 0;
            }
            if (z4) {
                populate();
            }
        }
    }

    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    private void enableLayers(boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            ViewCompat.setLayerType(getChildAt(i2), i, null);
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mLastMotionY = MotionEventCompat.getY(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        boolean z;
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        if (this.mPageTransformer != null) {
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            enableLayers(z);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if ((action == 1 || action == 3) && this.disallowIntercept) {
                resetTouch();
            }
        } else {
            this.disallowIntercept = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ItemInfo infoForAnyChild(View view2) {
        while (true) {
            ViewParent parent = view2.getParent();
            if (parent != this) {
                if (!(parent instanceof View)) {
                    return null;
                }
                view2 = (View) parent;
            } else {
                return infoForChild(view2);
            }
        }
    }

    public ItemInfo infoForChild(View view2) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view2, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    public ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    public boolean internalCanScrollVertically(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            if (scrollY <= ((int) (clientHeight * this.mFirstOffset))) {
                return false;
            }
            return true;
        } else if (i <= 0 || scrollY >= ((int) (clientHeight * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        if (this.mInLayout) {
            removeViewInLayout(view2);
        } else {
            super.removeView(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.disallowIntercept = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setDetermineYRatio(float f) {
        this.mDetermineYRatio = f;
    }

    public ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setIsScrollable(boolean z) {
        this.mIsScrollable = z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int height = getHeight();
        recomputeScrollPosition(height, height, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mMarginDrawable) {
            return false;
        }
        return true;
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientHeight = getClientHeight();
        if (clientHeight > 0) {
            f = this.mPageMargin / clientHeight;
        } else {
            f = 0.0f;
        }
        if (itemInfo2 != null) {
            int i4 = itemInfo2.position;
            int i5 = itemInfo.position;
            if (i4 < i5) {
                float f4 = itemInfo2.offset + itemInfo2.heightFactor + f;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= itemInfo.position && i7 < this.mItems.size()) {
                    ItemInfo itemInfo5 = this.mItems.get(i7);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i6 <= itemInfo4.position || i7 >= this.mItems.size() - 1) {
                            break;
                        }
                        i7++;
                        itemInfo5 = this.mItems.get(i7);
                    }
                    while (i6 < itemInfo4.position) {
                        f4 += this.mAdapter.getPageWidth(i6) + f;
                        i6++;
                    }
                    itemInfo4.offset = f4;
                    f4 += itemInfo4.heightFactor + f;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.mItems.size() - 1;
                float f5 = itemInfo2.offset;
                while (true) {
                    i4--;
                    if (i4 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i4 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i4 > itemInfo3.position) {
                        f5 -= this.mAdapter.getPageWidth(i4) + f;
                        i4--;
                    }
                    f5 -= itemInfo3.heightFactor + f;
                    itemInfo3.offset = f5;
                }
            }
        }
        int size2 = this.mItems.size();
        float f6 = itemInfo.offset;
        int i8 = itemInfo.position;
        int i9 = i8 - 1;
        if (i8 == 0) {
            f2 = f6;
        } else {
            f2 = -3.4028235E38f;
        }
        this.mFirstOffset = f2;
        int i10 = count - 1;
        if (itemInfo.position == i10) {
            f3 = (itemInfo.offset + itemInfo.heightFactor) - 1.0f;
        } else {
            f3 = Float.MAX_VALUE;
        }
        this.mLastOffset = f3;
        int i11 = i - 1;
        while (i11 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i11);
            while (true) {
                i3 = itemInfo7.position;
                if (i9 <= i3) {
                    break;
                }
                f6 -= this.mAdapter.getPageWidth(i9) + f;
                i9--;
            }
            f6 -= itemInfo7.heightFactor + f;
            itemInfo7.offset = f6;
            if (i3 == 0) {
                this.mFirstOffset = f6;
            }
            i11--;
            i9--;
        }
        float f7 = itemInfo.offset + itemInfo.heightFactor + f;
        int i12 = itemInfo.position + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i13);
            while (true) {
                i2 = itemInfo8.position;
                if (i12 >= i2) {
                    break;
                }
                f7 += this.mAdapter.getPageWidth(i12) + f;
                i12++;
            }
            if (i2 == i10) {
                this.mLastOffset = (itemInfo8.heightFactor + f7) - 1.0f;
            }
            itemInfo8.offset = f7;
            f7 += itemInfo8.heightFactor + f;
            i13++;
            i12++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r5 > 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int determineTargetPage(int i, float f, int i2, int i3) {
        float f2;
        ArrayList<ItemInfo> arrayList;
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            if (Math.abs(i3) > getClientHeight() * 0.17f) {
                if (i3 > 0) {
                    i--;
                }
                i++;
            } else {
                if (i >= this.mCurItem) {
                    f2 = 0.4f;
                } else {
                    f2 = 0.6f;
                }
                i = (int) (i + f + f2);
            }
        }
        if (this.mItems.size() > 0) {
            return Math.max(this.mItems.get(0).position, Math.min(i, this.mItems.get(arrayList.size() - 1).position));
        }
        return i;
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean z3 = false;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z2 && this.mCurItem == i && this.mItems.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            int i4 = this.mCurItem;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).scrolling = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
                if (z3 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f;
        float f2;
        int i;
        int clientHeight = getClientHeight();
        float f3 = 0.0f;
        if (clientHeight > 0) {
            f = getScrollY() / clientHeight;
        } else {
            f = 0.0f;
        }
        if (clientHeight > 0) {
            f2 = this.mPageMargin / clientHeight;
        } else {
            f2 = 0.0f;
        }
        ItemInfo itemInfo = null;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i3);
            if (!z && itemInfo2.position != (i = i2 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f3 + f4 + f2;
                itemInfo2.position = i;
                itemInfo2.heightFactor = this.mAdapter.getPageWidth(i);
                i3--;
            }
            f3 = itemInfo2.offset;
            float f5 = itemInfo2.heightFactor + f3 + f2;
            if (!z && f < f3) {
                return itemInfo;
            }
            if (f >= f5 && i3 != this.mItems.size() - 1) {
                i2 = itemInfo2.position;
                f4 = itemInfo2.heightFactor;
                i3++;
                itemInfo = itemInfo2;
                z = false;
            } else {
                return itemInfo2;
            }
        }
        return itemInfo;
    }

    private void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, INTERPOLATOR);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTopEdge = new EdgeEffectCompat(context);
        this.mBottomEdge = new EdgeEffectCompat(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mDetermineYRatio = 0.5f;
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2 = this.mLastMotionY - f;
        this.mLastMotionY = f;
        float scrollY = getScrollY() + f2;
        float clientHeight = getClientHeight();
        float f3 = this.mFirstOffset * clientHeight;
        float f4 = this.mLastOffset * clientHeight;
        boolean z2 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        boolean z3 = true;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * clientHeight;
            z3 = false;
        }
        if (scrollY < f3) {
            if (z) {
                z2 = this.mTopEdge.onPull(Math.abs(f3 - scrollY) / clientHeight);
            }
            scrollY = f3;
        } else if (scrollY > f4) {
            if (z3) {
                z2 = this.mBottomEdge.onPull(Math.abs(scrollY - f4) / clientHeight);
            }
            scrollY = f4;
        }
        int i = (int) scrollY;
        this.mLastMotionX += scrollY - i;
        scrollTo(getScrollX(), i);
        pageScrolled(i);
        return z2;
    }

    public void fakeDragBy(float f) {
        ArrayList<ItemInfo> arrayList;
        if (this.mFakeDragging) {
            this.mLastMotionY += f;
            float scrollY = getScrollY() - f;
            float clientHeight = getClientHeight();
            float f2 = this.mFirstOffset * clientHeight;
            float f3 = this.mLastOffset * clientHeight;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f2 = itemInfo.offset * clientHeight;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f3 = itemInfo2.offset * clientHeight;
            }
            if (scrollY < f2) {
                scrollY = f2;
            } else if (scrollY > f3) {
                scrollY = f3;
            }
            int i = (int) scrollY;
            this.mLastMotionY += scrollY - i;
            scrollTo(getScrollX(), i);
            pageScrolled(i);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, 0.0f, this.mLastMotionY, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
        if (onAdapterChangeListener != null && pagerAdapter3 != pagerAdapter) {
            onAdapterChangeListener.onAdapterChanged(pagerAdapter3, pagerAdapter);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        float f;
        if (i2 > 0 && !this.mItems.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)) * (((i - getPaddingTop()) - getPaddingBottom()) + i3));
            scrollTo(getScrollX(), scrollY);
            if (!this.mScroller.isFinished()) {
                this.mScroller.startScroll(0, scrollY, 0, (int) (infoForPosition(this.mCurItem).offset * i), this.mScroller.getDuration() - this.mScroller.timePassed());
                Log.e(MixTagConstants.MIX_PAGER, "recomputeScrollPosition " + i + " " + i2 + " " + i3 + " " + i4);
                return;
            }
            return;
        }
        ItemInfo infoForPosition = infoForPosition(this.mCurItem);
        if (infoForPosition != null) {
            f = Math.min(infoForPosition.offset, this.mLastOffset);
        } else {
            f = 0.0f;
        }
        int paddingTop = (int) (f * ((i - getPaddingTop()) - getPaddingBottom()));
        if (paddingTop != getScrollY()) {
            completeScroll(false);
            scrollTo(getScrollX(), paddingTop);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int i3;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        ItemInfo infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            i3 = (int) (getClientHeight() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        } else {
            i3 = 0;
        }
        if (z) {
            smoothScrollTo(0, i3, i2);
            if (z2 && (onPageChangeListener4 = this.mOnPageChangeListener) != null) {
                onPageChangeListener4.onPageSelected(i);
            }
            if (z2 && (onPageChangeListener3 = this.mInternalPageChangeListener) != null) {
                onPageChangeListener3.onPageSelected(i);
                return;
            }
            return;
        }
        if (z2 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
            onPageChangeListener2.onPageSelected(i);
        }
        if (z2 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(i);
        }
        completeScroll(false);
        scrollTo(0, i3);
        pageScrolled(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.isDecor | (view2 instanceof Decor);
        layoutParams2.isDecor = z;
        if (this.mInLayout) {
            if (!z) {
                layoutParams2.needsMeasure = true;
                addViewInLayout(view2, i, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view2, i, layoutParams);
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i) {
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        View findFocus = findFocus();
        boolean z2 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (parent instanceof ViewGroup) {
                        if (parent == this) {
                            z = true;
                            break;
                        }
                        parent = parent.getParent();
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i == 33) {
                    int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).top;
                    int i3 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).top;
                    if (findFocus != null && i2 >= i3) {
                        requestFocus = pageUp();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i == 130) {
                    int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).bottom;
                    int i5 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).bottom;
                    if (findFocus != null && i4 <= i5) {
                        requestFocus = pageDown();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z2 = requestFocus;
            } else if (i == 33 && i != 1) {
                if (i == 130 || i == 2) {
                    z2 = pageDown();
                }
            } else {
                z2 = pageUp();
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null) {
        }
        if (i == 33) {
        }
        z2 = pageUp();
        if (z2) {
        }
        return z2;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionY = 0.0f;
        this.mInitialMotionY = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public boolean canScroll(View view2, boolean z, int i, int i2, int i3) {
        int i4;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollY;
                if (i5 >= childAt.getTop() && i5 < childAt.getBottom() && (i4 = i2 + scrollX) >= childAt.getLeft() && i4 < childAt.getRight() && canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z && ViewCompat.canScrollVertically(view2, -i)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (this.mCallback != null && this.mScroller.getFinalY() - currY == 0) {
                this.mCallback.onScrollNearlyComplete();
            }
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!pageScrolled(currY)) {
                    this.mScroller.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        completeScroll(true);
    }

    public void endFakeDrag() {
        float yVelocity;
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            if (this.isPointerCountValid) {
                yVelocity = VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
            } else {
                yVelocity = VelocityTracker.obtain().getYVelocity();
            }
            int i = (int) yVelocity;
            this.mPopulatePending = true;
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, i, (int) (this.mLastMotionY - this.mInitialMotionY)), true, true, i);
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void dataSetChanged() {
        boolean z;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count) {
            z = true;
        } else {
            z = false;
        }
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i3 = this.mCurItem;
                    if (i3 == itemInfo.position) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = itemInfo.position;
                    if (i4 != itemPosition) {
                        if (i4 == this.mCurItem) {
                            i = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.heightFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    return arrowScroll(66);
                }
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                if (this.mSetChildrenDrawingOrderEnabled != null) {
                    this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() <= 1)) {
            this.mTopEdge.finish();
            this.mBottomEdge.finish();
        } else {
            if (!this.mTopEdge.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.mFirstOffset * height);
                this.mTopEdge.setSize(width, height);
                z = false | this.mTopEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mBottomEdge.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.mLastOffset + 1.0f)) * height2);
                this.mBottomEdge.setSize(width2, height2);
                z |= this.mBottomEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollY = getScrollY();
            float height2 = getHeight();
            float f3 = this.mPageMargin / height2;
            int i = 0;
            ItemInfo itemInfo = this.mItems.get(0);
            float f4 = itemInfo.offset;
            int size = this.mItems.size();
            int i2 = itemInfo.position;
            int i3 = this.mItems.get(size - 1).position;
            while (i2 < i3) {
                while (i2 > itemInfo.position && i < size) {
                    i++;
                    itemInfo = this.mItems.get(i);
                }
                if (i2 == itemInfo.position) {
                    float f5 = itemInfo.offset;
                    float f6 = itemInfo.heightFactor;
                    f = (f5 + f6) * height2;
                    f4 = f5 + f6 + f3;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i2);
                    f = (f4 + pageWidth) * height2;
                    f4 += pageWidth + f3;
                }
                int i4 = this.mPageMargin;
                if (i4 + f > scrollY) {
                    f2 = f3;
                    this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int) f, this.mRightPageBounds, (int) (i4 + f + 0.5f));
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f2 = f3;
                }
                if (f <= scrollY + height) {
                    i2++;
                    f3 = f2;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        boolean z;
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y;
        float x;
        float f;
        if (!this.mIsScrollable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                } else {
                    try {
                        int i = this.mActivePointerId;
                        if (i != -1) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                            if (this.isPointerCountValid) {
                                y = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            } else {
                                y = motionEvent.getY();
                            }
                            float f2 = y;
                            float f3 = f2 - this.mLastMotionY;
                            float abs = Math.abs(f3);
                            if (this.isPointerCountValid) {
                                x = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            } else {
                                x = motionEvent.getX();
                            }
                            float abs2 = Math.abs(x - this.mInitialMotionX);
                            int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            if (i2 != 0 && !isGutterDrag(this.mLastMotionY, f3) && canScroll(this, false, (int) f3, (int) x, (int) f2)) {
                                this.mLastMotionX = x;
                                this.mLastMotionY = f2;
                                this.mIsUnableToDrag = true;
                                return false;
                            }
                            if (abs > this.mTouchSlop && abs * this.mDetermineYRatio > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                if (i2 > 0) {
                                    f = this.mInitialMotionY + this.mTouchSlop;
                                } else {
                                    f = this.mInitialMotionY - this.mTouchSlop;
                                }
                                this.mLastMotionY = f;
                                this.mLastMotionX = x;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > this.mTouchSlop) {
                                this.mIsUnableToDrag = true;
                            }
                            if (this.mIsBeingDragged && performDrag(f2)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                float x2 = motionEvent.getX();
                this.mInitialMotionX = x2;
                this.mLastMotionX = x2;
                float y2 = motionEvent.getY();
                this.mInitialMotionY = y2;
                this.mLastMotionY = y2;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        resetTouch();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ItemInfo infoForChild;
        int max;
        int i5;
        int max2;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i11 = layoutParams.gravity;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    if (i12 != 1) {
                        if (i12 != 3) {
                            if (i12 != 5) {
                                i5 = paddingLeft;
                            } else {
                                max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i13 == 16) {
                            if (i13 != 48) {
                                if (i13 != 80) {
                                    i6 = paddingTop;
                                } else {
                                    max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i14 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i14, childAt.getMeasuredWidth() + paddingLeft, i14 + childAt.getMeasuredHeight());
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        } else {
                            max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i15 = max2;
                        i6 = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i142, childAt.getMeasuredWidth() + paddingLeft, i142 + childAt.getMeasuredHeight());
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    } else {
                        max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i16 = max;
                    i5 = paddingLeft;
                    paddingLeft = i16;
                    if (i13 == 16) {
                    }
                    int i152 = max2;
                    i6 = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i1422, childAt.getMeasuredWidth() + paddingLeft, i1422 + childAt.getMeasuredHeight());
                    i9++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i17 = (i8 - paddingTop) - paddingBottom;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    float f = i17;
                    int i19 = ((int) (infoForChild.offset * f)) + paddingTop;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i7 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.heightFactor), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i19, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i19);
                }
            }
        }
        this.mLeftPageBounds = paddingLeft;
        this.mRightPageBounds = i7 - paddingRight;
        this.mDecorChildCount = i9;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        int measuredHeight = getMeasuredHeight();
        this.mGutterSize = Math.min(measuredHeight / 10, this.mDefaultGutterSize);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i8 = layoutParams2.gravity;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                if (i10 != 48 && i10 != 80) {
                    z = false;
                } else {
                    z = true;
                }
                if (i9 != 3 && i9 != 5) {
                    z2 = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z) {
                    i11 = 1073741824;
                } else if (z2) {
                    i3 = 1073741824;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 == -2) {
                        if (i4 == -1) {
                            i4 = measuredWidth;
                        }
                        i11 = 1073741824;
                    } else {
                        i4 = measuredWidth;
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 == -2) {
                        if (i5 == -1) {
                            i5 = paddingTop;
                        }
                    } else {
                        i5 = paddingTop;
                        i7 = i3;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (!z) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i3 = Integer.MIN_VALUE;
                i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i4 == -2) {
                }
                i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i5 == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (!z) {
                }
            }
            i6++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.isDecor) {
                childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.heightFactor), 1073741824));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i, float f, int i2) {
        int max;
        int i3;
        int top;
        if (this.mDecorChildCount > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i5 = layoutParams.gravity & 112;
                    if (i5 != 16) {
                        if (i5 != 48) {
                            if (i5 != 80) {
                                i3 = paddingTop;
                            } else {
                                max = (height - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                        } else {
                            i3 = childAt.getHeight() + paddingTop;
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i3;
                    } else {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i6 = max;
                    i3 = paddingTop;
                    paddingTop = i6;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i3;
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
        if (this.mPageTransformer != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i5, i5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
        if (r8.mBottomEdge.onRelease() == false) goto L35;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float yVelocity;
        float y;
        float y2;
        float y3;
        float x;
        float f;
        if (!this.mIsScrollable) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        try {
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    onSecondaryPointerUp(motionEvent);
                                }
                            } else {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                MotionEventCompat.getY(motionEvent, actionIndex);
                                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            }
                        } else if (this.mIsBeingDragged) {
                            scrollToItem(this.mCurItem, true, 0, false);
                            this.mActivePointerId = -1;
                            endDrag();
                            if (!this.mTopEdge.onRelease()) {
                            }
                            z = true;
                        }
                    } else {
                        if (!this.mIsBeingDragged) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                            if (this.isPointerCountValid) {
                                y3 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            } else {
                                y3 = motionEvent.getY();
                            }
                            float abs = Math.abs(y3 - this.mLastMotionY);
                            if (this.isPointerCountValid) {
                                x = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            } else {
                                x = motionEvent.getX();
                            }
                            float abs2 = Math.abs(x - this.mLastMotionX);
                            if (abs > this.mTouchSlop && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                if (y3 - this.mInitialMotionY > 0.0f) {
                                    f = this.mInitialMotionY + this.mTouchSlop;
                                } else {
                                    f = this.mInitialMotionY - this.mTouchSlop;
                                }
                                this.mLastMotionY = f;
                                this.mLastMotionX = x;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                            if (this.isPointerCountValid) {
                                y2 = MotionEventCompat.getY(motionEvent, findPointerIndex2);
                            } else {
                                y2 = motionEvent.getY();
                            }
                            z = false | performDrag(y2);
                        }
                    }
                } else if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    if (this.isPointerCountValid) {
                        yVelocity = VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
                    } else {
                        yVelocity = VelocityTracker.obtain().getYVelocity();
                    }
                    int i = (int) yVelocity;
                    this.mPopulatePending = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    int i2 = infoForCurrentScrollPosition.position;
                    float f2 = ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor;
                    int findPointerIndex3 = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.isPointerCountValid) {
                        y = MotionEventCompat.getY(motionEvent, findPointerIndex3);
                    } else {
                        y = motionEvent.getY();
                    }
                    setCurrentItemInternal(determineTargetPage(i2, f2, i, (int) (y - this.mInitialMotionY)), true, true, i);
                    this.mActivePointerId = -1;
                    endDrag();
                    if (!this.mTopEdge.onRelease()) {
                        if (this.mBottomEdge.onRelease()) {
                        }
                    }
                    z = true;
                }
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                float x2 = motionEvent.getX();
                this.mInitialMotionX = x2;
                this.mLastMotionX = x2;
                float y4 = motionEvent.getY();
                this.mInitialMotionY = y4;
                this.mLastMotionY = y4;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r10 == r11) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void populate(int i) {
        int i2;
        ItemInfo itemInfo;
        String hexString;
        ItemInfo itemInfo2;
        Object obj;
        ItemInfo itemInfo3;
        ItemInfo infoForChild;
        ItemInfo itemInfo4;
        float paddingLeft;
        ItemInfo itemInfo5;
        float paddingRight;
        ItemInfo itemInfo6;
        int i3 = this.mCurItem;
        if (i3 != i) {
            if (i3 < i) {
                i2 = 130;
            } else {
                i2 = 33;
            }
            itemInfo = infoForPosition(this.mCurItem);
            this.mCurItem = i;
        } else {
            i2 = 2;
            itemInfo = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i4 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i4);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, this.mCurItem + i4);
            if (count == this.mExpectedAdapterCount) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.mItems.size()) {
                        break;
                    }
                    itemInfo2 = this.mItems.get(i5);
                    int i6 = itemInfo2.position;
                    int i7 = this.mCurItem;
                    if (i6 < i7) {
                        i5++;
                    }
                }
                itemInfo2 = null;
                if (itemInfo2 == null && count > 0) {
                    itemInfo2 = addNewItem(this.mCurItem, i5);
                }
                if (itemInfo2 != null) {
                    int i8 = i5 - 1;
                    if (i8 >= 0) {
                        itemInfo4 = this.mItems.get(i8);
                    } else {
                        itemInfo4 = null;
                    }
                    int clientHeight = getClientHeight();
                    if (clientHeight <= 0) {
                        paddingLeft = 0.0f;
                    } else {
                        paddingLeft = (2.0f - itemInfo2.heightFactor) + (getPaddingLeft() / clientHeight);
                    }
                    float f = 0.0f;
                    for (int i9 = this.mCurItem - 1; i9 >= 0; i9--) {
                        if (f >= paddingLeft && i9 < max) {
                            if (itemInfo4 == null) {
                                break;
                            }
                            if (i9 == itemInfo4.position && !itemInfo4.scrolling) {
                                this.mItems.remove(i8);
                                this.mAdapter.destroyItem((ViewGroup) this, i9, itemInfo4.object);
                                i8--;
                                i5--;
                                if (i8 >= 0) {
                                    itemInfo6 = this.mItems.get(i8);
                                    itemInfo4 = itemInfo6;
                                }
                                itemInfo6 = null;
                                itemInfo4 = itemInfo6;
                            }
                        } else if (itemInfo4 != null && i9 == itemInfo4.position) {
                            f += itemInfo4.heightFactor;
                            i8--;
                            if (i8 >= 0) {
                                itemInfo6 = this.mItems.get(i8);
                                itemInfo4 = itemInfo6;
                            }
                            itemInfo6 = null;
                            itemInfo4 = itemInfo6;
                        } else {
                            f += addNewItem(i9, i8 + 1).heightFactor;
                            i5++;
                            if (i8 >= 0) {
                                itemInfo6 = this.mItems.get(i8);
                                itemInfo4 = itemInfo6;
                            }
                            itemInfo6 = null;
                            itemInfo4 = itemInfo6;
                        }
                    }
                    float f2 = itemInfo2.heightFactor;
                    int i10 = i5 + 1;
                    if (f2 < 2.0f) {
                        if (i10 < this.mItems.size()) {
                            itemInfo5 = this.mItems.get(i10);
                        } else {
                            itemInfo5 = null;
                        }
                        if (clientHeight <= 0) {
                            paddingRight = 0.0f;
                        } else {
                            paddingRight = (getPaddingRight() / clientHeight) + 2.0f;
                        }
                        int i11 = this.mCurItem;
                        while (true) {
                            i11++;
                            if (i11 >= count) {
                                break;
                            } else if (f2 >= paddingRight && i11 > min) {
                                if (itemInfo5 == null) {
                                    break;
                                } else if (i11 == itemInfo5.position && !itemInfo5.scrolling) {
                                    this.mItems.remove(i10);
                                    this.mAdapter.destroyItem((ViewGroup) this, i11, itemInfo5.object);
                                    if (i10 < this.mItems.size()) {
                                        itemInfo5 = this.mItems.get(i10);
                                    } else {
                                        itemInfo5 = null;
                                    }
                                }
                            } else if (itemInfo5 != null && i11 == itemInfo5.position) {
                                f2 += itemInfo5.heightFactor;
                                i10++;
                                if (i10 >= this.mItems.size()) {
                                    itemInfo5 = null;
                                } else {
                                    itemInfo5 = this.mItems.get(i10);
                                }
                            } else {
                                ItemInfo addNewItem = addNewItem(i11, i10);
                                i10++;
                                f2 += addNewItem.heightFactor;
                                if (i10 >= this.mItems.size()) {
                                    itemInfo5 = null;
                                } else {
                                    itemInfo5 = this.mItems.get(i10);
                                }
                            }
                        }
                    }
                    calculatePageOffsets(itemInfo2, i5, itemInfo);
                }
                PagerAdapter pagerAdapter = this.mAdapter;
                int i12 = this.mCurItem;
                if (itemInfo2 != null) {
                    obj = itemInfo2.object;
                } else {
                    obj = null;
                }
                pagerAdapter.setPrimaryItem((ViewGroup) this, i12, obj);
                this.mAdapter.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.childIndex = i13;
                    if (!layoutParams.isDecor && layoutParams.heightFactor == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                        layoutParams.heightFactor = infoForChild.heightFactor;
                        layoutParams.position = infoForChild.position;
                    }
                }
                sortChildDrawingOrder();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    if (findFocus != null) {
                        itemInfo3 = infoForAnyChild(findFocus);
                    } else {
                        itemInfo3 = null;
                    }
                    if (itemInfo3 == null || itemInfo3.position != this.mCurItem) {
                        for (int i14 = 0; i14 < getChildCount(); i14++) {
                            View childAt2 = getChildAt(i14);
                            ItemInfo infoForChild2 = infoForChild(childAt2);
                            if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(i2)) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
    }

    public void smoothScrollTo(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float f = clientHeight;
        float f2 = i6;
        float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i4) * 1.0f) / f)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
            Log.e(MixTagConstants.MIX_PAGER, "smoothScrollTo1 " + scrollX + " " + scrollY + " " + i4 + " " + i5 + " " + abs + " " + abs2);
        } else {
            abs = (int) (((Math.abs(i4) / ((f * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 500.0f);
            Log.e(MixTagConstants.MIX_PAGER, "smoothScrollTo2 " + scrollX + " " + scrollY + " " + i4 + " " + i5 + " " + abs);
        }
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 2000));
        ViewCompat.postInvalidateOnAnimation(this);
    }
}
