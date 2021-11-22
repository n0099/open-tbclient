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
    public Paint f39249a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f39250b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f39251c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f39252d;

    /* renamed from: e  reason: collision with root package name */
    public int f39253e;

    /* renamed from: f  reason: collision with root package name */
    public int f39254f;

    /* renamed from: g  reason: collision with root package name */
    public int f39255g;

    /* renamed from: h  reason: collision with root package name */
    public float f39256h;

    /* renamed from: i  reason: collision with root package name */
    public float f39257i;
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
            float f2 = width - (this.f39255g / 2);
            canvas.drawCircle(width, width, f2, this.f39249a);
            float f3 = width - f2;
            float f4 = f2 + width;
            this.f39252d.set(f3, f3, f4, f4);
            canvas.drawArc(this.f39252d, -90.0f, this.f39257i, false, this.f39250b);
            canvas.drawText(this.j, width - (this.f39251c.measureText(this.j) / 2.0f), width, this.f39251c);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j = i2 + "%";
            this.f39257i = (float) ((i2 * 360) / 100);
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
        this.f39255g = h.a(context, 3.0f);
        this.f39256h = h.a(context, 24.0f);
        this.f39253e = Color.parseColor("#E1DDDD");
        this.f39254f = Color.parseColor("#3C76FF");
        this.f39249a = new Paint();
        this.f39250b = new Paint();
        this.f39251c = new Paint();
        this.f39252d = new RectF();
        this.f39249a.setColor(this.f39253e);
        this.f39249a.setStyle(Paint.Style.STROKE);
        this.f39249a.setStrokeWidth(this.f39255g);
        this.f39249a.setAntiAlias(true);
        this.f39249a.setStrokeCap(Paint.Cap.ROUND);
        this.f39250b.setColor(this.f39254f);
        this.f39250b.setStyle(Paint.Style.STROKE);
        this.f39250b.setStrokeWidth(this.f39255g);
        this.f39250b.setAntiAlias(true);
        this.f39250b.setStrokeCap(Paint.Cap.ROUND);
        this.f39251c.setStrokeWidth(0.0f);
        this.f39251c.setColor(this.f39254f);
        this.f39251c.setTextSize(this.f39256h);
        this.f39251c.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
