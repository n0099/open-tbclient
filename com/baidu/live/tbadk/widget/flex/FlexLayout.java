package com.baidu.live.tbadk.widget.flex;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes7.dex */
public class FlexLayout extends ViewGroup {
    static final String BUNDLE_KEY_SELECTS = "selects";
    static final String BUNDLE_KEY_STATE = "savedInstance";
    static final int INVALID_RESULT = -1;
    private FlexAdapter mAdapter;
    private float mHorizontalSpacing;
    private int mMaxSelectedNum;
    private MotionEvent mMotionEvent;
    private OnItemClickListener mOnItemClickListener;
    protected OnStateChangedListener mOnStateChangedListener;
    private LinkedHashSet<Integer> mSelectedPos;
    private float mVerticalSpacing;
    public int realHeight;

    /* loaded from: classes7.dex */
    public interface OnItemClickListener {
        void onItemClick(FlexLayout flexLayout, View view, int i);
    }

    /* loaded from: classes7.dex */
    public interface OnStateChangedListener {
        void onMaxNumSelected();

        void onStateChanged(int i, boolean z);
    }

    public FlexLayout(Context context) {
        this(context, null);
    }

    public FlexLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        initAttrs(attributeSet);
        initFields();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.mOnStateChangedListener = onStateChangedListener;
    }

    public void setAdapter(FlexAdapter flexAdapter) {
        this.mAdapter = flexAdapter;
        this.mAdapter.setCallback(new FlexAdapter.Callback() { // from class: com.baidu.live.tbadk.widget.flex.FlexLayout.1
            @Override // com.baidu.live.tbadk.widget.flex.FlexAdapter.Callback
            public void onChanged() {
                FlexLayout.this.onDataSetChanged();
            }
        });
        onDataSetChanged();
    }

    public void setHorizontalSpacing(int i) {
        this.mHorizontalSpacing = i;
        invalidate();
    }

    public void setVerticalSpacing(int i) {
        this.mVerticalSpacing = i;
        invalidate();
    }

    public void setMaxSelectedNum(int i) {
        this.mMaxSelectedNum = i;
    }

    public void setAllState(boolean z) {
        int childCount = getChildCount();
        if (z) {
            for (int i = 0; i < childCount; i++) {
                this.mSelectedPos.add(Integer.valueOf(i));
                getChildAt(i).setSelected(true);
            }
            return;
        }
        this.mSelectedPos.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setSelected(false);
        }
    }

    public LinkedHashSet<Integer> getSelectedPos() {
        return this.mSelectedPos;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        int findPosByView;
        if (this.mMotionEvent == null) {
            return super.performClick();
        }
        View findChild = findChild((int) this.mMotionEvent.getX(), (int) this.mMotionEvent.getY());
        this.mMotionEvent = null;
        if (findChild == null || (findPosByView = findPosByView(findChild)) == -1) {
            return true;
        }
        if (this.mOnItemClickListener != null) {
            this.mOnItemClickListener.onItemClick(this, findChild, findPosByView);
        }
        if (findChild.isSelected()) {
            this.mSelectedPos.remove(Integer.valueOf(findPosByView));
            findChild.setSelected(false);
            if (this.mOnStateChangedListener != null) {
                this.mOnStateChangedListener.onStateChanged(findPosByView, false);
                return true;
            }
            return true;
        } else if (this.mSelectedPos.size() != this.mMaxSelectedNum) {
            this.mSelectedPos.add(Integer.valueOf(findPosByView));
            findChild.setSelected(true);
            if (this.mOnStateChangedListener != null) {
                this.mOnStateChangedListener.onStateChanged(findPosByView, true);
                return true;
            }
            return true;
        } else if (this.mOnStateChangedListener != null) {
            this.mOnStateChangedListener.onMaxNumSelected();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int resolveSize = resolveSize(0, i);
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i4 = 0;
        int i5 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int max = Math.max(i5, measuredHeight);
            if (paddingLeft + measuredWidth + getPaddingRight() > resolveSize) {
                paddingLeft = getPaddingLeft();
                i3 = (int) (max + this.mVerticalSpacing + paddingTop);
            } else {
                measuredHeight = max;
                i3 = paddingTop;
            }
            paddingLeft = (int) (paddingLeft + this.mHorizontalSpacing + measuredWidth);
            i4++;
            paddingTop = i3;
            i5 = measuredHeight;
        }
        this.realHeight = paddingTop + i5 + getPaddingBottom();
        setMeasuredDimension(resolveSize, resolveSize(paddingTop + i5 + getPaddingBottom(), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i6 = Math.max(i6, measuredHeight);
                if (paddingLeft + measuredWidth + getPaddingRight() > i5) {
                    paddingLeft = getPaddingLeft();
                    paddingTop = (int) (i6 + this.mVerticalSpacing + paddingTop);
                    i6 = measuredHeight;
                }
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, measuredHeight + paddingTop);
                paddingLeft = (int) (paddingLeft + this.mHorizontalSpacing + measuredWidth);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        if (getChildCount() <= 0) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_STATE, super.onSaveInstanceState());
        bundle.putSerializable(BUNDLE_KEY_SELECTS, this.mSelectedPos);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mSelectedPos = (LinkedHashSet) bundle.getSerializable(BUNDLE_KEY_SELECTS);
            if (this.mSelectedPos != null && this.mSelectedPos.size() > 0) {
                Iterator<Integer> it = this.mSelectedPos.iterator();
                while (it.hasNext()) {
                    View childAt = getChildAt(it.next().intValue());
                    if (childAt != null) {
                        childAt.setSelected(true);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable(BUNDLE_KEY_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_FlexLayout);
        this.mHorizontalSpacing = obtainStyledAttributes.getDimension(a.k.sdk_FlexLayout_fl_spacing_horizontal, 0.0f);
        this.mVerticalSpacing = obtainStyledAttributes.getDimension(a.k.sdk_FlexLayout_fl_spcaing_vertical, 0.0f);
        this.mMaxSelectedNum = obtainStyledAttributes.getInteger(a.k.sdk_FlexLayout_fl_max_selected, -1);
        obtainStyledAttributes.recycle();
    }

    private void initFields() {
        this.mSelectedPos = new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSetChanged() {
        removeAllViews();
        this.mSelectedPos.clear();
        for (int i = 0; i < this.mAdapter.getCount(); i++) {
            View view = this.mAdapter.getView(i, this);
            addView(view);
            if (view.isSelected()) {
                this.mSelectedPos.add(Integer.valueOf(i));
            }
        }
    }

    private View findChild(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private int findPosByView(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }
}
