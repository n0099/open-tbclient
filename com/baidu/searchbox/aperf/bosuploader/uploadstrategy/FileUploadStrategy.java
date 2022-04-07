package com.baidu.searchbox.aperf.bosuploader.uploadstrategy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.aperf.bosuploader.ZipUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ub1;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class FileUploadStrategy implements IUpload {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FileUploadStrategy";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mInvalidDirDeleted;
    public ThreadPoolExecutor mUploadExecutor;

    /* loaded from: classes2.dex */
    public static final class Constants {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final long MAX_LIFE_TIME = 2592000000L;
        public static final int UPLOAD_MAX_FILE = 5;
        public transient /* synthetic */ FieldHolder $fh;

        public Constants() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileEntity implements Comparable<FileEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public File mFile;
        @NonNull
        public FileName mFileName;

        public FileEntity(@NonNull File file, @NonNull FileName fileName) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, fileName};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFile = file;
            this.mFileName = fileName;
        }

        public static FileEntity getFileEntity(@NonNull File file) {
            InterceptResult invokeL;
            FileName fileName;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
                if (file == null || !file.exists() || (fileName = FileName.getFileName(file.getName())) == null) {
                    return null;
                }
                return new FileEntity(file, fileName);
            }
            return (FileEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull FileEntity fileEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fileEntity)) == null) {
                int i = ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) > 0L ? 1 : ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) == 0L ? 0 : -1));
                if (i > 0) {
                    return -1;
                }
                return i < 0 ? 1 : 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FileName {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public transient /* synthetic */ FieldHolder $fh;
        public String mFileID;
        public String mFileType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mFileType = str3;
        }

        public static String createFileID(@NonNull String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j)) == null) {
                return str.replace("_", "").replace("#", "") + "_" + j;
            }
            return (String) invokeLJ.objValue;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fileName)) == null) {
                return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mFileType;
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mFileType;
            }
            return (String) invokeV.objValue;
        }

        public static FileName getFileName(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, str3)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    long j = -1;
                    String[] split = str.split("_");
                    if (split != null && split.length == 2) {
                        try {
                            j = Long.valueOf(split[1]).longValue();
                        } catch (NumberFormatException unused) {
                            return null;
                        }
                    }
                    long j2 = j;
                    if (j2 > 0) {
                        return new FileName(str, j2, str2, str3);
                    }
                }
                return null;
            }
            return (FileName) invokeLLL.objValue;
        }

        public static FileName getFileName(@NonNull String str) {
            InterceptResult invokeL;
            String[] split;
            String[] split2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
                if (!TextUtils.isEmpty(str) && (split = str.split("#")) != null && split.length == 3) {
                    long j = -1;
                    String str2 = split[0];
                    if (!TextUtils.isEmpty(str2) && (split2 = str2.split("_")) != null && split2.length == 2) {
                        String str3 = split2[1];
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                j = Long.valueOf(str3).longValue();
                            } catch (NumberFormatException unused) {
                                return null;
                            }
                        }
                    }
                    String str4 = split[1];
                    String str5 = split[2];
                    if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                        return new FileName(str2, j, str4, str5);
                    }
                }
                return null;
            }
            return (FileName) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class StoreUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BASE_ATTACHMENT_UPLOAD_FILE_PATH = "attachment_upload";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";
        public transient /* synthetic */ FieldHolder $fh;

        public StoreUtil() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static File getAttachDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new File(getStoreDir(), "attachment") : (File) invokeV.objValue;
        }

        public static final File getAttachFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new File(getStoreDir(), "attachment.flag") : (File) invokeV.objValue;
        }

        public static File getInvalidZipDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new File(getStoreDir(), "zip_supply") : (File) invokeV.objValue;
        }

        public static File getStoreDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                Context appContext = AppRuntime.getAppContext();
                Context applicationContext = appContext.getApplicationContext();
                if (applicationContext != null) {
                    appContext = applicationContext;
                }
                return new File(new File(appContext.getFilesDir(), BASE_ATTACHMENT_UPLOAD_FILE_PATH), ub1.b().replace(":", "_"));
            }
            return (File) invokeV.objValue;
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, file, fileName)) == null) ? new File(file, FileName.getFileName(fileName)) : (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class TrimConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMaxCount = i;
            this.mLifeTime = j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266522518, "Lcom/baidu/searchbox/aperf/bosuploader/uploadstrategy/FileUploadStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-266522518, "Lcom/baidu/searchbox/aperf/bosuploader/uploadstrategy/FileUploadStrategy;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FileUploadStrategy() {
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
        this.mInvalidDirDeleted = false;
        this.mUploadExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static boolean checkFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? StoreUtil.getAttachFlag().exists() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            clearInvalidFiles();
            updateFileFlag();
        }
    }

    private Pair<LinkedList<FileEntity>, LinkedList<File>> clearInvalidFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            File[] listFiles = StoreUtil.getAttachDir().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(100, 2592000000L));
            if (((LinkedList) fileCluster.second).size() > 0) {
                Iterator it = ((LinkedList) fileCluster.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        if (DEBUG) {
                            Log.d(TAG, "invalid delete = " + file.getAbsolutePath());
                        }
                        file.delete();
                    }
                }
            }
            return fileCluster;
        }
        return (Pair) invokeV.objValue;
    }

    @Nullable
    private File createAttachZipFile(@Nullable List<File> list, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, this, list, str, str2, str3)) == null) {
            FileName fileName = FileName.getFileName(str, str2, str3);
            if (fileName == null) {
                return null;
            }
            File attachDir = StoreUtil.getAttachDir();
            if (!attachDir.exists()) {
                attachDir.mkdirs();
            }
            File obtainFilePath = StoreUtil.obtainFilePath(attachDir, fileName);
            try {
                if (obtainFilePath.exists()) {
                    obtainFilePath.delete();
                }
                obtainFilePath.createNewFile();
            } catch (IOException e) {
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                }
            }
            if (obtainFilePath.exists()) {
                LinkedList linkedList = new LinkedList();
                if (list != null && list.size() > 0) {
                    linkedList.addAll(list);
                }
                try {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        File file = (File) it.next();
                        if (file != null) {
                            linkedList2.add(new ZipUtils.ZipSrc(file));
                        }
                    }
                    ZipUtils.zip(obtainFilePath, linkedList2);
                    return obtainFilePath;
                } catch (IOException e2) {
                    if (DEBUG) {
                        Log.d(TAG, e2.getMessage());
                    }
                }
            }
            return null;
        }
        return (File) invokeLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            Pair<LinkedList<FileEntity>, LinkedList<File>> clearInvalidFiles = clearInvalidFiles();
            if (clearInvalidFiles == null) {
                return false;
            }
            if (((LinkedList) clearInvalidFiles.first).size() > 0) {
                Iterator it = ((LinkedList) clearInvalidFiles.first).iterator();
                i2 = 0;
                while (it.hasNext() && i2 < i) {
                    FileEntity fileEntity = (FileEntity) it.next();
                    if (fileEntity != null) {
                        i2++;
                        ResponseEntity uploadAction = uploadAction(fileEntity);
                        if (uploadAction == null || !uploadAction.isSuccess()) {
                            break;
                        }
                        fileEntity.mFile.delete();
                    }
                }
            } else {
                i2 = 0;
            }
            return i2 == i;
        }
        return invokeI.booleanValue;
    }

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, fileArr, trimConfig)) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (File file : fileArr) {
                if (file != null && file.exists()) {
                    FileEntity fileEntity = FileEntity.getFileEntity(file);
                    if (fileEntity != null) {
                        if (currentTimeMillis - fileEntity.mFileName.mTimestamp.longValue() > trimConfig.mLifeTime) {
                            linkedList2.add(file);
                        } else {
                            linkedList.add(fileEntity);
                        }
                    } else {
                        linkedList2.add(file);
                    }
                }
            }
            Collections.sort(linkedList);
            if (linkedList.size() > trimConfig.mMaxCount) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i++;
                    FileEntity fileEntity2 = (FileEntity) it.next();
                    if (i > trimConfig.mMaxCount) {
                        linkedList2.add(fileEntity2.mFile);
                        it.remove();
                        if (DEBUG) {
                            Log.d(TAG, "fileCluster + " + Thread.currentThread().getName());
                        }
                    }
                }
            }
            return new Pair<>(linkedList, linkedList2);
        }
        return (Pair) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            File attachFlag = StoreUtil.getAttachFlag();
            File attachDir = StoreUtil.getAttachDir();
            if (attachFlag == null || attachDir == null) {
                return;
            }
            String[] list = attachDir.list();
            boolean z = false;
            if (list != null && list.length > 0) {
                z = true;
            }
            boolean exists = attachFlag.exists();
            if (!z) {
                if (exists) {
                    attachFlag.delete();
                }
            } else if (exists) {
            } else {
                try {
                    attachFlag.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull FileEntity fileEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, fileEntity)) == null) {
            if (fileEntity == null) {
                return new ResponseEntity(false);
            }
            String str = fileEntity.mFileName.mFileID;
            return uploadAttachmentSync(str.substring(0, str.indexOf("_")), fileEntity.mFile);
        }
        return (ResponseEntity) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null) {
                ResponseEntity uploadSync = new BOSFileUpload().uploadSync(str, file);
                if (uploadSync == null) {
                    uploadSync = new ResponseEntity(false);
                }
                if (DEBUG && uploadSync != null) {
                    Log.d(TAG, "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath());
                    String message = uploadSync.getMessage();
                    if (!TextUtils.isEmpty(message)) {
                        Log.d(TAG, "attachment upload message = " + message);
                    }
                }
                return uploadSync;
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    public void reUpload(int i) {
        ThreadPoolExecutor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i <= 0 || (threadPoolExecutor = this.mUploadExecutor) == null) {
            return;
        }
        threadPoolExecutor.execute(new Runnable(this, i) { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FileUploadStrategy this$0;
            public final /* synthetic */ int val$maxFileCount;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$maxFileCount = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!this.this$0.doUpload(this.val$maxFileCount)) {
                        this.this$0.updateFileFlag();
                    } else {
                        this.this$0.reUpload(this.val$maxFileCount);
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.IUpload
    public void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            reUpload(5);
            if (this.mInvalidDirDeleted) {
                return;
            }
            this.mInvalidDirDeleted = true;
            File invalidZipDir = StoreUtil.getInvalidZipDir();
            if (invalidZipDir.exists()) {
                invalidZipDir.delete();
            }
        }
    }

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.IUpload
    public void upload(@NonNull List<File> list, @NonNull String str, @NonNull String str2) {
        File createAttachZipFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, list, str, str2) == null) || (createAttachZipFile = createAttachZipFile(list, FileName.createFileID(str, System.currentTimeMillis()), ub1.b(), str2)) == null) {
            return;
        }
        this.mUploadExecutor.execute(new Runnable(this, createAttachZipFile, str) { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FileUploadStrategy this$0;
            public final /* synthetic */ File val$attachZipFile;
            public final /* synthetic */ String val$fileIDPrefix;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, createAttachZipFile, str};
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
                this.val$attachZipFile = createAttachZipFile;
                this.val$fileIDPrefix = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!NetWorkUtils.isNetworkConnected()) {
                        this.this$0.cleanDiskCache();
                        return;
                    }
                    this.this$0.updateFileFlag();
                    if (FileUploadStrategy.DEBUG) {
                        Log.d(FileUploadStrategy.TAG, "new attachement file = " + this.val$attachZipFile.getAbsolutePath());
                    }
                    ResponseEntity uploadAttachmentSync = this.this$0.uploadAttachmentSync(this.val$fileIDPrefix, this.val$attachZipFile);
                    if (uploadAttachmentSync.isSuccess()) {
                        this.val$attachZipFile.delete();
                    }
                    if (this.this$0.mUploadExecutor.getQueue().size() == 0) {
                        if (!uploadAttachmentSync.isSuccess()) {
                            this.this$0.cleanDiskCache();
                        } else {
                            this.this$0.reUpload(5);
                        }
                    }
                }
            }
        });
    }
}
