package com.baidu.graph.sdk.framework.bdbox;
/* loaded from: classes3.dex */
public class SharePluginManager {
    public static final int BROWSER_LIGHT = 1;
    public static final int BROWSER_MAIN = 0;

    /* loaded from: classes3.dex */
    public interface PluginShareResultListener {
        void onCancel(String str);

        void onComplete(String str);

        void onError(String str);

        void onItemClicked(String str);
    }
}
