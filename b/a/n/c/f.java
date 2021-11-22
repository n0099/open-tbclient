package b.a.n.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3574b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3575c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Integer> f3576d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3577a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1046297463, "Lb/a/n/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1046297463, "Lb/a/n/c/f;");
                return;
            }
        }
        f3574b = AppConfig.isDebug();
        f3575c = "networkparam";
        HashMap<String, Integer> hashMap = new HashMap<>();
        f3576d = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f3576d.put("3GNET", 21);
        f3576d.put("3GWAP", 22);
        f3576d.put("CMNET", 31);
        f3576d.put("UNINET", 32);
        f3576d.put("CTNET", 33);
        f3576d.put("CMWAP", 41);
        f3576d.put("UNIWAP", 42);
        f3576d.put("CTWAP", 43);
    }

    public f() {
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
        this.f3577a = AppRuntime.getAppContext();
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                String b2 = b();
                if (TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.f3577a.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
                }
                if (TextUtils.isEmpty(b2)) {
                    return str;
                }
                if (!TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f3577a.getApplicationContext()).edit();
                    edit.putString(NetworkParam.LAST_NETWORK_TYPE, b2);
                    edit.apply();
                }
                return UrlUtil.addParam(str, "network", b2);
            }
            return UrlUtil.addParam(str, "network", b());
        }
        return (String) invokeLZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long uptimeMillis = f3574b ? SystemClock.uptimeMillis() : 0L;
            ConnectManager connectManager = new ConnectManager(this.f3577a);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            if (!TextUtils.isEmpty(netType)) {
                netType = netType.toUpperCase(Locale.getDefault());
                Integer num = f3576d.get(netType);
                if (num == null) {
                    num = 5;
                }
                str = num + "_" + subType;
            } else {
                str = ((Object) 5) + "_" + subType;
            }
            if (f3574b) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                String str2 = "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
