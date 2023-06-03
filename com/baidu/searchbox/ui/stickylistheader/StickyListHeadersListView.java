package com.baidu.searchbox.ui.stickylistheader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.searchbox.ui.stickylistheader.IndexWrapperListView;
import com.baidu.searchbox.ui.stickylistheader.StickyAdapterWrapper;
import com.baidu.searchbox.ui.stickylistheader.WrapperViewList;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class StickyListHeadersListView extends FrameLayout {
    public static final String TAG = "StickyListHeaders";
    public StickyAdapterWrapper mAdapter;
    public boolean mAreHeadersSticky;
    public boolean mClippingToPadding;
    public AdapterWrapperDataSetObserver mDataSetObserver;
    public Drawable mDivider;
    public int mDividerHeight;
    public float mDownY;
    public View mHeader;
    public Long mHeaderId;
    public Integer mHeaderOffset;
    public boolean mHeaderOwnsTouch;
    public Integer mHeaderPosition;
    public boolean mIsDrawingListUnderStickyHeader;
    public IndexWrapperListView mList;
    public OnHeaderClickListener mOnHeaderClickListener;
    public AbsListView.OnScrollListener mOnScrollListenerDelegate;
    public OnStickyHeaderChangedListener mOnStickyHeaderChangedListener;
    public OnStickyHeaderOffsetChangedListener mOnStickyHeaderOffsetChangedListener;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public int mStickyHeaderTopOffset;
    public float mTouchSlop;

    /* loaded from: classes4.dex */
    public interface OnHeaderClickListener {
        void onHeaderClick(StickyListHeadersListView stickyListHeadersListView, View view2, int i, long j, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface OnStickyHeaderChangedListener {
        void onStickyHeaderChanged(StickyListHeadersListView stickyListHeadersListView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface OnStickyHeaderOffsetChangedListener {
        void onStickyHeaderOffsetChanged(StickyListHeadersListView stickyListHeadersListView, View view2, int i);
    }

    /* loaded from: classes4.dex */
    public class AdapterWrapperDataSetObserver extends DataSetObserver {
        public AdapterWrapperDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            StickyListHeadersListView.this.clearHeader();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            StickyListHeadersListView.this.clearHeader();
        }
    }

    /* loaded from: classes4.dex */
    public class AdapterWrapperHeaderClickHandler implements StickyAdapterWrapper.OnHeaderClickListener {
        public AdapterWrapperHeaderClickHandler() {
        }

        @Override // com.baidu.searchbox.ui.stickylistheader.StickyAdapterWrapper.OnHeaderClickListener
        public void onHeaderClick(View view2, int i, long j) {
            StickyListHeadersListView.this.mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, view2, i, j, false);
        }
    }

    /* loaded from: classes4.dex */
    public class WrapperListScrollListener implements AbsListView.OnScrollListener {
        public WrapperListScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (StickyListHeadersListView.this.mOnScrollListenerDelegate != null) {
                StickyListHeadersListView.this.mOnScrollListenerDelegate.onScrollStateChanged(absListView, i);
            }
            StickyListHeadersListView.this.mList.onScrollStateChanged(absListView, i);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (StickyListHeadersListView.this.mOnScrollListenerDelegate != null) {
                StickyListHeadersListView.this.mOnScrollListenerDelegate.onScroll(absListView, i, i2, i3);
            }
            StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
            stickyListHeadersListView.updateOrClearHeader(stickyListHeadersListView.mList.getFixedFirstVisibleItem());
        }
    }

    /* loaded from: classes4.dex */
    public class WrapperViewListLifeCycleListener implements WrapperViewList.LifeCycleListener {
        public WrapperViewListLifeCycleListener() {
        }

        @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList.LifeCycleListener
        @SuppressLint({"ObsoleteSdkInt"})
        public void onDispatchDrawOccurred(Canvas canvas) {
            if (Build.VERSION.SDK_INT < 8) {
                StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                stickyListHeadersListView.updateOrClearHeader(stickyListHeadersListView.mList.getFixedFirstVisibleItem());
            }
            if (StickyListHeadersListView.this.mHeader != null) {
                if (StickyListHeadersListView.this.mClippingToPadding) {
                    canvas.save();
                    canvas.clipRect(0, StickyListHeadersListView.this.mPaddingTop, StickyListHeadersListView.this.getRight(), StickyListHeadersListView.this.getBottom());
                    StickyListHeadersListView stickyListHeadersListView2 = StickyListHeadersListView.this;
                    stickyListHeadersListView2.drawChild(canvas, stickyListHeadersListView2.mHeader, 0L);
                    canvas.restore();
                    return;
                }
                StickyListHeadersListView stickyListHeadersListView3 = StickyListHeadersListView.this;
                stickyListHeadersListView3.drawChild(canvas, stickyListHeadersListView3.mHeader, 0L);
            }
        }
    }

    public StickyListHeadersListView(Context context) {
        this(context, null);
    }

    private void ensureHeaderHasCorrectLayoutParams(View view2) {
        if (view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        } else if (layoutParams.height == -1 || layoutParams.width == -2) {
            layoutParams.height = -2;
            layoutParams.width = -1;
            view2.setLayoutParams(layoutParams);
        }
    }

    private boolean isStartOfSection(int i) {
        if (i == 0 || this.mAdapter.getHeaderId(i) != this.mAdapter.getHeaderId(i - 1)) {
            return true;
        }
        return false;
    }

    private void measureHeader(View view2) {
        if (view2 != null) {
            measureChild(view2, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.mPaddingLeft) - this.mPaddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    private boolean requireSdkVersion(int i) {
        if (Build.VERSION.SDK_INT < i) {
            Log.e(TAG, "Api lvl must be at least " + i + " to call this method");
            return false;
        }
        return true;
    }

    private void swapHeader(View view2) {
        View view3 = this.mHeader;
        if (view3 != null) {
            removeView(view3);
        }
        this.mHeader = view2;
        addView(view2);
        if (this.mOnHeaderClickListener != null) {
            this.mHeader.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyListHeadersListView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    OnHeaderClickListener onHeaderClickListener = StickyListHeadersListView.this.mOnHeaderClickListener;
                    StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                    onHeaderClickListener.onHeaderClick(stickyListHeadersListView, stickyListHeadersListView.mHeader, StickyListHeadersListView.this.mHeaderPosition.intValue(), StickyListHeadersListView.this.mHeaderId.longValue(), true);
                }
            });
        }
        this.mHeader.setClickable(true);
    }

    public void addFooterView(View view2) {
        this.mList.addFooterView(view2);
    }

    public void addHeaderView(View view2) {
        this.mList.addHeaderView(view2);
    }

    @Override // android.view.View
    @TargetApi(14)
    public boolean canScrollVertically(int i) {
        return this.mList.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.mList.getVisibility() == 0 || this.mList.getAnimation() != null) {
            drawChild(canvas, this.mList, 0L);
        }
    }

    public int getHeaderOverlap(int i) {
        if (isStartOfSection(Math.max(0, i - getHeaderViewsCount()))) {
            return 0;
        }
        View headerView = this.mAdapter.getHeaderView(i, null, this.mList);
        if (headerView == null) {
            Log.e(TAG, "header may not be null");
            return 0;
        }
        ensureHeaderHasCorrectLayoutParams(headerView);
        measureHeader(headerView);
        return headerView.getMeasuredHeight();
    }

    public Object getItemAtPosition(int i) {
        return this.mList.getItemAtPosition(i);
    }

    public long getItemIdAtPosition(int i) {
        return this.mList.getItemIdAtPosition(i);
    }

    public View getListChildAt(int i) {
        return this.mList.getChildAt(i);
    }

    public View getListViewChildAt(int i) {
        return this.mList.getChildAt(i);
    }

    public int getPositionForView(View view2) {
        return this.mList.getPositionForView(view2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mList.onRestoreInstanceState(savedState.wrappedState);
    }

    public void removeFooterView(View view2) {
        this.mList.removeFooterView(view2);
    }

    public void removeHeaderView(View view2) {
        this.mList.removeHeaderView(view2);
    }

    public void setAreHeadersSticky(boolean z) {
        this.mAreHeadersSticky = z;
        if (!z) {
            clearHeader();
        } else {
            updateOrClearHeader(this.mList.getFixedFirstVisibleItem());
        }
        this.mList.invalidate();
    }

    public void setBlockLayoutChildren(boolean z) {
        this.mList.setBlockLayoutChildren(z);
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        this.mList.setChoiceMode(i);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        IndexWrapperListView indexWrapperListView = this.mList;
        if (indexWrapperListView != null) {
            indexWrapperListView.setClipToPadding(z);
        }
        this.mClippingToPadding = z;
    }

    public void setDivider(Drawable drawable) {
        this.mDivider = drawable;
        StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
        if (stickyAdapterWrapper != null) {
            stickyAdapterWrapper.setDivider(drawable, this.mDividerHeight);
        }
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
        if (stickyAdapterWrapper != null) {
            stickyAdapterWrapper.setDivider(this.mDivider, i);
        }
    }

    public void setDrawingListUnderStickyHeader(boolean z) {
        this.mIsDrawingListUnderStickyHeader = z;
        this.mList.setTopClippingLength(0);
    }

    public void setEmptyView(View view2) {
        this.mList.setEmptyView(view2);
    }

    @TargetApi(11)
    public void setFastScrollAlwaysVisible(boolean z) {
        if (requireSdkVersion(11)) {
            this.mList.setFastScrollAlwaysVisible(z);
        }
    }

    public void setFastScrollEnabled(boolean z) {
        this.mList.setFastScrollEnabled(z);
    }

    public void setHasMoreData(boolean z) {
        this.mList.setHasMoreData(z);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.mList.setHorizontalScrollBarEnabled(z);
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener multiChoiceModeListener) {
        if (requireSdkVersion(11)) {
            this.mList.setMultiChoiceModeListener(multiChoiceModeListener);
        }
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        this.mList.setOnCreateContextMenuListener(onCreateContextMenuListener);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
        StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
        if (stickyAdapterWrapper != null) {
            if (onHeaderClickListener != null) {
                stickyAdapterWrapper.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler());
                View view2 = this.mHeader;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyListHeadersListView.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            OnHeaderClickListener onHeaderClickListener2 = StickyListHeadersListView.this.mOnHeaderClickListener;
                            StickyListHeadersListView stickyListHeadersListView = StickyListHeadersListView.this;
                            onHeaderClickListener2.onHeaderClick(stickyListHeadersListView, stickyListHeadersListView.mHeader, StickyListHeadersListView.this.mHeaderPosition.intValue(), StickyListHeadersListView.this.mHeaderId.longValue(), true);
                        }
                    });
                    return;
                }
                return;
            }
            stickyAdapterWrapper.setOnHeaderClickListener(null);
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mList.setOnItemClickListener(onItemClickListener);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mList.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setOnRefreshListener(IndexWrapperListView.OnRefreshListener onRefreshListener) {
        this.mList.setOnRefreshListener(onRefreshListener);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListenerDelegate = onScrollListener;
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener onStickyHeaderChangedListener) {
        this.mOnStickyHeaderChangedListener = onStickyHeaderChangedListener;
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener) {
        this.mOnStickyHeaderOffsetChangedListener = onStickyHeaderOffsetChangedListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(final View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.mList.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyListHeadersListView.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return onTouchListener.onTouch(StickyListHeadersListView.this, motionEvent);
                }
            });
        } else {
            this.mList.setOnTouchListener(null);
        }
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i) {
        IndexWrapperListView indexWrapperListView;
        if (requireSdkVersion(9) && (indexWrapperListView = this.mList) != null) {
            indexWrapperListView.setOverScrollMode(i);
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        this.mList.setScrollBarStyle(i);
    }

    public void setScrollLoadEnabled(boolean z) {
        this.mList.setScrollLoadEnabled(z);
    }

    public void setSelection(int i) {
        setSelectionFromTop(i, 0);
    }

    public void setSelector(int i) {
        this.mList.setSelector(i);
    }

    public void setStackFromBottom(boolean z) {
        this.mList.setStackFromBottom(z);
    }

    public void setStickyHeaderTopOffset(int i) {
        this.mStickyHeaderTopOffset = i;
        updateOrClearHeader(this.mList.getFixedFirstVisibleItem());
    }

    public void setTranscriptMode(int i) {
        this.mList.setTranscriptMode(i);
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        this.mList.setVerticalScrollBarEnabled(z);
    }

    @TargetApi(11)
    public void smoothScrollByOffset(int i) {
        if (requireSdkVersion(11)) {
            this.mList.smoothScrollByOffset(i);
        }
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt"})
    @TargetApi(8)
    public void smoothScrollToPosition(int i) {
        int headerOverlap;
        if (requireSdkVersion(8)) {
            if (Build.VERSION.SDK_INT < 11) {
                this.mList.smoothScrollToPosition(i);
                return;
            }
            int i2 = 0;
            if (this.mAdapter == null) {
                headerOverlap = 0;
            } else {
                headerOverlap = getHeaderOverlap(i);
            }
            if (!this.mClippingToPadding) {
                i2 = this.mPaddingTop;
            }
            this.mList.smoothScrollToPositionFromTop(i, headerOverlap - i2);
        }
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.ui.stickylistheader.StickyListHeadersListView.SavedState.1
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
        public Parcelable wrappedState;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.wrappedState = parcel.readParcelable(SavedState.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.wrappedState, i);
        }

        public SavedState(Parcelable parcelable, Parcelable parcelable2) {
            super(parcelable);
            this.wrappedState = parcelable2;
        }
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0406c3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureHeader(this.mHeader);
    }

    @TargetApi(11)
    public void setItemChecked(int i, boolean z) {
        this.mList.setItemChecked(i, z);
    }

    public void setSelectionFromTop(int i, int i2) {
        int headerOverlap;
        int i3 = 0;
        if (this.mAdapter == null) {
            headerOverlap = 0;
        } else {
            headerOverlap = getHeaderOverlap(i);
        }
        int i4 = i2 + headerOverlap;
        if (!this.mClippingToPadding) {
            i3 = this.mPaddingTop;
        }
        this.mList.setSelectionFromTop(i, i4 - i3);
    }

    @TargetApi(8)
    public void smoothScrollBy(int i, int i2) {
        if (requireSdkVersion(8)) {
            this.mList.smoothScrollBy(i, i2);
        }
    }

    @TargetApi(8)
    public void smoothScrollToPosition(int i, int i2) {
        if (requireSdkVersion(8)) {
            this.mList.smoothScrollToPosition(i, i2);
        }
    }

    @TargetApi(11)
    public void smoothScrollToPositionFromTop(int i, int i2) {
        int headerOverlap;
        if (requireSdkVersion(11)) {
            int i3 = 0;
            if (this.mAdapter == null) {
                headerOverlap = 0;
            } else {
                headerOverlap = getHeaderOverlap(i);
            }
            int i4 = i2 + headerOverlap;
            if (!this.mClippingToPadding) {
                i3 = this.mPaddingTop;
            }
            this.mList.smoothScrollToPositionFromTop(i, i4 - i3);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public StickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        boolean z2;
        this.mAreHeadersSticky = true;
        this.mClippingToPadding = true;
        this.mIsDrawingListUnderStickyHeader = true;
        this.mStickyHeaderTopOffset = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        IndexWrapperListView indexWrapperListView = new IndexWrapperListView(context);
        this.mList = indexWrapperListView;
        this.mDivider = indexWrapperListView.getDivider();
        this.mDividerHeight = this.mList.getDividerHeight();
        this.mList.setDivider(null);
        this.mList.setDividerHeight(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.StickyListHeadersListView, i, 0);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                this.mPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
                this.mPaddingTop = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
                this.mPaddingRight = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
                this.mPaddingBottom = dimensionPixelSize2;
                setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, dimensionPixelSize2);
                this.mClippingToPadding = obtainStyledAttributes.getBoolean(8, true);
                super.setClipToPadding(true);
                this.mList.setClipToPadding(this.mClippingToPadding);
                int i2 = obtainStyledAttributes.getInt(6, 512);
                IndexWrapperListView indexWrapperListView2 = this.mList;
                if ((i2 & 512) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                indexWrapperListView2.setVerticalScrollBarEnabled(z);
                IndexWrapperListView indexWrapperListView3 = this.mList;
                if ((i2 & 256) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                indexWrapperListView3.setHorizontalScrollBarEnabled(z2);
                if (Build.VERSION.SDK_INT >= 9) {
                    this.mList.setOverScrollMode(obtainStyledAttributes.getInt(19, 0));
                }
                this.mList.setFadingEdgeLength(obtainStyledAttributes.getDimensionPixelSize(7, this.mList.getVerticalFadingEdgeLength()));
                int i3 = obtainStyledAttributes.getInt(21, 0);
                if (i3 == 4096) {
                    this.mList.setVerticalFadingEdgeEnabled(false);
                    this.mList.setHorizontalFadingEdgeEnabled(true);
                } else if (i3 == 8192) {
                    this.mList.setVerticalFadingEdgeEnabled(true);
                    this.mList.setHorizontalFadingEdgeEnabled(false);
                } else {
                    this.mList.setVerticalFadingEdgeEnabled(false);
                    this.mList.setHorizontalFadingEdgeEnabled(false);
                }
                this.mList.setCacheColorHint(obtainStyledAttributes.getColor(14, this.mList.getCacheColorHint()));
                if (Build.VERSION.SDK_INT >= 11) {
                    this.mList.setChoiceMode(obtainStyledAttributes.getInt(17, this.mList.getChoiceMode()));
                }
                this.mList.setDrawSelectorOnTop(obtainStyledAttributes.getBoolean(10, false));
                this.mList.setFastScrollEnabled(obtainStyledAttributes.getBoolean(18, this.mList.isFastScrollEnabled()));
                if (Build.VERSION.SDK_INT >= 11) {
                    this.mList.setFastScrollAlwaysVisible(obtainStyledAttributes.getBoolean(20, this.mList.isFastScrollAlwaysVisible()));
                }
                this.mList.setScrollBarStyle(obtainStyledAttributes.getInt(0, 0));
                if (obtainStyledAttributes.hasValue(9)) {
                    this.mList.setSelector(obtainStyledAttributes.getDrawable(9));
                }
                this.mList.setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(12, this.mList.isScrollingCacheEnabled()));
                if (obtainStyledAttributes.hasValue(15)) {
                    this.mDivider = obtainStyledAttributes.getDrawable(15);
                }
                this.mList.setStackFromBottom(obtainStyledAttributes.getBoolean(11, false));
                this.mDividerHeight = obtainStyledAttributes.getDimensionPixelSize(16, this.mDividerHeight);
                this.mList.setTranscriptMode(obtainStyledAttributes.getInt(13, 0));
                this.mAreHeadersSticky = obtainStyledAttributes.getBoolean(22, true);
                this.mIsDrawingListUnderStickyHeader = obtainStyledAttributes.getBoolean(23, true);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.mList.setLifeCycleListener(new WrapperViewListLifeCycleListener());
        this.mList.setOnScrollListener(new WrapperListScrollListener());
        addView(this.mList);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
        IndexWrapperListView indexWrapperListView = this.mList;
        if (indexWrapperListView != null) {
            indexWrapperListView.setPadding(i, i2, i3, i4);
        }
        super.setPadding(0, 0, 0, 0);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeader() {
        View view2 = this.mHeader;
        if (view2 != null) {
            removeView(view2);
            this.mHeader = null;
            this.mHeaderId = null;
            this.mHeaderPosition = null;
            this.mHeaderOffset = null;
            this.mList.setTopClippingLength(0);
            updateHeaderVisibilities();
        }
    }

    private int stickyHeaderTop() {
        int i;
        int i2 = this.mStickyHeaderTopOffset;
        if (this.mClippingToPadding) {
            i = this.mPaddingTop;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public boolean areHeadersSticky() {
        return this.mAreHeadersSticky;
    }

    public StickyListHeadersAdapter getAdapter() {
        StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
        if (stickyAdapterWrapper == null) {
            return null;
        }
        return stickyAdapterWrapper.mDelegate;
    }

    @Deprecated
    public boolean getAreHeadersSticky() {
        return areHeadersSticky();
    }

    @TargetApi(11)
    public int getCheckedItemCount() {
        if (requireSdkVersion(11)) {
            return this.mList.getCheckedItemCount();
        }
        return 0;
    }

    @TargetApi(8)
    public long[] getCheckedItemIds() {
        if (requireSdkVersion(8)) {
            return this.mList.getCheckedItemIds();
        }
        return null;
    }

    @TargetApi(11)
    public int getCheckedItemPosition() {
        return this.mList.getCheckedItemPosition();
    }

    @TargetApi(11)
    public SparseBooleanArray getCheckedItemPositions() {
        return this.mList.getCheckedItemPositions();
    }

    public int getCount() {
        return this.mList.getCount();
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public View getEmptyView() {
        return this.mList.getEmptyView();
    }

    public int getFirstVisiblePosition() {
        return this.mList.getFirstVisiblePosition();
    }

    public int getFooterViewsCount() {
        return this.mList.getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return this.mList.getHeaderViewsCount();
    }

    public int getLastVisiblePosition() {
        return this.mList.getLastVisiblePosition();
    }

    public int getLisViewtChildCount() {
        return this.mList.getChildCount();
    }

    public int getListChildCount() {
        return this.mList.getChildCount();
    }

    @Override // android.view.View
    @TargetApi(9)
    public int getOverScrollMode() {
        if (requireSdkVersion(9)) {
            return this.mList.getOverScrollMode();
        }
        return 0;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        return this.mList.getScrollBarStyle();
    }

    public int getStickyHeaderTopOffset() {
        return this.mStickyHeaderTopOffset;
    }

    public IndexWrapperListView getWrappedList() {
        return this.mList;
    }

    public void invalidateViews() {
        this.mList.invalidateViews();
    }

    public boolean isDrawingListUnderStickyHeader() {
        return this.mIsDrawingListUnderStickyHeader;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public boolean isFastScrollAlwaysVisible() {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        return this.mList.isFastScrollAlwaysVisible();
    }

    @Override // android.view.View
    public boolean isHorizontalScrollBarEnabled() {
        return this.mList.isHorizontalScrollBarEnabled();
    }

    public boolean isStackFromBottom() {
        return this.mList.isStackFromBottom();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        return this.mList.isVerticalScrollBarEnabled();
    }

    public void onLoadMoreComplete() {
        this.mList.onLoadMoreComplete();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mList.onSaveInstanceState());
    }

    public void recomputePadding() {
        setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    }

    public void setSelectionAfterHeaderView() {
        this.mList.setSelectionAfterHeaderView();
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        return this.mList.showContextMenu();
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt", "suppressNewApi"})
    private void setHeaderOffet(int i) {
        Integer num = this.mHeaderOffset;
        if (num == null || num.intValue() != i) {
            Integer valueOf = Integer.valueOf(i);
            this.mHeaderOffset = valueOf;
            if (Build.VERSION.SDK_INT >= 11) {
                this.mHeader.setTranslationY(valueOf.intValue());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mHeader.getLayoutParams();
                marginLayoutParams.topMargin = this.mHeaderOffset.intValue();
                this.mHeader.setLayoutParams(marginLayoutParams);
            }
            OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener = this.mOnStickyHeaderOffsetChangedListener;
            if (onStickyHeaderOffsetChangedListener != null) {
                onStickyHeaderOffsetChangedListener.onStickyHeaderOffsetChanged(this, this.mHeader, -this.mHeaderOffset.intValue());
            }
        }
    }

    public void setAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
        if (stickyListHeadersAdapter == null) {
            StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
            if (stickyAdapterWrapper != null) {
                stickyAdapterWrapper.mDelegate = null;
            }
            this.mList.setAdapter((ListAdapter) null);
            clearHeader();
            return;
        }
        StickyAdapterWrapper stickyAdapterWrapper2 = this.mAdapter;
        if (stickyAdapterWrapper2 != null) {
            stickyAdapterWrapper2.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mAdapter = new StickyAdapterWrapper(getContext(), stickyListHeadersAdapter);
        AdapterWrapperDataSetObserver adapterWrapperDataSetObserver = new AdapterWrapperDataSetObserver();
        this.mDataSetObserver = adapterWrapperDataSetObserver;
        this.mAdapter.registerDataSetObserver(adapterWrapperDataSetObserver);
        if (this.mOnHeaderClickListener != null) {
            this.mAdapter.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler());
        } else {
            this.mAdapter.setOnHeaderClickListener(null);
        }
        this.mAdapter.setDivider(this.mDivider, this.mDividerHeight);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        clearHeader();
    }

    private void updateHeader(int i) {
        boolean z;
        Integer num = this.mHeaderPosition;
        if (num == null || num.intValue() != i) {
            this.mHeaderPosition = Integer.valueOf(i);
            long headerId = this.mAdapter.getHeaderId(i);
            Long l = this.mHeaderId;
            if (l == null || l.longValue() != headerId) {
                this.mHeaderId = Long.valueOf(headerId);
                View headerView = this.mAdapter.getHeaderView(this.mHeaderPosition.intValue(), this.mHeader, this);
                if (this.mHeader != headerView) {
                    if (headerView == null) {
                        Log.e(TAG, "header may not be null");
                        return;
                    }
                    swapHeader(headerView);
                }
                ensureHeaderHasCorrectLayoutParams(this.mHeader);
                measureHeader(this.mHeader);
                OnStickyHeaderChangedListener onStickyHeaderChangedListener = this.mOnStickyHeaderChangedListener;
                if (onStickyHeaderChangedListener != null) {
                    onStickyHeaderChangedListener.onStickyHeaderChanged(this, this.mHeader, i, this.mHeaderId.longValue());
                }
                this.mHeaderOffset = null;
            }
        }
        if (this.mHeader == null) {
            return;
        }
        int stickyHeaderTop = stickyHeaderTop();
        for (int i2 = 0; i2 < this.mList.getChildCount(); i2++) {
            View childAt = this.mList.getChildAt(i2);
            if ((childAt instanceof WrapperView) && ((WrapperView) childAt).hasHeader()) {
                z = true;
            } else {
                z = false;
            }
            boolean containsFooterView = this.mList.containsFooterView(childAt);
            if (childAt.getTop() >= stickyHeaderTop() && (z || containsFooterView)) {
                stickyHeaderTop = Math.min(childAt.getTop() - this.mHeader.getMeasuredHeight(), stickyHeaderTop);
                break;
            }
        }
        setHeaderOffet(stickyHeaderTop);
        if (!this.mIsDrawingListUnderStickyHeader) {
            this.mList.setTopClippingLength(this.mHeader.getMeasuredHeight() + this.mHeaderOffset.intValue());
        }
        updateHeaderVisibilities();
    }

    private void updateHeaderVisibilities() {
        int stickyHeaderTop = stickyHeaderTop();
        int childCount = this.mList.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mList.getChildAt(i);
            if (childAt instanceof WrapperView) {
                WrapperView wrapperView = (WrapperView) childAt;
                if (wrapperView.hasHeader()) {
                    View view2 = wrapperView.mHeader;
                    if (wrapperView.getTop() < stickyHeaderTop) {
                        if (view2.getVisibility() != 4) {
                            view2.setVisibility(4);
                        }
                    } else if (view2.getVisibility() != 0) {
                        view2.setVisibility(0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrClearHeader(int i) {
        int count;
        boolean z;
        boolean z2;
        StickyAdapterWrapper stickyAdapterWrapper = this.mAdapter;
        boolean z3 = false;
        if (stickyAdapterWrapper == null) {
            count = 0;
        } else {
            count = stickyAdapterWrapper.getCount();
        }
        if (count != 0 && this.mAreHeadersSticky) {
            int headerViewsCount = i - this.mList.getHeaderViewsCount();
            if (this.mList.getChildCount() > 0 && this.mList.getChildAt(0).getBottom() < stickyHeaderTop()) {
                headerViewsCount++;
            }
            if (this.mList.getChildCount() != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.mList.getFirstVisiblePosition() == 0 && this.mList.getChildAt(0).getTop() >= stickyHeaderTop()) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = (headerViewsCount > count - 1 || headerViewsCount < 0) ? true : true;
            if (z && !z3 && !z2) {
                updateHeader(headerViewsCount);
            } else {
                clearHeader();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if ((motionEvent.getAction() & 255) == 0) {
            float y = motionEvent.getY();
            this.mDownY = y;
            View view2 = this.mHeader;
            if (view2 != null && y <= view2.getHeight() + this.mHeaderOffset.intValue()) {
                z = true;
            } else {
                z = false;
            }
            this.mHeaderOwnsTouch = z;
        }
        if (this.mHeaderOwnsTouch) {
            if (this.mHeader != null && Math.abs(this.mDownY - motionEvent.getY()) <= this.mTouchSlop) {
                return this.mHeader.dispatchTouchEvent(motionEvent);
            }
            if (this.mHeader != null) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                this.mHeader.dispatchTouchEvent(obtain);
                obtain.recycle();
            }
            MotionEvent obtain2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX(), this.mDownY, motionEvent.getMetaState());
            obtain2.setAction(0);
            boolean dispatchTouchEvent = this.mList.dispatchTouchEvent(obtain2);
            obtain2.recycle();
            this.mHeaderOwnsTouch = false;
            return dispatchTouchEvent;
        }
        return this.mList.dispatchTouchEvent(motionEvent);
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        this.mList.addFooterView(view2, obj, z);
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        this.mList.addHeaderView(view2, obj, z);
    }

    @TargetApi(11)
    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        int headerOverlap;
        if (requireSdkVersion(11)) {
            int i4 = 0;
            if (this.mAdapter == null) {
                headerOverlap = 0;
            } else {
                headerOverlap = getHeaderOverlap(i);
            }
            int i5 = i2 + headerOverlap;
            if (!this.mClippingToPadding) {
                i4 = this.mPaddingTop;
            }
            this.mList.smoothScrollToPositionFromTop(i, i5 - i4, i3);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IndexWrapperListView indexWrapperListView = this.mList;
        indexWrapperListView.layout(0, 0, indexWrapperListView.getMeasuredWidth(), getHeight());
        View view2 = this.mHeader;
        if (view2 != null) {
            int i5 = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).topMargin;
            View view3 = this.mHeader;
            view3.layout(this.mPaddingLeft, i5, view3.getMeasuredWidth() + this.mPaddingLeft, this.mHeader.getMeasuredHeight() + i5);
        }
    }

    public void setSelector(Drawable drawable) {
        this.mList.setSelector(drawable);
    }
}
