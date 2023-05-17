package com.baidu.searchbox.ui.animview.praise.resource;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.PraisePerformanceStrategyRuntime;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class PraiseResourceAPSManager implements NightModeChangeListener {
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String PRAISE_DOWNLOAD_DIR_NAME = "download";
    public static final int PRAISE_INSTALL_FAILED = 1;
    public static final int PRAISE_INSTALL_SUCCESS = 0;
    public static final String PRAISE_PACKAGE_NAME_FOR_NORMAL = "com.baidu.box.praise.v2";
    public static final String PRAISE_ROOT_DIR_NAME = "praise_root";
    public static final String RESTORE_SUFFIX = "_lastest.json";
    public static final String TAG = "ResourceAPSManager";
    public boolean mIsDebugLoadMode;
    public volatile boolean mLoaded;
    public final Object mNightModeSubObj;
    public Map<String, PraiseResourceInfo> mResourceMap;

    /* loaded from: classes4.dex */
    public interface PraiseInstallResultCb {
        void onResult(int i, String str);
    }

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final PraiseResourceAPSManager INSTANCE = new PraiseResourceAPSManager();
    }

    public PraiseResourceAPSManager() {
        this.mNightModeSubObj = new Object();
        this.mIsDebugLoadMode = false;
        this.mResourceMap = new ConcurrentHashMap();
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeSubObj, this);
    }

    public static final PraiseResourceAPSManager getInstance() {
        return Holder.INSTANCE;
    }

    public static File getPraiseDownloadDir() {
        File file = new File(getPraiseRootDir(), "download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getPraiseRootDir() {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (DEBUG) {
            Log.d("ResourceAPSManager", "getPraiseRootDir = " + path);
        }
        return new File(path, PRAISE_ROOT_DIR_NAME);
    }

    public static File[] getRestoreFileList() {
        File praiseRootDir = getPraiseRootDir();
        if (!praiseRootDir.exists()) {
            if (DEBUG) {
                Log.d("ResourceAPSManager", "getRestoreFileList return, praiseRootDir.exists = false");
            }
            return null;
        }
        File[] listFiles = praiseRootDir.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (!file.isDirectory() && PraiseResourceAPSManager.isValidRestoreFileName(file.getName())) {
                    return true;
                }
                return false;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            return listFiles;
        }
        if (DEBUG) {
            Log.d("ResourceAPSManager", "getRestoreFileList return, praiseRootDir.listFiles = empty");
        }
        return null;
    }

    public static boolean makePraiseRootDirIfNeeded() {
        File praiseRootDir = getPraiseRootDir();
        if (praiseRootDir.exists()) {
            return true;
        }
        return praiseRootDir.mkdirs();
    }

    public boolean hasValidProvider() {
        Map<String, PraiseResourceInfo> map = this.mResourceMap;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDebugLoadMode() {
        if (DEBUG) {
            return this.mIsDebugLoadMode;
        }
        return false;
    }

    public boolean isLoaded() {
        return this.mLoaded;
    }

    @Nullable
    public static File getPraiseIconById(String str) {
        return getPraiseIconById(str, NightModeHelper.getNightModeSwitcherState());
    }

    public static boolean isValidRestoreFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (!lowerCase.endsWith("_lastest.json") || !lowerCase.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL)) {
            return false;
        }
        return true;
    }

    public static void removeOldResources(PraiseResourceInfo praiseResourceInfo) {
        removeNoIgnoreResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
    }

    public static PraiseResourceInfo restorePraiseResourceInfo(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String readFileData = FileUtils.readFileData(file);
        if (TextUtils.isEmpty(readFileData)) {
            return null;
        }
        return PraiseResourceInfo.valueOf(readFileData);
    }

    private void savePraiseResourceInfo(PraiseResourceInfo praiseResourceInfo) {
        if (praiseResourceInfo == null) {
            return;
        }
        File praiseRootDir = getPraiseRootDir();
        File file = new File(praiseRootDir, praiseResourceInfo.mPkgName + "_lastest.json");
        FileUtils.deleteFile(file);
        FileUtils.saveFile(praiseResourceInfo.toJSONString(), file);
    }

    public IResourceProvider getProvider(String str) {
        PraiseResourceInfo praiseResourceInfo;
        if (!hasValidProvider() || TextUtils.isEmpty(str) || (praiseResourceInfo = this.mResourceMap.get(str)) == null) {
            return null;
        }
        return praiseResourceInfo.mProvider;
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    public void onNightModeChanged(final boolean z) {
        Map<String, PraiseResourceInfo> map = this.mResourceMap;
        if (map != null && !map.isEmpty()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.2
                @Override // java.lang.Runnable
                public void run() {
                    IResourceProvider iResourceProvider;
                    String str;
                    Iterator it = PraiseResourceAPSManager.this.mResourceMap.entrySet().iterator();
                    while (it != null && it.hasNext()) {
                        PraiseResourceInfo praiseResourceInfo = (PraiseResourceInfo) ((Map.Entry) it.next()).getValue();
                        if (praiseResourceInfo != null && (iResourceProvider = praiseResourceInfo.mProvider) != null) {
                            String[] strArr = new String[1];
                            if (z) {
                                str = "day";
                            } else {
                                str = "night";
                            }
                            strArr[0] = str;
                            iResourceProvider.loadResource(strArr);
                            PraiseResourceAPSManager.this.preInitPraiseElements();
                            if (z) {
                                if (PraiseResourceAPSManager.DEBUG) {
                                    Log.d("ResourceAPSManager", praiseResourceInfo.mPkgName + " has been switched to night mode");
                                }
                            } else if (PraiseResourceAPSManager.DEBUG) {
                                Log.d("ResourceAPSManager", praiseResourceInfo.mPkgName + " has been switched to day mode");
                            }
                        }
                    }
                }
            }, "praiseResNightModeProcess", 2);
        } else if (DEBUG) {
            Log.d("ResourceAPSManager", "onNightModeChanged，nothing to do");
        }
    }

    public void setDebugLoadMode(boolean z) {
        if (DEBUG) {
            releaseResources();
            this.mIsDebugLoadMode = z;
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                for (File file : restoreFileList) {
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                }
            }
            if (this.mIsDebugLoadMode) {
                getInstance().mockDoAPSProcess();
            }
        }
    }

    public static File getPraiseResourceDir(String str, String str2) {
        File praiseRootDir = getPraiseRootDir();
        return new File(praiseRootDir, str + File.separator + str2);
    }

    public static void removeNoIgnoreResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getPraiseRootDir(), str);
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.4
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isDirectory() && PraiseResourceAPSManager.willBeRemovedButIgnore(file2, jArr)) {
                    return true;
                }
                return false;
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            FileUtils.deleteFile(file2);
        }
    }

    public static void removeTargetResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getPraiseRootDir(), str);
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.5
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isDirectory() && PraiseResourceAPSManager.willBeRemoved(file2, jArr)) {
                    return true;
                }
                return false;
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            FileUtils.deleteFile(file2);
        }
    }

    public static boolean willBeRemoved(File file, long... jArr) {
        if (jArr == null) {
            return false;
        }
        String name = file.getName();
        for (long j : jArr) {
            if (TextUtils.equals(name, String.valueOf(j))) {
                return true;
            }
        }
        return false;
    }

    public static boolean willBeRemovedButIgnore(File file, long... jArr) {
        if (jArr == null) {
            return false;
        }
        String name = file.getName();
        for (long j : jArr) {
            if (TextUtils.equals(name, String.valueOf(j))) {
                return false;
            }
        }
        return true;
    }

    public static boolean copyPraiseResourceFile(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb) {
        File praiseResourceDir = getPraiseResourceDir(praiseResourceInfo.mPkgName, String.valueOf(praiseResourceInfo.mVersion));
        if (!praiseResourceDir.exists() && !praiseResourceDir.mkdirs()) {
            praiseInstallResultCb.onResult(1, "make praise resource dir failed.");
            return false;
        }
        File file = new File(praiseResourceInfo.mDownloadFilePath);
        File file2 = new File(praiseResourceDir, file.getName());
        if (file2.exists()) {
            file2.delete();
        }
        if (file.length() != 0 && FileUtils.copyFile(file, file2) == file.length()) {
            praiseResourceInfo.mPraiseResSavePath = file2.getPath();
            return true;
        }
        praiseInstallResultCb.onResult(1, "failed to copy praise resource.");
        return false;
    }

    @Nullable
    public static File getPraiseIconById(String str, boolean z) {
        File[] praiseIconById;
        File[] restoreFileList = getRestoreFileList();
        if (restoreFileList != null && restoreFileList.length > 0) {
            for (File file : restoreFileList) {
                PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                if (restorePraiseResourceInfo != null && (praiseIconById = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build().getPraiseIconById(str, z)) != null && praiseIconById.length > 0) {
                    if (DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        for (File file2 : praiseIconById) {
                            sb.append(file2.getPath());
                            sb.append("; ");
                        }
                        Log.d("ResourceAPSManager", "获取到匹配的文件：" + ((Object) sb));
                    }
                    return praiseIconById[0];
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preInitPraiseElements() {
        HashMap hashMap = new HashMap();
        hashMap.put(4, 8);
        IPraiseElementBuilder.PreBuildConfig preBuildConfig = new IPraiseElementBuilder.PreBuildConfig();
        preBuildConfig.setResourceProvider(getProvider(PRAISE_PACKAGE_NAME_FOR_NORMAL));
        preBuildConfig.setElementCntsMap(hashMap);
        PraiseAnimElementBuilderEx.getInstance().preBuild(preBuildConfig);
        EruptionElementBuilder.getInstance().preBuild(preBuildConfig);
    }

    public void loadPraiseIcon() {
        IResourceProvider build;
        File[] restoreFileList = getRestoreFileList();
        if (restoreFileList != null && restoreFileList.length > 0) {
            for (File file : restoreFileList) {
                PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                if (restorePraiseResourceInfo != null && (build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build()) != null) {
                    build.onlyLoadPraiseIcon();
                }
            }
        } else if (DEBUG) {
            Log.d("ResourceAPSManager", "loadPraiseIcon return, praiseRootDir.listFiles = empty");
        }
    }

    public void mockDoAPSProcess() {
        doAPSProcess(new PraiseResourceInfo(PRAISE_PACKAGE_NAME_FOR_NORMAL, Environment.getExternalStorageDirectory().getPath() + File.separator + "lottie.zip", "", 1L, "0", "10101010"), new PraiseInstallResultCb() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.1
            @Override // com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.PraiseInstallResultCb
            public void onResult(int i, String str) {
            }
        }, true);
    }

    public void releaseResources() {
        if (!this.mLoaded) {
            return;
        }
        Map<String, PraiseResourceInfo> map = this.mResourceMap;
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, PraiseResourceInfo>> it = this.mResourceMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                PraiseResourceInfo value = it.next().getValue();
                if (value != null) {
                    value.mProvider = null;
                }
            }
            this.mResourceMap.clear();
        }
        this.mLoaded = false;
    }

    private void savePraiseResource(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        String str;
        if (!praiseResourceInfo.isAvailable()) {
            removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
            praiseInstallResultCb.onResult(1, "praise resource is not available.");
            if (DEBUG) {
                Log.d("ResourceAPSManager", "savePraiseResource failed, praise resource is not available");
                return;
            }
            return;
        }
        IResourceProvider build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(praiseResourceInfo.mPraiseResSavePath).build();
        if (build == null) {
            removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
            praiseInstallResultCb.onResult(1, "failed to build provider.");
            if (DEBUG) {
                Log.d("ResourceAPSManager", "savePraiseResource failed, failed to build provider");
                return;
            }
            return;
        }
        praiseResourceInfo.mProvider = build;
        savePraiseResourceInfo(praiseResourceInfo);
        removeOldResources(praiseResourceInfo);
        if (z && !TextUtils.isEmpty(praiseResourceInfo.mPkgName) && praiseResourceInfo.mPkgName.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL)) {
            if (PraisePerformanceStrategyRuntime.getContext().isEnable()) {
                String[] strArr = new String[1];
                if (NightModeHelper.getNightModeSwitcherState()) {
                    str = "day";
                } else {
                    str = "night";
                }
                strArr[0] = str;
                build.loadResource(strArr);
                if (DEBUG) {
                    Log.d("ResourceAPSManager", "savePraiseResource: all resource");
                }
            } else {
                build.onlyLoadPraiseIcon();
                if (DEBUG) {
                    Log.d("ResourceAPSManager", "savePraiseResource: only icon resource");
                }
            }
            this.mResourceMap.put(praiseResourceInfo.mPkgName, praiseResourceInfo);
            this.mLoaded = true;
            if (DEBUG) {
                Log.d("ResourceAPSManager", "loadToMem success, pkgName = " + praiseResourceInfo.mPkgName);
            }
        }
        preInitPraiseElements();
        praiseInstallResultCb.onResult(0, "praise install success, loadToMem = " + z);
        if (DEBUG) {
            Log.d("ResourceAPSManager", "praise install success, loadToMem = " + z);
        }
    }

    public void doAPSProcess(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        if (praiseResourceInfo != null && praiseInstallResultCb != null) {
            if (!praiseResourceInfo.isValid()) {
                praiseInstallResultCb.onResult(1, "praiseInfo invalid.");
                if (DEBUG) {
                    Log.d("ResourceAPSManager", "doAPSProcess failed, praiseInfo invalid");
                }
            } else if (makePraiseRootDirIfNeeded() && copyPraiseResourceFile(praiseResourceInfo, praiseInstallResultCb)) {
                savePraiseResource(praiseResourceInfo, praiseInstallResultCb, z);
            } else {
                praiseInstallResultCb.onResult(1, "failed to make praise root dir or copyPraiseResourceFile.");
                if (DEBUG) {
                    Log.d("ResourceAPSManager", "doAPSProcess failed, failed to make praise root dir or copyPraiseResourceFile");
                }
            }
        } else if (DEBUG) {
            Log.d("ResourceAPSManager", "doAPSProcess failed, both praiseInfo and callback must not be null");
        }
    }

    public String getAPSResourceDebugInfo() {
        boolean z;
        String str;
        String str2;
        List<IResourceProvider.PackageInfo> packageList;
        StringBuilder sb = new StringBuilder();
        sb.append("点赞动效APS根目录:" + getPraiseRootDir().getPath());
        sb.append("\n点赞动效合法资源清单:\n");
        Map<String, PraiseResourceInfo> map = this.mResourceMap;
        int i = 1;
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, PraiseResourceInfo>> it = this.mResourceMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                PraiseResourceInfo value = it.next().getValue();
                if (value != null) {
                    sb.append("\n======第" + i + "个资源包======\n");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("包名:");
                    sb2.append(value.mPkgName);
                    sb.append(sb2.toString());
                    sb.append("\n包版本号:" + value.mVersion);
                    sb.append("\n最小宿主版本号:" + value.mMinHostVer);
                    sb.append("\n最大宿主版本号:" + value.mMaxHostVer);
                    sb.append("\nAPS下载路径:" + value.mDownloadFilePath);
                    sb.append("\n包存储路径:" + value.mPraiseResSavePath);
                    IResourceProvider iResourceProvider = value.mProvider;
                    if (iResourceProvider != null && (packageList = iResourceProvider.getPackageList()) != null && packageList.size() > 0) {
                        for (IResourceProvider.PackageInfo packageInfo : packageList) {
                            sb.append("\n<" + packageInfo.mPkgTag + "> shake = " + packageInfo.mResPkg.getResourceCounts("shake"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> wave = " + packageInfo.mResPkg.getResourceCounts("wave"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> level = " + packageInfo.mResPkg.getResourceCounts("level"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> number = " + packageInfo.mResPkg.getResourceCounts("number"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> eruption = " + packageInfo.mResPkg.getResourceCounts(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION));
                            sb.append("\n");
                        }
                    }
                    i++;
                }
            }
        } else {
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                z = false;
            } else {
                z = true;
            }
            i = (ComboPraiseRuntime.getContext() == null || !ComboPraiseRuntime.getContext().getPraiseSwitchState()) ? 0 : 0;
            sb.append("\n暂无\n");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n点赞动效资源: ");
            if (z) {
                str = "下载失败\n";
            } else {
                str = "下载成功\n";
            }
            sb3.append(str);
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\n点赞动效开关: ");
            if (i != 0) {
                str2 = "开启\n";
            } else {
                str2 = "关闭\n";
            }
            sb4.append(str2);
            sb.append(sb4.toString());
        }
        return sb.toString();
    }

    public void loadResourcesIfNeeded() {
        String str;
        if (this.mLoaded) {
            if (DEBUG) {
                Log.d("ResourceAPSManager", "loadResourcesIfNeeded return, mLoaded = true");
                return;
            }
            return;
        }
        File[] restoreFileList = getRestoreFileList();
        if (restoreFileList != null && restoreFileList.length > 0) {
            boolean z = false;
            for (File file : restoreFileList) {
                PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                if (restorePraiseResourceInfo != null) {
                    IResourceProvider build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build();
                    if (build != null) {
                        if (!z) {
                            releaseResources();
                            z = true;
                        }
                        String[] strArr = new String[1];
                        if (NightModeHelper.getNightModeSwitcherState()) {
                            str = "day";
                        } else {
                            str = "night";
                        }
                        strArr[0] = str;
                        build.loadResource(strArr);
                        restorePraiseResourceInfo.mProvider = build;
                        this.mResourceMap.put(restorePraiseResourceInfo.mPkgName, restorePraiseResourceInfo);
                        this.mLoaded = true;
                        preInitPraiseElements();
                        if (DEBUG) {
                            Log.d("ResourceAPSManager", "loadResourcesIfNeeded success, pkgName = " + restorePraiseResourceInfo.mPkgName);
                        }
                    } else if (DEBUG) {
                        Log.d("ResourceAPSManager", "loadResourcesIfNeeded failed, pkgName = " + restorePraiseResourceInfo.mPkgName);
                    }
                }
            }
            if (!this.mLoaded && DEBUG) {
                Log.d("ResourceAPSManager", "loadResourcesIfNeeded failed totally");
                for (File file2 : restoreFileList) {
                    FileUtils.deleteFile(file2);
                }
            }
        } else if (DEBUG) {
            Log.d("ResourceAPSManager", "loadResourcesIfNeeded return, praiseRootDir.listFiles = empty");
        }
    }
}
