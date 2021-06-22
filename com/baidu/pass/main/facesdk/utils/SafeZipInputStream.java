package com.baidu.pass.main.facesdk.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes2.dex */
public class SafeZipInputStream extends ZipInputStream {
    public SafeZipInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.util.zip.ZipInputStream
    public ZipEntry createZipEntry(String str) {
        return new SafeZipEntry(str);
    }
}
