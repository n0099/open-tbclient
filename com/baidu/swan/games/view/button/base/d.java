package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.l.a;
import java.io.File;
/* loaded from: classes11.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType oY(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String aEa() {
        File bm;
        e apE = com.baidu.swan.apps.runtime.d.apI().apE();
        if (apE.available() && apE.getVersion() != null && (bm = a.c.bm(apE.getAppId(), apE.getVersion())) != null && bm.exists()) {
            return "file://" + bm.getAbsolutePath();
        }
        return null;
    }
}
