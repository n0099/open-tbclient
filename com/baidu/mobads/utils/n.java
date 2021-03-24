package com.baidu.mobads.utils;

import java.io.File;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class n extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8551a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f8552c;

    public n(m mVar, String str) {
        this.f8552c = mVar;
        this.f8551a = str;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        File file;
        long j;
        try {
            file = new File(this.f8551a);
        } catch (Exception unused) {
        }
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            Arrays.sort(listFiles, new o(this));
            long j2 = 0;
            for (int length = listFiles.length - 1; length >= 0; length--) {
                File file2 = listFiles[length];
                if (file2.exists()) {
                    if (System.currentTimeMillis() - file2.lastModified() <= 2592000000L) {
                        j = m.f8545a;
                        if (file2.length() + j2 > j) {
                            file2.delete();
                        } else {
                            j2 += file2.length();
                        }
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        return null;
    }
}
