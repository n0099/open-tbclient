package b.a.p0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f8358d;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8360f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8361g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ j f8362h;

        public a(j jVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8362h = jVar;
            this.f8359e = str;
            this.f8360f = str2;
            this.f8361g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    this.f8362h.d(this.f8359e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
                    return;
                }
                this.f8362h.s(this.f8360f, this.f8361g);
                this.f8362h.d(this.f8359e, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6384b = "sms_panel";
            fVar.f6387e = String.valueOf(this.f8358d);
            fVar.a("appid", b.a.p0.a.a2.d.g().getAppId());
            b.a.p0.a.j2.k.u("1639", fVar);
        }
    }

    public final String r(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f8358d = jSONArray.length();
            for (int i2 = 0; i2 < this.f8358d; i2++) {
                String optString = jSONArray.optString(i2);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                sb.append(optString);
                if (i2 != this.f8358d - 1) {
                    sb.append(";");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void s(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            getContext().startActivity(intent);
            q();
        }
    }

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-ShowSMSPanel", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-ShowSMSPanel", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            b.a.p0.a.e0.d.a("Api-ShowSMSPanel", "params: ", jSONObject);
            String optString = jSONObject.optString("content");
            JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
            if (optJSONArray == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            String r = r(optJSONArray);
            if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202);
                }
                b.a.p0.a.a2.d.g().r().S().g(getContext(), "scope_show_sms_panel", new a(this, optString2, r, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
