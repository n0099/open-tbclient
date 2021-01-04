package com.baidu.media.ext;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.b;
import com.baidu.media.duplayer.e;
import java.io.File;
@Keep
/* loaded from: classes15.dex */
public class CyberMediaExtLoader {

    /* renamed from: a  reason: collision with root package name */
    private static ClassLoader f3248a = null;

    private static void a(Context context) {
        CyberLog.i("CyberMediaExtInvoker", "tryLoadExtJar isExtJarLoader = " + a.a());
        if (context == null || a.a()) {
            return;
        }
        String str = b.c() + File.separator + "libs";
        File file = new File(e.adA().ha(2048).c());
        if (file == null || !file.exists()) {
            CyberLog.e("CyberMediaExtInvoker", "dexFile = null or dexFile not exist!");
        } else {
            f3248a = new CyberClassLoader(file.getAbsolutePath(), new File(str), null, context.getClassLoader());
        }
    }

    public static synchronized boolean init(Context context) {
        boolean a2;
        synchronized (CyberMediaExtLoader.class) {
            a(context);
            a.c(f3248a);
            a2 = a.a();
        }
        return a2;
    }
}
