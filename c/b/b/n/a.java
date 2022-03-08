package c.b.b.n;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final a f27219e;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f27220b;

    /* renamed from: c  reason: collision with root package name */
    public float f27221c;

    /* renamed from: d  reason: collision with root package name */
    public float f27222d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156777101, "Lc/b/b/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156777101, "Lc/b/b/n/a;");
                return;
            }
        }
        f27219e = new a(1.0f, 1.0f, 1.0f, 1.0f);
        new a(-1077952513);
        new a(2139062271);
        new a(1061109759);
        new a(0.0f, 0.0f, 0.0f, 1.0f);
        f27219e.f();
        new a(0.0f, 0.0f, 0.0f, 0.0f);
        new a(0.0f, 0.0f, 1.0f, 1.0f);
        new a(0.0f, 0.0f, 0.5f, 1.0f);
        new a(1097458175);
        new a(1887473919);
        new a(-2016482305);
        new a(0.0f, 1.0f, 1.0f, 1.0f);
        new a(0.0f, 0.5f, 0.5f, 1.0f);
        new a((int) GeneratedTexture.MAGENTA);
        new a(2147418367);
        new a(852308735);
        new a(579543807);
        new a(1804477439);
        new a(-65281);
        new a(-2686721);
        new a(-626712321);
        new a(-5963521);
        new a(-1958407169);
        new a(-759919361);
        new a(-1306385665);
        new a(-16776961);
        new a(-13361921);
        new a(-8433409);
        new a(-92245249);
        new a(-9849601);
        new a(1.0f, 0.0f, 1.0f, 1.0f);
        new a(-1608453889);
        new a(-293409025);
        new a(-1339006721);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int b(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (((int) (f2 * 255.0f)) << 24) | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 8) | ((int) (f5 * 255.0f)) : invokeCommon.intValue;
    }

    public static void c(a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, aVar, i2) == null) {
            aVar.a = (((-16777216) & i2) >>> 24) / 255.0f;
            aVar.f27220b = ((16711680 & i2) >>> 16) / 255.0f;
            aVar.f27221c = ((65280 & i2) >>> 8) / 255.0f;
            aVar.f27222d = (i2 & 255) / 255.0f;
        }
    }

    public static a h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            a aVar = new a();
            i(str, aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a i(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, aVar)) == null) {
            if (str.charAt(0) == '#') {
                str = str.substring(1);
            }
            aVar.a = Integer.parseInt(str.substring(0, 2), 16) / 255.0f;
            aVar.f27220b = Integer.parseInt(str.substring(2, 4), 16) / 255.0f;
            aVar.f27221c = Integer.parseInt(str.substring(4, 6), 16) / 255.0f;
            aVar.f27222d = str.length() != 8 ? 1.0f : Integer.parseInt(str.substring(6, 8), 16) / 255.0f;
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f2 = this.a;
            if (f2 < 0.0f) {
                this.a = 0.0f;
            } else if (f2 > 1.0f) {
                this.a = 1.0f;
            }
            float f3 = this.f27220b;
            if (f3 < 0.0f) {
                this.f27220b = 0.0f;
            } else if (f3 > 1.0f) {
                this.f27220b = 1.0f;
            }
            float f4 = this.f27221c;
            if (f4 < 0.0f) {
                this.f27221c = 0.0f;
            } else if (f4 > 1.0f) {
                this.f27221c = 1.0f;
            }
            float f5 = this.f27222d;
            if (f5 < 0.0f) {
                this.f27222d = 0.0f;
            } else if (f5 > 1.0f) {
                this.f27222d = 1.0f;
            }
            return this;
        }
        return (a) invokeV.objValue;
    }

    public a d(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.a = f2;
            this.f27220b = f3;
            this.f27221c = f4;
            this.f27222d = f5;
            a();
            return this;
        }
        return (a) invokeCommon.objValue;
    }

    public a e(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.a = aVar.a;
            this.f27220b = aVar.f27220b;
            this.f27221c = aVar.f27221c;
            this.f27222d = aVar.f27222d;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && g() == ((a) obj).g();
        }
        return invokeL.booleanValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? t.c((((int) (this.f27222d * 255.0f)) << 24) | (((int) (this.f27221c * 255.0f)) << 16) | (((int) (this.f27220b * 255.0f)) << 8) | ((int) (this.a * 255.0f))) : invokeV.floatValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (((int) (this.f27222d * 255.0f)) << 24) | (((int) (this.f27221c * 255.0f)) << 16) | (((int) (this.f27220b * 255.0f)) << 8) | ((int) (this.a * 255.0f)) : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.a;
            int a = (f2 != 0.0f ? t.a(f2) : 0) * 31;
            float f3 = this.f27220b;
            int a2 = (a + (f3 != 0.0f ? t.a(f3) : 0)) * 31;
            float f4 = this.f27221c;
            int a3 = (a2 + (f4 != 0.0f ? t.a(f4) : 0)) * 31;
            float f5 = this.f27222d;
            return a3 + (f5 != 0.0f ? t.a(f5) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String hexString = Integer.toHexString((((int) (this.a * 255.0f)) << 24) | (((int) (this.f27220b * 255.0f)) << 16) | (((int) (this.f27221c * 255.0f)) << 8) | ((int) (this.f27222d * 255.0f)));
            while (hexString.length() < 8) {
                hexString = "0" + hexString;
            }
            return hexString;
        }
        return (String) invokeV.objValue;
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        c(this, i2);
    }

    public a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = f2;
        this.f27220b = f3;
        this.f27221c = f4;
        this.f27222d = f5;
        a();
    }

    public a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        e(aVar);
    }
}
