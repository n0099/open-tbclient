package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private static volatile e cvW;
    private Map<String, com.baidu.swan.apps.inlinewidget.rtcroom.c.b> cvX = new HashMap();

    private e() {
    }

    public static e aoE() {
        if (cvW == null) {
            synchronized (e.class) {
                if (cvW == null) {
                    cvW = new e();
                }
            }
        }
        return cvW;
    }

    public synchronized void nj(String str) {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.cvX.values()).iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar = (com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next();
            if (TextUtils.equals(bVar.getSlaveId(), str)) {
                bVar.onRelease();
            }
        }
    }

    public static void release() {
        if (cvW != null) {
            cvW.onRelease();
        }
        cvW = null;
    }

    private synchronized void onRelease() {
        com.baidu.swan.apps.console.c.i("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.cvX.values()).iterator();
        while (it.hasNext()) {
            ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) it.next()).onRelease();
        }
        this.cvX.clear();
    }
}
