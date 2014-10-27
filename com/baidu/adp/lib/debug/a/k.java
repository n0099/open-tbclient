package com.baidu.adp.lib.debug.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends a implements Runnable {
    private l gA;
    private Process gw;
    private InputStream gx;
    private OutputStream gy;
    public static String gz = "logcat ";
    private static Map<String, com.baidu.adp.lib.debug.b> gB = new HashMap();

    public static void a(String str, com.baidu.adp.lib.debug.b bVar) {
        gB.put(str, bVar);
        gz = String.valueOf(gz) + " -s " + str;
    }

    public void O(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, com.baidu.adp.lib.debug.b>> it = gB.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, com.baidu.adp.lib.debug.b> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().K(split[i2]);
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
        super.start();
        try {
            Runtime.getRuntime().exec("logcat -c");
            this.gw = Runtime.getRuntime().exec(gz);
            this.gy = this.gw.getOutputStream();
            this.gx = this.gw.getInputStream();
            cL();
            this.gy.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void cL() {
        this.gA = new l(this, this.gx);
        this.gA.start();
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void stop() {
        super.stop();
        try {
            if (this.gw != null) {
                this.gw.destroy();
            }
            if (this.gA != null) {
                this.gA.finish();
            }
            if (this.gx != null) {
                this.gx.close();
            }
            if (this.gy != null) {
                this.gy.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
