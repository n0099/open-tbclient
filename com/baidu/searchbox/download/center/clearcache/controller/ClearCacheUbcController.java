package com.baidu.searchbox.download.center.clearcache.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.ZipUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.DiskDirToolListener;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.download.center.clearcache.DiskUtilKt;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.ubc.UBCManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ClearCacheUbcController {
    public static final String BOS_BIZ_TYPE = "basis-functions";
    public static final String CLEAN = "clean";
    public static final String CLEAN_CONFIRM = "clean_confirm";
    public static final String DATA_FILE_PATH_VALUE = "0";
    public static final String DOCUMENT = "document";
    public static final String EXT = "ext";
    public static final String EXTERNAL_FILE_PATH_VALUE = "1";
    public static final String FREE = "free";
    public static final String FROM = "from";
    public static final String FROM_VALUE = "tool";
    public static final String ITEMS = "items";
    public static final String REPORT_FILE_TYPE_CLEAN_DONE = "cleandone";
    public static final String REPORT_FILE_TYPE_COLD_START = "coldstart";
    public static final String REPORT_FILE_TYPE_FEEDBACK_DONE = "feedback";
    public static final String REPORT_FILE_TYPE_FISHING_BACK = "fishingback";
    public static final String REPORT_FILE_TYPE_WARNING = "warning";
    public static final String SCAN = "scan";
    public static final String SCAN_BAIDU_FILE_TASK_NAME = "scan_baidu_file";
    public static final String SHOW = "show";
    public static final String SOURCE = "source";
    public static final String TAG = "ClearCacheUBC";
    public static final String TOTAL = "total";
    public static final String TYPE = "type";
    public static final String TYPE_VALUE_CLEAN = "clean";
    public static final String TYPE_VALUE_CLICK = "click";
    public static final String UBC_CLEAN_CACHE = "570";
    public static final String VALUE = "value";
    public static final String VALUE_DOWNLOADED_FILE = "downloaded_file";
    public static final String VALUE_FEEDBACK = "feedback";
    public static volatile boolean sClearTargetDirDone = true;
    public JSONObject mExtObject;

    public static void resetLocalDiskDirData() {
        PreferenceUtils.setString(DiskDirToolListener.DISK_DIR_TOOL_DATA, "");
        sClearTargetDirDone = true;
    }

    public static boolean clearFileRule(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "clearFileRule: ");
            }
            if (TextUtils.isEmpty(str)) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "fail: targetFilePath is null");
                }
                return false;
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "targetFilePath: " + str);
            }
            File filesDir = AppRuntime.getAppContext().getFilesDir();
            if (filesDir != null) {
                filesDir = filesDir.getParentFile();
            }
            String str7 = "";
            if (filesDir == null || !filesDir.exists()) {
                str2 = "";
            } else {
                str2 = filesDir.getAbsolutePath();
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "dataFilePath: " + str2);
            }
            File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                externalFilesDir = externalFilesDir.getParentFile();
            }
            if (externalFilesDir == null || !externalFilesDir.exists()) {
                str3 = "";
            } else {
                str3 = externalFilesDir.getAbsolutePath();
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "externalFilePath: " + str3);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (!str.startsWith(str2) && !str.startsWith(str3)) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "fail: targetFilePath must not be data/data or 外置sd私有目录");
                    }
                    return false;
                }
                for (File file : DiskUtilKt.getUserAssetFileList()) {
                    if (str.startsWith(file.getAbsolutePath())) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "fail: targetFilePath must not be userAssetDir");
                        }
                        return false;
                    }
                }
                File file2 = new File(str);
                if (!file2.exists()) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "fail: targetFilePath is not exist");
                    }
                    return false;
                }
                File filesDir2 = AppRuntime.getAppContext().getFilesDir();
                if (filesDir2 == null || !filesDir2.exists()) {
                    str4 = "";
                } else {
                    str4 = filesDir2.getAbsolutePath();
                }
                File cacheDir = AppRuntime.getAppContext().getCacheDir();
                if (cacheDir == null || !cacheDir.exists()) {
                    str5 = "";
                } else {
                    str5 = cacheDir.getAbsolutePath();
                }
                File externalFilesDir2 = AppRuntime.getAppContext().getExternalFilesDir(null);
                if (externalFilesDir2 == null || !externalFilesDir2.exists()) {
                    str6 = "";
                } else {
                    str6 = externalFilesDir2.getAbsolutePath();
                }
                File externalCacheDir = AppRuntime.getAppContext().getExternalCacheDir();
                if (externalCacheDir != null && externalCacheDir.exists()) {
                    str7 = externalCacheDir.getAbsolutePath();
                }
                String absolutePath = file2.getAbsolutePath();
                if (!TextUtils.equals(absolutePath, str2) && !TextUtils.equals(absolutePath, str3) && !TextUtils.equals(absolutePath, str4) && !TextUtils.equals(absolutePath, str5) && !TextUtils.equals(absolutePath, str6) && !TextUtils.equals(absolutePath, str7)) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "success: targetFilePath can be deleted");
                        return true;
                    }
                    return true;
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "fail: targetFilePath must not be files/cache directly");
                }
                return false;
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "fail: dataFilePath or externalFilePath is null");
            }
            return false;
        } catch (Throwable th) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "Throwable: msg = " + th.getMessage());
            }
            th.printStackTrace();
            return false;
        }
    }

    public static void clearTargetDir() {
        Log.d(TAG, "clearTargetDir: ");
        try {
            if (!sClearTargetDirDone) {
                return;
            }
            sClearTargetDirDone = false;
            String string = PreferenceUtils.getString(DiskDirToolListener.DISK_DIR_TOOL_DATA, "");
            boolean z = true;
            if (TextUtils.isEmpty(string)) {
                sClearTargetDirDone = true;
                return;
            }
            Log.d(TAG, "targetFileJson: " + string);
            final JSONArray optJSONArray = new JSONObject(string).optJSONArray(MapBundleKey.MapObjKey.OBJ_DIR);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString) && !clearFileRule(optString)) {
                        z = false;
                    }
                }
                if (!z) {
                    resetLocalDiskDirData();
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.2
                        @Override // java.lang.Runnable
                        public void run() {
                            StringBuilder sb;
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                try {
                                    String optString2 = optJSONArray.optString(i2);
                                    if (!TextUtils.isEmpty(optString2)) {
                                        if (FileUtils.deleteFile(optString2)) {
                                            sb = new StringBuilder();
                                            sb.append(optString2);
                                            sb.append(" deleted success");
                                        } else {
                                            sb = new StringBuilder();
                                            sb.append(optString2);
                                            sb.append(" deleted failed");
                                        }
                                        Log.d(ClearCacheUbcController.TAG, sb.toString());
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            ClearCacheUbcController.resetLocalDiskDirData();
                        }
                    }, "CLEAR_TARGET_DIRS", 3);
                    return;
                }
            }
            resetLocalDiskDirData();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static void reportBaiduFile(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "reportBaiduFile type : " + str);
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1
            /* JADX WARN: Removed duplicated region for block: B:110:0x02a7  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                FileOutputStream fileOutputStream;
                String str2;
                String str3;
                String str4;
                File file;
                File file2;
                long j;
                String str5 = "tree_";
                try {
                    File filesDir = AppRuntime.getAppContext().getFilesDir();
                    if (filesDir == null) {
                        return;
                    }
                    File file3 = new File(filesDir, "tree_" + str);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    try {
                        String appVersionName = ClearCacheUtils.getAppVersionName(AppRuntime.getAppContext());
                        String cuid = AppCuidManager.getInstance().getCuid();
                        if (!TextUtils.isEmpty(cuid) && !TextUtils.isEmpty(appVersionName)) {
                            int i = 4;
                            fileOutputStream2.write(String.format("android,%s,%s,%s,%s,%s,%s,%s\n", appVersionName, cuid, String.valueOf(StorageUtils.getTotalExternalMemorySize()), String.valueOf(StorageUtils.getAvailableExternalMemorySize()), String.valueOf(Build.VERSION.SDK_INT), "_", DiskManager.INSTANCE.getDiskLevel().toString().toLowerCase()).getBytes());
                            StringBuilder sb = new StringBuilder();
                            LinkedList linkedList = new LinkedList();
                            File filesDir2 = AppRuntime.getAppContext().getFilesDir();
                            if (filesDir2 != null) {
                                filesDir2 = filesDir2.getParentFile();
                            }
                            String str6 = "";
                            if (filesDir2 == null || !filesDir2.exists()) {
                                str2 = "";
                            } else {
                                str2 = filesDir2.getAbsolutePath();
                                linkedList.offer(filesDir2);
                            }
                            File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
                            if (externalFilesDir != null) {
                                externalFilesDir = externalFilesDir.getParentFile();
                            }
                            if (externalFilesDir != null && externalFilesDir.exists()) {
                                str6 = externalFilesDir.getAbsolutePath();
                                linkedList.offer(externalFilesDir);
                            }
                            while (true) {
                                File file4 = (File) linkedList.poll();
                                if (file4 == null) {
                                    break;
                                } else if (file4.exists()) {
                                    String absolutePath = file4.getAbsolutePath();
                                    if (!TextUtils.isEmpty(str2)) {
                                        absolutePath = absolutePath.replace(str2, "0");
                                    }
                                    if (!TextUtils.isEmpty(str6)) {
                                        absolutePath = absolutePath.replace(str6, "1");
                                    }
                                    if (file4.isDirectory()) {
                                        File[] listFiles = file4.listFiles();
                                        if (listFiles != null) {
                                            int length = listFiles.length;
                                            int i2 = 0;
                                            while (i2 < length) {
                                                String str7 = str5;
                                                File file5 = listFiles[i2];
                                                if (file5 != null && file5.exists()) {
                                                    linkedList.offer(file5);
                                                }
                                                i2++;
                                                str5 = str7;
                                            }
                                        }
                                        str4 = str5;
                                        file = filesDir;
                                        file2 = file3;
                                    } else {
                                        str4 = str5;
                                        sb.append(absolutePath);
                                        sb.append(",");
                                        file = filesDir;
                                        file2 = file3;
                                        sb.append(file4.length());
                                        sb.append(",");
                                        if (!TextUtils.equals(str, ClearCacheUbcController.REPORT_FILE_TYPE_FISHING_BACK) && !TextUtils.equals(str, "feedback")) {
                                            if (TextUtils.equals(str, ClearCacheUbcController.REPORT_FILE_TYPE_COLD_START)) {
                                                if (Build.VERSION.SDK_INT >= 21) {
                                                    j = Os.lstat(file4.getAbsolutePath()).st_atime;
                                                } else {
                                                    j = 0;
                                                }
                                                sb.append(j);
                                                sb.append(",");
                                            }
                                        }
                                        sb.append(file4.lastModified());
                                        sb.append(",");
                                    }
                                    if (sb.length() >= 1024) {
                                        fileOutputStream2.write(sb.toString().getBytes());
                                        sb = new StringBuilder();
                                    }
                                    filesDir = file;
                                    file3 = file2;
                                    str5 = str4;
                                    i = 4;
                                }
                            }
                            fileOutputStream2.flush();
                            File file6 = new File(filesDir, str5 + str + ".zip");
                            ZipUtils.zip(file3.getAbsolutePath(), file6.getAbsolutePath());
                            file3.delete();
                            if (AppConfig.isDebug()) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Toast.makeText(AppRuntime.getAppContext(), "开始上传文件目录", 0).show();
                                    }
                                });
                            }
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            Object[] objArr = new Object[i];
                            objArr[0] = str;
                            objArr[1] = appVersionName;
                            objArr[2] = cuid;
                            objArr[3] = valueOf;
                            String format = String.format("disk/%s/%s/%s/%s.zip", objArr);
                            final BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(ClearCacheUbcController.BOS_BIZ_TYPE, format, file6);
                            if (AppConfig.isDebug()) {
                                Log.d(ClearCacheUbcController.TAG, "reportBaiduFile bos fileid : " + format);
                                if (uploadFileSync != null && uploadFileSync.isSuccess()) {
                                    Log.d(ClearCacheUbcController.TAG, "reportBaiduFile success");
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("reportBaiduFile error : ");
                                    if (uploadFileSync != null) {
                                        str3 = uploadFileSync.getMessage();
                                    } else {
                                        str3 = "entry is null";
                                    }
                                    sb2.append(str3);
                                    Log.d(ClearCacheUbcController.TAG, sb2.toString());
                                }
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String str8;
                                        Context appContext = AppRuntime.getAppContext();
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("上传文件目录");
                                        BOSResponseEntity bOSResponseEntity = uploadFileSync;
                                        if (bOSResponseEntity != null && bOSResponseEntity.isSuccess()) {
                                            str8 = "成功";
                                        } else {
                                            str8 = "失败";
                                        }
                                        sb3.append(str8);
                                        Toast.makeText(appContext, sb3.toString(), 0).show();
                                    }
                                });
                            }
                            file6.delete();
                            Closeables.closeSafely(fileOutputStream2);
                            return;
                        }
                        if (AppConfig.isDebug()) {
                            Log.d(ClearCacheUbcController.TAG, "cuid or appVersion is null! cancel");
                        }
                        Closeables.closeSafely(fileOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            if (AppConfig.isDebug()) {
                                e.printStackTrace();
                            }
                            if (fileOutputStream != null) {
                                Closeables.closeSafely(fileOutputStream);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                Closeables.closeSafely(fileOutputStream);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            }
        }, SCAN_BAIDU_FILE_TASK_NAME, 3);
    }

    public static void toDownloadCenterToUBC(long j, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("from", FROM_VALUE);
            jSONObject.put("type", "click");
            jSONObject.put("value", VALUE_DOWNLOADED_FILE);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("source", str);
            }
            jSONObject2.put(DOCUMENT, j / 1024);
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
    }

    public static void toFeedBackToUBC(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", FROM_VALUE);
            jSONObject.put("type", "click");
            jSONObject.put("value", "feedback");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("source", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
    }

    public static void ubc(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", FROM_VALUE);
            jSONObject.put("type", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("total", StorageUtils.getTotalExternalMemorySize());
            jSONObject2.put("free", StorageUtils.getAvailableExternalMemorySize());
            jSONObject.putOpt("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showToUBC(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", FROM_VALUE);
            jSONObject.put("type", "show");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("source", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("total", StorageUtils.getTotalExternalMemorySize());
            jSONObject2.put("free", StorageUtils.getAvailableExternalMemorySize());
            jSONObject.putOpt("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cleanConfirmToUBC(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", FROM_VALUE);
            jSONObject.put("type", CLEAN_CONFIRM);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("source", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("total", StorageUtils.getTotalExternalMemorySize());
            jSONObject2.put("free", StorageUtils.getAvailableExternalMemorySize());
            jSONObject.putOpt("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    public void clearCacheTOUBC(String str, long j, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", FROM_VALUE);
            jSONObject2.put("type", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("source", str2);
            }
            if (TextUtils.equals(str, "clean")) {
                if (this.mExtObject != null) {
                    this.mExtObject.put(DOCUMENT, j / 1024);
                    this.mExtObject.put("total", StorageUtils.getTotalExternalMemorySize());
                    this.mExtObject.put("free", StorageUtils.getAvailableExternalMemorySize());
                }
                jSONObject2.putOpt("ext", jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject2.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject2);
            this.mExtObject = null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void putExtObject(String str, long j) {
        if (this.mExtObject == null) {
            this.mExtObject = new JSONObject();
        }
        try {
            this.mExtObject.put(str, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void reportCleanCacheToUBC(long j, String str) {
        clearCacheTOUBC("clean", j, this.mExtObject, str);
    }

    public void scanToUBC(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("from", FROM_VALUE);
            jSONObject2.put("type", SCAN);
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("source", str);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("total", StorageUtils.getTotalExternalMemorySize());
            jSONObject3.put("free", StorageUtils.getAvailableExternalMemorySize());
            jSONObject3.put("items", jSONObject);
            jSONObject2.putOpt("ext", jSONObject3);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject2.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
