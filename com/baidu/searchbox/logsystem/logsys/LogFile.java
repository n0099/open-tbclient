package com.baidu.searchbox.logsystem.logsys;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public class LogFile {
    public boolean mCanDelete;
    public File mFile;
    public boolean mNecessary;

    public LogFile(@NonNull File file, boolean z) {
        this.mCanDelete = true;
        this.mNecessary = false;
        this.mFile = file;
        this.mCanDelete = z;
    }

    public LogFile(@NonNull File file, boolean z, boolean z2) {
        this.mCanDelete = true;
        this.mNecessary = false;
        this.mFile = file;
        this.mCanDelete = z;
        this.mNecessary = z2;
    }

    public LogFile(@NonNull File file) {
        this.mCanDelete = true;
        this.mNecessary = false;
        this.mFile = file;
    }

    public static void init() {
    }

    public String toString() {
        return this.mFile.getAbsolutePath() + "," + this.mCanDelete + "," + this.mNecessary;
    }
}
