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
    public static int f42385a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f42386b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f42387c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f42388d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f42389e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f42390f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f42391g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f42392h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f42393i = null;

    /* renamed from: j  reason: collision with root package name */
    public static c f42394j = null;
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
                    String unused = PermissionCheck.f42388d;
                    int permissionCheck = PermissionCheck.permissionCheck();
                    String unused2 = PermissionCheck.f42388d;
                    String str2 = "onAuthResult try permissionCheck result is: " + permissionCheck;
                    return;
                }
                b bVar = new b();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        bVar.f42395a = jSONObject.optInt("status");
                    }
                    if (jSONObject.has("appid")) {
                        bVar.f42397c = jSONObject.optString("appid");
                    }
                    if (jSONObject.has("uid")) {
                        bVar.f42396b = jSONObject.optString("uid");
                    }
                    if (jSONObject.has("message")) {
                        bVar.f42398d = jSONObject.optString("message");
                    }
                    if (jSONObject.has("token")) {
                        bVar.f42399e = jSONObject.optString("token");
                    }
                    if (jSONObject.has("ak_permission")) {
                        bVar.f42400f = jSONObject.optInt("ak_permission");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                int unused3 = PermissionCheck.k = bVar.f42395a;
                if (PermissionCheck.f42394j != null) {
                    PermissionCheck.f42394j.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42395a;

        /* renamed from: b  reason: collision with root package name */
        public String f42396b;

        /* renamed from: c  reason: collision with root package name */
        public String f42397c;

        /* renamed from: d  reason: collision with root package name */
        public String f42398d;

        /* renamed from: e  reason: collision with root package name */
        public String f42399e;

        /* renamed from: f  reason: collision with root package name */
        public int f42400f;

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
            this.f42395a = 0;
            this.f42396b = "-1";
            this.f42397c = "-1";
            this.f42398d = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f42389e), PermissionCheck.f42390f, Integer.valueOf(this.f42395a), this.f42396b, this.f42397c, this.f42398d) : (String) invokeV.objValue;
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
            f42394j = null;
            f42389e = null;
            f42393i = null;
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
            f42389e = context;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(f42389e.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                f42390f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
            }
            if (f42391g == null) {
                f42391g = new Hashtable<>();
            }
            if (f42392h == null) {
                f42392h = LBSAuthManager.getInstance(f42389e);
            }
            if (f42393i == null) {
                f42393i = new a(null);
            }
            try {
                str = context.getPackageManager().getPackageInfo(f42389e.getPackageName(), 0).applicationInfo.loadLabel(f42389e.getPackageManager()).toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            Bundle b2 = i.b();
            if (b2 != null) {
                f42391g.put("mb", b2.getString("mb"));
                f42391g.put("os", b2.getString("os"));
                f42391g.put("sv", b2.getString("sv"));
                f42391g.put("imt", "1");
                f42391g.put("net", b2.getString("net"));
                f42391g.put("cpu", b2.getString("cpu"));
                f42391g.put("glr", b2.getString("glr"));
                f42391g.put("glv", b2.getString("glv"));
                f42391g.put("resid", b2.getString("resid"));
                f42391g.put("appid", "-1");
                f42391g.put("ver", "1");
                f42391g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
                f42391g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
                f42391g.put("pcn", b2.getString("pcn"));
                f42391g.put("cuid", b2.getString("cuid"));
                f42391g.put("name", str);
            }
        }
    }

    public static synchronized int permissionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (PermissionCheck.class) {
                if (f42392h != null && f42393i != null && f42389e != null) {
                    int authenticate = f42392h.authenticate(false, "lbs_androidmapsdk", f42391g, f42393i);
                    if (authenticate != 0) {
                        String str = "permission check result is: " + authenticate;
                    }
                    return authenticate;
                }
                String str2 = "The authManager is: " + f42392h + "; the authCallback is: " + f42393i + "; the mContext is: " + f42389e;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void setPermissionCheckResultListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cVar) == null) {
            f42394j = cVar;
        }
    }
}
