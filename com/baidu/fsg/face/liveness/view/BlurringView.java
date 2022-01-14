package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BlurringView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f34365b;

    /* renamed from: c  reason: collision with root package name */
    public View f34366c;

    /* renamed from: d  reason: collision with root package name */
    public int f34367d;

    /* renamed from: e  reason: collision with root package name */
    public int f34368e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34369f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f34370g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f34371h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f34372i;

    /* renamed from: j  reason: collision with root package name */
    public RenderScript f34373j;
    public ScriptIntrinsicBlur k;
    public Allocation l;
    public Allocation m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurringView(Context context) {
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

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            RenderScript create = RenderScript.create(context);
            this.f34373j = create;
            this.k = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        }
    }

    public void blur() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.copyFrom(this.f34370g);
            this.k.setInput(this.l);
            this.k.forEach(this.m);
            this.m.copyTo(this.f34371h);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            RenderScript renderScript = this.f34373j;
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f34366c != null) {
                if (prepare()) {
                    if (this.f34366c.getBackground() != null && (this.f34366c.getBackground() instanceof ColorDrawable)) {
                        this.f34370g.eraseColor(((ColorDrawable) this.f34366c.getBackground()).getColor());
                    } else {
                        this.f34370g.eraseColor(0);
                    }
                    this.f34366c.draw(this.f34372i);
                    blur();
                    canvas.save();
                    canvas.translate(this.f34366c.getX() - getX(), this.f34366c.getY() - getY());
                    int i2 = this.a;
                    canvas.scale(i2, i2);
                    canvas.drawBitmap(this.f34371h, 0.0f, 0.0f, (Paint) null);
                    canvas.restore();
                }
                canvas.drawColor(this.f34365b);
            }
        }
    }

    public boolean prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int width = this.f34366c.getWidth();
            int height = this.f34366c.getHeight();
            if (this.f34372i == null || this.f34369f || this.f34367d != width || this.f34368e != height) {
                this.f34369f = false;
                this.f34367d = width;
                this.f34368e = height;
                int i2 = this.a;
                int i3 = width / i2;
                int i4 = height / i2;
                int i5 = (i3 - (i3 % 4)) + 4;
                int i6 = (i4 - (i4 % 4)) + 4;
                Bitmap bitmap = this.f34371h;
                if (bitmap == null || bitmap.getWidth() != i5 || this.f34371h.getHeight() != i6) {
                    Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                    this.f34370g = createBitmap;
                    if (createBitmap == null) {
                        return false;
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                    this.f34371h = createBitmap2;
                    if (createBitmap2 == null) {
                        return false;
                    }
                }
                Canvas canvas = new Canvas(this.f34370g);
                this.f34372i = canvas;
                int i7 = this.a;
                canvas.scale(1.0f / i7, 1.0f / i7);
                Allocation createFromBitmap = Allocation.createFromBitmap(this.f34373j, this.f34370g, Allocation.MipmapControl.MIPMAP_NONE, 1);
                this.l = createFromBitmap;
                this.m = Allocation.createTyped(this.f34373j, createFromBitmap.getType());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setBlurRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.k.setRadius(i2);
        }
    }

    public void setBlurredView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f34366c = view;
        }
    }

    public void setDownsampleFactor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 > 0) {
                if (this.a != i2) {
                    this.a = i2;
                    this.f34369f = true;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
    }

    public void setOverlayColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f34365b = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int parseColor = Color.parseColor("#96FFFFFF");
        a(context);
        setBlurRadius(11);
        setDownsampleFactor(6);
        setOverlayColor(parseColor);
    }
}
