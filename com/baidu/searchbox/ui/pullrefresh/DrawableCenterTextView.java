package com.baidu.searchbox.ui.pullrefresh;

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
/* loaded from: classes4.dex */
public class DrawableCenterTextView extends TextView {
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 1;
    public static final int POSITION_UNKNOWN = -1;
    public static final float STANDARD_CORNER_RADIUS = 4.0f;
    public boolean isDrawBg;
    public boolean isDrawBorder;
    public boolean isDrawSingleBorder;
    public boolean isPressEnable;
    public boolean isPressed;
    public float mAnimationPercent;
    public Pair<Object, Object> mBgColor;
    public Object mBorderColor;
    public float mCornerRadius;
    public boolean mIsAnimationActive;
    public Paint mOutShadowPaint;
    public GradientDrawable mRoundDrawable;
    public Path mRoundPath;
    public Object mSingleBorderColor;
    public int mSingleBorderDirect;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public void initBorderColor(Object obj) {
        if (!UIUtils.isColorValid(obj)) {
            this.isDrawBorder = false;
            return;
        }
        this.isDrawBorder = true;
        this.mBorderColor = obj;
    }

    public void initCornerRadius(int i) {
        this.mCornerRadius = i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        onDrawBackground(canvas);
        onDrawableAndTextRelocated(canvas);
        super.onDraw(canvas);
    }

    public void setAnimationModeActive(boolean z) {
        this.mIsAnimationActive = z;
    }

