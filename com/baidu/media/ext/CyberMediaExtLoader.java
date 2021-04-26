package com.baidu.media.ext;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.media.duplayer.Keep;
import d.a.w.a.c;
import d.a.w.a.e;
import d.a.w.b.a;
import java.io.File;
@Keep
/* loaded from: classes2.dex */
public class CyberMediaExtLoader {

    /* renamed from: a  reason: collision with root package name */
    public static ClassLoader f8300a;

    public static void a(Context context) {
        CyberLog.i("CyberMediaExtInvoker", "tryLoadExtJar isExtJarLoader = " + a.d());
        if (context == null || a.d()) {
            return;
        }
        String str = c.i() + File.separator + "libs";
        File file = new File(e.b().a(2048).d());
        if (file.exists()) {
            f8300a = new CyberClassLoader(file.getAbsolutePath(), new File(str), null, context.getClassLoader());
        } else {
            CyberLog.e("CyberMediaExtInvoker", "dexFile = null or dexFile not exist!");
        }
    }

    public static synchronized boolean init(Context context) {
        boolean d2;
        synchronized (CyberMediaExtLoader.class) {
            a(context);
            a.e(f8300a);
            d2 = a.d();
        }
        return d2;
    }
}
