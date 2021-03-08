package com.baidu.swan.apps.event;

import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
@Keep
/* loaded from: classes8.dex */
public class SwanJSVersionUpdateEvent {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = "SwanJSVersionUpdateEven";
    private final long mVersionNum;
    private final String mVersionString;

    private SwanJSVersionUpdateEvent() {
        SwanCoreVersion jD = com.baidu.swan.apps.swancore.b.jD(0);
        if (jD != null) {
            this.mVersionNum = jD.swanCoreVersion;
            this.mVersionString = com.baidu.swan.apps.swancore.b.cY(this.mVersionNum);
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
            com.baidu.swan.apps.t.a.axI().a(swanJSVersionUpdateEvent);
            if (DEBUG) {
                Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionString() + "(" + swanJSVersionUpdateEvent.getVersionNum() + ")");
            }
        }
    }
}
