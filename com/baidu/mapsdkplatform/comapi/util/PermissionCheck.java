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
    public static int f7880a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f7881b = 202;

    /* renamed from: c  reason: collision with root package name */
    public static int f7882c = 252;

    /* renamed from: d  reason: collision with root package name */
    public static final String f7883d = "PermissionCheck";

    /* renamed from: e  reason: collision with root package name */
    public static Context f7884e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f7885f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Hashtable<String, String> f7886g = null;

    /* renamed from: h  reason: collision with root package name */
    public static LBSAuthManager f7887h = null;

    /* renamed from: i  reason: collision with root package name */
    public static LBSAuthManagerListener f7888i = null;
    public static c j = null;
    public static int k = 601;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i2, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f7883d, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                String str2 = PermissionCheck.f7883d;
                Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f7889a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.f7891c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f7890b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.f7892d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.f7893e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    bVar.f7894f = jSONObject.optInt("ak_permission");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int unused = PermissionCheck.k = bVar.f7889a;
            if (PermissionCheck.j != null) {
                PermissionCheck.j.a(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7889a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f7890b = "-1";

        /* renamed from: c  reason: collision with root package name */
        public String f7891c = "-1";

        /* renamed from: d  reason: collision with root package name */
        public String f7892d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f7893e;

        /* renamed from: f  reason: collision with root package name */
        public int f7894f;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f7884e), PermissionCheck.f7885f, Integer.valueOf(this.f7889a), this.f7890b, this.f7891c, this.f7892d);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        j = null;
        f7884e = null;
        f7888i = null;
    }

    public static int getPermissionResult() {
        return k;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        f7884e = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f7884e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f7885f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f7886g == null) {
            f7886g = new Hashtable<>();
        }
        if (f7887h == null) {
            f7887h = LBSAuthManager.getInstance(f7884e);
        }
        if (f7888i == null) {
            f7888i = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(f7884e.getPackageName(), 0).applicationInfo.loadLabel(f7884e.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        Bundle b2 = i.b();
        if (b2 != null) {
            f7886g.put("mb", b2.getString("mb"));
            f7886g.put(IAdRequestParam.OS, b2.getString(IAdRequestParam.OS));
            f7886g.put("sv", b2.getString("sv"));
            f7886g.put("imt", "1");
            f7886g.put("net", b2.getString("net"));
            f7886g.put("cpu", b2.getString("cpu"));
            f7886g.put("glr", b2.getString("glr"));
            f7886g.put("glv", b2.getString("glv"));
            f7886g.put("resid", b2.getString("resid"));
            f7886g.put("appid", "-1");
            f7886g.put("ver", "1");
            f7886g.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
            f7886g.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
            f7886g.put("pcn", b2.getString("pcn"));
            f7886g.put("cuid", b2.getString("cuid"));
            f7886g.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f7887h != null && f7888i != null && f7884e != null) {
                int authenticate = f7887h.authenticate(false, "lbs_androidmapsdk", f7886g, f7888i);
                if (authenticate != 0) {
                    String str = f7883d;
                    Log.e(str, "permission check result is: " + authenticate);
                }
                return authenticate;
            }
            String str2 = f7883d;
            Log.e(str2, "The authManager is: " + f7887h + "; the authCallback is: " + f7888i + "; the mContext is: " + f7884e);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        j = cVar;
    }
}
