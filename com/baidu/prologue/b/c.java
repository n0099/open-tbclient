package com.baidu.prologue.b;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public class c {
    int Lt = 1;
    String cql;
    String cqm;
    File mFile;

    public static c c(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.cqm = str;
    }
}
