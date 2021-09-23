package com.baidu.mobads.cid;

import android.content.Context;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.cid.cesium.c;
import com.baidu.mobads.cid.cesium.e;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.f;
import com.baidu.mobads.cid.cesium.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static g.a f42778b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f42779c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f42780f = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f42781a;

    /* renamed from: d  reason: collision with root package name */
    public g f42782d;

    /* renamed from: e  reason: collision with root package name */
    public f f42783e;

    /* renamed from: g  reason: collision with root package name */
    public c f42784g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-827581944, "Lcom/baidu/mobads/cid/DeviceId;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-827581944, "Lcom/baidu/mobads/cid/DeviceId;");
        }
    }

    public DeviceId(Context context) {
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
        this.f42781a = context.getApplicationContext();
        this.f42784g = new c();
        this.f42782d = new g(this.f42781a, new a(this.f42781a), this.f42784g);
        this.f42783e = new f(this.f42781a, this.f42784g);
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (e.class) {
                if (f42780f == null) {
                    f42780f = new DeviceId(context);
                }
                deviceId = f42780f;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private g.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            g.a a2 = a((String) null);
            return a2 == null ? this.f42782d.a() : a2;
        }
        return (g.a) invokeV.objValue;
    }

    private g.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            g.a b2 = this.f42782d.b();
            return b2 == null ? b(str) : b2;
        }
        return (g.a) invokeL.objValue;
    }

    public static g.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f42778b == null) {
                synchronized (e.class) {
                    if (f42778b == null) {
                        SystemClock.uptimeMillis();
                        f42778b = a(context).a();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            return f42778b;
        }
        return (g.a) invokeL.objValue;
    }

    private g.a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            e a2 = this.f42783e.a(str);
            if (a2 != null) {
                return this.f42782d.a(a2);
            }
            return null;
        }
        return (g.a) invokeL.objValue;
    }

    public static g.a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (f42779c == null) {
                synchronized (e.class) {
                    if (f42779c == null) {
                        SystemClock.uptimeMillis();
                        f42779c = a(context).f42782d.c();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            return f42779c;
        }
        return (g.a) invokeL.objValue;
    }

    public static String getSelfCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? c(context).c() : (String) invokeL.objValue;
    }

    public static String getTrustChainCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? b(context).c() : (String) invokeL.objValue;
    }

    public static String getTrustChainDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? b(context).a() : (String) invokeL.objValue;
    }
}
