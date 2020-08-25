package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.l.a;
import java.io.File;
/* loaded from: classes8.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType rJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String aQJ() {
        File bB;
        e azA = d.azE().azA();
        if (azA.available() && azA.getVersion() != null && (bB = a.c.bB(azA.getAppId(), azA.getVersion())) != null && bB.exists()) {
            return "file://" + bB.getAbsolutePath();
        }
        return null;
    }
}
