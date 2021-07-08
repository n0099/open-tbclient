package com.baidu.searchbox.dns.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public b n;
    public b o;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new c();
        this.o = new c();
        this.mContext = context;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && p == null) {
            synchronized (a.class) {
                if (p == null) {
                    p = new a(context.getApplicationContext());
                }
            }
        }
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? p : (a) invokeV.objValue;
    }

    public void a(String str, com.baidu.searchbox.dns.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null) {
            return;
        }
        String aVar2 = aVar.toString();
        if (TextUtils.isEmpty(aVar2)) {
            return;
        }
        this.n.put(str, aVar2);
    }

    public com.baidu.searchbox.dns.d.a.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = this.n.get(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.baidu.searchbox.dns.d.a.a(str2);
        }
        return (com.baidu.searchbox.dns.d.a.a) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n.clear();
        }
    }

    public com.baidu.searchbox.dns.d.a.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                if (this.o.isEmpty()) {
                    String f2 = f();
                    if (TextUtils.isEmpty(f2)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(f2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject = jSONObject.optJSONObject(next);
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("ip");
                            ArrayList arrayList = new ArrayList(optJSONArray.length());
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList.add(optJSONArray.getString(i2));
                            }
                            if (!arrayList.isEmpty()) {
                                b(next, new com.baidu.searchbox.dns.d.a.a(null, 0, null, 0L, arrayList, null));
                            }
                        }
                    }
                }
                String str2 = this.o.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    return new com.baidu.searchbox.dns.d.a.a(str2);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (com.baidu.searchbox.dns.d.a.a) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mContext.getSharedPreferences("dns_prefs", 0).getString("SP_BACKUPIP_KEY", "") : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mContext.getSharedPreferences("dns_prefs", 0).getString("SP_BACKUPIP_VERSION_KEY", "0") : (String) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences("dns_prefs", 0).edit();
            edit.putString("SP_BACKUPIP_KEY", str);
            edit.apply();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences("dns_prefs", 0).edit();
            edit.putString("SP_BACKUPIP_VERSION_KEY", str);
            edit.apply();
        }
    }

    public void b(String str, com.baidu.searchbox.dns.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null) {
            return;
        }
        String aVar2 = aVar.toString();
        if (TextUtils.isEmpty(aVar2)) {
            return;
        }
        this.o.put(str, aVar2);
    }
}
