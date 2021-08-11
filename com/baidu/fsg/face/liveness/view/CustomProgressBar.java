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
/* loaded from: classes5.dex */
public class CustomProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40116a;

    /* renamed from: b  reason: collision with root package name */
    public int f40117b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f40118c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f40119d;

    /* renamed from: e  reason: collision with root package name */
    public float f40120e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40121f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f40122g;

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
        this.f40122g = new RectF();
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
            this.f40120e = typedArray.getFloat(R.styleable.CustomProgressBar_mpb_percent, 0.0f);
            this.f40116a = typedArray.getColor(R.styleable.CustomProgressBar_mpb_fill_color, 0);
            this.f40117b = typedArray.getColor(R.styleable.CustomProgressBar_mpb_background_color, 0);
            this.f40121f = typedArray.getBoolean(R.styleable.CustomProgressBar_mpb_flat, false);
            Paint paint = new Paint();
            this.f40118c = paint;
            paint.setColor(this.f40116a);
            this.f40118c.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f40119d = paint2;
            paint2.setColor(this.f40117b);
            this.f40119d.setAntiAlias(true);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40117b : invokeV.intValue;
    }

    public int getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40116a : invokeV.intValue;
    }

    public float getPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40120e : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            float f2 = this.f40120e;
            canvas.save();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            float measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            float f3 = f2 * measuredWidth;
            float f4 = measuredHeight;
            float f5 = f4 / 2.0f;
            RectF rectF = this.f40122g;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = measuredWidth;
            rectF.bottom = f4;
            if (this.f40117b != 0) {
                canvas.drawRoundRect(rectF, f5, f5, this.f40119d);
            }
            try {
                if (this.f40116a != 0 && f3 > 0.0f) {
                    if (f3 == measuredWidth) {
                        this.f40122g.right = f3;
                        canvas.drawRoundRect(this.f40122g, f5, f5, this.f40118c);
                    } else if (this.f40121f) {
                        canvas.save();
                        this.f40122g.right = f3 > f5 ? f5 : f3;
                        canvas.clipRect(this.f40122g);
                        this.f40122g.right = 2.0f * f5;
                        canvas.drawRoundRect(this.f40122g, f5, f5, this.f40118c);
                        canvas.restore();
                        if (f3 <= f5) {
                            return;
                        }
                        float f6 = measuredWidth - f5;
                        float f7 = f3 > f6 ? f6 : f3;
                        this.f40122g.left = f5;
                        this.f40122g.right = f7;
                        canvas.drawRect(this.f40122g, this.f40118c);
                        if (f3 <= f6) {
                            return;
                        }
                        this.f40122g.left = f6 - f5;
                        this.f40122g.right = f3;
                        canvas.clipRect(this.f40122g);
                        this.f40122g.right = measuredWidth;
                        canvas.drawArc(this.f40122g, -90.0f, 180.0f, true, this.f40118c);
                    } else {
                        float f8 = 2.0f * f5;
                        if (f3 <= f8) {
                            this.f40122g.right = f3;
                            canvas.clipRect(this.f40122g);
                            this.f40122g.right = f8;
                            canvas.drawRoundRect(this.f40122g, f5, f5, this.f40118c);
                        } else {
                            this.f40122g.right = f3;
                            canvas.drawRoundRect(this.f40122g, f5, f5, this.f40118c);
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
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f40117b == i2) {
            return;
        }
        this.f40117b = i2;
        this.f40119d.setColor(i2);
        invalidate();
    }

    public void setFillColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f40116a == i2) {
            return;
        }
        this.f40116a = i2;
        this.f40118c.setColor(i2);
        invalidate();
    }

    public void setFlat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f40121f == z) {
            return;
        }
        this.f40121f = z;
        invalidate();
    }

    public void setPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float max = Math.max(0.0f, Math.min(1.0f, f2));
            if (this.f40120e != max) {
                this.f40120e = max;
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
        this.f40122g = new RectF();
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
        this.f40122g = new RectF();
        a(context, attributeSet);
    }
}
