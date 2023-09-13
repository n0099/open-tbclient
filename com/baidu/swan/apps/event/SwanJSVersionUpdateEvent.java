package com.baidu.swan.apps.event;

import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.mk3;
import com.baidu.tieba.ou2;
import com.baidu.tieba.rr1;
@Keep
/* loaded from: classes4.dex */
public class SwanJSVersionUpdateEvent {
    public static final boolean DEBUG = rr1.a;
    public static final String TAG = "SwanJSVersionUpdateEven";
    public final long mVersionCode;
    public final String mVersionName;

    public SwanJSVersionUpdateEvent() {
        SwanCoreVersion g = mk3.g(0);
        if (g != null) {
            this.mVersionCode = g.swanCoreVersionCode;
            this.mVersionName = g.swanCoreVersionName;
            return;
        }
        this.mVersionCode = 0L;
        this.mVersionName = null;
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public static void sendEvent(long j) {
        SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
        if (swanJSVersionUpdateEvent.mVersionName == null) {
            return;
        }
        ou2.N().a(swanJSVersionUpdateEvent);
        if (DEBUG) {
            Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionName() + "(" + swanJSVersionUpdateEvent.getVersionCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }
}
