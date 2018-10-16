package com.baidu.searchbox.ng.ai.apps.launch;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppsLaunchStatusTransfer {
    private static AiAppsLaunchStatusTransfer sInstance;
    private List<AiAppsApsStatusListener> mListenerList = new ArrayList();

    /* loaded from: classes2.dex */
    public interface AiAppsApsStatusListener {
        boolean onLaunchFailed();

        boolean onLaunchReady();
    }

    private AiAppsLaunchStatusTransfer() {
    }

    public static AiAppsLaunchStatusTransfer getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsLaunchStatusTransfer.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsLaunchStatusTransfer();
                }
            }
        }
        return sInstance;
    }

    public void registerStatusListener(AiAppsApsStatusListener aiAppsApsStatusListener) {
        if (aiAppsApsStatusListener != null && !this.mListenerList.contains(aiAppsApsStatusListener)) {
            this.mListenerList.add(aiAppsApsStatusListener);
        }
    }

    public void removeStatusListener(AiAppsApsStatusListener aiAppsApsStatusListener) {
        if (aiAppsApsStatusListener != null) {
            this.mListenerList.remove(aiAppsApsStatusListener);
        }
    }

    public void onLaunchReady() {
        for (AiAppsApsStatusListener aiAppsApsStatusListener : this.mListenerList) {
            if (aiAppsApsStatusListener != null && aiAppsApsStatusListener.onLaunchReady()) {
                return;
            }
        }
    }

    public void onLaunchFailed() {
        for (AiAppsApsStatusListener aiAppsApsStatusListener : this.mListenerList) {
            if (aiAppsApsStatusListener != null && aiAppsApsStatusListener.onLaunchFailed()) {
                return;
            }
        }
    }
}
