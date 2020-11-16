package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class e {
    private static volatile e cUI;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> cUJ = new HashMap();

    private e() {
    }

    public static e avd() {
        if (cUI == null) {
            synchronized (e.class) {
                if (cUI == null) {
                    cUI = new e();
                }
            }
        }
        return cUI;
    }

    public synchronized void oy(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.cUJ.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (cUI != null) {
            cUI.onRelease();
        }
        cUI = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.cUJ.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.cUJ.clear();
    }
}
