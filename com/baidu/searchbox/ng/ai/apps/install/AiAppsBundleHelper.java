package com.baidu.searchbox.ng.ai.apps.install;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.download.AiAppsBundleDownloadHelper;
import com.baidu.searchbox.ng.ai.apps.install.decrypt.BundleDecrypt;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.prepose.util.AiAppsDebugUtil;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting;
import com.baidu.searchbox.ng.ai.apps.swancore.debug.DebugSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppMD5Utils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStorageUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.data.ErrorCodePicker;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class AiAppsBundleHelper {
    public static final String AI_APPS_CONFIG_FILE = "app.json";
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsBundleHelper";
    private static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public interface AiAppsLoadCallback {
        public static final int LOAD_FAILED = 1;
        public static final int LOAD_SUCCESS = 0;

        void onLoaded(int i, AiAppsLoadInfo aiAppsLoadInfo);
    }

    /* loaded from: classes2.dex */
    public static class AiAppsLoadInfo {
        public String mAppBundlePath;
        public AiAppsConfigData mConfigData;
    }

    /* loaded from: classes2.dex */
    public interface InternalUseDownloadCb {
        void onFailed();

        void onProgressChanged(int i);

        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class InternalUseDownloadInfo {
        public String mAppId;
        public String mDownloadUrl;
    }

    public static void asyncLoadAiApps(final AiAppsLaunchInfo aiAppsLaunchInfo, final AiAppsLoadCallback aiAppsLoadCallback) {
        singleExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsLoadInfo loadAndRunAiApps;
                ErrorCodePicker errorCodePicker = new ErrorCodePicker();
                if (AiAppsDebugUtil.isDebug(AiAppsLaunchInfo.this)) {
                    loadAndRunAiApps = AiAppsDebugUtil.debugForLoadAndRunAiApps(AiAppsLaunchInfo.this, errorCodePicker);
                } else {
                    loadAndRunAiApps = ReleaseBundleHelper.loadAndRunAiApps(AiAppsLaunchInfo.this, errorCodePicker);
                }
                if (loadAndRunAiApps == null || loadAndRunAiApps.mConfigData == null || loadAndRunAiApps.mConfigData.mPageConfig == null) {
                    ErrCode errCode = errorCodePicker.errCode;
                    if (errCode == null) {
                        errCode = new ErrCode().feature(5L).error(20L).detail("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).page(AiAppsPerformanceUBC.STABILITY_PAGE_PACKAGE_CONFIG_INVALID).launchInfo(AiAppsLaunchInfo.this).infoAdd("detail", errCode.details().toString()));
                }
                aiAppsLoadCallback.onLoaded(0, loadAndRunAiApps);
            }
        });
    }

    public static File getBundleBaseFolder() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + ReleaseBundleHelper.FOLDER_BASE_PATH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean unzipAiAppBundle(File file, File file2, AiAppsLaunchInfo aiAppsLaunchInfo) {
        return unzipAiAppBundle(file, file2, aiAppsLaunchInfo, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean unzipAiAppBundle(File file, File file2, AiAppsLaunchInfo aiAppsLaunchInfo, ErrorCodePicker errorCodePicker) {
        boolean z = false;
        if (file != null && file2 != null) {
            if (!file.exists() || file.length() == 0) {
                ErrCode detail = new ErrCode().feature(5L).error(4L).detail("小程序bundle文件不存在或者空文件! ");
                if (errorCodePicker != null) {
                    errorCodePicker.errCode = detail;
                }
            } else {
                AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PACKAGE_START_UNZIP));
                System.currentTimeMillis();
                BufferedInputStream obtainEncryptedBundle = BundleDecrypt.obtainEncryptedBundle(file);
                if (obtainEncryptedBundle != null) {
                    z = BundleDecrypt.decrypt(file, file2, obtainEncryptedBundle).isSuccess;
                } else {
                    z = AiAppsFileUtils.unzipFile(file.getPath(), file2.getPath());
                }
                System.currentTimeMillis();
                if (!z) {
                    ErrCode detail2 = new ErrCode().feature(5L).error(7L).detail("小程序bundle解压失败! ");
                    if (errorCodePicker != null) {
                        errorCodePicker.errCode = detail2;
                    }
                }
                AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PACKAGE_END_UNZIP));
            }
        }
        return z;
    }

    public static String buildHtml(String str, Map<String, String> map) {
        String str2;
        if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            for (String str3 : map.keySet()) {
                if (TextUtils.isEmpty(map.get(str3))) {
                    str2 = "";
                } else {
                    str2 = map.get(str3);
                }
                str = str.replace(str3, str2);
            }
        }
        return str;
    }

    /* loaded from: classes2.dex */
    public static class ReleaseBundleHelper {
        public static final String BUNDLE_BASE_PATH = "aiapps_zip";
        public static final String BUNDLE_FILE_SUFFIX = ".aiapps";
        public static final String FOLDER_BASE_PATH = "aiapps_folder";

        public static AiAppsLoadInfo loadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo) {
            if (aiAppsLaunchInfo == null || getBundleFile(aiAppsLaunchInfo.mAppId, true) == null) {
                return null;
            }
            return loadAndRunAiApps(aiAppsLaunchInfo, null);
        }

        public static AiAppsLoadInfo loadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo, ErrorCodePicker errorCodePicker) {
            File bundleFile;
            boolean z = true;
            if (aiAppsLaunchInfo != null && (bundleFile = getBundleFile(aiAppsLaunchInfo.mAppId, true, errorCodePicker)) != null) {
                File unzipFolder = getUnzipFolder(aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mVersion);
                if (!unzipFolder.exists()) {
                    if (!AiAppsBundleHelper.unzipAiAppBundle(bundleFile, createUnzipFolder(unzipFolder), aiAppsLaunchInfo, errorCodePicker)) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        ErrCode detail = new ErrCode().feature(5L).error(7L).detail("小程序bundle解压失败! for release");
                        Tracer.get().record(detail);
                        if (errorCodePicker != null && errorCodePicker.errCode == null) {
                            errorCodePicker.errCode = detail;
                        }
                        return null;
                    }
                } else {
                    z = false;
                }
                deleteLowerVersionFolder(aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mVersion);
                AiAppsLoadInfo aiAppsLoadInfo = new AiAppsLoadInfo();
                AiAppsConfigData buildConfigData = AiAppsConfigData.buildConfigData(AiAppsFileUtils.readFileData(new File(unzipFolder, AiAppsBundleHelper.AI_APPS_CONFIG_FILE)));
                if (z && buildConfigData != null && buildConfigData.mSubPackageList != null) {
                    SubPackageInfoHelper.getInstance().initSubPackageStatus(aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mVersion, buildConfigData);
                }
                aiAppsLoadInfo.mAppBundlePath = unzipFolder.getPath() + File.separator;
                aiAppsLoadInfo.mConfigData = buildConfigData;
                return aiAppsLoadInfo;
            }
            return null;
        }

        public static File createUnzipFolder(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File getUnzipFolder(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + FOLDER_BASE_PATH + File.separator + str, str2);
        }

        public static void deleteAiAppFile(String str) {
            if (!TextUtils.isEmpty(str)) {
                File bundleFile = getBundleFile(str, false);
                if (bundleFile != null) {
                    AiAppsFileUtils.deleteFile(bundleFile);
                }
                AiAppsFileUtils.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + FOLDER_BASE_PATH + File.separator + str));
            }
        }

        private static void deleteLowerVersionFolder(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + FOLDER_BASE_PATH, str).listFiles(new FileFilter() { // from class: com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.ReleaseBundleHelper.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (isLowerVersion(str2, file.getName())) {
                        AiAppsFileUtils.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File getBundleFile(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return getBundleFile(str, z, null);
        }

        public static File getBundleFile(String str, boolean z, ErrorCodePicker errorCodePicker) {
            File bundleFolder;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = getBundleFolder().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (z) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), bundleFolder.getPath() + " 没有小程序包!").showToast();
                }
                ErrCode detail = new ErrCode().feature(5L).error(4L).detail("没有小程序包! for release, bundle files are empty");
                Tracer.get().record(detail);
                if (errorCodePicker != null) {
                    errorCodePicker.errCode = detail;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + BUNDLE_FILE_SUFFIX)) {
                    return file;
                }
            }
            if (z) {
                UniversalToast.makeText(AppRuntime.getAppContext(), bundleFolder.getPath() + " 没有小程序包!").showToast();
            }
            ErrCode detail2 = new ErrCode().feature(5L).error(4L).detail("没有小程序包! for release, no such bundle file");
            Tracer.get().record(detail2);
            if (errorCodePicker != null) {
                errorCodePicker.errCode = detail2;
            }
            return null;
        }

        public static File getBundleFolder() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), BUNDLE_BASE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean isLowerVersion(String str, String str2) {
            try {
                return compareVersion(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }

        private static long compareVersion(String str, String str2) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("version null");
            }
            if (!TextUtils.isDigitsOnly(str) || !TextUtils.isDigitsOnly(str2)) {
                throw new IllegalArgumentException("version is not digits only");
            }
            return Long.parseLong(str) - Long.parseLong(str2);
        }
    }

    public static void startDownload(InternalUseDownloadInfo internalUseDownloadInfo, InternalUseDownloadCb internalUseDownloadCb) {
        new AiAppsBundleDownloadHelper().startDownload(internalUseDownloadInfo, DebugBundleHelper.getDebugBundleFolder().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", internalUseDownloadCb);
    }

    public static void startDebugSwanCoreDownload(String str, InternalUseDownloadCb internalUseDownloadCb) {
        InternalUseDownloadInfo internalUseDownloadInfo = new InternalUseDownloadInfo();
        internalUseDownloadInfo.mDownloadUrl = str;
        DebugSwanCoreControl.clearDownloadDir();
        new AiAppsBundleDownloadHelper().startDownload(internalUseDownloadInfo, DebugSwanCoreControl.getDownloadTargetFilePath().getPath(), internalUseDownloadCb);
    }

    /* loaded from: classes2.dex */
    public static class DebugBundleHelper {
        private static final String BUNDLE_FILE_SUFFIX = ".aibundle";
        private static final String DEBUG_BUNDLE_BASE_PATH = "baidu/aiapps_debug/";
        private static final String ENCRYPTED_FILE_SUFFIX = ".smapp";

        public static AiAppsLoadInfo debugForLoadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo) {
            return debugForLoadAndRunAiApps(aiAppsLaunchInfo, null);
        }

        public static AiAppsLoadInfo debugForLoadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo, ErrorCodePicker errorCodePicker) {
            boolean z = true;
            File debugBundleFile = getDebugBundleFile(errorCodePicker);
            if (debugBundleFile == null) {
                return null;
            }
            AiApp aiApp = AiApp.get();
            if (aiApp == null) {
                if (!AiAppsBundleHelper.unzipAiAppBundle(debugBundleFile, getDebugUnzipFolder(), aiAppsLaunchInfo, errorCodePicker)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    ErrCode detail = new ErrCode().feature(5L).error(7L).detail("小程序bundle解压失败! for debug");
                    Tracer.get().record(detail);
                    if (errorCodePicker != null && errorCodePicker.errCode == null) {
                        errorCodePicker.errCode = detail;
                    }
                    return null;
                }
            } else {
                String string = aiApp.getSetting().getString(AiAppSetting.KEY_INSTALLED_DEBUG_BUNDLE_MD5, "");
                String md5 = AiAppMD5Utils.toMd5(debugBundleFile, false);
                if (TextUtils.equals(string, md5)) {
                    z = false;
                } else if (!AiAppsBundleHelper.unzipAiAppBundle(debugBundleFile, getDebugUnzipFolder(), aiAppsLaunchInfo, errorCodePicker)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    ErrCode detail2 = new ErrCode().feature(5L).error(7L).detail("小程序bundle解压失败! for debug");
                    Tracer.get().record(detail2);
                    if (errorCodePicker != null && errorCodePicker.errCode == null) {
                        errorCodePicker.errCode = detail2;
                    }
                    return null;
                } else {
                    aiApp.getSetting().putString(AiAppSetting.KEY_INSTALLED_DEBUG_BUNDLE_MD5, md5);
                }
            }
            AiAppsLoadInfo aiAppsLoadInfo = new AiAppsLoadInfo();
            AiAppsConfigData buildConfigData = AiAppsConfigData.buildConfigData(AiAppsFileUtils.readFileData(new File(getDebugUnzipOutputFolder(), AiAppsBundleHelper.AI_APPS_CONFIG_FILE)));
            if (z && aiApp != null && buildConfigData != null && buildConfigData.mSubPackageList != null) {
                SubPackageInfoHelper.getInstance().initSubPackageStatus(aiApp.id, aiApp.getVersion(), buildConfigData);
            }
            aiAppsLoadInfo.mAppBundlePath = getDebugUnzipOutputFolder().getPath() + File.separator;
            aiAppsLoadInfo.mConfigData = buildConfigData;
            return aiAppsLoadInfo;
        }

        public static File getDebugUnzipOutputFolder() {
            return getDebugUnzipFolder();
        }

        public static File getDebugUnzipFolder() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File getDebugBundleFile() {
            return getDebugBundleFile(null);
        }

        public static File getDebugBundleFile(ErrorCodePicker errorCodePicker) {
            File debugBundleFolder = getDebugBundleFolder();
            File[] listFiles = debugBundleFolder.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                UniversalToast.makeText(AppRuntime.getAppContext(), debugBundleFolder.getPath() + " 没有测试程序包!").showToast();
                ErrCode detail = new ErrCode().feature(5L).error(4L).detail("没有小程序包! for debug, bundle files are empty");
                Tracer.get().record(detail);
                if (errorCodePicker != null) {
                    errorCodePicker.errCode = detail;
                }
                return null;
            }
            return getLatestFile(listFiles);
        }

        private static File getLatestFile(File[] fileArr) {
            File file = null;
            for (File file2 : fileArr) {
                if (file == null || file2.lastModified() > file.lastModified()) {
                    file = file2;
                }
            }
            return file;
        }

        public static File getDebugBundleFolder() {
            File file = new File(AiAppStorageUtils.getStorageList().get(0).mPath, DEBUG_BUNDLE_BASE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public static class RemoteDebugBundleHelper {
        public static final String APP_FILE_NAME = "remote_debug.aiapps";
        public static final String BUNDLE_BASE_PATH = "aiapps_remote_debug_zip";
        public static final String FOLDER_BASE_PATH = "aiapps_remote_debug_folder";

        public static AiAppsLoadInfo debugForLoadAndRunAiApps(AiAppsLaunchInfo aiAppsLaunchInfo) {
            AiAppsBundleHelper.unzipAiAppBundle(getDebugBundleFile(), getDebugUnzipFolder(), aiAppsLaunchInfo);
            AiAppsLoadInfo aiAppsLoadInfo = new AiAppsLoadInfo();
            AiAppsConfigData buildConfigData = AiAppsConfigData.buildConfigData(AiAppsFileUtils.readFileData(new File(getDebugUnzipFolder(), AiAppsBundleHelper.AI_APPS_CONFIG_FILE)));
            aiAppsLoadInfo.mAppBundlePath = getDebugUnzipFolder().getPath() + File.separator;
            aiAppsLoadInfo.mConfigData = buildConfigData;
            return aiAppsLoadInfo;
        }

        public static File getDebugUnzipFolder() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), FOLDER_BASE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File getDebugBundleFile() {
            return new File(getDebugBundleFolder(), APP_FILE_NAME);
        }

        public static File getDebugBundleFolder() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), BUNDLE_BASE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public static class SubPackageBundleHelper {
        public static boolean unZipSubPackage(SubPackageAPSInfo subPackageAPSInfo) {
            File unzipFolder;
            boolean unzipFile;
            if (subPackageAPSInfo == null) {
                return false;
            }
            File file = new File(subPackageAPSInfo.mZipPath);
            if (!file.exists() || (unzipFolder = getUnzipFolder(subPackageAPSInfo)) == null) {
                return false;
            }
            if (unzipFolder.exists() || unzipFolder.mkdirs()) {
                BufferedInputStream obtainEncryptedBundle = BundleDecrypt.obtainEncryptedBundle(file);
                if (obtainEncryptedBundle != null) {
                    unzipFile = BundleDecrypt.decrypt(file, unzipFolder, obtainEncryptedBundle).isSuccess;
                } else {
                    unzipFile = AiAppsFileUtils.unzipFile(file.getAbsolutePath(), unzipFolder.getAbsolutePath());
                }
                return unzipFile;
            }
            return false;
        }

        private static File getUnzipFolder(SubPackageAPSInfo subPackageAPSInfo) {
            if (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.mAppRootPath) || TextUtils.isEmpty(subPackageAPSInfo.mSubPackageName)) {
                return null;
            }
            return new File(subPackageAPSInfo.mAppRootPath, subPackageAPSInfo.mSubPackageName);
        }
    }
}
