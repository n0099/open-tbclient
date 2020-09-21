package com.baidu.swan.apps.event;

import android.support.annotation.Keep;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
@Keep
/* loaded from: classes3.dex */
public class SwanJSVersionUpdateEvent {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = "SwanJSVersionUpdateEven";
    private final long mVersionNum;
    private final String mVersionString;

    private SwanJSVersionUpdateEvent() {
        SwanCoreVersion jO = com.baidu.swan.apps.swancore.b.jO(0);
        if (jO != null) {
            this.mVersionNum = jO.swanCoreVersion;
            this.mVersionString = com.baidu.swan.apps.swancore.b.bM(this.mVersionNum);
            return;
        }
        this.mVersionNum = 0L;
        this.mVersionString = null;
    }

    public long getVersionNum() {
        return this.mVersionNum;
    }

    public String getVersionString() {
        return this.mVersionString;
    }

    public static void sendEvent(long j) {
        SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
        if (swanJSVersionUpdateEvent.mVersionString != null) {
            com.baidu.swan.apps.t.a.aqd().a(swanJSVersionUpdateEvent);
            if (DEBUG) {
                Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionString() + "(" + swanJSVersionUpdateEvent.getVersionNum() + ")");
            }
        }
    }
}
