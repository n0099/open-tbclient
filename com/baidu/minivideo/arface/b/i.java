package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes6.dex */
public class i {
    private File clt;
    private File clu;
    private File clv;
    private volatile boolean clw = false;

    @SuppressLint({"NewApi"})
    public i(@NonNull File file) {
        this.clt = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            d("create " + file.getAbsolutePath());
        }
        this.clu = new File(this.clt, ".property/lockers");
        this.clv = new File(this.clt, ".property/holders");
    }

    public boolean isLocked() {
        String[] list = this.clu.list();
        return list != null && list.length > 0;
    }

    public String jJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = str + ".locker." + System.currentTimeMillis();
        File file = new File(this.clu, str2);
        if (!file.exists()) {
            if (!this.clu.exists()) {
                this.clu.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isDebug()) {
            d(file.exists() + " to addLocker , " + file.getAbsolutePath());
            return str2;
        }
        return str2;
    }

    public void jK(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(this.clu, str);
            if (file.exists()) {
                com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file);
            }
            if (isDebug()) {
                d((!file.exists()) + " to removeLocker , " + file.getAbsolutePath());
            }
        }
    }

    public void jL(String str) {
        File file;
        String[] list = this.clu.list();
        if (list != null && list.length != 0) {
            String str2 = str + ".locker.";
            for (String str3 : list) {
                if (str3 != null && str3.startsWith(str2)) {
                    com.baidu.minivideo.arface.utils.f.deleteFileOrDir(new File(this.clu, str3));
                    if (isDebug()) {
                        d("cleanLockerTag , " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void c(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null) {
            File file2 = new File(this.clv, file.getName());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str + ".holder");
            if (!file3.exists()) {
                try {
                    file3.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isDebug()) {
                d(file3.exists() + " addChildHolder , " + file3.getAbsolutePath());
            }
        }
    }

    public void d(String str, File file) {
        String str2;
        File file2;
        File[] listFiles = this.clv.listFiles();
        String str3 = str + ".holder";
        if (file == null) {
            str2 = null;
        } else {
            String name = file.getName();
            c(str, file);
            str2 = name;
        }
        if (listFiles != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && !TextUtils.equals(file3.getName(), str2)) {
                    if (!file3.isDirectory()) {
                        if (file3.getName().endsWith(str3)) {
                            com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file3);
                        }
                    } else {
                        String[] list = file3.list();
                        if (list != null && list.length != 0) {
                            for (String str4 : list) {
                                if (str4 != null && str4.endsWith(str3)) {
                                    com.baidu.minivideo.arface.utils.f.deleteFileOrDir(new File(file3, str4));
                                    if (isDebug()) {
                                        d("clearChildHolderTo , " + file2.getAbsolutePath());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean q(File file) {
        boolean z = true;
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(this.clv, file.getName());
        if (file2.exists()) {
            if (file2.isDirectory()) {
                String[] list = file2.list();
                if (list == null || list.length <= 0) {
                    z = false;
                }
                if (!z) {
                    com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file2);
                    return z;
                }
                return z;
            }
            return true;
        }
        return false;
    }

    public void aeu() {
        File[] listFiles = this.clt.listFiles();
        if (listFiles != null && listFiles.length != 0 && !isLocked()) {
            for (File file : listFiles) {
                if (!TextUtils.equals(".property", file.getName()) && !q(file)) {
                    com.baidu.minivideo.arface.utils.f.deleteFileOrDir(file);
                    if (isDebug()) {
                        d("cleanCache , " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.minivideo.arface.b.i$1] */
    public void aev() {
        if (this.clw) {
            if (isDebug()) {
                d("cleanCacehAsync isCleaning... ");
                return;
            }
            return;
        }
        synchronized (this) {
            if (this.clw) {
                if (isDebug()) {
                    d("cleanCacehAsync isCleaning... ");
                }
                return;
            }
            this.clw = true;
            new Thread() { // from class: com.baidu.minivideo.arface.b.i.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    i.this.aeu();
                    synchronized (i.this) {
                        i.this.clw = false;
                        if (i.this.isDebug()) {
                            i.this.d("cleanCacehAsync finish.");
                        }
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Log.d("DuAr_sharedFM", str);
    }
}
