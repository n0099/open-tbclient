package c.b.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c.b.a.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class t0 implements v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t0() {
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

    @Override // c.b.a.v0
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? Build.VERSION.SDK_INT > 28 : invokeL.booleanValue;
    }

    @Override // c.b.a.v0
    public v0.a b(Context context) {
        InterceptResult invokeL;
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            try {
                if (Build.VERSION.SDK_INT > 17) {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient == null) {
                        return null;
                    }
                    call = acquireContentProviderClient.call("getOAID", null, null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    call = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
                }
                if (call == null) {
                    return null;
                }
                if (call.getInt("code", -1) == 0) {
                    v0.a aVar = new v0.a();
                    aVar.f31459a = call.getString("id");
                    return aVar;
                }
                if (!TextUtils.isEmpty(call.getString("message"))) {
                    String str = u0.f31448j;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (v0.a) invokeL.objValue;
    }
}
