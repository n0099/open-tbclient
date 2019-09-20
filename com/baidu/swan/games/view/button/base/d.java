package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.i.a;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
/* loaded from: classes2.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType hI(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String TW() {
        File ae;
        if (com.baidu.swan.apps.ae.b.isDataValid() && com.baidu.swan.apps.ae.b.Mh().getVersion() != null && (ae = a.d.ae(com.baidu.swan.apps.ae.b.Ms(), com.baidu.swan.apps.ae.b.Mh().getVersion())) != null && ae.exists()) {
            return SkiaImageDecoder.FILE_PREFIX + ae.getAbsolutePath();
        }
        return null;
    }
}
