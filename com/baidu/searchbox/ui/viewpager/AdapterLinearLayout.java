package com.baidu.searchbox.ui.viewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import com.baidu.searchbox.widget.RecyclePool;
/* loaded from: classes4.dex */
public class AdapterLinearLayout extends LinearLayout {
    public static final int INVALID_POSITION = -1;
    public static final String TAG = "AdapterLinear";
    public Adapter mAdapter;
    public final Rect mBound;
    public Drawable mDivider;
    public int mDividerSize;
    public GestureDetector mGestureDetector;
    public GestureDetector.SimpleOnGestureListener mGestureListener;
    public boolean mIsPendingCheckTap;
    public OnItemClickListener mItemClickListener;
    public int mMontionIndex;
    public int mMotionDownY;
    public int mMotionUpY;
    public ItemDataSetObserver mObserver;
    public CheckForTap mPendingCheckForTap;
    public Runnable mPendingCheckForUp;
    public int mSelectedPosition;
    public Drawable mSelector;
    public boolean mShowLastDivider;
    public int mSpace;
    public final Rect mTempRect;
    public int mTouchSlop;
    public RecyclePool<View> mViewRecycle;

    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void onItemClick(AdapterLinearLayout adapterLinearLayout, View view2, int i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    public void onItemClick(int i) {
    }

    /* loaded from: classes4.dex */
    public abstract class CheckForTap implements Runnable {
        public int mPosition = -1;

        public CheckForTap() {
        }

        public void setPostion(int i) {
            this.mPosition = i;
        }

        public int getPosition() {
            return this.mPosition;
        }
    }

    /* loaded from: classes4.dex */
    public class ItemDataSetObserver extends DataSetObserver {
        public ItemDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AdapterLinearLayout.this.layoutChildren();
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public AdapterLinearLayout(Context context) {
        super(context);
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onSingleTapUp(motionEvent);
            }
        };
        init(context);
    }

    private void drawHorizontalDividers(Canvas canvas) {
        int childCount = this.mShowLastDivider ? getChildCount() : getChildCount() - 1;
        if (this.mDivider != null && childCount > 0) {
            int i = this.mDividerSize;
            int i2 = (this.mSpace - i) / 2;
            Rect rect = this.mTempRect;
            int paddingTop = getPaddingTop();
            rect.top = paddingTop;
            rect.bottom = (paddingTop + getHeight()) - getPaddingBottom();
            for (int i3 = 0; i3 < childCount; i3++) {
                int right = getChildAt(i3).getRight() + i2;
                rect.left = right;
                rect.right = right + i;
                drawDivider(canvas, rect);
            }
        }
    }

    private void drawVerticalDividers(Canvas canvas) {
        int childCount = this.mShowLastDivider ? getChildCount() : getChildCount() - 1;
        if (this.mDivider != null && childCount > 0) {
            int i = this.mDividerSize;
            int i2 = (this.mSpace - i) / 2;
            Rect rect = this.mTempRect;
            int paddingLeft = getPaddingLeft();
            rect.left = paddingLeft;
            rect.right = (paddingLeft + getWidth()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                int bottom = getChildAt(i3).getBottom() + i2;
                rect.top = bottom;
                rect.bottom = bottom + i;
                drawDivider(canvas, rect);
            }
        }
    }

