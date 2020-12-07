package com.baidu.searchbox.ui.animview.praise.resource;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class PraiseResourceAPSManager implements NightModeChangeListener {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String PRAISE_DOWNLOAD_DIR_NAME = "download";
    public static final int PRAISE_INSTALL_FAILED = 1;
    public static final int PRAISE_INSTALL_SUCCESS = 0;
    public static final String PRAISE_PACKAGE_NAME_FOR_NORMAL = "com.baidu.box.praise.v2";
    private static final String PRAISE_ROOT_DIR_NAME = "praise_root";
    private static final String RESTORE_SUFFIX = "_lastest.json";
    private static final String TAG = "ResourceAPSManager";
    private boolean mIsDebugLoadMode;
    private volatile boolean mLoaded;
    private final Object mNightModeSubObj;
    private Map<String, PraiseResourceInfo> mResourceMap;

    /* loaded from: classes6.dex */
    public interface PraiseInstallResultCb {
        void onResult(int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class Holder {
        private static final PraiseResourceAPSManager sINSTANCE = new PraiseResourceAPSManager();

        private Holder() {
        }
    }

    private PraiseResourceAPSManager() {
        this.mNightModeSubObj = new Object();
        this.mIsDebugLoadMode = false;
        this.mResourceMap = new ConcurrentHashMap();
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeSubObj, this);
    }

    public static final PraiseResourceAPSManager getInstance() {
        return Holder.sINSTANCE;
    }

    public void mockDoAPSProcess() {
        doAPSProcess(new PraiseResourceInfo(PRAISE_PACKAGE_NAME_FOR_NORMAL, Environment.getExternalStorageDirectory().getPath() + File.separator + "lottie.zip", "", 1L, "0", "10101010"), new PraiseInstallResultCb() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.1
            @Override // com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.PraiseInstallResultCb
            public void onResult(int i, String str) {
            }
        }, true);
    }

    public boolean isDebugLoadMode() {
        if (DEBUG) {
            return this.mIsDebugLoadMode;
        }
        return false;
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

    public String getAPSResourceDebugInfo() {
        int i;
        List<IResourceProvider.PackageInfo> packageList;
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        sb.append("点赞动效APS根目录:" + getPraiseRootDir().getPath());
        sb.append("\n点赞动效合法资源清单:\n");
        if (this.mResourceMap != null && !this.mResourceMap.isEmpty()) {
            Iterator<Map.Entry<String, PraiseResourceInfo>> it = this.mResourceMap.entrySet().iterator();
            int i2 = 1;
            while (it != null && it.hasNext()) {
                PraiseResourceInfo value = it.next().getValue();
                if (value != null) {
                    sb.append("\n======第" + i2 + "个资源包======\n");
                    sb.append("包名:" + value.mPkgName);
                    sb.append("\n包版本号:" + value.mVersion);
                    sb.append("\n最小宿主版本号:" + value.mMinHostVer);
                    sb.append("\n最大宿主版本号:" + value.mMaxHostVer);
                    sb.append("\nAPS下载路径:" + value.mDownloadFilePath);
                    sb.append("\n包存储路径:" + value.mPraiseResSavePath);
                    if (value.mProvider != null && (packageList = value.mProvider.getPackageList()) != null && packageList.size() > 0) {
                        for (IResourceProvider.PackageInfo packageInfo : packageList) {
                            sb.append("\n<" + packageInfo.mPkgTag + "> shake = " + packageInfo.mResPkg.getResourceCounts("shake"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> wave = " + packageInfo.mResPkg.getResourceCounts("wave"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> level = " + packageInfo.mResPkg.getResourceCounts("level"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> number = " + packageInfo.mResPkg.getResourceCounts("number"));
                            sb.append("\n<" + packageInfo.mPkgTag + "> eruption = " + packageInfo.mResPkg.getResourceCounts(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION));
                            sb.append("\n");
                        }
                    }
                    i = i2 + 1;
                } else {
                    i = i2;
                }
                i2 = i;
            }
        } else {
            File[] restoreFileList = getRestoreFileList();
            boolean z2 = restoreFileList == null || restoreFileList.length <= 0;
            z = (ComboPraiseRuntime.getContext() == null || !ComboPraiseRuntime.getContext().getPraiseSwitchState()) ? false : false;
            sb.append("\n暂无\n");
            sb.append("\n点赞动效资源: " + (z2 ? "下载失败\n" : "下载成功\n"));
            sb.append("\n点赞动效开关: " + (z ? "开启\n" : "关闭\n"));
        }
        return sb.toString();
    }

    public void doAPSProcess(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        if (praiseResourceInfo == null || praiseInstallResultCb == null) {
            if (DEBUG) {
                Log.d(TAG, "doAPSProcess failed, both praiseInfo and callback must not be null");
            }
        } else if (!praiseResourceInfo.isValid()) {
            praiseInstallResultCb.onResult(1, "praiseInfo invalid.");
            if (DEBUG) {
                Log.d(TAG, "doAPSProcess failed, praiseInfo invalid");
            }
        } else if (makePraiseRootDirIfNeeded() && copyPraiseResourceFile(praiseResourceInfo, praiseInstallResultCb)) {
            savePraiseResource(praiseResourceInfo, praiseInstallResultCb, z);
        } else {
            praiseInstallResultCb.onResult(1, "failed to make praise root dir or copyPraiseResourceFile.");
            if (DEBUG) {
                Log.d(TAG, "doAPSProcess failed, failed to make praise root dir or copyPraiseResourceFile");
            }
        }
    }

    public boolean isLoaded() {
        return this.mLoaded;
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    public void onNightModeChanged(final boolean z) {
        if (this.mResourceMap == null || this.mResourceMap.isEmpty()) {
            if (DEBUG) {
                Log.d(TAG, "onNightModeChanged，nothing to do");
                return;
            }
            return;
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = PraiseResourceAPSManager.this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    PraiseResourceInfo praiseResourceInfo = (PraiseResourceInfo) ((Map.Entry) it.next()).getValue();
                    if (praiseResourceInfo != null && praiseResourceInfo.mProvider != null) {
                        IResourceProvider iResourceProvider = praiseResourceInfo.mProvider;
                        String[] strArr = new String[1];
                        strArr[0] = z ? "day" : ComboPraiseProvider.DIR_PREFIX_NIGHT;
                        iResourceProvider.loadResource(strArr);
                        PraiseResourceAPSManager.this.preInitPraiseElements();
                        if (z) {
                            if (PraiseResourceAPSManager.DEBUG) {
                                Log.d(PraiseResourceAPSManager.TAG, praiseResourceInfo.mPkgName + " has been switched to night mode");
                            }
                        } else if (PraiseResourceAPSManager.DEBUG) {
                            Log.d(PraiseResourceAPSManager.TAG, praiseResourceInfo.mPkgName + " has been switched to day mode");
                        }
                    }
                }
            }
        }, "praiseResNightModeProcess", 2);
    }

    public static File[] getRestoreFileList() {
        File praiseRootDir = getPraiseRootDir();
        if (!praiseRootDir.exists()) {
            if (DEBUG) {
                Log.d(TAG, "getRestoreFileList return, praiseRootDir.exists = false");
                return null;
            }
            return null;
        }
        File[] listFiles = praiseRootDir.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.isDirectory() && PraiseResourceAPSManager.isValidRestoreFileName(file.getName());
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            if (DEBUG) {
                Log.d(TAG, "getRestoreFileList return, praiseRootDir.listFiles = empty");
                return null;
            }
            return null;
        }
        return listFiles;
    }

    public void loadResourcesIfNeeded() {
        if (this.mLoaded) {
            if (DEBUG) {
                Log.d(TAG, "loadResourcesIfNeeded return, mLoaded = true");
                return;
            }
            return;
        }
        File[] restoreFileList = getRestoreFileList();
        if (restoreFileList == null || restoreFileList.length <= 0) {
            if (DEBUG) {
                Log.d(TAG, "loadResourcesIfNeeded return, praiseRootDir.listFiles = empty");
                return;
            }
            return;
        }
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
                    strArr[0] = NightModeHelper.getNightModeSwitcherState() ? "day" : ComboPraiseProvider.DIR_PREFIX_NIGHT;
                    build.loadResource(strArr);
                    restorePraiseResourceInfo.mProvider = build;
                    this.mResourceMap.put(restorePraiseResourceInfo.mPkgName, restorePraiseResourceInfo);
                    this.mLoaded = true;
                    preInitPraiseElements();
                    if (DEBUG) {
                        Log.d(TAG, "loadResourcesIfNeeded success, pkgName = " + restorePraiseResourceInfo.mPkgName);
                    }
                } else if (DEBUG) {
                    Log.d(TAG, "loadResourcesIfNeeded failed, pkgName = " + restorePraiseResourceInfo.mPkgName);
                }
            }
        }
        if (!this.mLoaded && DEBUG) {
            Log.d(TAG, "loadResourcesIfNeeded failed totally");
            for (File file2 : restoreFileList) {
                FileUtils.deleteFile(file2);
            }
        }
    }

    public void releaseResources() {
        if (this.mLoaded) {
            if (this.mResourceMap != null && !this.mResourceMap.isEmpty()) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidRestoreFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(RESTORE_SUFFIX) && lowerCase.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL);
    }

    public boolean hasValidProvider() {
        return (this.mResourceMap == null || this.mResourceMap.isEmpty()) ? false : true;
    }

    public IResourceProvider getProvider(String str) {
        if (!hasValidProvider() || TextUtils.isEmpty(str)) {
            return null;
        }
        PraiseResourceInfo praiseResourceInfo = this.mResourceMap.get(str);
        if (praiseResourceInfo == null) {
            return null;
        }
        return praiseResourceInfo.mProvider;
    }

    private void savePraiseResource(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        if (!praiseResourceInfo.isAvailable()) {
            removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
            praiseInstallResultCb.onResult(1, "praise resource is not available.");
            if (DEBUG) {
                Log.d(TAG, "savePraiseResource failed, praise resource is not available");
                return;
            }
            return;
        }
        IResourceProvider build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(praiseResourceInfo.mPraiseResSavePath).build();
        if (build == null) {
            removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
            praiseInstallResultCb.onResult(1, "failed to build provider.");
            if (DEBUG) {
                Log.d(TAG, "savePraiseResource failed, failed to build provider");
                return;
            }
            return;
        }
        praiseResourceInfo.mProvider = build;
        savePraiseResourceInfo(praiseResourceInfo);
        removeOldResources(praiseResourceInfo);
        if (z && !TextUtils.isEmpty(praiseResourceInfo.mPkgName) && praiseResourceInfo.mPkgName.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL)) {
            String[] strArr = new String[1];
            strArr[0] = NightModeHelper.getNightModeSwitcherState() ? "day" : ComboPraiseProvider.DIR_PREFIX_NIGHT;
            build.loadResource(strArr);
            this.mResourceMap.put(praiseResourceInfo.mPkgName, praiseResourceInfo);
            this.mLoaded = true;
            if (DEBUG) {
                Log.d(TAG, "loadToMem success, pkgName = " + praiseResourceInfo.mPkgName);
            }
        }
        preInitPraiseElements();
        praiseInstallResultCb.onResult(0, "praise install success, loadToMem = " + z);
        if (DEBUG) {
            Log.d(TAG, "praise install success, loadToMem = " + z);
        }
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

    private void savePraiseResourceInfo(PraiseResourceInfo praiseResourceInfo) {
        if (praiseResourceInfo != null) {
            File file = new File(getPraiseRootDir(), praiseResourceInfo.mPkgName + RESTORE_SUFFIX);
            FileUtils.deleteFile(file);
            FileUtils.saveFile(praiseResourceInfo.toJSONString(), file);
        }
    }

    private PraiseResourceInfo restorePraiseResourceInfo(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String readFileData = FileUtils.readFileData(file);
        if (TextUtils.isEmpty(readFileData)) {
            return null;
        }
        return PraiseResourceInfo.valueOf(readFileData);
    }

    private static boolean copyPraiseResourceFile(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb) {
        File praiseResourceDir = getPraiseResourceDir(praiseResourceInfo.mPkgName, String.valueOf(praiseResourceInfo.mVersion));
        if (praiseResourceDir.exists() || praiseResourceDir.mkdirs()) {
            File file = new File(praiseResourceInfo.mDownloadFilePath);
            File file2 = new File(praiseResourceDir, file.getName());
            if (file2.exists()) {
                file2.delete();
            }
            if (file.length() == 0 || FileUtils.copyFile(file, file2) != file.length()) {
                praiseInstallResultCb.onResult(1, "failed to copy praise resource.");
                return false;
            }
            praiseResourceInfo.mPraiseResSavePath = file2.getPath();
            return true;
        }
        praiseInstallResultCb.onResult(1, "make praise resource dir failed.");
        return false;
    }

    private static boolean makePraiseRootDirIfNeeded() {
        File praiseRootDir = getPraiseRootDir();
        if (praiseRootDir.exists()) {
            return true;
        }
        return praiseRootDir.mkdirs();
    }

    private static void removeOldResources(PraiseResourceInfo praiseResourceInfo) {
        removeNoIgnoreResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
    }

    private static void removeNoIgnoreResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getPraiseRootDir(), str);
        if (file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.4
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && PraiseResourceAPSManager.willBeRemovedButIgnore(file2, jArr);
            }
        })) != null) {
            for (File file2 : listFiles) {
                FileUtils.deleteFile(file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private static void removeTargetResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getPraiseRootDir(), str);
        if (file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.5
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && PraiseResourceAPSManager.willBeRemoved(file2, jArr);
            }
        })) != null) {
            for (File file2 : listFiles) {
                FileUtils.deleteFile(file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private static File getPraiseRootDir() {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (DEBUG) {
            Log.d(TAG, "getPraiseRootDir = " + path);
        }
        return new File(path, PRAISE_ROOT_DIR_NAME);
    }

    private static File getPraiseResourceDir(String str, String str2) {
        return new File(getPraiseRootDir(), str + File.separator + str2);
    }

    public static File getPraiseDownloadDir() {
        File file = new File(getPraiseRootDir(), PRAISE_DOWNLOAD_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
