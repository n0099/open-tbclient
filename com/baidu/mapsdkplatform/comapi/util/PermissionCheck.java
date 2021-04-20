package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PermissionCheck {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7888a = "PermissionCheck";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7889b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f7890c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Hashtable<String, String> f7891d = null;

    /* renamed from: e  reason: collision with root package name */
    public static LBSAuthManager f7892e = null;

    /* renamed from: f  reason: collision with root package name */
    public static LBSAuthManagerListener f7893f = null;

    /* renamed from: g  reason: collision with root package name */
    public static c f7894g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7895h = 601;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f7888a, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                String str2 = PermissionCheck.f7888a;
                Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f7896a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.f7898c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f7897b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.f7899d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.f7900e = jSONObject.optString("token");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int unused = PermissionCheck.f7895h = bVar.f7896a;
            if (PermissionCheck.f7894g != null) {
                PermissionCheck.f7894g.a(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7896a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f7897b = "-1";

        /* renamed from: c  reason: collision with root package name */
        public String f7898c = "-1";

        /* renamed from: d  reason: collision with root package name */
        public String f7899d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f7900e;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f7889b), PermissionCheck.f7890c, Integer.valueOf(this.f7896a), this.f7897b, this.f7898c, this.f7899d);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        f7894g = null;
        f7889b = null;
        f7893f = null;
    }

    public static int getPermissionResult() {
        return f7895h;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        f7889b = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f7889b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f7890c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f7891d == null) {
            f7891d = new Hashtable<>();
        }
        if (f7892e == null) {
            f7892e = LBSAuthManager.getInstance(f7889b);
        }
        if (f7893f == null) {
            f7893f = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(f7889b.getPackageName(), 0).applicationInfo.loadLabel(f7889b.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        Bundle b2 = f.b();
        if (b2 != null) {
            f7891d.put("mb", b2.getString("mb"));
            f7891d.put(IAdRequestParam.OS, b2.getString(IAdRequestParam.OS));
            f7891d.put("sv", b2.getString("sv"));
            f7891d.put("imt", "1");
            f7891d.put("net", b2.getString("net"));
            f7891d.put("cpu", b2.getString("cpu"));
            f7891d.put("glr", b2.getString("glr"));
            f7891d.put("glv", b2.getString("glv"));
            f7891d.put("resid", b2.getString("resid"));
            f7891d.put("appid", "-1");
            f7891d.put("ver", "1");
            f7891d.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
            f7891d.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
            f7891d.put("pcn", b2.getString("pcn"));
            f7891d.put("cuid", b2.getString("cuid"));
            f7891d.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f7892e != null && f7893f != null && f7889b != null) {
                int authenticate = f7892e.authenticate(false, "lbs_androidsdk", f7891d, f7893f);
                if (authenticate != 0) {
                    String str = f7888a;
                    Log.e(str, "permission check result is: " + authenticate);
                }
                return authenticate;
            }
            String str2 = f7888a;
            Log.e(str2, "The authManager is: " + f7892e + "; the authCallback is: " + f7893f + "; the mContext is: " + f7889b);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        f7894g = cVar;
    }
}
