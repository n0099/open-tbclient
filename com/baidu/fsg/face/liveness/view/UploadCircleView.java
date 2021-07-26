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
    public Paint f6254a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6255b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f6256c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f6257d;

    /* renamed from: e  reason: collision with root package name */
    public int f6258e;

    /* renamed from: f  reason: collision with root package name */
    public int f6259f;

    /* renamed from: g  reason: collision with root package name */
    public int f6260g;

    /* renamed from: h  reason: collision with root package name */
    public float f6261h;

    /* renamed from: i  reason: collision with root package name */
    public float f6262i;
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
            float f2 = width - (this.f6260g / 2);
            canvas.drawCircle(width, width, f2, this.f6254a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f6257d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f6257d, -90.0f, this.f6262i, false, this.f6255b);
            canvas.drawText(this.j, width - (this.f6256c.measureText(this.j) / 2.0f), width, this.f6256c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j = i2 + "%";
            this.f6262i = (float) ((i2 * 360) / 100);
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
        this.f6260g = h.a(context, 3.0f);
        this.f6261h = h.a(context, 24.0f);
        this.f6258e = Color.parseColor("#E1DDDD");
        this.f6259f = Color.parseColor("#3C76FF");
        this.f6254a = new Paint();
        this.f6255b = new Paint();
        this.f6256c = new Paint();
        this.f6257d = new RectF();
        this.f6254a.setColor(this.f6258e);
        this.f6254a.setStyle(Paint.Style.STROKE);
        this.f6254a.setStrokeWidth(this.f6260g);
        this.f6254a.setAntiAlias(true);
        this.f6254a.setStrokeCap(Paint.Cap.ROUND);
        this.f6255b.setColor(this.f6259f);
        this.f6255b.setStyle(Paint.Style.STROKE);
        this.f6255b.setStrokeWidth(this.f6260g);
        this.f6255b.setAntiAlias(true);
        this.f6255b.setStrokeCap(Paint.Cap.ROUND);
        this.f6256c.setStrokeWidth(0.0f);
        this.f6256c.setColor(this.f6259f);
        this.f6256c.setTextSize(this.f6261h);
        this.f6256c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
