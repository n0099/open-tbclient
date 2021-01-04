package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class PermissionCheck {
    private static Context e;
    private static String f;
    private static Hashtable<String, String> g;
    private static final String d = PermissionCheck.class.getSimpleName();
    private static LBSAuthManager h = null;
    private static LBSAuthManagerListener i = null;
    private static c j = null;
    private static int k = 601;

    /* renamed from: a  reason: collision with root package name */
    public static int f3206a = 200;

    /* renamed from: b  reason: collision with root package name */
    public static int f3207b = 202;
    public static int c = GDiffPatcher.COPY_INT_UBYTE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements LBSAuthManagerListener {
        private a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.d, "The result is null");
                Log.d(PermissionCheck.d, "onAuthResult try permissionCheck result is: " + PermissionCheck.permissionCheck());
                return;
            }
            Log.e(PermissionCheck.d, "The onAuthResult is " + str);
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f3208a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f3209b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    bVar.f = jSONObject.optInt("ak_permission");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int unused = PermissionCheck.k = bVar.f3208a;
            if (PermissionCheck.j != null) {
                PermissionCheck.j.a(bVar);
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3208a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f3209b = "-1";
        public String c = "-1";
        public String d = "";
        public String e;
        public int f;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.e), PermissionCheck.f, Integer.valueOf(this.f3208a), this.f3209b, this.c, this.d);
        }
    }

    /* loaded from: classes15.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        j = null;
        e = null;
        i = null;
    }

    public static int getPermissionResult() {
        return k;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        e = context;
        try {
            applicationInfo = e.getPackageManager().getApplicationInfo(e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (g == null) {
            g = new Hashtable<>();
        }
        if (h == null) {
            h = LBSAuthManager.getInstance(e);
        }
        if (i == null) {
            i = new a();
        }
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            JSONObject jSONObject = new JSONObject(h.b());
            g.put("mb", jSONObject.optString("mb"));
            g.put("os", jSONObject.optString("os"));
            g.put("sv", jSONObject.optString("sv"));
            g.put("imt", "1");
            g.put("net", jSONObject.optString("net"));
            g.put("cpu", jSONObject.optString("cpu"));
            g.put("glr", jSONObject.optString("glr"));
            g.put("glv", jSONObject.optString("glv"));
            g.put("resid", jSONObject.optString("resid"));
            g.put("appid", "-1");
            g.put("ver", "1");
            g.put("screen", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("screen_x")), Integer.valueOf(jSONObject.optInt("screen_y"))));
            g.put("dpi", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("dpi_x")), Integer.valueOf(jSONObject.optInt("dpi_y"))));
            g.put("pcn", jSONObject.optString("pcn"));
            g.put("cuid", jSONObject.optString("cuid"));
            g.put("name", str);
        } catch (Exception e4) {
        }
    }

    public static synchronized int permissionCheck() {
        int i2 = 0;
        synchronized (PermissionCheck.class) {
            if (h == null || i == null || e == null) {
                Log.e(d, "The authManager is: " + h + "; the authCallback is: " + i + "; the mContext is: " + e);
            } else {
                i2 = h.authenticate(false, "lbs_androidmapsdk", g, i);
                if (i2 != 0) {
                    Log.e(d, "permission check result is: " + i2);
                }
            }
        }
        return i2;
    }

    public static void setPermissionCheckResultListener(c cVar) {
        j = cVar;
    }
}
