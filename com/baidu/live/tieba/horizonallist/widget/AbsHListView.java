package com.baidu.live.tieba.horizonallist.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.live.tieba.horizonallist.a.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.u.a;
import java.util.ArrayList;
@TargetApi(11)
/* loaded from: classes3.dex */
public abstract class AbsHListView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    a.AbstractC0178a aZK;
    protected a aZL;
    protected final j aZM;
    private e aZN;
    protected i aZO;
    private g aZP;
    private c aZQ;
    private b aZR;
    private h aZS;
    private f aZT;
    private SavedState aZU;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    boolean mAdapterHasStableIds;
    private int mCacheColorHint;
    protected boolean mCachingActive;
    protected boolean mCachingStarted;
    protected SparseArrayCompat<Boolean> mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    int mCheckedItemCount;
    public Object mChoiceActionMode;
    protected int mChoiceMode;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private EdgeEffectCompat mEdgeGlowBottom;
    private EdgeEffectCompat mEdgeGlowTop;
    private int mFirstPositionDistanceGuess;
    private boolean mForceTranscriptScroll;
    private int mGlowPaddingBottom;
    private int mGlowPaddingTop;
    protected int mHeightMeasureSpec;
    private float mHorizontalScrollFactor;
    protected boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    protected final boolean[] mIsScrap;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastX;
    protected int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    protected int mMotionPosition;
    int mMotionViewNewLeft;
    int mMotionViewOriginalLeft;
    int mMotionX;
    int mMotionY;
    Object mMultiChoiceModeCallback;
    int mOverflingDistance;
    int mOverscrollDistance;
    protected int mOverscrollMax;
    private Runnable mPendingCheckForTap;
    protected Runnable mPositionScrollAfterLayout;
    protected int mResurrectToPosition;
    View mScrollLeft;
    View mScrollRight;
    boolean mScrollingCacheEnabled;
    protected int mSelectedLeft;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    protected Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    protected boolean mStackFromRight;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    static final Interpolator sLinearInterpolator = new LinearInterpolator();
    public static final int[] STATESET_NOTHING = {0};

    /* loaded from: classes3.dex */
    public interface g {
        void a(AbsHListView absHListView, int i);

        void a(AbsHListView absHListView, int i, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void onMovedToScrapHeap(View view);
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(Rect rect);
    }

    protected abstract void fillGap(boolean z);

    protected abstract int findMotionCol(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.aZM = new j();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.c.sdk_hlv_absHListViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        Drawable drawable;
        int i4;
        boolean z4 = true;
        int i5 = 0;
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.aZM = new j();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.k.sdk_HListView, i2, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(a.k.sdk_AbsHListView_android_listSelector);
            z3 = obtainStyledAttributes.getBoolean(a.k.sdk_AbsHListView_android_drawSelectorOnTop, false);
            z2 = obtainStyledAttributes.getBoolean(a.k.sdk_AbsHListView_hlv_stackFromRight, false);
            z = obtainStyledAttributes.getBoolean(a.k.sdk_AbsHListView_android_scrollingCache, true);
            i3 = obtainStyledAttributes.getInt(a.k.sdk_AbsHListView_sdk_hlv_transcriptMode, 0);
            i4 = obtainStyledAttributes.getColor(a.k.sdk_AbsHListView_android_cacheColorHint, 0);
            z4 = obtainStyledAttributes.getBoolean(a.k.sdk_AbsHListView_android_smoothScrollbar, true);
            i5 = obtainStyledAttributes.getInt(a.k.sdk_AbsHListView_android_choiceMode, 0);
            obtainStyledAttributes.recycle();
        } else {
            i3 = 0;
            z = true;
            z2 = false;
            z3 = false;
            drawable = null;
            i4 = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.aZK = com.baidu.live.tieba.horizonallist.a.a.Q(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.mEdgeGlowTop == null) {
                Context context = getContext();
                this.mEdgeGlowTop = new EdgeEffectCompat(context);
                this.mEdgeGlowBottom = new EdgeEffectCompat(context);
            }
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.mAdapterHasStableIds = this.mAdapter.hasStableIds();
            if (this.mChoiceMode != 0 && this.mAdapterHasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        if (this.mCheckStates != null) {
            this.mCheckStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public boolean isItemChecked(int i2) {
        if (this.mChoiceMode == 0 || this.mCheckStates == null) {
            return false;
        }
        return this.mCheckStates.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.mChoiceMode == 1 && this.mCheckStates != null && this.mCheckStates.size() == 1) {
            return this.mCheckStates.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.mChoiceMode == 0 || this.mCheckedIdStates == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.mCheckStates != null) {
            this.mCheckStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
        this.mCheckedItemCount = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.mChoiceMode != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.mChoiceMode == 3 && this.mChoiceActionMode == null) {
                if (this.mMultiChoiceModeCallback == null || !((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback).Gw()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.mChoiceActionMode = startActionMode((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback);
            }
            if (this.mChoiceMode == 2 || (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3)) {
                boolean booleanValue = this.mCheckStates.get(i2, false).booleanValue();
                this.mCheckStates.put(i2, Boolean.valueOf(z));
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.mCheckedItemCount++;
                    } else {
                        this.mCheckedItemCount--;
                    }
                }
                if (this.mChoiceActionMode != null) {
                    ((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback).a((ActionMode) this.mChoiceActionMode, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.mCheckStates.clear();
                    if (z2) {
                        this.mCheckedIdStates.clear();
                    }
                }
                if (z) {
                    this.mCheckStates.put(i2, true);
                    if (z2) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.mCheckedItemCount = 1;
                } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                    this.mCheckedItemCount = 0;
                }
            }
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                this.mDataChanged = true;
                rememberSyncState();
                requestLayout();
            }
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView
    public boolean performItemClick(View view, int i2, long j2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        if (this.mChoiceMode != 0) {
            if (this.mChoiceMode == 2 || (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3 && this.mChoiceActionMode != null)) {
                boolean z5 = !this.mCheckStates.get(i2, false).booleanValue();
                this.mCheckStates.put(i2, Boolean.valueOf(z5));
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
                if (this.mChoiceActionMode != null) {
                    ((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback).a((ActionMode) this.mChoiceActionMode, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.mChoiceMode == 1) {
                if (!this.mCheckStates.get(i2, false).booleanValue()) {
                    this.mCheckStates.clear();
                    this.mCheckStates.put(i2, true);
                    if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                        this.mCheckedIdStates.clear();
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.mCheckedItemCount = 1;
                } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                    this.mCheckedItemCount = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                updateOnScreenCheckedViews();
            }
            boolean z6 = z2;
            z = true;
            z3 = z6;
        } else {
            z = false;
        }
        if (z3) {
            return z | super.performItemClick(view, i2, j2);
        }
        return z;
    }

    private void updateOnScreenCheckedViews() {
        int i2 = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.mCheckStates.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    @TargetApi(11)
    public void setChoiceMode(int i2) {
        this.mChoiceMode = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.mChoiceActionMode != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.mChoiceActionMode).finish();
            }
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseArrayCompat<>();
            }
            if (this.mCheckedIdStates == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(com.baidu.live.tieba.horizonallist.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.mMultiChoiceModeCallback == null) {
                this.mMultiChoiceModeCallback = new com.baidu.live.tieba.horizonallist.a.a.b(this);
            }
            ((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.mItemCount) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.mListPadding.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.mListPadding.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setOnScrollListener(g gVar) {
        this.aZP = gVar;
        invokeOnItemScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeOnItemScrollListener() {
        if (this.aZP != null) {
            this.aZP.a(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex != firstVisiblePosition || this.mLastAccessibilityScrollEventToIndex != lastVisiblePosition) {
                this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i2);
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.View
    @SuppressLint({"Override"})
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
            return;
        }
        super.getFocusedRect(rect);
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.mStackFromRight != z) {
            this.mStackFromRight = z;
            requestLayoutIfNecessary();
        }
    }

    void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.live.tieba.horizonallist.widget.AbsHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: cP */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        SparseArrayCompat<Boolean> baA;
        LongSparseArray<Integer> baB;
        long baw;
        int bax;
        boolean bay;
        int baz;
        String filter;
        int position;
        long selectedId;
        int width;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.baw = parcel.readLong();
            this.bax = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.filter = parcel.readString();
            this.bay = parcel.readByte() != 0;
            this.baz = parcel.readInt();
            this.baA = j(parcel);
            this.baB = i(parcel);
        }

        private LongSparseArray<Integer> i(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> j(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>(readInt);
            a(sparseArrayCompat, parcel, readInt);
            return sparseArrayCompat;
        }

        private void a(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            while (i > 0) {
                longSparseArray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        private void a(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel, int i) {
            while (i > 0) {
                sparseArrayCompat.append(parcel.readInt(), Boolean.valueOf(parcel.readByte() == 1));
                i--;
            }
        }

        private void a(LongSparseArray<Integer> longSparseArray, Parcel parcel) {
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeLong(longSparseArray.keyAt(i));
                parcel.writeInt(longSparseArray.valueAt(i).intValue());
            }
        }

        private void a(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel) {
            if (sparseArrayCompat == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = sparseArrayCompat.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeInt(sparseArrayCompat.keyAt(i));
                parcel.writeByte((byte) (sparseArrayCompat.valueAt(i).booleanValue() ? 1 : 0));
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.baw);
            parcel.writeInt(this.bax);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.filter);
            parcel.writeByte((byte) (this.bay ? 1 : 0));
            parcel.writeInt(this.baz);
            a(this.baA, parcel);
            a(this.baB, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.baw + " viewLeft=" + this.bax + " position=" + this.position + " width=" + this.width + " filter=" + this.filter + " checkState=" + this.baA + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.aZU != null) {
            savedState.selectedId = this.aZU.selectedId;
            savedState.baw = this.aZU.baw;
            savedState.bax = this.aZU.bax;
            savedState.position = this.aZU.position;
            savedState.width = this.aZU.width;
            savedState.filter = this.aZU.filter;
            savedState.bay = this.aZU.bay;
            savedState.baz = this.aZU.baz;
            savedState.baA = this.aZU.baA;
            savedState.baB = this.aZU.baB;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.bax = this.mSelectedLeft;
            savedState.position = getSelectedItemPosition();
            savedState.baw = -1L;
        } else if (z2 && this.mFirstPosition > 0) {
            savedState.bax = getChildAt(0).getLeft();
            int i2 = this.mFirstPosition;
            if (i2 >= this.mItemCount) {
                i2 = this.mItemCount - 1;
            }
            savedState.position = i2;
            savedState.baw = this.mAdapter.getItemId(i2);
        } else {
            savedState.bax = 0;
            savedState.baw = -1L;
            savedState.position = 0;
        }
        savedState.filter = null;
        savedState.bay = (Build.VERSION.SDK_INT < 11 || this.mChoiceMode != 3 || this.mChoiceActionMode == null) ? false : false;
        if (this.mCheckStates != null) {
            try {
                savedState.baA = this.mCheckStates.m5clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.baA = new SparseArrayCompat<>();
            }
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.mCheckedIdStates.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.mCheckedIdStates.keyAt(i3), this.mCheckedIdStates.valueAt(i3));
            }
            savedState.baB = longSparseArray;
        }
        savedState.baz = this.mCheckedItemCount;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncWidth = savedState.width;
        if (savedState.selectedId >= 0) {
            this.mNeedSync = true;
            this.aZU = savedState;
            this.mSyncColId = savedState.selectedId;
            this.mSyncPosition = savedState.position;
            this.mSpecificLeft = savedState.bax;
            this.mSyncMode = 0;
        } else if (savedState.baw >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            this.mNeedSync = true;
            this.aZU = savedState;
            this.mSyncColId = savedState.baw;
            this.mSyncPosition = savedState.position;
            this.mSpecificLeft = savedState.bax;
            this.mSyncMode = 1;
        }
        if (savedState.baA != null) {
            this.mCheckStates = savedState.baA;
        }
        if (savedState.baB != null) {
            this.mCheckedIdStates = savedState.baB;
        }
        this.mCheckedItemCount = savedState.baz;
        if (Build.VERSION.SDK_INT >= 11 && savedState.bay && this.mChoiceMode == 3 && this.mMultiChoiceModeCallback != null) {
            this.mChoiceActionMode = startActionMode((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.mSelectedPosition < 0 && !isInTouchMode()) {
            if (!this.mIsAttached && this.mAdapter != null) {
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = this.mAdapter.getCount();
            }
            resurrectSelection();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mPositionScrollAfterLayout = null;
        this.mNeedSync = false;
        this.aZU = null;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectedLeft = 0;
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                int i2 = childCount * 100;
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    i2 += (left * 100) / width;
                }
                View childAt2 = getChildAt(childCount - 1);
                int right = childAt2.getRight();
                int width2 = childAt2.getWidth();
                if (width2 > 0) {
                    return i2 - (((right - getWidth()) * 100) / width2);
                }
                return i2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int i2 = 0;
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.mSmoothScrollbarEnabled) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.mItemCount;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            int max = Math.max(this.mItemCount * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f));
            }
            return max;
        }
        return this.mItemCount;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int left = getChildAt(0).getLeft();
            return left < getPaddingLeft() ? (-(left - getPaddingLeft())) / getHorizontalFadingEdgeLength() : leftFadingEdgeStrength;
        }
        return leftFadingEdgeStrength;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount != 0) {
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int right = getChildAt(childCount - 1).getRight();
            int width = getWidth();
            float horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            if (right <= width - getPaddingRight()) {
                return rightFadingEdgeStrength;
            }
            return ((right - width) + getPaddingRight()) / horizontalFadingEdgeLength;
        }
        return rightFadingEdgeStrength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        if (this.mTranscriptMode == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.mForceTranscriptScroll = childCount + this.mFirstPosition >= this.mLastHandledItemCount && (childAt != null ? childAt.getRight() : width) <= width;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.aZM.GA();
        }
        layoutChildren();
        this.mInLayout = false;
        this.mOverscrollMax = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateScrollIndicators() {
        boolean z = true;
        if (this.mScrollLeft != null) {
            boolean z2 = this.mFirstPosition > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.mListPadding.left;
            }
            this.mScrollLeft.setVisibility(z2 ? 0 : 4);
        }
        if (this.mScrollRight != null) {
            int childCount = getChildCount();
            boolean z3 = this.mFirstPosition + childCount < this.mItemCount;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.mListPadding.right) {
                z = false;
            }
            this.mScrollRight.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
    }

    public int getListPaddingBottom() {
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        return this.mListPadding.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View obtainView(int i2, boolean[] zArr) {
        View view;
        LayoutParams layoutParams;
        zArr[0] = false;
        View cN = this.aZM.cN(i2);
        if (cN == null) {
            View cO = this.aZM.cO(i2);
            if (cO != null) {
                view = this.mAdapter.getView(i2, cO, this);
                if (view != cO) {
                    this.aZM.d(cO, i2);
                    if (this.mCacheColorHint != 0) {
                        view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                        cN = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    cN = view;
                }
                if (this.mAdapterHasStableIds) {
                    ViewGroup.LayoutParams layoutParams2 = cN.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams = (LayoutParams) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams2)) {
                        layoutParams = (LayoutParams) generateLayoutParams(layoutParams2);
                    } else {
                        layoutParams = (LayoutParams) layoutParams2;
                    }
                    layoutParams.bae = this.mAdapter.getItemId(i2);
                    cN.setLayoutParams(layoutParams);
                }
                if (this.mAccessibilityManager.isEnabled() && this.aZT == null) {
                    this.aZT = new f();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.mCacheColorHint != 0) {
                    view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                }
            }
            cN = view;
            if (this.mAdapterHasStableIds) {
            }
            if (this.mAccessibilityManager.isEnabled()) {
                this.aZT = new f();
            }
        }
        return cN;
    }

    @TargetApi(14)
    /* loaded from: classes3.dex */
    class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView != -1 && adapter != null && AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                if (positionForView == AbsHListView.this.getSelectedItemPosition()) {
                    accessibilityNodeInfoCompat.setSelected(true);
                    accessibilityNodeInfoCompat.addAction(8);
                } else {
                    accessibilityNodeInfoCompat.addAction(4);
                }
                if (AbsHListView.this.isClickable()) {
                    accessibilityNodeInfoCompat.addAction(16);
                    accessibilityNodeInfoCompat.setClickable(true);
                }
                if (AbsHListView.this.isLongClickable()) {
                    accessibilityNodeInfoCompat.addAction(32);
                    accessibilityNodeInfoCompat.setLongClickable(true);
                }
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView == -1 || adapter == null) {
                return false;
            }
            if (AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                long itemIdAtPosition = AbsHListView.this.getItemIdAtPosition(positionForView);
                switch (i) {
                    case 4:
                        if (AbsHListView.this.getSelectedItemPosition() != positionForView) {
                            AbsHListView.this.setSelection(positionForView);
                            return true;
                        }
                        return false;
                    case 8:
                        if (AbsHListView.this.getSelectedItemPosition() == positionForView) {
                            AbsHListView.this.setSelection(-1);
                            return true;
                        }
                        return false;
                    case 16:
                        if (AbsHListView.this.isClickable()) {
                            return AbsHListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    case 32:
                        if (AbsHListView.this.isLongClickable()) {
                            return AbsHListView.this.performLongPress(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    default:
                        return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void positionSelector(int i2, View view) {
        if (i2 != -1) {
            this.mSelectorPosition = i2;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof l) {
            ((l) view).a(rect);
        }
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.mIsChildViewEnabled;
        if (view.isEnabled() != z) {
            this.mIsChildViewEnabled = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void positionSelector(int i2, int i3, int i4, int i5) {
        this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, this.mSelectionRightPadding + i4, this.mSelectionBottomPadding + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.mDrawSelectorOnTop;
        if (!z) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            drawSelector(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    boolean touchModeDrawsInPressedState() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    private void drawSelector(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.mSelector != null) {
            this.mSelector.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (!childAt.hasFocusable()) {
                            childAt.setPressed(true);
                        } else {
                            return;
                        }
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (isLongClickable && !this.mDataChanged) {
                        if (this.aZR == null) {
                            this.aZR = new b();
                        }
                        this.aZR.GF();
                        postDelayed(this.aZR, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    public void setScrollIndicators(View view, View view2) {
        this.mScrollLeft = view;
        this.mScrollRight = view2;
    }

    void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(STATESET_NOTHING);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"Override"})
    protected int[] onCreateDrawableState(int i2) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i2);
        }
        int i3 = ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i3) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
            return onCreateDrawableState;
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mSelector != null) {
            this.mSelector.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.aZL == null) {
            this.aZL = new a();
            this.mAdapter.registerDataSetObserver(this.aZL);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.mIsAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aZM.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.aZL != null) {
            this.mAdapter.unregisterDataSetObserver(this.aZL);
            this.aZL = null;
        }
        if (this.aZN != null) {
            removeCallbacks(this.aZN);
        }
        if (this.aZO != null) {
            this.aZO.stop();
        }
        if (this.mClearScrollingCache != null) {
            removeCallbacks(this.mClearScrollingCache);
        }
        if (this.aZS != null) {
            removeCallbacks(this.aZS);
        }
        if (this.mTouchModeReset != null) {
            removeCallbacks(this.mTouchModeReset);
            this.mTouchModeReset = null;
        }
        this.mIsAttached = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.aZN != null) {
                removeCallbacks(this.aZN);
                this.aZN.Gy();
                if (this.aZO != null) {
                    this.aZO.stop();
                }
                if (getScrollX() != 0) {
                    this.aZK.setScrollX(0);
                    finishGlows();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else if (i2 != this.mLastTouchMode && this.mLastTouchMode != -1) {
            if (i2 == 1) {
                resurrectSelection();
            } else {
                hideSelector();
                this.mLayoutMode = 0;
                layoutChildren();
            }
        }
        this.mLastTouchMode = i2;
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j2) {
        return new AdapterView.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class m {
        private int baC;

        private m() {
        }

        public void GF() {
            this.baC = AbsHListView.this.getWindowAttachCount();
        }

        public boolean GG() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.baC;
        }
    }

    /* loaded from: classes3.dex */
    private class h extends m implements Runnable {
        int baf;

        private h() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.mDataChanged) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.baf;
                if (listAdapter != null && AbsHListView.this.mItemCount > 0 && i != -1 && i < listAdapter.getCount() && GG() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.mFirstPosition)) != null) {
                    AbsHListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends m implements Runnable {
        private c() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
            if (childAt != null) {
                if ((!GG() || AbsHListView.this.mDataChanged) ? false : AbsHListView.this.performLongPress(childAt, AbsHListView.this.mMotionPosition, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.mMotionPosition))) {
                    AbsHListView.this.mTouchMode = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.mTouchMode = 2;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b extends m implements Runnable {
        private b() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbsHListView.this.isPressed() && AbsHListView.this.mSelectedPosition >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mSelectedPosition - AbsHListView.this.mFirstPosition);
                if (!AbsHListView.this.mDataChanged) {
                    if (GG() ? AbsHListView.this.performLongPress(childAt, AbsHListView.this.mSelectedPosition, AbsHListView.this.mSelectedColId) : false) {
                        AbsHListView.this.setPressed(false);
                        childAt.setPressed(false);
                        return;
                    }
                    return;
                }
                AbsHListView.this.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
        }
    }

    boolean performLongPress(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
            if (this.mChoiceActionMode == null) {
                ActionMode startActionMode = startActionMode((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.baF != null ? this.baF.b(this, view, i2, j2) : false;
        if (!b2) {
            this.mContextMenuInfo = createContextMenuInfo(view, i2, j2);
            b2 = super.showContextMenuForChild(this);
        }
        if (b2) {
            performHapticFeedback(0);
            return b2;
        }
        return b2;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    public boolean showContextMenu(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return showContextMenu(f2, f3, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            boolean b2 = this.baF != null ? this.baF.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                return super.showContextMenuForChild(view);
            }
            return b2;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 23:
            case 66:
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && this.mSelectedPosition >= 0 && this.mAdapter != null && this.mSelectedPosition < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        performItemClick(childAt, this.mSelectedPosition, this.mSelectedColId);
                        childAt.setPressed(false);
                    }
                    setPressed(false);
                    return true;
                }
                break;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public int pointToPosition(int i2, int i3) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* loaded from: classes3.dex */
    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            if (AbsHListView.this.mTouchMode == 0) {
                AbsHListView.this.mTouchMode = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.mLayoutMode = 0;
                    if (!AbsHListView.this.mDataChanged) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.positionSelector(AbsHListView.this.mMotionPosition, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.mSelector != null && (current = AbsHListView.this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.aZQ == null) {
                                AbsHListView.this.aZQ = new c();
                            }
                            AbsHListView.this.aZQ.GF();
                            AbsHListView.this.postDelayed(AbsHListView.this.aZQ, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.mTouchMode = 2;
                        return;
                    }
                    AbsHListView.this.mTouchMode = 2;
                }
            }
        }
    }

    private boolean startScrollIfNeeded(int i2) {
        int i3 = i2 - this.mMotionX;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            createScrollingCache();
            if (z) {
                this.mTouchMode = 5;
                this.mMotionCorrection = 0;
            } else {
                this.mTouchMode = 3;
                this.mMotionCorrection = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.aZQ);
            }
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i2);
            return true;
        }
        return false;
    }

    private void scrollIfNeeded(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.mMotionX;
        int i5 = i4 - this.mMotionCorrection;
        int i6 = this.mLastX != Integer.MIN_VALUE ? i2 - this.mLastX : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.mLastX) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.mMotionPosition >= 0) {
                    childCount = this.mMotionPosition - this.mFirstPosition;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = i6 != 0 ? trackMotionScroll(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (trackMotionScroll) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                        if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !contentFits())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.mEdgeGlowTop.onPull(i7 / getWidth());
                                if (!this.mEdgeGlowBottom.isFinished()) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.mEdgeGlowBottom.onPull(i7 / getWidth());
                                if (!this.mEdgeGlowTop.isFinished()) {
                                    this.mEdgeGlowTop.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.mMotionX = i2;
                }
                this.mLastX = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.mLastX) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.mLastX ? 1 : -1;
            if (this.mDirection == 0) {
                this.mDirection = i9;
            }
            int i10 = -i6;
            if ((i8 >= 0 || scrollX < 0) && (i8 <= 0 || scrollX > 0)) {
                i3 = 0;
            } else {
                i10 = -scrollX;
                i3 = i6 + i10;
            }
            if (i10 != 0) {
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !contentFits())) {
                    if (i4 > 0) {
                        this.mEdgeGlowTop.onPull(i10 / getWidth());
                        if (!this.mEdgeGlowBottom.isFinished()) {
                            this.mEdgeGlowBottom.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.mEdgeGlowBottom.onPull(i10 / getWidth());
                        if (!this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.aZK.setScrollX(0);
                    invalidateParentIfNeeded();
                }
                trackMotionScroll(i3, i3);
                this.mTouchMode = 3;
                int findClosestMotionCol = findClosestMotionCol(i2);
                this.mMotionCorrection = 0;
                View childAt3 = getChildAt(findClosestMotionCol - this.mFirstPosition);
                this.mMotionViewOriginalLeft = childAt3 != null ? childAt3.getLeft() : 0;
                this.mMotionX = i2;
                this.mMotionPosition = findClosestMotionCol;
            }
            this.mLastX = i2;
            this.mDirection = i9;
        }
    }

    @TargetApi(11)
    protected void invalidateParentIfNeeded() {
        if (this.aZK.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            hideSelector();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.aZN != null) {
                this.aZN.Gy();
            }
            if (this.aZO != null) {
                this.aZO.stop();
            }
            if (getScrollX() != 0) {
                this.aZK.setScrollX(0);
                finishGlows();
                invalidate();
            }
        }
    }

    @TargetApi(14)
    protected boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @Override // android.view.View
    @SuppressLint({"Override"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2;
        int i3 = 0;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.aZO != null) {
            this.aZO.stop();
        }
        if (this.mIsAttached) {
            int action = motionEvent.getAction();
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & 255) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.aZN.Gy();
                            if (this.aZO != null) {
                                this.aZO.stop();
                            }
                            this.mTouchMode = 5;
                            this.mMotionY = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.mLastX = x;
                            this.mMotionX = x;
                            this.mMotionCorrection = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.mDataChanged) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.mPendingCheckForTap == null) {
                                        this.mPendingCheckForTap = new d();
                                    }
                                    postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    createScrollingCache();
                                    this.mTouchMode = 3;
                                    this.mMotionCorrection = 0;
                                    i2 = findMotionCol(x2);
                                    this.aZN.Gz();
                                }
                                if (i2 >= 0) {
                                    this.mMotionViewOriginalLeft = getChildAt(i2 - this.mFirstPosition).getLeft();
                                }
                                this.mMotionX = x2;
                                this.mMotionY = y;
                                this.mMotionPosition = i2;
                                this.mLastX = Integer.MIN_VALUE;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.mMotionX = x2;
                            this.mMotionY = y;
                            this.mMotionPosition = i2;
                            this.mLastX = Integer.MIN_VALUE;
                    }
                    if (performButtonActionOnTouchDown(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.mPendingCheckForTap);
                        return true;
                    }
                    return true;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i4 = this.mMotionPosition;
                            final View childAt = getChildAt(i4 - this.mFirstPosition);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.mListPadding.left) && x3 < ((float) (getWidth() - this.mListPadding.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.aZS == null) {
                                    this.aZS = new h();
                                }
                                final h hVar = this.aZS;
                                hVar.baf = i4;
                                hVar.GF();
                                this.mResurrectToPosition = i4;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.aZQ);
                                    }
                                    this.mLayoutMode = 0;
                                    if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.mMotionPosition);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        positionSelector(this.mMotionPosition, childAt);
                                        setPressed(true);
                                        if (this.mSelector != null && (current = this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.mTouchModeReset != null) {
                                            removeCallbacks(this.mTouchModeReset);
                                        }
                                        this.mTouchModeReset = new Runnable() { // from class: com.baidu.live.tieba.horizonallist.widget.AbsHListView.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AbsHListView.this.mTouchMode = -1;
                                                childAt.setPressed(false);
                                                AbsHListView.this.setPressed(false);
                                                if (!AbsHListView.this.mDataChanged) {
                                                    hVar.run();
                                                }
                                            }
                                        };
                                        postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                                        return true;
                                    }
                                    this.mTouchMode = -1;
                                    updateSelectorState();
                                    return true;
                                } else if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                                    hVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            updateSelectorState();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i5 = this.mListPadding.left;
                                int width = getWidth() - this.mListPadding.right;
                                if (this.mFirstPosition == 0 && left >= i5 && this.mFirstPosition + childCount < this.mItemCount && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    reportScrollStateChange(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.mVelocityScale);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i5 - this.mOverscrollDistance) && (childCount + this.mFirstPosition != this.mItemCount || right != this.mOverscrollDistance + width))) {
                                        if (this.aZN == null) {
                                            this.aZN = new e();
                                        }
                                        reportScrollStateChange(2);
                                        this.aZN.start(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        reportScrollStateChange(0);
                                        if (this.aZN != null) {
                                            this.aZN.Gy();
                                        }
                                        if (this.aZO != null) {
                                            this.aZO.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.aZN == null) {
                                this.aZN = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            reportScrollStateChange(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.aZN.cI(-xVelocity2);
                                break;
                            } else {
                                this.aZN.Gx();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.mEdgeGlowTop != null) {
                        this.mEdgeGlowTop.onRelease();
                        this.mEdgeGlowBottom.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.aZQ);
                    }
                    recycleVelocityTracker();
                    this.mActivePointerId = -1;
                    return true;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                    } else {
                        i3 = findPointerIndex;
                    }
                    int x4 = (int) motionEvent.getX(i3);
                    if (this.mDataChanged) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            startScrollIfNeeded(x4);
                            return true;
                        case 3:
                        case 5:
                            scrollIfNeeded(x4);
                            return true;
                        case 4:
                        default:
                            return true;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.aZN == null) {
                                this.aZN = new e();
                            }
                            this.aZN.Gx();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            clearScrollingCache();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.aZQ);
                            }
                            recycleVelocityTracker();
                            break;
                    }
                    if (this.mEdgeGlowTop != null) {
                        this.mEdgeGlowTop.onRelease();
                        this.mEdgeGlowBottom.onRelease();
                    }
                    this.mActivePointerId = -1;
                    return true;
                case 4:
                default:
                    return true;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.mMotionCorrection = 0;
                    this.mActivePointerId = pointerId;
                    this.mMotionX = x5;
                    this.mMotionY = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition2;
                    }
                    this.mLastX = x5;
                    return true;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i6 = this.mMotionX;
                    int pointToPosition3 = pointToPosition(i6, this.mMotionY);
                    if (pointToPosition3 >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition3;
                    }
                    this.mLastX = i6;
                    return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.aZK.setScrollX(i2);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.mTouchMode == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!trackMotionScroll(horizontalScrollFactor, horizontalScrollFactor)) {
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    protected float getHorizontalScrollFactor() {
        if (this.mHorizontalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(a.c.sdk_hlv_listPreferredItemWidth, typedValue, true)) {
                this.mHorizontalScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.mHorizontalScrollFactor;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollX = getScrollX();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                int i2 = this.mListPadding.top + this.mGlowPaddingTop;
                int height = (getHeight() - i2) - (this.mListPadding.bottom + this.mGlowPaddingBottom);
                int min = Math.min(0, this.mFirstPositionDistanceGuess + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.mEdgeGlowTop.setSize(height, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.mListPadding.left + this.mGlowPaddingTop;
                int height2 = (getHeight() - i3) - (this.mListPadding.right + this.mGlowPaddingBottom);
                int max = Math.max(getWidth(), scrollX + this.mLastPositionDistanceGuess);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.mEdgeGlowBottom.setSize(height2, height2);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public void setOverScrollEffectPadding(int i2, int i3) {
        this.mGlowPaddingTop = i2;
        this.mGlowPaddingBottom = i3;
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.aZO != null) {
            this.aZO.stop();
        }
        if (this.mIsAttached) {
            switch (action & 255) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.mMotionCorrection = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int findMotionCol = findMotionCol(x);
                    if (i2 != 4 && findMotionCol >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(findMotionCol - this.mFirstPosition).getLeft();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = findMotionCol;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.mLastX = Integer.MIN_VALUE;
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    recycleVelocityTracker();
                    reportScrollStateChange(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return startScrollIfNeeded((int) motionEvent.getX(findPointerIndex));
                        default:
                            return false;
                    }
                case 4:
                case 5:
                default:
                    return false;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    return false;
            }
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i2);
            this.mMotionY = (int) motionEvent.getY(i2);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    void reportScrollStateChange(int i2) {
        if (i2 != this.mLastScrollState && this.aZP != null) {
            this.mLastScrollState = i2;
            this.aZP.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e implements Runnable {
        private final com.baidu.live.tieba.horizonallist.widget.c aZX;
        private final Runnable aZY = new Runnable() { // from class: com.baidu.live.tieba.horizonallist.widget.AbsHListView.e.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AbsHListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsHListView.this.mVelocityTracker;
                com.baidu.live.tieba.horizonallist.widget.c cVar = e.this.aZX;
                if (velocityTracker != null && i != -1) {
                    velocityTracker.computeCurrentVelocity(1000, AbsHListView.this.mMaximumVelocity);
                    float f = -velocityTracker.getXVelocity(i);
                    if (Math.abs(f) >= AbsHListView.this.mMinimumVelocity && cVar.l(f, 0.0f)) {
                        AbsHListView.this.postDelayed(this, 40L);
                        return;
                    }
                    e.this.Gy();
                    AbsHListView.this.mTouchMode = 3;
                    AbsHListView.this.reportScrollStateChange(1);
                }
            }
        };
        private int mLastFlingX;

        e() {
            this.aZX = new com.baidu.live.tieba.horizonallist.widget.c(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingX = i2;
            this.aZX.setInterpolator(null);
            this.aZX.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.aZK.postOnAnimation(this);
        }

        void Gx() {
            if (this.aZX.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.aZK.postOnAnimation(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.reportScrollStateChange(0);
        }

        void cI(int i) {
            this.aZX.setInterpolator(null);
            this.aZX.fling(AbsHListView.this.getScrollX(), 0, i, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.aZK.postOnAnimation(this);
        }

        void cJ(int i) {
            this.aZX.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.mOverflingDistance);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.contentFits())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.aZX.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.mEdgeGlowTop.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.mEdgeGlowBottom.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.aZO != null) {
                    AbsHListView.this.aZO.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.aZK.postOnAnimation(this);
        }

        void e(int i, int i2, boolean z) {
            int i3 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 0;
            this.mLastFlingX = i3;
            this.aZX.setInterpolator(z ? AbsHListView.sLinearInterpolator : null);
            this.aZX.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.aZK.postOnAnimation(this);
        }

        void Gy() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.aZY);
            AbsHListView.this.reportScrollStateChange(0);
            AbsHListView.this.clearScrollingCache();
            this.aZX.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void Gz() {
            AbsHListView.this.postDelayed(this.aZY, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.aZX.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    Gy();
                    return;
                case 6:
                    com.baidu.live.tieba.horizonallist.widget.c cVar = this.aZX;
                    if (cVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = cVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.mOverflingDistance, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) cVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                cVar.abortAnimation();
                                start(currVelocity);
                                return;
                            }
                            Gx();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.aZK.postOnAnimation(this);
                        return;
                    }
                    Gy();
                    return;
            }
            if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.mItemCount == 0 || AbsHListView.this.getChildCount() == 0) {
                Gy();
                return;
            }
            com.baidu.live.tieba.horizonallist.widget.c cVar2 = this.aZX;
            boolean computeScrollOffset = cVar2.computeScrollOffset();
            int currX2 = cVar2.getCurrX();
            int i = this.mLastFlingX - currX2;
            if (i > 0) {
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition;
                AbsHListView.this.mMotionViewOriginalLeft = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition + childCount;
                AbsHListView.this.mMotionViewOriginalLeft = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean trackMotionScroll = AbsHListView.this.trackMotionScroll(max, max);
            if (!trackMotionScroll || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.mOverflingDistance, 0, false);
                }
                if (computeScrollOffset) {
                    cJ(max);
                }
            } else if (computeScrollOffset && !z) {
                if (trackMotionScroll) {
                    AbsHListView.this.invalidate();
                }
                this.mLastFlingX = currX2;
                AbsHListView.this.aZK.postOnAnimation(this);
            } else {
                Gy();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        private int bag;
        private int bah;
        private int bai;
        private int baj;
        private final int bak;
        private int bal;
        private int mMode;

        i() {
            this.bak = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        void start(int i) {
            stop();
            int childCount = (AbsHListView.this.getChildCount() + AbsHListView.this.mFirstPosition) - 1;
            if (i < AbsHListView.this.mFirstPosition) {
                this.mMode = 2;
            } else if (i > childCount) {
                this.mMode = 1;
            } else {
                m(i, -1, 200);
                return;
            }
            this.baj = 200;
            this.bag = i;
            this.bah = -1;
            this.bai = -1;
            AbsHListView.this.aZK.postOnAnimation(this);
        }

        void E(final int i, final int i2) {
            int i3;
            int i4;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.mPositionScrollAfterLayout = new Runnable() { // from class: com.baidu.live.tieba.horizonallist.widget.AbsHListView.i.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i.this.E(i, i2);
                    }
                };
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i5 = AbsHListView.this.mFirstPosition;
                    int i6 = (childCount + i5) - 1;
                    int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                    if (max < i5) {
                        int i7 = i6 - i2;
                        if (i7 >= 1) {
                            i3 = (i5 - max) + 1;
                            i4 = i7 - 1;
                            if (i4 < i3) {
                                this.mMode = 4;
                            } else {
                                this.mMode = 2;
                                i4 = i3;
                            }
                        } else {
                            return;
                        }
                    } else if (max > i6) {
                        int i8 = i2 - i5;
                        if (i8 >= 1) {
                            i3 = (max - i6) + 1;
                            i4 = i8 - 1;
                            if (i4 < i3) {
                                this.mMode = 3;
                            } else {
                                this.mMode = 1;
                                i4 = i3;
                            }
                        } else {
                            return;
                        }
                    } else {
                        m(max, i2, 200);
                        return;
                    }
                    if (i4 > 0) {
                        this.baj = 200 / i4;
                    } else {
                        this.baj = 200;
                    }
                    this.bag = max;
                    this.bah = i2;
                    this.bai = -1;
                    AbsHListView.this.aZK.postOnAnimation(this);
                }
            }
        }

        void m(int i, int i2, int i3) {
            int i4 = AbsHListView.this.mFirstPosition;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.mListPadding.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.mListPadding.right;
            i2 = (i2 < i4 || i2 > childCount) ? -1 : -1;
            View childAt = AbsHListView.this.getChildAt(i - i4);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int i6 = right > width ? right - width : 0;
            if (left < i5) {
                i6 = left - i5;
            }
            if (i6 != 0) {
                if (i2 >= 0) {
                    View childAt2 = AbsHListView.this.getChildAt(i2 - i4);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    int abs = Math.abs(i6);
                    if (i6 < 0 && right2 + abs > width) {
                        i6 = Math.max(0, right2 - width);
                    } else if (i6 > 0 && left2 - abs < i5) {
                        i6 = Math.min(0, left2 - i5);
                    }
                }
                AbsHListView.this.smoothScrollBy(i6, i3);
            }
        }

        public void stop() {
            AbsHListView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int left;
            int i = 0;
            int width = AbsHListView.this.getWidth();
            int i2 = AbsHListView.this.mFirstPosition;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    if (childCount >= 0) {
                        int i3 = i2 + childCount;
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.smoothScrollBy((i3 < AbsHListView.this.mItemCount + (-1) ? Math.max(AbsHListView.this.mListPadding.right, this.bak) : AbsHListView.this.mListPadding.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.baj, true);
                        this.bai = i3;
                        if (i3 < this.bag) {
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.bai) {
                        AbsHListView.this.aZK.postOnAnimation(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.smoothScrollBy(childAt2.getLeft() - (i2 > 0 ? Math.max(this.bak, AbsHListView.this.mListPadding.left) : AbsHListView.this.mListPadding.left), this.baj, true);
                        this.bai = i2;
                        if (i2 > this.bag) {
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.bah && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.mItemCount) {
                        int i4 = i2 + 1;
                        if (i4 == this.bai) {
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.mListPadding.right, this.bak);
                        if (i4 < this.bah) {
                            AbsHListView.this.smoothScrollBy(Math.max(0, (left2 + width2) - max), this.baj, true);
                            this.bai = i4;
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.smoothScrollBy(left2 - max, this.baj, true);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 4:
                    int childCount3 = AbsHListView.this.getChildCount() - 2;
                    if (childCount3 >= 0) {
                        int i5 = i2 + childCount3;
                        if (i5 == this.bai) {
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.mListPadding.left, this.bak);
                        this.bai = i5;
                        if (i5 > this.bah) {
                            AbsHListView.this.smoothScrollBy(-(i6 - max2), this.baj, true);
                            AbsHListView.this.aZK.postOnAnimation(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.smoothScrollBy(-(i7 - i8), this.baj, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.bai == i2) {
                        AbsHListView.this.aZK.postOnAnimation(this);
                        return;
                    }
                    this.bai = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.bag;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.smoothScrollBy((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.baj), true);
                        AbsHListView.this.aZK.postOnAnimation(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.smoothScrollBy((int) (AbsHListView.this.getWidth() * min), (int) (min * this.baj), true);
                        AbsHListView.this.aZK.postOnAnimation(this);
                        return;
                    } else {
                        AbsHListView.this.smoothScrollBy(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.bal, (int) (this.baj * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.aZN == null) {
            this.aZN = new e();
        }
        this.aZN.aZX.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.mVelocityScale = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.aZO == null) {
            this.aZO = new i();
        }
        this.aZO.E(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, false);
    }

    public void smoothScrollBy(int i2, int i3, boolean z) {
        if (this.aZN == null) {
            this.aZN = new e();
        }
        int i4 = this.mFirstPosition;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.mItemCount == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.mItemCount && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.aZN.Gy();
            if (this.aZO != null) {
                this.aZO.stop();
                return;
            }
            return;
        }
        reportScrollStateChange(2);
        this.aZN.e(i2, i3, z);
    }

    private void createScrollingCache() {
        if (this.mScrollingCacheEnabled && !this.mCachingStarted && !this.aZK.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.mCachingActive = true;
            this.mCachingStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (!this.aZK.isHardwareAccelerated()) {
            if (this.mClearScrollingCache == null) {
                this.mClearScrollingCache = new Runnable() { // from class: com.baidu.live.tieba.horizonallist.widget.AbsHListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AbsHListView.this.mCachingStarted) {
                            AbsHListView absHListView = AbsHListView.this;
                            AbsHListView.this.mCachingActive = false;
                            absHListView.mCachingStarted = false;
                            AbsHListView.this.setChildrenDrawnWithCacheEnabled(false);
                            if ((AbsHListView.this.getPersistentDrawingCache() & 2) == 0) {
                                AbsHListView.this.setChildrenDrawingCacheEnabled(false);
                            }
                            if (!AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                                AbsHListView.this.invalidate();
                            }
                        }
                    }
                };
            }
            post(this.mClearScrollingCache);
        }
    }

    boolean trackMotionScroll(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.mListPadding;
        int i5 = 0 - left;
        int width = right - (getWidth() - 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (i2 < 0) {
            min = Math.max(-(width2 - 1), i2);
        } else {
            min = Math.min(width2 - 1, i2);
        }
        if (i3 < 0) {
            min2 = Math.max(-(width2 - 1), i3);
        } else {
            min2 = Math.min(width2 - 1, i3);
        }
        int i6 = this.mFirstPosition;
        if (i6 == 0) {
            this.mFirstPositionDistanceGuess = left - rect.left;
        } else {
            this.mFirstPositionDistanceGuess += min2;
        }
        if (i6 + childCount == this.mItemCount) {
            this.mLastPositionDistanceGuess = rect.right + right;
        } else {
            this.mLastPositionDistanceGuess += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            hideSelector();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        int i7 = 0;
        if (z3) {
            int i8 = -min2;
            i4 = 0;
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = getChildAt(i9);
                if (childAt.getRight() >= i8) {
                    break;
                }
                int i10 = i4 + 1;
                int i11 = i6 + i9;
                if (i11 >= headerViewsCount && i11 < footerViewsCount) {
                    this.aZM.d(childAt, i11);
                }
                i9++;
                i4 = i10;
            }
        } else {
            int width3 = getWidth() - min2;
            i4 = 0;
            for (int i12 = childCount - 1; i12 >= 0; i12--) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getLeft() <= width3) {
                    break;
                }
                int i13 = i4 + 1;
                int i14 = i6 + i12;
                if (i14 >= headerViewsCount && i14 < footerViewsCount) {
                    this.aZM.d(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.mMotionViewNewLeft = this.mMotionViewOriginalLeft + min;
        this.mBlockLayoutRequests = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.aZM.GC();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        offsetChildrenLeftAndRight(min2);
        if (z3) {
            this.mFirstPosition = i4 + this.mFirstPosition;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && this.mSelectedPosition != -1) {
            int i15 = this.mSelectedPosition - this.mFirstPosition;
            if (i15 >= 0 && i15 < getChildCount()) {
                positionSelector(this.mSelectedPosition, getChildAt(i15));
            }
        } else if (this.mSelectorPosition != -1) {
            int i16 = this.mSelectorPosition - this.mFirstPosition;
            if (i16 >= 0 && i16 < getChildCount()) {
                positionSelector(-1, getChildAt(i16));
            }
        } else {
            this.mSelectorRect.setEmpty();
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    public void offsetChildrenLeftAndRight(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).offsetLeftAndRight(i2);
        }
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideSelector() {
        if (this.mSelectedPosition != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
            if (this.mNextSelectedPosition >= 0 && this.mNextSelectedPosition != this.mSelectedPosition) {
                this.mResurrectToPosition = this.mNextSelectedPosition;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedLeft = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reconcileSelectedPosition() {
        int i2 = this.mSelectedPosition;
        if (i2 < 0) {
            i2 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i2), this.mItemCount - 1);
    }

    protected int findClosestMotionCol(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int findMotionCol = findMotionCol(i2);
        return findMotionCol == -1 ? (this.mFirstPosition + childCount) - 1 : findMotionCol;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition >= 0 || !resurrectSelection()) {
            return false;
        }
        updateSelectorState();
        return true;
    }

    boolean resurrectSelection() {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int i9 = this.mListPadding.left;
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        int i10 = this.mFirstPosition;
        int i11 = this.mResurrectToPosition;
        if (i11 >= i10 && i11 < i10 + childCount) {
            View childAt = getChildAt(i11 - this.mFirstPosition);
            int left = childAt.getLeft();
            int right2 = childAt.getRight();
            if (left < i9) {
                left = getHorizontalFadingEdgeLength() + i9;
            } else if (right2 > right) {
                left = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
            }
            i2 = left;
            z = true;
        } else if (i11 >= i10) {
            int i12 = this.mItemCount;
            int i13 = (i10 + childCount) - 1;
            int i14 = childCount - 1;
            i2 = 0;
            while (true) {
                if (i14 < 0) {
                    i11 = i13;
                    z = false;
                    break;
                }
                View childAt2 = getChildAt(i14);
                int left2 = childAt2.getLeft();
                int right3 = childAt2.getRight();
                if (i14 != childCount - 1) {
                    int i15 = right;
                    i3 = i2;
                    i4 = i15;
                } else if (i10 + childCount < i12 || right3 > right) {
                    i4 = right - getHorizontalFadingEdgeLength();
                    i3 = left2;
                } else {
                    i4 = right;
                    i3 = left2;
                }
                if (right3 > i4) {
                    i14--;
                    int i16 = i4;
                    i2 = i3;
                    right = i16;
                } else {
                    i2 = left2;
                    i11 = i10 + i14;
                    z = false;
                    break;
                }
            }
        } else {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 >= childCount) {
                    i5 = i18;
                    i6 = i10;
                    break;
                }
                i5 = getChildAt(i17).getLeft();
                if (i17 != 0) {
                    int i19 = i9;
                    i7 = i18;
                    i8 = i19;
                } else if (i10 > 0 || i5 < i9) {
                    i8 = getHorizontalFadingEdgeLength() + i9;
                    i7 = i5;
                } else {
                    i8 = i9;
                    i7 = i5;
                }
                if (i5 >= i8) {
                    i6 = i10 + i17;
                    break;
                }
                i17++;
                int i20 = i8;
                i18 = i7;
                i9 = i20;
            }
            i2 = i5;
            i11 = i6;
            z = true;
        }
        this.mResurrectToPosition = -1;
        removeCallbacks(this.aZN);
        if (this.aZO != null) {
            this.aZO.stop();
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.mSpecificLeft = i2;
        int lookForSelectablePosition = lookForSelectablePosition(i11, z);
        if (lookForSelectablePosition < i10 || lookForSelectablePosition > getLastVisiblePosition()) {
            lookForSelectablePosition = -1;
        } else {
            this.mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
        }
        reportScrollStateChange(0);
        return lookForSelectablePosition >= 0;
    }

    void confirmCheckedPositionsById() {
        boolean z;
        this.mCheckStates.clear();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mCheckedIdStates.size()) {
            long keyAt = this.mCheckedIdStates.keyAt(i2);
            int intValue = this.mCheckedIdStates.valueAt(i2).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.mCheckStates.put(max, true);
                        this.mCheckedIdStates.setValueAt(i2, Integer.valueOf(max));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.mCheckedIdStates.delete(keyAt);
                    int i3 = i2 - 1;
                    this.mCheckedItemCount--;
                    if (Build.VERSION.SDK_INT > 11 && this.mChoiceActionMode != null && this.mMultiChoiceModeCallback != null) {
                        ((com.baidu.live.tieba.horizonallist.a.a.b) this.mMultiChoiceModeCallback).a((ActionMode) this.mChoiceActionMode, intValue, keyAt, false);
                    }
                    i2 = i3;
                    z2 = true;
                }
            } else {
                this.mCheckStates.put(intValue, true);
            }
            z2 = z2;
            i2++;
        }
        if (z2 && this.mChoiceActionMode != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.mChoiceActionMode).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView
    public void handleDataChanged() {
        int i2 = this.mItemCount;
        int i3 = this.mLastHandledItemCount;
        this.mLastHandledItemCount = this.mItemCount;
        if (this.mChoiceMode != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.aZM.GB();
        if (i2 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.aZU = null;
                if (this.mTranscriptMode == 2) {
                    this.mLayoutMode = 3;
                    return;
                }
                if (this.mTranscriptMode == 1) {
                    if (this.mForceTranscriptScroll) {
                        this.mForceTranscriptScroll = false;
                        this.mLayoutMode = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.mFirstPosition >= i3 && bottom <= width) {
                        this.mLayoutMode = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.mSyncMode) {
                    case 1:
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                            return;
                        }
                        int findSyncPosition = findSyncPosition();
                        if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                            this.mSyncPosition = findSyncPosition;
                            if (this.mSyncWidth == getWidth()) {
                                this.mLayoutMode = 5;
                            } else {
                                this.mLayoutMode = 2;
                            }
                            setNextSelectedPositionInt(findSyncPosition);
                            return;
                        }
                        break;
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i2) {
                    selectedItemPosition = i2 - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(selectedItemPosition, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = this.mStackFromRight ? 3 : 1;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.aZU = null;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    public static int getDistance(Rect rect, Rect rect2, int i2) {
        int width;
        int height;
        int width2;
        int height2;
        switch (i2) {
            case 1:
            case 2:
                width = rect.right + (rect.width() / 2);
                height = rect.top + (rect.height() / 2);
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 17:
                width = rect.left;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        int i3 = width2 - width;
        int i4 = height2 - height;
        return (i4 * i4) + (i3 * i3);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -1, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setTranscriptMode(int i2) {
        this.mTranscriptMode = i2;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.mCacheColorHint) {
            this.mCacheColorHint = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.aZM.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    private void finishGlows() {
        if (this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisibleRangeHint(int i2, int i3) {
    }

    public void setRecyclerListener(k kVar) {
        this.aZM.bao = kVar;
    }

    /* loaded from: classes3.dex */
    public class a extends AdapterView<ListAdapter>.b {
        public a() {
            super();
        }

        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.b, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.b, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int baa;
        public boolean bab;
        public boolean bac;
        public int bad;
        public long bae;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bae = -1L;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.bae = -1L;
            this.baa = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bae = -1L;
        }
    }

    /* loaded from: classes3.dex */
    public class j {
        private k bao;
        private int bap;
        private View[] baq = new View[0];
        private ArrayList<View>[] bar;
        private int bas;
        private ArrayList<View> bat;
        private ArrayList<View> bau;
        private SparseArrayCompat<View> bav;

        public j() {
        }

        public void cK(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.bas = i;
            this.bat = arrayListArr[0];
            this.bar = arrayListArr;
        }

        public void GA() {
            if (this.bas == 1) {
                ArrayList<View> arrayList = this.bat;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.bas;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bar[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.bav != null) {
                int size3 = this.bav.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.bav.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean cL(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.bas == 1) {
                ArrayList<View> arrayList = this.bat;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.bas;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bar[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.bav != null) {
                this.bav.clear();
            }
        }

        public void F(int i, int i2) {
            if (this.baq.length < i) {
                this.baq = new View[i];
            }
            this.bap = i2;
            View[] viewArr = this.baq;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.baa != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View cM(int i) {
            int i2 = i - this.bap;
            View[] viewArr = this.baq;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View cN(int i) {
            int indexOfKey;
            if (this.bav != null && (indexOfKey = this.bav.indexOfKey(i)) >= 0) {
                View valueAt = this.bav.valueAt(indexOfKey);
                this.bav.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void GB() {
            if (this.bav != null) {
                this.bav.clear();
            }
        }

        View cO(int i) {
            if (this.bas == 1) {
                return AbsHListView.retrieveFromScrap(this.bat, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.bar.length) {
                return AbsHListView.retrieveFromScrap(this.bar[itemViewType], i);
            }
            return null;
        }

        @SuppressLint({"NewApi"})
        public void d(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bad = i;
                int i2 = layoutParams.baa;
                if (!cL(i2)) {
                    if (i2 != -2) {
                        if (this.bau == null) {
                            this.bau = new ArrayList<>();
                        }
                        this.bau.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.bas == 1) {
                    this.bat.add(view);
                } else {
                    this.bar[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.bao != null) {
                    this.bao.onMovedToScrapHeap(view);
                }
            }
        }

        public void GC() {
            if (this.bau != null) {
                int size = this.bau.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.bau.get(i), false);
                }
                this.bau.clear();
            }
        }

        @SuppressLint({"NewApi"})
        public void GD() {
            View[] viewArr = this.baq;
            boolean z = this.bao != null;
            boolean z2 = this.bas > 1;
            ArrayList<View> arrayList = this.bat;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.baa;
                    viewArr[length] = null;
                    if (!cL(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.bar[i];
                        }
                        view.onStartTemporaryDetach();
                        layoutParams.bad = this.bap + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.bao.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            GE();
        }

        @SuppressLint({"NewApi"})
        private void GE() {
            int length = this.baq.length;
            int i = this.bas;
            ArrayList<View>[] arrayListArr = this.bar;
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<View> arrayList = arrayListArr[i2];
                int size = arrayList.size();
                int i3 = size - length;
                int i4 = size - 1;
                int i5 = 0;
                while (i5 < i3) {
                    AbsHListView.this.removeDetachedView(arrayList.remove(i4), false);
                    i5++;
                    i4--;
                }
            }
            if (this.bav != null) {
                for (int i6 = 0; i6 < this.bav.size(); i6++) {
                    this.bav.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bas == 1) {
                ArrayList<View> arrayList = this.bat;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bas;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.bar[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.baq) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }
    }

    static View retrieveFromScrap(ArrayList<View> arrayList, int i2) {
        int size = arrayList.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                View view = arrayList.get(i3);
                if (((LayoutParams) view.getLayoutParams()).bad == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
