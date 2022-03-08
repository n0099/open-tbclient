package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.h;
import com.baidu.sofire.utility.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        String str = "";
        try {
            com.baidu.sofire.h.a a = com.baidu.sofire.h.a.a(context);
            if (!TextUtils.isEmpty(a.f37109c.getString("rpiiem", ""))) {
                a.f37110d.putString("rpiiem", "");
                a.f37110d.commit();
            }
            String n = a.n();
            try {
                if (TextUtils.isEmpty(n)) {
                    n = u.h(context);
                    if (!TextUtils.isEmpty(n)) {
                        if (TextUtils.isEmpty(n)) {
                            a.f37110d.putString("rpiiemn", "");
                            a.f37110d.commit();
                        } else {
                            a.f37110d.putString("rpiiemn", new String(Base64.encode(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), n.getBytes("UTF-8"), true), 10), "UTF-8"));
                            a.f37110d.commit();
                        }
                    }
                }
                return n;
            } catch (Throwable unused) {
                str = n;
                c.a();
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str = "";
            try {
                com.baidu.sofire.h.a a = com.baidu.sofire.h.a.a(context);
                str = a.f37109c.getString("rpandid", "");
                if (TextUtils.isEmpty(str)) {
                    str = u.i(context);
                    if (!TextUtils.isEmpty(str)) {
                        a.f37110d.putString("rpandid", str);
                        a.f37110d.commit();
                    }
                }
            } catch (Throwable unused) {
                c.a();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
