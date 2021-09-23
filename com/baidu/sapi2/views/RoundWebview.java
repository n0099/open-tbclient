package com.baidu.sapi2.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import c.a.c0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RoundWebview extends SapiWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f45008a;

    /* renamed from: b  reason: collision with root package name */
    public float f45009b;

    /* renamed from: c  reason: collision with root package name */
    public float f45010c;

    /* renamed from: d  reason: collision with root package name */
    public float f45011d;

    /* renamed from: e  reason: collision with root package name */
    public int f45012e;

    /* renamed from: f  reason: collision with root package name */
    public int f45013f;

    /* renamed from: g  reason: collision with root package name */
    public int f45014g;

    /* renamed from: h  reason: collision with root package name */
    public int f45015h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f45016i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f45017j;
    public float[] k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45008a = 0.0f;
        this.f45009b = 0.0f;
        this.f45010c = 0.0f;
        this.f45011d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, attributeSet) == null) {
            Paint paint = new Paint();
            this.f45016i = paint;
            paint.setColor(-1);
            this.f45016i.setAntiAlias(true);
            this.f45016i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.f45017j = paint2;
            paint2.setXfermode(null);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_RoundWebview);
            this.f45008a = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_left, 0.0f);
            this.f45009b = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_top_right, 0.0f);
            this.f45010c = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_left, 0.0f);
            float dimension = obtainStyledAttributes.getDimension(i.sapi_sdk_RoundWebview_sapi_sdk_bottom_right, 0.0f);
            this.f45011d = dimension;
            a(this.f45008a, this.f45009b, dimension, this.f45010c);
        }
    }

    @Override // com.baidu.sapi2.SapiWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f45014g = getScrollX();
            this.f45015h = getScrollY();
            Path path = new Path();
            int i2 = this.f45015h;
            path.addRoundRect(new RectF(0.0f, i2, this.f45014g + this.f45012e, i2 + this.f45013f), this.k, Path.Direction.CW);
            canvas.clipPath(path);
            super.onDraw(canvas);
        }
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f45012e = getMeasuredWidth();
            this.f45013f = getMeasuredHeight();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundWebview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45008a = 0.0f;
        this.f45009b = 0.0f;
        this.f45010c = 0.0f;
        this.f45011d = 0.0f;
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = this.k;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f3;
            fArr[4] = f4;
            fArr[5] = f4;
            fArr[6] = f5;
            fArr[7] = f5;
        }
    }
}
