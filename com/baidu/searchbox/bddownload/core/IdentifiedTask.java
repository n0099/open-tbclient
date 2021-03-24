package com.baidu.searchbox.bddownload.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class IdentifiedTask {
    public static final File EMPTY_FILE = new File("");
    public static final String EMPTY_URL = "";

    public boolean compareIgnoreId(IdentifiedTask identifiedTask) {
        if (!getUrl().equals(identifiedTask.getUrl()) || getUrl().equals("") || getParentFile().equals(EMPTY_FILE)) {
            return false;
        }
        if (getProvidedPathFile().equals(identifiedTask.getProvidedPathFile())) {
            return true;
        }
        if (getParentFile().equals(identifiedTask.getParentFile())) {
            String filename = getFilename();
            String filename2 = identifiedTask.getFilename();
            return (filename2 == null || filename == null || !filename2.equals(filename)) ? false : true;
        }
        return false;
    }

    @Nullable
    public abstract String getFilename();

    public abstract int getId();

    @NonNull
    public abstract File getParentFile();

    @NonNull
    public abstract File getProvidedPathFile();

    @NonNull
    public abstract String getUrl();
}
