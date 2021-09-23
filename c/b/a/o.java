package c.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IAppParam;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f31405a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f31406b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868020961, "Lc/b/a/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868020961, "Lc/b/a/o;");
                return;
            }
        }
        f31405a = new String[]{"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", AsInstallService.SCHEME_PACKAGE_ADDED, "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
        f31406b = new String[]{"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", "version_name", HttpConstants.DEVICE_TYPE, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    }

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, IAppParam iAppParam) {
        InterceptResult invokeCommon;
        HashMap<String, String> appSSIDs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, jSONObject, str, Boolean.valueOf(z), iAppParam})) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            HashMap hashMap = new HashMap(f31405a.length + 10);
            int i2 = 0;
            while (true) {
                String[] strArr = f31405a;
                if (i2 >= strArr.length) {
                    break;
                }
                String optString = jSONObject.optString(strArr[i2], null);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(f31406b[i2], optString);
                }
                i2++;
            }
            if (iAppParam != null) {
                try {
                    appSSIDs = iAppParam.getAppSSIDs(context);
                } catch (Exception e2) {
                    h0.b(e2);
                }
            } else {
                appSSIDs = null;
            }
            if (i0.i(context) && appSSIDs != null) {
                hashMap.putAll(appSSIDs);
            }
            try {
                HashMap<String, String> extraParams = AppLog.getExtraParams() == null ? null : AppLog.getExtraParams().getExtraParams();
                if (extraParams != null) {
                    hashMap.putAll(extraParams);
                }
            } catch (Exception e3) {
                h0.b(e3);
            }
            if (AppLog.sCustomNetParams.size() > 0) {
                hashMap.putAll(AppLog.sCustomNetParams);
            }
            if (z) {
                hashMap.put("ssmix", "a");
            }
            String b2 = e0.b(context);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("ac", b2);
            }
            String str2 = (String) AppLog.getHeaderValue("tweaked_channel", "");
            if (TextUtils.isEmpty(str2)) {
                str2 = (String) AppLog.getHeaderValue("channel", "");
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("channel", str2);
            }
            String optString2 = jSONObject.optString(HttpConstants.OS_VERSION, null);
            if (optString2 != null && optString2.length() > 10) {
                optString2 = optString2.substring(0, 10);
            }
            hashMap.put(HttpConstants.OS_VERSION, optString2);
            hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
            hashMap.put("device_platform", "android");
            int intValue = ((Integer) AppLog.getHeaderValue("version_code", -1)).intValue();
            if (intValue != -1) {
                hashMap.put("version_code", String.valueOf(intValue));
            }
            int intValue2 = ((Integer) AppLog.getHeaderValue("manifest_version_code", -1)).intValue();
            if (intValue2 != -1) {
                hashMap.put("manifest_version_code", String.valueOf(intValue2));
            }
            int intValue3 = ((Integer) AppLog.getHeaderValue("update_version_code", -1)).intValue();
            if (intValue3 != -1) {
                hashMap.put("update_version_code", String.valueOf(intValue3));
            }
            String b3 = n0.b(jSONObject.optJSONObject("oaid"));
            if (!TextUtils.isEmpty(b3)) {
                hashMap.put("oaid", b3);
            }
            String optString3 = jSONObject.optString("cdid");
            if (!TextUtils.isEmpty(optString3)) {
                hashMap.put("cdid", optString3);
            }
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.indexOf(63) >= 0 ? Typography.amp : '?');
            return i0.d(sb.toString(), hashMap, "UTF-8");
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] b(j1 j1Var, Context context, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, j1Var, context, jSONObject)) == null) {
            String[] sendUris = j1Var.n().getSendUris();
            String[] strArr = new String[sendUris.length];
            String str = AppLog.getEncryptAndCompress() ? "?tt_data=a" : "?";
            for (int i2 = 0; i2 < sendUris.length; i2++) {
                strArr[i2] = a(context, jSONObject, sendUris[i2] + str, true, AppLog.getIAppParam());
                strArr[i2] = n.d(strArr[i2], n.f31398d);
            }
            return strArr;
        }
        return (String[]) invokeLLL.objValue;
    }
}
