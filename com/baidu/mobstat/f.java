package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static f a;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    private boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) ? i == 100 || i == 200 || i == 130 : invokeI.booleanValue;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.b = str2 == null ? "" : str2;
            this.c = str3 == null ? "" : str3;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("n", this.a);
                    jSONObject.put("v", this.b);
                    jSONObject.put(Config.DEVICE_WIDTH, this.c);
                    return jSONObject;
                } catch (JSONException e) {
                    ba.c().b(e);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366710082, "Lcom/baidu/mobstat/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366710082, "Lcom/baidu/mobstat/f;");
                return;
            }
        }
        a = new f();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
    }

    private String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            try {
                str2 = packageManager.getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                ba.c().b(e);
                str2 = "";
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    private ArrayList<a> a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return c(context, i);
            }
            return b(context, i);
        }
        return (ArrayList) invokeLI.objValue;
    }

    private void a(Context context, ArrayList<a> arrayList, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, context, arrayList, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() + "|");
            sb.append(z ? 1 : 0);
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject a2 = it.next().a();
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_trace", jSONArray);
                jSONObject.put("meta-data", sb.toString());
                str = bl.a.a(jSONObject.toString().getBytes());
            } catch (Exception e) {
                ba.c().b(e);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                k.c.a(context, System.currentTimeMillis(), str);
            }
        }
    }

    private void a(Context context, boolean z, int i) {
        ArrayList<a> a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (a2 = a(context, i)) != null && a2.size() != 0) {
            if (z) {
                String b = a2.get(0).b();
                if (a(b, this.b)) {
                    this.b = b;
                }
            }
            a(context, a2, z);
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !str.equals(this.b)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private ArrayList<a> b(Context context, int i) {
        InterceptResult invokeLI;
        List<ActivityManager.RunningTaskInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, context, i)) == null) {
            try {
                list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            } catch (Exception e) {
                ba.c().b(e);
                list = null;
            }
            if (list == null) {
                return new ArrayList<>();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : list) {
                if (linkedHashMap.size() > i) {
                    break;
                }
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null) {
                    String packageName = componentName.getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !b(context, packageName) && !linkedHashMap.containsKey(packageName)) {
                        linkedHashMap.put(packageName, new a(packageName, a(context, packageName), ""));
                    }
                }
            }
            return new ArrayList<>(linkedHashMap.values());
        }
        return (ArrayList) invokeLI.objValue;
    }

    private ArrayList<a> c(Context context, int i) {
        InterceptResult invokeLI;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, this, context, i)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return new ArrayList<>();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i2 = 0; i2 < runningAppProcesses.size() && linkedHashMap.size() <= i; i2++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                if (a(runningAppProcessInfo.importance) && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!TextUtils.isEmpty(str) && !b(context, str) && !linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, new a(str, a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                    }
                }
            }
            return new ArrayList<>(linkedHashMap.values());
        }
        return (ArrayList) invokeLI.objValue;
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, str)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
                if (applicationInfo == null) {
                    return false;
                }
                if ((applicationInfo.flags & 1) == 0) {
                    return false;
                }
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                ba.c().b(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            synchronized (this) {
                int i = 1;
                if (!z) {
                    i = 20;
                }
                a(context, z, i);
            }
        }
    }
}
