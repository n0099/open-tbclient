package com.baidu.prologue.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes8.dex */
public class c {
    int Ka = 1;
    String bGD;
    String bGE;
    File mFile;

    public static c b(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.bGE = str;
    }
}
