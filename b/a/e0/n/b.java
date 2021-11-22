package b.a.e0.n;

import android.text.TextUtils;
import b.a.e0.l.e;
import b.a.e0.l.h.d;
import b.a.e0.r.l;
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
    public static long f2645c;

    /* renamed from: d  reason: collision with root package name */
    public static b f2646d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2647a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2648b;

    /* loaded from: classes.dex */
    public class a extends b.a.e0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.s.g.a f2649a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2650b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2651c;

        public a(b bVar, b.a.e0.s.g.a aVar, String str) {
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
            this.f2651c = bVar;
            this.f2649a = aVar;
            this.f2650b = str;
        }

        @Override // b.a.e0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) || this.f2651c.f2648b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (e.b(l.a()) && currentTimeMillis - b.f2645c <= 3000) {
                if (this.f2651c.f2647a) {
                    this.f2649a.onResult(1, "");
                }
                this.f2651c.i(this.f2650b, this.f2649a);
            } else {
                this.f2649a.onResult(3, "支付失败，请重试");
            }
            this.f2651c.f2647a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || this.f2651c.f2648b) {
                return;
            }
            int optInt = jSONObject.optInt("status", -1);
            int optInt2 = jSONObject.optInt("payStatus", -1);
            if (optInt != 1 || optInt2 != 0) {
                if (optInt == 2 || (optInt == 1 && optInt2 == 2)) {
                    this.f2649a.onResult(0, "小额免密支付成功");
                } else if (optInt != 1 || optInt2 != 3) {
                    if (System.currentTimeMillis() - b.f2645c <= 3000) {
                        if (this.f2651c.f2647a) {
                            this.f2649a.onResult(1, "");
                        }
                        this.f2651c.i(this.f2650b, this.f2649a);
                    } else {
                        this.f2649a.onResult(6, "支付结果查询失败，请重试");
                    }
                } else {
                    this.f2649a.onResult(3, "支付失败，请重试");
                }
                this.f2651c.f2647a = false;
                return;
            }
            this.f2649a.onResult(3, "支付失败，请重试");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1785617513, "Lb/a/e0/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1785617513, "Lb/a/e0/n/b;");
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
        this.f2647a = true;
        this.f2648b = false;
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f2646d == null) {
                synchronized (b.class) {
                    if (f2646d == null) {
                        f2646d = new b();
                    }
                }
            }
            return f2646d;
        }
        return (b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2648b = true;
        }
    }

    public void g(String str, b.a.e0.s.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) {
            this.f2648b = false;
            this.f2647a = true;
            f2645c = System.currentTimeMillis();
            i(str, aVar);
        }
    }

    public final void i(String str, b.a.e0.s.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            String[] split = str.split("&");
            b.a.e0.l.b bVar = new b.a.e0.l.b();
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
            b.a.e0.l.h.b.j().g(d.e(), bVar, new a(this, aVar, str));
        }
    }
}
