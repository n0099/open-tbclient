package com.baidu.searchbox.ng.ai.apps.swancore;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.b.a.b;
import com.baidu.b.a.e.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.swancore.remote.RemoteSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.swancore.remote.SwanCoreDynamicCallback;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class AiAppsSwanCoreManager {
    private static final boolean DEBUG = false;
    public static final String KEY_AIAPP_DEBUG_SWAN_CORE_MODE = "KEY_AIAPP_DEBUG_SWAN_CORE_MODE";
    private static final String PKG_NAME_PREVIEW = "com.baidu.searchbox.smartapp";
    public static final String SWAN_CORE_DIR_NAME = "swan_core";
    public static final String SWAN_VERSION_FOR_CORE_UPDATE = "1.6.0";
    private static final String TAG = "AiAppsSwanCoreManager";
    public static final long VERSION_DEFAULT = 0;
    private static final int VERSION_DIGIT_NUM = 3;
    private static final int VERSION_LEFT_SHIFT_NUM = 16;
    private static final int VERSION_MASK_VALUE = 65535;
    private static final String VERSION_SPLIT_REGEX = "\\.";
    private static final String VERSION_SPLIT_STRING = ".";

    public static void requestUpdateSwanCore() {
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SwanCoreDynamicCallback(true));
        b.init(AppRuntime.getAppContext(), true);
        a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        a.c(arrayList, true);
    }

    public static void onAppUpgrade(int i, int i2) {
        if (PKG_NAME_PREVIEW.equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            PresetSwanCoreControl.setNeedUpdateFlag(true);
        }
    }

    public static boolean isSupportedCoreUpdate(String str) {
        return getVersion(str) >= getVersion(SWAN_VERSION_FOR_CORE_UPDATE);
    }

    public static String getSwanCoreVersionString() {
        return getSwanCoreVersionString(null);
    }

    public static String getSwanCoreVersionString(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion == null) {
            swanCoreVersion = getSwanCoreVersion();
        }
        return swanCoreVersion.swanCoreVersion > 0 ? versionValueToString(swanCoreVersion.swanCoreVersion) : PresetSwanCoreControl.getPresetConfig().swanCoreVer;
    }

    public static SwanCoreVersion getSwanCoreVersionIPC() {
        if (ProcessUtils.isMainProcess()) {
            return getSwanCoreVersion();
        }
        return GetSwanCoreDelegation.getDataFromBundle(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), GetSwanCoreDelegation.class, null).mResult);
    }

    public static SwanCoreVersion getSwanCoreVersion() {
        long curPresetVersion = PresetSwanCoreControl.getCurPresetVersion();
        long curRemoteVersion = RemoteSwanCoreControl.getCurRemoteVersion();
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        if (curPresetVersion >= curRemoteVersion) {
            swanCoreVersion.swanCorePath = PresetSwanCoreControl.getPresetDirFile(curPresetVersion).getPath();
            swanCoreVersion.swanCoreType = 0;
            swanCoreVersion.swanCoreVersion = curPresetVersion;
        } else {
            swanCoreVersion.swanCorePath = RemoteSwanCoreControl.getRemoteDirFile(curRemoteVersion).getPath();
            swanCoreVersion.swanCoreType = 1;
            swanCoreVersion.swanCoreVersion = curRemoteVersion;
        }
        return swanCoreVersion;
    }

    public static File getSwanCoreBaseDir() {
        return new File(AiAppsBundleHelper.getBundleBaseFolder(), SWAN_CORE_DIR_NAME);
    }

    public static String versionValueToString(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(String.format("%d", Long.valueOf((j >> (i * 16)) & 65535)));
            if (i > 0) {
                sb.append(VERSION_SPLIT_STRING);
            }
        }
        return sb.toString();
    }

    public static long getVersion(String str) {
        String[] splitVersion = splitVersion(str);
        if (splitVersion == null) {
            return 0L;
        }
        int i = 0;
        long j = 0;
        while (i < 3) {
            try {
                j = (j << 16) | (i < splitVersion.length ? Integer.valueOf(splitVersion[i]).intValue() : 0L);
                i++;
            } catch (NumberFormatException e) {
                return 0L;
            }
        }
        return j;
    }

    private static String[] splitVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(VERSION_SPLIT_REGEX);
        if (split.length == 0 || split.length != 3) {
            return null;
        }
        return split;
    }

    public static void deleteOldSwanCores(File file, List<Long> list) {
        File[] listFiles;
        if (file != null && file.exists()) {
            for (File file2 : file.listFiles()) {
                if (!isIgnoreFolder(file2, list)) {
                    AiAppsFileUtils.deleteFile(file2);
                }
            }
        }
    }

    private static boolean isIgnoreFolder(File file, List<Long> list) {
        if (list == null) {
            return false;
        }
        String name = file.getName();
        for (Long l : list) {
            if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class GetSwanCoreDelegation extends ProviderDelegation {
        private static final String BUNDLE_KEY_SWAN_CORE = "aiapps_swan_core";

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(BUNDLE_KEY_SWAN_CORE, AiAppsSwanCoreManager.getSwanCoreVersion());
            return bundle2;
        }

        public static SwanCoreVersion getDataFromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            return (SwanCoreVersion) bundle.getParcelable(BUNDLE_KEY_SWAN_CORE);
        }
    }

    public static boolean isDebugSwanCoreMode() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(KEY_AIAPP_DEBUG_SWAN_CORE_MODE, false);
    }

    public static void setDebugSwanCoreMode(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean(KEY_AIAPP_DEBUG_SWAN_CORE_MODE, z).apply();
    }
}
