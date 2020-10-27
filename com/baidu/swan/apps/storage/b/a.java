package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes10.dex */
public abstract class a implements d {
    private static final ReadWriteLock duO = new ReentrantReadWriteLock();
    private File duP = aIk();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aIl();

    @Override // com.baidu.swan.apps.storage.b.d
    public void bU(long j) {
        duO.writeLock().lock();
        try {
            if (this.duP == null) {
                this.duP = aIk();
            }
            File file = this.duP;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aIj() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            duO.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bV(long j) {
        duO.readLock().lock();
        try {
            return aIj() + j > this.MAX_SIZE;
        } finally {
            duO.readLock().unlock();
        }
    }

    private long aIj() {
        if (this.duP == null) {
            this.duP = aIk();
        }
        File file = this.duP;
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

    private File aIk() {
        return new File(aIl() + File.separator + "record.pro");
    }
}
