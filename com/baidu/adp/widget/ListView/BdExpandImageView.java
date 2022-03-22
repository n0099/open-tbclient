package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BdExpandImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f23943b;

    /* renamed from: c  reason: collision with root package name */
    public final float f23944c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f23945d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f23946e;

    /* renamed from: f  reason: collision with root package name */
    public int f23947f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23948g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f23949h;
    public float i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.f23945d = new Rect();
        this.f23946e = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400c5, R.attr.obfuscated_res_0x7f0401ee});
        this.a = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.f23943b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        int i3 = getResources().getDisplayMetrics().widthPixels;
        this.f23944c = this.f23943b + (this.a * 2.0f);
        this.f23949h = new Paint();
        getResources().getDisplayMetrics();
    }

    public final void a() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = intrinsicHeight / 10.0f;
        this.i = f2;
        this.f23947f = (int) (intrinsicHeight - (((f2 * ((this.f23944c - measuredHeight) / 2.0f)) / this.a) * 2.0f));
    }

    public boolean getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (drawable = getDrawable()) == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.f23947f;
        int i2 = (height - i) / 2;
        this.f23945d.set(0, i2, width, i + i2);
        int width2 = getWidth();
        float f2 = width;
        float max = Math.max(width2 / f2, getHeight() / this.f23947f);
        int i3 = (int) (f2 * max);
        int i4 = (i3 - width2) / 2;
        this.f23946e.set(-i4, 0, i3 - (i4 * 2), (int) (this.f23947f * max));
        canvas.drawBitmap(bitmap, this.f23945d, this.f23946e, this.f23949h);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            a();
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i, i2, i3, i4)) == null) {
            this.f23948g = true;
            return super.setFrame(i, i2, i3, i4);
        }
        return invokeIIII.booleanValue;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            if (this.f23948g) {
                a();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            super.setImageDrawable(drawable);
            if (this.f23948g) {
                a();
            }
        }
    }
}
