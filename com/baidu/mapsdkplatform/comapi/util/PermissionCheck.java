package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.p0.u;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PermissionCheck {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 200;
    public static int b = 202;
    public static int c = 252;
    public static final String d = "PermissionCheck";
    public static Context e = null;
    public static String f = null;
    public static Hashtable<String, String> g = null;
    public static LBSAuthManager h = null;
    public static LBSAuthManagerListener i = null;
    public static c j = null;
    public static int k = 601;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface c {
        void a(b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(363765385, "Lcom/baidu/mapsdkplatform/comapi/util/PermissionCheck;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(363765385, "Lcom/baidu/mapsdkplatform/comapi/util/PermissionCheck;");
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements LBSAuthManagerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (str == null) {
                    Log.e(PermissionCheck.d, "The result is null");
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String str2 = PermissionCheck.d;
                    Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int unused = PermissionCheck.k = bVar.a;
                if (PermissionCheck.j != null && PermissionCheck.l) {
                    PermissionCheck.j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;

        public b() {
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
            this.a = 0;
            this.b = "-1";
            this.c = "-1";
            this.d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.e), PermissionCheck.f, Integer.valueOf(this.a), this.b, this.c, this.d);
            }
            return (String) invokeV.objValue;
        }
    }

    public PermissionCheck() {
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

    public static void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            j = null;
            e = null;
            i = null;
        }
    }

    public static int getPermissionResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return k;
        }
        return invokeV.intValue;
    }

    public static void setApiKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, str) == null) && str != null && str.trim().length() > 0) {
            f = str;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, cVar) == null) {
            j = cVar;
        }
    }

    public static void setPrivacyMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            l = z;
            if (z) {
                permissionCheck();
            } else {
                h.a();
            }
        }
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null && TextUtils.isEmpty(f)) {
                f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (g == null) {
                g = new Hashtable<>();
            }
            if (h == null) {
                h = LBSAuthManager.getInstance(e);
            }
            if (i == null) {
                i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            try {
                JSONObject jSONObject = new JSONObject(h.c());
                g.put(FunAdSdk.PLATFORM_MB, jSONObject.optString(FunAdSdk.PLATFORM_MB));
                g.put(TtsLogLoad.KEY_OS, jSONObject.optString(TtsLogLoad.KEY_OS));
                g.put("sv", jSONObject.optString("sv"));
                g.put("imt", "1");
                g.put("net", jSONObject.optString("net"));
                g.put("cpu", jSONObject.optString("cpu"));
                g.put("glr", jSONObject.optString("glr"));
                g.put("glv", jSONObject.optString("glv"));
                g.put("resid", jSONObject.optString("resid"));
                g.put("appid", "-1");
                g.put("ver", "1");
                g.put("screen", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("screen_x")), Integer.valueOf(jSONObject.optInt("screen_y"))));
                g.put("dpi", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("dpi_x")), Integer.valueOf(jSONObject.optInt("dpi_y"))));
                g.put(u.w, jSONObject.optString(u.w));
                g.put("cuid", jSONObject.optString("cuid"));
                g.put("name", str);
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (h != null && i != null && e != null) {
                    h.setKey(f);
                    int authenticate = h.authenticate(false, "lbs_androidmapsdk", g, i);
                    if (authenticate != 0) {
                        String str = d;
                        Log.e(str, "permission check result is: " + authenticate);
                    }
                    return authenticate;
                }
                String str2 = d;
                Log.e(str2, "The authManager is: " + h + "; the authCallback is: " + i + "; the mContext is: " + e);
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
