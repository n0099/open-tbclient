package com.baidu.searchbox.ui.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.ScrollerCompat;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class SwipeMenuLayout extends FrameLayout {
    public static final int CONTENT_VIEW_ID = 1;
    public static final boolean DEBUG = false;
    public static final int MENU_VIEW_ID = 2;
    public static final int STATE_CLOSE = 0;
    public static final int STATE_OPEN = 1;
    public static final String TAG = "SwipeMenuLayout";
    public boolean isFling;
    public int mBaseX;
    public Interpolator mCloseInterpolator;
    public ScrollerCompat mCloseScroller;
    public View mContentView;
    public int mDownX;
    public GestureDetectorCompat mGestureDetector;
    public GestureDetector.OnGestureListener mGestureListener;
    public final int mMaxVelocityX;
    public SwipeMenuView mMenuView;
    public final int mMinFling;
    public Interpolator mOpenInterpolator;
    public ScrollerCompat mOpenScroller;
    public int mPosition;
    public int state;

    public SwipeMenuLayout(Context context) {
        super(context);
        this.state = 0;
        this.mMinFling = DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f);
        this.mMaxVelocityX = -DeviceUtil.ScreenInfo.dp2px(getContext(), 500.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setMenuHeight(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMenuView.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            SwipeMenuView swipeMenuView = this.mMenuView;
            swipeMenuView.setLayoutParams(swipeMenuView.getLayoutParams());
        }
    }

    public void setPosition(int i) {
        this.mPosition = i;
        this.mMenuView.setPosition(i);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        this.mMinFling = DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f);
        this.mMaxVelocityX = -DeviceUtil.ScreenInfo.dp2px(getContext(), 500.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mMenuView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    public SwipeMenuLayout(View view2, SwipeMenuView swipeMenuView) {
        this(view2, swipeMenuView, null, null);
    }

    public SwipeMenuLayout(View view2, SwipeMenuView swipeMenuView, Interpolator interpolator, Interpolator interpolator2) {
        super(view2.getContext());
        this.state = 0;
        this.mMinFling = DeviceUtil.ScreenInfo.dp2px(getContext(), 15.0f);
        this.mMaxVelocityX = -DeviceUtil.ScreenInfo.dp2px(getContext(), 500.0f);
        this.mCloseInterpolator = interpolator;
        this.mOpenInterpolator = interpolator2;
        this.mContentView = view2;
        this.mMenuView = swipeMenuView;
        swipeMenuView.setLayout(this);
        init();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @SuppressLint({"ResourceType"})
    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.ui.swipe.SwipeMenuLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SwipeMenuLayout.this.isFling = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent.getX() - motionEvent2.getX() > SwipeMenuLayout.this.mMinFling && f < SwipeMenuLayout.this.mMaxVelocityX) {
                    SwipeMenuLayout.this.isFling = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.mGestureListener);
        if (this.mCloseInterpolator != null) {
            this.mCloseScroller = ScrollerCompat.create(getContext(), this.mCloseInterpolator);
        } else {
            this.mCloseScroller = ScrollerCompat.create(getContext());
        }
        if (this.mOpenInterpolator != null) {
            this.mOpenScroller = ScrollerCompat.create(getContext(), this.mOpenInterpolator);
        } else {
            this.mOpenScroller = ScrollerCompat.create(getContext());
        }
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.mMenuView.setId(2);
        this.mMenuView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.mMenuView);
    }

    private void swipe(int i) {
        if (i > this.mMenuView.getWidth()) {
            i = this.mMenuView.getWidth();
        }
        if (i < 0) {
            i = 0;
        }
        View view2 = this.mContentView;
        view2.layout(-i, view2.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        this.mMenuView.layout(this.mContentView.getWidth() - i, this.mMenuView.getTop(), (this.mContentView.getWidth() + this.mMenuView.getWidth()) - i, this.mMenuView.getBottom());
    }

    public boolean onSwipe(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int x = (int) (this.mDownX - motionEvent.getX());
                    if (this.state == 1) {
                        x += this.mMenuView.getWidth();
                    }
                    swipe(x);
                }
            } else if (!this.isFling && this.mDownX - motionEvent.getX() <= this.mMenuView.getWidth() / 2) {
                smoothCloseMenu();
                return false;
            } else {
                smoothOpenMenu();
            }
        } else {
            this.mDownX = (int) motionEvent.getX();
            this.isFling = false;
        }
        return true;
    }

    public void closeMenu() {
        if (this.mCloseScroller.computeScrollOffset()) {
            this.mCloseScroller.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            swipe(0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.mOpenScroller.computeScrollOffset()) {
                swipe(this.mOpenScroller.getCurrX());
                postInvalidate();
            }
        } else if (this.mCloseScroller.computeScrollOffset()) {
            swipe(this.mBaseX - this.mCloseScroller.getCurrX());
            postInvalidate();
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SwipeMenuView getMenuView() {
        return this.mMenuView;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public boolean isOpen() {
        if (this.state == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void openMenu() {
        if (this.state == 0) {
            this.state = 1;
            swipe(this.mMenuView.getWidth());
        }
    }

    public void smoothCloseMenu() {
        this.state = 0;
        int i = -this.mContentView.getLeft();
        this.mBaseX = i;
        this.mCloseScroller.startScroll(0, 0, i, 0, 350);
        postInvalidate();
    }

    public void smoothOpenMenu() {
        this.state = 1;
        this.mOpenScroller.startScroll(-this.mContentView.getLeft(), 0, this.mMenuView.getWidth(), 0, 350);
        postInvalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        this.mMenuView.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.mMenuView.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
    }
}
