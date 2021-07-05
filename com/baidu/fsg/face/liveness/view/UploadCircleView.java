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
/* loaded from: classes3.dex */
public class UploadCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f6211a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6212b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6213c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6214d;

    /* renamed from: e  reason: collision with root package name */
    public int f6215e;

    /* renamed from: f  reason: collision with root package name */
    public int f6216f;

    /* renamed from: g  reason: collision with root package name */
    public int f6217g;

    /* renamed from: h  reason: collision with root package name */
    public float f6218h;

    /* renamed from: i  reason: collision with root package name */
    public float f6219i;
    public String j;

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
            float f2 = width - (this.f6217g / 2);
            canvas.drawCircle(width, width, f2, this.f6211a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f6214d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f6214d, -90.0f, this.f6219i, false, this.f6212b);
            canvas.drawText(this.j, width - (this.f6213c.measureText(this.j) / 2.0f), width, this.f6213c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j = i2 + "%";
            this.f6219i = (float) ((i2 * 360) / 100);
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
        this.j = "";
        this.f6217g = h.a(context, 3.0f);
        this.f6218h = h.a(context, 24.0f);
        this.f6215e = Color.parseColor("#E1DDDD");
        this.f6216f = Color.parseColor("#3C76FF");
        this.f6211a = new Paint();
        this.f6212b = new Paint();
        this.f6213c = new Paint();
        this.f6214d = new RectF();
        this.f6211a.setColor(this.f6215e);
        this.f6211a.setStyle(Paint.Style.STROKE);
        this.f6211a.setStrokeWidth(this.f6217g);
        this.f6211a.setAntiAlias(true);
        this.f6211a.setStrokeCap(Paint.Cap.ROUND);
        this.f6212b.setColor(this.f6216f);
        this.f6212b.setStyle(Paint.Style.STROKE);
        this.f6212b.setStrokeWidth(this.f6217g);
        this.f6212b.setAntiAlias(true);
        this.f6212b.setStrokeCap(Paint.Cap.ROUND);
        this.f6213c.setStrokeWidth(0.0f);
        this.f6213c.setColor(this.f6216f);
        this.f6213c.setTextSize(this.f6218h);
        this.f6213c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
