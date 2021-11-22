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
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdExpandImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f35385e;

    /* renamed from: f  reason: collision with root package name */
    public final float f35386f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f35387g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f35388h;

    /* renamed from: i  reason: collision with root package name */
    public int f35389i;
    public boolean j;
    public final Paint k;
    public float l;
    public float mCoverHeight;
    public float mCoverWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdExpandImageView(Context context, AttributeSet attributeSet) {
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
        this.f35385e = 0.0f;
        this.f35387g = new Rect();
        this.f35388h = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.f35385e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.mCoverHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.mCoverWidth = getResources().getDisplayMetrics().widthPixels;
        this.f35386f = this.mCoverHeight + (this.f35385e * 2.0f);
        this.k = new Paint();
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
        this.l = f2;
        this.f35389i = (int) (intrinsicHeight - (((f2 * ((this.f35386f - measuredHeight) / 2.0f)) / this.f35385e) * 2.0f));
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
        int i2 = this.f35389i;
        int i3 = (height - i2) / 2;
        this.f35387g.set(0, i3, width, i2 + i3);
        int width2 = getWidth();
        float f2 = width;
        float max = Math.max(width2 / f2, getHeight() / this.f35389i);
        int i4 = (int) (f2 * max);
        int i5 = (i4 - width2) / 2;
        this.f35388h.set(-i5, 0, i4 - (i5 * 2), (int) (this.f35389i * max));
        canvas.drawBitmap(bitmap, this.f35387g, this.f35388h, this.k);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            a();
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048580, this, i2, i3, i4, i5)) == null) {
            this.j = true;
            return super.setFrame(i2, i3, i4, i5);
        }
        return invokeIIII.booleanValue;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            if (this.j) {
                a();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            super.setImageDrawable(drawable);
            if (this.j) {
                a();
            }
        }
    }
}
