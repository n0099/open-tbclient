package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes9.dex */
public abstract class a implements d {
    private static final ReadWriteLock dOC = new ReentrantReadWriteLock();
    private File dOD = aPA();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aPB();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cQ(long j) {
        dOC.writeLock().lock();
        try {
            if (this.dOD == null) {
                this.dOD = aPA();
            }
            File file = this.dOD;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aPz() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dOC.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cR(long j) {
        dOC.readLock().lock();
        try {
            return aPz() + j > this.MAX_SIZE;
        } finally {
            dOC.readLock().unlock();
        }
    }

    private long aPz() {
        if (this.dOD == null) {
            this.dOD = aPA();
        }
        File file = this.dOD;
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

    private File aPA() {
        return new File(aPB() + File.separator + "record.pro");
    }
}
