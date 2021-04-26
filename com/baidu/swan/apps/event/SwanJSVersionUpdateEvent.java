package com.baidu.swan.apps.event;

import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.b2.b;
import d.a.h0.a.k;
import d.a.h0.a.w0.a;
@Keep
/* loaded from: classes2.dex */
public class SwanJSVersionUpdateEvent {
    public static final boolean DEBUG = k.f43101a;
    public static final String TAG = "SwanJSVersionUpdateEven";
    public final long mVersionNum;
    public final String mVersionString;

    public SwanJSVersionUpdateEvent() {
        SwanCoreVersion e2 = b.e(0);
        if (e2 != null) {
            long j = e2.swanCoreVersion;
            this.mVersionNum = j;
            this.mVersionString = b.q(j);
            return;
        }
        this.mVersionNum = 0L;
        this.mVersionString = null;
    }

    public static void sendEvent(long j) {
        SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
        if (swanJSVersionUpdateEvent.mVersionString == null) {
            return;
        }
        a.A().a(swanJSVersionUpdateEvent);
        if (DEBUG) {
            Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionString() + "(" + swanJSVersionUpdateEvent.getVersionNum() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public long getVersionNum() {
        return this.mVersionNum;
    }

    public String getVersionString() {
        return this.mVersionString;
    }
}
