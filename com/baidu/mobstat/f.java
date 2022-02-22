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
import com.baidu.mobstat.bm;
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
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static f a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f37113b;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f37114b;

        /* renamed from: c  reason: collision with root package name */
        public String f37115c;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.f37114b = str2 == null ? "" : str2;
            this.f37115c = str3 == null ? "" : str3;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("n", this.a);
                    jSONObject.put("v", this.f37114b);
                    jSONObject.put("w", this.f37115c);
                    return jSONObject;
                } catch (JSONException e2) {
                    bb.c().b(e2);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37113b = "";
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) ? i2 == 100 || i2 == 200 || i2 == 130 : invokeI.booleanValue;
    }

    private ArrayList<a> b(Context context, int i2) {
        InterceptResult invokeLI;
        List<ActivityManager.RunningTaskInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, context, i2)) == null) {
            try {
                list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            } catch (Exception e2) {
                bb.c().b(e2);
                list = null;
            }
            if (list == null) {
                return new ArrayList<>();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : list) {
                if (linkedHashMap.size() > i2) {
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

    private ArrayList<a> c(Context context, int i2) {
        InterceptResult invokeLI;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, this, context, i2)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return new ArrayList<>();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i3 = 0; i3 < runningAppProcesses.size() && linkedHashMap.size() <= i2; i3++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i3);
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

    public synchronized void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            synchronized (this) {
                a(context, z, z ? 1 : 20);
            }
        }
    }

    private void a(Context context, boolean z, int i2) {
        ArrayList<a> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (a2 = a(context, i2)) == null || a2.size() == 0) {
            return;
        }
        if (z) {
            String b2 = a2.get(0).b();
            if (a(b2, this.f37113b)) {
                this.f37113b = b2;
            }
        }
        a(context, a2, z);
    }

    private ArrayList<a> a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return c(context, i2);
            }
            return b(context, i2);
        }
        return (ArrayList) invokeLI.objValue;
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) ? (TextUtils.isEmpty(str) || str.equals(this.f37113b)) ? false : true : invokeLL.booleanValue;
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
            } catch (PackageManager.NameNotFoundException e2) {
                bb.c().b(e2);
                str2 = "";
            }
            return str2 == null ? "" : str2;
        }
        return (String) invokeLL.objValue;
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
                str = bm.a.a(jSONObject.toString().getBytes());
            } catch (Exception e2) {
                bb.c().b(e2);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            k.f37128c.a(System.currentTimeMillis(), str);
        }
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
                return (applicationInfo.flags & 1) != 0;
            } catch (PackageManager.NameNotFoundException e2) {
                bb.c().b(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
