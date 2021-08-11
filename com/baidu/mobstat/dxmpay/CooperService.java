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
/* loaded from: classes5.dex */
public class CooperService implements ICooperService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CooperService f43457a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43458c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadObject f43459b;

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
        this.f43459b = new HeadObject();
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            try {
                if (this.f43459b.m == null || this.f43459b.m.equals("")) {
                    boolean f2 = q.a().f(context);
                    if (f2) {
                        this.f43459b.m = q.a().e(context);
                    }
                    if (!f2 || this.f43459b.m == null || this.f43459b.m.equals("")) {
                        this.f43459b.m = w.a(context, "BaiduMobAd_CHANNEL");
                    }
                }
            } catch (Exception unused) {
            }
            return this.f43459b.m;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized CooperService instance() {
        InterceptResult invokeV;
        CooperService cooperService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (CooperService.class) {
                if (f43457a == null) {
                    f43457a = new CooperService();
                }
                cooperService = f43457a;
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
            HeadObject headObject = this.f43459b;
            if (headObject.f43494f == null) {
                headObject.f43494f = w.a(context, "BaiduMobAd_STAT_ID");
            }
            return this.f43459b.f43494f;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            HeadObject headObject = this.f43459b;
            if (headObject.f43496h == -1) {
                headObject.f43496h = w.f(context);
            }
            return this.f43459b.f43496h;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (TextUtils.isEmpty(this.f43459b.f43497i)) {
                this.f43459b.f43497i = w.g(context);
            }
            return this.f43459b.f43497i;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getCUID(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z)) == null) {
            q.a().b(context, "");
            String str = this.f43459b.f43495g;
            if (str == null || "".equalsIgnoreCase(str)) {
                try {
                    this.f43459b.f43495g = x.a(context);
                    this.f43459b.f43495g = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f43459b.f43495g).replaceAll("");
                    this.f43459b.f43495g = getSecretValue(this.f43459b.f43495g);
                } catch (Exception unused) {
                }
            }
            if (z) {
                return this.f43459b.f43495g;
            }
            try {
                String str2 = this.f43459b.f43495g;
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
            if (!TextUtils.isEmpty(this.f43459b.f43498j)) {
                return this.f43459b.f43498j;
            }
            if (q.a().g(context)) {
                this.f43459b.f43498j = getMacIdForTv(context);
                return this.f43459b.f43498j;
            }
            this.f43459b.f43498j = "02:00:00:00:00:00".replace(":", "");
            HeadObject headObject = this.f43459b;
            headObject.f43498j = getSecretValue(headObject.f43498j);
            return this.f43459b.f43498j;
        }
        return (String) invokeLL.objValue;
    }

    public HeadObject getHeadObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f43459b : (HeadObject) invokeV.objValue;
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
            if (TextUtils.isEmpty(this.f43459b.s)) {
                this.f43459b.s = w.i(context);
            }
            return this.f43459b.s;
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
            if (f43458c) {
                if (!TextUtils.isEmpty(this.f43459b.u)) {
                    return this.f43459b.u;
                }
                String h2 = q.a().h(context);
                if (!TextUtils.isEmpty(h2)) {
                    this.f43459b.u = h2;
                    return h2;
                }
                String h3 = w.h(2, context);
                if (!TextUtils.isEmpty(h3)) {
                    this.f43459b.u = h3;
                    q.a().d(context, h3);
                    return this.f43459b.u;
                }
                this.f43459b.u = "";
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
            if (TextUtils.isEmpty(this.f43459b.p)) {
                this.f43459b.p = android.os.Build.MANUFACTURER;
            }
            return this.f43459b.p;
        }
        return (String) invokeV.objValue;
    }

    public String getOSSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.f43459b.f43492d)) {
                this.f43459b.f43492d = Build.VERSION.RELEASE;
            }
            return this.f43459b.f43492d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (TextUtils.isEmpty(this.f43459b.f43491c)) {
                this.f43459b.f43491c = Integer.toString(Build.VERSION.SDK_INT);
            }
            return this.f43459b.f43491c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, telephonyManager)) == null) {
            if (TextUtils.isEmpty(this.f43459b.n)) {
                this.f43459b.n = telephonyManager.getNetworkOperator();
            }
            return this.f43459b.n;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.dxmpay.ICooperService
    public String getPhoneModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (TextUtils.isEmpty(this.f43459b.o)) {
                this.f43459b.o = android.os.Build.MODEL;
            }
            return this.f43459b.o;
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
            String j2 = q.a().j(context);
            if (!TextUtils.isEmpty(j2)) {
                try {
                    return new JSONObject(j2);
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
            this.f43459b.installHeader(context, jSONObject);
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
            this.f43459b.A = instance().getUUID();
        }
    }

    public void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f43459b.f43497i = str;
    }

    public void setAuthorizedState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            f43458c = z;
            this.f43459b.setAuthorizedState(z);
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
            this.f43459b.setHeaderExt(jSONObject);
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
            this.f43459b.setPushInfo(pushId);
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
            this.f43459b.setStartType(z);
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
            this.f43459b.setUserId(str);
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
                this.f43459b.setUserProperty("");
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
                    this.f43459b.setUserProperty(jSONObject.toString());
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
