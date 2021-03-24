package com.baidu.spswitch.emotion.resource;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.EmotionUsageUtil;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.spswitch.utils.SPConfig;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class EmotionAPSManager {
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final String EMOTION_DOWNLOAD_DIR_NAME = "download";
    public static final int EMOTION_INSTALL_FAILED = 1;
    public static final int EMOTION_INSTALL_SUCCESS = 0;
    public static final String EMOTION_PACKAGE_NAME_FOR_NORMAL = "com.baidu.spswitch.emotion";
    public static final String EMOTION_PRESET_PATH = "emotion/com.baidu.spswitch.emotion.preset.zip";
    public static final String EMOTION_ROOT_DIR_NAME = "emotion_root";
    public static final long MOCK_VERSION = -2;
    public static final long PRESET_VERSION = -1;
    public static final String RESTORE_SUFFIX = "_lastest.json";
    public static final String TAG = "EmotionAPSManager";
    public boolean mIsDebugLoadMode;
    public volatile boolean mLoaded;
    public Map<String, EmotionResourceInfo> mResourceMap;

    /* loaded from: classes3.dex */
    public interface EmotionInstallResultCb {
        void onResult(int i, String str);
    }

    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final EmotionAPSManager sINSTANCE = new EmotionAPSManager();
    }

    static {
        try {
            Class.forName(EmotionUsageUtil.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean copyEmotionResourceFile(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb) {
        FileOutputStream fileOutputStream;
        File emotionResourceDir = getEmotionResourceDir(emotionResourceInfo.mPkgName, String.valueOf(emotionResourceInfo.mVersion));
        if (!emotionResourceDir.exists() && !emotionResourceDir.mkdirs()) {
            emotionInstallResultCb.onResult(1, "make emotion resource dir failed.");
            return false;
        }
        File file = new File(emotionResourceInfo.mDownloadFilePath);
        File file2 = new File(emotionResourceDir, file.getName());
        if (file2.exists()) {
            file2.delete();
        }
        if (emotionResourceInfo.mVersion == -1) {
            InputStream inputStream = null;
            try {
                InputStream open = AppRuntime.getAppContext().getAssets().open(emotionResourceInfo.mDownloadFilePath);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        if (FileUtils.copyStream(open, fileOutputStream) == 0) {
                            emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
                            Closeables.closeSafely(open);
                            Closeables.closeSafely(fileOutputStream);
                            return false;
                        }
                        Closeables.closeSafely(open);
                        Closeables.closeSafely(fileOutputStream);
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = open;
                        try {
                            e.printStackTrace();
                            emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = open;
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } else if (file.length() == 0 || FileUtils.copyFile(file, file2) != file.length()) {
            emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
            return false;
        }
        emotionResourceInfo.mEmotionResSavePath = file2.getPath();
        return true;
    }

    public static File getEmotionDownloadDir() {
        File file = new File(getEmotionRootDir(), "download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getEmotionResourceDir(String str, String str2) {
        File emotionRootDir = getEmotionRootDir();
        return new File(emotionRootDir, str + File.separator + str2);
    }

    public static File getEmotionRootDir() {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (DEBUG) {
            Log.d(TAG, "getEmotionRootDir = " + path);
        }
        return new File(path, EMOTION_ROOT_DIR_NAME);
    }

    public static final EmotionAPSManager getInstance() {
        return Holder.sINSTANCE;
    }

    public static File[] getRestoreFileList() {
        File emotionRootDir = getEmotionRootDir();
        if (!emotionRootDir.exists()) {
            if (DEBUG) {
                Log.d(TAG, "getRestoreFileList return, emotionRootDir.exists = false");
            }
            return null;
        }
        File[] listFiles = emotionRootDir.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.isDirectory() && EmotionAPSManager.isValidRestoreFileName(file.getName());
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            if (DEBUG) {
                Log.d(TAG, "getRestoreFileList return, emotionRootDir.listFiles = empty");
            }
            return null;
        }
        return listFiles;
    }

    public static boolean hasPresetRestoreFile(File[] fileArr) {
        if (fileArr != null && fileArr.length > 0) {
            for (File file : fileArr) {
                EmotionResourceInfo restoreEmotionResourceInfo = restoreEmotionResourceInfo(file);
                if (restoreEmotionResourceInfo != null && restoreEmotionResourceInfo.mVersion == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidRestoreFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(RESTORE_SUFFIX) && lowerCase.contains(EMOTION_PACKAGE_NAME_FOR_NORMAL);
    }

    public static boolean makeEmotionRootDirIfNeeded() {
        File emotionRootDir = getEmotionRootDir();
        if (emotionRootDir.exists()) {
            return true;
        }
        return emotionRootDir.mkdirs();
    }

    public static void removeNoIgnoreResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getEmotionRootDir(), str);
        if (file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.4
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && EmotionAPSManager.willBeRemovedButIgnore(file2, jArr);
            }
        })) != null) {
            for (File file2 : listFiles) {
                FileUtils.deleteFile(file2);
            }
        }
    }

    public static void removeOldResources(EmotionResourceInfo emotionResourceInfo) {
        removeNoIgnoreResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
    }

    public static void removeTargetResources(String str, final long... jArr) {
        File[] listFiles;
        File file = new File(getEmotionRootDir(), str);
        if (file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.5
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && EmotionAPSManager.willBeRemoved(file2, jArr);
            }
        })) != null) {
            for (File file2 : listFiles) {
                FileUtils.deleteFile(file2);
            }
        }
    }

    public static EmotionResourceInfo restoreEmotionResourceInfo(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String readFileData = FileUtils.readFileData(file);
        if (TextUtils.isEmpty(readFileData)) {
            return null;
        }
        return EmotionResourceInfo.valueOf(readFileData);
    }

    private void saveEmotionResource(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb, boolean z) {
        boolean z2;
        IResourceProvider iResourceProvider;
        if (!emotionResourceInfo.isAvailable()) {
            removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
            emotionInstallResultCb.onResult(1, "emotion resource is not available.");
            if (DEBUG) {
                Log.d(TAG, "saveEmotionResource failed, emotion resource is not available");
                return;
            }
            return;
        }
        IResourceProvider build = new EmotionResourceProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(emotionResourceInfo.mEmotionResSavePath).build();
        if (build == null) {
            removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
            emotionInstallResultCb.onResult(1, "failed to build provider.");
            if (DEBUG) {
                Log.d(TAG, "saveEmotionResource failed, failed to build provider");
                return;
            }
            return;
        }
        emotionResourceInfo.mProvider = build;
        EmotionResourceInfo emotionResourceInfo2 = this.mResourceMap.get(emotionResourceInfo.mPkgName);
        if (z) {
            if (TextUtils.isEmpty(emotionResourceInfo.mPkgName) || !emotionResourceInfo.mPkgName.contains(EMOTION_PACKAGE_NAME_FOR_NORMAL)) {
                z2 = false;
            } else {
                build.loadResource();
                z2 = EmotionUtils.getInstance().loadEmotionInfo(build);
                if (z2) {
                    if (emotionResourceInfo2 != null && (iResourceProvider = emotionResourceInfo2.mProvider) != null) {
                        iResourceProvider.releaseResource();
                    }
                    this.mResourceMap.put(emotionResourceInfo.mPkgName, emotionResourceInfo);
                    this.mLoaded = true;
                    if (DEBUG) {
                        Log.d(TAG, "loadToMem success, pkgName = " + emotionResourceInfo.mPkgName);
                    }
                }
            }
            if (z2) {
                removeOldResources(emotionResourceInfo);
                saveEmotionResourceInfo(emotionResourceInfo);
                emotionInstallResultCb.onResult(0, "emotion install success, loadToMem = " + z);
                if (DEBUG) {
                    Log.d(TAG, "emotion install success, loadToMem = " + z);
                    return;
                }
                return;
            }
            build.releaseResource();
            removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
            emotionInstallResultCb.onResult(1, "failed to load EmotionInfo.");
            if (DEBUG) {
                Log.d(TAG, "saveEmotionResource failed, failed to load EmotionInfo");
                return;
            }
            return;
        }
        removeOldResources(emotionResourceInfo);
        saveEmotionResourceInfo(emotionResourceInfo);
        emotionInstallResultCb.onResult(0, "emotion install success, loadToMem = " + z);
        if (DEBUG) {
            Log.d(TAG, "emotion install success, loadToMem = " + z);
        }
    }

    private void saveEmotionResourceInfo(EmotionResourceInfo emotionResourceInfo) {
        if (emotionResourceInfo == null) {
            return;
        }
        File emotionRootDir = getEmotionRootDir();
        File file = new File(emotionRootDir, emotionResourceInfo.mPkgName + RESTORE_SUFFIX);
        FileUtils.deleteFile(file);
        FileUtils.saveFile(emotionResourceInfo.toJSONString(), file);
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

    public void doAPSProcess(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb, boolean z) {
        if (emotionResourceInfo != null && emotionInstallResultCb != null) {
            if (!emotionResourceInfo.isValid()) {
                emotionInstallResultCb.onResult(1, "emotionInfo invalid.");
                if (DEBUG) {
                    Log.d(TAG, "doAPSProcess failed, emotionInfo invalid");
                }
            } else if (makeEmotionRootDirIfNeeded() && copyEmotionResourceFile(emotionResourceInfo, emotionInstallResultCb)) {
                saveEmotionResource(emotionResourceInfo, emotionInstallResultCb, z);
            } else {
                emotionInstallResultCb.onResult(1, "failed to make emotion root dir or copyEmotionResourceFile.");
                if (DEBUG) {
                    Log.d(TAG, "doAPSProcess failed, failed to make praise root dir or copyEmotionResourceFile");
                }
            }
        } else if (DEBUG) {
            Log.d(TAG, "doAPSProcess failed, both emotionInfo and callback must not be null");
        }
    }

    public IResourceProvider getProvider(String str) {
        EmotionResourceInfo emotionResourceInfo;
        if (!hasValidProvider() || TextUtils.isEmpty(str) || (emotionResourceInfo = this.mResourceMap.get(str)) == null) {
            return null;
        }
        return emotionResourceInfo.mProvider;
    }

    public String getResourceDebugInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("表情APS根目录:" + getEmotionRootDir().getPath());
        sb.append("\n合法资源清单:\n");
        Map<String, EmotionResourceInfo> map = this.mResourceMap;
        int i = 1;
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, EmotionResourceInfo>> it = this.mResourceMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                EmotionResourceInfo value = it.next().getValue();
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
                    sb.append("\n包存储路径:" + value.mEmotionResSavePath);
                    i++;
                }
            }
        } else {
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                i = 0;
            }
            sb.append("\n暂无\n");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n表情资源: ");
            sb3.append(i != 0 ? "下载失败\n" : "下载成功\n");
            sb.append(sb3.toString());
        }
        return sb.toString();
    }

    public boolean hasValidProvider() {
        Map<String, EmotionResourceInfo> map = this.mResourceMap;
        return (map == null || map.isEmpty()) ? false : true;
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

    public void loadResourcesIfNeeded() {
        IResourceProvider iResourceProvider;
        if (this.mLoaded) {
            if (DEBUG) {
                Log.d(TAG, "loadResourcesIfNeeded return, mLoaded = true");
                return;
            }
            return;
        }
        File[] restoreFileList = getRestoreFileList();
        if (restoreFileList != null && restoreFileList.length > 0) {
            int length = restoreFileList.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                File file = restoreFileList[i];
                EmotionResourceInfo restoreEmotionResourceInfo = restoreEmotionResourceInfo(file);
                if (restoreEmotionResourceInfo != null) {
                    EmotionResourceInfo emotionResourceInfo = this.mResourceMap.get(restoreEmotionResourceInfo.mPkgName);
                    IResourceProvider build = new EmotionResourceProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restoreEmotionResourceInfo.mEmotionResSavePath).build();
                    if (build != null) {
                        build.loadResource();
                        restoreEmotionResourceInfo.mProvider = build;
                        if (EmotionUtils.getInstance().loadEmotionInfo(build)) {
                            if (emotionResourceInfo != null && (iResourceProvider = emotionResourceInfo.mProvider) != null) {
                                iResourceProvider.releaseResource();
                            }
                            this.mResourceMap.put(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo);
                            this.mLoaded = true;
                            if (DEBUG) {
                                Log.d(TAG, "loadResourcesIfNeeded success, pkgName = " + restoreEmotionResourceInfo.mPkgName);
                            }
                        } else {
                            build.releaseResource();
                            removeTargetResources(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo.mVersion);
                            FileUtils.deleteFile(file);
                            if (DEBUG) {
                                Log.d(TAG, "loadResourcesIfNeeded failed1, pkgName = " + restoreEmotionResourceInfo.mPkgName);
                            }
                        }
                    } else {
                        removeTargetResources(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo.mVersion);
                        FileUtils.deleteFile(file);
                        if (DEBUG) {
                            Log.d(TAG, "loadResourcesIfNeeded failed2, pkgName = " + restoreEmotionResourceInfo.mPkgName);
                        }
                    }
                } else {
                    FileUtils.deleteFile(file);
                }
                i++;
            }
            if (this.mLoaded || !DEBUG) {
                return;
            }
            Log.d(TAG, "loadResourcesIfNeeded failed totally");
        } else if (DEBUG) {
            Log.d(TAG, "loadResourcesIfNeeded return, emotionRootDir.listFiles = empty");
        }
    }

    public void mockDoAPSProcess() {
        doAPSProcess(new EmotionResourceInfo(EMOTION_PACKAGE_NAME_FOR_NORMAL, Environment.getExternalStorageDirectory().getPath() + File.separator + "emotion.zip", "", -2L, "0.0.0.0", "255.255.255.255"), new EmotionInstallResultCb() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.1
            @Override // com.baidu.spswitch.emotion.resource.EmotionAPSManager.EmotionInstallResultCb
            public void onResult(int i, String str) {
            }
        }, true);
    }

    public void presetDoAPSProcess() {
        doAPSProcess(new EmotionResourceInfo(EMOTION_PACKAGE_NAME_FOR_NORMAL, EMOTION_PRESET_PATH, "", -1L, "0.0.0.0", "255.255.255.255"), new EmotionInstallResultCb() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.2
            @Override // com.baidu.spswitch.emotion.resource.EmotionAPSManager.EmotionInstallResultCb
            public void onResult(int i, String str) {
            }
        }, true);
    }

    public void releaseResources() {
        if (this.mLoaded) {
            Map<String, EmotionResourceInfo> map = this.mResourceMap;
            if (map != null && !map.isEmpty()) {
                Iterator<Map.Entry<String, EmotionResourceInfo>> it = this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    EmotionResourceInfo value = it.next().getValue();
                    if (value != null) {
                        value.mProvider.releaseResource();
                        value.mProvider = null;
                    }
                }
                this.mResourceMap.clear();
            }
            this.mLoaded = false;
        }
    }

    public void setDebugLoadMode(boolean z) {
        if (DEBUG) {
            this.mIsDebugLoadMode = z;
            if (EmotionDownloadRuntime.getDownloadImpl() != null) {
                EmotionDownloadRuntime.getDownloadImpl().downloadRetryImmediately();
            }
        }
    }

    public EmotionAPSManager() {
        this.mIsDebugLoadMode = false;
        this.mResourceMap = new ConcurrentHashMap();
    }
}
