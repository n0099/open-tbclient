package c.a.b0.w;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h.g;
import c.a.b0.h0.m;
import c.a.b0.s.l;
import c.a.b0.u.n;
import c.a.b0.u.s.d;
import c.a.b0.y.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f2266c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, String> f2267d;

    /* renamed from: e  reason: collision with root package name */
    public static final JSONArray f2268e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f2269f;

    /* renamed from: g  reason: collision with root package name */
    public static String f2270g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.b0.y.b f2271b;

    /* renamed from: c.a.b0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0091a extends c.a.b0.u.p.c<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RequestParameters a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRequester.b f2272b;

        public C0091a(a aVar, RequestParameters requestParameters, NadRequester.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, requestParameters, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = requestParameters;
            this.f2272b = bVar;
        }

        @Override // c.a.b0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.f2272b.a(new NadRequester.Error());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, bVar, i2) == null) {
                if (bVar != null) {
                    this.f2272b.b(Arrays.asList(bVar.a));
                } else {
                    this.f2272b.a(new NadRequester.Error());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: f */
        public b d(Headers headers, String str, int i2) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) {
                AdBaseModel[] c2 = l.c(str, new String[]{this.a.a});
                ArrayList arrayList = new ArrayList();
                for (AdBaseModel adBaseModel : c2) {
                    if (this.a.l || adBaseModel.f35661f.a != AdBaseModel.STYLE.HIDDEN) {
                        arrayList.add(adBaseModel);
                        adBaseModel.a(this.a.f35756e);
                    }
                }
                b bVar = new b(null);
                bVar.a = (AdBaseModel[]) arrayList.toArray(new AdBaseModel[0]);
                return bVar;
            }
            return (b) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdBaseModel[] a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(C0091a c0091a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1949844531, "Lc/a/b0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1949844531, "Lc/a/b0/w/a;");
                return;
            }
        }
        f2266c = new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -69, 118, 15, 43, -102, -34, -94, -8, -78, 1, 17, -80, 84, 56, 79, 40, -89, 68, 50, 105, -35, 111, -70, 68, -68, -64, 62, 111, -66, -108, 77, 21, 106, 69, -34, 94, -1, 18, -100, -75, 7, 48, -59, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 50, -58, -124, 23, -97, -14, 100, 67, 115, -70, 4, 2, Cea608Decoder.CTRL_END_OF_CAPTION, -36, 11, 80, 6, -88, 116, -38, -121, -4, -61, -13, -32, 106, 7, 85, -39, 111, 53, 0, -35, Base64.INTERNAL_PADDING, 33, 106, -125, -59, 100, -42, -32, 15, -108, 33, -14, 67, 124, 57, -83, -91, -86, -67, -57, 19, 90, -113, -41, 69, -25, 70, 70, 111, -41, -47, 76, -85, 118, -52, 110, -56, -28, 9, 75, 2, 43, -35, 15, 58, 31, 126, 8, 27, -82, -107, 2, 3, 1, 0, 1};
        f2267d = new HashMap();
        f2268e = new JSONArray();
        f2269f = c.a.b0.h.a.a();
        f2270g = null;
        d("is_https", "1");
        d(SearchJsBridge.COOKIE_MOD, f2269f.j());
        d("ua", f2269f.i());
        d("fmt", "json");
        d("apna", f2269f.packageName());
        d("ver", f2269f.q());
        d(SearchJsBridge.COOKIE_OV, f2269f.c());
        d("ot", "2");
        d("ct", "2");
        d("cuid", f2269f.b());
        d("uid", f2269f.m());
        d(TiebaStatic.Params.BDID, f2269f.g());
        d("encrypted_imei", g());
        d(HttpRequest.ANDROID_ID, f2269f.a());
        f2268e.put(f(AdExtParam.KEY_NAD_CORE_VERSION, "5.0.0.12"));
        f2268e.put(f("os_br", Build.BRAND));
        f2268e.put(f("os_mafa", Build.MANUFACTURER));
        f2268e.put(f("mac", f2269f.t()));
        f2268e.put(f("oaid_v", f2269f.h()));
        try {
            f2268e.put(f("encoded_ua_new", URLEncoder.encode(c.a.b0.h.a.e(), "utf-8")));
        } catch (UnsupportedEncodingException unused) {
        }
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
        this.f2271b = e.a().b("nad.refresh_count.sp");
    }

    public static void c(@NonNull c.a.b0.u.s.c cVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, cVar, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        cVar.a(str, str2);
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f2267d.put(str, str2);
    }

    public static JSONObject f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = f2270g;
            if (str != null) {
                return str;
            }
            try {
                String p = f2269f.p();
                if (TextUtils.isEmpty(p)) {
                    f2270g = "";
                } else {
                    byte[] a = m.a(p.getBytes(), m.b(f2266c));
                    if (a != null) {
                        f2270g = new String(android.util.Base64.encode(a, 2));
                    } else {
                        f2270g = "";
                    }
                }
            } catch (Throwable unused) {
                f2270g = "";
            }
            return f2270g;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.b0.w.c
    public void a(@NonNull RequestParameters requestParameters, @NonNull NadRequester.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, requestParameters, bVar) == null) {
            c.a.b0.u.g b2 = c.a.b0.u.g.b();
            d dVar = new d();
            JSONArray jSONArray = new JSONArray();
            c.a.b0.u.s.c e2 = c.a.b0.u.s.c.e(f2267d);
            for (int i2 = 0; i2 < f2268e.length(); i2++) {
                jSONArray.put(f2268e.opt(i2));
            }
            jSONArray.put(f(AdExtParam.KEY_IADEX, c.a.b0.d.c.a.e()));
            NadRequester.Error error = TextUtils.isEmpty(requestParameters.a) ? new NadRequester.Error("missing placeId") : null;
            if (requestParameters.f35761j == RequestParameters.SlotType.REWARD) {
                if (TextUtils.isEmpty(requestParameters.f35759h)) {
                    error = new NadRequester.Error("missing tu");
                }
                if (TextUtils.isEmpty(requestParameters.f35760i)) {
                    error = new NadRequester.Error("missing app_sid");
                }
                dVar.a("X-BD-SDK-SOURCE", "reward");
                c(e2, "appsid", requestParameters.f35760i);
                jSONArray.put(f("tu", requestParameters.f35759h));
                jSONArray.put(f("app_sid", requestParameters.f35760i));
            }
            if (error != null) {
                bVar.a(error);
                return;
            }
            dVar.k("https://afd.baidu.com/afd/entry");
            c(e2, "pid", requestParameters.a);
            c(e2, "ac", String.valueOf(requestParameters.f35753b));
            c(e2, "ft", requestParameters.f35757f.value);
            c(e2, "tabid", requestParameters.f35755d);
            c(e2, "tabn", requestParameters.f35754c);
            e(e2, requestParameters.a, requestParameters.f35754c);
            c(e2, "nt", String.valueOf(new n().c()));
            c(e2, "qe", requestParameters.f35758g);
            c(e2, "ext", jSONArray.toString());
            c(e2, "eid", f2269f.d());
            b(e2, requestParameters.k);
            dVar.a("User-Agent", c.a.b0.h.a.e());
            dVar.f(e2);
            b2.a().a(dVar, new C0091a(this, requestParameters, bVar));
        }
    }

    public final void b(@NonNull c.a.b0.u.s.c cVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, map) == null) || c.a.b0.x.a.h(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                c(cVar, entry.getKey(), entry.getValue());
            }
        }
    }

    public final void e(@NonNull c.a.b0.u.s.c cVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2 == null ? "" : str2);
            sb.append("_fc");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("_");
            if (str2 == null) {
                str2 = "";
            }
            sb3.append(str2);
            sb3.append("_ts");
            String sb4 = sb3.toString();
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = c.a.b0.h0.e.b(this.f2271b.getLong(sb4, 0L), currentTimeMillis) ? this.f2271b.getInt(sb2, 1) : 1;
            this.f2271b.h(sb4, currentTimeMillis);
            this.f2271b.g(sb2, i2 + 1);
            c(cVar, "fc", String.valueOf(i2));
        }
    }
}
