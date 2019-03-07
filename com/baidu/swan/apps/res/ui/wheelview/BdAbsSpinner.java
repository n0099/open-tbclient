package com.baidu.swan.apps.res.ui.wheelview;

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
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
/* loaded from: classes2.dex */
public abstract class BdAbsSpinner extends BdAdapterView<SpinnerAdapter> {
    Rect aJW;
    View aJX;
    a aJY;
    SpinnerAdapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    abstract void k(int i, boolean z);

    protected DataSetObserver getDataSetObserver() {
        return this.mDataSetObserver;
    }

    public BdAbsSpinner(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.aJW = new Rect();
        this.aJX = null;
        this.aJY = new a();
        HH();
    }

    public BdAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.aJW = new Rect();
        this.aJX = null;
        this.aJY = new a();
        HH();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.AbsSpinner, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(b.j.AbsSpinner_entriesArray);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(17367049);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }

    private void HH() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new BdAdapterView.b();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            int i = this.mItemCount > 0 ? 0 : -1;
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

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = true;
        int i4 = 0;
        int mode = View.MeasureSpec.getMode(i);
        this.aJW.left = getPaddingLeft() > this.mSelectionLeftPadding ? getPaddingLeft() : this.mSelectionLeftPadding;
        this.aJW.top = getPaddingTop() > this.mSelectionTopPadding ? getPaddingTop() : this.mSelectionTopPadding;
        this.aJW.right = getPaddingRight() > this.mSelectionRightPadding ? getPaddingRight() : this.mSelectionRightPadding;
        this.aJW.bottom = getPaddingBottom() > this.mSelectionBottomPadding ? getPaddingBottom() : this.mSelectionBottomPadding;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0 && this.mAdapter != null) {
            View cY = this.aJY.cY(selectedItemPosition);
            if (cY == null) {
                cY = this.mAdapter.getView(selectedItemPosition, null, this);
            }
            if (cY != null) {
                this.aJY.c(selectedItemPosition, cY);
            }
            if (cY != null) {
                if (cY.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    cY.setLayoutParams(generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                measureChild(cY, i, i2);
                int Z = Z(cY) + this.aJW.top + this.aJW.bottom;
                i3 = aa(cY) + this.aJW.left + this.aJW.right;
                i4 = Z;
                z = false;
                if (z) {
                    i4 = this.aJW.top + this.aJW.bottom;
                    if (mode == 0) {
                        i3 = this.aJW.left + this.aJW.right;
                    }
                }
                setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
                this.mHeightMeasureSpec = i2;
                this.mWidthMeasureSpec = i;
            }
        }
        i3 = 0;
        if (z) {
        }
        setMeasuredDimension(resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
        this.mHeightMeasureSpec = i2;
        this.mWidthMeasureSpec = i;
    }

    int Z(View view) {
        return view.getMeasuredHeight();
    }

    int aa(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HI() {
        int childCount = getChildCount();
        a aVar = this.aJY;
        for (int i = 0; i < childCount; i++) {
            aVar.c(this.mFirstPosition + i, getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void handleDataChanged() {
        super.handleDataChanged();
    }

    public void setSelection(int i, boolean z) {
        j(i, z && this.mFirstPosition <= i && i <= (this.mFirstPosition + getChildCount()) + (-1));
        checkSelectionChanged();
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
        checkSelectionChanged();
    }

    public void setNewSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    void j(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            setNextSelectedPositionInt(i);
            k(i - this.mSelectedPosition, z);
            this.mBlockLayoutRequests = false;
        }
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public int getCount() {
        return this.mItemCount;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: cZ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        long aKb;
        int position;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aKb = parcel.readLong();
            this.position = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aKb);
            parcel.writeInt(this.position);
        }

        public String toString() {
            return "BdAbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.aKb + " position=" + this.position + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aKb = getSelectedItemId();
        if (savedState.aKb >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.aKb >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = savedState.aKb;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        private SparseArray<View> aJZ = new SparseArray<>();

        a() {
        }

        public void c(int i, View view) {
            this.aJZ.put(i, view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View cY(int i) {
            View view = this.aJZ.get(i);
            if (view != null) {
                this.aJZ.delete(i);
            }
            return view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            SparseArray<View> sparseArray = this.aJZ;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    BdAbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }
    }
}
