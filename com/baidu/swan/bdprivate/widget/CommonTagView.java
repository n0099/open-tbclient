package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.r0.a.z2.n0;
import c.a.r0.b.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class CommonTagView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f40916e;

    /* renamed from: f  reason: collision with root package name */
    public int f40917f;

    /* renamed from: g  reason: collision with root package name */
    public int f40918g;

    /* renamed from: h  reason: collision with root package name */
    public int f40919h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40920i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40921j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f40922k;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.CommonTagView);
            this.f40917f = obtainStyledAttributes.getDimensionPixelOffset(j.CommonTagView_borderWidth, 1);
            this.f40918g = obtainStyledAttributes.getColor(j.CommonTagView_borderColor, -16777216);
            this.f40919h = obtainStyledAttributes.getDimensionPixelOffset(j.CommonTagView_cornerRadius, 3);
            obtainStyledAttributes.recycle();
            setPadding(getPaddingLeft() == 0 ? n0.f(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? n0.f(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? n0.f(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? n0.f(context, 1.0f) : getPaddingBottom());
            b(context);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f40916e = context;
            this.f40922k = new Paint();
            this.l = new RectF();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f40920i) {
                this.f40922k.setStyle(Paint.Style.STROKE);
                this.f40922k.setAntiAlias(true);
                this.f40922k.setStrokeWidth(this.f40917f);
                if (this.f40921j && this.f40918g != getCurrentTextColor()) {
                    this.f40918g = getCurrentTextColor();
                }
                this.f40922k.setColor(this.f40918g);
                RectF rectF = this.l;
                int i2 = this.f40917f;
                rectF.left = i2 * 0.5f;
                rectF.top = i2 * 0.5f;
                rectF.right = getMeasuredWidth() - (this.f40917f * 0.5f);
                this.l.bottom = getMeasuredHeight() - (this.f40917f * 0.5f);
                RectF rectF2 = this.l;
                int i3 = this.f40919h;
                canvas.drawRoundRect(rectF2, i3, i3, this.f40922k);
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
        this.f40920i = true;
        this.f40921j = true;
        a(context, attributeSet, i2);
    }
}