    public void onUp(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        this.mMotionUpY = y;
        int i = y - this.mMotionDownY;
        if (Math.abs(i) > this.mTouchSlop) {
            onMove(i);
        }
        if (this.mPendingCheckForUp == null) {
            this.mPendingCheckForUp = new Runnable() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    AdapterLinearLayout.this.reset();
                    AdapterLinearLayout.this.positionSelector(-1);
                    AdapterLinearLayout.this.setPressed(false);
                    AdapterLinearLayout.this.invalidate();
                }
            };
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setPressed(false);
            }
        }
        if (this.mIsPendingCheckTap) {
            postDelayed(this.mPendingCheckForUp, ViewConfiguration.getTapTimeout());
        } else {
            this.mPendingCheckForUp.run();
        }
        this.mIsPendingCheckTap = false;
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onSingleTapUp(motionEvent);
            }
        };
        init(context);
    }

    @TargetApi(11)
    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return AdapterLinearLayout.this.onSingleTapUp(motionEvent);
            }
        };
        init(context);
    }

    private void drawSelector(Canvas canvas) {
        View childAt;
        if (this.mSelector != null && (childAt = getChildAt(this.mMontionIndex)) != null) {
            Rect rect = this.mTempRect;
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            this.mSelector.setBounds(rect);
            this.mSelector.draw(canvas);
        }
    }

    private void init(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener);
        int i = (int) (f * 1.0f);
        this.mDividerSize = i;
        this.mSpace = i;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (getOrientation() == 0) {
            drawHorizontalDividers(canvas);
        } else {
            drawVerticalDividers(canvas);
        }
        drawSelector(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            onMove(5);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCancel(MotionEvent motionEvent) {
        onUp(motionEvent);
    }

    public void onMove(int i) {
        if (Math.abs(i) > this.mTouchSlop) {
            removeCallbacks(this.mPendingCheckForTap);
            reset();
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition >= 0 && pointToPosition < this.mAdapter.getCount()) {
            performItemClick(getChildAt(pointToPosition), pointToPosition);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp(motionEvent);
        } else if (action == 3) {
            onCancel(motionEvent);
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void positionSelector(int i) {
        this.mMontionIndex = i;
    }

    public void selectChild(int i) {
        boolean z;
        this.mSelectedPosition = i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.mObserver);
        }
        layoutChildren();
    }

    @Override // android.widget.LinearLayout
    @TargetApi(11)
    public void setDividerDrawable(Drawable drawable) {
        this.mDivider = drawable;
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (getOrientation() == 0) {
                setDividerSize(bitmapDrawable.getIntrinsicWidth());
            } else {
                setDividerSize(bitmapDrawable.getIntrinsicHeight());
            }
        }
        invalidate();
    }

    public void setDividerSize(int i) {
        this.mDividerSize = i;
        if (this.mSpace != i) {
            this.mSpace = i;
            layoutChildren();
        }
        invalidate();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setSelector(Drawable drawable) {
        this.mSelector = drawable;
        invalidate();
    }

    public void setSpace(int i) {
        if (this.mSpace != i) {
            this.mSpace = i;
            layoutChildren();
        }
    }

    public void showLastDivider(boolean z) {
        this.mShowLastDivider = z;
    }

    private void drawDivider(Canvas canvas, Rect rect) {
        Drawable drawable = this.mDivider;
        if (drawable != null) {
            canvas.save();
            canvas.clipRect(rect);
            drawable.setBounds(rect);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    private void performItemClick(final View view2, final int i) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.3
            @Override // java.lang.Runnable
            public void run() {
                AdapterLinearLayout.this.onItemClick(i);
                AdapterLinearLayout.this.playSoundEffect(0);
                if (AdapterLinearLayout.this.mItemClickListener != null) {
                    AdapterLinearLayout.this.mItemClickListener.onItemClick(AdapterLinearLayout.this, view2, i);
                }
            }
        }, ViewConfiguration.getPressedStateDuration());
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mBound;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return childCount;
                }
            }
        }
        return -1;
    }

    private ViewGroup.LayoutParams getChildLayoutParameter() {
        if (getOrientation() == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    private void recycleChildren() {
        this.mViewRecycle.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.mViewRecycle.recycle(getChildAt(i));
        }
        removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mIsPendingCheckTap = false;
        positionSelector(-1);
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    public int getSpace() {
        return this.mSpace;
    }

    public void layoutChildren() {
        boolean z;
        if (this.mAdapter == null) {
            removeAllViews();
            return;
        }
        recycleChildren();
        int count = this.mAdapter.getCount();
        int i = this.mSpace;
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = this.mAdapter.getView(i2, this.mViewRecycle.get(), this);
            if (view2 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = getChildLayoutParameter();
            } else if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                return;
            }
            if (!this.mShowLastDivider && i2 == count - 1) {
                i = 0;
            }
            if (getOrientation() == 0) {
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = i;
            } else {
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
            }
            if (this.mSelectedPosition == i2) {
                z = true;
            } else {
                z = false;
            }
            view2.setSelected(z);
            addView(view2, layoutParams);
        }
        this.mViewRecycle.clear();
    }

    public boolean onDown(MotionEvent motionEvent) {
        View childAt;
        this.mMotionDownY = (int) motionEvent.getY();
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition >= 0 && pointToPosition < this.mAdapter.getCount() && (childAt = getChildAt(pointToPosition)) != null) {
            if (this.mPendingCheckForTap == null) {
                this.mPendingCheckForTap = new CheckForTap() { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdapterLinearLayout.this.setPressed(true);
                        AdapterLinearLayout.this.positionSelector(getPosition());
                        AdapterLinearLayout.this.invalidate();
                        AdapterLinearLayout.this.mIsPendingCheckTap = false;
                    }
                };
            }
            childAt.setPressed(true);
            this.mPendingCheckForTap.setPostion(pointToPosition);
            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
            this.mIsPendingCheckTap = true;
        }
        return true;
    }
}
