package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes8.dex */
public abstract class a implements d {
    private static final ReadWriteLock dJQ = new ReentrantReadWriteLock();
    private File dJR = aLG();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aLH();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cQ(long j) {
        dJQ.writeLock().lock();
        try {
            if (this.dJR == null) {
                this.dJR = aLG();
            }
            File file = this.dJR;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aLF() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dJQ.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cR(long j) {
        dJQ.readLock().lock();
        try {
            return aLF() + j > this.MAX_SIZE;
        } finally {
            dJQ.readLock().unlock();
        }
    }

    private long aLF() {
        if (this.dJR == null) {
            this.dJR = aLG();
        }
        File file = this.dJR;
        if (file.exists() && file.isFile()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file);
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

    private File aLG() {
        return new File(aLH() + File.separator + "record.pro");
    }
}
