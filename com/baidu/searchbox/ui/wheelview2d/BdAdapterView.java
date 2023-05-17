package com.baidu.searchbox.ui.wheelview2d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
/* loaded from: classes4.dex */
public abstract class BdAdapterView<T extends Adapter> extends ViewGroup {
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final int SYNC_FIRST_POSITION = 1;
    public static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int SYNC_SELECTED_POSITION = 0;
    public static final String TAG = "BdAdapterView";
    public boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    public boolean mDesiredFocusableInTouchModeState;
    public boolean mDesiredFocusableState;
    public View mEmptyView;
    @ViewDebug.ExportedProperty
    public int mFirstPosition;
    public boolean mInLayout;
    @ViewDebug.ExportedProperty
    public int mItemCount;
    public int mLayoutHeight;
    public boolean mNeedSync;
    @ViewDebug.ExportedProperty
    public int mNextSelectedPosition;
    public long mNextSelectedRowId;
    public int mOldItemCount;
    public int mOldSelectedPosition;
    public long mOldSelectedRowId;
    public OnItemClickListener mOnItemClickListener;
    public OnItemDoubleClickListener mOnItemDoubleClickListener;
    public OnItemLongClickListener mOnItemLongClickListener;
    public OnItemSelectedListener mOnItemSelectedListener;
    @ViewDebug.ExportedProperty
    public int mSelectedPosition;
    public long mSelectedRowId;
    public BdAdapterView<T>.SelectionNotifier mSelectionNotifier;
    public int mSpecificTop;
    public long mSyncHeight;
    public int mSyncMode;
    public int mSyncPosition;
    public long mSyncRowId;

    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void onItemClick(BdAdapterView<?> bdAdapterView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface OnItemDoubleClickListener {
        boolean onItemDoubleClick(BdAdapterView<?> bdAdapterView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(BdAdapterView<?> bdAdapterView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface OnItemSelectedListener {
        void onItemSelected(BdAdapterView<?> bdAdapterView, View view2, int i, long j);

        void onNothingSelected(BdAdapterView<?> bdAdapterView);
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public boolean isInFilterMode() {
        return false;
    }

    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
    }

    public abstract void setAdapter(T t);

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public abstract void setSelection(int i);

    /* loaded from: classes4.dex */
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public long id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view2, int i, long j) {
            this.targetView = view2;
            this.position = i;
            this.id = j;
        }
    }

    /* loaded from: classes4.dex */
    public class AdapterDataSetObserver extends DataSetObserver {
        public Parcelable mInstanceState = null;

        public AdapterDataSetObserver() {
        }

        public void clearSavedState() {
            this.mInstanceState = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            BdAdapterView bdAdapterView = BdAdapterView.this;
            bdAdapterView.mDataChanged = true;
            bdAdapterView.mOldItemCount = bdAdapterView.mItemCount;
            bdAdapterView.mItemCount = bdAdapterView.getAdapter().getCount();
            if (BdAdapterView.this.getAdapter().hasStableIds() && (parcelable = this.mInstanceState) != null) {
                BdAdapterView bdAdapterView2 = BdAdapterView.this;
                if (bdAdapterView2.mOldItemCount == 0 && bdAdapterView2.mItemCount > 0) {
                    bdAdapterView2.onRestoreInstanceState(parcelable);
                    this.mInstanceState = null;
                    BdAdapterView.this.checkFocus();
                    BdAdapterView.this.requestLayout();
                }
            }
            BdAdapterView.this.rememberSyncState();
            BdAdapterView.this.checkFocus();
            BdAdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            BdAdapterView bdAdapterView = BdAdapterView.this;
            bdAdapterView.mDataChanged = true;
            if (bdAdapterView.getAdapter().hasStableIds()) {
                this.mInstanceState = BdAdapterView.this.onSaveInstanceState();
            }
            BdAdapterView bdAdapterView2 = BdAdapterView.this;
            bdAdapterView2.mOldItemCount = bdAdapterView2.mItemCount;
            bdAdapterView2.mItemCount = 0;
            bdAdapterView2.mSelectedPosition = -1;
            bdAdapterView2.mSelectedRowId = Long.MIN_VALUE;
            bdAdapterView2.mNextSelectedPosition = -1;
            bdAdapterView2.mNextSelectedRowId = Long.MIN_VALUE;
            bdAdapterView2.mNeedSync = false;
            bdAdapterView2.checkSelectionChanged();
            BdAdapterView.this.checkFocus();
            BdAdapterView.this.requestLayout();
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class SelectionNotifier extends Handler implements Runnable {
        public SelectionNotifier() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdAdapterView bdAdapterView = BdAdapterView.this;
            if (!bdAdapterView.mDataChanged) {
                bdAdapterView.fireOnSelected();
            } else {
                post(this);
            }
        }
    }

    public BdAdapterView(Context context) {
        super(context);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z;
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            z = selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        } else {
            z = false;
        }
        if (!z) {
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setItemCount(getCount());
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public Object getItemAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter != null && i >= 0) {
            return adapter.getItem(i);
        }
        return null;
    }

    public long getItemIdAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter != null && i >= 0) {
            return adapter.getItemId(i);
        }
        return Long.MIN_VALUE;
    }

