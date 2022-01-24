package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LivenessCircleProgressView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34436b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f34437c;

    /* renamed from: d  reason: collision with root package name */
    public int f34438d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f34439e;

    /* renamed from: f  reason: collision with root package name */
    public int f34440f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessCircleProgressView(@NonNull Context context) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f34440f = 12;
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(Color.argb(127, 255, 255, 255));
            this.a.setAntiAlias(true);
            this.a.setStrokeWidth(this.f34440f);
            this.a.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f34436b = paint2;
            paint2.setColor(Color.argb(255, 255, 255, 255));
            this.f34436b.setAntiAlias(true);
            this.f34436b.setStrokeWidth(this.f34440f);
            this.f34436b.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f34437c = paint3;
            paint3.setColor(Color.rgb(255, 255, 255));
            this.f34437c.setAntiAlias(true);
            this.f34437c.setTextSize(getResources().getDimensionPixelSize(R.dimen.rim_text_size_20));
            this.f34437c.setTextAlign(Paint.Align.CENTER);
            this.f34439e = new RectF();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - (this.f34440f / 2), this.a);
            RectF rectF = this.f34439e;
            int i2 = this.f34440f;
            rectF.left = i2 / 2;
            rectF.top = i2 / 2;
            rectF.right = getWidth() - (this.f34440f / 2);
            this.f34439e.bottom = getHeight() - (this.f34440f / 2);
            canvas.drawArc(this.f34439e, -90.0f, (this.f34438d / 100.0f) * 360.0f, false, this.f34436b);
            canvas.drawText(this.f34438d + "%", getWidth() / 2, getHeight() / 2, this.f34437c);
        }
    }

    public void updateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f34438d = i2;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessCircleProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a();
    }
}
