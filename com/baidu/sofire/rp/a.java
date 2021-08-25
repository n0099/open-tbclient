package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.g;
import com.baidu.sofire.utility.s;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
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
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            if (!TextUtils.isEmpty(a2.f45226c.getString("rpiiem", ""))) {
                a2.f45227d.putString("rpiiem", "");
                a2.f45227d.commit();
            }
            String n = a2.n();
            try {
                if (TextUtils.isEmpty(n)) {
                    n = s.h(context);
                    if (!TextUtils.isEmpty(n)) {
                        if (TextUtils.isEmpty(n)) {
                            a2.f45227d.putString("rpiiemn", "");
                            a2.f45227d.commit();
                        } else {
                            a2.f45227d.putString("rpiiemn", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), n.getBytes("UTF-8"), true), 10), "UTF-8"));
                            a2.f45227d.commit();
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
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                str = a2.f45226c.getString("rpandid", "");
                if (TextUtils.isEmpty(str)) {
                    str = s.i(context);
                    if (!TextUtils.isEmpty(str)) {
                        a2.f45227d.putString("rpandid", str);
                        a2.f45227d.commit();
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
