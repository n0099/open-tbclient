package c.a.a0.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1067e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1068b;

    /* renamed from: c  reason: collision with root package name */
    public String f1069c;

    /* renamed from: d  reason: collision with root package name */
    public int f1070d;

    /* renamed from: c.a.a0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0012a implements c.a.a0.g.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f1071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1072c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1073d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1076g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f1077h;
        public final /* synthetic */ String i;
        public final /* synthetic */ a j;

        public C0012a(a aVar, c cVar, Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.a = cVar;
            this.f1071b = context;
            this.f1072c = str;
            this.f1073d = str2;
            this.f1074e = str3;
            this.f1075f = str4;
            this.f1076g = str5;
            this.f1077h = z;
            this.i = str6;
        }

        @Override // c.a.a0.g.h.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.j.f1069c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.j.a)) {
                            clogBuilder.o(this.j.a);
                        }
                        clogBuilder.r("DEEPLINK");
                        clogBuilder.s(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.h("APP");
                        clogBuilder.n(this.j.f1069c);
                        if (this.j.f1070d == 1) {
                            clogBuilder.i("deferred");
                        }
                        c.a.a0.a0.a.b(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                    }
                    c.a.a0.d.b.c.c.e(this.j.f1069c);
                    return;
                }
                this.j.j(this.f1071b, this.f1072c, this.f1073d, this.f1074e, this.f1075f, this.f1076g, this.f1077h, this.i, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.a0.g.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f1078b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1079c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1080d;

        public b(a aVar, c cVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1080d = aVar;
            this.a = cVar;
            this.f1078b = context;
            this.f1079c = str;
        }

        @Override // c.a.a0.g.h.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.f1080d.f1069c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.f1080d.a)) {
                            clogBuilder.o(this.f1080d.a);
                        }
                        clogBuilder.r("DEEPLINK");
                        clogBuilder.s(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.h("MARKET");
                        clogBuilder.n(this.f1080d.f1069c);
                        c.a.a0.a0.a.b(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                        return;
                    }
                    return;
                }
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.onResult(this.f1080d.h(this.f1078b, this.f1079c));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onResult(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(68668684, "Lc/a/a0/d/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(68668684, "Lc/a/a0/d/b/a;");
                return;
            }
        }
        f1067e = c.a.a0.h.a.a().k() + "://vendor/ad/easybrowse?ad_id=_AD_ID_&ext_info=_AD_EXT_&url=_URL_TEMPLATE_";
    }

    public a() {
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
        this.f1070d = 0;
    }

    public boolean f(Context context, String str, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, hashMap, cVar)) == null) {
            this.a = str;
            return k(context, hashMap, cVar);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean g(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap, cVar)) == null) ? f(context, null, hashMap, cVar) : invokeLLL.booleanValue;
    }

    public final boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!TextUtils.isEmpty(this.f1069c)) {
                ClogBuilder clogBuilder = new ClogBuilder();
                if (!TextUtils.isEmpty(this.a)) {
                    clogBuilder.o(this.a);
                }
                clogBuilder.r("DEEPLINK");
                clogBuilder.s(ClogBuilder.LogType.DEEP_LINK);
                clogBuilder.h("URL");
                clogBuilder.n(this.f1069c);
                if (this.f1070d == 1) {
                    clogBuilder.i("deferred");
                }
                c.a.a0.a0.a.b(clogBuilder);
            }
            if (!str.startsWith(c.a.a0.h.a.a().k()) && !str.startsWith("nadcorevendor://")) {
                if (str.startsWith("http") || str.startsWith("https")) {
                    String replace = f1067e.replace("_URL_TEMPLATE_", str);
                    if (!TextUtils.isEmpty(this.f1068b)) {
                        replace = replace.replace("_AD_ID_", this.f1068b);
                    }
                    if (!TextUtils.isEmpty(this.f1069c)) {
                        replace = replace.replace("_AD_EXT_", this.f1069c);
                    }
                    c.a.a0.g.c.c(replace, context);
                    return true;
                }
                return false;
            }
            c.a.a0.g.c.c(str, context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void i(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, str3, str4, str5, str6, Boolean.valueOf(z), str7, cVar}) != null) {
            return;
        }
        try {
            try {
                c.a.a0.g.h.c.a(context, str, str6, new C0012a(this, cVar, context, str2, str3, str4, str5, str6, z, str7), z);
            } catch (Exception unused) {
                j(context, str2, str3, str4, str5, str6, z, str7, cVar);
            }
        } catch (Exception unused2) {
        }
    }

    public final void j(Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6, cVar}) == null) {
            if (TextUtils.isEmpty(str2)) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                    return;
                }
                return;
            }
            try {
                c.a.a0.g.h.c.a(context, str2, str3, new b(this, cVar, context, str), z);
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.onResult(h(context, str));
                }
            }
        }
    }

    public final boolean k(Context context, HashMap<String, String> hashMap, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, hashMap, cVar)) == null) {
            if (hashMap == null) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
            try {
                String str = hashMap.get("app_url");
                String str2 = hashMap.get("web_url");
                String str3 = hashMap.get("min_version");
                String str4 = hashMap.get(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                String str5 = hashMap.get("market_url");
                String str6 = hashMap.get("market_pkg_name");
                String str7 = hashMap.get("exemption");
                int parseInt = !TextUtils.isEmpty(str7) ? Integer.parseInt(str7) : 0;
                String str8 = hashMap.get("source");
                this.f1068b = hashMap.get(LegoListActivityConfig.AD_ID);
                this.f1069c = hashMap.get("ext_info");
                String str9 = hashMap.get("exemption");
                if (!TextUtils.isEmpty(str9)) {
                    this.f1070d = Integer.parseInt(str9);
                }
                hashMap.get("ad_name");
                if (!TextUtils.isEmpty(str)) {
                    i(context, str, str2, str5, str6, str3, str4, parseInt != 1, str8, cVar);
                } else if (!TextUtils.isEmpty(str5)) {
                    j(context, str2, str5, str6, str3, str4, parseInt != 1, str8, cVar);
                } else if (TextUtils.isEmpty(str2)) {
                    if (cVar != null) {
                        cVar.onResult(false);
                    }
                    return false;
                } else if (cVar != null) {
                    cVar.onResult(h(context, str2));
                }
                return true;
            } catch (NumberFormatException unused) {
                if (cVar != null) {
                    cVar.onResult(false);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
