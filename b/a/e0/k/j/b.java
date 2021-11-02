package b.a.e0.k.j;

import android.text.TextUtils;
import b.a.e0.h;
import b.a.e0.k.a.c;
import b.a.e0.k.a.f;
import b.a.e0.k.b.d;
import b.a.e0.k.j.a;
import b.a.e0.n.g;
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
    public static class a extends b.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.k.j.a f2677a;

        public a(b.a.e0.k.j.a aVar) {
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
            this.f2677a = aVar;
        }

        @Override // b.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                a.C0057a c0057a = new a.C0057a();
                c0057a.f2673a = 2;
                c0057a.f2674b = g.a().getResources().getString(h.calculate_price_default_error);
                this.f2677a.a(c0057a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                a.C0057a c0057a = new a.C0057a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        c0057a.f2673a = 0;
                        c0057a.f2674b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        optJSONObject.optLong("totalAmount");
                        c0057a.f2675c = optJSONObject.optLong("userPayAmount");
                        c0057a.f2676d = optJSONObject.optString("usedhostMarketingDetail");
                    } else {
                        c0057a.f2673a = jSONObject.optInt("errorLevel", 2);
                        c0057a.f2674b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    c0057a.f2673a = 2;
                    c0057a.f2674b = g.a().getResources().getString(h.calculate_price_default_error);
                }
                this.f2677a.a(c0057a);
            }
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, b.a.e0.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, str, str2, str3, list, aVar) == null) {
            c cVar = new c();
            if (!TextUtils.isEmpty(str)) {
                cVar.e("Cookie", "BDUSS=" + str);
            }
            b.a.e0.k.a.b bVar = new b.a.e0.k.a.b();
            bVar.e("appKey", str2);
            bVar.e("totalAmount", str3);
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
                bVar.e("hostMarketingDetail", jSONArray.toString());
            }
            new f().a(d.c(), cVar, bVar, new a(aVar));
        }
    }
}
