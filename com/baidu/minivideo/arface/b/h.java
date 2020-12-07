package com.baidu.minivideo.arface.b;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.util.Objects;
/* loaded from: classes8.dex */
public class h {
    private File ceE;
    private File ceF;
    private File ceG;
    private volatile boolean ceH = false;

    @SuppressLint({"NewApi"})
    public h(@NonNull File file) {
        this.ceE = (File) Objects.requireNonNull(file);
        if (isDebug()) {
            d("create " + file.getAbsolutePath());
        }
        this.ceF = new File(this.ceE, ".property/lockers");
        this.ceG = new File(this.ceE, ".property/holders");
    }

    public void jQ(String str) {
        File file;
        String[] list = this.ceF.list();
        if (list != null && list.length != 0) {
            String str2 = str + ".locker.";
            for (String str3 : list) {
                if (str3 != null && str3.startsWith(str2)) {
                    com.baidu.minivideo.arface.utils.e.deleteFileOrDir(new File(this.ceF, str3));
                    if (isDebug()) {
                        d("cleanLockerTag , " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private void d(String str) {
        Log.d("DuAr_sharedFM", str);
    }
}
