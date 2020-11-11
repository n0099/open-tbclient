package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes10.dex */
public abstract class a implements d {
    private static final ReadWriteLock dAG = new ReentrantReadWriteLock();
    private File dAH = aKK();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aKL();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cq(long j) {
        dAG.writeLock().lock();
        try {
            if (this.dAH == null) {
                this.dAH = aKK();
            }
            File file = this.dAH;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aKJ() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dAG.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cr(long j) {
        dAG.readLock().lock();
        try {
            return aKJ() + j > this.MAX_SIZE;
        } finally {
            dAG.readLock().unlock();
        }
    }

    private long aKJ() {
        if (this.dAH == null) {
            this.dAH = aKK();
        }
        File file = this.dAH;
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

    private File aKK() {
        return new File(aKL() + File.separator + "record.pro");
    }
}
