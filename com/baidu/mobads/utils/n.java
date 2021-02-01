package com.baidu.mobads.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import java.io.File;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class n extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3503a;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, String str) {
        this.c = mVar;
        this.f3503a = str;
    }

    @Override // com.baidu.mobads.f.a
    protected Object a() {
        long j;
        try {
            File file = new File(this.f3503a);
            if (!file.exists()) {
                file.mkdirs();
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    Arrays.sort(listFiles, new o(this));
                    long j2 = 0;
                    for (int length = listFiles.length - 1; length >= 0; length--) {
                        File file2 = listFiles[length];
                        if (file2.exists()) {
                            if (System.currentTimeMillis() - file2.lastModified() <= BdKVCache.MILLS_30Days) {
                                j = m.f3499a;
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
            }
        } catch (Exception e) {
        }
        return null;
    }
}
