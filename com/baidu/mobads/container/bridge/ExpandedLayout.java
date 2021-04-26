package com.baidu.mobads.container.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class ExpandedLayout extends FrameLayout {
    public static final float CLOSE_BUTTON_PADDING_DP = 8.0f;
    public static final float CLOSE_BUTTON_SIZE_DP = 30.0f;
    public static final float CLOSE_REGION_SIZE_DP = 50.0f;
    public final Rect mClosableLayoutRect;
    public boolean mCloseBoundChanged;
    public final Rect mCloseButtonBounds;
    public final int mCloseButtonPadding;
    public final int mCloseButtonSize;
    public final BitmapDrawable mCloseDrawable;
    public ClosePosition mClosePosition;
    public final Rect mCloseRegionBounds;
    public final int mCloseRegionSize;
    public final Rect mInsetCloseRegionBounds;
    public KeyDownListener mKeyDownListener;
    public OnCloseListener mOnCloseListener;
    public final int mTouchSlop;
    public UnsetPressedState mUnsetPressedState;

    /* loaded from: classes2.dex */
    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        public final int mGravity;

        ClosePosition(int i2) {
            this.mGravity = i2;
        }

        public int getGravity() {
            return this.mGravity;
        }
    }

    /* loaded from: classes2.dex */
    public interface KeyDownListener {
        boolean handleKeyDown(int i2, KeyEvent keyEvent);
    }

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes2.dex */
    public final class UnsetPressedState implements Runnable {
        public UnsetPressedState() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpandedLayout.this.setClosePressed(false);
        }
    }

    public ExpandedLayout(Context context, Bitmap bitmap) {
        super(context);
        this.mClosableLayoutRect = new Rect();
        this.mCloseRegionBounds = new Rect();
        this.mCloseButtonBounds = new Rect();
        this.mInsetCloseRegionBounds = new Rect();
        this.mKeyDownListener = null;
        this.mCloseDrawable = new BitmapDrawable(context.getResources(), bitmap);
        this.mClosePosition = ClosePosition.TOP_RIGHT;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mCloseRegionSize = (int) (50.0f * f2);
        this.mCloseButtonSize = (int) (30.0f * f2);
        this.mCloseButtonPadding = (int) (f2 * 8.0f);
        setWillNotDraw(false);
    }

    private void applyCloseBoundsWithSize(ClosePosition closePosition, int i2, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.getGravity(), i2, i2, rect, rect2);
    }

    private void applyCloseButtonBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        applyCloseBoundsWithSize(closePosition, this.mCloseButtonSize, rect, rect2);
    }

    private void performClose() {
        playSoundEffect(0);
        OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == isClosePressed()) {
            return;
        }
        this.mCloseDrawable.setState(z ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.mCloseRegionBounds);
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        applyCloseBoundsWithSize(closePosition, this.mCloseRegionSize, rect, rect2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mCloseBoundChanged) {
            this.mCloseBoundChanged = false;
            this.mClosableLayoutRect.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.mClosePosition, this.mClosableLayoutRect, this.mCloseRegionBounds);
            this.mInsetCloseRegionBounds.set(this.mCloseRegionBounds);
            Rect rect = this.mInsetCloseRegionBounds;
            int i2 = this.mCloseButtonPadding;
            rect.inset(i2, i2);
            applyCloseButtonBounds(this.mClosePosition, this.mInsetCloseRegionBounds, this.mCloseButtonBounds);
            this.mCloseDrawable.setBounds(this.mCloseButtonBounds);
        }
        if (this.mCloseDrawable.isVisible()) {
            this.mCloseDrawable.draw(canvas);
        }
    }

    public boolean isClosePressed() {
        return this.mCloseDrawable.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        KeyDownListener keyDownListener = this.mKeyDownListener;
        if (keyDownListener == null) {
            return false;
        }
        return keyDownListener.handleKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mCloseBoundChanged = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!pointInCloseBounds((int) motionEvent.getX(), (int) motionEvent.getY(), this.mTouchSlop)) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (isClosePressed()) {
            if (this.mUnsetPressedState == null) {
                this.mUnsetPressedState = new UnsetPressedState();
            }
            postDelayed(this.mUnsetPressedState, ViewConfiguration.getPressedStateDuration());
            performClose();
        }
        return true;
    }

    public boolean pointInCloseBounds(int i2, int i3, int i4) {
        Rect rect = this.mCloseRegionBounds;
        return i2 >= rect.left - i4 && i3 >= rect.top - i4 && i2 < rect.right + i4 && i3 < rect.bottom + i4;
    }

    public void setClosePosition(ClosePosition closePosition) {
        if (closePosition == null) {
            return;
        }
        this.mClosePosition = closePosition;
        this.mCloseBoundChanged = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.mCloseDrawable.setVisible(z, false)) {
            invalidate(this.mCloseRegionBounds);
        }
    }

    public void setKeyDownListener(KeyDownListener keyDownListener) {
        this.mKeyDownListener = keyDownListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }
}
