package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes9.dex */
public abstract class a implements d {
    private static final ReadWriteLock dLU = new ReentrantReadWriteLock();
    private File dLV = aLZ();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aMa();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cW(long j) {
        dLU.writeLock().lock();
        try {
            if (this.dLV == null) {
                this.dLV = aLZ();
            }
            File file = this.dLV;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aLY() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dLU.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cX(long j) {
        dLU.readLock().lock();
        try {
            return aLY() + j > this.MAX_SIZE;
        } finally {
            dLU.readLock().unlock();
        }
    }

    private long aLY() {
        if (this.dLV == null) {
            this.dLV = aLZ();
        }
        File file = this.dLV;
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

    private File aLZ() {
        return new File(aMa() + File.separator + "record.pro");
    }
}
