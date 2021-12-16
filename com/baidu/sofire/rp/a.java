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
/* loaded from: classes10.dex */
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
            if (!TextUtils.isEmpty(a.f39610c.getString("rpiiem", ""))) {
                a.f39611d.putString("rpiiem", "");
                a.f39611d.commit();
            }
            String n = a.n();
            try {
                if (TextUtils.isEmpty(n)) {
                    n = u.h(context);
                    if (!TextUtils.isEmpty(n)) {
                        if (TextUtils.isEmpty(n)) {
                            a.f39611d.putString("rpiiemn", "");
                            a.f39611d.commit();
                        } else {
                            a.f39611d.putString("rpiiemn", new String(Base64.encode(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), n.getBytes("UTF-8"), true), 10), "UTF-8"));
                            a.f39611d.commit();
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
                str = a.f39610c.getString("rpandid", "");
                if (TextUtils.isEmpty(str)) {
                    str = u.i(context);
                    if (!TextUtils.isEmpty(str)) {
                        a.f39611d.putString("rpandid", str);
                        a.f39611d.commit();
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
