package c.a.n0.g.i.b;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.n0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10672c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(814453788, "Lc/a/n0/g/i/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(814453788, "Lc/a/n0/g/i/b/a;");
                return;
            }
        }
        f10672c = k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("GetAppUseDuration");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.g.f.a
    public c.a.n0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.n0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                bVar.onFail(202, "params may be error");
                return null;
            }
            if (f10672c) {
                String str = "params is " + jSONObject.toString();
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(202, "params may be error");
            } else {
                b(optString, bVar);
            }
            return null;
        }
        return (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public final void b(String str, @NonNull c.a.n0.a.u0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            try {
                if (c()) {
                    PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        List<UsageStats> queryUsageStats = ((UsageStatsManager) AppRuntime.getAppContext().getSystemService("usagestats")).queryUsageStats(3, packageInfo.firstInstallTime, Calendar.getInstance().getTimeInMillis());
                        if (queryUsageStats.size() == 0) {
                            bVar.onFail(101, "noPermission");
                            return;
                        }
                        for (UsageStats usageStats : queryUsageStats) {
                            if (TextUtils.equals(usageStats.getPackageName(), str)) {
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("appUseDuration", usageStats.getTotalTimeInForeground());
                                jSONObject.put("data", jSONObject2);
                                bVar.a(jSONObject);
                                return;
                            }
                        }
                        bVar.onFail(31016, "no package info");
                        return;
                    }
                    bVar.onFail(31016, "no package info");
                    return;
                }
                bVar.onFail(101, "noPermission");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                bVar.onFail(31011, "app is not installed");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((AppOpsManager) AppRuntime.getAppContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), AppRuntime.getAppContext().getPackageName()) == 0 : invokeV.booleanValue;
    }
}
