package com.baidu.sapi2.views.logindialog.utils;

import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "auto_statistic";
    public static final String b = "login_dialog";
    public static LinkedHashMap c = null;
    public static final String d = "show_time_consume";
    public static final String e = "show_login_type";
    public static final String f = "clickevent";
    public static final String g = "login_result";
    public static final String h = "login_type";
    public static JSONArray i = null;
    public static final String j = "0";
    public static final String k = "1";
    public static final String l = "name";
    public static final String m = "time_consume";
    public static final String n = "result_code";
    public static final String o = "result_msg";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "{eventType:login_dialog}" : (String) invokeV.objValue;
    }

    /* renamed from: com.baidu.sapi2.views.logindialog.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0135a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0135a(boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1276985143, "Lcom/baidu/sapi2/views/logindialog/utils/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1276985143, "Lcom/baidu/sapi2/views/logindialog/utils/a;");
                return;
            }
        }
        c = new LinkedHashMap();
        i = new JSONArray();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            i = new JSONArray();
            c.clear();
        }
    }

    public static void a(long j2, QuickLoginType quickLoginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65539, null, j2, quickLoginType) == null) {
            c.put(d, String.valueOf(j2));
            c.put(e, quickLoginType.getValue());
        }
    }

    public static void a(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j2, str) == null) {
            c.put(d, String.valueOf(j2));
            c.put(e, str);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            try {
                if (i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                    i.remove(0);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", str);
                i.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, long j2, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), str2}) == null) {
            try {
                if (i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                    i.remove(0);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", str);
                jSONObject.put(m, j2);
                jSONObject.put("result_code", i2);
                jSONObject.put("result_msg", str2);
                i.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, QuickLoginType quickLoginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, quickLoginType) == null) {
            c.put(g, str);
            c.put("login_type", quickLoginType.getValue());
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            c.put(g, str);
            c.put("login_type", str2);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            try {
                SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
                if (sapiAccountManager == null || sapiAccountManager.getConfignation() == null) {
                    return;
                }
                c.put(f, String.valueOf(i));
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
                httpHashMapWrap.put("pid", "111");
                httpHashMapWrap.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
                httpHashMapWrap.put("source", "native");
                httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                httpHashMapWrap.put("data_source", "client");
                httpHashMapWrap.put("name", "auto_statistic");
                httpHashMapWrap.put("auto_statistic", Base64.encodeToString(a().getBytes(), 2));
                if (c != null) {
                    for (String str : c.keySet()) {
                        httpHashMapWrap.put(str, (String) c.get(str));
                    }
                }
                new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new C0135a(true));
                b();
            } catch (Exception e2) {
                Log.e(Log.TAG, e2.getMessage());
            }
        }
    }
}
