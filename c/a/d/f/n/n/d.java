package c.a.d.f.n.n;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) || hashMap == null || str == null || str2 == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) || sb == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append("&");
            sb.append(str);
            sb.append("=");
            if (z) {
                str2 = URLEncoder.encode(str2, "utf-8");
            }
            sb.append(str2);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static String c(c.a.d.f.n.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            if (dVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.f2890b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.f2891c, "utf-8"));
                sb.append("&");
                sb.append(UrlOcrConfig.IdCardKey.OS);
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.q, "utf-8"));
                if (!TextUtils.isEmpty(dVar.f2892d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2892d, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.f2893e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2893e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.k, "utf-8"));
                if (!TextUtils.isEmpty(dVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.f2894f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2894f, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.f2897i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2897i, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.f2895g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2895g, "utf-8"));
                }
                if (!TextUtils.isEmpty(dVar.f2896h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(dVar.f2896h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(dVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                BdLog.e(e2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, c.a.d.f.n.d dVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, dVar)) == null) {
            if (dVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", dVar.f2891c, z);
            b(sb, HttpRequest.PHONE_IMEI, dVar.f2897i, z);
            b(sb, HttpRequest.CLIENT_ID, dVar.f2894f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, dVar.f2898j, z);
            b(sb, HttpConstants.OS_VERSION, dVar.q, z);
            b(sb, "from", dVar.f2892d, z);
            b(sb, "cfrom", dVar.f2893e, z);
            b(sb, "net_type", dVar.p, z);
            b(sb, "cuid", dVar.f2895g, z);
            b(sb, "model", dVar.k, z);
            if (TextUtils.isEmpty(dVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", dVar.l, z);
            }
            b(sb, "un", dVar.m, z);
            b(sb, "utbrand", dVar.w, z);
            b(sb, "cuid_galaxy2", dVar.f2896h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(c.a.d.f.n.j.a aVar, c.a.d.f.n.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, dVar)) == null) {
            if (aVar.p() != null && (aVar.p().equals("omp") || aVar.p().equals("mon"))) {
                return c(dVar);
            }
            return d(true, dVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, c.a.d.f.n.d dVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, dVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", dVar.f2891c);
            a(hashMap, HttpRequest.CLIENT_ID, dVar.f2894f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, dVar.f2898j);
            a(hashMap, "from", dVar.f2892d);
            a(hashMap, "net_type", dVar.p);
            a(hashMap, "cuid", dVar.f2895g);
            a(hashMap, "cuid_galaxy2", dVar.f2896h);
            a(hashMap, "model", dVar.k);
            if (TextUtils.isEmpty(dVar.l)) {
                dVar.l = "0";
            }
            a(hashMap, "uid", dVar.l);
            a(hashMap, "un", dVar.m);
            a(hashMap, HttpRequest.BDUSS, dVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", dVar.r);
            a(hashMap, "cua", dVar.s);
            a(hashMap, TiebaStatic.Params.BDID, dVar.z);
            a(hashMap, "cookie", dVar.n);
            a(hashMap, "oaid", dVar.t);
            a(hashMap, "utbrand", dVar.w);
            a(hashMap, "baiduapppb_ut", dVar.x);
            a(hashMap, "user_agent", dVar.y);
            a(hashMap, "active_timestamp", dVar.A);
            a(hashMap, "first_install_time", dVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, dVar.C);
            a(hashMap, "event_day", dVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", dVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, dVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, dVar.f2897i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
