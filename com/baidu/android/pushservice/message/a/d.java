package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3553a;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3553a = context;
    }

    public abstract com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr);

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? ("com.baidu.searchbox_samsung".equals(str) && "com.baidu.searchbox".equals(this.f3553a.getPackageName())) ? "com.baidu.searchbox" : str : (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) != null) {
            return invokeL.booleanValue;
        }
        try {
            jSONObject = new JSONObject(new String(bArr));
        } catch (Exception e2) {
            new b.c(this.f3553a).a(Log.getStackTraceString(e2)).a();
        }
        if (!jSONObject.isNull("bccs_fb")) {
            i2 = Integer.parseInt(jSONObject.getString("bccs_fb"));
            return i2 != 1;
        }
        i2 = 0;
        if (i2 != 1) {
        }
    }
}
