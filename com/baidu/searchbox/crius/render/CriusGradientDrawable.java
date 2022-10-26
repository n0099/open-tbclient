package com.baidu.searchbox.crius.render;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 J!\u0010$\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!¢\u0006\u0004\b$\u0010%J-\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!¢\u0006\u0004\b*\u0010+J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001e¢\u0006\u0004\b*\u0010-J!\u0010.\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!¢\u0006\u0004\b.\u0010%R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010/R\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u00103R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00101R\u0016\u0010;\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101¨\u0006>"}, d2 = {"Lcom/baidu/searchbox/crius/render/CriusGradientDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "", "getOpacity", "()I", Key.ALPHA, "setAlpha", "(I)V", "Landroid/graphics/Rect;", "bounds", "setBounds", "(Landroid/graphics/Rect;)V", "left", "top", "right", "bottom", "(IIII)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "", "colors", "setColors", "([I)V", "", NativeConstants.LOCATIONS, "([I[F)V", "", "x", "y", "setEnd", "(Ljava/lang/Float;Ljava/lang/Float;)V", "tl", "tr", "bl", TtmlNode.TAG_BR, "setRadii", "(FFFF)V", "radii", "([F)V", "setStart", "[I", "endX", "F", "endY", "[F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "startX", "startY", "<init>", "()V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class CriusGradientDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] colors;
    public float endX;
    public float endY;
    public float[] locations;
    public final Paint paint;
    public float[] radii;
    public RectF rect;
    public float startX;
    public float startY;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, colorFilter) == null) {
        }
    }

    public CriusGradientDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.paint = new Paint();
        this.rect = new RectF();
        this.colors = new int[0];
        this.radii = new float[8];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Paint paint = this.paint;
            RectF rectF = this.rect;
            float f = rectF.right;
            float f2 = rectF.bottom;
            paint.setShader(new LinearGradient(this.startX * f, this.startY * f2, this.endX * f, f2 * this.endY, this.colors, this.locations, Shader.TileMode.CLAMP));
            Path path = new Path();
            path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
            canvas.drawPath(path, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.setBounds(i, i2, i3, i4);
            this.rect = new RectF(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect bounds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bounds) == null) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            super.setBounds(bounds);
            this.rect = new RectF(bounds.left, bounds.top, bounds.right, bounds.bottom);
        }
    }

    public final void setColors(int[] colors) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colors) == null) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            int[] copyOf = Arrays.copyOf(colors, colors.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            this.colors = copyOf;
        }
    }

    public final void setRadii(float[] radii) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, radii) == null) {
            Intrinsics.checkNotNullParameter(radii, "radii");
            float[] copyOf = Arrays.copyOf(radii, radii.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            this.radii = copyOf;
        }
    }

    public final void setColors(int[] colors, float[] fArr) {
        float[] fArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, colors, fArr) == null) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            int[] copyOf = Arrays.copyOf(colors, colors.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            this.colors = copyOf;
            if (fArr != null) {
                fArr2 = Arrays.copyOf(fArr, fArr.length);
                Intrinsics.checkNotNullExpressionValue(fArr2, "java.util.Arrays.copyOf(this, size)");
            } else {
                fArr2 = null;
            }
            this.locations = fArr2;
        }
    }

    public final void setEnd(Float f, Float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f, f2) == null) {
            float f4 = 0.0f;
            if (f != null) {
                f3 = f.floatValue();
            } else {
                f3 = 0.0f;
            }
            this.endX = f3;
            if (f2 != null) {
                f4 = f2.floatValue();
            }
            this.endY = f4;
        }
    }

    public final void setStart(Float f, Float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, f, f2) == null) {
            float f4 = 0.0f;
            if (f != null) {
                f3 = f.floatValue();
            } else {
                f3 = 0.0f;
            }
            this.startX = f3;
            if (f2 != null) {
                f4 = f2.floatValue();
            }
            this.startY = f4;
        }
    }

    public final void setRadii(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.radii = new float[]{f, f, f2, f2, f4, f4, f3, f3};
        }
    }
}
