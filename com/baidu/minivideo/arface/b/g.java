package com.baidu.minivideo.arface.b;

import android.util.Log;
import java.io.File;
/* loaded from: classes8.dex */
public class g {
    private static g ceC;
    private Boolean ceD;

    public static g acA() {
        if (ceC == null) {
            createInst();
        }
        return ceC;
    }

    private static synchronized void createInst() {
        synchronized (g.class) {
            if (ceC == null) {
                ceC = new g();
            }
        }
    }

    private g() {
    }

    private boolean acB() {
        String str;
        boolean z = false;
        if (this.ceD == null) {
            this.ceD = false;
            try {
                String[] list = com.baidu.minivideo.arface.b.getContext().getAssets().list("arsource");
                if (list != null && list.length > 0) {
                    z = true;
                }
                this.ceD = Boolean.valueOf(z);
                if (com.baidu.minivideo.arface.b.isDebug()) {
                    if (list == null) {
                        str = "null";
                    } else {
                        str = "" + list.length;
                    }
                    d("hasAssetsResource: " + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.ceD.booleanValue();
    }

    public File acC() {
        File acm;
        boolean z = com.baidu.minivideo.arface.b.abZ() && acB();
        if (z) {
            acm = e.acv().acw();
        } else {
            acm = b.jP(com.baidu.minivideo.arface.b.aca()).acm();
        }
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("sdkPath useLocal " + z + ", SDKPath " + acm);
        }
        return acm;
    }

    private static void d(String str) {
        Log.e("DuAr_SDKLoader", "ar->" + str);
    }
}
