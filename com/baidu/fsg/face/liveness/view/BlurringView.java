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
    public int f35519b;

    /* renamed from: c  reason: collision with root package name */
    public View f35520c;

    /* renamed from: d  reason: collision with root package name */
    public int f35521d;

    /* renamed from: e  reason: collision with root package name */
    public int f35522e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35523f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f35524g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f35525h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f35526i;

    /* renamed from: j  reason: collision with root package name */
    public RenderScript f35527j;

    /* renamed from: k  reason: collision with root package name */
    public ScriptIntrinsicBlur f35528k;
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
            this.f35527j = create;
            this.f35528k = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        }
    }

    public void blur() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.copyFrom(this.f35524g);
            this.f35528k.setInput(this.l);
            this.f35528k.forEach(this.m);
            this.m.copyTo(this.f35525h);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            RenderScript renderScript = this.f35527j;
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
            if (this.f35520c != null) {
                if (prepare()) {
                    if (this.f35520c.getBackground() != null && (this.f35520c.getBackground() instanceof ColorDrawable)) {
                        this.f35524g.eraseColor(((ColorDrawable) this.f35520c.getBackground()).getColor());
                    } else {
                        this.f35524g.eraseColor(0);
                    }
                    this.f35520c.draw(this.f35526i);
                    blur();
                    canvas.save();
                    canvas.translate(this.f35520c.getX() - getX(), this.f35520c.getY() - getY());
                    int i2 = this.a;
                    canvas.scale(i2, i2);
                    canvas.drawBitmap(this.f35525h, 0.0f, 0.0f, (Paint) null);
                    canvas.restore();
                }
                canvas.drawColor(this.f35519b);
            }
        }
    }

    public boolean prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int width = this.f35520c.getWidth();
            int height = this.f35520c.getHeight();
            if (this.f35526i == null || this.f35523f || this.f35521d != width || this.f35522e != height) {
                this.f35523f = false;
                this.f35521d = width;
                this.f35522e = height;
                int i2 = this.a;
                int i3 = width / i2;
                int i4 = height / i2;
                int i5 = (i3 - (i3 % 4)) + 4;
                int i6 = (i4 - (i4 % 4)) + 4;
                Bitmap bitmap = this.f35525h;
                if (bitmap == null || bitmap.getWidth() != i5 || this.f35525h.getHeight() != i6) {
                    Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                    this.f35524g = createBitmap;
                    if (createBitmap == null) {
                        return false;
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                    this.f35525h = createBitmap2;
                    if (createBitmap2 == null) {
                        return false;
                    }
                }
                Canvas canvas = new Canvas(this.f35524g);
                this.f35526i = canvas;
                int i7 = this.a;
                canvas.scale(1.0f / i7, 1.0f / i7);
                Allocation createFromBitmap = Allocation.createFromBitmap(this.f35527j, this.f35524g, Allocation.MipmapControl.MIPMAP_NONE, 1);
                this.l = createFromBitmap;
                this.m = Allocation.createTyped(this.f35527j, createFromBitmap.getType());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setBlurRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f35528k.setRadius(i2);
        }
    }

    public void setBlurredView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f35520c = view;
        }
    }

    public void setDownsampleFactor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 > 0) {
                if (this.a != i2) {
                    this.a = i2;
                    this.f35523f = true;
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
            this.f35519b = i2;
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
