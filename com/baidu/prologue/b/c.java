package com.baidu.prologue.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes14.dex */
public class c {
    int Ma = 1;
    String cnW;
    String cnX;
    File mFile;

    public static c b(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.cnX = str;
    }
}
