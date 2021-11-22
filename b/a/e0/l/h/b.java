package b.a.e0.l.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e0.i;
import b.a.e0.r.h;
import b.a.e0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public static String f2580b = "payChannel";

    /* renamed from: c  reason: collision with root package name */
    public static String f2581c = "installmentPeriod";

    /* renamed from: d  reason: collision with root package name */
    public static String f2582d = "payType";

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f2583e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e0.l.f f2584a;

    /* loaded from: classes.dex */
    public class a extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2585a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f2586b;

        public a(b bVar, b.a.e0.l.a aVar) {
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
            this.f2586b = bVar;
            this.f2585a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2586b.w("7", 119501, "cashier/channelAllInfo", i2);
                this.f2585a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
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
                        this.f2586b.w("7", 119503, "cashier/channelAllInfo", optInt2);
                        String optString = jSONObject.optString("errmsg");
                        b.a.e0.l.a aVar = this.f2585a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        aVar.b(serverDataException, "errno is " + optInt2);
                        return;
                    }
                    this.f2585a.c(optJSONObject);
                } catch (JSONException unused) {
                    this.f2586b.w("7", 119502, "cashier/channelAllInfo", -1);
                    this.f2585a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* renamed from: b.a.e0.l.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048b extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2587a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2588b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2589c;

        public C0048b(b bVar, String str, b.a.e0.l.a aVar) {
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
            this.f2589c = bVar;
            this.f2587a = str;
            this.f2588b = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2589c.x("8", 119501, "cashier/launchpayment", i2, this.f2587a);
                this.f2588b.b(th, l.a().getResources().getString(i.common_error_tips));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f2589c.x("8", 119503, "cashier/launchpayment", optInt, this.f2587a);
                        String optString = jSONObject.optString("msg");
                        b.a.e0.l.a aVar = this.f2588b;
                        aVar.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.f2588b.c(this.f2589c.y(jSONObject.optJSONObject("data")));
                } catch (JSONException unused) {
                    this.f2589c.x("8", 119502, "cashier/launchpayment", -1, this.f2587a);
                    this.f2588b.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2590a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f2591b;

        public c(b bVar, b.a.e0.l.a aVar) {
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
            this.f2591b = bVar;
            this.f2590a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2591b.w("8", 119501, "cashier/pay", i2);
                this.f2590a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f2591b.w("8", 119503, "cashier/pay", optInt);
                        String optString = jSONObject.optString("msg");
                        b.a.e0.l.a aVar = this.f2590a;
                        aVar.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.f2590a.c(this.f2591b.y(jSONObject.optJSONObject("data")));
                } catch (Throwable unused) {
                    this.f2591b.w("8", 119502, "cashier/pay", -1);
                    this.f2590a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f2593b;

        public d(b bVar, b.a.e0.l.a aVar) {
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
            this.f2593b = bVar;
            this.f2592a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2593b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i2);
                this.f2592a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.f2593b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        b.a.e0.l.a aVar = this.f2592a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        aVar.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.f2592a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.f2593b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.f2592a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2594a;

        public e(b bVar, b.a.e0.l.a aVar) {
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
            this.f2594a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2594a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f2594a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    b.a.e0.l.a aVar = this.f2594a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.f2594a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2595a;

        public f(b bVar, b.a.e0.l.a aVar) {
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
            this.f2595a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2595a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f2595a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    b.a.e0.l.a aVar = this.f2595a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.f2595a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends b.a.e0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.l.a f2596a;

        public g(b bVar, b.a.e0.l.a aVar) {
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
            this.f2596a = aVar;
        }

        @Override // b.a.e0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f2596a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f2596a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    b.a.e0.l.a aVar = this.f2596a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    aVar.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    h.d(th.getMessage());
                    this.f2596a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1951400416, "Lb/a/e0/l/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1951400416, "Lb/a/e0/l/h/b;");
        }
    }

    public b(b.a.e0.l.f fVar) {
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
        this.f2584a = fVar;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f2583e == null) {
                synchronized (b.class) {
                    if (f2583e == null) {
                        f2583e = new b(new b.a.e0.l.g());
                    }
                }
            }
            return f2583e;
        }
        return (b) invokeV.objValue;
    }

    public b.a.e0.l.b d(Bundle bundle, b.a.e0.l.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, cVar)) == null) {
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            t(bVar, bundle);
            bVar.d(f2582d, "android");
            n(bundle, bVar, cVar);
            return bVar;
        }
        return (b.a.e0.l.b) invokeLL.objValue;
    }

    public void e(Bundle bundle, b.a.e0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, aVar) == null) {
            f(bundle, false, aVar);
        }
    }

    public void f(Bundle bundle, boolean z, b.a.e0.l.a<JSONObject> aVar) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), aVar}) == null) {
            b.a.e0.l.c h2 = h();
            Set<String> keySet = bundle.keySet();
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    bVar.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, bVar, h2);
            r(bundle, bVar, h2);
            p(bundle, bVar, h2);
            if (z) {
                c2 = b.a.e0.l.h.d.d();
            } else {
                c2 = b.a.e0.l.h.d.c();
            }
            b.a.e0.p.b.a("1.02", System.currentTimeMillis());
            this.f2584a.a(c2, h2, bVar, new a(this, aVar));
        }
    }

    public void g(String str, b.a.e0.l.b bVar, b.a.e0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, bVar, aVar) == null) {
            this.f2584a.a(str, h(), bVar, new g(this, aVar));
        }
    }

    public final b.a.e0.l.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.e0.l.c cVar = new b.a.e0.l.c();
            b.a.e0.l.h.c.d(cVar);
            return cVar;
        }
        return (b.a.e0.l.c) invokeV.objValue;
    }

    public final b.a.e0.l.c i(b.a.e0.l.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                cVar = new b.a.e0.l.c();
            }
            b.a.e0.l.h.c.d(cVar);
            return cVar;
        }
        return (b.a.e0.l.c) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, b.a.e0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, aVar) == null) {
            b.a.e0.l.c h2 = h();
            o(str, h2);
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            bVar.d("bduss", str);
            bVar.d("payChannel", str2);
            bVar.d("appKey", str3);
            this.f2584a.a(b.a.e0.l.h.d.i(), h2, bVar, new e(this, aVar));
        }
    }

    public void l(String str, String str2, String str3, b.a.e0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, aVar) == null) {
            b.a.e0.l.c h2 = h();
            o(str, h2);
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            bVar.d("appKey", str3);
            bVar.d("bduss", str);
            bVar.d("payChannel", str2);
            bVar.d("sign", b.a.e0.m.i.b.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.f2584a.a(b.a.e0.l.h.d.k(), h2, bVar, new f(this, aVar));
        }
    }

    public void m(Bundle bundle, b.a.e0.l.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, aVar) == null) {
            b.a.e0.l.c h2 = h();
            Set<String> keySet = bundle.keySet();
            b.a.e0.l.b bVar = new b.a.e0.l.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.d(str, bundle.get(str).toString());
                }
            }
            this.f2584a.a(b.a.e0.l.h.d.m(), h2, bVar, new d(this, aVar));
        }
    }

    public final void n(Bundle bundle, b.a.e0.l.b bVar, b.a.e0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, cVar);
        }
    }

    public final void o(String str, b.a.e0.l.c cVar) {
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

    public final void p(Bundle bundle, b.a.e0.l.b bVar, b.a.e0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, cVar);
        }
    }

    public final void q(String str, b.a.e0.l.c cVar) {
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

    public final void r(Bundle bundle, b.a.e0.l.b bVar, b.a.e0.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, cVar);
        }
    }

    public final void s(String str, b.a.e0.l.c cVar) {
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

    public final void t(b.a.e0.l.b bVar, Bundle bundle) {
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

    public void u(Bundle bundle, b.a.e0.l.a<Map<String, String>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, aVar) == null) {
            b.a.e0.l.c h2 = h();
            b.a.e0.l.b d2 = d(bundle, h2);
            this.f2584a.a(b.a.e0.l.h.d.l(), h2, d2, new c(this, aVar));
        }
    }

    public void v(b.a.e0.l.c cVar, Bundle bundle, b.a.e0.l.a<Map<String, String>> aVar, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, cVar, bundle, aVar, payChannelEntity, str) == null) {
            b.a.e0.l.c i2 = i(cVar);
            Set<String> keySet = bundle.keySet();
            b.a.e0.l.b bVar = new b.a.e0.l.b();
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
                bVar.d(f2580b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                bVar.d(f2581c, installmentPeriod);
            }
            n(bundle, bVar, i2);
            this.f2584a.a(b.a.e0.l.h.d.j(), i2, bVar, new C0048b(this, str, aVar));
        }
    }

    public final void w(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i2);
            hashMap.put("path", str2);
            hashMap.put("errCode", "" + i3);
            b.a.e0.p.b.c(str, hashMap);
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
            b.a.e0.p.b.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = b.a.e0.r.i.c();
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
