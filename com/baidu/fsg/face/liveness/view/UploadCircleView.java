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
/* loaded from: classes2.dex */
public class UploadCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f6228a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6229b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6230c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6231d;

    /* renamed from: e  reason: collision with root package name */
    public int f6232e;

    /* renamed from: f  reason: collision with root package name */
    public int f6233f;

    /* renamed from: g  reason: collision with root package name */
    public int f6234g;

    /* renamed from: h  reason: collision with root package name */
    public float f6235h;

    /* renamed from: i  reason: collision with root package name */
    public float f6236i;
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
            float f2 = width - (this.f6234g / 2);
            canvas.drawCircle(width, width, f2, this.f6228a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f6231d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f6231d, -90.0f, this.f6236i, false, this.f6229b);
            canvas.drawText(this.j, width - (this.f6230c.measureText(this.j) / 2.0f), width, this.f6230c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j = i2 + "%";
            this.f6236i = (float) ((i2 * 360) / 100);
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
        this.f6234g = h.a(context, 3.0f);
        this.f6235h = h.a(context, 24.0f);
        this.f6232e = Color.parseColor("#E1DDDD");
        this.f6233f = Color.parseColor("#3C76FF");
        this.f6228a = new Paint();
        this.f6229b = new Paint();
        this.f6230c = new Paint();
        this.f6231d = new RectF();
        this.f6228a.setColor(this.f6232e);
        this.f6228a.setStyle(Paint.Style.STROKE);
        this.f6228a.setStrokeWidth(this.f6234g);
        this.f6228a.setAntiAlias(true);
        this.f6228a.setStrokeCap(Paint.Cap.ROUND);
        this.f6229b.setColor(this.f6233f);
        this.f6229b.setStyle(Paint.Style.STROKE);
        this.f6229b.setStrokeWidth(this.f6234g);
        this.f6229b.setAntiAlias(true);
        this.f6229b.setStrokeCap(Paint.Cap.ROUND);
        this.f6230c.setStrokeWidth(0.0f);
        this.f6230c.setColor(this.f6233f);
        this.f6230c.setTextSize(this.f6235h);
        this.f6230c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
