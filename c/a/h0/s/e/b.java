package c.a.h0.s.e;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.i;
import c.a.h0.l.c;
import c.a.h0.l.g;
import c.a.h0.l.h.d;
import c.a.h0.r.l;
import c.a.h0.s.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.h0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.h0.s.e.a a;

        public a(c.a.h0.s.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                a.C0149a c0149a = new a.C0149a();
                c0149a.a = 2;
                c0149a.f3668b = l.a().getResources().getString(i.calculate_price_default_error);
                this.a.a(c0149a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.C0149a c0149a = new a.C0149a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        c0149a.a = 0;
                        c0149a.f3668b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        c0149a.f3669c = optJSONObject.optLong("totalAmount");
                        c0149a.f3670d = optJSONObject.optLong("userPayAmount");
                        c0149a.f3672f = optJSONObject.optString("usedHostMarketingDetail");
                        c0149a.f3674h = a.C0149a.C0150a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        c0149a.a = jSONObject.optInt("errorLevel", 2);
                        c0149a.f3668b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    c0149a.a = 2;
                    c0149a.f3668b = l.a().getResources().getString(i.calculate_price_default_error);
                }
                this.a.a(c0149a);
            }
        }
    }

    /* renamed from: c.a.h0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0151b extends c.a.h0.l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.h0.s.e.a a;

        public C0151b(c.a.h0.s.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // c.a.h0.l.a
        public void a(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                a.C0149a c0149a = new a.C0149a();
                c0149a.a = 2;
                c0149a.f3668b = l.a().getResources().getString(i.calculate_price_default_error);
                this.a.a(c0149a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.C0149a c0149a = new a.C0149a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        c0149a.a = 0;
                        c0149a.f3668b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        c0149a.f3669c = optJSONObject.optLong("totalAmount");
                        c0149a.f3670d = optJSONObject.optLong("userPayAmount");
                        c0149a.f3671e = optJSONObject.optLong("reduceAmount");
                        c0149a.f3673g = optJSONObject.optInt("overdueStatus");
                        c0149a.f3672f = optJSONObject.optString("usedHostMarketingDetail");
                        c0149a.f3674h = a.C0149a.C0150a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        c0149a.a = jSONObject.optInt("errorLevel", 2);
                        c0149a.f3668b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    c0149a.a = 2;
                    c0149a.f3668b = l.a().getResources().getString(i.calculate_price_default_error);
                }
                this.a.a(c0149a);
            }
        }
    }

    public static void a(Bundle bundle, c.a.h0.s.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, aVar) == null) {
            c cVar = new c();
            c.a.h0.l.h.c.d(cVar);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, cVar);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, cVar);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, cVar);
            c.a.h0.l.b bVar = new c.a.h0.l.b();
            bVar.d("appKey", bundle.get("appKey").toString());
            bVar.d("totalAmount", bundle.get("totalAmount").toString());
            bVar.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new g().a(d.b(), cVar, bVar, new C0151b(aVar));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, c.a.h0.s.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, aVar) == null) {
            c cVar = new c();
            c.a.h0.l.h.c.d(cVar);
            if (!TextUtils.isEmpty(str)) {
                cVar.d("Cookie", "BDUSS=" + str);
            }
            c.a.h0.l.b bVar = new c.a.h0.l.b();
            bVar.d("appKey", str2);
            bVar.d("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                bVar.d("hostMarketingDetail", jSONArray.toString());
            }
            new g().a(d.b(), cVar, bVar, new a(aVar));
        }
    }

    public static void c(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, cVar) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = cVar.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            cVar.d("Cookie", str2);
            return;
        }
        cVar.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, cVar) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = cVar.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            cVar.d("Cookie", str2);
            return;
        }
        cVar.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, cVar) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = cVar.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            cVar.d("Cookie", str2);
            return;
        }
        cVar.d("Cookie", a2 + "; " + str2);
    }
}
