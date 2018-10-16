package com.baidu.searchbox.ng.aiapps.menu;
/* loaded from: classes2.dex */
public class AiAppMenuFactoryInit {
    public static AiAppMenuListenerFactory mListenerFactory;

    public static synchronized void setListenerFactory(AiAppMenuListenerFactory aiAppMenuListenerFactory) {
        synchronized (AiAppMenuFactoryInit.class) {
            if (mListenerFactory == null) {
                mListenerFactory = aiAppMenuListenerFactory;
            }
        }
    }
}
