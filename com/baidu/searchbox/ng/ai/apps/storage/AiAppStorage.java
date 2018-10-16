package com.baidu.searchbox.ng.ai.apps.storage;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent;
import com.baidu.searchbox.ng.ai.apps.runtime.Persistability;
import com.baidu.searchbox.ng.ai.apps.trace.Index;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppStorage extends AiAppComponent implements Persistability<AiAppSharedPrefsWrapper, SQLiteDatabase> {
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "AiAppStorage";
    private static final int MAX_SIZE_LIMIT = 10485760;
    private static final String PREFIX = "aiapp_";
    private final Index.ValueUpdater<Long> mIndexStorageSizeUpdater;
    private AiAppSharedPrefsWrapper mPref;
    public final File mPrefFile;
    public final String name;
    public final String prefName;
    public static int SIZE_BUFFER = 1024;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public AiAppStorage(AiApp aiApp) {
        super(aiApp);
        this.mIndexStorageSizeUpdater = new Index.ValueUpdater<Long>() { // from class: com.baidu.searchbox.ng.ai.apps.storage.AiAppStorage.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.ng.ai.apps.trace.Index.ValueUpdater
            public Long update() throws IllegalStateException {
                return Long.valueOf(AiAppStorage.this.currentSize());
            }
        };
        this.name = aiApp.id;
        this.prefName = PREFIX + this.name;
        this.mPrefFile = new File(getApplicationInfo().dataDir, "shared_prefs/" + this.prefName + ".xml");
        Tracer.INDEX_STORAGE_SIZE.updater(this.mIndexStorageSizeUpdater);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean available() {
        return currentSize() < limitSize();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public void disable() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enabled() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Persistability
    public AiAppSharedPrefsWrapper getReferences() {
        if (this.mPref == null) {
            this.mPref = new AiAppSharedPrefsWrapper(this.prefName);
        }
        return this.mPref;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Persistability
    public SQLiteDatabase getDataBase() {
        return null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Persistability
    public File getStorageDir() {
        return null;
    }

    public void clear() {
        getReferences().edit().clear().apply();
        AiAppsFileUtils.deleteFile(StorageUtil.getAiappTmpDirectory(AiApp.getAiAppId()));
        AiAppsFileUtils.deleteFile(StorageUtil.getAiappStoreDirectory(AiApp.getAiAppId()));
        Tracer.INDEX_STORAGE_SIZE.update();
    }

    public int checkFilePath(@NonNull String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 2001;
        }
        if (file.length() > 10485760) {
            return 2002;
        }
        return 2000;
    }

    public String getFileName(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf == INVALID_INDEX || length <= lastIndexOf) {
            return null;
        }
        return str.substring(ONE_INCREAMENT + lastIndexOf, length);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:62:0x00a9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=5, 217=4, 218=4, 219=4, 223=4, 225=4, 226=4, 227=4] */
    public java.lang.String saveFile(java.lang.String r8) {
        /*
            r7 = this;
            r2 = 0
            java.lang.String r0 = ""
            java.lang.String r1 = r7.name
            java.lang.String r1 = com.baidu.searchbox.ng.ai.apps.storage.StorageUtil.getAiappStoreDirectory(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L14
            java.lang.String r0 = ""
        L13:
            return r0
        L14:
            java.lang.String r3 = r7.getFileName(r8)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            java.io.File r4 = r7.getStorageFile(r1, r3)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            r1.<init>(r8)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            r3.<init>(r1)     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8b java.io.FileNotFoundException -> Lb2
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La4 java.io.IOException -> Lad java.io.FileNotFoundException -> Lb5
            r1.<init>(r4)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> Lad java.io.FileNotFoundException -> Lb5
            int r2 = com.baidu.searchbox.ng.ai.apps.storage.AiAppStorage.SIZE_BUFFER     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
            byte[] r2 = new byte[r2]     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
        L2f:
            int r5 = r3.read(r2)     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
            r6 = -1
            if (r5 == r6) goto L53
            r6 = 0
            r1.write(r2, r6, r5)     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
            r1.flush()     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
            goto L2f
        L3e:
            r2 = move-exception
            r2 = r3
        L40:
            java.lang.String r0 = ""
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L6c
        L48:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L13
        L4e:
            r1 = move-exception
            r1.printStackTrace()
            goto L13
        L53:
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.io.FileNotFoundException -> L3e java.lang.Throwable -> La6 java.io.IOException -> Laf
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L67
        L5c:
            if (r1 == 0) goto L13
            r1.close()     // Catch: java.io.IOException -> L62
            goto L13
        L62:
            r1 = move-exception
            r1.printStackTrace()
            goto L13
        L67:
            r2 = move-exception
            r2.printStackTrace()
            goto L5c
        L6c:
            r2 = move-exception
            r2.printStackTrace()
            goto L48
        L71:
            r1 = move-exception
            r3 = r2
        L73:
            java.lang.String r0 = ""
            if (r3 == 0) goto L7b
            r3.close()     // Catch: java.io.IOException -> L86
        L7b:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L81
            goto L13
        L81:
            r1 = move-exception
            r1.printStackTrace()
            goto L13
        L86:
            r1 = move-exception
            r1.printStackTrace()
            goto L7b
        L8b:
            r1 = move-exception
            r3 = r2
        L8d:
            if (r3 == 0) goto L92
            r3.close()     // Catch: java.io.IOException -> L9f
        L92:
            if (r2 == 0) goto L13
            r2.close()     // Catch: java.io.IOException -> L99
            goto L13
        L99:
            r1 = move-exception
            r1.printStackTrace()
            goto L13
        L9f:
            r1 = move-exception
            r1.printStackTrace()
            goto L92
        La4:
            r1 = move-exception
            goto L8d
        La6:
            r2 = move-exception
            r2 = r1
            goto L8d
        La9:
            r3 = move-exception
            r3 = r2
            r2 = r1
            goto L8d
        Lad:
            r1 = move-exception
            goto L73
        Laf:
            r2 = move-exception
            r2 = r1
            goto L73
        Lb2:
            r1 = move-exception
            r1 = r2
            goto L40
        Lb5:
            r1 = move-exception
            r1 = r2
            r2 = r3
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ng.ai.apps.storage.AiAppStorage.saveFile(java.lang.String):java.lang.String");
    }

    private File getStorageFile(@NonNull String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str, str2);
    }

    public FileInfo getSavedFileInfo(@NonNull String str) {
        File file = new File(str);
        if (file == null || !file.isFile()) {
            return null;
        }
        FileInfo fileInfo = new FileInfo();
        fileInfo.setSize(file.length());
        fileInfo.setCreatedTime(file.lastModified());
        return fileInfo;
    }

    public List<FileInfo> getSavedFileList() {
        String aiappStoreDirectory = StorageUtil.getAiappStoreDirectory(this.name);
        if (TextUtils.isEmpty(aiappStoreDirectory)) {
            return null;
        }
        return getSavedFileList(aiappStoreDirectory);
    }

    public List<FileInfo> getSavedFileList(@NonNull String str) {
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            return getSavedFileList(file);
        }
        return null;
    }

    public List<FileInfo> getSavedFileList(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        FileInfo fileInfo = new FileInfo();
        ArrayList arrayList = new ArrayList();
        if (file.isFile()) {
            fileInfo.setPath(file.getAbsolutePath());
            fileInfo.setSize(file.length());
            fileInfo.setCreatedTime(file.lastModified());
            arrayList.add(fileInfo);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                List<FileInfo> savedFileList = getSavedFileList(file2);
                if (savedFileList != null) {
                    arrayList.addAll(arrayList.size(), savedFileList);
                }
            }
        }
        return arrayList;
    }

    public long currentSize() {
        if (this.mPrefFile == null) {
            return 0L;
        }
        return this.mPrefFile.length();
    }

    public long limitSize() {
        return 10485760L;
    }
}
