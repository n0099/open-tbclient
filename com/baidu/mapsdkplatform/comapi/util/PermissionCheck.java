package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PermissionCheck {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f7996a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f7997b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f7998c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f7999d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f8000e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f8001f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f8002g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f8003h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f8004i = null;
    public static c j = null;
    public static int k = 601;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (str == null) {
                    Log.e(PermissionCheck.f7999d, "The result is null");
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String str2 = PermissionCheck.f7999d;
                    Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.f8005a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f8007c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f8006b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f8008d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f8009e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f8010f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused = PermissionCheck.k = bVar.f8005a;
                if (PermissionCheck.j != null) {
                    PermissionCheck.j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f8005a;

        /* renamed from: b  reason: collision with root package name */
        public String f8006b;

        /* renamed from: c  reason: collision with root package name */
        public String f8007c;

        /* renamed from: d  reason: collision with root package name */
        public String f8008d;

        /* renamed from: e  reason: collision with root package name */
        public String f8009e;

        /* renamed from: f  reason: collision with root package name */
        public int f8010f;

        public b() {
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
            this.f8005a = 0;
            this.f8006b = "-1";
            this.f8007c = "-1";
            this.f8008d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f8000e), PermissionCheck.f8001f, Integer.valueOf(this.f8005a), this.f8006b, this.f8007c, this.f8008d) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
            f8000e = null;
            f8004i = null;
        }
    }

    public static int getPermissionResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? k : invokeV.intValue;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            f8000e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f8000e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f8001f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f8002g == null) {
                f8002g = new Hashtable<>();
            }
            if (f8003h == null) {
                f8003h = LBSAuthManager.getInstance(f8000e);
            }
            if (f8004i == null) {
                f8004i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f8000e.getPackageName(), 0).applicationInfo.loadLabel(f8000e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f8002g.put("mb", b2.getString("mb"));
                f8002g.put(IAdRequestParam.OS, b2.getString(IAdRequestParam.OS));
                f8002g.put("sv", b2.getString("sv"));
                f8002g.put("imt", "1");
                f8002g.put("net", b2.getString("net"));
                f8002g.put("cpu", b2.getString("cpu"));
                f8002g.put("glr", b2.getString("glr"));
                f8002g.put("glv", b2.getString("glv"));
                f8002g.put("resid", b2.getString("resid"));
                f8002g.put("appid", "-1");
                f8002g.put("ver", "1");
                f8002g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f8002g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f8002g.put("pcn", b2.getString("pcn"));
                f8002g.put("cuid", b2.getString("cuid"));
                f8002g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f8003h != null && f8004i != null && f8000e != null) {
                    int authenticate = f8003h.authenticate(false, "lbs_androidmapsdk", f8002g, f8004i);
                    if (authenticate != 0) {
                        String str = f7999d;
                        Log.e(str, "permission check result is: " + authenticate);
                    }
                    return authenticate;
                }
                String str2 = f7999d;
                Log.e(str2, "The authManager is: " + f8003h + "; the authCallback is: " + f8004i + "; the mContext is: " + f8000e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void setPermissionCheckResultListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cVar) == null) {
            j = cVar;
        }
    }
}
