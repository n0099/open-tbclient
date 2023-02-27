package com.baidu.android.pushservice.w;

import android.content.Context;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.w.c
    public g a(e eVar) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            g gVar = new g();
            try {
                jSONObject = new JSONObject(new String(eVar.b));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            int optInt = jSONObject != null ? jSONObject.optInt(Constants.KEYS.RET, -1) : -1;
            if (optInt == 2002) {
                com.baidu.android.pushservice.j.a(this.a).a(null, null, null, null);
                Utility.X(this.a);
            }
            gVar.a(optInt);
            return gVar;
        }
        return (g) invokeL.objValue;
    }
}
