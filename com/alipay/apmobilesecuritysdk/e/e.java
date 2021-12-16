package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
            if (com.alipay.security.mobile.module.a.a.a(a)) {
                a = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
            }
            if (com.alipay.security.mobile.module.a.a.a(a)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                f fVar = new f();
                fVar.a(jSONObject.getString("imei"));
                fVar.b(jSONObject.getString(BaseStatisContent.IMSI));
                fVar.c(jSONObject.getString(BaseStatisContent.MAC));
                fVar.d(jSONObject.getString("bluetoothmac"));
                fVar.e(jSONObject.getString("gsi"));
                return fVar;
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
                return null;
            }
        }
        return (f) invokeL.objValue;
    }
}
