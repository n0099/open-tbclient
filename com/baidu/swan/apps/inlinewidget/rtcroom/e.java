package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public class e {
    private static volatile e dgz;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> dgA = new HashMap();

    private e() {
    }

    public static e azC() {
        if (dgz == null) {
            synchronized (e.class) {
                if (dgz == null) {
                    dgz = new e();
                }
            }
        }
        return dgz;
    }

    public synchronized void oY(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.dgA.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (dgz != null) {
            dgz.onRelease();
        }
        dgz = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.dgA.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.dgA.clear();
    }
}
