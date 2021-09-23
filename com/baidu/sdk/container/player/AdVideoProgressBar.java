package com.baidu.sdk.container.player;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AdVideoProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f45111e;

    /* renamed from: f  reason: collision with root package name */
    public int f45112f;

    /* renamed from: g  reason: collision with root package name */
    public int f45113g;

    /* renamed from: h  reason: collision with root package name */
    public int f45114h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f45115i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f45116j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoProgressBar(Context context) {
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
        this.f45112f = -7829368;
        this.f45113g = -16777216;
        this.f45114h = 4;
        this.f45115i = new Paint();
        this.f45116j = new Rect();
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45111e : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            getDrawingRect(this.f45116j);
            Rect rect = this.f45116j;
            this.f45115i.setStyle(Paint.Style.STROKE);
            this.f45115i.setStrokeWidth(this.f45114h);
            this.f45115i.setStrokeCap(Paint.Cap.SQUARE);
            this.f45115i.setAlpha(204);
            this.f45115i.setAntiAlias(true);
            this.f45115i.setColor(this.f45113g);
            Rect rect2 = this.f45116j;
            float f2 = (rect.top + rect.bottom) / 2;
            canvas.drawLine(rect2.left, f2, rect2.right, f2, this.f45115i);
            this.f45115i.setColor(this.f45112f);
            canvas.drawLine(this.f45116j.left, f2, i2 + ((int) (((rect.right - rect.left) * this.f45111e) / 100.0f)), f2, this.f45115i);
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f45111e = f2 * 100.0f;
            invalidate();
        }
    }

    public void setProgressBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f45113g = i2;
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f45112f = i2;
        }
    }

    public void setProgressHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f45114h = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
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
        this.f45112f = -7829368;
        this.f45113g = -16777216;
        this.f45114h = 4;
        this.f45115i = new Paint();
        this.f45116j = new Rect();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f45112f = -7829368;
        this.f45113g = -16777216;
        this.f45114h = 4;
        this.f45115i = new Paint();
        this.f45116j = new Rect();
    }
}
