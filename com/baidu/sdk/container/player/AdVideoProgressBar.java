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
    public float f45023e;

    /* renamed from: f  reason: collision with root package name */
    public int f45024f;

    /* renamed from: g  reason: collision with root package name */
    public int f45025g;

    /* renamed from: h  reason: collision with root package name */
    public int f45026h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f45027i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f45028j;

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
        this.f45024f = -7829368;
        this.f45025g = -16777216;
        this.f45026h = 4;
        this.f45027i = new Paint();
        this.f45028j = new Rect();
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45023e : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            getDrawingRect(this.f45028j);
            Rect rect = this.f45028j;
            this.f45027i.setStyle(Paint.Style.STROKE);
            this.f45027i.setStrokeWidth(this.f45026h);
            this.f45027i.setStrokeCap(Paint.Cap.SQUARE);
            this.f45027i.setAlpha(204);
            this.f45027i.setAntiAlias(true);
            this.f45027i.setColor(this.f45025g);
            Rect rect2 = this.f45028j;
            float f2 = (rect.top + rect.bottom) / 2;
            canvas.drawLine(rect2.left, f2, rect2.right, f2, this.f45027i);
            this.f45027i.setColor(this.f45024f);
            canvas.drawLine(this.f45028j.left, f2, i2 + ((int) (((rect.right - rect.left) * this.f45023e) / 100.0f)), f2, this.f45027i);
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f45023e = f2 * 100.0f;
            invalidate();
        }
    }

    public void setProgressBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f45025g = i2;
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f45024f = i2;
        }
    }

    public void setProgressHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f45026h = i2;
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
        this.f45024f = -7829368;
        this.f45025g = -16777216;
        this.f45026h = 4;
        this.f45027i = new Paint();
        this.f45028j = new Rect();
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
        this.f45024f = -7829368;
        this.f45025g = -16777216;
        this.f45026h = 4;
        this.f45027i = new Paint();
        this.f45028j = new Rect();
    }
}
