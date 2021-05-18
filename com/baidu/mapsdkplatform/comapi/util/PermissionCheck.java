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
    public static int f7980a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f7981b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f7982c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f7983d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f7984e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f7985f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f7986g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f7987h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f7988i = null;
    public static c j = null;
    public static int k = 601;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i2, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f7983d, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                String str2 = PermissionCheck.f7983d;
                Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f7989a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.f7991c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f7990b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.f7992d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.f7993e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    bVar.f7994f = jSONObject.optInt("ak_permission");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int unused = PermissionCheck.k = bVar.f7989a;
            if (PermissionCheck.j != null) {
                PermissionCheck.j.a(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7989a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f7990b = "-1";

        /* renamed from: c  reason: collision with root package name */
        public String f7991c = "-1";

        /* renamed from: d  reason: collision with root package name */
        public String f7992d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f7993e;

        /* renamed from: f  reason: collision with root package name */
        public int f7994f;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f7984e), PermissionCheck.f7985f, Integer.valueOf(this.f7989a), this.f7990b, this.f7991c, this.f7992d);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        j = null;
        f7984e = null;
        f7988i = null;
    }

    public static int getPermissionResult() {
        return k;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        f7984e = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f7984e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f7985f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f7986g == null) {
            f7986g = new Hashtable<>();
        }
        if (f7987h == null) {
            f7987h = LBSAuthManager.getInstance(f7984e);
        }
        if (f7988i == null) {
            f7988i = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(f7984e.getPackageName(), 0).applicationInfo.loadLabel(f7984e.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        Bundle b2 = i.b();
        if (b2 != null) {
            f7986g.put("mb", b2.getString("mb"));
            f7986g.put(IAdRequestParam.OS, b2.getString(IAdRequestParam.OS));
            f7986g.put("sv", b2.getString("sv"));
            f7986g.put("imt", "1");
            f7986g.put("net", b2.getString("net"));
            f7986g.put("cpu", b2.getString("cpu"));
            f7986g.put("glr", b2.getString("glr"));
            f7986g.put("glv", b2.getString("glv"));
            f7986g.put("resid", b2.getString("resid"));
            f7986g.put("appid", "-1");
            f7986g.put("ver", "1");
            f7986g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
            f7986g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
            f7986g.put("pcn", b2.getString("pcn"));
            f7986g.put("cuid", b2.getString("cuid"));
            f7986g.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f7987h != null && f7988i != null && f7984e != null) {
                int authenticate = f7987h.authenticate(false, "lbs_androidmapsdk", f7986g, f7988i);
                if (authenticate != 0) {
                    String str = f7983d;
                    Log.e(str, "permission check result is: " + authenticate);
                }
                return authenticate;
            }
            String str2 = f7983d;
            Log.e(str2, "The authManager is: " + f7987h + "; the authCallback is: " + f7988i + "; the mContext is: " + f7984e);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        j = cVar;
    }
}
