package com.baidu.media.ext;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.b;
import com.baidu.media.duplayer.e;
import java.io.File;
@Keep
/* loaded from: classes16.dex */
public class CyberMediaExtLoader {

    /* renamed from: a  reason: collision with root package name */
    private static ClassLoader f2261a = null;

    private static void a(Context context) {
        CyberLog.i("CyberMediaExtInvoker", "tryLoadExtJar isExtJarLoader = " + a.a());
        if (context == null || a.a()) {
            return;
        }
        String str = b.c() + File.separator + "libs";
        File file = new File(e.VB().gj(2048).c());
        if (file == null || !file.exists()) {
            CyberLog.e("CyberMediaExtInvoker", "dexFile = null or dexFile not exist!");
        } else {
            f2261a = new CyberClassLoader(file.getAbsolutePath(), new File(str), null, context.getClassLoader());
        }
    }

    public static synchronized boolean init(Context context) {
        boolean a2;
        synchronized (CyberMediaExtLoader.class) {
            a(context);
            a.b(f2261a);
            a2 = a.a();
        }
        return a2;
    }
}
