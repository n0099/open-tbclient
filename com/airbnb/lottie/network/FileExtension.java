package com.airbnb.lottie.network;

import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import d.a.a.x.d;
/* loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    
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
        d.c("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return XAdSimpleImageLoader.TEMP_SUFFIX + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
