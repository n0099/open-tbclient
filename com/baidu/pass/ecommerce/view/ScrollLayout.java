package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class ScrollLayout extends FrameLayout {
    public static final float DRAG_SPEED_MULTIPLIER = 1.2f;
    public static final int DRAG_SPEED_SLOP = 30;
    public static final int FLING_VELOCITY_SLOP = 80;
    public static final int MAX_SCROLL_DURATION = 400;
    public static final int MIN_SCROLL_DURATION = 100;
    public static final int MOTION_DISTANCE_SLOP = 10;
    public static final float SCROLL_TO_CLOSE_OFFSET_FACTOR = 0.5f;
    public static final float SCROLL_TO_EXIT_OFFSET_FACTOR = 0.8f;
    public final RecyclerView.OnScrollListener associatedRecyclerViewListener;
    public int contentHeight;
    public InnerStatus currentInnerStatus;
    public int exitOffset;
    public GestureDetector gestureDetector;
    public final GestureDetector.OnGestureListener gestureListener;
    public boolean isAllowHorizontalScroll;
    public boolean isAllowPointerIntercepted;
    public boolean isCurrentPointerIntercepted;
    public boolean isDraggable;
    public boolean isEnable;
    public boolean isSupportExit;
    public float lastDownX;
    public float lastDownY;
    public Status lastFlingStatus;
    public float lastY;
    public int maxOffset;
    public OnScrollChangedListener onScrollChangedListener;
    public int openedOffset;
    public Scroller scroller;

    /* renamed from: com.baidu.pass.ecommerce.view.ScrollLayout$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus;

        static {
            int[] iArr = new int[InnerStatus.values().length];
            $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus = iArr;
            try {
                iArr[InnerStatus.OPENED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus[InnerStatus.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum InnerStatus {
        EXIT,
        HALF,
        OPENED,
        MOVING,
        SCROLLING
    }

    /* loaded from: classes2.dex */
    public interface OnScrollChangedListener {
        void onChildScroll(int i2);

        void onScrollFinished(Status status);

        void onScrollProgressChanged(float f2);
    }

    /* loaded from: classes2.dex */
    public enum Status {
        EXIT,
        HALF,
        OPENED
    }

    public ScrollLayout(Context context) {
        super(context);
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (f3 > 80.0f) {
                    if (ScrollLayout.this.lastFlingStatus.equals(Status.HALF) && (-ScrollLayout.this.getScrollY()) > ScrollLayout.this.maxOffset) {
                        ScrollLayout.this.lastFlingStatus = Status.EXIT;
                        ScrollLayout.this.scrollToExit();
                    } else {
                        ScrollLayout.this.scrollToHalf();
                        ScrollLayout.this.lastFlingStatus = Status.HALF;
                    }
                    return true;
                }
                int i2 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                if (i2 >= 0 || ScrollLayout.this.getScrollY() > (-ScrollLayout.this.maxOffset)) {
                    if (i2 >= 0 || ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.maxOffset)) {
                        return false;
                    }
                    ScrollLayout.this.scrollToOpened();
                    ScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                ScrollLayout.this.scrollToHalf();
                ScrollLayout.this.lastFlingStatus = Status.HALF;
                return true;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
    }

    private void completeMove() {
        float f2 = -((this.maxOffset - this.openedOffset) * 0.5f);
        if (getScrollY() > f2) {
            scrollToOpened();
        } else if (this.isSupportExit) {
            int i2 = this.exitOffset;
            int i3 = this.maxOffset;
            float f3 = -(((i2 - i3) * 0.8f) + i3);
            if (getScrollY() <= f2 && getScrollY() > f3) {
                scrollToHalf();
            } else {
                scrollToExit();
            }
        } else {
            scrollToHalf();
        }
    }

    private boolean disposeEdgeValue(int i2) {
        if (this.isSupportExit) {
            if (i2 > 0 || getScrollY() < (-this.openedOffset)) {
                return i2 >= 0 && getScrollY() <= (-this.exitOffset);
            }
            return true;
        } else if (i2 > 0 || getScrollY() < (-this.openedOffset)) {
            return i2 >= 0 && getScrollY() <= (-this.maxOffset);
        } else {
            return true;
        }
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SapiSdkScrollLayout);
        if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkHalfOffset) && (dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkHalfOffset, this.maxOffset)) != getContentHeight()) {
            this.maxOffset = getContentHeight() - dimensionPixelOffset;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkOpenedOffset)) {
            this.openedOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkOpenedOffset, this.openedOffset);
        } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkExitOffset)) {
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkExitOffset, getContentHeight());
            if (dimensionPixelOffset2 != getContentHeight()) {
                this.exitOffset = getContentHeight() - dimensionPixelOffset2;
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkAllowHorizontalScroll)) {
            this.isAllowHorizontalScroll = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkScrollLayout_SapiSdkAllowHorizontalScroll, true);
        } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkIsSupportExit)) {
            this.isSupportExit = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkScrollLayout_SapiSdkIsSupportExit, true);
        } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkMode)) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.SapiSdkScrollLayout_SapiSdkMode, 0);
            if (integer == 0) {
                setHalf();
            } else if (integer != 2) {
                setToOpen();
            } else {
                setToExit();
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void onScrollFinished(Status status) {
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollFinished(status);
        }
    }

    private void onScrollProgressChanged(float f2) {
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollProgressChanged(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewScrollState(RecyclerView recyclerView) {
        if (recyclerView.getChildCount() == 0) {
            setDraggable(true);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int[] iArr = new int[1];
        if (layoutManager instanceof LinearLayoutManager) {
            iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            iArr = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
        }
        if (iArr[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
            setDraggable(true);
        } else {
            setDraggable(false);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.scroller.isFinished() || !this.scroller.computeScrollOffset()) {
            return;
        }
        int currY = this.scroller.getCurrY();
        scrollTo(0, currY);
        if (currY != (-this.openedOffset) && currY != (-this.maxOffset) && (!this.isSupportExit || currY != (-this.exitOffset))) {
            invalidate();
        } else {
            this.scroller.abortAnimation();
        }
    }

    public int getContentHeight() {
        return this.contentHeight;
    }

    public Status getCurrentStatus() {
        int i2 = AnonymousClass3.$SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus[this.currentInnerStatus.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return Status.HALF;
            }
            return Status.EXIT;
        }
        return Status.OPENED;
    }

    public boolean isAllowHorizontalScroll() {
        return this.isAllowHorizontalScroll;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isSupportExit() {
        return this.isSupportExit;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isEnable) {
            if (this.isDraggable || this.currentInnerStatus != InnerStatus.OPENED) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.isAllowPointerIntercepted) {
                                if (this.isCurrentPointerIntercepted) {
                                    return true;
                                }
                                int y = (int) (motionEvent.getY() - this.lastDownY);
                                int x = (int) (motionEvent.getX() - this.lastDownX);
                                if (Math.abs(y) < 10) {
                                    return false;
                                }
                                if (Math.abs(y) < Math.abs(x) && this.isAllowHorizontalScroll) {
                                    this.isAllowPointerIntercepted = false;
                                    this.isCurrentPointerIntercepted = false;
                                    return false;
                                }
                                InnerStatus innerStatus = this.currentInnerStatus;
                                if (innerStatus == InnerStatus.OPENED) {
                                    if (y < 0) {
                                        return false;
                                    }
                                } else if (innerStatus == InnerStatus.HALF && !this.isSupportExit && y > 0) {
                                    return false;
                                }
                                this.isCurrentPointerIntercepted = true;
                                return true;
                            }
                            return false;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    this.isAllowPointerIntercepted = true;
                    this.isCurrentPointerIntercepted = false;
                    if (this.currentInnerStatus == InnerStatus.MOVING) {
                        return true;
                    }
                } else {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.lastY = y2;
                    this.lastDownX = x2;
                    this.lastDownY = y2;
                    this.isAllowPointerIntercepted = true;
                    this.isCurrentPointerIntercepted = false;
                    if (!this.scroller.isFinished()) {
                        this.scroller.forceFinished(true);
                        this.currentInnerStatus = InnerStatus.MOVING;
                        this.isCurrentPointerIntercepted = true;
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isCurrentPointerIntercepted) {
            this.gestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) ((motionEvent.getY() - this.lastY) * 1.2f);
                        int signum = ((int) Math.signum(y)) * Math.min(Math.abs(y), 30);
                        if (disposeEdgeValue(signum)) {
                            return true;
                        }
                        this.currentInnerStatus = InnerStatus.MOVING;
                        int scrollY = getScrollY() - signum;
                        int i2 = -this.openedOffset;
                        if (scrollY >= i2) {
                            scrollTo(0, i2);
                        } else {
                            int i3 = -this.maxOffset;
                            if (scrollY <= i3 && !this.isSupportExit) {
                                scrollTo(0, i3);
                            } else {
                                scrollTo(0, scrollY);
                            }
                        }
                        this.lastY = motionEvent.getY();
                        return true;
                    } else if (action != 3) {
                        return false;
                    }
                }
                if (this.currentInnerStatus == InnerStatus.MOVING) {
                    completeMove();
                    return true;
                }
                return false;
            }
            this.lastY = motionEvent.getY();
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
        int i4 = this.maxOffset;
        int i5 = this.openedOffset;
        if (i4 == i5) {
            return;
        }
        int i6 = -i3;
        if (i6 <= i4) {
            onScrollProgressChanged((i6 - i5) / (i4 - i5));
        } else {
            onScrollProgressChanged((i6 - i4) / (i4 - this.exitOffset));
        }
        if (i3 == (-this.openedOffset)) {
            InnerStatus innerStatus = this.currentInnerStatus;
            InnerStatus innerStatus2 = InnerStatus.OPENED;
            if (innerStatus != innerStatus2) {
                this.currentInnerStatus = innerStatus2;
                onScrollFinished(Status.OPENED);
            }
        } else if (i3 == (-this.maxOffset)) {
            InnerStatus innerStatus3 = this.currentInnerStatus;
            InnerStatus innerStatus4 = InnerStatus.HALF;
            if (innerStatus3 != innerStatus4) {
                this.currentInnerStatus = innerStatus4;
                onScrollFinished(Status.HALF);
            }
        } else if (this.isSupportExit && i3 == (-this.exitOffset)) {
            InnerStatus innerStatus5 = this.currentInnerStatus;
            InnerStatus innerStatus6 = InnerStatus.EXIT;
            if (innerStatus5 != innerStatus6) {
                this.currentInnerStatus = innerStatus6;
                onScrollFinished(Status.EXIT);
            }
        }
    }

    public void scrollToExit() {
        int i2;
        int i3;
        if (!this.isSupportExit || this.currentInnerStatus == InnerStatus.EXIT || this.exitOffset == this.maxOffset || (i3 = (-getScrollY()) - (i2 = this.exitOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.maxOffset)) + 100);
        invalidate();
    }

    public void scrollToHalf() {
        int i2;
        int i3;
        if (this.currentInnerStatus == InnerStatus.HALF || this.maxOffset == this.openedOffset || (i3 = (-getScrollY()) - (i2 = this.maxOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.openedOffset)) + 100);
        invalidate();
    }

    public void scrollToOpened() {
        int i2;
        int i3;
        if (this.currentInnerStatus == InnerStatus.OPENED || this.maxOffset == this.openedOffset || (i3 = (-getScrollY()) - (i2 = this.openedOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (this.maxOffset - i2)) + 100);
        invalidate();
    }

    public void setAllowHorizontalScroll(boolean z) {
        this.isAllowHorizontalScroll = z;
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(this.associatedRecyclerViewListener);
        updateRecyclerViewScrollState(recyclerView);
    }

    public void setContentHeight(int i2) {
        this.contentHeight = i2;
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setExitOffset(int i2) {
        this.exitOffset = getContentHeight() - i2;
    }

    public void setHalf() {
        scrollTo(0, -this.maxOffset);
        this.currentInnerStatus = InnerStatus.HALF;
        this.lastFlingStatus = Status.HALF;
    }

    public void setHalfOffset(int i2) {
        this.maxOffset = getContentHeight() - i2;
    }

    public void setIsSupportExit(boolean z) {
        this.isSupportExit = z;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public void setOpenedOffset(int i2) {
        this.openedOffset = i2;
    }

    public void setToExit() {
        if (this.isSupportExit) {
            scrollTo(0, -this.exitOffset);
            this.currentInnerStatus = InnerStatus.EXIT;
        }
    }

    public void setToOpen() {
        scrollTo(0, -this.openedOffset);
        this.currentInnerStatus = InnerStatus.OPENED;
        this.lastFlingStatus = Status.OPENED;
    }

    public void showOrHide() {
        InnerStatus innerStatus = this.currentInnerStatus;
        if (innerStatus == InnerStatus.HALF) {
            scrollToOpened();
        } else if (innerStatus == InnerStatus.OPENED) {
            scrollToHalf();
        }
    }

    public ScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (f3 > 80.0f) {
                    if (ScrollLayout.this.lastFlingStatus.equals(Status.HALF) && (-ScrollLayout.this.getScrollY()) > ScrollLayout.this.maxOffset) {
                        ScrollLayout.this.lastFlingStatus = Status.EXIT;
                        ScrollLayout.this.scrollToExit();
                    } else {
                        ScrollLayout.this.scrollToHalf();
                        ScrollLayout.this.lastFlingStatus = Status.HALF;
                    }
                    return true;
                }
                int i2 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                if (i2 >= 0 || ScrollLayout.this.getScrollY() > (-ScrollLayout.this.maxOffset)) {
                    if (i2 >= 0 || ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.maxOffset)) {
                        return false;
                    }
                    ScrollLayout.this.scrollToOpened();
                    ScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                ScrollLayout.this.scrollToHalf();
                ScrollLayout.this.lastFlingStatus = Status.HALF;
                return true;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
        initFromAttributes(context, attributeSet);
    }

    public ScrollLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (f3 > 80.0f) {
                    if (ScrollLayout.this.lastFlingStatus.equals(Status.HALF) && (-ScrollLayout.this.getScrollY()) > ScrollLayout.this.maxOffset) {
                        ScrollLayout.this.lastFlingStatus = Status.EXIT;
                        ScrollLayout.this.scrollToExit();
                    } else {
                        ScrollLayout.this.scrollToHalf();
                        ScrollLayout.this.lastFlingStatus = Status.HALF;
                    }
                    return true;
                }
                int i22 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                if (i22 >= 0 || ScrollLayout.this.getScrollY() > (-ScrollLayout.this.maxOffset)) {
                    if (i22 >= 0 || ScrollLayout.this.getScrollY() <= (-ScrollLayout.this.maxOffset)) {
                        return false;
                    }
                    ScrollLayout.this.scrollToOpened();
                    ScrollLayout.this.lastFlingStatus = Status.OPENED;
                    return true;
                }
                ScrollLayout.this.scrollToHalf();
                ScrollLayout.this.lastFlingStatus = Status.HALF;
                return true;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i3) {
                super.onScrolled(recyclerView, i22, i3);
                ScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
        initFromAttributes(context, attributeSet);
    }
}
