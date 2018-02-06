package com.baidu.graph.sdk.framework.bdbox;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.graph.sdk.framework.bdbox.AccountPluginManager;
import com.baidu.graph.sdk.framework.bdbox.SharePluginManager;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public interface IBDBoxPluginInvoker {
    void invokeHost(int i, String str, Class<?>[] clsArr, Object[] objArr, String str2, IBDBoxHostInvokeCallback iBDBoxHostInvokeCallback) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, PluginInvokeException;

    boolean isLogin();

    void login(PluginLoginParams pluginLoginParams, AccountPluginManager.OnPluginLoginResultListener onPluginLoginResultListener);

    void shareSyncForPlugin(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, SharePluginManager.PluginShareResultListener pluginShareResultListener);

    /* loaded from: classes3.dex */
    public static final class HostManager {
        public static final int DOWNLOAD_RECEIVER = 1;
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
