package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public class e {
    private static volatile e cQz;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> cQA = new HashMap();

    private e() {
    }

    public static e atl() {
        if (cQz == null) {
            synchronized (e.class) {
                if (cQz == null) {
                    cQz = new e();
                }
            }
        }
        return cQz;
    }

    public synchronized void oq(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.cQA.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (cQz != null) {
            cQz.onRelease();
        }
        cQz = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.cQA.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.cQA.clear();
    }
}
