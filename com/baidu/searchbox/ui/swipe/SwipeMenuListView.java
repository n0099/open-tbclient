package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.MotionEventCompat;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes4.dex */
public class SwipeMenuListView extends ListView {
    public static final boolean DEBUG = false;
    public static final String TAG = "SwipeMenuListView";
    public static final int TOUCH_STATE_NONE = 0;
    public static final int TOUCH_STATE_X = 1;
    public static final int TOUCH_STATE_Y = 2;
    public Interpolator mCloseInterpolator;
    public float mDownX;
    public float mDownY;
    public int mMaxX;
    public int mMaxY;
    public SwipeMenuCreator mMenuCreator;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public OnSwipeListener mOnSwipeListener;
    public Interpolator mOpenInterpolator;
    public int mTouchPosition;
    public int mTouchState;
    public SwipeMenuLayout mTouchView;

    /* loaded from: classes4.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(int i, SwipeMenu swipeMenu, int i2);
    }

    /* loaded from: classes4.dex */
    public interface OnSwipeListener {
        void onSwipeEnd(int i);

        void onSwipeStart(int i);
    }

    public SwipeMenuListView(Context context) {
        super(context);
        this.mMaxX = 5;
        this.mMaxY = 3;
        init();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchState == 1) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.mCloseInterpolator = interpolator;
    }

    public void setMenuCreator(SwipeMenuCreator swipeMenuCreator) {
        this.mMenuCreator = swipeMenuCreator;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mOnSwipeListener = onSwipeListener;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.mOpenInterpolator = interpolator;
    }

    public SwipeMenuListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxX = 5;
        this.mMaxY = 3;
        init();
    }

    public SwipeMenuListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxX = 5;
        this.mMaxY = 3;
        init();
    }

    private void init() {
        this.mMaxY = DeviceUtil.ScreenInfo.dp2px(getContext(), this.mMaxY);
        this.mMaxX = DeviceUtil.ScreenInfo.dp2px(getContext(), this.mMaxX);
        this.mTouchState = 0;
    }

    public boolean canInterceptInPullRefreshView() {
        SwipeMenuLayout swipeMenuLayout = this.mTouchView;
        if ((swipeMenuLayout != null && swipeMenuLayout.isOpen()) || this.mTouchState == 1) {
            return false;
        }
        return true;
    }

    public Interpolator getCloseInterpolator() {
        return this.mCloseInterpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.mOpenInterpolator;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && this.mTouchView == null) {
            return super.onTouchEvent(motionEvent);
        }
        MotionEventCompat.getActionMasked(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this.mTouchState == 1) {
                            SwipeMenuLayout swipeMenuLayout = this.mTouchView;
                            if (swipeMenuLayout != null) {
                                swipeMenuLayout.smoothCloseMenu();
                            }
                            this.mTouchState = 0;
                        }
                        this.mTouchPosition = -1;
                        this.mTouchView = null;
                    }
                } else {
                    float abs = Math.abs(motionEvent.getY() - this.mDownY);
                    float abs2 = Math.abs(motionEvent.getX() - this.mDownX);
                    int i = this.mTouchState;
                    if (i == 1) {
                        SwipeMenuLayout swipeMenuLayout2 = this.mTouchView;
                        if (swipeMenuLayout2 != null) {
                            swipeMenuLayout2.onSwipe(motionEvent);
                        }
                        getSelector().setState(new int[]{0});
                        motionEvent.setAction(3);
                        super.onTouchEvent(motionEvent);
                        return true;
                    } else if (i == 0) {
                        if (Math.abs(abs) > this.mMaxY) {
                            this.mTouchState = 2;
                        } else if (abs2 > this.mMaxX) {
                            this.mTouchState = 1;
                            OnSwipeListener onSwipeListener = this.mOnSwipeListener;
                            if (onSwipeListener != null) {
                                onSwipeListener.onSwipeStart(this.mTouchPosition);
                            }
                            motionEvent.setAction(3);
                            super.onTouchEvent(motionEvent);
                            return true;
                        }
                    }
                }
            } else if (this.mTouchState == 1) {
                SwipeMenuLayout swipeMenuLayout3 = this.mTouchView;
                if (swipeMenuLayout3 != null) {
                    swipeMenuLayout3.onSwipe(motionEvent);
                    if (!this.mTouchView.isOpen()) {
                        this.mTouchPosition = -1;
                        this.mTouchView = null;
                    }
                }
                OnSwipeListener onSwipeListener2 = this.mOnSwipeListener;
                if (onSwipeListener2 != null) {
                    onSwipeListener2.onSwipeEnd(this.mTouchPosition);
                }
                this.mTouchState = 0;
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mTouchState = 0;
            this.mTouchPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            SwipeMenuLayout swipeMenuLayout4 = this.mTouchView;
            if (swipeMenuLayout4 != null && swipeMenuLayout4.isOpen()) {
                this.mTouchView.smoothCloseMenu();
                this.mTouchView = null;
                this.mTouchState = 0;
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
            View childAt = getChildAt(this.mTouchPosition - getFirstVisiblePosition());
            if (childAt instanceof SwipeMenuLayout) {
                this.mTouchView = (SwipeMenuLayout) childAt;
            } else {
                this.mTouchView = null;
            }
            SwipeMenuLayout swipeMenuLayout5 = this.mTouchView;
            if (swipeMenuLayout5 != null) {
                swipeMenuLayout5.onSwipe(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) new SwipeMenuAdapter(getContext(), listAdapter) { // from class: com.baidu.searchbox.ui.swipe.SwipeMenuListView.1
            @Override // com.baidu.searchbox.ui.swipe.SwipeMenuAdapter, com.baidu.searchbox.ui.swipe.SwipeMenuView.OnSwipeItemClickListener
            public void onItemClick(SwipeMenuView swipeMenuView, SwipeMenu swipeMenu, int i) {
                boolean z;
                if (SwipeMenuListView.this.mOnMenuItemClickListener != null) {
                    z = SwipeMenuListView.this.mOnMenuItemClickListener.onMenuItemClick(swipeMenuView.getPosition(), swipeMenu, i);
                } else {
                    z = false;
                }
                SwipeMenuLayout swipeMenuLayout = SwipeMenuListView.this.mTouchView;
                if (swipeMenuLayout != null && !z) {
                    swipeMenuLayout.smoothCloseMenu();
                }
            }

            @Override // com.baidu.searchbox.ui.swipe.SwipeMenuAdapter
            public void createMenu(SwipeMenu swipeMenu) {
                if (SwipeMenuListView.this.mMenuCreator != null) {
                    SwipeMenuListView.this.mMenuCreator.create(swipeMenu);
                }
            }
        });
    }
}
