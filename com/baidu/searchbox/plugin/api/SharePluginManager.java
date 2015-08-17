package com.baidu.searchbox.plugin.api;
/* loaded from: classes.dex */
public class SharePluginManager {
    public static final int BROWSER_LIGHT = 1;
    public static final int BROWSER_MAIN = 0;

    /* loaded from: classes.dex */
    public interface PluginShareResultListener {
        void onCancel(String str);

        void onComplete(String str);

        void onError(String str);

        void onItemClicked(String str);
    }
}
