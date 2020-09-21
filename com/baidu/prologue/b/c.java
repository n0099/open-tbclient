package com.baidu.prologue.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes10.dex */
public class c {
    int KM = 1;
    String bOh;
    String bOi;
    File mFile;

    public static c b(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.bOi = str;
    }
}
