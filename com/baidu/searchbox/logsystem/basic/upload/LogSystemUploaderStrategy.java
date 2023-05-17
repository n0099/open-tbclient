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
    public static final boolean DEBUG = LLog.sDebug;
    public static final String TAG = "LSStrategy";
    public ThreadPoolExecutor mAttachmentExecutor;
    public ThreadPoolExecutor mContentExecutor;
    public boolean mInvalidDirDeleted;

    /* loaded from: classes3.dex */
    public static final class Constants {
        public static final int KEEP_ALIVE_TIME = 60000;
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final int MAX_COUNT_CONTENT = 500;
        public static final long MAX_LIFE_TIME = 2592000000L;
        public static final int UPLOAD_MAX_FILE = 5;
    }

    /* loaded from: classes3.dex */
    public enum Type {
        CONTENT,
        ATTACHMENT
    }

    /* renamed from: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$logsystem$basic$upload$LogSystemUploaderStrategy$Type;

        static {
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
    public static final class FileEntity implements Comparable<FileEntity> {
        @NonNull
        public File mFile;
        @NonNull
        public FileName mFileName;

        public FileEntity(@NonNull File file, @NonNull FileName fileName) {
            this.mFile = file;
            this.mFileName = fileName;
        }

        public static FileEntity getFileEntity(@NonNull File file) {
            FileName fileName;
            if (file == null || !file.exists() || (fileName = FileName.getFileName(file.getName())) == null) {
                return null;
            }
            return new FileEntity(file, fileName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull FileEntity fileEntity) {
            int i = ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) > 0L ? 1 : ((this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue()) == 0L ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            if (i < 0) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FileName {
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public String mFileID;
        public LogType mLogType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mLogType = logType;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
        }

        public static String createFileID(@NonNull String str, long j) {
            return str.replace("_", "").replace("#", "") + "_" + j;
        }

        public static FileName getFileName(@NonNull String str) {
            String[] split;
            String[] split2;
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

        public static FileName getFileName(String str, String str2, LogType logType) {
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

        @NonNull
        public String toString() {
            return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
        }
    }

    /* loaded from: classes3.dex */
    public static final class StoreUtil {
        public static final String BASE_GZIP_TMP = ".gz.tmp";
        public static final String BASE_TMP = ".tmp";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String BASE_UPLOAD_CONTENT_DIR = "content";
        public static final String BASE_UPLOAD_CONTENT_FLAG = "content.flag";
        public static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";

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
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "attachment");
        }

        public static final File getAttachFlag() {
            return new File(getStoreDir(), "attachment.flag");
        }

        public static File getContentDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content");
        }

        public static final File getContentFlag() {
            return new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG);
        }

        public static File getInvalidZipDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "zip_supply");
        }

        public static File getStoreDir() {
            return LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get();
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            return new File(file, FileName.getFileName(fileName));
        }
    }

    /* loaded from: classes3.dex */
    public static final class TrimConfig {
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i, long j) {
            this.mMaxCount = i;
            this.mLifeTime = j;
        }
    }

    public LogSystemUploaderStrategy() {
        this(true, true, null);
    }

    public static boolean checkFlag() {
        if (!StoreUtil.access$000().exists() && !StoreUtil.access$100().exists()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        if (this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0) {
            return true;
        }
        return false;
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
    }

    public void reUpload(final Type type, final int i) {
        if (i <= 0) {
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
            threadPoolExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!LogSystemUploaderStrategy.this.doUpload(type, i)) {
                        LogSystemUploaderStrategy.this.updateFileFlag(type);
                    } else {
                        LogSystemUploaderStrategy.this.reUpload(type, i);
                    }
                }
            });
        }
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        this.mInvalidDirDeleted = false;
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mAttachmentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag(Type type) {
        File access$1000;
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

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
        if (r7 == 2) goto L44;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File createAttachZipFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2, @NonNull String str) {
        FileName fileName;
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

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i) {
        File[] listFiles;
        int i2;
        int i3;
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

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
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

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
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

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
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

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(final Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        if (logObject.mLogType == LogType.JAVA_CRASH && !this.mUploadJavaCrash) {
            return;
        }
        if ((logObject.mLogType != LogType.NATIVE_CRASH || this.mUploadNativeCrash) && (crashTAG = CrashUtil.CrashTAG.getCrashTAG(logObject.getCrashTAG())) != null) {
            final String createFileID = FileName.createFileID(crashTAG.mCrashProcessUUID, System.currentTimeMillis());
            final File createContentFile = createContentFile(logObject, list2, createFileID);
            final File createAttachZipFile = createAttachZipFile(logObject, list, set, list2, createFileID);
            BaseUploaderStrategy.UploadListener uploadListener = this.mUploadListener;
            if (uploadListener != null) {
                uploadListener.onUploadStart(logObject);
            }
            if (createContentFile != null) {
                this.mContentExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Utility.isNetWorkEnabled(context)) {
                            LogSystemUploaderStrategy.this.cleanDiskCache(Type.CONTENT);
                            return;
                        }
                        LogSystemUploaderStrategy.this.updateFileFlag(Type.CONTENT);
                        if (LLog.sDebug) {
                            Log.d("LSStrategy", "new content file = " + createContentFile.getAbsolutePath());
                        }
                        ResponseEntity uploadContentSync = LogSystemUploaderStrategy.this.uploadContentSync(createContentFile);
                        if (uploadContentSync.isSuccess()) {
                            createContentFile.delete();
                        }
                        if (LogSystemUploaderStrategy.this.mContentExecutor.getQueue().size() == 0) {
                            if (!uploadContentSync.isSuccess()) {
                                LogSystemUploaderStrategy.this.cleanDiskCache(Type.CONTENT);
                            } else {
                                LogSystemUploaderStrategy.this.reUpload(Type.CONTENT, 5);
                            }
                        }
                    }
                });
            }
            if (createAttachZipFile != null) {
                this.mAttachmentExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Utility.isNetWorkEnabled(context)) {
                            LogSystemUploaderStrategy.this.cleanDiskCache(Type.ATTACHMENT);
                            return;
                        }
                        LogSystemUploaderStrategy.this.updateFileFlag(Type.ATTACHMENT);
                        if (LLog.sDebug) {
                            Log.d("LSStrategy", "new attachement file = " + createAttachZipFile.getAbsolutePath());
                        }
                        ResponseEntity uploadAttachmentSync = LogSystemUploaderStrategy.this.uploadAttachmentSync(createFileID, createAttachZipFile);
                        if (uploadAttachmentSync.isSuccess()) {
                            createAttachZipFile.delete();
                        }
                        if (LogSystemUploaderStrategy.this.mAttachmentExecutor.getQueue().size() == 0) {
                            if (!uploadAttachmentSync.isSuccess()) {
                                LogSystemUploaderStrategy.this.cleanDiskCache(Type.ATTACHMENT);
                            } else {
                                LogSystemUploaderStrategy.this.reUpload(Type.ATTACHMENT, 5);
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

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        boolean z;
        BaseContentUploader contentUploader;
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
}
