package c.a.b0.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import c.a.b0.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.CallActionLoadingDialog;
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
public class a extends c.a.b0.f.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0026a extends c.a.b0.u.p.c<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallActionLoadingDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f1411c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1412d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.f.g.d f1413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.f.f.a f1414f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HashMap f1415g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f1416h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f1417i;

        public C0026a(a aVar, CallActionLoadingDialog callActionLoadingDialog, String str, Context context, String str2, c.a.b0.f.g.d dVar, c.a.b0.f.f.a aVar2, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callActionLoadingDialog, str, context, str2, dVar, aVar2, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1417i = aVar;
            this.a = callActionLoadingDialog;
            this.f1410b = str;
            this.f1411c = context;
            this.f1412d = str2;
            this.f1413e = dVar;
            this.f1414f = aVar2;
            this.f1415g = hashMap;
            this.f1416h = str3;
        }

        @Override // c.a.b0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.a.dismiss();
                this.f1417i.m("4", this.f1410b);
                boolean k = this.f1417i.k(this.f1411c, this.f1412d, this.f1410b);
                this.f1417i.c(this.f1413e, this.f1414f, k ? 0 : 1001, k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i2) == null) {
                this.a.dismiss();
                if (map == null) {
                    this.f1417i.m("8", this.f1410b);
                    boolean k = this.f1417i.k(this.f1411c, this.f1412d, this.f1410b);
                    this.f1417i.c(this.f1413e, this.f1414f, k ? 0 : 1001, k);
                    return;
                }
                String str = (String) c.a.b0.x.c.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.f1417i.m("5", this.f1410b);
                    boolean k2 = this.f1417i.k(this.f1411c, this.f1412d, this.f1410b);
                    this.f1417i.c(this.f1413e, this.f1414f, k2 ? 0 : 1001, k2);
                    return;
                }
                String str2 = (String) c.a.b0.x.c.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.f1417i.m("6", this.f1410b);
                    boolean k3 = this.f1417i.k(this.f1411c, this.f1412d, this.f1410b);
                    this.f1417i.c(this.f1413e, this.f1414f, k3 ? 0 : 1001, k3);
                    return;
                }
                String str3 = (String) c.a.b0.x.c.b(this.f1415g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.f1417i.m("3", this.f1410b);
                } else {
                    this.f1417i.m("7", this.f1410b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.f1416h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    c.a.b0.u.s.d dVar = new c.a.b0.u.s.d();
                    dVar.k(replaceAll);
                    dVar.g(3000);
                    dVar.c();
                    g.b().a().a(dVar, null);
                }
                boolean k4 = this.f1417i.k(this.f1411c, str, this.f1410b);
                this.f1417i.c(this.f1413e, this.f1414f, k4 ? 0 : 1001, k4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? a.l(str) : (Map) invokeLLI.objValue;
        }
    }

    public a() {
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
            JSONArray optJSONArray = c.a.b0.x.b.b(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // c.a.b0.f.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    @Override // c.a.b0.f.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.b0.f.f.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.b0.f.g.d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = (String) c.a.b0.x.c.b(d2, "ext_info");
            String str2 = (String) c.a.b0.x.c.b(d2, "phone");
            if (TextUtils.isEmpty(str2)) {
                m("1", str);
                c(dVar, aVar, 202, false);
                return true;
            }
            if (TextUtils.equals(d2.containsKey("type") ? (String) c.a.b0.x.c.b(d2, "type") : "0", "1")) {
                String str3 = (String) c.a.b0.x.c.b(d2, "number_url");
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
                CallActionLoadingDialog cancelWhenTouchOutside = new CallActionLoadingDialog(context).setMessage(context.getString(R.string.nad_ocpc_phone_call_toast_text)).setCancelWhenBackKey(false).setCancelWhenTouchOutside(false);
                c.a.b0.h0.a.b(cancelWhenTouchOutside);
                C0026a c0026a = new C0026a(this, cancelWhenTouchOutside, str, context, str2, dVar, aVar, d2, valueOf);
                String replaceAll = str4.replaceAll("\\__TIMESTAMP__", valueOf);
                c.a.b0.u.s.d dVar2 = new c.a.b0.u.s.d();
                dVar2.k(replaceAll);
                dVar2.g(3000);
                dVar2.c();
                g.b().a().a(dVar2, c0026a);
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
            if (c.a.b0.h0.a.c(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                m("11", str2);
                new c.a.b0.l0.t.a().m(context, str2, "makePhoneCall");
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
        c.a.b0.a0.a.b(new ClogBuilder().q(ClogBuilder.Page.AD_CALL).g(ClogBuilder.Area.AD_CALL).s(ClogBuilder.LogType.AD_CALL).i(str).n(str2));
    }
}
