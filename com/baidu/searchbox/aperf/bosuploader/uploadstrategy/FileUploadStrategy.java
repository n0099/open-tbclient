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
import com.baidu.tieba.ej1;
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
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FileUploadStrategy";
    public boolean mInvalidDirDeleted = false;
    public ThreadPoolExecutor mUploadExecutor = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* loaded from: classes2.dex */
    public static final class Constants {
        public static final int MAX_COUNT_ATTACHMENT = 100;
        public static final long MAX_LIFE_TIME = 2592000000L;
        public static final int UPLOAD_MAX_FILE = 5;
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class FileName {
        public static final String FILE_ID_SEPARATOR = "_";
        public static final String SEPARATOR = "#";
        public String mFileID;
        public String mFileType;
        public String mProcessName;
        public Long mTimestamp;

        public FileName(@NonNull String str, long j, @NonNull String str2, @NonNull String str3) {
            this.mFileID = str;
            this.mTimestamp = Long.valueOf(j);
            this.mProcessName = str2;
            this.mFileType = str3;
        }

        @NonNull
        public static String getFileName(@NonNull FileName fileName) {
            return fileName.mFileID + "#" + fileName.mProcessName + "#" + fileName.mFileType;
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
                String str5 = split[2];
                if (!TextUtils.isEmpty(str2) && j > 0 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    return new FileName(str2, j, str4, str5);
                }
            }
            return null;
        }

        public static FileName getFileName(String str, String str2, String str3) {
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

        @NonNull
        public String toString() {
            return this.mFileID + "#" + this.mTimestamp + "#" + this.mProcessName + "#" + this.mFileType;
        }
    }

    /* loaded from: classes2.dex */
    public static final class StoreUtil {
        public static final String BASE_ATTACHMENT_UPLOAD_FILE_PATH = "attachment_upload";
        public static final String BASE_UPLOAD_ATTACHMENT_DIR = "attachment";
        public static final String BASE_UPLOAD_ATTACHMENT_FLAG = "attachment.flag";
        public static final String INVALID_UPLOAD_ZIP_DIR = "zip_supply";

        public static /* synthetic */ File access$000() {
            return getAttachFlag();
        }

        public static /* synthetic */ File access$100() {
            return getInvalidZipDir();
        }

        public static /* synthetic */ File access$1000() {
            return getAttachDir();
        }

        public static File getAttachDir() {
            return new File(getStoreDir(), "attachment");
        }

        public static final File getAttachFlag() {
            return new File(getStoreDir(), "attachment.flag");
        }

        public static File getInvalidZipDir() {
            return new File(getStoreDir(), "zip_supply");
        }

        public static File getStoreDir() {
            Context appContext = AppRuntime.getAppContext();
            Context applicationContext = appContext.getApplicationContext();
            if (applicationContext != null) {
                appContext = applicationContext;
            }
            return new File(new File(appContext.getFilesDir(), BASE_ATTACHMENT_UPLOAD_FILE_PATH), ej1.b().replace(":", "_"));
        }

        @NonNull
        public static File obtainFilePath(@NonNull File file, @NonNull FileName fileName) {
            return new File(file, FileName.getFileName(fileName));
        }
    }

    /* loaded from: classes2.dex */
    public static final class TrimConfig {
        public long mLifeTime;
        public int mMaxCount;

        public TrimConfig(int i, long j) {
            this.mMaxCount = i;
            this.mLifeTime = j;
        }
    }

    public static boolean checkFlag() {
        return StoreUtil.access$000().exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDiskCache() {
        clearInvalidFiles();
        updateFileFlag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFileFlag() {
        File access$000 = StoreUtil.access$000();
        File access$1000 = StoreUtil.access$1000();
        if (access$000 != null && access$1000 != null) {
            String[] list = access$1000.list();
            boolean z = false;
            if (list != null && list.length > 0) {
                z = true;
            }
            boolean exists = access$000.exists();
            if (z) {
                if (!exists) {
                    try {
                        access$000.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (exists) {
                access$000.delete();
            }
        }
    }

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.IUpload
    public void upload() {
        reUpload(5);
        if (!this.mInvalidDirDeleted) {
            this.mInvalidDirDeleted = true;
            File access$100 = StoreUtil.access$100();
            if (access$100.exists()) {
                access$100.delete();
            }
        }
    }

    @NonNull
    private ResponseEntity uploadAction(@NonNull FileEntity fileEntity) {
        if (fileEntity != null) {
            String str = fileEntity.mFileName.mFileID;
            return uploadAttachmentSync(str.substring(0, str.indexOf("_")), fileEntity.mFile);
        }
        return new ResponseEntity(false);
    }

    public void reUpload(final int i) {
        ThreadPoolExecutor threadPoolExecutor;
        if (i > 0 && (threadPoolExecutor = this.mUploadExecutor) != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!FileUploadStrategy.this.doUpload(i)) {
                        FileUploadStrategy.this.updateFileFlag();
                    } else {
                        FileUploadStrategy.this.reUpload(i);
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.aperf.bosuploader.uploadstrategy.IUpload
    public void upload(@NonNull List<File> list, @NonNull final String str, @NonNull String str2) {
        final File createAttachZipFile = createAttachZipFile(list, FileName.createFileID(str, System.currentTimeMillis()), ej1.b(), str2);
        if (createAttachZipFile != null) {
            this.mUploadExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!NetWorkUtils.isNetworkConnected()) {
                        FileUploadStrategy.this.cleanDiskCache();
                        return;
                    }
                    FileUploadStrategy.this.updateFileFlag();
                    if (FileUploadStrategy.DEBUG) {
                        Log.d(FileUploadStrategy.TAG, "new attachement file = " + createAttachZipFile.getAbsolutePath());
                    }
                    ResponseEntity uploadAttachmentSync = FileUploadStrategy.this.uploadAttachmentSync(str, createAttachZipFile);
                    if (uploadAttachmentSync.isSuccess()) {
                        createAttachZipFile.delete();
                    }
                    if (FileUploadStrategy.this.mUploadExecutor.getQueue().size() == 0) {
                        if (!uploadAttachmentSync.isSuccess()) {
                            FileUploadStrategy.this.cleanDiskCache();
                        } else {
                            FileUploadStrategy.this.reUpload(5);
                        }
                    }
                }
            });
        }
    }

    private Pair<LinkedList<FileEntity>, LinkedList<File>> clearInvalidFiles() {
        File[] listFiles = StoreUtil.access$1000().listFiles();
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

    @Nullable
    private File createAttachZipFile(@Nullable List<File> list, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        FileName fileName = FileName.getFileName(str, str2, str3);
        if (fileName == null) {
            return null;
        }
        File access$1000 = StoreUtil.access$1000();
        if (!access$1000.exists()) {
            access$1000.mkdirs();
        }
        File obtainFilePath = StoreUtil.obtainFilePath(access$1000, fileName);
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doUpload(int i) {
        int i2;
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
        if (i2 != i) {
            return false;
        }
        return true;
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
                        Log.d(TAG, "fileCluster + " + Thread.currentThread().getName());
                    }
                }
            }
        }
        return new Pair<>(linkedList, linkedList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ResponseEntity uploadAttachmentSync(@NonNull String str, @NonNull File file) {
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
}
