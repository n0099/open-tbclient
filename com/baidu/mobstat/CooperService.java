package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.bm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CooperService implements ICooperService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CooperService f42939a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HeadObject f42940b;

    public CooperService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42940b = new HeadObject();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String l = bw.l(context);
            return !TextUtils.isEmpty(l) ? l.replaceAll(":", "") : l;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String k = bw.k(context);
            return !TextUtils.isEmpty(k) ? k.replaceAll(":", "") : k;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String n = bw.n(context);
            return !TextUtils.isEmpty(n) ? n.replaceAll(":", "") : n;
        }
        return (String) invokeL.objValue;
    }

    private String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            String e2 = bq.a().e(context);
            if (TextUtils.isEmpty(e2) || e2.equals("000000000000000")) {
                String str = new Date().getTime() + "";
                String str2 = "hol" + str.hashCode() + "mes";
                bq.a().a(context, str2);
                return str2;
            }
            return e2;
        }
        return (String) invokeL.objValue;
    }

    private String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            try {
                if (this.f42940b.l == null || this.f42940b.l.equals("")) {
                    boolean g2 = bq.a().g(context);
                    if (g2) {
                        this.f42940b.l = bq.a().f(context);
                    }
                    if (!g2 || this.f42940b.l == null || this.f42940b.l.equals("")) {
                        this.f42940b.l = bw.a(context, "BaiduMobAd_CHANNEL");
                    }
                }
            } catch (Exception unused) {
            }
            return this.f42940b.l;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized CooperService instance() {
        InterceptResult invokeV;
        CooperService cooperService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (CooperService.class) {
                if (f42939a == null) {
                    f42939a = new CooperService();
                }
                cooperService = f42939a;
            }
            return cooperService;
        }
        return (CooperService) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkCellLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? "true".equalsIgnoreCase(bw.a(context, "BaiduMobAd_CELL_LOCATION")) : invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkGPSLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? "true".equals(bw.a(context, "BaiduMobAd_GPS_LOCATION")) : invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? "true".equalsIgnoreCase(bw.a(context, "BaiduMobAd_WIFI_LOCATION")) : invokeL.booleanValue;
    }

    public void enableDeviceMac(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) {
            bq.a().d(context, z);
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppChannel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? e(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            HeadObject headObject = this.f42940b;
            if (headObject.f42975e == null) {
                headObject.f42975e = bw.a(context, "BaiduMobAd_STAT_ID");
            }
            return this.f42940b.f42975e;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            HeadObject headObject = this.f42940b;
            if (headObject.f42977g == -1) {
                headObject.f42977g = bw.f(context);
            }
            return this.f42940b.f42977g;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (TextUtils.isEmpty(this.f42940b.f42978h)) {
                this.f42940b.f42978h = bw.g(context);
            }
            return this.f42940b.f42978h;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z)) == null) {
            bq.a().b(context, "");
            String str = this.f42940b.f42976f;
            if (str == null || "".equalsIgnoreCase(str)) {
                try {
                    this.f42940b.f42976f = bx.a(context);
                    this.f42940b.f42976f = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f42940b.f42976f).replaceAll("");
                    this.f42940b.f42976f = getSecretValue(this.f42940b.f42976f);
                } catch (Exception unused) {
                }
            }
            if (z) {
                return this.f42940b.f42976f;
            }
            try {
                String str2 = this.f42940b.f42976f;
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                return new String(bm.b.b(1, bp.a(str2.getBytes())));
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public String getDevicImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, telephonyManager, context)) == null) {
            if (!TextUtils.isEmpty(this.f42940b.f42979i)) {
                return this.f42940b.f42979i;
            }
            if (bq.a().i(context)) {
                this.f42940b.f42979i = getMacIdForTv(context);
                return this.f42940b.f42979i;
            }
            String s = bq.a().s(context);
            if (!TextUtils.isEmpty(s)) {
                this.f42940b.f42979i = s;
                return s;
            } else if (telephonyManager == null) {
                return this.f42940b.f42979i;
            } else {
                Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
                try {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        s = compile.matcher(deviceId).replaceAll("");
                    }
                } catch (Exception unused) {
                }
                if (s == null || s.equals("000000000000000")) {
                    s = a(context);
                }
                if (bw.w(context) && (TextUtils.isEmpty(s) || s.equals("000000000000000"))) {
                    try {
                        s = c(context);
                    } catch (Exception unused2) {
                    }
                }
                if (TextUtils.isEmpty(s) || s.equals("000000000000000")) {
                    s = d(context);
                }
                HeadObject headObject = this.f42940b;
                headObject.f42979i = s;
                headObject.f42979i = getSecretValue(s);
                return this.f42940b.f42979i;
            }
        }
        return (String) invokeLL.objValue;
    }

    public HeadObject getHeadObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f42940b : (HeadObject) invokeV.objValue;
    }

    public JSONObject getHeaderExt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            String k = bq.a().k(context);
            if (!TextUtils.isEmpty(k)) {
                try {
                    return new JSONObject(k);
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? Config.LOG_SEND_URL : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getLinkedWay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            if (TextUtils.isEmpty(this.f42940b.r)) {
                this.f42940b.r = bw.r(context);
            }
            return this.f42940b.r;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "3.9.5.1" : (String) invokeV.objValue;
    }

    public String getMacAddress(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, context, z)) == null) {
            String replace = "02:00:00:00:00:00".replace(":", "");
            if (!z && Build.VERSION.SDK_INT >= 23) {
                return getSecretValue(replace);
            }
            if (!TextUtils.isEmpty(this.f42940b.s)) {
                return this.f42940b.s;
            }
            String h2 = bq.a().h(context);
            if (!TextUtils.isEmpty(h2)) {
                this.f42940b.s = h2;
                return h2;
            }
            String a2 = a(context, z);
            if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
                this.f42940b.s = getSecretValue(a2);
                bq.a().e(context, this.f42940b.s);
                return this.f42940b.s;
            }
            this.f42940b.s = "";
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public String getMacIdForTv(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) {
            if (!TextUtils.isEmpty(this.f42940b.t)) {
                return this.f42940b.t;
            }
            String j2 = bq.a().j(context);
            if (!TextUtils.isEmpty(j2)) {
                this.f42940b.t = j2;
                return j2;
            }
            String c2 = bw.c(1, context);
            if (!TextUtils.isEmpty(c2)) {
                this.f42940b.t = c2;
                bq.a().f(context, c2);
                return this.f42940b.t;
            }
            this.f42940b.t = "";
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (TextUtils.isEmpty(this.f42940b.o)) {
                this.f42940b.o = android.os.Build.MANUFACTURER;
            }
            return this.f42940b.o;
        }
        return (String) invokeV.objValue;
    }

    public String getOSSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TextUtils.isEmpty(this.f42940b.f42973c)) {
                this.f42940b.f42973c = Build.VERSION.RELEASE;
            }
            return this.f42940b.f42973c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.f42940b.f42972b)) {
                this.f42940b.f42972b = Integer.toString(Build.VERSION.SDK_INT);
            }
            return this.f42940b.f42972b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, telephonyManager)) == null) {
            if (TextUtils.isEmpty(this.f42940b.m)) {
                this.f42940b.m = telephonyManager.getNetworkOperator();
            }
            return this.f42940b.m;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getPhoneModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(this.f42940b.n)) {
                this.f42940b.n = android.os.Build.MODEL;
            }
            return this.f42940b.n;
        }
        return (String) invokeV.objValue;
    }

    public String getPlainDeviceIdForCar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) {
            String optUUID = CarUUID.optUUID(context);
            if (TextUtils.isEmpty(optUUID)) {
                optUUID = d(context);
            }
            return TextUtils.isEmpty(optUUID) ? "" : optUUID;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject getPushId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) {
            String l = bq.a().l(context);
            if (!TextUtils.isEmpty(l)) {
                try {
                    return new JSONObject(l);
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getSecretValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? bm.b.c(1, str.getBytes()) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getTagValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? UUID.randomUUID().toString().replace("-", "") : (String) invokeV.objValue;
    }

    public String getUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, context)) == null) ? bq.a().q(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, jSONObject) == null) {
            this.f42940b.installHeader(context, jSONObject);
        }
    }

    public boolean isDeviceMacEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) ? bq.a().m(context) : invokeL.booleanValue;
    }

    public void resetHeadSign() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f42940b.z = instance().getUUID();
        }
    }

    public void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f42940b.f42978h = str;
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, extraInfo) == null) {
            JSONObject jSONObject = new JSONObject();
            if (extraInfo != null) {
                jSONObject = extraInfo.dumpToJson();
            }
            this.f42940b.setHeaderExt(jSONObject);
            bq.a().g(context, jSONObject.toString());
            if (extraInfo != null) {
                str = "Set global ExtraInfo: " + jSONObject;
            } else {
                str = "Clear global ExtraInfo";
            }
            bc.c().a(str);
        }
    }

    public void setPushId(Context context, String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, context, str, str2, str3) == null) {
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
            this.f42940b.setPushInfo(pushId);
            bq.a().h(context, pushId.toString());
            if (str3 != null) {
                str4 = "Set platform:" + str2 + " pushId: " + str3;
            } else {
                str4 = "Clear platform:" + str2 + " pushId";
            }
            bc.c().a(str4);
        }
    }

    public void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f42940b.setStartType(z);
        }
    }

    public void setUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            bq.a().i(context, str);
            this.f42940b.setUserId(str);
            bc.c().a("Set user id " + str);
        }
    }

    private String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, context, z)) == null) {
            if (z) {
                a2 = b(context);
            } else {
                a2 = a(context);
            }
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        return (String) invokeLZ.objValue;
    }
}
