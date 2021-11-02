package com.baidu.android.pushservice.d;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35249d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(i iVar, Context context) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35249d = false;
    }

    @Override // com.baidu.android.pushservice.d.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("response_params");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("channel_id");
                    String optString2 = optJSONObject.optString("new_channel_id");
                    String optString3 = optJSONObject.optString(com.baidu.android.pushservice.h.f() ? "rsa_channel_token" : "channel_token");
                    ((a) this).f35245b.f35265f = optJSONObject.optString("user_id");
                    ((a) this).f35245b.f35264e = optJSONObject.optString("appid");
                    com.baidu.android.pushservice.k.a(((a) this).f35244a).a(optString, optString3, optString2, optJSONObject.optString("new_channel_token"));
                }
            } catch (Exception e2) {
                new b.c(((a) this).f35244a).a(Log.getStackTraceString(e2)).a();
            }
            if (!com.baidu.android.pushservice.b.d.q(((a) this).f35244a) || com.baidu.android.pushservice.b.d.c(((a) this).f35244a)) {
                com.baidu.android.pushservice.a.e eVar = new com.baidu.android.pushservice.a.e();
                eVar.b(((a) this).f35245b.f35263d);
                eVar.a(((a) this).f35245b.f35264e);
                i iVar = ((a) this).f35245b;
                eVar.f34977d = iVar.f35265f;
                eVar.a(iVar.f35267h);
                eVar.a(com.baidu.android.pushservice.a.a());
                com.baidu.android.pushservice.a.b.a(((a) this).f35244a).a("r_v2", com.baidu.android.pushservice.a.b.a(((a) this).f35244a).a(eVar, this.f35249d));
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
