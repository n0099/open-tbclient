package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes8.dex */
public abstract class a implements d {
    private static final ReadWriteLock cXY = new ReentrantReadWriteLock();
    private File cXZ = aCX();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aCY();

    @Override // com.baidu.swan.apps.storage.b.d
    public void bJ(long j) {
        cXY.writeLock().lock();
        try {
            if (this.cXZ == null) {
                this.cXZ = aCX();
            }
            File file = this.cXZ;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aCW() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            cXY.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean bK(long j) {
        cXY.readLock().lock();
        try {
            return aCW() + j > this.MAX_SIZE;
        } finally {
            cXY.readLock().unlock();
        }
    }

    private long aCW() {
        if (this.cXZ == null) {
            this.cXZ = aCX();
        }
        File file = this.cXZ;
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

    private File aCX() {
        return new File(aCY() + File.separator + "record.pro");
    }
}
