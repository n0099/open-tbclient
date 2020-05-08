package com.baidu.prologue.b;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes6.dex */
public class c {
    int Jq = 1;
    String btN;
    String btO;
    File mFile;

    public static c b(@NonNull File file, @NonNull String str) {
        return new c(file, str);
    }

    private c(File file, String str) {
        this.mFile = file;
        this.btO = str;
    }
}
