package com.baidu.searchbox.ui;

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
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
/* loaded from: classes4.dex */
public class FullScreenFloatView extends FrameLayout {
    public static final int ANIMATION_TIME = 300;
    public static final int BOTTOM = 4;
    public static final boolean DEBUG = false;
    public static final int LEFT = 1;
    public static final int MIN_DISTANCE = 10;
    public static final int RIGHT = 2;
    public static final String TAG = "FullScreenFloatView";
    public static final int TOP = 3;
    public CheckClick mCheckClick;
    public DragImageClickListener mDragImageListener;
    public View mFloatImgView;
    public int mFloatViewHeight;
    public int mFloatViewWidth;
    public boolean mIsClickDrag;
    public boolean mIsTouchDrag;
    public int mParentHeight;
    public int mParentWidth;
    public float mStartX;
    public float mStartY;
    public int mStatusBarHeight;

    /* loaded from: classes4.dex */
    public interface DragImageClickListener {
        void onClick();

        void onDrag();
    }

    /* loaded from: classes4.dex */
    public class CheckClick implements Runnable {
        public CheckClick() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullScreenFloatView.this.mIsClickDrag = false;
        }
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mCheckClick = new CheckClick();
        setStatusBarHeight();
    }

    public FullScreenFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarHeight = 66;
        this.mIsClickDrag = false;
        this.mIsTouchDrag = false;
        this.mCheckClick = new CheckClick();
        setStatusBarHeight();
    }

    private int minDistance(float f, float f2) {
        boolean z;
        boolean z2;
        if (f <= this.mParentWidth - f) {
            z = true;
        } else {
            z = false;
        }
        if (f2 <= this.mParentHeight - f2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if (f <= f2) {
                return 1;
            }
            return 3;
        } else if (z && !z2) {
            if (f <= this.mParentHeight - f2) {
                return 1;
            }
            return 4;
        } else if ((!z) & z2) {
            if (this.mParentWidth - f > f2) {
                return 3;
            }
            return 2;
        } else if (!((!z) & (true ^ z2))) {
            return 0;
        } else {
            if (this.mParentWidth - f > this.mParentHeight - f2) {
                return 4;
            }
            return 2;
        }
    }

    private void move(float f, float f2) {
        if (this.mFloatImgView == null) {
            return;
        }
        int i = (int) (f - (this.mFloatViewWidth / 2));
        int i2 = (int) (f2 - (this.mFloatViewHeight / 2));
        if (i <= 0) {
            i = 0;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        int i3 = this.mParentWidth;
        int i4 = this.mFloatViewWidth;
        if (i > i3 - i4) {
            i = i3 - i4;
        }
        int i5 = this.mParentHeight;
        int i6 = this.mFloatViewHeight;
        if (i2 > i5 - i6) {
            i2 = i5 - i6;
        }
        this.mFloatImgView.setX(i);
        this.mFloatImgView.setY(i2);
        requestLayout();
    }

    public void dragInit(View view2) {
        if (this.mParentWidth == 0) {
            this.mParentWidth = getWidth();
        }
        if (this.mParentHeight == 0) {
            this.mParentHeight = getHeight();
        }
        this.mFloatViewWidth = view2.getWidth();
        this.mFloatViewHeight = view2.getHeight();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mParentWidth = getHeight() + this.mStatusBarHeight;
        this.mParentHeight = getWidth() - this.mStatusBarHeight;
        moveToDefaultPosition();
    }

    public void setDragImageListener(DragImageClickListener dragImageClickListener) {
        this.mDragImageListener = dragImageClickListener;
    }

    public void setFloatButtonText(String str) {
        View findViewById = findViewById(com.baidu.tieba.R.id.float_imgview);
        if (findViewById instanceof Button) {
            ((Button) findViewById).setText(str);
        }
    }

    public void setFloatImageBackground(int i) {
        View findViewById = findViewById(com.baidu.tieba.R.id.float_imgview);
        if (findViewById != null) {
            findViewById.setBackgroundResource(i);
        }
    }

    public DragImageClickListener getDragImageListener() {
        return this.mDragImageListener;
    }

    public void setStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
        if (identifier > 0) {
            this.mStatusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
    }

    public void moveToDefaultPosition() {
        if (this.mFloatImgView != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070349);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07034d);
            this.mFloatImgView.animate().x((DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) - dimensionPixelOffset) - this.mFloatViewWidth).y((DeviceUtil.ScreenInfo.getDisplayHeight(getContext()) - dimensionPixelOffset2) - this.mFloatViewHeight).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            if (this.mFloatImgView == null) {
                View findViewById = findViewById(com.baidu.tieba.R.id.float_imgview);
                this.mFloatImgView = findViewById;
                dragInit(findViewById);
            }
            this.mFloatImgView.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.mIsTouchDrag = true;
                this.mStartX = x;
                this.mStartY = y;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mParentWidth = getWidth();
        this.mParentHeight = getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DragImageClickListener dragImageClickListener;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 4) {
                            this.mIsClickDrag = false;
                            this.mIsTouchDrag = false;
                        }
                    } else {
                        this.mIsClickDrag = false;
                        this.mIsTouchDrag = false;
                    }
                } else {
                    float abs = Math.abs(x - this.mStartX);
                    float abs2 = Math.abs(y - this.mStartY);
                    if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                        this.mIsClickDrag = false;
                    }
                    move(x, y);
                }
            } else {
                if (this.mIsClickDrag) {
                    DragImageClickListener dragImageClickListener2 = this.mDragImageListener;
                    if (dragImageClickListener2 != null) {
                        dragImageClickListener2.onClick();
                    }
                    removeCallbacks(this.mCheckClick);
                } else if (this.mIsTouchDrag && (dragImageClickListener = this.mDragImageListener) != null) {
                    dragImageClickListener.onDrag();
                }
                if (!this.mIsClickDrag) {
                    int i = this.mFloatViewWidth;
                    if (x > i / 2 && x < this.mParentWidth - (i / 2)) {
                        int i2 = this.mFloatViewHeight;
                        if (y > i2 / 2 && y < this.mParentHeight - (i2 / 2)) {
                            int minDistance = minDistance(x, y);
                            if (minDistance != 1) {
                                if (minDistance != 2) {
                                    if (minDistance != 3) {
                                        if (minDistance == 4) {
                                            y = this.mParentHeight - this.mFloatViewHeight;
                                        }
                                    } else {
                                        y = 0.0f;
                                    }
                                } else {
                                    x = this.mParentWidth - this.mFloatViewWidth;
                                }
                            } else {
                                x = 0.0f;
                            }
                            if (minDistance != 1 && minDistance != 2) {
                                if (minDistance == 3 || minDistance == 4) {
                                    this.mFloatImgView.animate().y(y).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                                }
                            } else {
                                this.mFloatImgView.animate().x(x).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                            }
                        }
                    }
                }
                this.mIsClickDrag = false;
                this.mIsTouchDrag = false;
            }
        } else {
            this.mFloatImgView.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.mStartX = x;
                this.mStartY = y;
                this.mIsTouchDrag = true;
                this.mIsClickDrag = true;
                postDelayed(this.mCheckClick, ViewConfiguration.getTapTimeout());
            }
        }
        return this.mIsClickDrag | this.mIsTouchDrag;
    }
}
