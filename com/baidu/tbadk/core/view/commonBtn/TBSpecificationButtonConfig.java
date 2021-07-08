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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public abstract class TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebpType f12683a;

    /* renamed from: b  reason: collision with root package name */
    public int f12684b;

    /* renamed from: c  reason: collision with root package name */
    public int f12685c;

    /* renamed from: d  reason: collision with root package name */
    public int f12686d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f12687e;

    /* renamed from: f  reason: collision with root package name */
    public IconType f12688f;

    /* renamed from: g  reason: collision with root package name */
    public int f12689g;

    /* renamed from: h  reason: collision with root package name */
    public int f12690h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12691i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public GradientDrawable.Orientation r;
    public a s;

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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public WebpType(String str, int i2) {
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

        public static WebpType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebpType) Enum.valueOf(WebpType.class, str) : (WebpType) invokeL.objValue;
        }

        public static WebpType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebpType[]) $VALUES.clone() : (WebpType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public TBSpecificationButtonConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = true;
        this.q = 0;
        this.r = GradientDrawable.Orientation.LEFT_RIGHT;
        this.f12687e = new int[2];
        this.j = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        this.k = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
        this.l = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        this.m = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
        this.n = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
        this.o = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
        this.f12689g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    }

    public abstract Drawable a(float f2);

    public final Drawable b(int i2) {
        InterceptResult invokeI;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            IconType iconType = this.f12688f;
            if (iconType == IconType.SVG) {
                int i3 = this.f12690h;
                if (i3 <= 0) {
                    i3 = this.f12684b;
                }
                drawable = SvgManager.getInstance().getPureDrawableColorInt(i2, SkinManager.getColor(this.q, i3), SvgManager.SvgResourceStateType.NORMAL);
            } else if (iconType == IconType.WEBP) {
                if (this.f12683a == WebpType.MASK) {
                    drawable = WebPManager.getMaskDrawable(i2, (WebPManager.ResourceStateType) null);
                } else {
                    int i4 = this.f12690h;
                    if (i4 <= 0) {
                        i4 = this.f12684b;
                    }
                    drawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(this.q, i4), null);
                }
            } else {
                drawable = SkinManager.getDrawable(this.q, i2);
            }
            if (drawable != null) {
                int i5 = this.f12689g;
                drawable.setBounds(0, 0, i5, i5);
            }
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public Drawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b(this.f12687e[0]) : (Drawable) invokeV.objValue;
    }

    public Drawable d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b(this.f12687e[1]) : (Drawable) invokeV.objValue;
    }

    public void e(GradientDrawable.Orientation orientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, orientation) == null) {
            this.r = orientation;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.m = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 <= 0 || this.f12689g == i2) {
            return;
        }
        this.f12689g = i2;
        a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void h(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f12690h == i2) {
            return;
        }
        this.f12690h = i2;
        a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void i(int i2, int i3, IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, iconType) == null) {
            int[] iArr = this.f12687e;
            if (iArr[0] == i2 && iArr[1] == i3 && this.f12688f == iconType) {
                return;
            }
            int[] iArr2 = this.f12687e;
            iArr2[0] = i2;
            iArr2[1] = i3;
            this.f12688f = iconType;
            a aVar = this.s;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            if (i2 > 0) {
                this.n = i2;
            }
            if (i3 > 0) {
                this.o = i3;
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.j = i2;
            this.k = i2;
        }
    }

    public void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.j = i2;
            this.k = i3;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.l = i2;
        }
    }

    public void n(WebpType webpType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, webpType) == null) {
            this.f12683a = webpType;
        }
    }
}