    public int getPositionForView(View view2) {
        while (true) {
            try {
                View view3 = (View) view2.getParent();
                if (view3.equals(this)) {
                    break;
                }
                view2 = view3;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view2)) {
                return this.mFirstPosition + i;
            }
        }
        return -1;
    }

    public void setEmptyView(View view2) {
        boolean z;
        this.mEmptyView = view2;
        T adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        updateEmptyStatus(z);
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2;
        T adapter = getAdapter();
        boolean z3 = true;
        if (adapter != null && adapter.getCount() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.mDesiredFocusableState = z;
        if (!z) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        if (!z || (z2 && !isInFilterMode())) {
            z3 = false;
        }
        super.setFocusable(z3);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2;
        T adapter = getAdapter();
        boolean z3 = false;
        if (adapter != null && adapter.getCount() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.mDesiredFocusableInTouchModeState = z;
        if (z) {
            this.mDesiredFocusableState = true;
        }
        if (z && (!z2 || isInFilterMode())) {
            z3 = true;
        }
        super.setFocusableInTouchMode(z3);
    }

    public void setNextSelectedPositionInt(int i) {
        this.mNextSelectedPosition = i;
        long itemIdAtPosition = getItemIdAtPosition(i);
        this.mNextSelectedRowId = itemIdAtPosition;
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.mSyncRowId = itemIdAtPosition;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemDoubleClickListener(OnItemDoubleClickListener onItemDoubleClickListener) {
        this.mOnItemDoubleClickListener = onItemDoubleClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    public void setSelectedPositionInt(int i) {
        this.mSelectedPosition = i;
        this.mSelectedRowId = getItemIdAtPosition(i);
    }

    public BdAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public BdAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstPosition = 0;
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public boolean performItemClick(View view2, int i, long j) {
        if (this.mOnItemClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        this.mOnItemClickListener.onItemClick(this, view2, i, j);
        return true;
    }

    public boolean performItemDoubleClick(View view2, int i, long j) {
        OnItemDoubleClickListener onItemDoubleClickListener = this.mOnItemDoubleClickListener;
        if (onItemDoubleClickListener != null) {
            onItemDoubleClickListener.onItemDoubleClick(this, view2, i, j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            return;
        }
        this.mOnItemSelectedListener.onNothingSelected(this);
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        if (super.canAnimate() && this.mItemCount > 0) {
            return true;
        }
        return false;
    }

    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedRowId = this.mSelectedRowId;
        }
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && selectedItemPosition >= 0) {
            return adapter.getItem(selectedItemPosition);
        }
        return null;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.mNextSelectedRowId;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            View view2 = this.mEmptyView;
            if (view2 != null) {
                view2.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                layout(getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view3 = this.mEmptyView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        setVisibility(0);
    }

    public void checkFocus() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        T adapter = getAdapter();
        boolean z5 = false;
        if (adapter != null && adapter.getCount() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z && !isInFilterMode()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && this.mDesiredFocusableInTouchModeState) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusableInTouchMode(z3);
        if (z2 && this.mDesiredFocusableState) {
            z4 = true;
        } else {
            z4 = false;
        }
        super.setFocusable(z4);
        if (this.mEmptyView != null) {
            updateEmptyStatus((adapter == null || adapter.isEmpty()) ? true : true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDataChanged() {
        boolean z;
        int i = this.mItemCount;
        boolean z2 = true;
        if (i > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                int findSyncPosition = findSyncPosition();
                if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                    setNextSelectedPositionInt(findSyncPosition);
                    z = true;
                    if (!z) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                        if (lookForSelectablePosition < 0) {
                            lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, false);
                        }
                        if (lookForSelectablePosition >= 0) {
                            setNextSelectedPositionInt(lookForSelectablePosition);
                            checkSelectionChanged();
                        }
                    }
                    z2 = z;
                }
            }
            z = false;
            if (!z) {
            }
            z2 = z;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.mSelectedPosition = -1;
            this.mSelectedRowId = Long.MIN_VALUE;
            this.mNextSelectedPosition = -1;
            this.mNextSelectedRowId = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = this.mLayoutHeight;
            int i = this.mSelectedPosition;
            if (i >= 0) {
                View childAt = getChildAt(i - this.mFirstPosition);
                this.mSyncRowId = this.mNextSelectedRowId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificTop = childAt.getTop();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            int i2 = this.mFirstPosition;
            if (i2 >= 0 && i2 < adapter.getCount()) {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncRowId = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.mSpecificTop = childAt2.getTop();
            }
            this.mSyncMode = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findSyncPosition() {
        boolean z;
        boolean z2;
        int i = this.mItemCount;
        if (i == 0) {
            return -1;
        }
        long j = this.mSyncRowId;
        int i2 = this.mSyncPosition;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = i - 1;
        int min = Math.min(i3, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i4 = min;
        int i5 = i4;
        loop0: while (true) {
            boolean z3 = false;
            while (SystemClock.uptimeMillis() <= uptimeMillis) {
                if (adapter.getItemId(min) == j) {
                    return min;
                }
                if (i4 == i3) {
                    z = true;
                } else {
                    z = false;
                }
                if (i5 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    break loop0;
                } else if (!z2 && (!z3 || z)) {
                    if (z || (!z3 && !z2)) {
                        i5--;
                        min = i5;
                        z3 = true;
                    }
                } else {
                    i4++;
                    min = i4;
                }
            }
            break loop0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutHeight = getHeight();
    }

    public void selectionChanged() {
        if (this.mOnItemSelectedListener != null) {
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                fireOnSelected();
            } else {
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new SelectionNotifier();
                }
                BdAdapterView<T>.SelectionNotifier selectionNotifier = this.mSelectionNotifier;
                selectionNotifier.post(selectionNotifier);
            }
        }
        if (this.mSelectedPosition != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }
}
