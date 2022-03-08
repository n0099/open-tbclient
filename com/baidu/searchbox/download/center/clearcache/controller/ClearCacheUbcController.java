package com.baidu.searchbox.download.center.clearcache.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.system.Os;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.ZipUtils;
import com.baidu.android.util.sp.PreferenceUtils;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ClearCacheUbcController {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject mExtObject;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2080387844, "Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2080387844, "Lcom/baidu/searchbox/download/center/clearcache/controller/ClearCacheUbcController;");
        }
    }

    public ClearCacheUbcController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean clearFileRule(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                AppConfig.isDebug();
                if (TextUtils.isEmpty(str)) {
                    AppConfig.isDebug();
                    return false;
                }
                if (AppConfig.isDebug()) {
                    String str2 = "targetFilePath: " + str;
                }
                File filesDir = AppRuntime.getAppContext().getFilesDir();
                if (filesDir != null) {
                    filesDir = filesDir.getParentFile();
                }
                String str3 = "";
                String absolutePath = (filesDir == null || !filesDir.exists()) ? "" : filesDir.getAbsolutePath();
                if (AppConfig.isDebug()) {
                    String str4 = "dataFilePath: " + absolutePath;
                }
                File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    externalFilesDir = externalFilesDir.getParentFile();
                }
                String absolutePath2 = (externalFilesDir == null || !externalFilesDir.exists()) ? "" : externalFilesDir.getAbsolutePath();
                if (AppConfig.isDebug()) {
                    String str5 = "externalFilePath: " + absolutePath2;
                }
                if (!TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(absolutePath2)) {
                    if (!str.startsWith(absolutePath) && !str.startsWith(absolutePath2)) {
                        AppConfig.isDebug();
                        return false;
                    }
                    for (File file : DiskUtilKt.getUserAssetFileList()) {
                        if (str.startsWith(file.getAbsolutePath())) {
                            AppConfig.isDebug();
                            return false;
                        }
                    }
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        AppConfig.isDebug();
                        return false;
                    }
                    File filesDir2 = AppRuntime.getAppContext().getFilesDir();
                    String absolutePath3 = (filesDir2 == null || !filesDir2.exists()) ? "" : filesDir2.getAbsolutePath();
                    File cacheDir = AppRuntime.getAppContext().getCacheDir();
                    String absolutePath4 = (cacheDir == null || !cacheDir.exists()) ? "" : cacheDir.getAbsolutePath();
                    File externalFilesDir2 = AppRuntime.getAppContext().getExternalFilesDir(null);
                    String absolutePath5 = (externalFilesDir2 == null || !externalFilesDir2.exists()) ? "" : externalFilesDir2.getAbsolutePath();
                    File externalCacheDir = AppRuntime.getAppContext().getExternalCacheDir();
                    if (externalCacheDir != null && externalCacheDir.exists()) {
                        str3 = externalCacheDir.getAbsolutePath();
                    }
                    String absolutePath6 = file2.getAbsolutePath();
                    if (!TextUtils.equals(absolutePath6, absolutePath) && !TextUtils.equals(absolutePath6, absolutePath2) && !TextUtils.equals(absolutePath6, absolutePath3) && !TextUtils.equals(absolutePath6, absolutePath4) && !TextUtils.equals(absolutePath6, absolutePath5) && !TextUtils.equals(absolutePath6, str3)) {
                        AppConfig.isDebug();
                        return true;
                    }
                    AppConfig.isDebug();
                    return false;
                }
                AppConfig.isDebug();
                return false;
            } catch (Throwable th) {
                if (AppConfig.isDebug()) {
                    String str6 = "Throwable: msg = " + th.getMessage();
                }
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void clearTargetDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                if (sClearTargetDirDone) {
                    sClearTargetDirDone = false;
                    String string = PreferenceUtils.getString(DiskDirToolListener.DISK_DIR_TOOL_DATA, "");
                    boolean z = true;
                    if (TextUtils.isEmpty(string)) {
                        sClearTargetDirDone = true;
                        return;
                    }
                    String str = "targetFileJson: " + string;
                    JSONArray optJSONArray = new JSONObject(string).optJSONArray("dir");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString) && !clearFileRule(optString)) {
                                z = false;
                            }
                        }
                        if (!z) {
                            resetLocalDiskDirData();
                            return;
                        } else {
                            ExecutorUtilsExt.postOnElastic(new Runnable(optJSONArray) { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ JSONArray val$targetFiles;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {optJSONArray};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$targetFiles = optJSONArray;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    StringBuilder sb;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        for (int i3 = 0; i3 < this.val$targetFiles.length(); i3++) {
                                            try {
                                                String optString2 = this.val$targetFiles.optString(i3);
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
                                                    sb.toString();
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                        ClearCacheUbcController.resetLocalDiskDirData();
                                    }
                                }
                            }, "CLEAR_TARGET_DIRS", 3);
                            return;
                        }
                    }
                    resetLocalDiskDirData();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static void reportBaiduFile(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (AppConfig.isDebug()) {
            String str2 = "reportBaiduFile type : " + str;
        }
        ExecutorUtilsExt.postOnElastic(new Runnable(str) { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$type;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$type = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File filesDir = AppRuntime.getAppContext().getFilesDir();
                        if (filesDir == null) {
                            return;
                        }
                        File file = new File(filesDir, "tree_" + this.val$type);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            String appVersionName = ClearCacheUtils.getAppVersionName(AppRuntime.getAppContext());
                            String cuid = AppCuidManager.getInstance().getCuid();
                            if (!TextUtils.isEmpty(cuid) && !TextUtils.isEmpty(appVersionName)) {
                                char c2 = 3;
                                int i2 = 4;
                                fileOutputStream2.write(String.format("android,%s,%s,%s,%s,%s,%s,%s\n", appVersionName, cuid, String.valueOf(StorageUtils.getTotalExternalMemorySize()), String.valueOf(StorageUtils.getAvailableExternalMemorySize()), String.valueOf(Build.VERSION.SDK_INT), "_", DiskManager.INSTANCE.getDiskLevel().toString().toLowerCase()).getBytes());
                                StringBuilder sb = new StringBuilder();
                                LinkedList linkedList = new LinkedList();
                                File filesDir2 = AppRuntime.getAppContext().getFilesDir();
                                if (filesDir2 != null) {
                                    filesDir2 = filesDir2.getParentFile();
                                }
                                String str4 = "";
                                if (filesDir2 == null || !filesDir2.exists()) {
                                    str3 = "";
                                } else {
                                    str3 = filesDir2.getAbsolutePath();
                                    linkedList.offer(filesDir2);
                                }
                                File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    externalFilesDir = externalFilesDir.getParentFile();
                                }
                                if (externalFilesDir != null && externalFilesDir.exists()) {
                                    str4 = externalFilesDir.getAbsolutePath();
                                    linkedList.offer(externalFilesDir);
                                }
                                while (true) {
                                    File file2 = (File) linkedList.poll();
                                    if (file2 == null) {
                                        break;
                                    } else if (file2.exists()) {
                                        String absolutePath = file2.getAbsolutePath();
                                        if (!TextUtils.isEmpty(str3)) {
                                            absolutePath = absolutePath.replace(str3, "0");
                                        }
                                        if (!TextUtils.isEmpty(str4)) {
                                            absolutePath = absolutePath.replace(str4, "1");
                                        }
                                        if (file2.isDirectory()) {
                                            File[] listFiles = file2.listFiles();
                                            if (listFiles != null) {
                                                for (File file3 : listFiles) {
                                                    if (file3 != null && file3.exists()) {
                                                        linkedList.offer(file3);
                                                    }
                                                }
                                            }
                                        } else {
                                            sb.append(absolutePath);
                                            sb.append(",");
                                            sb.append(file2.length());
                                            sb.append(",");
                                            if (!TextUtils.equals(this.val$type, ClearCacheUbcController.REPORT_FILE_TYPE_FISHING_BACK) && !TextUtils.equals(this.val$type, "feedback")) {
                                                if (TextUtils.equals(this.val$type, ClearCacheUbcController.REPORT_FILE_TYPE_COLD_START)) {
                                                    sb.append(Build.VERSION.SDK_INT >= 21 ? Os.lstat(file2.getAbsolutePath()).st_atime : 0L);
                                                    sb.append(",");
                                                }
                                            }
                                            sb.append(file2.lastModified());
                                            sb.append(",");
                                        }
                                        if (sb.length() >= 1024) {
                                            fileOutputStream2.write(sb.toString().getBytes());
                                            sb = new StringBuilder();
                                        }
                                        c2 = 3;
                                        i2 = 4;
                                    }
                                }
                                fileOutputStream2.flush();
                                File file4 = new File(filesDir, "tree_" + this.val$type + ".zip");
                                ZipUtils.zip(file.getAbsolutePath(), file4.getAbsolutePath());
                                file.delete();
                                if (AppConfig.isDebug()) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$0;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                Toast.makeText(AppRuntime.getAppContext(), "开始上传文件目录", 0).show();
                                            }
                                        }
                                    });
                                }
                                String valueOf = String.valueOf(System.currentTimeMillis());
                                Object[] objArr = new Object[i2];
                                objArr[0] = this.val$type;
                                objArr[1] = appVersionName;
                                objArr[2] = cuid;
                                objArr[c2] = valueOf;
                                String format = String.format("disk/%s/%s/%s/%s.zip", objArr);
                                BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(ClearCacheUbcController.BOS_BIZ_TYPE, format, file4);
                                if (AppConfig.isDebug()) {
                                    String str5 = "reportBaiduFile bos fileid : " + format;
                                    if (uploadFileSync == null || !uploadFileSync.isSuccess()) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("reportBaiduFile error : ");
                                        sb2.append(uploadFileSync != null ? uploadFileSync.getMessage() : "entry is null");
                                        sb2.toString();
                                    }
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this, uploadFileSync) { // from class: com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController.1.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$0;
                                        public final /* synthetic */ BOSResponseEntity val$entity;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr2 = {this, uploadFileSync};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$entity = uploadFileSync;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                Context appContext = AppRuntime.getAppContext();
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("上传文件目录");
                                                BOSResponseEntity bOSResponseEntity = this.val$entity;
                                                sb3.append((bOSResponseEntity == null || !bOSResponseEntity.isSuccess()) ? "失败" : "成功");
                                                Toast.makeText(appContext, sb3.toString(), 0).show();
                                            }
                                        }
                                    });
                                }
                                file4.delete();
                                Closeables.closeSafely(fileOutputStream2);
                                return;
                            }
                            AppConfig.isDebug();
                            Closeables.closeSafely(fileOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (AppConfig.isDebug()) {
                                e.printStackTrace();
                            }
                            if (fileOutputStream != null) {
                                Closeables.closeSafely(fileOutputStream);
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                Closeables.closeSafely(fileOutputStream);
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }, SCAN_BAIDU_FILE_TASK_NAME, 3);
    }

    public static void resetLocalDiskDirData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            PreferenceUtils.setString(DiskDirToolListener.DISK_DIR_TOOL_DATA, "");
            sClearTargetDirDone = true;
        }
    }

    public static void toDownloadCenterToUBC(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65543, null, j2, str) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("from", FROM_VALUE);
                jSONObject.put("type", "click");
                jSONObject.put("value", VALUE_DOWNLOADED_FILE);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject2.put(DOCUMENT, j2 / 1024);
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
        }
    }

    public static void toFeedBackToUBC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", FROM_VALUE);
                jSONObject.put("type", "click");
                jSONObject.put("value", "feedback");
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("source", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
        }
    }

    public static void ubc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", FROM_VALUE);
                jSONObject.put("type", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("total", StorageUtils.getTotalExternalMemorySize());
                jSONObject2.put("free", StorageUtils.getAvailableExternalMemorySize());
                jSONObject.putOpt("ext", jSONObject2);
                if (AppConfig.isDebug()) {
                    jSONObject.toString();
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void cleanConfirmToUBC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
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
                    jSONObject.toString();
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void clearCacheTOUBC(String str, long j2, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), jSONObject, str2}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", FROM_VALUE);
                jSONObject2.put("type", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("source", str2);
                }
                if (TextUtils.equals(str, "clean")) {
                    if (this.mExtObject != null) {
                        this.mExtObject.put(DOCUMENT, j2 / 1024);
                        this.mExtObject.put("total", StorageUtils.getTotalExternalMemorySize());
                        this.mExtObject.put("free", StorageUtils.getAvailableExternalMemorySize());
                    }
                    jSONObject2.putOpt("ext", jSONObject);
                }
                if (AppConfig.isDebug()) {
                    jSONObject2.toString();
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject2);
                this.mExtObject = null;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void putExtObject(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            if (this.mExtObject == null) {
                this.mExtObject = new JSONObject();
            }
            try {
                this.mExtObject.put(str, j2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void reportCleanCacheToUBC(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, str) == null) {
            clearCacheTOUBC("clean", j2, this.mExtObject, str);
        }
    }

    public void scanToUBC(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
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
                    jSONObject2.toString();
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void showToUBC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
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
                    jSONObject.toString();
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_CLEAN_CACHE, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
