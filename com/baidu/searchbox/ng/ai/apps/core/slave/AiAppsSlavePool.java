package com.baidu.searchbox.ng.ai.apps.core.slave;

import android.app.Activity;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebPageCallback;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class AiAppsSlavePool {
    private static final boolean DEBUG = false;
    private static final int MAX_PRELOAD_MANAGERS = 2;
    public static final int PRELOAD_NEXT_DELAY_MS = 600;
    public static final String TAG = "AiAppsSlavePool";
    private static LinkedList<PreloadSlaveManager> sPreloadManagers = new LinkedList<>();
    private static Map<String, AiAppsSlaveManager> sAvailableManagers = new TreeMap();

    /* loaded from: classes2.dex */
    public static class PreloadSlaveManager {
        public final ArrayList<PreloadStatusCallback> callbacks = new ArrayList<>();
        public boolean isReady;
        public AiAppsSlaveManager slaveManager;
    }

    /* loaded from: classes2.dex */
    public interface PreloadStatusCallback {
        void onReady();
    }

    public static void preloadSlaveManager(Activity activity) {
        if (activity != null && !activity.isFinishing() && sPreloadManagers.size() < 2) {
            sPreloadManagers.add(createNewPreloadManager(activity));
        }
    }

    public static void preloadSlaveManager(final Activity activity, long j) {
        AiAppsUtils.postOnUi(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsSlavePool.preloadSlaveManager(activity);
            }
        }, j);
    }

    public static PreloadSlaveManager getPreloadSlaveManager(Activity activity) {
        if (sPreloadManagers.isEmpty()) {
            return createNewPreloadManager(activity);
        }
        PreloadSlaveManager removeFirst = sPreloadManagers.removeFirst();
        AiAppsUtils.postOnUi(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.2
            @Override // java.lang.Runnable
            public void run() {
                AiAppsSlavePool.preloadSlaveManager(AiAppsController.getInstance().getActivity());
            }
        }, 600L);
        return removeFirst;
    }

    public static void requestPreloadOnReady(PreloadSlaveManager preloadSlaveManager, PreloadStatusCallback preloadStatusCallback) {
        if (preloadStatusCallback != null) {
            if (preloadSlaveManager.isReady) {
                preloadStatusCallback.onReady();
            } else {
                preloadSlaveManager.callbacks.add(preloadStatusCallback);
            }
        }
    }

    private static PreloadSlaveManager createNewPreloadManager(Activity activity) {
        final PreloadSlaveManager preloadSlaveManager = new PreloadSlaveManager();
        preloadSlaveManager.isReady = false;
        preloadSlaveManager.slaveManager = AiAppsCoreRuntime.getInstance().prepareSlave(activity, new AiAppsWebPageCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.3
            @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebPageCallback
            public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
                PreloadSlaveManager.this.isReady = true;
                if (!PreloadSlaveManager.this.callbacks.isEmpty()) {
                    Iterator<PreloadStatusCallback> it = PreloadSlaveManager.this.callbacks.iterator();
                    while (it.hasNext()) {
                        PreloadStatusCallback next = it.next();
                        if (next != null) {
                            next.onReady();
                        }
                    }
                    PreloadSlaveManager.this.callbacks.clear();
                }
            }
        });
        return preloadSlaveManager;
    }

    public static void putSlaveManager(String str, AiAppsSlaveManager aiAppsSlaveManager) {
        sAvailableManagers.put(str, aiAppsSlaveManager);
    }

    public static AiAppsSlaveManager getSlaveManager(String str) {
        AiAppsSlaveManager aiAppsSlaveManager = sAvailableManagers.get(str);
        if (aiAppsSlaveManager != null) {
            sAvailableManagers.remove(str);
        }
        return aiAppsSlaveManager;
    }

    public static void clearAll() {
        sPreloadManagers.clear();
        sAvailableManagers.clear();
    }
}
