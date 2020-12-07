package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.android.common.others.UIUtils;
import com.baidu.android.common.others.java.Pair;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes20.dex */
public class DrawableCenterTextView extends TextView {
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 1;
    public static final int POSITION_UNKNOWN = -1;
    private static final float STANDARD_CORNER_RADIUS = 4.0f;
    private boolean isDrawBg;
    private boolean isDrawBorder;
    private boolean isDrawSingleBorder;
    private boolean isPressEnable;
    private boolean isPressed;
    private float mAnimationPercent;
    private Pair<Object, Object> mBgColor;
    private Object mBorderColor;
    private float mCornerRadius;
    private boolean mIsAnimationActive;
    private Paint mOutShadowPaint;
    private GradientDrawable mRoundDrawable;
    private Path mRoundPath;
    private Object mSingleBorderColor;
    private int mSingleBorderDirect;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRoundDrawable = new GradientDrawable();
        this.mOutShadowPaint = null;
        this.mRoundPath = new Path();
        this.mBgColor = null;
        this.isPressed = false;
        this.mCornerRadius = -1.0f;
        this.mAnimationPercent = 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        onDrawBackground(canvas);
        onDrawableAndTextRelocated(canvas);
        super.onDraw(canvas);
    }

    private void onDrawableAndTextRelocated(Canvas canvas) {
        int i;
        Drawable drawable;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null) {
            i = 0;
            while (i < compoundDrawables.length) {
                if (compoundDrawables[i] == null) {
                    i++;
                } else {
                    drawable = compoundDrawables[i];
                    break;
                }
            }
        }
        i = -1;
        drawable = null;
        int textViewWidth = UIUtils.getTextViewWidth(this);
        int textViewHeight = UIUtils.getTextViewHeight(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i3 = bounds.right - bounds.left;
            i2 = bounds.bottom - bounds.top;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i == 0 || i == 2) {
            i4 = textViewWidth + i3 + compoundDrawablePadding;
            i5 = 0;
        } else if (i == 1 || i == 3) {
            i5 = i2 + textViewHeight + compoundDrawablePadding;
            i4 = 0;
        } else {
            i5 = 0;
            i4 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        switch (i) {
            case 0:
                setGravity(19);
                i6 = width - i4;
                break;
            case 1:
                setGravity(49);
                i6 = 0;
                i7 = height - i5;
                break;
            case 2:
                setGravity(21);
                i6 = i4 - width;
                break;
            case 3:
                setGravity(81);
                i6 = 0;
                i7 = i5 - height;
                break;
            default:
                setGravity(19);
                i6 = width - textViewWidth;
                break;
        }
        canvas.translate(i6 / 2, i7 / 2);
    }

    private void onDrawBackground(Canvas canvas) {
        if (isEnableHandlePress()) {
            if (this.mCornerRadius >= 0.0f) {
                this.mRoundDrawable.setCornerRadius(this.mCornerRadius);
            } else {
                this.mRoundDrawable.setCornerRadius(4.0f);
            }
            if (this.isDrawBorder) {
                int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f);
                if (this.mBorderColor instanceof String) {
                    this.mRoundDrawable.setStroke(dp2px, Color.parseColor(this.mBorderColor.toString()));
                } else if (this.mBorderColor instanceof Integer) {
                    this.mRoundDrawable.setStroke(dp2px, getResources().getColor(Integer.valueOf(this.mBorderColor.toString()).intValue()));
                }
            }
            if (this.isPressed) {
                if (this.mBgColor.mSecond instanceof String) {
                    this.mRoundDrawable.setColor(Color.parseColor(this.mBgColor.mSecond.toString()));
                } else if (this.mBgColor.mSecond instanceof Integer) {
                    this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mSecond.toString()).intValue()));
                }
            } else if (this.mBgColor.mFirst instanceof String) {
                this.mRoundDrawable.setColor(Color.parseColor(this.mBgColor.mFirst.toString()));
            } else if (this.mBgColor.mFirst instanceof Integer) {
                this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mFirst.toString()).intValue()));
            }
            canvas.save();
            if (this.mIsAnimationActive) {
                generateNextAnimationFrame();
            } else {
                this.mRoundDrawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.mRoundDrawable.draw(canvas);
            if (this.isDrawSingleBorder) {
                onDrawSingleBorder(canvas);
            }
            canvas.restore();
        }
    }

    private void onDrawSingleBorder(Canvas canvas) {
        float height;
        float f;
        float width = getWidth();
        float height2 = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f));
        if (this.mSingleBorderColor instanceof String) {
            paint.setColor(Color.parseColor(this.mSingleBorderColor.toString()));
        } else if (this.mSingleBorderColor instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.mSingleBorderColor.toString()).intValue()));
        }
        switch (this.mSingleBorderDirect) {
            case 0:
                width = 0.0f;
                height = 0.0f;
                f = 0.0f;
                break;
            case 1:
                height2 = 0.0f;
                height = 0.0f;
                f = 0.0f;
                break;
            case 2:
                f = getWidth();
                height = 0.0f;
                break;
            case 3:
                height = getHeight();
                f = 0.0f;
                break;
            default:
                height = 0.0f;
                f = 0.0f;
                break;
        }
        canvas.drawLine(f, height, width, height2, paint);
    }

    public void setAnimationPercent(float f) {
        if (this.mAnimationPercent != f) {
            this.mAnimationPercent = f;
            postInvalidate();
        }
    }

    public void setAnimationModeActive(boolean z) {
        this.mIsAnimationActive = z;
    }

    private void generateNextAnimationFrame() {
        if (this.mRoundDrawable != null) {
            int[] iArr = {getWidth(), getHeight()};
            if (this.mIsAnimationActive) {
                iArr[0] = (int) (getWidth() * this.mAnimationPercent);
                iArr[1] = getHeight();
            }
            int width = getWidth() / 2;
            this.mRoundDrawable.setBounds(width - (iArr[0] / 2), 0, (iArr[0] / 2) + width, getHeight());
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        initShadowPaint();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        setPadding(rectF.left < 0.0f ? 0 : (int) (rectF.left + 0.5f), rectF.top < 0.0f ? 0 : (int) (rectF.top + 0.5f), rectF.right < 0.0f ? 0 : (int) (rectF.right + 0.5f), rectF.bottom >= 0.0f ? (int) (rectF.bottom + 0.5f) : 0);
        this.mOutShadowPaint.setShadowLayer(f, f2, f3, i);
    }

    private void initShadowPaint() {
        if (this.mOutShadowPaint == null) {
            this.mOutShadowPaint = new Paint();
            this.mOutShadowPaint.setColor(0);
            this.mOutShadowPaint.setStyle(Paint.Style.STROKE);
            this.mOutShadowPaint.setAntiAlias(true);
            this.mOutShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public void initDrawable(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null && i > -1 && i <= 3) {
            if (i2 <= 0 || i3 <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i3 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, i3);
            switch (i) {
                case 0:
                    setCompoundDrawables(drawable, null, null, null);
                    return;
                case 1:
                    setCompoundDrawables(null, drawable, null, null);
                    return;
                case 2:
                    setCompoundDrawables(null, null, drawable, null);
                    return;
                case 3:
                    setCompoundDrawables(null, null, null, drawable);
                    return;
                default:
                    return;
            }
        }
    }

    public void initBgColor(Object obj, Object obj2) {
        if (!UIUtils.isColorValid(obj) || !UIUtils.isColorValid(obj2)) {
            this.isPressEnable = false;
            return;
        }
        this.mBgColor = new Pair<>(obj, obj2);
        this.isPressEnable = true;
    }

    public void initBorderColor(Object obj) {
        if (!UIUtils.isColorValid(obj)) {
            this.isDrawBorder = false;
            return;
        }
        this.isDrawBorder = true;
        this.mBorderColor = obj;
    }

    public void initSingleBorder(Object obj, int i) {
        if (!UIUtils.isColorValid(obj)) {
            this.isDrawSingleBorder = false;
        } else if (i < 0 || i > 3) {
            this.isDrawSingleBorder = false;
        } else {
            this.isDrawSingleBorder = true;
            this.mSingleBorderColor = obj;
            this.mSingleBorderDirect = i;
        }
    }

    public void initCornerRadius(int i) {
        this.mCornerRadius = i;
    }

    private boolean isEnableHandlePress() {
        return this.isPressEnable && this.mBgColor != null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (isEnableHandlePress()) {
                    this.isPressed = true;
                    invalidate();
                    break;
                }
                break;
            case 1:
                if (isEnableHandlePress()) {
                    this.isPressed = false;
                    invalidate();
                    break;
                }
                break;
            case 3:
                if (isEnableHandlePress()) {
                    this.isPressed = false;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
