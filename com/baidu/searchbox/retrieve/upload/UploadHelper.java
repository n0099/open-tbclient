package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.FileZipUtil;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.LoggerManager;
import com.repackage.fb9;
import com.repackage.gb9;
import com.repackage.ib9;
import com.repackage.jb9;
import com.repackage.ra9;
import com.repackage.sa9;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UploadHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHAR_UNDERLINE = "_";
    public static final boolean DEBUG;
    public static final String FILTER_ALL_DEFAULT = "*";
    public static final String FILTER_DIVIDER_DEFAULT = "/";
    public static final String LOG_FILE_FETCHZIP_SUFFIX = ".zip";
    public static final String LOG_FILE_FETCH_ZIP_PATH = "/.fetch_zip";
    public static final String LOG_FILE_SNAP_PATH = "/.yalog_snap";
    public static final boolean SNAP_SHOT_FLUSH_DEFAULT = true;
    public static final String TAG = "FetchLogUpload";
    public static final String UPLOAD_RESULT_VALID = "1";
    public static ExecutorService mExecutorService;
    public static volatile UploadHelper sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public gb9 mVoyager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1831820439, "Lcom/baidu/searchbox/retrieve/upload/UploadHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1831820439, "Lcom/baidu/searchbox/retrieve/upload/UploadHelper;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public UploadHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        mExecutorService = Executors.newSingleThreadExecutor();
        if (this.mVoyager == null) {
            this.mVoyager = (gb9) ServiceManager.getService(gb9.a);
        }
    }

    private boolean checkValid(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? !TextUtils.isEmpty(str) && str.endsWith(".log") && j < j2 && j <= System.currentTimeMillis() : invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashSet<String> getFetchDirSet(long j, long j2, List<String> list) {
        InterceptResult invokeCommon;
        File[] listFiles;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list})) == null) {
            String baseDir = LoggerManager.getBaseDir();
            HashSet<String> hashSet = new HashSet<>();
            if (list != null && list.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        int indexOf = next.indexOf("/");
                        if (indexOf == -1) {
                            substring = "";
                        } else {
                            String substring2 = next.substring(0, indexOf);
                            substring = next.substring(indexOf + 1);
                            next = substring2;
                        }
                        List<String> queryLogFiles = LoggerManager.queryLogFiles(j / 1000, j2 / 1000, TextUtils.isEmpty(next) ? "*" : next, TextUtils.isEmpty(substring) ? "*" : substring);
                        if (queryLogFiles != null && queryLogFiles.size() != 0) {
                            Iterator<String> it2 = queryLogFiles.iterator();
                            while (it2.hasNext()) {
                                hashSet.add(baseDir + File.separator + it2.next());
                            }
                        }
                    }
                }
            } else {
                File file = new File(baseDir);
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.isDirectory()) {
                            hashSet.add(baseDir + File.separatorChar + file2.getName());
                        }
                    }
                }
            }
            if (DEBUG) {
                Log.d(TAG, "fetchDirList size is: " + hashSet.size());
                Log.d(TAG, "fetchDirList: " + Arrays.asList(hashSet));
            }
            return hashSet;
        }
        return (HashSet) invokeCommon.objValue;
    }

    public static UploadHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (sSingleton == null) {
                synchronized (UploadHelper.class) {
                    if (sSingleton == null) {
                        sSingleton = new UploadHelper();
                    }
                }
            }
            return sSingleton;
        }
        return (UploadHelper) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadActiveFile(String str, String str2, List<String> list, long j, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{str, str2, list, Long.valueOf(j), iActiveUploadListener}) == null) {
            statActiveFileData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() != 0) {
                statActiveFileData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                gb9 gb9Var = (gb9) ServiceManager.getService(gb9.a);
                if (gb9Var == null) {
                    if (DEBUG) {
                        Log.d(TAG, "loss voyager impl component");
                        return;
                    }
                    return;
                }
                ActiveUpObj activeUpObj = new ActiveUpObj(str, str2, list, null);
                activeUpObj.setFileType("2");
                gb9Var.e(list, "acupload", j * 1024, new fb9(this, activeUpObj, iActiveUploadListener) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UploadHelper this$0;
                    public final /* synthetic */ ActiveUpObj val$activeObj;
                    public final /* synthetic */ IActiveUploadListener val$activeUploadListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activeUpObj, iActiveUploadListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$activeObj = activeUpObj;
                        this.val$activeUploadListener = iActiveUploadListener;
                    }

                    @Override // com.repackage.fb9
                    public void onFailure(String str3, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str3, jSONObject) == null) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "Active upload normal file failed, errMsg: " + str3);
                            }
                            this.this$0.statMultiActiveFileData(false, this.val$activeObj.getDataId(), this.val$activeObj.getType(), str3);
                            if (this.val$activeUploadListener != null) {
                                if (!TextUtils.isEmpty(str3)) {
                                    this.val$activeUploadListener.onFailure(str3);
                                } else {
                                    this.val$activeUploadListener.onFailure(IActiveUploadListener.UPLOAD_ERR_MSG);
                                }
                            }
                        }
                    }

                    @Override // com.repackage.fb9
                    public void onSuccess(String str3, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, jSONObject) == null) {
                            this.val$activeObj.setFileID(str3);
                            this.val$activeObj.setFileMeta(jSONObject.toString());
                            this.this$0.statMultiActiveFileData(true, this.val$activeObj.getDataId(), this.val$activeObj.getType(), jSONObject.toString());
                            ActiveUploadManager.getInstance().activeUploadReportContent(this.val$activeObj, this.val$activeUploadListener);
                        }
                    }
                });
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "type, dataId can not null");
            }
            statActiveFileData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statActiveData(boolean z, String str, String str2, String str3) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        iStatTask.recordActiveUploadData(z, str, str2, str3, "1");
    }

    private void statActiveFileData(boolean z, String str, String str2, String str3) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        iStatTask.recordActiveUploadData(z, str, str2, str3, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4, str5, str6, jSONObject}) == null) || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        iStatTask.recordUploadRetrieveData(str, z, str2, str3, str4, str5, str6, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statMultiActiveFileData(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
            if (z) {
                statActiveFileData(true, "query", str, str2);
                statActiveFileData(true, StatConstants.VALUE_TYPE_ZIP, str, str2);
                statActiveFileData(true, StatConstants.VALUE_TYPE_UPLOAD, str, str2);
            } else if (TextUtils.equals("dir not found", str3)) {
                statActiveFileData(false, "query", str, str2);
            } else if (TextUtils.equals("zip failed", str3)) {
                statActiveFileData(true, "query", str, str2);
                statActiveFileData(false, StatConstants.VALUE_TYPE_ZIP, str, str2);
            } else {
                statActiveFileData(true, "query", str, str2);
                statActiveFileData(true, StatConstants.VALUE_TYPE_ZIP, str, str2);
                statActiveFileData(false, StatConstants.VALUE_TYPE_UPLOAD, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File zipFetchFile(HashSet<String> hashSet, String str, String str2, String str3, String str4, long j, long j2, long j3, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{hashSet, str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), jSONObject})) == null) {
            if (hashSet == null || hashSet.size() == 0 || TextUtils.isEmpty(str)) {
                return null;
            }
            long j4 = 1000 * j;
            if (hashSet.size() > 0) {
                Iterator<String> it = hashSet.iterator();
                long j5 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    File file = new File(next);
                    if (file.exists()) {
                        int lastIndexOf = next.lastIndexOf("/");
                        if (lastIndexOf > -1) {
                            next = next.substring(lastIndexOf + 1);
                        }
                        if (checkValid(next, j2, j3)) {
                            j5 += file.length();
                            if (j5 > j4) {
                                sa9.g().e(file.getAbsolutePath(), "3", file.getAbsolutePath() + "size exceed maxFileSize ", null, null, true, jSONObject);
                                break;
                            }
                            String substring = file.getAbsolutePath().substring(str.length());
                            if (DEBUG) {
                                Log.d(TAG, "new Path:" + substring);
                            }
                            sa9.g().e(file.getAbsolutePath(), "0", " success", file, substring, true, jSONObject);
                        } else {
                            continue;
                        }
                    }
                }
                String str5 = AppRuntime.getAppContext().getApplicationInfo().dataDir + LOG_FILE_FETCH_ZIP_PATH + File.separator;
                String str6 = UUID.randomUUID().toString().replace("-", "") + ".zip";
                File file2 = new File(str5);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                String str7 = str5 + str6;
                if (DEBUG) {
                    Log.d(TAG, "zipPath: " + str7);
                }
                File file3 = new File(str7);
                if (jb9.i(new ArrayList(hashSet), str7, str)) {
                    if (file3.length() > 0) {
                        if (DEBUG) {
                            Log.d(TAG, "zip directory is succeed, zip length is: " + file3.length());
                        }
                        return file3;
                    }
                    reportTaskDone(str2, str3, str4, "", "1", jSONObject);
                } else {
                    reportTaskDone(str2, str3, str4, "", "1", jSONObject);
                }
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void activeUpload(String str, String str2, List<String> list, String str3, long j, long j2, long j3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, list, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), jSONObject}) == null) {
            mExecutorService.execute(new Runnable(this, str2, str, j2, j3, list, j, str3, jSONObject) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ JSONObject val$extInfo;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ String val$source;
                public final /* synthetic */ List val$spaces;
                public final /* synthetic */ long val$startTime;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, str2, str, Long.valueOf(j2), Long.valueOf(j3), list, Long.valueOf(j), str3, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataId = str2;
                    this.val$type = str;
                    this.val$startTime = j2;
                    this.val$endTime = j3;
                    this.val$spaces = list;
                    this.val$maxSizeLimit = j;
                    this.val$source = str3;
                    this.val$extInfo = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, this.val$dataId, this.val$type);
                        if (TextUtils.isEmpty(this.val$type) || TextUtils.isEmpty(this.val$dataId)) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "type, dataId can not null");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                        HashSet fetchDirSet = this.this$0.getFetchDirSet(this.val$startTime, this.val$endTime, this.val$spaces);
                        if (fetchDirSet == null || fetchDirSet.size() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "not get upload dir");
                            }
                            this.this$0.statActiveData(false, "query", this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, "query", this.val$dataId, this.val$type);
                        JSONObject jSONObject2 = new JSONObject();
                        File zipFetchFile = this.this$0.zipFetchFile(fetchDirSet, LoggerManager.getBaseDir(), this.val$type, this.val$dataId, "", this.val$maxSizeLimit, this.val$startTime, this.val$endTime, jSONObject2);
                        if (zipFetchFile == null || zipFetchFile.length() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                        this.this$0.activeUploadZipFile(this.val$type, this.val$dataId, this.val$spaces, this.val$source, jSONObject2.toString(), zipFetchFile, this.val$extInfo);
                    }
                }
            });
        }
    }

    public void activeUploadFile(String str, String str2, List<String> list, long j, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, list, Long.valueOf(j), iActiveUploadListener}) == null) {
            mExecutorService.execute(new Runnable(this, str, str2, list, j, iActiveUploadListener) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ IActiveUploadListener val$activeUploadListener;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ List val$filePathList;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, list, Long.valueOf(j), iActiveUploadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = str;
                    this.val$dataId = str2;
                    this.val$filePathList = list;
                    this.val$maxSizeLimit = j;
                    this.val$activeUploadListener = iActiveUploadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startUploadActiveFile(this.val$type, this.val$dataId, this.val$filePathList, this.val$maxSizeLimit, this.val$activeUploadListener);
                    }
                }
            });
        }
    }

    public void activeUploadSnapShot(String str, String str2, List<String> list, long j, long j2, long j3, boolean z, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, list, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), iActiveUploadListener}) == null) {
            mExecutorService.execute(new Runnable(this, str2, str, iActiveUploadListener, j2, j3, list, z, j) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ IActiveUploadListener val$activeUploadListener;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ boolean val$removeLogFile;
                public final /* synthetic */ List val$spaces;
                public final /* synthetic */ long val$startTime;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r4;
                        Object[] objArr = {this, str2, str, iActiveUploadListener, Long.valueOf(j2), Long.valueOf(j3), list, Boolean.valueOf(z), Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataId = str2;
                    this.val$type = str;
                    this.val$activeUploadListener = iActiveUploadListener;
                    this.val$startTime = j2;
                    this.val$endTime = j3;
                    this.val$spaces = list;
                    this.val$removeLogFile = z;
                    this.val$maxSizeLimit = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, this.val$dataId, this.val$type);
                        if (TextUtils.isEmpty(this.val$type) || TextUtils.isEmpty(this.val$dataId)) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "type, dataId can not null");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener2 = this.val$activeUploadListener;
                            if (iActiveUploadListener2 != null) {
                                iActiveUploadListener2.onFailure(IActiveUploadListener.PARAM_ERR_MSG);
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                        String str3 = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_SNAP_PATH + File.separator + this.val$dataId + "_" + new SimpleDateFormat("yyMMddhhmmss").format(new Date());
                        if (UploadHelper.DEBUG) {
                            Log.d(UploadHelper.TAG, "snap short dir: " + str3);
                        }
                        HashSet<String> snapShotSet = this.this$0.getSnapShotSet(this.val$startTime, this.val$endTime, this.val$spaces, this.val$removeLogFile, true, str3);
                        if (snapShotSet == null || snapShotSet.size() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "not get upload dir");
                            }
                            this.this$0.statActiveData(false, "query", this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener3 = this.val$activeUploadListener;
                            if (iActiveUploadListener3 != null) {
                                iActiveUploadListener3.onFailure(IActiveUploadListener.DIR_ERR_MSG);
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, "query", this.val$dataId, this.val$type);
                        JSONObject jSONObject = new JSONObject();
                        File zipFetchFile = this.this$0.zipFetchFile(snapShotSet, str3, this.val$type, this.val$dataId, "", this.val$maxSizeLimit, this.val$startTime, this.val$endTime, jSONObject);
                        if (zipFetchFile == null || zipFetchFile.length() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener4 = this.val$activeUploadListener;
                            if (iActiveUploadListener4 != null) {
                                iActiveUploadListener4.onFailure("zip failed");
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                        FileZipUtil.deleteDirWithFile(new File(str3));
                        this.this$0.activeUploadZipFile(this.val$type, this.val$dataId, this.val$spaces, jSONObject.toString(), zipFetchFile, this.val$activeUploadListener);
                    }
                }
            });
        }
    }

    public void activeUploadZipFile(String str, String str2, List<String> list, String str3, File file, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, list, str3, file, iActiveUploadListener}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || file == null || file.length() == 0) {
            return;
        }
        ActiveUpObj activeUpObj = new ActiveUpObj(str, str2, list, str3);
        activeUpObj.setFileType("1");
        gb9 gb9Var = this.mVoyager;
        if (gb9Var == null) {
            if (DEBUG) {
                Log.d(TAG, "voyager component fail");
            }
            if (iActiveUploadListener != null) {
                iActiveUploadListener.onFailure("voyager component fail");
                return;
            }
            return;
        }
        gb9Var.a(file.getAbsolutePath(), "acupload", ra9.l, new fb9(this, activeUpObj, iActiveUploadListener) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UploadHelper this$0;
            public final /* synthetic */ ActiveUpObj val$activeObj;
            public final /* synthetic */ IActiveUploadListener val$activeUploadListener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activeUpObj, iActiveUploadListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$activeObj = activeUpObj;
                this.val$activeUploadListener = iActiveUploadListener;
            }

            @Override // com.repackage.fb9
            public void onFailure(String str4, JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str4, jSONObject) == null) {
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "Active upload yalog file failed");
                    }
                    this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_UPLOAD, this.val$activeObj.getDataId(), this.val$activeObj.getType());
                    if (this.val$activeUploadListener != null) {
                        if (!TextUtils.isEmpty(str4)) {
                            this.val$activeUploadListener.onFailure(str4);
                        } else {
                            this.val$activeUploadListener.onFailure(IActiveUploadListener.UPLOAD_ERR_MSG);
                        }
                    }
                }
            }

            @Override // com.repackage.fb9
            public void onSuccess(String str4, JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str4, jSONObject) == null) {
                    this.val$activeObj.setFileID(str4);
                    this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_UPLOAD, this.val$activeObj.getDataId(), this.val$activeObj.getType());
                    ActiveUploadManager.getInstance().activeUploadReportContent(this.val$activeObj, this.val$activeUploadListener);
                }
            }
        });
    }

    public void fetchUpload(String str, String str2, String str3, long j, long j2, long j3, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), list}) == null) {
            mExecutorService.execute(new Runnable(this, str, str2, str3, j2, j3, list, j) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ String val$jobId;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ List val$spaces;
                public final /* synthetic */ long val$startTime;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ String val$version;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), list, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = str;
                    this.val$jobId = str2;
                    this.val$version = str3;
                    this.val$startTime = j2;
                    this.val$endTime = j3;
                    this.val$spaces = list;
                    this.val$maxSizeLimit = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (TextUtils.isEmpty(this.val$type) || TextUtils.isEmpty(this.val$jobId) || TextUtils.isEmpty(this.val$version)) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "日志回捞命令校验失败");
                            }
                            this.this$0.statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, false, this.val$jobId, this.val$type, this.val$version, StatConstants.ERR_MSG_CHECK_PARAM_FAIL, "", null);
                            return;
                        }
                        this.this$0.statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, true, this.val$jobId, this.val$type, this.val$version, "", "", null);
                        FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(this.val$type, "3", this.val$jobId, this.val$version, "", "", ""), new IUploadListener(this) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                            public void onFailure() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass1 anonymousClass1 = this.this$1;
                                    anonymousClass1.this$0.statFetchData("start", false, anonymousClass1.val$jobId, anonymousClass1.val$type, anonymousClass1.val$version, StatConstants.ERR_MSG_START_FAIL, "", null);
                                }
                            }

                            @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                            public void onSuccess(FetchResult fetchResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchResult) == null) {
                                    if (fetchResult != null && TextUtils.equals("1", fetchResult.getValid())) {
                                        if (UploadHelper.DEBUG) {
                                            Log.d(UploadHelper.TAG, "日志回捞命开始上传");
                                        }
                                        AnonymousClass1 anonymousClass1 = this.this$1;
                                        anonymousClass1.this$0.statFetchData("start", true, anonymousClass1.val$jobId, anonymousClass1.val$type, anonymousClass1.val$version, "", "", null);
                                        AnonymousClass1 anonymousClass12 = this.this$1;
                                        HashSet fetchDirSet = anonymousClass12.this$0.getFetchDirSet(anonymousClass12.val$startTime, anonymousClass12.val$endTime, anonymousClass12.val$spaces);
                                        if (fetchDirSet != null && fetchDirSet.size() > 0) {
                                            AnonymousClass1 anonymousClass13 = this.this$1;
                                            anonymousClass13.this$0.statFetchData("query", true, anonymousClass13.val$jobId, anonymousClass13.val$type, anonymousClass13.val$version, "", "", null);
                                            JSONObject jSONObject = new JSONObject();
                                            String baseDir = LoggerManager.getBaseDir();
                                            AnonymousClass1 anonymousClass14 = this.this$1;
                                            File zipFetchFile = anonymousClass14.this$0.zipFetchFile(fetchDirSet, baseDir, anonymousClass14.val$type, anonymousClass14.val$jobId, anonymousClass14.val$version, anonymousClass14.val$maxSizeLimit, anonymousClass14.val$startTime, anonymousClass14.val$endTime, jSONObject);
                                            if (zipFetchFile == null || zipFetchFile.length() <= 0) {
                                                if (UploadHelper.DEBUG) {
                                                    Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                                                }
                                                AnonymousClass1 anonymousClass15 = this.this$1;
                                                anonymousClass15.this$0.reportTaskDone(anonymousClass15.val$type, anonymousClass15.val$jobId, anonymousClass15.val$version, "", "1", jSONObject);
                                                AnonymousClass1 anonymousClass16 = this.this$1;
                                                anonymousClass16.this$0.statFetchData(StatConstants.VALUE_TYPE_ZIP, false, anonymousClass16.val$jobId, anonymousClass16.val$type, anonymousClass16.val$version, "zip failed", "", jSONObject);
                                                return;
                                            }
                                            AnonymousClass1 anonymousClass17 = this.this$1;
                                            anonymousClass17.this$0.statFetchData(StatConstants.VALUE_TYPE_ZIP, true, anonymousClass17.val$jobId, anonymousClass17.val$type, anonymousClass17.val$version, "", "", jSONObject);
                                            AnonymousClass1 anonymousClass18 = this.this$1;
                                            anonymousClass18.this$0.uploadFetchZipFile(anonymousClass18.val$type, anonymousClass18.val$jobId, anonymousClass18.val$version, zipFetchFile, jSONObject);
                                            return;
                                        }
                                        AnonymousClass1 anonymousClass19 = this.this$1;
                                        anonymousClass19.this$0.reportTaskDone(anonymousClass19.val$type, anonymousClass19.val$jobId, anonymousClass19.val$version, "", "1", ib9.c(anonymousClass19.val$spaces));
                                        AnonymousClass1 anonymousClass110 = this.this$1;
                                        anonymousClass110.this$0.statFetchData("query", false, anonymousClass110.val$jobId, anonymousClass110.val$type, anonymousClass110.val$version, StatConstants.ERR_MSG_QUERY_FAIL, "", ib9.c(anonymousClass110.val$spaces));
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass111 = this.this$1;
                                    anonymousClass111.this$0.statFetchData("start", false, anonymousClass111.val$jobId, anonymousClass111.val$type, anonymousClass111.val$version, StatConstants.ERR_MSG_START_FAIL, "", null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public HashSet<String> getSnapShotSet(long j, long j2, List<String> list, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            HashSet<String> hashSet = new HashSet<>();
            if (list != null && list.size() > 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        int indexOf = next.indexOf("/");
                        if (indexOf == -1) {
                            substring = "";
                        } else {
                            String substring2 = next.substring(0, indexOf);
                            substring = next.substring(indexOf + 1);
                            next = substring2;
                        }
                        List<String> createLogSnapShot = LoggerManager.createLogSnapShot(j / 1000, j2 / 1000, TextUtils.isEmpty(next) ? "*" : next, TextUtils.isEmpty(substring) ? "*" : substring, z, z2, str);
                        if (createLogSnapShot != null) {
                            if (createLogSnapShot.size() != 0) {
                                for (String str2 : createLogSnapShot) {
                                    sb.setLength(0);
                                    sb.append(str);
                                    sb.append(File.separator);
                                    sb.append(str2);
                                    hashSet.add(sb.toString());
                                }
                            }
                        }
                    }
                }
            }
            if (DEBUG) {
                Log.d(TAG, "snapShotDirList size is: " + hashSet.size());
                Log.d(TAG, "snapShotDirList: " + Arrays.asList(hashSet));
            }
            return hashSet;
        }
        return (HashSet) invokeCommon.objValue;
    }

    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, jSONObject}) == null) {
            if (DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("report task done: type: ");
                sb.append(str);
                sb.append(", jobId: ");
                sb.append(str2);
                sb.append(", version: ");
                sb.append(str3);
                sb.append(", fileID: ");
                sb.append(str4);
                sb.append(", status: ");
                sb.append(str5);
                sb.append(", fileMeta: ");
                sb.append(jSONObject == null ? "" : jSONObject.toString());
                Log.d(TAG, sb.toString());
            }
            if (!"2".equals(str5)) {
                FetchTaskManager.getInstance().clearOriginData();
                FetchTaskManager.getInstance().saveRetryCount(0);
            }
            ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskDone(str, str2, str3, str5, str4, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    public void uploadFetchZipFile(String str, String str2, String str3, File file, JSONObject jSONObject) {
        gb9 gb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048587, this, str, str2, str3, file, jSONObject) == null) || file == null || file.length() == 0 || (gb9Var = this.mVoyager) == null) {
            return;
        }
        gb9Var.d(file.getAbsolutePath(), "fetchlog", new fb9(this, str2, str, str3, jSONObject, file) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UploadHelper this$0;
            public final /* synthetic */ String val$jobId;
            public final /* synthetic */ JSONObject val$metaJson;
            public final /* synthetic */ String val$type;
            public final /* synthetic */ String val$version;
            public final /* synthetic */ File val$zipFile;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str2, str, str3, jSONObject, file};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$jobId = str2;
                this.val$type = str;
                this.val$version = str3;
                this.val$metaJson = jSONObject;
                this.val$zipFile = file;
            }

            @Override // com.repackage.fb9
            public void onFailure(String str4, JSONObject jSONObject2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str4, jSONObject2) == null) {
                    UploadHelper uploadHelper = this.this$0;
                    String str5 = this.val$type;
                    String str6 = this.val$jobId;
                    String str7 = this.val$version;
                    JSONObject jSONObject3 = this.val$metaJson;
                    ib9.a(jSONObject3, str4);
                    uploadHelper.reportTaskDone(str5, str6, str7, "", "1", jSONObject3);
                }
            }

            @Override // com.repackage.fb9
            public void onSuccess(String str4, JSONObject jSONObject2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str4, jSONObject2) == null) {
                    this.this$0.statFetchData(StatConstants.VALUE_TYPE_UPLOAD, true, this.val$jobId, this.val$type, this.val$version, "", str4, this.val$metaJson);
                    if (this.val$zipFile.exists()) {
                        this.val$zipFile.delete();
                    }
                    if (UploadHelper.DEBUG) {
                        Log.d(UploadHelper.TAG, "fetch upload success");
                    }
                    this.this$0.reportTaskDone(this.val$type, this.val$jobId, this.val$version, str4, "0", this.val$metaJson);
                }
            }
        });
    }

    public void activeUpload(String str, String str2, List<String> list, long j, long j2, long j3, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, list, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iActiveUploadListener}) == null) {
            mExecutorService.execute(new Runnable(this, str2, str, iActiveUploadListener, j2, j3, list, j) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ IActiveUploadListener val$activeUploadListener;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ List val$spaces;
                public final /* synthetic */ long val$startTime;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str, iActiveUploadListener, Long.valueOf(j2), Long.valueOf(j3), list, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataId = str2;
                    this.val$type = str;
                    this.val$activeUploadListener = iActiveUploadListener;
                    this.val$startTime = j2;
                    this.val$endTime = j3;
                    this.val$spaces = list;
                    this.val$maxSizeLimit = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, this.val$dataId, this.val$type);
                        if (TextUtils.isEmpty(this.val$type) || TextUtils.isEmpty(this.val$dataId)) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "type, dataId can not null");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener2 = this.val$activeUploadListener;
                            if (iActiveUploadListener2 != null) {
                                iActiveUploadListener2.onFailure(IActiveUploadListener.PARAM_ERR_MSG);
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                        HashSet fetchDirSet = this.this$0.getFetchDirSet(this.val$startTime, this.val$endTime, this.val$spaces);
                        if (fetchDirSet == null || fetchDirSet.size() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "not get upload dir");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener3 = this.val$activeUploadListener;
                            if (iActiveUploadListener3 != null) {
                                iActiveUploadListener3.onFailure(IActiveUploadListener.DIR_ERR_MSG);
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, "query", this.val$dataId, this.val$type);
                        JSONObject jSONObject = new JSONObject();
                        File zipFetchFile = this.this$0.zipFetchFile(fetchDirSet, LoggerManager.getBaseDir(), this.val$type, this.val$dataId, "", this.val$maxSizeLimit, this.val$startTime, this.val$endTime, jSONObject);
                        if (zipFetchFile == null || zipFetchFile.length() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                            IActiveUploadListener iActiveUploadListener4 = this.val$activeUploadListener;
                            if (iActiveUploadListener4 != null) {
                                iActiveUploadListener4.onFailure(IActiveUploadListener.PRE_ZIP_ERR_MSG);
                                return;
                            }
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                        this.this$0.activeUploadZipFile(this.val$type, this.val$dataId, this.val$spaces, jSONObject.toString(), zipFetchFile, this.val$activeUploadListener);
                    }
                }
            });
        }
    }

    public void activeUploadFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, list, str3, Long.valueOf(j), jSONObject}) == null) {
            mExecutorService.execute(new Runnable(this, str, str2, list, str3, j, jSONObject) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ JSONObject val$extInfo;
                public final /* synthetic */ List val$filePathList;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ String val$source;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, list, str3, Long.valueOf(j), jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = str;
                    this.val$dataId = str2;
                    this.val$filePathList = list;
                    this.val$source = str3;
                    this.val$maxSizeLimit = j;
                    this.val$extInfo = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startUploadActiveFile(this.val$type, this.val$dataId, this.val$filePathList, this.val$source, this.val$maxSizeLimit, this.val$extInfo);
                    }
                }
            });
        }
    }

    public void activeUploadSnapShot(String str, String str2, List<String> list, String str3, long j, long j2, long j3, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, list, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), jSONObject}) == null) {
            mExecutorService.execute(new Runnable(this, str2, str, j2, j3, list, z, j, str3, jSONObject) { // from class: com.baidu.searchbox.retrieve.upload.UploadHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UploadHelper this$0;
                public final /* synthetic */ String val$dataId;
                public final /* synthetic */ long val$endTime;
                public final /* synthetic */ JSONObject val$extInfo;
                public final /* synthetic */ long val$maxSizeLimit;
                public final /* synthetic */ boolean val$removeLogFile;
                public final /* synthetic */ String val$source;
                public final /* synthetic */ List val$spaces;
                public final /* synthetic */ long val$startTime;
                public final /* synthetic */ String val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r4;
                        Object[] objArr = {this, str2, str, Long.valueOf(j2), Long.valueOf(j3), list, Boolean.valueOf(z), Long.valueOf(j), str3, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataId = str2;
                    this.val$type = str;
                    this.val$startTime = j2;
                    this.val$endTime = j3;
                    this.val$spaces = list;
                    this.val$removeLogFile = z;
                    this.val$maxSizeLimit = j;
                    this.val$source = str3;
                    this.val$extInfo = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_RECEIVE, this.val$dataId, this.val$type);
                        if (TextUtils.isEmpty(this.val$type) || TextUtils.isEmpty(this.val$dataId)) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "type, dataId can not null");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, this.val$dataId, this.val$type);
                        String str4 = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_SNAP_PATH + File.separator + this.val$dataId + "_" + new SimpleDateFormat("yyMMddhhmmss").format(new Date());
                        if (UploadHelper.DEBUG) {
                            Log.d(UploadHelper.TAG, "snap short dir: " + str4);
                        }
                        HashSet<String> snapShotSet = this.this$0.getSnapShotSet(this.val$startTime, this.val$endTime, this.val$spaces, this.val$removeLogFile, true, str4);
                        if (snapShotSet == null || snapShotSet.size() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "not get upload dir");
                            }
                            this.this$0.statActiveData(false, "query", this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, "query", this.val$dataId, this.val$type);
                        JSONObject jSONObject2 = new JSONObject();
                        File zipFetchFile = this.this$0.zipFetchFile(snapShotSet, str4, this.val$type, this.val$dataId, "", this.val$maxSizeLimit, this.val$startTime, this.val$endTime, jSONObject2);
                        if (zipFetchFile == null || zipFetchFile.length() == 0) {
                            if (UploadHelper.DEBUG) {
                                Log.d(UploadHelper.TAG, "zip file is null, and not upload");
                            }
                            this.this$0.statActiveData(false, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                            return;
                        }
                        this.this$0.statActiveData(true, StatConstants.VALUE_TYPE_ZIP, this.val$dataId, this.val$type);
                        FileZipUtil.deleteDirWithFile(new File(str4));
                        this.this$0.activeUploadZipFile(this.val$type, this.val$dataId, this.val$spaces, this.val$source, jSONObject2.toString(), zipFetchFile, this.val$extInfo);
                    }
                }
            });
        }
    }

    public void activeUploadZipFile(String str, String str2, List<String> list, String str3, String str4, File file, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, list, str3, str4, file, jSONObject}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || file == null || file.length() == 0) {
            return;
        }
        if (this.mVoyager == null) {
            if (DEBUG) {
                Log.d(TAG, "voyager component fail");
                return;
            }
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", str);
            jSONObject.put("dataId", str2);
            jSONObject.put("space", list.toString());
            jSONObject.put("fileMeta", str4);
            jSONObject.put("source", str3);
            jSONObject.put(UploadConstant.KEY_FILE_TYPE, "1");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        this.mVoyager.c(file.getAbsolutePath(), "acupload", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadActiveFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, str2, list, str3, Long.valueOf(j), jSONObject}) == null) {
            statActiveFileData(true, StatConstants.VALUE_TYPE_RECEIVE, str2, str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && list.size() != 0) {
                statActiveFileData(true, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
                gb9 gb9Var = (gb9) ServiceManager.getService(gb9.a);
                if (gb9Var == null) {
                    if (DEBUG) {
                        Log.d(TAG, "loss voyager impl component");
                        return;
                    }
                    return;
                }
                long j2 = j * 1024;
                JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                try {
                    jSONObject2.put("type", str);
                    jSONObject2.put("dataId", str2);
                    jSONObject2.put("space", list.toString());
                    jSONObject2.put("source", str3);
                    jSONObject2.put(UploadConstant.KEY_FILE_TYPE, "2");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                gb9Var.b(list, "acupload", j2, jSONObject2);
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "type, dataId can not null");
            }
            statActiveFileData(false, StatConstants.VALUE_TYPE_CHECK_PARAM, str2, str);
        }
    }
}
