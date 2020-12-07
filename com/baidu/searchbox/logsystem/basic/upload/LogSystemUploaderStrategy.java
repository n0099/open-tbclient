package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.util.io.Closeables;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.util.Common;
import com.baidu.searchbox.logsystem.util.DebugUtil;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.logsystem.util.ZipUtils;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class LogSystemUploaderStrategy extends BaseUploaderStrategy {
    private static final boolean DEBUG = LLog.sDebug;
    private static final String TAG = "LSStrategy";
    private ThreadPoolExecutor mAttachmentExecutor;
    private ThreadPoolExecutor mContentExecutor;
    private boolean mInvalidDirDeleted;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum Type {
        CONTENT,
        ATTACHMENT
    }

    public LogSystemUploaderStrategy() {
        this(true, true, null);
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2) {
        this(z, z2, null);
    }

    public LogSystemUploaderStrategy(boolean z, boolean z2, @Nullable BaseUploaderStrategy.UploadListener uploadListener) {
        super(z, z2, uploadListener);
        this.mInvalidDirDeleted = false;
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.mAttachmentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static boolean checkFlag() {
        return StoreUtil.getContentFlag().exists() || StoreUtil.getAttachFlag().exists();
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(Context context) {
        reUpload(Type.CONTENT, 5);
        reUpload(Type.ATTACHMENT, 5);
        if (!this.mInvalidDirDeleted) {
            this.mInvalidDirDeleted = true;
            File invalidZipDir = StoreUtil.getInvalidZipDir();
            if (invalidZipDir.exists()) {
                invalidZipDir.delete();
            }
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy, com.baidu.searchbox.logsystem.basic.upload.UploadInterface
    public void upload(final Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2) {
        CrashUtil.CrashTAG crashTAG;
        if (logObject.mLogType != LogType.JAVA_CRASH || this.mUploadJavaCrash) {
            if ((logObject.mLogType == LogType.NATIVE_CRASH && !this.mUploadNativeCrash) || (crashTAG = CrashUtil.CrashTAG.getCrashTAG(logObject.getCrashTAG())) == null) {
                return;
            }
            final String createFileID = FileName.createFileID(crashTAG.mCrashProcessUUID, System.currentTimeMillis());
            final File createContentFile = createContentFile(logObject, list2, createFileID);
            final File createAttachZipFile = createAttachZipFile(logObject, list, set, list2, createFileID);
            if (this.mUploadListener != null) {
                this.mUploadListener.onUploadStart(logObject);
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
                            Log.d(LogSystemUploaderStrategy.TAG, "new content file = " + createContentFile.getAbsolutePath());
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
                            Log.d(LogSystemUploaderStrategy.TAG, "new attachement file = " + createAttachZipFile.getAbsolutePath());
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
                if (this.mUploadListener != null) {
                    this.mUploadListener.onUploadDone(logObject);
                }
            }
        }
    }

    public void reUpload(final Type type, final int i) {
        if (i > 0) {
            ThreadPoolExecutor threadPoolExecutor = null;
            switch (type) {
                case CONTENT:
                    threadPoolExecutor = this.mContentExecutor;
                    break;
                case ATTACHMENT:
                    threadPoolExecutor = this.mAttachmentExecutor;
                    break;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(Type type, int i) {
        File[] listFiles;
        int i2;
        int i3;
        switch (type) {
            case CONTENT:
                listFiles = StoreUtil.getContentDir().listFiles();
                i2 = 500;
                break;
            case ATTACHMENT:
                listFiles = StoreUtil.getAttachDir().listFiles();
                i2 = 100;
                break;
            default:
                listFiles = null;
                i2 = 0;
                break;
        }
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i2, BdKVCache.MILLS_30Days));
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
        if (((LinkedList) fileCluster.first).size() > 0) {
            Iterator it2 = ((LinkedList) fileCluster.first).iterator();
            i3 = 0;
            while (it2.hasNext() && i3 < i) {
                FileEntity fileEntity = (FileEntity) it2.next();
                if (fileEntity != null) {
                    i3++;
                    ResponseEntity uploadAction = uploadAction(type, fileEntity);
                    if (uploadAction != null && uploadAction.isSuccess()) {
                        fileEntity.mFile.delete();
                    }
                }
                i3 = i3;
            }
        } else {
            i3 = 0;
        }
        return i3 == i;
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull Type type, @NonNull FileEntity fileEntity) {
        if (type == null || fileEntity == null) {
            return new ResponseEntity(false);
        }
        switch (type) {
            case CONTENT:
                return uploadContentSync(fileEntity.mFile);
            case ATTACHMENT:
                return uploadAttachmentSync(fileEntity.mFileName.mFileID, fileEntity.mFile);
            default:
                return new ResponseEntity(false);
        }
    }

    @NonNull
    public ResponseEntity uploadContentSync(@NonNull File file) {
        BaseContentUploader contentUploader;
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
            Log.d(TAG, "content upload file = " + file.getAbsolutePath());
            Log.d(TAG, "content upload success = " + uploadSync.isSuccess());
            String message = uploadSync.getMessage();
            if (!TextUtils.isEmpty(message)) {
                Log.d(TAG, "content upload message = " + message);
                return uploadSync;
            }
            return uploadSync;
        }
        return uploadSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            return new ResponseEntity(false);
        }
        ResponseEntity uploadSync = UploaderProvider.getAttachUploader().uploadSync(str, file);
        if (uploadSync == null) {
            uploadSync = new ResponseEntity(false);
        }
        if (DEBUG && uploadSync != null) {
            Log.d(TAG, "attachment upload success = " + uploadSync.isSuccess() + "," + file.getAbsolutePath());
            String message = uploadSync.getMessage();
            if (!TextUtils.isEmpty(message)) {
                Log.d(TAG, "attachment upload message = " + message);
                return uploadSync;
            }
            return uploadSync;
        }
        return uploadSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache(Type type) {
        File[] listFiles;
        int i;
        switch (type) {
            case CONTENT:
                listFiles = StoreUtil.getContentDir().listFiles();
                i = 500;
                break;
            case ATTACHMENT:
                listFiles = StoreUtil.getAttachDir().listFiles();
                i = 100;
                break;
            default:
                i = 0;
                listFiles = null;
                break;
        }
        if (listFiles != null && listFiles.length != 0) {
            Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster = fileCluster(listFiles, new TrimConfig(i, BdKVCache.MILLS_30Days));
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

    private File createContentFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str) {
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
        File file2 = new File(obtainFilePath.getAbsolutePath() + ".gz.tmp");
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

    @Nullable
    private File createAttachZipFile(@NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2, @NonNull String str) {
        if (logObject.getLogBasicDataFile() == null || !logObject.getLogBasicDataFile().exists()) {
            return null;
        }
        FileName fileName = FileName.getFileName(str, logObject.getProcessName(), logObject.mLogType);
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
            if (LLog.sDebug) {
                Log.d(TAG, e.getMessage());
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
                Iterator<LogFile> it = list2.iterator();
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        LogFile next = it.next();
                        if (next == null || !(next.mFile.getName().startsWith(CrashUtil.CrashpadConstant.FULL_BDMP_PERFIX) || next.mFile.getName().startsWith(CrashUtil.CrashpadConstant.TXT_EXTRA))) {
                            i = i2;
                        } else {
                            linkedList.add(next);
                            i = i2 + 1;
                        }
                        if (i != 2) {
                        }
                    }
                }
            }
            try {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(new ZipUtils.ZipSrc(logObject.getLogBasicDataFile(), SnapshotConstant.ProcessConstants.PROCESS_LOG_BASIC_DATA));
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    LogFile logFile = (LogFile) it2.next();
                    if (logFile != null && logFile.mFile.exists()) {
                        linkedList2.add(new ZipUtils.ZipSrc(logFile.mFile));
                    }
                }
                ZipUtils.zip(obtainFilePath, linkedList2);
                return obtainFilePath;
            } catch (IOException e2) {
                if (LLog.sDebug) {
                    Log.d(TAG, e2.getMessage());
                }
            }
        }
        return null;
    }

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseUploaderStrategy
    public boolean canStopService() {
        return this.mAttachmentExecutor.getQueue().size() == 0 && this.mAttachmentExecutor.getActiveCount() == 0 && this.mContentExecutor.getQueue().size() == 0 && this.mContentExecutor.getActiveCount() == 0;
    }

    @NonNull
    private Pair<LinkedList<FileEntity>, LinkedList<File>> fileCluster(@NonNull File[] fileArr, @NonNull TrimConfig trimConfig) {
        int i = 0;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        for (File file : fileArr) {
            if (file != null && file.exists()) {
                FileEntity fileEntity = FileEntity.getFileEntity(file);
                if (fileEntity == null) {
                    linkedList2.add(file);
                } else if (currentTimeMillis - fileEntity.mFileName.mTimestamp.longValue() > trimConfig.mLifeTime) {
                    linkedList2.add(file);
                } else {
                    linkedList.add(fileEntity);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag(Type type) {
        File contentFlag;
        File file = null;
        switch (type) {
            case CONTENT:
                contentFlag = StoreUtil.getContentFlag();
                file = StoreUtil.getContentDir();
                break;
            case ATTACHMENT:
                contentFlag = StoreUtil.getAttachFlag();
                file = StoreUtil.getAttachDir();
                break;
            default:
                contentFlag = null;
                break;
        }
        if (contentFlag != null && file != null) {
            String[] list = file.list();
            boolean z = false;
            if (list != null && list.length > 0) {
                z = true;
            }
            boolean exists = contentFlag.exists();
            if (z) {
                if (!exists) {
                    try {
                        contentFlag.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (exists) {
                contentFlag.delete();
            }
        }
    }

    /* loaded from: classes15.dex */
    private static final class Constants {
        private static final int KEEP_ALIVE_TIME = 60000;
        private static final int MAX_COUNT_ATTACHMENT = 100;
        private static final int MAX_COUNT_CONTENT = 500;
        private static final long MAX_LIFE_TIME = 2592000000L;
        private static final String UBC_EVENT_ID = "1156";
        private static final int UI_TRACE_MAX_SIZE = 20;
        private static final int UPLOAD_MAX_FILE = 5;

        private Constants() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class TrimConfig {
        private long mLifeTime;
        private int mMaxCount;

        private TrimConfig(int i, long j) {
            this.mMaxCount = i;
            this.mLifeTime = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class StoreUtil {
        private static final String BASE_GZIP_TMP = ".gz.tmp";
        private static final String BASE_TMP = ".tmp";
        private static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        private static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        private static final String BASE_UPLOAD_CONTENT_DIR = "content";
        private static final String BASE_UPLOAD_CONTENT_FLAG = "content.flag";
        private static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";

        private StoreUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static File getAttachDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), BASE_UPLOAD_ATTACHMENT_DIR);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static File getContentDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), "content");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static File getInvalidZipDir() {
            return new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), INVALID_UPLOAD_ZIP_DIR);
        }

        private static File getStoreDir() {
            return LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            return new File(file, FileName.getFileName(fileName));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final File getAttachFlag() {
            return new File(getStoreDir(), BASE_UPLOAD_ATTACHMENT_FLAG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final File getContentFlag() {
            return new File(getStoreDir(), BASE_UPLOAD_CONTENT_FLAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class FileEntity implements Comparable<FileEntity> {
        @NonNull
        private File mFile;
        @NonNull
        private FileName mFileName;

        private FileEntity(@NonNull File file, @NonNull FileName fileName) {
            this.mFile = file;
            this.mFileName = fileName;
        }

        protected static FileEntity getFileEntity(@NonNull File file) {
            FileName fileName;
            if (file == null || !file.exists() || (fileName = FileName.getFileName(file.getName())) == null) {
                return null;
            }
            return new FileEntity(file, fileName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull FileEntity fileEntity) {
            long longValue = this.mFileName.mTimestamp.longValue() - fileEntity.mFileName.mTimestamp.longValue();
            if (longValue > 0) {
                return -1;
            }
            if (longValue < 0) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class FileName {
        private static final String FILE_ID_SEPARATOR = "_";
        private static final String SEPARATOR = "#";
        private String mFileID;
        private LogType mLogType;
        private String mProcessName;
        private Long mTimestamp;

        private FileName(@NonNull String str, long j, @NonNull String str2, @NonNull LogType logType) {
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mLogType = logType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String createFileID(@NonNull String str, long j) {
            return str.replace("_", "").replace("#", "") + "_" + j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mLogType.getTypeName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FileName getFileName(String str, String str2, LogType logType) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || logType == null) {
                return null;
            }
            long j = -1;
            String[] split = str.split("_");
            if (split != null && split.length == 2) {
                try {
                    j = Long.valueOf(split[1]).longValue();
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            if (j > 0) {
                return new FileName(str, j, str2, logType);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FileName getFileName(@NonNull String str) {
            String[] split;
            String[] split2;
            if (TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 3) {
                return null;
            }
            long j = -1;
            String str2 = split[0];
            if (!TextUtils.isEmpty(str2) && (split2 = str2.split("_")) != null && split2.length == 2) {
                String str3 = split2[1];
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        j = Long.valueOf(str3).longValue();
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
            String str4 = split[1];
            LogType logType = LogType.getLogType(split[2]);
            if (TextUtils.isEmpty(str2) || j <= 0 || TextUtils.isEmpty(str4) || logType == null) {
                return null;
            }
            return new FileName(str2, j, str4, logType);
        }

        @NonNull
        public String toString() {
            return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mLogType.getTypeName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class CrashPadUtil {
        private static final int MAX_READ_BDMP = 102400;
        private static final int MAX_READ_EXTRA = 20480;

        private CrashPadUtil() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1083=4] */
        /* JADX INFO: Access modifiers changed from: private */
        public static void createMiniBDMPInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            ByteArrayOutputStream byteArrayOutputStream;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            int i = 0;
            if (file == null || jsonWriter == null || !file.exists()) {
                return;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    int round = Math.round(76800.0f);
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1 || i >= round) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        i += read;
                    }
                    byteArrayOutputStream.flush();
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                    if (LogSystemUploaderStrategy.DEBUG) {
                        DebugUtil.saveLog("mini-bdmp : " + encodeToString);
                    }
                    jsonWriter.name("stacktrace_crashpad_bdmp").value(encodeToString);
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream2);
                        Closeables.closeSafely(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void createJsonExtraInfo(@NonNull File file, @NonNull JsonWriter jsonWriter) {
            if (file != null && file.exists() && jsonWriter != null) {
                try {
                    Pair<String, Boolean> readFile = Utility.readFile(file, MAX_READ_EXTRA);
                    if (readFile != null && !TextUtils.isEmpty((CharSequence) readFile.first)) {
                        if (LogSystemUploaderStrategy.DEBUG) {
                            DebugUtil.saveLog("json-extra : " + ((String) readFile.first));
                            Log.d(LogSystemUploaderStrategy.TAG, "json-extra.size = " + ((String) readFile.first).length());
                        }
                        jsonWriter.name("crash_envir").value((String) readFile.first);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class ContentUtil {
        private static final byte GZIP_HEAD_1 = 117;
        private static final byte GZIP_HEAD_2 = 123;

        private ContentUtil() {
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x01e7 A[LOOP:0: B:22:0x00a3->B:70:0x01e7, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00ca A[EDGE_INSN: B:78:0x00ca->B:31:0x00ca ?: BREAK  , SYNTHETIC] */
        @NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static void createCrashInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull JsonWriter jsonWriter) {
            String string;
            File file;
            File file2;
            int i;
            File file3 = null;
            try {
                LogExtra logExtra = logObject.getLogExtra();
                if (logExtra != null) {
                    jsonWriter.name("content");
                    jsonWriter.beginObject();
                    jsonWriter.name("page").value(logExtra.mPage);
                    jsonWriter.name("type").value(logObject.mLogType == LogType.NATIVE_CRASH ? "NATIVE" : "JAVA");
                    jsonWriter.name("crashtime").value(logExtra.mCrashTime);
                    jsonWriter.name("launchTime").value(logExtra.mLaunchTime);
                    jsonWriter.name("processLifeTime").value(logExtra.mProcessLifeTime);
                    if (logExtra.mForeground != null) {
                        jsonWriter.name("foreground").value(logExtra.mForeground);
                    }
                    String logBasicData = logObject.getLogBasicData();
                    String typeName = logObject.mLogType.getTypeName();
                    if (!TextUtils.isEmpty(logBasicData) && logBasicData.startsWith(typeName)) {
                        jsonWriter.name("stacktrace").value(logBasicData.replaceFirst(Matcher.quoteReplacement(typeName), ""));
                    } else {
                        jsonWriter.name("stacktrace").value(logBasicData);
                    }
                    if (logObject.mLogType == LogType.NATIVE_CRASH && list != null && list.size() > 0) {
                        Iterator<LogFile> it = list.iterator();
                        int i2 = 0;
                        File file4 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                file = file3;
                                file2 = file4;
                                break;
                            }
                            LogFile next = it.next();
                            if (next != null) {
                                if (next.mFile.getName().startsWith(CrashUtil.CrashpadConstant.MIND_BDMP_PREFIX)) {
                                    File file5 = next.mFile;
                                    file = file3;
                                    file2 = file5;
                                    i = i2 + 1;
                                } else if (next.mFile.getName().startsWith(CrashUtil.CrashpadConstant.JSON_EXTRA)) {
                                    file = next.mFile;
                                    file2 = file4;
                                    i = i2 + 1;
                                }
                                if (i != 2) {
                                    break;
                                }
                                i2 = i;
                                file4 = file2;
                                file3 = file;
                            }
                            file = file3;
                            file2 = file4;
                            i = i2;
                            if (i != 2) {
                            }
                        }
                        if (file2 != null) {
                            CrashPadUtil.createMiniBDMPInfo(file2, jsonWriter);
                        }
                        if (file != null) {
                            CrashPadUtil.createJsonExtraInfo(file, jsonWriter);
                        }
                    }
                    jsonWriter.name(com.baidu.searchbox.perfframe.ioc.Constant.KEY_PROCESS_NAME).value(logObject.getProcessName());
                    jsonWriter.name("crashThreadDes");
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(logExtra.mCrashThreadName);
                    jsonWriter.name("priority").value(logExtra.mCrashThreadPriority);
                    jsonWriter.endObject();
                    if (!TextUtils.isEmpty(logExtra.mJSONAttach)) {
                        jsonWriter.name("traceinfo");
                        jsonWriter.beginObject();
                        jsonWriter.name("traceid").value(logExtra.mTraceID);
                        String str = "";
                        try {
                            JSONObject jSONObject = new JSONObject(logExtra.mJSONAttach);
                            str = jSONObject.getString(Constant.LAUNCH_STAGE);
                            string = jSONObject.getString(Constant.CRASH_STAGE);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next2 = keys.next();
                                if (!Constant.LAUNCH_STAGE.equals(next2) && !Constant.CRASH_STAGE.equals(next2)) {
                                    jsonWriter.name(next2).value(jSONObject.getString(next2));
                                }
                            }
                        } catch (JSONException e) {
                            if (LLog.sDebug) {
                                Log.d(LogSystemUploaderStrategy.TAG, e.getMessage());
                            }
                        }
                        jsonWriter.endObject();
                        if (!TextUtils.isEmpty(str)) {
                            jsonWriter.name(Constant.LAUNCH_STAGE).value(str);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            jsonWriter.name(Constant.CRASH_STAGE).value(string);
                        }
                    }
                    jsonWriter.name("pageTrace");
                    jsonWriter.beginArray();
                    createTraceUI(logObject.getProcessName(), jsonWriter);
                    jsonWriter.endArray();
                    jsonWriter.endObject();
                }
            } catch (IOException e2) {
                if (LLog.sDebug) {
                    e2.printStackTrace();
                }
            }
        }

        private static void createTraceUI(@NonNull String str, @NonNull JsonWriter jsonWriter) {
            RandomAccessFile randomAccessFile;
            File file = new File(LogPipelineSingleton.obtainFileDirWithProcessName(str), SnapshotConstant.ProcessConstants.PROC_UI_TRACE);
            if (file.exists()) {
                int i = 0;
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        try {
                            long length = randomAccessFile.length();
                            if (length > 0) {
                                long j = length - 1;
                                while (j > 0) {
                                    j--;
                                    randomAccessFile.seek(j);
                                    if (randomAccessFile.readByte() == 10) {
                                        String[] parse = TrackUI.parse(randomAccessFile.readLine());
                                        if (parse != null && parse.length == 4) {
                                            jsonWriter.beginObject();
                                            jsonWriter.name("time").value(parse[1]);
                                            jsonWriter.name("page").value(parse[2]);
                                            jsonWriter.name("event").value(parse[3]);
                                            jsonWriter.endObject();
                                        }
                                        i++;
                                        if (i == 20) {
                                            break;
                                        }
                                    }
                                }
                                if (j == 0) {
                                    randomAccessFile.seek(0L);
                                    String[] parse2 = TrackUI.parse(randomAccessFile.readLine());
                                    if (parse2 != null) {
                                        jsonWriter.beginObject();
                                        jsonWriter.name("time").value(parse2[1]);
                                        jsonWriter.name("page").value(parse2[2]);
                                        jsonWriter.name("event").value(parse2[3]);
                                        jsonWriter.endObject();
                                    }
                                }
                            }
                            Closeables.closeSafely(randomAccessFile);
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            Closeables.closeSafely(randomAccessFile);
                        }
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(randomAccessFile);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                    Closeables.closeSafely(randomAccessFile);
                    throw th;
                }
            }
        }

        private static void createAperfInfo(@NonNull String str, @NonNull String str2, @NonNull JsonWriter jsonWriter) {
            try {
                jsonWriter.name("aperf");
                jsonWriter.beginObject();
                jsonWriter.name(com.baidu.searchbox.perfframe.ioc.Constant.KEY_LAUNCHID).value(str);
                jsonWriter.name("logid").value(UUID.randomUUID().toString());
                jsonWriter.name("appext").value(Common.getAppExtra());
                jsonWriter.name("packagename").value(AppRuntime.getAppContext().getPackageName());
                jsonWriter.name("osversion").value(Common.getDeviceInfo().mOSVersion);
                jsonWriter.name("memory").value(Common.getDeviceInfo().mMemory);
                jsonWriter.name("cpu").value(Common.getDeviceInfo().mCPU);
                jsonWriter.name("sdkversion").value(Common.getVersionInfo().mSDKVersion);
                jsonWriter.name("appversion").value(Common.getVersionInfo().mAppVersion);
                jsonWriter.name("network").value(new NetworkParam().getCurrentNetTypeId());
                String deviceScore = LokiRuntime.getIdentityContext().getDeviceScore();
                if (!TextUtils.isEmpty(deviceScore)) {
                    jsonWriter.name("devicescore").value(deviceScore);
                }
                jsonWriter.name("fileid").value(str2);
                jsonWriter.endObject();
            } catch (IOException e) {
                if (LLog.sDebug) {
                    e.printStackTrace();
                }
            }
        }

        public static void createUBCContentInfo(@NonNull LogObject logObject, @Nullable List<LogFile> list, @NonNull String str, @NonNull File file) {
            JsonWriter jsonWriter;
            try {
                try {
                    jsonWriter = new JsonWriter(new FileWriter(file));
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name("data");
                        jsonWriter.beginArray();
                        jsonWriter.beginObject();
                        jsonWriter.name("id").value("1156");
                        jsonWriter.name("timestamp").value(System.currentTimeMillis());
                        jsonWriter.name("idtype").value("1");
                        jsonWriter.name("type").value("0");
                        jsonWriter.name("isreal").value("1");
                        createAperfInfo(logObject.getCrashTAG(), str, jsonWriter);
                        createCrashInfo(logObject, list, jsonWriter);
                        jsonWriter.endObject();
                        jsonWriter.endArray();
                        jsonWriter.endObject();
                        jsonWriter.flush();
                        Closeables.closeSafely(jsonWriter);
                    } catch (IOException e) {
                        e = e;
                        if (LLog.sDebug) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(jsonWriter);
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely((Closeable) null);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                jsonWriter = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Closeable) null);
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1422=4] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void gzipContent(@NonNull File file, @NonNull File file2) {
            File file3;
            FileInputStream fileInputStream;
            GZIPOutputStream gZIPOutputStream;
            FileInputStream fileInputStream2;
            GZIPOutputStream gZIPOutputStream2;
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            if (file == null || file2 == null || !file.exists() || !file2.exists()) {
                return;
            }
            byte[] bArr = new byte[1024];
            try {
                file3 = new File(file2.getAbsolutePath() + ".tmp");
                try {
                    if (Utility.createNewEmptyFile(file3)) {
                        gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file3));
                        try {
                            fileInputStream2 = new FileInputStream(file);
                            while (true) {
                                try {
                                    int read = fileInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    gZIPOutputStream2.write(bArr, 0, read);
                                } catch (IOException e) {
                                    e = e;
                                } catch (Throwable th) {
                                    th = th;
                                    gZIPOutputStream = gZIPOutputStream2;
                                    fileInputStream = fileInputStream2;
                                }
                            }
                            gZIPOutputStream2.flush();
                            gZIPOutputStream2.close();
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                gZIPOutputStream2 = null;
                                try {
                                    e.printStackTrace();
                                    Closeables.closeSafely(fileOutputStream2);
                                    Closeables.closeSafely(gZIPOutputStream2);
                                    Closeables.closeSafely(fileInputStream2);
                                    if (file3 == null && file3.exists()) {
                                        file3.delete();
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    FileInputStream fileInputStream3 = fileInputStream2;
                                    gZIPOutputStream = gZIPOutputStream2;
                                    fileInputStream = fileInputStream3;
                                    Closeables.closeSafely(fileOutputStream2);
                                    Closeables.closeSafely(gZIPOutputStream);
                                    Closeables.closeSafely(fileInputStream);
                                    if (file3 != null && file3.exists()) {
                                        file3.delete();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                gZIPOutputStream = null;
                                Closeables.closeSafely(fileOutputStream2);
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely(fileInputStream);
                                if (file3 != null) {
                                    file3.delete();
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPOutputStream = gZIPOutputStream2;
                            fileInputStream = null;
                        }
                    }
                    fileInputStream = new FileInputStream(file3);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (IOException e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        gZIPOutputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPOutputStream = null;
                    }
                    try {
                        fileOutputStream.write(new byte[]{GZIP_HEAD_1, GZIP_HEAD_2});
                        if (fileInputStream.read(new byte[2]) != -1) {
                            while (true) {
                                int read2 = fileInputStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read2);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        Closeables.closeSafely((Closeable) null);
                        Closeables.closeSafely((Closeable) null);
                        Closeables.closeSafely((Closeable) null);
                        if (file3 == null || !file3.exists()) {
                            return;
                        }
                        file3.delete();
                    } catch (IOException e5) {
                        e = e5;
                        fileInputStream2 = fileInputStream;
                        gZIPOutputStream2 = null;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        Closeables.closeSafely(fileOutputStream2);
                        Closeables.closeSafely(gZIPOutputStream2);
                        Closeables.closeSafely(fileInputStream2);
                        if (file3 == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        gZIPOutputStream = null;
                        fileOutputStream2 = fileOutputStream;
                        Closeables.closeSafely(fileOutputStream2);
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely(fileInputStream);
                        if (file3 != null) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream2 = null;
                    gZIPOutputStream2 = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                    gZIPOutputStream = null;
                }
            } catch (IOException e7) {
                e = e7;
                file3 = null;
                fileInputStream2 = null;
                gZIPOutputStream2 = null;
            } catch (Throwable th8) {
                th = th8;
                file3 = null;
                fileInputStream = null;
                gZIPOutputStream = null;
            }
        }
    }
}
