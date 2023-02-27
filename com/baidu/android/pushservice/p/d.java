package com.baidu.android.pushservice.p;

import android.content.Context;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;

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
        this.f = false;
    }

    @Override // com.baidu.android.pushservice.p.a
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("response_params");
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("channel_id");
                    String optString3 = optJSONObject.optString("new_channel_id");
                    String optString4 = optJSONObject.optString(com.baidu.android.pushservice.g.f() ? "rsa_channel_token" : "channel_token");
                    String optString5 = optJSONObject.optString("user_id");
                    String optString6 = optJSONObject.optString("appid");
                    this.d.e = optString5;
                    this.d.d = optString6;
                    com.baidu.android.pushservice.j.a(this.c).a(optString2, optString4, optString3, optJSONObject.optString("new_channel_token"));
                    com.baidu.android.pushservice.a0.i.a(this.c, optString6, optString2, optString3, optString, optString5, System.currentTimeMillis(), this.d.b, this.d.f);
                }
            } catch (Exception unused) {
            }
            if (!com.baidu.android.pushservice.l.d.r(this.c) || com.baidu.android.pushservice.l.d.q(this.c)) {
                com.baidu.android.pushservice.k.e eVar = new com.baidu.android.pushservice.k.e();
                eVar.b(this.d.c);
                eVar.a(this.d.d);
                i iVar = this.d;
                eVar.d = iVar.e;
                eVar.a(iVar.g);
                eVar.a(com.baidu.android.pushservice.a.a());
                com.baidu.android.pushservice.k.b.a(this.c).b("r_v2", com.baidu.android.pushservice.k.b.a(this.c).a(eVar, this.f));
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
