package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes11.dex */
public class LogSystemUploaderStrategy extends BaseUploaderStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LSStrategy";
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mAttachmentExecutor;
    public ThreadPoolExecutor mContentExecutor;
    public boolean mInvalidDirDeleted;

    /* renamed from: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$4  reason: invalid class name */
    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) > 0L ? 1 : ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return -1;
                }
                return i2 < 0 ? 1 : 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static File getAttachDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "attachment") : (File) invokeV.objValue;
        }

        public static final File getAttachFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new File(getStoreDir(), "attachment.flag") : (File) invokeV.objValue;
        }

        public static File getContentDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content") : (File) invokeV.objValue;
        }

        public static final File getContentFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG) : (File) invokeV.objValue;
        }

        public static File getInvalidZipDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "zip_supply") : (File) invokeV.objValue;
        }

        public static File getStoreDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get() : (File) invokeV.objValue;
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, file, fileName)) == null) ? new File(file, FileName.getFileName(fileName)) : (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class TrimConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMaxCount = i2;
            this.mLifeTime = j2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogSystemUploaderStrategy() {
        this(true, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean checkFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? StoreUtil.getContentFlag().exists() || StoreUtil.getAttachFlag().exists() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, type) == null) {
            int i3 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i3 == 1) {
                listFiles = StoreUtil.getContentDir().listFiles();
                i2 = 500;
            } else if (i3 != 2) {
                listFiles = null;
                i2 = 0;
            } else {
                listFiles = StoreUtil.getAttachDir().listFiles();
                i2 = 100;
            }
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i2, 2592000000L));
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

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        if (r6 == 2) goto L46;
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
            } catch (IOException e2) {
                if (LLog.sDebug) {
                    e2.getMessage();
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
                    int i2 = 0;
                    for (LogFile logFile : list2) {
                        if (logFile != null && (logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.FULL_BDMP_PERFIX) || logFile.mFile.getName().startsWith(CrashUtil.CrashpadConstant.TXT_EXTRA))) {
                            linkedList.add(logFile);
                            i2++;
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
                } catch (IOException e3) {
                    if (LLog.sDebug) {
                        e3.getMessage();
                    }
                }
            }
            return null;
        }
        return (File) invokeLLLLL.objValue;
    }

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, this, logObject, list, str)) == null) {
            File contentDir = StoreUtil.getContentDir();
            if (!contentDir.exists()) {
                contentDir.mkdirs();
            }
            FileName fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType);
            if (fileName == null) {
                return null;
            }
            File obtainFilePath = StoreUtil.obtainFilePath(contentDir, fileName);
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
            if (obtainFilePath.exists()) {
                return obtainFilePath;
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i2) {
        InterceptResult invokeLI;
        File[] listFiles;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, this, type, i2)) == null) {
            int i5 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            if (i5 == 1) {
                listFiles = StoreUtil.getContentDir().listFiles();
                i3 = 500;
            } else if (i5 != 2) {
                listFiles = null;
                i3 = 0;
            } else {
                listFiles = StoreUtil.getAttachDir().listFiles();
                i3 = 100;
            }
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i3, 2592000000L));
            if (((LinkedList) fileCluster.second).size() > 0) {
                Iterator it = ((LinkedList) fileCluster.second).iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (file != null) {
                        if (DEBUG) {
                            String str = "invalid delete = " + file.getAbsolutePath();
                        }
                        file.delete();
                    }
                }
            }
            if (((LinkedList) fileCluster.first).size() > 0) {
                Iterator it2 = ((LinkedList) fileCluster.first).iterator();
                i4 = 0;
                while (it2.hasNext() && i4 < i2) {
                    FileEntity fileEntity = (FileEntity) it2.next();
                    if (fileEntity != null) {
                        i4++;
                        ResponseEntity uploadAction = uploadAction(type, fileEntity);
                        if (uploadAction == null || !uploadAction.isSuccess()) {
                            break;
                        }
                        fileEntity.mFile.delete();
                    }
                }
            } else {
                i4 = 0;
            }
            return i4 == i2;
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
            int i2 = 0;
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
                    i2++;
                    FileEntity fileEntity2 = (FileEntity) it.next();
                    if (i2 > trimConfig.mMaxCount) {
                        linkedList2.add(fileEntity2.mFile);
                        it.remove();
                        if (DEBUG) {
                            String str = "fileCluster + " + Thread.currentThread().getName();
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
        File contentDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, type) == null) {
            int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
            boolean z = true;
            File file = null;
            if (i2 == 1) {
                file = StoreUtil.getContentFlag();
                contentDir = StoreUtil.getContentDir();
            } else if (i2 != 2) {
                contentDir = null;
            } else {
                file = StoreUtil.getAttachFlag();
                contentDir = StoreUtil.getAttachDir();
            }
            if (file == null || contentDir == null) {
                return;
            }
            String[] list = contentDir.list();
            z = (list == null || list.length <= 0) ? false : false;
            boolean exists = file.exists();
            if (!z) {
                if (exists) {
                    file.delete();
                }
            } else if (exists) {
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, type, fileEntity)) == null) {
            if (type != null && fileEntity != null) {
                int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return uploadAttachmentSync(fileEntity.mFileName.mFileID, fileEntity.mFile);
                    }
                    return new ResponseEntity(false);
                }
                return uploadContentSync(fileEntity.mFile);
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
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
                    String str2 = "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath();
                    String message = uploadSync.getMessage();
                    if (!TextUtils.isEmpty(message)) {
                        String str3 = "attachment upload message = " + message;
                    }
                }
                return uploadSync;
            }
            return new ResponseEntity(false);
        }
        return (ResponseEntity) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0 : invokeV.booleanValue;
    }

    public void reUpload(Type type, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, i2) == null) || i2 <= 0) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = null;
        int i3 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type[type.ordinal()];
        if (i3 == 1) {
            threadPoolExecutor = this.mContentExecutor;
        } else if (i3 == 2) {
            threadPoolExecutor = this.mAttachmentExecutor;
        }
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable(this, type, i2) { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.3
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
                        Object[] objArr = {this, type, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$type = type;
                    this.val$maxFileCount = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.doUpload(this.val$type, this.val$maxFileCount)) {
                            this.this$0.updateFileFlag(this.val$type);
                        } else {
                            this.this$0.reUpload(this.val$type, this.val$maxFileCount);
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

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        InterceptResult invokeL;
        BaseContentUploader contentUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) {
            if (file == null) {
                return new ResponseEntity(false);
            }
            BaseContentUploader defaultContentUploader = UploaderProvider.getDefaultContentUploader();
            ResponseEntity uploadSync = defaultContentUploader.uploadSync(file);
            if (!(uploadSync != null ? uploadSync.isSuccess() : false) && (contentUploader = UploaderProvider.getContentUploader()) != defaultContentUploader) {
                uploadSync = contentUploader.uploadSync(file);
            }
            if (uploadSync == null) {
                uploadSync = new ResponseEntity(false);
            }
            if (DEBUG && uploadSync != null) {
                String str = "content upload file = " + file.getAbsolutePath();
                String str2 = "content upload success = " + uploadSync.isSuccess();
                String message = uploadSync.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    String str3 = "content upload message = " + message;
                }
            }
            return uploadSync;
        }
        return (ResponseEntity) invokeL.objValue;
    }

    /* loaded from: classes11.dex */
    public static final class FileName {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public transient /* synthetic */ FieldHolder $fh;
        public String mFileID;
        public LogType mLogType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j2, @NonNull String str2, @NonNull LogType logType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), str2, logType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j2);
            this.mProcessName = str2;
            this.mLogType = logType;
        }

        public static String createFileID(@NonNull String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j2)) == null) {
                return str.replace("_", "").replace("#", "") + "_" + j2;
            }
            return (String) invokeLJ.objValue;
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

        public static FileName getFileName(String str, String str2, LogType logType) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, logType)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && logType != null) {
                    long j2 = -1;
                    String[] split = str.split("_");
                    if (split != null && split.length == 2) {
                        try {
                            j2 = Long.valueOf(split[1]).longValue();
                        } catch (NumberFormatException unused) {
                            return null;
                        }
                    }
                    long j3 = j2;
                    if (j3 > 0) {
                        return new FileName(str, j3, str2, logType);
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
                    long j2 = -1;
                    String str2 = split[0];
                    if (!TextUtils.isEmpty(str2) && (split2 = str2.split("_")) != null && split2.length == 2) {
                        String str3 = split2[1];
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                j2 = Long.valueOf(str3).longValue();
                            } catch (NumberFormatException unused) {
                                return null;
                            }
                        }
                    }
                    String str4 = split[1];
                    LogType logType = LogType.getLogType(split[2]);
                    if (!TextUtils.isEmpty(str2) && j2 > 0 && !TextUtils.isEmpty(str4) && logType != null) {
                        return new FileName(str2, j2, str4, logType);
                    }
                }
                return null;
            }
            return (FileName) invokeL.objValue;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), (BaseUploaderStrategy.UploadListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, logObject, list, set, list2) == null) {
            if (logObject.mLogType != LogType.JAVA_CRASH || this.mUploadJavaCrash) {
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
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
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
                                        String str = "new content file = " + this.val$contentFile.getAbsolutePath();
                                    }
                                    ResponseEntity uploadContentSync = this.this$0.uploadContentSync(this.val$contentFile);
                                    if (uploadContentSync.isSuccess()) {
                                        this.val$contentFile.delete();
                                    }
                                    if (this.this$0.mContentExecutor.getQueue().size() == 0) {
                                        if (!uploadContentSync.isSuccess()) {
                                            this.this$0.cleanDiskCache(Type.CONTENT);
                                        } else {
                                            this.this$0.reUpload(Type.CONTENT, 5);
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
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
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
                                        String str = "new attachement file = " + this.val$attachZipFile.getAbsolutePath();
                                    }
                                    ResponseEntity uploadAttachmentSync = this.this$0.uploadAttachmentSync(this.val$fileID, this.val$attachZipFile);
                                    if (uploadAttachmentSync.isSuccess()) {
                                        this.val$attachZipFile.delete();
                                    }
                                    if (this.this$0.mAttachmentExecutor.getQueue().size() == 0) {
                                        if (!uploadAttachmentSync.isSuccess()) {
                                            this.this$0.cleanDiskCache(Type.ATTACHMENT);
                                        } else {
                                            this.this$0.reUpload(Type.ATTACHMENT, 5);
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
}
