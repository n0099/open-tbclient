package c.a.e0.k.b;

import android.content.Context;
import android.content.pm.PackageManager;
import c.a.e0.n.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(c.a.e0.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, cVar) == null) || cVar == null) {
            return;
        }
        cVar.e("channel", "cashiersdk");
        cVar.e("deviceType", "ANDROID");
        cVar.e(CommandMessage.SDK_VERSION, "2.7.6");
        cVar.e("appVersion", d());
        cVar.e("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static final void b(c.a.e0.k.a.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, cVar, str) == null) || cVar == null) {
            return;
        }
        boolean z = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return;
        }
        String b2 = cVar.b("Cookie");
        String str2 = "BDUSS=" + str;
        if ((b2 == null || StringsKt__StringsJVMKt.isBlank(b2)) ? true : true) {
            cVar.e("Cookie", str2);
            return;
        }
        cVar.e("Cookie", b2 + "; " + str2);
    }

    public static final c.a.e0.k.a.b c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c.a.e0.k.a.b bVar = new c.a.e0.k.a.b();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bVar.e(next, jSONObject.optString(next));
                }
            }
            return bVar;
        }
        return (c.a.e0.k.a.b) invokeL.objValue;
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context a2 = g.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a2.getPackageManager();
            try {
                Context a3 = g.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a3.getPackageName(), 0).versionName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.versionName");
                return str;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
