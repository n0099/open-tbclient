package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bl;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CooperService implements ICooperService {
    public static /* synthetic */ Interceptable $ic;
    public static CooperService a;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadObject b;
    public boolean c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "4.0.9.7" : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getTagValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void setZid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
        }
    }

    public CooperService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HeadObject();
        this.c = true;
        this.d = "0";
        this.e = false;
        this.f = true;
        this.g = 1;
        this.h = 10;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!bu.a().d()) {
                return Config.DEF_MAC_ID;
            }
            String j = bw.j(context);
            if (TextUtils.isEmpty(j)) {
                return Config.DEF_MAC_ID;
            }
            return j.replaceAll(":", "");
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String i = bw.i(context);
            if (!TextUtils.isEmpty(i)) {
                return i.replaceAll(":", "");
            }
            return i;
        }
        return (String) invokeL.objValue;
    }

    public String getDevicImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            try {
                if (!bn.e(context, com.kuaishou.weapon.p0.h.c)) {
                    return "";
                }
                return ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
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
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            return a2;
        }
        return (String) invokeLZ.objValue;
    }

    public void enableDeviceMac(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) {
            bp.a().d(context, z);
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, jSONObject) == null) {
            this.b.installHeader(context, jSONObject);
        }
    }

    public void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048617, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.h = str;
    }

    public void setEnableBplus(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048620, this, context, z) == null) {
            bp.a().e(context, z);
        }
    }

    public void setLastUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, context, str) == null) {
            bp.a().j(context, str);
        }
    }

    private String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            String e = bp.a().e(context);
            if (TextUtils.isEmpty(e) || e.equals(Config.NULL_DEVICE_ID)) {
                String str = new Date().getTime() + "";
                String str2 = "hol" + str.hashCode() + "mes";
                bp.a().a(context, str2);
                return str2;
            }
            return e;
        }
        return (String) invokeL.objValue;
    }

    private String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
                if (this.b.l == null || this.b.l.equals("")) {
                    boolean g = bp.a().g(context);
                    if (g) {
                        this.b.l = bp.a().f(context);
                    }
                    if (!g || this.b.l == null || this.b.l.equals("")) {
                        this.b.l = bw.a(context, Config.CHANNEL_META_NAME);
                    }
                }
            } catch (Exception unused) {
            }
            return this.b.l;
        }
        return (String) invokeL.objValue;
    }

    public void deleteCacheImei(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            try {
                String t = bp.a().t(context);
                if (TextUtils.isEmpty(t)) {
                    return;
                }
                String str = new String(bl.b.b(2, bo.a(t.getBytes())));
                if (!TextUtils.isEmpty(str) && !str.contains("hol") && !str.contains("0200")) {
                    bp.a().l(context, "");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String getMacIdForTv(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            if (!TextUtils.isEmpty(this.b.r)) {
                return this.b.r;
            }
            String j = bp.a().j(context);
            if (!TextUtils.isEmpty(j)) {
                this.b.r = j;
                return j;
            }
            String i = bw.i(2, context);
            if (!TextUtils.isEmpty(i)) {
                this.b.r = i;
                bp.a().f(context, i);
                return this.b.r;
            }
            this.b.r = "";
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static synchronized CooperService instance() {
        InterceptResult invokeV;
        CooperService cooperService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (CooperService.class) {
                if (a == null) {
                    a = new CooperService();
                }
                cooperService = a;
            }
            return cooperService;
        }
        return (CooperService) invokeV.objValue;
    }

    public void closeTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = true;
        }
    }

    public int getCollectTitleMaxLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int getEvAutoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public HeadObject getHeadObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (HeadObject) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return Config.LOG_SEND_URL;
        }
        return (String) invokeV.objValue;
    }

    public String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (TextUtils.isEmpty(this.b.o)) {
                this.b.o = android.os.Build.MANUFACTURER;
            }
            return this.b.o;
        }
        return (String) invokeV.objValue;
    }

    public String getOSSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(this.b.c)) {
                this.b.c = Build.VERSION.RELEASE;
            }
            return this.b.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (TextUtils.isEmpty(this.b.b)) {
                this.b.b = Integer.toString(Build.VERSION.SDK_INT);
            }
            return this.b.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getPhoneModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (TextUtils.isEmpty(this.b.n)) {
                this.b.n = android.os.Build.MODEL;
            }
            return this.b.n;
        }
        return (String) invokeV.objValue;
    }

    public String getPlatformType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String getUUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return UUID.randomUUID().toString().replace("-", "");
        }
        return (String) invokeV.objValue;
    }

    public boolean isCloseTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableDownloadJs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnabledAutoEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void resetHeadSign() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.b.x = instance().getUUID();
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return "true".equalsIgnoreCase(bw.a(context, Config.GET_WIFI_LOCATION));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppChannel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return d(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            HeadObject headObject = this.b;
            if (headObject.e == null) {
                headObject.e = bw.a(context, Config.APPKEY_META_NAME);
            }
            return this.b.e;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            HeadObject headObject = this.b;
            if (headObject.g == -1) {
                headObject.g = bw.f(context);
            }
            return this.b.g;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (TextUtils.isEmpty(this.b.h)) {
                this.b.h = bw.g(context);
            }
            return this.b.h;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject getHeaderExt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            String k = bp.a().k(context);
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

    public String getLastUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) {
            return bp.a().r(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getLinkedWay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            if (TextUtils.isEmpty(this.b.p)) {
                this.b.p = bw.p(context);
            }
            return this.b.p;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, telephonyManager)) == null) {
            if (TextUtils.isEmpty(this.b.m)) {
                this.b.m = telephonyManager.getNetworkOperator();
            }
            return this.b.m;
        }
        return (String) invokeL.objValue;
    }

    public String getPlainDeviceIdForCar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, context)) == null) {
            String optUUID = CarUUID.optUUID(context);
            if (TextUtils.isEmpty(optUUID)) {
                optUUID = c(context);
            }
            if (TextUtils.isEmpty(optUUID)) {
                return "";
            }
            return optUUID;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject getPushId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) {
            String l = bp.a().l(context);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            return bl.b.c(2, str.getBytes());
        }
        return (String) invokeL.objValue;
    }

    public String getUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, context)) == null) {
            return bp.a().q(context);
        }
        return (String) invokeL.objValue;
    }

    public boolean isDeviceMacEnabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, context)) == null) {
            return bp.a().m(context);
        }
        return invokeL.booleanValue;
    }

    public boolean isEnableBplus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, context)) == null) {
            return bp.a().x(context);
        }
        return invokeL.booleanValue;
    }

    public void setCollectTitleMaxLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.g = i;
        }
    }

    public void setEnableAutoEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.c = z;
        }
    }

    public void setEnableDownloadJs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.f = z;
        }
    }

    public void setEvAutoSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.h = i;
        }
    }

    public void setHeaderPy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.b.setHeaderPy(str);
        }
    }

    public void setPlatformType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.d = i + "";
        }
    }

    public void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.b.setStartType(z);
        }
    }

    public boolean filterCuid(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, context, str, z)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "";
                String replace = str.replace(":", "");
                if (replace.equals(Config.DEF_MAC_ID.replace(":", ""))) {
                    if (TextUtils.isEmpty(this.b.f)) {
                        this.b.i = getSecretValue(c(context));
                        return true;
                    }
                    try {
                        str2 = new String(bl.b.b(2, bo.a(this.b.f.getBytes())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        this.b.i = getSecretValue(c(context));
                        z = true;
                    } else {
                        this.b.i = getSecretValue(replace);
                    }
                    return z;
                }
                this.b.i = getSecretValue(replace);
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, context, z)) == null) {
            bp.a().b(context, "");
            String str = this.b.f;
            if (str == null || "".equalsIgnoreCase(str)) {
                try {
                    this.b.f = bx.a(context);
                    this.b.f = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.f).replaceAll("");
                    this.b.f = getSecretValue(this.b.f);
                } catch (Exception unused) {
                }
            }
            if (z) {
                return this.b.f;
            }
            try {
                String str2 = this.b.f;
                if (!TextUtils.isEmpty(str2)) {
                    return new String(bl.b.b(2, bo.a(str2.getBytes())));
                }
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public String getPhoneAddress(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048601, this, context, z)) == null) {
            String replace = Config.DEF_MAC_ID.replace(":", "");
            if (!z && Build.VERSION.SDK_INT >= 23) {
                return getSecretValue(replace);
            }
            if (!TextUtils.isEmpty(this.b.q)) {
                return this.b.q;
            }
            String h = bp.a().h(context);
            if (!TextUtils.isEmpty(h)) {
                this.b.q = h;
                return h;
            }
            String a2 = a(context, z);
            if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
                this.b.q = getSecretValue(a2);
                bp.a().e(context, this.b.q);
                return this.b.q;
            }
            this.b.q = "";
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r4.length() > 30) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
        if (r4.length() > 30) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    @Override // com.baidu.mobstat.ICooperService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        InterceptResult invokeLL;
        String str;
        String str2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, telephonyManager, context)) == null) {
            if (!TextUtils.isEmpty(this.b.i)) {
                return this.b.i;
            }
            if (bp.a().i(context)) {
                this.b.i = getMacIdForTv(context);
                return this.b.i;
            }
            String t = bp.a().t(context);
            if (!TextUtils.isEmpty(t)) {
                try {
                    str2 = new String(bl.b.b(2, bo.a(t.getBytes())));
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    str2 = "";
                    z = false;
                }
                if (z) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (!str2.contains(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX)) {
                            if (!str2.contains("=")) {
                            }
                        }
                    }
                    t = "";
                    str2 = t;
                    if (!TextUtils.isEmpty(str2)) {
                        filterCuid(context, str2, true);
                        return this.b.i;
                    }
                } else {
                    try {
                        str2 = new String(bl.b.b(1, bo.a(t.getBytes())));
                        z2 = true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        z2 = false;
                    }
                    if (z2) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (!str2.contains(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX)) {
                                if (!str2.contains("=")) {
                                }
                            }
                        }
                        t = "";
                        str2 = t;
                        if (!TextUtils.isEmpty(str2)) {
                        }
                    } else {
                        this.b.i = t;
                        return t;
                    }
                }
            }
            if (telephonyManager != null && bu.a().d()) {
                Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
                try {
                    if (!bn.e(context, com.kuaishou.weapon.p0.h.c)) {
                        str = "";
                    } else {
                        str = ApiReplaceUtil.getDeviceId(telephonyManager);
                    }
                    if (str != null) {
                        t = compile.matcher(str).replaceAll("");
                    }
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(t) && !t.equals(Config.NULL_DEVICE_ID)) {
                this.b.i = getSecretValue(t);
                return this.b.i;
            } else if (filterCuid(context, a(context), false)) {
                return this.b.i;
            } else {
                return this.b.i;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, context, extraInfo) == null) {
            JSONObject jSONObject = new JSONObject();
            if (extraInfo != null) {
                jSONObject = extraInfo.dumpToJson();
            }
            this.b.setHeaderExt(jSONObject);
            bp.a().g(context, jSONObject.toString());
            if (extraInfo != null) {
                str = "Set global ExtraInfo: " + jSONObject;
            } else {
                str = "Clear global ExtraInfo";
            }
            bb.c().a(str);
        }
    }

    public void setUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            bp.a().i(context, str);
            this.b.setUserId(str);
            bb.c().a("Set user id " + str);
        }
    }

    public void setPushId(Context context, String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048627, this, context, str, str2, str3) == null) {
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
            this.b.setPushInfo(pushId);
            bp.a().h(context, pushId.toString());
            if (str3 != null) {
                str4 = "Set platform:" + str2 + " pushId: " + str3;
            } else {
                str4 = "Clear platform:" + str2 + " pushId";
            }
            bb.c().a(str4);
        }
    }

    public void setUserProperty(Context context, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, context, map) == null) {
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            try {
            } catch (Exception e) {
                bb c = bb.c();
                c.c("[Exception] " + e.getMessage());
                e.printStackTrace();
            }
            if (map == null) {
                bp.a().m(context, "");
                this.b.setUserProperty("");
            } else if (map.size() > 100) {
                bb.c().c("[WARNING] setUserProperty failed,map size can not over 100 !");
            } else {
                boolean z2 = true;
                for (Map.Entry entry : map.entrySet()) {
                    JSONArray jSONArray = new JSONArray();
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str) && str2 != null) {
                        if (str.length() <= 256 && (TextUtils.isEmpty(str2) || str2.length() <= 256)) {
                            jSONArray.put(str2);
                            jSONArray.put("1");
                            jSONObject.put(str, jSONArray);
                        }
                        bb.c().c("[WARNING] setUserProperty failed,key or value can not over 256 bytes !");
                        z2 = false;
                    }
                    bb.c().c("[WARNING] setUserProperty failed,key or value can not null !");
                    z2 = false;
                }
                z = z2;
                if (z) {
                    bp.a().m(context, jSONObject.toString());
                    this.b.setUserProperty(jSONObject.toString());
                }
            }
        }
    }
}
