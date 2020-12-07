package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes25.dex */
public class e {
    private static volatile e dbE;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> dbF = new HashMap();

    private e() {
    }

    public static e ayl() {
        if (dbE == null) {
            synchronized (e.class) {
                if (dbE == null) {
                    dbE = new e();
                }
            }
        }
        return dbE;
    }

    public synchronized void pf(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.dbF.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (dbE != null) {
            dbE.onRelease();
        }
        dbE = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.dbF.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.dbF.clear();
    }
}
