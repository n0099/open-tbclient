package c.a.p0.h.i.p;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int q;
    public int r;
    public int s;
    public String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, d dVar, int i2, int i3) {
        super(context, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 1;
        this.r = 1;
        this.s = 1;
        this.r = i2;
        this.s = i3;
    }

    @Override // c.a.p0.h.i.p.f
    public HashMap<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // c.a.p0.h.i.p.f
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.h.i.p.f
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://powerful.xdplt.com/api/v1/front/ltc" : (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                String a = c.a.p0.f.a.b.c.f9517b.a(this.f9729b);
                return TextUtils.isEmpty(a) ? UUID.randomUUID().toString() : a;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", this.f9736i.e());
                jSONObject2.put("name", c.a.p0.h.i.n.a.b().a());
                jSONObject2.put("bundle", c.a.p0.h.i.s.h.k());
                jSONObject2.put("version", c.a.p0.h.i.s.h.l());
                jSONObject.put("app", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ua", l());
                jSONObject3.put("imei", c.a.p0.h.i.n.a.b().s());
                jSONObject3.put("android_id", h());
                jSONObject3.put("ip", j(true));
                jSONObject3.put("type", 1);
                jSONObject3.put(UrlOcrConfig.IdCardKey.OS, 1);
                jSONObject3.put(HttpConstants.OS_VERSION, c.a.p0.h.i.s.h.f());
                jSONObject3.put("make", c.a.p0.h.i.s.h.g());
                jSONObject3.put("model", c.a.p0.h.i.s.h.e());
                jSONObject3.put("language", this.f9729b.getResources().getConfiguration().locale.getLanguage());
                jSONObject3.put("connection_type", NetworkUtils.c(true));
                jSONObject3.put("carrier", k(this.f9729b));
                jSONObject3.put(BaseStatisContent.MAC, NetworkUtils.e(this.f9729b));
                jSONObject3.put("screen_width", c.a.p0.h.i.s.h.i(this.f9729b));
                jSONObject3.put("screen_height", c.a.p0.h.i.s.h.h(this.f9729b));
                jSONObject3.put("screen_orientation", this.f9729b.getResources().getConfiguration().orientation);
                jSONObject.put("device", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("sid", this.f9736i.b());
                jSONObject4.put("ad_count", this.q);
                jSONObject4.put(TiebaStatic.Params.AD_TYPE, this.r);
                jSONObject4.put("pos", this.s);
                jSONObject4.put("width", this.f9736i.d());
                jSONObject4.put("height", this.f9736i.a());
                jSONObject4.put(ClientCookie.SECURE_ATTR, 1);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject4);
                jSONObject.put("imps", jSONArray);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                loop0: while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!z || !(nextElement instanceof Inet6Address)) {
                            if (!nextElement.isLoopbackAddress()) {
                                break loop0;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeZ.objValue;
    }

    public int k(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String simOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
                return 1;
            }
            if ("46001".equals(simOperator)) {
                return 2;
            }
            return "46003".equals(simOperator) ? 3 : 0;
        }
        return invokeL.intValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.t)) {
                try {
                    try {
                        this.t = WebSettings.getDefaultUserAgent(this.f9729b);
                    } catch (Exception unused) {
                        this.t = "";
                    }
                } catch (Exception unused2) {
                    this.t = System.getProperty("http.agent");
                }
            }
            return this.t;
        }
        return (String) invokeV.objValue;
    }
}
