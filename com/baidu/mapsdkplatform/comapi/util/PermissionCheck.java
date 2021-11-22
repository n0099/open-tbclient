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
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PermissionCheck {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f41208a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f41209b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f41210c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f41211d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f41212e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f41213f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f41214g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f41215h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f41216i = null;
    public static c j = null;
    public static int k = 601;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                    String unused = PermissionCheck.f41211d;
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String unused2 = PermissionCheck.f41211d;
                    String str2 = "onAuthResult try permissionCheck result is: " + permissionCheck;
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.f41217a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f41219c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f41218b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f41220d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f41221e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f41222f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused3 = PermissionCheck.k = bVar.f41217a;
                if (PermissionCheck.j != null) {
                    PermissionCheck.j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f41217a;

        /* renamed from: b  reason: collision with root package name */
        public String f41218b;

        /* renamed from: c  reason: collision with root package name */
        public String f41219c;

        /* renamed from: d  reason: collision with root package name */
        public String f41220d;

        /* renamed from: e  reason: collision with root package name */
        public String f41221e;

        /* renamed from: f  reason: collision with root package name */
        public int f41222f;

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
            this.f41217a = 0;
            this.f41218b = "-1";
            this.f41219c = "-1";
            this.f41220d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f41212e), PermissionCheck.f41213f, Integer.valueOf(this.f41217a), this.f41218b, this.f41219c, this.f41220d) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
            f41212e = null;
            f41216i = null;
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
            f41212e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f41212e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f41213f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f41214g == null) {
                f41214g = new Hashtable<>();
            }
            if (f41215h == null) {
                f41215h = LBSAuthManager.getInstance(f41212e);
            }
            if (f41216i == null) {
                f41216i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f41212e.getPackageName(), 0).applicationInfo.loadLabel(f41212e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f41214g.put("mb", b2.getString("mb"));
                f41214g.put("os", b2.getString("os"));
                f41214g.put("sv", b2.getString("sv"));
                f41214g.put("imt", "1");
                f41214g.put("net", b2.getString("net"));
                f41214g.put("cpu", b2.getString("cpu"));
                f41214g.put("glr", b2.getString("glr"));
                f41214g.put("glv", b2.getString("glv"));
                f41214g.put("resid", b2.getString("resid"));
                f41214g.put("appid", "-1");
                f41214g.put("ver", "1");
                f41214g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f41214g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f41214g.put("pcn", b2.getString("pcn"));
                f41214g.put("cuid", b2.getString("cuid"));
                f41214g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f41215h != null && f41216i != null && f41212e != null) {
                    int authenticate = f41215h.authenticate(false, "lbs_androidmapsdk", f41214g, f41216i);
                    if (authenticate != 0) {
                        String str = "permission check result is: " + authenticate;
                    }
                    return authenticate;
                }
                String str2 = "The authManager is: " + f41215h + "; the authCallback is: " + f41216i + "; the mContext is: " + f41212e;
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
