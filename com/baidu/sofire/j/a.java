package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.k.f;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] k;
    public static a l;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;
    public SharedPreferences e;
    public SharedPreferences.Editor f;
    public Context g;
    public int h;
    public String i;
    public Map<String, SharedPreferences> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074229070, "Lcom/baidu/sofire/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074229070, "Lcom/baidu/sofire/j/a;");
                return;
            }
        }
        k = f.a(24);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.getString("xyus", "");
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.getBoolean("s_c_c", true);
        }
        return invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c.getString("xyusec", "");
        }
        return (String) invokeV.objValue;
    }

    public SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.a.getInt("mo_fa_pu_ap", 0);
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.getInt("wi_fa_pu_ap", 0);
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a.getInt("mo_fa_pu_cl", 0);
        }
        return invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.a.getInt("wi_fa_pu_cl", 0);
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
                return this.e.getInt("re_net_hr", 24);
            }
            return this.e.getInt("re_net_hr", 3);
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.a.getInt("rtqe", 0);
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a.getBoolean("bka", true);
        }
        return invokeV.booleanValue;
    }

    public a(Context context) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = new HashMap();
        this.g = context;
        int j = com.baidu.sofire.k.b.j(context);
        this.h = j;
        if (j == 1) {
            sharedPreferences = context.getSharedPreferences("leroadcfg", 0);
        } else {
            sharedPreferences = null;
        }
        c cVar = new c(this.g, sharedPreferences, "leroadcfg", false, this.h);
        this.a = cVar;
        SharedPreferences.Editor edit = cVar.edit();
        this.b = edit;
        this.c = this.a;
        this.d = edit;
        c cVar2 = new c(this.g, this.h == 1 ? context.getSharedPreferences("re_po_rt", 0) : null, "re_po_rt", false, this.h);
        this.e = cVar2;
        this.f = cVar2.edit();
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (context == null) {
                    return l;
                }
                if (l == null) {
                    l = new a(context);
                }
                return l;
            }
        }
        return (a) invokeL.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b.putInt("mo_fa_pu_ap", i);
            this.b.commit();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.putInt("wi_fa_pu_ap", i);
            this.b.commit();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.b.putInt("rtqe", i);
            this.b.commit();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.b.putInt("sufzfd", i);
            this.b.commit();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.b.putInt("sustfd", i);
            this.b.commit();
        }
    }

    public int a(int i, int i2) {
        InterceptResult invokeII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            if (i != 0) {
                if (i != 1) {
                    str = "";
                } else {
                    str = "suetfite";
                }
            } else {
                str = "sustfits";
            }
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            SharedPreferences sharedPreferences = this.a;
            return sharedPreferences.getInt(str + i2, 0);
        }
        return invokeII.intValue;
    }

    public SharedPreferences a(String str) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                synchronized (this.j) {
                    sharedPreferences = this.j.get(str);
                    if (sharedPreferences == null) {
                        if (this.h == 1) {
                            sharedPreferences2 = this.g.getSharedPreferences(str, 0);
                        } else {
                            sharedPreferences2 = null;
                        }
                        c cVar = new c(this.g, sharedPreferences2, str, false, this.h, null);
                        this.j.put(str, cVar);
                        sharedPreferences = cVar;
                    }
                }
                return sharedPreferences;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.d.putString("rpnewuidn", "");
                this.d.commit();
                return;
            }
            try {
                this.d.putString("rpnewuidn", new String(Base64.encode(f.b(k, str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.d.commit();
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        SharedPreferences a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            try {
                string = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if ("querySharedHandler".equals(string)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("handle_platform", "sofire");
                return bundle2;
            }
            String string2 = bundle.getString("pref_name");
            if (TextUtils.isEmpty(string2)) {
                return null;
            }
            String string3 = bundle.getString("key");
            if (TextUtils.isEmpty(string3)) {
                return null;
            }
            if (string2.equals("leroadcfg")) {
                a = this.a;
            } else if (string2.equals("leroadcfg")) {
                a = this.c;
            } else if (string2.equals("re_po_rt")) {
                a = this.e;
            } else {
                a = a(string2);
            }
            char c = 0;
            if (string.startsWith("get")) {
                String string4 = bundle.getString("defult_value");
                if ((!"getString".equals(string) && TextUtils.isEmpty(string4)) || a == null) {
                    return null;
                }
                Bundle bundle3 = new Bundle();
                switch (string.hashCode()) {
                    case -1249359687:
                        if (string.equals("getInt")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -75354382:
                        if (string.equals("getLong")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 804029191:
                        if (string.equals("getString")) {
                            break;
                        }
                        c = 65535;
                        break;
                    case 1101572082:
                        if (string.equals("getBoolean")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1953351846:
                        if (string.equals("getFloat")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c == 4) {
                                    bundle3.putBoolean("result", a.getBoolean(string3, Boolean.parseBoolean(string4)));
                                }
                            } else {
                                bundle3.putFloat("result", a.getFloat(string3, Float.parseFloat(string4)));
                            }
                        } else {
                            bundle3.putLong("result", a.getLong(string3, Long.parseLong(string4)));
                        }
                    } else {
                        bundle3.putInt("result", a.getInt(string3, Integer.parseInt(string4)));
                    }
                } else {
                    bundle3.putString("result", a.getString(string3, string4));
                }
                return bundle3;
            }
            if (string.startsWith("put")) {
                SharedPreferences.Editor edit = a.edit();
                switch (string.hashCode()) {
                    case -976920992:
                        if (string.equals("putInt")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -462997504:
                        if (string.equals("putString")) {
                            break;
                        }
                        c = 65535;
                        break;
                    case -219689429:
                        if (string.equals("putLong")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 478450201:
                        if (string.equals("putBoolean")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1773932685:
                        if (string.equals("putFloat")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c == 4) {
                                    edit.putBoolean(string3, bundle.getBoolean("value"));
                                }
                            } else {
                                edit.putFloat(string3, bundle.getFloat("value"));
                            }
                        } else {
                            edit.putLong(string3, bundle.getLong("value"));
                        }
                    } else {
                        edit.putInt(string3, bundle.getInt("value"));
                    }
                } else {
                    edit.putString(string3, bundle.getString("value"));
                }
                edit.apply();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && i > this.a.getInt("opi", 0)) {
            this.b.putInt("opi", i);
            this.b.commit();
        }
    }

    public void a(int i, int i2, int i3) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            if (i != 0) {
                if (i != 1) {
                    str = "";
                } else {
                    str = "suetfite";
                }
            } else {
                str = "sustfits";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences.Editor editor = this.b;
            editor.putInt(str + i2, i3);
            this.b.commit();
        }
    }

    public void a(com.baidu.sofire.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            String string = this.e.getString("re_con", "");
            SharedPreferences.Editor editor = this.f;
            editor.putString("re_con", string + "||" + com.baidu.sofire.e.a.a(aVar));
            this.f.commit();
        }
    }

    public void a(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (list.size() == 0) {
                this.b.putString("glspk", "");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append("-");
                    }
                }
                this.b.putString("glspk", sb.toString());
            }
            this.b.commit();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.b.putBoolean("s_c_c", z);
            if (Build.VERSION.SDK_INT >= 9) {
                this.b.apply();
            } else {
                this.b.commit();
            }
        }
    }

    public void a(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < iArr.length; i++) {
                    sb.append(iArr[i]);
                    if (i != iArr.length - 1) {
                        sb.append("-");
                    }
                }
                this.b.putString("hcpk", sb.toString());
            } else {
                this.b.putString("hcpk", "");
            }
            this.b.commit();
        }
    }

    public List<com.baidu.sofire.e.a> c() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String string = this.e.getString("re_con", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : string.split("\\|\\|")) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        aVar.a = jSONObject.optString("0");
                        aVar.c = jSONObject.optString("1");
                        aVar.d = jSONObject.optString("2");
                        aVar.e = jSONObject.optString("3");
                        aVar.b = jSONObject.optString("4");
                    } catch (Exception unused) {
                        int i = com.baidu.sofire.a.b.a;
                        aVar = null;
                    }
                    if (aVar != null) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> e() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString("hcpk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e) {
                        e.getMessage();
                        int i = com.baidu.sofire.a.b.a;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> f() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString("glspk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e) {
                        e.getMessage();
                        int i = com.baidu.sofire.a.b.a;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
