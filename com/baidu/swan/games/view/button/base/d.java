package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.k.a;
import java.io.File;
/* loaded from: classes9.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType lI(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String aof() {
        File aA;
        e ZM = com.baidu.swan.apps.runtime.d.ZP().ZM();
        if (ZM.available() && ZM.getVersion() != null && (aA = a.c.aA(ZM.getAppId(), ZM.getVersion())) != null && aA.exists()) {
            return "file://" + aA.getAbsolutePath();
        }
        return null;
    }
}
