package c.a.a0.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import c.a.a0.l0.f;
import c.a.a0.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class a extends c.a.a0.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0011a extends c.a.a0.u.p.c<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1060b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f1061c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1062d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.g.g.d f1063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.g.f.a f1064f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HashMap f1065g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f1066h;
        public final /* synthetic */ a i;

        public C0011a(a aVar, f fVar, String str, Context context, String str2, c.a.a0.g.g.d dVar, c.a.a0.g.f.a aVar2, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar, str, context, str2, dVar, aVar2, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = aVar;
            this.a = fVar;
            this.f1060b = str;
            this.f1061c = context;
            this.f1062d = str2;
            this.f1063e = dVar;
            this.f1064f = aVar2;
            this.f1065g = hashMap;
            this.f1066h = str3;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.a.dismiss();
                this.i.m("4", this.f1060b);
                boolean k = this.i.k(this.f1061c, this.f1062d, this.f1060b);
                this.i.c(this.f1063e, this.f1064f, k ? 0 : 1001, k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i) == null) {
                this.a.dismiss();
                if (map == null) {
                    this.i.m("8", this.f1060b);
                    boolean k = this.i.k(this.f1061c, this.f1062d, this.f1060b);
                    this.i.c(this.f1063e, this.f1064f, k ? 0 : 1001, k);
                    return;
                }
                String str = (String) c.a.a0.x.c.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.i.m("5", this.f1060b);
                    boolean k2 = this.i.k(this.f1061c, this.f1062d, this.f1060b);
                    this.i.c(this.f1063e, this.f1064f, k2 ? 0 : 1001, k2);
                    return;
                }
                String str2 = (String) c.a.a0.x.c.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.i.m("6", this.f1060b);
                    boolean k3 = this.i.k(this.f1061c, this.f1062d, this.f1060b);
                    this.i.c(this.f1063e, this.f1064f, k3 ? 0 : 1001, k3);
                    return;
                }
                String str3 = (String) c.a.a0.x.c.b(this.f1065g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.i.m("3", this.f1060b);
                } else {
                    this.i.m("7", this.f1060b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.f1066h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    c.a.a0.u.s.d dVar = new c.a.a0.u.s.d();
                    dVar.k(replaceAll);
                    dVar.g(3000);
                    dVar.c();
                    g.b().a().a(dVar, null);
                }
                boolean k4 = this.i.k(this.f1061c, str, this.f1060b);
                this.i.c(this.f1063e, this.f1064f, k4 ? 0 : 1001, k4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? a.l(str) : (Map) invokeLLI.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Map<String, String> l(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONArray optJSONArray = c.a.a0.x.b.b(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.a0.g.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    @Override // c.a.a0.g.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.a0.g.f.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.a0.g.g.d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = (String) c.a.a0.x.c.b(d2, "ext_info");
            String str2 = (String) c.a.a0.x.c.b(d2, "phone");
            if (TextUtils.isEmpty(str2)) {
                m("1", str);
                c(dVar, aVar, 202, false);
                return true;
            }
            if (TextUtils.equals(d2.containsKey("type") ? (String) c.a.a0.x.c.b(d2, "type") : "0", "1")) {
                String str3 = (String) c.a.a0.x.c.b(d2, "number_url");
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str4)) {
                    m("2", str);
                    boolean k = k(context, str2, str);
                    c(dVar, aVar, k ? 0 : 1001, k);
                    return true;
                }
                f fVar = new f(context);
                fVar.e(context.getString(R.string.obfuscated_res_0x7f0f0ba6));
                fVar.c(false);
                fVar.d(false);
                c.a.a0.h0.a.b(fVar);
                C0011a c0011a = new C0011a(this, fVar, str, context, str2, dVar, aVar, d2, valueOf);
                String replaceAll = str4.replaceAll("\\__TIMESTAMP__", valueOf);
                c.a.a0.u.s.d dVar2 = new c.a.a0.u.s.d();
                dVar2.k(replaceAll);
                dVar2.g(3000);
                dVar2.c();
                g.b().a().a(dVar2, c0011a);
            } else {
                boolean k2 = k(context, str2, str);
                c(dVar, aVar, k2 ? 0 : 1001, k2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean k(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.a.a0.h0.a.c(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                m("11", str2);
                new c.a.a0.l0.v.a().m(context, str2, "makePhoneCall");
                return true;
            }
            m("9", str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void m(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.a0.a0.a.b(new ClogBuilder().q(ClogBuilder.Page.AD_CALL).g(ClogBuilder.Area.AD_CALL).s(ClogBuilder.LogType.AD_CALL).i(str).n(str2));
    }
}
