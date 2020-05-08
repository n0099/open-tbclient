package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.k.a;
import java.io.File;
/* loaded from: classes11.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType nm(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String azc() {
        File aT;
        e akG = com.baidu.swan.apps.runtime.d.akJ().akG();
        if (akG.available() && akG.getVersion() != null && (aT = a.c.aT(akG.getAppId(), akG.getVersion())) != null && aT.exists()) {
            return "file://" + aT.getAbsolutePath();
        }
        return null;
    }
}
