package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.k.a;
import java.io.File;
/* loaded from: classes10.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType lL(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String aoy() {
        File aB;
        e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
        if (aaj.available() && aaj.getVersion() != null && (aB = a.c.aB(aaj.getAppId(), aaj.getVersion())) != null && aB.exists()) {
            return "file://" + aB.getAbsolutePath();
        }
        return null;
    }
}
