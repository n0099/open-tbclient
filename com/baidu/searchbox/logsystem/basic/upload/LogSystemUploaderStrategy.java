package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.logsystem.util.ZipUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class LogSystemUploaderStrategy extends BaseUploaderStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LSStrategy";
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mAttachmentExecutor;
    public ThreadPoolExecutor mContentExecutor;
    public boolean mInvalidDirDeleted;

    /* renamed from: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(798875310, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(798875310, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$4;");
                    return;
                }
            }
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type = iArr;
            try {
                iArr[Type.CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[Type.ATTACHMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Constants {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int KEEP_ALIVE_TIME = 60000;
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final int MAX_COUNT_CONTENT = 500;
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

    /* loaded from: classes3.dex */
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
                if (i < 0) {
                    return 1;
                }
                return 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FileName {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public transient /* synthetic */ FieldHolder $fh;
        public String mFileID;
        public LogType mLogType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), str2, logType};
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
            this.mLogType = logType;
        }

        public static String createFileID(@NonNull String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j)) == null) {
                return str.replace("_", "").replace("#", "") + "_" + j;
            }
            return (String) invokeLJ.objValue;
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
                    LogType logType = LogType.getLogType(split[2]);
                    if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && logType != null) {
                        return new FileName(str2, j, str4, logType);
                    }
                }
                return null;
            }
            return (FileName) invokeL.objValue;
        }

        public static FileName getFileName(String str, String str2, LogType logType) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, logType)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && logType != null) {
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
                        return new FileName(str, j2, str2, logType);
                    }
                }
                return null;
            }
            return (FileName) invokeLLL.objValue;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fileName)) == null) {
                return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StoreUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BASE_GZIP_TMP = ".gz.tmp";
        public static final String BASE_TMP = ".tmp";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String BASE_UPLOAD_CONTENT_DIR = "content";
        public static final String BASE_UPLOAD_CONTENT_FLAG = "content.flag";
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

        public static /* synthetic */ File access$000() {
            return getContentFlag();
        }

        public static /* synthetic */ File access$100() {
            return getAttachFlag();
        }

        public static /* synthetic */ File access$1000() {
            return getContentDir();
        }

        public static /* synthetic */ File access$1100() {
            return getAttachDir();
        }

        public static /* synthetic */ File access$200() {
            return getInvalidZipDir();
        }

        public static File getAttachDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "attachment");
            }
            return (File) invokeV.objValue;
        }

        public static final File getAttachFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                return new File(getStoreDir(), "attachment.flag");
            }
            return (File) invokeV.objValue;
        }

        public static File getContentDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content");
            }
            return (File) invokeV.objValue;
        }

        public static final File getContentFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
                return new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG);
            }
            return (File) invokeV.objValue;
        }

        public static File getInvalidZipDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "zip_supply");
            }
            return (File) invokeV.objValue;
        }

        public static File getStoreDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                return LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get();
            }
            return (File) invokeV.objValue;
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, file, fileName)) == null) {
                return new File(file, FileName.getFileName(fileName));
            }
            return (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type ATTACHMENT;
        public static final Type CONTENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(912083610, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(912083610, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy$Type;");
                    return;
                }
            }
            CONTENT = new Type("CONTENT", 0);
            Type type = new Type("ATTACHMENT", 1);
            ATTACHMENT = type;
            $VALUES = new Type[]{CONTENT, type};
        }

        public Type(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Type) Enum.valueOf(Type.class, str);
            }
            return (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Type[]) $VALUES.clone();
            }
            return (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843860482, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843860482, "Lcom/baidu/searchbox/logsystem/basic/upload/LogSystemUploaderStrategy;");
                return;
            }
        }
        DEBUG = LLog.sDebug;
    }

    public static boolean checkFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (!StoreUtil.access$000().exists() && !StoreUtil.access$100().exists()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy() {
        this(true, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, type, fileEntity)) == null) {
            if (type != null && fileEntity != null) {
                int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        return new ResponseEntity(false);
                    }
                    return uploadAttachmentSync(fileEntity.mFileName.mFileID, fileEntity.mFile);
                }
                return uploadContentSync(fileEntity.mFile);
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), uploadListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mInvalidDirDeleted = false;
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mAttachmentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, this, logObject, list, str)) == null) {
            File access$1000 = StoreUtil.access$1000();
            if (!access$1000.exists()) {
                access$1000.mkdirs();
            }
            FileName fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType);
            if (fileName != null) {
                File obtainFilePath = StoreUtil.obtainFilePath(access$1000, fileName);
                File file = new File(obtainFilePath.getAbsolutePath() + ".tmp");
                File file2 = new File(obtainFilePath.getAbsolutePath() + StoreUtil.BASE_GZIP_TMP);
                Utility.createNewEmptyFile(file);
                Utility.createNewEmptyFile(file2);
                if (file.exists()) {
                    ContentUtil.createUBCContentInfo(logObject, list, str, file);
                    if (file2.exists()) {
                        ContentUtil.gzipContent(file, file2);
                    }
                    file2.renameTo(obtainFilePath);
                }
                file.delete();
                file2.delete();
                if (!obtainFilePath.exists()) {
                    return null;
                }
                return obtainFilePath;
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    public void reUpload(Type type, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, i) != null) || i <= 0) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = null;
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                threadPoolExecutor = this.mAttachmentExecutor;
            }
        } else {
            threadPoolExecutor = this.mContentExecutor;
        }
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable(this, type, i) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LogSystemUploaderStrategy this$0;
                public final /* synthetic */ int val$maxFileCount;
                public final /* synthetic */ Type val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, type, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = type;
                    this.val$maxFileCount = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.doUpload(this.val$type, this.val$maxFileCount)) {
                            this.this$0.reUpload(this.val$type, this.val$maxFileCount);
                        } else {
                            this.this$0.updateFileFlag(this.val$type);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            reUpload(Type.CONTENT, 5);
            reUpload(Type.ATTACHMENT, 5);
            if (!this.mInvalidDirDeleted) {
                this.mInvalidDirDeleted = true;
                File access$200 = StoreUtil.access$200();
                if (access$200.exists()) {
                    access$200.delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, type) == null) {
            int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    listFiles = null;
                    i = 0;
                } else {
                    listFiles = StoreUtil.access$1100().listFiles();
                    i = 100;
                }
            } else {
                listFiles = StoreUtil.access$1000().listFiles();
                i = 500;
            }
            if (listFiles != null && listFiles.length != 0) {
                Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i, 2592000000L));
                if (((LinkedList) fileCluster.second).size() > 0) {
                    Iterator it = ((LinkedList) fileCluster.second).iterator();
                    while (it.hasNext()) {
                        File file = (File) it.next();
                        if (file != null) {
                            file.delete();
                        }
                    }
                }
                updateFileFlag(type);
            }
        }
    }

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        InterceptResult invokeL;
        boolean z;
        BaseContentUploader contentUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) {
            if (file == null) {
                return new ResponseEntity(false);
            }
            BaseContentUploader defaultContentUploader = UploaderProvider.getDefaultContentUploader();
            ResponseEntity uploadSync = defaultContentUploader.uploadSync(file);
            if (uploadSync != null) {
                z = uploadSync.isSuccess();
            } else {
                z = false;
            }
            if (!z && (contentUploader = UploaderProvider.getContentUploader()) != defaultContentUploader) {
                uploadSync = contentUploader.uploadSync(file);
            }
            if (uploadSync == null) {
                uploadSync = new ResponseEntity(false);
            }
            if (DEBUG && uploadSync != null) {
                Log.d("LSStrategy", "content upload file = " + file.getAbsolutePath());
                Log.d("LSStrategy", "content upload success = " + uploadSync.isSuccess());
                String message = uploadSync.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    Log.d("LSStrategy", "content upload message = " + message);
                }
            }
            return uploadSync;
        }
        return (ResponseEntity) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r7 == 2) goto L46;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File createAttachZipFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2, @NonNull String str) {
        InterceptResult invokeLLLLL;
        FileName fileName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, this, logObject, list, set, list2, str)) == null) {
            if (logObject.getLogBasicDataFile() == null || !logObject.getLogBasicDataFile().exists() || (fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType)) == null) {
                return null;
            }
            File access$1100 = StoreUtil.access$1100();
            if (!access$1100.exists()) {
                access$1100.mkdirs();
            }
            File obtainFilePath = StoreUtil.obtainFilePath(access$1100, fileName);
            try {
                if (obtainFilePath.exists()) {
                    obtainFilePath.delete();
                }
                obtainFilePath.createNewFile();
            } catch (IOException e) {
                if (LLog.sDebug) {
                    Log.d("LSStrategy", e.getMessage());
                }
            }
            if (obtainFilePath.exists()) {
                LinkedList linkedList = new LinkedList();
                if (set != null && set.size() > 0) {
                    linkedList.addAll(set);
                }
                if (list != null && list.size() > 0) {
                    linkedList.addAll(list);
                }
                if (list2 != null && list2.size() > 0) {
                    int i = 0;
                    for (LogFile logFile : list2) {
                        if (logFile != null && (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.FULL_BDMP_PERFIX) || logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.TXT_EXTRA))) {
                            linkedList.add(logFile);
                            i++;
                        }
                    }
                }
                try {
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new ZipUtils.ZipSrc(logObject.getLogBasicDataFile(), SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA));
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        LogFile logFile2 = (LogFile) it.next();
                        if (logFile2 != null && logFile2.mFile.exists()) {
                            linkedList2.add(new ZipUtils.ZipSrc(logFile2.mFile));
                        }
                    }
                    ZipUtils.zip(obtainFilePath, linkedList2);
                    return obtainFilePath;
                } catch (IOException e2) {
                    if (LLog.sDebug) {
                        Log.d("LSStrategy", e2.getMessage());
                    }
                }
            }
            return null;
        }
        return (File) invokeLLLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i) {
        InterceptResult invokeLI;
        File[] listFiles;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, this, type, i)) == null) {
            int i4 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    listFiles = null;
                    i2 = 0;
                } else {
                    listFiles = StoreUtil.access$1100().listFiles();
                    i2 = 100;
                }
            } else {
                listFiles = StoreUtil.access$1000().listFiles();
                i2 = 500;
            }
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i2, 2592000000L));
            if (((LinkedList) fileCluster.second).size() > 0) {
                Iterator it = ((LinkedList) fileCluster.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        if (DEBUG) {
                            Log.d("LSStrategy", "invalid delete = " + file.getAbsolutePath());
                        }
                        file.delete();
                    }
                }
            }
            if (((LinkedList) fileCluster.first).size() > 0) {
                Iterator it2 = ((LinkedList) fileCluster.first).iterator();
                i3 = 0;
                while (it2.hasNext() && i3 < i) {
                    FileEntity fileEntity = (FileEntity) it2.next();
                    if (fileEntity != null) {
                        i3++;
                        ResponseEntity uploadAction = uploadAction(type, fileEntity);
                        if (uploadAction == null || !uploadAction.isSuccess()) {
                            break;
                        }
                        fileEntity.mFile.delete();
                    }
                }
            } else {
                i3 = 0;
            }
            if (i3 == i) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, fileArr, trimConfig)) == null) {
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
                            Log.d("LSStrategy", "fileCluster + " + Thread.currentThread().getName());
                        }
                    }
                }
            }
            return new Pair<>(linkedList, linkedList2);
        }
        return (Pair) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag(Type type) {
        File access$1000;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, type) == null) {
            int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            boolean z = true;
            File file = null;
            if (i != 1) {
                if (i != 2) {
                    access$1000 = null;
                } else {
                    file = StoreUtil.access$100();
                    access$1000 = StoreUtil.access$1100();
                }
            } else {
                file = StoreUtil.access$000();
                access$1000 = StoreUtil.access$1000();
            }
            if (file != null && access$1000 != null) {
                String[] list = access$1000.list();
                z = (list == null || list.length <= 0) ? false : false;
                boolean exists = file.exists();
                if (z) {
                    if (!exists) {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (exists) {
                    file.delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null) {
                ResponseEntity uploadSync = UploaderProvider.getAttachUploader().uploadSync(str, file);
                if (uploadSync == null) {
                    uploadSync = new ResponseEntity(false);
                }
                if (DEBUG && uploadSync != null) {
                    Log.d("LSStrategy", "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath());
                    String message = uploadSync.getMessage();
                    if (!TextUtils.isEmpty(message)) {
                        Log.d("LSStrategy", "attachment upload message = " + message);
                    }
                }
                return uploadSync;
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, logObject, list, set, list2) == null) {
            if (logObject.mLogType == LogType.JAVA_CRASH && !this.mUploadJavaCrash) {
                return;
            }
            if ((logObject.mLogType != LogType.NATIVE_CRASH || this.mUploadNativeCrash) && (crashTAG = CrashUtil.CrashTAG.getCrashTAG(logObject.getCrashTAG())) != null) {
                String createFileID = FileName.createFileID(crashTAG.mCrashProcessUUID, System.currentTimeMillis());
                File createContentFile = createContentFile(logObject, list2, createFileID);
                File createAttachZipFile = createAttachZipFile(logObject, list, set, list2, createFileID);
                BaseUploaderStrategy.UploadListener uploadListener = this.mUploadListener;
                if (uploadListener != null) {
                    uploadListener.onUploadStart(logObject);
                }
                if (createContentFile != null) {
                    this.mContentExecutor.execute(new Runnable(this, context, createContentFile) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LogSystemUploaderStrategy this$0;
                        public final /* synthetic */ File val$contentFile;
                        public final /* synthetic */ Context val$context;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, createContentFile};
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
                            this.val$context = context;
                            this.val$contentFile = createContentFile;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (!Utility.isNetWorkEnabled(this.val$context)) {
                                    this.this$0.cleanDiskCache(Type.CONTENT);
                                    return;
                                }
                                this.this$0.updateFileFlag(Type.CONTENT);
                                if (LLog.sDebug) {
                                    Log.d("LSStrategy", "new content file = " + this.val$contentFile.getAbsolutePath());
                                }
                                ResponseEntity uploadContentSync = this.this$0.uploadContentSync(this.val$contentFile);
                                if (uploadContentSync.isSuccess()) {
                                    this.val$contentFile.delete();
                                }
                                if (this.this$0.mContentExecutor.getQueue().size() == 0) {
                                    if (uploadContentSync.isSuccess()) {
                                        this.this$0.reUpload(Type.CONTENT, 5);
                                    } else {
                                        this.this$0.cleanDiskCache(Type.CONTENT);
                                    }
                                }
                            }
                        }
                    });
                }
                if (createAttachZipFile != null) {
                    this.mAttachmentExecutor.execute(new Runnable(this, context, createAttachZipFile, createFileID) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LogSystemUploaderStrategy this$0;
                        public final /* synthetic */ File val$attachZipFile;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$fileID;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, createAttachZipFile, createFileID};
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
                            this.val$context = context;
                            this.val$attachZipFile = createAttachZipFile;
                            this.val$fileID = createFileID;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (!Utility.isNetWorkEnabled(this.val$context)) {
                                    this.this$0.cleanDiskCache(Type.ATTACHMENT);
                                    return;
                                }
                                this.this$0.updateFileFlag(Type.ATTACHMENT);
                                if (LLog.sDebug) {
                                    Log.d("LSStrategy", "new attachement file = " + this.val$attachZipFile.getAbsolutePath());
                                }
                                ResponseEntity uploadAttachmentSync = this.this$0.uploadAttachmentSync(this.val$fileID, this.val$attachZipFile);
                                if (uploadAttachmentSync.isSuccess()) {
                                    this.val$attachZipFile.delete();
                                }
                                if (this.this$0.mAttachmentExecutor.getQueue().size() == 0) {
                                    if (uploadAttachmentSync.isSuccess()) {
                                        this.this$0.reUpload(Type.ATTACHMENT, 5);
                                    } else {
                                        this.this$0.cleanDiskCache(Type.ATTACHMENT);
                                    }
                                }
                            }
                        }
                    });
                    BaseUploaderStrategy.UploadListener uploadListener2 = this.mUploadListener;
                    if (uploadListener2 != null) {
                        uploadListener2.onUploadDone(logObject);
                    }
                }
            }
        }
    }
}
