package c.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.InitConfig;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f31237a;

    /* renamed from: b  reason: collision with root package name */
    public final InitConfig f31238b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f31239c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedPreferences f31240d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f31241e;

    /* renamed from: f  reason: collision with root package name */
    public volatile JSONObject f31242f;

    /* renamed from: g  reason: collision with root package name */
    public volatile JSONObject f31243g;

    public y1(Context context, InitConfig initConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, initConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31237a = context;
        this.f31238b = initConfig;
        this.f31241e = context.getSharedPreferences("embed_applog_stats", 0);
        this.f31239c = this.f31237a.getSharedPreferences("embed_header_custom", 0);
        this.f31240d = this.f31237a.getSharedPreferences("embed_last_sp_session", 0);
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31240d.getInt("session_order", 0) : invokeV.intValue;
    }

    public JSONObject B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? V().optJSONObject(str) : (JSONObject) invokeL.objValue;
    }

    public void C(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            h0.a("setAbConfig, " + jSONObject.toString(), null);
            this.f31239c.edit().putString("ab_configure", jSONObject.toString()).apply();
            this.f31242f = null;
        }
    }

    public SharedPreferences D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31241e : (SharedPreferences) invokeV.objValue;
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f31241e.edit().putString(com.alipay.sdk.cons.b.f35719b, str).apply();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f31239c.edit().putString("ab_version", str).apply();
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31238b.isPlayEnable() : invokeV.booleanValue;
    }

    public JSONObject H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31243g : (JSONObject) invokeV.objValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31241e.getLong("app_log_last_config_time", 0L) : invokeV.longValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31241e.getInt("bav_monitor_rate", 0) : invokeV.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31238b.getAid() : (String) invokeV.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31238b.getChannel() : (String) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f31238b.getGoogleAid() : (String) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31238b.getLanguage() : (String) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f31238b.getRegion() : (String) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f31239c.getString("header_custom_info", null) : (String) invokeV.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f31239c.getString("ab_sdk_version", "") : (String) invokeV.objValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f31239c.getString("user_unique_id", null) : (String) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f31238b.getProcess() == 0) {
                this.f31238b.setProcess(!i0.b(this.f31237a).contains(":"));
            }
            return this.f31238b.getProcess() == 1;
        }
        return invokeV.booleanValue;
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f31241e.getLong("abtest_fetch_interval", 0L) : invokeV.longValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (!TextUtils.isEmpty(this.f31238b.getAbVersion())) {
                return this.f31238b.getAbVersion();
            }
            return this.f31239c.getString("ab_version", null);
        }
        return (String) invokeV.objValue;
    }

    public JSONObject V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            JSONObject jSONObject = this.f31242f;
            if (jSONObject == null) {
                synchronized (this) {
                    try {
                        if (W()) {
                            jSONObject = new JSONObject(this.f31239c.getString("ab_configure", ""));
                        }
                    } catch (JSONException unused) {
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    this.f31242f = jSONObject;
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f31241e.getBoolean("bav_ab_config", false) : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f31241e.getBoolean("bav_log_collect", false) : invokeV.booleanValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f31241e.getLong("session_interval", 30000L) : invokeV.longValue;
    }

    public long Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f31241e.getLong("batch_event_interval", 30000L) : invokeV.longValue;
    }

    @Nullable
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f31241e.getString(com.alipay.sdk.cons.b.f35719b, null) : (String) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return 10000L;
        }
        return invokeV.longValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f31238b.getReleaseBuild() : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f31238b.getAppName() : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f31238b.getVersionCode() : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f31238b.getUpdateVersionCode() : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f31238b.getManifestVersionCode() : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f31238b.getVersion() : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f31238b.getTweakedChannel() : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f31238b.getAbClient() : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f31238b.getAbGroup() : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f31238b.getAbFeature() : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f31238b.getVersionMinor() : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f31238b.getAppImei() == null ? "" : this.f31238b.getAppImei() : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f31238b.isImeiEnable() : invokeV.booleanValue;
    }

    public InitConfig o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f31238b : (InitConfig) invokeV.objValue;
    }

    public CharSequence p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f31238b.getZiJieCloudPkg() : (CharSequence) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f31238b.getAliyunUdid() : (String) invokeV.objValue;
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j2) == null) {
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.f31239c.edit().putString("ab_sdk_version", str).apply();
        }
    }

    public void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, str, i2) == null) {
            this.f31240d.edit().putString("session_last_day", str).putInt("session_order", i2).apply();
        }
    }

    public void u(HashSet<String> hashSet, HashSet<String> hashSet2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, hashSet, hashSet2) == null) {
        }
    }

    public void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jSONObject) == null) {
            if (h0.f31132b) {
                h0.a("setConfig, " + jSONObject.toString(), null);
            }
            this.f31243g = jSONObject;
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor edit = this.f31241e.edit();
            long optInt = jSONObject.optInt("session_interval", 0);
            if (optInt > 0 && optInt <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
                edit.putLong("session_interval", optInt * 1000);
            } else {
                edit.remove("session_interval");
            }
            long optInt2 = jSONObject.optInt("batch_event_interval", 0);
            if (optInt2 > 0 && optInt2 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
                edit.putLong("batch_event_interval", optInt2 * 1000);
            } else {
                edit.remove("batch_event_interval");
            }
            int optInt3 = jSONObject.optInt("send_launch_timely", 0);
            if (optInt3 > 0 && optInt3 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
                edit.putInt("send_launch_timely", optInt3);
            } else {
                edit.remove("send_launch_timely");
            }
            long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
            if (optInt4 > 20 && optInt4 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
                edit.putLong("abtest_fetch_interval", optInt4 * 1000);
            } else {
                edit.remove("abtest_fetch_interval");
            }
            boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
            if (optBoolean) {
                edit.putBoolean("bav_log_collect", true);
            } else {
                edit.remove("bav_log_collect");
            }
            h0.f31131a = optBoolean;
            if (jSONObject.optBoolean("bav_ab_config", false)) {
                edit.putBoolean("bav_ab_config", true);
            } else {
                edit.remove("bav_ab_config");
            }
            int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
            if (optInt5 > 0 && optInt5 <= 100) {
                edit.putInt("bav_monitor_rate", optInt5);
                g0.b(true);
            } else {
                edit.remove("bav_monitor_rate");
                g0.b(false);
            }
            edit.putLong("app_log_last_config_time", currentTimeMillis);
            edit.apply();
        }
    }

    public boolean w(ArrayList<p> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f31240d.getString("session_last_day", "") : (String) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.f31239c.edit().putString("user_unique_id", str).apply();
        }
    }

    public void z(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, jSONObject) == null) {
            this.f31239c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }
}
