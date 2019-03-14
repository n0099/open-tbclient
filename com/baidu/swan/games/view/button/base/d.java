package com.baidu.swan.games.view.button.base;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.games.i.a;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
/* loaded from: classes2.dex */
public class d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static PathType gY(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return PathType.NETWORK;
        }
        return PathType.RELATIVE;
    }

    public static String PG() {
        File ah;
        if (com.baidu.swan.apps.ae.b.isDataValid() && com.baidu.swan.apps.ae.b.IX().getVersion() != null && (ah = a.c.ah(com.baidu.swan.apps.ae.b.Ji(), com.baidu.swan.apps.ae.b.IX().getVersion())) != null && ah.exists()) {
            return SkiaImageDecoder.FILE_PREFIX + ah.getAbsolutePath();
        }
        return null;
    }
}
