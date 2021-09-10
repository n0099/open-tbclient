package c.b.a;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.b.a.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embed_dr.VivoIdentifier;
/* loaded from: classes4.dex */
public final class z0 implements v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f31460b;

    /* renamed from: c  reason: collision with root package name */
    public static final j0<Boolean> f31461c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public VivoIdentifier f31462a;

    /* loaded from: classes4.dex */
    public static class a extends j0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.a.j0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) ? Boolean.valueOf("1".equals(z0.e(z0.f31460b, "0"))) : (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074064654, "Lc/b/a/z0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074064654, "Lc/b/a/z0;");
                return;
            }
        }
        f31460b = a("cGVyc2lzdC5zeXMuaWRlbnRpZmllcmlkLnN1cHBvcnRlZA==");
        f31461c = new a();
    }

    public z0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            d1.a(context);
        } catch (Throwable unused) {
        }
        try {
            VivoIdentifier vivoIdentifier = new VivoIdentifier();
            this.f31462a = vivoIdentifier;
            vivoIdentifier.preloadOaid(context);
        } catch (Throwable th) {
            o0.e("OaidVivo", Log.getStackTraceString(th));
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f31461c.b(new Object[0]).booleanValue() : invokeV.booleanValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            try {
                return SystemProperties.get(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.b.a.v0
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? c() : invokeL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return new String(Base64.decode(str.getBytes("UTF-8"), 2));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // c.b.a.v0
    public v0.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            VivoIdentifier vivoIdentifier = this.f31462a;
            if (vivoIdentifier == null) {
                return null;
            }
            return vivoIdentifier.getOaid(context);
        }
        return (v0.a) invokeL.objValue;
    }
}
