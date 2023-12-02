package com.angcyo.tablayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 f2\u00020\u0001:\u0001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u0010H\u0016J\u001c\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u0016H\u0016J\b\u0010C\u001a\u00020\u0001H\u0016J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\bH\u0014J\u0010\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0010H\u0014J\u0010\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020JH\u0014J\u0010\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u0010H\u0016J\u0010\u0010M\u001a\u0002002\u0006\u0010E\u001a\u00020\bH\u0016J(\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0016J\u0012\u0010R\u001a\u0002002\b\u0010S\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\u0016H\u0016J\u0010\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020\u0016H\u0016J\u0018\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020ZH\u0016J(\u0010\\\u001a\u0002002\u0006\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0016J\u0012\u0010]\u001a\u0002002\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010`\u001a\u0002002\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010c\u001a\u0002002\b\u0010d\u001a\u0004\u0018\u00010eH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u0012R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0011\u0010'\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u0011\u0010)\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b*\u0010\u0012R\u0011\u0010+\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b,\u0010\u0012R\u0011\u0010-\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b.\u0010\u0012¨\u0006g"}, d2 = {"Lcom/angcyo/tablayout/AbsDslDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "attachView", "Landroid/view/View;", "getAttachView", "()Landroid/view/View;", "drawRect", "Landroid/graphics/Rect;", "getDrawRect", "()Landroid/graphics/Rect;", "drawRectF", "Landroid/graphics/RectF;", "getDrawRectF", "()Landroid/graphics/RectF;", "drawType", "", "getDrawType", "()I", "setDrawType", "(I)V", "isInEditMode", "", "()Z", "isViewRtl", "paddingBottom", "getPaddingBottom", "paddingLeft", "getPaddingLeft", "paddingRight", "getPaddingRight", "paddingTop", "getPaddingTop", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint$delegate", "Lkotlin/Lazy;", "viewDrawHeight", "getViewDrawHeight", "viewDrawWidth", "getViewDrawWidth", "viewHeight", "getViewHeight", "viewWidth", "getViewWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getColorFilter", "Landroid/graphics/ColorFilter;", "getHotspotBounds", "outRect", "getIntrinsicHeight", "getIntrinsicWidth", "getMinimumHeight", "getMinimumWidth", "getOpacity", "initAttribute", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "isFilterBitmap", "mutate", "onBoundsChange", "bounds", "onLevelChange", "level", "onStateChange", "state", "", "setAlpha", Key.ALPHA, "setBounds", "left", "top", "right", "bottom", "setColorFilter", "colorFilter", "setDither", "dither", "setFilterBitmap", "filter", "setHotspot", "x", "", "y", "setHotspotBounds", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbsDslDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(204537388, "Lcom/angcyo/tablayout/AbsDslDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(204537388, "Lcom/angcyo/tablayout/AbsDslDrawable;");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
        }
    }

    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public AbsDslDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(AbsDslDrawable$textPaint$2.INSTANCE);
        new Rect();
        new RectF();
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!(getCallback() instanceof View)) {
                return null;
            }
            Drawable.Callback callback = getCallback();
            if (!(callback instanceof View)) {
                return null;
            }
            return (View) callback;
        }
        return (View) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getPaddingBottom();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getPaddingLeft();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getPaddingRight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getPaddingTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final TextPaint f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (TextPaint) this.a.getValue();
        }
        return (TextPaint) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (i() - e()) - b();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return f().getAlpha();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return f().getColorFilter();
        }
        return (ColorFilter) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return super.getMinimumHeight();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return super.getMinimumWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (getAlpha() < 255) {
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (j() - c()) - d();
        }
        return invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getMeasuredHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return f().isFilterBitmap();
        }
        return invokeV.booleanValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            View a = a();
            if (a != null) {
                return a.getMeasuredWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            View a = a();
            if (a != null) {
                return a.isInEditMode();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (a() != null) {
                View a = a();
                Intrinsics.checkNotNull(a);
                if (ViewCompat.getLayoutDirection(a) == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Drawable mutate = super.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "super.mutate()");
            return mutate;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect outRect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, outRect) == null) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            super.getHotspotBounds(outRect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bounds) == null) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            super.onBoundsChange(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            return super.onLevelChange(i);
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, state)) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            return super.onStateChange(state);
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && f().getAlpha() != i) {
            f().setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect bounds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bounds) == null) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            super.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, colorFilter) == null) {
            f().setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            f().setDither(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            f().setFilterBitmap(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode blendMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, blendMode) == null) {
            super.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, colorStateList) == null) {
            super.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, mode) == null) {
            super.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            super.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048610, this, i, i2, i3, i4) == null) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.setHotspot(f, f2);
        }
    }
}
