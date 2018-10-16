package com.baidu.searchbox.ng.ai.apps.core.aps.subpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.a.b;
import com.baidu.b.a.f.c.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppSignChecker;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GetSubPackageHelper {
    private static final String AI_APPS_SUB_PACKAGE_DIR = "aiapps_sub_package_zip";
    private static final String AI_APPS_ZIP_SUFFIX = ".aiapps";
    private static final int COPY_FILE_FAILED = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "GetSubPackageHelper";

    public static void processGetSubPackageMessage(SubPackageAPSInfo subPackageAPSInfo, int i) {
        if (subPackageAPSInfo != null) {
            if (verifyAPSInfo(subPackageAPSInfo)) {
                subPackageAPSInfo.mAiAppProcessId = i;
                downloadSubPackage(subPackageAPSInfo);
                return;
            }
            subPackageAPSInfo.mResultCode = 2101;
            Bundle bundle = new Bundle();
            bundle.putParcelable(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY, subPackageAPSInfo);
            AiAppsMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.mAiAppProcessId, 104, bundle);
        }
    }

    private static void downloadSubPackage(SubPackageAPSInfo subPackageAPSInfo) {
        Context appContext = AppRuntime.getAppContext();
        a.putParams(subPackageAPSInfo.mKey, subPackageAPSInfo.mAppVersion);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AiAppsSubPackageAPSCallback(appContext, subPackageAPSInfo));
        b.init(appContext, ProcessUtils.isMainProcess());
        com.baidu.b.a.e.a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        com.baidu.b.a.e.a.c(arrayList, true);
    }

    public static void callbackDownloadError(SubPackageAPSInfo subPackageAPSInfo, int i) {
        if (subPackageAPSInfo != null) {
            subPackageAPSInfo.mResultCode = i;
            Bundle bundle = new Bundle();
            bundle.putParcelable(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY, subPackageAPSInfo);
            AiAppsMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.mAiAppProcessId, 104, bundle);
        }
    }

    private static void callbackDownloadSuccess(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo != null) {
            subPackageAPSInfo.mResultCode = 2100;
            Bundle bundle = new Bundle();
            bundle.putParcelable(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY, subPackageAPSInfo);
            AiAppsMessengerService.getServiceObject().sendMessageToClient(subPackageAPSInfo.mAiAppProcessId, 105, bundle);
        }
    }

    public static void downloadSubPackageSuccess(SubPackageAPSInfo subPackageAPSInfo, com.baidu.b.a.c.a.a aVar) {
        if (subPackageAPSInfo != null && aVar != null) {
            if (!AiAppSignChecker.checkZipSign(new File(aVar.filePath), AiAppJSONUtils.parseString(aVar.Zr).optString("sign"))) {
                callbackDownloadError(subPackageAPSInfo, 2104);
            } else if (renameSubPackageZip(subPackageAPSInfo, aVar) && unZipSubPackage(subPackageAPSInfo)) {
                SubPackageInfoHelper.getInstance().downloadSubPackageSuccess(subPackageAPSInfo.mAppId, subPackageAPSInfo.mAppVersion, subPackageAPSInfo.mSubPackageName);
                callbackDownloadSuccess(subPackageAPSInfo);
            } else {
                callbackDownloadError(subPackageAPSInfo, 2105);
            }
        }
    }

    public static String getSubPackageZipFolder(SubPackageAPSInfo subPackageAPSInfo) {
        if (subPackageAPSInfo == null) {
            return null;
        }
        String str = subPackageAPSInfo.mAppRootPath;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        File subPackageZipFolder = getSubPackageZipFolder(str);
        if (subPackageZipFolder != null) {
            return subPackageZipFolder.getPath();
        }
        return null;
    }

    private static boolean unZipSubPackage(SubPackageAPSInfo subPackageAPSInfo) {
        return AiAppsBundleHelper.SubPackageBundleHelper.unZipSubPackage(subPackageAPSInfo);
    }

    private static boolean renameSubPackageZip(SubPackageAPSInfo subPackageAPSInfo, com.baidu.b.a.c.a.a aVar) {
        if (aVar == null || subPackageAPSInfo == null) {
            return false;
        }
        String subPackageZipName = getSubPackageZipName(subPackageAPSInfo.mKey);
        String subPackageZipFolder = getSubPackageZipFolder(subPackageAPSInfo);
        if (subPackageZipFolder == null || TextUtils.isEmpty(subPackageZipName)) {
            return false;
        }
        File file = new File(subPackageZipFolder, subPackageZipName);
        File file2 = new File(aVar.filePath);
        if (file2.renameTo(file)) {
            subPackageAPSInfo.mZipPath = file.getAbsolutePath();
            return true;
        }
        AiAppsFileUtils.deleteFile(file2);
        return false;
    }

    private static String getSubPackageZipName(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encodeToString(str.getBytes(), 2) + ".aiapps" : "";
    }

    private static File getSubPackageZipFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str, AI_APPS_SUB_PACKAGE_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    private static boolean verifyAPSInfo(SubPackageAPSInfo subPackageAPSInfo) {
        return (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.mAppVersion) || TextUtils.isEmpty(subPackageAPSInfo.mKey) || TextUtils.isEmpty(subPackageAPSInfo.mAppRootPath) || TextUtils.isEmpty(subPackageAPSInfo.mSubPackageName) || TextUtils.isEmpty(subPackageAPSInfo.mCallbackKey)) ? false : true;
    }
}
