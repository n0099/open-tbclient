package com.baidu.sofire.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
            a2.d.putString("rpandid", "");
            a2.d.commit();
            a2.d.putString("rpiiem", "");
            a2.d.commit();
            if (TextUtils.isEmpty("")) {
                a2.d.putString("rpiiemn", "");
                a2.d.commit();
            } else {
                try {
                    a2.d.putString("rpiiemn", new String(Base64.encode(e.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.d.commit();
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
            }
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_o_d_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_o_d_t", new String(Base64.encode(e.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
            }
            a2.b.putLong("p_s_o_d_t_t", 0L);
            a2.b.commit();
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_s_o_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_s_o_t", new String(Base64.encode(e.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused3) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
            }
            a2.b.putLong("p_s_s_o_t_t", 0L);
            a2.b.commit();
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_n_o_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_n_o_t", new String(Base64.encode(e.b("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused4) {
                    int i4 = com.baidu.sofire.a.b.a;
                }
            }
            a2.b.putLong("p_s_n_o_t_t", 0L);
            a2.b.commit();
            if (b(context)) {
                a2.c("");
                a2.b(0L);
                a2.g("");
                a2.d(0L);
                a2.b("");
                a2.a(0L);
                a2.e("");
                a2.c(0L);
            }
        }
    }

    public static synchronized boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (d.class) {
                int i = a;
                boolean z = false;
                if (i != -1) {
                    if (i == 1) {
                        z = true;
                    }
                    return z;
                }
                String packageName = context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    return false;
                }
                packageName.toLowerCase().contains("baidu");
                a = 1;
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
