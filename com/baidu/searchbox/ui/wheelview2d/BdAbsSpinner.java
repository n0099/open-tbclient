package com.baidu.searchbox.ui.wheelview2d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.ui.wheelview2d.BdAdapterView;
/* loaded from: classes4.dex */
public abstract class BdAbsSpinner extends BdAdapterView<SpinnerAdapter> {
    public SpinnerAdapter mAdapter;
    public boolean mBlockLayoutRequests;
    public DataSetObserver mDataSetObserver;
    public int mHeightMeasureSpec;
    public Interpolator mInterpolator;
    public RecycleBin mRecycler;
    public View mSelectedView;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public Rect mSpinnerPadding;
    public Rect mTouchFrame;
    public int mWidthMeasureSpec;

    public abstract void layout(int i, boolean z);

    /* loaded from: classes4.dex */
    public class RecycleBin {
        public SparseArray<View> mScrapHeap = new SparseArray<>();

        public RecycleBin() {
        }

        public View get(int i) {
            View view2 = this.mScrapHeap.get(i);
            if (view2 != null) {
                this.mScrapHeap.delete(i);
            }
            return view2;
        }

        public View peek(int i) {
            return this.mScrapHeap.get(i);
        }

        public void clear() {
            SparseArray<View> sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    BdAbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        public void put(int i, View view2) {
            this.mScrapHeap.put(i, view2);
        }
    }

    public BdAbsSpinner(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mSelectedView = null;
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    public int getChildHeight(View view2) {
        return view2.getMeasuredHeight();
    }

    public int getChildWidth(View view2) {
        return view2.getMeasuredWidth();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        long j = savedState.selectedId;
        if (j >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = j;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    public void setNewSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
        checkSelectionChanged();
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner.SavedState.1
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
        public int position;
        public long selectedId;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "BdAbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }
    }

    public BdAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public void setSelection(int i, boolean z) {
        int i2;
        boolean z2 = true;
        setSelectionInt(i, (!z || (i2 = this.mFirstPosition) > i || i > (i2 + getChildCount()) - 1) ? false : false);
        checkSelectionChanged();
    }

    public void setSelectionInt(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            setNextSelectedPositionInt(i);
            layout(i - this.mSelectedPosition, z);
            this.mBlockLayoutRequests = false;
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public BdAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mSelectedView = null;
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsSpinner, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(17367049);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public int getCount() {
        return this.mItemCount;
    }

    public DataSetObserver getDataSetObserver() {
        return this.mDataSetObserver;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public View getSelectedView() {
        int i;
        if (this.mItemCount > 0 && (i = this.mSelectedPosition) >= 0) {
            return getChildAt(i - this.mFirstPosition);
        }
        return null;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void handleDataChanged() {
        super.handleDataChanged();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        if (selectedItemId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        for (int i = 0; i < childCount; i++) {
            recycleBin.put(this.mFirstPosition + i, getChildAt(i));
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        Rect rect = this.mSpinnerPadding;
        int paddingLeft = getPaddingLeft();
        int i4 = this.mSelectionLeftPadding;
        if (paddingLeft > i4) {
            i4 = getPaddingLeft();
        }
        rect.left = i4;
        Rect rect2 = this.mSpinnerPadding;
        int paddingTop = getPaddingTop();
        int i5 = this.mSelectionTopPadding;
        if (paddingTop > i5) {
            i5 = getPaddingTop();
        }
        rect2.top = i5;
        Rect rect3 = this.mSpinnerPadding;
        int paddingRight = getPaddingRight();
        int i6 = this.mSelectionRightPadding;
        if (paddingRight > i6) {
            i6 = getPaddingRight();
        }
        rect3.right = i6;
        Rect rect4 = this.mSpinnerPadding;
        int paddingBottom = getPaddingBottom();
        int i7 = this.mSelectionBottomPadding;
        if (paddingBottom > i7) {
            i7 = getPaddingBottom();
        }
        rect4.bottom = i7;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        boolean z = true;
        int i8 = 0;
        if (selectedItemPosition >= 0 && this.mAdapter != null) {
            View view2 = this.mRecycler.get(selectedItemPosition);
            if (view2 == null) {
                view2 = this.mAdapter.getView(selectedItemPosition, null, this);
            }
            if (view2 != null) {
                this.mRecycler.put(selectedItemPosition, view2);
            }
            if (view2 != null) {
                if (view2.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    view2.setLayoutParams(generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                measureChild(view2, i, i2);
                int childHeight = getChildHeight(view2);
                Rect rect5 = this.mSpinnerPadding;
                int i9 = childHeight + rect5.top + rect5.bottom;
                int childWidth = getChildWidth(view2);
                Rect rect6 = this.mSpinnerPadding;
                i8 = i9;
                i3 = childWidth + rect6.left + rect6.right;
                z = false;
                if (z) {
                    Rect rect7 = this.mSpinnerPadding;
                    i8 = rect7.top + rect7.bottom;
                    if (mode == 0) {
                        i3 = rect7.right + rect7.left;
                    }
                }
                int max = Math.max(i8, getSuggestedMinimumHeight());
                int max2 = Math.max(i3, getSuggestedMinimumWidth());
                setMeasuredDimension(ViewGroup.resolveSize(max2, i), ViewGroup.resolveSize(max, i2));
                this.mHeightMeasureSpec = i2;
                this.mWidthMeasureSpec = i;
            }
        }
        i3 = 0;
        if (z) {
        }
        int max3 = Math.max(i8, getSuggestedMinimumHeight());
        int max22 = Math.max(i3, getSuggestedMinimumWidth());
        setMeasuredDimension(ViewGroup.resolveSize(max22, i), ViewGroup.resolveSize(max3, i2));
        this.mHeightMeasureSpec = i2;
        this.mWidthMeasureSpec = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.mAdapter;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        int i = -1;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (spinnerAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = spinnerAdapter.getCount();
            checkFocus();
            BdAdapterView.AdapterDataSetObserver adapterDataSetObserver = new BdAdapterView.AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver);
            if (this.mItemCount > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }
}
