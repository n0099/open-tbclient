package com.baidu.pass.main.facesdk.utils;

import com.baidu.android.imsdk.retrieve.Constants;
import java.util.zip.ZipEntry;
/* loaded from: classes2.dex */
public class SafeZipEntry extends ZipEntry {
    public SafeZipEntry(String str) {
        super(str);
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String name = super.getName();
        if (name.contains(Constants.PATH_PARENT)) {
            throw new RuntimeException("invalid name contains ../");
        }
        return name;
    }

    public SafeZipEntry(ZipEntry zipEntry) {
        super(zipEntry);
    }
}
