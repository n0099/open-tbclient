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
/* loaded from: classes5.dex */
public class PermissionCheck {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f42562a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f42563b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f42564c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f42565d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f42566e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f42567f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f42568g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f42569h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f42570i = null;

    /* renamed from: j  reason: collision with root package name */
    public static c f42571j = null;
    public static int k = 601;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                    String unused = PermissionCheck.f42565d;
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String unused2 = PermissionCheck.f42565d;
                    String str2 = "onAuthResult try permissionCheck result is: " + permissionCheck;
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.f42572a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f42574c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f42573b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f42575d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f42576e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f42577f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused3 = PermissionCheck.k = bVar.f42572a;
                if (PermissionCheck.f42571j != null) {
                    PermissionCheck.f42571j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42572a;

        /* renamed from: b  reason: collision with root package name */
        public String f42573b;

        /* renamed from: c  reason: collision with root package name */
        public String f42574c;

        /* renamed from: d  reason: collision with root package name */
        public String f42575d;

        /* renamed from: e  reason: collision with root package name */
        public String f42576e;

        /* renamed from: f  reason: collision with root package name */
        public int f42577f;

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
            this.f42572a = 0;
            this.f42573b = "-1";
            this.f42574c = "-1";
            this.f42575d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f42566e), PermissionCheck.f42567f, Integer.valueOf(this.f42572a), this.f42573b, this.f42574c, this.f42575d) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            f42571j = null;
            f42566e = null;
            f42570i = null;
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
            f42566e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f42566e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f42567f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f42568g == null) {
                f42568g = new Hashtable<>();
            }
            if (f42569h == null) {
                f42569h = LBSAuthManager.getInstance(f42566e);
            }
            if (f42570i == null) {
                f42570i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f42566e.getPackageName(), 0).applicationInfo.loadLabel(f42566e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f42568g.put("mb", b2.getString("mb"));
                f42568g.put("os", b2.getString("os"));
                f42568g.put("sv", b2.getString("sv"));
                f42568g.put("imt", "1");
                f42568g.put("net", b2.getString("net"));
                f42568g.put("cpu", b2.getString("cpu"));
                f42568g.put("glr", b2.getString("glr"));
                f42568g.put("glv", b2.getString("glv"));
                f42568g.put("resid", b2.getString("resid"));
                f42568g.put("appid", "-1");
                f42568g.put("ver", "1");
                f42568g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f42568g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f42568g.put("pcn", b2.getString("pcn"));
                f42568g.put("cuid", b2.getString("cuid"));
                f42568g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f42569h != null && f42570i != null && f42566e != null) {
                    int authenticate = f42569h.authenticate(false, "lbs_androidmapsdk", f42568g, f42570i);
                    if (authenticate != 0) {
                        String str = "permission check result is: " + authenticate;
                    }
                    return authenticate;
                }
                String str2 = "The authManager is: " + f42569h + "; the authCallback is: " + f42570i + "; the mContext is: " + f42566e;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void setPermissionCheckResultListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cVar) == null) {
            f42571j = cVar;
        }
    }
}
