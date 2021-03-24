package com.airbnb.lottie.network;

import d.a.a.c;
/* loaded from: classes.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        FileExtension[] values;
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        c.d("Unable to find correct extension for " + str);
        return Json;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
