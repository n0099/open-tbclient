package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject bYc;

    public static synchronized void acy() {
        synchronized (e.class) {
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "release cache system info");
            }
            bYc = null;
        }
    }

    @Nullable
    public static synchronized void bA(Context context) {
        synchronized (e.class) {
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "start pre cache");
            }
            if (com.baidu.swan.apps.t.a.aoM().YP()) {
                if (bYc == null && context != null) {
                    if (DEBUG) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    bYc = bC(context);
                }
                if (DEBUG) {
                    Log.d("SystemInfoCacheHelper", "end pre cache system info");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static synchronized JSONObject bB(Context context) {
        JSONObject jSONObject;
        synchronized (e.class) {
            if (bYc == null && context != null) {
                if (DEBUG) {
                    Log.d("SystemInfoCacheHelper", "need create system info");
                }
                bYc = bC(context);
            }
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "return cache system info");
            }
            jSONObject = bYc;
        }
        return jSONObject;
    }

    public static JSONObject bC(@NonNull Context context) {
        if (DEBUG) {
            Log.d("SystemInfoCacheHelper", "start create System Info");
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("language", b(configuration));
            jSONObject.put("version", ak.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", "android");
            jSONObject.put("fontSizeSetting", com.baidu.swan.apps.t.a.aoV().aao());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            jSONObject.put("host", com.baidu.swan.apps.t.a.apw().getHostName());
            jSONObject.put("statusBarHeight", ah.J(ah.getStatusBarHeight()));
            jSONObject.put("navigationBarHeight", ah.J(ah.getActionBarHeight()));
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "end create System Info");
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "crate system info error : ");
                e.printStackTrace();
            }
            return null;
        }
    }

    private static String b(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 21) {
            return configuration.locale.toString();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }
}
