package com.baidu.swan.apps.storage.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes25.dex */
public abstract class a implements d {
    private static final ReadWriteLock dFY = new ReentrantReadWriteLock();
    private File dFZ = aNj();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aNk();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cP(long j) {
        dFY.writeLock().lock();
        try {
            if (this.dFZ == null) {
                this.dFZ = aNj();
            }
            File file = this.dFZ;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aNi() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dFY.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cQ(long j) {
        dFY.readLock().lock();
        try {
            return aNi() + j > this.MAX_SIZE;
        } finally {
            dFY.readLock().unlock();
        }
    }

    private long aNi() {
        if (this.dFZ == null) {
            this.dFZ = aNj();
        }
        File file = this.dFZ;
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

    private File aNj() {
        return new File(aNk() + File.separator + "record.pro");
    }
}
