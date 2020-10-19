package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public class e {
    private static volatile e cId;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> cIe = new HashMap();

    private e() {
    }

    public static e arq() {
        if (cId == null) {
            synchronized (e.class) {
                if (cId == null) {
                    cId = new e();
                }
            }
        }
        return cId;
    }

    public synchronized void nV(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.cIe.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (cId != null) {
            cId.onRelease();
        }
        cId = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.cIe.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.cIe.clear();
    }
}
