package b.a.p0.a.h0.i.g.d;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5620f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f5621a;

    /* renamed from: b  reason: collision with root package name */
    public RequestStatus f5622b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.p0.a.h0.i.g.d.a> f5623c;

    /* renamed from: d  reason: collision with root package name */
    public List<b.a.p0.a.h0.i.g.d.a> f5624d;

    /* renamed from: e  reason: collision with root package name */
    public long f5625e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5626a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1335434236, "Lb/a/p0/a/h0/i/g/d/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1335434236, "Lb/a/p0/a/h0/i/g/d/d$a;");
                    return;
                }
            }
            int[] iArr = new int[RequestStatus.values().length];
            f5626a = iArr;
            try {
                iArr[RequestStatus.STATUS_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5626a[RequestStatus.STATUS_CORE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5626a[RequestStatus.STATUS_SERVER_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5626a[RequestStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5626a[RequestStatus.STATUS_SLOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5626a[RequestStatus.STATUS_UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-948874591, "Lb/a/p0/a/h0/i/g/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-948874591, "Lb/a/p0/a/h0/i/g/d/d;");
                return;
            }
        }
        f5620f = k.f6863a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5622b = RequestStatus.STATUS_SUCCESS;
        this.f5623c = new ArrayList();
        this.f5624d = new ArrayList();
        this.f5625e = 0L;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f5625e : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<b.a.p0.a.h0.i.g.d.a> list = this.f5623c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String g2 = b.a.p0.a.z2.k.g(System.currentTimeMillis(), "【HH:mm:ss】");
            for (b.a.p0.a.h0.i.g.d.a aVar : this.f5624d) {
                if (aVar != null) {
                    try {
                        sb.append(String.format("\n%s请求%s耗时较长：%s ms；", g2, new URL(aVar.f5606a).getPath(), Long.valueOf(aVar.d())));
                    } catch (MalformedURLException e2) {
                        if (f5620f) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            for (b.a.p0.a.h0.i.g.d.a aVar2 : this.f5623c) {
                if (aVar2 != null) {
                    try {
                        sb.append(String.format("\n%s请求%s请求失败；", g2, new URL(aVar2.f5606a).getPath()));
                    } catch (MalformedURLException e3) {
                        if (f5620f) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            switch (a.f5626a[this.f5622b.ordinal()]) {
                case 1:
                    sb.append("业务请求：失败率超");
                    sb.append(50);
                    sb.append("%；");
                    break;
                case 2:
                    sb.append("业务请求：核心业务请求失败；");
                    break;
                case 3:
                    sb.append("业务请求：开发者服务异常；");
                    break;
                case 4:
                    sb.append("业务请求：无异常；");
                    break;
                case 5:
                    sb.append("业务请求：响应缓慢；");
                    break;
                case 6:
                    sb.append("业务请求：未知；");
                    break;
            }
            if (g() > 0) {
                sb.append(String.format("共发起请求%s个，失败%s个，缓慢%s个；", Integer.valueOf(g()), Integer.valueOf(b()), Integer.valueOf(f())));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public RequestStatus e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5622b : (RequestStatus) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<b.a.p0.a.h0.i.g.d.a> list = this.f5624d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5621a : invokeV.intValue;
    }

    public void h(List<b.a.p0.a.h0.i.g.d.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f5623c = list;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f5625e = j;
        }
    }

    public void j(RequestStatus requestStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, requestStatus) == null) {
            this.f5622b = requestStatus;
        }
    }

    public void k(List<b.a.p0.a.h0.i.g.d.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f5624d = list;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f5621a = i2;
        }
    }
}
