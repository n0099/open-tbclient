package com.baidu.searchbox.ng.ai.apps.swancore.preset;

import com.baidu.searchbox.ng.ai.apps.swancore.callback.OnSwanCoreUpdateCallback;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class PresetSwanCoreUpdater {
    private static final boolean DEBUG = false;
    private static final String TAG = "PresetSwanCoreUpdater";
    public static volatile PresetSwanCoreUpdater sInstance;
    private ArrayList<OnSwanCoreUpdateCallback> mCallbacks = new ArrayList<>();

    public static PresetSwanCoreUpdater getInstance() {
        if (sInstance == null) {
            synchronized (PresetSwanCoreUpdater.class) {
                if (sInstance == null) {
                    sInstance = new PresetSwanCoreUpdater();
                }
            }
        }
        return sInstance;
    }

    public void updateSwanCoreAsync(OnSwanCoreUpdateCallback onSwanCoreUpdateCallback) {
        synchronized (PresetSwanCoreUpdater.class) {
            if (!PresetSwanCoreControl.isNeedUpdateStatus()) {
                notifyCallback(onSwanCoreUpdateCallback);
                return;
            }
            if (this.mCallbacks.isEmpty()) {
                new Thread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PresetSwanCoreControl.onPresetUpdate();
                        PresetSwanCoreUpdater.this.notifyAllCallbacks();
                    }
                }, "updateSwanCoreAsync").start();
            }
            this.mCallbacks.add(onSwanCoreUpdateCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllCallbacks() {
        synchronized (PresetSwanCoreUpdater.class) {
            Iterator<OnSwanCoreUpdateCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                notifyCallback(it.next());
            }
            this.mCallbacks.clear();
        }
    }

    private void notifyCallback(final OnSwanCoreUpdateCallback onSwanCoreUpdateCallback) {
        if (onSwanCoreUpdateCallback != null) {
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreUpdater.2
                @Override // java.lang.Runnable
                public void run() {
                    onSwanCoreUpdateCallback.onUpdateFinished();
                }
            });
        }
    }
}
