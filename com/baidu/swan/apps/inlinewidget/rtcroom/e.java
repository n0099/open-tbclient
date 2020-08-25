package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class e {
    private static volatile e ctO;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> ctP = new HashMap();

    private e() {
    }

    public static e anU() {
        if (ctO == null) {
            synchronized (e.class) {
                if (ctO == null) {
                    ctO = new e();
                }
            }
        }
        return ctO;
    }

    public synchronized void mP(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.ctP.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (ctO != null) {
            ctO.onRelease();
        }
        ctO = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.ctP.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.ctP.clear();
    }
}
