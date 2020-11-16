package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes7.dex */
public abstract class a implements d {
    private static final ReadWriteLock dyZ = new ReentrantReadWriteLock();
    private File dza = aKc();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aKd();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cq(long j) {
        dyZ.writeLock().lock();
        try {
            if (this.dza == null) {
                this.dza = aKc();
            }
            File file = this.dza;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aKb() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dyZ.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cr(long j) {
        dyZ.readLock().lock();
        try {
            return aKb() + j > this.MAX_SIZE;
        } finally {
            dyZ.readLock().unlock();
        }
    }

    private long aKb() {
        if (this.dza == null) {
            this.dza = aKc();
        }
        File file = this.dza;
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

    private File aKc() {
        return new File(aKd() + File.separator + "record.pro");
    }
}
