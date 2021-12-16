package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            g gVar = new g();
            try {
                jSONObject = new JSONObject(new String(eVar.f33202b));
            } catch (JSONException e2) {
                new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                jSONObject = null;
            }
            int optInt = jSONObject != null ? jSONObject.optInt(Constants.KEYS.RET, -1) : -1;
            if (optInt == 2002) {
                com.baidu.android.pushservice.k.a(this.a).a(null, null, null, null);
                m.c(this.a);
            }
            new b.C1719b(this.a).a(System.currentTimeMillis()).a(optInt + "").d(401102L).a();
            gVar.a(optInt);
            return gVar;
        }
        return (g) invokeL.objValue;
    }
}
