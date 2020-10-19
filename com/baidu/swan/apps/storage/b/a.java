package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes10.dex */
public abstract class a implements d {
    private static final ReadWriteLock dmm = new ReentrantReadWriteLock();
    private File dmn = aGq();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aGr();

    @Override // com.baidu.swan.apps.storage.b.d
    public void bS(long j) {
        dmm.writeLock().lock();
        try {
            if (this.dmn == null) {
                this.dmn = aGq();
            }
            File file = this.dmn;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aGp() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dmm.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bT(long j) {
        dmm.readLock().lock();
        try {
            return aGp() + j > this.MAX_SIZE;
        } finally {
            dmm.readLock().unlock();
        }
    }

    private long aGp() {
        if (this.dmn == null) {
            this.dmn = aGq();
        }
        File file = this.dmn;
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

    private File aGq() {
        return new File(aGr() + File.separator + "record.pro");
    }
}
