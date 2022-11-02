package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.bl;
import com.baidu.mobstat.bs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;

        public a(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            str = str == null ? "" : str;
            str2 = str2 == null ? "" : str2;
            str3 = str3 == null ? "" : str3;
            str4 = str4 == null ? "" : str4;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("n", this.a);
                    jSONObject.put("v", this.b);
                    jSONObject.put("c", this.c);
                    jSONObject.put("a", this.d);
                    return jSONObject;
                } catch (JSONException e) {
                    ba.c().b(e);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366710144, "Lcom/baidu/mobstat/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366710144, "Lcom/baidu/mobstat/d;");
                return;
            }
        }
        a = new d();
    }

    public d() {
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0009: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    private void a(Context context, ArrayList<a> arrayList) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, arrayList) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
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
                jSONObject.put("app_apk", jSONArray);
                jSONObject.put("meta-data", sb.toString());
                str = bl.a.a(jSONObject.toString().getBytes());
            } catch (Exception e) {
                ba.c().b(e);
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                k.e.a(context, System.currentTimeMillis(), str);
            }
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            a(context, c(context));
        }
    }

    public synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                b(context);
            }
        }
    }

    private ArrayList<a> c(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            ArrayList<a> arrayList = new ArrayList<>();
            Iterator<PackageInfo> it = d(context).iterator();
            while (it.hasNext()) {
                PackageInfo next = it.next();
                ApplicationInfo applicationInfo = next.applicationInfo;
                if (applicationInfo != null) {
                    String str2 = next.packageName;
                    String str3 = next.versionName;
                    Signature[] signatureArr = next.signatures;
                    String str4 = "";
                    if (signatureArr == null || signatureArr.length == 0) {
                        str = "";
                    } else {
                        str = signatureArr[0].toChars().toString();
                    }
                    String a2 = bs.b.a(str.getBytes());
                    String str5 = applicationInfo.sourceDir;
                    if (!TextUtils.isEmpty(str5)) {
                        str4 = bs.b.a(new File(str5));
                    }
                    arrayList.add(new a(str2, str3, a2, str4));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private ArrayList<PackageInfo> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            ArrayList<PackageInfo> arrayList = new ArrayList<>();
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return arrayList;
            }
            List<PackageInfo> arrayList2 = new ArrayList<>(1);
            try {
                arrayList2 = packageManager.getInstalledPackages(64);
            } catch (Exception e) {
                ba.c().b(e);
            }
            for (PackageInfo packageInfo : arrayList2) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                    arrayList.add(packageInfo);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
