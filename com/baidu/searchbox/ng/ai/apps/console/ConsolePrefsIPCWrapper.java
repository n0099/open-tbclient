package com.baidu.searchbox.ng.ai.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.AiAppSharedPrefsWrapper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppSha256Utils;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes2.dex */
public class ConsolePrefsIPCWrapper {
    private static final String BUNDLE_KEY = "key";
    private static final String BUNDLE_VALUE = "value";
    public static final String CONSOLE_SWITCH = "consoleSwitch";

    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            ConsolePrefsWrapper.getInstance().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), ConsoleSpDelegation.class, createParams(str, z));
        }
    }

    public static void saveConsoleSwitch(boolean z) {
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            putBoolean(buildConsoleSpKey(aiApp.getAppKey()), z);
        }
    }

    public static boolean getConsoleSwitch(String str) {
        return !TextUtils.isEmpty(str) && ConsolePrefsWrapper.getInstance().getBoolean(buildConsoleSpKey(str), false);
    }

    private static String buildConsoleSpKey(String str) {
        String uid = AiAppsRuntime.getAiAppAccountRuntime().getUid(AiAppsRuntime.getAppContext());
        return CONSOLE_SWITCH + str + (TextUtils.isEmpty(uid) ? "" : AiAppSha256Utils.toHash(uid.getBytes(), false));
    }

    public static Bundle createParams(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putBoolean("value", z);
        return bundle;
    }

    /* loaded from: classes2.dex */
    public static class ConsolePrefsWrapper extends AiAppSharedPrefsWrapper {
        private static final String CONSOLE_SP_NAME = "searchbox_sconsole_sp";

        private ConsolePrefsWrapper() {
            super(CONSOLE_SP_NAME);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class Holder {
            private static final ConsolePrefsWrapper INSTANCE = new ConsolePrefsWrapper();

            private Holder() {
            }
        }

        public static ConsolePrefsWrapper getInstance() {
            return Holder.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ConsoleSpDelegation extends ProviderDelegation {
        private ConsoleSpDelegation() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            ConsolePrefsWrapper.getInstance().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
