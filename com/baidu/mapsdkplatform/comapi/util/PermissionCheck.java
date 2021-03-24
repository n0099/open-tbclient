package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PermissionCheck {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7852a = "PermissionCheck";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7853b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f7854c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Hashtable<String, String> f7855d = null;

    /* renamed from: e  reason: collision with root package name */
    public static LBSAuthManager f7856e = null;

    /* renamed from: f  reason: collision with root package name */
    public static LBSAuthManagerListener f7857f = null;

    /* renamed from: g  reason: collision with root package name */
    public static c f7858g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7859h = 601;

    /* loaded from: classes2.dex */
    public static class a implements LBSAuthManagerListener {
        public a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f7852a, "The result is null");
                int permissionCheck = PermissionCheck.permissionCheck();
                String str2 = PermissionCheck.f7852a;
                Log.d(str2, "onAuthResult try permissionCheck result is: " + permissionCheck);
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.f7860a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.f7862c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    bVar.f7861b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    bVar.f7863d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.f7864e = jSONObject.optString("token");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            int unused = PermissionCheck.f7859h = bVar.f7860a;
            if (PermissionCheck.f7858g != null) {
                PermissionCheck.f7858g.a(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7860a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f7861b = "-1";

        /* renamed from: c  reason: collision with root package name */
        public String f7862c = "-1";

        /* renamed from: d  reason: collision with root package name */
        public String f7863d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f7864e;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f7853b), PermissionCheck.f7854c, Integer.valueOf(this.f7860a), this.f7861b, this.f7862c, this.f7863d);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(b bVar);
    }

    public static void destory() {
        f7858g = null;
        f7853b = null;
        f7857f = null;
    }

    public static int getPermissionResult() {
        return f7859h;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        f7853b = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f7853b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f7854c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f7855d == null) {
            f7855d = new Hashtable<>();
        }
        if (f7856e == null) {
            f7856e = LBSAuthManager.getInstance(f7853b);
        }
        if (f7857f == null) {
            f7857f = new a();
        }
        try {
            str = context.getPackageManager().getPackageInfo(f7853b.getPackageName(), 0).applicationInfo.loadLabel(f7853b.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str = "";
        }
        Bundle b2 = f.b();
        if (b2 != null) {
            f7855d.put("mb", b2.getString("mb"));
            f7855d.put(IXAdRequestInfo.OS, b2.getString(IXAdRequestInfo.OS));
            f7855d.put("sv", b2.getString("sv"));
            f7855d.put("imt", "1");
            f7855d.put("net", b2.getString("net"));
            f7855d.put("cpu", b2.getString("cpu"));
            f7855d.put("glr", b2.getString("glr"));
            f7855d.put("glv", b2.getString("glv"));
            f7855d.put("resid", b2.getString("resid"));
            f7855d.put("appid", "-1");
            f7855d.put("ver", "1");
            f7855d.put("screen", String.format("(%d,%d)", Integer.valueOf(b2.getInt("screen_x")), Integer.valueOf(b2.getInt("screen_y"))));
            f7855d.put("dpi", String.format("(%d,%d)", Integer.valueOf(b2.getInt("dpi_x")), Integer.valueOf(b2.getInt("dpi_y"))));
            f7855d.put("pcn", b2.getString("pcn"));
            f7855d.put("cuid", b2.getString("cuid"));
            f7855d.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f7856e != null && f7857f != null && f7853b != null) {
                int authenticate = f7856e.authenticate(false, "lbs_androidsdk", f7855d, f7857f);
                if (authenticate != 0) {
                    String str = f7852a;
                    Log.e(str, "permission check result is: " + authenticate);
                }
                return authenticate;
            }
            String str2 = f7852a;
            Log.e(str2, "The authManager is: " + f7856e + "; the authCallback is: " + f7857f + "; the mContext is: " + f7853b);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(c cVar) {
        f7858g = cVar;
    }
}
