package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes11.dex */
public abstract class a implements d {
    private static final ReadWriteLock cGR = new ReentrantReadWriteLock();
    private File mRecordFile = arG();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String arH();

    @Override // com.baidu.swan.apps.storage.b.d
    public void br(long j) {
        cGR.writeLock().lock();
        try {
            if (this.mRecordFile == null) {
                this.mRecordFile = arG();
            }
            File file = this.mRecordFile;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.e.d.saveFileCommon(String.valueOf(arF() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            cGR.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bs(long j) {
        cGR.readLock().lock();
        try {
            return arF() + j > this.MAX_SIZE;
        } finally {
            cGR.readLock().unlock();
        }
    }

    private long arF() {
        if (this.mRecordFile == null) {
            this.mRecordFile = arG();
        }
        File file = this.mRecordFile;
        if (file.exists() && file.isFile()) {
            String readFileData = com.baidu.swan.e.d.readFileData(file);
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

    private File arG() {
        return new File(arH() + File.separator + "record.pro");
    }
}
