package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 1010;
    public static a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, int i, int i2, Intent intent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, Integer.valueOf(i), Integer.valueOf(i2), intent})) == null) {
            if (i != 1010 || intent == null) {
                return false;
            }
            a aVar2 = b;
            if (aVar2 == null) {
                return true;
            }
            b = null;
            if (i2 != -1) {
                String str = "";
                if (i2 != 0) {
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.B0, "" + i2);
                } else {
                    if (intent != null) {
                        str = intent.toUri(1);
                    }
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.A0, str);
                    aVar2.a(false, null, "CANCELED");
                }
            } else {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.C0, intent.toUri(1));
                aVar2.a(true, l.a(intent), "OK");
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, Activity activity, int i, String str, String str2, a aVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{aVar, activity, Integer.valueOf(i), str, str2, aVar2})) == null) {
            try {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.z0);
                activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
                b = aVar2;
                return true;
            } catch (Throwable th) {
                aVar2.a(false, null, "UNKNOWN_ERROR");
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.D0, th);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, context)) == null) {
            return l.b(aVar, context, Collections.singletonList(new a.b("com.taobao.taobao", 0, "")));
        }
        return invokeLL.booleanValue;
    }
}
