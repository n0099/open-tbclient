package c.a.r0.j3.k0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.q0.r.j0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f18509f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18510b;

    /* renamed from: c  reason: collision with root package name */
    public long f18511c;

    /* renamed from: d  reason: collision with root package name */
    public String f18512d;

    /* renamed from: e  reason: collision with root package name */
    public String f18513e;

    public a() {
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
        this.f18513e = b.k().q("asp_shown_info", "");
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f18509f == null) {
                synchronized (c.a.r0.y3.p0.b.class) {
                    if (f18509f == null) {
                        f18509f = new a();
                    }
                }
            }
            return f18509f;
        }
        return (a) invokeV.objValue;
    }

    public AppPosInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(l.H());
            builder.latitude = this.f18510b;
            builder.longitude = this.a;
            builder.addr_timestamp = Long.valueOf(this.f18511c);
            builder.coordinate_type = "bd09ll";
            builder.asp_shown_info = this.f18513e;
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                builder.mercator_lat = e2.z();
                builder.mercator_lon = e2.A();
                builder.mercator_city = Integer.valueOf(e2.w());
                builder.mercator_radius = e2.C();
                builder.mercator_time = Long.valueOf(e2.D());
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppPosInfo c2 = c();
            JSONObject jSONObject = new JSONObject();
            if (c2 != null) {
                try {
                    jSONObject.put("ap_mac", c2.ap_mac);
                    jSONObject.put("ap_connected", c2.ap_connected);
                    jSONObject.put("latitude", c2.latitude);
                    jSONObject.put("longitude", c2.longitude);
                    jSONObject.put("addr_timestamp", c2.addr_timestamp);
                    jSONObject.put("coordinate_type", c2.coordinate_type);
                    jSONObject.put("asp_shown_info", c2.asp_shown_info);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LAT, c2.mercator_lat);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LON, c2.mercator_lon);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_CITY, c2.mercator_city);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_RADIUS, c2.mercator_radius);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_TIME, c2.mercator_time);
                    jSONObject.put("mercator_province_name", c2.mercator_province_name);
                    jSONObject.put("mercator_city_name", c2.mercator_city_name);
                    jSONObject.put("mercator_district_name", c2.mercator_district_name);
                } catch (JSONException unused) {
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public AppPosInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(l.H());
            String str = this.f18510b;
            builder.latitude = str;
            builder.longitude = this.a;
            if (m.isEmpty(str) || m.isEmpty(this.a)) {
                String q = b.k().q("key_last_receive_location_latitude_and_longitude", "");
                if (!m.isEmpty(q)) {
                    String[] split = q.split(",");
                    if (split.length >= 2) {
                        builder.latitude = split[0];
                        builder.longitude = split[1];
                    }
                }
            }
            builder.addr_timestamp = Long.valueOf(this.f18511c);
            builder.coordinate_type = "BD09LL";
            builder.asp_shown_info = this.f18513e;
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                builder.mercator_lat = e2.z();
                builder.mercator_lon = e2.A();
                builder.mercator_city = Integer.valueOf(e2.w());
                builder.mercator_radius = e2.C();
                builder.mercator_time = Long.valueOf(e2.D());
                builder.mercator_province_name = e2.B();
                builder.mercator_city_name = e2.x();
                builder.mercator_district_name = e2.y();
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f18512d)) {
                f();
            }
            return this.f18512d;
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        this.f18512d = connectionInfo.getBSSID();
                    } else {
                        this.f18512d = "";
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.k().y("asp_shown_info", this.f18513e);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f18513e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f18510b = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a = str;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.f18511c = j2;
        }
    }
}
