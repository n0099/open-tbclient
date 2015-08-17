package com.baidu.searchbox.plugin.api;

import android.content.Context;
/* loaded from: classes.dex */
public final class PluginInvoker {
    public static final String IMPL_CLASS_NAME = ".PluginInvoker";

    private PluginInvoker() {
    }

    public static void invokePlugin(Context context, String str, String str2, String str3, String str4, InvokeCallback invokeCallback, InvokeListener[] invokeListenerArr) {
    }

    public static void urlInvokePlugin(String str, String str2, String str3, InvokeCallback invokeCallback, InvokeListener[] invokeListenerArr) {
    }

    public static void invokeHost(int i, String str, Class<?>[] clsArr, Object[] objArr, String str2, HostInvokeCallback hostInvokeCallback) {
    }

    /* loaded from: classes.dex */
    public static final class HostManager {
        public static final int CARD_RECEIVER = 9;
        public static final int DOWNLOAD_RECEIVER = 1;
        public static final int IM_RECEIVER = 11;
        public static final int LIGHTAPP_RECEIVER = 10;
        public static final int LOCATION_RECEIVER = 3;
        public static final int LOGIN_RECEIVER = 2;
        public static final int PAY_RECEIVER = 8;
        public static final int PICTURE_RECEIVER = 7;
        public static final int SHARE_RECEIVER = 4;
        public static final int UTILITY_RECEIVER = 6;
        public static final int WEBAPP_RECEIVER = 5;

        private HostManager() {
        }
    }
}
