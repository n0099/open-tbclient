package c.a.p0.a.r1.q;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import c.a.p0.a.j2.b;
import c.a.p0.a.k;
import c.a.p0.a.v2.m;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8482a;

    /* renamed from: b  reason: collision with root package name */
    public static List<Pair<String, Pair<String, String>>> f8483b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1400897937, "Lc/a/p0/a/r1/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1400897937, "Lc/a/p0/a/r1/q/a;");
                return;
            }
        }
        boolean z = k.f7085a;
        f8482a = z;
        if (z) {
            ArrayList arrayList = new ArrayList();
            f8483b = arrayList;
            arrayList.add(new Pair("总时长", new Pair("na_pms_start_req", "na_end_update_db")));
            f8483b.add(new Pair<>("PMS信息获取时长", new Pair("na_pms_start_req", "na_pms_end_req")));
            f8483b.add(new Pair<>("包下载时长", new Pair("na_pms_start_download", "na_pms_end_download")));
            f8483b.add(new Pair<>("Icon下载时长", new Pair("na_pms_start_icon", "na_pms_end_icon")));
            f8483b.add(new Pair<>("签名校验时长", new Pair("na_pms_start_check_sign", "na_pms_end_check_sign")));
            f8483b.add(new Pair<>("包解压时长", new Pair("na_package_start_unzip", "na_package_end_unzip")));
            f8483b.add(new Pair<>("包解密时长", new Pair("na_package_start_decrypt", "na_package_end_decrypt")));
            f8483b.add(new Pair<>("更新数据库时长", new Pair("na_start_update_db", "na_end_update_db")));
        }
    }

    public static void a(String str, String str2, List<UbcFlowEvent> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, list, str3) == null) || TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        c.a.p0.a.j2.a c2 = c.a.p0.a.j2.k.c("770");
        for (UbcFlowEvent ubcFlowEvent : list) {
            if (ubcFlowEvent != null) {
                b.e(c2, ubcFlowEvent.f46188a, ubcFlowEvent.j(), ubcFlowEvent.g());
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("from", "swan");
            jSONObject.put("type", str2);
            jSONObject2.put("appid", str);
            jSONObject2.put("mobile", m.c());
            jSONObject2.put("net", SwanAppNetworkUtils.f().type);
            if (TextUtils.isEmpty(str3)) {
                str3 = "0";
            }
            jSONObject2.put("scene", str3);
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b.f(c2, jSONObject.toString());
        b.c(c2);
        b(str, list, f8483b);
    }

    @SuppressLint({"SwanDebugLog", "LogConditional"})
    public static void b(String str, List<UbcFlowEvent> list, List<Pair<String, Pair<String, String>>> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, list, list2) == null) || !f8482a || list == null || list2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("小程序PMS下载耗时Log：");
        sb.append(StringUtils.LF);
        sb.append("小程序ID：");
        sb.append(str);
        sb.append(StringUtils.LF);
        sb.append("小程序ID：");
        sb.append(str);
        for (UbcFlowEvent ubcFlowEvent : list) {
            if (ubcFlowEvent != null) {
                sb.append(StringUtils.LF);
                sb.append(ubcFlowEvent.g());
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb.append(ubcFlowEvent.f46188a);
                hashMap.put(ubcFlowEvent.f46188a, Long.valueOf(ubcFlowEvent.g()));
            }
        }
        sb.append(StringUtils.LF);
        sb.append("耗时计算开始：>>>>>>>>>>>>");
        for (Pair<String, Pair<String, String>> pair : list2) {
            if (pair != null) {
                String str2 = (String) pair.first;
                Object obj = pair.second;
                String str3 = (String) ((Pair) obj).first;
                String str4 = (String) ((Pair) obj).second;
                if (hashMap.get(str3) != null && hashMap.get(str4) != null) {
                    long longValue = ((Long) hashMap.get(str3)).longValue();
                    String format = String.format(Locale.CHINA, "%-13d", Long.valueOf(((Long) hashMap.get(str4)).longValue() - longValue));
                    sb.append(StringUtils.LF);
                    sb.append("耗时：");
                    sb.append(format);
                    sb.append(" >>> ");
                    sb.append(str2);
                    sb.append("，计算方式：");
                    sb.append(str4);
                    sb.append(" - ");
                    sb.append(str3);
                }
            }
        }
        sb.toString();
    }
}
