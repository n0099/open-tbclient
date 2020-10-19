package com.baidu.ala.dumixar;

import android.content.Context;
import java.io.File;
import java.util.Objects;
/* loaded from: classes12.dex */
public class ArSourceConfig {
    private static ArSourceConfig sInst;
    private String mAssetsSourcePath = "arsource";
    private File mRootDir;
    private File mSourceDir;

    public static ArSourceConfig getInst() {
        if (sInst == null) {
            createInst();
        }
        return sInst;
    }

    private static synchronized void createInst() {
        synchronized (ArSourceConfig.class) {
            if (sInst == null) {
                sInst = new ArSourceConfig();
            }
        }
    }

    public String getSourceAssetsPath() {
        return this.mAssetsSourcePath;
    }

    public File getSourceDir(Context context) {
        if (this.mSourceDir == null) {
            this.mSourceDir = new File(getRootDir(context), "arsource/");
        }
        return this.mSourceDir;
    }

    public File getRootDir(Context context) {
        if (this.mRootDir == null) {
            this.mRootDir = ((Context) Objects.requireNonNull(context)).getExternalFilesDir("duar/");
        }
        return this.mRootDir;
    }
}
