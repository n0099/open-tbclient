package com.baidu.adp.lib.debug.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static String f393a = "logcat ";
    private static Map f = new HashMap();
    private Process b;
    private InputStream c;
    private OutputStream d;
    private k e;

    public static void a(String str, com.baidu.adp.lib.debug.a aVar) {
        f.put(str, aVar);
        f393a = String.valueOf(f393a) + " -s " + str;
    }

    public void a(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator it = f.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (split[i2].contains(entry.getKey().toString())) {
                        ((com.baidu.adp.lib.debug.a) entry.getValue()).a(split[i2]);
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        super.b();
        try {
            Runtime.getRuntime().exec("logcat -c");
            this.b = Runtime.getRuntime().exec(f393a);
            this.d = this.b.getOutputStream();
            this.c = this.b.getInputStream();
            d();
            this.d.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        this.e = new k(this, this.c);
        this.e.start();
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void c() {
        super.c();
        try {
            if (this.b != null) {
                this.b.destroy();
            }
            this.e.a();
            this.c.close();
            this.d.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
