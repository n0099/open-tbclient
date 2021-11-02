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
/* loaded from: classes7.dex */
public class UploadCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f38419a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f38420b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f38421c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f38422d;

    /* renamed from: e  reason: collision with root package name */
    public int f38423e;

    /* renamed from: f  reason: collision with root package name */
    public int f38424f;

    /* renamed from: g  reason: collision with root package name */
    public int f38425g;

    /* renamed from: h  reason: collision with root package name */
    public float f38426h;

    /* renamed from: i  reason: collision with root package name */
    public float f38427i;
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
            float f2 = width - (this.f38425g / 2);
            canvas.drawCircle(width, width, f2, this.f38419a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f38422d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f38422d, -90.0f, this.f38427i, false, this.f38420b);
            canvas.drawText(this.j, width - (this.f38421c.measureText(this.j) / 2.0f), width, this.f38421c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j = i2 + "%";
            this.f38427i = (float) ((i2 * 360) / 100);
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
        this.f38425g = h.a(context, 3.0f);
        this.f38426h = h.a(context, 24.0f);
        this.f38423e = Color.parseColor("#E1DDDD");
        this.f38424f = Color.parseColor("#3C76FF");
        this.f38419a = new Paint();
        this.f38420b = new Paint();
        this.f38421c = new Paint();
        this.f38422d = new RectF();
        this.f38419a.setColor(this.f38423e);
        this.f38419a.setStyle(Paint.Style.STROKE);
        this.f38419a.setStrokeWidth(this.f38425g);
        this.f38419a.setAntiAlias(true);
        this.f38419a.setStrokeCap(Paint.Cap.ROUND);
        this.f38420b.setColor(this.f38424f);
        this.f38420b.setStyle(Paint.Style.STROKE);
        this.f38420b.setStrokeWidth(this.f38425g);
        this.f38420b.setAntiAlias(true);
        this.f38420b.setStrokeCap(Paint.Cap.ROUND);
        this.f38421c.setStrokeWidth(0.0f);
        this.f38421c.setColor(this.f38424f);
        this.f38421c.setTextSize(this.f38426h);
        this.f38421c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
