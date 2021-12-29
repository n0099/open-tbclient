package c.a.c0.b.l;

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
    public static final String f1795e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1796b;

    /* renamed from: c  reason: collision with root package name */
    public String f1797c;

    /* renamed from: d  reason: collision with root package name */
    public int f1798d;

    /* renamed from: c.a.c0.b.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040a implements c.a.c0.d.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f1799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1801d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1802e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1803f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1804g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f1805h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f1806i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f1807j;

        public C0040a(a aVar, c cVar, Context context, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, context, str, str2, str3, str4, str5, Boolean.valueOf(z), str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1807j = aVar;
            this.a = cVar;
            this.f1799b = context;
            this.f1800c = str;
            this.f1801d = str2;
            this.f1802e = str3;
            this.f1803f = str4;
            this.f1804g = str5;
            this.f1805h = z;
            this.f1806i = str6;
        }

        @Override // c.a.c0.d.h.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.f1807j.f1797c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.f1807j.a)) {
                            clogBuilder.n(this.f1807j.a);
                        }
                        clogBuilder.q("DEEPLINK");
                        clogBuilder.r(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.g("APP");
                        clogBuilder.m(this.f1807j.f1797c);
                        if (this.f1807j.f1798d == 1) {
                            clogBuilder.h("deferred");
                        }
                        c.a.c0.x.a.b(clogBuilder);
                    }
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.onResult(true);
                    }
                    c.a.c0.b.l.c.c.e(this.f1807j.f1797c);
                    return;
                }
                this.f1807j.j(this.f1799b, this.f1800c, this.f1801d, this.f1802e, this.f1803f, this.f1804g, this.f1805h, this.f1806i, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.c0.d.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f1808b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1809c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f1810d;

        public b(a aVar, c cVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1810d = aVar;
            this.a = cVar;
            this.f1808b = context;
            this.f1809c = str;
        }

        @Override // c.a.c0.d.h.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (!TextUtils.isEmpty(this.f1810d.f1797c)) {
                        ClogBuilder clogBuilder = new ClogBuilder();
                        if (!TextUtils.isEmpty(this.f1810d.a)) {
                            clogBuilder.n(this.f1810d.a);
                        }
                        clogBuilder.q("DEEPLINK");
                        clogBuilder.r(ClogBuilder.LogType.DEEP_LINK);
                        clogBuilder.g("MARKET");
                        clogBuilder.m(this.f1810d.f1797c);
                        c.a.c0.x.a.b(clogBuilder);
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
                    cVar2.onResult(this.f1810d.h(this.f1808b, this.f1809c));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(691766662, "Lc/a/c0/b/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(691766662, "Lc/a/c0/b/l/a;");
                return;
            }
        }
        f1795e = c.a.c0.e.a.a().j() + "://vendor/ad/easybrowse?ad_id=_AD_ID_&ext_info=_AD_EXT_&url=_URL_TEMPLATE_";
    }

    public a() {
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
        this.f1798d = 0;
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
            if (!TextUtils.isEmpty(this.f1797c)) {
                ClogBuilder clogBuilder = new ClogBuilder();
                if (!TextUtils.isEmpty(this.a)) {
                    clogBuilder.n(this.a);
                }
                clogBuilder.q("DEEPLINK");
                clogBuilder.r(ClogBuilder.LogType.DEEP_LINK);
                clogBuilder.g("URL");
                clogBuilder.m(this.f1797c);
                if (this.f1798d == 1) {
                    clogBuilder.h("deferred");
                }
                c.a.c0.x.a.b(clogBuilder);
            }
            if (!str.startsWith(c.a.c0.e.a.a().j()) && !str.startsWith("nadcorevendor://")) {
                if (str.startsWith("http") || str.startsWith("https")) {
                    String replace = f1795e.replace("_URL_TEMPLATE_", str);
                    if (!TextUtils.isEmpty(this.f1796b)) {
                        replace = replace.replace("_AD_ID_", this.f1796b);
                    }
                    if (!TextUtils.isEmpty(this.f1797c)) {
                        replace = replace.replace("_AD_EXT_", this.f1797c);
                    }
                    c.a.c0.d.c.c(replace, context);
                    return true;
                }
                return false;
            }
            c.a.c0.d.c.c(str, context);
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
                c.a.c0.d.h.c.a(context, str, str6, new C0040a(this, cVar, context, str2, str3, str4, str5, str6, z, str7), z);
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
                c.a.c0.d.h.c.a(context, str2, str3, new b(this, cVar, context, str), z);
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
                this.f1796b = hashMap.get(LegoListActivityConfig.AD_ID);
                this.f1797c = hashMap.get("ext_info");
                String str9 = hashMap.get("exemption");
                if (!TextUtils.isEmpty(str9)) {
                    this.f1798d = Integer.parseInt(str9);
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
