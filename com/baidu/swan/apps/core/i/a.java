package com.baidu.swan.apps.core.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.b.c.g;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.facebook.common.internal.h;
import java.net.URISyntaxException;
import java.util.Set;
/* loaded from: classes2.dex */
public class a implements g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aMU = h.J("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX, SkiaImageDecoder.FILE_PREFIX);

    @Override // com.baidu.swan.apps.b.c.g
    public boolean O(@NonNull Context context, String str) {
        return !eF(str) && S(context, str);
    }

    private static boolean S(Context context, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            try {
                if (context instanceof Activity) {
                    if (((Activity) context).startActivityIfNeeded(parseUri, -1)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d("SchemeUrlHandler", Log.getStackTraceString(e));
                }
            }
            return false;
        } catch (URISyntaxException e2) {
            if (DEBUG) {
                Log.d("SchemeUrlHandler", "Bad URI " + str + ": " + e2.getMessage());
            }
            return false;
        }
    }

    private static boolean eF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aMU) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
