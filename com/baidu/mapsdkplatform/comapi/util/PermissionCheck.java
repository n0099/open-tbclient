package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.un.x;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PermissionCheck {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f37141b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f37142c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f37143d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f37144e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f37145f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f37146g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f37147h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f37148i = null;

    /* renamed from: j  reason: collision with root package name */
    public static c f37149j = null;

    /* renamed from: k  reason: collision with root package name */
    public static int f37150k = 601;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
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
                    String unused = PermissionCheck.f37143d;
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String unused2 = PermissionCheck.f37143d;
                    String str2 = "onAuthResult try permissionCheck result is: " + permissionCheck;
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f37152c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f37151b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f37153d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f37154e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f37155f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused3 = PermissionCheck.f37150k = bVar.a;
                if (PermissionCheck.f37149j != null) {
                    PermissionCheck.f37149j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f37151b;

        /* renamed from: c  reason: collision with root package name */
        public String f37152c;

        /* renamed from: d  reason: collision with root package name */
        public String f37153d;

        /* renamed from: e  reason: collision with root package name */
        public String f37154e;

        /* renamed from: f  reason: collision with root package name */
        public int f37155f;

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
            this.a = 0;
            this.f37151b = "-1";
            this.f37152c = "-1";
            this.f37153d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f37144e), PermissionCheck.f37145f, Integer.valueOf(this.a), this.f37151b, this.f37152c, this.f37153d) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
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
            f37149j = null;
            f37144e = null;
            f37148i = null;
        }
    }

    public static int getPermissionResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f37150k : invokeV.intValue;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            f37144e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f37144e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f37145f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f37146g == null) {
                f37146g = new Hashtable<>();
            }
            if (f37147h == null) {
                f37147h = LBSAuthManager.getInstance(f37144e);
            }
            if (f37148i == null) {
                f37148i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f37144e.getPackageName(), 0).applicationInfo.loadLabel(f37144e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f37146g.put(FunAdSdk.PLATFORM_MB, b2.getString(FunAdSdk.PLATFORM_MB));
                f37146g.put(UrlOcrConfig.IdCardKey.OS, b2.getString(UrlOcrConfig.IdCardKey.OS));
                f37146g.put("sv", b2.getString("sv"));
                f37146g.put("imt", "1");
                f37146g.put("net", b2.getString("net"));
                f37146g.put("cpu", b2.getString("cpu"));
                f37146g.put("glr", b2.getString("glr"));
                f37146g.put("glv", b2.getString("glv"));
                f37146g.put("resid", b2.getString("resid"));
                f37146g.put("appid", "-1");
                f37146g.put("ver", "1");
                f37146g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f37146g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f37146g.put(x.x, b2.getString(x.x));
                f37146g.put("cuid", b2.getString("cuid"));
                f37146g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f37147h != null && f37148i != null && f37144e != null) {
                    int authenticate = f37147h.authenticate(false, "lbs_androidmapsdk", f37146g, f37148i);
                    if (authenticate != 0) {
                        String str = "permission check result is: " + authenticate;
                    }
                    return authenticate;
                }
                String str2 = "The authManager is: " + f37147h + "; the authCallback is: " + f37148i + "; the mContext is: " + f37144e;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void setPermissionCheckResultListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cVar) == null) {
            f37149j = cVar;
        }
    }
}
