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
    public static int f40376a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f40377b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f40378c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f40379d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f40380e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f40381f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f40382g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f40383h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f40384i = null;
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
                    String unused = PermissionCheck.f40379d;
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String unused2 = PermissionCheck.f40379d;
                    String str2 = "onAuthResult try permissionCheck result is: " + permissionCheck;
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.f40385a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f40387c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f40386b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f40388d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f40389e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f40390f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused3 = PermissionCheck.k = bVar.f40385a;
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
        public int f40385a;

        /* renamed from: b  reason: collision with root package name */
        public String f40386b;

        /* renamed from: c  reason: collision with root package name */
        public String f40387c;

        /* renamed from: d  reason: collision with root package name */
        public String f40388d;

        /* renamed from: e  reason: collision with root package name */
        public String f40389e;

        /* renamed from: f  reason: collision with root package name */
        public int f40390f;

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
            this.f40385a = 0;
            this.f40386b = "-1";
            this.f40387c = "-1";
            this.f40388d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f40380e), PermissionCheck.f40381f, Integer.valueOf(this.f40385a), this.f40386b, this.f40387c, this.f40388d) : (String) invokeV.objValue;
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
            f40380e = null;
            f40384i = null;
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
            f40380e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f40380e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f40381f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f40382g == null) {
                f40382g = new Hashtable<>();
            }
            if (f40383h == null) {
                f40383h = LBSAuthManager.getInstance(f40380e);
            }
            if (f40384i == null) {
                f40384i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f40380e.getPackageName(), 0).applicationInfo.loadLabel(f40380e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f40382g.put("mb", b2.getString("mb"));
                f40382g.put("os", b2.getString("os"));
                f40382g.put("sv", b2.getString("sv"));
                f40382g.put("imt", "1");
                f40382g.put("net", b2.getString("net"));
                f40382g.put("cpu", b2.getString("cpu"));
                f40382g.put("glr", b2.getString("glr"));
                f40382g.put("glv", b2.getString("glv"));
                f40382g.put("resid", b2.getString("resid"));
                f40382g.put("appid", "-1");
                f40382g.put("ver", "1");
                f40382g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f40382g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f40382g.put("pcn", b2.getString("pcn"));
                f40382g.put("cuid", b2.getString("cuid"));
                f40382g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f40383h != null && f40384i != null && f40380e != null) {
                    int authenticate = f40383h.authenticate(false, "lbs_androidmapsdk", f40382g, f40384i);
                    if (authenticate != 0) {
                        String str = "permission check result is: " + authenticate;
                    }
                    return authenticate;
                }
                String str2 = "The authManager is: " + f40383h + "; the authCallback is: " + f40384i + "; the mContext is: " + f40380e;
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
