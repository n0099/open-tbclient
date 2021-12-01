package c.a.f0.l.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.i;
import c.a.f0.r.h;
import c.a.f0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f3117b = "payChannel";

    /* renamed from: c  reason: collision with root package name */
    public static String f3118c = "installmentPeriod";

    /* renamed from: d  reason: collision with root package name */
    public static String f3119d = "payType";

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f3120e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.f0.l.f a;

    /* loaded from: classes.dex */
    public class a extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3121b;

        public a(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3121b = bVar;
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3121b.w("7", 119501, "cashier/channelAllInfo", i2);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errCode", -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null || optInt != 0 || optInt2 != 0) {
                        this.f3121b.w("7", 119503, "cashier/channelAllInfo", optInt2);
                        String optString = jSONObject.optString("errmsg");
                        c.a.f0.l.a aVar = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        aVar.b(serverDataException, "errno is " + optInt2);
                        return;
                    }
                    this.a.c(optJSONObject);
                } catch (JSONException unused) {
                    this.f3121b.w("7", 119502, "cashier/channelAllInfo", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* renamed from: c.a.f0.l.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0107b extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.l.a f3122b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f3123c;

        public C0107b(b bVar, String str, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3123c = bVar;
            this.a = str;
            this.f3122b = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3123c.x("8", 119501, "cashier/launchpayment", i2, this.a);
                this.f3122b.b(th, l.a().getResources().getString(i.common_error_tips));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f3123c.x("8", 119503, "cashier/launchpayment", optInt, this.a);
                        String optString = jSONObject.optString("msg");
                        c.a.f0.l.a aVar = this.f3122b;
                        aVar.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.f3122b.c(this.f3123c.y(jSONObject.optJSONObject("data")));
                } catch (JSONException unused) {
                    this.f3123c.x("8", 119502, "cashier/launchpayment", -1, this.a);
                    this.f3122b.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3124b;

        public c(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3124b = bVar;
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3124b.w("8", 119501, "cashier/pay", i2);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f3124b.w("8", 119503, "cashier/pay", optInt);
                        String optString = jSONObject.optString("msg");
                        c.a.f0.l.a aVar = this.a;
                        aVar.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.a.c(this.f3124b.y(jSONObject.optJSONObject("data")));
                } catch (Throwable unused) {
                    this.f3124b.w("8", 119502, "cashier/pay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3125b;

        public d(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3125b = bVar;
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f3125b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i2);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f3125b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        c.a.f0.l.a aVar = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        aVar.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.f3125b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        public e(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    c.a.f0.l.a aVar = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        public f(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    c.a.f0.l.a aVar = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.f0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.f0.l.a a;

        public g(b bVar, c.a.f0.l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.f0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    c.a.f0.l.a aVar = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-149457054, "Lc/a/f0/l/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-149457054, "Lc/a/f0/l/h/b;");
        }
    }

    public b(c.a.f0.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = fVar;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f3120e == null) {
                synchronized (b.class) {
                    if (f3120e == null) {
                        f3120e = new b(new c.a.f0.l.g());
                    }
                }
            }
            return f3120e;
        }
        return (b) invokeV.objValue;
    }

    public c.a.f0.l.b d(Bundle bundle, c.a.f0.l.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, cVar)) == null) {
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            t(bVar, bundle);
            bVar.d(f3119d, "android");
            n(bundle, bVar, cVar);
            return bVar;
        }
        return (c.a.f0.l.b) invokeLL.objValue;
    }

    public void e(Bundle bundle, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, aVar) == null) {
            f(bundle, false, aVar);
        }
    }

    public void f(Bundle bundle, boolean z, c.a.f0.l.a<JSONObject> aVar) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), aVar}) == null) {
            c.a.f0.l.c h2 = h();
            Set<String> keySet = bundle.keySet();
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    bVar.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, bVar, h2);
            r(bundle, bVar, h2);
            p(bundle, bVar, h2);
            if (z) {
                c2 = c.a.f0.l.h.d.d();
            } else {
                c2 = c.a.f0.l.h.d.c();
            }
            c.a.f0.p.b.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h2, bVar, new a(this, aVar));
        }
    }

    public void g(String str, c.a.f0.l.b bVar, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, bVar, aVar) == null) {
            this.a.a(str, h(), bVar, new g(this, aVar));
        }
    }

    public final c.a.f0.l.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.f0.l.c cVar = new c.a.f0.l.c();
            c.a.f0.l.h.c.d(cVar);
            return cVar;
        }
        return (c.a.f0.l.c) invokeV.objValue;
    }

    public final c.a.f0.l.c i(c.a.f0.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                cVar = new c.a.f0.l.c();
            }
            c.a.f0.l.h.c.d(cVar);
            return cVar;
        }
        return (c.a.f0.l.c) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, aVar) == null) {
            c.a.f0.l.c h2 = h();
            o(str, h2);
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            bVar.d("bduss", str);
            bVar.d("payChannel", str2);
            bVar.d("appKey", str3);
            this.a.a(c.a.f0.l.h.d.i(), h2, bVar, new e(this, aVar));
        }
    }

    public void l(String str, String str2, String str3, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, aVar) == null) {
            c.a.f0.l.c h2 = h();
            o(str, h2);
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            bVar.d("appKey", str3);
            bVar.d("bduss", str);
            bVar.d("payChannel", str2);
            bVar.d("sign", c.a.f0.m.i.b.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(c.a.f0.l.h.d.k(), h2, bVar, new f(this, aVar));
        }
    }

    public void m(Bundle bundle, c.a.f0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, aVar) == null) {
            c.a.f0.l.c h2 = h();
            Set<String> keySet = bundle.keySet();
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(c.a.f0.l.h.d.m(), h2, bVar, new d(this, aVar));
        }
    }

    public final void n(Bundle bundle, c.a.f0.l.b bVar, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, cVar);
        }
    }

    public final void o(String str, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, cVar) == null) {
            String a2 = cVar.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                cVar.d("Cookie", str2);
                return;
            }
            cVar.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void p(Bundle bundle, c.a.f0.l.b bVar, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, cVar);
        }
    }

    public final void q(String str, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, cVar) == null) {
            String a2 = cVar.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                cVar.d("Cookie", str2);
                return;
            }
            cVar.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void r(Bundle bundle, c.a.f0.l.b bVar, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, cVar);
        }
    }

    public final void s(String str, c.a.f0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, cVar) == null) {
            String a2 = cVar.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                cVar.d("Cookie", str2);
                return;
            }
            cVar.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void t(c.a.f0.l.b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, bVar, bundle) == null) || bundle == null || bVar == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            bVar.d(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = bVar.b().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void u(Bundle bundle, c.a.f0.l.a<Map<String, String>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, aVar) == null) {
            c.a.f0.l.c h2 = h();
            c.a.f0.l.b d2 = d(bundle, h2);
            this.a.a(c.a.f0.l.h.d.l(), h2, d2, new c(this, aVar));
        }
    }

    public void v(c.a.f0.l.c cVar, Bundle bundle, c.a.f0.l.a<Map<String, String>> aVar, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, cVar, bundle, aVar, payChannelEntity, str) == null) {
            c.a.f0.l.c i2 = i(cVar);
            Set<String> keySet = bundle.keySet();
            c.a.f0.l.b bVar = new c.a.f0.l.b();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    bVar.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                bVar.d(f3117b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                bVar.d(f3118c, installmentPeriod);
            }
            n(bundle, bVar, i2);
            this.a.a(c.a.f0.l.h.d.j(), i2, bVar, new C0107b(this, str, aVar));
        }
    }

    public final void w(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i2);
            hashMap.put("path", str2);
            hashMap.put("errCode", "" + i3);
            c.a.f0.p.b.c(str, hashMap);
        }
    }

    public final void x(String str, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i2);
            hashMap.put("path", str2);
            hashMap.put("errCode", "" + i3);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("isFoldChannel", str3);
            }
            c.a.f0.p.b.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = c.a.f0.r.i.c();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        c2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return c2;
        }
        return (Map) invokeL.objValue;
    }
}
