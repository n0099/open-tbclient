package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebpType a;
    public int b;
    public int c;
    public int d;
    public final int[] e;
    public IconType f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public int r;
    public GradientDrawable.Orientation s;
    public a t;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public abstract Drawable a(float f);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1161343502, "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationButtonConfig$IconType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1161343502, "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationButtonConfig$IconType;");
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class WebpType {
        public static final /* synthetic */ WebpType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WebpType MASK;
        public static final WebpType PURE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-100636497, "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationButtonConfig$WebpType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-100636497, "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationButtonConfig$WebpType;");
                    return;
                }
            }
            MASK = new WebpType("MASK", 0);
            WebpType webpType = new WebpType("PURE", 1);
            PURE = webpType;
            $VALUES = new WebpType[]{MASK, webpType};
        }

        public WebpType(String str, int i) {
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

        public static WebpType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (WebpType) Enum.valueOf(WebpType.class, str);
            }
            return (WebpType) invokeL.objValue;
        }

        public static WebpType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (WebpType[]) $VALUES.clone();
            }
            return (WebpType[]) invokeV.objValue;
        }
    }

    public TBSpecificationButtonConfig() {
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
        this.q = true;
        this.r = 0;
        this.s = GradientDrawable.Orientation.LEFT_RIGHT;
        this.e = new int[2];
        this.j = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        this.k = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        this.l = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        this.m = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
        this.n = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
        this.o = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        this.g = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    }

    public final Drawable b(int i) {
        InterceptResult invokeI;
        int i2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.q) {
                int i3 = this.h;
                if (i3 <= 0) {
                    i3 = this.b;
                }
                i2 = SkinManager.getColor(this.r, i3);
            } else {
                i2 = this.h;
                if (i2 == 0) {
                    i2 = this.b;
                }
            }
            IconType iconType = this.f;
            if (iconType == IconType.SVG) {
                drawable = SvgManager.getInstance().getPureDrawableColorInt(i, i2, SvgManager.SvgResourceStateType.NORMAL);
            } else if (iconType == IconType.WEBP) {
                if (this.a == WebpType.MASK) {
                    drawable = WebPManager.getMaskDrawable(i, (WebPManager.ResourceStateType) null);
                } else {
                    drawable = WebPManager.getPureDrawable(i, i2, null);
                }
            } else {
                drawable = SkinManager.getDrawable(this.r, i);
            }
            if (drawable != null) {
                int i4 = this.g;
                drawable.setBounds(0, 0, i4, i4);
            }
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public Drawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b(this.e[0]);
        }
        return (Drawable) invokeV.objValue;
    }

    public Drawable d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b(this.e[1]);
        }
        return (Drawable) invokeV.objValue;
    }

    public void e(GradientDrawable.Orientation orientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, orientation) == null) {
            this.s = orientation;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m = i;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && i > 0 && this.g != i) {
            this.g = i;
            a aVar = this.t;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void h(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.h != i) {
            this.h = i;
            a aVar = this.t;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void k(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b = i;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
            this.k = i;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.l = i;
        }
    }

    public void p(WebpType webpType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, webpType) == null) {
            this.a = webpType;
        }
    }

    public void i(int i, int i2, IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, iconType) == null) {
            int[] iArr = this.e;
            if (iArr[0] != i || iArr[1] != i2 || this.f != iconType) {
                int[] iArr2 = this.e;
                iArr2[0] = i;
                iArr2[1] = i2;
                this.f = iconType;
                a aVar = this.t;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    public void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            if (i > 0) {
                this.n = i;
            }
            if (i2 > 0) {
                this.o = i2;
            }
        }
    }

    public void n(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.j = i;
            this.k = i2;
        }
    }
}
