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
    public static final String f8174a = "PermissionCheck";

    /* renamed from: b  reason: collision with root package name */
    public static Context f8175b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f8176c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Hashtable<String, String> f8177d = null;

    /* renamed from: e  reason: collision with root package name */
    public static LBSAuthManager f8178e = null;

    /* renamed from: f  reason: collision with root package name */
    public static LBSAuthManagerListener f8179f = null;

    /* renamed from: g  reason: collision with root package name */
    public static c f8180g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f8181h = 601;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i2, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f8174a, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                String str2 = PermissionCheck.f8174a;
                Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f8182a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.f8184c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f8183b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.f8185d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.f8186e = jSONObject.optString("token");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int unused = PermissionCheck.f8181h = bVar.f8182a;
            if (PermissionCheck.f8180g != null) {
                PermissionCheck.f8180g.a(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f8182a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f8183b = "-1";

        /* renamed from: c  reason: collision with root package name */
        public String f8184c = "-1";

        /* renamed from: d  reason: collision with root package name */
        public String f8185d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f8186e;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f8175b), PermissionCheck.f8176c, Integer.valueOf(this.f8182a), this.f8183b, this.f8184c, this.f8185d);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        f8180g = null;
        f8175b = null;
        f8179f = null;
    }

    public static int getPermissionResult() {
        return f8181h;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        f8175b = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f8175b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f8176c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f8177d == null) {
            f8177d = new Hashtable<>();
        }
        if (f8178e == null) {
            f8178e = LBSAuthManager.getInstance(f8175b);
        }
        if (f8179f == null) {
            f8179f = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(f8175b.getPackageName(), 0).applicationInfo.loadLabel(f8175b.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        Bundle b2 = f.b();
        if (b2 != null) {
            f8177d.put("mb", b2.getString("mb"));
            f8177d.put(IAdRequestParam.OS, b2.getString(IAdRequestParam.OS));
            f8177d.put("sv", b2.getString("sv"));
            f8177d.put("imt", "1");
            f8177d.put("net", b2.getString("net"));
            f8177d.put("cpu", b2.getString("cpu"));
            f8177d.put("glr", b2.getString("glr"));
            f8177d.put("glv", b2.getString("glv"));
            f8177d.put("resid", b2.getString("resid"));
            f8177d.put("appid", "-1");
            f8177d.put("ver", "1");
            f8177d.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
            f8177d.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
            f8177d.put("pcn", b2.getString("pcn"));
            f8177d.put("cuid", b2.getString("cuid"));
            f8177d.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f8178e != null && f8179f != null && f8175b != null) {
                int authenticate = f8178e.authenticate(false, "lbs_androidsdk", f8177d, f8179f);
                if (authenticate != 0) {
                    String str = f8174a;
                    Log.e(str, "permission check result is: " + authenticate);
                }
                return authenticate;
            }
            String str2 = f8174a;
            Log.e(str2, "The authManager is: " + f8178e + "; the authCallback is: " + f8179f + "; the mContext is: " + f8175b);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        f8180g = cVar;
    }
}
