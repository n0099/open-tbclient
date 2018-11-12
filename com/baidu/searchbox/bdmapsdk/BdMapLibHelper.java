package com.baidu.searchbox.bdmapsdk;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.searchbox.bdmapsdk.data.BdMapLibSpHelper;
import com.baidu.searchbox.bdmapsdk.data.BdMapLibVersionDelegation;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.File;
/* loaded from: classes4.dex */
public class BdMapLibHelper {
    private static final String MAP_LIB_BASE_DIR = "baidu_map/libs";
    private static final String MAP_LIB_ZIP_NAME = "baidu_map_lib.zip";
    private static final String MAP_SYMBOL_POINT = ".";
    private static final String MAP_SYMBOL_UNDERLINE = "_";
    private static final String MODULE_TAG = "APS_MAP_TAG";
    public static final String PREF_MAP_LIB_VERSION = "baidu_map_lib_version";
    private static final String PREF_MAP_LIB_VERSION_DEF = "0";

    public static File getBdMapLibBaseDir() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + MAP_LIB_BASE_DIR);
    }

    public static File getBdMapLibFile() {
        return new File(getBdMapLibBaseDir(), MAP_LIB_ZIP_NAME);
    }

    public static boolean matchBdMapSdkVersion(String str) {
        return getStandardBdMapLibVersion().equals(str);
    }

    public static String getStandardBdMapLibVersion() {
        return VersionInfo.getApiVersion().replace("_", MAP_SYMBOL_POINT);
    }

    public static boolean renameBdMapLibFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }

    public static String getBdMapLibVersionIPC() {
        if (ProcessUtils.isMainProcess()) {
            return getMapLibVersion();
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), BdMapLibVersionDelegation.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString(PREF_MAP_LIB_VERSION, "0") : "0";
    }

    public static String getMapLibVersion() {
        return BdMapLibSpHelper.getsInstance().getString(PREF_MAP_LIB_VERSION, "0");
    }

    public static void setMapLibVersion(String str) {
        BdMapLibSpHelper.getsInstance().putString(PREF_MAP_LIB_VERSION, str);
    }

    public static boolean checkLocalMapLibZipExist() {
        return getBdMapLibFile().exists();
    }
}
