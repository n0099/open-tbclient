package c.a.g0.n;

import android.text.TextUtils;
import c.a.g0.l.e;
import c.a.g0.l.h.d;
import c.a.g0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static long f3182c;

    /* renamed from: d  reason: collision with root package name */
    public static b f3183d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3184b;

    /* loaded from: classes.dex */
    public class a extends c.a.g0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.g0.s.g.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3185b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f3186c;

        public a(b bVar, c.a.g0.s.g.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3186c = bVar;
            this.a = aVar;
            this.f3185b = str;
        }

        @Override // c.a.g0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) || this.f3186c.f3184b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (e.b(l.a()) && currentTimeMillis - b.f3182c <= 3000) {
                if (this.f3186c.a) {
                    this.a.onResult(1, "");
                }
                this.f3186c.i(this.f3185b, this.a);
            } else {
                this.a.onResult(3, "支付失败，请重试");
            }
            this.f3186c.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.g0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || this.f3186c.f3184b) {
                return;
            }
            int optInt = jSONObject.optInt("status", -1);
            int optInt2 = jSONObject.optInt("payStatus", -1);
            if (optInt != 1 || optInt2 != 0) {
                if (optInt == 2 || (optInt == 1 && optInt2 == 2)) {
                    this.a.onResult(0, "小额免密支付成功");
                } else if (optInt != 1 || optInt2 != 3) {
                    if (System.currentTimeMillis() - b.f3182c <= 3000) {
                        if (this.f3186c.a) {
                            this.a.onResult(1, "");
                        }
                        this.f3186c.i(this.f3185b, this.a);
                    } else {
                        this.a.onResult(6, "支付结果查询失败，请重试");
                    }
                } else {
                    this.a.onResult(3, "支付失败，请重试");
                }
                this.f3186c.a = false;
                return;
            }
            this.a.onResult(3, "支付失败，请重试");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1807561510, "Lc/a/g0/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1807561510, "Lc/a/g0/n/b;");
        }
    }

    public b() {
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
        this.a = true;
        this.f3184b = false;
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f3183d == null) {
                synchronized (b.class) {
                    if (f3183d == null) {
                        f3183d = new b();
                    }
                }
            }
            return f3183d;
        }
        return (b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f3184b = true;
        }
    }

    public void g(String str, c.a.g0.s.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            this.f3184b = false;
            this.a = true;
            f3182c = System.currentTimeMillis();
            i(str, aVar);
        }
    }

    public final void i(String str, c.a.g0.s.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            String[] split = str.split("&");
            c.a.g0.l.b bVar = new c.a.g0.l.b();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        bVar.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        bVar.d(split2[0], split2[1]);
                    }
                }
            }
            bVar.d("terminalData", "{\"queryOrderType\":\"AGREEMENT\",\"payChannel\":\"BAIDU-ALIPAY-WISE\"}");
            c.a.g0.l.h.b.j().g(d.e(), bVar, new a(this, aVar, str));
        }
    }
}
