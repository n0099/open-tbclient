package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes7.dex */
public abstract class a implements d {
    private static final ReadWriteLock cOW = new ReentrantReadWriteLock();
    private File mRecordFile = auO();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String auP();

    @Override // com.baidu.swan.apps.storage.b.d
    public void bC(long j) {
        cOW.writeLock().lock();
        try {
            if (this.mRecordFile == null) {
                this.mRecordFile = auO();
            }
            File file = this.mRecordFile;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.d.d.saveFileCommon(String.valueOf(auN() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            cOW.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bD(long j) {
        cOW.readLock().lock();
        try {
            return auN() + j > this.MAX_SIZE;
        } finally {
            cOW.readLock().unlock();
        }
    }

    private long auN() {
        if (this.mRecordFile == null) {
            this.mRecordFile = auO();
        }
        File file = this.mRecordFile;
        if (file.exists() && file.isFile()) {
            String readFileData = com.baidu.swan.d.d.readFileData(file);
            try {
                if (TextUtils.isEmpty(readFileData) || !TextUtils.isDigitsOnly(readFileData.trim())) {
                    return 0L;
                }
                return Long.valueOf(readFileData.trim()).longValue();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                    return 0L;
                }
                return 0L;
            }
        }
        return 0L;
    }

    private File auO() {
        return new File(auP() + File.separator + "record.pro");
    }
}
