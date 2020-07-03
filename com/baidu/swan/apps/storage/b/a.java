package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes11.dex */
public abstract class a implements d {
    private static final ReadWriteLock cLB = new ReentrantReadWriteLock();
    private File mRecordFile = asN();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String asO();

    @Override // com.baidu.swan.apps.storage.b.d
    public void br(long j) {
        cLB.writeLock().lock();
        try {
            if (this.mRecordFile == null) {
                this.mRecordFile = asN();
            }
            File file = this.mRecordFile;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.e.d.saveFileCommon(String.valueOf(asM() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            cLB.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bs(long j) {
        cLB.readLock().lock();
        try {
            return asM() + j > this.MAX_SIZE;
        } finally {
            cLB.readLock().unlock();
        }
    }

    private long asM() {
        if (this.mRecordFile == null) {
            this.mRecordFile = asN();
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

    private File asN() {
        return new File(asO() + File.separator + "record.pro");
    }
}
