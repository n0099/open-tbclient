package c.a.p0.a.u.e.n;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.h2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends c.a.p0.a.u.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f8415f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8418g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f8419h;

        public a(k kVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8419h = kVar;
            this.f8416e = str;
            this.f8417f = str2;
            this.f8418g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.h2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    this.f8419h.d(this.f8416e, new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
                    return;
                }
                this.f8419h.z(this.f8417f, this.f8418g);
                this.f8419h.d(this.f8416e, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#openSystemSMSPanel", false);
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                c.a.p0.a.e0.d.b("ShowSMSPanelApi", "params: ", jSONObject);
                String optString = jSONObject.optString("content");
                JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
                if (optJSONArray == null) {
                    return new c.a.p0.a.u.h.b(202);
                }
                String y = y(optJSONArray);
                if (!TextUtils.isEmpty(y) && !TextUtils.isEmpty(optString)) {
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new c.a.p0.a.u.h.b(202);
                    }
                    c.a.p0.a.d2.d.J().r().d0().g(getContext(), "scope_show_sms_panel", new a(this, optString2, y, optString));
                    return c.a.p0.a.u.h.b.f();
                }
                return new c.a.p0.a.u.h.b(202);
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ShowSMSPanelApi" : (String) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.a.n2.s.f fVar = new c.a.p0.a.n2.s.f();
            fVar.f7113b = "sms_panel";
            fVar.f7116e = String.valueOf(this.f8415f);
            fVar.a("appid", c.a.p0.a.d2.d.J().getAppId());
            c.a.p0.a.n2.n.x("1639", fVar);
        }
    }

    public final String y(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f8415f = jSONArray.length();
            for (int i2 = 0; i2 < this.f8415f; i2++) {
                String optString = jSONArray.optString(i2);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                sb.append(optString);
                if (i2 != this.f8415f - 1) {
                    sb.append(";");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void z(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            getContext().startActivity(intent);
            x();
        }
    }
}
