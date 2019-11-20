package com.baidu.swan.apps.v.d;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.v.c;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    @NonNull
    public static Uri b(int i, @NonNull String str, @Nullable String str2, @NonNull String str3) {
        Uri build;
        Uri.Builder builder = new Uri.Builder();
        String str4 = "swan";
        switch (i) {
            case 0:
                str4 = "swan";
                break;
            case 1:
                str4 = "swangame";
                break;
        }
        builder.scheme(SchemeConfig.getSchemeHead()).authority(str4).path(str);
        String fL = fL(str2);
        if (TextUtils.isEmpty(fL)) {
            builder.appendQueryParameter("_baiduboxapp", str3);
            build = builder.build();
        } else if (!fL.contains("?")) {
            builder.appendEncodedPath(fL).appendQueryParameter("_baiduboxapp", str3);
            build = builder.build();
        } else {
            builder.appendEncodedPath(fL);
            Uri.Builder buildUpon = Uri.parse(builder.toString()).buildUpon();
            buildUpon.appendQueryParameter("_baiduboxapp", str3);
            build = buildUpon.build();
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUtils", "generateLaunchScheme: " + build.toString());
        }
        return build;
    }

    public static String fL(String str) {
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll("^//*|/*/$", "");
            if (DEBUG && !TextUtils.equals(str, replaceAll)) {
                Log.d("SwanAppLaunchUtils", "trimHeadAndTailSeparator: before: " + str + "  after: " + replaceAll);
            }
            return replaceAll;
        }
        return str;
    }

    public static boolean Q(@NonNull Context context, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.core.pms.a.Gf()) {
            return c.fq(str);
        }
        return com.baidu.swan.apps.core.a.c.Q(context, str);
    }
}
