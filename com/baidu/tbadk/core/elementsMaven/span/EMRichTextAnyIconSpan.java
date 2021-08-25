package com.baidu.tbadk.core.elementsMaven.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.s.u.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EMRichTextAnyIconSpan extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47376e;

    /* renamed from: f  reason: collision with root package name */
    public IconType f47377f;

    /* renamed from: g  reason: collision with root package name */
    public int f47378g;

    /* renamed from: h  reason: collision with root package name */
    public int f47379h;

    /* renamed from: i  reason: collision with root package name */
    public int f47380i;

    /* renamed from: j  reason: collision with root package name */
    public int f47381j;
    public int k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

        public IconType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IconType) Enum.valueOf(IconType.class, str) : (IconType) invokeL.objValue;
        }

        public static IconType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IconType[]) $VALUES.clone() : (IconType[]) invokeV.objValue;
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

    public EMRichTextAnyIconSpan(int i2, int i3, IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), iconType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47376e = i2;
        this.f47377f = iconType;
        this.f47378g = i3;
        b(l);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f47380i = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f47380i = i2;
            this.f47381j = i2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f47381j = i2;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.k = i2;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        Drawable drawable;
        float dimenPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            IconType iconType = this.f47377f;
            if (iconType == IconType.WEBP) {
                drawable = WebPManager.getPureDrawable(this.f47376e, SkinManager.getColor(this.f47378g), WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawable(this.f47376e, this.f47378g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                drawable = SkinManager.getDrawable(this.f47376e);
            }
            if (drawable == null) {
                return;
            }
            int i7 = this.f47379h;
            drawable.setBounds(0, 0, i7, i7);
            canvas.save();
            float f3 = f2 + this.f47380i;
            float f4 = this.k;
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (a.b(charSequence)) {
                a.a(fontMetricsInt, (int) paint.getTextSize());
                dimenPixelSize = f4 - UtilHelper.getDimenPixelSize(R.dimen.tbds2);
            } else {
                dimenPixelSize = f4 + UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            }
            canvas.translate(f3, dimenPixelSize + i5 + fontMetricsInt.ascent);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f47379h = i2;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            if (this.f47379h == 0) {
                this.f47379h = (int) paint.getTextSize();
            }
            return this.f47380i + this.f47381j + this.f47379h;
        }
        return invokeCommon.intValue;
    }
}
