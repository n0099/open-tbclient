package c.a.c0.g.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.c0.g;
import c.a.c0.d.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, c.a.c0.g.f.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, String> f1929b;

    /* renamed from: c  reason: collision with root package name */
    public final LruCache<String, String> f1930c;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1122931731, "Lc/a/c0/g/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1122931731, "Lc/a/c0/g/a/c$a;");
                    return;
                }
            }
            a = new c();
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(5);
        this.f1929b = new LruCache<>(5);
        this.f1930c = new LruCache<>(5);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (c) invokeV.objValue;
    }

    @NonNull
    public final c.a.c0.g.d.a a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            c.a.c0.g.d.a aVar = new c.a.c0.g.d.a();
            aVar.f1944g = str;
            aVar.g(str2);
            aVar.f1941d = str3;
            TextUtils.isEmpty(str3);
            aVar.n.a = str4;
            aVar.p.a = new JSONObject().toString();
            return aVar;
        }
        return (c.a.c0.g.d.a) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(c.a.c0.d.f.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
            String str = (String) c.a.c0.u.c.b(aVar.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject b2 = c.a.c0.u.b.b(str);
            String optString = b2.optString("type", "");
            String e2 = aVar.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b3 = c.a.c0.e.a.b();
            char c2 = 0;
            if (!NetUtil.a(b3) && (TextUtils.equals(optString, "startdownload") || TextUtils.equals(optString, "resumedownload"))) {
                Toast.makeText(b3, b3.getString(g.nad_download_net_tip), 0).show();
                return;
            }
            switch (optString.hashCode()) {
                case -1263192174:
                    if (optString.equals("openapk")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1028248962:
                    if (optString.equals("querypackage")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -690213213:
                    if (optString.equals(MiPushClient.COMMAND_REGISTER)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -568075006:
                    if (optString.equals("canceldownload")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -515860354:
                    if (optString.equals("pausedownload")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 120066997:
                    if (optString.equals("resumedownload")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 636901206:
                    break;
                case 836015164:
                    if (optString.equals(MiPushClient.COMMAND_UNREGISTER)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 900442785:
                    if (optString.equals("installapk")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1490291434:
                    if (optString.equals("startdownload")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c(b2, dVar);
                    return;
                case 1:
                    i(b2, dVar);
                    return;
                case 2:
                    g(b2, dVar);
                    return;
                case 3:
                    h(b2, dVar);
                    return;
                case 4:
                    d(b2, dVar);
                    return;
                case 5:
                    e(b2, dVar);
                    return;
                case 6:
                    f(e2, b2, dVar);
                    return;
                case 7:
                    j(b2, dVar);
                    return;
                case '\b':
                    m(b2, dVar);
                    return;
                case '\t':
                    n(b2, dVar);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, dVar) == null) || jSONObject == null || dVar == null) {
            return;
        }
        String optString = jSONObject.optString("callback", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("query");
        String optString2 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString3 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString);
        if (optJSONArray != null && optJSONArray.length() > 0 && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("url", "")) && !TextUtils.isEmpty(optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "")) && !TextUtils.isEmpty(optJSONObject.optString("ext_info", ""))) {
                    String optString4 = optJSONObject.optString("url", "");
                    String optString5 = optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
                    c.a.c0.g.f.b l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString("ext_info", ""), optString3, optString2);
                    if (l != null) {
                        String w = l.w();
                        Uri uri = l.v().f1948k;
                        jSONArray.put(c.a.c0.u.b.b(c.a.c0.g.i.b.a(w, l.v().f1946i + "", uri == null ? "" : uri.toString(), optString5)));
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            c.a.c0.u.b.d(jSONObject2, "result", jSONArray);
            hashMap.put("data", jSONObject2.toString());
            c.a.c0.g.i.b.b(dVar, true, hashMap);
        } else if (!TextUtils.isEmpty(optString)) {
            c.a.c0.g.i.b.b(dVar, false, hashMap);
        }
    }

    public final void d(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString("callback", "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.f();
                c.a.c0.g.i.b.c(dVar, optString3, optString2, optString4, "1");
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("callback", "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            c.a.c0.g.f.b l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.x();
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("callback", "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            c.a.c0.g.f.b l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.v();
                l.x();
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            c.a.c0.g.i.b.b(dVar, c.a.c0.g.i.a.g(optString4), hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString("callback", "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.v();
                l.x();
                c.a.c0.g.i.b.c(dVar, optString3, optString2, optString4, "2");
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString("callback", "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString3);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.v();
                l.x();
                c.a.c0.g.i.b.c(dVar, optString3, optString2, optString4, "1");
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable d dVar) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("callback", "");
        String optString3 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString4 = jSONObject.optString("uri", "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("packageName", "");
        String optString7 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString8 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString2);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                c.a.c0.g.d.a v = l.v();
                l.x();
                if (v != null && (uri = v.f1948k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", c.a.c0.g.i.b.a("0", "0", optString4, optString3));
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("callback");
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && c.a.c0.g.i.a.b(optString2)) {
            str = "0";
        }
        c.a.c0.u.b.d(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (dVar != null) {
            dVar.a(true, hashMap);
        }
    }

    public final c.a.c0.g.f.b l(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            if (TextUtils.isEmpty(str2) && this.f1929b.containsValue(str)) {
                for (String str7 : this.f1929b.keySet()) {
                    if (TextUtils.equals(this.f1929b.get(str7), str)) {
                        str2 = str7;
                    }
                }
            }
            if (TextUtils.isEmpty(str) && this.f1929b.containsKey(str2)) {
                str = this.f1929b.get(str2);
            }
            c.a.c0.g.f.b bVar = this.a.get(str2);
            if (bVar == null && !TextUtils.isEmpty(str)) {
                c.a.c0.g.d.a a2 = a(str, str2, str3, c.a.c0.g.i.b.d(str4));
                if (a2.o == null) {
                    a2.o = new c.a.c0.g.d.b();
                }
                if (a2.n == null) {
                    a2.n = new c.a.c0.g.d.d();
                }
                c.a.c0.g.d.b bVar2 = a2.o;
                bVar2.f1949b = str6;
                bVar2.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject b2 = c.a.c0.u.b.b(str4);
                    a2.o.f1953f = b2.optInt("close_v_dl");
                    a2.o.f1949b = b2.optString("source");
                    a2.n.f1967h = b2.optString("app_name");
                    a2.n.f1966g = b2.optString("app_icon");
                    a2.n.f1968i = b2.optString("version");
                }
                bVar = new c.a.c0.g.f.b(a2);
                this.a.put(str2, bVar);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.f1929b.put(str2, str);
            }
            return bVar;
        }
        return (c.a.c0.g.f.b) invokeCommon.objValue;
    }

    public final void m(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("callback");
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        c.a.c0.u.c.e(this.f1930c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.z(optString3, optString2, optString7, optString6);
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, dVar) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("callback");
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        c.a.c0.u.c.g(this.f1930c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put("callback", optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            c.a.c0.g.f.b l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.A(optString3, optString2, optString7, optString6);
                c.a.c0.g.i.b.b(dVar, true, hashMap);
                return;
            }
            c.a.c0.g.i.b.b(dVar, false, hashMap);
            return;
        }
        c.a.c0.g.i.b.b(dVar, false, hashMap);
    }
}
