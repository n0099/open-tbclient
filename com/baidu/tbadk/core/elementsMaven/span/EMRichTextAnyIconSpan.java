package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public IconType b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    @Px
    public int i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class IconType {
        public static final /* synthetic */ IconType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconType PIC;
        public static final IconType SVG;
        public static final IconType WEBP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(814399973, "Lcom/baidu/tbadk/core/elementsMaven/span/EMRichTextAnyIconSpan$IconType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(814399973, "Lcom/baidu/tbadk/core/elementsMaven/span/EMRichTextAnyIconSpan$IconType;");
                    return;
                }
            }
            SVG = new IconType("SVG", 0);
            WEBP = new IconType("WEBP", 1);
            IconType iconType = new IconType("PIC", 2);
            PIC = iconType;
            $VALUES = new IconType[]{SVG, WEBP, iconType};
        }

        public IconType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static IconType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (IconType) Enum.valueOf(IconType.class, str);
            }
            return (IconType) invokeL.objValue;
        }

        public static IconType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (IconType[]) $VALUES.clone();
            }
            return (IconType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-580651846, "Lcom/baidu/tbadk/core/elementsMaven/span/EMRichTextAnyIconSpan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-580651846, "Lcom/baidu/tbadk/core/elementsMaven/span/EMRichTextAnyIconSpan;");
                return;
            }
        }
        j = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    }

    public EMRichTextAnyIconSpan(int i, int i2, IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), iconType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.a = i;
        this.b = iconType;
        this.c = i2;
        e(j);
    }

    public final int a() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.d;
            IconType iconType = this.b;
            if (iconType == IconType.WEBP) {
                drawable = WebPManager.getPureDrawable(this.a, SkinManager.getColor(this.c), WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawable(this.a, this.c, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                drawable = SkinManager.getDrawable(this.a);
            }
            if (this.e && drawable != null) {
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicHeight != 0) {
                    return (intrinsicWidth * this.d) / intrinsicHeight;
                }
                return i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.e = z;
        }
    }

    public void c(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.i = UtilHelper.getDimenPixelSize(i);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
            this.g = i;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.h = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d = i;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            IconType iconType = this.b;
            if (iconType == IconType.WEBP) {
                drawable = WebPManager.getPureDrawable(this.a, SkinManager.getColor(this.c), WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawable(this.a, this.c, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                drawable = SkinManager.getDrawable(this.a);
            }
            if (drawable == null) {
                return;
            }
            drawable.setBounds(0, 0, a(), this.d);
            canvas.save();
            float f2 = f + this.f;
            float f3 = this.h;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (tw4.b(charSequence)) {
                tw4.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = f3 - UtilHelper.getDimenPixelSize(R.dimen.tbds2);
            } else {
                dimenPixelSize = f3 + UtilHelper.getDimenPixelSize(R.dimen.tbds3) + this.i;
            }
            canvas.translate(f2, dimenPixelSize + i4 + fontMetricsInt.ascent);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            if (this.d == 0) {
                this.d = (int) paint.getTextSize();
            }
            return this.f + this.g + a();
        }
        return invokeCommon.intValue;
    }
}
