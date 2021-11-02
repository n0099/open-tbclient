package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class CooperService implements ICooperService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CooperService f41436a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41437c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadObject f41438b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2140558665, "Lcom/baidu/mobstat/dxmpay/CooperService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2140558665, "Lcom/baidu/mobstat/dxmpay/CooperService;");
        }
    }

    public CooperService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41438b = new HeadObject();
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            try {
                if (this.f41438b.m == null || this.f41438b.m.equals("")) {
                    boolean f2 = q.a().f(context);
                    if (f2) {
                        this.f41438b.m = q.a().e(context);
                    }
                    if (!f2 || this.f41438b.m == null || this.f41438b.m.equals("")) {
                        this.f41438b.m = w.a(context, "BaiduMobAd_CHANNEL");
                    }
                }
            } catch (Exception unused) {
            }
            return this.f41438b.m;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized CooperService instance() {
        InterceptResult invokeV;
        CooperService cooperService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (CooperService.class) {
                if (f41436a == null) {
                    f41436a = new CooperService();
                }
                cooperService = f41436a;
            }
            return cooperService;
        }
        return (CooperService) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public boolean checkCellLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? "true".equalsIgnoreCase(w.a(context, "BaiduMobAd_CELL_LOCATION")) : invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public boolean checkGPSLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? "true".equals(w.a(context, "BaiduMobAd_GPS_LOCATION")) : invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? "true".equalsIgnoreCase(w.a(context, "BaiduMobAd_WIFI_LOCATION")) : invokeL.booleanValue;
    }

    public void enableDeviceMac(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) {
            q.a().d(context, z);
        }
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getAppChannel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? a(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            HeadObject headObject = this.f41438b;
            if (headObject.f41471f == null) {
                headObject.f41471f = w.a(context, "BaiduMobAd_STAT_ID");
            }
            return this.f41438b.f41471f;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            HeadObject headObject = this.f41438b;
            if (headObject.f41473h == -1) {
                headObject.f41473h = w.f(context);
            }
            return this.f41438b.f41473h;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (TextUtils.isEmpty(this.f41438b.f41474i)) {
                this.f41438b.f41474i = w.g(context);
            }
            return this.f41438b.f41474i;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getCUID(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z)) == null) {
            q.a().b(context, "");
            String str = this.f41438b.f41472g;
            if (str == null || "".equalsIgnoreCase(str)) {
                try {
                    this.f41438b.f41472g = x.a(context);
                    this.f41438b.f41472g = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f41438b.f41472g).replaceAll("");
                    this.f41438b.f41472g = getSecretValue(this.f41438b.f41472g);
                } catch (Exception unused) {
                }
            }
            if (z) {
                return this.f41438b.f41472g;
            }
            try {
                String str2 = this.f41438b.f41472g;
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                return new String(m.b.b(2, p.a(str2.getBytes())));
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public String getDevicImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, telephonyManager, context)) == null) {
            if (!TextUtils.isEmpty(this.f41438b.j)) {
                return this.f41438b.j;
            }
            if (q.a().g(context)) {
                this.f41438b.j = getMacIdForTv(context);
                return this.f41438b.j;
            }
            this.f41438b.j = "02:00:00:00:00:00".replace(":", "");
            HeadObject headObject = this.f41438b;
            headObject.j = getSecretValue(headObject.j);
            return this.f41438b.j;
        }
        return (String) invokeLL.objValue;
    }

    public HeadObject getHeadObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f41438b : (HeadObject) invokeV.objValue;
    }

    public JSONObject getHeaderExt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            String i2 = q.a().i(context);
            if (!TextUtils.isEmpty(i2)) {
                try {
                    return new JSONObject(i2);
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? Config.LOG_SEND_URL : (String) invokeV.objValue;
    }

    public String getLastUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) ? q.a().m(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getLinkedWay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            if (TextUtils.isEmpty(this.f41438b.s)) {
                this.f41438b.s = w.i(context);
            }
            return this.f41438b.s;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getMTJSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "4.0.0.0" : (String) invokeV.objValue;
    }

    public String getMacAddress(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, context, z)) == null) ? "" : (String) invokeLZ.objValue;
    }

    public String getMacIdForTv(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            if (f41437c) {
                if (!TextUtils.isEmpty(this.f41438b.u)) {
                    return this.f41438b.u;
                }
                String h2 = q.a().h(context);
                if (!TextUtils.isEmpty(h2)) {
                    this.f41438b.u = h2;
                    return h2;
                }
                String h3 = w.h(2, context);
                if (!TextUtils.isEmpty(h3)) {
                    this.f41438b.u = h3;
                    q.a().d(context, h3);
                    return this.f41438b.u;
                }
                this.f41438b.u = "";
                return "";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TextUtils.isEmpty(this.f41438b.p)) {
                this.f41438b.p = android.os.Build.MANUFACTURER;
            }
            return this.f41438b.p;
        }
        return (String) invokeV.objValue;
    }

    public String getOSSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.f41438b.f41469d)) {
                this.f41438b.f41469d = Build.VERSION.RELEASE;
            }
            return this.f41438b.f41469d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (TextUtils.isEmpty(this.f41438b.f41468c)) {
                this.f41438b.f41468c = Integer.toString(Build.VERSION.SDK_INT);
            }
            return this.f41438b.f41468c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, telephonyManager)) == null) {
            if (TextUtils.isEmpty(this.f41438b.n)) {
                this.f41438b.n = telephonyManager.getNetworkOperator();
            }
            return this.f41438b.n;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getPhoneModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (TextUtils.isEmpty(this.f41438b.o)) {
                this.f41438b.o = android.os.Build.MODEL;
            }
            return this.f41438b.o;
        }
        return (String) invokeV.objValue;
    }

    public String getPlainDeviceIdForCar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public JSONObject getPushId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) {
            String j = q.a().j(context);
            if (!TextUtils.isEmpty(j)) {
                try {
                    return new JSONObject(j);
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getSecretValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? m.b.c(2, str.getBytes()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public int getTagValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UUID.randomUUID().toString().replace("-", "") : (String) invokeV.objValue;
    }

    public String getUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) ? q.a().l(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, jSONObject) == null) {
            this.f41438b.installHeader(context, jSONObject);
        }
    }

    public boolean isDeviceMacEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, context)) == null) {
            q.a().k(context);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void resetHeadSign() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f41438b.A = instance().getUUID();
        }
    }

    public void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f41438b.f41474i = str;
    }

    public void setAuthorizedState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            f41437c = z;
            this.f41438b.setAuthorizedState(z);
        }
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, extraInfo) == null) {
            JSONObject jSONObject = new JSONObject();
            if (extraInfo != null) {
                jSONObject = extraInfo.dumpToJson();
            }
            this.f41438b.setHeaderExt(jSONObject);
            q.a().e(context, jSONObject.toString());
            if (extraInfo != null) {
                str = "Set global ExtraInfo: " + jSONObject;
            } else {
                str = "Clear global ExtraInfo";
            }
            h.c().a(str);
        }
    }

    public void setLastUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, str) == null) {
            q.a().h(context, str);
        }
    }

    public void setPushId(Context context, String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048613, this, context, str, str2, str3) == null) {
            JSONObject pushId = getPushId(context);
            if (pushId == null) {
                pushId = new JSONObject();
            }
            try {
                if (!TextUtils.isEmpty(str3)) {
                    pushId.put(str, str3);
                } else {
                    pushId.remove(str);
                }
            } catch (Exception unused) {
            }
            this.f41438b.setPushInfo(pushId);
            q.a().f(context, pushId.toString());
            if (str3 != null) {
                str4 = "Set platform:" + str2 + " pushId: " + str3;
            } else {
                str4 = "Clear platform:" + str2 + " pushId";
            }
            h.c().a(str4);
        }
    }

    public void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f41438b.setStartType(z);
        }
    }

    public void setUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            q.a().g(context, str);
            this.f41438b.setUserId(str);
            h.c().a("Set user id " + str);
        }
    }

    public void setUserProperty(Context context, Map<String, String> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, context, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
            } catch (Exception e2) {
                h c2 = h.c();
                c2.c("[Exception] " + e2.getMessage());
                e2.printStackTrace();
                z = false;
            }
            if (map == null) {
                q.a().j(context, "");
                this.f41438b.setUserProperty("");
            } else if (map.size() > 100) {
                h.c().c("[WARNING] setUserProperty failed,map size can not over 100 !");
            } else {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    JSONArray jSONArray = new JSONArray();
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        if (key.length() <= 256 && (TextUtils.isEmpty(value) || value.length() <= 256)) {
                            jSONArray.put(value);
                            jSONArray.put("1");
                            jSONObject.put(key, jSONArray);
                        }
                        h.c().c("[WARNING] setUserProperty failed,key or value can not over 256 bytes !");
                        return;
                    }
                    h.c().c("[WARNING] setUserProperty failed,key or value can not null !");
                    return;
                }
                z = true;
                if (z) {
                    q.a().j(context, jSONObject.toString());
                    this.f41438b.setUserProperty(jSONObject.toString());
                }
            }
        }
    }

    public void setZid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
        }
    }
}
