package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.d.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class UploadCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f40517a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f40518b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f40519c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f40520d;

    /* renamed from: e  reason: collision with root package name */
    public int f40521e;

    /* renamed from: f  reason: collision with root package name */
    public int f40522f;

    /* renamed from: g  reason: collision with root package name */
    public int f40523g;

    /* renamed from: h  reason: collision with root package name */
    public float f40524h;

    /* renamed from: i  reason: collision with root package name */
    public float f40525i;

    /* renamed from: j  reason: collision with root package name */
    public String f40526j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UploadCircleView(Context context) {
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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            float width = getWidth() / 2;
            float f2 = width - (this.f40523g / 2);
            canvas.drawCircle(width, width, f2, this.f40517a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f40520d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f40520d, -90.0f, this.f40525i, false, this.f40518b);
            canvas.drawText(this.f40526j, width - (this.f40519c.measureText(this.f40526j) / 2.0f), width, this.f40519c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f40526j = i2 + "%";
            this.f40525i = (float) ((i2 * 360) / 100);
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UploadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40526j = "";
        this.f40523g = h.a(context, 3.0f);
        this.f40524h = h.a(context, 24.0f);
        this.f40521e = Color.parseColor("#E1DDDD");
        this.f40522f = Color.parseColor("#3C76FF");
        this.f40517a = new Paint();
        this.f40518b = new Paint();
        this.f40519c = new Paint();
        this.f40520d = new RectF();
        this.f40517a.setColor(this.f40521e);
        this.f40517a.setStyle(Paint.Style.STROKE);
        this.f40517a.setStrokeWidth(this.f40523g);
        this.f40517a.setAntiAlias(true);
        this.f40517a.setStrokeCap(Paint.Cap.ROUND);
        this.f40518b.setColor(this.f40522f);
        this.f40518b.setStyle(Paint.Style.STROKE);
        this.f40518b.setStrokeWidth(this.f40523g);
        this.f40518b.setAntiAlias(true);
        this.f40518b.setStrokeCap(Paint.Cap.ROUND);
        this.f40519c.setStrokeWidth(0.0f);
        this.f40519c.setColor(this.f40522f);
        this.f40519c.setTextSize(this.f40524h);
        this.f40519c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
