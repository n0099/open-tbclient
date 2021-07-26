package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CustomProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6139a;

    /* renamed from: b  reason: collision with root package name */
    public int f6140b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6141c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f6142d;

    /* renamed from: e  reason: collision with root package name */
    public float f6143e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6144f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f6145g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6145g = new RectF();
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) || context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomProgressBar);
            this.f6143e = typedArray.getFloat(R.styleable.CustomProgressBar_mpb_percent, 0.0f);
            this.f6139a = typedArray.getColor(R.styleable.CustomProgressBar_mpb_fill_color, 0);
            this.f6140b = typedArray.getColor(R.styleable.CustomProgressBar_mpb_background_color, 0);
            this.f6144f = typedArray.getBoolean(R.styleable.CustomProgressBar_mpb_flat, false);
            Paint paint = new Paint();
            this.f6141c = paint;
            paint.setColor(this.f6139a);
            this.f6141c.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f6142d = paint2;
            paint2.setColor(this.f6140b);
            this.f6142d.setAntiAlias(true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6140b : invokeV.intValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6139a : invokeV.intValue;
    }

    public float getPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6143e : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            float f2 = this.f6143e;
            canvas.save();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            float measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            float f3 = f2 * measuredWidth;
            float f4 = measuredHeight;
            float f5 = f4 / 2.0f;
            RectF rectF = this.f6145g;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = measuredWidth;
            rectF.bottom = f4;
            if (this.f6140b != 0) {
                canvas.drawRoundRect(rectF, f5, f5, this.f6142d);
            }
            try {
                if (this.f6139a != 0 && f3 > 0.0f) {
                    if (f3 == measuredWidth) {
                        this.f6145g.right = f3;
                        canvas.drawRoundRect(this.f6145g, f5, f5, this.f6141c);
                    } else if (this.f6144f) {
                        canvas.save();
                        this.f6145g.right = f3 > f5 ? f5 : f3;
                        canvas.clipRect(this.f6145g);
                        this.f6145g.right = 2.0f * f5;
                        canvas.drawRoundRect(this.f6145g, f5, f5, this.f6141c);
                        canvas.restore();
                        if (f3 <= f5) {
                            return;
                        }
                        float f6 = measuredWidth - f5;
                        float f7 = f3 > f6 ? f6 : f3;
                        this.f6145g.left = f5;
                        this.f6145g.right = f7;
                        canvas.drawRect(this.f6145g, this.f6141c);
                        if (f3 <= f6) {
                            return;
                        }
                        this.f6145g.left = f6 - f5;
                        this.f6145g.right = f3;
                        canvas.clipRect(this.f6145g);
                        this.f6145g.right = measuredWidth;
                        canvas.drawArc(this.f6145g, -90.0f, 180.0f, true, this.f6141c);
                    } else {
                        float f8 = 2.0f * f5;
                        if (f3 <= f8) {
                            this.f6145g.right = f3;
                            canvas.clipRect(this.f6145g);
                            this.f6145g.right = f8;
                            canvas.drawRoundRect(this.f6145g, f5, f5, this.f6141c);
                        } else {
                            this.f6145g.right = f3;
                            canvas.drawRoundRect(this.f6145g, f5, f5, this.f6141c);
                        }
                    }
                }
            } finally {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f6140b == i2) {
            return;
        }
        this.f6140b = i2;
        this.f6142d.setColor(i2);
        invalidate();
    }

    public void setFillColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f6139a == i2) {
            return;
        }
        this.f6139a = i2;
        this.f6141c.setColor(i2);
        invalidate();
    }

    public void setFlat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f6144f == z) {
            return;
        }
        this.f6144f = z;
        invalidate();
    }

    public void setPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float max = Math.max(0.0f, Math.min(1.0f, f2));
            if (this.f6143e != max) {
                this.f6143e = max;
                postInvalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressBar(Context context, AttributeSet attributeSet) {
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
        this.f6145g = new RectF();
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f6145g = new RectF();
        a(context, attributeSet);
    }
}
