package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class FullScreenFloatView extends FrameLayout {
    private static final int ANIMATION_TIME = 300;
    private static final int BOTTOM = 4;
    private static final boolean DEBUG = false;
    private static final int LEFT = 1;
    private static final int MIN_DISTANCE = 10;
    private static final int RIGHT = 2;
    private static final String TAG = "FullScreenFloatView";
    private static final int TOP = 3;
    private CheckClick mCheckClick;
    private DragImageClickListener mDragImageListener;
    private View mFloatImgView;
    private int mFloatViewHeight;
    private int mFloatViewWidth;
    private boolean mIsClickDrag;
    private boolean mIsTouchDrag;
    private int mParentHeight;
    private int mParentWidth;
    private float mStartX;
    private float mStartY;
    private int mStatusBarHeight;

    /* loaded from: classes2.dex */
    public interface DragImageClickListener {
        void onClick();

        void onDrag();
    }

    public DragImageClickListener getDragImageListener() {
        return this.mDragImageListener;
    }

    public void setDragImageListener(DragImageClickListener dragImageClickListener) {
        this.mDragImageListener = dragImageClickListener;
    }

    /* loaded from: classes2.dex */
    private class CheckClick implements Runnable {
        private CheckClick() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.mIsClickDrag = false;
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mCheckClick = new CheckClick();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mCheckClick = new CheckClick();
        setStatusBarHeight();
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier > 0) {
            this.mStatusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById = findViewById(R.id.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i);
        }
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(R.id.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void dragInit(View view) {
        if (this.mParentWidth == 0) {
            this.mParentWidth = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.mFloatViewWidth = view.getWidth();
        this.mFloatViewHeight = view.getHeight();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                if (this.mFloatImgView == null) {
                    this.mFloatImgView = findViewById(R.id.float_imgview);
                    dragInit(this.mFloatImgView);
                }
                this.mFloatImgView.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.mIsTouchDrag = true;
                    this.mStartX = x;
                    this.mStartY = y;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mParentWidth = getWidth();
        this.mParentHeight = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.mFloatImgView.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.mStartX = x;
                    this.mStartY = y;
                    this.mIsTouchDrag = true;
                    this.mIsClickDrag = true;
                    postDelayed(this.mCheckClick, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.mIsClickDrag) {
                    if (this.mDragImageListener != null) {
                        this.mDragImageListener.onClick();
                    }
                    removeCallbacks(this.mCheckClick);
                } else if (this.mIsTouchDrag && this.mDragImageListener != null) {
                    this.mDragImageListener.onDrag();
                }
                if (!this.mIsClickDrag && x > this.mFloatViewWidth / 2 && x < this.mParentWidth - (this.mFloatViewWidth / 2) && y > this.mFloatViewHeight / 2 && y < this.mParentHeight - (this.mFloatViewHeight / 2)) {
                    int minDistance = minDistance(x, y);
                    switch (minDistance) {
                        case 1:
                            break;
                        case 2:
                            f = this.mParentWidth - this.mFloatViewWidth;
                            break;
                        case 3:
                            y = 0.0f;
                            f = x;
                            break;
                        case 4:
                            y = this.mParentHeight - this.mFloatViewHeight;
                            f = x;
                            break;
                        default:
                            f = x;
                            break;
                    }
                    switch (minDistance) {
                        case 1:
                        case 2:
                            this.mFloatImgView.animate().x(f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                        case 3:
                        case 4:
                            this.mFloatImgView.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            break;
                    }
                }
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
                break;
            case 2:
                float abs = Math.abs(x - this.mStartX);
                float abs2 = Math.abs(y - this.mStartY);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.mIsClickDrag = false;
                }
                move(x, y);
                break;
            case 3:
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
                break;
            case 4:
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
                break;
        }
        return this.mIsClickDrag || this.mIsTouchDrag;
    }

    private int minDistance(float f, float f2) {
        boolean z = f <= ((float) this.mParentWidth) - f;
        boolean z2 = f2 <= ((float) this.mParentHeight) - f2;
        if (z && z2) {
            return f <= f2 ? 1 : 3;
        } else if (z && !z2) {
            return f > ((float) this.mParentHeight) - f2 ? 4 : 1;
        } else if (!z && z2) {
            return ((float) this.mParentWidth) - f <= f2 ? 2 : 3;
        } else if (z || z2) {
            return 0;
        } else {
            return ((float) this.mParentWidth) - f <= ((float) this.mParentHeight) - f2 ? 2 : 4;
        }
    }

    private void move(float f, float f2) {
        if (this.mFloatImgView != null) {
            int i = (int) (f - (this.mFloatViewWidth / 2));
            int i2 = (int) (f2 - (this.mFloatViewHeight / 2));
            if (i <= 0) {
                i = 0;
            }
            int i3 = i2 > 0 ? i2 : 0;
            int i4 = i > this.mParentWidth - this.mFloatViewWidth ? this.mParentWidth - this.mFloatViewWidth : i;
            if (i3 > this.mParentHeight - this.mFloatViewHeight) {
                i3 = this.mParentHeight - this.mFloatViewHeight;
            }
            int i5 = (this.mParentWidth - i4) - this.mFloatViewWidth;
            int i6 = (this.mParentHeight - i3) - this.mFloatViewHeight;
            this.mFloatImgView.setX(i4);
            this.mFloatImgView.setY(i3);
            requestLayout();
        }
    }

    public void moveToDefaultPosition() {
        if (this.mFloatImgView != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dimens_21dp);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.dimens_51dp);
            this.mFloatImgView.animate().x((AiAppsUIUtils.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.mFloatViewWidth).y((AiAppsUIUtils.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.mFloatViewHeight).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mParentWidth = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        moveToDefaultPosition();
    }
}
