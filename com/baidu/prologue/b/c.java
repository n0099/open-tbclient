package com.baidu.prologue.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes9.dex */
public class c {
    int KE = 1;
    String bMd;
    String bMe;
    File mFile;

    public static c b(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.bMe = str;
    }
}
