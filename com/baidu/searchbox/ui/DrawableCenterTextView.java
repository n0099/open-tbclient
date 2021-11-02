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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.UIUtils;
import com.baidu.android.common.others.java.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DrawableCenterTextView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 1;
    public static final int POSITION_UNKNOWN = -1;
    public static final float STANDARD_CORNER_RADIUS = 4.0f;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawableCenterTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void generateNextAnimationFrame() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.mRoundDrawable == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mOutShadowPaint == null) {
            Paint paint = new Paint();
            this.mOutShadowPaint = paint;
            paint.setColor(0);
            this.mOutShadowPaint.setStyle(Paint.Style.STROKE);
            this.mOutShadowPaint.setAntiAlias(true);
            this.mOutShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    private boolean isEnableHandlePress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.isPressEnable && this.mBgColor != null : invokeV.booleanValue;
    }

    private void onDrawBackground(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, canvas) == null) && isEnableHandlePress()) {
            float f2 = this.mCornerRadius;
            if (f2 >= 0.0f) {
                this.mRoundDrawable.setCornerRadius(f2);
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
    }

    private void onDrawSingleBorder(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, canvas) == null) {
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
            int i2 = this.mSingleBorderDirect;
            float f5 = 0.0f;
            if (i2 == 0) {
                f2 = height;
                f3 = 0.0f;
                f4 = 0.0f;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    f4 = width;
                    f2 = height;
                    f5 = getWidth();
                } else if (i2 != 3) {
                    f4 = width;
                    f2 = height;
                } else {
                    f4 = width;
                    f2 = height;
                    f3 = getHeight();
                }
                f3 = 0.0f;
            } else {
                f4 = width;
                f3 = 0.0f;
                f2 = 0.0f;
            }
            canvas.drawLine(f5, f3, f4, f2, paint);
        }
    }

    private void onDrawableAndTextRelocated(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            int i9 = 0;
            if (compoundDrawables != null) {
                i2 = 0;
                while (i2 < compoundDrawables.length) {
                    if (compoundDrawables[i2] != null) {
                        drawable = compoundDrawables[i2];
                        break;
                    }
                    i2++;
                }
            }
            drawable = null;
            i2 = -1;
            int textViewWidth = UIUtils.getTextViewWidth(this);
            int textViewHeight = UIUtils.getTextViewHeight(this);
            int compoundDrawablePadding = getCompoundDrawablePadding();
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                i3 = bounds.right - bounds.left;
                i4 = bounds.bottom - bounds.top;
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (i2 == 0 || i2 == 2) {
                i5 = i3 + textViewWidth + compoundDrawablePadding;
                i6 = 0;
            } else {
                i6 = (i2 == 1 || i2 == 3) ? textViewHeight + i4 + compoundDrawablePadding : 0;
                i5 = 0;
            }
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (i2 == 0) {
                setGravity(19);
                i7 = width - i5;
            } else {
                if (i2 == 1) {
                    setGravity(49);
                    i8 = height - i6;
                } else if (i2 == 2) {
                    setGravity(21);
                    i9 = i5 - width;
                    i8 = 0;
                } else if (i2 != 3) {
                    setGravity(19);
                    i7 = width - textViewWidth;
                } else {
                    setGravity(81);
                    i8 = i6 - height;
                }
                canvas.translate(i9 / 2, i8 / 2);
            }
            i9 = i7;
            i8 = 0;
            canvas.translate(i9 / 2, i8 / 2);
        }
    }

    public void initBgColor(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) {
            if (UIUtils.isColorValid(obj) && UIUtils.isColorValid(obj2)) {
                this.mBgColor = new Pair<>(obj, obj2);
                this.isPressEnable = true;
                return;
            }
            this.isPressEnable = false;
        }
    }

    public void initBorderColor(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            if (!UIUtils.isColorValid(obj)) {
                this.isDrawBorder = false;
                return;
            }
            this.isDrawBorder = true;
            this.mBorderColor = obj;
        }
    }

    public void initCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mCornerRadius = i2;
        }
    }

    public void initDrawable(Drawable drawable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048579, this, drawable, i2, i3, i4) == null) || drawable == null || i2 <= -1 || i2 > 3) {
            return;
        }
        if (i3 <= 0 || i4 <= 0) {
            i3 = drawable.getIntrinsicWidth();
            i4 = drawable.getIntrinsicHeight();
        }
        drawable.setBounds(0, 0, i3, i4);
        if (i2 == 0) {
            setCompoundDrawables(drawable, null, null, null);
        } else if (i2 == 1) {
            setCompoundDrawables(null, drawable, null, null);
        } else if (i2 == 2) {
            setCompoundDrawables(null, null, drawable, null);
        } else if (i2 != 3) {
        } else {
            setCompoundDrawables(null, null, null, drawable);
        }
    }

    public void initSingleBorder(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, obj, i2) == null) {
            if (!UIUtils.isColorValid(obj)) {
                this.isDrawSingleBorder = false;
            } else if (i2 >= 0 && i2 <= 3) {
                this.isDrawSingleBorder = true;
                this.mSingleBorderColor = obj;
                this.mSingleBorderDirect = i2;
            } else {
                this.isDrawSingleBorder = false;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            onDrawBackground(canvas);
            onDrawableAndTextRelocated(canvas);
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setAnimationModeActive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsAnimationActive = z;
        }
    }

    public void setAnimationPercent(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) || this.mAnimationPercent == f2) {
            return;
        }
        this.mAnimationPercent = f2;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            initShadowPaint();
            RectF rectF = new RectF(f2, f2, f2, f2);
            rectF.offset(f3, f4);
            float f5 = rectF.left;
            int i3 = f5 < 0.0f ? 0 : (int) (f5 + 0.5f);
            float f6 = rectF.right;
            int i4 = f6 < 0.0f ? 0 : (int) (f6 + 0.5f);
            float f7 = rectF.top;
            int i5 = f7 < 0.0f ? 0 : (int) (f7 + 0.5f);
            float f8 = rectF.bottom;
            setPadding(i3, i5, i4, f8 >= 0.0f ? (int) (f8 + 0.5f) : 0);
            this.mOutShadowPaint.setShadowLayer(f2, f3, f4, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRoundDrawable = new GradientDrawable();
        this.mOutShadowPaint = null;
        this.mRoundPath = new Path();
        this.mBgColor = null;
        this.isPressed = false;
        this.mCornerRadius = -1.0f;
        this.mAnimationPercent = 0.0f;
    }
}
