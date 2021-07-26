package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.n0;
import d.a.o0.b.h;
/* loaded from: classes3.dex */
public class CommonTagView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f11693e;

    /* renamed from: f  reason: collision with root package name */
    public int f11694f;

    /* renamed from: g  reason: collision with root package name */
    public int f11695g;

    /* renamed from: h  reason: collision with root package name */
    public int f11696h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11697i;
    public boolean j;
    public Paint k;
    public RectF l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTagView(Context context) {
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

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.CommonTagView);
            this.f11694f = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_borderWidth, 1);
            this.f11695g = obtainStyledAttributes.getColor(h.CommonTagView_borderColor, -16777216);
            this.f11696h = obtainStyledAttributes.getDimensionPixelOffset(h.CommonTagView_cornerRadius, 3);
            obtainStyledAttributes.recycle();
            setPadding(getPaddingLeft() == 0 ? n0.f(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? n0.f(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? n0.f(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? n0.f(context, 1.0f) : getPaddingBottom());
            b(context);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f11693e = context;
            this.k = new Paint();
            this.l = new RectF();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f11697i) {
                this.k.setStyle(Paint.Style.STROKE);
                this.k.setAntiAlias(true);
                this.k.setStrokeWidth(this.f11694f);
                if (this.j && this.f11695g != getCurrentTextColor()) {
                    this.f11695g = getCurrentTextColor();
                }
                this.k.setColor(this.f11695g);
                RectF rectF = this.l;
                int i2 = this.f11694f;
                rectF.left = i2 * 0.5f;
                rectF.top = i2 * 0.5f;
                rectF.right = getMeasuredWidth() - (this.f11694f * 0.5f);
                this.l.bottom = getMeasuredHeight() - (this.f11694f * 0.5f);
                RectF rectF2 = this.l;
                int i3 = this.f11696h;
                canvas.drawRoundRect(rectF2, i3, i3, this.k);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
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
    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f11697i = true;
        this.j = true;
        a(context, attributeSet, i2);
    }
}
