package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final e a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366710113, "Lcom/baidu/mobstat/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366710113, "Lcom/baidu/mobstat/e;");
                return;
            }
        }
        a = new e();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (str != null) {
                File file = new File(str);
                if (file.exists()) {
                    return file.lastModified();
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    private void b(Context context, boolean z) {
        PackageManager packageManager;
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65539, this, context, z) != null) || (packageManager = context.getPackageManager()) == null) {
            return;
        }
        List<PackageInfo> arrayList = new ArrayList<>(1);
        try {
            arrayList = packageManager.getInstalledPackages(0);
        } catch (Exception e) {
            ba.c().b(e);
        }
        JSONArray jSONArray = new JSONArray();
        for (PackageInfo packageInfo : arrayList) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 1) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String str2 = applicationInfo.sourceDir;
                if (z == z2) {
                    a(z, "", str2, packageInfo, jSONArray, true);
                }
            }
        }
        if (jSONArray.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() + "|");
        sb.append(z ? 1 : 0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = bl.a.a(jSONObject.toString().getBytes());
        } catch (Exception unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            k.b.a(context, System.currentTimeMillis(), str);
        }
    }

    public synchronized void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            synchronized (this) {
                b(context, z);
            }
        }
    }

    public void a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray, boolean z2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, str2, packageInfo, jSONArray, Boolean.valueOf(z2)}) == null) {
            if (z && packageInfo.packageName.startsWith("com.android.")) {
                return;
            }
            long j2 = 0;
            try {
                j = packageInfo.firstInstallTime;
            } catch (Throwable th) {
                ba.c().b(th);
                j = 0;
            }
            try {
                j2 = packageInfo.lastUpdateTime;
            } catch (Throwable th2) {
                ba.c().b(th2);
            }
            long a2 = a(str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put("a", str);
                jSONObject.put("v", String.valueOf(packageInfo.versionName));
                jSONObject.put("f", j);
                jSONObject.put("l", j2);
                jSONObject.put("m", a2);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                ba.c().b(e);
            }
        }
    }
}
