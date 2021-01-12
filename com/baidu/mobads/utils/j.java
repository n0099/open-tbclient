package com.baidu.mobads.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import java.io.File;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3503a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f3504b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.f3504b = iVar;
        this.f3503a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        try {
            File file = new File(this.f3503a);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                Arrays.sort(listFiles, new k(this));
                long j2 = 0;
                for (int length = listFiles.length - 1; length >= 0; length--) {
                    File file2 = listFiles[length];
                    if (file2.exists()) {
                        if (System.currentTimeMillis() - file2.lastModified() <= BdKVCache.MILLS_30Days) {
                            j = i.f3499a;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
