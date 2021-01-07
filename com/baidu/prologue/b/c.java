package com.baidu.prologue.b;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes6.dex */
public class c {
    int Lv = 1;
    String cvd;
    String cve;
    File mFile;

    public static c c(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.cve = str;
    }
}
