package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class PagerLayoutManager extends LinearLayoutManager implements View.OnTouchListener {
    public static final float DEFAULT_SPEED = 70.0f;
    public static final float VERTICAL_OFFSET_DOWN = -10.0f;
    public static final float VERTICAL_OFFSET_UP = 10.0f;
    public boolean hasDownTriggerSlide;
    public boolean hasForceSetPosition;
    public boolean hasUpTriggerSlide;
    public boolean isCanScroll;
    public int mFlipY;
    public int mLastMoveY;
    public PagerListener mPagerListener;
    public PagerHelper mPagerSnapHelper;
    public int mPosition;
    public RecyclerView mRecyclerView;
    public int mState;
    public RecyclerView.OnChildAttachStateChangeListener mStateChangeListener;
    public TouchListener mTouchListener;
    public boolean scroll;
    public int slideOffset;

    /* loaded from: classes4.dex */
    public interface PagerListener {

        /* loaded from: classes4.dex */
        public enum PageAction {
            UP,
            DOWN,
            NONE
        }

        void onAttachedToWindow(View view2);

        void onDetachedToWindow(View view2);

        void onPageScrolled(boolean z, int i, boolean z2, boolean z3);

        void onPageSelected(PageAction pageAction, int i, @Nullable View view2);

        void onScrollStateChanged(int i, int i2);

        void onStartPageScrolledOffset(boolean z, int i);
    }

    /* loaded from: classes4.dex */
    public static class SimplePagerListener implements PagerListener {
        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onAttachedToWindow(View view2) {
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onDetachedToWindow(View view2) {
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onPageScrolled(boolean z, int i, boolean z2, boolean z3) {
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onPageSelected(PagerListener.PageAction pageAction, int i, @Nullable View view2) {
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onScrollStateChanged(int i, int i2) {
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onStartPageScrolledOffset(boolean z, int i) {
        }
    }

    /* loaded from: classes4.dex */
    public interface TouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public class PagerHelper extends PagerSnapHelper {
        public OrientationHelper mHorizontalHelper;
        public OrientationHelper mVerticalHelper;

        public PagerHelper() {
        }

        private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
            if (this.mHorizontalHelper == null) {
                this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.mHorizontalHelper;
        }

        private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
            if (this.mVerticalHelper == null) {
                this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
            }
            return this.mVerticalHelper;
        }

        private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, OrientationHelper orientationHelper) {
            int end;
            int decoratedStart = orientationHelper.getDecoratedStart(view2) + (orientationHelper.getDecoratedMeasurement(view2) / 2);
            if (layoutManager.getClipToPadding()) {
                end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                end = orientationHelper.getEnd() / 2;
            }
            return decoratedStart - end;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
            int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
            if (findTargetSnapPosition <= 0 && PagerLayoutManager.this.mPosition == 0) {
                return -1;
            }
            return findTargetSnapPosition;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2) {
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = distanceToCenter(layoutManager, view2, getHorizontalHelper(layoutManager));
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                iArr[1] = distanceToCenter(layoutManager, view2, getVerticalHelper(layoutManager));
            } else {
                iArr[1] = 0;
            }
            PagerLayoutManager.this.mLastMoveY = iArr[1];
            return iArr;
        }
    }

    public PagerLayoutManager(Context context) {
        super(context, 1, false);
        this.mPosition = -1;
        this.hasForceSetPosition = false;
        this.mLastMoveY = 0;
        this.scroll = true;
        this.isCanScroll = true;
        this.mState = 0;
        this.hasUpTriggerSlide = false;
        this.hasDownTriggerSlide = false;
        this.slideOffset = 0;
        this.mStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view2) {
                if (PagerLayoutManager.this.mPagerListener != null) {
                    PagerLayoutManager.this.mPagerListener.onAttachedToWindow(view2);
                    if (PagerLayoutManager.this.getChildCount() == 1) {
                        PagerLayoutManager.this.mPagerListener.onPageSelected(PagerListener.PageAction.NONE, 0, view2);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view2) {
                if (PagerLayoutManager.this.mPagerListener != null) {
                    PagerLayoutManager.this.mPagerListener.onDetachedToWindow(view2);
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnScrollChanged(int i) {
        this.mState = i;
        if (i == 0) {
            this.hasDownTriggerSlide = false;
            this.hasUpTriggerSlide = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
        this.mPosition = 0;
        this.mPagerSnapHelper.attachToRecyclerView(recyclerView);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this.mStateChangeListener);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView2, int i) {
                super.onScrollStateChanged(recyclerView2, i);
                PagerLayoutManager.this.dispatchOnScrollChanged(i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                if (PagerLayoutManager.this.mState == 0 || PagerLayoutManager.this.mState == 2) {
                    PagerLayoutManager.this.slideOffset = 0;
                    return;
                }
                PagerLayoutManager.this.slideOffset += i2;
                if (PagerLayoutManager.this.slideOffset > 10.0f && !PagerLayoutManager.this.hasUpTriggerSlide) {
                    PagerLayoutManager.this.hasUpTriggerSlide = true;
                    PagerLayoutManager.this.mPagerListener.onStartPageScrolledOffset(true, PagerLayoutManager.this.mPosition);
                }
                if (PagerLayoutManager.this.slideOffset <= -10.0f && !PagerLayoutManager.this.hasDownTriggerSlide) {
                    PagerLayoutManager.this.hasDownTriggerSlide = true;
                    PagerLayoutManager.this.mPagerListener.onStartPageScrolledOffset(false, PagerLayoutManager.this.mPosition);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        this.mState = i;
        if (this.mPagerListener == null) {
            return;
        }
        if (i != 0) {
            if (i == 2) {
                try {
                    if (findFirstVisibleItemPosition() == 0 && this.mPosition > 0) {
                        this.mPosition = 0;
                        this.hasForceSetPosition = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            dispatchScrollEvent();
        }
        this.mPagerListener.onScrollStateChanged(i, this.mPosition);
    }

    public void setIsCanScroll(boolean z) {
        this.isCanScroll = z;
    }

    public void setOnPagerListener(PagerListener pagerListener) {
        this.mPagerListener = pagerListener;
    }

    public void setScroll(boolean z) {
        this.scroll = z;
    }

    public void setTouchListener(TouchListener touchListener) {
        this.mTouchListener = touchListener;
    }

    public void updatePosition(int i) {
        this.mPosition = i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (canScrollVertically() && ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.mRecyclerView.getScrollState() != 0)) {
            dispatchScrollEvent();
        }
        TouchListener touchListener = this.mTouchListener;
        if (touchListener != null) {
            touchListener.onTouch(motionEvent);
            return false;
        }
        return false;
    }

    private void dispatchScrollEvent() {
        int i;
        boolean z;
        boolean z2;
        PagerListener.PageAction pageAction;
        if (this.mPagerListener == null) {
            return;
        }
        View findSnapView = this.mPagerSnapHelper.findSnapView(this);
        boolean z3 = false;
        if (findSnapView != null) {
            i = getPosition(findSnapView);
        } else {
            i = 0;
        }
        PagerListener pagerListener = this.mPagerListener;
        if (this.mFlipY > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mPosition != i) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mLastMoveY == 0) {
            z3 = true;
        }
        pagerListener.onPageScrolled(z, i, z2, z3);
        if (this.mLastMoveY == 0 && !canScrollVertically()) {
            return;
        }
        this.mPosition = i;
        if (this.mFlipY > 0) {
            pageAction = PagerListener.PageAction.UP;
        } else {
            pageAction = PagerListener.PageAction.DOWN;
        }
        this.mPagerListener.onPageSelected(pageAction, this.mPosition, findSnapView);
    }

    private void init() {
        this.mPagerSnapHelper = new PagerHelper();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.scroll && this.isCanScroll) {
            return true;
        }
        return false;
    }

    public void clearPageListener() {
        this.mPagerListener = null;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public boolean isScrollerIdle() {
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    public void snapToNext() {
        RecyclerView recyclerView;
        if (this.mPosition + 1 >= getItemCount() || (recyclerView = this.mRecyclerView) == null) {
            return;
        }
        this.mLastMoveY = -1;
        recyclerView.smoothScrollToPosition(this.mPosition + 1);
    }

    public void snapToPre() {
        RecyclerView recyclerView;
        int i = this.mPosition;
        if (i - 1 < 0 || (recyclerView = this.mRecyclerView) == null) {
            return;
        }
        this.mLastMoveY = -1;
        recyclerView.smoothScrollToPosition(i - 1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mFlipY = i;
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.2
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 70.0f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }
}
