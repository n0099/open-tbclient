package c.a.n0.a.x.i.g.d;

import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.k;
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
    public static final boolean f7123f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public RequestStatus f7124b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.n0.a.x.i.g.d.a> f7125c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.n0.a.x.i.g.d.a> f7126d;

    /* renamed from: e  reason: collision with root package name */
    public long f7127e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1210557697, "Lc/a/n0/a/x/i/g/d/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1210557697, "Lc/a/n0/a/x/i/g/d/d$a;");
                    return;
                }
            }
            int[] iArr = new int[RequestStatus.values().length];
            a = iArr;
            try {
                iArr[RequestStatus.STATUS_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RequestStatus.STATUS_CORE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RequestStatus.STATUS_SERVER_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RequestStatus.STATUS_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RequestStatus.STATUS_SLOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RequestStatus.STATUS_UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(490359900, "Lc/a/n0/a/x/i/g/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(490359900, "Lc/a/n0/a/x/i/g/d/d;");
                return;
            }
        }
        f7123f = c.a.n0.a.a.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7124b = RequestStatus.STATUS_SUCCESS;
        this.f7125c = new ArrayList();
        this.f7126d = new ArrayList();
        this.f7127e = 0L;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f7127e : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<c.a.n0.a.x.i.g.d.a> list = this.f7125c;
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
            String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
            for (c.a.n0.a.x.i.g.d.a aVar : this.f7126d) {
                if (aVar != null) {
                    try {
                        sb.append(String.format("\n%s请求%s耗时较长：%s ms；", g2, new URL(aVar.a).getPath(), Long.valueOf(aVar.d())));
                    } catch (MalformedURLException e2) {
                        if (f7123f) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            for (c.a.n0.a.x.i.g.d.a aVar2 : this.f7125c) {
                if (aVar2 != null) {
                    try {
                        sb.append(String.format("\n%s请求%s请求失败；", g2, new URL(aVar2.a).getPath()));
                    } catch (MalformedURLException e3) {
                        if (f7123f) {
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
            switch (a.a[this.f7124b.ordinal()]) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7124b : (RequestStatus) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<c.a.n0.a.x.i.g.d.a> list = this.f7126d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.intValue;
    }

    public void h(List<c.a.n0.a.x.i.g.d.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f7125c = list;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.f7127e = j;
        }
    }

    public void j(RequestStatus requestStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, requestStatus) == null) {
            this.f7124b = requestStatus;
        }
    }

    public void k(List<c.a.n0.a.x.i.g.d.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f7126d = list;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.a = i;
        }
    }
}