    public void setAnimationPercent(float f) {
        if (this.mAnimationPercent != f) {
            this.mAnimationPercent = f;
            postInvalidate();
        }
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

    public void initBgColor(Object obj, Object obj2) {
        if (UIUtils.isColorValid(obj) && UIUtils.isColorValid(obj2)) {
            this.mBgColor = new Pair<>(obj, obj2);
            this.isPressEnable = true;
            return;
        }
        this.isPressEnable = false;
    }

    public void initSingleBorder(Object obj, int i) {
        if (!UIUtils.isColorValid(obj)) {
            this.isDrawSingleBorder = false;
        } else if (i >= 0 && i <= 3) {
            this.isDrawSingleBorder = true;
            this.mSingleBorderColor = obj;
            this.mSingleBorderDirect = i;
        } else {
            this.isDrawSingleBorder = false;
        }
    }

    private void generateNextAnimationFrame() {
        if (this.mRoundDrawable == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.mIsAnimationActive) {
            iArr[0] = (int) (getWidth() * this.mAnimationPercent);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.mRoundDrawable.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    private void initShadowPaint() {
        if (this.mOutShadowPaint == null) {
            Paint paint = new Paint();
            this.mOutShadowPaint = paint;
            paint.setColor(0);
            this.mOutShadowPaint.setStyle(Paint.Style.STROKE);
            this.mOutShadowPaint.setAntiAlias(true);
            this.mOutShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    private boolean isEnableHandlePress() {
        if (this.isPressEnable && this.mBgColor != null) {
            return true;
        }
        return false;
    }

    private void onDrawBackground(Canvas canvas) {
        if (!isEnableHandlePress()) {
            return;
        }
        float f = this.mCornerRadius;
        if (f >= 0.0f) {
            this.mRoundDrawable.setCornerRadius(f);
        } else {
            this.mRoundDrawable.setCornerRadius(4.0f);
        }
        if (this.isDrawBorder) {
            int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f);
            Object obj = this.mBorderColor;
            if (obj instanceof String) {
                this.mRoundDrawable.setStroke(dp2px, Color.parseColor(obj.toString()));
            } else if (obj instanceof Integer) {
                this.mRoundDrawable.setStroke(dp2px, getResources().getColor(Integer.valueOf(this.mBorderColor.toString()).intValue()));
            }
        }
        if (this.isPressed) {
            Object obj2 = this.mBgColor.mSecond;
            if (obj2 instanceof String) {
                this.mRoundDrawable.setColor(Color.parseColor(obj2.toString()));
            } else if (obj2 instanceof Integer) {
                this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mSecond.toString()).intValue()));
            }
        } else {
            Object obj3 = this.mBgColor.mFirst;
            if (obj3 instanceof String) {
                this.mRoundDrawable.setColor(Color.parseColor(obj3.toString()));
            } else if (obj3 instanceof Integer) {
                this.mRoundDrawable.setColor(getResources().getColor(Integer.valueOf(this.mBgColor.mFirst.toString()).intValue()));
            }
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

    private void onDrawSingleBorder(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float width = getWidth();
        float height = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(getContext(), 0.5f));
        Object obj = this.mSingleBorderColor;
        if (obj instanceof String) {
            paint.setColor(Color.parseColor(obj.toString()));
        } else if (obj instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.mSingleBorderColor.toString()).intValue()));
        }
        int i = this.mSingleBorderDirect;
        float f4 = 0.0f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        f3 = width;
                        f = height;
                    } else {
                        f3 = width;
                        f = height;
                        f2 = getHeight();
                    }
                } else {
                    f3 = width;
                    f = height;
                    f4 = getWidth();
                }
                f2 = 0.0f;
            } else {
                f3 = width;
                f2 = 0.0f;
                f = 0.0f;
            }
        } else {
            f = height;
            f2 = 0.0f;
            f3 = 0.0f;
        }
        canvas.drawLine(f4, f2, f3, f, paint);
    }

    private void onDrawableAndTextRelocated(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable[] compoundDrawables = getCompoundDrawables();
        int i8 = 0;
        if (compoundDrawables != null) {
            i = 0;
            while (i < compoundDrawables.length) {
                if (compoundDrawables[i] != null) {
                    drawable = compoundDrawables[i];
                    break;
                }
                i++;
            }
        }
        drawable = null;
        i = -1;
        int textViewWidth = UIUtils.getTextViewWidth(this);
        int textViewHeight = UIUtils.getTextViewHeight(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.right - bounds.left;
            i3 = bounds.bottom - bounds.top;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i != 0 && i != 2) {
            if (i != 1 && i != 3) {
                i5 = 0;
            } else {
                i5 = textViewHeight + i3 + compoundDrawablePadding;
            }
            i4 = 0;
        } else {
            i4 = i2 + textViewWidth + compoundDrawablePadding;
            i5 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        setGravity(19);
                        i6 = width - textViewWidth;
                    } else {
                        setGravity(81);
                        i7 = i5 - height;
                    }
                } else {
                    setGravity(21);
                    i8 = i4 - width;
                    i7 = 0;
                }
            } else {
                setGravity(49);
                i7 = height - i5;
            }
            canvas.translate(i8 / 2, i7 / 2);
        }
        setGravity(19);
        i6 = width - i4;
        i8 = i6;
        i7 = 0;
        canvas.translate(i8 / 2, i7 / 2);
    }

    public void initDrawable(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null && i > -1 && i <= 3) {
            if (i2 <= 0 || i3 <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i3 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, i3);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            setCompoundDrawables(null, null, null, drawable);
                            return;
                        }
                        return;
                    }
                    setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                setCompoundDrawables(null, drawable, null, null);
                return;
            }
            setCompoundDrawables(drawable, null, null, null);
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        int i2;
        int i3;
        int i4;
        initShadowPaint();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        float f4 = rectF.left;
        int i5 = 0;
        if (f4 < 0.0f) {
            i2 = 0;
        } else {
            i2 = (int) (f4 + 0.5f);
        }
        float f5 = rectF.right;
        if (f5 < 0.0f) {
            i3 = 0;
        } else {
            i3 = (int) (f5 + 0.5f);
        }
        float f6 = rectF.top;
        if (f6 < 0.0f) {
            i4 = 0;
        } else {
            i4 = (int) (f6 + 0.5f);
        }
        float f7 = rectF.bottom;
        if (f7 >= 0.0f) {
            i5 = (int) (f7 + 0.5f);
        }
        setPadding(i2, i4, i3, i5);
        this.mOutShadowPaint.setShadowLayer(f, f2, f3, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3 && isEnableHandlePress()) {
                    this.isPressed = false;
                    invalidate();
                }
            } else if (isEnableHandlePress()) {
                this.isPressed = false;
                invalidate();
            }
        } else if (isEnableHandlePress()) {
            this.isPressed = true;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }
}
