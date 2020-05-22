package com.baidu.swan.apps.event;

import android.support.annotation.Keep;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
@Keep
/* loaded from: classes11.dex */
public class SwanJSVersionUpdateEvent {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = "SwanJSVersionUpdateEven";
    private final long mVersionNum;
    private final String mVersionString;

    private SwanJSVersionUpdateEvent() {
        SwanCoreVersion ha = com.baidu.swan.apps.swancore.b.ha(0);
        if (ha != null) {
            this.mVersionNum = ha.swanCoreVersion;
            this.mVersionString = com.baidu.swan.apps.swancore.b.bt(this.mVersionNum);
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
            com.baidu.swan.apps.u.a.afy().a(swanJSVersionUpdateEvent);
            if (DEBUG) {
                Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionString() + "(" + swanJSVersionUpdateEvent.getVersionNum() + ")");
            }
        }
    }
}
