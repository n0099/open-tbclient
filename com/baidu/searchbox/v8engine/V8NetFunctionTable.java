package com.baidu.searchbox.v8engine;

import android.webkit.ValueCallback;
import com.baidu.smallgame.sdk.Log;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes3.dex */
public class V8NetFunctionTable {
    public static final String TAG = "V8NetFunctionTable";
    public static long sNativeGlobalFunctionTablePointer;
    public static final List<ValueCallback<Long>> sV8NetFunctionTableInitListenerList = new ArrayList();

    public static void addOnCronetThreadInitializedListenerForT7() {
        try {
            Class.forName("com.baidu.webkit.internal.ApisInteractWithMario").getDeclaredMethod("addOnCronetThreadInitializedListener", ValueCallback.class).invoke(null, new ValueCallback<Long>() { // from class: com.baidu.searchbox.v8engine.V8NetFunctionTable.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Long l) {
                    Log.i(V8NetFunctionTable.TAG, "[mario-request] Receive global V8NetFunctionTable raw pointer: " + l);
                    if (l != null && l.longValue() != 0) {
                        V8NetFunctionTable.notifyAllV8NetFunctionTableListeners(l.longValue());
                    } else {
                        Log.e(V8NetFunctionTable.TAG, "[mario-request] Failed to notify V8NetFunctionTable listeners, because pointer is null or 0");
                    }
                }
            });
        } catch (Throwable th) {
            Log.w(TAG, th.getMessage(), th);
        }
    }

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        synchronized (sV8NetFunctionTableInitListenerList) {
            if (valueCallback != null) {
                if (sNativeGlobalFunctionTablePointer != 0) {
                    valueCallback.onReceiveValue(Long.valueOf(sNativeGlobalFunctionTablePointer));
                } else {
                    sV8NetFunctionTableInitListenerList.add(valueCallback);
                }
            }
        }
    }

    public static void notifyAllV8NetFunctionTableListeners(long j) {
        synchronized (sV8NetFunctionTableInitListenerList) {
            sNativeGlobalFunctionTablePointer = j;
            for (ValueCallback<Long> valueCallback : sV8NetFunctionTableInitListenerList) {
                valueCallback.onReceiveValue(Long.valueOf(j));
            }
            sV8NetFunctionTableInitListenerList.clear();
        }
    }

    public static void removeOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        synchronized (sV8NetFunctionTableInitListenerList) {
            sV8NetFunctionTableInitListenerList.remove(valueCallback);
        }
    }
}
