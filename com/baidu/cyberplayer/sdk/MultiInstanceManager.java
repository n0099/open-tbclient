package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes3.dex */
public class MultiInstanceManager {
    public static volatile MediaInstanceManagerProvider sInstanceManager;

    public static MediaInstanceManagerProvider getInstance() {
        if (sInstanceManager == null) {
            synchronized (MediaInstanceManagerProvider.class) {
                if (sInstanceManager == null && CyberPlayerCoreInvoker.isLoaded(1)) {
                    sInstanceManager = CyberPlayerCoreInvoker.createInstanceManager();
                }
            }
        }
        return sInstanceManager;
    }
}
