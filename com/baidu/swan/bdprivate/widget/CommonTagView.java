package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CommonTagView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f29387b;

    /* renamed from: c  reason: collision with root package name */
    public int f29388c;

    /* renamed from: d  reason: collision with root package name */
    public int f29389d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29390e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29391f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f29392g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f29393h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTagView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400dc, R.attr.obfuscated_res_0x7f0400e0, R.attr.obfuscated_res_0x7f04018b, R.attr.obfuscated_res_0x7f040624});
            this.f29387b = obtainStyledAttributes.getDimensionPixelOffset(1, 1);
            this.f29388c = obtainStyledAttributes.getColor(0, -16777216);
            this.f29389d = obtainStyledAttributes.getDimensionPixelOffset(2, 3);
            obtainStyledAttributes.recycle();
            setPadding(getPaddingLeft() == 0 ? n0.f(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? n0.f(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? n0.f(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? n0.f(context, 1.0f) : getPaddingBottom());
            b(context);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            this.f29392g = new Paint();
            this.f29393h = new RectF();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f29390e) {
                this.f29392g.setStyle(Paint.Style.STROKE);
                this.f29392g.setAntiAlias(true);
                this.f29392g.setStrokeWidth(this.f29387b);
                if (this.f29391f && this.f29388c != getCurrentTextColor()) {
                    this.f29388c = getCurrentTextColor();
                }
                this.f29392g.setColor(this.f29388c);
                RectF rectF = this.f29393h;
                int i = this.f29387b;
                rectF.left = i * 0.5f;
                rectF.top = i * 0.5f;
                rectF.right = getMeasuredWidth() - (this.f29387b * 0.5f);
                this.f29393h.bottom = getMeasuredHeight() - (this.f29387b * 0.5f);
                RectF rectF2 = this.f29393h;
                int i2 = this.f29389d;
                canvas.drawRoundRect(rectF2, i2, i2, this.f29392g);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f29390e = true;
        this.f29391f = true;
        a(context, attributeSet, i);
    }
}
