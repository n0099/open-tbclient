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
    public Paint f40521a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f40522b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f40523c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f40524d;

    /* renamed from: e  reason: collision with root package name */
    public int f40525e;

    /* renamed from: f  reason: collision with root package name */
    public int f40526f;

    /* renamed from: g  reason: collision with root package name */
    public int f40527g;

    /* renamed from: h  reason: collision with root package name */
    public float f40528h;

    /* renamed from: i  reason: collision with root package name */
    public float f40529i;

    /* renamed from: j  reason: collision with root package name */
    public String f40530j;

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
            float f2 = width - (this.f40527g / 2);
            canvas.drawCircle(width, width, f2, this.f40521a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f40524d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f40524d, -90.0f, this.f40529i, false, this.f40522b);
            canvas.drawText(this.f40530j, width - (this.f40523c.measureText(this.f40530j) / 2.0f), width, this.f40523c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f40530j = i2 + "%";
            this.f40529i = (float) ((i2 * 360) / 100);
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
        this.f40530j = "";
        this.f40527g = h.a(context, 3.0f);
        this.f40528h = h.a(context, 24.0f);
        this.f40525e = Color.parseColor("#E1DDDD");
        this.f40526f = Color.parseColor("#3C76FF");
        this.f40521a = new Paint();
        this.f40522b = new Paint();
        this.f40523c = new Paint();
        this.f40524d = new RectF();
        this.f40521a.setColor(this.f40525e);
        this.f40521a.setStyle(Paint.Style.STROKE);
        this.f40521a.setStrokeWidth(this.f40527g);
        this.f40521a.setAntiAlias(true);
        this.f40521a.setStrokeCap(Paint.Cap.ROUND);
        this.f40522b.setColor(this.f40526f);
        this.f40522b.setStyle(Paint.Style.STROKE);
        this.f40522b.setStrokeWidth(this.f40527g);
        this.f40522b.setAntiAlias(true);
        this.f40522b.setStrokeCap(Paint.Cap.ROUND);
        this.f40523c.setStrokeWidth(0.0f);
        this.f40523c.setColor(this.f40526f);
        this.f40523c.setTextSize(this.f40528h);
        this.f40523c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
