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
/* loaded from: classes10.dex */
public class UploadCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f35640b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f35641c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f35642d;

    /* renamed from: e  reason: collision with root package name */
    public int f35643e;

    /* renamed from: f  reason: collision with root package name */
    public int f35644f;

    /* renamed from: g  reason: collision with root package name */
    public int f35645g;

    /* renamed from: h  reason: collision with root package name */
    public float f35646h;

    /* renamed from: i  reason: collision with root package name */
    public float f35647i;

    /* renamed from: j  reason: collision with root package name */
    public String f35648j;

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
            float f2 = width - (this.f35645g / 2);
            canvas.drawCircle(width, width, f2, this.a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f35642d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f35642d, -90.0f, this.f35647i, false, this.f35640b);
            canvas.drawText(this.f35648j, width - (this.f35641c.measureText(this.f35648j) / 2.0f), width, this.f35641c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f35648j = i2 + "%";
            this.f35647i = (float) ((i2 * 360) / 100);
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
        this.f35648j = "";
        this.f35645g = h.a(context, 3.0f);
        this.f35646h = h.a(context, 24.0f);
        this.f35643e = Color.parseColor("#E1DDDD");
        this.f35644f = Color.parseColor("#3C76FF");
        this.a = new Paint();
        this.f35640b = new Paint();
        this.f35641c = new Paint();
        this.f35642d = new RectF();
        this.a.setColor(this.f35643e);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f35645g);
        this.a.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.f35640b.setColor(this.f35644f);
        this.f35640b.setStyle(Paint.Style.STROKE);
        this.f35640b.setStrokeWidth(this.f35645g);
        this.f35640b.setAntiAlias(true);
        this.f35640b.setStrokeCap(Paint.Cap.ROUND);
        this.f35641c.setStrokeWidth(0.0f);
        this.f35641c.setColor(this.f35644f);
        this.f35641c.setTextSize(this.f35646h);
        this.f35641c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
