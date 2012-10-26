package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.widget.EdgeEffectCompat;
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
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.NetWorkErr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCurItem;
    private int mDecorChildCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private int mFlingDistance;
    private boolean mInLayout;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final int[] LAYOUT_ATTRS = {16842931};
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ItemInfo lhs, ItemInfo rhs) {
            return lhs.position - rhs.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    };

    /* loaded from: classes.dex */
    interface Decor {
    }

    /* loaded from: classes.dex */
    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ItemInfo {
        Object object;
        int position;
        boolean scrolling;

        ItemInfo() {
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mItems = new ArrayList<>();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        this.mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        float density = context.getResources().getDisplayMetrics().density;
        this.mFlingDistance = (int) (25.0f * density);
    }

    private void setScrollState(int newState) {
        if (this.mScrollState != newState) {
            this.mScrollState = newState;
            if (this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageScrollStateChanged(newState);
            }
        }
    }

    public void setAdapter(PagerAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo ii = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, ii.position, ii.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter oldAdapter = this.mAdapter;
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListener != null && oldAdapter != adapter) {
            this.mAdapterChangeListener.onAdapterChanged(oldAdapter, adapter);
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!lp.isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        this.mAdapterChangeListener = listener;
    }

    public void setCurrentItem(int item) {
        this.mPopulatePending = false;
        setCurrentItemInternal(item, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.mPopulatePending = false;
        setCurrentItemInternal(item, smoothScroll, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!always && this.mCurItem == item && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (item < 0) {
                item = 0;
            } else if (item >= this.mAdapter.getCount()) {
                item = this.mAdapter.getCount() - 1;
            }
            int pageLimit = this.mOffscreenPageLimit;
            if (item > this.mCurItem + pageLimit || item < this.mCurItem - pageLimit) {
                for (int i = 0; i < this.mItems.size(); i++) {
                    this.mItems.get(i).scrolling = true;
                }
            }
            boolean dispatchSelected = this.mCurItem != item;
            this.mCurItem = item;
            populate();
            int destX = (getWidth() + this.mPageMargin) * item;
            if (smoothScroll) {
                smoothScrollTo(destX, 0, velocity);
                if (dispatchSelected && this.mOnPageChangeListener != null) {
                    this.mOnPageChangeListener.onPageSelected(item);
                }
                if (dispatchSelected && this.mInternalPageChangeListener != null) {
                    this.mInternalPageChangeListener.onPageSelected(item);
                    return;
                }
                return;
            }
            if (dispatchSelected && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(item);
            }
            if (dispatchSelected && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(item);
            }
            completeScroll();
            scrollTo(destX, 0);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener oldListener = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = listener;
        return oldListener;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int limit) {
        if (limit < 1) {
            Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to 1");
            limit = 1;
        }
        if (limit != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = limit;
            populate();
        }
    }

    public void setPageMargin(int marginPixels) {
        int oldMargin = this.mPageMargin;
        this.mPageMargin = marginPixels;
        int width = getWidth();
        recomputeScrollPosition(width, width, marginPixels, oldMargin);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable d) {
        this.mMarginDrawable = d;
        if (d != null) {
            refreshDrawableState();
        }
        setWillNotDraw(d == null);
        invalidate();
    }

    public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mMarginDrawable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = this.mMarginDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
    }

    void smoothScrollTo(int x, int y, int velocity) {
        int duration;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if (dx == 0 && dy == 0) {
            completeScroll();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        this.mScrolling = true;
        setScrollState(2);
        int width = getWidth();
        int halfWidth = width / 2;
        float distanceRatio = Math.min(1.0f, (1.0f * Math.abs(dx)) / width);
        float distance = halfWidth + (halfWidth * distanceInfluenceForSnapDuration(distanceRatio));
        int velocity2 = Math.abs(velocity);
        if (velocity2 > 0) {
            duration = Math.round(1000.0f * Math.abs(distance / velocity2)) * 4;
        } else {
            float pageDelta = Math.abs(dx) / (this.mPageMargin + width);
            duration = (int) ((1.0f + pageDelta) * 100.0f);
        }
        this.mScroller.startScroll(sx, sy, dx, dy, Math.min(duration, 600));
        invalidate();
    }

    void addNewItem(int position, int index) {
        ItemInfo ii = new ItemInfo();
        ii.position = position;
        ii.object = this.mAdapter.instantiateItem((ViewGroup) this, position);
        if (index < 0) {
            this.mItems.add(ii);
        } else {
            this.mItems.add(index, ii);
        }
    }

    void dataSetChanged() {
        boolean needPopulate = this.mItems.size() < 3 && this.mItems.size() < this.mAdapter.getCount();
        int newCurrItem = -1;
        boolean isUpdating = false;
        int i = 0;
        while (i < this.mItems.size()) {
            ItemInfo ii = this.mItems.get(i);
            int newPos = this.mAdapter.getItemPosition(ii.object);
            if (newPos != -1) {
                if (newPos == -2) {
                    this.mItems.remove(i);
                    i--;
                    if (!isUpdating) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        isUpdating = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, ii.position, ii.object);
                    needPopulate = true;
                    if (this.mCurItem == ii.position) {
                        newCurrItem = Math.max(0, Math.min(this.mCurItem, this.mAdapter.getCount() - 1));
                    }
                } else if (ii.position != newPos) {
                    if (ii.position == this.mCurItem) {
                        newCurrItem = newPos;
                    }
                    ii.position = newPos;
                    needPopulate = true;
                }
            }
            i++;
        }
        if (isUpdating) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (newCurrItem >= 0) {
            setCurrentItemInternal(newCurrItem, false, true);
            needPopulate = true;
        }
        if (needPopulate) {
            populate();
            requestLayout();
        }
    }

    void populate() {
        if (this.mAdapter != null && !this.mPopulatePending && getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int pageLimit = this.mOffscreenPageLimit;
            int startPos = Math.max(0, this.mCurItem - pageLimit);
            int N = this.mAdapter.getCount();
            int endPos = Math.min(N - 1, this.mCurItem + pageLimit);
            int lastPos = -1;
            int i = 0;
            while (i < this.mItems.size()) {
                ItemInfo ii = this.mItems.get(i);
                if ((ii.position < startPos || ii.position > endPos) && !ii.scrolling) {
                    this.mItems.remove(i);
                    i--;
                    this.mAdapter.destroyItem((ViewGroup) this, ii.position, ii.object);
                } else if (lastPos < endPos && ii.position > startPos) {
                    int lastPos2 = lastPos + 1;
                    if (lastPos2 < startPos) {
                        lastPos2 = startPos;
                    }
                    while (lastPos2 <= endPos && lastPos2 < ii.position) {
                        addNewItem(lastPos2, i);
                        lastPos2++;
                        i++;
                    }
                }
                lastPos = ii.position;
                i++;
            }
            int lastPos3 = this.mItems.size() > 0 ? this.mItems.get(this.mItems.size() - 1).position : -1;
            if (lastPos3 < endPos) {
                int lastPos4 = lastPos3 + 1;
                if (lastPos4 <= startPos) {
                    lastPos4 = startPos;
                }
                while (lastPos4 <= endPos) {
                    addNewItem(lastPos4, -1);
                    lastPos4++;
                }
            }
            ItemInfo curItem = null;
            int i2 = 0;
            while (true) {
                if (i2 < this.mItems.size()) {
                    if (this.mItems.get(i2).position != this.mCurItem) {
                        i2++;
                    } else {
                        ItemInfo curItem2 = this.mItems.get(i2);
                        curItem = curItem2;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, curItem != null ? curItem.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            if (hasFocus()) {
                View currentFocused = findFocus();
                ItemInfo ii2 = currentFocused != null ? infoForAnyChild(currentFocused) : null;
                if (ii2 == null || ii2.position != this.mCurItem) {
                    for (int i3 = 0; i3 < getChildCount(); i3++) {
                        View child = getChildAt(i3);
                        ItemInfo ii3 = infoForChild(child);
                        if (ii3 != null && ii3.position == this.mCurItem && child.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.position);
            out.writeParcelable(this.adapterState, flags);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel in, ClassLoader loader) {
            super(in);
            loader = loader == null ? getClass().getClassLoader() : loader;
            this.position = in.readInt();
            this.adapterState = in.readParcelable(loader);
            this.loader = loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.position = this.mCurItem;
        if (this.mAdapter != null) {
            ss.adapterState = this.mAdapter.saveState();
        }
        return ss;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(ss.adapterState, ss.loader);
            setCurrentItemInternal(ss.position, false, true);
            return;
        }
        this.mRestoredCurItem = ss.position;
        this.mRestoredAdapterState = ss.adapterState;
        this.mRestoredClassLoader = ss.loader;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (!checkLayoutParams(params)) {
            params = generateLayoutParams(params);
        }
        LayoutParams lp = (LayoutParams) params;
        lp.isDecor |= child instanceof Decor;
        if (this.mInLayout) {
            if (lp != null && lp.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(child, index, params);
            child.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
            return;
        }
        super.addView(child, index, params);
    }

    ItemInfo infoForChild(View child) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo ii = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(child, ii.object)) {
                return ii;
            }
        }
        return null;
    }

    ItemInfo infoForAnyChild(View child) {
        while (true) {
            ViewParent parent = child.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                child = (View) parent;
            } else {
                return infoForChild(child);
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        LayoutParams lp;
        LayoutParams lp2;
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int childHeightSize = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int size = getChildCount();
        for (int i = 0; i < size; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8 && (lp2 = (LayoutParams) child.getLayoutParams()) != null && lp2.isDecor) {
                int hgrav = lp2.gravity & 7;
                int vgrav = lp2.gravity & 112;
                Log.d(TAG, "gravity: " + lp2.gravity + " hgrav: " + hgrav + " vgrav: " + vgrav);
                int widthMode = Integer.MIN_VALUE;
                int heightMode = Integer.MIN_VALUE;
                boolean consumeVertical = vgrav == 48 || vgrav == 80;
                boolean consumeHorizontal = hgrav == 3 || hgrav == 5;
                if (consumeVertical) {
                    widthMode = 1073741824;
                } else if (consumeHorizontal) {
                    heightMode = 1073741824;
                }
                int widthSpec = View.MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                int heightSpec = View.MeasureSpec.makeMeasureSpec(childHeightSize, heightMode);
                child.measure(widthSpec, heightSpec);
                if (consumeVertical) {
                    childHeightSize -= child.getMeasuredHeight();
                } else if (consumeHorizontal) {
                    childWidthSize -= child.getMeasuredWidth();
                }
            }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(childWidthSize, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(childHeightSize, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int size2 = getChildCount();
        for (int i2 = 0; i2 < size2; i2++) {
            View child2 = getChildAt(i2);
            if (child2.getVisibility() != 8 && ((lp = (LayoutParams) child2.getLayoutParams()) == null || !lp.isDecor)) {
                child2.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            recomputeScrollPosition(w, oldw, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        int widthWithMargin = width + margin;
        if (oldWidth > 0) {
            int oldScrollPos = getScrollX();
            int oldwwm = oldWidth + oldMargin;
            int oldScrollItem = oldScrollPos / oldwwm;
            float scrollOffset = (oldScrollPos % oldwwm) / oldwwm;
            int scrollPos = (int) ((oldScrollItem + scrollOffset) * widthWithMargin);
            scrollTo(scrollPos, getScrollY());
            if (!this.mScroller.isFinished()) {
                int newDuration = this.mScroller.getDuration() - this.mScroller.timePassed();
                this.mScroller.startScroll(scrollPos, 0, this.mCurItem * widthWithMargin, 0, newDuration);
                return;
            }
            return;
        }
        int scrollPos2 = this.mCurItem * widthWithMargin;
        if (scrollPos2 != getScrollX()) {
            completeScroll();
            scrollTo(scrollPos2, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft;
        int childTop;
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int count = getChildCount();
        int width = r - l;
        int height = b - t;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int decorCount = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.isDecor) {
                    int hgrav = lp.gravity & 7;
                    int vgrav = lp.gravity & 112;
                    switch (hgrav) {
                        case 1:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            childLeft = paddingLeft;
                            break;
                        case 3:
                            childLeft = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                            break;
                        case 5:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    switch (vgrav) {
                        case 16:
                            childTop = Math.max((height - child.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            childTop = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                            break;
                        case 80:
                            childTop = (height - paddingBottom) - child.getMeasuredHeight();
                            paddingBottom += child.getMeasuredHeight();
                            break;
                        default:
                            childTop = paddingTop;
                            break;
                    }
                    int childLeft2 = childLeft + scrollX;
                    decorCount++;
                    child.layout(childLeft2, childTop, child.getMeasuredWidth() + childLeft2, child.getMeasuredHeight() + childTop);
                } else {
                    ItemInfo ii = infoForChild(child);
                    if (ii != null) {
                        int loff = (this.mPageMargin + width) * ii.position;
                        int childLeft3 = paddingLeft + loff;
                        int childTop2 = paddingTop;
                        child.layout(childLeft3, childTop2, child.getMeasuredWidth() + childLeft3, child.getMeasuredHeight() + childTop2);
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = height - paddingBottom;
        this.mDecorChildCount = decorCount;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (oldX != x || oldY != y) {
                scrollTo(x, y);
                pageScrolled(x);
            }
            invalidate();
            return;
        }
        completeScroll();
    }

    private void pageScrolled(int xpos) {
        int widthWithMargin = getWidth() + this.mPageMargin;
        int position = xpos / widthWithMargin;
        int offsetPixels = xpos % widthWithMargin;
        float offset = offsetPixels / widthWithMargin;
        this.mCalledSuper = false;
        onPageScrolled(position, offset, offsetPixels);
        if (!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        int childLeft;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp.isDecor) {
                    int hgrav = lp.gravity & 7;
                    switch (hgrav) {
                        case 1:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            childLeft = paddingLeft;
                            break;
                        case 3:
                            childLeft = paddingLeft;
                            paddingLeft += child.getWidth();
                            break;
                        case 5:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    int childOffset = (childLeft + scrollX) - child.getLeft();
                    if (childOffset != 0) {
                        child.offsetLeftAndRight(childOffset);
                    }
                }
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        this.mCalledSuper = true;
    }

    private void completeScroll() {
        boolean needPopulate = this.mScrolling;
        if (needPopulate) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (oldX != x || oldY != y) {
                scrollTo(x, y);
            }
            setScrollState(0);
        }
        this.mPopulatePending = false;
        this.mScrolling = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo ii = this.mItems.get(i);
            if (ii.scrolling) {
                needPopulate = true;
                ii.scrolling = false;
            }
        }
        if (needPopulate) {
            populate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = ev.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                this.mLastMotionY = ev.getY();
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                if (this.mScrollState == 2) {
                    this.mIsBeingDragged = true;
                    this.mIsUnableToDrag = false;
                    setScrollState(1);
                    break;
                } else {
                    completeScroll();
                    this.mIsBeingDragged = false;
                    this.mIsUnableToDrag = false;
                    break;
                }
            case 2:
                int activePointerId = this.mActivePointerId;
                if (activePointerId != -1) {
                    int pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId);
                    float x2 = MotionEventCompat.getX(ev, pointerIndex);
                    float dx = x2 - this.mLastMotionX;
                    float xDiff = Math.abs(dx);
                    float y = MotionEventCompat.getY(ev, pointerIndex);
                    float yDiff = Math.abs(y - this.mLastMotionY);
                    if (canScroll(this, false, (int) dx, (int) x2, (int) y)) {
                        this.mLastMotionX = x2;
                        this.mInitialMotionX = x2;
                        this.mLastMotionY = y;
                        return false;
                    } else if (xDiff > this.mTouchSlop && xDiff > yDiff) {
                        this.mIsBeingDragged = true;
                        setScrollState(1);
                        this.mLastMotionX = x2;
                        setScrollingCacheEnabled(true);
                        break;
                    } else if (yDiff > this.mTouchSlop) {
                        this.mIsUnableToDrag = true;
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        if (!this.mIsBeingDragged) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(ev);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int scrollX;
        if (this.mFakeDragging) {
            return true;
        }
        if ((ev.getAction() == 0 && ev.getEdgeFlags() != 0) || this.mAdapter == null || this.mAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        int action = ev.getAction();
        boolean needsInvalidate = false;
        switch (action & MotionEventCompat.ACTION_MASK) {
            case 0:
                completeScroll();
                float x = ev.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, this.mMaximumVelocity);
                    int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int widthWithMargin = getWidth() + this.mPageMargin;
                    int currentPage = getScrollX() / widthWithMargin;
                    float pageOffset = (scrollX % widthWithMargin) / widthWithMargin;
                    int activePointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x2 = MotionEventCompat.getX(ev, activePointerIndex);
                    int totalDelta = (int) (x2 - this.mInitialMotionX);
                    int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity, totalDelta);
                    setCurrentItemInternal(nextPage, true, true, initialVelocity);
                    this.mActivePointerId = -1;
                    endDrag();
                    needsInvalidate = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    int pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x3 = MotionEventCompat.getX(ev, pointerIndex);
                    float xDiff = Math.abs(x3 - this.mLastMotionX);
                    float y = MotionEventCompat.getY(ev, pointerIndex);
                    float yDiff = Math.abs(y - this.mLastMotionY);
                    if (xDiff > this.mTouchSlop && xDiff > yDiff) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionX = x3;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.mIsBeingDragged) {
                    int activePointerIndex2 = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                    float x4 = MotionEventCompat.getX(ev, activePointerIndex2);
                    float deltaX = this.mLastMotionX - x4;
                    this.mLastMotionX = x4;
                    float oldScrollX = getScrollX();
                    float scrollX2 = oldScrollX + deltaX;
                    int width = getWidth();
                    int widthWithMargin2 = width + this.mPageMargin;
                    int lastItemIndex = this.mAdapter.getCount() - 1;
                    float leftBound = Math.max(0, (this.mCurItem - 1) * widthWithMargin2);
                    float rightBound = Math.min(this.mCurItem + 1, lastItemIndex) * widthWithMargin2;
                    if (scrollX2 < leftBound) {
                        if (leftBound == 0.0f) {
                            float over = -scrollX2;
                            needsInvalidate = this.mLeftEdge.onPull(over / width);
                        }
                        scrollX2 = leftBound;
                    } else if (scrollX2 > rightBound) {
                        if (rightBound == lastItemIndex * widthWithMargin2) {
                            float over2 = scrollX2 - rightBound;
                            needsInvalidate = this.mRightEdge.onPull(over2 / width);
                        }
                        scrollX2 = rightBound;
                    }
                    this.mLastMotionX += scrollX2 - ((int) scrollX2);
                    scrollTo((int) scrollX2, getScrollY());
                    pageScrolled((int) scrollX2);
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    setCurrentItemInternal(this.mCurItem, true, true);
                    this.mActivePointerId = -1;
                    endDrag();
                    needsInvalidate = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
                    break;
                }
                break;
            case 5:
                int index = MotionEventCompat.getActionIndex(ev);
                float x5 = MotionEventCompat.getX(ev, index);
                this.mLastMotionX = x5;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                this.mLastMotionX = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                break;
        }
        if (needsInvalidate) {
            invalidate();
        }
        return true;
    }

    private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        if (Math.abs(deltaX) > this.mFlingDistance && Math.abs(velocity) > this.mMinimumVelocity) {
            if (velocity > 0) {
                return currentPage;
            }
            int targetPage = currentPage + 1;
            return targetPage;
        }
        int targetPage2 = (int) (currentPage + pageOffset + 0.5f);
        return targetPage2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean needsInvalidate = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int restoreCount = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), 0.0f);
                this.mLeftEdge.setSize(height, getWidth());
                needsInvalidate = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(restoreCount);
            }
            if (!this.mRightEdge.isFinished()) {
                int restoreCount2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int itemCount = this.mAdapter != null ? this.mAdapter.getCount() : 1;
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), ((-itemCount) * (this.mPageMargin + width)) + this.mPageMargin);
                this.mRightEdge.setSize(height2, width);
                needsInvalidate |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(restoreCount2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (needsInvalidate) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int offset = scrollX % (this.mPageMargin + width);
            if (offset != 0) {
                int left = (scrollX - offset) + width;
                this.mMarginDrawable.setBounds(left, this.mTopPageBounds, this.mPageMargin + left, this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long time = SystemClock.uptimeMillis();
        MotionEvent ev = MotionEvent.obtain(time, time, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(ev);
        ev.recycle();
        this.mFakeDragBeginTime = time;
        return true;
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, this.mMaximumVelocity);
        int initialVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        int totalDelta = (int) (this.mLastMotionX - this.mInitialMotionX);
        int scrollX = getScrollX();
        int widthWithMargin = getWidth() + this.mPageMargin;
        int currentPage = scrollX / widthWithMargin;
        float pageOffset = (scrollX % widthWithMargin) / widthWithMargin;
        int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity, totalDelta);
        setCurrentItemInternal(nextPage, true, true, initialVelocity);
        endDrag();
        this.mFakeDragging = false;
    }

    public void fakeDragBy(float xOffset) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.mLastMotionX += xOffset;
        float scrollX = getScrollX() - xOffset;
        int width = getWidth();
        int widthWithMargin = width + this.mPageMargin;
        float leftBound = Math.max(0, (this.mCurItem - 1) * widthWithMargin);
        float rightBound = Math.min(this.mCurItem + 1, this.mAdapter.getCount() - 1) * widthWithMargin;
        if (scrollX < leftBound) {
            scrollX = leftBound;
        } else if (scrollX > rightBound) {
            scrollX = rightBound;
        }
        this.mLastMotionX += scrollX - ((int) scrollX);
        scrollTo((int) scrollX, getScrollY());
        pageScrolled((int) scrollX);
        long time = SystemClock.uptimeMillis();
        MotionEvent ev = MotionEvent.obtain(this.mFakeDragBeginTime, time, 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(ev);
        ev.recycle();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = MotionEventCompat.getActionIndex(ev);
        int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean enabled) {
        if (this.mScrollingCacheEnabled != enabled) {
            this.mScrollingCacheEnabled = enabled;
        }
    }

    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            int count = group.getChildCount();
            for (int i = count - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom() && canScroll(child, true, dx, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                    return true;
                }
            }
        }
        return checkV && ViewCompat.canScrollHorizontally(v, -dx);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    public boolean executeKeyEvent(KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        switch (event.getKeyCode()) {
            case NetWorkErr.USER_CANNOT_LOGIN /* 21 */:
                boolean handled = arrowScroll(17);
                return handled;
            case NetWorkErr.USER_HAS_LIKE_FORUM /* 22 */:
                boolean handled2 = arrowScroll(66);
                return handled2;
            case BDLocation.TypeGpsLocation /* 61 */:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.hasNoModifiers(event)) {
                    boolean handled3 = arrowScroll(2);
                    return handled3;
                } else if (!KeyEventCompat.hasModifiers(event, 1)) {
                    return false;
                } else {
                    boolean handled4 = arrowScroll(1);
                    return handled4;
                }
            default:
                return false;
        }
    }

    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        }
        boolean handled = false;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        if (nextFocused != null && nextFocused != currentFocused) {
            if (direction == 17) {
                handled = (currentFocused == null || nextFocused.getLeft() < currentFocused.getLeft()) ? nextFocused.requestFocus() : pageLeft();
            } else if (direction == 66) {
                handled = (currentFocused == null || nextFocused.getLeft() > currentFocused.getLeft()) ? nextFocused.requestFocus() : pageRight();
            }
        } else if (direction == 17 || direction == 1) {
            handled = pageLeft();
        } else if (direction == 66 || direction == 2) {
            handled = pageRight();
        }
        if (handled) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        }
        return handled;
    }

    boolean pageLeft() {
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        ItemInfo ii;
        int focusableCount = views.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem) {
                    child.addFocusables(views, direction, focusableMode);
                }
            }
        }
        if ((descendantFocusability != 262144 || focusableCount == views.size()) && isFocusable()) {
            if (((focusableMode & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && views != null) {
                views.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> views) {
        ItemInfo ii;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem) {
                child.addTouchables(views);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int index;
        int increment;
        int end;
        ItemInfo ii;
        int count = getChildCount();
        if ((direction & 2) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        for (int i = index; i != end; i += increment) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem && child.requestFocus(direction, previouslyFocusedRect)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        ItemInfo ii;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0 && (ii = infoForChild(child)) != null && ii.position == this.mCurItem && child.dispatchPopulateAccessibilityEvent(event)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return (p instanceof LayoutParams) && super.checkLayoutParams(p);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* loaded from: classes.dex */
    private class PagerObserver extends DataSetObserver {
        private PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, ViewPager.LAYOUT_ATTRS);
            this.gravity = a.getInteger(0, 0);
            a.recycle();
        }
    }
}
