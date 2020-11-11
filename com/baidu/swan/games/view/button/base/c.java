package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.l.a;
import java.io.File;
/* loaded from: classes10.dex */
public class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType tx(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String aYy() {
        File bN;
        e aHm = d.aHq().aHm();
        if (aHm.available() && aHm.getVersion() != null && (bN = a.c.bN(aHm.getAppId(), aHm.getVersion())) != null && bN.exists()) {
            return "file://" + bN.getAbsolutePath();
        }
        return null;
    }
}
