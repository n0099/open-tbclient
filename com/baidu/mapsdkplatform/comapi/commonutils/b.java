package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.j;
import com.baidu.platform.comjni.engine.NAEngine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.Engine;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1117203784, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1117203784, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] e;
        public transient /* synthetic */ FieldHolder $fh;
        public int d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109006613, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-109006613, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$a;");
                    return;
                }
            }
            a = new a("eMonitorConsole", 0, 1);
            b = new a("eMonitorNative", 1, 2);
            a aVar = new a("eMonitorNet", 2, 4);
            c = aVar;
            e = new a[]{a, b, aVar};
        }

        public a(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = 0;
            this.d = i2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) e.clone();
            }
            return (a[]) invokeV.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class EnumC0119b {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC0119b a;
        public static final EnumC0119b b;
        public static final EnumC0119b c;
        public static final EnumC0119b d;
        public static final EnumC0119b e;
        public static final EnumC0119b f;
        public static final EnumC0119b g;
        public static final /* synthetic */ EnumC0119b[] h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109006582, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-109006582, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$b;");
                    return;
                }
            }
            a = new EnumC0119b("eNone", 0);
            b = new EnumC0119b("eMonitorVerbose", 1);
            c = new EnumC0119b("eMonitorDebug", 2);
            d = new EnumC0119b("eMonitorInfo", 3);
            e = new EnumC0119b("eMonitorWarn", 4);
            f = new EnumC0119b("eMonitorError", 5);
            EnumC0119b enumC0119b = new EnumC0119b("eMonitorRealTime", 6);
            g = enumC0119b;
            h = new EnumC0119b[]{a, b, c, d, e, f, enumC0119b};
        }

        public EnumC0119b(String str, int i) {
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

        public static EnumC0119b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (EnumC0119b) Enum.valueOf(EnumC0119b.class, str);
            }
            return (EnumC0119b) invokeL.objValue;
        }

        public static EnumC0119b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (EnumC0119b[]) h.clone();
            }
            return (EnumC0119b[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109006551, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-109006551, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$c;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public static final d b;
        public static final d c;
        public static final /* synthetic */ d[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109006520, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-109006520, "Lcom/baidu/mapsdkplatform/comapi/commonutils/b$d;");
                    return;
                }
            }
            a = new d("SDK_MAP", 0);
            b = new d("Net", 1);
            d dVar = new d(Engine.TAG, 2);
            c = dVar;
            d = new d[]{a, b, dVar};
        }

        public d(String str, int i) {
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

        public static d valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (d) Enum.valueOf(d.class, str);
            }
            return (d) invokeL.objValue;
        }

        public static d[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (d[]) d.clone();
            }
            return (d[]) invokeV.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a;
        }
        return (b) invokeV.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            NAEngine.a(new String[]{d.a.name(), d.c.name()});
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && a && b) {
            b = false;
            a = false;
            NAEngine.a(false);
        }
    }

    public /* synthetic */ b(com.baidu.mapsdkplatform.comapi.commonutils.c cVar) {
        this();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a(EnumC0119b.g, d.a.name(), str);
        }
    }

    private void a(EnumC0119b enumC0119b, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, enumC0119b, str, str2) != null) || !a) {
            return;
        }
        j.a().submit(new com.baidu.mapsdkplatform.comapi.commonutils.c(this, enumC0119b, str, str2));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean isMapLogEnable = OpenLogUtil.isMapLogEnable();
            a = isMapLogEnable;
            if (isMapLogEnable && !b) {
                String mapLogFilePath = OpenLogUtil.getMapLogFilePath();
                if (TextUtils.isEmpty(mapLogFilePath)) {
                    mapLogFilePath = SysOSUtil.getInstance().getExternalFilesDir();
                }
                NAEngine.a(false);
                NAEngine.a(mapLogFilePath);
                NAEngine.a(a.b.a());
                NAEngine.b(EnumC0119b.f.ordinal());
                d();
                NAEngine.a(true);
                b = true;
            }
        }
    }
}
