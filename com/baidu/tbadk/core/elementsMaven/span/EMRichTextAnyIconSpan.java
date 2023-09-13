package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.o75;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public Drawable c;
    public IconType d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    @Px
    public int k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class IconType {
        public static final /* synthetic */ IconType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconType NET;
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
            PIC = new IconType("PIC", 2);
            IconType iconType = new IconType("NET", 3);
            NET = iconType;
            $VALUES = new IconType[]{SVG, WEBP, PIC, iconType};
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
        l = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
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
        this.g = false;
        this.a = i;
        this.d = iconType;
        this.e = i2;
        i(l);
    }

    public final int a() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.f;
            IconType iconType = this.d;
            if (iconType == IconType.WEBP) {
                drawable = WebPManager.getPureDrawable(this.a, SkinManager.getColor(this.e), WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawable(this.a, this.e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.NET) {
                drawable = this.c;
            } else {
                drawable = SkinManager.getDrawable(this.a);
            }
            if (this.g && drawable != null) {
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicHeight != 0) {
                    return (intrinsicWidth * this.f) / intrinsicHeight;
                }
                return i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g = z;
        }
    }

    public void d(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
            this.c = drawable;
        }
    }

    public void e(IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iconType) == null) {
            this.d = iconType;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.h = i;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                if (DeviceInfoUtil.isXiaoMi() || DeviceInfoUtil.isOnePlus8()) {
                    this.k = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
                    return;
                }
                return;
            }
            this.k = 0;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = i;
            this.i = i;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.i = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f = i;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            IconType iconType = this.d;
            if (iconType == IconType.WEBP) {
                drawable = WebPManager.getPureDrawable(this.a, SkinManager.getColor(this.e), WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawable(this.a, this.e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.NET) {
                drawable = this.c;
            } else {
                drawable = SkinManager.getDrawable(this.a);
            }
            if (drawable == null) {
                return;
            }
            drawable.setBounds(0, 0, a(), this.f);
            canvas.save();
            float f2 = f + this.h;
            float f3 = this.j;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (o75.b(charSequence)) {
                o75.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = f3 - UtilHelper.getDimenPixelSize(R.dimen.tbds2);
            } else {
                dimenPixelSize = f3 + UtilHelper.getDimenPixelSize(R.dimen.tbds3) + this.k;
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
            if (this.f == 0) {
                this.f = (int) paint.getTextSize();
            }
            return this.h + this.i + a();
        }
        return invokeCommon.intValue;
    }
}
