package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24691d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(i iVar, Context context) {
        super(iVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24691d = false;
    }

    @Override // com.baidu.android.pushservice.httpapi.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("response_params");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("channel_id");
                    String optString2 = optJSONObject.optString("new_channel_id");
                    String optString3 = optJSONObject.optString(com.baidu.android.pushservice.g.f() ? "rsa_channel_token" : "channel_token");
                    ((a) this).f24688b.f24704f = optJSONObject.optString("user_id");
                    ((a) this).f24688b.f24703e = optJSONObject.optString("appid");
                    com.baidu.android.pushservice.j.a(((a) this).a).a(optString, optString3, optString2, optJSONObject.optString("new_channel_token"));
                }
            } catch (Exception e2) {
                new b.c(((a) this).a).a(Log.getStackTraceString(e2)).a();
            }
            if (!com.baidu.android.pushservice.b.d.q(((a) this).a) || com.baidu.android.pushservice.b.d.c(((a) this).a)) {
                com.baidu.android.pushservice.a.e eVar = new com.baidu.android.pushservice.a.e();
                eVar.b(((a) this).f24688b.f24702d);
                eVar.a(((a) this).f24688b.f24703e);
                i iVar = ((a) this).f24688b;
                eVar.f24178d = iVar.f24704f;
                eVar.a(iVar.f24706h);
                eVar.a(com.baidu.android.pushservice.a.a());
                com.baidu.android.pushservice.a.b.a(((a) this).a).a("r_v2", com.baidu.android.pushservice.a.b.a(((a) this).a).a(eVar, this.f24691d));
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
