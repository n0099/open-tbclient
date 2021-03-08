package com.baidu.swan.apps.storage.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes8.dex */
public abstract class a implements d {
    private static final ReadWriteLock dNv = new ReentrantReadWriteLock();
    private File dNw = aMc();
    private final long MAX_SIZE = getMaxSize();

    @NonNull
    public abstract String aMd();

    @Override // com.baidu.swan.apps.storage.b.d
    public void cW(long j) {
        dNv.writeLock().lock();
        try {
            if (this.dNw == null) {
                this.dNw = aMc();
            }
            File file = this.dNw;
            if (!file.exists()) {
                file.createNewFile();
            }
            com.baidu.swan.c.d.saveFileCommon(String.valueOf(aMb() + j).getBytes(), file);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            dNv.writeLock().unlock();
        }
    }

    @Override // com.baidu.swan.apps.storage.b.d
    public boolean cX(long j) {
        dNv.readLock().lock();
        try {
            return aMb() + j > this.MAX_SIZE;
        } finally {
            dNv.readLock().unlock();
        }
    }

    private long aMb() {
        if (this.dNw == null) {
            this.dNw = aMc();
        }
        File file = this.dNw;
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

    private File aMc() {
        return new File(aMd() + File.separator + "record.pro");
    }
}
