package com.baidu.minivideo.arface.b;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    private List<a> ceI = new ArrayList();
    private File cet;
    private File ceu;
    private String mUrl;

    /* loaded from: classes8.dex */
    public static class a<T> {
    }

    public i(String str, File file) {
        this.mUrl = str;
        this.cet = file;
        this.ceu = new File(this.cet.getAbsolutePath() + ".loading");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isLoaded() {
        return this.cet != null && this.cet.exists();
    }

    public File getLocalFile() {
        return this.cet;
    }
}
