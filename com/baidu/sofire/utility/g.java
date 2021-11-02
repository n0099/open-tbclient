package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sofire.ac.F;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? b(context, str, str2, z, z2) : (String) invokeCommon.objValue;
    }

    public static String b(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        InterceptResult invokeCommon;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String[] g2 = c.g(context);
            String str3 = g2[0];
            String str4 = g2[1];
            if ("com.baidu.input_huawei".equals(context.getPackageName()) && !com.baidu.sofire.h.a.a(context).w()) {
                throw new NetworkErrorException("conn is blocked");
            }
            String valueOf = String.valueOf(new Date().getTime() / 1000);
            String a2 = q.a(str3 + valueOf + str4);
            byte[] a3 = com.baidu.sofire.core.h.a();
            String str5 = "";
            if (!TextUtils.isEmpty(str2)) {
                bytes = F.getInstance().ae(k.a(str2.getBytes()), a3);
            } else {
                bytes = "".getBytes();
            }
            byte[] bytes2 = q.a(e.b(context)).getBytes();
            String encodeToString = Base64.encodeToString(F.getInstance().re(a3, bytes2), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/100/");
            sb.append(str3);
            sb.append("/");
            sb.append(valueOf);
            sb.append("/");
            sb.append(a2);
            if (!TextUtils.isEmpty(encodeToString)) {
                sb.append("?skey=");
                sb.append(URLEncoder.encode(encodeToString, "utf-8"));
            }
            try {
                if (s.a(context)) {
                    str5 = new s(context).a(sb.toString(), bytes);
                } else {
                    str5 = new o(context).a(sb.toString(), bytes);
                }
            } catch (Throwable unused) {
                c.a();
            }
            if (!z || !TextUtils.isEmpty(str5)) {
                if (z2) {
                    JSONObject jSONObject = new JSONObject(str5);
                    byte[] rd = F.getInstance().rd(Base64.decode(jSONObject.optString("skey"), 0), bytes2);
                    String optString = jSONObject.optString("response");
                    jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    byte[] decode = Base64.decode(optString, 0);
                    byte[] ad = F.getInstance().ad(decode, rd);
                    if (decode != null && decode.length > 0 && (ad == null || ad.length == 0)) {
                        c.h(context);
                        throw new NetworkErrorException("aes is fail");
                    }
                    return new String(ad);
                }
                return str5;
            }
            try {
                com.baidu.sofire.h.a a4 = com.baidu.sofire.h.a.a(context);
                long currentTimeMillis = System.currentTimeMillis();
                long j = a4.f43070a.getLong("pu_cl_fd", 0L);
                if (j == 0) {
                    j = System.currentTimeMillis();
                    a4.f();
                }
                if (currentTimeMillis - j > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (c.e(context)) {
                        hashMap.put("0", Integer.valueOf(a4.h() + 1));
                        hashMap.put("1", Integer.valueOf(a4.i()));
                    } else {
                        hashMap.put("0", Integer.valueOf(a4.h()));
                        hashMap.put("1", Integer.valueOf(a4.i() + 1));
                    }
                    a4.f43071b.putInt("mo_fa_pu_cl", 0);
                    a4.f43071b.commit();
                    a4.f43071b.putInt("wi_fa_pu_cl", 0);
                    a4.f43071b.commit();
                    a4.f();
                    c.a(context, "1003112", (Map<String, Object>) hashMap, false);
                } else if (c.e(context)) {
                    a4.a(a4.h() + 1);
                } else {
                    a4.b(a4.i() + 1);
                }
            } catch (Throwable unused2) {
                c.a();
            }
            throw new NetworkErrorException("response is empty");
        }
        return (String) invokeCommon.objValue;
    }
}
