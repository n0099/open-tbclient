package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public abstract class a implements d {
    private static final ReadWriteLock dac = new ReentrantReadWriteLock();
    private File dad = aDH();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aDI();

    @Override // com.baidu.swan.apps.storage.b.d
    public void bK(long j) {
        dac.writeLock().lock();
        try {
            if (this.dad == null) {
                this.dad = aDH();
            }
            File file = this.dad;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aDG() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dac.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bL(long j) {
        dac.readLock().lock();
        try {
            return aDG() + j > this.MAX_SIZE;
        } finally {
            dac.readLock().unlock();
        }
    }

    private long aDG() {
        if (this.dad == null) {
            this.dad = aDH();
        }
        File file = this.dad;
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

    private File aDH() {
        return new File(aDI() + File.separator + "record.pro");
    }
}
