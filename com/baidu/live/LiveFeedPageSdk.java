package com.baidu.live;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.w.d.b.b;
import b.a.w.e.d.c;
import b.a.w.i.f;
import b.q.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LiveFeedPageSdk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f39484e;

    /* renamed from: f  reason: collision with root package name */
    public static LiveFeedPageSdk f39485f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39486a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39487b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39488c;

    /* renamed from: d  reason: collision with root package name */
    public b f39489d;

    /* loaded from: classes7.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final LiveFeedPageSdk f39490a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237300023, "Lcom/baidu/live/LiveFeedPageSdk$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1237300023, "Lcom/baidu/live/LiveFeedPageSdk$Holder;");
                    return;
                }
            }
            f39490a = new LiveFeedPageSdk();
        }

        public Holder() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1671392719, "Lcom/baidu/live/LiveFeedPageSdk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1671392719, "Lcom/baidu/live/LiveFeedPageSdk;");
        }
    }

    public LiveFeedPageSdk() {
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

    public static LiveFeedPageSdk e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f39485f == null) {
                f39485f = Holder.f39490a;
            }
            return f39485f;
        }
        return (LiveFeedPageSdk) invokeV.objValue;
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            boolean z = f39484e;
        }
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39487b : (Context) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f() != null) {
                String a2 = f().a();
                return (TextUtils.isEmpty(a2) || "0".equals(a2)) ? f().getCuid() : a2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ("haokan".equals(d())) {
                return "baiduhaokan://video/yylive/router?url=yymobile%3a%2f%2fMobileLive%2fPreViewPage%3fneedLogin%3d1";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39486a : (String) invokeV.objValue;
    }

    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39489d : (b) invokeV.objValue;
    }

    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? a.a(context) : (String) invokeL.objValue;
    }

    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.f39486a = str;
            f.e().o(str, str2);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f39489d = bVar;
        }
    }

    public void j(INetWork iNetWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iNetWork) == null) {
            c.b(iNetWork);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39488c : invokeV.booleanValue;
    }

    public void m(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, context) == null) && context != null && this.f39487b == null) {
            this.f39487b = context.getApplicationContext();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f39488c = true;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            f.e().q(str);
        }
    }
}
