package com.baidu.adp.lib.debug.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class j extends a implements Runnable {
    public static String a = "logcat ";
    private static Map<String, com.baidu.adp.lib.debug.a> f = new HashMap();
    private Process b;
    private InputStream c;
    private OutputStream d;
    private k e;

    public static void a(String str, com.baidu.adp.lib.debug.a aVar) {
        f.put(str, aVar);
        a = String.valueOf(a) + " -s " + str;
    }

    public void a(String str) {
        String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, com.baidu.adp.lib.debug.a>> it = f.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, com.baidu.adp.lib.debug.a> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().a(split[i2]);
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
            this.b = Runtime.getRuntime().exec(a);
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
            if (this.e != null) {
                this.e.a();
            }
            if (this.c != null) {
                this.c.close();
            }
            if (this.d != null) {
                this.d.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
