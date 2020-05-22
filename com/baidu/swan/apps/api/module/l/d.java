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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static JSONObject bMO;

    public static synchronized void UF() {
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "release cache system info");
            }
            bMO = null;
        }
    }

    @Nullable
    public static synchronized void bp(Context context) {
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "start pre cache");
            }
            if (com.baidu.swan.apps.u.a.aeU().Ry()) {
                if (bMO == null && context != null) {
                    if (DEBUG) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    bMO = br(context);
                }
                if (DEBUG) {
                    Log.d("SystemInfoCacheHelper", "end pre cache system info");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static synchronized JSONObject bq(Context context) {
        JSONObject jSONObject;
        synchronized (d.class) {
            if (bMO == null && context != null) {
                if (DEBUG) {
                    Log.d("SystemInfoCacheHelper", "need create system info");
                }
                bMO = br(context);
            }
            if (DEBUG) {
                Log.d("SystemInfoCacheHelper", "return cache system info");
            }
            jSONObject = bMO;
        }
        return jSONObject;
    }

    public static JSONObject br(@NonNull Context context) {
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
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, b(configuration));
            jSONObject.put("version", aj.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", "android");
            jSONObject.put("fontSizeSetting", com.baidu.swan.apps.u.a.afd().SJ());
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            jSONObject.put("host", com.baidu.swan.apps.u.a.afB().getHostName());
            jSONObject.put("statusBarHeight", ag.D(ag.getStatusBarHeight()));
            jSONObject.put("navigationBarHeight", ag.D(ag.getActionBarHeight()));
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
