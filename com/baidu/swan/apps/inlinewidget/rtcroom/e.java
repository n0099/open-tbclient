package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public class e {
    private static volatile e cWs;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> cWt = new HashMap();

    private e() {
    }

    public static e avL() {
        if (cWs == null) {
            synchronized (e.class) {
                if (cWs == null) {
                    cWs = new e();
                }
            }
        }
        return cWs;
    }

    public synchronized void oE(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.cWt.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (cWs != null) {
            cWs.onRelease();
        }
        cWs = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.cWt.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.cWt.clear();
    }
}
