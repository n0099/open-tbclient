package com.baidu.swan.apps.event;

import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.c1.a;
import d.a.i0.a.k;
import d.a.i0.a.m2.b;
@Keep
/* loaded from: classes2.dex */
public class SwanJSVersionUpdateEvent {
    public static final boolean DEBUG = k.f43025a;
    public static final String TAG = "SwanJSVersionUpdateEven";
    public final long mVersionCode;
    public final String mVersionName;

    public SwanJSVersionUpdateEvent() {
        SwanCoreVersion g2 = b.g(0);
        if (g2 != null) {
            this.mVersionCode = g2.swanCoreVersionCode;
            this.mVersionName = g2.swanCoreVersionName;
            return;
        }
        this.mVersionCode = 0L;
        this.mVersionName = null;
    }

    public static void sendEvent(long j) {
        SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
        if (swanJSVersionUpdateEvent.mVersionName == null) {
            return;
        }
        a.I().a(swanJSVersionUpdateEvent);
        if (DEBUG) {
            Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionName() + "(" + swanJSVersionUpdateEvent.getVersionCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }
}
