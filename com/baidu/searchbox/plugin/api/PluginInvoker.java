package com.baidu.searchbox.plugin.api;

import android.content.Context;
/* loaded from: classes.dex */
public final class PluginInvoker {
    public static final String IMPL_CLASS_NAME = ".PluginInvoker";

    private PluginInvoker() {
    }

    public static void invokePlugin(Context context, String str, String str2, String str3, String str4, InvokeCallback invokeCallback, InvokeListener[] invokeListenerArr) {
    }

    public static void invokeHost(int i, String str, Class<?>[] clsArr, Object[] objArr, String str2, HostInvokeCallback hostInvokeCallback) {
    }

    /* loaded from: classes.dex */
    public final class HostManager {
        public static final int DOWNLOAD_RECEIVER = 1;
        public static final int LOCATION_RECEIVER = 3;
        public static final int LOGIN_RECEIVER = 2;
        public static final int SHARE_RECEIVER = 4;
        public static final int UTILITY_RECEIVER = 6;
        public static final int WEBAPP_RECEIVER = 5;

        private HostManager() {
        }
    }
}
