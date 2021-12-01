package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.p1.l;
import c.a.p0.a.y1.b.e;
import c.a.p0.a.z2.q0;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppNetworkUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class NetType {
        public static final /* synthetic */ NetType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetType NONE;
        public static final NetType UNKOWN;
        public static final NetType WIFI;
        public static final NetType _2G;
        public static final NetType _3G;
        public static final NetType _4G;
        public static final NetType _5G;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1791297955, "Lcom/baidu/swan/apps/network/SwanAppNetworkUtils$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1791297955, "Lcom/baidu/swan/apps/network/SwanAppNetworkUtils$NetType;");
                    return;
                }
            }
            NONE = new NetType(PolyActivity.NONE_PANEL_TYPE, 0, "no");
            WIFI = new NetType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1, "wifi");
            _2G = new NetType("_2G", 2, "2g");
            _3G = new NetType("_3G", 3, "3g");
            _4G = new NetType("_4G", 4, "4g");
            _5G = new NetType("_5G", 5, "5g");
            NetType netType = new NetType("UNKOWN", 6, "unknow");
            UNKOWN = netType;
            $VALUES = new NetType[]{NONE, WIFI, _2G, _3G, _4G, _5G, netType};
        }

        public NetType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static NetType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetType) Enum.valueOf(NetType.class, str) : (NetType) invokeL.objValue;
        }

        public static NetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetType[]) $VALUES.clone() : (NetType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements c.a.p0.a.y1.b.a<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.y1.b.a
        /* renamed from: a */
        public void onResult(Bundle bundle) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (bVar = this.a) == null) {
                return;
            }
            bVar.onResult(bundle.getInt("net_quality"));
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onResult(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1126712330, "Lcom/baidu/swan/apps/network/SwanAppNetworkUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1126712330, "Lcom/baidu/swan/apps/network/SwanAppNetworkUtils;");
                return;
            }
        }
        a = k.a;
    }

    public static boolean a(OkHttpClient okHttpClient, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, okHttpClient, str)) == null) {
            boolean z = false;
            if (okHttpClient != null && !TextUtils.isEmpty(str) && okHttpClient.dispatcher() != null) {
                for (Call call : okHttpClient.dispatcher().queuedCalls()) {
                    if (call != null && call.request() != null && call.request().tag() != null && call.request().tag().equals(str)) {
                        call.cancel();
                        z = true;
                    }
                }
                for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
                    if (call2 != null && call2.request() != null && call2.request().tag() != null && call2.request().tag().equals(str)) {
                        call2.cancel();
                        z = true;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void b(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            e.a(l.class, null, new a(bVar));
        }
    }

    public static NetworkInfo c(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String d(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str)) == null) {
            if (a) {
                String str2 = "——> getNetworkType: netType " + i2 + " subTypeName " + str;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3g";
                case 13:
                case 18:
                case 19:
                    return "4g";
                case 20:
                    return "5g";
                default:
                    return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
            }
        }
        return (String) invokeIL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            NetworkInfo c2 = c(AppRuntime.getAppContext());
            return (c2 == null || !c2.isConnected()) ? "no" : c2.getType() == 1 ? "wifi" : c2.getType() == 0 ? d(c2.getSubtype(), c2.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static NetType f() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String e2 = e();
            int hashCode = e2.hashCode();
            if (hashCode == -840472412) {
                if (e2.equals("unknow")) {
                    c2 = 6;
                }
                c2 = 65535;
            } else if (hashCode == 1653) {
                if (e2.equals("2g")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 1684) {
                if (e2.equals("3g")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 1715) {
                if (e2.equals("4g")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 1746) {
                if (e2.equals("5g")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != 3521) {
                if (hashCode == 3649301 && e2.equals("wifi")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else {
                if (e2.equals("no")) {
                    c2 = 5;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                if (c2 != 5) {
                                    return NetType.UNKOWN;
                                }
                                return NetType.NONE;
                            }
                            return NetType.WIFI;
                        }
                        return NetType._5G;
                    }
                    return NetType._4G;
                }
                return NetType._3G;
            }
            return NetType._2G;
        }
        return (NetType) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String f2 = q0.f(g.U().g0());
            return TextUtils.isEmpty(f2) ? "" : f2;
        }
        return (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            NetworkInfo c2 = c(AppRuntime.getAppContext());
            return c2 != null && c2.isConnectedOrConnecting();
        }
        return invokeV.booleanValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? h() : invokeL.booleanValue;
    }

    public static boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            NetworkInfo c2 = c(AppRuntime.getAppContext());
            return c2 != null && c2.isAvailable() && c2.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static void k(Context context, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, context, callbackHandler, str) == null) || context == null || TextUtils.isEmpty(str) || callbackHandler == null) {
            return;
        }
        boolean i2 = i(context);
        String e2 = e();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isConnected", i2);
            if (TextUtils.equals(e2, "no")) {
                e2 = "none";
            }
            jSONObject.put("networkType", e2);
            if (a) {
                String str2 = "——> notifyNetworkStatus: isConnected " + jSONObject.get("isConnected") + " , networkType " + jSONObject.get("networkType");
            }
        } catch (JSONException e3) {
            if (a) {
                e3.printStackTrace();
            }
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        boolean z = a;
    }
}
